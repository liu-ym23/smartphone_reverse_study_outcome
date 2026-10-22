package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0003\u000e\u000f\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/p1;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/chatroom/model/o1;", "Lcom/bytedance/android/livesdk/chatroom/model/p1$c;", "getExpandAward", "()Lcom/bytedance/android/livesdk/chatroom/model/p1$c;", "getExpandAward$annotations", "()V", "expandAward", "", "getDressId", "()Ljava/lang/String;", "getDressId$annotations", "dressId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "d", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p1 extends vh7.e<o1>, o1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/p1$a;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/p1$d;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getVoucherList", "()Ljava/util/List;", "setVoucherList", "(Ljava/util/List;)V", "getVoucherList$annotations", "()V", "voucherList", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getActivityId$annotations", "activityId", "getVoucherName", "setVoucherName", "getVoucherName$annotations", "voucherName", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.c<a> {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.model.p1$a$a, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C1622a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "activity_id")
        String getActivityId();

        @FieldName(name = "voucher_group")
        List<d> getVoucherList();

        @FieldName(name = "voucher_name")
        String getVoucherName();

        @FieldName(name = "activity_id#setter")
        void setActivityId(String r100);

        @FieldName(name = "voucher_group#setter")
        void setVoucherList(List<? extends d> r100);

        @FieldName(name = "voucher_name#setter")
        void setVoucherName(String r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/p1$c;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/p1$a;", "getCaijingVoucher", "()Lcom/bytedance/android/livesdk/chatroom/model/p1$a;", "setCaijingVoucher", "(Lcom/bytedance/android/livesdk/chatroom/model/p1$a;)V", "getCaijingVoucher$annotations", "()V", "caijingVoucher", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "caijing_voucher")
        a getCaijingVoucher();

        @FieldName(name = "caijing_voucher#setter")
        void setCaijingVoucher(a r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/p1$d;", "Lvh7/c;", "", "getExpireTime", "()J", "getExpireTime$annotations", "()V", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "getFaceValue", "()Ljava/lang/String;", "getFaceValue$annotations", "faceValue", "getUnit", "getUnit$annotations", Scraps.INNER_UNIT, "getTitle", "getTitle$annotations", "title", "getSubTitle", "getSubTitle$annotations", "subTitle", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.c<d> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "valid_end_datetime")
        long getExpireTime();

        @FieldName(name = "face_value")
        String getFaceValue();

        @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
        String getSubTitle();

        @FieldName(name = "title")
        String getTitle();

        @FieldName(name = Scraps.INNER_UNIT)
        String getUnit();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.chatroom.model.o1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "box_type")
    /* synthetic */ int getBoxType();

    @FieldName(name = "cash_count")
    /* synthetic */ long getCashCount();

    @FieldName(name = "diamond_count")
    /* synthetic */ long getDiamondCount();

    @FieldName(name = "dress_id")
    String getDressId();

    @FieldName(name = "expand_award")
    c getExpandAward();

    @FieldName(name = AiBotPollingAuthResult.STATUS_EXPIRED)
    /* synthetic */ boolean getExpired();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "gift_guide")
    /* synthetic */ o1.b getGiftGuide();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    /* synthetic */ long getGiftId();

    @FieldName(name = "gift_name")
    /* synthetic */ String getGiftName();

    @FieldName(name = "image")
    /* synthetic */ py.k getImage();

    @FieldName(name = "succeed")
    /* synthetic */ boolean getSucceed();

    @FieldName(name = "text")
    /* synthetic */ String getText();

    @FieldName(name = "box_type#setter")
    /* synthetic */ void setBoxType(int r100);

    @FieldName(name = "cash_count#setter")
    /* synthetic */ void setCashCount(long r100);

    @FieldName(name = "diamond_count#setter")
    /* synthetic */ void setDiamondCount(long r100);

    @FieldName(name = "gift_guide#setter")
    /* synthetic */ void setGiftGuide(o1.b r100);

    @FieldName(name = "gift_id#setter")
    /* synthetic */ void setGiftId(long r100);

    @FieldName(name = "gift_name#setter")
    /* synthetic */ void setGiftName(String r100);

    @FieldName(name = "image#setter")
    /* synthetic */ void setImage(py.k r100);

    @FieldName(name = "text#setter")
    /* synthetic */ void setText(String r100);
}
