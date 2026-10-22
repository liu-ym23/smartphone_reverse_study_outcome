package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RoomFeatureValue")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/RoomFeatureValue;", "", "()V", "expTimeMs", "", "getExpTimeMs", "()Ljava/lang/Long;", "setExpTimeMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "genTimeMs", "getGenTimeMs", "setGenTimeMs", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "value", "getValue", "setValue", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomFeatureValue implements h {

    @SerializedName("exp_time")
    protected Long expTimeMs;

    @SerializedName("gen_time")
    protected Long genTimeMs;

    @SerializedName("type")
    protected String type;

    @SerializedName("value")
    protected String value;

    public RoomFeatureValue() {
    }

    public final Long getExpTimeMs() {
        return this.expTimeMs;
    }

    public final Long getGenTimeMs() {
        return this.genTimeMs;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public RoomFeatureValue(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.type = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.value = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.genTimeMs = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.expTimeMs = Long.valueOf(r100.j());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setExpTimeMs(Long r100) {
        this.expTimeMs = r100;
    }

    public final void setGenTimeMs(Long r100) {
        this.genTimeMs = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setValue(String r100) {
        this.value = r100;
    }
}
