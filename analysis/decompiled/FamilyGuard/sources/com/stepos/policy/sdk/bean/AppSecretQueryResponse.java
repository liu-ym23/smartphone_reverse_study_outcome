package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class AppSecretQueryResponse {
    private final int code;
    private final AppSecretData data;
    private final String msg;

    public AppSecretQueryResponse(int i5, String str, AppSecretData appSecretData) {
        this.code = i5;
        this.msg = str;
        this.data = appSecretData;
    }

    public static /* synthetic */ AppSecretQueryResponse copy$default(AppSecretQueryResponse appSecretQueryResponse, int i5, String str, AppSecretData appSecretData, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = appSecretQueryResponse.code;
        }
        if ((i6 & 2) != 0) {
            str = appSecretQueryResponse.msg;
        }
        if ((i6 & 4) != 0) {
            appSecretData = appSecretQueryResponse.data;
        }
        return appSecretQueryResponse.copy(i5, str, appSecretData);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final AppSecretData component3() {
        return this.data;
    }

    public final AppSecretQueryResponse copy(int i5, String str, AppSecretData appSecretData) {
        return new AppSecretQueryResponse(i5, str, appSecretData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSecretQueryResponse)) {
            return false;
        }
        AppSecretQueryResponse appSecretQueryResponse = (AppSecretQueryResponse) obj;
        return this.code == appSecretQueryResponse.code && k.b(this.msg, appSecretQueryResponse.msg) && k.b(this.data, appSecretQueryResponse.data);
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
