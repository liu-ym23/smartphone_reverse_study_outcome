package androidx.window.embedding;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0016\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004H\u0080\u0002¢\u0006\u0002\b\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u001e"}, d2 = {"Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitRule;", "filters", "", "Landroidx/window/embedding/SplitPairFilter;", "finishPrimaryWithSecondary", "", "finishSecondaryWithPrimary", "clearTop", "", "minWidth", "minSmallestWidth", "splitRatio", "", "layoutDir", "(Ljava/util/Set;IIZIIFI)V", "getClearTop", "()Z", "getFilters", "()Ljava/util/Set;", "getFinishPrimaryWithSecondary", "()I", "getFinishSecondaryWithPrimary", "equals", "other", "", "hashCode", "plus", "filter", "plus$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final int finishPrimaryWithSecondary;
    private final int finishSecondaryWithPrimary;

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        int r100 = ((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.finishPrimaryWithSecondary) * 31) + this.finishSecondaryWithPrimary) * 31;
        if (this.clearTop == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final int getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final int getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SplitPairRule) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        SplitPairRule r101 = (SplitPairRule) r100;
        if (Intrinsics.areEqual(this.filters, r101.filters) == true) goto L15;
        return false;
    L15:
        if (this.finishPrimaryWithSecondary == r101.finishPrimaryWithSecondary) goto L18;
        return false;
    L18:
        if (this.finishSecondaryWithPrimary == r101.finishSecondaryWithPrimary) goto L21;
        return false;
    L21:
        if (this.clearTop == r101.clearTop) goto L23;
        return false;
    L23:
        return true;
    }

    public final SplitPairRule plus$window_release(SplitPairFilter r110) {
        Intrinsics.checkNotNullParameter(r110, "filter");
        LinkedHashSet r100 = new LinkedHashSet();
        r100.addAll(this.filters);
        r100.add(r110);
        return new SplitPairRule(CollectionsKt.toSet(r100), this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    public SplitPairRule(Set<SplitPairFilter> r100, int r101, int r102, boolean r103, int r104, int r105, float r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "filters");
        super(r104, r105, r106, r107);
        this.finishPrimaryWithSecondary = r101;
        this.finishSecondaryWithPrimary = r102;
        this.clearTop = r103;
        this.filters = CollectionsKt.toSet(r100);
    }

    public /* synthetic */ SplitPairRule(Set r100, int r101, int r110, boolean r111, int r112, int r113, float r114, int r115, int r116, DefaultConstructorMarker r117) {
        int r102 = 0;
        if ((r116 & 2) == 0) goto L5;
        int r103 = 0;
    L7:
        if ((r116 & 4) == 0) goto L9;
        int r104 = 1;
    L11:
        if ((r116 & 8) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r116 & 16) == 0) goto L17;
        int r106 = 0;
    L19:
        if ((r116 & 32) != 0) goto L23;
        r102 = r113;
    L23:
        if ((r116 & 64) == 0) goto L25;
        float r107 = 0.5f;
    L27:
        if ((r116 & 128) == 0) goto L29;
        int r108 = 3;
    L30:
        this(r100, r103, r104, r105, r106, r102, r107, r108);
        return;
    L29:
        r108 = r115;
        goto L30
    L25:
        r107 = r114;
        goto L27
    L17:
        r106 = r112;
        goto L19
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}
