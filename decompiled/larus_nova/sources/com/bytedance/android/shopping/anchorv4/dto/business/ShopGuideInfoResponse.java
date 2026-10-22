package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/ShopGuideInfoResponse;", "Ljava/io/Serializable;", "isShopGuide", "", "shopGuideId", "", "(ZLjava/lang/String;)V", "()Z", "getShopGuideId", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ShopGuideInfoResponse implements Serializable {

    @SerializedName("is_shop_guide")
    private final boolean isShopGuide;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID)
    private final String shopGuideId;

    /* JADX WARN: Multi-variable type inference failed */
    public ShopGuideInfoResponse() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public final String getShopGuideId() {
        return this.shopGuideId;
    }

    public final boolean isShopGuide() {
        return this.isShopGuide;
    }

    public ShopGuideInfoResponse(boolean r100, String r101) {
        this.isShopGuide = r100;
        this.shopGuideId = r101;
    }

    public /* synthetic */ ShopGuideInfoResponse(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
