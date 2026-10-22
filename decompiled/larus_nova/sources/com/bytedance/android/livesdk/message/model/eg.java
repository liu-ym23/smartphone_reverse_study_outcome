package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.MiniAppCommonMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/eg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "scene", "I", "getScene", "()I", "setScene", "(I)V", "", "mini_app_id", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "setMini_app_id", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "Lcom/bytedance/android/livesdk/message/model/fg;", "data", "Lcom/bytedance/android/livesdk/message/model/fg;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/message/model/fg;", "setData", "(Lcom/bytedance/android/livesdk/message/model/fg;)V", "openId", "getOpenId", "setOpenId", "extra", "getExtra", "setExtra", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class eg extends o0 implements vh7.h {

    @SerializedName("data")
    protected fg data;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("mini_app_id")
    protected String mini_app_id;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("scene")
    protected int scene;

    @SerializedName("action")
    protected int status;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "MiniAppCommonMessage(messageId: " + getMessageId() + ", scene=" + this.scene + ", mini_app_id=" + this.mini_app_id + ", status=" + this.status + ", openId=" + this.openId + ", extra=" + this.extra + ')';
    }

    public eg() {
        this.type = MessageType.MINI_APP_COMMON_MESSAGE;
    }

    public final fg E() {
        return this.data;
    }

    public final String G() {
        return this.mini_app_id;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final int getScene() {
        return this.scene;
    }

    public final int getStatus() {
        return this.status;
    }

    public eg(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.extra = am3.h.c(r100);
        goto L3
    L8:
        this.openId = am3.h.c(r100);
        goto L3
    L9:
        this.data = new fg(r100);
        goto L3
    L10:
        this.status = r100.i();
        goto L3
    L11:
        this.mini_app_id = am3.h.c(r100);
        goto L3
    L12:
        this.scene = r100.i();
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.MINI_APP_COMMON_MESSAGE;
    }
}
