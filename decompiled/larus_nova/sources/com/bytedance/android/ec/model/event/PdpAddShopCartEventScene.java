package com.bytedance.android.ec.model.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/model/event/PdpAddShopCartEventScene;", "", "CART_ANIMATION_ACTION", "CART_NUM_UPDATE_ACTION", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PdpAddShopCartEventScene extends Enum<PdpAddShopCartEventScene> {
    public static final PdpAddShopCartEventScene CART_ANIMATION_ACTION = null;
    public static final PdpAddShopCartEventScene CART_NUM_UPDATE_ACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PdpAddShopCartEventScene[] f47863a = null;

    static {
        PdpAddShopCartEventScene r100 = new PdpAddShopCartEventScene("CART_ANIMATION_ACTION", 0);
        CART_ANIMATION_ACTION = r100;
        PdpAddShopCartEventScene r101 = new PdpAddShopCartEventScene("CART_NUM_UPDATE_ACTION", 1);
        CART_NUM_UPDATE_ACTION = r101;
        f47863a = new PdpAddShopCartEventScene[]{r100, r101};
    }

    public static PdpAddShopCartEventScene valueOf(String r100) {
        return (PdpAddShopCartEventScene) a.a(PdpAddShopCartEventScene.class, r100);
    }

    public static PdpAddShopCartEventScene[] values() {
        return (PdpAddShopCartEventScene[]) f47863a.clone();
    }

    public PdpAddShopCartEventScene(String r100, int r101) {
        super(r100, r101);
    }
}
