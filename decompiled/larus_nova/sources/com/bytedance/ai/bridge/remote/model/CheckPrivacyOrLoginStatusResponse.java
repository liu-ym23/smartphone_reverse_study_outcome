package com.bytedance.ai.bridge.remote.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusResponse;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "data", "Lcom/bytedance/ai/bridge/remote/model/PrivacyData;", "alreadyLogin", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyData;Ljava/lang/Boolean;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrMsg", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyData;", "getAlreadyLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyData;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusResponse;", "equals", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPrivacyOrLoginStatusResponse implements Serializable {

    @SerializedName("already_login")
    private final Boolean alreadyLogin;

    @SerializedName("data")
    private final PrivacyData data;

    @SerializedName("err_code")
    private final Integer errCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private final String errMsg;

    public CheckPrivacyOrLoginStatusResponse() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CheckPrivacyOrLoginStatusResponse copy$default(CheckPrivacyOrLoginStatusResponse r100, Integer r101, String r102, PrivacyData r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.errCode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.errMsg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.alreadyLogin;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final PrivacyData component3() {
        return this.data;
    }

    public final Boolean component4() {
        return this.alreadyLogin;
    }

    public final CheckPrivacyOrLoginStatusResponse copy(Integer r100, String r101, PrivacyData r102, Boolean r103) {
        return new CheckPrivacyOrLoginStatusResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckPrivacyOrLoginStatusResponse) == true) goto L8;
        return false;
    L8:
        CheckPrivacyOrLoginStatusResponse r101 = (CheckPrivacyOrLoginStatusResponse) r100;
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.alreadyLogin, r101.alreadyLogin) == true) goto L20;
        return false;
    L20:
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
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PrivacyData r107 = this.data;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.alreadyLogin;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckPrivacyOrLoginStatusResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", data=" + this.data + ", alreadyLogin=" + this.alreadyLogin + ')';
    }

    public final Boolean getAlreadyLogin() {
        return this.alreadyLogin;
    }

    public final PrivacyData getData() {
        return this.data;
    }

    public final Integer getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public CheckPrivacyOrLoginStatusResponse(Integer r100, String r101, PrivacyData r102, Boolean r103) {
        this.errCode = r100;
        this.errMsg = r101;
        this.data = r102;
        this.alreadyLogin = r103;
    }

    public /* synthetic */ CheckPrivacyOrLoginStatusResponse(Integer r100, String r101, PrivacyData r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
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
