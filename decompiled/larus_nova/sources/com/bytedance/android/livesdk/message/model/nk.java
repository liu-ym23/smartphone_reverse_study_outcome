package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomStreamAdaptationMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/nk;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "", "_adaptationType", "I", ExifInterface.GPS_DIRECTION_TRUE, "()I", "set_adaptationType", "(I)V", "", "_adaptationHeightRatio", FaceService.girlLabel, "get_adaptationHeightRatio", "()F", "set_adaptationHeightRatio", "(F)V", "_adaptationBodyCenterRatio", "get_adaptationBodyCenterRatio", "set_adaptationBodyCenterRatio", "_adaptationContentTopRadio", "Q", "set_adaptationContentTopRadio", "_adaptationContentBottomRadio", "P", "set_adaptationContentBottomRadio", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class nk extends o0 implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153675a = 0;

    @SerializedName("adaptation_body_center_ratio")
    protected float _adaptationBodyCenterRatio;

    @SerializedName("adaptation_content_bottom_ratio")
    protected float _adaptationContentBottomRadio;

    @SerializedName("adaptation_content_top_ratio")
    protected float _adaptationContentTopRadio;

    @SerializedName("adaptation_height_ratio")
    protected float _adaptationHeightRatio;

    @SerializedName("adaptation_type")
    protected int _adaptationType;

    public static final class a {
    }

    static {
    }

    public nk() {
        this._adaptationType = 1;
        this._adaptationContentBottomRadio = 1.0f;
        this.type = MessageType.STREAM_ADAPTATION_MESSAGE;
    }

    public final float E() {
        return this._adaptationBodyCenterRatio;
    }

    public final float G() {
        return this._adaptationHeightRatio;
    }

    public final int H() {
        return this._adaptationType;
    }

    public final float P() {
        return this._adaptationContentBottomRadio;
    }

    public final float Q() {
        return this._adaptationContentTopRadio;
    }

    public final int T() {
        return this._adaptationType;
    }

    public nk(am3.g r100) {
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
        this._adaptationContentBottomRadio = Float.intBitsToFloat(r100.g());
        r102 = r102 | 2;
        goto L3
    L8:
        this._adaptationContentTopRadio = Float.intBitsToFloat(r100.g());
        goto L3
    L9:
        this._adaptationBodyCenterRatio = Float.intBitsToFloat(r100.g());
        goto L3
    L10:
        this._adaptationHeightRatio = Float.intBitsToFloat(r100.g());
        goto L3
    L11:
        this._adaptationType = r100.i();
        r102 = r102 | 1;
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
        this._adaptationType = 1;
    L17:
        if ((r102 & 2) != 0) goto L19;
        this._adaptationContentBottomRadio = 1.0f;
    L19:
        this.type = MessageType.STREAM_ADAPTATION_MESSAGE;
    }
}
