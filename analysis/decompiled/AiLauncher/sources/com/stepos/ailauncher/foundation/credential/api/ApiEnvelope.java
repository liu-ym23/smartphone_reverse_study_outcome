package com.stepos.ailauncher.foundation.credential.api;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ6\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/ApiEnvelope;", ExifInterface.GPS_DIRECTION_TRUE, "", "status", "", "msg", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "getStatus", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(ILjava/lang/String;Ljava/lang/Object;)Lcom/stepos/ailauncher/foundation/credential/api/ApiEnvelope;", "equals", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApiEnvelope<T> {

    @SerializedName("data")
    private final T data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("status")
    private final int status;

    public ApiEnvelope() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiEnvelope copy$default(ApiEnvelope apiEnvelope, int i10, String str, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = apiEnvelope.status;
        }
        if ((i11 & 2) != 0) {
            str = apiEnvelope.msg;
        }
        if ((i11 & 4) != 0) {
            obj = apiEnvelope.data;
        }
        return apiEnvelope.copy(i10, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final ApiEnvelope<T> copy(int status, String msg, T data) {
        return new ApiEnvelope<>(status, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiEnvelope)) {
            return false;
        }
        ApiEnvelope apiEnvelope = (ApiEnvelope) other;
        return this.status == apiEnvelope.status && p.d(this.msg, apiEnvelope.msg) && p.d(this.data, apiEnvelope.data);
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.status) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t10 = this.data;
        return iHashCode2 + (t10 != null ? t10.hashCode() : 0);
    }

    public final boolean isSuccess() {
        return this.status == 200;
    }

    public String toString() {
        return "ApiEnvelope(status=" + this.status + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public ApiEnvelope(int i10, String str, T t10) {
        this.status = i10;
        this.msg = str;
        this.data = t10;
    }

    public /* synthetic */ ApiEnvelope(int i10, String str, Object obj, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : obj);
    }
}
