package com.bytedance.android.live.base.model.message;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/base/model/message/i1;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "delaySeconds", "J", ExifInterface.LONGITUDE_EAST, "()J", "", "position", "I", "getPosition", "()I", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i1 extends com.bytedance.android.livesdk.message.model.o0 implements vh7.h {

    @SerializedName("max_delay_seconds")
    protected long delaySeconds;

    @SerializedName("position")
    protected int position;

    public static final class a {
    }

    static {
    }

    public i1() {
        this.type = MessageType.IN_ROOM_BANNER_REFRESH_MESSAGE;
    }

    public final long E() {
        return this.delaySeconds;
    }

    public final int getPosition() {
        return this.position;
    }

    public i1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.delaySeconds = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.position = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.IN_ROOM_BANNER_REFRESH_MESSAGE;
    }
}
