package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0005\n\u000b\f\r\u000eR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/n1$e;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getReceiveInfo", "()Ljava/util/List;", "getReceiveInfo$annotations", "()V", "receiveInfo", "b", "c", "d", "e", "f", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n1 extends vh7.c<n1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\"\u0010\u0013\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n1$b;", "Lvh7/c;", "", "getGiftId", "()J", "getGiftId$annotations", "()V", "giftId", "getPropId", "getPropId$annotations", "propId", "getGiftCount", "getGiftCount$annotations", "giftCount", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getGiftImage", "()Lpy/k;", "getGiftImage$annotations", "giftImage", "", "getGiftName", "()Ljava/lang/String;", "getGiftName$annotations", "giftName", "getCoinAnimation", "getCoinAnimation$annotations", "coinAnimation", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "coin_animation")
        py.k getCoinAnimation();

        @FieldName(name = "gift_count")
        long getGiftCount();

        @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
        long getGiftId();

        @FieldName(name = "gift_image")
        py.k getGiftImage();

        @FieldName(name = "gift_name")
        String getGiftName();

        @FieldName(name = "prop_def_id")
        long getPropId();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n1$c;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/n1$f;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getVoucherList", "()Ljava/util/List;", "setVoucherList", "(Ljava/util/List;)V", "getVoucherList$annotations", "()V", "voucherList", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getActivityId$annotations", "activityId", "getVoucherName", "setVoucherName", "getVoucherName$annotations", "voucherName", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "activity_id")
        String getActivityId();

        @FieldName(name = "voucher_group")
        List<f> getVoucherList();

        @FieldName(name = "voucher_name")
        String getVoucherName();

        @FieldName(name = "activity_id#setter")
        void setActivityId(String r100);

        @FieldName(name = "voucher_group#setter")
        void setVoucherList(List<? extends f> r100);

        @FieldName(name = "voucher_name#setter")
        void setVoucherName(String r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n1$d;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/n1$c;", "getCaijingVoucher", "()Lcom/bytedance/android/livesdk/chatroom/model/n1$c;", "setCaijingVoucher", "(Lcom/bytedance/android/livesdk/chatroom/model/n1$c;)V", "getCaijingVoucher$annotations", "()V", "caijingVoucher", "", "getExtraAward", "()Ljava/lang/String;", "setExtraAward", "(Ljava/lang/String;)V", "getExtraAward$annotations", "extraAward", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.c<d> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "caijing_voucher")
        c getCaijingVoucher();

        @FieldName(name = "extra_award")
        String getExtraAward();

        @FieldName(name = "caijing_voucher#setter")
        void setCaijingVoucher(c r100);

        @FieldName(name = "extra_award#setter")
        void setExtraAward(String r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\u001bR*\u0010)\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0006\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\u0006\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010,R\"\u00102\u001a\u00020\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\u0006\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\u001bR$\u00106\u001a\u0004\u0018\u00010\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u0006\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010,R$\u0010=\u001a\u0004\u0018\u0001078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\u0006\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010B\u001a\u0004\u0018\u00010>8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\b?\u0010@R\u001c\u0010G\u001a\u0004\u0018\u00010C8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0006\u001a\u0004\bD\u0010ER\u001c\u0010J\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0006\u001a\u0004\bH\u0010\u000f¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n1$e;", "Lvh7/c;", "", "getSucceed", "()Z", "getSucceed$annotations", "()V", "succeed", "", "getBoxId", "()J", "getBoxId$annotations", "boxId", "", "getBoxIdStr", "()Ljava/lang/String;", "getBoxIdStr$annotations", "boxIdStr", "", "getBoxType", "()I", "setBoxType", "(I)V", "getBoxType$annotations", "boxType", "getDiamondCount", "setDiamondCount", "(J)V", "getDiamondCount$annotations", "diamondCount", "getGiftId", "setGiftId", "getGiftId$annotations", "giftId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "getImage$annotations", "image", "getText", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "getCashCount", "setCashCount", "getCashCount$annotations", "cashCount", "getGiftName", "setGiftName", "getGiftName$annotations", "giftName", "Lcom/bytedance/android/livesdk/chatroom/model/n1$b;", "getGiftGuide", "()Lcom/bytedance/android/livesdk/chatroom/model/n1$b;", "setGiftGuide", "(Lcom/bytedance/android/livesdk/chatroom/model/n1$b;)V", "getGiftGuide$annotations", "giftGuide", "Lcom/bytedance/android/livesdk/chatroom/model/n1$d;", "getExpandAward", "()Lcom/bytedance/android/livesdk/chatroom/model/n1$d;", "getExpandAward$annotations", "expandAward", "Lcom/bytedance/android/livesdk/chatroom/model/m1;", "getBonus", "()Lcom/bytedance/android/livesdk/chatroom/model/m1;", "getBonus$annotations", "bonus", "getBizExtra", "getBizExtra$annotations", "bizExtra", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface e extends vh7.c<e> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "biz_extra")
        String getBizExtra();

        @FieldName(name = "bonus")
        m1 getBonus();

        @FieldName(name = "box_id")
        long getBoxId();

        @FieldName(name = "box_id_str")
        String getBoxIdStr();

        @FieldName(name = "box_type")
        int getBoxType();

        @FieldName(name = "cash_count")
        long getCashCount();

        @FieldName(name = "diamond_count")
        long getDiamondCount();

        @FieldName(name = "expand_award")
        d getExpandAward();

        @FieldName(name = "gift_guide")
        b getGiftGuide();

        @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
        long getGiftId();

        @FieldName(name = "gift_name")
        String getGiftName();

        @FieldName(name = "image")
        py.k getImage();

        @FieldName(name = "succeed")
        boolean getSucceed();

        @FieldName(name = "text")
        String getText();

        @FieldName(name = "box_type#setter")
        void setBoxType(int r100);

        @FieldName(name = "cash_count#setter")
        void setCashCount(long r100);

        @FieldName(name = "diamond_count#setter")
        void setDiamondCount(long r100);

        @FieldName(name = "gift_guide#setter")
        void setGiftGuide(b r100);

        @FieldName(name = "gift_id#setter")
        void setGiftId(long r100);

        @FieldName(name = "gift_name#setter")
        void setGiftName(String r100);

        @FieldName(name = "image#setter")
        void setImage(py.k r100);

        @FieldName(name = "text#setter")
        void setText(String r100);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n1$f;", "Lvh7/c;", "", "getExpireTime", "()J", "getExpireTime$annotations", "()V", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "getFaceValue", "()Ljava/lang/String;", "getFaceValue$annotations", "faceValue", "getUnit", "getUnit$annotations", Scraps.INNER_UNIT, "getTitle", "getTitle$annotations", "title", "getSubTitle", "getSubTitle$annotations", "subTitle", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface f extends vh7.c<f> {

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

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "receive_info")
    List<e> getReceiveInfo();
}
