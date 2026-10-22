package com.bytedance.android.shopping.anchorv4.monitor;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/monitor/ImageMonitorMeta;", "Ljava/io/Serializable;", "imageBiz", "", "imageScene", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageBiz", "()Ljava/lang/String;", "getImageScene", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageMonitorMeta implements Serializable {
    private final String imageBiz;
    private final String imageScene;

    public static /* synthetic */ ImageMonitorMeta copy$default(ImageMonitorMeta r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.imageBiz;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.imageScene;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.imageBiz;
    }

    public final String component2() {
        return this.imageScene;
    }

    public final ImageMonitorMeta copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "imageBiz");
        Intrinsics.checkNotNullParameter(r101, "imageScene");
        return new ImageMonitorMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageMonitorMeta) == false) goto L10;
        ImageMonitorMeta r101 = (ImageMonitorMeta) r100;
        if (Intrinsics.areEqual(this.imageBiz, r101.imageBiz) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.imageScene, r101.imageScene) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.imageBiz;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.imageScene;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ImageMonitorMeta(imageBiz=" + this.imageBiz + ", imageScene=" + this.imageScene + ")";
    }

    public final String getImageBiz() {
        return this.imageBiz;
    }

    public final String getImageScene() {
        return this.imageScene;
    }

    public ImageMonitorMeta(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "imageBiz");
        Intrinsics.checkNotNullParameter(r101, "imageScene");
        this.imageBiz = r100;
        this.imageScene = r101;
    }
}
