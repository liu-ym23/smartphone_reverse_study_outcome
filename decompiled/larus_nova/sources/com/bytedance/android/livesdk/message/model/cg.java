package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.MagicGestureActivityMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "", "effectId", "Ljava/lang/String;", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "setActionType", "actionSchema", "getActionSchema", "setActionSchema", "bizId", "getBizId", "setBizId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class cg extends o0 implements vh7.h {

    @SerializedName("action_schema")
    protected String actionSchema;

    @SerializedName("action_type")
    protected int actionType;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    protected String bizId;

    @SerializedName(MobConstants.EFFECT_ID)
    protected String effectId;

    @SerializedName("status")
    protected int status;

    public cg() {
        this.type = MessageType.MAGIC_GESTURE_ACTIVITY_MESSAGE;
    }

    public cg(am3.g r100) {
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
        this.bizId = am3.h.c(r100);
        goto L3
    L8:
        this.actionSchema = am3.h.c(r100);
        goto L3
    L9:
        this.actionType = r100.i();
        goto L3
    L10:
        this.effectId = am3.h.c(r100);
        goto L3
    L11:
        this.status = r100.i();
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.MAGIC_GESTURE_ACTIVITY_MESSAGE;
    }
}
