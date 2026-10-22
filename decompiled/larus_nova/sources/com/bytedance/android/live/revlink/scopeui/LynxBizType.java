package com.bytedance.android.live.revlink.scopeui;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/scopeui/LynxBizType;", "", "DynamicCentral", "Hybrid", "BreakThrough", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LynxBizType extends Enum<LynxBizType> {
    public static final LynxBizType BreakThrough = null;
    public static final LynxBizType DynamicCentral = null;
    public static final LynxBizType Hybrid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxBizType[] f98795a = null;

    static {
        LynxBizType r100 = new LynxBizType("DynamicCentral", 0);
        DynamicCentral = r100;
        LynxBizType r101 = new LynxBizType("Hybrid", 1);
        Hybrid = r101;
        LynxBizType r102 = new LynxBizType("BreakThrough", 2);
        BreakThrough = r102;
        f98795a = new LynxBizType[]{r100, r101, r102};
    }

    public static LynxBizType valueOf(String r100) {
        return (LynxBizType) a.a(LynxBizType.class, r100);
    }

    public static LynxBizType[] values() {
        return (LynxBizType[]) f98795a.clone();
    }

    public LynxBizType(String r100, int r101) {
        super(r100, r101);
    }
}
