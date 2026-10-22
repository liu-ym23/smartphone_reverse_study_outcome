package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ContentOpenTreasureTouchMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/th;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/sh;", "items", "Ljava/util/List;", "", "eventType", "I", "", WsConstants.KEY_PAYLOAD, "Ljava/lang/String;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class th extends o0 implements vh7.h {

    @SerializedName("event_type")
    public int eventType;

    @SerializedName("items")
    public List<sh> items;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    public String payload;

    public th() {
        this.payload = "";
        this.type = MessageType.OPEN_TREASURE_TOUCH_ENTRANCE_MESSAGE;
    }

    public th(am3.g r100) {
        this.items = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.items.add(new sh(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.eventType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.payload = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.payload != null) goto L21;
        this.payload = "";
    L21:
        this.type = MessageType.OPEN_TREASURE_TOUCH_ENTRANCE_MESSAGE;
    }
}
