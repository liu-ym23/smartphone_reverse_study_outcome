package com.bytedance.android.shopping.api;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/ClickArea;", "", "ENTER_SHOP", "COMMENT", "SHARE", "COLLECT", "ADD_CART", "BUY", FlowDoraWifiScene.OTHER, "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ClickArea extends Enum<ClickArea> {
    public static final ClickArea ADD_CART = null;
    public static final ClickArea BUY = null;
    public static final ClickArea COLLECT = null;
    public static final ClickArea COMMENT = null;
    public static final ClickArea ENTER_SHOP = null;
    public static final ClickArea OTHER = null;
    public static final ClickArea SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClickArea[] f170186a = null;

    static {
        ClickArea r100 = new ClickArea("ENTER_SHOP", 0);
        ENTER_SHOP = r100;
        ClickArea r101 = new ClickArea("COMMENT", 1);
        COMMENT = r101;
        ClickArea r102 = new ClickArea("SHARE", 2);
        SHARE = r102;
        ClickArea r103 = new ClickArea("COLLECT", 3);
        COLLECT = r103;
        ClickArea r104 = new ClickArea("ADD_CART", 4);
        ADD_CART = r104;
        ClickArea r105 = new ClickArea("BUY", 5);
        BUY = r105;
        ClickArea r106 = new ClickArea(FlowDoraWifiScene.OTHER, 6);
        OTHER = r106;
        f170186a = new ClickArea[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ClickArea valueOf(String r100) {
        return (ClickArea) a.a(ClickArea.class, r100);
    }

    public static ClickArea[] values() {
        return (ClickArea[]) f170186a.clone();
    }

    public ClickArea(String r100, int r101) {
        super(r100, r101);
    }
}
