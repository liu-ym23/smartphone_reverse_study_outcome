package com.bytedance.android.livesdkapi.commerce;

import com.bytedance.android.live.base.model.shopping.UpdatedCampaignInfo;
import com.bytedance.android.live.base.model.shopping.UpdatedCouponInfo;
import com.bytedance.android.live.base.model.shopping.UpdatedProductInfo;
import com.bytedance.android.live.base.model.shopping.UpdatedSkuInfo;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveShoppingMessage {
    public static final int MSG_TYPE_AUTHOR_SCREEN_SHOT = 5;
    public static final int MSG_TYPE_CANCEL_PROMOTION = 3;
    public static final int MSG_TYPE_CREATE_PROMOTION = 2;
    public static final int MSG_TYPE_DIALOG_PROMOTION = 4;
    public static final int MSG_TYPE_ECOM_NOTICE = 6;
    public static final int MSG_TYPE_FLASH_BUY = 8;
    public static final int MSG_TYPE_FLASH_CLOSE = 9;
    public static final int MSG_TYPE_HAS_PROMOTIONS = 0;
    public static final int MSG_TYPE_NO_PROMOTIONS = 1;
    public static final int MSG_TYPE_UPDATE_PRODUCT_INFO = 7;

    public interface BubbleType {
        public static final int FLASH_ALL = 1;
        public static final int NORMAL = 0;
    }

    public interface UpdateType {
        public static final int CAMPAIGN = 3;
        public static final int COUPON = 2;
        public static final int PRICE = 0;
        public static final int SOLD_OUT = 1;
    }

    int getBubbleType();

    UpdatedCampaignInfo getCampaignInfo();

    UpdatedCouponInfo getCouponInfo();

    String getEcomNotice();

    int getMsgType();

    List<Long> getProductIds();

    UpdatedProductInfo getProductInfo();

    long getPromotionId();

    int getPromotionNum();

    long getScreenshotTimestamp();

    List<String> getSecTargetUid();

    UpdatedSkuInfo getSkuInfo();

    List<Long> getTargetUid();

    long getTimeStamp();

    int getUpdateType();

    boolean isFullFlashPromotion();

    boolean isNormalPromotion();

    boolean isSoldOut();
}
