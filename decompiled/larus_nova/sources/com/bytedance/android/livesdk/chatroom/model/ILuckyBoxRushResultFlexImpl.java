package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.RushLuckyBoxResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R/\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010!\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010%\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R+\u0010,\u001a\u00020&2\u0006\u0010\r\u001a\u00020&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R+\u00100\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R/\u00104\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R/\u0010;\u001a\u0004\u0018\u0001052\b\u0010\r\u001a\u0004\u0018\u0001058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0005\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILuckyBoxRushResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/o1;", "", "succeed$delegate", "Ljava/lang/Object;", "getSucceed", "()Z", "succeed", "expired$delegate", "getExpired", AiBotPollingAuthResult.STATUS_EXPIRED, "Lpy/k;", "<set-?>", "image$delegate", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "", "text$delegate", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "", "diamondCount$delegate", "getDiamondCount", "()J", "setDiamondCount", "(J)V", "diamondCount", "cashCount$delegate", "getCashCount", "setCashCount", "cashCount", "", "boxType$delegate", "getBoxType", "()I", "setBoxType", "(I)V", "boxType", "giftId$delegate", "getGiftId", "setGiftId", "giftId", "giftName$delegate", "getGiftName", "setGiftName", "giftName", "Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "giftGuide$delegate", "getGiftGuide", "()Lcom/bytedance/android/livesdk/chatroom/model/o1$b;", "setGiftGuide", "(Lcom/bytedance/android/livesdk/chatroom/model/o1$b;)V", "giftGuide", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILuckyBoxRushResultFlexImpl extends FlexModelBase<o1> implements o1, vh7.h {

    @SerializedName("box_type")
    protected int _$$boxType;

    @SerializedName("cash_count")
    protected long _$$cashCount;

    @SerializedName("diamond_count")
    protected long _$$diamondCount;

    @SerializedName(AiBotPollingAuthResult.STATUS_EXPIRED)
    protected boolean _$$expired;

    @SerializedName("gift_guide")
    protected o1.b _$$giftGuide;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long _$$giftId;

    @SerializedName("gift_name")
    protected String _$$giftName;

    @SerializedName("image")
    protected py.k _$$image;

    @SerializedName("succeed")
    protected boolean _$$succeed;

    @SerializedName("text")
    protected String _$$text;

    public ILuckyBoxRushResultFlexImpl() {
        super(o1.class);
        this._$$succeed = false;
        this._$$expired = false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final int getBoxType() {
        return this._$$boxType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final long getCashCount() {
        return this._$$cashCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final long getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final boolean getExpired() {
        return this._$$expired;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final o1.b getGiftGuide() {
        return this._$$giftGuide;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final py.k getImage() {
        return this._$$image;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final boolean getSucceed() {
        return this._$$succeed;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final String getText() {
        return this._$$text;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.android.livesdk.chatroom.model.o1$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, py.k] */
    public ILuckyBoxRushResultFlexImpl(am3.g r100) {
        super(o1.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L30;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$succeed = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$expired = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this._$$diamondCount = r100.j();
        r102 = r102 | 4;
        goto L3
    L11:
        if (r103 != 5) goto L13;
        this._$$boxType = r100.i();
        r102 = r102 | 16;
        goto L3
    L13:
        if (r103 != 6) goto L15;
        this._$$image = vh7.f.a(r100, py.k.class);
        goto L3
    L15:
        if (r103 != 7) goto L17;
        this._$$text = am3.h.c(r100);
        goto L3
    L17:
        if (r103 != 15) goto L18;
        this._$$giftGuide = vh7.f.a(r100, o1.b.class);
        goto L3
    L18:
        switch(r103) {
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            default: goto L19;
        };
    L20:
        this._$$giftName = am3.h.c(r100);
        goto L3
    L21:
        this._$$cashCount = r100.j();
        r102 = r102 | 8;
        goto L3
    L22:
        this._$$giftId = r100.j();
        r102 = r102 | 32;
        goto L3
    L19:
        am3.h.d(r104, r100);
        goto L3
    L30:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L34;
        this._$$succeed = false;
    L34:
        if ((r102 & 2) != 0) goto L68;
        this._$$expired = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setBoxType(int r100) {
        this._$$boxType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setCashCount(long r100) {
        this._$$cashCount = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setDiamondCount(long r100) {
        this._$$diamondCount = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setGiftGuide(o1.b r100) {
        this._$$giftGuide = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setGiftId(long r100) {
        this._$$giftId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setGiftName(String r100) {
        this._$$giftName = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setImage(py.k r100) {
        this._$$image = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.o1
    public final void setText(String r100) {
        this._$$text = r100;
    }
}
