package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l93.b;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\bH\b\u0087\b\u0018\u00002\u00020\u0001:\u0005rstuvB\u0083\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010/¢\u0006\u0004\bp\u0010qJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b)\u0010*J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003J\u0012\u00100\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0004\b0\u00101J\u008c\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010/HÆ\u0001¢\u0006\u0004\bG\u0010HJ\t\u0010I\u001a\u00020\nHÖ\u0001J\t\u0010J\u001a\u00020\bHÖ\u0001J\u0013\u0010L\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u00102\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010M\u001a\u0004\bN\u0010OR\u001c\u00103\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010P\u001a\u0004\bQ\u0010RR\u001c\u00104\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010S\u001a\u0004\bT\u0010UR\u001c\u00105\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010V\u001a\u0004\bW\u0010XR\u001c\u00106\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010V\u001a\u0004\bY\u0010XR\u001c\u00107\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010V\u001a\u0004\bZ\u0010XR\u001c\u00108\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010V\u001a\u0004\b[\u0010XR\u001c\u00109\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010V\u001a\u0004\b\\\u0010XR\u001c\u0010:\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010P\u001a\u0004\b]\u0010RR\u001c\u0010;\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010V\u001a\u0004\b^\u0010XR\u001c\u0010<\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010V\u001a\u0004\b_\u0010XR\u001c\u0010=\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010V\u001a\u0004\b`\u0010XR\u001c\u0010>\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010V\u001a\u0004\ba\u0010XR\u001c\u0010?\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010V\u001a\u0004\bb\u0010XR\u001c\u0010@\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010P\u001a\u0004\bc\u0010RR\u001c\u0010A\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010V\u001a\u0004\bd\u0010XR\u001c\u0010B\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010V\u001a\u0004\be\u0010XR\u001c\u0010C\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010f\u001a\u0004\bg\u0010*R\u001c\u0010D\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010E\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010k\u001a\u0004\bl\u0010mR\u001c\u0010F\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010n\u001a\u0004\bo\u00101¨\u0006w"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "getChannelLives", "", "isChannelStatic", "()Ljava/lang/Boolean;", "", "index", "", "getNoticeName", "getItemImageUrl", "getTitleImgUrl", "showItemPrice", "getItemPrice", "getItemPriceOrTag", "showItemTag", "getItemTag", "getDisplayType", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$a;", "getCouponAnimation", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "component1", "component2", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "component19", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "component20", "", "component21", "()Ljava/lang/Long;", "layout", "extra", "logExtra", "componentId", "moduleId", "name", "title", "subtitle", "icon", "link", "resourceId", "bgUrl", "bgUrl1", "bgUrl2", "fgUrl", "tagUrl", "tagUrl2", "originChannelCardFIndex", "data", "bcm", "leftTime", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;Ljava/lang/Object;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "toString", "hashCode", "other", "equals", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "getLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/Object;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "getLogExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "Ljava/lang/String;", "getComponentId", "()Ljava/lang/String;", "getModuleId", "getName", "getTitle", "getSubtitle", "getIcon", "getLink", "getResourceId", "getBgUrl", "getBgUrl1", "getBgUrl2", "getFgUrl", "getTagUrl", "getTagUrl2", "Ljava/lang/Integer;", "getOriginChannelCardFIndex", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "getData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "getBcm", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "Ljava/lang/Long;", "getLeftTime", "<init>", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;Ljava/lang/Object;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;Ljava/lang/Long;)V", "Animation", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Data", "Layout", "LogExtra", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelVO {

    @SerializedName("bcm")
    private final Bcm bcm;

    @SerializedName("bgUrl")
    private final String bgUrl;

    @SerializedName("bg_url_1")
    private final String bgUrl1;

    @SerializedName("bg_url_2")
    private final String bgUrl2;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("data")
    private final Data data;

    @SerializedName("extra")
    private final Object extra;

    @SerializedName("fgUrl")
    private final Object fgUrl;

    @SerializedName("icon")
    private final Object icon;

    @SerializedName("layout")
    private final Layout layout;

    @SerializedName("left_time")
    private final Long leftTime;

    @SerializedName("link")
    private final String link;

    @SerializedName("log_extra")
    private final LogExtra logExtra;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("name")
    private final String name;

    @SerializedName("originChannelCardFIndex")
    private final Integer originChannelCardFIndex;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName("tag_url")
    private final String tagUrl;

    @SerializedName("tag_url_2")
    private final String tagUrl2;

    @SerializedName("title")
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J¶\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b$\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "", "animationType", "", "animationStartTime", "", "animationEndTime", "dayRange", "carouselPeriod", "tagProductInterval", "tagUrl", "", "carouselTimes", "lottieUrl", "lottieUrl1", "startCustomLottieFrame", "endCustomLottieFrame", "extra", "", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)V", "getAnimationEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAnimationStartTime", "getAnimationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCarouselPeriod", "getCarouselTimes", "getDayRange", "getEndCustomLottieFrame", "getExtra", "()Ljava/util/Map;", "getLottieUrl", "()Ljava/lang/String;", "getLottieUrl1", "getStartCustomLottieFrame", "getTagProductInterval", "getTagUrl", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Animation {

        @SerializedName("animation_end_time")
        private final Long animationEndTime;

        @SerializedName("animation_start_time")
        private final Long animationStartTime;

        @SerializedName("animation_type")
        private final Integer animationType;

        @SerializedName("carousel_period")
        private final Long carouselPeriod;

        @SerializedName("carousel_times")
        private final Long carouselTimes;

        @SerializedName("day_range")
        private final Long dayRange;

        @SerializedName("end_custom_lottie_frame")
        private final Integer endCustomLottieFrame;

        @SerializedName("extra")
        private final Map<String, String> extra;

        @SerializedName("lottie_url")
        private final String lottieUrl;

        @SerializedName("lottie_url_1")
        private final String lottieUrl1;

        @SerializedName("start_custom_lottie_frame")
        private final Integer startCustomLottieFrame;

        @SerializedName("tag_product_interval")
        private final Long tagProductInterval;

        @SerializedName("tag_url")
        private final String tagUrl;

        public Animation() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Animation copy$default(Animation r110, Integer r111, Long r112, Long r113, Long r114, Long r115, Long r210, String r211, Long r212, String r213, String r214, Integer r215, Integer r216, Map r217, int r218, Object r219) {
            if ((r218 & 1) == 0) goto L5;
            Integer r100 = r110.animationType;
        L7:
            if ((r218 & 2) == 0) goto L9;
            Long r101 = r110.animationStartTime;
        L11:
            if ((r218 & 4) == 0) goto L13;
            Long r102 = r110.animationEndTime;
        L15:
            if ((r218 & 8) == 0) goto L17;
            Long r103 = r110.dayRange;
        L19:
            if ((r218 & 16) == 0) goto L21;
            Long r104 = r110.carouselPeriod;
        L23:
            if ((r218 & 32) == 0) goto L25;
            Long r105 = r110.tagProductInterval;
        L27:
            if ((r218 & 64) == 0) goto L29;
            String r106 = r110.tagUrl;
        L31:
            if ((r218 & 128) == 0) goto L33;
            Long r107 = r110.carouselTimes;
        L35:
            if ((r218 & 256) == 0) goto L37;
            String r116 = r110.lottieUrl;
        L39:
            if ((r218 & 512) == 0) goto L41;
            String r117 = r110.lottieUrl1;
        L43:
            if ((r218 & 1024) == 0) goto L45;
            Integer r118 = r110.startCustomLottieFrame;
        L47:
            if ((r218 & 2048) == 0) goto L49;
            Integer r119 = r110.endCustomLottieFrame;
        L51:
            if ((r218 & 4096) == 0) goto L53;
            Map r108 = r110.extra;
        L55:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
        L53:
            r108 = r217;
            goto L55
        L49:
            r119 = r216;
            goto L51
        L45:
            r118 = r215;
            goto L47
        L41:
            r117 = r214;
            goto L43
        L37:
            r116 = r213;
            goto L39
        L33:
            r107 = r212;
            goto L35
        L29:
            r106 = r211;
            goto L31
        L25:
            r105 = r210;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final Integer component1() {
            return this.animationType;
        }

        public final String component10() {
            return this.lottieUrl1;
        }

        public final Integer component11() {
            return this.startCustomLottieFrame;
        }

        public final Integer component12() {
            return this.endCustomLottieFrame;
        }

        public final Map<String, String> component13() {
            return this.extra;
        }

        public final Long component2() {
            return this.animationStartTime;
        }

        public final Long component3() {
            return this.animationEndTime;
        }

        public final Long component4() {
            return this.dayRange;
        }

        public final Long component5() {
            return this.carouselPeriod;
        }

        public final Long component6() {
            return this.tagProductInterval;
        }

        public final String component7() {
            return this.tagUrl;
        }

        public final Long component8() {
            return this.carouselTimes;
        }

        public final String component9() {
            return this.lottieUrl;
        }

        public final Animation copy(Integer r110, Long r111, Long r112, Long r113, Long r210, Long r211, String r212, Long r213, String r214, String r215, Integer r216, Integer r217, Map<String, String> r218) {
            return new Animation(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Animation) == false) goto L32;
            Animation r101 = (Animation) r100;
            if (Intrinsics.areEqual(this.animationType, r101.animationType) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.animationStartTime, r101.animationStartTime) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.animationEndTime, r101.animationEndTime) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.dayRange, r101.dayRange) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.carouselPeriod, r101.carouselPeriod) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.tagProductInterval, r101.tagProductInterval) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.tagUrl, r101.tagUrl) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.carouselTimes, r101.carouselTimes) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.lottieUrl, r101.lottieUrl) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.lottieUrl1, r101.lottieUrl1) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.startCustomLottieFrame, r101.startCustomLottieFrame) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.endCustomLottieFrame, r101.endCustomLottieFrame) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L49;
            return false;
        L49:
            return true;
        L32:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.animationType;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Long r104 = this.animationStartTime;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.animationEndTime;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.dayRange;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Long r113 = this.carouselPeriod;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Long r116 = this.tagProductInterval;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.tagUrl;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            Long r122 = this.carouselTimes;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.lottieUrl;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.lottieUrl1;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            Integer r131 = this.startCustomLottieFrame;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            Integer r134 = this.endCustomLottieFrame;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            Map<String, String> r137 = this.extra;
            if (r137 == null) goto L54;
            r101 = r137.hashCode();
        L54:
            return r136 + r101;
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Animation(animationType=" + this.animationType + ", animationStartTime=" + this.animationStartTime + ", animationEndTime=" + this.animationEndTime + ", dayRange=" + this.dayRange + ", carouselPeriod=" + this.carouselPeriod + ", tagProductInterval=" + this.tagProductInterval + ", tagUrl=" + this.tagUrl + ", carouselTimes=" + this.carouselTimes + ", lottieUrl=" + this.lottieUrl + ", lottieUrl1=" + this.lottieUrl1 + ", startCustomLottieFrame=" + this.startCustomLottieFrame + ", endCustomLottieFrame=" + this.endCustomLottieFrame + ", extra=" + this.extra + ")";
        }

        public final Long getAnimationEndTime() {
            return this.animationEndTime;
        }

        public final Long getAnimationStartTime() {
            return this.animationStartTime;
        }

        public final Integer getAnimationType() {
            return this.animationType;
        }

        public final Long getCarouselPeriod() {
            return this.carouselPeriod;
        }

        public final Long getCarouselTimes() {
            return this.carouselTimes;
        }

        public final Long getDayRange() {
            return this.dayRange;
        }

        public final Integer getEndCustomLottieFrame() {
            return this.endCustomLottieFrame;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final String getLottieUrl() {
            return this.lottieUrl;
        }

        public final String getLottieUrl1() {
            return this.lottieUrl1;
        }

        public final Integer getStartCustomLottieFrame() {
            return this.startCustomLottieFrame;
        }

        public final Long getTagProductInterval() {
            return this.tagProductInterval;
        }

        public final String getTagUrl() {
            return this.tagUrl;
        }

        public Animation(Integer r100, Long r101, Long r102, Long r103, Long r104, Long r105, String r106, Long r107, String r108, String r110, Integer r111, Integer r112, Map<String, String> r113) {
            this.animationType = r100;
            this.animationStartTime = r101;
            this.animationEndTime = r102;
            this.dayRange = r103;
            this.carouselPeriod = r104;
            this.tagProductInterval = r105;
            this.tagUrl = r106;
            this.carouselTimes = r107;
            this.lottieUrl = r108;
            this.lottieUrl1 = r110;
            this.startCustomLottieFrame = r111;
            this.endCustomLottieFrame = r112;
            this.extra = r113;
        }

        public /* synthetic */ Animation(Integer r110, Long r111, Long r112, Long r113, Long r114, Long r210, String r211, Long r212, String r213, String r214, Integer r215, Integer r216, Map r217, int r218, DefaultConstructorMarker r219) {
            Map r100 = null;
            if ((r218 & 1) == 0) goto L5;
            Integer r101 = null;
        L7:
            if ((r218 & 2) == 0) goto L9;
            Long r102 = null;
        L11:
            if ((r218 & 4) == 0) goto L13;
            Long r103 = null;
        L15:
            if ((r218 & 8) == 0) goto L17;
            Long r104 = null;
        L19:
            if ((r218 & 16) == 0) goto L21;
            Long r105 = null;
        L23:
            if ((r218 & 32) == 0) goto L25;
            Long r106 = null;
        L27:
            if ((r218 & 64) == 0) goto L29;
            String r107 = null;
        L31:
            if ((r218 & 128) == 0) goto L33;
            Long r108 = null;
        L35:
            if ((r218 & 256) == 0) goto L37;
            String r115 = null;
        L39:
            if ((r218 & 512) == 0) goto L41;
            String r116 = null;
        L43:
            if ((r218 & 1024) == 0) goto L45;
            Integer r117 = null;
        L47:
            if ((r218 & 2048) == 0) goto L49;
            Integer r118 = null;
        L51:
            if ((r218 & 4096) != 0) goto L54;
            r100 = r217;
        L54:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
            return;
        L49:
            r118 = r216;
            goto L51
        L45:
            r117 = r215;
            goto L47
        L41:
            r116 = r214;
            goto L43
        L37:
            r115 = r213;
            goto L39
        L33:
            r108 = r212;
            goto L35
        L29:
            r107 = r211;
            goto L31
        L25:
            r106 = r210;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\"#BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nHÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nHÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "items", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard;", GXTemplateKey.GAIAX_ANIMATION, "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "marketingItems", "", "subItems", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;Ljava/util/List;Ljava/util/List;)V", "getAnimation", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "getEntrance", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "getItems", "()Ljava/util/List;", "getMarketingItems", "getSubItems", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Entrance", "EntrancePit", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Data {

        @SerializedName(GXTemplateKey.GAIAX_ANIMATION)
        private final Animation animation;

        @SerializedName(SoloKtvContext.SOLO_PAGE_ENTRANCE)
        private final Entrance entrance;

        @SerializedName("items")
        private final List<ECCommonCard> items;

        @SerializedName("marketing_items")
        private final List<ECCommonCard> marketingItems;

        @SerializedName("sub_items")
        private final List<ECCommonCard> subItems;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "", "entranceDisplayType", "", "entranceContentFormat", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "(Ljava/lang/Integer;Ljava/util/List;)V", "getEntranceContentFormat", "()Ljava/util/List;", "getEntranceDisplayType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Entrance {

            @SerializedName("entrance_content_format")
            private final List<EntrancePit> entranceContentFormat;

            @SerializedName("entrance_display_type")
            private final Integer entranceDisplayType;

            /* JADX WARN: Multi-variable type inference failed */
            public Entrance() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Entrance copy$default(Entrance r100, Integer r101, List r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.entranceDisplayType;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.entranceContentFormat;
            L9:
                return r100.copy(r101, r102);
            }

            public final Integer component1() {
                return this.entranceDisplayType;
            }

            public final List<EntrancePit> component2() {
                return this.entranceContentFormat;
            }

            public final Entrance copy(Integer r100, List<EntrancePit> r101) {
                return new Entrance(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Entrance) == false) goto L10;
                Entrance r101 = (Entrance) r100;
                if (Intrinsics.areEqual(this.entranceDisplayType, r101.entranceDisplayType) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.entranceContentFormat, r101.entranceContentFormat) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Integer r100 = this.entranceDisplayType;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<EntrancePit> r104 = this.entranceContentFormat;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "Entrance(entranceDisplayType=" + this.entranceDisplayType + ", entranceContentFormat=" + this.entranceContentFormat + ")";
            }

            public final List<EntrancePit> getEntranceContentFormat() {
                return this.entranceContentFormat;
            }

            public final Integer getEntranceDisplayType() {
                return this.entranceDisplayType;
            }

            public Entrance(Integer r100, List<EntrancePit> r101) {
                this.entranceDisplayType = r100;
                this.entranceContentFormat = r101;
            }

            public /* synthetic */ Entrance(Integer r100, List r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "", "targetIdx", "", "tagType", "content", "", "subTagType", "subContent", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getSubContent", "getSubTagType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagType", "getTargetIdx", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class EntrancePit {

            @SerializedName("content")
            private final String content;

            @SerializedName("sub_content")
            private final String subContent;

            @SerializedName("sub_tag_type")
            private final Integer subTagType;

            @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
            private final Integer tagType;

            @SerializedName("target_idx")
            private final Integer targetIdx;

            public EntrancePit() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ EntrancePit copy$default(EntrancePit r100, Integer r101, Integer r102, String r103, Integer r104, String r105, int r106, Object r110) {
                if ((r106 & 1) == 0) goto L6;
                r101 = r100.targetIdx;
            L6:
                if ((r106 & 2) == 0) goto L8;
                r102 = r100.tagType;
            L8:
                Integer r111 = r102;
                if ((r106 & 4) == 0) goto L11;
                r103 = r100.content;
            L11:
                String r107 = r103;
                if ((r106 & 8) == 0) goto L14;
                r104 = r100.subTagType;
            L14:
                Integer r108 = r104;
                if ((r106 & 16) == 0) goto L17;
                r105 = r100.subContent;
            L17:
                Integer r109 = r101;
                return r100.copy(r109, r111, r107, r108, r105);
            }

            public final Integer component1() {
                return this.targetIdx;
            }

            public final Integer component2() {
                return this.tagType;
            }

            public final String component3() {
                return this.content;
            }

            public final Integer component4() {
                return this.subTagType;
            }

            public final String component5() {
                return this.subContent;
            }

            public final EntrancePit copy(Integer r100, Integer r101, String r110, Integer r111, String r112) {
                return new EntrancePit(r100, r101, r110, r111, r112);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof EntrancePit) == false) goto L16;
                EntrancePit r101 = (EntrancePit) r100;
                if (Intrinsics.areEqual(this.targetIdx, r101.targetIdx) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.tagType, r101.tagType) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.subTagType, r101.subTagType) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.subContent, r101.subContent) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                Integer r100 = this.targetIdx;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Integer r104 = this.tagType;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                String r107 = this.content;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.subTagType;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.subContent;
                if (r113 == null) goto L22;
                r101 = r113.hashCode();
            L22:
                return r112 + r101;
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "EntrancePit(targetIdx=" + this.targetIdx + ", tagType=" + this.tagType + ", content=" + this.content + ", subTagType=" + this.subTagType + ", subContent=" + this.subContent + ")";
            }

            public final String getContent() {
                return this.content;
            }

            public final String getSubContent() {
                return this.subContent;
            }

            public final Integer getSubTagType() {
                return this.subTagType;
            }

            public final Integer getTagType() {
                return this.tagType;
            }

            public final Integer getTargetIdx() {
                return this.targetIdx;
            }

            public EntrancePit(Integer r100, Integer r101, String r102, Integer r103, String r104) {
                this.targetIdx = r100;
                this.tagType = r101;
                this.content = r102;
                this.subTagType = r103;
                this.subContent = r104;
            }

            public /* synthetic */ EntrancePit(Integer r100, Integer r101, String r102, Integer r103, String r104, int r110, DefaultConstructorMarker r111) {
                if ((r110 & 1) == 0) goto L5;
                Integer r112 = null;
            L7:
                if ((r110 & 2) == 0) goto L9;
                Integer r105 = null;
            L11:
                if ((r110 & 4) == 0) goto L13;
                String r106 = null;
            L15:
                if ((r110 & 8) == 0) goto L17;
                Integer r107 = null;
            L19:
                if ((r110 & 16) == 0) goto L21;
                String r113 = null;
            L22:
                this(r112, r105, r106, r107, r113);
                return;
            L21:
                r113 = r104;
                goto L22
            L17:
                r107 = r103;
                goto L19
            L13:
                r106 = r102;
                goto L15
            L9:
                r105 = r101;
                goto L11
            L5:
                r112 = r100;
                goto L7
            }
        }

        public Data() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data r100, Entrance r101, List r102, Animation r103, List r104, List r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.entrance;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.items;
        L8:
            List r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.animation;
        L11:
            Animation r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.marketingItems;
        L14:
            List r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.subItems;
        L17:
            Entrance r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final Entrance component1() {
            return this.entrance;
        }

        public final List<ECCommonCard> component2() {
            return this.items;
        }

        public final Animation component3() {
            return this.animation;
        }

        public final List<ECCommonCard> component4() {
            return this.marketingItems;
        }

        public final List<ECCommonCard> component5() {
            return this.subItems;
        }

        public final Data copy(Entrance r100, List<ECCommonCard> r101, Animation r110, List<ECCommonCard> r111, List<ECCommonCard> r112) {
            return new Data(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Data) == false) goto L16;
            Data r101 = (Data) r100;
            if (Intrinsics.areEqual(this.entrance, r101.entrance) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.items, r101.items) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.animation, r101.animation) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.marketingItems, r101.marketingItems) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.subItems, r101.subItems) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            Entrance r100 = this.entrance;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<ECCommonCard> r104 = this.items;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Animation r107 = this.animation;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            List<ECCommonCard> r110 = this.marketingItems;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            List<ECCommonCard> r113 = this.subItems;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Data(entrance=" + this.entrance + ", items=" + this.items + ", animation=" + this.animation + ", marketingItems=" + this.marketingItems + ", subItems=" + this.subItems + ")";
        }

        public final Animation getAnimation() {
            return this.animation;
        }

        public final Entrance getEntrance() {
            return this.entrance;
        }

        public final List<ECCommonCard> getItems() {
            return this.items;
        }

        public final List<ECCommonCard> getMarketingItems() {
            return this.marketingItems;
        }

        public final List<ECCommonCard> getSubItems() {
            return this.subItems;
        }

        public Data(Entrance r100, List<ECCommonCard> r101, Animation r102, List<ECCommonCard> r103, List<ECCommonCard> r104) {
            this.entrance = r100;
            this.items = r101;
            this.animation = r102;
            this.marketingItems = r103;
            this.subItems = r104;
        }

        public /* synthetic */ Data(Entrance r100, List r101, Animation r102, List r103, List r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            Entrance r112 = null;
        L7:
            if ((r110 & 2) == 0) goto L9;
            List r105 = null;
        L11:
            if ((r110 & 4) == 0) goto L13;
            Animation r106 = null;
        L15:
            if ((r110 & 8) == 0) goto L17;
            List r107 = null;
        L19:
            if ((r110 & 16) == 0) goto L21;
            List r113 = null;
        L22:
            this(r112, r105, r106, r107, r113);
            return;
        L21:
            r113 = r104;
            goto L22
        L17:
            r107 = r103;
            goto L19
        L13:
            r106 = r102;
            goto L15
        L9:
            r105 = r101;
            goto L11
        L5:
            r112 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "", "vSpan", "", "hSpan", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHSpan", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVSpan", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Layout {

        @SerializedName("hSpan")
        private final Integer hSpan;

        @SerializedName("vSpan")
        private final Integer vSpan;

        /* JADX WARN: Multi-variable type inference failed */
        public Layout() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Layout copy$default(Layout r100, Integer r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.vSpan;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.hSpan;
        L9:
            return r100.copy(r101, r102);
        }

        public final Integer component1() {
            return this.vSpan;
        }

        public final Integer component2() {
            return this.hSpan;
        }

        public final Layout copy(Integer r100, Integer r101) {
            return new Layout(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Layout) == false) goto L10;
            Layout r101 = (Layout) r100;
            if (Intrinsics.areEqual(this.vSpan, r101.vSpan) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.hSpan, r101.hSpan) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.vSpan;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.hSpan;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Layout(vSpan=" + this.vSpan + ", hSpan=" + this.hSpan + ")";
        }

        public final Integer getHSpan() {
            return this.hSpan;
        }

        public final Integer getVSpan() {
            return this.vSpan;
        }

        public Layout(Integer r100, Integer r101) {
            this.vSpan = r100;
            this.hSpan = r101;
        }

        public /* synthetic */ Layout(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "", "requestId", "", "(Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LogExtra {

        @SerializedName("request_id")
        private final String requestId;

        /* JADX WARN: Multi-variable type inference failed */
        public LogExtra() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ LogExtra copy$default(LogExtra r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.requestId;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.requestId;
        }

        public final LogExtra copy(String r100) {
            return new LogExtra(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LogExtra) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.requestId, ((LogExtra) r100).requestId) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.requestId;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "LogExtra(requestId=" + this.requestId + ")";
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public LogExtra(String r100) {
            this.requestId = r100;
        }

        public /* synthetic */ LogExtra(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f170323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f170324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Coupon4Activity f170325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f170326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f170327e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C2560a f170328f;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO$a$a, reason: collision with other inner class name */
        public static final class C2560a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f170329a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f170330b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f170331c;

            public C2560a(long r100, int r101, int r102) {
                this.f170329a = r100;
                this.f170330b = r101;
                this.f170331c = r102;
            }
        }

        public a(int r100, int r101, Coupon4Activity r102, String r103, String r104, C2560a r105) {
            Intrinsics.checkNotNullParameter(r102, AnchorBenefitToast.TYPE_COUPON);
            Intrinsics.checkNotNullParameter(r103, "lottieImg");
            Intrinsics.checkNotNullParameter(r104, "staticImg");
            Intrinsics.checkNotNullParameter(r105, "animConfig");
            this.f170323a = r100;
            this.f170324b = r101;
            this.f170325c = r102;
            this.f170326d = r103;
            this.f170327e = r104;
            this.f170328f = r105;
        }
    }

    public ChannelVO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public static /* synthetic */ ChannelVO copy$default(ChannelVO r110, Layout r111, Object r112, LogExtra r210, String r211, String r212, String r213, String r214, String r215, Object r216, String r217, String r218, String r219, String r310, String r311, Object r312, String r313, String r314, Integer r315, Data r316, Bcm r317, Long r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        Layout r100 = r110.layout;
    L7:
        if ((r319 & 2) == 0) goto L9;
        Object r101 = r110.extra;
    L11:
        if ((r319 & 4) == 0) goto L13;
        LogExtra r102 = r110.logExtra;
    L15:
        if ((r319 & 8) == 0) goto L17;
        String r103 = r110.componentId;
    L19:
        if ((r319 & 16) == 0) goto L21;
        String r104 = r110.moduleId;
    L23:
        if ((r319 & 32) == 0) goto L25;
        String r105 = r110.name;
    L27:
        if ((r319 & 64) == 0) goto L29;
        String r106 = r110.title;
    L31:
        if ((r319 & 128) == 0) goto L33;
        String r107 = r110.subtitle;
    L35:
        if ((r319 & 256) == 0) goto L37;
        Object r113 = r110.icon;
    L39:
        if ((r319 & 512) == 0) goto L41;
        String r114 = r110.link;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        String r115 = r110.resourceId;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        String r116 = r110.bgUrl;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        String r117 = r110.bgUrl1;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        String r118 = r110.bgUrl2;
    L58:
        String r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        Object r119 = r110.fgUrl;
    L62:
        Object r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        String r120 = r110.tagUrl;
    L66:
        String r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        String r121 = r110.tagUrl2;
    L70:
        String r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        Integer r122 = r110.originChannelCardFIndex;
    L74:
        Integer r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        Data r123 = r110.data;
    L78:
        Data r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        Bcm r124 = r110.bcm;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        Long r108 = r110.leftTime;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Layout component1() {
        return this.layout;
    }

    public final String component10() {
        return this.link;
    }

    public final String component11() {
        return this.resourceId;
    }

    public final String component12() {
        return this.bgUrl;
    }

    public final String component13() {
        return this.bgUrl1;
    }

    public final String component14() {
        return this.bgUrl2;
    }

    public final Object component15() {
        return this.fgUrl;
    }

    public final String component16() {
        return this.tagUrl;
    }

    public final String component17() {
        return this.tagUrl2;
    }

    public final Integer component18() {
        return this.originChannelCardFIndex;
    }

    public final Data component19() {
        return this.data;
    }

    public final Object component2() {
        return this.extra;
    }

    public final Bcm component20() {
        return this.bcm;
    }

    public final Long component21() {
        return this.leftTime;
    }

    public final LogExtra component3() {
        return this.logExtra;
    }

    public final String component4() {
        return this.componentId;
    }

    public final String component5() {
        return this.moduleId;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.subtitle;
    }

    public final Object component9() {
        return this.icon;
    }

    public final ChannelVO copy(Layout r210, Object r211, LogExtra r212, String r213, String r214, String r215, String r310, String r311, Object r312, String r313, String r314, String r315, String r316, String r317, Object r318, String r319, String r410, Integer r411, Data r412, Bcm r413, Long r414) {
        return new ChannelVO(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ChannelVO) == false) goto L48;
        ChannelVO r101 = (ChannelVO) r100;
        if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.moduleId, r101.moduleId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.bgUrl, r101.bgUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bgUrl1, r101.bgUrl1) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.bgUrl2, r101.bgUrl2) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.fgUrl, r101.fgUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagUrl, r101.tagUrl) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.tagUrl2, r101.tagUrl2) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.originChannelCardFIndex, r101.originChannelCardFIndex) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.bcm, r101.bcm) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.leftTime, r101.leftTime) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public int hashCode() {
        Layout r100 = this.layout;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.extra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LogExtra r107 = this.logExtra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.componentId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.moduleId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.name;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.title;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.subtitle;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Object r125 = this.icon;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.link;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.resourceId;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.bgUrl;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.bgUrl1;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.bgUrl2;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Object r143 = this.fgUrl;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.tagUrl;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.tagUrl2;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.originChannelCardFIndex;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Data r155 = this.data;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Bcm r158 = this.bcm;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Long r161 = this.leftTime;
        if (r161 == null) goto L86;
        r101 = r161.hashCode();
    L86:
        return r160 + r101;
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ChannelVO(layout=" + this.layout + ", extra=" + this.extra + ", logExtra=" + this.logExtra + ", componentId=" + this.componentId + ", moduleId=" + this.moduleId + ", name=" + this.name + ", title=" + this.title + ", subtitle=" + this.subtitle + ", icon=" + this.icon + ", link=" + this.link + ", resourceId=" + this.resourceId + ", bgUrl=" + this.bgUrl + ", bgUrl1=" + this.bgUrl1 + ", bgUrl2=" + this.bgUrl2 + ", fgUrl=" + this.fgUrl + ", tagUrl=" + this.tagUrl + ", tagUrl2=" + this.tagUrl2 + ", originChannelCardFIndex=" + this.originChannelCardFIndex + ", data=" + this.data + ", bcm=" + this.bcm + ", leftTime=" + this.leftTime + ")";
    }

    public final List<ECLiveStruct> getChannelLives() {
        ArrayList r100 = new ArrayList();
        Data r101 = this.data;
        if (r101 == null) goto L18;
        List<ECCommonCard> r102 = r101.getItems();
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        ECCommonCard r104 = (ECCommonCard) r103.next();
        if (r104 == null) goto L8;
        ECLiveStruct r105 = r104.getLive();
        if (r105 == null) goto L8;
        String r106 = r105.getRoomId();
        String r107 = r105.getStreamData();
        String r108 = r105.getUid();
        String r109 = r105.getTitle();
        Integer r110 = r105.getStatus();
        WysiwygParam r111 = r104.getWysiwygParam();
        if (r111 == null) goto L16;
        String r112 = r111.getItems();
    L17:
        r100.add(new ECLiveStruct(r106, r107, r108, r109, r110, r112));
        goto L8
    L16:
        r112 = null;
    L18:
        return r100;
    }

    public final a getCouponAnimation() {
        Data r100 = this.data;
        a r101 = null;
        if (r100 == null) goto L9;
        List<ECCommonCard> r102 = r100.getMarketingItems();
        if (r102 == null) goto L9;
        ECCommonCard r103 = (ECCommonCard) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L9;
        Coupon4Activity r104 = r103.getCoupon();
    L10:
        Data r105 = this.data;
        if (r105 == null) goto L13;
        Animation r106 = r105.getAnimation();
    L14:
        if (r106 == null) goto L16;
        Integer r107 = r106.getAnimationType();
    L17:
        int r108 = AnimationType.LOTTIE_WITH_INFO.getValue();
        if (r107 != null) goto L21;
    L62:
        return r101;
    L21:
        if (r107.intValue() != r108) goto L62;
        if (r104 == null) goto L62;
        Map<String, String> r109 = r104.getExtra();
        int r110 = 0;
        if (r109 == null) goto L30;
        String r111 = r109.get("coupon_number");
        if (r111 == null) goto L30;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L30;
        int r113 = r112.intValue();
    L32:
        if (r113 <= 1) goto L36;
        String r114 = r106.getLottieUrl1();
        if (r114 == null) goto L38;
    L39:
        String r115 = r114;
    L40:
        Integer r116 = r104.getAmount();
        if (r116 == null) goto L43;
        r110 = r116.intValue();
    L43:
        int r117 = r110 / 100;
        String r118 = b.a(this.fgUrl);
        if (r118 != null) goto L46;
        String r119 = "";
    L47:
        Long r120 = r106.getCarouselPeriod();
        if (r120 == null) goto L50;
        r120.longValue();
    L50:
        Long r121 = r106.getCarouselTimes();
        if (r121 == null) goto L53;
        long r122 = r121.longValue();
    L54:
        Integer r123 = r106.getStartCustomLottieFrame();
        int r124 = -1;
        if (r123 == null) goto L57;
        int r125 = r123.intValue();
    L58:
        Integer r126 = r106.getEndCustomLottieFrame();
        if (r126 == null) goto L61;
        r124 = r126.intValue();
    L61:
        r101 = new a(r117, r113, r104, r115, r119, new a.C2560a(r122, r125, r124));
        goto L62
    L57:
        r125 = -1;
        goto L58
    L53:
        r122 = 1;
        goto L54
    L46:
        r119 = r118;
    L38:
        r115 = "";
        goto L40
    L36:
        r114 = r106.getLottieUrl();
        if (r114 != null) goto L39;
    L30:
        r113 = 0;
        goto L32
    L16:
        r107 = null;
        goto L17
    L13:
        r106 = null;
    L9:
        r104 = null;
        goto L10
    }

    public final int getDisplayType() {
        Data r100 = this.data;
        if (r100 == null) goto L10;
        Data.Entrance r101 = r100.getEntrance();
        if (r101 == null) goto L10;
        Integer r102 = r101.getEntranceDisplayType();
        if (r102 == null) goto L10;
        return r102.intValue();
    L10:
        return EntranceDisplayType.None.getValue();
    }

    public final String getTitleImgUrl() {
        Layout r100 = this.layout;
        if (r100 == null) goto L5;
        Integer r101 = r100.getHSpan();
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 == null) goto L17;
        if (r101.intValue() != 2) goto L17;
        return this.tagUrl;
    L17:
        return this.tagUrl2;
    L9:
        if (r101.intValue() != 4) goto L11;
        return this.bgUrl2;
    L5:
        r101 = null;
        goto L6
    }

    public final Boolean isChannelStatic() {
        String r100 = this.componentId;
        if (r100 == null) goto L15;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L17;
        int r102 = r101.intValue();
        if (200 <= r102) goto L10;
    L12:
        boolean r103 = false;
    L14:
        return Boolean.valueOf(r103);
    L10:
        if (299 < r102) goto L12;
        r103 = true;
        goto L14
    L17:
        return null;
    L15:
        return null;
    }

    public final Bcm getBcm() {
        return this.bcm;
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getBgUrl1() {
        return this.bgUrl1;
    }

    public final String getBgUrl2() {
        return this.bgUrl2;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final Data getData() {
        return this.data;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final Object getFgUrl() {
        return this.fgUrl;
    }

    public final Object getIcon() {
        return this.icon;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final Long getLeftTime() {
        return this.leftTime;
    }

    public final String getLink() {
        return this.link;
    }

    public final LogExtra getLogExtra() {
        return this.logExtra;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOriginChannelCardFIndex() {
        return this.originChannelCardFIndex;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTagUrl() {
        return this.tagUrl;
    }

    public final String getTagUrl2() {
        return this.tagUrl2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getItemImageUrl(int r100) {
        if (r100 >= 0) goto L6;
        return null;
    L6:
        if (getDisplayType() != EntranceDisplayType.StaticEntrance.getValue()) goto L16;
        if (r100 != 0) goto L9;
        Object r101 = this.icon;
        if (r101 != null) goto L15;
        return null;
    L15:
        return b.a(r101);
    L9:
        if (r100 == 1) goto L43;
        return null;
    L43:
        return this.bgUrl2;
    L16:
        Data r102 = this.data;
        if (r102 == null) goto L21;
        List<ECCommonCard> r103 = r102.getItems();
        if (r103 == null) goto L21;
        ECCommonCard r104 = (ECCommonCard) CollectionsKt.getOrNull(r103, r100);
    L22:
        if (r104 == null) goto L24;
        Integer r105 = r104.getType();
    L25:
        int r106 = ECCommonCardType.PRODUCT.getValue();
        if (r105 != null) goto L29;
    L33:
        int r107 = ECCommonCardType.LIVE.getValue();
        if (r105 == null) goto L42;
        if (r105.intValue() != r107) goto L42;
        ECUserStruct r108 = r104.getUser();
        if (r108 != null) goto L49;
        return null;
    L49:
        return r108.getAvatarUrl();
    L42:
        return b.a(this.icon);
    L29:
        if (r105.intValue() != r106) goto L33;
        ECProductStruct r109 = r104.getProduct();
        if (r109 != null) goto L47;
        return null;
    L47:
        return r109.getCoverUrl();
    L24:
        r105 = null;
    L21:
        r104 = null;
        goto L22
    }

    public final String getItemPrice(int r100) {
        if (showItemPrice(r100) == false) goto L14;
        Data r101 = this.data;
        if (r101 == null) goto L15;
        Data.Entrance r102 = r101.getEntrance();
        if (r102 == null) goto L16;
        List<Data.EntrancePit> r103 = r102.getEntranceContentFormat();
        if (r103 == null) goto L17;
        Data.EntrancePit r104 = (Data.EntrancePit) CollectionsKt.getOrNull(r103, r100);
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.getContent();
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public final String getItemPriceOrTag(int r100) {
        Data r101 = this.data;
        if (r101 == null) goto L11;
        Data.Entrance r102 = r101.getEntrance();
        if (r102 == null) goto L11;
        List<Data.EntrancePit> r103 = r102.getEntranceContentFormat();
        if (r103 == null) goto L11;
        Data.EntrancePit r104 = (Data.EntrancePit) CollectionsKt.getOrNull(r103, r100);
        if (r104 == null) goto L11;
        return r104.getContent();
    L11:
        return null;
    }

    public final String getItemTag(int r100) {
        if (showItemTag(r100) == false) goto L14;
        Data r101 = this.data;
        if (r101 == null) goto L15;
        Data.Entrance r102 = r101.getEntrance();
        if (r102 == null) goto L16;
        List<Data.EntrancePit> r103 = r102.getEntranceContentFormat();
        if (r103 == null) goto L17;
        Data.EntrancePit r104 = (Data.EntrancePit) CollectionsKt.getOrNull(r103, r100);
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.getContent();
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public final String getNoticeName(int r100) {
        Data r101 = this.data;
        Integer r102 = null;
        if (r101 == null) goto L5;
        Data.Entrance r103 = r101.getEntrance();
    L6:
        if (r103 == null) goto L10;
        List<Data.EntrancePit> r104 = r103.getEntranceContentFormat();
        if (r104 == null) goto L10;
        Data.EntrancePit r105 = (Data.EntrancePit) CollectionsKt.getOrNull(r104, r100);
    L12:
        if (Intrinsics.areEqual(this.componentId, ChannelCID.LIVE_SQUARE.getValue()) == true) goto L34;
        if (r105 == null) goto L16;
        r102 = r105.getTagType();
    L16:
        int r106 = EntranceTagType.PlainText.getValue();
        if (r102 != null) goto L20;
    L25:
        int r107 = EntranceTagType.Price.getValue();
        if (r102 != null) goto L29;
        return "";
    L29:
        if (r102.intValue() == r107) goto L31;
        return "";
    L31:
        return "¥" + r105.getContent();
    L20:
        if (r102.intValue() != r106) goto L25;
        String r108 = r105.getContent();
        if (r108 != null) goto L32;
        return "";
    L32:
        return r108;
    L34:
        return "";
    L10:
        r105 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public final boolean showItemPrice(int r100) {
        Data r101 = this.data;
        if (r101 == null) goto L11;
        Data.Entrance r102 = r101.getEntrance();
        if (r102 == null) goto L11;
        List<Data.EntrancePit> r103 = r102.getEntranceContentFormat();
        if (r103 == null) goto L11;
        Data.EntrancePit r104 = (Data.EntrancePit) CollectionsKt.getOrNull(r103, r100);
        if (r104 == null) goto L11;
        Integer r105 = r104.getTagType();
    L12:
        int r106 = EntranceTagType.Price.getValue();
        if (r105 != null) goto L16;
    L18:
        return false;
    L16:
        if (r105.intValue() != r106) goto L18;
        return true;
    L11:
        r105 = null;
        goto L12
    }

    public final boolean showItemTag(int r100) {
        Data r101 = this.data;
        if (r101 == null) goto L11;
        Data.Entrance r102 = r101.getEntrance();
        if (r102 == null) goto L11;
        List<Data.EntrancePit> r103 = r102.getEntranceContentFormat();
        if (r103 == null) goto L11;
        Data.EntrancePit r104 = (Data.EntrancePit) CollectionsKt.getOrNull(r103, r100);
        if (r104 == null) goto L11;
        Integer r105 = r104.getTagType();
    L12:
        int r106 = EntranceTagType.PlainText.getValue();
        if (r105 != null) goto L16;
    L18:
        return false;
    L16:
        if (r105.intValue() != r106) goto L18;
        return true;
    L11:
        r105 = null;
        goto L12
    }

    public ChannelVO(Layout r100, Object r101, LogExtra r102, String r103, String r104, String r105, String r106, String r110, Object r111, String r112, String r113, String r114, String r115, String r116, Object r117, String r118, String r119, Integer r210, Data r211, Bcm r212, Long r213) {
        this.layout = r100;
        this.extra = r101;
        this.logExtra = r102;
        this.componentId = r103;
        this.moduleId = r104;
        this.name = r105;
        this.title = r106;
        this.subtitle = r110;
        this.icon = r111;
        this.link = r112;
        this.resourceId = r113;
        this.bgUrl = r114;
        this.bgUrl1 = r115;
        this.bgUrl2 = r116;
        this.fgUrl = r117;
        this.tagUrl = r118;
        this.tagUrl2 = r119;
        this.originChannelCardFIndex = r210;
        this.data = r211;
        this.bcm = r212;
        this.leftTime = r213;
    }

    public /* synthetic */ ChannelVO(Layout r210, Object r211, LogExtra r212, String r213, String r214, String r215, String r216, String r310, Object r311, String r312, String r313, String r314, String r315, String r316, Object r317, String r318, String r319, Integer r410, Data r411, Bcm r412, Long r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        Layout r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        LogExtra r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        Object r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        Object r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        Integer r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        Data r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        Bcm r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        Long r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
