package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.GlobalProxyLancet;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.OPopoverLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverMenuView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J\u000e\u0010\u0010\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\nJ(\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001cH\u0004J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0007H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006+"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forceDark", "", "getForceDark", "()Z", "setForceDark", "(Z)V", "hasAligned", "ignoreWidthConstraint", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "pressedWithArrow", "getPressedWithArrow", "setPressedWithArrow", "collectMenuItemLayout", "", "view", "Landroid/view/View;", "list", "", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "findMenuItem", "", "findOPopoverLayout", "Lcom/obric/oui/popover/OPopoverLayout;", "ignore", "onSizeChanged", "w", "h", "oldw", "oldh", "registerPressedCallback", "itemView", "setPopoverMaxHeight", "maxHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OPopoverMenuView extends LinearLayout {
    private boolean forceDark;
    private boolean hasAligned;
    private boolean ignoreWidthConstraint;
    private boolean pressedWithArrow;

    public OPopoverMenuView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPopoverMenuView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public void setPopoverMaxHeight(int r1) {
    }

    public /* synthetic */ OPopoverMenuView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OPopoverMenuView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.ignoreWidthConstraint = true;
    }

    protected final boolean getForceDark() {
        return this.forceDark;
    }

    protected final void setForceDark(boolean r1) {
        this.forceDark = r1;
    }

    protected final boolean getPressedWithArrow() {
        return this.pressedWithArrow;
    }

    protected final void setPressedWithArrow(boolean r1) {
        this.pressedWithArrow = r1;
    }

    protected final boolean getIgnoreWidthConstraint() {
        return this.ignoreWidthConstraint;
    }

    protected final void setIgnoreWidthConstraint(boolean r1) {
        this.ignoreWidthConstraint = r1;
    }

    protected final OPopoverLayout findOPopoverLayout(View r3) {
        if (r3 != null) goto L5;
        OPopoverLayout r2 = (OPopoverLayout) null;
        return null;
    L5:
        if ((r3 instanceof OPopoverLayout) == false) goto L8;
        return (OPopoverLayout) r3;
    L8:
        if (r3.getParent() == null) goto L14;
        ViewParent r4 = r3.getParent();
        if (r4 == null) goto L13;
        return findOPopoverLayout((ViewGroup) r4);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L14:
        OPopoverLayout r5 = (OPopoverLayout) null;
        return null;
    }

    protected final void registerPressedCallback(final PopoverMenuLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        if (this.pressedWithArrow == false) goto L6;
        r2.setNotifyPressedCallback(new AnonymousClass1(this, r2));
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        StringBuilder r7 = new StringBuilder("onSizeChanged() called with: w = ");
        Context r8 = getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OPopoverMenu", r7.append(OUnitExtensionKt.px2dp(r8, r3)).append("dp").toString());
        if (r3 > 0) goto L5;
    L14:
        OUnitExtensionKt.vdp(this, 188);
        return;
    L5:
        if (this.hasAligned == true) goto L14;
        this.hasAligned = true;
        Iterator<T> r9 = findMenuItem().iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        PopoverMenuLinearLayout r10 = (PopoverMenuLinearLayout) r9.next();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L13;
        r11.width = (r3 - getPaddingLeft()) - getPaddingRight();
        r10.setLayoutParams(r11);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void ignoreWidthConstraint(boolean r1) {
        this.ignoreWidthConstraint = r1;
    }

    private final List<PopoverMenuLinearLayout> findMenuItem() {
        ArrayList r0 = new ArrayList();
        collectMenuItemLayout(this, r0);
        return r0;
    }

    private final void collectMenuItemLayout(View r2, List<PopoverMenuLinearLayout> r3) {
        if ((r2 instanceof PopoverMenuLinearLayout) == false) goto L7;
        r3.add(r2);
        return;
    L7:
        if ((r2 instanceof ViewGroup) == false) goto L12;
        Iterator<View> r4 = ViewGroupKt.getChildren((ViewGroup) r2).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        collectMenuItemLayout(r4.next(), r3);
        goto L10
    L14:
        return;
    }
}
