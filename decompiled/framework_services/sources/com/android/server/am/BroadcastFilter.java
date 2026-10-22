package com.android.server.am;

import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.UserHandle;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.util.proto.ProtoOutputStream;
import com.android.server.compat.PlatformCompat;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class BroadcastFilter extends IntentFilter {
    static final long RESTRICT_PRIORITY_VALUES = 371309185;
    public final boolean exported;
    final String featureId;
    final int initialPriority;
    final boolean instantApp;
    final int owningUid;
    final int owningUserId;
    final String packageName;
    final String receiverId;
    final ReceiverList receiverList;
    final String requiredPermission;
    final boolean visibleToInstantApp;

    BroadcastFilter(IntentFilter _filter, ReceiverList _receiverList, String _packageName, String _featureId, String _receiverId, String _requiredPermission, int _owningUid, int _userId, boolean _instantApp, boolean _visibleToInstantApp, boolean _exported, ApplicationInfo _applicationInfo, PlatformCompat platformCompat) {
        super(_filter);
        this.receiverList = _receiverList;
        this.packageName = _packageName;
        this.featureId = _featureId;
        this.receiverId = _receiverId;
        this.requiredPermission = _requiredPermission;
        this.owningUid = _owningUid;
        this.owningUserId = _userId;
        this.instantApp = _instantApp;
        this.visibleToInstantApp = _visibleToInstantApp;
        this.exported = _exported;
        this.initialPriority = getPriority();
        setPriority(calculateAdjustedPriority(this.owningUid, this.initialPriority, _applicationInfo, platformCompat));
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
    }

    public String getReceiverClassName() {
        if (this.receiverId == null) goto L8;
        int index = this.receiverId.lastIndexOf(64);
        if (index > 0) goto L7;
        return null;
    L7:
        return this.receiverId.substring(0, index);
    L8:
        return null;
    }

    public ApplicationInfo getApplicationInfo() {
        return this.receiverList.app.info;
    }

    @NeverCompile
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L);
        if (this.requiredPermission == null) goto L5;
        proto.write(1138166333442L, this.requiredPermission);
    L5:
        proto.write(1138166333443L, Integer.toHexString(System.identityHashCode(this)));
        proto.write(1120986464260L, this.owningUserId);
        proto.end(token);
    }

    @NeverCompile
    public void dump(PrintWriter pw, String prefix) {
        dumpInReceiverList(pw, new PrintWriterPrinter(pw), prefix);
        this.receiverList.dumpLocal(pw, prefix);
    }

    @NeverCompile
    public void dumpBrief(PrintWriter pw, String prefix) {
        dumpBroadcastFilterState(pw, prefix);
    }

    @NeverCompile
    public void dumpInReceiverList(PrintWriter pw, Printer pr, String prefix) {
        super.dump(pr, prefix);
        dumpBroadcastFilterState(pw, prefix);
    }

    @NeverCompile
    void dumpBroadcastFilterState(PrintWriter pw, String prefix) {
        if (this.requiredPermission == null) goto L6;
        pw.print(prefix);
        pw.print("requiredPermission=");
        pw.println(this.requiredPermission);
    L6:
        if (this.initialPriority == getPriority()) goto L9;
        pw.print(prefix);
        pw.print("initialPriority=");
        pw.println(this.initialPriority);
        return;
    }

    static int calculateAdjustedPriority(int owningUid, int priority, ApplicationInfo applicationInfo, PlatformCompat platformCompat) {
        long token = Binder.clearCallingIdentity();
        if (platformCompat.isChangeEnabledInternalNoLogging(RESTRICT_PRIORITY_VALUES, applicationInfo) == true) goto L7;
        Binder.restoreCallingIdentity(token);
        return priority;
    L7:
        Binder.restoreCallingIdentity(token);
        if (UserHandle.isCore(owningUid) == false) goto L10;
    L17:
        return priority;
    L10:
        if (priority < 1000) goto L14;
        return 999;
    L14:
        if (priority > (-1000)) goto L17;
        return -999;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public String toString() {
        return "BroadcastFilter{" + Integer.toHexString(System.identityHashCode(this)) + ' ' + this.owningUid + "/u" + this.owningUserId + ' ' + this.receiverList + '}';
    }
}
