package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InteractOpenDevelopMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wc;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "gameId", "J", "getGameId", "()J", "setGameId", "(J)V", "", "develop", "I", "G", "()I", "setDevelop", "(I)V", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "sign", FaceService.neutralLabel, "setSign", "appKind", ExifInterface.LONGITUDE_EAST, "setAppKind", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wc extends o0 implements vh7.h {

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("app_kind")
    protected long appKind;

    @SerializedName("develop")
    protected int develop;

    @SerializedName("game_id")
    protected long gameId;

    @SerializedName("sign")
    protected String sign;

    public final String toString() {
        return "InteractOpenDevelopMessage{gameId=" + this.gameId + ", develop=" + this.develop + ", appId='" + this.appId + "', sign='" + this.sign + "', appKind=" + this.appKind + '}';
    }

    public wc() {
        this.develop = -1;
        this.appId = "";
        this.sign = "";
        this.appKind = -1;
        this.type = MessageType.INTERACT_OPEN_DEVELOP_MESSAGE;
    }

    public final long E() {
        return this.appKind;
    }

    public final int G() {
        return this.develop;
    }

    public final String H() {
        return this.sign;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public wc(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.appKind = r100.j();
        r102 = r102 | 2;
        goto L3
    L8:
        this.gameId = r100.j();
        goto L3
    L9:
        this.sign = am3.h.c(r100);
        goto L3
    L10:
        this.develop = r100.i();
        r102 = r102 | 1;
        goto L3
    L11:
        this.appId = am3.h.c(r100);
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L17;
        this.develop = -1;
    L17:
        if (this.appId != null) goto L20;
        this.appId = "";
    L20:
        if (this.sign != null) goto L23;
        this.sign = "";
    L23:
        if ((r102 & 2) != 0) goto L25;
        this.appKind = -1;
    L25:
        this.type = MessageType.INTERACT_OPEN_DEVELOP_MESSAGE;
    }
}
