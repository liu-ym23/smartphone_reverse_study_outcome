package com.obric.oui.filter;

import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.common.util.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterGroup.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\rJ\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0010J)\u0010\u001b\u001a\u00020\r2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\u001cJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020 J\u0006\u0010!\u001a\u00020\rJ\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u0010J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010&\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006)"}, d2 = {"Lcom/obric/oui/filter/FilterGroup;", "", "()V", "children", "Ljava/util/ArrayList;", "Lcom/obric/oui/filter/OFilter;", "listener", "Lcom/obric/oui/filter/FilterGroup$onItemSelectedListener;", "<set-?>", "selected", "getSelected", "()Lcom/obric/oui/filter/OFilter;", "add", "", "btn", "autoSelectWhenClick", "", "addAllFilters", "view", "Landroid/view/ViewGroup;", "disableAll", "dismiss", "filter", "enable", "enableAll", "registerContainer", "selectFirst", "registerItemSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "select", "Landroid/view/View;", "selectFirstEnabledItem", "setDisabled", "calledByDisableAll", "setSelected", "setUnselected", "show", "showAll", "onItemSelectedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterGroup {
    private final ArrayList<OFilter> children;
    private onItemSelectedListener listener;
    private OFilter selected;

    /* JADX INFO: compiled from: FilterGroup.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/filter/FilterGroup$onItemSelectedListener;", "", "onItemSelected", "", "oFilter", "Lcom/obric/oui/filter/OFilter;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onItemSelectedListener {
        void onItemSelected(OFilter r1);
    }

    public static /* synthetic */ void $r8$lambda$aUGNRGX5C7AXOSw92hS0msmoDqE(FilterGroup r0, View r1) {
        m497add$lambda0(r0, r1);
    }

    public FilterGroup() {
        this.children = new ArrayList();
    }

    public final OFilter getSelected() {
        return this.selected;
    }

    public static /* synthetic */ void registerContainer$default(FilterGroup r0, ViewGroup r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.registerContainer(r1, r2);
    }

    public final void registerContainer(ViewGroup r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        addAllFilters(r2);
        if (r3 == true) goto L5;
        return;
    L5:
        if ((!this.children.isEmpty()) == false) goto L9;
        select((View) CollectionsKt.first(this.children));
        return;
    }

    private final void addAllFilters(ViewGroup r5) {
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r1 + 1;
        View r3 = r5.getChildAt(r1);
        if ((r3 instanceof ViewGroup) == false) goto L8;
        addAllFilters((ViewGroup) r3);
    L10:
        r1 = r2;
        goto L3
    L8:
        if ((r3 instanceof OFilter) == false) goto L10;
        add((OFilter) r3, true);
        goto L10
    }

    public static /* synthetic */ void add$default(FilterGroup r0, OFilter r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.add(r1, r2);
    }

    public final void add(OFilter r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "btn");
        this.children.add(r2);
        if (r3 == false) goto L6;
        r2.setOnClickListener(new FilterGroup$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: add$lambda-0, reason: not valid java name */
    private static final void m497add$lambda0(FilterGroup r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.select(r2);
    }

    public final void select(View r4) {
        Intrinsics.checkNotNullParameter(r4, "btn");
        Iterator<T> r0 = this.children.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        OFilter r1 = (OFilter) r0.next();
        if (Intrinsics.areEqual(r1, r4) == true) goto L4;
        setUnselected(r1);
        goto L4
    L8:
        setSelected((OFilter) r4);
    }

    private final void setSelected(OFilter r2) {
        r2.setSelected(true);
        this.selected = r2;
        onItemSelectedListener r1 = this.listener;
        if (r1 == null) goto L7;
        r1.onItemSelected(r2);
        return;
    }

    private final void setUnselected(OFilter r1) {
        r1.setSelected(false);
    }

    public static /* synthetic */ void setDisabled$default(FilterGroup r0, OFilter r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setDisabled(r1, r2);
    }

    public final void setDisabled(OFilter r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        if (r3.isSelected() == false) goto L5;
        r3.setSelected(false);
    L5:
        r3.setEnabled(false);
        if (r4 == true) goto L9;
        selectFirstEnabledItem();
        return;
    }

    public final void selectFirstEnabledItem() {
        Iterator<OFilter> r0 = this.children.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        OFilter r1 = r0.next();
        if (r1.isEnabled() == false) goto L4;
        Intrinsics.checkNotNullExpressionValue(r1, "child");
        OFilter r2 = r1;
        if (ViewExtensionsKt.isVisibile(r2) == false) goto L4;
        select(r2);
        return;
    }

    public final void dismiss(OFilter r4) {
        Intrinsics.checkNotNullParameter(r4, "filter");
        ViewExtensionsKt.makeGone(r4);
        Iterator<T> r5 = this.children.iterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        OFilter r0 = (OFilter) r5.next();
        OFilter r1 = r0;
        if (ViewExtensionsKt.isVisibile(r1) == false) goto L4;
        if (r0.isEnabled() == false) goto L4;
        select(r1);
        return;
    }

    public final void show(OFilter r1) {
        Intrinsics.checkNotNullParameter(r1, "filter");
        ViewExtensionsKt.makeVisible(r1);
    }

    public final void enable(OFilter r1) {
        Intrinsics.checkNotNullParameter(r1, "filter");
        r1.setEnabled(true);
    }

    public final void showAll() {
        Iterator<T> r1 = this.children.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ViewExtensionsKt.makeVisible((OFilter) r1.next());
        goto L4
    }

    public final void enableAll() {
        Iterator<T> r2 = this.children.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((OFilter) r2.next()).setEnabled(true);
        goto L4
    }

    public final void disableAll() {
        Iterator<T> r0 = this.children.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        setDisabled((OFilter) r0.next(), true);
        goto L4
    }

    public final void registerItemSelectedListener(onItemSelectedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listener = r2;
    }

    public final void registerItemSelectedListener(final Function1<? super OFilter, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listener = new AnonymousClass1(r2);
    }
}
