package com.bytedance.android.ui.ec.widget.loading;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/RefreshTextConfig;", "", "pullText", "", "loadingText", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getLoadingText", "()Ljava/lang/CharSequence;", "getPullText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshTextConfig {
    private final CharSequence loadingText;
    private final CharSequence pullText;

    /* JADX WARN: Multi-variable type inference failed */
    public RefreshTextConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RefreshTextConfig copy$default(RefreshTextConfig r100, CharSequence r101, CharSequence r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pullText;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.loadingText;
    L9:
        return r100.copy(r101, r102);
    }

    public final CharSequence component1() {
        return this.pullText;
    }

    public final CharSequence component2() {
        return this.loadingText;
    }

    public final RefreshTextConfig copy(CharSequence r100, CharSequence r101) {
        return new RefreshTextConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RefreshTextConfig) == false) goto L10;
        RefreshTextConfig r101 = (RefreshTextConfig) r100;
        if (Intrinsics.areEqual(this.pullText, r101.pullText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadingText, r101.loadingText) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        CharSequence r100 = this.pullText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CharSequence r104 = this.loadingText;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RefreshTextConfig(pullText=" + this.pullText + ", loadingText=" + this.loadingText + ")";
    }

    public final CharSequence getLoadingText() {
        return this.loadingText;
    }

    public final CharSequence getPullText() {
        return this.pullText;
    }

    public RefreshTextConfig(CharSequence r100, CharSequence r101) {
        this.pullText = r100;
        this.loadingText = r101;
    }

    public /* synthetic */ RefreshTextConfig(CharSequence r100, CharSequence r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
