package com.bytedance.android.window.shop.repository.header.utils;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/repository/header/utils/WindowHeaderStrategy;", "", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "I", "getStrategy", "()I", "ONLY_SHOW_IN_FULLSCREEN", "ALWAYS_SHOWING", "ONLY_SHOW_IN_SPLIT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowHeaderStrategy extends Enum<WindowHeaderStrategy> {
    public static final WindowHeaderStrategy ALWAYS_SHOWING = null;
    public static final WindowHeaderStrategy ONLY_SHOW_IN_FULLSCREEN = null;
    public static final WindowHeaderStrategy ONLY_SHOW_IN_SPLIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowHeaderStrategy[] f189427a = null;
    private final int strategy;

    static {
        WindowHeaderStrategy r100 = new WindowHeaderStrategy("ONLY_SHOW_IN_FULLSCREEN", 0, 0);
        ONLY_SHOW_IN_FULLSCREEN = r100;
        WindowHeaderStrategy r101 = new WindowHeaderStrategy("ALWAYS_SHOWING", 1, 1);
        ALWAYS_SHOWING = r101;
        WindowHeaderStrategy r102 = new WindowHeaderStrategy("ONLY_SHOW_IN_SPLIT", 2, 2);
        ONLY_SHOW_IN_SPLIT = r102;
        f189427a = new WindowHeaderStrategy[]{r100, r101, r102};
    }

    public static WindowHeaderStrategy valueOf(String r100) {
        return (WindowHeaderStrategy) a.a(WindowHeaderStrategy.class, r100);
    }

    public static WindowHeaderStrategy[] values() {
        return (WindowHeaderStrategy[]) f189427a.clone();
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public WindowHeaderStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.strategy = r102;
    }
}
