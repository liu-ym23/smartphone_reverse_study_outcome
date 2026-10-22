package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u000bR\"\u0010#\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/gk;", "Lcom/bytedance/android/livesdkapi/message/IRoomMessageGiftExtra;", "", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "", "giftName", "Ljava/lang/String;", "giftCount", "Ljava/lang/Long;", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "webpImage", "getWebpImage", "setWebpImage", "groupId", "getGroupId", "setGroupId", "", "clientGiftSource", "I", "getClientGiftSource", "()I", "setClientGiftSource", "(I)V", "describe", "diamondCount", "getDiamondCount", "setDiamondCount", "toUserId", "getToUserId", "()Ljava/lang/String;", "setToUserId", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gk implements IRoomMessageGiftExtra, vh7.h {

    @SerializedName("client_gift_source")
    protected int clientGiftSource;

    @SerializedName("describe")
    public String describe;

    @SerializedName("diamond_count")
    protected int diamondCount;

    @SerializedName("gift_count")
    public Long giftCount;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long giftId;

    @SerializedName("gift_name")
    public String giftName;

    @SerializedName("group_id")
    protected long groupId;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    protected String toUserId;

    @SerializedName("webp_image")
    protected ImageModel webpImage;

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final Integer getClientGiftSource() {
        return Integer.valueOf(this.clientGiftSource);
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final Integer getDiamondCount() {
        return Integer.valueOf(this.diamondCount);
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final String getGiftCount() {
        Long r100 = this.giftCount;
        if (r100 != null) goto L7;
        return null;
    L7:
        return String.valueOf(r100.longValue());
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final Long getGiftId() {
        return Long.valueOf(this.giftId);
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final Long getGroupId() {
        return Long.valueOf(this.groupId);
    }

    public gk() {
        this.toUserId = "";
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final String getDescribe() {
        return this.describe;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final String getGiftName() {
        return this.giftName;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final py.k getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final String getToUserIdString() {
        return this.toUserId;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra
    public final py.k getWebpImage() {
        return this.webpImage;
    }

    public gk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.toUserId = am3.h.c(r100);
        goto L3
    L8:
        this.diamondCount = (int) r100.j();
        goto L3
    L9:
        this.describe = am3.h.c(r100);
        goto L3
    L10:
        this.clientGiftSource = r100.i();
        goto L3
    L11:
        this.groupId = r100.j();
        goto L3
    L12:
        this.webpImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L13:
        this.image = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        this.giftCount = Long.valueOf(r100.j());
        goto L3
    L15:
        this.giftName = am3.h.c(r100);
        goto L3
    L16:
        this.giftId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.toUserId != null) goto L45;
        this.toUserId = "";
        return;
    }
}
