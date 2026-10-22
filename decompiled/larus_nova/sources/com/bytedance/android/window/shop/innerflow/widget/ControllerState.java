package com.bytedance.android.window.shop.innerflow.widget;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;", "", "ENABLED", "DISABLED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ControllerState extends Enum<ControllerState> {
    public static final ControllerState DISABLED = null;
    public static final ControllerState ENABLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ControllerState[] f189196a = null;

    static {
        ControllerState r100 = new ControllerState("ENABLED", 0);
        ENABLED = r100;
        ControllerState r101 = new ControllerState("DISABLED", 1);
        DISABLED = r101;
        f189196a = new ControllerState[]{r100, r101};
    }

    public static ControllerState valueOf(String r100) {
        return (ControllerState) a.a(ControllerState.class, r100);
    }

    public static ControllerState[] values() {
        return (ControllerState[]) f189196a.clone();
    }

    public ControllerState(String r100, int r101) {
        super(r100, r101);
    }
}
