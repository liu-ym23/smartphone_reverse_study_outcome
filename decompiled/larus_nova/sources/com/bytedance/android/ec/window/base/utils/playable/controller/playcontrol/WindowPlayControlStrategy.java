package com.bytedance.android.ec.window.base.utils.playable.controller.playcontrol;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/window/base/utils/playable/controller/playcontrol/WindowPlayControlStrategy;", "", "ORDER_FIRST", "KEEP_LAST", "ORDER_FIRST_IMAGE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowPlayControlStrategy extends Enum<WindowPlayControlStrategy> {
    public static final WindowPlayControlStrategy KEEP_LAST = null;
    public static final WindowPlayControlStrategy ORDER_FIRST = null;
    public static final WindowPlayControlStrategy ORDER_FIRST_IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowPlayControlStrategy[] f49745a = null;

    static {
        WindowPlayControlStrategy r100 = new WindowPlayControlStrategy("ORDER_FIRST", 0);
        ORDER_FIRST = r100;
        WindowPlayControlStrategy r101 = new WindowPlayControlStrategy("KEEP_LAST", 1);
        KEEP_LAST = r101;
        WindowPlayControlStrategy r102 = new WindowPlayControlStrategy("ORDER_FIRST_IMAGE", 2);
        ORDER_FIRST_IMAGE = r102;
        f49745a = new WindowPlayControlStrategy[]{r100, r101, r102};
    }

    public static WindowPlayControlStrategy valueOf(String r100) {
        return (WindowPlayControlStrategy) a.a(WindowPlayControlStrategy.class, r100);
    }

    public static WindowPlayControlStrategy[] values() {
        return (WindowPlayControlStrategy[]) f49745a.clone();
    }

    public WindowPlayControlStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
