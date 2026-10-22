package com.stepos.ailauncher.sheet.internal;

import Z8.C1173v;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.U;
import com.stepos.ailauncher.sheet.a0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÍ\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\u0004\b\u001e\u0010\u001fJC\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b&\u0010'JC\u0010(\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b(\u0010'¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/z;", "", "<init>", "()V", "Landroid/view/View;", "panel", "clipView", "", "visibleHeight", "barRadiusPx", "startTranslationY", "endTranslationY", "startScaleX", "endScaleX", "startScaleY", "endScaleY", "offsetStiffness", "offsetDampingRatio", "scaleXStiffness", "scaleXDampingRatio", "scaleYStiffness", "scaleYDampingRatio", "bottomWidthPinchPx", "Lkotlin/Function1;", "LY8/t;", "onProgress", "Lkotlin/Function0;", "onCollapsedToBar", "onEnd", "Lcom/stepos/ailauncher/sheet/internal/z$a;", "l", "(Landroid/view/View;Landroid/view/View;FFFFFFFFFFFFFFFLp9/l;Lp9/a;Lp9/a;)Lcom/stepos/ailauncher/sheet/internal/z$a;", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "stiffness", "dampingRatio", "onUpdate", "Landroidx/dynamicanimation/animation/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(FFFFLp9/l;)Landroidx/dynamicanimation/animation/i;", "y", Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    public static final z INSTANCE = new z();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/z$a;", "", "", "Landroidx/dynamicanimation/animation/i;", "animations", "Lkotlin/Function0;", "LY8/t;", "restore", "<init>", "(Ljava/util/List;Lp9/a;)V", Const.INTENT_KEY_APIKEY, "()V", "Ljava/util/List;", "Lp9/a;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final List<androidx.dynamicanimation.animation.i> animations;
        private final InterfaceC5063a<Y8.t> restore;

        public a(List<androidx.dynamicanimation.animation.i> animations, InterfaceC5063a<Y8.t> restore) {
            kotlin.jvm.internal.p.i(animations, "animations");
            kotlin.jvm.internal.p.i(restore, "restore");
            this.animations = animations;
            this.restore = restore;
        }

        public final void a() {
            Iterator<T> it = this.animations.iterator();
            while (it.hasNext()) {
                ((androidx.dynamicanimation.animation.i) it.next()).d();
            }
            this.restore.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sheet/internal/z$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ Ref$FloatRef $clipCapsuleRadius;
        final /* synthetic */ Rect $clipRect;

        public b(Rect rect, Ref$FloatRef ref$FloatRef) {
            this.$clipRect = rect;
            this.$clipCapsuleRadius = ref$FloatRef;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(this.$clipRect, this.$clipCapsuleRadius.f34817a);
        }
    }

    public static final void k(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public static final void m(float f10, float f11, View view, Rect rect, Ref$FloatRef ref$FloatRef, float f12, View view2, float f13, float f14) {
        float fE = C5685n.e(f10 * f13, 1.0f);
        float fE2 = C5685n.e(f11 * f14, 1.0f);
        float left = view.getLeft() + view.getTranslationX() + (view.getPivotX() * (1.0f - f13));
        float top = view.getTop() + view.getTranslationY() + (view.getPivotY() * (1.0f - f14));
        int iCeil = (int) Math.ceil(left);
        int iCeil2 = (int) Math.ceil(top);
        rect.set(iCeil, iCeil2, C5685n.f((int) Math.floor(left + fE), iCeil + 1), C5685n.f((int) Math.floor(top + fE2), iCeil2 + 1));
        ref$FloatRef.f34817a = K.INSTANCE.b(rect.width(), rect.height(), f12);
        if (!view2.getClipToOutline()) {
            view2.setClipToOutline(true);
        }
        view2.invalidateOutline();
    }

    public static final void n(View view, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, Ref$BooleanRef ref$BooleanRef, float f18, InterfaceC5063a<Y8.t> interfaceC5063a, Ref$FloatRef ref$FloatRef3, Ref$FloatRef ref$FloatRef4, float f19, Rect rect, Ref$FloatRef ref$FloatRef5, float f20, View view2) {
        float fX = x(ref$FloatRef3, ref$FloatRef4, f19);
        float top = view.getTop() + ref$FloatRef.f34817a;
        float pivotY = view.getPivotY();
        float f21 = ref$FloatRef2.f34817a;
        view.setTranslationY(ref$FloatRef.f34817a + K.INSTANCE.a(top + (pivotY * (1.0f - f21)) + (f10 * f21), a0.c(f15, f16, f17, f11 > f12 ? (f11 - f21) / (f11 - f12) : (ref$FloatRef.f34817a - f13) / f14)));
        view.setScaleX(fX);
        view.setScaleY(ref$FloatRef2.f34817a);
        m(f19, f10, view, rect, ref$FloatRef5, f20, view2, fX, ref$FloatRef2.f34817a);
        if (ref$BooleanRef.f34815a || !U.a(ref$FloatRef2.f34817a * f10, f10 * f12, f18 - ref$FloatRef.f34817a)) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t o(Ref$FloatRef ref$FloatRef, InterfaceC5074l interfaceC5074l, float f10, float f11, View view, Ref$FloatRef ref$FloatRef2, float f12, float f13, float f14, float f15, float f16, float f17, Ref$BooleanRef ref$BooleanRef, float f18, InterfaceC5063a interfaceC5063a, Ref$FloatRef ref$FloatRef3, Ref$FloatRef ref$FloatRef4, float f19, Rect rect, Ref$FloatRef ref$FloatRef5, float f20, View view2, float f21) {
        ref$FloatRef.f34817a = f21;
        n(view, ref$FloatRef, ref$FloatRef2, f12, f13, f14, f10, f11, f15, f16, f17, ref$BooleanRef, f18, interfaceC5063a, ref$FloatRef3, ref$FloatRef4, f19, rect, ref$FloatRef5, f20, view2);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(C5685n.m((f21 - f10) / f11, 0.0f, 1.0f)));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t p(Ref$FloatRef ref$FloatRef, View view, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, Ref$BooleanRef ref$BooleanRef, float f18, InterfaceC5063a interfaceC5063a, Ref$FloatRef ref$FloatRef4, float f19, Rect rect, Ref$FloatRef ref$FloatRef5, float f20, View view2, float f21) {
        ref$FloatRef.f34817a = C5685n.e(f21, 0.01f);
        n(view, ref$FloatRef2, ref$FloatRef3, f10, f11, f12, f13, f14, f15, f16, f17, ref$BooleanRef, f18, interfaceC5063a, ref$FloatRef, ref$FloatRef4, f19, rect, ref$FloatRef5, f20, view2);
        return Y8.t.f7040a;
    }

    public static final Y8.t q(Ref$FloatRef ref$FloatRef, float f10, Ref$BooleanRef ref$BooleanRef, float f11, float f12, View view, Ref$FloatRef ref$FloatRef2, float f13, float f14, float f15, float f16, float f17, float f18, Ref$BooleanRef ref$BooleanRef2, float f19, InterfaceC5063a interfaceC5063a, Ref$FloatRef ref$FloatRef3, Ref$FloatRef ref$FloatRef4, float f20, Rect rect, Ref$FloatRef ref$FloatRef5, float f21, View view2, float f22) {
        float fE = C5685n.e(f22, 1.0f / f10);
        ref$FloatRef.f34817a = fE;
        ref$BooleanRef.f34815a = f11 > 0.0f && fE <= Math.max(4.0f * f12, f12);
        n(view, ref$FloatRef2, ref$FloatRef, f10, f13, f12, f14, f15, f16, f17, f18, ref$BooleanRef2, f19, interfaceC5063a, ref$FloatRef3, ref$FloatRef4, f20, rect, ref$FloatRef5, f21, view2);
        return Y8.t.f7040a;
    }

    public static final void r(Ref$BooleanRef ref$BooleanRef, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef, float f10, Ref$FloatRef ref$FloatRef2, float f11, Ref$FloatRef ref$FloatRef3, float f12, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, View view, float f13, float f14, float f15, float f16, float f17, float f18, float f19, Ref$BooleanRef ref$BooleanRef2, InterfaceC5063a interfaceC5063a2, Ref$FloatRef ref$FloatRef4, float f20, Rect rect, Ref$FloatRef ref$FloatRef5, float f21, View view2, androidx.dynamicanimation.animation.e eVar, boolean z10, float f22, float f23) {
        if (z10 || ref$BooleanRef.f34815a) {
            return;
        }
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 > 0) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        ref$FloatRef.f34817a = f10;
        ref$FloatRef2.f34817a = f11;
        ref$FloatRef3.f34817a = f12;
        n(view, ref$FloatRef, ref$FloatRef3, f13, f14, f12, f15, f16, f17, f18, f19, ref$BooleanRef2, f10, interfaceC5063a2, ref$FloatRef2, ref$FloatRef4, f20, rect, ref$FloatRef5, f21, view2);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        interfaceC5063a.invoke();
    }

    public static final void s(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef3, Ref$BooleanRef ref$BooleanRef4, float f10, Ref$IntRef ref$IntRef, float f11, List list, e.q qVar, Ref$FloatRef ref$FloatRef2, View view, Ref$FloatRef ref$FloatRef3, Ref$FloatRef ref$FloatRef4, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, Ref$BooleanRef ref$BooleanRef5, float f20, InterfaceC5063a interfaceC5063a, Ref$FloatRef ref$FloatRef5, float f21, Rect rect, Ref$FloatRef ref$FloatRef6, float f22, View view2, androidx.dynamicanimation.animation.e eVar, float f23, float f24) {
        if (ref$BooleanRef.f34815a && f24 > 0.0f) {
            ref$BooleanRef2.f34815a = true;
        }
        if (ref$BooleanRef2.f34815a && ref$FloatRef.f34817a > 0.0f && f24 <= 0.0f) {
            v(ref$BooleanRef3, ref$BooleanRef4, f10, ref$IntRef, f11, list, qVar, ref$FloatRef2, view, ref$FloatRef3, ref$FloatRef4, f12, f13, f14, f15, f16, f17, f18, f19, ref$BooleanRef5, f20, interfaceC5063a, ref$FloatRef5, f21, rect, ref$FloatRef6, f22, view2);
        }
        ref$FloatRef.f34817a = f24;
    }

    public static final Y8.t t(Ref$BooleanRef ref$BooleanRef, View view, ViewOutlineProvider viewOutlineProvider, boolean z10, Boolean bool, View view2, ViewOutlineProvider viewOutlineProvider2, boolean z11, float f10) {
        u(ref$BooleanRef, view, viewOutlineProvider, z10, bool, view2, viewOutlineProvider2, z11, f10);
        return Y8.t.f7040a;
    }

    public static final void u(Ref$BooleanRef ref$BooleanRef, View view, ViewOutlineProvider viewOutlineProvider, boolean z10, Boolean bool, View view2, ViewOutlineProvider viewOutlineProvider2, boolean z11, float f10) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        view.setOutlineProvider(viewOutlineProvider);
        view.setClipToOutline(z10);
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).setClipChildren(zBooleanValue);
        }
        view2.setOutlineProvider(viewOutlineProvider2);
        view2.setClipToOutline(z11);
        view2.setElevation(f10);
        view2.invalidateOutline();
    }

    public static final void v(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, float f10, Ref$IntRef ref$IntRef, float f11, List<androidx.dynamicanimation.animation.i> list, e.q qVar, final Ref$FloatRef ref$FloatRef, final View view, final Ref$FloatRef ref$FloatRef2, final Ref$FloatRef ref$FloatRef3, final float f12, final float f13, final float f14, final float f15, final float f16, final float f17, final float f18, final float f19, final Ref$BooleanRef ref$BooleanRef3, final float f20, final InterfaceC5063a<Y8.t> interfaceC5063a, final Ref$FloatRef ref$FloatRef4, final float f21, final Rect rect, final Ref$FloatRef ref$FloatRef5, final float f22, final View view2) {
        if (ref$BooleanRef.f34815a || ref$BooleanRef2.f34815a || f10 <= 0.0f) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        ref$IntRef.f34818a++;
        float fSqrt = (float) Math.sqrt(f11);
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(0.0f));
        iVar.B(new androidx.dynamicanimation.animation.j(0.0f).h(f11).f(1.0f));
        iVar.r(fSqrt * f10 * 2.7182817f);
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.y
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f23, float f24) {
                z.w(ref$FloatRef, view, ref$FloatRef2, ref$FloatRef3, f12, f13, f14, f15, f16, f17, f18, f19, ref$BooleanRef3, f20, interfaceC5063a, ref$FloatRef4, f21, rect, ref$FloatRef5, f22, view2, eVar, f23, f24);
            }
        });
        list.add(iVar);
        iVar.b(qVar);
        iVar.t();
    }

    public static final void w(Ref$FloatRef ref$FloatRef, View view, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, Ref$BooleanRef ref$BooleanRef, float f18, InterfaceC5063a interfaceC5063a, Ref$FloatRef ref$FloatRef4, float f19, Rect rect, Ref$FloatRef ref$FloatRef5, float f20, View view2, androidx.dynamicanimation.animation.e eVar, float f21, float f22) {
        ref$FloatRef.f34817a = C5685n.e(f21, 0.0f);
        n(view, ref$FloatRef2, ref$FloatRef3, f10, f11, f12, f13, f14, f15, f16, f17, ref$BooleanRef, f18, interfaceC5063a, ref$FloatRef4, ref$FloatRef, f19, rect, ref$FloatRef5, f20, view2);
    }

    public static final float x(Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, float f10) {
        return C5685n.e(ref$FloatRef.f34817a - (ref$FloatRef2.f34817a / f10), 0.01f);
    }

    public static final void z(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public final androidx.dynamicanimation.animation.i j(float start, float end, float stiffness, float dampingRatio, final InterfaceC5074l<? super Float, Y8.t> onUpdate) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(start));
        iVar.B(new androidx.dynamicanimation.animation.j(end).h(stiffness).f(dampingRatio));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.x
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                z.k(onUpdate, eVar, f10, f11);
            }
        });
        return iVar;
    }

    public final a l(final View panel, final View clipView, float visibleHeight, final float barRadiusPx, final float startTranslationY, final float endTranslationY, float startScaleX, final float endScaleX, final float startScaleY, final float endScaleY, float offsetStiffness, float offsetDampingRatio, float scaleXStiffness, float scaleXDampingRatio, final float scaleYStiffness, float scaleYDampingRatio, final float bottomWidthPinchPx, final InterfaceC5074l<? super Float, Y8.t> onProgress, final InterfaceC5063a<Y8.t> onCollapsedToBar, final InterfaceC5063a<Y8.t> onEnd) {
        e.q qVar;
        List<androidx.dynamicanimation.animation.i> list;
        kotlin.jvm.internal.p.i(panel, "panel");
        kotlin.jvm.internal.p.i(clipView, "clipView");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        final ViewOutlineProvider outlineProvider = clipView.getOutlineProvider();
        final boolean clipToOutline = clipView.getClipToOutline();
        boolean z10 = clipView instanceof ViewGroup;
        ViewGroup viewGroup = z10 ? (ViewGroup) clipView : null;
        Boolean boolValueOf = viewGroup != null ? Boolean.valueOf(viewGroup.getClipChildren()) : null;
        final ViewOutlineProvider outlineProvider2 = panel.getOutlineProvider();
        final boolean clipToOutline2 = panel.getClipToOutline();
        final float elevation = panel.getElevation();
        final float fE = C5685n.e(visibleHeight, 1.0f);
        final float fE2 = C5685n.e(panel.getWidth(), 1.0f);
        final Rect rect = new Rect();
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        clipView.getLocationOnScreen(new int[2]);
        final float fMin = Math.min(clipView.getHeight(), clipView.getResources().getDisplayMetrics().heightPixels - r7[1]);
        final float f10 = clipView.getResources().getDisplayMetrics().density * 5.0f;
        final float top = panel.getTop() + startTranslationY + (panel.getPivotY() * (1.0f - startScaleY)) + (fE * startScaleY);
        panel.setClipToOutline(false);
        panel.setElevation(0.0f);
        ViewGroup viewGroup2 = z10 ? (ViewGroup) clipView : null;
        if (viewGroup2 != null) {
            viewGroup2.setClipChildren(false);
        }
        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        ref$FloatRef2.f34817a = startTranslationY;
        final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
        ref$FloatRef3.f34817a = startScaleX;
        final Ref$FloatRef ref$FloatRef4 = new Ref$FloatRef();
        ref$FloatRef4.f34817a = startScaleY;
        final Ref$FloatRef ref$FloatRef5 = new Ref$FloatRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        final Ref$FloatRef ref$FloatRef6 = new Ref$FloatRef();
        final Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef4 = new Ref$BooleanRef();
        float f11 = endTranslationY - startTranslationY;
        final float f12 = Math.abs(f11) >= 1.0f ? f11 : 1.0f;
        clipView.setOutlineProvider(new b(rect, ref$FloatRef));
        final Ref$BooleanRef ref$BooleanRef5 = new Ref$BooleanRef();
        final float f13 = f12;
        androidx.dynamicanimation.animation.i iVarJ = j(startTranslationY, endTranslationY, offsetStiffness, offsetDampingRatio, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.o(ref$FloatRef2, onProgress, startTranslationY, f12, panel, ref$FloatRef4, fE, startScaleY, endScaleY, top, fMin, f10, ref$BooleanRef4, endTranslationY, onCollapsedToBar, ref$FloatRef3, ref$FloatRef5, fE2, rect, ref$FloatRef, barRadiusPx, clipView, ((Float) obj).floatValue());
            }
        });
        androidx.dynamicanimation.animation.i iVarY = y(startScaleX, endScaleX, scaleXStiffness, scaleXDampingRatio, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.p(ref$FloatRef3, panel, ref$FloatRef2, ref$FloatRef4, fE, startScaleY, endScaleY, startTranslationY, f13, top, fMin, f10, ref$BooleanRef4, endTranslationY, onCollapsedToBar, ref$FloatRef5, fE2, rect, ref$FloatRef, barRadiusPx, clipView, ((Float) obj).floatValue());
            }
        });
        InterfaceC5074l<? super Float, Y8.t> interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.q(ref$FloatRef4, fE, ref$BooleanRef, bottomWidthPinchPx, endScaleY, panel, ref$FloatRef2, startScaleY, startTranslationY, f13, top, fMin, f10, ref$BooleanRef4, endTranslationY, onCollapsedToBar, ref$FloatRef3, ref$FloatRef5, fE2, rect, ref$FloatRef, barRadiusPx, clipView, ((Float) obj).floatValue());
            }
        };
        final float f14 = fE;
        final Ref$BooleanRef ref$BooleanRef6 = ref$BooleanRef4;
        final List listS = C1173v.s(iVarJ, iVarY, y(startScaleY, endScaleY, scaleYStiffness, scaleYDampingRatio, interfaceC5074l));
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = listS.size();
        final Ref$BooleanRef ref$BooleanRef7 = new Ref$BooleanRef();
        final e.q qVar2 = new e.q() { // from class: com.stepos.ailauncher.sheet.internal.t
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z11, float f15, float f16) {
                z.r(ref$BooleanRef7, ref$IntRef, ref$FloatRef2, endTranslationY, ref$FloatRef3, endScaleX, ref$FloatRef4, endScaleY, onProgress, onEnd, panel, f14, startScaleY, startTranslationY, f13, top, fMin, f10, ref$BooleanRef6, onCollapsedToBar, ref$FloatRef5, fE2, rect, ref$FloatRef, barRadiusPx, clipView, eVar, z11, f15, f16);
            }
        };
        final Ref$FloatRef ref$FloatRef7 = ref$FloatRef3;
        final Ref$FloatRef ref$FloatRef8 = ref$FloatRef4;
        final float f15 = f13;
        final float f16 = top;
        final float f17 = fMin;
        final float f18 = f10;
        final Ref$FloatRef ref$FloatRef9 = ref$FloatRef5;
        final float f19 = fE2;
        final Rect rect2 = rect;
        final Ref$FloatRef ref$FloatRef10 = ref$FloatRef;
        final Ref$FloatRef ref$FloatRef11 = ref$FloatRef2;
        if (bottomWidthPinchPx > 0.0f) {
            e.r rVar = new e.r() { // from class: com.stepos.ailauncher.sheet.internal.u
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f20, float f21) {
                    z.s(ref$BooleanRef, ref$BooleanRef3, ref$FloatRef6, ref$BooleanRef2, ref$BooleanRef7, bottomWidthPinchPx, ref$IntRef, scaleYStiffness, listS, qVar2, ref$FloatRef9, panel, ref$FloatRef11, ref$FloatRef8, f14, startScaleY, endScaleY, startTranslationY, f15, f16, f17, f18, ref$BooleanRef6, endTranslationY, onCollapsedToBar, ref$FloatRef7, f19, rect2, ref$FloatRef10, barRadiusPx, clipView, eVar, f20, f21);
                }
            };
            list = listS;
            qVar = qVar2;
            ref$FloatRef11 = ref$FloatRef11;
            ref$FloatRef8 = ref$FloatRef8;
            f14 = f14;
            f15 = f15;
            f16 = f16;
            f18 = f18;
            ref$BooleanRef6 = ref$BooleanRef6;
            ref$FloatRef7 = ref$FloatRef7;
            f19 = f19;
            rect2 = rect2;
            ref$FloatRef10 = ref$FloatRef10;
            ref$FloatRef9 = ref$FloatRef9;
            f17 = f17;
            iVarY.c(rVar);
        } else {
            qVar = qVar2;
            list = listS;
        }
        for (androidx.dynamicanimation.animation.i iVar : list) {
            iVar.b(qVar);
            iVar.t();
        }
        n(panel, ref$FloatRef11, ref$FloatRef8, f14, startScaleY, endScaleY, startTranslationY, f15, f16, f17, f18, ref$BooleanRef6, endTranslationY, onCollapsedToBar, ref$FloatRef7, ref$FloatRef9, f19, rect2, ref$FloatRef10, barRadiusPx, clipView);
        final Boolean bool = boolValueOf;
        return new a(list, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.internal.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return z.t(ref$BooleanRef5, clipView, outlineProvider, clipToOutline, bool, panel, outlineProvider2, clipToOutline2, elevation);
            }
        });
    }

    public final androidx.dynamicanimation.animation.i y(float start, float end, float stiffness, float dampingRatio, final InterfaceC5074l<? super Float, Y8.t> onUpdate) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(start));
        iVar.o(0.002f);
        iVar.B(new androidx.dynamicanimation.animation.j(end).h(stiffness).f(dampingRatio));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.w
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                z.z(onUpdate, eVar, f10, f11);
            }
        });
        return iVar;
    }
}
