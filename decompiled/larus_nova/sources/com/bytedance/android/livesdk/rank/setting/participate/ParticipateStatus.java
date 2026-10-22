package com.bytedance.android.livesdk.rank.setting.participate;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/rank/setting/participate/ParticipateStatus;", "", "", "value", "I", "getValue", "()I", "Normal", "Exited", "Rejoin", "Banned", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ParticipateStatus extends Enum<ParticipateStatus> {
    public static final ParticipateStatus Banned = null;
    public static final ParticipateStatus Exited = null;
    public static final ParticipateStatus Normal = null;
    public static final ParticipateStatus Rejoin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ParticipateStatus[] f157012a = null;
    private final int value;

    static {
        ParticipateStatus r100 = new ParticipateStatus("Normal", 0, 0);
        Normal = r100;
        ParticipateStatus r101 = new ParticipateStatus("Exited", 1, 1);
        Exited = r101;
        ParticipateStatus r102 = new ParticipateStatus("Rejoin", 2, 2);
        Rejoin = r102;
        ParticipateStatus r103 = new ParticipateStatus("Banned", 3, 3);
        Banned = r103;
        f157012a = new ParticipateStatus[]{r100, r101, r102, r103};
    }

    public static ParticipateStatus valueOf(String r100) {
        return (ParticipateStatus) r27.a.a(ParticipateStatus.class, r100);
    }

    public static ParticipateStatus[] values() {
        return (ParticipateStatus[]) f157012a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ParticipateStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
