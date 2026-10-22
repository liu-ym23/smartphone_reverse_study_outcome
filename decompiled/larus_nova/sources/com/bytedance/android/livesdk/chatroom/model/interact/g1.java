package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0017R\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\u0006\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/g1;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOrderUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOrderUser$annotations", "()V", "orderUser", "getGiftSender", "getGiftSender$annotations", "giftSender", "", "getItemId", "()Ljava/lang/String;", "getItemId$annotations", "itemId", "", "getMicrophoneType", "()I", "getMicrophoneType$annotations", "microphoneType", "", "getGiftId", "()J", "getGiftId$annotations", "giftId", "getGiftDiamondCount", "getGiftDiamondCount$annotations", "giftDiamondCount", "Lpy/k;", "getOrderSingGiftIcon", "()Lpy/k;", "getOrderSingGiftIcon$annotations", "orderSingGiftIcon", "getGiftType", "()Ljava/lang/Integer;", "setGiftType", "(Ljava/lang/Integer;)V", "getGiftType$annotations", "giftType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g1 extends vh7.c<g1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "gift_diamond_count")
    long getGiftDiamondCount();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "gift_sender")
    IBaseUser getGiftSender();

    @FieldName(name = "gift_type")
    Integer getGiftType();

    @FieldName(name = "item_id")
    String getItemId();

    @FieldName(name = "microphone_type")
    int getMicrophoneType();

    @FieldName(name = "order_sing_gift_icon")
    py.k getOrderSingGiftIcon();

    @FieldName(name = "order_user")
    IBaseUser getOrderUser();

    @FieldName(name = "gift_type#setter")
    void setGiftType(Integer r100);
}
