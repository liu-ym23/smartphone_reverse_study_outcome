package androidx.window.embedding;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitPairRule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0080\u0002¢\u0006\u0002\b\u001cR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitRule;", "filters", "", "Landroidx/window/embedding/SplitPairFilter;", "finishPrimaryWithSecondary", "", "finishSecondaryWithPrimary", "clearTop", "minWidth", "", "minSmallestWidth", "splitRatio", "", "layoutDir", "(Ljava/util/Set;ZZZIIFI)V", "getClearTop", "()Z", "getFilters", "()Ljava/util/Set;", "getFinishPrimaryWithSecondary", "getFinishSecondaryWithPrimary", "equals", "other", "", "hashCode", "plus", "filter", "plus$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    public /* synthetic */ SplitPairRule(Set r8, boolean r9, boolean r10, boolean r11, int r12, int r13, float r14, int r15, int r16, DefaultConstructorMarker r17) {
        int r2 = 0;
        if ((r16 & 2) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r16 & 4) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r16 & 16) == 0) goto L17;
        int r5 = 0;
    L19:
        if ((r16 & 32) != 0) goto L23;
        r2 = r13;
    L23:
        if ((r16 & 64) == 0) goto L25;
        float r6 = 0.5f;
    L27:
        if ((r16 & 128) == 0) goto L29;
        int r0 = 3;
    L30:
        this(r8, r1, r3, r4, r5, r2, r6, r0);
        return;
    L29:
        r0 = r15;
        goto L30
    L25:
        r6 = r14;
        goto L27
    L17:
        r5 = r12;
        goto L19
    L13:
        r4 = r11;
        goto L15
    L9:
        r3 = r10;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public SplitPairRule(Set<SplitPairFilter> r2, boolean r3, boolean r4, boolean r5, int r6, int r7, float r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "filters");
        super(r6, r7, r8, r9);
        this.finishPrimaryWithSecondary = r3;
        this.finishSecondaryWithPrimary = r4;
        this.clearTop = r5;
        this.filters = CollectionsKt.toSet(r2);
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final SplitPairRule plus$window_release(SplitPairFilter r12) {
        Intrinsics.checkNotNullParameter(r12, "filter");
        LinkedHashSet r0 = new LinkedHashSet();
        r0.addAll(this.filters);
        r0.add(r12);
        return new SplitPairRule(CollectionsKt.toSet(r0), this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SplitPairRule) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        SplitPairRule r6 = (SplitPairRule) r5;
        if (Intrinsics.areEqual(this.filters, r6.filters) == true) goto L15;
        return false;
    L15:
        if (this.finishPrimaryWithSecondary == r6.finishPrimaryWithSecondary) goto L18;
        return false;
    L18:
        if (this.finishSecondaryWithPrimary == r6.finishSecondaryWithPrimary) goto L21;
        return false;
    L21:
        if (this.clearTop == r6.clearTop) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + Boolean.hashCode(this.finishPrimaryWithSecondary)) * 31) + Boolean.hashCode(this.finishSecondaryWithPrimary)) * 31) + Boolean.hashCode(this.clearTop);
    }
}
