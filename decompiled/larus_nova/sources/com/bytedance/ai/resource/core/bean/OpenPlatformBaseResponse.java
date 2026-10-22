package com.bytedance.ai.resource.core.bean;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003JB\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\u00148Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "data", "logId", "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLogId", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformBaseResponse<T> {
    private final int code;
    private final T data;

    @SerializedName("log_id")
    private final String logId;
    private final String message;

    public OpenPlatformBaseResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformBaseResponse copy$default(OpenPlatformBaseResponse r100, int r101, String r102, Object r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.logId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    public final String component4() {
        return this.logId;
    }

    public final OpenPlatformBaseResponse<T> copy(int r100, String r101, T r102, String r103) {
        return new OpenPlatformBaseResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformBaseResponse) == true) goto L8;
        return false;
    L8:
        OpenPlatformBaseResponse r101 = (OpenPlatformBaseResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.message;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        T r105 = this.data;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.logId;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformBaseResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", logId=" + this.logId + ')';
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public OpenPlatformBaseResponse(int r100, String r101, T r102, String r103) {
        this.code = r100;
        this.message = r101;
        this.data = r102;
        this.logId = r103;
    }

    public /* synthetic */ OpenPlatformBaseResponse(int r100, String r101, Object r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
