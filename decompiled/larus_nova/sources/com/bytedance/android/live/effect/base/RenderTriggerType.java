package com.bytedance.android.live.effect.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/base/RenderTriggerType;", "", "", "code", "I", "getCode", "()I", "SelectByUser", "UnSelectByUser", "SelectByOthers", "UnSelectByOthers", "Recover", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RenderTriggerType extends Enum<RenderTriggerType> {
    public static final RenderTriggerType Recover = null;
    public static final RenderTriggerType SelectByOthers = null;
    public static final RenderTriggerType SelectByUser = null;
    public static final RenderTriggerType UnSelectByOthers = null;
    public static final RenderTriggerType UnSelectByUser = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderTriggerType[] f66988a = null;
    private final int code;

    static {
        RenderTriggerType r100 = new RenderTriggerType("SelectByUser", 0, 0);
        SelectByUser = r100;
        RenderTriggerType r101 = new RenderTriggerType("UnSelectByUser", 1, 1);
        UnSelectByUser = r101;
        RenderTriggerType r102 = new RenderTriggerType("SelectByOthers", 2, 2);
        SelectByOthers = r102;
        RenderTriggerType r103 = new RenderTriggerType("UnSelectByOthers", 3, 3);
        UnSelectByOthers = r103;
        RenderTriggerType r104 = new RenderTriggerType("Recover", 4, 4);
        Recover = r104;
        f66988a = new RenderTriggerType[]{r100, r101, r102, r103, r104};
    }

    public static RenderTriggerType valueOf(String r100) {
        return (RenderTriggerType) r27.a.a(RenderTriggerType.class, r100);
    }

    public static RenderTriggerType[] values() {
        return (RenderTriggerType[]) f66988a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public RenderTriggerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
