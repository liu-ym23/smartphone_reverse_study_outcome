package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PopularCardMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ei;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/ei$b;", "_popularCardInfo", "Lcom/bytedance/android/livesdk/message/model/ei$b;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/message/model/ei$b;", "set_popularCardInfo", "(Lcom/bytedance/android/livesdk/message/model/ei$b;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ei extends o0 implements vh7.h {

    @SerializedName("popular_card_info")
    protected b _popularCardInfo;

    public static final class a {
    }

    @ProtoMessage("webcast.im.PopularCardMessage.PopularCardInfo")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ei$b;", "", "", "_status", "I", "b", "()I", "set_status", "(I)V", "", "_startTime", "J", "get_startTime", "()J", "set_startTime", "(J)V", "_endTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "set_endTime", "_enterNumber", "get_enterNumber", "set_enterNumber", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("end_time")
        protected long _endTime;

        @SerializedName("enter_number")
        protected int _enterNumber;

        @SerializedName(ILoadStallMonitor.START_TIME)
        protected long _startTime;

        @SerializedName("status")
        protected int _status;

        public b() {
        }

        public final long a() {
            return this._endTime;
        }

        public final int b() {
            return this._status;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this._status = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this._startTime = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this._endTime = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this._enterNumber = r100.i();
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    static {
    }

    public ei() {
        this.type = MessageType.POPULAR_CARD_MESSAGE;
    }

    public final b E() {
        return this._popularCardInfo;
    }

    public ei(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._popularCardInfo = new b(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.POPULAR_CARD_MESSAGE;
    }
}
