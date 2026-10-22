package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RealTimeChorusStage;", "", "", "value", "I", "getValue", "()I", "RealTimeChorusStage_Normal", "RealTimeChorusStage_Carnival", "RealTimeChorusStage_Peak", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RealTimeChorusStage extends Enum<RealTimeChorusStage> {
    public static final RealTimeChorusStage RealTimeChorusStage_Carnival = null;
    public static final RealTimeChorusStage RealTimeChorusStage_Normal = null;
    public static final RealTimeChorusStage RealTimeChorusStage_Peak = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealTimeChorusStage[] f153611a = null;
    private final int value;

    static {
        RealTimeChorusStage r100 = new RealTimeChorusStage("RealTimeChorusStage_Normal", 0, 0);
        RealTimeChorusStage_Normal = r100;
        RealTimeChorusStage r101 = new RealTimeChorusStage("RealTimeChorusStage_Carnival", 1, 1);
        RealTimeChorusStage_Carnival = r101;
        RealTimeChorusStage r102 = new RealTimeChorusStage("RealTimeChorusStage_Peak", 2, 2);
        RealTimeChorusStage_Peak = r102;
        f153611a = new RealTimeChorusStage[]{r100, r101, r102};
    }

    public static RealTimeChorusStage valueOf(String r100) {
        return (RealTimeChorusStage) r27.a.a(RealTimeChorusStage.class, r100);
    }

    public static RealTimeChorusStage[] values() {
        return (RealTimeChorusStage[]) f153611a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RealTimeChorusStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
