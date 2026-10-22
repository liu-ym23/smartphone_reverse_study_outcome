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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "", "items", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "nextCursor", "", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "getItems", "()Ljava/util/List;", "getNextCursor", "()Ljava/lang/String;", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewVersionPage {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("items")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewVersion> items;

    @SerializedName("next_cursor")
    private final String nextCursor;

    public OpenPlatformPreviewVersionPage() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewVersionPage copy$default(OpenPlatformPreviewVersionPage r100, List r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.nextCursor;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<OpenPlatformPreviewVersion> component1() {
        return this.items;
    }

    public final String component2() {
        return this.nextCursor;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final OpenPlatformPreviewVersionPage copy(List<OpenPlatformPreviewVersion> r100, String r101, boolean r102) {
        return new OpenPlatformPreviewVersionPage(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformPreviewVersionPage) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewVersionPage r101 = (OpenPlatformPreviewVersionPage) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nextCursor, r101.nextCursor) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<OpenPlatformPreviewVersion> r100 = this.items;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.nextCursor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.hasMore == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformPreviewVersionPage(items=" + this.items + ", nextCursor=" + this.nextCursor + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<OpenPlatformPreviewVersion> getItems() {
        return this.items;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public OpenPlatformPreviewVersionPage(List<OpenPlatformPreviewVersion> r100, String r101, boolean r102) {
        this.items = r100;
        this.nextCursor = r101;
        this.hasMore = r102;
    }

    public /* synthetic */ OpenPlatformPreviewVersionPage(List r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
