package com.bytedance.ai.bridge.remote.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckResponse;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "data", "Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckResponse$Data;", "<init>", "(ILjava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckResponse$Data;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckResponse$Data;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Data", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyCheckResponse implements Serializable {

    @SerializedName("data")
    private final Data data;

    @SerializedName("err_code")
    private final int errCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private final String errMsg;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckResponse$Data;", "Ljava/io/Serializable;", "privacyAgreed", "", "privacyCard", "Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "<init>", "(ZLcom/bytedance/ai/bridge/remote/model/PrivacyCard;)V", "getPrivacyAgreed", "()Z", "getPrivacyCard", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {

        @SerializedName("PrivacyAgreed")
        private final boolean privacyAgreed;

        @SerializedName("privacyCard")
        private final PrivacyCard privacyCard;

        /* JADX WARN: Multi-variable type inference failed */
        public Data() {
            boolean r100 = false;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Data copy$default(Data r100, boolean r101, PrivacyCard r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.privacyAgreed;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.privacyCard;
        L9:
            return r100.copy(r101, r102);
        }

        public final boolean component1() {
            return this.privacyAgreed;
        }

        public final PrivacyCard component2() {
            return this.privacyCard;
        }

        public final Data copy(boolean r100, PrivacyCard r101) {
            return new Data(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Data) == true) goto L8;
            return false;
        L8:
            Data r101 = (Data) r100;
            if (this.privacyAgreed == r101.privacyAgreed) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.privacyCard, r101.privacyCard) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            if (this.privacyAgreed == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            PrivacyCard r102 = this.privacyCard;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public String toString() {
            return "Data(privacyAgreed=" + this.privacyAgreed + ", privacyCard=" + this.privacyCard + ')';
        }

        public final boolean getPrivacyAgreed() {
            return this.privacyAgreed;
        }

        public final PrivacyCard getPrivacyCard() {
            return this.privacyCard;
        }

        public Data(boolean r100, PrivacyCard r101) {
            this.privacyAgreed = r100;
            this.privacyCard = r101;
        }

        public /* synthetic */ Data(boolean r100, PrivacyCard r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public PrivacyCheckResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ PrivacyCheckResponse copy$default(PrivacyCheckResponse r100, int r101, String r102, Data r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.errCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final Data component3() {
        return this.data;
    }

    public final PrivacyCheckResponse copy(int r100, String r101, Data r102) {
        return new PrivacyCheckResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrivacyCheckResponse) == true) goto L8;
        return false;
    L8:
        PrivacyCheckResponse r101 = (PrivacyCheckResponse) r100;
        if (this.errCode == r101.errCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.errCode * 31;
        String r101 = this.errMsg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Data r105 = this.data;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PrivacyCheckResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", data=" + this.data + ')';
    }

    public final Data getData() {
        return this.data;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public PrivacyCheckResponse(int r100, String r101, Data r102) {
        this.errCode = r100;
        this.errMsg = r101;
        this.data = r102;
    }

    public /* synthetic */ PrivacyCheckResponse(int r100, String r101, Data r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
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
