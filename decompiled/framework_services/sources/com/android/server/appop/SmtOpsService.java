package com.android.server.appop;

import android.app.ActivityThread;
import android.app.SmtOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.app.ISmtOpsCallback;
import com.android.internal.app.ISmtOpsService;
import com.android.internal.app.ThemeUtils;
import com.android.internal.util.FastXmlSerializer;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.scene.SceneUtils;
import com.android.server.slice.SliceClientPermissions;
import com.obric.server.memorydata.MemoryManagerService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SmtOpsService extends ISmtOpsService.Stub {
    static final int CHECK_OPT_FOR_RUNTIME_PERMISSION = 4;
    static final boolean DEBUG = false;
    static final int MSG_PROCESS_DIED = 2;
    static final int SHOW_ASYNC_DIALOG = 3;
    static final int SHOW_PERMISSION_DIALOG = 1;
    static final String TAG = "SmtOps";
    static final long WRITE_DELAY = 0;
    static final String mOpsFileName = "/system/etc/package_ops_config.xml";
    private HashMap mActiveItem;
    final ArrayMap<IBinder, ClientState> mClients;
    Context mContext;
    HashMap<String, HashMap<Integer, Integer>> mDefaultPackageOps;
    boolean mEnabled;
    final AtomicFile mFile;
    final Handler mHandler;
    final ArrayMap<IBinder, Callback> mModeWatchers;
    final SparseArray<ArrayList<Callback>> mOpModeWatchers;
    final ArrayMap<String, ArrayList<Callback>> mPackageModeWatchers;
    HashMap<Integer, HashMap<Integer, Integer>> mProcessMaps;
    final SmtOpsSettings mSettings;
    Context mUiContext;
    final SparseArray<HashMap<String, Ops>> mUidOps;
    boolean mWriteNowScheduled;
    final Runnable mWriteRunner;
    boolean mWriteScheduled;

    public final class Callback implements IBinder.DeathRecipient {
        final ISmtOpsCallback mCallback;
        final /* synthetic */ SmtOpsService this$0;

        public Callback(SmtOpsService this$0, ISmtOpsCallback callback) {
            this.this$0 = this$0;
            this.mCallback = callback;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        public void unlinkToDeath() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.stopWatchingMode(this.mCallback);
        }
    }

    public final class ClientState extends Binder implements IBinder.DeathRecipient {
        final IBinder mAppToken;
        final int mPid;
        final ArrayList<Op> mStartedOps;
        final /* synthetic */ SmtOpsService this$0;

        public ClientState(SmtOpsService this$0, IBinder appToken) {
            this.this$0 = this$0;
            this.mAppToken = appToken;
            this.mPid = Binder.getCallingPid();
            if ((appToken instanceof Binder) == false) goto L5;
            this.mStartedOps = null;
            return;
        L5:
            this.mStartedOps = new ArrayList();
            this.mAppToken.linkToDeath(this, 0);     // Catch: RemoteException -> L8
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ClientState{mAppToken=");
            r0.append(this.mAppToken);
            r0.append(", ");
            if (this.mStartedOps == null) goto L5;
            String r1 = "pid=" + this.mPid;
        L6:
            r0.append(r1);
            r0.append('}');
            return r0.toString();
        L5:
            r1 = "local";
            goto L6
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            SmtOpsService r0 = this.this$0;
            monitor-enter(r0);
            int i = this.mStartedOps.size() - 1;     // Catch: Throwable -> L7
        L5:
            if (i < 0) goto L9;
            this.this$0.finishOperationLocked(this.mStartedOps.get(i));     // Catch: Throwable -> L7
            i = i - 1;     // Catch: Throwable -> L7
            goto L5
        L9:
            this.this$0.mClients.remove(this.mAppToken);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class Op {
        public PermissionDialogResult dialogResult;
        public int duration;
        final ArrayList<IBinder> mClientTokens;
        public int mode;
        public int nesting;
        public int noteOpCount;
        public final int op;
        public final String packageName;
        public long rejectTime;
        public int startOpCount;
        public long time;
        public final int uid;

        public Op(int _uid, String _packageName, int _op, int _mode) {
            this.uid = _uid;
            this.packageName = _packageName;
            this.op = _op;
            this.mode = _mode;
            this.dialogResult = new PermissionDialogResult();
            this.mClientTokens = new ArrayList();
        }
    }

    public static final class Ops extends SparseArray<Op> {
        public final String packageName;
        public final int uid;

        public Ops(String _packageName, int _uid) {
            this.packageName = _packageName;
            this.uid = _uid;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUiContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1826$$Nest$mgetUiContext(SmtOpsService r0) {
        return r0.getUiContext();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        if (DEBUG == false) goto L5;
        long r0 = 1000;
    L6:
        WRITE_DELAY = r0;
        return;
    L5:
        r0 = 1800000;
        goto L6
    }

    public int updateData(String taskName) {
        if (this.mSettings == null) goto L6;
        int result = this.mSettings.loadData(taskName);
        return result;
    L6:
        return -1;
    }

    public SmtOpsService(File storagePath) {
        this.mEnabled = true;
        this.mDefaultPackageOps = new HashMap();
        this.mProcessMaps = new HashMap();
        this.mWriteRunner = new AnonymousClass1(this);
        this.mUidOps = new SparseArray();
        this.mOpModeWatchers = new SparseArray();
        this.mPackageModeWatchers = new ArrayMap();
        this.mModeWatchers = new ArrayMap();
        this.mClients = new ArrayMap();
        this.mFile = new AtomicFile(storagePath);
        this.mHandler = new AnonymousClass2(this);
        this.mSettings = new SmtOpsSettings(this);
        this.mSettings.readDefaultSettings();
        readState();
    }

    private Context getUiContext() {
        if (this.mUiContext != null) goto L6;
        this.mUiContext = ThemeUtils.createUiContext(this.mContext);
    L6:
        if (this.mUiContext == null) goto L9;
        return this.mUiContext;
    L9:
        return this.mContext;
    }

    public void publish(Context context) {
        this.mSettings.publish(context);
        this.mContext = context;
        ServiceManager.addService("smtops", asBinder());
    }

    public void systemReady() {
        monitor-enter(this);
        boolean changed = false;
        int i = 0;
    L33:
    L12:
        th = move-exception;
        throw th;
    L5:
        if (i >= this.mUidOps.size()) goto L25;
        HashMap<String, Ops> pkgs = this.mUidOps.valueAt(i);     // Catch: Throwable -> L12
        Iterator<Ops> it = pkgs.values().iterator();     // Catch: Throwable -> L12
    L8:
        if (it.hasNext() == false) goto L21;
        Ops ops = it.next();     // Catch: Throwable -> L12
        int curUid = this.mContext.getPackageManager().getPackageUidAsUser(ops.packageName, 8192, UserHandle.getUserId(ops.uid));     // Catch: Throwable -> L12 PackageManager.NameNotFoundException -> L14
    L17:
        if (curUid == ops.uid) goto L8;
        Slog.i(TAG, "Pruning old package " + ops.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + ops.uid + ": new uid=" + curUid);     // Catch: Throwable -> L12
        it.remove();     // Catch: Throwable -> L12
        changed = true;
    L15:
        curUid = -1;
        goto L17
    L21:
        if (pkgs.size() > 0) goto L23;
        this.mUidOps.removeAt(i);     // Catch: Throwable -> L12
    L23:
        i = i + 1;     // Catch: Throwable -> L12
        goto L33
    L25:
        if (changed == false) goto L27;
        scheduleWriteLocked();     // Catch: Throwable -> L12
    L27:
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public void packageRemoved(int uid, String packageName) {
        monitor-enter(this);
        HashMap<String, Ops> pkgs = this.mUidOps.get(uid);     // Catch: Throwable -> L10
        if (pkgs != null) goto L6;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L6:
        if (pkgs.remove(packageName) == null) goto L13;
        if (pkgs.size() > 0) goto L12;
        this.mUidOps.remove(uid);     // Catch: Throwable -> L10
    L12:
        scheduleWriteLocked();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void uidRemoved(int uid) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mUidOps.indexOfKey(uid) < 0) goto L8;
        this.mUidOps.remove(uid);     // Catch: Throwable -> L6
        scheduleWriteLocked();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public void shutdown() {
        Slog.w(TAG, "Writing app ops before shutdown...");
        boolean doWrite = false;
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteScheduled == false) goto L9;
        this.mWriteScheduled = false;     // Catch: Throwable -> L7
        doWrite = true;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (doWrite == false) goto L17;
        writeState();
        return;
    }

    private ArrayList<SmtOpsManager.OpEntry> collectOps(Ops pkgOps, int[] ops) {
        ArrayList<SmtOpsManager.OpEntry> resOps = null;
        if (ops != null) goto L9;
        ArrayList<SmtOpsManager.OpEntry> resOps2 = new ArrayList();
        int j = 0;
    L6:
        if (j >= pkgOps.size()) goto L24;
        Op curOp = pkgOps.valueAt(j);
        resOps2.add(new SmtOpsManager.OpEntry(curOp.op, curOp.mode, curOp.time, curOp.rejectTime, curOp.duration));
        j = j + 1;
        goto L6
    L24:
        return resOps2;
    L9:
        int j2 = 0;
    L11:
        if (j2 >= ops.length) goto L19;
        Op curOp2 = pkgOps.get(ops[j2]);
        if (curOp2 == null) goto L17;
        if (resOps != null) goto L16;
        resOps = new ArrayList();
    L16:
        resOps.add(new SmtOpsManager.OpEntry(curOp2.op, curOp2.mode, curOp2.time, curOp2.rejectTime, curOp2.duration));
    L17:
        j2 = j2 + 1;
        goto L11
    L19:
        return resOps;
    }

    public List<SmtOpsManager.PackageOps> getPackagesForOps(int[] ops) {
        this.mContext.enforcePermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
        ArrayList<SmtOpsManager.PackageOps> res = null;
        monitor-enter(this);
        int i = 0;
    L24:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUidOps.size()) goto L20;
        HashMap<String, Ops> packages = this.mUidOps.valueAt(i);     // Catch: Throwable -> L14
        Iterator<Ops> r3 = packages.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r3.hasNext() == false) goto L18;
        Ops pkgOps = r3.next();     // Catch: Throwable -> L14
        ArrayList<SmtOpsManager.OpEntry> resOps = collectOps(pkgOps, ops);     // Catch: Throwable -> L14
        if (resOps == null) goto L9;
        if (res != null) goto L16;
        res = new ArrayList();     // Catch: Throwable -> L14
    L16:
        SmtOpsManager.PackageOps resPackage = new SmtOpsManager.PackageOps(pkgOps.packageName, pkgOps.uid, resOps);     // Catch: Throwable -> L14
        res.add(resPackage);     // Catch: Throwable -> L14
        goto L9
    L18:
        i = i + 1;     // Catch: Throwable -> L14
        goto L24
    L20:
        monitor-exit(this);     // Catch: Throwable -> L14
        return res;
    }

    public List<SmtOpsManager.PackageOps> getOpsForPackage(int uid, String packageName, int[] ops) {
        this.mContext.enforcePermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
        monitor-enter(this);
        Ops pkgOps = getOpsLocked(uid, packageName, false);     // Catch: Throwable -> L9
        if (pkgOps != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return null;
    L11:
        ArrayList<SmtOpsManager.OpEntry> resOps = collectOps(pkgOps, ops);     // Catch: Throwable -> L9
        if (resOps != null) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L9
        return null;
    L15:
        ArrayList<SmtOpsManager.PackageOps> res = new ArrayList();     // Catch: Throwable -> L9
        SmtOpsManager.PackageOps resPackage = new SmtOpsManager.PackageOps(pkgOps.packageName, pkgOps.uid, resOps);     // Catch: Throwable -> L9
        res.add(resPackage);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return res;
    L9:
        th = move-exception;
        throw th;
    }

    private void pruneOp(Op op, int uid, String packageName) {
        if (op.time == 0) goto L5;
        return;
    L5:
        if (op.rejectTime != 0) goto L17;
        Ops ops = getOpsLocked(uid, packageName, false);
        if (ops == null) goto L18;
        ops.remove(op.op);
        if (ops.size() > 0) goto L19;
        HashMap<String, Ops> pkgOps = this.mUidOps.get(uid);
        if (pkgOps == null) goto L20;
        pkgOps.remove(ops.packageName);
        if (pkgOps.size() > 0) goto L21;
        this.mUidOps.remove(uid);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public void setMode(int code, int uid, String packageName, int mode) {
        if (verifyIncomingUid(uid, code, packageName) == true) goto L5;
        return;
    L5:
        verifyIncomingOp(code);
        ArrayList<Callback> repCbs = null;
        monitor-enter(this);
        Op op = getOpLocked(code, uid, packageName, true);     // Catch: Throwable -> L16
        if (op != null) goto L11;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L16
        if (repCbs == null) goto L37;
        int i = 0;
    L32:
        if (i >= repCbs.size()) goto L47;
        repCbs.get(i).mCallback.opChanged(code, packageName, uid);     // Catch: RemoteException -> L35
    L36:
        i = i + 1;
        goto L32
    L47:
        return;
    L37:
        return;
    L11:
        if (op.mode == mode) goto L28;
        op.mode = mode;     // Catch: Throwable -> L16
        ArrayList<Callback> cbs = this.mOpModeWatchers.get(code);     // Catch: Throwable -> L16
        if (cbs == null) goto L19;
        if (0 != 0) goto L18;
        repCbs = new ArrayList();     // Catch: Throwable -> L16
    L18:
        repCbs.addAll(cbs);     // Catch: Throwable -> L16
    L19:
        ArrayList<Callback> cbs2 = this.mPackageModeWatchers.get(packageName);     // Catch: Throwable -> L16
        if (cbs2 == null) goto L25;
        if (repCbs != null) goto L23;
        repCbs = new ArrayList();     // Catch: Throwable -> L16
    L23:
        repCbs.addAll(cbs2);     // Catch: Throwable -> L16
    L25:
        if (mode != getDefaultMode(op.op, op.uid, op.packageName)) goto L27;
        pruneOp(op, uid, packageName);     // Catch: Throwable -> L16
    L27:
        scheduleWriteNowLocked();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private static HashMap<Callback, ArrayList<Pair<String, Pair<Integer, Integer>>>> addCallbacks(HashMap<Callback, ArrayList<Pair<String, Pair<Integer, Integer>>>> callbacks, String packageName, int op, int uid, ArrayList<Callback> cbs) {
        if (cbs != null) goto L4;
        return callbacks;
    L4:
        if (callbacks != null) goto L6;
        callbacks = new HashMap();
    L6:
        int i = 0;
    L8:
        if (i >= cbs.size()) goto L14;
        Callback cb = cbs.get(i);
        ArrayList<Pair<String, Pair<Integer, Integer>>> reports = callbacks.get(cb);
        if (reports != null) goto L12;
        reports = new ArrayList();
        callbacks.put(cb, reports);
    L12:
        reports.add(new Pair(packageName, new Pair(Integer.valueOf(op), Integer.valueOf(uid))));
        i = i + 1;
        goto L8
    L14:
        return callbacks;
    }

    public void startWatchingMode(int op, String packageName, ISmtOpsCallback callback) {
        if (checkPermission(Binder.getCallingUid()) == true) goto L6;
        Log.d(TAG, "startWatchingMode: no permission to watch package " + packageName + " callinguid " + Binder.getCallingUid());
        return;
    L6:
        monitor-enter(this);
        Callback cb = this.mModeWatchers.get(callback.asBinder());     // Catch: Throwable -> L10
        if (cb != null) goto L13;
        cb = new Callback(this, callback);     // Catch: Throwable -> L10
        this.mModeWatchers.put(callback.asBinder(), cb);     // Catch: Throwable -> L10
    L13:
        if (op == (-1)) goto L18;
        ArrayList<Callback> cbs = this.mOpModeWatchers.get(op);     // Catch: Throwable -> L10
        if (cbs != null) goto L17;
        cbs = new ArrayList();     // Catch: Throwable -> L10
        this.mOpModeWatchers.put(op, cbs);     // Catch: Throwable -> L10
    L17:
        cbs.add(cb);     // Catch: Throwable -> L10
    L18:
        if (packageName == null) goto L23;
        ArrayList<Callback> cbs2 = this.mPackageModeWatchers.get(packageName);     // Catch: Throwable -> L10
        if (cbs2 != null) goto L22;
        cbs2 = new ArrayList();     // Catch: Throwable -> L10
        this.mPackageModeWatchers.put(packageName, cbs2);     // Catch: Throwable -> L10
    L22:
        cbs2.add(cb);     // Catch: Throwable -> L10
    L23:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void stopWatchingMode(ISmtOpsCallback callback) {
        monitor-enter(this);
        Callback cb = this.mModeWatchers.remove(callback.asBinder());     // Catch: Throwable -> L10
        if (cb == null) goto L19;
        cb.unlinkToDeath();     // Catch: Throwable -> L10
        int i = this.mOpModeWatchers.size() - 1;     // Catch: Throwable -> L10
    L6:
        if (i < 0) goto L13;
        ArrayList<Callback> cbs = this.mOpModeWatchers.valueAt(i);     // Catch: Throwable -> L10
        cbs.remove(cb);     // Catch: Throwable -> L10
        if (cbs.size() > 0) goto L12;
        this.mOpModeWatchers.removeAt(i);     // Catch: Throwable -> L10
    L12:
        i = i - 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        int i2 = this.mPackageModeWatchers.size() - 1;     // Catch: Throwable -> L10
    L14:
        if (i2 < 0) goto L19;
        ArrayList<Callback> cbs2 = this.mPackageModeWatchers.valueAt(i2);     // Catch: Throwable -> L10
        cbs2.remove(cb);     // Catch: Throwable -> L10
        if (cbs2.size() > 0) goto L18;
        this.mPackageModeWatchers.removeAt(i2);     // Catch: Throwable -> L10
    L18:
        i2 = i2 - 1;     // Catch: Throwable -> L10
    L19:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public IBinder getToken(IBinder clientToken) {
        monitor-enter(this);
        ClientState cs = this.mClients.get(clientToken);     // Catch: Throwable -> L6
        if (cs != null) goto L8;
        cs = new ClientState(this, clientToken);     // Catch: Throwable -> L6
        this.mClients.put(clientToken, cs);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return cs;
    L6:
        th = move-exception;
        throw th;
    }

    public int checkOperation(int code, int uid, String packageName) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L10;
        Log.d(TAG, "checkOperation: for uid " + uid + " package " + packageName + " code " + code);     // Catch: Throwable -> L7
    L10:
        if (this.mEnabled == true) goto L20;
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L20;
        if (code == 21) goto L20;
        if (code == 28) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L7
        return 0;
    L20:
        if (canIgnoreCheckOp(code, uid, packageName) == false) goto L23;
        monitor-exit(this);     // Catch: Throwable -> L7
        return 0;
    L23:
        Op op = getOpLocked(code, uid, packageName, false);     // Catch: Throwable -> L7
        if (op != null) goto L28;
        int r1 = getDefaultMode(code, uid, packageName);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r1;
    L28:
        int r2 = op.mode;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r2;
    }

    public void checkOpAndGrantRuntimePermissionAsync(String runtimePerm, int uid, String packageName, int flags) {
        Message msg = Message.obtain();
        msg.what = 4;
        HashMap data = new HashMap();
        data.put("runtimePerm", runtimePerm);
        data.put("uid", Integer.valueOf(uid));
        data.put("packageName", packageName);
        data.put("flags", Integer.valueOf(flags));
        msg.obj = data;
        this.mHandler.sendMessage(msg);
    }

    public void checkOpAndGrantRuntimePermission(String runtimePerm, int uid, String packageName, int flags) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(runtimePerm) == false) goto L5;
        String runtimePerm2 = "android.permission.ACCESS_COARSE_LOCATION";
    L7:
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(runtimePerm2) == true) goto L39;
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(runtimePerm2) == true) goto L39;
        int code = SmtOpsManager.runtimePermissionToOp(runtimePerm2);
        if (code >= 0) goto L14;
        return;
    L14:
        monitor-enter(this);
    L29:
        th = th;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L29
        throw th;
    L31:
        th = th;
        goto L36
    L16:
        if (DEBUG == false) goto L22;
        Log.d(TAG, "checkOperationForRuntimePermission: for uid " + uid + " package " + packageName + " code " + code);     // Catch: Throwable -> L19
    L19:
        th = th;
    L22:
        Op op = getOpLocked(code, uid, packageName, false);     // Catch: Throwable -> L31
        if (op == null) goto L34;
        if (op.mode != 0) goto L34;
        this.mContext.getPackageManager().grantRuntimePermission(packageName, runtimePerm2, UserHandle.getUserHandleForUid(uid));     // Catch: Throwable -> L31
        this.mContext.getPackageManager().updatePermissionFlags(runtimePerm2, packageName, flags, flags, UserHandle.getUserHandleForUid(uid));     // Catch: Throwable -> L29
    L34:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L39:
        this.mContext.getPackageManager().grantRuntimePermission(packageName, runtimePerm2, UserHandle.getUserHandleForUid(uid));
        this.mContext.getPackageManager().updatePermissionFlags(runtimePerm2, packageName, flags, flags, UserHandle.getUserHandleForUid(uid));
        return;
    L5:
        runtimePerm2 = runtimePerm;
        goto L7
    }

    public int checkPackage(int uid, String packageName) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (getOpsLocked(uid, packageName, true) == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return 1;
    }

    public int noteOperation(int code, int uid, String packageName) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        monitor-enter(this);
        if (uid < 10000) goto L12;
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mEnabled == false) goto L12;
    L16:
        if (canIgnoreCheckOp(code, uid, packageName) == false) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L19:
        Ops ops = getOpsLocked(uid, packageName, true);     // Catch: Throwable -> L9
        if (ops == null) goto L22;
        Op op = getOpLockedInner(ops, code, true);     // Catch: Throwable -> L9
        if (op.duration != (-1)) goto L29;
        Slog.w(TAG, "Noting op not finished: uid " + uid + " pkg " + packageName + " code " + code + " time=" + op.time + " duration=" + op.duration);     // Catch: Throwable -> L9
    L29:
        op.duration = 0;     // Catch: Throwable -> L9
        if (op.mode != 1) goto L38;
        if (DEBUG == false) goto L34;
        Log.d(TAG, "noteOperation: reject #" + op.mode + " for code " + code + " (" + code + ") uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L34:
        op.rejectTime = System.currentTimeMillis();     // Catch: Throwable -> L9
        int r0 = op.mode;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L38:
        if (op.mode != 0) goto L46;
        if (DEBUG == false) goto L42;
        Log.d(TAG, "noteOperation: allowing code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L42:
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L9
        op.rejectTime = 0;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L46:
        if (op.mode != 3) goto L54;
        if (DEBUG == false) goto L50;
        Log.d(TAG, "noteOperation: during use code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L50:
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L9
        op.rejectTime = 0;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return 3;
    L54:
        if (DEBUG == false) goto L56;
        Log.d(TAG, "noteOperation: ask code " + code + " uid " + uid + " mode " + op.mode + " package " + packageName);     // Catch: Throwable -> L9
    L56:
        op.noteOpCount++;     // Catch: Throwable -> L9
        PermissionDialogResult.Result userDialogResult = askOperationLocked(code, uid, packageName, op);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return userDialogResult.get();
    L22:
        if (DEBUG == false) goto L24;
        Log.d(TAG, "noteOperation: no op for code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L24:
        monitor-exit(this);     // Catch: Throwable -> L9
        return 1;
    L12:
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    }

    public int noteProcessOperation(int code, int pid, int uid, String packageName) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        monitor-enter(this);
        if (uid < 10000) goto L78;
    L9:
        th = th;
    L74:
        monitor-exit(this);     // Catch: Throwable -> L70
        throw th;
    L7:
        if (this.mEnabled == false) goto L78;
    L16:
        if (canIgnoreCheckOp(code, uid, packageName) == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L20:
        Ops ops = getOpsLocked(uid, packageName, true);     // Catch: Throwable -> L72
        if (ops == null) goto L23;
        Op op = getOpLockedInner(ops, code, true);     // Catch: Throwable -> L72
        if (op.duration != (-1)) goto L31;
        Slog.w(TAG, "Noting op not finished: uid " + uid + " pkg " + packageName + " code " + code + " time=" + op.time + " duration=" + op.duration);     // Catch: Throwable -> L9
    L31:
        op.duration = 0;     // Catch: Throwable -> L72
        if (op.mode != 1) goto L41;
        if (DEBUG == false) goto L36;
        Log.d(TAG, "noteProcessOperation: reject #" + op.mode + " for code " + code + " (" + code + ") uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L36:
        op.rejectTime = System.currentTimeMillis();     // Catch: Throwable -> L9
        int r0 = op.mode;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L41:
        if (op.mode != 0) goto L50;
        if (DEBUG == false) goto L45;
        Log.d(TAG, "noteProcessOperation: allowing code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L45:
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L9
        op.rejectTime = 0;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L50:
        if (op.mode == 3) goto L52;
        HashMap<Integer, Integer> pidOps = this.mProcessMaps.get(Integer.valueOf(pid));     // Catch: Throwable -> L72
        if (pidOps != null) goto L62;
        pidOps = new HashMap();     // Catch: Throwable -> L9
    L62:
        if (pidOps.get(Integer.valueOf(code)) != null) goto L64;
        pidOps.put(Integer.valueOf(code), 2);     // Catch: Throwable -> L9
    L64:
        this.mProcessMaps.put(Integer.valueOf(pid), pidOps);     // Catch: Throwable -> L72
        op.noteOpCount++;     // Catch: Throwable -> L72
        PermissionDialogResult.Result userDialogResult = askOperationLocked(code, pid, uid, packageName, op);     // Catch: Throwable -> L70
        monitor-exit(this);     // Catch: Throwable -> L70
        return userDialogResult.get();
    L72:
        th = th;
        goto L74
    L52:
        if (DEBUG == false) goto L54;
        Log.d(TAG, "noteOperation: during use code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L54:
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L9
        op.rejectTime = 0;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return 3;
    L23:
        if (DEBUG == false) goto L25;
        Log.d(TAG, "noteProcessOperation: no op for code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L25:
        monitor-exit(this);     // Catch: Throwable -> L9
        return 1;
    L78:
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L70:
        th = th;
        goto L74
    }

    public int startOperation(IBinder token, int code, int uid, String packageName) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        ClientState client = (ClientState) token;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L13;
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return 0;
    L13:
        if (canIgnoreCheckOp(code, uid, packageName) == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L10
        return 0;
    L16:
        Ops ops = getOpsLocked(uid, packageName, true);     // Catch: Throwable -> L10
        if (ops == null) goto L19;
        Op op = getOpLockedInner(ops, code, true);     // Catch: Throwable -> L10
        if (op.mode != 1) goto L32;
        if (DEBUG == false) goto L28;
        Log.d(TAG, "startOperation: reject #" + op.mode + " for code " + code + " (" + code + ") uid " + uid + " package " + packageName);     // Catch: Throwable -> L10
    L28:
        op.rejectTime = System.currentTimeMillis();     // Catch: Throwable -> L10
        int r1 = op.mode;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r1;
    L32:
        if (op.mode != 0) goto L45;
        if (DEBUG == false) goto L37;
        Log.d(TAG, "startOperation: allowing code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L10
    L37:
        if (op.nesting != 0) goto L39;
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L10
        op.rejectTime = 0;     // Catch: Throwable -> L10
        op.duration = -1;     // Catch: Throwable -> L10
    L39:
        op.nesting++;     // Catch: Throwable -> L10
        if (client.mStartedOps == null) goto L42;
        client.mStartedOps.add(op);     // Catch: Throwable -> L10
    L42:
        monitor-exit(this);     // Catch: Throwable -> L10
        return 0;
    L45:
        if (op.mode == 3) goto L47;
        op.startOpCount++;     // Catch: Throwable -> L10
        IBinder clientToken = client.mAppToken;     // Catch: Throwable -> L10
        op.mClientTokens.add(clientToken);     // Catch: Throwable -> L10
        PermissionDialogResult.Result userDialogResult = askOperationLocked(code, uid, packageName, op);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return userDialogResult.get();
    L47:
        if (DEBUG == false) goto L50;
        Log.d(TAG, "startOperation: during use code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L10
    L50:
        if (op.nesting != 0) goto L52;
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L10
        op.rejectTime = 0;     // Catch: Throwable -> L10
        op.duration = -1;     // Catch: Throwable -> L10
    L52:
        op.nesting++;     // Catch: Throwable -> L10
        if (client.mStartedOps == null) goto L55;
        client.mStartedOps.add(op);     // Catch: Throwable -> L10
    L55:
        monitor-exit(this);     // Catch: Throwable -> L10
        return 0;
    L19:
        if (DEBUG == false) goto L21;
        Log.d(TAG, "startOperation: no op for code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L10
    L21:
        monitor-exit(this);     // Catch: Throwable -> L10
        return 1;
    }

    public void finishOperation(IBinder token, int code, int uid, String packageName) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        ClientState client = (ClientState) token;
        monitor-enter(this);
        Op op = getOpLocked(code, uid, packageName, true);     // Catch: Throwable -> L9
        if (op != null) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L12:
        if (client.mStartedOps != null) goto L14;
    L18:
        finishOperationLocked(op);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L14:
        if (client.mStartedOps.remove(op) == true) goto L18;
        throw new IllegalStateException("Operation not started: uid" + op.uid + " pkg=" + op.packageName + " op=" + op.op);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void finishOperationLocked(Op op) {
        if (op.nesting <= 1) goto L5;
        op.nesting--;
        return;
    L5:
        if (op.nesting != 1) goto L7;
        op.duration = (int) (System.currentTimeMillis() - op.time);
        op.time += (long) op.duration;
    L8:
        op.nesting = 0;
        return;
    L7:
        Slog.w(TAG, "Finishing op nesting under-run: uid " + op.uid + " pkg " + op.packageName + " code " + op.op + " time=" + op.time + " duration=" + op.duration + " nesting=" + op.nesting);
        goto L8
    }

    private void verifyIncomingUid(int uid) {
        if (uid != Binder.getCallingUid()) goto L6;
        return;
    L6:
        if (Binder.getCallingPid() != Process.myPid()) goto L8;
        return;
    L8:
        this.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
    }

    private boolean verifyIncomingUid(int uid, int code, String packageName) {
        if (uid != Binder.getCallingUid()) goto L6;
        return true;
    L6:
        if (Binder.getCallingPid() != Process.myPid()) goto L13;
        return true;
    L13:
        this.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);     // Catch: SecurityException -> L10
        return true;
    L11:
        Log.w(TAG, "package " + packageName + " uid=" + uid + " verify failed");
        return false;
    }

    private void verifyIncomingOp(int op) {
        if (op < 0) goto L7;
        if (op >= 31) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Bad operation #" + op);
    }

    private Ops getOpsLocked(int uid, String packageName, boolean edit) {
        HashMap<String, Ops> pkgOps = this.mUidOps.get(uid);
        if (pkgOps != null) goto L7;
        if (edit == true) goto L6;
        return null;
    L6:
        pkgOps = new HashMap();
        this.mUidOps.put(uid, pkgOps);
    L7:
        if (uid != 0) goto L10;
        packageName = "root";
    L16:
        Ops ops = pkgOps.get(packageName);
        if (ops != null) goto L42;
        if (edit == true) goto L20;
        return null;
    L20:
        if (uid == 0) goto L37;
        long ident = Binder.clearCallingIdentity();
        int pkgUid = -1;
        pkgUid = this.mContext.getPackageManager().getPackageUidAsUser(packageName, 8192, UserHandle.getUserId(uid));     // Catch: Throwable -> L24 PackageManager.NameNotFoundException -> L26
    L30:
        if (pkgUid == uid) goto L34;
        Slog.w(TAG, "Bad call: specified package " + packageName + " under uid " + uid + " but it is really " + pkgUid);     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(ident);
        return null;
    L34:
        Binder.restoreCallingIdentity(ident);
        goto L37
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L28:
        if ("media".equals(packageName) == false) goto L30;
        pkgUid = 1013;
    L37:
        Ops ops2 = new Ops(packageName, uid);
        pkgOps.put(packageName, ops2);
        return ops2;
    L42:
        return ops;
    L10:
        if (uid != 2000) goto L13;
        packageName = "com.android.shell";
        goto L16
    L13:
        if (uid != 1000) goto L16;
        if (packageName != null) goto L16;
        packageName = PackageManagerService.PLATFORM_PACKAGE_NAME;
        goto L16
    }

    private void scheduleWriteLocked() {
        if (this.mWriteScheduled == true) goto L6;
        this.mWriteScheduled = true;
        this.mHandler.postDelayed(this.mWriteRunner, WRITE_DELAY);
        return;
    }

    private void scheduleWriteNowLocked() {
        if (this.mWriteNowScheduled == true) goto L6;
        this.mWriteScheduled = true;
        this.mWriteNowScheduled = true;
        this.mHandler.removeCallbacks(this.mWriteRunner);
        this.mHandler.postDelayed(this.mWriteRunner, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    }

    private Op getOpLocked(int code, int uid, String packageName, boolean edit) {
        Ops ops = getOpsLocked(uid, packageName, edit);
        if (ops != null) goto L7;
        return null;
    L7:
        return getOpLocked(ops, code, edit);
    }

    private Op getOpLocked(Ops ops, int code, boolean edit) {
        Op op = ops.get(code);
        if (op != null) goto L8;
        if (edit == true) goto L7;
        return null;
    L7:
        int mode = getDefaultMode(code, ops.uid, ops.packageName);
        op = new Op(ops.uid, ops.packageName, code, mode);
        ops.put(code, op);
    L8:
        if (edit == false) goto L10;
        scheduleWriteLocked();
    L10:
        return op;
    }

    private Op getOpLockedInner(Ops ops, int code, boolean edit) {
        return getOpLockedInner(ops, code, edit, null);
    }

    private Op getOpLockedInner(Ops ops, int code, boolean edit, String target) {
        Op op = ops.get(code);
        if (op != null) goto L11;
        if (edit == true) goto L7;
        return null;
    L7:
        int mode = getDefaultMode(code, ops.uid, ops.packageName);
        if (mode != 2) goto L10;
        mode = -1;
        edit = false;
    L10:
        op = new Op(ops.uid, ops.packageName, code, mode);
        ops.put(code, op);
    L11:
        if (edit == false) goto L13;
        scheduleWriteLocked();
    L13:
        return op;
    }

    void readState() {
        AtomicFile r0 = this.mFile;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L102
        FileInputStream stream = this.mFile.openRead();     // Catch: Throwable -> L55 FileNotFoundException -> L111
        goto L112
    L126:
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        parser.setInput(stream, null);     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
    L8:
        int type = parser.next();     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        if (type == 2) goto L12;
        if (type != 1) goto L8;
    L12:
        if (type != 2) goto L62;
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
    L14:
        int type2 = parser.next();     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        if (type2 == 1) goto L52;
        if (type2 == 3) goto L19;
    L36:
        if (type2 == 3) goto L14;
        if (type2 == 4) goto L14;
        String tagName = parser.getName();     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        if (tagName.equals(SceneUtils.KEY_PKG) == true) goto L42;
        if (tagName.equals("enable") == true) goto L45;
        if (tagName.equals("version") == true) goto L48;
        Slog.w(TAG, "Unknown element under <smt-ops>: " + parser.getName());     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        goto L14
    L48:
        String version = parser.getAttributeValue(null, "version");     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        Slog.i(TAG, "parse smt ops version " + version);     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        goto L14
    L45:
        this.mEnabled = Boolean.parseBoolean(parser.getAttributeValue(null, "e"));     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        goto L14
    L42:
        readPackage(parser);     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
        goto L14
    L19:
        if (parser.getDepth() > outerDepth) goto L36;
    L52:
        if (1 != 0) goto L57;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L57:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L123:
        goto L99
    L62:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L21 IndexOutOfBoundsException -> L23 IOException -> L25 XmlPullParserException -> L27 NumberFormatException -> L29 NullPointerException -> L31 IllegalStateException -> L33
    L27:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L79;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L79:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L33:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L97;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L97:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L25:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L73;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L73:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L31:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L91;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L91:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L23:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L67;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L67:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L29:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L85;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L85:
        stream.close();     // Catch: Throwable -> L55 IOException -> L59
    L99:
        monitor-exit(this);     // Catch: Throwable -> L55
        monitor-exit(r0);     // Catch: Throwable -> L102
        return;
    L21:
        th = move-exception;
        if (0 != 0) goto L127;
        this.mUidOps.clear();     // Catch: Throwable -> L55
    L127:
        stream.close();     // Catch: Throwable -> L55 IOException -> L108
    L110:
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L102
    L112:
        Slog.i(TAG, "No existing smt ops " + this.mFile.getBaseFile() + "; starting empty");     // Catch: Throwable -> L55
        return;
    L102:
        th = move-exception;
        throw th;
    }

    void readPackage(XmlPullParser parser) throws NumberFormatException, XmlPullParserException, IOException {
        String pkgName = parser.getAttributeValue(null, "n");
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("uid") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readUid(parser, pkgName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    void readUid(XmlPullParser parser, String pkgName) throws NumberFormatException, XmlPullParserException, IOException {
        int uid = Integer.parseInt(parser.getAttributeValue(null, "n"));
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L28;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        int code = SmtOpsManager.opNameToOp(parser.getAttributeValue(null, "n"));
        int defaultMode = getDefaultMode(code, uid, pkgName);
        Op op = new Op(uid, pkgName, code, defaultMode);
        String mode = parser.getAttributeValue(null, "m");
        if (mode == null) goto L19;
        op.mode = SmtOpsManager.modeNameToMode(mode);
    L19:
        HashMap<String, Ops> pkgOps = this.mUidOps.get(uid);
        if (pkgOps != null) goto L22;
        pkgOps = new HashMap();
        this.mUidOps.put(uid, pkgOps);
    L22:
        Ops ops = pkgOps.get(pkgName);
        if (ops != null) goto L25;
        ops = new Ops(pkgName, uid);
        pkgOps.put(pkgName, ops);
    L25:
        ops.put(op.op, op);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    void writeState() {
        AtomicFile r0 = this.mFile;
        monitor-enter(r0);
        List<SmtOpsManager.PackageOps> allOps = getPackagesForOps(null);     // Catch: Throwable -> L16
        FileOutputStream stream = this.mFile.startWrite();     // Catch: Throwable -> L16 IOException -> L35
        FastXmlSerializer r4 = new FastXmlSerializer();     // Catch: Throwable -> L16 IOException -> L18
        r4.setOutput(stream, "utf-8");     // Catch: Throwable -> L16 IOException -> L18
        r4.startDocument(null, true);     // Catch: Throwable -> L16 IOException -> L18
        r4.startTag(null, "smt-ops");     // Catch: Throwable -> L16 IOException -> L18
        r4.startTag(null, "version");     // Catch: Throwable -> L16 IOException -> L18
        r4.attribute(null, "version", "1.0");     // Catch: Throwable -> L16 IOException -> L18
        r4.endTag(null, "version");     // Catch: Throwable -> L16 IOException -> L18
        r4.startTag(null, "enable");     // Catch: Throwable -> L16 IOException -> L18
        r4.attribute(null, "e", Boolean.toString(this.mEnabled));     // Catch: Throwable -> L16 IOException -> L18
        r4.endTag(null, "enable");     // Catch: Throwable -> L16 IOException -> L18
        if (allOps == null) goto L29;
        String lastPkg = null;
        int i = 0;
    L11:
        if (i >= allOps.size()) goto L27;
        SmtOpsManager.PackageOps pkg = allOps.get(i);     // Catch: Throwable -> L16 IOException -> L18
        if (pkg.getPackageName().equals(lastPkg) == true) goto L21;
        if (lastPkg == null) goto L20;
        r4.endTag(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L16 IOException -> L18
    L20:
        String lastPkg2 = pkg.getPackageName();     // Catch: Throwable -> L16 IOException -> L18
        r4.startTag(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L16 IOException -> L18
        r4.attribute(null, "n", lastPkg2);     // Catch: Throwable -> L16 IOException -> L18
        lastPkg = lastPkg2;
    L21:
        r4.startTag(null, "uid");     // Catch: Throwable -> L16 IOException -> L18
        r4.attribute(null, "n", Integer.toString(pkg.getUid()));     // Catch: Throwable -> L16 IOException -> L18
        List<SmtOpsManager.OpEntry> ops = pkg.getOps();     // Catch: Throwable -> L16 IOException -> L18
        int j = 0;
    L23:
        if (j >= ops.size()) goto L25;
        SmtOpsManager.OpEntry op = ops.get(j);     // Catch: Throwable -> L16 IOException -> L18
        r4.startTag(null, "op");     // Catch: Throwable -> L16 IOException -> L18
        r4.attribute(null, "n", SmtOpsManager.opToName(op.getOp()));     // Catch: Throwable -> L16 IOException -> L18
        r4.attribute(null, "m", SmtOpsManager.modeToName(op.getMode()));     // Catch: Throwable -> L16 IOException -> L18
        r4.endTag(null, "op");     // Catch: Throwable -> L16 IOException -> L18
        j = j + 1;     // Catch: Throwable -> L16 IOException -> L18
        goto L23
    L25:
        r4.endTag(null, "uid");     // Catch: Throwable -> L16 IOException -> L18
        i = i + 1;     // Catch: Throwable -> L16 IOException -> L18
        goto L11
    L27:
        if (lastPkg == null) goto L29;
        r4.endTag(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L16 IOException -> L18
    L29:
        r4.endTag(null, "smt-ops");     // Catch: Throwable -> L16 IOException -> L18
        r4.endDocument();     // Catch: Throwable -> L16 IOException -> L18
        this.mFile.finishWrite(stream);     // Catch: Throwable -> L16 IOException -> L18
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L18:
        e = move-exception;
        Slog.w(TAG, "Failed to write state, restoring backup.", e);     // Catch: Throwable -> L16
        this.mFile.failWrite(stream);     // Catch: Throwable -> L16
        goto L33
    L35:
        e = move-exception;
        Slog.w(TAG, "Failed to write state: " + e);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        pw.println("Permission Denial: can't dump ApOps service from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
        return;
    L6:
        monitor-enter(this);
        pw.println("Current SmtOps Service state:");     // Catch: Throwable -> L16
        long now = System.currentTimeMillis();     // Catch: Throwable -> L16
        boolean needSep = false;
        if (this.mOpModeWatchers.size() <= 0) goto L20;
        needSep = true;
        pw.println("  Op mode watchers:");     // Catch: Throwable -> L16
        int i = 0;
    L11:
        if (i >= this.mOpModeWatchers.size()) goto L20;
        pw.print("    Op ");     // Catch: Throwable -> L16
        pw.print(SmtOpsManager.opToName(this.mOpModeWatchers.keyAt(i)));     // Catch: Throwable -> L16
        pw.println(":");     // Catch: Throwable -> L16
        ArrayList<Callback> callbacks = this.mOpModeWatchers.valueAt(i);     // Catch: Throwable -> L16
        int j = 0;
    L14:
        if (j >= callbacks.size()) goto L18;
        pw.print("      #");     // Catch: Throwable -> L16
        pw.print(j);     // Catch: Throwable -> L16
        pw.print(": ");     // Catch: Throwable -> L16
        pw.println(callbacks.get(j));     // Catch: Throwable -> L16
        j = j + 1;     // Catch: Throwable -> L16
        goto L14
    L18:
        i = i + 1;     // Catch: Throwable -> L16
    L20:
        if (this.mPackageModeWatchers.size() <= 0) goto L30;
        needSep = true;
        pw.println("  Package mode watchers:");     // Catch: Throwable -> L16
        int i2 = 0;
    L23:
        if (i2 >= this.mPackageModeWatchers.size()) goto L30;
        pw.print("    Pkg ");     // Catch: Throwable -> L16
        pw.print(this.mPackageModeWatchers.keyAt(i2));     // Catch: Throwable -> L16
        pw.println(":");     // Catch: Throwable -> L16
        ArrayList<Callback> callbacks2 = this.mPackageModeWatchers.valueAt(i2);     // Catch: Throwable -> L16
        int j2 = 0;
    L26:
        if (j2 >= callbacks2.size()) goto L28;
        pw.print("      #");     // Catch: Throwable -> L16
        pw.print(j2);     // Catch: Throwable -> L16
        pw.print(": ");     // Catch: Throwable -> L16
        pw.println(callbacks2.get(j2));     // Catch: Throwable -> L16
        j2 = j2 + 1;     // Catch: Throwable -> L16
        goto L26
    L28:
        i2 = i2 + 1;     // Catch: Throwable -> L16
    L30:
        if (this.mModeWatchers.size() <= 0) goto L36;
        needSep = true;
        pw.println("  All mode watchers:");     // Catch: Throwable -> L16
        int i3 = 0;
    L33:
        if (i3 >= this.mModeWatchers.size()) goto L36;
        pw.print("    ");     // Catch: Throwable -> L16
        pw.print(this.mModeWatchers.keyAt(i3));     // Catch: Throwable -> L16
        pw.print(" -> ");     // Catch: Throwable -> L16
        pw.println(this.mModeWatchers.valueAt(i3));     // Catch: Throwable -> L16
        i3 = i3 + 1;     // Catch: Throwable -> L16
    L36:
        if (this.mClients.size() <= 0) goto L49;
        needSep = true;
        pw.println("  Clients:");     // Catch: Throwable -> L16
        int i4 = 0;
    L39:
        if (i4 >= this.mClients.size()) goto L49;
        pw.print("    ");     // Catch: Throwable -> L16
        pw.print(this.mClients.keyAt(i4));     // Catch: Throwable -> L16
        pw.println(":");     // Catch: Throwable -> L16
        ClientState cs = this.mClients.valueAt(i4);     // Catch: Throwable -> L16
        pw.print("      ");     // Catch: Throwable -> L16
        pw.println(cs);     // Catch: Throwable -> L16
        if (cs.mStartedOps == null) goto L48;
        if (cs.mStartedOps.size() <= 0) goto L48;
        pw.println("      Started ops:");     // Catch: Throwable -> L16
        int j3 = 0;
    L46:
        if (j3 >= cs.mStartedOps.size()) goto L48;
        Op op = cs.mStartedOps.get(j3);     // Catch: Throwable -> L16
        pw.print("        ");     // Catch: Throwable -> L16
        pw.print("uid=");     // Catch: Throwable -> L16
        pw.print(op.uid);     // Catch: Throwable -> L16
        pw.print(" pkg=");     // Catch: Throwable -> L16
        pw.print(op.packageName);     // Catch: Throwable -> L16
        pw.print(" op=");     // Catch: Throwable -> L16
        pw.println(SmtOpsManager.opToName(op.op));     // Catch: Throwable -> L16
        j3 = j3 + 1;     // Catch: Throwable -> L16
    L48:
        i4 = i4 + 1;     // Catch: Throwable -> L16
    L49:
        if (needSep == false) goto L51;
        pw.println();     // Catch: Throwable -> L16
    L51:
        int i5 = 0;
    L53:
        if (i5 >= this.mUidOps.size()) goto L74;
        pw.print("  Uid ");     // Catch: Throwable -> L16
        UserHandle.formatUid(pw, this.mUidOps.keyAt(i5));     // Catch: Throwable -> L16
        pw.println(":");     // Catch: Throwable -> L16
        HashMap<String, Ops> pkgOps = this.mUidOps.valueAt(i5);     // Catch: Throwable -> L16
        Iterator<Ops> r6 = pkgOps.values().iterator();     // Catch: Throwable -> L16
    L56:
        if (r6.hasNext() == false) goto L72;
        Ops ops = r6.next();     // Catch: Throwable -> L16
        pw.print("    Package ");     // Catch: Throwable -> L16
        pw.print(ops.packageName);     // Catch: Throwable -> L16
        pw.println(":");     // Catch: Throwable -> L16
        int j4 = 0;
    L59:
        if (j4 >= ops.size()) goto L56;
        Op op2 = ops.valueAt(j4);     // Catch: Throwable -> L16
        pw.print("      ");     // Catch: Throwable -> L16
        pw.print(SmtOpsManager.opToName(op2.op));     // Catch: Throwable -> L16
        pw.print(": mode=");     // Catch: Throwable -> L16
        pw.print(op2.mode);     // Catch: Throwable -> L16
        if (op2.time == 0) goto L64;
        pw.print("; time=");     // Catch: Throwable -> L16
        TimeUtils.formatDuration(now - op2.time, pw);     // Catch: Throwable -> L16
        pw.print(" ago");     // Catch: Throwable -> L16
    L64:
        if (op2.rejectTime == 0) goto L67;
        pw.print("; rejectTime=");     // Catch: Throwable -> L16
        TimeUtils.formatDuration(now - op2.rejectTime, pw);     // Catch: Throwable -> L16
        pw.print(" ago");     // Catch: Throwable -> L16
    L67:
        if (op2.duration != (-1)) goto L69;
        pw.println(" (running)");     // Catch: Throwable -> L16
    L70:
        j4 = j4 + 1;     // Catch: Throwable -> L16
        goto L59
    L69:
        pw.print("; duration=");     // Catch: Throwable -> L16
        TimeUtils.formatDuration(op2.duration, pw);     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L16
        goto L70
    L72:
        i5 = i5 + 1;     // Catch: Throwable -> L16
        goto L53
    L74:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private int getDefaultMode(int code, int uid, String packageName) {
        if (uid < 10000) goto L5;
    L8:
        int mode = this.mSettings.getDefaultMode(code, uid, packageName, SmtOpsManager.opToDefaultMode(code, true));
        return mode;
    L5:
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L8;
        return 0;
    }

    private PermissionDialogResult.Result askOperationLocked(int code, int uid, String packageName, Op op) {
        return askOperationLocked(code, -1, uid, packageName, op);
    }

    public void exitPCMode() {
        if (this.mActiveItem == null) goto L6;
        notifyOperation(((Integer) this.mActiveItem.get("code")).intValue(), ((Integer) this.mActiveItem.get(SceneUtils.KEY_PID)).intValue(), ((Integer) this.mActiveItem.get("uid")).intValue(), (String) this.mActiveItem.get("packageName"), 1, false);
        this.mActiveItem = null;
        return;
    }

    private PermissionDialogResult.Result askOperationLocked(int code, int pid, int uid, String packageName, Op op) {
        PermissionDialogResult.Result result = new PermissionDialogResult.Result();
        long origId = Binder.clearCallingIdentity();
        Message msg = Message.obtain();
        msg.what = 1;
        HashMap data = new HashMap();
        data.put(MemoryManagerService.RESULT_KEY, result);
        data.put("code", Integer.valueOf(code));
        data.put("packageName", packageName);
        data.put("op", op);
        data.put("uid", Integer.valueOf(uid));
        data.put(SceneUtils.KEY_PID, Integer.valueOf(pid));
        msg.obj = data;
        this.mHandler.sendMessage(msg);
        Binder.restoreCallingIdentity(origId);
        this.mActiveItem = (HashMap) data.clone();
        return result;
    }

    private void printOperationLocked(Op op, int mode, String operation) {
        if (op != null) goto L4;
        return;
    L4:
        if (mode == 1) goto L6;
        if (mode == 0) goto L10;
        return;
    L10:
        if (DEBUG == false) goto L17;
        Log.d(TAG, operation + ": allowing code " + op.op + " uid " + op.uid + " package " + op.packageName);
        return;
    L17:
        return;
    L6:
        if (DEBUG == false) goto L14;
        Log.d(TAG, operation + ": reject #" + mode + " for code (" + op.op + ") uid " + op.uid + " package " + op.packageName);
        return;
    }

    private void recordOperationLocked(int code, int uid, String packageName, int mode) {
        Op op = getOpLocked(code, uid, packageName, false);
        if (op != null) goto L5;
        return;
    L5:
        if (op.noteOpCount == 0) goto L8;
        printOperationLocked(op, mode, "noteOperartion");
    L8:
        if (op.startOpCount == 0) goto L11;
        printOperationLocked(op, mode, "startOperation");
    L11:
        if (mode != 1) goto L13;
        op.rejectTime = System.currentTimeMillis();
    L31:
        op.startOpCount = 0;
        op.noteOpCount = 0;
        return;
    L13:
        if (mode != 0) goto L31;
        if (op.noteOpCount == 0) goto L18;
        op.time = System.currentTimeMillis();
        op.rejectTime = 0;
    L18:
        if (op.startOpCount == 0) goto L31;
        if (op.nesting != 0) goto L22;
        op.time = System.currentTimeMillis();
        op.rejectTime = 0;
        op.duration = -1;
    L22:
        op.nesting += op.startOpCount;
    L24:
        if (op.mClientTokens.size() == 0) goto L31;
        IBinder clientToken = op.mClientTokens.get(0);
        ClientState client = this.mClients.get(clientToken);
        if (client == null) goto L30;
        if (client.mStartedOps == null) goto L30;
        client.mStartedOps.add(op);
    L30:
        op.mClientTokens.remove(0);
        goto L24
    }

    public void onProcessDied(int pid, int uid) {
        this.mHandler.obtainMessage(2, pid, uid).sendToTarget();
    }

    private void recordProcessOpLocked(int code, int pid, int mode) {
        HashMap<Integer, Integer> r0 = this.mProcessMaps.get(Integer.valueOf(pid));
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get(Integer.valueOf(code)) == null) goto L11;
        int oldMode = r0.get(Integer.valueOf(code)).intValue();
        if (oldMode == mode) goto L12;
        r0.put(Integer.valueOf(code), Integer.valueOf(mode));
        return;
    L12:
        return;
    }

    public void notifyOperation(int code, int pid, int uid, String packageName, int mode, boolean remember) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        ArrayList<Callback> repCbs = null;
        monitor-enter(this);
        recordOperationLocked(code, uid, packageName, mode);     // Catch: Throwable -> L7
        if (pid == (-1)) goto L9;
        recordProcessOpLocked(code, pid, mode);     // Catch: Throwable -> L7
    L9:
        Op op = getOpLocked(code, uid, packageName, true);     // Catch: Throwable -> L7
        if (op != null) goto L12;
    L34:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (repCbs == null) goto L43;
        int i = 0;
    L38:
        if (i >= repCbs.size()) goto L53;
        repCbs.get(i).mCallback.opChanged(code, packageName, uid);     // Catch: RemoteException -> L41
    L42:
        i = i + 1;
        goto L38
    L53:
        return;
    L43:
        return;
    L12:
        if (op.dialogResult.mDialog == null) goto L14;
        op.dialogResult.notifyAll(mode);     // Catch: Throwable -> L7
        op.dialogResult.mDialog = null;     // Catch: Throwable -> L7
    L14:
        if (remember == false) goto L34;
        if (op.mode == mode) goto L34;
        if (DEBUG == false) goto L20;
        Log.d(TAG, "notifyOperation: code " + code + " mode " + mode + " code " + code + " op.mode " + op.mode);     // Catch: Throwable -> L7
    L20:
        op.mode = mode;     // Catch: Throwable -> L7
        ArrayList<Callback> cbs = this.mOpModeWatchers.get(code);     // Catch: Throwable -> L7
        if (cbs == null) goto L25;
        if (0 != 0) goto L24;
        repCbs = new ArrayList();     // Catch: Throwable -> L7
    L24:
        repCbs.addAll(cbs);     // Catch: Throwable -> L7
    L25:
        ArrayList<Callback> cbs2 = this.mPackageModeWatchers.get(packageName);     // Catch: Throwable -> L7
        if (cbs2 == null) goto L31;
        if (repCbs != null) goto L29;
        repCbs = new ArrayList();     // Catch: Throwable -> L7
    L29:
        repCbs.addAll(cbs2);     // Catch: Throwable -> L7
    L31:
        if (mode != getDefaultMode(op.op, op.uid, op.packageName)) goto L33;
        pruneOp(op, uid, packageName);     // Catch: Throwable -> L7
    L33:
        scheduleWriteNowLocked();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setEnabled(boolean enable) {
        this.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
        if (DEBUG == false) goto L5;
        Log.d(TAG, "setEnabled: enable=" + enable);
    L5:
        HashMap<Callback, ArrayList<Pair<String, Pair<Integer, Integer>>>> callbacks = null;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (Build.IS_USER == false) goto L16;
        if (Build.IS_DEBUGGABLE == true) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L13
        return true;
    L16:
        if (this.mEnabled == enable) goto L28;
        this.mEnabled = enable;     // Catch: Throwable -> L13
        int i = this.mUidOps.size() - 1;     // Catch: Throwable -> L13
    L18:
        if (i < 0) goto L27;
        HashMap<String, Ops> packages = this.mUidOps.valueAt(i);     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, Ops>> it = packages.entrySet().iterator();     // Catch: Throwable -> L13
    L21:
        if (it.hasNext() == false) goto L26;
        Map.Entry<String, Ops> ent = it.next();     // Catch: Throwable -> L13
        String packageName = ent.getKey();     // Catch: Throwable -> L13
        Ops pkgOps = ent.getValue();     // Catch: Throwable -> L13
        int j = pkgOps.size() - 1;     // Catch: Throwable -> L13
    L23:
        if (j < 0) goto L21;
        Op curOp = pkgOps.valueAt(j);     // Catch: Throwable -> L13
        callbacks = addCallbacks(addCallbacks(callbacks, packageName, curOp.op, curOp.uid, this.mOpModeWatchers.get(curOp.op)), packageName, curOp.op, curOp.uid, this.mPackageModeWatchers.get(packageName));     // Catch: Throwable -> L13
        j = j - 1;     // Catch: Throwable -> L13
        goto L23
    L26:
        i = i - 1;     // Catch: Throwable -> L13
        goto L18
    L27:
        scheduleWriteNowLocked();     // Catch: Throwable -> L13
    L28:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (callbacks == null) goto L43;
        Iterator<Map.Entry<Callback, ArrayList<Pair<String, Pair<Integer, Integer>>>>> r1 = callbacks.entrySet().iterator();
    L32:
        if (r1.hasNext() == false) goto L43;
        Map.Entry<Callback, ArrayList<Pair<String, Pair<Integer, Integer>>>> ent2 = r1.next();
        Callback cb = ent2.getKey();
        ArrayList<Pair<String, Pair<Integer, Integer>>> reports = ent2.getValue();
        int i2 = 0;
    L35:
        if (i2 >= reports.size()) goto L32;
        Pair<String, Pair<Integer, Integer>> rep = reports.get(i2);
        cb.mCallback.opChanged(((Integer) ((Pair) rep.second).first).intValue(), (String) rep.first, ((Integer) ((Pair) rep.second).second).intValue());     // Catch: RemoteException -> L39
    L40:
        i2 = i2 + 1;
    L43:
        return this.mEnabled;
    }

    public boolean getEnabled() {
        if (Build.IS_USER == false) goto L9;
        if (Build.IS_DEBUGGABLE == true) goto L9;
        return true;
    L9:
        return this.mEnabled;
    }

    private void readPackageOps(XmlPullParser parser, String pkgName) throws NumberFormatException, XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        HashMap<Integer, Integer> ops = new HashMap();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        int code = Integer.parseInt(parser.getAttributeValue(null, "n"));
        int mode = Integer.parseInt(parser.getAttributeValue(null, "m"));
        ops.put(Integer.valueOf(code), Integer.valueOf(mode));
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L19:
        this.mDefaultPackageOps.put(pkgName, ops);
    }

    public int getOpDefaultMode(int code, int uid, String packageName) {
        if (uid < 10000) goto L5;
    L8:
        int mode = this.mSettings.getDefaultMode(code, uid, packageName, SmtOpsManager.opToDefaultMode(code, true));
        return mode;
    L5:
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L8;
        return 0;
    }

    private int getOpConfig(int code, String pkgName) {
        HashMap<Integer, Integer> ops = this.mDefaultPackageOps.get(pkgName);
        if (ops == null) goto L8;
        Integer mode = ops.get(Integer.valueOf(code));
        if (mode != null) goto L7;
        return -1;
    L7:
        return mode.intValue();
    L8:
        return -1;
    }

    private void scheduleAskOperation(Op op, String targetPackage) {
        long origId = Binder.clearCallingIdentity();
        Message msg = Message.obtain();
        msg.what = 3;
        HashMap data = new HashMap();
        data.put("op", op);
        data.put("target", targetPackage);
        msg.obj = data;
        this.mHandler.sendMessage(msg);
        Binder.restoreCallingIdentity(origId);
    }

    public int noteAppOperation(int code, int uid, String packageName, String targetPackage) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        monitor-enter(this);
        if (uid < 10000) goto L12;
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mEnabled == false) goto L12;
    L16:
        if (canIgnoreCheckOp(code, uid, packageName) == false) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L19:
        Ops ops = getOpsLocked(uid, packageName, true);     // Catch: Throwable -> L9
        if (ops == null) goto L22;
        Op op = getOpLockedInner(ops, code, true, targetPackage);     // Catch: Throwable -> L9
        if (op.duration != (-1)) goto L29;
        Slog.w(TAG, "Noting op not finished: uid " + uid + " pkg " + packageName + " code " + code + " time=" + op.time + " duration=" + op.duration);     // Catch: Throwable -> L9
    L29:
        op.duration = 0;     // Catch: Throwable -> L9
        if (op.mode != 1) goto L38;
        if (DEBUG == false) goto L34;
        Log.d(TAG, "noteAppOperation: reject #" + op.mode + " for code " + code + " (" + code + ") uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L34:
        op.rejectTime = System.currentTimeMillis();     // Catch: Throwable -> L9
        int r0 = op.mode;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L38:
        if (op.mode == 0) goto L40;
        op.noteOpCount++;     // Catch: Throwable -> L9
        PermissionDialogResult.Result userDialogResult = askOperationLocked(code, uid, packageName, op);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return userDialogResult.get();
    L40:
        if (DEBUG == false) goto L42;
        Log.d(TAG, "noteAppOperation: allowing code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L42:
        op.time = System.currentTimeMillis();     // Catch: Throwable -> L9
        op.rejectTime = 0;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    L22:
        if (DEBUG == false) goto L24;
        Log.d(TAG, "noteAppOperation: no op for code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L9
    L24:
        monitor-exit(this);     // Catch: Throwable -> L9
        return 1;
    L12:
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L9
        return 0;
    }

    private boolean canIgnoreCheckOp(int code, int uid, String packageName) {
        if (SmtOpsManager.isRuntimePermissionOp(code) == true) goto L5;
        return false;
    L5:
        if (packageName == null) goto L28;
        if (uid == 0) goto L28;
        long ident = Binder.clearCallingIdentity();
        ApplicationInfo appInfo = ActivityThread.getPackageManager().getApplicationInfo(packageName, 0, UserHandle.getUserId(uid));     // Catch: Throwable -> L13 RemoteException -> L15
        if (appInfo != null) goto L11;
    L17:
        boolean ignore = false;
    L19:
        if (ignore == false) goto L21;
        Log.d(TAG, "canIgnoreCheckOp: allowing code " + code + " uid " + uid + " package " + packageName);     // Catch: Throwable -> L13 RemoteException -> L15
    L21:
        Binder.restoreCallingIdentity(ident);
        return ignore;
    L11:
        if (appInfo.targetSdkVersion < 23) goto L17;
        ignore = true;
    L15:
        e = move-exception;
        Slog.w(TAG, "Could not contact PackageManager", e);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L28:
        return false;
    }

    private boolean checkPermission(int uid) {
        if (uid != 0) goto L5;
    L17:
        return true;
    L5:
        if (uid == 1000) goto L17;
        AndroidPackage androidPackage = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackage(uid);
        if (androidPackage == null) goto L16;
        PackageInfo packageInfo = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageInfo(androidPackage.getPackageName(), 0, Process.myUid(), UserHandle.getUserId(uid));
        if (packageInfo == null) goto L15;
        if (packageInfo.applicationInfo.isSystemApp() == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
