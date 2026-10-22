package com.stepos.ailauncher.network;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ6\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/network/ApiResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "getDataOrThrow", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(ILjava/lang/String;Ljava/lang/Object;)Lcom/stepos/ailauncher/network/ApiResponse;", "equals", "other", "hashCode", "toString", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApiResponse<T> {
    private final int code;
    private final T data;
    private final String message;

    public ApiResponse(int i10, String str, T t10) {
        this.code = i10;
        this.message = str;
        this.data = t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, int i10, String str, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = apiResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = apiResponse.message;
        }
        if ((i11 & 4) != 0) {
            obj = apiResponse.data;
        }
        return apiResponse.copy(i10, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    public final ApiResponse<T> copy(int code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) other;
        return this.code == apiResponse.code && p.d(this.message, apiResponse.message) && p.d(this.data, apiResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final T getDataOrThrow() {
        if (isSuccess()) {
            T t10 = this.data;
            if (t10 != null) {
                return t10;
            }
            throw new IllegalStateException("Data is null");
        }
        int i10 = this.code;
        String str = this.message;
        if (str == null) {
            str = "Request failed";
        }
        throw new ApiException(i10, str);
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t10 = this.data;
        return iHashCode2 + (t10 != null ? t10.hashCode() : 0);
    }

    public final boolean isSuccess() {
        int i10 = this.code;
        return i10 == 0 || i10 == 200;
    }

    public String toString() {
        return "ApiResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public /* synthetic */ ApiResponse(int i10, String str, Object obj, int i11, i iVar) {
        this(i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : obj);
    }
}
