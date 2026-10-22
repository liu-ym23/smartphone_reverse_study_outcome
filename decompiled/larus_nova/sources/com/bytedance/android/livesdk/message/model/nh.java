package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated(message = "已废弃，直播间挂载IM消息见ShelfInfo")
@ProtoMessage("webcast.im.CustomizedCardMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/nh;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "appId", "Ljava/lang/String;", "startId", "Lcom/bytedance/android/livesdk/message/model/v1;", BrowserDependency.UrlClickType.CARD, "Lcom/bytedance/android/livesdk/message/model/v1;", "", "sceneSource", "Ljava/lang/Integer;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class nh extends o0 implements vh7.h {

    @SerializedName("app_id")
    public String appId;

    @SerializedName(BrowserDependency.UrlClickType.CARD)
    public v1 card;

    @SerializedName("scene_source")
    public Integer sceneSource;

    @SerializedName("start_id")
    public String startId;

    public nh() {
        this.type = MessageType.OPEN_PLATFORM_CARD_MESSAGE;
    }

    public nh(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.card = new v1(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.appId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.startId = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.sceneSource = Integer.valueOf(r100.i());
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.OPEN_PLATFORM_CARD_MESSAGE;
    }
}
