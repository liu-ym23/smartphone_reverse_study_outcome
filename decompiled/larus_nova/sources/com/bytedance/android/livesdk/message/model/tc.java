package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InteractEffectMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/tc;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "effectID", "J", "", "extra", "Ljava/lang/String;", "teaLogParams", "messageType", "arg1", "arg2", "arg3", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class tc extends o0 implements vh7.h {

    @SerializedName("arg1")
    public long arg1;

    @SerializedName("arg2")
    public long arg2;

    @SerializedName("arg3")
    public String arg3;

    @SerializedName(MobConstants.EFFECT_ID)
    public long effectID;

    @SerializedName("extra")
    public String extra;

    @SerializedName("message_type")
    public long messageType;

    @SerializedName(Sticker.TEA_LOG_KEY)
    public String teaLogParams;

    public tc() {
        this.extra = "";
        this.teaLogParams = "";
        this.arg3 = "";
        this.type = MessageType.INTERACT_EFFECT_INFO_UPDATE_MESSAGE;
    }

    public tc(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.arg3 = am3.h.c(r100);
        goto L3
    L8:
        this.arg2 = r100.j();
        goto L3
    L9:
        this.arg1 = r100.j();
        goto L3
    L10:
        this.messageType = r100.j();
        goto L3
    L11:
        this.teaLogParams = am3.h.c(r100);
        goto L3
    L12:
        this.extra = am3.h.c(r100);
        goto L3
    L13:
        this.effectID = r100.j();
        goto L3
    L14:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.extra != null) goto L19;
        this.extra = "";
    L19:
        if (this.teaLogParams != null) goto L22;
        this.teaLogParams = "";
    L22:
        if (this.arg3 != null) goto L24;
        this.arg3 = "";
    L24:
        this.type = MessageType.INTERACT_EFFECT_INFO_UPDATE_MESSAGE;
    }
}
