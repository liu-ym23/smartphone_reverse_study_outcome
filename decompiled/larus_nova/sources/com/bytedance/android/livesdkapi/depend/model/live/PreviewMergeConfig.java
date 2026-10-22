package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewMergeConfig;", "", "isPreviewMergeInteract", "", "isPreviewCautious", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMergeConfig {
    private final boolean isPreviewCautious;
    private final boolean isPreviewMergeInteract;

    public static /* synthetic */ PreviewMergeConfig copy$default(PreviewMergeConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isPreviewMergeInteract;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isPreviewCautious;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isPreviewMergeInteract;
    }

    public final boolean component2() {
        return this.isPreviewCautious;
    }

    public final PreviewMergeConfig copy(boolean r100, boolean r101) {
        return new PreviewMergeConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreviewMergeConfig) == false) goto L10;
        PreviewMergeConfig r101 = (PreviewMergeConfig) r100;
        if (this.isPreviewMergeInteract == r101.isPreviewMergeInteract) goto L8;
        return false;
    L8:
        if (this.isPreviewCautious == r101.isPreviewCautious) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.isPreviewMergeInteract;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.isPreviewCautious;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public String toString() {
        return "PreviewMergeConfig(isPreviewMergeInteract=" + this.isPreviewMergeInteract + ", isPreviewCautious=" + this.isPreviewCautious + ")";
    }

    public final boolean isPreviewCautious() {
        return this.isPreviewCautious;
    }

    public final boolean isPreviewMergeInteract() {
        return this.isPreviewMergeInteract;
    }

    public PreviewMergeConfig(boolean r100, boolean r101) {
        this.isPreviewMergeInteract = r100;
        this.isPreviewCautious = r101;
    }
}
