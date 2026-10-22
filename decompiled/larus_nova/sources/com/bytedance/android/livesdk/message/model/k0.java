package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k0;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;", "data", "Lcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;", "setData", "(Lcom/bytedance/android/livesdk/chatroom/model/BannerInRoomCollection;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k0 extends o0 implements vh7.h {

    @SerializedName("data")
    protected BannerInRoomCollection data;

    public k0() {
        this.type = MessageType.BANNER_UPDATE;
    }

    public final BannerInRoomCollection E() {
        return this.data;
    }

    public k0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.data = com.bytedance.android.livesdk.chatroom.model.e4.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.BANNER_UPDATE;
    }
}
