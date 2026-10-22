package com.bytedance.android.shopping.anchorv4.containers;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/containers/GalleryViewerParams;", "Ljava/io/Serializable;", "galleryIndex", "", "(I)V", "getGalleryIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryViewerParams implements Serializable {
    private final int galleryIndex;

    public GalleryViewerParams() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ GalleryViewerParams copy$default(GalleryViewerParams r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.galleryIndex;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.galleryIndex;
    }

    public final GalleryViewerParams copy(int r100) {
        return new GalleryViewerParams(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GalleryViewerParams) == true) goto L6;
        return false;
    L6:
        if (this.galleryIndex == ((GalleryViewerParams) r100).galleryIndex) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.galleryIndex;
    }

    public String toString() {
        return "GalleryViewerParams(galleryIndex=" + this.galleryIndex + ")";
    }

    public final int getGalleryIndex() {
        return this.galleryIndex;
    }

    public GalleryViewerParams(int r100) {
        this.galleryIndex = r100;
    }

    public /* synthetic */ GalleryViewerParams(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
