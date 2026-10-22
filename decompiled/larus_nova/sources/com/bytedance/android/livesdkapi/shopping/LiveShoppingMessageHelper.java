package com.bytedance.android.livesdkapi.shopping;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\bR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\bR\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\bR\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\bR\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/shopping/LiveShoppingMessageHelper;", "", "Ltlc/d;", "message", "", "getMessageType", "(Ltlc/d;)Ljava/lang/Integer;", "MSG_TYPE", "I", "MSG_TYPE_HAS_PROMOTIONS", "MSG_TYPE_NO_PROMOTIONS", "MSG_TYPE_CREATE_PROMOTION", "MSG_TYPE_CANCEL_PROMOTION", "MSG_TYPE_DIALOG_PROMOTION", "MSG_TYPE_AUTHOR_SCREEN_SHOT", "MSG_TYPE_ECOM_NOTICE", "MSG_TYPE_UPDATE_PRODUCT_INFO", "MSG_TYPE_FLASH_BUY", "MSG_TYPE_FLASH_CLOSE", "MSG_TYPE_UP_CART", "MSG_TYPE_DOWN_CART", "MSG_TYPE_UPDATE_GROUP_INFO", "MSG_TYPE_HAS_COMMERCE_AUTHORITY", "MSG_TYPE_NO_COMMERCE_AUTHORITY", "MSG_TYPE_AUCTION_BID", "MSG_TYPE_AUCTION_SUCCESS", "MSG_TYPE_AUCTION_STATUS_CHANGE", "MSG_TYPE_RED_PACKET", "MSG_TYPE_RED_PACKET_CANCEL", "MSG_TYPE_LOTTERY_UP", "MSG_TYPE_LOTTERY_DOWN", "MSG_TYPE_LOTTERY_OPEN", "MSG_TYPE_LOTTERY_WIN", "MSG_TYPE_SHOP_VIP", "MSG_TYPE_ROOM_TAG_OFFLINE", "MSG_TYPE_FILTER_SWITCH_CHANGE", "PRODUCT_SHOP_INTERACTION", "<init>", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveShoppingMessageHelper {
    public static final LiveShoppingMessageHelper INSTANCE = null;
    public static final int MSG_TYPE = 1002;
    public static final int MSG_TYPE_AUCTION_BID = 15;
    public static final int MSG_TYPE_AUCTION_STATUS_CHANGE = 17;
    public static final int MSG_TYPE_AUCTION_SUCCESS = 16;
    public static final int MSG_TYPE_AUTHOR_SCREEN_SHOT = 5;
    public static final int MSG_TYPE_CANCEL_PROMOTION = 3;
    public static final int MSG_TYPE_CREATE_PROMOTION = 2;
    public static final int MSG_TYPE_DIALOG_PROMOTION = 4;
    public static final int MSG_TYPE_DOWN_CART = 11;
    public static final int MSG_TYPE_ECOM_NOTICE = 6;
    public static final int MSG_TYPE_FILTER_SWITCH_CHANGE = 26;
    public static final int MSG_TYPE_FLASH_BUY = 8;
    public static final int MSG_TYPE_FLASH_CLOSE = 9;
    public static final int MSG_TYPE_HAS_COMMERCE_AUTHORITY = 13;
    public static final int MSG_TYPE_HAS_PROMOTIONS = 0;
    public static final int MSG_TYPE_LOTTERY_DOWN = 21;
    public static final int MSG_TYPE_LOTTERY_OPEN = 22;
    public static final int MSG_TYPE_LOTTERY_UP = 20;
    public static final int MSG_TYPE_LOTTERY_WIN = 23;
    public static final int MSG_TYPE_NO_COMMERCE_AUTHORITY = 14;
    public static final int MSG_TYPE_NO_PROMOTIONS = 1;
    public static final int MSG_TYPE_RED_PACKET = 18;
    public static final int MSG_TYPE_RED_PACKET_CANCEL = 19;
    public static final int MSG_TYPE_ROOM_TAG_OFFLINE = 25;
    public static final int MSG_TYPE_SHOP_VIP = 24;
    public static final int MSG_TYPE_UPDATE_GROUP_INFO = 12;
    public static final int MSG_TYPE_UPDATE_PRODUCT_INFO = 7;
    public static final int MSG_TYPE_UP_CART = 10;
    public static final int PRODUCT_SHOP_INTERACTION = 27;

    private LiveShoppingMessageHelper() {
    }

    static {
        INSTANCE = new LiveShoppingMessageHelper();
    }

    public final Integer getMessageType(d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Object r101 = r100.getClass().getMethod("getMsgType", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L9
        if ((r101 instanceof Integer) == true) goto L6;
        r101 = null;
    L6:
        return (Integer) r101;
    L12:
        return null;
    }
}
