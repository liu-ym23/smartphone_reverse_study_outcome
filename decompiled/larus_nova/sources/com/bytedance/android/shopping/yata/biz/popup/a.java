package com.bytedance.android.shopping.yata.biz.popup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior;
import com.bytedance.android.shopping.yata.biz.popup.component.c;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundFrameLayout;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.larus.nova.R;
import hl3.d;
import hl3.e;
import hl3.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements hl3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f187506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f187507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<hl3.b> f187508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f187509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final il3.a f187510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f187511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super hl3.a, Unit> f187512g;

    public a() {
        throw null;
    }

    public final d a() {
        c r100 = this.f187509d;
        hl3.c r101 = null;
        if (r100 == null) goto L5;
        hl3.c r102 = r100.f187555b;
    L7:
        if ((r102 instanceof d) == false) goto L11;
        r101 = r102;
    L11:
        return (d) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final View b() {
        c r100 = this.f187509d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f187560e;
    }

    @Override // hl3.a
    public final void dismiss() {
        c r100 = this.f187509d;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    public final int hashCode() {
        return this.f187511f.hashCode();
    }

    @Override // hl3.a
    public final void init() {
        e r100 = this.f187507b;
        if (r100 == null) goto L5;
        r100.e(this.f187510e);
    L5:
        Iterator<hl3.b> r101 = this.f187508c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().e(this.f187510e);
        goto L7
    L9:
        c r102 = this.f187509d;
        if (r102 == null) goto L113;
        r102.f187554a = this;
        r102.f187555b = new com.bytedance.android.shopping.yata.biz.popup.component.e(r102.getContext(), (String) r102.c("schema", ""), r102.f187554a);
        Drawable r103 = null;
        View r104 = View.inflate(r102.getContext(), R.layout.yata_popup_bottom, null);
        r102.f187560e = r104;
        if (r104 == null) goto L96;
        RoundFrameLayout r105 = (RoundFrameLayout) r104.findViewById(R.id.commerce_design_sheet);
        if (r105 == null) goto L96;
        int r106 = SheetBaseBehavior.f187546g;
        Intrinsics.checkNotNull(r105);
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if ((r107 instanceof CoordinatorLayout.LayoutParams) == false) goto L95;
        CoordinatorLayout.Behavior r108 = ((CoordinatorLayout.LayoutParams) r107).getBehavior();
        if ((r108 instanceof SheetBaseBehavior) == false) goto L93;
        SheetBaseBehavior<?> r109 = (SheetBaseBehavior) r108;
        Boolean r110 = Boolean.TRUE;
        r109.f187547a = ((Boolean) r102.c("hide_able", r110)).booleanValue();
        if (((Boolean) r102.c("enable_pull_up", Boolean.FALSE)).booleanValue() == false) goto L23;
        r109.setPeekHeight((int) ((Number) r102.c("collapsed_height", Float.valueOf(0.0f))).floatValue());
        boolean r111 = false;
    L24:
        r109.f187549c = r111;
        r109.f187550d = ((Boolean) r102.c("disable_drag_down", r110)).booleanValue();
        r109.f187548b = r102;
        Unit r112 = Unit.INSTANCE;
        r102.f187562g = r109;
        int r113 = (int) ((Number) r102.c("height", Float.valueOf(-1.0f))).floatValue();
        int r114 = -1;
        if (r113 != (-1)) goto L27;
        r113 = (int) (k1.j(r102.getContext()) * 0.73f);
    L27:
        ViewGroup.LayoutParams r115 = r105.getLayoutParams();
        r115.height = r113;
        r105.setLayoutParams(r115);
        View r116 = r102.f187560e;
        if (r116 == null) goto L30;
        FrameLayout r117 = (FrameLayout) r116.findViewById(R.id.inner_sheet_container);
    L31:
        if (r117 == null) goto L33;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
    L35:
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        r118 = null;
    L37:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        if (r119 == null) goto L40;
        r119.bottomMargin = ((Number) r102.c("bottom_offset", 0)).intValue();
        r117.setLayoutParams(r119);
    L40:
        hl3.c r120 = r102.f187555b;
        if (r120 == null) goto L96;
        View r121 = r120.getView();
        if (r121 == null) goto L96;
        r105.addView(r121);
        Iterable r122 = (Iterable) r102.c("radius", CollectionsKt.listOf(new Integer[]{20, 20, 0, 0}));
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
    L47:
        if (r124.hasNext() == false) goto L124;
        Object r125 = r124.next();
        if ((r125 instanceof Number) == true) goto L51;
        r125 = null;
    L51:
        Number r126 = (Number) r125;
        if (r126 == null) goto L54;
        float r127 = r126.floatValue();
    L55:
        r123.add(Float.valueOf(r127));
        goto L47
    L54:
        r127 = 0.0f;
        goto L55
    L124:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L58
        int r129 = s.f45717a;     // Catch: Throwable -> L58
        Object r130 = Result.m9449constructorimpl(s.b((String) r102.c("bg_color", CustomHeaderConfig.COLOR_LIGHT)));     // Catch: Throwable -> L58
    L61:
        if (Result.m9455isFailureimpl(r130) == false) goto L63;
        r130 = null;
    L63:
        Integer r131 = (Integer) r130;
        if (r131 == null) goto L66;
        r114 = r131.intValue();
    L66:
        Drawable r132 = r105.getBackground();
        if ((r132 instanceof BackgroundDrawable) == false) goto L70;
        r103 = r132;
    L70:
        BackgroundDrawable r133 = (BackgroundDrawable) r103;
        if (r133 == null) goto L89;
        r133.setBgColor(r114);
        Float r134 = (Float) CollectionsKt.getOrNull(r123, 0);
        float r135 = 20.0f;
        if (r134 == null) goto L75;
        float r136 = r134.floatValue();
    L76:
        r133.setCornerRadiusTL(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r136)));
        Float r137 = (Float) CollectionsKt.getOrNull(r123, 1);
        if (r137 == null) goto L79;
        r135 = r137.floatValue();
    L79:
        r133.setCornerRadiusTR(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r135)));
        Float r138 = (Float) CollectionsKt.getOrNull(r123, 2);
        if (r138 == null) goto L82;
        float r139 = r138.floatValue();
    L83:
        r133.setCornerRadiusBR(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r139)));
        Float r140 = (Float) CollectionsKt.getOrNull(r123, 3);
        if (r140 == null) goto L86;
        float r141 = r140.floatValue();
    L87:
        r133.setCornerRadiusBL(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r141)));
        r133.invalidate();
        goto L89
    L86:
        r141 = 0.0f;
        goto L87
    L82:
        r139 = 0.0f;
        goto L83
    L75:
        r136 = 20.0f;
    L89:
        if (((Boolean) r102.c("render_safe_area", Boolean.TRUE)).booleanValue() == false) goto L91;
        r105.setPadding(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(20));
        goto L96
    L91:
        r105.setPadding(0, 0, 0, 0);
    L58:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L61
    L33:
        r118 = null;
        goto L35
    L30:
        r117 = null;
        goto L31
    L23:
        r111 = true;
        goto L24
    L93:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L95:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    L96:
        Boolean r143 = Boolean.FALSE;
        boolean r144 = ((Boolean) r102.c("has_mask", r143)).booleanValue();
        r102.f187564i = r144;
        if (r144 == false) goto L113;
        View r145 = r102.f187560e;
        if (r145 == null) goto L113;
        View r146 = r145.findViewById(R.id.commerce_touch_outside);
        if (r146 == null) goto L113;
        r102.f187561f = r146;
        r102.f187565j = ((Boolean) r102.c("allow_close_by_touch_mask", r143)).booleanValue();
        View r147 = r102.f187561f;
        if (r147 == null) goto L107;
        r147.setOnClickListener(r102);
    L107:
        int r148 = ((Number) r102.c("mask_color", 0)).intValue();
        View r149 = r102.f187561f;
        if (r149 == null) goto L110;
        r149.setBackgroundColor(r148);
    L110:
        View r150 = r102.f187561f;
        if (r150 == null) goto L113;
        r150.setAlpha(0.0f);
    L113:
        Function1<? super hl3.a, Unit> r151 = this.f187512g;
        if (r151 == null) goto L116;
        Unit r152 = r151.invoke(this);
    L116:
        e r153 = this.f187507b;
        if (r153 == null) goto L119;
        r153.c(this);
    L119:
        Iterator<hl3.b> r154 = this.f187508c.iterator();
    L121:
        if (r154.hasNext() == false) goto L123;
        r154.next().c(this);
        goto L121
    }

    @Override // hl3.a
    public final void show() {
        c r100 = this.f187509d;
        if (r100 == null) goto L8;
        hl3.c r101 = r100.f187555b;
        if (r101 == null) goto L9;
        r101.b(r100.f187557d, new com.bytedance.android.shopping.yata.biz.popup.component.b(r100));
        return;
    L9:
        return;
    }

    @Override // hl3.a
    public final String getId() {
        return this.f187511f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(this.f187511f, ((a) r100).f187511f)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.yata.biz.popup.PopupCard");
    L8:
        r101 = null;
        goto L10
    }

    public a(WeakReference r100, il3.a r101) {
        String r102 = r101.b();
        Intrinsics.checkNotNullParameter(r100, "contextRef");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "id");
        this.f187510e = r101;
        this.f187511f = r102;
        c r103 = null;
        this.f187512g = null;
        this.f187508c = new ArrayList();
        Context r104 = (Context) r100.get();
        if (r104 == null) goto L5;
        r103 = new c(r104, r101);
    L5:
        this.f187509d = r103;
    }
}
