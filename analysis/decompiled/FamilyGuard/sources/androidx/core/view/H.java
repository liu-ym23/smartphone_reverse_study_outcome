package androidx.core.view;

import E.c;
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
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.C0456a;
import androidx.core.view.X;
import androidx.core.view.Y;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import z.C1332d;

/* loaded from: classes.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<View, S> f9730a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f9731b = {C1332d.f23959b, C1332d.f23960c, C1332d.f23971n, C1332d.f23982y, C1332d.f23944B, C1332d.f23945C, C1332d.f23946D, C1332d.f23947E, C1332d.f23948F, C1332d.f23949G, C1332d.f23961d, C1332d.f23962e, C1332d.f23963f, C1332d.f23964g, C1332d.f23965h, C1332d.f23966i, C1332d.f23967j, C1332d.f23968k, C1332d.f23969l, C1332d.f23970m, C1332d.f23972o, C1332d.f23973p, C1332d.f23974q, C1332d.f23975r, C1332d.f23976s, C1332d.f23977t, C1332d.f23978u, C1332d.f23979v, C1332d.f23980w, C1332d.f23981x, C1332d.f23983z, C1332d.f23943A};

    /* renamed from: c, reason: collision with root package name */
    private static final InterfaceC0480z f9732c = new InterfaceC0480z() { // from class: androidx.core.view.G
    };

    /* renamed from: d, reason: collision with root package name */
    private static final e f9733d = new e();

    class a extends f<Boolean> {
        a(int i5, Class cls, int i6) {
            super(i5, cls, i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.j(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f<CharSequence> {
        b(int i5, Class cls, int i6, int i7) {
            super(i5, cls, i6, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return k.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            k.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f<CharSequence> {
        c(int i5, Class cls, int i6, int i7) {
            super(i5, cls, i6, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return m.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            m.f(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f<Boolean> {
        d(int i5, Class cls, int i6) {
            super(i5, cls, i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.H.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f9734a = new WeakHashMap<>();

        e() {
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void d(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.f9734a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                b(view);
            }
        }

        void c(View view) {
            this.f9734a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
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

    static abstract class f<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f9735a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f9736b;

        /* renamed from: c, reason: collision with root package name */
        private final int f9737c;

        /* renamed from: d, reason: collision with root package name */
        private final int f9738d;

        f(int i5, Class<T> cls, int i6) {
            this(i5, cls, 0, i6);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f9737c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract T c(View view);

        abstract void d(View view, T t5);

        T e(View view) {
            if (b()) {
                return c(view);
            }
            T t5 = (T) view.getTag(this.f9735a);
            if (this.f9736b.isInstance(t5)) {
                return t5;
            }
            return null;
        }

        void f(View view, T t5) {
            if (b()) {
                d(view, t5);
            } else if (g(e(view), t5)) {
                H.i(view);
                view.setTag(this.f9735a, t5);
                H.T(view, this.f9738d);
            }
        }

        abstract boolean g(T t5, T t6);

        f(int i5, Class<T> cls, int i6, int i7) {
            this.f9735a = i5;
            this.f9736b = cls;
            this.f9738d = i6;
            this.f9737c = i7;
        }
    }

    static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            Y f9739a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f9740b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ InterfaceC0479y f9741c;

            a(View view, InterfaceC0479y interfaceC0479y) {
                this.f9740b = view;
                this.f9741c = interfaceC0479y;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                Y yU = Y.u(windowInsets, view);
                this.f9739a = yU;
                return this.f9741c.a(view, yU).s();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(C1332d.f23957O);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static Y b(View view, Y y5, Rect rect) {
            WindowInsets windowInsetsS = y5.s();
            if (windowInsetsS != null) {
                return Y.u(view.computeSystemWindowInsets(windowInsetsS, rect), view);
            }
            rect.setEmpty();
            return y5;
        }

        static boolean c(View view, float f5, float f6, boolean z5) {
            return view.dispatchNestedFling(f5, f6, z5);
        }

        static boolean d(View view, float f5, float f6) {
            return view.dispatchNestedPreFling(f5, f6);
        }

        static boolean e(View view, int i5, int i6, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i5, i6, iArr, iArr2);
        }

        static boolean f(View view, int i5, int i6, int i7, int i8, int[] iArr) {
            return view.dispatchNestedScroll(i5, i6, i7, i8, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static Y j(View view) {
            return Y.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f5) {
            view.setElevation(f5);
        }

        static void t(View view, boolean z5) {
            view.setNestedScrollingEnabled(z5);
        }

        static void u(View view, InterfaceC0479y interfaceC0479y) {
            if (interfaceC0479y == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(C1332d.f23957O));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, interfaceC0479y));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f5) {
            view.setTranslationZ(f5);
        }

        static void x(View view, float f5) {
            view.setZ(f5);
        }

        static boolean y(View view, int i5) {
            return view.startNestedScroll(i5);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class i {
        public static Y a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            Y yT = Y.t(rootWindowInsets);
            yT.r(yT);
            yT.d(view.getRootView());
            return yT;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i5) {
            view.setScrollIndicators(i5);
        }

        static void d(View view, int i5, int i6) {
            view.setScrollIndicators(i5, i6);
        }
    }

    static class j {
        static void a(View view, Collection<View> collection, int i5) {
            view.addKeyboardNavigationClusters(collection, i5);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        static int c(View view) {
            return view.getImportantForAutofill();
        }

        static int d(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View i(View view, View view2, int i5) {
            return view.keyboardNavigationClusterSearch(view2, i5);
        }

        static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void l(View view, boolean z5) {
            view.setFocusedByDefault(z5);
        }

        static void m(View view, int i5) {
            view.setImportantForAutofill(i5);
        }

        static void n(View view, boolean z5) {
            view.setKeyboardNavigationCluster(z5);
        }

        static void o(View view, int i5) {
            view.setNextClusterForwardId(i5);
        }

        static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class k {
        static void a(View view, final n nVar) {
            int i5 = C1332d.f23956N;
            q.i iVar = (q.i) view.getTag(i5);
            if (iVar == null) {
                iVar = new q.i();
                view.setTag(i5, iVar);
            }
            Objects.requireNonNull(nVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.I
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return nVar.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            iVar.put(nVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, n nVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            q.i iVar = (q.i) view.getTag(C1332d.f23956N);
            if (iVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) iVar.get(nVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i5) {
            return (T) view.requireViewById(i5);
        }

        static void g(View view, boolean z5) {
            view.setAccessibilityHeading(z5);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, F.a aVar) {
            view.setAutofillId(null);
        }

        static void j(View view, boolean z5) {
            view.setScreenReaderFocusable(z5);
        }
    }

    private static class l {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5, int i6) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i5, i6);
        }

        static void e(View view, G.a aVar) {
            view.setContentCaptureSession(null);
        }

        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class m {
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static Z c(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return Z.d(windowInsetsController);
            }
            return null;
        }

        static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        static void e(View view, int i5) {
            view.setImportantForContentCapture(i5);
        }

        static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public interface n {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    @Deprecated
    public static int A(View view) {
        return view.getMinimumWidth();
    }

    @Deprecated
    public static void A0(View view, float f5) {
        view.setScaleY(f5);
    }

    @Deprecated
    public static int B(View view) {
        return view.getPaddingEnd();
    }

    public static void B0(View view, int i5, int i6) {
        i.d(view, i5, i6);
    }

    @Deprecated
    public static int C(View view) {
        return view.getPaddingStart();
    }

    public static void C0(View view, CharSequence charSequence) {
        J0().f(view, charSequence);
    }

    public static Y D(View view) {
        return i.a(view);
    }

    public static void D0(View view, String str) {
        h.v(view, str);
    }

    public static CharSequence E(View view) {
        return J0().e(view);
    }

    @Deprecated
    public static void E0(View view, float f5) {
        view.setTranslationX(f5);
    }

    public static String F(View view) {
        return h.k(view);
    }

    @Deprecated
    public static void F0(View view, float f5) {
        view.setTranslationY(f5);
    }

    @Deprecated
    public static float G(View view) {
        return view.getTranslationX();
    }

    public static void G0(View view, float f5) {
        h.w(view, f5);
    }

    @Deprecated
    public static float H(View view) {
        return view.getTranslationY();
    }

    public static void H0(View view, X.b bVar) {
        X.c(view, bVar);
    }

    public static float I(View view) {
        return h.l(view);
    }

    public static void I0(View view, float f5) {
        h.x(view, f5);
    }

    @Deprecated
    public static Z J(View view) {
        return m.c(view);
    }

    private static f<CharSequence> J0() {
        return new c(C1332d.f23955M, CharSequence.class, 64, 30);
    }

    @Deprecated
    public static int K(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void K0(View view) {
        h.z(view);
    }

    public static float L(View view) {
        return h.m(view);
    }

    public static boolean M(View view) {
        return l(view) != null;
    }

    @Deprecated
    public static boolean N(View view) {
        return view.hasTransientState();
    }

    public static boolean O(View view) {
        Boolean boolE = a().e(view);
        return boolE != null && boolE.booleanValue();
    }

    @Deprecated
    public static boolean P(View view) {
        return view.isAttachedToWindow();
    }

    @Deprecated
    public static boolean Q(View view) {
        return view.isLaidOut();
    }

    public static boolean R(View view) {
        Boolean boolE = j0().e(view);
        return boolE != null && boolE.booleanValue();
    }

    @Deprecated
    public static void S(View view) {
        view.jumpDrawablesToCurrentState();
    }

    static void T(View view, int i5) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z5 = m(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z5) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z5 ? 32 : RecyclerView.ItemAnimator.FLAG_MOVED);
                accessibilityEventObtain.setContentChangeTypes(i5);
                if (z5) {
                    accessibilityEventObtain.getText().add(m(view));
                    u0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i5 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i5);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(m(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i5);
                } catch (AbstractMethodError e6) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e6);
                }
            }
        }
    }

    public static void U(View view, int i5) {
        view.offsetLeftAndRight(i5);
    }

    public static void V(View view, int i5) {
        view.offsetTopAndBottom(i5);
    }

    public static Y W(View view, Y y5) {
        WindowInsets windowInsetsS = y5.s();
        if (windowInsetsS != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsS);
            if (!windowInsetsB.equals(windowInsetsS)) {
                return Y.u(windowInsetsB, view);
            }
        }
        return y5;
    }

    @Deprecated
    public static void X(View view, E.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.D0());
    }

    private static f<CharSequence> Y() {
        return new b(C1332d.f23953K, CharSequence.class, 8, 28);
    }

    @Deprecated
    public static boolean Z(View view, int i5, Bundle bundle) {
        return view.performAccessibilityAction(i5, bundle);
    }

    private static f<Boolean> a() {
        return new d(C1332d.f23952J, Boolean.class, 28);
    }

    @Deprecated
    public static void a0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int b(View view, CharSequence charSequence, E.f fVar) {
        int iP = p(view, charSequence);
        if (iP != -1) {
            c(view, new c.a(iP, charSequence, fVar));
        }
        return iP;
    }

    @Deprecated
    public static void b0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    private static void c(View view, c.a aVar) {
        i(view);
        e0(aVar.b(), view);
        n(view).add(aVar);
        T(view, 0);
    }

    @Deprecated
    public static void c0(View view, Runnable runnable, long j5) {
        view.postOnAnimationDelayed(runnable, j5);
    }

    @Deprecated
    public static S d(View view) {
        if (f9730a == null) {
            f9730a = new WeakHashMap<>();
        }
        S s5 = f9730a.get(view);
        if (s5 != null) {
            return s5;
        }
        S s6 = new S(view);
        f9730a.put(view, s6);
        return s6;
    }

    public static void d0(View view, int i5) {
        e0(i5, view);
        T(view, 0);
    }

    @Deprecated
    public static boolean e(View view, int i5) {
        return view.canScrollHorizontally(i5);
    }

    private static void e0(int i5, View view) {
        List<c.a> listN = n(view);
        for (int i6 = 0; i6 < listN.size(); i6++) {
            if (listN.get(i6).b() == i5) {
                listN.remove(i6);
                return;
            }
        }
    }

    public static Y f(View view, Y y5, Rect rect) {
        return h.b(view, y5, rect);
    }

    public static void f0(View view, c.a aVar, CharSequence charSequence, E.f fVar) {
        if (fVar == null && charSequence == null) {
            d0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, fVar));
        }
    }

    public static Y g(View view, Y y5) {
        WindowInsets windowInsetsS = y5.s();
        if (windowInsetsS != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsS);
            if (!windowInsetsA.equals(windowInsetsS)) {
                return Y.u(windowInsetsA, view);
            }
        }
        return y5;
    }

    public static void g0(View view) {
        g.c(view);
    }

    static boolean h(View view, KeyEvent keyEvent) {
        return false;
    }

    @Deprecated
    public static int h0(int i5, int i6, int i7) {
        return View.resolveSizeAndState(i5, i6, i7);
    }

    static void i(View view) {
        C0456a c0456aK = k(view);
        if (c0456aK == null) {
            c0456aK = new C0456a();
        }
        k0(view, c0456aK);
    }

    public static void i0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5, int i6) {
        l.d(view, context, iArr, attributeSet, typedArray, i5, i6);
    }

    @Deprecated
    public static int j() {
        return View.generateViewId();
    }

    private static f<Boolean> j0() {
        return new a(C1332d.f23954L, Boolean.class, 28);
    }

    public static C0456a k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof C0456a.C0121a ? ((C0456a.C0121a) accessibilityDelegateL).f9799a : new C0456a(accessibilityDelegateL);
    }

    public static void k0(View view, C0456a c0456a) {
        if (c0456a == null && (l(view) instanceof C0456a.C0121a)) {
            c0456a = new C0456a();
        }
        u0(view);
        view.setAccessibilityDelegate(c0456a == null ? null : c0456a.getBridge());
    }

    private static View.AccessibilityDelegate l(View view) {
        return l.a(view);
    }

    public static void l0(View view, boolean z5) {
        a().f(view, Boolean.valueOf(z5));
    }

    public static CharSequence m(View view) {
        return Y().e(view);
    }

    public static void m0(View view, CharSequence charSequence) {
        Y().f(view, charSequence);
        if (charSequence != null) {
            f9733d.a(view);
        } else {
            f9733d.c(view);
        }
    }

    private static List<c.a> n(View view) {
        int i5 = C1332d.f23950H;
        ArrayList arrayList = (ArrayList) view.getTag(i5);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i5, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static void n0(View view, float f5) {
        view.setAlpha(f5);
    }

    @Deprecated
    public static float o(View view) {
        return view.getAlpha();
    }

    @Deprecated
    public static void o0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    private static int p(View view, CharSequence charSequence) {
        List<c.a> listN = n(view);
        for (int i5 = 0; i5 < listN.size(); i5++) {
            if (TextUtils.equals(charSequence, listN.get(i5).c())) {
                return listN.get(i5).b();
            }
        }
        int i6 = -1;
        int i7 = 0;
        while (true) {
            int[] iArr = f9731b;
            if (i7 >= iArr.length || i6 != -1) {
                break;
            }
            int i8 = iArr[i7];
            boolean z5 = true;
            for (int i9 = 0; i9 < listN.size(); i9++) {
                z5 &= listN.get(i9).b() != i8;
            }
            if (z5) {
                i6 = i8;
            }
            i7++;
        }
        return i6;
    }

    public static void p0(View view, ColorStateList colorStateList) {
        h.q(view, colorStateList);
    }

    public static ColorStateList q(View view) {
        return h.g(view);
    }

    public static void q0(View view, PorterDuff.Mode mode) {
        h.r(view, mode);
    }

    public static PorterDuff.Mode r(View view) {
        return h.h(view);
    }

    public static void r0(View view, float f5) {
        h.s(view, f5);
    }

    @Deprecated
    public static Display s(View view) {
        return view.getDisplay();
    }

    @Deprecated
    public static void s0(View view, boolean z5) {
        view.setFitsSystemWindows(z5);
    }

    public static float t(View view) {
        return h.i(view);
    }

    @Deprecated
    public static void t0(View view, int i5) {
        view.setImportantForAccessibility(i5);
    }

    @Deprecated
    public static boolean u(View view) {
        return view.getFitsSystemWindows();
    }

    private static void u0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @Deprecated
    public static int v(View view) {
        return view.getImportantForAccessibility();
    }

    public static void v0(View view, int i5) {
        j.m(view, i5);
    }

    public static int w(View view) {
        return j.c(view);
    }

    public static void w0(View view, InterfaceC0479y interfaceC0479y) {
        h.u(view, interfaceC0479y);
    }

    @Deprecated
    public static int x(View view) {
        return view.getLayoutDirection();
    }

    @Deprecated
    public static void x0(View view, int i5, int i6, int i7, int i8) {
        view.setPaddingRelative(i5, i6, i7, i8);
    }

    @Deprecated
    public static int y(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static void y0(View view, float f5) {
        view.setRotation(f5);
    }

    @Deprecated
    public static int z(View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static void z0(View view, float f5) {
        view.setScaleX(f5);
    }
}
