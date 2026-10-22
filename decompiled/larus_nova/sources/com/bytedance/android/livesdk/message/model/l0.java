package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.BarMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l0;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "duration", "I", "getDuration", "()I", "setDuration", "(I)V", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 implements vh7.h {

    @SerializedName("duration")
    protected int duration;

    @SerializedName("params")
    protected Map<String, String> params;

    @SerializedName("text")
    protected String text;

    public l0() {
        this.text = "";
    }

    public l0(am3.g r110) {
        this.params = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.text = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.duration = r110.i();
        goto L3
    L10:
        if (r101 != 3) goto L11;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L13
    L16:
        if (r105 != 2) goto L17;
        r104 = am3.h.c(r110);
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r102);
        Map<String, String> r106 = this.params;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
        if (this.text != null) goto L57;
        this.text = "";
        return;
    }
}
