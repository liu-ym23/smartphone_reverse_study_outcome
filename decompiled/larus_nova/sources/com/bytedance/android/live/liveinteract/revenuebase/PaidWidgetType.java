package com.bytedance.android.live.liveinteract.revenuebase;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenuebase/PaidWidgetType;", "", "INTERACT", "VIDEO", "AUDIO", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PaidWidgetType extends Enum<PaidWidgetType> {
    public static final PaidWidgetType AUDIO = null;
    public static final PaidWidgetType INTERACT = null;
    public static final PaidWidgetType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaidWidgetType[] f78593a = null;

    static {
        PaidWidgetType r100 = new PaidWidgetType("INTERACT", 0);
        INTERACT = r100;
        PaidWidgetType r101 = new PaidWidgetType("VIDEO", 1);
        VIDEO = r101;
        PaidWidgetType r102 = new PaidWidgetType("AUDIO", 2);
        AUDIO = r102;
        f78593a = new PaidWidgetType[]{r100, r101, r102};
    }

    public static PaidWidgetType valueOf(String r100) {
        return (PaidWidgetType) r27.a.a(PaidWidgetType.class, r100);
    }

    public static PaidWidgetType[] values() {
        return (PaidWidgetType[]) f78593a.clone();
    }

    public PaidWidgetType(String r100, int r101) {
        super(r100, r101);
    }
}
