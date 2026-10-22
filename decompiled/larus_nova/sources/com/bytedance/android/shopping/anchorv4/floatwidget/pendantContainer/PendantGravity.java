package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/PendantGravity;", "", "BOTTOM_START", "TOP_RIGHT", "BOTTOM_END", "TOP_LEFT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PendantGravity extends Enum<PendantGravity> {
    public static final PendantGravity BOTTOM_END = null;
    public static final PendantGravity BOTTOM_START = null;
    public static final PendantGravity TOP_LEFT = null;
    public static final PendantGravity TOP_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PendantGravity[] f166763a = null;

    static {
        PendantGravity r100 = new PendantGravity("BOTTOM_START", 0);
        BOTTOM_START = r100;
        PendantGravity r101 = new PendantGravity("TOP_RIGHT", 1);
        TOP_RIGHT = r101;
        PendantGravity r102 = new PendantGravity("BOTTOM_END", 2);
        BOTTOM_END = r102;
        PendantGravity r103 = new PendantGravity("TOP_LEFT", 3);
        TOP_LEFT = r103;
        f166763a = new PendantGravity[]{r100, r101, r102, r103};
    }

    public static PendantGravity valueOf(String r100) {
        return (PendantGravity) r27.a.a(PendantGravity.class, r100);
    }

    public static PendantGravity[] values() {
        return (PendantGravity[]) f166763a.clone();
    }

    public PendantGravity(String r100, int r101) {
        super(r100, r101);
    }
}
