package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.oui.popover.OPopoverLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0 H\u0002¢\u0006\u0004\b\"\u0010#R\"\u0010*\u001a\u00020$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\"\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u00100\u001a\u00020$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u0016\u00101\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010%¨\u00062"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "view", "Lcom/obric/oui/popover/OPopoverLayout;", "c", "(Landroid/view/View;)Lcom/obric/oui/popover/OPopoverLayout;", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "itemView", "", "d", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "maxHeight", "setPopoverMaxHeight", "(I)V", "", "b", "()Ljava/util/List;", "", ServerElements.LIST, "a", "(Landroid/view/View;Ljava/util/List;)V", "", "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "getPressedWithArrow", "setPressedWithArrow", "pressedWithArrow", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "ignoreWidthConstraint", "hasAligned", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OPopoverMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16196d;

    @JvmOverloads
    public OPopoverMenuView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(View r10, List r11) {
        if ((r10 instanceof PopoverMenuLinearLayout) == false) goto L7;
        r11.add(r10);
        return;
    L7:
        if ((r10 instanceof ViewGroup) == false) goto L12;
        Iterator r12 = ViewGroupKt.a((ViewGroup) r10).iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        a((View) r12.next(), r11);
        goto L10
    L14:
        return;
    }

    public final List b() {
        ArrayList r10 = new ArrayList();
        a(this, r10);
        return r10;
    }

    public final OPopoverLayout c(View r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r10 instanceof OPopoverLayout) == false) goto L8;
        return (OPopoverLayout) r10;
    L8:
        if (r10.getParent() == null) goto L16;
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L13;
        return c((ViewGroup) r11);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L16:
        return null;
    }

    public final void d(final PopoverMenuLinearLayout r10) {
        q.g(r10, "itemView");
        if (this.f16194b == false) goto L6;
        r10.setNotifyPressedCallback(new OPopoverMenuView$registerPressedCallback$1(this, r10));
        return;
    }

    public final boolean getForceDark() {
        return this.f16193a;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.f16195c;
    }

    public final boolean getPressedWithArrow() {
        return this.f16194b;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        StringBuilder r14 = new StringBuilder();
        r14.append("onSizeChanged() called with: w = ");
        Context r15 = getContext();
        q.f(r15, "context");
        r14.append(f.o(r15, r10));
        r14.append("dp");
        Log.e("OPopoverMenu", r14.toString());
        if (r10 > 0) goto L5;
    L14:
        f.r(this, 188);
        return;
    L5:
        if (this.f16196d == true) goto L14;
        this.f16196d = true;
        Iterator r16 = b().iterator();
    L8:
        if (r16.hasNext() == false) goto L14;
        PopoverMenuLinearLayout r17 = (PopoverMenuLinearLayout) r16.next();
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L13;
        r18.width = (r10 - getPaddingLeft()) - getPaddingRight();
        r17.setLayoutParams(r18);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setForceDark(boolean r10) {
        this.f16193a = r10;
    }

    public final void setIgnoreWidthConstraint(boolean r10) {
        this.f16195c = r10;
    }

    public void setPopoverMaxHeight(int r10) {
    }

    public final void setPressedWithArrow(boolean r10) {
        this.f16194b = r10;
    }

    @JvmOverloads
    public OPopoverMenuView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OPopoverMenuView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OPopoverMenuView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16195c = true;
    }
}
