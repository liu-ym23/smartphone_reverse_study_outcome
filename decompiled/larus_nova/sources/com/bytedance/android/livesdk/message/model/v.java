package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.AppointmentNumberUpdateMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/v;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/v$a;", "data", "Lcom/bytedance/android/livesdk/message/model/v$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v extends o0 implements vh7.h {

    @SerializedName("data")
    public a data;

    @ProtoMessage("webcast.im.AppointmentNumberUpdateMessage.Data")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/v$a;", "", "", "currentNumber", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setCurrentNumber", "(J)V", "anchorUid", "getAnchorUid", "setAnchorUid", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("AnchorUID")
        protected long anchorUid;

        @SerializedName("CurrentNumber")
        protected long currentNumber;

        public a() {
            this.currentNumber = 0;
            this.anchorUid = 0;
        }

        public final long a() {
            return this.currentNumber;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
            int r102 = 0;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L11;
            if (r103 != 1) goto L7;
            this.currentNumber = r100.j();
            r102 = r102 | 1;
            goto L3
        L7:
            if (r103 != 2) goto L8;
            this.anchorUid = r100.j();
            r102 = r102 | 2;
            goto L3
        L8:
            am3.h.e(r100);
            goto L3
        L11:
            r100.d(r101);
            if ((r102 & 1) != 0) goto L15;
            this.currentNumber = 0;
        L15:
            if ((r102 & 2) != 0) goto L27;
            this.anchorUid = 0;
            return;
        }

        public a(int r100) {
            this.currentNumber = 0;
            this.anchorUid = 0;
        }
    }

    public v() {
        this.data = new a(0);
        this.type = MessageType.ANNOUNCEMENT_APPOINTMENT_INFO_MESSAGE;
    }

    public v(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.data = new a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.data != null) goto L15;
        this.data = new a(0);
    L15:
        this.type = MessageType.ANNOUNCEMENT_APPOINTMENT_INFO_MESSAGE;
    }
}
