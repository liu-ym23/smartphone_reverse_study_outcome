package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.anchor.GetRoomClipStickerResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/RoomClipStickerData;", "", "()V", "anchorVideoSticker", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;", "getAnchorVideoSticker", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;", "setAnchorVideoSticker", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomClipStickerData implements h {

    @SerializedName("room_clip_sticker")
    protected AnchorVideoSticker anchorVideoSticker;

    public RoomClipStickerData() {
    }

    public RoomClipStickerData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.anchorVideoSticker = new AnchorVideoSticker(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final AnchorVideoSticker getAnchorVideoSticker() {
        return this.anchorVideoSticker;
    }

    public final void setAnchorVideoSticker(AnchorVideoSticker r100) {
        this.anchorVideoSticker = r100;
    }
}
