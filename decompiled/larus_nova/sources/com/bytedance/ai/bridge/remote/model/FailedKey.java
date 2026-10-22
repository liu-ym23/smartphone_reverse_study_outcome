package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/FailedKey;", "Ljava/io/Serializable;", b.f276376z, "", "errorCode", "", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/remote/model/FailedKey;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FailedKey implements Serializable {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("error_code")
    private final Integer errorCode;

    @SerializedName("error_message")
    private final String errorMessage;

    public FailedKey() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FailedKey copy$default(FailedKey r100, String r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.appKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errorCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.errorMessage;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.appKey;
    }

    public final Integer component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final FailedKey copy(String r100, Integer r101, String r102) {
        return new FailedKey(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FailedKey) == true) goto L8;
        return false;
    L8:
        FailedKey r101 = (FailedKey) r100;
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorMessage, r101.errorMessage) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.appKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.errorCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.errorMessage;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FailedKey(appKey=" + this.appKey + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public FailedKey(String r100, Integer r101, String r102) {
        this.appKey = r100;
        this.errorCode = r101;
        this.errorMessage = r102;
    }

    public /* synthetic */ FailedKey(String r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
