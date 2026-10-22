package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stepos/policy/sdk/bean/AppSecretQueryResponse;", "", "code", "", "msg", "", "data", "Lcom/stepos/policy/sdk/bean/AppSecretData;", "(ILjava/lang/String;Lcom/stepos/policy/sdk/bean/AppSecretData;)V", "getCode", "()I", "getData", "()Lcom/stepos/policy/sdk/bean/AppSecretData;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppSecretQueryResponse {
    private final int code;
    private final AppSecretData data;
    private final String msg;

    public AppSecretQueryResponse(int i10, String str, AppSecretData appSecretData) {
        this.code = i10;
        this.msg = str;
        this.data = appSecretData;
    }

    public static /* synthetic */ AppSecretQueryResponse copy$default(AppSecretQueryResponse appSecretQueryResponse, int i10, String str, AppSecretData appSecretData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = appSecretQueryResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = appSecretQueryResponse.msg;
        }
        if ((i11 & 4) != 0) {
            appSecretData = appSecretQueryResponse.data;
        }
        return appSecretQueryResponse.copy(i10, str, appSecretData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component3, reason: from getter */
    public final AppSecretData getData() {
        return this.data;
    }

    public final AppSecretQueryResponse copy(int code, String msg, AppSecretData data) {
        return new AppSecretQueryResponse(code, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSecretQueryResponse)) {
            return false;
        }
        AppSecretQueryResponse appSecretQueryResponse = (AppSecretQueryResponse) other;
        return this.code == appSecretQueryResponse.code && p.d(this.msg, appSecretQueryResponse.msg) && p.d(this.data, appSecretQueryResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final AppSecretData getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        AppSecretData appSecretData = this.data;
        return iHashCode2 + (appSecretData != null ? appSecretData.hashCode() : 0);
    }

    public String toString() {
        return "AppSecretQueryResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }
}
