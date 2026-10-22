package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse;", "Ljava/io/Serializable;", "message", "", "data", "Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse$Data;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse$Data;)V", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse$Data;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Data", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginCodeResponse implements Serializable {

    @SerializedName("data")
    private final Data data;

    @SerializedName("message")
    private final String message;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse$Data;", "Ljava/io/Serializable;", "code", "", "errorCode", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse$Data;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {

        @SerializedName("code")
        private final String code;

        @SerializedName("description")
        private final String description;

        @SerializedName("error_code")
        private final Integer errorCode;

        public Data() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Data copy$default(Data r100, String r101, Integer r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.code;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.errorCode;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.description;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.code;
        }

        public final Integer component2() {
            return this.errorCode;
        }

        public final String component3() {
            return this.description;
        }

        public final Data copy(String r100, Integer r101, String r102) {
            return new Data(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Data) == true) goto L8;
            return false;
        L8:
            Data r101 = (Data) r100;
            if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.description, r101.description) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.code;
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
            String r107 = this.description;
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
            return "Data(code=" + this.code + ", errorCode=" + this.errorCode + ", description=" + this.description + ')';
        }

        public final String getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public Data(String r100, Integer r101, String r102) {
            this.code = r100;
            this.errorCode = r101;
            this.description = r102;
        }

        public /* synthetic */ Data(String r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public LoginCodeResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LoginCodeResponse copy$default(LoginCodeResponse r100, String r101, Data r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.message;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.message;
    }

    public final Data component2() {
        return this.data;
    }

    public final LoginCodeResponse copy(String r100, Data r101) {
        return new LoginCodeResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LoginCodeResponse) == true) goto L8;
        return false;
    L8:
        LoginCodeResponse r101 = (LoginCodeResponse) r100;
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.message;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Data r104 = this.data;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LoginCodeResponse(message=" + this.message + ", data=" + this.data + ')';
    }

    public final Data getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public LoginCodeResponse(String r100, Data r101) {
        this.message = r100;
        this.data = r101;
    }

    public /* synthetic */ LoginCodeResponse(String r100, Data r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
