package com.bytedance.android.window.shop.router;

import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/router/WindowEntranceInfoScene;", "", "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "entranceInfoScene", "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "getEntranceInfoScene", "()Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "SCHEMA_PARSE", "ADD_TO_CART", "ENTER_REPLAY", "PRODUCT_GENERIC", "ENTER_PRODUCT_DETAIL", "SECONDARY_ENTER_WINDOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowEntranceInfoScene extends Enum<WindowEntranceInfoScene> {
    public static final WindowEntranceInfoScene ADD_TO_CART = null;
    public static final WindowEntranceInfoScene ENTER_PRODUCT_DETAIL = null;
    public static final WindowEntranceInfoScene ENTER_REPLAY = null;
    public static final WindowEntranceInfoScene PRODUCT_GENERIC = null;
    public static final WindowEntranceInfoScene SCHEMA_PARSE = null;
    public static final WindowEntranceInfoScene SECONDARY_ENTER_WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowEntranceInfoScene[] f189648a = null;
    private final EntranceInfoScene entranceInfoScene;

    static {
        WindowEntranceInfoScene r100 = new WindowEntranceInfoScene("SCHEMA_PARSE", 0, new EntranceInfoScene(LiveEndPageData.TAG_WINDOW, "schemaParse"));
        SCHEMA_PARSE = r100;
        WindowEntranceInfoScene r101 = new WindowEntranceInfoScene("ADD_TO_CART", 1, new EntranceInfoScene(LiveEndPageData.TAG_WINDOW, "addToCart"));
        ADD_TO_CART = r101;
        WindowEntranceInfoScene r102 = new WindowEntranceInfoScene("ENTER_REPLAY", 2, new EntranceInfoScene(LiveEndPageData.TAG_WINDOW, "enterReplay"));
        ENTER_REPLAY = r102;
        WindowEntranceInfoScene r103 = new WindowEntranceInfoScene("PRODUCT_GENERIC", 3, new EntranceInfoScene(LiveEndPageData.TAG_WINDOW, "productGeneric"));
        PRODUCT_GENERIC = r103;
        WindowEntranceInfoScene r104 = new WindowEntranceInfoScene("ENTER_PRODUCT_DETAIL", 4, new EntranceInfoScene(LiveEndPageData.TAG_WINDOW, "enterProductDetail"));
        ENTER_PRODUCT_DETAIL = r104;
        WindowEntranceInfoScene r105 = new WindowEntranceInfoScene("SECONDARY_ENTER_WINDOW", 5, new EntranceInfoScene(LiveEndPageData.TAG_WINDOW, "secondaryEnterWindow"));
        SECONDARY_ENTER_WINDOW = r105;
        f189648a = new WindowEntranceInfoScene[]{r100, r101, r102, r103, r104, r105};
    }

    public static WindowEntranceInfoScene valueOf(String r100) {
        return (WindowEntranceInfoScene) r27.a.a(WindowEntranceInfoScene.class, r100);
    }

    public static WindowEntranceInfoScene[] values() {
        return (WindowEntranceInfoScene[]) f189648a.clone();
    }

    public final EntranceInfoScene getEntranceInfoScene() {
        return this.entranceInfoScene;
    }

    public WindowEntranceInfoScene(String r100, int r101, EntranceInfoScene r102) {
        super(r100, r101);
        this.entranceInfoScene = r102;
    }
}
