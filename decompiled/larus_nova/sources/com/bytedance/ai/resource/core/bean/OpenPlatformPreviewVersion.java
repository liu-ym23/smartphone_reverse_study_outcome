package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "", "versionTag", "", "updatedAt", "", "isDefault", "", "status", "createdAt", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)V", "getVersionTag", "()Ljava/lang/String;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewVersion {

    @SerializedName("created_at")
    private final Long createdAt;

    @SerializedName("is_default")
    private final Boolean isDefault;

    @SerializedName("status")
    private final String status;

    @SerializedName(BarrageMaskInfo.KEY_MASK_UPDATED_AT)
    private final Long updatedAt;

    @SerializedName("version_tag")
    private final String versionTag;

    public OpenPlatformPreviewVersion() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OpenPlatformPreviewVersion copy$default(OpenPlatformPreviewVersion r100, String r101, Long r102, Boolean r103, String r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.versionTag;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.updatedAt;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.isDefault;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.status;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.createdAt;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.versionTag;
    }

    public final Long component2() {
        return this.updatedAt;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final String component4() {
        return this.status;
    }

    public final Long component5() {
        return this.createdAt;
    }

    public final OpenPlatformPreviewVersion copy(String r100, Long r101, Boolean r110, String r111, Long r112) {
        return new OpenPlatformPreviewVersion(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformPreviewVersion) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewVersion r101 = (OpenPlatformPreviewVersion) r100;
        if (Intrinsics.areEqual(this.versionTag, r101.versionTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updatedAt, r101.updatedAt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isDefault, r101.isDefault) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createdAt, r101.createdAt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.versionTag;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.updatedAt;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isDefault;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.status;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.createdAt;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "OpenPlatformPreviewVersion(versionTag=" + this.versionTag + ", updatedAt=" + this.updatedAt + ", isDefault=" + this.isDefault + ", status=" + this.status + ", createdAt=" + this.createdAt + ')';
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public OpenPlatformPreviewVersion(String r100, Long r101, Boolean r102, String r103, Long r104) {
        this.versionTag = r100;
        this.updatedAt = r101;
        this.isDefault = r102;
        this.status = r103;
        this.createdAt = r104;
    }

    public /* synthetic */ OpenPlatformPreviewVersion(String r100, Long r101, Boolean r102, String r103, Long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Boolean r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Long r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
