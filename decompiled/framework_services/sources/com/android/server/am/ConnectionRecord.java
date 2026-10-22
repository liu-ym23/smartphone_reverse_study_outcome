package com.android.server.am;

import android.app.IServiceConnection;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.SystemClock;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import com.android.internal.app.procstats.AssociationState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.server.wm.ActivityServiceConnectionsHolder;
import java.io.PrintWriter;
import org.tukaani.xz.common.Util;

/* JADX INFO: loaded from: classes.dex */
final class ConnectionRecord implements OomAdjusterModernImpl.Connection {
    private static final int[] BIND_ORIG_ENUMS = null;
    private static final int[] BIND_PROTO_ENUMS = null;
    final ActivityServiceConnectionsHolder<ConnectionRecord> activity;
    final ComponentName aliasComponent;
    public AssociationState.SourceState association;
    final AppBindRecord binding;
    final PendingIntent clientIntent;
    final int clientLabel;
    final String clientPackageName;
    final String clientProcessName;
    final int clientUid;
    final IServiceConnection conn;
    private final long flags;
    private final ConnectionRecordSmtEx mConnectionRecordSmtEx;
    private Object mProcStatsLock;
    boolean serviceDead;
    String stringName;

    static {
        BIND_ORIG_ENUMS = new int[]{1, 2, 4, 8388608, 8, 16, 32, 64, 128, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 256, 4096, 512};
        BIND_PROTO_ENUMS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18};
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "binding=" + this.binding);
        if (this.activity == null) goto L5;
        this.activity.dump(pw, prefix);
    L5:
        pw.println(prefix + "conn=" + this.conn.asBinder() + " flags=0x" + Long.toHexString(this.flags));
    }

    ConnectionRecord(AppBindRecord _binding, ActivityServiceConnectionsHolder<ConnectionRecord> _activity, IServiceConnection _conn, long _flags, int _clientLabel, PendingIntent _clientIntent, int _clientUid, String _clientProcessName, String _clientPackageName, ComponentName _aliasComponent) {
        this.mConnectionRecordSmtEx = new ConnectionRecordSmtEx();
        this.binding = _binding;
        this.activity = _activity;
        this.conn = _conn;
        this.flags = _flags;
        this.clientLabel = _clientLabel;
        this.clientIntent = _clientIntent;
        this.clientUid = _clientUid;
        this.clientProcessName = _clientProcessName;
        this.clientPackageName = _clientPackageName;
        this.aliasComponent = _aliasComponent;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
    }

    @Override // com.android.server.am.OomAdjusterModernImpl.Connection
    public void computeHostOomAdjLSP(OomAdjuster oomAdjuster, ProcessRecord host, ProcessRecord client, long now, ProcessRecord topApp, boolean doingAll, int oomAdjReason, int cachedAdj) {
        oomAdjuster.computeServiceHostOomAdjLSP(this, host, client, now, topApp, doingAll, false, false, oomAdjReason, 1001, false, false);
    }

    @Override // com.android.server.am.OomAdjusterModernImpl.Connection
    public boolean canAffectCapabilities() {
        return hasFlag(4294971392L);
    }

    @Override // com.android.server.am.OomAdjusterModernImpl.Connection
    public boolean transmitsCpuTime() {
        return !hasFlag(Util.BACKWARD_SIZE_MAX);
    }

    public long getFlags() {
        return this.flags;
    }

    public boolean hasFlag(int flag) {
        if ((this.flags & Integer.toUnsignedLong(flag)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlag(long flag) {
        if ((this.flags & flag) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean notHasFlag(int flag) {
        return !hasFlag(flag);
    }

    public boolean notHasFlag(long flag) {
        return !hasFlag(flag);
    }

    public void startAssociationIfNeeded() {
        if (this.association == null) goto L5;
        return;
    L5:
        if (this.binding.service.app != null) goto L7;
        return;
    L7:
        if (this.binding.service.appInfo.uid == this.clientUid) goto L9;
    L10:
        ProcessStats.ProcessStateHolder holder = this.binding.service.app.getPkgList().get(this.binding.service.instanceName.getPackageName());
        if (holder != null) goto L14;
        Slog.wtf("ActivityManager", "No package in referenced service " + this.binding.service.shortInstanceName + ": proc=" + this.binding.service.app);
        return;
    L14:
        if (holder.pkg != null) goto L16;
        Slog.wtf("ActivityManager", "Inactive holder in referenced service " + this.binding.service.shortInstanceName + ": proc=" + this.binding.service.app);
        return;
    L16:
        this.mProcStatsLock = this.binding.service.app.mService.mProcessStats.mLock;
        Object r1 = this.mProcStatsLock;
        monitor-enter(r1);
        this.association = holder.pkg.getAssociationStateLocked(holder.state, this.binding.service.instanceName.getClassName()).startSource(this.clientUid, this.clientProcessName, this.clientPackageName);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.binding.service.processName.equals(this.clientProcessName) == false) goto L10;
    }

    public void trackProcState(int procState, int seq) {
        if (this.association == null) goto L12;
        Object r0 = this.mProcStatsLock;
        monitor-enter(r0);
        this.association.trackProcState(procState, seq, SystemClock.uptimeMillis());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void stopAssociation() {
        if (this.association == null) goto L12;
        Object r0 = this.mProcStatsLock;
        monitor-enter(r0);
        this.association.stop();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.association = null;
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("ConnectionRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" u");
        sb.append(this.binding.client.userId);
        sb.append(' ');
        if (hasFlag(1) == false) goto L10;
        sb.append("CR ");
    L10:
        if (hasFlag(2) == false) goto L13;
        sb.append("DBG ");
    L13:
        if (hasFlag(4) == false) goto L16;
        sb.append("!FG ");
    L16:
        if (hasFlag(8388608) == false) goto L19;
        sb.append("IMPB ");
    L19:
        if (hasFlag(8) == false) goto L22;
        sb.append("ABCLT ");
    L22:
        if (hasFlag(16) == false) goto L25;
        sb.append("OOM ");
    L25:
        if (hasFlag(32) == false) goto L28;
        sb.append("WPRI ");
    L28:
        if (hasFlag(64) == false) goto L31;
        sb.append("IMP ");
    L31:
        if (hasFlag(128) == false) goto L34;
        sb.append("WACT ");
    L34:
        if (hasFlag(33554432) == false) goto L37;
        sb.append("FGSA ");
    L37:
        if (hasFlag(67108864) == false) goto L40;
        sb.append("FGS ");
    L40:
        if (hasFlag(134217728) == false) goto L43;
        sb.append("LACT ");
    L43:
        if (hasFlag(524288) == false) goto L46;
        sb.append("SLTA ");
    L46:
        if (hasFlag(268435456) == false) goto L49;
        sb.append("VFGS ");
    L49:
        if (hasFlag(536870912) == false) goto L52;
        sb.append("UI ");
    L52:
        if (hasFlag(1073741824) == false) goto L55;
        sb.append("!VIS ");
    L55:
        if (hasFlag(256) == false) goto L58;
        sb.append("!PRCP ");
    L58:
        if (hasFlag(512) == false) goto L61;
        sb.append("BALF ");
    L61:
        if (hasFlag(4096) == false) goto L64;
        sb.append("CAPS ");
    L64:
        if (hasFlag(Util.BACKWARD_SIZE_MAX) == false) goto L67;
        sb.append("!CPU ");
    L67:
        if (this.serviceDead == false) goto L69;
        sb.append("DEAD ");
    L69:
        sb.append(this.binding.service.shortInstanceName);
        sb.append(":@");
        sb.append(Integer.toHexString(System.identityHashCode(this.conn.asBinder())));
        sb.append(" flags=0x" + Long.toHexString(this.flags));
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L5:
        return this.stringName;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        if (this.binding != null) goto L5;
        return;
    L5:
        long token = proto.start(fieldId);
        proto.write(1138166333441L, Integer.toHexString(System.identityHashCode(this)));
        if (this.binding.client == null) goto L8;
        proto.write(1120986464258L, this.binding.client.userId);
    L8:
        ProtoUtils.writeBitWiseFlagsToProtoEnum(proto, 2259152797699L, this.flags, BIND_ORIG_ENUMS, BIND_PROTO_ENUMS);
        if (this.serviceDead == false) goto L12;
        proto.write(2259152797699L, 15);
    L12:
        if (this.binding.service == null) goto L14;
        proto.write(1138166333444L, this.binding.service.shortInstanceName);
    L14:
        proto.end(token);
    }

    public ConnectionRecordSmtEx getSmtEx() {
        return this.mConnectionRecordSmtEx;
    }
}
