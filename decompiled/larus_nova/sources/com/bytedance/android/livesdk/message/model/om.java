package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.UnionAnchorMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/om;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "schema", "Ljava/util/Map;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/Map;", "setSchema", "(Ljava/util/Map;)V", "", "duration", "I", "getDuration", "()I", "setDuration", "(I)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class om extends o0 implements vh7.h {

    @SerializedName("duration")
    protected int duration;

    @SerializedName("schema")
    protected Map<String, String> schema;

    @SerializedName("text")
    protected String text;

    public om() {
        this.type = MessageType.UNION_LIVE_NOTICE_MESSAGE;
    }

    public final Map<String, String> E() {
        return this.schema;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getText() {
        return this.text;
    }

    public om(am3.g r110) {
        this.schema = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.text = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L16:
        int r105 = r110.f();
        if (r105 == (-1)) goto L23;
        if (r105 != 1) goto L19;
        r103 = am3.h.c(r110);
        goto L16
    L19:
        if (r105 != 2) goto L20;
        r104 = am3.h.c(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r102);
        Map<String, String> r106 = this.schema;
        if (r103 == null) goto L30;
        if (r104 == null) goto L28;
        r106.put(r103, r104);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 4) goto L13;
        this.duration = r110.i();
        goto L3
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
        this.type = MessageType.UNION_LIVE_NOTICE_MESSAGE;
    }
}
