package com.bytedance.android.ec.window.base.common.datachannel;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/datachannel/ECWindowSourceMethod;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "PRODUCT_CARD", "COMMENT_CART_TAG", "STORE_VIDEO_CARD", "LIVE_TOP", "MOMENTS", "STORE_SHOP_HEAD_INFO", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECWindowSourceMethod extends Enum<ECWindowSourceMethod> {
    public static final ECWindowSourceMethod COMMENT_CART_TAG = null;
    public static final ECWindowSourceMethod LIVE_TOP = null;
    public static final ECWindowSourceMethod MOMENTS = null;
    public static final ECWindowSourceMethod PRODUCT_CARD = null;
    public static final ECWindowSourceMethod STORE_SHOP_HEAD_INFO = null;
    public static final ECWindowSourceMethod STORE_VIDEO_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECWindowSourceMethod[] f49150a = null;
    private final String des;

    static {
        ECWindowSourceMethod r100 = new ECWindowSourceMethod("PRODUCT_CARD", 0, "product_card");
        PRODUCT_CARD = r100;
        ECWindowSourceMethod r101 = new ECWindowSourceMethod("COMMENT_CART_TAG", 1, "comment_cart_tag");
        COMMENT_CART_TAG = r101;
        ECWindowSourceMethod r102 = new ECWindowSourceMethod("STORE_VIDEO_CARD", 2, "store_video_card");
        STORE_VIDEO_CARD = r102;
        ECWindowSourceMethod r103 = new ECWindowSourceMethod("LIVE_TOP", 3, "live_top");
        LIVE_TOP = r103;
        ECWindowSourceMethod r104 = new ECWindowSourceMethod("MOMENTS", 4, ShareChannel.WX_MOMENTS);
        MOMENTS = r104;
        ECWindowSourceMethod r105 = new ECWindowSourceMethod("STORE_SHOP_HEAD_INFO", 5, "store_shop_head_info");
        STORE_SHOP_HEAD_INFO = r105;
        f49150a = new ECWindowSourceMethod[]{r100, r101, r102, r103, r104, r105};
    }

    public static ECWindowSourceMethod valueOf(String r100) {
        return (ECWindowSourceMethod) a.a(ECWindowSourceMethod.class, r100);
    }

    public static ECWindowSourceMethod[] values() {
        return (ECWindowSourceMethod[]) f49150a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public ECWindowSourceMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
