package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GameCardMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/oh;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/w4;", "gameCardInfo", "Lcom/bytedance/android/livesdk/message/model/w4;", "", "appId", "Ljava/lang/String;", "startId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class oh extends o0 implements vh7.h {

    @SerializedName("app_id")
    public String appId;

    @SerializedName(BrowserDependency.UrlClickType.CARD)
    public w4 gameCardInfo;

    @SerializedName("start_id")
    public String startId;

    public oh() {
        this.type = MessageType.OPEN_PLATFORM_GAME_CARD_MESSAGE;
    }

    public oh(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameCardInfo = new w4(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.appId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.startId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.OPEN_PLATFORM_GAME_CARD_MESSAGE;
    }
}
