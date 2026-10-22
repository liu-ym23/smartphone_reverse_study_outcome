package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/UploadModelContextResponse;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/remote/model/UploadModelContextResponse;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadModelContextResponse implements Serializable {

    @SerializedName("code")
    private final Integer errCode;

    @SerializedName("msg")
    private final String errMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadModelContextResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UploadModelContextResponse copy$default(UploadModelContextResponse r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.errMsg;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final UploadModelContextResponse copy(Integer r100, String r101) {
        return new UploadModelContextResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadModelContextResponse) == true) goto L8;
        return false;
    L8:
        UploadModelContextResponse r101 = (UploadModelContextResponse) r100;
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.errCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.errMsg;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UploadModelContextResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
    }

    public final Integer getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public UploadModelContextResponse(Integer r100, String r101) {
        this.errCode = r100;
        this.errMsg = r101;
    }

    public /* synthetic */ UploadModelContextResponse(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
