package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002uvR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u0016R\"\u0010#\u001a\u00020\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010&\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b$\u0010\u0011R\"\u0010*\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u0016R\u001a\u0010-\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\b\u001a\u0004\b+\u0010\fR\u001c\u00102\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\b\u001a\u0004\b/\u00100R\u001a\u00104\u001a\u0002038&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\b\u001a\u0004\b4\u00105R\u001a\u00109\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\b\u001a\u0004\b7\u0010\u001fR\u001a\u0010<\u001a\u0002038&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010\b\u001a\u0004\b:\u00105R(\u0010D\u001a\b\u0012\u0004\u0012\u00020>0=8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bC\u0010\b\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010H\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bG\u0010\b\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u0016R\u001a\u0010K\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\b\u001a\u0004\bI\u0010\u001fR\u001a\u0010N\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\bM\u0010\b\u001a\u0004\bL\u0010\u001fR\u001a\u0010Q\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\bP\u0010\b\u001a\u0004\bO\u0010\u001fR\u001a\u0010T\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\bS\u0010\b\u001a\u0004\bR\u0010\u001fR\u001a\u0010W\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\bV\u0010\b\u001a\u0004\bU\u0010\fR$\u0010\\\u001a\u0004\u0018\u00010.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b[\u0010\b\u001a\u0004\bX\u00100\"\u0004\bY\u0010ZR$\u0010`\u001a\u0004\u0018\u00010.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b_\u0010\b\u001a\u0004\b]\u00100\"\u0004\b^\u0010ZR\"\u0010a\u001a\u0002038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bd\u0010\b\u001a\u0004\ba\u00105\"\u0004\bb\u0010cR$\u0010k\u001a\u0004\u0018\u00010e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bj\u0010\b\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010n\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\bm\u0010\b\u001a\u0004\bl\u0010\u0011R\u001a\u0010q\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\bp\u0010\b\u001a\u0004\bo\u0010\fR\u001a\u0010t\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\bs\u0010\b\u001a\u0004\br\u0010\u0011¨\u0006w"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/b;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getUser$annotations", "()V", "user", "", "getBoxId", "()J", "getBoxId$annotations", "boxId", "", "getBoxIdStr", "()Ljava/lang/String;", "getBoxIdStr$annotations", "boxIdStr", "getSendTime", "setSendTime", "(J)V", "getSendTime$annotations", RemoteMessageConst.SEND_TIME, "getDelayTime", "setDelayTime", "getDelayTime$annotations", "delayTime", "", "getBoxType", "()I", "setBoxType", "(I)V", "getBoxType$annotations", "boxType", "getTitle", "getTitle$annotations", "title", "getDiamondCount", "setDiamondCount", "getDiamondCount$annotations", "diamondCount", "getStyle", "getStyle$annotations", "style", "Lpy/k;", "getBackground", "()Lpy/k;", "getBackground$annotations", "background", "", "isOfficial", "()Z", "isOfficial$annotations", "getPriority", "getPriority$annotations", "priority", "getLarge", "getLarge$annotations", "large", "", "Lcom/bytedance/android/live/profit/redpacket/model/c;", "getDescriptionList", "()Ljava/util/List;", "setDescriptionList", "(Ljava/util/List;)V", "getDescriptionList$annotations", "descriptionList", "getDisplayDuration", "setDisplayDuration", "getDisplayDuration$annotations", "displayDuration", "getBoxStatus", "getBoxStatus$annotations", "boxStatus", "getFlatDuration", "getFlatDuration$annotations", "flatDuration", "getUnpackType", "getUnpackType$annotations", "unpackType", "getRushCondition", "getRushCondition$annotations", "rushCondition", "getBusinessType", "getBusinessType$annotations", "businessType", "getTopCoverImage", "setTopCoverImage", "(Lpy/k;)V", "getTopCoverImage$annotations", "topCoverImage", "getBottomCoverImage", "setBottomCoverImage", "getBottomCoverImage$annotations", "bottomCoverImage", "isRiskyOwner", "setRiskyOwner", "(Z)V", "isRiskyOwner$annotations", "Lcom/bytedance/android/live/profit/redpacket/model/b$b;", "getDressInfo", "()Lcom/bytedance/android/live/profit/redpacket/model/b$b;", "setDressInfo", "(Lcom/bytedance/android/live/profit/redpacket/model/b$b;)V", "getDressInfo$annotations", "dressInfo", "getActivityId", "getActivityId$annotations", "activityId", "getJoinFrozenDuration", "getJoinFrozenDuration$annotations", "joinFrozenDuration", "getBizExtra", "getBizExtra$annotations", "bizExtra", "b", "c", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.redpacket.model.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/b$b;", "Lvh7/c;", "", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "getDressId$annotations", "()V", "dressId", "", "getDressOfflineTime", "()J", "setDressOfflineTime", "(J)V", "getDressOfflineTime$annotations", "dressOfflineTime", "Lcom/bytedance/android/live/profit/redpacket/model/b$c;", "getSameBoxJumpSchema", "()Lcom/bytedance/android/live/profit/redpacket/model/b$c;", "setSameBoxJumpSchema", "(Lcom/bytedance/android/live/profit/redpacket/model/b$c;)V", "getSameBoxJumpSchema$annotations", "sameBoxJumpSchema", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface InterfaceC1362b extends vh7.c<InterfaceC1362b> {

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.redpacket.model.b$b$a */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "dress_id")
        String getDressId();

        @FieldName(name = "dress_offline_time")
        long getDressOfflineTime();

        @FieldName(name = "same_box_jump_schema")
        c getSameBoxJumpSchema();

        @FieldName(name = "dress_id#setter")
        void setDressId(String r100);

        @FieldName(name = "dress_offline_time#setter")
        void setDressOfflineTime(long r100);

        @FieldName(name = "same_box_jump_schema#setter")
        void setSameBoxJumpSchema(c r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/b$c;", "Lvh7/c;", "", "getJumpText", "()Ljava/lang/String;", "setJumpText", "(Ljava/lang/String;)V", "getJumpText$annotations", "()V", "jumpText", "getJumpSchema", "setJumpSchema", "getJumpSchema$annotations", "jumpSchema", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "jump_schema")
        String getJumpSchema();

        @FieldName(name = "jump_text")
        String getJumpText();

        @FieldName(name = "jump_schema#setter")
        void setJumpSchema(String r100);

        @FieldName(name = "jump_text#setter")
        void setJumpText(String r100);
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activity_id")
    String getActivityId();

    @FieldName(name = "background")
    py.k getBackground();

    @FieldName(name = "biz_extra")
    String getBizExtra();

    @FieldName(name = "bottom_cover_image")
    py.k getBottomCoverImage();

    @FieldName(name = "box_id")
    long getBoxId();

    @FieldName(name = "box_id_str")
    String getBoxIdStr();

    @FieldName(name = "box_status")
    int getBoxStatus();

    @FieldName(name = "box_type")
    int getBoxType();

    @FieldName(name = "business_type")
    long getBusinessType();

    @FieldName(name = "delay_time")
    long getDelayTime();

    @FieldName(name = "description_list")
    List<com.bytedance.android.live.profit.redpacket.model.c> getDescriptionList();

    @FieldName(name = "diamond_count")
    long getDiamondCount();

    @FieldName(name = "display_duration")
    long getDisplayDuration();

    @FieldName(name = "dress_info")
    InterfaceC1362b getDressInfo();

    @FieldName(name = "flat_duration")
    int getFlatDuration();

    @FieldName(name = "join_frozen_duration")
    long getJoinFrozenDuration();

    @FieldName(name = "large")
    boolean getLarge();

    @FieldName(name = "priority")
    int getPriority();

    @FieldName(name = "rush_condition")
    int getRushCondition();

    @FieldName(name = "send_time")
    long getSendTime();

    @FieldName(name = "style")
    long getStyle();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "top_cover_image")
    py.k getTopCoverImage();

    @FieldName(name = "unpack_type")
    int getUnpackType();

    @FieldName(name = "user")
    IBaseUser getUser();

    @FieldName(name = "is_official")
    boolean isOfficial();

    @FieldName(name = "is_risky_owner")
    boolean isRiskyOwner();

    @FieldName(name = "bottom_cover_image#setter")
    void setBottomCoverImage(py.k r100);

    @FieldName(name = "box_type#setter")
    void setBoxType(int r100);

    @FieldName(name = "delay_time#setter")
    void setDelayTime(long r100);

    @FieldName(name = "description_list#setter")
    void setDescriptionList(List<? extends com.bytedance.android.live.profit.redpacket.model.c> r100);

    @FieldName(name = "diamond_count#setter")
    void setDiamondCount(long r100);

    @FieldName(name = "display_duration#setter")
    void setDisplayDuration(long r100);

    @FieldName(name = "dress_info#setter")
    void setDressInfo(InterfaceC1362b r100);

    @FieldName(name = "is_risky_owner#setter")
    void setRiskyOwner(boolean r100);

    @FieldName(name = "send_time#setter")
    void setSendTime(long r100);

    @FieldName(name = "top_cover_image#setter")
    void setTopCoverImage(py.k r100);

    @FieldName(name = "user#setter")
    void setUser(IBaseUser r100);
}
