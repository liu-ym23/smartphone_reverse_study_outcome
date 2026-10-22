package com.android.server.am;

import android.app.ActivityManager;
import android.os.UserHandle;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class ActiveUids {
    private final SparseArray<UidRecord> mActiveUids;
    private final boolean mPostChangesToAtm;
    private final ActivityManagerGlobalLock mProcLock;
    private final ActivityManagerService mService;

    public static /* synthetic */ void $r8$lambda$NgdZNvkwS6lqiR_KpbqmBNFCCTU(PrintWriter r0, ProcessRecord r1) {
        lambda$dump$0(r0, r1);
    }

    ActiveUids(ActivityManagerService service, boolean postChangesToAtm) {
        this.mActiveUids = new SparseArray();
        this.mService = service;
        if (service == null) goto L5;
        ActivityManagerGlobalLock r0 = service.mProcLock;
    L6:
        this.mProcLock = r0;
        this.mPostChangesToAtm = postChangesToAtm;
        return;
    L5:
        r0 = null;
        goto L6
    }

    void put(int uid, UidRecord value) {
        this.mActiveUids.put(uid, value);
        if (this.mPostChangesToAtm == false) goto L6;
        this.mService.mAtmInternal.onUidActive(uid, value.getCurProcState());
        return;
    }

    void remove(int uid) {
        this.mActiveUids.remove(uid);
        if (this.mPostChangesToAtm == false) goto L6;
        this.mService.mAtmInternal.onUidInactive(uid);
        return;
    }

    void clear() {
        this.mActiveUids.clear();
    }

    UidRecord get(int uid) {
        return this.mActiveUids.get(uid);
    }

    int size() {
        return this.mActiveUids.size();
    }

    UidRecord valueAt(int index) {
        return this.mActiveUids.valueAt(index);
    }

    int keyAt(int index) {
        return this.mActiveUids.keyAt(index);
    }

    int indexOfKey(int uid) {
        return this.mActiveUids.indexOfKey(uid);
    }

    boolean dump(final PrintWriter pw, String dumpPackage, int dumpAppId, String header, boolean needSep) {
        boolean printed = false;
        int i = 0;
    L4:
        if (i >= this.mActiveUids.size()) goto L18;
        UidRecord uidRec = this.mActiveUids.valueAt(i);
        if (dumpPackage != null) goto L8;
    L10:
        if (printed == true) goto L15;
        printed = true;
        if (needSep == false) goto L14;
        pw.println();
    L14:
        pw.print("  ");
        pw.println(header);
    L15:
        pw.print("    UID ");
        UserHandle.formatUid(pw, uidRec.getUid());
        pw.print(": ");
        pw.println(uidRec);
        pw.print("      curProcState=");
        pw.print(uidRec.getCurProcState());
        pw.print(" curCapability=");
        ActivityManager.printCapabilitiesFull(pw, uidRec.getCurCapability());
        pw.println();
        uidRec.forEachProcess(new ActiveUids$$ExternalSyntheticLambda0(pw));
    L16:
        i = i + 1;
        goto L4
    L8:
        if (UserHandle.getAppId(uidRec.getUid()) == dumpAppId) goto L10;
    L18:
        return printed;
    }

    private static /* synthetic */ void lambda$dump$0(PrintWriter pw, ProcessRecord app) {
        pw.print("      proc=");
        pw.println(app);
    }

    void dumpProto(ProtoOutputStream proto, String dumpPackage, int dumpAppId, long fieldId) {
        int i = 0;
    L4:
        if (i >= this.mActiveUids.size()) goto L13;
        UidRecord uidRec = this.mActiveUids.valueAt(i);
        if (dumpPackage != null) goto L8;
    L10:
        uidRec.dumpDebug(proto, fieldId);
    L11:
        i = i + 1;
        goto L4
    L8:
        if (UserHandle.getAppId(uidRec.getUid()) == dumpAppId) goto L10;
    }
}
