package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/model/d1;", "", "", "assertId", "Ljava/lang/String;", "getAssertId", "()Ljava/lang/String;", "setAssertId", "(Ljava/lang/String;)V", "assertName", "getAssertName", "setAssertName", "assertPath", "getAssertPath", "setAssertPath", "assertUrl", "getAssertUrl", "setAssertUrl", "assertDesc", "getAssertDesc", "setAssertDesc", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 {

    @SerializedName("assert_desc")
    private String assertDesc;

    @SerializedName("assert_id")
    private String assertId;

    @SerializedName("assert_name")
    private String assertName;

    @SerializedName("assert_path")
    private String assertPath;

    @SerializedName("assert_url")
    private String assertUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d1) == false) goto L16;
        d1 r101 = (d1) r100;
        if (Intrinsics.areEqual(this.assertId, r101.assertId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.assertName, r101.assertName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.assertPath, r101.assertPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.assertUrl, r101.assertUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.assertDesc, r101.assertDesc) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.assertId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.assertName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.assertPath;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.assertUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.assertDesc;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VirtualSceneInfo(assertId=" + this.assertId + ", assertName=" + this.assertName + ", assertPath=" + this.assertPath + ", assertUrl=" + this.assertUrl + ", assertDesc=" + this.assertDesc + ")";
    }

    public d1() {
        this.assertId = "";
        this.assertName = "";
        this.assertPath = "";
        this.assertUrl = "";
        this.assertDesc = "";
    }
}
