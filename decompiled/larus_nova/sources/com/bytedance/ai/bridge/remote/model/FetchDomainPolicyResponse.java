package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse;", "Ljava/io/Serializable;", "code", "", "message", "", "data", "Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "logId", "<init>", "(ILjava/lang/String;Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "getLogId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Data", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FetchDomainPolicyResponse implements Serializable {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final Data data;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("message")
    private final String message;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "Ljava/io/Serializable;", "signedPayload", "", "signature", "domainVerifySwitch", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getSignedPayload", "()Ljava/lang/String;", "getSignature", "getDomainVerifySwitch", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {

        @SerializedName("domain_verify_switch")
        private final boolean domainVerifySwitch;

        @SerializedName("signature")
        private final String signature;

        @SerializedName("signed_payload")
        private final String signedPayload;

        public Data() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ Data copy$default(Data r100, String r101, String r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.signedPayload;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.signature;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.domainVerifySwitch;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.signedPayload;
        }

        public final String component2() {
            return this.signature;
        }

        public final boolean component3() {
            return this.domainVerifySwitch;
        }

        public final Data copy(String r100, String r101, boolean r102) {
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
            if (Intrinsics.areEqual(this.signedPayload, r101.signedPayload) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.signature, r101.signature) == true) goto L15;
            return false;
        L15:
            if (this.domainVerifySwitch == r101.domainVerifySwitch) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.signedPayload;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.signature;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            if (this.domainVerifySwitch == false) goto L13;
            int r106 = 1231;
        L15:
            return r105 + r106;
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Data(signedPayload=" + this.signedPayload + ", signature=" + this.signature + ", domainVerifySwitch=" + this.domainVerifySwitch + ')';
        }

        public final boolean getDomainVerifySwitch() {
            return this.domainVerifySwitch;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getSignedPayload() {
            return this.signedPayload;
        }

        public Data(String r100, String r101, boolean r102) {
            this.signedPayload = r100;
            this.signature = r101;
            this.domainVerifySwitch = r102;
        }

        public /* synthetic */ Data(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = true;
        L11:
            this(r100, r101, r102);
        }
    }

    public FetchDomainPolicyResponse() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ FetchDomainPolicyResponse copy$default(FetchDomainPolicyResponse r100, int r101, String r102, Data r103, String r104, int r105, Object r106) {
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

    public final Data component3() {
        return this.data;
    }

    public final String component4() {
        return this.logId;
    }

    public final FetchDomainPolicyResponse copy(int r100, String r101, Data r102, String r103) {
        return new FetchDomainPolicyResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FetchDomainPolicyResponse) == true) goto L8;
        return false;
    L8:
        FetchDomainPolicyResponse r101 = (FetchDomainPolicyResponse) r100;
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
        Data r105 = this.data;
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
        return "FetchDomainPolicyResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", logId=" + this.logId + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public FetchDomainPolicyResponse(int r100, String r101, Data r102, String r103) {
        this.code = r100;
        this.message = r101;
        this.data = r102;
        this.logId = r103;
    }

    public /* synthetic */ FetchDomainPolicyResponse(int r100, String r101, Data r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
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
