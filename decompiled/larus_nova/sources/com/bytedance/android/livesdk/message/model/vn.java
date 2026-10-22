package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.WishFinishMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/vn;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/ImageModel;", "gestureTipImageOneHand", "Lcom/bytedance/android/live/base/model/ImageModel;", "G", "()Lcom/bytedance/android/live/base/model/ImageModel;", "gestureTipImageTwoHands", FaceService.neutralLabel, "", "displaySeconds", "J", ExifInterface.LONGITUDE_EAST, "()J", "effectId", "getEffectId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class vn extends o0 implements vh7.h {

    @SerializedName("display_seconds")
    protected long displaySeconds;

    @SerializedName(MobConstants.EFFECT_ID)
    protected long effectId;

    @SerializedName("gesture_image_single")
    protected ImageModel gestureTipImageOneHand;

    @SerializedName("gesture_image_double")
    protected ImageModel gestureTipImageTwoHands;

    public vn() {
        this.type = MessageType.WISH_FINISH_MESSAGE;
    }

    public final long E() {
        return this.displaySeconds;
    }

    public final ImageModel G() {
        return this.gestureTipImageOneHand;
    }

    public final ImageModel H() {
        return this.gestureTipImageTwoHands;
    }

    public final long getEffectId() {
        return this.effectId;
    }

    public vn(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gestureTipImageOneHand = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.gestureTipImageTwoHands = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.displaySeconds = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.effectId = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.WISH_FINISH_MESSAGE;
    }
}
