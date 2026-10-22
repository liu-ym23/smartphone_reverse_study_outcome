package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.RushLuckyBoxResponse.GiftGuide")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILuckyBoxRushResult_GiftGuideFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "Lpy/k;", "giftImage", "Lpy/k;", "getGiftImage", "()Lpy/k;", "setGiftImage", "(Lpy/k;)V", "coinAnimation", "getCoinAnimation", "setCoinAnimation", "", "giftId$delegate", "Ljava/lang/Object;", "getGiftId", "()J", "giftId", "propId$delegate", "getPropId", "propId", "giftCount$delegate", "getGiftCount", "giftCount", "", "giftName$delegate", "getGiftName", "()Ljava/lang/String;", "giftName", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILuckyBoxRushResult_GiftGuideFlexImpl extends FlexModelBase<o1.b> implements o1.b, vh7.h {

    @SerializedName("gift_count")
    protected long _$$giftCount;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long _$$giftId;

    @SerializedName("gift_name")
    protected String _$$giftName;

    @SerializedName("prop_def_id")
    protected long _$$propId;

    @SerializedName("coin_animation")
    protected py.k coinAnimation;

    @SerializedName("gift_image")
    protected py.k giftImage;

    public ILuckyBoxRushResult_GiftGuideFlexImpl() {
        super(o1.b.class);
        this._$$giftName = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1.b
    public py.k getCoinAnimation() {
        return this.coinAnimation;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1.b
    public final long getGiftCount() {
        return this._$$giftCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1.b
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1.b
    public py.k getGiftImage() {
        return this.giftImage;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1.b
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1.b
    public final long getPropId() {
        return this._$$propId;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public ILuckyBoxRushResult_GiftGuideFlexImpl(am3.g r100) {
        super(o1.b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$propId = r100.j();
        goto L3
    L9:
        this.coinAnimation = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        this._$$giftName = am3.h.c(r100);
        goto L3
    L11:
        this.giftImage = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        this._$$giftCount = r100.j();
        goto L3
    L13:
        this._$$giftId = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$giftName != null) goto L34;
        this._$$giftName = "";
        return;
    }

    public void setCoinAnimation(py.k r100) {
        this.coinAnimation = r100;
    }

    public void setGiftImage(py.k r100) {
        this.giftImage = r100;
    }
}
