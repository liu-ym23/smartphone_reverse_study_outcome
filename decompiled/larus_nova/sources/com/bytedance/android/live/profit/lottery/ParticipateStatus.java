package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ParticipateStatus;", "", "", "status", "I", "getStatus", "()I", "UNKNOWN", "NOTPARTICIPATED", "PARTICIPATEINSUCCESS", "ISLUCKY", "PARTICIPATED", "CHOOSEING", "CHOOSEEND", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ParticipateStatus extends Enum<ParticipateStatus> {
    public static final ParticipateStatus CHOOSEEND = null;
    public static final ParticipateStatus CHOOSEING = null;
    public static final ParticipateStatus ISLUCKY = null;
    public static final ParticipateStatus NOTPARTICIPATED = null;
    public static final ParticipateStatus PARTICIPATED = null;
    public static final ParticipateStatus PARTICIPATEINSUCCESS = null;
    public static final ParticipateStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ParticipateStatus[] f88036a = null;
    private final int status;

    static {
        ParticipateStatus r100 = new ParticipateStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ParticipateStatus r101 = new ParticipateStatus("NOTPARTICIPATED", 1, 1);
        NOTPARTICIPATED = r101;
        ParticipateStatus r102 = new ParticipateStatus("PARTICIPATEINSUCCESS", 2, 2);
        PARTICIPATEINSUCCESS = r102;
        ParticipateStatus r103 = new ParticipateStatus("ISLUCKY", 3, 3);
        ISLUCKY = r103;
        ParticipateStatus r104 = new ParticipateStatus("PARTICIPATED", 4, 4);
        PARTICIPATED = r104;
        ParticipateStatus r105 = new ParticipateStatus("CHOOSEING", 5, 5);
        CHOOSEING = r105;
        ParticipateStatus r106 = new ParticipateStatus("CHOOSEEND", 6, 6);
        CHOOSEEND = r106;
        f88036a = new ParticipateStatus[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ParticipateStatus valueOf(String r100) {
        return (ParticipateStatus) r27.a.a(ParticipateStatus.class, r100);
    }

    public static ParticipateStatus[] values() {
        return (ParticipateStatus[]) f88036a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public ParticipateStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
