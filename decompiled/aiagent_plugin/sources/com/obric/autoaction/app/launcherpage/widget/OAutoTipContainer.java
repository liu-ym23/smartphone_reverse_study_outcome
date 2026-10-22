package com.obric.autoaction.app.launcherpage.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import androidx.lifecycle.d;
import androidx.lifecycle.i;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.e;
import androidx.transition.s;
import androidx.transition.v;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: OAutoTipContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoTipContainer extends OUIFrameLayout implements d {
    public static final a Companion = null;
    private boolean addIconGuideChecked;
    private final OAutoAddIconGuideView addIconGuideView;
    private boolean checkPermissionShowed;
    private final OAutoPermissionCheckView checkPermissionView;
    private boolean enableAddIconGuide;
    private final OUIFrameLayout glassLayer;
    private boolean isDismissing;
    private am scope;
    private d.h.a.b<? super Boolean, x> visibilityListener;

    /* JADX INFO: compiled from: OAutoTipContainer.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final boolean a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            if (l.a(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (l.d() == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: compiled from: OAutoTipContainer.kt */
    @f(b = "OAutoTipContainer.kt", c = {151, 176}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoTipContainer$checkVisibility$1")
    static final class b extends d.c.b.a.l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OAutoTipContainer f24559b;

        b(OAutoTipContainer r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24559b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24559b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24558a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r6);
        L28:
            boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            if (r7 == true) goto L31;
        L34:
            if (r7 == true) goto L37;
            OAutoTipContainer.access$setAddIconGuideChecked$p(this.f24559b, true);
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getCheckPermissionView(), View.class, "com.obric.aiagent.plugin"));
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getAddIconGuideView(), View.class, "com.obric.aiagent.plugin"));
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b, View.class, "com.obric.aiagent.plugin"));
        L37:
            return x.f38692a;
        L31:
            if (OAutoTipContainer.access$getAddIconGuideChecked$p(this.f24559b) == true) goto L34;
            OAutoTipContainer.access$setAddIconGuideChecked$p(this.f24559b, true);
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getCheckPermissionView(), View.class, "com.obric.aiagent.plugin"));
            k.a((View) ZeusTransformUtils.preCheckCast(this.f24559b.getAddIconGuideView(), View.class, "com.obric.aiagent.plugin"));
            k.a((View) ZeusTransformUtils.preCheckCast(this.f24559b, View.class, "com.obric.aiagent.plugin"));
            com.obric.event.task.base.report.a.a(com.obric.event.task.base.report.a.f32756a, null, 1, null);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r6);
        L14:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L18;
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getAddIconGuideView(), View.class, "com.obric.aiagent.plugin"));
            k.a((View) ZeusTransformUtils.preCheckCast(this.f24559b.getCheckPermissionView(), View.class, "com.obric.aiagent.plugin"));
            OAutoTipContainer.access$setCheckPermissionShowed$p(this.f24559b, true);
            k.a((View) ZeusTransformUtils.preCheckCast(this.f24559b, View.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L18:
            if (OAutoTipContainer.access$getCheckPermissionShowed$p(this.f24559b) == false) goto L22;
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getCheckPermissionView(), View.class, "com.obric.aiagent.plugin"));
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getAddIconGuideView(), View.class, "com.obric.aiagent.plugin"));
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b, View.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L22:
            if (this.f24559b.getEnableAddIconGuide() == true) goto L25;
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getCheckPermissionView(), View.class, "com.obric.aiagent.plugin"));
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b.getAddIconGuideView(), View.class, "com.obric.aiagent.plugin"));
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24559b, View.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L25:
            OAutoAddIconGuideView r8 = this.f24559b.getAddIconGuideView();
            d.c.d<? super Boolean> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24558a = 2;
            r6 = r8.shouldShow(r2);
            if (r6 != r0) goto L28;
            return r0;
        L10:
            d.o.a(r6);
            OAutoPermissionCheckView r9 = this.f24559b.getCheckPermissionView();
            d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24558a = 1;
            r6 = r9.shouldShow(r3);
            if (r6 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OAutoTipContainer.kt */
    @f(b = "OAutoTipContainer.kt", c = {201}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoTipContainer$dismissWithAnimation$1")
    static final class c extends d.c.b.a.l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OAutoTipContainer f24561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f24562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f24563d;

        c(OAutoTipContainer r3, long r4, d.h.a.a<x> r6, d.c.d<? super c> r7) {
            d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24561b = r3;
            this.f24562c = r4;
            this.f24563d = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24561b, this.f24562c, this.f24563d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24560a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r9);
        L11:
            ViewParent r10 = this.f24561b.getParent();
            if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L14;
            ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.aiagent.plugin");
        L15:
            if (r11 == null) goto L17;
            OAutoTipContainer r2 = this.f24561b;
            s r3 = new Fade(2).a(200);
            o.c(r3, "setDuration(...)");
            e r5 = new e();
            r5.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), true);
            s r4 = r5.a(250);
            o.c(r4, "setDuration(...)");
            v r6 = new v().a(r3).a(r4).a(1);
            o.c(r6, "setOrdering(...)");
            TransitionManager.a(r11, (s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin"));
        L17:
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24561b, View.class, "com.obric.aiagent.plugin"));
            d.h.a.a<x> r12 = this.f24563d;
            if (r12 == null) goto L20;
            r12.invoke();
        L20:
            OAutoTipContainer.access$setDismissing$p(this.f24561b, false);
            return x.f38692a;
        L14:
            r11 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            OAutoTipContainer.access$setDismissing$p(this.f24561b, true);
            long r7 = this.f24562c;
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24560a = 1;
            if (ax.a(r7, r13) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public OAutoTipContainer(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OAutoTipContainer(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$SHqlvr-y4beXJ3f7vKvLezwzyLI, reason: not valid java name */
    public static /* synthetic */ x m576lambda$SHqlvry4beXJ3f7vKvLezwzyLI(OAutoTipContainer r0, boolean r1) {
        return setVisibilityListener$lambda$3(r0, r1);
    }

    public static /* synthetic */ x lambda$feox5UMlcxa2oGxVF6bK7bY_3XY(OAutoTipContainer r0, boolean r1) {
        return setVisibilityListener$lambda$2(r0, r1);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public /* synthetic */ OAutoTipContainer(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ boolean access$getAddIconGuideChecked$p(OAutoTipContainer r0) {
        return r0.addIconGuideChecked;
    }

    public static final /* synthetic */ boolean access$getCheckPermissionShowed$p(OAutoTipContainer r0) {
        return r0.checkPermissionShowed;
    }

    public static final /* synthetic */ void access$setAddIconGuideChecked$p(OAutoTipContainer r0, boolean r1) {
        r0.addIconGuideChecked = r1;
    }

    public static final /* synthetic */ void access$setCheckPermissionShowed$p(OAutoTipContainer r0, boolean r1) {
        r0.checkPermissionShowed = r1;
    }

    public static final /* synthetic */ void access$setDismissing$p(OAutoTipContainer r0, boolean r1) {
        r0.isDismissing = r1;
    }

    public OAutoTipContainer(Context r19, AttributeSet r20, int r21) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r2 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r2, r21, null, 8, null);
        this.enableAddIconGuide = true;
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.layout_oauto_tip_view_container, "layout", "layout_oauto_tip_view_container"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.glass_layer, DbHelper.COL_ID, "glass_layer"));
        o.c(r1, "findViewById(...)");
        OUIFrameLayout r3 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r1, OUIFrameLayout.class, "com.obric.aiagent.plugin");
        this.glassLayer = r3;
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.permission_check_view, DbHelper.COL_ID, "permission_check_view"));
        o.c(r4, "findViewById(...)");
        OAutoPermissionCheckView r5 = (OAutoPermissionCheckView) ZeusTransformUtils.preCheckCast(r4, OAutoPermissionCheckView.class, "com.obric.aiagent.plugin");
        this.checkPermissionView = r5;
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.add_icon_view, DbHelper.COL_ID, "add_icon_view"));
        o.c(r6, "findViewById(...)");
        OAutoAddIconGuideView r7 = (OAutoAddIconGuideView) ZeusTransformUtils.preCheckCast(r6, OAutoAddIconGuideView.class, "com.obric.aiagent.plugin");
        this.addIconGuideView = r7;
        r5.setContainer(this);
        if (Companion.a(r9) == false) goto L5;
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(0);
        r8.setCornerRadius(TypedValue.applyDimension(1, 99, Resources.getSystem().getDisplayMetrics()));
        r8.setColor(0);
        r3.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r8, Drawable.class, "com.obric.aiagent.plugin"));
        r3.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(true ^ isNightMode(r9))), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), false, 0, null, 14, null);
        r5.setBackground(null);
        r7.setBackground(null);
        return;
    L5:
        GradientDrawable r10 = new GradientDrawable();
        r10.setShape(0);
        r10.setCornerRadius(TypedValue.applyDimension(1, 99, Resources.getSystem().getDisplayMetrics()));
        int r0 = ZeusTransformUtils.mapRes(R.color.oui_bg_base_3, "color", "oui_bg_base_3");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "getContext(...)");
        r10.setColor(p.b(r0, r11, null, 2, null));
        r3.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r10, Drawable.class, "com.obric.aiagent.plugin"));
    }

    public final OAutoPermissionCheckView getCheckPermissionView() {
        return this.checkPermissionView;
    }

    public final OAutoAddIconGuideView getAddIconGuideView() {
        return this.addIconGuideView;
    }

    public final boolean getEnableAddIconGuide() {
        return this.enableAddIconGuide;
    }

    public final void setEnableAddIconGuide(boolean r1) {
        this.enableAddIconGuide = r1;
    }

    private final boolean isNightMode(Context r2) {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.lifecycle.p r0 = null;
        this.scope = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.b().a(), g.class, "com.obric.aiagent.plugin")));
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, androidx.lifecycle.p.class) == false) goto L5;
        r0 = (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r1, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
    L5:
        if (r0 == null) goto L9;
        i r2 = r0.getLifecycle();
        if (r2 == null) goto L9;
        r2.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
    L9:
        checkVisibility();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        am r0 = this.scope;
        androidx.lifecycle.p r1 = null;
        if (r0 == null) goto L5;
        an.a(r0, null, 1, null);
    L5:
        this.scope = null;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, androidx.lifecycle.p.class) == false) goto L8;
        r1 = (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r2, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L13;
        i r3 = r1.getLifecycle();
        if (r3 == null) goto L14;
        r3.b((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r4) {
        if (r4 == getVisibility()) goto L5;
        boolean r0 = true;
    L6:
        super.setVisibility(r4);
        if (r0 == false) goto L16;
        if (r4 != 0) goto L12;
        d.h.a.b<? super Boolean, x> r3 = this.visibilityListener;
        if (r3 == null) goto L17;
        r3.invoke(true);
        return;
    L17:
        return;
    L12:
        d.h.a.b<? super Boolean, x> r5 = this.visibilityListener;
        if (r5 == null) goto L19;
        r5.invoke(false);
        return;
    L19:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.lifecycle.d
    public void onResume(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.onResume(r4);
        checkVisibility();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        checkVisibility();
    }

    private final void checkVisibility() {
        if (this.isDismissing == false) goto L5;
        return;
    L5:
        am r1 = this.scope;
        if (r1 == null) goto L9;
        kotlinx.coroutines.i.a(r1, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public static /* synthetic */ void dismissWithAnimation$default(OAutoTipContainer r1, long r2, d.h.a.a r4, int r5, Object r6) {
        d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 1000;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        r1.dismissWithAnimation(r2, r7);
    }

    public final void dismissWithAnimation(long r14, d.h.a.a<x> r16) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.a.class, "com.obric.aiagent.plugin");
        am r8 = this.scope;
        if (r8 == null) goto L6;
        kotlinx.coroutines.i.a(r8, null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, r14, r6, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final void setVisibilityListener(d.h.a.b<? super Boolean, x> r3) {
        d.h.a.b<? super Boolean, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.visibilityListener = r4;
        this.checkPermissionView.setVisibilityListener(new $$Lambda$OAutoTipContainer$feox5UMlcxa2oGxVF6bK7bY_3XY(this));
        this.addIconGuideView.setVisibilityListener(new $$Lambda$OAutoTipContainer$SHqlvry4beXJ3f7vKvLezwzyLI(this));
    }

    private static final x setVisibilityListener$lambda$2(OAutoTipContainer r0, boolean r1) {
        r0.checkVisibility();
        return x.f38692a;
    }

    private static final x setVisibilityListener$lambda$3(OAutoTipContainer r0, boolean r1) {
        r0.checkVisibility();
        return x.f38692a;
    }
}
