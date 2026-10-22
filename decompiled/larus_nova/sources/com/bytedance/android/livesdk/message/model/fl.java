package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/fl;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/Integer;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/Integer;", FaceService.neutralLabel, "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/live/base/model/n;", "shortTouchArea", "Lcom/bytedance/android/live/base/model/n;", "G", "()Lcom/bytedance/android/live/base/model/n;", "P", "(Lcom/bytedance/android/live/base/model/n;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class fl extends o0 implements vh7.h {

    @SerializedName("message_type")
    protected Integer actionType;

    @SerializedName("short_touch_area_data")
    protected com.bytedance.android.live.base.model.n shortTouchArea;

    public fl() {
        this.type = MessageType.SHORT_TOUCH_AREA_MESSAGE;
    }

    public final Integer E() {
        return this.actionType;
    }

    public final com.bytedance.android.live.base.model.n G() {
        return this.shortTouchArea;
    }

    public fl(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.actionType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.shortTouchArea = new com.bytedance.android.live.base.model.n(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.SHORT_TOUCH_AREA_MESSAGE;
    }

    public final void H(Integer r100) {
        this.actionType = r100;
    }

    public final void P(com.bytedance.android.live.base.model.n r100) {
        this.shortTouchArea = r100;
    }
}
