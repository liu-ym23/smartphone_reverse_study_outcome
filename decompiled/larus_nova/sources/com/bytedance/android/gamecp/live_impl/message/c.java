package com.bytedance.android.gamecp.live_impl.message;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.GameCPBaseMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/c;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/l;", "info", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/l;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/gamecp/host_api/model/introducecard/l;", "setInfo", "(Lcom/bytedance/android/gamecp/host_api/model/introducecard/l;)V", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c extends ExternalBaseMessage implements vh7.h {

    @SerializedName("show_info")
    protected com.bytedance.android.gamecp.host_api.model.introducecard.l info;

    public c() {
    }

    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.info = new com.bytedance.android.gamecp.host_api.model.introducecard.l(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 6001;
    }

    public final com.bytedance.android.gamecp.host_api.model.introducecard.l E() {
        return this.info;
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_GAME_PROMOTE;
    }
}
