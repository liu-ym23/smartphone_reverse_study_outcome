package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001;R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R*\u0010\u0012\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010+\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\u0006\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\u0006\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR$\u00103\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\u0006\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R$\u0010:\u001a\u0004\u0018\u0001048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\u0006\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/o1;", "Lvh7/c;", "", "getSucceed", "()Z", "getSucceed$annotations", "()V", "succeed", "getExpired", "getExpired$annotations", AiBotPollingAuthResult.STATUS_EXPIRED, "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "getImage$annotations", "image", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "", "getDiamondCount", "()J", "setDiamondCount", "(J)V", "getDiamondCount$annotations", "diamondCount", "getCashCount", "setCashCount", "getCashCount$annotations", "cashCount", "", "getBoxType", "()I", "setBoxType", "(I)V", "getBoxType$annotations", "boxType", "getGiftId", "setGiftId", "getGiftId$annotations", "giftId", "getGiftName", "setGiftName", "getGiftName$annotations", "giftName", "Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "getGiftGuide", "()Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "setGiftGuide", "(Lcom/bytedance/android/livesdk/chatroom/model/o1$b;)V", "getGiftGuide$annotations", "giftGuide", "b", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o1 extends vh7.c<o1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\"\u0010\u0013\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "Lvh7/c;", "", "getGiftId", "()J", "getGiftId$annotations", "()V", "giftId", "getPropId", "getPropId$annotations", "propId", "getGiftCount", "getGiftCount$annotations", "giftCount", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getGiftImage", "()Lpy/k;", "getGiftImage$annotations", "giftImage", "", "getGiftName", "()Ljava/lang/String;", "getGiftName$annotations", "giftName", "getCoinAnimation", "getCoinAnimation$annotations", "coinAnimation", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "box_type")
    int getBoxType();

    @FieldName(name = "cash_count")
    long getCashCount();

    @FieldName(name = "diamond_count")
    long getDiamondCount();

    @FieldName(name = AiBotPollingAuthResult.STATUS_EXPIRED)
    boolean getExpired();

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
