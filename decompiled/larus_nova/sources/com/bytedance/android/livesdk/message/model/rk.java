package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomTopMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rk;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/ImageModel;", "actionIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/live/base/model/ImageModel;", "setActionIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "foldDuration", "I", FaceService.neutralLabel, "()I", "setFoldDuration", "(I)V", "displayDuration", "getDisplayDuration", "setDisplayDuration", "Lcom/bytedance/android/livesdkapi/message/Text;", "firstTitle", "Lcom/bytedance/android/livesdkapi/message/Text;", "G", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setFirstTitle", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "secondTitle", "P", "setSecondTitle", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class rk extends o0 implements vh7.h {

    @SerializedName("action_icon")
    protected ImageModel actionIcon;

    @SerializedName("display_duration")
    protected int displayDuration;

    @SerializedName("first_title")
    protected Text firstTitle;

    @SerializedName("fold_duration")
    protected int foldDuration;

    @SerializedName("second_title")
    protected Text secondTitle;

    public rk() {
        this.type = MessageType.ROOM_TOP_MESSAGE;
    }

    public final ImageModel E() {
        return this.actionIcon;
    }

    public final Text G() {
        return this.firstTitle;
    }

    public final int H() {
        return this.foldDuration;
    }

    public final Text P() {
        return this.secondTitle;
    }

    public final int getDisplayDuration() {
        return this.displayDuration;
    }

    public rk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.actionIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.foldDuration = (int) r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.displayDuration = (int) r100.j();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.firstTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L16:
        if (r102 != 7) goto L17;
        this.secondTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        this.type = MessageType.ROOM_TOP_MESSAGE;
    }
}
