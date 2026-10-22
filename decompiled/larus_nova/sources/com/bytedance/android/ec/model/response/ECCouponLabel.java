package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes44.dex */
public class ECCouponLabel implements Serializable {
    public static final int COUPON_NEW_CUSTOMER = 3;
    public static final int COUPON_NEW_CUSTOMER_GIFT = 5;
    public static final int COUPON_TYPE_1 = 1;
    public static final int COUPON_TYPE_2 = 2;
    public static final int COUPON_TYPE_3 = 3;
    public static final int COUPON_TYPE_4 = 4;
    public static final int COUPON_TYPE_6 = 6;
    public static final int COUPON_TYPE_8 = 8;
    public static final int KOL_USER_TAG_ALL = 1;
    public static final int KOL_USER_TAG_FANS = 1;

    @SerializedName("coupon_applet")
    public String applet;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public String f47900id;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    public int isShow;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_USER_TAG)
    public long kolUserTag;

    @SerializedName("tag")
    public String tag;

    @SerializedName("tag_background")
    public String tagColor;

    @SerializedName("tag_header")
    public String tagHeader;

    @SerializedName("tag_icon")
    public String tagIcon;

    @SerializedName("type")
    public int type;

    @SerializedName("url")
    public String url;

    public ECCouponLabel() {
        this.type = 1;
    }
}
