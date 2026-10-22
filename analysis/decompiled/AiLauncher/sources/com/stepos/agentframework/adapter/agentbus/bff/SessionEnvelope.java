package com.stepos.agentframework.adapter.agentbus.bff;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/p;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "code", "", "message", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", Const.INTENT_KEY_UMID, "()Z", "isOk", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.bff.p, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionEnvelope<T> {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final T data;

    @SerializedName("message")
    private final String message;

    public SessionEnvelope() {
        this(0, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final T b() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final boolean d() {
        return this.code == 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionEnvelope)) {
            return false;
        }
        SessionEnvelope sessionEnvelope = (SessionEnvelope) other;
        return this.code == sessionEnvelope.code && kotlin.jvm.internal.p.d(this.message, sessionEnvelope.message) && kotlin.jvm.internal.p.d(this.data, sessionEnvelope.data);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t10 = this.data;
        return iHashCode2 + (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "SessionEnvelope(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public SessionEnvelope(int i10, String str, T t10) {
        this.code = i10;
        this.message = str;
        this.data = t10;
    }

    public /* synthetic */ SessionEnvelope(int i10, String str, Object obj, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : obj);
    }
}
