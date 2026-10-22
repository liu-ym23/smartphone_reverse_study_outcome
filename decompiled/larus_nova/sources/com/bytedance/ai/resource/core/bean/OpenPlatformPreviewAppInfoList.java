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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "", "mode", "", "scanSelectedApps", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "apps", "nextCursor", "hasMore", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)V", "getMode", "()Ljava/lang/String;", "getScanSelectedApps", "()Ljava/util/List;", "getApps", "getNextCursor", "getHasMore", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppInfoList {

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewAppInfo> apps;

    @SerializedName("has_more")
    private final boolean hasMore;
    private final String mode;

    @SerializedName("next_cursor")
    private final String nextCursor;

    @SerializedName("scan_selected_apps")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewAppInfo> scanSelectedApps;

    public OpenPlatformPreviewAppInfoList() {
        this(null, null, null, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewAppInfoList copy$default(OpenPlatformPreviewAppInfoList r100, String r101, List r102, List r103, String r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.mode;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.scanSelectedApps;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.apps;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.nextCursor;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.hasMore;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.mode;
    }

    public final List<OpenPlatformPreviewAppInfo> component2() {
        return this.scanSelectedApps;
    }

    public final List<OpenPlatformPreviewAppInfo> component3() {
        return this.apps;
    }

    public final String component4() {
        return this.nextCursor;
    }

    public final boolean component5() {
        return this.hasMore;
    }

    public final OpenPlatformPreviewAppInfoList copy(String r100, List<OpenPlatformPreviewAppInfo> r101, List<OpenPlatformPreviewAppInfo> r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        return new OpenPlatformPreviewAppInfoList(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformPreviewAppInfoList) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppInfoList r101 = (OpenPlatformPreviewAppInfoList) r100;
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scanSelectedApps, r101.scanSelectedApps) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.apps, r101.apps) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextCursor, r101.nextCursor) == true) goto L21;
        return false;
    L21:
        if (this.hasMore == r101.hasMore) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.mode.hashCode() * 31;
        List<OpenPlatformPreviewAppInfo> r101 = this.scanSelectedApps;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<OpenPlatformPreviewAppInfo> r105 = this.apps;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.nextCursor;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.hasMore == false) goto L17;
        int r110 = 1231;
    L19:
        return r109 + r110;
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformPreviewAppInfoList(mode=" + this.mode + ", scanSelectedApps=" + this.scanSelectedApps + ", apps=" + this.apps + ", nextCursor=" + this.nextCursor + ", hasMore=" + this.hasMore + ')';
    }

    public final List<OpenPlatformPreviewAppInfo> getApps() {
        return this.apps;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public final List<OpenPlatformPreviewAppInfo> getScanSelectedApps() {
        return this.scanSelectedApps;
    }

    public OpenPlatformPreviewAppInfoList(String r100, List<OpenPlatformPreviewAppInfo> r101, List<OpenPlatformPreviewAppInfo> r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.mode = r100;
        this.scanSelectedApps = r101;
        this.apps = r102;
        this.nextCursor = r103;
        this.hasMore = r104;
    }

    public /* synthetic */ OpenPlatformPreviewAppInfoList(String r100, List r101, List r102, String r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        List r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = null;
    L14:
        String r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        boolean r108 = false;
    L18:
        this(r100, r111, r106, r107, r108);
        return;
    L17:
        r108 = r104;
        goto L18
    }
}
