package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GameBackgroundImageMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u4;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/y0;", "Lcom/bytedance/android/live/base/model/ImageModel;", "_image", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_image", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_image", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "_changeMs", "Ljava/lang/Long;", "get_changeMs", "()Ljava/lang/Long;", "set_changeMs", "(Ljava/lang/Long;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u4 extends o0 implements com.bytedance.android.live.base.model.message.y0, vh7.h {

    @SerializedName("change_ms")
    protected Long _changeMs;

    @SerializedName("image")
    protected ImageModel _image;

    public u4() {
        this.type = MessageType.GAME_ROOM_BG_MESSAGE;
    }

    @Override // com.bytedance.android.live.base.model.message.y0
    public final py.k getImage() {
        return this._image;
    }

    @Override // com.bytedance.android.live.base.model.message.y0
    public final Long v() {
        return this._changeMs;
    }

    public u4(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._image = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._changeMs = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.GAME_ROOM_BG_MESSAGE;
    }
}
