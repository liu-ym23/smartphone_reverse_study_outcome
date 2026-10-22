package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ab;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.OPopoverLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OPopoverMenuView.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OPopoverMenuView extends LinearLayout {
    private boolean forceDark;
    private boolean hasAligned;
    private boolean ignoreWidthConstraint;
    private boolean pressedWithArrow;

    /* JADX INFO: compiled from: OPopoverMenuView.kt */
    static final class a extends p implements m<Boolean, Integer, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPopoverMenuView f36028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PopoverMenuLinearLayout f36029b;

        /* JADX INFO: renamed from: com.obric.oui.popover.menu.OPopoverMenuView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OPopoverMenuView.kt */
        public /* synthetic */ class C0974a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f36030a = null;

            static {
                int[] r0 = new int[PopoverMenuLinearLayout.a.values().length];
                r0[PopoverMenuLinearLayout.a.f36031a.ordinal()] = 1;
                r0[PopoverMenuLinearLayout.a.f36032b.ordinal()] = 2;
                r0[PopoverMenuLinearLayout.a.f36034d.ordinal()] = 3;
                f36030a = r0;
            }
        }

        a(OPopoverMenuView r1, PopoverMenuLinearLayout r2) {
            this.f36028a = r1;
            this.f36029b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Integer r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
            return x.f38692a;
        }

        public final void a(boolean r6, int r7) {
            OPopoverMenuView r0 = this.f36028a;
            OPopoverLayout r1 = r0.findOPopoverLayout((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
            if (r1 == null) goto L20;
            int r5 = C0974a.f36030a[this.f36029b.getIndexPos().ordinal()];
            boolean r2 = false;
            if (r5 == 1) goto L15;
            if (r5 == 2) goto L12;
            if (r5 != 3) goto L17;
        L10:
            r2 = true;
        L17:
            if (r2 == false) goto L21;
            r1.notifyPressed(r6, r7);
            return;
        L21:
            return;
        L12:
            if (r1.arrowDirection() != 3) goto L17;
        L15:
            if (r1.arrowDirection() != 0) goto L17;
        }
    }

    public OPopoverMenuView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPopoverMenuView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public void setPopoverMaxHeight(int r1) {
    }

    public /* synthetic */ OPopoverMenuView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OPopoverMenuView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.ignoreWidthConstraint = true;
    }

    public final boolean getForceDark() {
        return this.forceDark;
    }

    public final void setForceDark(boolean r1) {
        this.forceDark = r1;
    }

    public final boolean getPressedWithArrow() {
        return this.pressedWithArrow;
    }

    public final void setPressedWithArrow(boolean r1) {
        this.pressedWithArrow = r1;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.ignoreWidthConstraint;
    }

    public final void setIgnoreWidthConstraint(boolean r1) {
        this.ignoreWidthConstraint = r1;
    }

    public final OPopoverLayout findOPopoverLayout(View r4) {
        if (r4 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, OPopoverLayout.class) == false) goto L8;
        return (OPopoverLayout) ZeusTransformUtils.preCheckCast(r4, OPopoverLayout.class, "com.obric.aiagent.plugin");
    L8:
        if (r4.getParent() == null) goto L15;
        ViewParent r5 = r4.getParent();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        return findOPopoverLayout((View) ZeusTransformUtils.preCheckCast((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin"), View.class, "com.obric.aiagent.plugin"));
    L15:
        return (OPopoverLayout) ZeusTransformUtils.preCheckCast(null, OPopoverLayout.class, "com.obric.aiagent.plugin");
    L12:
        return (OPopoverLayout) ZeusTransformUtils.preCheckCast(null, OPopoverLayout.class, "com.obric.aiagent.plugin");
    }

    public final void registerPressedCallback(PopoverMenuLinearLayout r3) {
        o.e(r3, "itemView");
        if (this.pressedWithArrow == false) goto L6;
        r3.setNotifyPressedCallback((m) ZeusTransformUtils.preCheckCast(new a(this, r3), m.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        StringBuilder r8 = new StringBuilder().append("onSizeChanged() called with: w = ");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "context");
        INVOKESTATIC_com_obric_oui_popover_menu_OPopoverMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("OPopoverMenu", r8.append(g.a(r9, r4)).append("dp").toString());
        if (r4 > 0) goto L5;
    L10:
        g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 188);
        return;
    L5:
        if (this.hasAligned == true) goto L10;
        this.hasAligned = true;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(findMenuItem(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        View r11 = (View) ZeusTransformUtils.preCheckCast((PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(r10.next(), PopoverMenuLinearLayout.class, "com.obric.aiagent.plugin"), View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r0.width = (r4 - getPaddingLeft()) - getPaddingRight();
        r11.setLayoutParams(r0);
        goto L8
    }

    public final void ignoreWidthConstraint(boolean r1) {
        this.ignoreWidthConstraint = r1;
    }

    private final List<PopoverMenuLinearLayout> findMenuItem() {
        List<PopoverMenuLinearLayout> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        collectMenuItemLayout((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void collectMenuItemLayout(View r4, List<PopoverMenuLinearLayout> r5) {
        List<PopoverMenuLinearLayout> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, PopoverMenuLinearLayout.class) == false) goto L7;
        r6.add(r4);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L12;
        Iterator<View> r7 = ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).a();
    L10:
        if (r7.hasNext() == false) goto L14;
        collectMenuItemLayout((View) ZeusTransformUtils.preCheckCast(r7.next(), View.class, "com.obric.aiagent.plugin"), r6);
        goto L10
    L14:
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_popover_menu_OPopoverMenuView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
