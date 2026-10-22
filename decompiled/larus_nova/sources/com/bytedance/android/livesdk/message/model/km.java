package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.TrafficSceneMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/km;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "number", "Ljava/lang/Long;", "status", "", "icon", "Ljava/lang/String;", "mType", "", "isKeep", "Ljava/lang/Boolean;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class km extends o0 implements vh7.h {

    @SerializedName("icon")
    public String icon;

    @SerializedName("is_keep")
    public Boolean isKeep;

    @SerializedName("type")
    public Long mType;

    @SerializedName("number")
    public Long number;

    @SerializedName("status")
    public Long status;

    public km() {
        this.mType = 0L;
        this.isKeep = Boolean.FALSE;
        this.type = MessageType.TRAFFIC_SCENE_MESSAGE;
    }

    public km(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.isKeep = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.mType = Long.valueOf(r100.j());
        goto L3
    L9:
        this.icon = am3.h.c(r100);
        goto L3
    L10:
        this.status = Long.valueOf(r100.j());
        goto L3
    L11:
        this.number = Long.valueOf(r100.j());
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.mType != null) goto L17;
        this.mType = 0L;
    L17:
        if (this.isKeep != null) goto L19;
        this.isKeep = Boolean.FALSE;
    L19:
        this.type = MessageType.TRAFFIC_SCENE_MESSAGE;
    }
}
