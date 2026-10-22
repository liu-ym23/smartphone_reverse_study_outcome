package androidx.window.embedding;

import android.content.Intent;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0004H\u0080\u0002¢\u0006\u0002\b\u001eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitRule;", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "placeholderIntent", "Landroid/content/Intent;", "isSticky", "", "finishPrimaryWithSecondary", "", "minWidth", "minSmallestWidth", "splitRatio", "", "layoutDirection", "(Ljava/util/Set;Landroid/content/Intent;ZIIIFI)V", "getFilters", "()Ljava/util/Set;", "getFinishPrimaryWithSecondary", "()I", "()Z", "getPlaceholderIntent", "()Landroid/content/Intent;", "equals", "other", "", "hashCode", "plus", "filter", "plus$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final int finishPrimaryWithSecondary;
    private final boolean isSticky;
    private final Intent placeholderIntent;

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        int r100 = ((super.hashCode() * 31) + this.placeholderIntent.hashCode()) * 31;
        if (this.isSticky == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.finishPrimaryWithSecondary) * 31) + this.filters.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final int getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    public final boolean isSticky() {
        return this.isSticky;
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SplitPlaceholderRule) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        SplitPlaceholderRule r101 = (SplitPlaceholderRule) r100;
        if (Intrinsics.areEqual(this.placeholderIntent, r101.placeholderIntent) == true) goto L15;
        return false;
    L15:
        if (this.isSticky == r101.isSticky) goto L18;
        return false;
    L18:
        if (this.finishPrimaryWithSecondary == r101.finishPrimaryWithSecondary) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.filters, r101.filters) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter r110) {
        Intrinsics.checkNotNullParameter(r110, "filter");
        LinkedHashSet r100 = new LinkedHashSet();
        r100.addAll(this.filters);
        r100.add(r110);
        return new SplitPlaceholderRule(CollectionsKt.toSet(r100), this.placeholderIntent, this.isSticky, this.finishPrimaryWithSecondary, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    public SplitPlaceholderRule(Set<ActivityFilter> r100, Intent r101, boolean r102, int r103, int r104, int r105, float r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "filters");
        Intrinsics.checkNotNullParameter(r101, "placeholderIntent");
        super(r104, r105, r106, r107);
        this.placeholderIntent = r101;
        this.isSticky = r102;
        this.finishPrimaryWithSecondary = r103;
        this.filters = CollectionsKt.toSet(r100);
    }

    public /* synthetic */ SplitPlaceholderRule(Set r110, Intent r111, boolean r112, int r113, int r114, int r115, float r116, int r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 8) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r210 & 16) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r210 & 32) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r210 & 64) == 0) goto L17;
        float r103 = 0.5f;
    L19:
        if ((r210 & 128) == 0) goto L21;
        int r118 = 3;
    L22:
        this(r110, r111, r112, r100, r101, r102, r103, r118);
        return;
    L21:
        r118 = r117;
        goto L22
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
