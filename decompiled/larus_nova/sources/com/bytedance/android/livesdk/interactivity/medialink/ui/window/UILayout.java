package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/UILayout;", "", "Normal", "Enlarge", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UILayout extends Enum<UILayout> {
    public static final UILayout Enlarge = null;
    public static final UILayout Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UILayout[] f138418a = null;

    static {
        UILayout r100 = new UILayout("Normal", 0);
        Normal = r100;
        UILayout r101 = new UILayout("Enlarge", 1);
        Enlarge = r101;
        f138418a = new UILayout[]{r100, r101};
    }

    public static UILayout valueOf(String r100) {
        return (UILayout) r27.a.a(UILayout.class, r100);
    }

    public static UILayout[] values() {
        return (UILayout[]) f138418a.clone();
    }

    public UILayout(String r100, int r101) {
        super(r100, r101);
    }
}
