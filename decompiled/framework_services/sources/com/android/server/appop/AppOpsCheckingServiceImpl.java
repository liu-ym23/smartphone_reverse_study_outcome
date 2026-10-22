package com.android.server.appop;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserPackage;
import android.os.Handler;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.scene.SceneUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsCheckingServiceImpl implements AppOpsCheckingServiceInterface {
    static final int CURRENT_VERSION = 4;
    private static final boolean DEBUG = false;
    private static final int NO_FILE_VERSION = -2;
    private static final int NO_VERSION = -1;
    static final String TAG = "LegacyAppOpsServiceInterfaceImpl";
    private static final long WRITE_DELAY = 1800000;
    private final LegacyAppOpStateParser mAppOpsStateParser;
    final Context mContext;
    boolean mFastWriteScheduled;
    final AtomicFile mFile;
    final Handler mHandler;
    final Object mLock;
    private List<AppOpsCheckingServiceInterface.AppOpsModeChangedListener> mModeChangedListeners;
    final SparseArray<int[]> mSwitchedOps;
    final SparseArray<SparseIntArray> mUidModes;
    final SparseArray<ArrayMap<String, SparseIntArray>> mUserPackageModes;
    private int mVersionAtBoot;
    final Runnable mWriteRunner;
    boolean mWriteScheduled;

    AppOpsCheckingServiceImpl(File storageFile, Object lock, Handler handler, Context context, SparseArray<int[]> switchedOps) {
        this.mVersionAtBoot = -2;
        this.mUidModes = new SparseArray();
        this.mUserPackageModes = new SparseArray();
        this.mAppOpsStateParser = new LegacyAppOpStateParser();
        this.mModeChangedListeners = new ArrayList();
        this.mWriteRunner = new AnonymousClass1(this);
        this.mFile = new AtomicFile(storageFile);
        this.mLock = lock;
        this.mHandler = handler;
        this.mContext = context;
        this.mSwitchedOps = switchedOps;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void systemReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        upgradeLocked(this.mVersionAtBoot);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultUidModes(int uid, String persistentDeviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseIntArray opModes = this.mUidModes.get(uid, null);     // Catch: Throwable -> L9
        if (opModes != null) goto L11;
        SparseIntArray r2 = new SparseIntArray();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        SparseIntArray r3 = opModes.clone();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultPackageModes(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.get(userId);     // Catch: Throwable -> L9
        if (packageModes != null) goto L11;
        SparseIntArray r2 = new SparseIntArray();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        SparseIntArray opModes = packageModes.get(packageName);     // Catch: Throwable -> L9
        if (opModes != null) goto L16;
        SparseIntArray r3 = new SparseIntArray();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L16:
        SparseIntArray r4 = opModes.clone();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getUidMode(int uid, String persistentDeviceId, int op) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseIntArray opModes = this.mUidModes.get(uid, null);     // Catch: Throwable -> L9
        if (opModes != null) goto L11;
        int r2 = AppOpsManager.opToDefaultMode(op);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        int r3 = opModes.get(op, AppOpsManager.opToDefaultMode(op));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean setUidMode(int uid, String persistentDeviceId, int op, int mode) {
        int defaultMode = AppOpsManager.opToDefaultMode(op);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseIntArray opModes = this.mUidModes.get(uid, null);     // Catch: Throwable -> L7
        int previousMode = defaultMode;
        if (opModes == null) goto L9;
        previousMode = opModes.get(op, defaultMode);     // Catch: Throwable -> L7
    L9:
        if (mode != previousMode) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L7
        return false;
    L13:
        if (mode != defaultMode) goto L17;
        opModes.delete(op);     // Catch: Throwable -> L7
        if (opModes.size() != 0) goto L20;
        this.mUidModes.remove(uid);     // Catch: Throwable -> L7
    L20:
        scheduleWriteLocked();     // Catch: Throwable -> L7
        List<AppOpsCheckingServiceInterface.AppOpsModeChangedListener> listenersCopy = new ArrayList(this.mModeChangedListeners);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        int i = 0;
    L24:
        if (i >= listenersCopy.size()) goto L26;
        listenersCopy.get(i).onUidModeChanged(uid, op, mode, persistentDeviceId);
        i = i + 1;
        goto L24
    L26:
        return true;
    L17:
        if (opModes != null) goto L19;
        opModes = new SparseIntArray();     // Catch: Throwable -> L7
        this.mUidModes.put(uid, opModes);     // Catch: Throwable -> L7
    L19:
        opModes.put(op, mode);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getPackageMode(String packageName, int op, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.get(userId, null);     // Catch: Throwable -> L9
        if (packageModes != null) goto L11;
        int r2 = AppOpsManager.opToDefaultMode(op);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        SparseIntArray opModes = packageModes.getOrDefault(packageName, null);     // Catch: Throwable -> L9
        if (opModes != null) goto L16;
        int r3 = AppOpsManager.opToDefaultMode(op);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L16:
        int r4 = opModes.get(op, AppOpsManager.opToDefaultMode(op));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void setPackageMode(String packageName, int op, int mode, int userId) {
        int defaultMode = AppOpsManager.opToDefaultMode(op);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.get(userId, null);     // Catch: Throwable -> L8
        if (packageModes != null) goto L10;
        if (mode == defaultMode) goto L10;
        packageModes = new ArrayMap();     // Catch: Throwable -> L8
        this.mUserPackageModes.put(userId, packageModes);     // Catch: Throwable -> L8
    L10:
        SparseIntArray opModes = null;
        int previousMode = defaultMode;
        if (packageModes == null) goto L15;
        opModes = packageModes.get(packageName);     // Catch: Throwable -> L8
        if (opModes == null) goto L15;
        previousMode = opModes.get(op, defaultMode);     // Catch: Throwable -> L8
    L15:
        if (mode != previousMode) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L18:
        if (mode != defaultMode) goto L24;
        opModes.delete(op);     // Catch: Throwable -> L8
        if (opModes.size() != 0) goto L29;
        packageModes.remove(packageName);     // Catch: Throwable -> L8
        if (packageModes.size() != 0) goto L29;
        this.mUserPackageModes.remove(userId);     // Catch: Throwable -> L8
    L29:
        scheduleFastWriteLocked();     // Catch: Throwable -> L8
        List<AppOpsCheckingServiceInterface.AppOpsModeChangedListener> listenersCopy = new ArrayList(this.mModeChangedListeners);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        int i = 0;
    L33:
        if (i >= listenersCopy.size()) goto L36;
        listenersCopy.get(i).onPackageModeChanged(packageName, userId, op, mode);
        i = i + 1;
        goto L33
    L36:
        return;
    L24:
        if (packageModes != null) goto L26;
        packageModes = new ArrayMap();     // Catch: Throwable -> L8
        this.mUserPackageModes.put(userId, packageModes);     // Catch: Throwable -> L8
    L26:
        if (opModes != null) goto L28;
        opModes = new SparseIntArray();     // Catch: Throwable -> L8
        packageModes.put(packageName, opModes);     // Catch: Throwable -> L8
    L28:
        opModes.put(op, mode);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void removeUid(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseIntArray opModes = this.mUidModes.get(uid);     // Catch: Throwable -> L8
        if (opModes != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mUidModes.remove(uid);     // Catch: Throwable -> L8
        scheduleFastWriteLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removePackage(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.get(userId, null);     // Catch: Throwable -> L8
        if (packageModes != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        SparseIntArray ops = packageModes.remove(packageName);     // Catch: Throwable -> L8
        if (ops == null) goto L16;
        scheduleFastWriteLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void clearAllModes() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidModes.clear();     // Catch: Throwable -> L7
        this.mUserPackageModes.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(int uid, String persistentDeviceId) {
        SparseBooleanArray result = new SparseBooleanArray();
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseIntArray modes = this.mUidModes.get(uid);     // Catch: Throwable -> L8
        if (modes != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L10:
        int i = 0;
    L12:
        if (i >= modes.size()) goto L18;
        if (modes.valueAt(i) != 4) goto L16;
        result.put(modes.keyAt(i), true);     // Catch: Throwable -> L8
    L16:
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(String packageName, int userId) {
        SparseBooleanArray result = new SparseBooleanArray();
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.get(userId);     // Catch: Throwable -> L8
        if (packageModes != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L10:
        SparseIntArray modes = packageModes.get(packageName);     // Catch: Throwable -> L8
        if (modes != null) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L14:
        int i = 0;
    L16:
        if (i >= modes.size()) goto L22;
        if (modes.valueAt(i) != 4) goto L20;
        result.put(modes.keyAt(i), true);     // Catch: Throwable -> L8
    L20:
        i = i + 1;     // Catch: Throwable -> L8
        goto L16
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return result;
    L8:
        th = move-exception;
        throw th;
    }

    private void scheduleWriteLocked() {
        if (this.mWriteScheduled == true) goto L6;
        this.mWriteScheduled = true;
        this.mHandler.postDelayed(this.mWriteRunner, 1800000);
        return;
    }

    private void scheduleFastWriteLocked() {
        if (this.mFastWriteScheduled == true) goto L6;
        this.mWriteScheduled = true;
        this.mFastWriteScheduled = true;
        this.mHandler.removeCallbacks(this.mWriteRunner);
        this.mHandler.postDelayed(this.mWriteRunner, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void writeState() {
        AtomicFile r2 = this.mFile;
        monitor-enter(r2);
        FileOutputStream stream = this.mFile.startWrite();     // Catch: Throwable -> L31 IOException -> L57
    L63:
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L31 IOException -> L33
        out.startDocument(null, true);     // Catch: Throwable -> L31 IOException -> L33
        out.startTag(null, "app-ops");     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "v", 4);     // Catch: Throwable -> L31 IOException -> L33
        SparseArray<SparseIntArray> uidModesCopy = new SparseArray();     // Catch: Throwable -> L31 IOException -> L33
        SparseArray<ArrayMap<String, SparseIntArray>> userPackageModesCopy = new SparseArray();     // Catch: Throwable -> L31 IOException -> L33
        Object r8 = this.mLock;     // Catch: Throwable -> L31 IOException -> L33
        monitor-enter(r8);     // Catch: Throwable -> L31 IOException -> L33
        int uidModesSize = this.mUidModes.size();     // Catch: Throwable -> L47
        int uidIdx = 0;
    L10:
        if (uidIdx >= uidModesSize) goto L16;
        int uid = this.mUidModes.keyAt(uidIdx);     // Catch: Throwable -> L13
        uidModesCopy.put(uid, this.mUidModes.valueAt(uidIdx).clone());     // Catch: Throwable -> L13
        uidIdx = uidIdx + 1;
    L13:
        th = th;
    L69:
        monitor-exit(r8);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L51:
        th = th;
        goto L69
    L16:
        int usersSize = this.mUserPackageModes.size();     // Catch: Throwable -> L47
        int userIdx = 0;
    L18:
        if (userIdx >= usersSize) goto L25;
        int user = this.mUserPackageModes.keyAt(userIdx);     // Catch: Throwable -> L13
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.valueAt(userIdx);     // Catch: Throwable -> L13
        ArrayMap<String, SparseIntArray> packageModesCopy = new ArrayMap();     // Catch: Throwable -> L13
        userPackageModesCopy.put(user, packageModesCopy);     // Catch: Throwable -> L13
        int pkgIdx = 0;
        int packageModesSize = packageModes.size();     // Catch: Throwable -> L13
    L20:
        if (pkgIdx >= packageModesSize) goto L23;
        String pkg = packageModes.keyAt(pkgIdx);     // Catch: Throwable -> L13
        int userIdx2 = userIdx;
        packageModesCopy.put(pkg, packageModes.valueAt(pkgIdx).clone());     // Catch: Throwable -> L13
        pkgIdx = pkgIdx + 1;
        userIdx = userIdx2;
        goto L20
    L23:
        userIdx = userIdx + 1;
        goto L18
    L25:
        monitor-exit(r8);     // Catch: Throwable -> L47
        int uidStateNum = 0;
    L27:
        if (uidStateNum >= uidModesSize) goto L36;
        int uid2 = uidModesCopy.keyAt(uidStateNum);     // Catch: Throwable -> L31 IOException -> L33
        SparseIntArray modes = uidModesCopy.valueAt(uidStateNum);     // Catch: Throwable -> L31 IOException -> L33
        out.startTag(null, "uid");     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "n", uid2);     // Catch: Throwable -> L31 IOException -> L33
        int modesSize = modes.size();     // Catch: Throwable -> L31 IOException -> L33
        int modeIdx = 0;
    L29:
        if (modeIdx >= modesSize) goto L35;
        int op = modes.keyAt(modeIdx);     // Catch: Throwable -> L31 IOException -> L33
        int mode = modes.valueAt(modeIdx);     // Catch: Throwable -> L31 IOException -> L33
        out.startTag(null, "op");     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "n", op);     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "m", mode);     // Catch: Throwable -> L31 IOException -> L33
        out.endTag(null, "op");     // Catch: Throwable -> L31 IOException -> L33
        modeIdx = modeIdx + 1;     // Catch: Throwable -> L31 IOException -> L33
        uidModesSize = uidModesSize;
        goto L29
    L35:
        out.endTag(null, "uid");     // Catch: Throwable -> L31 IOException -> L33
        uidStateNum = uidStateNum + 1;     // Catch: Throwable -> L31 IOException -> L33
        uidModesSize = uidModesSize;
        goto L27
    L36:
        int userIdx3 = 0;
    L37:
        if (userIdx3 >= usersSize) goto L45;
        int userId = userPackageModesCopy.keyAt(userIdx3);     // Catch: Throwable -> L31 IOException -> L33
        ArrayMap<String, SparseIntArray> packageModes2 = userPackageModesCopy.valueAt(userIdx3);     // Catch: Throwable -> L31 IOException -> L33
        out.startTag(null, "user");     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "n", userId);     // Catch: Throwable -> L31 IOException -> L33
        int packageModesSize2 = packageModes2.size();     // Catch: Throwable -> L31 IOException -> L33
        int pkgIdx2 = 0;
    L39:
        if (pkgIdx2 >= packageModesSize2) goto L44;
        String pkg2 = packageModes2.keyAt(pkgIdx2);     // Catch: Throwable -> L31 IOException -> L33
        SparseIntArray modes2 = packageModes2.valueAt(pkgIdx2);     // Catch: Throwable -> L31 IOException -> L33
        out.startTag(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L31 IOException -> L33
        out.attribute(null, "n", pkg2);     // Catch: Throwable -> L31 IOException -> L33
        int modesSize2 = modes2.size();     // Catch: Throwable -> L31 IOException -> L33
        int modeIdx2 = 0;
    L41:
        if (modeIdx2 >= modesSize2) goto L43;
        int op2 = modes2.keyAt(modeIdx2);     // Catch: Throwable -> L31 IOException -> L33
        int mode2 = modes2.valueAt(modeIdx2);     // Catch: Throwable -> L31 IOException -> L33
        out.startTag(null, "op");     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "n", op2);     // Catch: Throwable -> L31 IOException -> L33
        out.attributeInt(null, "m", mode2);     // Catch: Throwable -> L31 IOException -> L33
        out.endTag(null, "op");     // Catch: Throwable -> L31 IOException -> L33
        modeIdx2 = modeIdx2 + 1;     // Catch: Throwable -> L31 IOException -> L33
        userIdx3 = userIdx3;
        userId = userId;
        uidModesCopy = uidModesCopy;
        goto L41
    L43:
        out.endTag(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L31 IOException -> L33
        pkgIdx2 = pkgIdx2 + 1;     // Catch: Throwable -> L31 IOException -> L33
        userIdx3 = userIdx3;
        userId = userId;
        uidModesCopy = uidModesCopy;
        goto L39
    L44:
        out.endTag(null, "user");     // Catch: Throwable -> L31 IOException -> L33
        userIdx3 = userIdx3 + 1;     // Catch: Throwable -> L31 IOException -> L33
        uidModesCopy = uidModesCopy;
        goto L37
    L45:
        out.endTag(null, "app-ops");     // Catch: Throwable -> L31 IOException -> L33
        out.endDocument();     // Catch: Throwable -> L31 IOException -> L33
        this.mFile.finishWrite(stream);     // Catch: Throwable -> L31 IOException -> L33
    L55:
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L47:
        th = th;
    L33:
        e = move-exception;
        Slog.w(TAG, "Failed to write state, restoring backup.", e);     // Catch: Throwable -> L31
        this.mFile.failWrite(stream);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L57:
        e = move-exception;
        Slog.w(TAG, "Failed to write state: " + e);     // Catch: Throwable -> L31
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void readState() {
        AtomicFile r0 = this.mFile;
        monitor-enter(r0);
        Object r1 = this.mLock;     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        this.mVersionAtBoot = this.mAppOpsStateParser.readState(this.mFile, this.mUidModes, this.mUserPackageModes);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void shutdown() {
        boolean doWrite = false;
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteScheduled == false) goto L9;
        this.mWriteScheduled = false;     // Catch: Throwable -> L7
        this.mFastWriteScheduled = false;     // Catch: Throwable -> L7
        this.mHandler.removeCallbacks(this.mWriteRunner);     // Catch: Throwable -> L7
        doWrite = true;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (doWrite == false) goto L17;
        writeState();
        return;
    }

    private void upgradeLocked(int oldVersion) {
        if (oldVersion != (-2)) goto L5;
        return;
    L5:
        if (oldVersion >= 4) goto L16;
        Slog.d(TAG, "Upgrading app-ops xml from version " + oldVersion + " to 4");
        switch(oldVersion) {
            case -1: goto L10;
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L12;
            default: goto L13;
        };
    L10:
        upgradeRunAnyInBackgroundLocked();
    L11:
        upgradeScheduleExactAlarmLocked();
    L12:
        resetUseFullScreenIntentLocked();
    L13:
        scheduleFastWriteLocked();
        return;
    }

    void upgradeRunAnyInBackgroundLocked() {
        int uidModesSize = this.mUidModes.size();
        int uidIdx = 0;
    L4:
        if (uidIdx >= uidModesSize) goto L9;
        SparseIntArray modesForUid = this.mUidModes.valueAt(uidIdx);
        int idx = modesForUid.indexOfKey(63);
        if (idx < 0) goto L8;
        modesForUid.put(70, modesForUid.valueAt(idx));
    L8:
        uidIdx = uidIdx + 1;
        goto L4
    L9:
        int usersSize = this.mUserPackageModes.size();
        int userIdx = 0;
    L10:
        if (userIdx >= usersSize) goto L19;
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.valueAt(userIdx);
        int pkgIdx = 0;
        int packageModesSize = packageModes.size();
    L12:
        if (pkgIdx >= packageModesSize) goto L17;
        SparseIntArray modes = packageModes.valueAt(pkgIdx);
        int idx2 = modes.indexOfKey(63);
        if (idx2 < 0) goto L16;
        modes.put(70, modes.valueAt(idx2));
    L16:
        pkgIdx = pkgIdx + 1;
        goto L12
    L17:
        userIdx = userIdx + 1;
        goto L10
    }

    void upgradeScheduleExactAlarmLocked() {
        PermissionManagerServiceInternal pmsi = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int r4 = 107;
        String[] packagesDeclaringPermission = pmsi.getAppOpPermissionPackages(AppOpsManager.opToPermission(107));
        int[] userIds = umi.getUserIds();
        int r7 = packagesDeclaringPermission.length;
        int r9 = 0;
    L3:
        if (r9 >= r7) goto L12;
        String pkg = packagesDeclaringPermission[r9];
        int r11 = userIds.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        int userId = userIds[r12];
        int uid = pmi.getPackageUid(pkg, 0, userId);
        int oldMode = getUidMode(uid, "default:0", r4);
        int r17 = r4;
        if (oldMode != AppOpsManager.opToDefaultMode(r17)) goto L9;
        r4 = r17;
        setUidMode(uid, "default:0", r4, 0);
    L10:
        r12 = r12 + 1;
        pmsi = pmsi;
        goto L5
    L9:
        r4 = r17;
        goto L10
    L11:
        r9 = r9 + 1;
        pmsi = pmsi;
        goto L3
    }

    void resetUseFullScreenIntentLocked() {
        PermissionManagerServiceInternal pmsi = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        PermissionManager permissionManager = (PermissionManager) this.mContext.getSystemService(PermissionManager.class);
        int r5 = 133;
        String permissionName = AppOpsManager.opToPermission(133);
        String[] packagesDeclaringPermission = pmsi.getAppOpPermissionPackages(permissionName);
        int[] userIds = umi.getUserIds();
        int r9 = packagesDeclaringPermission.length;
        int r11 = 0;
    L3:
        if (r11 >= r9) goto L12;
        String pkg = packagesDeclaringPermission[r11];
        int r13 = userIds.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L11;
        int userId = userIds[r14];
        int r16 = r11;
        int uid = pmi.getPackageUid(pkg, 0, userId);
        int flags = permissionManager.getPermissionFlags(pkg, permissionName, UserHandle.of(userId));
        if ((flags & 1) != 0) goto L9;
        int r17 = r5;
        int r2 = r17;
        setUidMode(uid, "default:0", r2, AppOpsManager.opToDefaultMode(r17));
    L10:
        r14 = r14 + 1;
        r5 = r2;
        r11 = r16;
        pmsi = pmsi;
        umi = umi;
        goto L5
    L9:
        r2 = r5;
        goto L10
    L11:
        r11 = r11 + 1;
        umi = umi;
        goto L3
    }

    List<Integer> getUidsWithNonDefaultModes() {
        List<Integer> result = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUidModes.size()) goto L14;
        SparseIntArray modes = this.mUidModes.valueAt(i);     // Catch: Throwable -> L10
        if (modes.size() <= 0) goto L12;
        result.add(Integer.valueOf(this.mUidModes.keyAt(i)));     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return result;
    }

    List<UserPackage> getPackagesWithNonDefaultModes() {
        List<UserPackage> result = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L22:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUserPackageModes.size()) goto L18;
        ArrayMap<String, SparseIntArray> packageModes = this.mUserPackageModes.valueAt(i);     // Catch: Throwable -> L13
        int j = 0;
    L9:
        if (j >= packageModes.size()) goto L16;
        SparseIntArray modes = packageModes.valueAt(j);     // Catch: Throwable -> L13
        if (modes.size() <= 0) goto L15;
        result.add(UserPackage.of(this.mUserPackageModes.keyAt(i), packageModes.keyAt(j)));     // Catch: Throwable -> L13
    L15:
        j = j + 1;     // Catch: Throwable -> L13
        goto L9
    L16:
        i = i + 1;     // Catch: Throwable -> L13
        goto L22
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return result;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean addAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mModeChangedListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removeAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mModeChangedListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
