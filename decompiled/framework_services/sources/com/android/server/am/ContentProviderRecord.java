package com.android.server.am;

import android.app.ContentProviderHolder;
import android.app.IApplicationThread;
import android.content.ComponentName;
import android.content.IContentProvider;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.StabTrace;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.app.procstats.AssociationState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class ContentProviderRecord implements ComponentName.WithComponentName {
    static final int MAX_RETRY_COUNT = 3;
    final ApplicationInfo appInfo;
    final ArrayList<ContentProviderConnection> connections;
    int externalProcessNoHandleCount;
    ArrayMap<IBinder, ExternalProcessHandle> externalProcessTokenToHandle;
    public final ProviderInfo info;
    ProcessRecord launchingApp;
    int mRestartCount;
    final ComponentName name;
    public boolean noReleaseNeeded;
    ProcessRecord proc;
    public IContentProvider provider;
    final ActivityManagerService service;
    String shortStringName;
    final boolean singleton;
    String stringName;
    final int uid;

    private class ExternalProcessHandle implements IBinder.DeathRecipient {
        private static final String LOG_TAG = "ExternalProcessHanldle";
        int mAcquisitionCount;
        AssociationState.SourceState mAssociation;
        final String mOwningProcessName;
        final int mOwningUid;
        private Object mProcStatsLock;
        final IBinder mToken;
        final /* synthetic */ ContentProviderRecord this$0;

        public ExternalProcessHandle(ContentProviderRecord r3, IBinder token, int owningUid, String owningProcessName) {
            this.this$0 = r3;
            this.mToken = token;
            this.mOwningUid = owningUid;
            this.mOwningProcessName = owningProcessName;
            token.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            re = move-exception;
            Slog.e(LOG_TAG, "Couldn't register for death for token: " + this.mToken, re);
        }

        public void unlinkFromOwnDeathLocked() {
            this.mToken.unlinkToDeath(this, 0);
        }

        public void startAssociationIfNeeded(ContentProviderRecord provider) {
            if (this.mAssociation == null) goto L5;
            return;
        L5:
            if (provider.proc != null) goto L7;
            return;
        L7:
            if (provider.appInfo.uid == this.mOwningUid) goto L9;
        L10:
            ProcessStats.ProcessStateHolder holder = provider.proc.getPkgList().get(provider.name.getPackageName());
            if (holder != null) goto L14;
            Slog.wtf("ActivityManager", "No package in referenced provider " + provider.name.toShortString() + ": proc=" + provider.proc);
            return;
        L14:
            if (holder.pkg != null) goto L16;
            Slog.wtf("ActivityManager", "Inactive holder in referenced provider " + provider.name.toShortString() + ": proc=" + provider.proc);
            return;
        L16:
            this.mProcStatsLock = provider.proc.mService.mProcessStats.mLock;
            Object r1 = this.mProcStatsLock;
            monitor-enter(r1);
            this.mAssociation = holder.pkg.getAssociationStateLocked(holder.state, provider.name.getClassName()).startSource(this.mOwningUid, this.mOwningProcessName, null);     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;
        L9:
            if (provider.info.processName.equals(this.mOwningProcessName) == false) goto L10;
        }

        public void stopAssociation() {
            if (this.mAssociation == null) goto L12;
            Object r0 = this.mProcStatsLock;
            monitor-enter(r0);
            this.mAssociation.stop();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            this.mAssociation = null;
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ActivityManagerService r0 = this.this$0.service;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L9:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.hasExternalProcessHandles() == true) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            if (this.this$0.externalProcessTokenToHandle.get(this.mToken) == null) goto L11;
            ContentProviderRecord.m1503$$Nest$mremoveExternalProcessHandleInternalLocked(this.this$0, this.mToken);     // Catch: Throwable -> L9
            goto L11
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveExternalProcessHandleInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1503$$Nest$mremoveExternalProcessHandleInternalLocked(ContentProviderRecord r0, IBinder r1) {
        r0.removeExternalProcessHandleInternalLocked(r1);
    }

    public ContentProviderRecord(ActivityManagerService _service, ProviderInfo _info, ApplicationInfo ai, ComponentName _name, boolean _singleton) {
        this.connections = new ArrayList();
        this.service = _service;
        this.info = _info;
        this.uid = ai.uid;
        this.appInfo = ai;
        this.name = _name;
        this.singleton = _singleton;
        if (this.uid != 0) goto L5;
    L7:
        if (_name != null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        this.noReleaseNeeded = r0;
        return;
    L9:
        if ("com.android.settings".equals(_name.getPackageName()) == false) goto L12;
    L11:
        r0 = false;
        goto L13
    L5:
        if (this.uid != 1000) goto L11;
        goto L7
    }

    public ContentProviderRecord(ContentProviderRecord cpr) {
        this.connections = new ArrayList();
        this.service = cpr.service;
        this.info = cpr.info;
        this.uid = cpr.uid;
        this.appInfo = cpr.appInfo;
        this.name = cpr.name;
        this.singleton = cpr.singleton;
        this.noReleaseNeeded = cpr.noReleaseNeeded;
    }

    public ContentProviderHolder newHolder(ContentProviderConnection conn, boolean local) {
        ContentProviderHolder holder = new ContentProviderHolder(this.info);
        holder.provider = this.provider;
        holder.noReleaseNeeded = this.noReleaseNeeded;
        holder.connection = conn;
        holder.mLocal = local;
        return holder;
    }

    public void setProcess(ProcessRecord proc) {
        this.proc = proc;
        int iconn = this.connections.size() - 1;
    L3:
        if (iconn < 0) goto L10;
        ContentProviderConnection conn = this.connections.get(iconn);
        if (proc == null) goto L7;
        conn.startAssociationIfNeeded();
    L8:
        iconn = iconn - 1;
        goto L3
    L7:
        conn.stopAssociation();
        goto L8
    L10:
        if (this.externalProcessTokenToHandle == null) goto L18;
        int iext = this.externalProcessTokenToHandle.size() - 1;
    L12:
        if (iext < 0) goto L25;
        ExternalProcessHandle handle = this.externalProcessTokenToHandle.valueAt(iext);
        if (proc == null) goto L16;
        handle.startAssociationIfNeeded(this);
    L17:
        iext = iext - 1;
        goto L12
    L16:
        handle.stopAssociation();
        goto L17
    L25:
        return;
    }

    public boolean canRunHere(ProcessRecord app) {
        if (this.info.multiprocess == true) goto L7;
        if (this.info.processName.equals(app.processName) == true) goto L7;
    L9:
        return false;
    L7:
        if (this.uid != app.info.uid) goto L9;
        return true;
    }

    public void addExternalProcessHandleLocked(IBinder token, int callingUid, String callingTag) {
        if (token != null) goto L5;
        this.externalProcessNoHandleCount++;
        return;
    L5:
        if (this.externalProcessTokenToHandle != null) goto L7;
        this.externalProcessTokenToHandle = new ArrayMap();
    L7:
        ExternalProcessHandle handle = this.externalProcessTokenToHandle.get(token);
        if (handle != null) goto L10;
        handle = new ExternalProcessHandle(this, token, callingUid, callingTag);
        this.externalProcessTokenToHandle.put(token, handle);
        handle.startAssociationIfNeeded(this);
    L10:
        handle.mAcquisitionCount++;
    }

    public boolean removeExternalProcessHandleLocked(IBinder token) {
        if (hasExternalProcessHandles() == false) goto L15;
        boolean hasHandle = false;
        if (this.externalProcessTokenToHandle == null) goto L12;
        ExternalProcessHandle handle = this.externalProcessTokenToHandle.get(token);
        if (handle == null) goto L12;
        hasHandle = true;
        handle.mAcquisitionCount--;
        if (handle.mAcquisitionCount != 0) goto L12;
        removeExternalProcessHandleInternalLocked(token);
        return true;
    L12:
        if (hasHandle == true) goto L17;
        this.externalProcessNoHandleCount--;
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    private void removeExternalProcessHandleInternalLocked(IBinder token) {
        ExternalProcessHandle handle = this.externalProcessTokenToHandle.get(token);
        handle.unlinkFromOwnDeathLocked();
        handle.stopAssociation();
        this.externalProcessTokenToHandle.remove(token);
        if (this.externalProcessTokenToHandle.size() != 0) goto L6;
        this.externalProcessTokenToHandle = null;
        return;
    }

    public boolean hasExternalProcessHandles() {
        if (this.externalProcessTokenToHandle == null) goto L5;
    L8:
        return true;
    L5:
        if (this.externalProcessNoHandleCount > 0) goto L8;
        return false;
    }

    public boolean hasConnectionOrHandle() {
        if (this.connections.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (hasExternalProcessHandles() == true) goto L8;
        return false;
    }

    void onProviderPublishStatusLocked(boolean status) {
        if (StabTrace.isEnable() == false) goto L5;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L6:
        int numOfConns = this.connections.size();
        int i = 0;
    L7:
        if (i >= numOfConns) goto L31;
        ContentProviderConnection conn = this.connections.get(i);
        if (conn.waiting == false) goto L29;
        if (conn.client == null) goto L29;
        ProcessRecord client = conn.client;
        if (status == false) goto L15;
    L18:
        IApplicationThread thread = client.getThread();
        if (thread == null) goto L27;
        if (status == false) goto L22;
        ContentProviderConnection r0 = conn;
    L32:
        thread.notifyContentProviderPublishStatus(newHolder(r0, false), this.info.authority, conn.mExpectedUserId, status);     // Catch: RemoteException -> L25
        goto L27
    L22:
        r0 = null;
    L27:
        if (StabTrace.isEnable() == false) goto L29;
        StabTrace.traceInfo(32, "notifyProviderPublish:" + client.getPid() + ":" + status, beginTime2, Process.getCpuClocks());
        goto L29
    L15:
        if (this.launchingApp != null) goto L17;
        Slog.w("ActivityManager", "Unable to launch app " + this.appInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + this.appInfo.uid + " for provider " + this.info.authority + ": launching app became null");
        EventLogTags.writeAmProviderLostProcess(UserHandle.getUserId(this.appInfo.uid), this.appInfo.packageName, this.appInfo.uid, this.info.authority);
        goto L18
    L17:
        Slog.wtf("ActivityManager", "Timeout waiting for provider " + this.appInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + this.appInfo.uid + " for provider " + this.info.authority + " caller=" + client);
    L29:
        conn.waiting = false;
        i = i + 1;
        goto L7
    L31:
        return;
    L5:
        beginTime2 = 0;
        goto L6
    }

    void dump(PrintWriter pw, String prefix, boolean full) {
        if (full == false) goto L4;
        pw.print(prefix);
        pw.print("package=");
        pw.print(this.info.applicationInfo.packageName);
        pw.print(" process=");
        pw.println(this.info.processName);
    L4:
        pw.print(prefix);
        pw.print("proc=");
        pw.println(this.proc);
        if (this.launchingApp == null) goto L7;
        pw.print(prefix);
        pw.print("launchingApp=");
        pw.println(this.launchingApp);
    L7:
        if (full == false) goto L10;
        pw.print(prefix);
        pw.print("uid=");
        pw.print(this.uid);
        pw.print(" provider=");
        pw.println(this.provider);
    L10:
        if (this.singleton == false) goto L12;
        pw.print(prefix);
        pw.print("singleton=");
        pw.println(this.singleton);
    L12:
        pw.print(prefix);
        pw.print("authority=");
        pw.println(this.info.authority);
        if (full == true) goto L15;
    L21:
        if (full == false) goto L32;
        if (hasExternalProcessHandles() == false) goto L37;
        pw.print(prefix);
        pw.print("externals:");
        if (this.externalProcessTokenToHandle == null) goto L28;
        pw.print(" w/token=");
        pw.print(this.externalProcessTokenToHandle.size());
    L28:
        if (this.externalProcessNoHandleCount <= 0) goto L30;
        pw.print(" notoken=");
        pw.print(this.externalProcessNoHandleCount);
    L30:
        pw.println();
    L37:
        if (this.connections.size() <= 0) goto L47;
        if (full == false) goto L40;
        pw.print(prefix);
        pw.println("Connections:");
    L40:
        int i = 0;
    L42:
        if (i >= this.connections.size()) goto L51;
        ContentProviderConnection conn = this.connections.get(i);
        pw.print(prefix);
        pw.print("  -> ");
        pw.println(conn.toClientString());
        if (conn.provider == this) goto L46;
        pw.print(prefix);
        pw.print("    *** WRONG PROVIDER: ");
        pw.println(conn.provider);
    L46:
        i = i + 1;
        goto L42
    L51:
        return;
    L47:
        return;
    L32:
        if (this.connections.size() <= 0) goto L34;
    L35:
        pw.print(prefix);
        pw.print(this.connections.size());
        pw.print(" connections, ");
        pw.print(this.externalProcessNoHandleCount);
        pw.println(" external handles");
        goto L37
    L34:
        if (this.externalProcessNoHandleCount <= 0) goto L37;
    L15:
        if (this.info.isSyncable == false) goto L17;
    L20:
        pw.print(prefix);
        pw.print("isSyncable=");
        pw.print(this.info.isSyncable);
        pw.print(" multiprocess=");
        pw.print(this.info.multiprocess);
        pw.print(" initOrder=");
        pw.println(this.info.initOrder);
        goto L21
    L17:
        if (this.info.multiprocess == true) goto L20;
        if (this.info.initOrder == 0) goto L21;
        goto L20
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("ContentProviderRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" u");
        sb.append(UserHandle.getUserId(this.uid));
        sb.append(' ');
        sb.append(this.name.flattenToShortString());
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L5:
        return this.stringName;
    }

    public String toShortString() {
        if (this.shortStringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append('/');
        sb.append(this.name.flattenToShortString());
        String r1 = sb.toString();
        this.shortStringName = r1;
        return r1;
    L5:
        return this.shortStringName;
    }

    public ComponentName getComponentName() {
        return this.name;
    }
}
