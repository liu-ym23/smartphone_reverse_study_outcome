package com.bytedance.android.gamecp.hybrid_api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_api/LoadImageResult;", "", "hitCache", "", "sense", "", "url", "(ZLjava/lang/String;Ljava/lang/String;)V", "getHitCache", "()Z", "getSense", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "gamecp-hybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadImageResult {
    private final boolean hitCache;
    private final String sense;
    private final String url;

    public static /* synthetic */ LoadImageResult copy$default(LoadImageResult r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.hitCache;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.sense;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.url;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.hitCache;
    }

    public final String component2() {
        return this.sense;
    }

    public final String component3() {
        return this.url;
    }

    public final LoadImageResult copy(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "sense");
        return new LoadImageResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LoadImageResult) == false) goto L12;
        LoadImageResult r101 = (LoadImageResult) r100;
        if (this.hitCache == r101.hitCache) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sense, r101.sense) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.hitCache;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.sense;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.url;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "LoadImageResult(hitCache=" + this.hitCache + ", sense=" + this.sense + ", url=" + this.url + ")";
    }

    public final boolean getHitCache() {
        return this.hitCache;
    }

    public final String getSense() {
        return this.sense;
    }

    public final String getUrl() {
        return this.url;
    }

    public LoadImageResult(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "sense");
        this.hitCache = r100;
        this.sense = r101;
        this.url = r102;
    }
}
