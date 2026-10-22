package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/anchorimpl/DoubleRematchType;", "", "None", "Anchor", "Guest", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DoubleRematchType extends Enum<DoubleRematchType> {
    public static final DoubleRematchType Anchor = null;
    public static final DoubleRematchType Guest = null;
    public static final DoubleRematchType None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubleRematchType[] f98410a = null;

    static {
        DoubleRematchType r100 = new DoubleRematchType("None", 0);
        None = r100;
        DoubleRematchType r101 = new DoubleRematchType("Anchor", 1);
        Anchor = r101;
        DoubleRematchType r102 = new DoubleRematchType("Guest", 2);
        Guest = r102;
        f98410a = new DoubleRematchType[]{r100, r101, r102};
    }

    public static DoubleRematchType valueOf(String r100) {
        return (DoubleRematchType) r27.a.a(DoubleRematchType.class, r100);
    }

    public static DoubleRematchType[] values() {
        return (DoubleRematchType[]) f98410a.clone();
    }

    public DoubleRematchType(String r100, int r101) {
        super(r100, r101);
    }
}
