package com.bytedance.android.ecom.arch.slice.render.util;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.Toast;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.bindinfo.SlcBindInfoKt;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.widget.background.SlcBackgroundDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaValue;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcViewExtensionsKt {

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSlcViewManager f50704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAction f50705b;

        public a(BaseSlcViewManager r100, IAction r101) {
            this.f50704a = r100;
            this.f50705b = r101;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            BaseSlcViewManager r101 = this.f50704a;
            SlcTemplateContext.e(r101.f50260a, this.f50705b, r100, r101.l(), "long_click_action", 8);
            return true;
        }
    }

    public static final boolean a(View r100) {
        if (r100.getVisibility() != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100.getAnimation() != null) goto L8;
        return false;
    }

    public static final com.bytedance.android.ecom.arch.slice.render.elements.g d(View r100) {
        Object r101 = r100.getTag(R.id.slc_view_manager);
        if ((r101 instanceof com.bytedance.android.ecom.arch.slice.render.elements.g) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.android.ecom.arch.slice.render.elements.g r102 = (com.bytedance.android.ecom.arch.slice.render.elements.g) r101;
        if (r102 == null) goto L9;
        return r102;
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L18;
        View r106 = r103.getChildAt(r105);
        if (r106 == null) goto L17;
        com.bytedance.android.ecom.arch.slice.render.elements.g r107 = d(r106);
        if (r107 == null) goto L17;
        return r107;
    L17:
        r105 = r105 + 1;
    L18:
        return null;
    }

    public static final BaseSlcViewManager<?> g(View r100) {
        Object r101 = r100.getTag(R.id.slc_view_manager);
        if ((r101 instanceof BaseSlcViewManager) == true) goto L5;
        r101 = null;
    L5:
        BaseSlcViewManager<?> r102 = (BaseSlcViewManager) r101;
        if (r102 == null) goto L8;
        return r102;
    L8:
        ViewParent r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == true) goto L11;
        r103 = null;
    L11:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 != null) goto L14;
        return null;
    L14:
        return g(r104);
    }

    public static final boolean i(View r100, MotionEvent r101) {
        int r102 = r101.getActionIndex();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 29) goto L5;
        float r104 = r101.getRawX(r102);
    L6:
        if (r103 < 29) goto L8;
        float r105 = r101.getRawY(r102);
    L10:
        return h(r100, r104, r105);
    L8:
        r105 = r101.getRawY();
        goto L10
    L5:
        r104 = r101.getRawX();
        goto L6
    }

    public static final void j(BaseSlcViewManager<?> r100, List<Float> r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        float r103 = 0.0f;
        float r104 = 0.0f;
        float r105 = 0.0f;
        float r106 = 0.0f;
    L21:
        YogaNode r107 = r100.f50272f;
        r107.setPadding(YogaEdge.TOP, r103);
        r107.setPadding(YogaEdge.RIGHT, r105);
        r107.setPadding(YogaEdge.BOTTOM, r104);
        r107.setPadding(YogaEdge.LEFT, r106);
        r100.J0();
        return;
    L11:
        int r108 = r101.size();
        if (r108 != 1) goto L14;
        r103 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 0), r100.f50260a.m());
        r104 = r103;
        r105 = r104;
        r106 = r105;
        goto L21
    L14:
        if (r108 != 2) goto L16;
        r104 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 0), r100.f50260a.m());
        r105 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 1), r100.f50260a.m());
        r106 = r105;
        r103 = r104;
        goto L21
    L16:
        if (r108 == 3) goto L18;
        float r109 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 0), r100.f50260a.m());
        r105 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 1), r100.f50260a.m());
        float r110 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 2), r100.f50260a.m());
        r106 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 3), r100.f50260a.m());
        r103 = r109;
        r104 = r110;
        goto L21
    L18:
        float r111 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 0), r100.f50260a.m());
        r105 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 1), r100.f50260a.m());
        r106 = r105;
        r104 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r101, 2), r100.f50260a.m());
        r103 = r111;
        goto L21
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final void m(final BaseSlcViewManager<?> r100, final IAction r101) {
        if (r101 == null) goto L4;
        r100.getView().setOnClickListener(new SlcViewExtensionsKt$setSlcClickAction$1(r100, r101));
        return;
    L4:
        r100.getView().setOnClickListener(null);
        r100.getView().setClickable(false);
    }

    public static final void n(BaseSlcViewManager<?> r100, Object r101) {
        YogaNode r102 = r100.f50272f;
        com.bytedance.android.ecom.arch.slice.render.context.b r103 = r100.f50260a.m();
        int r104 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f51025a;
        boolean r105 = false;
        if (r101 != null) goto L6;
        r102.setHeightAuto();     // Catch: Exception -> L38
    L39:
        r100.J0();
        if (r100.f50272f.getOwner() == null) goto L44;
        if (nq.a.g() == true) goto L44;
    L45:
        r105 = true;
    L46:
        if (r105 == true) goto L53;
        ViewGroup.LayoutParams r106 = r100.getView().getLayoutParams();
        if (r106 != null) goto L50;
        nq.a.c(null, SlcViewExtensionsKt$setSlcHeight$1.INSTANCE, 1);
        r106 = new ViewGroup.MarginLayoutParams(-2, -2);
        r100.getView().setLayoutParams(r106);
    L50:
        r106.height = b.j(r101, r100.f50260a.m());
        return;
    L53:
        return;
    L44:
        if (r100.f50306r3 == false) goto L46;
    L6:
        if ((r101 instanceof Number) == false) goto L9;
        r102.setHeight(Math.round(SlcDimensExtensionsKt.c((Number) r101, r103)));     // Catch: Exception -> L38
        goto L39
    L9:
        if ((r101 instanceof String) == false) goto L26;
        int r107 = ((String) r101).length();     // Catch: Exception -> L38
        if (r107 > 1) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r108 == false) goto L19;
        r102.setHeightPercent(CastFloatProtector.parseFloat(((String) r101).substring(0, ((String) r101).length() - 1)));     // Catch: Exception -> L38
        goto L39
    L19:
        if ("auto".equals(r101) == false) goto L22;
        r102.setHeightAuto();     // Catch: Exception -> L38
        goto L39
    L22:
        if ("stretch".equals(r101) == false) goto L24;
        r102.setHeightPercent(100.0f);     // Catch: Exception -> L38
        goto L39
    L24:
        r102.setHeight(SlcDimensExtensionsKt.a(Float.valueOf(CastFloatProtector.parseFloat((String) r101)), r103));     // Catch: Exception -> L38
        goto L39
    L13:
        if (((String) r101).charAt(r107 - 1) != '%') goto L15;
        r108 = true;
        goto L16
    L26:
        if ((r101 instanceof uq.a) == false) goto L36;
        int r109 = ((uq.a) r101).f551168b;     // Catch: Exception -> L38
        if (r109 == 0) goto L35;
        if (r109 != 1) goto L31;
        r102.setHeight(((uq.a) r101).f551167a);     // Catch: Exception -> L38
        goto L39
    L31:
        if (r109 == 2) goto L33;
        r102.setHeightAuto();     // Catch: Exception -> L38
        goto L39
    L33:
        r102.setHeightPercent(((uq.a) r101).f551167a);     // Catch: Exception -> L38
        goto L39
    L35:
        r102.setHeightAuto();     // Catch: Exception -> L38
        goto L39
    L36:
        r102.setHeightAuto();     // Catch: Exception -> L38
    L38:
        r102.setHeightAuto();
        goto L39
    }

    public static final void o(BaseSlcViewManager<?> r100, IAction r101) {
        if ((r100.getView() instanceof EditText) == false) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        r100.getView().setOnLongClickListener(new a(r100, r101));
        return;
    L7:
        r100.getView().setOnLongClickListener(null);
        r100.getView().setLongClickable(false);
    }

    public static final void q(BaseSlcViewManager<?> r100, List<?> r101) {
        if (r100.f50272f.getOwner() == null) goto L7;
        if (nq.a.g() == true) goto L7;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L14;
        ViewGroup.LayoutParams r103 = r100.getView().getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        p((ViewGroup.MarginLayoutParams) r103, r100.f50260a.m(), r101);
    L14:
        YogaNode r104 = r100.f50272f;
        com.bytedance.android.ecom.arch.slice.render.context.b r105 = r100.f50260a.m();
        int r106 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f51025a;
        List<?> r107 = r101;
        if (r107 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        r104.setMargin(YogaEdge.TOP, 0.0f);
        r104.setMargin(YogaEdge.RIGHT, 0.0f);
        r104.setMargin(YogaEdge.BOTTOM, 0.0f);
        r104.setMargin(YogaEdge.LEFT, 0.0f);
    L35:
        r100.J0();
        return;
    L23:
        int r109 = r101.size();
        if (r109 != 1) goto L26;
        YogaValue r110 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 0));
        YogaValue r111 = r110;
        YogaValue r112 = r111;
        YogaValue r113 = r112;
    L34:
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.t(r104, YogaEdge.TOP, r110);
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.t(r104, YogaEdge.RIGHT, r112);
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.t(r104, YogaEdge.BOTTOM, r113);
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.t(r104, YogaEdge.LEFT, r111);
        goto L35
    L26:
        if (r109 != 2) goto L28;
        r110 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 0));
        r112 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 1));
        r113 = r110;
    L32:
        r111 = r112;
        goto L34
    L28:
        if (r109 == 3) goto L30;
        r110 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 0));
        r112 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 1));
        r113 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 2));
        r111 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 3));
        goto L34
    L30:
        r110 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 0));
        r112 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 1));
        r113 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.g(r105, ListProtector.get(r101, 2));
        goto L32
    L17:
        if (r107.isEmpty() == true) goto L20;
        r108 = false;
    L7:
        if (r100.f50306r3 == true) goto L8;
        r102 = false;
        goto L10
    }

    public static final void r(BaseSlcViewManager<?> r100, Object r101) {
        YogaNode r102 = r100.f50272f;
        com.bytedance.android.ecom.arch.slice.render.context.b r103 = r100.f50260a.m();
        int r104 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f51025a;
        boolean r105 = false;
        if (r101 != null) goto L6;
        r102.setWidthAuto();     // Catch: Exception -> L38
    L39:
        r100.J0();
        if (r100.f50272f.getOwner() == null) goto L44;
        if (nq.a.g() == true) goto L44;
    L45:
        r105 = true;
    L46:
        if (r105 == true) goto L53;
        ViewGroup.LayoutParams r106 = r100.getView().getLayoutParams();
        if (r106 != null) goto L50;
        nq.a.c(null, SlcViewExtensionsKt$setSlcWidth$1.INSTANCE, 1);
        r106 = new ViewGroup.MarginLayoutParams(-2, -2);
        r100.getView().setLayoutParams(r106);
    L50:
        r106.width = b.j(r101, r100.f50260a.m());
        return;
    L53:
        return;
    L44:
        if (r100.f50306r3 == false) goto L46;
    L6:
        if ((r101 instanceof Number) == false) goto L9;
        r102.setWidth(Math.round(SlcDimensExtensionsKt.c((Number) r101, r103)));     // Catch: Exception -> L38
        goto L39
    L9:
        if ((r101 instanceof String) == false) goto L26;
        int r107 = ((String) r101).length();     // Catch: Exception -> L38
        if (r107 > 1) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r108 == false) goto L19;
        r102.setWidthPercent(CastFloatProtector.parseFloat(((String) r101).substring(0, ((String) r101).length() - 1)));     // Catch: Exception -> L38
        goto L39
    L19:
        if ("auto".equals(r101) == false) goto L22;
        r102.setWidthAuto();     // Catch: Exception -> L38
        goto L39
    L22:
        if ("stretch".equals(r101) == false) goto L24;
        r102.setWidthPercent(100.0f);     // Catch: Exception -> L38
        goto L39
    L24:
        r102.setWidth(SlcDimensExtensionsKt.a(Float.valueOf(CastFloatProtector.parseFloat((String) r101)), r103));     // Catch: Exception -> L38
        goto L39
    L13:
        if (((String) r101).charAt(r107 - 1) != '%') goto L15;
        r108 = true;
        goto L16
    L26:
        if ((r101 instanceof uq.a) == false) goto L36;
        int r109 = ((uq.a) r101).f551168b;     // Catch: Exception -> L38
        if (r109 == 0) goto L35;
        if (r109 != 1) goto L31;
        r102.setWidth(((uq.a) r101).f551167a);     // Catch: Exception -> L38
        goto L39
    L31:
        if (r109 == 2) goto L33;
        r102.setWidthAuto();     // Catch: Exception -> L38
        goto L39
    L33:
        r102.setWidthPercent(((uq.a) r101).f551167a);     // Catch: Exception -> L38
        goto L39
    L35:
        r102.setWidthAuto();     // Catch: Exception -> L38
        goto L39
    L36:
        r102.setWidthAuto();     // Catch: Exception -> L38
    L38:
        r102.setWidthAuto();
        goto L39
    }

    public static final void b(View r100, Canvas r101, Function0<Unit> r110) {
        Drawable r102 = r100.getBackground();
        if ((r102 instanceof SlcBackgroundDrawable) == true) goto L5;
        r102 = null;
    L5:
        SlcBackgroundDrawable r103 = (SlcBackgroundDrawable) r102;
        SliceRender.f50121o.getClass();
        boolean r104 = false;
        if (SliceRender.f() == false) goto L23;
        if (r103 == null) goto L15;
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r105 = r103.f50860l;
        if (r105 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L23;
    L11:
        if (r105.f50872e != true) goto L13;
        r106 = true;
    L15:
        Object r107 = r100.getTag();
        if (r107 != null) goto L18;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        r101.clipRect(r100.getScrollX(), r100.getScrollY(), r100.getWidth() + r100.getScrollX(), r100.getHeight() + r100.getScrollY());
        goto L23
    L18:
        if ((r107 instanceof Boolean) == false) goto L20;
        r108 = ((Boolean) r107).booleanValue();
    L23:
        if (r103 != null) goto L25;
        r110.invoke();
        return;
    L25:
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r109 = r103.f50860l;
        if (r109 != null) goto L28;
    L54:
        r110.invoke();
        return;
    L28:
        if (SlcBackgroundDrawable.f50846t == true) goto L40;
        if (r109.f50875h == false) goto L40;
        if (r109.f50876i == true) goto L35;
    L44:
        if (r104 == false) goto L54;
        r109.c(r100.getScrollX(), r100.getScrollY(), r100.getWidth(), r100.getHeight());
        Path r111 = r109.f50890w;
        if (r111 != null) goto L48;
        r111 = new Path();
        r109.f50890w = r111;
    L48:
        int r112 = r101.save();
        r101.clipPath(r111);
        r110.invoke();     // Catch: Throwable -> L51
        r101.restoreToCount(r112);
        return;
    L51:
        th = move-exception;
        r101.restoreToCount(r112);
        throw th;
    L35:
        if (r109.f50872e == false) goto L44;
        if (r109.f50877j <= 0) goto L44;
    L43:
        r104 = true;
    L40:
        if (r109.f50876i == false) goto L44;
        if (r109.f50872e == false) goto L44;
        goto L43
    }

    public static final void c(BaseSlcViewManager<?> r100, Canvas r101, Function0<Unit> r110) {
        SlcBackgroundDrawable r102 = r100.f50274g;
        SliceRender.f50121o.getClass();
        boolean r103 = false;
        if (SliceRender.f() == true) goto L5;
    L22:
        if (r102 != null) goto L24;
        r110.invoke();
        return;
    L24:
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r104 = r102.f50860l;
        if (r104 != null) goto L27;
    L53:
        r110.invoke();
        return;
    L27:
        if (SlcBackgroundDrawable.f50846t == true) goto L39;
        if (r104.f50875h == false) goto L39;
        if (r104.f50876i == true) goto L34;
    L43:
        if (r103 == false) goto L53;
        r104.c(r100.h0(), r100.i0(), r100.j0(), r100.c0());
        Path r105 = r104.f50890w;
        if (r105 != null) goto L47;
        r105 = new Path();
        r104.f50890w = r105;
    L47:
        int r106 = r101.save();
        r101.clipPath(r105);
        r110.invoke();     // Catch: Throwable -> L50
        r101.restoreToCount(r106);
        return;
    L50:
        th = move-exception;
        r101.restoreToCount(r106);
        throw th;
    L34:
        if (r104.f50872e == false) goto L43;
        if (r104.f50877j <= 0) goto L43;
    L42:
        r103 = true;
    L39:
        if (r104.f50876i == false) goto L43;
        if (r104.f50872e == false) goto L43;
    L5:
        if (r100.f50306r3 == true) goto L22;
        if (r102 == null) goto L14;
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r107 = r102.f50860l;
        if (r107 != null) goto L10;
    L12:
        boolean r108 = false;
    L13:
        if (r108 == true) goto L22;
    L10:
        if (r107.f50872e != true) goto L12;
        r108 = true;
    L14:
        Object r109 = r100.getView().getTag();
        if (r109 != null) goto L17;
    L19:
        boolean r111 = true;
    L20:
        if (r111 == false) goto L22;
        r101.clipRect(r100.h0(), r100.i0(), r100.j0() + r100.h0(), r100.c0() + r100.i0());
        goto L22
    L17:
        if ((r109 instanceof Boolean) == false) goto L19;
        r111 = ((Boolean) r109).booleanValue();
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List f(SlcTemplateContext r100, Map r110, List r111) {
        if (r111.isEmpty() == false) goto L5;
    L62:
        return r111;
    L5:
        if (r110 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L62;
        ArrayList r102 = new ArrayList(r111.size());
        int r103 = r111.size();
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L61;
        SlcElement r105 = (SlcElement) ListProtector.get(r111, r104);
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r106 = r105.bindInfo;
        if (r106 == 0) goto L59;
        int r107 = com.bytedance.android.ecom.arch.slice.render.bindinfo.d.f50129m;
        String r108 = r106.f50140k;
        if (r108 != null) goto L20;
    L23:
        boolean r109 = true;
    L25:
        if ((!r109) == true) goto L48;
        String r112 = r106.f50138i;
        if (r112 != null) goto L29;
    L32:
        boolean r113 = true;
    L33:
        if (r113 == false) goto L44;
        String r114 = r106.f50139j;
        if (r114 != null) goto L37;
    L40:
        boolean r115 = true;
    L41:
        if (r115 == false) goto L44;
        boolean r116 = false;
    L45:
        if (r116 == true) goto L48;
        boolean r117 = false;
    L49:
        if (r117 == false) goto L59;
        com.bytedance.android.ecom.arch.slice.render.bindinfo.c r118 = r106.f50133d;
        if (r118 == null) goto L55;
        com.bytedance.android.ecom.arch.slice.render.bindinfo.a r119 = r105.forConfigValue;
        Map r120 = SlcBindInfoKt.c(r110, r118, r119);
        if (r119 == null) goto L57;
        r119.f50126c = r120;
    L57:
        if (r106.b(r100, r120) == false) goto L60;
        r102.add(r105);
    L60:
        r104 = r104 + 1;
        goto L14
    L55:
        r120 = r110;
        goto L57
    L37:
        if (r114.length() == 0) goto L40;
        r115 = false;
    L44:
        r116 = true;
        goto L45
    L29:
        if (r112.length() == 0) goto L32;
        r113 = false;
    L48:
        r117 = true;
        goto L49
    L20:
        if (r108.length() == 0) goto L23;
        r109 = false;
    L59:
        r102.add(r105);
        goto L60
    L61:
        return r102;
    L7:
        if (r110.isEmpty() == true) goto L10;
        r101 = false;
        goto L11
    }

    public static final boolean h(View r100, float r101, float r102) {
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        int r104 = r103[0];
        if (r101 >= r104) goto L5;
        return false;
    L5:
        if (r102 > r103[1]) goto L7;
        return false;
    L7:
        if (r101 <= (r104 + r100.getWidth())) goto L9;
        return false;
    L9:
        if (r102 > (r103[1] + r100.getHeight())) goto L15;
        return true;
    L15:
        return false;
    }

    public static final void l(BaseSlcViewManager<?> r100, com.bytedance.android.ecom.arch.slice.render.context.b r101, String r102) {
        SlcBackgroundDrawable r103 = r100.K();
        if (r102 != null) goto L6;
    L11:
        boolean r104 = false;
    L12:
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r105 = r103.b();
        if (r104 != true) goto L15;
        r103.b();
        DashPathEffect r106 = new DashPathEffect(new float[]{SlcDimensExtensionsKt.c(Double.valueOf(1.5d), r101), SlcDimensExtensionsKt.c(Double.valueOf(0.5d), r101)}, 0.0f);
    L16:
        r105.f50879l = r106;
        r103.g().setPathEffect(r105.f50879l);
        if (r105.f50877j <= 0) goto L20;
        r103.invalidateSelf();
        return;
    L20:
        return;
    L15:
        r106 = null;
        goto L16
    L6:
        if (r102.hashCode() != (-1338941519)) goto L11;
        if (r102.equals("dashed") == false) goto L11;
        r104 = true;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    public static final void p(ViewGroup.MarginLayoutParams r100, com.bytedance.android.ecom.arch.slice.render.context.b r101, List<?> r102) {
        if (r102 == null) goto L7;
        List<?> r103 = r102;     // Catch: Throwable -> L9
        ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Throwable -> L9
        Iterator r105 = r103.iterator();     // Catch: Throwable -> L9
    L5:
        if (r105.hasNext() == false) goto L10;
        r104.add(Float.valueOf(b.c(r105.next(), 0.0f)));     // Catch: Throwable -> L9
    L10:
        r100.leftMargin = SlcDimensExtensionsKt.a(Float.valueOf(b.k(r104)), r101);
        r100.rightMargin = SlcDimensExtensionsKt.a(Float.valueOf(b.q(r104)), r101);
        r100.topMargin = SlcDimensExtensionsKt.a(Float.valueOf(b.t(r104)), r101);
        r100.bottomMargin = SlcDimensExtensionsKt.a(Float.valueOf(b.b(r104)), r101);
        return;
    L7:
        r104 = CollectionsKt.emptyList();     // Catch: Throwable -> L9
    L9:
        r104 = CollectionsKt.emptyList();
        goto L10
    }

    public static final void k(SlcBackgroundDrawable r110, com.bytedance.android.ecom.arch.slice.render.context.b r111, List<?> r112, boolean r113) {
        List<?> r100 = r112;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L22;
        int r103 = r112.size();
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L19;
        if (r103 == 3) goto L18;
        if (r103 != 4) goto L22;
        int r104 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 0), 0.0f)), r111);
        int r105 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 1), 0.0f)), r111);
        int r106 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 2), 0.0f)), r111);
        int r114 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 3), 0.0f)), r111);
    L23:
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r115 = r110.b();
        r115.f50876i = r113;
        r115.f50868a = r104;
        r115.f50869b = r114;
        r115.f50870c = r105;
        r115.f50871d = r106;
        if (r114 > 0) goto L30;
        if (r104 > 0) goto L30;
        if (r105 > 0) goto L30;
        if (r106 > 0) goto L30;
        boolean r107 = false;
    L31:
        r115.f50872e = r107;
        if (r107 == false) goto L83;
        if (r104 != r114) goto L37;
        if (r104 != r105) goto L37;
        if (r104 != r106) goto L37;
        r115.f50873f = 0;
        r115.f50874g = r104;
    L75:
        if (Build.VERSION.SDK_INT >= 28) goto L77;
    L82:
        r115.f50875h = r101;
    L85:
        if (r110.getBounds().isEmpty() == true) goto L87;
        r115.f50891x = true;
        r115.f50883p = true;
        r115.f50887t = true;
        r115.A = true;
    L87:
        r110.invalidateSelf();
        return;
    L77:
        if (r115.f50873f == (-1)) goto L82;
        if (r113 == false) goto L82;
        if (SlcBackgroundDrawable.f50846t == true) goto L82;
        r101 = true;
    L37:
        if (r104 != r105) goto L41;
        if (r114 != 0) goto L41;
        if (r106 != 0) goto L41;
        r115.f50873f = 2;
        r115.f50874g = r104;
    L41:
        if (r114 != r106) goto L45;
        if (r104 != 0) goto L45;
        if (r105 != 0) goto L45;
        r115.f50873f = 4;
        r115.f50874g = r114;
    L45:
        if (r104 != r114) goto L49;
        if (r105 != 0) goto L49;
        if (r106 != 0) goto L49;
        r115.f50873f = 1;
        r115.f50874g = r104;
    L49:
        if (r105 != r106) goto L53;
        if (r104 != 0) goto L53;
        if (r114 != 0) goto L53;
        r115.f50873f = 3;
        r115.f50874g = r105;
    L53:
        if (r104 == 0) goto L58;
        if (r114 != 0) goto L58;
        if (r105 != 0) goto L58;
        if (r106 != 0) goto L58;
        r115.f50873f = 5;
        r115.f50874g = r104;
    L58:
        if (r104 != 0) goto L63;
        if (r114 == 0) goto L63;
        if (r105 != 0) goto L63;
        if (r106 != 0) goto L63;
        r115.f50873f = 6;
        r115.f50874g = r114;
    L63:
        if (r104 != 0) goto L68;
        if (r114 != 0) goto L68;
        if (r105 == 0) goto L68;
        if (r106 != 0) goto L68;
        r115.f50873f = 7;
        r115.f50874g = r105;
    L68:
        if (r104 != 0) goto L73;
        if (r114 != 0) goto L73;
        if (r105 != 0) goto L73;
        if (r106 == 0) goto L73;
        r115.f50873f = 8;
        r115.f50874g = r106;
    L73:
        r115.f50873f = -1;
        r115.f50874g = 0;
        goto L75
    L83:
        r115.f50873f = -1;
        r115.f50874g = 0;
        r115.f50875h = false;
    L30:
        r107 = true;
        goto L31
    L18:
        r104 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 0), 0.0f)), r111);
        r105 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 1), 0.0f)), r111);
        r106 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 2), 0.0f)), r111);
    L20:
        r114 = r105;
        goto L23
    L19:
        r104 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 0), 0.0f)), r111);
        r105 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 1), 0.0f)), r111);
        r106 = r104;
        goto L20
    L21:
        r104 = SlcDimensExtensionsKt.a(Float.valueOf(b.c(ListProtector.get(r112, 0), 0.0f)), r111);
        r114 = r104;
        r105 = r114;
        r106 = r105;
    L22:
        r114 = 0;
        r104 = 0;
        r105 = 0;
        r106 = 0;
        goto L23
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public static final void s(BaseSlcViewManager<?> r100, IAction r101, View r102, BaseSlcViewManager<?> r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112, boolean r113) {
        SlcTemplateContext r103 = r100.f50260a;
        if (r102 != null) goto L6;
        r102 = r100.getView();
    L6:
        int r104 = r103.d(r101, r102, r111, r112, "click_action");
        if (b.a(r100.o(SlcElement.KEY_TAP_PROPAGATE)) == false) goto L10;
        if (r113 == true) goto L10;
    L11:
        BaseSlcViewManager<?> r105 = r110;
    L12:
        if (r105 == null) goto L16;
        if (r105.f50321x2 != null) goto L16;
        r105 = r105.f50268d;
    L16:
        if (r105 == null) goto L18;
        IAction r106 = r105.f50321x2;
    L19:
        IAction r107 = r106;
        if (r105 == null) goto L27;
        if (r107 == null) goto L28;
        s(r105, r107, r105.getView(), r105.f50268d, r105.l(), null, false);
        return;
    L28:
        return;
    L27:
        return;
    L18:
        r106 = null;
    L10:
        if (r104 == 1) goto L11;
    }

    public static void e(final BaseSlcViewManager r110, final IAction r111, View r112, BaseSlcViewManager r113, final Function0 r114, Function0 r115, boolean r116, int r210) {
        if ((r210 & 16) == 0) goto L5;
        final Function0 r100 = null;
    L7:
        if ((r210 & 32) == 0) goto L9;
        boolean r101 = false;
    L10:
        Object r102 = r110.o("enable_click_debounce");
        if (r102 == null) goto L13;
        boolean r103 = b.a(r102);
    L14:
        if (r103 == false) goto L25;
        Integer r104 = c.f50733a;
        final int r105 = r110.f50260a.f50235w.f50182k;
        final long r106 = System.currentTimeMillis();
        int r107 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcClickDebounceUtil$isValidClick$1(r106, r105));
        Integer r108 = c.f50733a;
        if (r108 != null) goto L18;
    L20:
        c.f50733a = Integer.valueOf(r105);
        c.f50734b = r106;
        boolean r109 = true;
    L21:
        if (r109 == true) goto L25;
        SlcRenderContext r117 = r110.f50260a.f50235w;
        Function0<Map<String, ? extends Object>> r118 = new SlcViewExtensionsKt$doClickWithClickDebounce$1(r110, r111, r114, r100);
        r117.getClass();
        SliceRender.f50121o.getClass();
        SliceRender.g().execute(new com.bytedance.android.ecom.arch.slice.render.context.f("slice_hit_click_debounce", r118));
        if (nq.a.g() == false) goto L35;
        Toast.makeText(r110.f50260a.getContext(), "Slice:点击被拦截，命中防暴击", 0).show();
        return;
    L35:
        return;
    L18:
        if ((r106 - c.f50734b) >= r108.intValue()) goto L20;
        r109 = false;
    L25:
        Map<String, Object> r119 = (Map) r114.invoke();
        if (r119 != null) goto L29;
        r119 = r110.l();
    L29:
        Map<String, Object> r120 = r119;
        if (r100 == null) goto L32;
        Map r121 = (Map) r100.invoke();
    L33:
        s(r110, r111, r112, r113, r120, r121, r101);
        return;
    L32:
        r121 = null;
        goto L33
    L13:
        r103 = r110.f50260a.f50235w.f50180j;
        goto L14
    L9:
        r101 = r116;
        goto L10
    L5:
        r100 = r115;
        goto L7
    }
}
