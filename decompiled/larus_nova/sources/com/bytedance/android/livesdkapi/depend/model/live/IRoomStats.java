package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001OR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010 \u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R$\u0010'\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010+\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R$\u0010/\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R$\u00103\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R$\u00107\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\b\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R$\u0010;\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\b\u001a\u0004\b8\u0010#\"\u0004\b9\u0010%R\"\u0010?\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\b\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R$\u0010C\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bB\u0010\b\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R$\u0010G\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bF\u0010\b\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R$\u0010N\u001a\u0004\u0018\u00010H8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\b\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "Lvh7/c;", "", "getId", "()J", "setId", "(J)V", "getId$annotations", "()V", "id", "getTicket", "setTicket", "getTicket$annotations", "ticket", "getMoney", "setMoney", "getMoney$annotations", "money", "", "getTotalUser", "()I", "setTotalUser", "(I)V", "getTotalUser$annotations", "totalUser", "getFollowCount", "setFollowCount", "getFollowCount$annotations", "followCount", "getGiftUVCount", "setGiftUVCount", "getGiftUVCount$annotations", "giftUVCount", "", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "getIdStr$annotations", "idStr", "getEnterCount", "setEnterCount", "getEnterCount$annotations", "enterCount", "getTotalUserDesp", "setTotalUserDesp", "getTotalUserDesp$annotations", "totalUserDesp", "getDouPlusPromotion", "setDouPlusPromotion", "getDouPlusPromotion$annotations", "douPlusPromotion", "getTotalUserStr", "setTotalUserStr", "getTotalUserStr$annotations", "totalUserStr", "getUserCountStr", "setUserCountStr", "getUserCountStr$annotations", "userCountStr", "getCommentCount", "setCommentCount", "getCommentCount$annotations", "commentCount", "getTopRightStr", "setTopRightStr", "getTopRightStr$annotations", "topRightStr", "getTopRightStrComplete", "setTopRightStrComplete", "getTopRightStrComplete$annotations", "topRightStrComplete", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "getUserComposition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "setUserComposition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;)V", "getUserComposition$annotations", "userComposition", "IUserComposition", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomStats extends c<IRoomStats> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "comment_count")
        public static /* synthetic */ void getCommentCount$annotations() {
        }

        @FieldName(name = "dou_plus_promotion")
        public static /* synthetic */ void getDouPlusPromotion$annotations() {
        }

        @FieldName(name = a.KEY_ENTER_COUNT)
        public static /* synthetic */ void getEnterCount$annotations() {
        }

        @FieldName(name = "follow_count")
        public static /* synthetic */ void getFollowCount$annotations() {
        }

        @FieldName(name = "gift_uv_count")
        public static /* synthetic */ void getGiftUVCount$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "id_str")
        public static /* synthetic */ void getIdStr$annotations() {
        }

        @FieldName(name = "money")
        public static /* synthetic */ void getMoney$annotations() {
        }

        @FieldName(name = "fan_ticket")
        public static /* synthetic */ void getTicket$annotations() {
        }

        @FieldName(name = "up_right_stats_str")
        public static /* synthetic */ void getTopRightStr$annotations() {
        }

        @FieldName(name = "up_right_stats_str_complete")
        public static /* synthetic */ void getTopRightStrComplete$annotations() {
        }

        @FieldName(name = "total_user")
        public static /* synthetic */ void getTotalUser$annotations() {
        }

        @FieldName(name = "total_user_desp")
        public static /* synthetic */ void getTotalUserDesp$annotations() {
        }

        @FieldName(name = "total_user_str")
        public static /* synthetic */ void getTotalUserStr$annotations() {
        }

        @FieldName(name = "user_count_composition")
        public static /* synthetic */ void getUserComposition$annotations() {
        }

        @FieldName(name = "user_count_str")
        public static /* synthetic */ void getUserCountStr$annotations() {
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "Lvh7/c;", "", "getCity", "()D", "getCity$annotations", "()V", "city", "getVideo", "getVideo$annotations", "video", "getFollow", "getFollow$annotations", "follow", "getOther", "getOther$annotations", "other", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface IUserComposition extends c<IUserComposition> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = "city")
            public static /* synthetic */ void getCity$annotations() {
            }

            @FieldName(name = "my_follow")
            public static /* synthetic */ void getFollow$annotations() {
            }

            @FieldName(name = "other")
            public static /* synthetic */ void getOther$annotations() {
            }

            @FieldName(name = "video_detail")
            public static /* synthetic */ void getVideo$annotations() {
            }
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "city")
        double getCity();

        @FieldName(name = "my_follow")
        double getFollow();

        @FieldName(name = "other")
        double getOther();

        @FieldName(name = "video_detail")
        double getVideo();
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "comment_count")
    int getCommentCount();

    @FieldName(name = "dou_plus_promotion")
    String getDouPlusPromotion();

    @FieldName(name = a.KEY_ENTER_COUNT)
    int getEnterCount();

    @FieldName(name = "follow_count")
    int getFollowCount();

    @FieldName(name = "gift_uv_count")
    int getGiftUVCount();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "id_str")
    String getIdStr();

    @FieldName(name = "money")
    long getMoney();

    @FieldName(name = "fan_ticket")
    long getTicket();

    @FieldName(name = "up_right_stats_str")
    String getTopRightStr();

    @FieldName(name = "up_right_stats_str_complete")
    String getTopRightStrComplete();

    @FieldName(name = "total_user")
    int getTotalUser();

    @FieldName(name = "total_user_desp")
    String getTotalUserDesp();

    @FieldName(name = "total_user_str")
    String getTotalUserStr();

    @FieldName(name = "user_count_composition")
    IUserComposition getUserComposition();

    @FieldName(name = "user_count_str")
    String getUserCountStr();

    @FieldName(name = "comment_count#setter")
    void setCommentCount(int r100);

    @FieldName(name = "dou_plus_promotion#setter")
    void setDouPlusPromotion(String r100);

    @FieldName(name = "enter_count#setter")
    void setEnterCount(int r100);

    @FieldName(name = "follow_count#setter")
    void setFollowCount(int r100);

    @FieldName(name = "gift_uv_count#setter")
    void setGiftUVCount(int r100);

    @FieldName(name = "id#setter")
    void setId(long r100);

    @FieldName(name = "id_str#setter")
    void setIdStr(String r100);

    @FieldName(name = "money#setter")
    void setMoney(long r100);

    @FieldName(name = "fan_ticket#setter")
    void setTicket(long r100);

    @FieldName(name = "up_right_stats_str#setter")
    void setTopRightStr(String r100);

    @FieldName(name = "up_right_stats_str_complete#setter")
    void setTopRightStrComplete(String r100);

    @FieldName(name = "total_user#setter")
    void setTotalUser(int r100);

    @FieldName(name = "total_user_desp#setter")
    void setTotalUserDesp(String r100);

    @FieldName(name = "total_user_str#setter")
    void setTotalUserStr(String r100);

    @FieldName(name = "user_count_composition#setter")
    void setUserComposition(IUserComposition r100);

    @FieldName(name = "user_count_str#setter")
    void setUserCountStr(String r100);
}
