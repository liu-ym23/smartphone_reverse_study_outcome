package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.GameIntroduceMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/a;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/k;", "mGameIntroduceShowMessage", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/k;", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends ExternalBaseMessage implements vh7.h {

    @SerializedName("game_introduce")
    public com.bytedance.android.gamecp.host_api.model.introducecard.k mGameIntroduceShowMessage;

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return AuthCode.StatusCode.PERMISSION_NOT_EXIST;
    }

    public a() {
        this.mGameIntroduceShowMessage = new com.bytedance.android.gamecp.host_api.model.introducecard.k();
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_GAME_PROMOTE;
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.mGameIntroduceShowMessage = new com.bytedance.android.gamecp.host_api.model.introducecard.k(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.mGameIntroduceShowMessage != null) goto L25;
        this.mGameIntroduceShowMessage = new com.bytedance.android.gamecp.host_api.model.introducecard.k();
        return;
    }
}
