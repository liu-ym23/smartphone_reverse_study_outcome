package com.bytedance.android.ec.window.base.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/widget/WindowScrollOrientation;", "", "BOTTOM_UP", "TOP_DOWN", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowScrollOrientation extends Enum<WindowScrollOrientation> {
    public static final WindowScrollOrientation BOTTOM_UP = null;
    public static final WindowScrollOrientation TOP_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowScrollOrientation[] f49929a = null;

    static {
        WindowScrollOrientation r100 = new WindowScrollOrientation("BOTTOM_UP", 0);
        BOTTOM_UP = r100;
        WindowScrollOrientation r101 = new WindowScrollOrientation("TOP_DOWN", 1);
        TOP_DOWN = r101;
        f49929a = new WindowScrollOrientation[]{r100, r101};
    }

    public static WindowScrollOrientation valueOf(String r100) {
        return (WindowScrollOrientation) r27.a.a(WindowScrollOrientation.class, r100);
    }

    public static WindowScrollOrientation[] values() {
        return (WindowScrollOrientation[]) f49929a.clone();
    }

    public WindowScrollOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
