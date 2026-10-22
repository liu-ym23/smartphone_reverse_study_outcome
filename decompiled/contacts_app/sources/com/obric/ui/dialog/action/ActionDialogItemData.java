package com.obric.ui.dialog.action;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/ui/dialog/action/ActionDialogItemData;", "", "title", "", "buttonStyle", "Lcom/obric/ui/dialog/action/ActionButtonStyle;", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Lcom/obric/ui/dialog/action/ActionButtonStyle;Landroid/view/View$OnClickListener;)V", "getButtonStyle", "()Lcom/obric/ui/dialog/action/ActionButtonStyle;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActionDialogItemData {
    private final ActionButtonStyle buttonStyle;
    private final View.OnClickListener onClickListener;
    private final String title;

    public static /* synthetic */ ActionDialogItemData copy$default(ActionDialogItemData r0, String r1, ActionButtonStyle r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.buttonStyle;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.onClickListener;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.title;
    }

    public final ActionButtonStyle component2() {
        return this.buttonStyle;
    }

    public final View.OnClickListener component3() {
        return this.onClickListener;
    }

    public final ActionDialogItemData copy(String r1, ActionButtonStyle r2, View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "buttonStyle");
        return new ActionDialogItemData(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionDialogItemData) == true) goto L8;
        return false;
    L8:
        ActionDialogItemData r6 = (ActionDialogItemData) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (this.buttonStyle == r6.buttonStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onClickListener, r6.onClickListener) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.title.hashCode() * 31) + this.buttonStyle.hashCode()) * 31;
        View.OnClickListener r2 = this.onClickListener;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionDialogItemData(title=" + this.title + ", buttonStyle=" + this.buttonStyle + ", onClickListener=" + this.onClickListener + ')';
    }

    public ActionDialogItemData(String r2, ActionButtonStyle r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "buttonStyle");
        this.title = r2;
        this.buttonStyle = r3;
        this.onClickListener = r4;
    }

    public /* synthetic */ ActionDialogItemData(String r1, ActionButtonStyle r2, View.OnClickListener r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final ActionButtonStyle getButtonStyle() {
        return this.buttonStyle;
    }

    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }
}
