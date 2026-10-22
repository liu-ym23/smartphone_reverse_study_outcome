package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppVersionList;", "", b.f276376z, "", "formalVersions", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;)V", "getAppKey", "()Ljava/lang/String;", "getFormalVersions", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppVersionList {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("formal_versions")
    private final OpenPlatformPreviewVersionPage formalVersions;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformPreviewAppVersionList() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OpenPlatformPreviewAppVersionList copy$default(OpenPlatformPreviewAppVersionList r100, String r101, OpenPlatformPreviewVersionPage r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appKey;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.formalVersions;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.appKey;
    }

    public final OpenPlatformPreviewVersionPage component2() {
        return this.formalVersions;
    }

    public final OpenPlatformPreviewAppVersionList copy(String r100, OpenPlatformPreviewVersionPage r101) {
        Intrinsics.checkNotNullParameter(r100, b.f276376z);
        return new OpenPlatformPreviewAppVersionList(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformPreviewAppVersionList) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppVersionList r101 = (OpenPlatformPreviewAppVersionList) r100;
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.formalVersions, r101.formalVersions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.appKey.hashCode() * 31;
        OpenPlatformPreviewVersionPage r101 = this.formalVersions;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OpenPlatformPreviewAppVersionList(appKey=" + this.appKey + ", formalVersions=" + this.formalVersions + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final OpenPlatformPreviewVersionPage getFormalVersions() {
        return this.formalVersions;
    }

    public OpenPlatformPreviewAppVersionList(String r100, OpenPlatformPreviewVersionPage r101) {
        Intrinsics.checkNotNullParameter(r100, b.f276376z);
        this.appKey = r100;
        this.formalVersions = r101;
    }

    public /* synthetic */ OpenPlatformPreviewAppVersionList(String r100, OpenPlatformPreviewVersionPage r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
