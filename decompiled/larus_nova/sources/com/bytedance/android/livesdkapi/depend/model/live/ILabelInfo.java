package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo;", "Lvh7/c;", "", "getLabelType", "()J", "setLabelType", "(J)V", "getLabelType$annotations", "()V", "labelType", "getDisplayType", "getDisplayType$annotations", "displayType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ISpliceLabel;", "getSpliceLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ISpliceLabel;", "getSpliceLabel$annotations", "spliceLabel", "Lpy/k;", "getWholeLabel", "()Lpy/k;", "getWholeLabel$annotations", "wholeLabel", "", "getExtra", "()Ljava/lang/String;", "getExtra$annotations", "extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/IProfilePicSpliceLabel;", "getProfilePicSpliceLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IProfilePicSpliceLabel;", "getProfilePicSpliceLabel$annotations", "profilePicSpliceLabel", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ILabelInfo extends c<ILabelInfo> {
    public static final Companion Companion = null;
    public static final long TYPE_DANCE = 93;
    public static final long TYPE_INSTRUMENT = 94;
    public static final long TYPE_SING = 92;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bB\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0014\u0010 \u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0014\u0010\"\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0014\u0010$\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u0014\u0010&\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0006R\u0014\u0010(\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0014\u0010*\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0014\u0010/\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0014\u00101\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0014\u00103\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0014\u00105\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0014\u00107\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0014\u00109\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0014\u0010;\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0014\u0010@\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0014\u0010B\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0006R\u0014\u0010D\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo$Companion;", "", "()V", "DISPLAY_TYPE_AVATAR_SPLICE", "", "getDISPLAY_TYPE_AVATAR_SPLICE", "()J", "DISPLAY_TYPE_SPLICE", "getDISPLAY_TYPE_SPLICE", "DISPLAY_TYPE_UNKNOWN", "getDISPLAY_TYPE_UNKNOWN", "DISPLAY_TYPE_WHOLE", "getDISPLAY_TYPE_WHOLE", "TYPE_AREA_RANK", "getTYPE_AREA_RANK", "TYPE_AUDIOLINKMIC", "getTYPE_AUDIOLINKMIC", "TYPE_AUDIOLIVE", "getTYPE_AUDIOLIVE", "TYPE_COUPON_EXCHANGE", "getTYPE_COUPON_EXCHANGE", "TYPE_COUPON_EXCHANGE_GET", "getTYPE_COUPON_EXCHANGE_GET", "TYPE_COUPON_EXCHANGE_USE", "getTYPE_COUPON_EXCHANGE_USE", "TYPE_DANCE", "TYPE_ECOM", "getTYPE_ECOM", "TYPE_ECOM_COIN_FEED", "getTYPE_ECOM_COIN_FEED", "TYPE_ECOM_RANK", "getTYPE_ECOM_RANK", "TYPE_ECOM_TREASUREBOX_FEED_GUIDE", "getTYPE_ECOM_TREASUREBOX_FEED_GUIDE", "TYPE_FANS_RED_PACKET", "getTYPE_FANS_RED_PACKET", "TYPE_FOLLOWING", "getTYPE_FOLLOWING", "TYPE_FRIEND", "getTYPE_FRIEND", "TYPE_GAME_PROMOTE", "getTYPE_GAME_PROMOTE", "TYPE_HOME_TOWN", "getTYPE_HOME_TOWN", "TYPE_INSTRUMENT", "TYPE_OFTEN_WATCH", "getTYPE_OFTEN_WATCH", "TYPE_PAID_LIVE_ASSIST", "getTYPE_PAID_LIVE_ASSIST", "TYPE_PK", "getTYPE_PK", "TYPE_QC_RED_PACKET", "getTYPE_QC_RED_PACKET", "TYPE_RECOMMEND_ANONYMOUS_LIVE", "getTYPE_RECOMMEND_ANONYMOUS_LIVE", "TYPE_RECOMMEND_LIVE", "getTYPE_RECOMMEND_LIVE", "TYPE_REDPACKAGE", "getTYPE_REDPACKAGE", "TYPE_SAMECITY", "getTYPE_SAMECITY", "TYPE_SING", "TYPE_UNION_LIVE", "getTYPE_UNION_LIVE", "TYPE_UNKNOWN", "getTYPE_UNKNOWN", "TYPE_WATCHED", "getTYPE_WATCHED", "TYPE_WATCHING", "getTYPE_WATCHING", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final long DISPLAY_TYPE_AVATAR_SPLICE = 0;
        private static final long DISPLAY_TYPE_SPLICE = 0;
        private static final long DISPLAY_TYPE_UNKNOWN = 0;
        private static final long DISPLAY_TYPE_WHOLE = 0;
        private static final long TYPE_AREA_RANK = 0;
        private static final long TYPE_AUDIOLINKMIC = 0;
        private static final long TYPE_AUDIOLIVE = 0;
        private static final long TYPE_COUPON_EXCHANGE = 0;
        private static final long TYPE_COUPON_EXCHANGE_GET = 0;
        private static final long TYPE_COUPON_EXCHANGE_USE = 0;
        public static final long TYPE_DANCE = 93;
        private static final long TYPE_ECOM = 0;
        private static final long TYPE_ECOM_COIN_FEED = 0;
        private static final long TYPE_ECOM_RANK = 0;
        private static final long TYPE_ECOM_TREASUREBOX_FEED_GUIDE = 0;
        private static final long TYPE_FANS_RED_PACKET = 0;
        private static final long TYPE_FOLLOWING = 0;
        private static final long TYPE_FRIEND = 0;
        private static final long TYPE_GAME_PROMOTE = 0;
        private static final long TYPE_HOME_TOWN = 0;
        public static final long TYPE_INSTRUMENT = 94;
        private static final long TYPE_OFTEN_WATCH = 0;
        private static final long TYPE_PAID_LIVE_ASSIST = 0;
        private static final long TYPE_PK = 0;
        private static final long TYPE_QC_RED_PACKET = 0;
        private static final long TYPE_RECOMMEND_ANONYMOUS_LIVE = 0;
        private static final long TYPE_RECOMMEND_LIVE = 0;
        private static final long TYPE_REDPACKAGE = 0;
        private static final long TYPE_SAMECITY = 0;
        public static final long TYPE_SING = 92;
        private static final long TYPE_UNION_LIVE = 0;
        private static final long TYPE_UNKNOWN = 0;
        private static final long TYPE_WATCHED = 0;
        private static final long TYPE_WATCHING = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            TYPE_ECOM = 9;
            TYPE_REDPACKAGE = 20;
            TYPE_AUDIOLIVE = 14;
            TYPE_AUDIOLINKMIC = 12;
            TYPE_PK = 13;
            TYPE_WATCHING = 33;
            TYPE_WATCHED = 34;
            TYPE_ECOM_RANK = 39;
            TYPE_SAMECITY = 36;
            TYPE_FRIEND = 21;
            TYPE_FOLLOWING = 22;
            TYPE_AREA_RANK = 24;
            TYPE_HOME_TOWN = 38;
            TYPE_PAID_LIVE_ASSIST = 46;
            TYPE_RECOMMEND_LIVE = 74;
            TYPE_UNION_LIVE = 83;
            TYPE_FANS_RED_PACKET = 84;
            DISPLAY_TYPE_SPLICE = 1;
            DISPLAY_TYPE_WHOLE = 2;
            DISPLAY_TYPE_AVATAR_SPLICE = 3;
            TYPE_QC_RED_PACKET = 10004;
            TYPE_COUPON_EXCHANGE = AppointmentService.SOURCE_LIVE_END;
            TYPE_COUPON_EXCHANGE_GET = 20001;
            TYPE_COUPON_EXCHANGE_USE = 20002;
            TYPE_GAME_PROMOTE = 257;
            TYPE_ECOM_COIN_FEED = 267;
            TYPE_ECOM_TREASUREBOX_FEED_GUIDE = 20003;
            TYPE_OFTEN_WATCH = 106;
            TYPE_RECOMMEND_ANONYMOUS_LIVE = 113;
        }

        public final long getDISPLAY_TYPE_AVATAR_SPLICE() {
            return DISPLAY_TYPE_AVATAR_SPLICE;
        }

        public final long getDISPLAY_TYPE_SPLICE() {
            return DISPLAY_TYPE_SPLICE;
        }

        public final long getDISPLAY_TYPE_UNKNOWN() {
            return DISPLAY_TYPE_UNKNOWN;
        }

        public final long getDISPLAY_TYPE_WHOLE() {
            return DISPLAY_TYPE_WHOLE;
        }

        public final long getTYPE_AREA_RANK() {
            return TYPE_AREA_RANK;
        }

        public final long getTYPE_AUDIOLINKMIC() {
            return TYPE_AUDIOLINKMIC;
        }

        public final long getTYPE_AUDIOLIVE() {
            return TYPE_AUDIOLIVE;
        }

        public final long getTYPE_COUPON_EXCHANGE() {
            return TYPE_COUPON_EXCHANGE;
        }

        public final long getTYPE_COUPON_EXCHANGE_GET() {
            return TYPE_COUPON_EXCHANGE_GET;
        }

        public final long getTYPE_COUPON_EXCHANGE_USE() {
            return TYPE_COUPON_EXCHANGE_USE;
        }

        public final long getTYPE_ECOM() {
            return TYPE_ECOM;
        }

        public final long getTYPE_ECOM_COIN_FEED() {
            return TYPE_ECOM_COIN_FEED;
        }

        public final long getTYPE_ECOM_RANK() {
            return TYPE_ECOM_RANK;
        }

        public final long getTYPE_ECOM_TREASUREBOX_FEED_GUIDE() {
            return TYPE_ECOM_TREASUREBOX_FEED_GUIDE;
        }

        public final long getTYPE_FANS_RED_PACKET() {
            return TYPE_FANS_RED_PACKET;
        }

        public final long getTYPE_FOLLOWING() {
            return TYPE_FOLLOWING;
        }

        public final long getTYPE_FRIEND() {
            return TYPE_FRIEND;
        }

        public final long getTYPE_GAME_PROMOTE() {
            return TYPE_GAME_PROMOTE;
        }

        public final long getTYPE_HOME_TOWN() {
            return TYPE_HOME_TOWN;
        }

        public final long getTYPE_OFTEN_WATCH() {
            return TYPE_OFTEN_WATCH;
        }

        public final long getTYPE_PAID_LIVE_ASSIST() {
            return TYPE_PAID_LIVE_ASSIST;
        }

        public final long getTYPE_PK() {
            return TYPE_PK;
        }

        public final long getTYPE_QC_RED_PACKET() {
            return TYPE_QC_RED_PACKET;
        }

        public final long getTYPE_RECOMMEND_ANONYMOUS_LIVE() {
            return TYPE_RECOMMEND_ANONYMOUS_LIVE;
        }

        public final long getTYPE_RECOMMEND_LIVE() {
            return TYPE_RECOMMEND_LIVE;
        }

        public final long getTYPE_REDPACKAGE() {
            return TYPE_REDPACKAGE;
        }

        public final long getTYPE_SAMECITY() {
            return TYPE_SAMECITY;
        }

        public final long getTYPE_UNION_LIVE() {
            return TYPE_UNION_LIVE;
        }

        public final long getTYPE_UNKNOWN() {
            return TYPE_UNKNOWN;
        }

        public final long getTYPE_WATCHED() {
            return TYPE_WATCHED;
        }

        public final long getTYPE_WATCHING() {
            return TYPE_WATCHING;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "display_type")
        public static /* synthetic */ void getDisplayType$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "label_type")
        public static /* synthetic */ void getLabelType$annotations() {
        }

        @FieldName(name = "profile_pic_splice_label")
        public static /* synthetic */ void getProfilePicSpliceLabel$annotations() {
        }

        @FieldName(name = "splice_label")
        public static /* synthetic */ void getSpliceLabel$annotations() {
        }

        @FieldName(name = "whole_label")
        public static /* synthetic */ void getWholeLabel$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "display_type")
    long getDisplayType();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "label_type")
    long getLabelType();

    @FieldName(name = "profile_pic_splice_label")
    IProfilePicSpliceLabel getProfilePicSpliceLabel();

    @FieldName(name = "splice_label")
    ISpliceLabel getSpliceLabel();

    @FieldName(name = "whole_label")
    k getWholeLabel();

    @FieldName(name = "label_type#setter")
    void setLabelType(long r100);
}
