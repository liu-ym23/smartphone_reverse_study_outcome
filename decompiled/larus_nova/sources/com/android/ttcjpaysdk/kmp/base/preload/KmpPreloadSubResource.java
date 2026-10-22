package com.android.ttcjpaysdk.kmp.base.preload;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/preload/KmpPreloadSubResource;", "", "type", "", "url", "enableMemory", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "getUrl$annotations", "getUrl", "getEnableMemory$annotations", "getEnableMemory", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpPreloadSubResource {
    public static final int $stable = 0;
    private final boolean enableMemory;
    private final String type;
    private final String url;

    public KmpPreloadSubResource() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ KmpPreloadSubResource copy$default(KmpPreloadSubResource r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.url;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.enableMemory;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public static /* synthetic */ void getEnableMemory$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.url;
    }

    public final boolean component3() {
        return this.enableMemory;
    }

    public final KmpPreloadSubResource copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "url");
        return new KmpPreloadSubResource(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KmpPreloadSubResource) == true) goto L8;
        return false;
    L8:
        KmpPreloadSubResource r101 = (KmpPreloadSubResource) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (this.enableMemory == r101.enableMemory) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.type.hashCode() * 31) + this.url.hashCode()) * 31;
        if (this.enableMemory == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "KmpPreloadSubResource(type=" + this.type + ", url=" + this.url + ", enableMemory=" + this.enableMemory + ')';
    }

    public final boolean getEnableMemory() {
        return this.enableMemory;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public KmpPreloadSubResource(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.type = r100;
        this.url = r101;
        this.enableMemory = r102;
    }

    public /* synthetic */ KmpPreloadSubResource(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
