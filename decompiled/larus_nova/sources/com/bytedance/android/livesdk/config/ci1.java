package com.bytedance.android.livesdk.config;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b%\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/config/ci1;", "", "", "follow", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "atTA", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "report", "o", AnchorBenefitToast.TYPE_COUPON, "d", "redPackage", OfficeSDKRequestTag.KEY_NEW_USER, "ecomRedPacket", "e", "jewelleryBox", RXScreenCaptureService.KEY_INDEX, "comment", "c", PbRequest.SwitchType.GIFT, com.amap.api.col.s.ce.f26391f, "heart", "h", "rankListFollow", "l", "danmuku", "getDanmuku", "liveListCard", "getLiveListCard", "livePopupCard", com.amap.api.col.s.ce.f26395j, "audienceRanklist", "b", PbRequest.SwitchType.RECHARGE, "m", "other", com.amap.api.col.s.ce.f26396k, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ci1 {

    @SerializedName("atTA")
    private final String atTA;

    @SerializedName("audienceRanklist")
    private final String audienceRanklist;

    @SerializedName("comment")
    private final String comment;

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private final String coupon;

    @SerializedName("danmuku")
    private final String danmuku;

    @SerializedName("ecomRedPacket")
    private final String ecomRedPacket;

    @SerializedName("follow")
    private final String follow;

    @SerializedName(PbRequest.SwitchType.GIFT)
    private final String gift;

    @SerializedName("heart")
    private final String heart;

    @SerializedName("jewelleryBox")
    private final String jewelleryBox;

    @SerializedName("live_list_card")
    private final String liveListCard;

    @SerializedName("live_popup_card")
    private final String livePopupCard;

    @SerializedName("other")
    private final String other;

    @SerializedName("rankListFollow")
    private final String rankListFollow;

    @SerializedName(PbRequest.SwitchType.RECHARGE)
    private final String recharge;

    @SerializedName("red_package")
    private final String redPackage;

    @SerializedName("report")
    private final String report;

    public ci1() {
        this(0);
    }

    public final String a() {
        return this.atTA;
    }

    public final String b() {
        return this.audienceRanklist;
    }

    public final String c() {
        return this.comment;
    }

    public final String d() {
        return this.coupon;
    }

    public final String e() {
        return this.ecomRedPacket;
    }

    public final String f() {
        return this.follow;
    }

    public final String g() {
        return this.gift;
    }

    public final String h() {
        return this.heart;
    }

    public final String i() {
        return this.jewelleryBox;
    }

    public final String j() {
        return this.livePopupCard;
    }

    public final String k() {
        return this.other;
    }

    public final String l() {
        return this.rankListFollow;
    }

    public final String m() {
        return this.recharge;
    }

    public final String n() {
        return this.redPackage;
    }

    public final String o() {
        return this.report;
    }

    public ci1(int r100) {
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "follow");
        Intrinsics.checkNotNullParameter("关联抖音后解锁更多功能体验", "atTA");
        Intrinsics.checkNotNullParameter("关联抖音后解锁更多功能体验", "report");
        Intrinsics.checkNotNullParameter("关联抖音领优惠券", AnchorBenefitToast.TYPE_COUPON);
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "redPackage");
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "ecomRedPacket");
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "jewelleryBox");
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "comment");
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", PbRequest.SwitchType.GIFT);
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "heart");
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "rankListFollow");
        Intrinsics.checkNotNullParameter("关联抖音后开启互动", "danmuku");
        Intrinsics.checkNotNullParameter("关联抖音后开始购物", "liveListCard");
        Intrinsics.checkNotNullParameter("关联抖音后开始购物", "livePopupCard");
        Intrinsics.checkNotNullParameter("关联抖音后解锁更多功能体验", "audienceRanklist");
        Intrinsics.checkNotNullParameter("关联抖音后解锁更多功能体验", PbRequest.SwitchType.RECHARGE);
        Intrinsics.checkNotNullParameter("关联抖音后解锁更多功能体验", "other");
        this.follow = "关联抖音后开启互动";
        this.atTA = "关联抖音后解锁更多功能体验";
        this.report = "关联抖音后解锁更多功能体验";
        this.coupon = "关联抖音领优惠券";
        this.redPackage = "关联抖音后开启互动";
        this.ecomRedPacket = "关联抖音后开启互动";
        this.jewelleryBox = "关联抖音后开启互动";
        this.comment = "关联抖音后开启互动";
        this.gift = "关联抖音后开启互动";
        this.heart = "关联抖音后开启互动";
        this.rankListFollow = "关联抖音后开启互动";
        this.danmuku = "关联抖音后开启互动";
        this.liveListCard = "关联抖音后开始购物";
        this.livePopupCard = "关联抖音后开始购物";
        this.audienceRanklist = "关联抖音后解锁更多功能体验";
        this.recharge = "关联抖音后解锁更多功能体验";
        this.other = "关联抖音后解锁更多功能体验";
    }
}
