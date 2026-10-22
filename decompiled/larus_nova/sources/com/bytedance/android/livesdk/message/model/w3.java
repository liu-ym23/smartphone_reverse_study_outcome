package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationDetail;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.DecorationUpdateMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/w3;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationDetail;", "decorationDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationDetail;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationDetail;", "setDecorationDetail", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationDetail;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w3 extends o0 implements vh7.h {

    @SerializedName("detai")
    protected DecorationDetail decorationDetail;

    public static final class a {
    }

    static {
    }

    public w3() {
        this.type = MessageType.MODIFY_DECORATION_V2;
    }

    public final DecorationDetail E() {
        return this.decorationDetail;
    }

    public w3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.decorationDetail = new DecorationDetail(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.MODIFY_DECORATION_V2;
    }
}
