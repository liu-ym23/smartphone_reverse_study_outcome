package com.bytedance.android.gamecp.host_api.model.introducecard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/IntroduceRequestType;", "", "", "type", "J", "getType", "()J", "MANUAL", "TIMER", "AUTO", "RULE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceRequestType extends Enum<IntroduceRequestType> {
    public static final IntroduceRequestType AUTO = null;
    public static final IntroduceRequestType MANUAL = null;
    public static final IntroduceRequestType RULE = null;
    public static final IntroduceRequestType TIMER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroduceRequestType[] f57378a = null;
    private final long type;

    static {
        IntroduceRequestType r100 = new IntroduceRequestType("MANUAL", 0, 0);
        MANUAL = r100;
        IntroduceRequestType r101 = new IntroduceRequestType("TIMER", 1, 1);
        TIMER = r101;
        IntroduceRequestType r102 = new IntroduceRequestType("AUTO", 2, 2);
        AUTO = r102;
        IntroduceRequestType r103 = new IntroduceRequestType("RULE", 3, 3);
        RULE = r103;
        f57378a = new IntroduceRequestType[]{r100, r101, r102, r103};
    }

    public static IntroduceRequestType valueOf(String r100) {
        return (IntroduceRequestType) r27.a.a(IntroduceRequestType.class, r100);
    }

    public static IntroduceRequestType[] values() {
        return (IntroduceRequestType[]) f57378a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public IntroduceRequestType(String r100, int r101, long r102) {
        super(r100, r101);
        this.type = r102;
    }
}
