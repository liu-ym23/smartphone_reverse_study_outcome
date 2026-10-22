package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OChannelGrabMicShowMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "showId", "J", "G", "()J", "setShowId", "(J)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "startTimeStamp", "P", "setStartTimeStamp", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "Lcom/bytedance/android/live/base/model/user/User;", "channelUser", "Lcom/bytedance/android/live/base/model/user/User;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/live/base/model/user/User;", "setChannelUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "showlistName", FaceService.neutralLabel, "setShowlistName", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class rg extends o0 implements vh7.h {

    @SerializedName("channel_user")
    protected User channelUser;

    @SerializedName("end_timestamp")
    protected long endTimeStamp;

    @SerializedName("show_id")
    protected long showId;

    @SerializedName("showlist_name")
    protected String showlistName;

    @SerializedName("start_timestamp")
    protected long startTimeStamp;

    @SerializedName("text")
    protected String text;

    public rg() {
        this.type = MessageType.OFFICIAL_CHANNEL_GRAB_MIC_SHOW_MESSAGE;
    }

    public final User E() {
        return this.channelUser;
    }

    public final long G() {
        return this.showId;
    }

    public final String H() {
        return this.showlistName;
    }

    public final long P() {
        return this.startTimeStamp;
    }

    public final long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public final String getText() {
        return this.text;
    }

    public rg(am3.g r100) {
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
        this.showlistName = am3.h.c(r100);
        goto L3
    L8:
        this.channelUser = new User(r100);
        goto L3
    L9:
        this.endTimeStamp = r100.j();
        goto L3
    L10:
        this.startTimeStamp = r100.j();
        goto L3
    L11:
        this.text = am3.h.c(r100);
        goto L3
    L12:
        this.showId = r100.j();
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.OFFICIAL_CHANNEL_GRAB_MIC_SHOW_MESSAGE;
    }
}
