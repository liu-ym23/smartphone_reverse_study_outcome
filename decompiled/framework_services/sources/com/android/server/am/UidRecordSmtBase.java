package com.android.server.am;

import android.util.ArraySet;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class UidRecordSmtBase {
    static final int CHANGE_FROZEN = 131072;
    static final int CHANGE_SCHEDGROUP = 65536;
    static final int FLAG_CONNECTED_SYSTEMSERVER = 1;
    static final int FLAG_CONNECTED_TOP = 2;
    int SmtFlags;
    int curFrozenStat;
    int curSchedGroup;
    IApplicationFreezer.Mode freezingMode;
    long freezingStartTime;
    int freezingStat;
    long lastKeepAliveTime;
    String not3rdReason;
    long perceptibleTime;
    ArraySet<ProcessRecord> procRecords;
    int setFrozenStat;
    int setSchedGroup;
    SparseArray<UidRecord> systemSmtUidRecoreds;
    int tntPriorityFraction;

    static final class ChangeItemSmtEx {
        int frozenStat;
        int schedGroup;

        ChangeItemSmtEx() {
        }
    }

    static final class ChangeRecordSmtEx {
        int frozenStat;
        int schedGroup;

        ChangeRecordSmtEx() {
        }
    }

    public UidRecordSmtBase() {
        this.freezingMode = IApplicationFreezer.Mode.INVALID;
        this.curSchedGroup = Integer.MIN_VALUE;
        this.setSchedGroup = Integer.MIN_VALUE;
        this.setFrozenStat = Integer.MAX_VALUE;
        this.freezingStat = 0;
        this.freezingStartTime = 0;
        this.tntPriorityFraction = 0;
        this.lastKeepAliveTime = 0;
        this.procRecords = new ArraySet();
        this.systemSmtUidRecoreds = new SparseArray();
    }

    boolean isFreezing() {
        if (this.freezingStat == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isFrozen() {
        if (this.freezingStat != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean inFreezeStat() {
        if (this.freezingStat == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void reset() {
        this.curSchedGroup = Integer.MIN_VALUE;
        this.not3rdReason = "";
        this.SmtFlags = 0;
        this.curFrozenStat = Integer.MAX_VALUE;
    }

    public UidRecord getSystemSmtUidRecord(int smtUid, ActivityManagerService service) {
        if (this.systemSmtUidRecoreds == null) goto L10;
        if (smtUid > 0) goto L13;
        UidRecord recored = this.systemSmtUidRecoreds.get(smtUid);
        if (recored != null) goto L12;
        UidRecord recored2 = new UidRecord(smtUid, service);
        this.systemSmtUidRecoreds.put(smtUid, recored2);
        return recored2;
    L12:
        return recored;
    L13:
        return null;
    L10:
        return null;
    }
}
