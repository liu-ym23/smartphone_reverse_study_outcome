package com.bytedance.android.shopping.store.hybrid.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/b;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "componentId", "getComponentId", "version", "b", "indexUrl", "getIndexUrl", "lynxIndexUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "settingUrl", "getSettingUrl", "", "frameworkType", "I", "getFrameworkType", "()I", "extra", "getExtra", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("framework_type")
    private final int frameworkType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f184847id;

    @SerializedName("index_url")
    private final String indexUrl;

    @SerializedName("lynx_index_url")
    private final String lynxIndexUrl;

    @SerializedName("setting_url")
    private final String settingUrl;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f184847id, r101.f184847id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.indexUrl, r101.indexUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lynxIndexUrl, r101.lynxIndexUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.settingUrl, r101.settingUrl) == true) goto L18;
        return false;
    L18:
        if (this.frameworkType == r101.frameworkType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f184847id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.componentId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.version;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.indexUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.lynxIndexUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.settingUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((r115 + r117) * 31) + this.frameworkType) * 31;
        String r119 = this.extra;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "ComponentVersion(id=" + this.f184847id + ", componentId=" + this.componentId + ", version=" + this.version + ", indexUrl=" + this.indexUrl + ", lynxIndexUrl=" + this.lynxIndexUrl + ", settingUrl=" + this.settingUrl + ", frameworkType=" + this.frameworkType + ", extra=" + this.extra + ")";
    }

    public b() {
        this.f184847id = null;
        this.componentId = null;
        this.version = null;
        this.indexUrl = null;
        this.lynxIndexUrl = null;
        this.settingUrl = null;
        this.frameworkType = -1;
        this.extra = null;
    }

    public final String a() {
        return this.lynxIndexUrl;
    }

    public final String b() {
        return this.version;
    }
}
