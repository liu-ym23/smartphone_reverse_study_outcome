package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistRequest;", "", "source", "", "deviceId", "", "packageName", "versionTag", "token", "parentAppId", "packageList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPackageItem;", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;)V", "getSource", "()I", "getDeviceId", "()Ljava/lang/String;", "getPackageName", "getVersionTag", "getToken", "getParentAppId", "getPackageList", "()Ljava/util/List;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsInAppWhitelistRequest {

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("extra_info")
    private final OpenPlatformExtraInfo extraInfo;

    @SerializedName("package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPackageItem> packageList;

    @SerializedName("app_key")
    private final String packageName;

    @SerializedName("parent_app_id")
    private final String parentAppId;
    private final int source;
    private final String token;

    @SerializedName("version_tag")
    private final String versionTag;

    public IsInAppWhitelistRequest() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsInAppWhitelistRequest copy$default(IsInAppWhitelistRequest r100, int r110, String r111, String r112, String r113, String r114, String r115, List r116, OpenPlatformExtraInfo r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.source;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.deviceId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.packageName;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.versionTag;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.token;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.parentAppId;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = r100.packageList;
    L31:
        if ((r118 & 128) == 0) goto L33;
        OpenPlatformExtraInfo r108 = r100.extraInfo;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final int component1() {
        return this.source;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.packageName;
    }

    public final String component4() {
        return this.versionTag;
    }

    public final String component5() {
        return this.token;
    }

    public final String component6() {
        return this.parentAppId;
    }

    public final List<OpenPlatformPackageItem> component7() {
        return this.packageList;
    }

    public final OpenPlatformExtraInfo component8() {
        return this.extraInfo;
    }

    public final IsInAppWhitelistRequest copy(int r110, String r111, String r112, String r113, String r114, String r115, List<OpenPlatformPackageItem> r116, OpenPlatformExtraInfo r117) {
        return new IsInAppWhitelistRequest(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IsInAppWhitelistRequest) == true) goto L8;
        return false;
    L8:
        IsInAppWhitelistRequest r101 = (IsInAppWhitelistRequest) r100;
        if (this.source == r101.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.versionTag, r101.versionTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parentAppId, r101.parentAppId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.packageList, r101.packageList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.source * 31;
        String r101 = this.deviceId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.packageName;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.versionTag;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.token;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.parentAppId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        List<OpenPlatformPackageItem> r117 = this.packageList;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        OpenPlatformExtraInfo r120 = this.extraInfo;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "IsInAppWhitelistRequest(source=" + this.source + ", deviceId=" + this.deviceId + ", packageName=" + this.packageName + ", versionTag=" + this.versionTag + ", token=" + this.token + ", parentAppId=" + this.parentAppId + ", packageList=" + this.packageList + ", extraInfo=" + this.extraInfo + ')';
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final OpenPlatformExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final List<OpenPlatformPackageItem> getPackageList() {
        return this.packageList;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getParentAppId() {
        return this.parentAppId;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public IsInAppWhitelistRequest(int r100, String r101, String r102, String r103, String r104, String r105, List<OpenPlatformPackageItem> r106, OpenPlatformExtraInfo r107) {
        this.source = r100;
        this.deviceId = r101;
        this.packageName = r102;
        this.versionTag = r103;
        this.token = r104;
        this.parentAppId = r105;
        this.packageList = r106;
        this.extraInfo = r107;
    }

    public /* synthetic */ IsInAppWhitelistRequest(int r110, String r111, String r112, String r113, String r114, String r115, List r116, OpenPlatformExtraInfo r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        int r100 = 0;
    L6:
        OpenPlatformExtraInfo r101 = null;
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = CollectionsKt.emptyList();
    L31:
        if ((r118 & 128) != 0) goto L34;
        r101 = r117;
    L34:
        this(r100, r102, r103, r104, r105, r106, r107, r101);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
