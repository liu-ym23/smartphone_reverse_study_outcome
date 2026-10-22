package androidx.core.view;

import C0.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import androidx.core.view.C1313a;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class N {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, U> f13117a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f13118b = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* renamed from: c, reason: collision with root package name */
    public static final C f13119c = new C() { // from class: androidx.core.view.M
    };

    /* renamed from: d, reason: collision with root package name */
    public static final e f13120d = new e();

    public class a extends f<Boolean> {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        @Override // androidx.core.view.N.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.f(view, bool.booleanValue());
        }

        @Override // androidx.core.view.N.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class b extends f<CharSequence> {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.a(view);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.e(view, charSequence);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class c extends f<CharSequence> {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.b(view);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.d(view, charSequence);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends f<Boolean> {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // androidx.core.view.N.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.b(view));
        }

        @Override // androidx.core.view.N.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.d(view, bool.booleanValue());
        }

        @Override // androidx.core.view.N.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f13121a = new WeakHashMap<>();

        public void a(View view) {
            this.f13121a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                b(view);
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void c(View view) {
            this.f13121a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
        }

        public final void d(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f13122a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f13123b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13124c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13125d;

        public f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.f13124c;
        }

        public abstract T c(View view);

        public abstract void d(View view, T t10);

        public T e(View view) {
            if (b()) {
                return c(view);
            }
            T t10 = (T) view.getTag(this.f13122a);
            if (this.f13123b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        public void f(View view, T t10) {
            if (b()) {
                d(view, t10);
            } else if (g(e(view), t10)) {
                N.h(view);
                view.setTag(this.f13122a, t10);
                N.R(view, this.f13125d);
            }
        }

        public abstract boolean g(T t10, T t11);

        public f(int i10, Class<T> cls, int i11, int i12) {
            this.f13122a = i10;
            this.f13123b = cls;
            this.f13125d = i11;
            this.f13124c = i12;
        }
    }

    public static class g {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void b(View view) {
            view.requestApplyInsets();
        }
    }

    public static class h {

        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public a0 f13126a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f13127b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ A f13128c;

            public a(View view, A a10) {
                this.f13127b = view;
                this.f13128c = a10;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                a0 a0VarZ = a0.z(windowInsets, view);
                this.f13126a = a0VarZ;
                return this.f13128c.a(view, a0VarZ).x();
            }
        }

        public static a0 a(View view, a0 a0Var, Rect rect) {
            WindowInsets windowInsetsX = a0Var.x();
            if (windowInsetsX != null) {
                return a0.z(view.computeSystemWindowInsets(windowInsetsX, rect), view);
            }
            rect.setEmpty();
            return a0Var;
        }

        public static ColorStateList b(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode c(View view) {
            return view.getBackgroundTintMode();
        }

        public static float d(View view) {
            return view.getElevation();
        }

        public static String e(View view) {
            return view.getTransitionName();
        }

        public static float f(View view) {
            return view.getTranslationZ();
        }

        public static float g(View view) {
            return view.getZ();
        }

        public static boolean h(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void i(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void j(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void k(View view, float f10) {
            view.setElevation(f10);
        }

        public static void l(View view, A a10) {
            a aVar = a10 != null ? new a(view, a10) : null;
            if (view.getTag(R$id.tag_compat_insets_dispatch) != null) {
                return;
            }
            if (aVar != null) {
                view.setOnApplyWindowInsetsListener(aVar);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            }
        }

        public static void m(View view, String str) {
            view.setTransitionName(str);
        }

        public static void n(View view, float f10) {
            view.setTranslationZ(f10);
        }

        public static void o(View view, float f10) {
            view.setZ(f10);
        }

        public static void p(View view) {
            view.stopNestedScroll();
        }
    }

    public static class i {
        public static a0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            a0 a0VarY = a0.y(rootWindowInsets);
            a0VarY.v(a0VarY);
            a0VarY.d(view.getRootView());
            return a0VarY;
        }

        public static void b(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    public static class j {
        public static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    public static class k {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i10) {
            view.setImportantForAutofill(i10);
        }
    }

    public static class l {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    public static class m {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static class n {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static b0 c(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return b0.h(windowInsetsController);
            }
            return null;
        }

        public static void d(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public static final class o {
        public static void a(View view, String[] strArr, B b10) {
            if (b10 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new p(b10));
            }
        }
    }

    public static final class p implements OnReceiveContentListener {

        /* renamed from: a, reason: collision with root package name */
        public final B f13129a;

        public p(B b10) {
            this.f13129a = b10;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C1315c c1315cE = C1315c.e(contentInfo);
            C1315c c1315cA = this.f13129a.a(view, c1315cE);
            if (c1315cA == null) {
                return null;
            }
            return c1315cA == c1315cE ? contentInfo : c1315cA.d();
        }
    }

    @Deprecated
    public static ViewParent A(View view) {
        return view.getParentForAccessibility();
    }

    public static void A0(View view, CharSequence charSequence) {
        G0().f(view, charSequence);
    }

    public static a0 B(View view) {
        return i.a(view);
    }

    public static void B0(View view, String str) {
        h.m(view, str);
    }

    public static CharSequence C(View view) {
        return G0().e(view);
    }

    @Deprecated
    public static void C0(View view, float f10) {
        view.setTranslationY(f10);
    }

    public static String D(View view) {
        return h.e(view);
    }

    public static void D0(View view, float f10) {
        h.n(view, f10);
    }

    @Deprecated
    public static float E(View view) {
        return view.getTranslationY();
    }

    public static void E0(View view, Z.b bVar) {
        Z.e(view, bVar);
    }

    public static float F(View view) {
        return h.f(view);
    }

    public static void F0(View view, float f10) {
        h.o(view, f10);
    }

    @Deprecated
    public static b0 G(View view) {
        return n.c(view);
    }

    public static f<CharSequence> G0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    @Deprecated
    public static int H(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void H0(View view) {
        h.p(view);
    }

    public static float I(View view) {
        return h.g(view);
    }

    public static boolean J(View view) {
        return j(view) != null;
    }

    @Deprecated
    public static boolean K(View view) {
        return view.hasTransientState();
    }

    public static boolean L(View view) {
        Boolean boolE = a().e(view);
        return boolE != null && boolE.booleanValue();
    }

    @Deprecated
    public static boolean M(View view) {
        return view.isAttachedToWindow();
    }

    @Deprecated
    public static boolean N(View view) {
        return view.isLaidOut();
    }

    public static boolean O(View view) {
        return h.h(view);
    }

    public static boolean P(View view) {
        Boolean boolE = h0().e(view);
        return boolE != null && boolE.booleanValue();
    }

    @Deprecated
    public static void Q(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void R(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = k(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(k(view));
                    s0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i10);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(k(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    public static void S(View view, int i10) {
        view.offsetLeftAndRight(i10);
    }

    public static void T(View view, int i10) {
        view.offsetTopAndBottom(i10);
    }

    public static a0 U(View view, a0 a0Var) {
        WindowInsets windowInsetsX = a0Var.x();
        if (windowInsetsX != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsX);
            if (!windowInsetsA.equals(windowInsetsX)) {
                return a0.z(windowInsetsA, view);
            }
        }
        return a0Var;
    }

    @Deprecated
    public static void V(View view, C0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.R0());
    }

    public static f<CharSequence> W() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    @Deprecated
    public static boolean X(View view, int i10, Bundle bundle) {
        return view.performAccessibilityAction(i10, bundle);
    }

    @Deprecated
    public static void Y(View view) {
        view.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void Z(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static f<Boolean> a() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    public static void a0(View view, Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    public static int b(View view, CharSequence charSequence, C0.f fVar) {
        int iM = m(view, charSequence);
        if (iM != -1) {
            c(view, new c.a(iM, charSequence, fVar));
        }
        return iM;
    }

    public static void b0(View view, int i10) {
        c0(i10, view);
        R(view, 0);
    }

    public static void c(View view, c.a aVar) {
        h(view);
        c0(aVar.b(), view);
        l(view).add(aVar);
        R(view, 0);
    }

    public static void c0(int i10, View view) {
        List<c.a> listL = l(view);
        for (int i11 = 0; i11 < listL.size(); i11++) {
            if (listL.get(i11).b() == i10) {
                listL.remove(i11);
                return;
            }
        }
    }

    @Deprecated
    public static U d(View view) {
        if (f13117a == null) {
            f13117a = new WeakHashMap<>();
        }
        U u10 = f13117a.get(view);
        if (u10 != null) {
            return u10;
        }
        U u11 = new U(view);
        f13117a.put(view, u11);
        return u11;
    }

    public static void d0(View view, c.a aVar, CharSequence charSequence, C0.f fVar) {
        if (fVar == null && charSequence == null) {
            b0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, fVar));
        }
    }

    public static a0 e(View view, a0 a0Var, Rect rect) {
        return h.a(view, a0Var, rect);
    }

    public static void e0(View view) {
        g.b(view);
    }

    public static a0 f(View view, a0 a0Var) {
        WindowInsets windowInsetsX = a0Var.x();
        if (windowInsetsX != null) {
            WindowInsets windowInsetsA = n.a(view, windowInsetsX);
            if (!windowInsetsA.equals(windowInsetsX)) {
                return a0.z(windowInsetsA, view);
            }
        }
        return a0Var;
    }

    @Deprecated
    public static int f0(int i10, int i11, int i12) {
        return View.resolveSizeAndState(i10, i11, i12);
    }

    public static boolean g(View view, KeyEvent keyEvent) {
        return false;
    }

    public static void g0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        m.b(view, context, iArr, attributeSet, typedArray, i10, i11);
    }

    public static void h(View view) {
        C1313a c1313aI = i(view);
        if (c1313aI == null) {
            c1313aI = new C1313a();
        }
        i0(view, c1313aI);
    }

    public static f<Boolean> h0() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static C1313a i(View view) {
        View.AccessibilityDelegate accessibilityDelegateJ = j(view);
        if (accessibilityDelegateJ == null) {
            return null;
        }
        return accessibilityDelegateJ instanceof C1313a.C0159a ? ((C1313a.C0159a) accessibilityDelegateJ).f13158a : new C1313a(accessibilityDelegateJ);
    }

    public static void i0(View view, C1313a c1313a) {
        if (c1313a == null && (j(view) instanceof C1313a.C0159a)) {
            c1313a = new C1313a();
        }
        s0(view);
        view.setAccessibilityDelegate(c1313a == null ? null : c1313a.getBridge());
    }

    public static View.AccessibilityDelegate j(View view) {
        return m.a(view);
    }

    public static void j0(View view, boolean z10) {
        a().f(view, Boolean.valueOf(z10));
    }

    public static CharSequence k(View view) {
        return W().e(view);
    }

    public static void k0(View view, CharSequence charSequence) {
        W().f(view, charSequence);
        if (charSequence != null) {
            f13120d.a(view);
        } else {
            f13120d.c(view);
        }
    }

    public static List<c.a> l(View view) {
        int i10 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static void l0(View view, float f10) {
        view.setAlpha(f10);
    }

    public static int m(View view, CharSequence charSequence) {
        List<c.a> listL = l(view);
        for (int i10 = 0; i10 < listL.size(); i10++) {
            if (TextUtils.equals(charSequence, listL.get(i10).c())) {
                return listL.get(i10).b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f13118b;
            if (i12 >= iArr.length || i11 != -1) {
                break;
            }
            int i13 = iArr[i12];
            boolean z10 = true;
            for (int i14 = 0; i14 < listL.size(); i14++) {
                z10 &= listL.get(i14).b() != i13;
            }
            if (z10) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    @Deprecated
    public static void m0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static ColorStateList n(View view) {
        return h.b(view);
    }

    public static void n0(View view, ColorStateList colorStateList) {
        h.i(view, colorStateList);
    }

    public static PorterDuff.Mode o(View view) {
        return h.c(view);
    }

    public static void o0(View view, PorterDuff.Mode mode) {
        h.j(view, mode);
    }

    @Deprecated
    public static Display p(View view) {
        return view.getDisplay();
    }

    public static void p0(View view, float f10) {
        h.k(view, f10);
    }

    public static float q(View view) {
        return h.d(view);
    }

    @Deprecated
    public static void q0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    @Deprecated
    public static boolean r(View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static void r0(View view, int i10) {
        view.setImportantForAccessibility(i10);
    }

    @Deprecated
    public static int s(View view) {
        return view.getImportantForAccessibility();
    }

    public static void s0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int t(View view) {
        return k.a(view);
    }

    public static void t0(View view, int i10) {
        k.b(view, i10);
    }

    @Deprecated
    public static int u(View view) {
        return view.getLayoutDirection();
    }

    public static void u0(View view, A a10) {
        h.l(view, a10);
    }

    @Deprecated
    public static int v(View view) {
        return view.getMeasuredState();
    }

    public static void v0(View view, String[] strArr, B b10) {
        o.a(view, strArr, b10);
    }

    @Deprecated
    public static int w(View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static void w0(View view, int i10, int i11, int i12, int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    @Deprecated
    public static int x(View view) {
        return view.getMinimumWidth();
    }

    public static void x0(View view, E e10) {
        j.a(view, (PointerIcon) (e10 != null ? e10.a() : null));
    }

    @Deprecated
    public static int y(View view) {
        return view.getPaddingEnd();
    }

    @Deprecated
    public static void y0(View view, float f10) {
        view.setRotation(f10);
    }

    @Deprecated
    public static int z(View view) {
        return view.getPaddingStart();
    }

    public static void z0(View view, int i10, int i11) {
        i.b(view, i10, i11);
    }
}
