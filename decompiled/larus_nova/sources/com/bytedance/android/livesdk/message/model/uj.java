package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomBackgroundMessage")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/uj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/z3;", "Lcom/bytedance/android/live/base/model/ImageModel;", "roomBackground", "Lcom/bytedance/android/live/base/model/ImageModel;", "getRoomBackground", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setRoomBackground", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class uj extends o0 implements com.bytedance.android.live.base.model.message.z3, vh7.h {

    @SerializedName("room_background")
    protected ImageModel roomBackground;

    public uj() {
        this.type = MessageType.ROOM_BG_MESSAGE;
    }

    @Override // com.bytedance.android.live.base.model.message.z3
    public final py.k getRoomBackground() {
        return this.roomBackground;
    }

    public uj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.roomBackground = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.ROOM_BG_MESSAGE;
    }
}
