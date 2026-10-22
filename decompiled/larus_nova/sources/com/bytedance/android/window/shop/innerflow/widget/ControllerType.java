package com.bytedance.android.window.shop.innerflow.widget;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ControllerType;", "", "VOLUME", "BARRAGE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ControllerType extends Enum<ControllerType> {
    public static final ControllerType BARRAGE = null;
    public static final ControllerType VOLUME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ControllerType[] f189197a = null;

    static {
        ControllerType r100 = new ControllerType("VOLUME", 0);
        VOLUME = r100;
        ControllerType r101 = new ControllerType("BARRAGE", 1);
        BARRAGE = r101;
        f189197a = new ControllerType[]{r100, r101};
    }

    public static ControllerType valueOf(String r100) {
        return (ControllerType) a.a(ControllerType.class, r100);
    }

    public static ControllerType[] values() {
        return (ControllerType[]) f189197a.clone();
    }

    public ControllerType(String r100, int r101) {
        super(r100, r101);
    }
}
