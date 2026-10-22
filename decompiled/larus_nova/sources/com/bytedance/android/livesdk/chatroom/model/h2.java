package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.RushLuckyBoxResponse.ResponseData")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b8\u00109R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010$\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/h2;", "", "", "succeed", "Z", "getSucceed", "()Z", "setSucceed", "(Z)V", AiBotPollingAuthResult.STATUS_EXPIRED, "getExpired", "setExpired", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "diamondCount", "I", "getDiamondCount", "()I", "setDiamondCount", "(I)V", "cashCount", "getCashCount", "setCashCount", "boxType", "getBoxType", "setBoxType", "", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "giftName", "getGiftName", "setGiftName", "Lcom/bytedance/android/livesdk/chatroom/model/h2$b;", "giftGuide", "Lcom/bytedance/android/livesdk/chatroom/model/h2$b;", "getGiftGuide", "()Lcom/bytedance/android/livesdk/chatroom/model/h2$b;", "setGiftGuide", "(Lcom/bytedance/android/livesdk/chatroom/model/h2$b;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h2 implements vh7.h {

    @SerializedName("box_type")
    protected int boxType;

    @SerializedName("cash_count")
    protected int cashCount;

    @SerializedName("diamond_count")
    protected int diamondCount;

    @SerializedName(AiBotPollingAuthResult.STATUS_EXPIRED)
    protected boolean expired;

    @SerializedName("gift_guide")
    protected b giftGuide;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long giftId;

    @SerializedName("gift_name")
    protected String giftName;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("succeed")
    protected boolean succeed;

    @SerializedName("text")
    protected String text;

    public static final class a {
    }

    @ProtoMessage("webcast.api.luckybox.RushLuckyBoxResponse.GiftGuide")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/h2$b;", "", "", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "propId", "getPropId", "setPropId", "giftCount", "getGiftCount", "setGiftCount", "Lcom/bytedance/android/live/base/model/ImageModel;", "giftImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "getGiftImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setGiftImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "mGiftName", "Ljava/lang/String;", "coinAnimation", "getCoinAnimation", "setCoinAnimation", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("coin_animation")
        protected ImageModel coinAnimation;

        @SerializedName("gift_count")
        protected long giftCount;

        @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
        protected long giftId;

        @SerializedName("gift_image")
        protected ImageModel giftImage;

        @SerializedName("gift_name")
        protected String mGiftName;

        @SerializedName("prop_def_id")
        protected long propId;

        public b() {
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            switch(r102) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.propId = r100.j();
            goto L3
        L8:
            this.coinAnimation = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L9:
            this.mGiftName = am3.h.c(r100);
            goto L3
        L10:
            this.giftImage = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L11:
            this.giftCount = r100.j();
            goto L3
        L12:
            this.giftId = r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L13:
            r100.d(r101);
        }
    }

    static {
    }

    public h2() {
    }

    public h2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L31;
        if (r102 != 1) goto L8;
        this.succeed = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.expired = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.diamondCount = (int) r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.boxType = r100.i();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.image = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L16:
        if (r102 != 7) goto L18;
        this.text = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 15) goto L19;
        this.giftGuide = new b(r100);
        goto L3
    L19:
        switch(r102) {
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            default: goto L20;
        };
    L21:
        this.giftName = am3.h.c(r100);
        goto L3
    L22:
        this.cashCount = (int) r100.j();
        goto L3
    L23:
        this.giftId = r100.j();
        goto L3
    L20:
        am3.h.e(r100);
        goto L3
    L31:
        r100.d(r101);
    }
}
