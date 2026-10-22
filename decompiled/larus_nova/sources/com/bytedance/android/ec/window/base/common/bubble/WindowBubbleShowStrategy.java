package com.bytedance.android.ec.window.base.common.bubble;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/bubble/WindowBubbleShowStrategy;", "", "ONLY_ONE_ONCE", "ALL_ONCE", "ONE_BY_ONE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowBubbleShowStrategy extends Enum<WindowBubbleShowStrategy> {
    public static final WindowBubbleShowStrategy ALL_ONCE = null;
    public static final WindowBubbleShowStrategy ONE_BY_ONE = null;
    public static final WindowBubbleShowStrategy ONLY_ONE_ONCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowBubbleShowStrategy[] f49117a = null;

    static {
        WindowBubbleShowStrategy r100 = new WindowBubbleShowStrategy("ONLY_ONE_ONCE", 0);
        ONLY_ONE_ONCE = r100;
        WindowBubbleShowStrategy r101 = new WindowBubbleShowStrategy("ALL_ONCE", 1);
        ALL_ONCE = r101;
        WindowBubbleShowStrategy r102 = new WindowBubbleShowStrategy("ONE_BY_ONE", 2);
        ONE_BY_ONE = r102;
        f49117a = new WindowBubbleShowStrategy[]{r100, r101, r102};
    }

    public static WindowBubbleShowStrategy valueOf(String r100) {
        return (WindowBubbleShowStrategy) r27.a.a(WindowBubbleShowStrategy.class, r100);
    }

    public static WindowBubbleShowStrategy[] values() {
        return (WindowBubbleShowStrategy[]) f49117a.clone();
    }

    public WindowBubbleShowStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
