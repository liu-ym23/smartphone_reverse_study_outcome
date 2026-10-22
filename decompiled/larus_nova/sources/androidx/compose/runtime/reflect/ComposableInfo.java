package androidx.compose.runtime.reflect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableInfo;", "", "isComposable", "", "realParamsCount", "", "changedParams", "defaultParams", "<init>", "(ZIII)V", "()Z", "getRealParamsCount", "()I", "getChangedParams", "getDefaultParams", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposableInfo {
    public static final int $stable = 0;
    private final int changedParams;
    private final int defaultParams;
    private final boolean isComposable;
    private final int realParamsCount;

    public static /* synthetic */ ComposableInfo copy$default(ComposableInfo r100, boolean r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isComposable;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.realParamsCount;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.changedParams;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.defaultParams;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isComposable;
    }

    public final int component2() {
        return this.realParamsCount;
    }

    public final int component3() {
        return this.changedParams;
    }

    public final int component4() {
        return this.defaultParams;
    }

    public final ComposableInfo copy(boolean r100, int r101, int r102, int r103) {
        return new ComposableInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ComposableInfo) == true) goto L8;
        return false;
    L8:
        ComposableInfo r101 = (ComposableInfo) r100;
        if (this.isComposable == r101.isComposable) goto L12;
        return false;
    L12:
        if (this.realParamsCount == r101.realParamsCount) goto L15;
        return false;
    L15:
        if (this.changedParams == r101.changedParams) goto L18;
        return false;
    L18:
        if (this.defaultParams == r101.defaultParams) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isComposable == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + this.realParamsCount) * 31) + this.changedParams) * 31) + this.defaultParams;
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "ComposableInfo(isComposable=" + this.isComposable + ", realParamsCount=" + this.realParamsCount + ", changedParams=" + this.changedParams + ", defaultParams=" + this.defaultParams + ')';
    }

    public final int getChangedParams() {
        return this.changedParams;
    }

    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    public final boolean isComposable() {
        return this.isComposable;
    }

    public ComposableInfo(boolean r100, int r101, int r102, int r103) {
        this.isComposable = r100;
        this.realParamsCount = r101;
        this.changedParams = r102;
        this.defaultParams = r103;
    }
}
