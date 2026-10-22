package com.obric.ui.dialog.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/ui/dialog/selection/SelectionButton;", "", "show", "", "text", "", "onClick", "Lkotlin/Function0;", "", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getShow", "()Z", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionButton {
    private final Function0<Unit> onClick;
    private final boolean show;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SelectionButton copy$default(SelectionButton r0, boolean r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.text;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.onClick;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.text;
    }

    public final Function0<Unit> component3() {
        return this.onClick;
    }

    public final SelectionButton copy(boolean r1, String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return new SelectionButton(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectionButton) == true) goto L8;
        return false;
    L8:
        SelectionButton r6 = (SelectionButton) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onClick, r6.onClick) == true) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.show;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.text.hashCode()) * 31;
        Function0<Unit> r3 = this.onClick;
        if (r3 != null) goto L8;
        int r4 = 0;
    L10:
        return r2 + r4;
    L8:
        r4 = r3.hashCode();
        goto L10
    }

    public String toString() {
        return "SelectionButton(show=" + this.show + ", text=" + this.text + ", onClick=" + this.onClick + ')';
    }

    public SelectionButton(boolean r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.show = r2;
        this.text = r3;
        this.onClick = r4;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getText() {
        return this.text;
    }
}
