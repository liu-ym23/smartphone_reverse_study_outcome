package com.bytedance.android.window.shop.repository.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/vo/WindowLabelType;", "", "PureText", "Hybrid", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLabelType extends Enum<WindowLabelType> {
    public static final WindowLabelType Hybrid = null;
    public static final WindowLabelType PureText = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLabelType[] f189646a = null;

    static {
        WindowLabelType r100 = new WindowLabelType("PureText", 0);
        PureText = r100;
        WindowLabelType r101 = new WindowLabelType("Hybrid", 1);
        Hybrid = r101;
        f189646a = new WindowLabelType[]{r100, r101};
    }

    public static WindowLabelType valueOf(String r100) {
        return (WindowLabelType) a.a(WindowLabelType.class, r100);
    }

    public static WindowLabelType[] values() {
        return (WindowLabelType[]) f189646a.clone();
    }

    public WindowLabelType(String r100, int r101) {
        super(r100, r101);
    }
}
