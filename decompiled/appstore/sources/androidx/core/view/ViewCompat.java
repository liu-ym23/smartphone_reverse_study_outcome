package androidx.core.view;

import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
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
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f2685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakHashMap f2686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f2688d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final OnReceiveContentViewBehavior f2689e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f2690f = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NestedScrollType {
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View r10, @NonNull KeyEvent r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    public class a extends f {
        public a(int r10, Class r11, int r12) {
            super(r10, r11, r12);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ Object d(View r10) {
            return i(r10);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ void e(View r10, Object r11) {
            j(r10, (Boolean) r11);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ boolean h(Object r10, Object r11) {
            return k((Boolean) r10, (Boolean) r11);
        }

        public Boolean i(View r10) {
            return Boolean.valueOf(q.d(r10));
        }

        public void j(View r10, Boolean r11) {
            q.i(r10, r11.booleanValue());
        }

        public boolean k(Boolean r10, Boolean r11) {
            return !a(r10, r11);
        }
    }

    public class b extends f {
        public b(int r10, Class r11, int r12, int r13) {
            super(r10, r11, r12, r13);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ Object d(View r10) {
            return i(r10);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ void e(View r10, Object r11) {
            j(r10, (CharSequence) r11);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ boolean h(Object r10, Object r11) {
            return k((CharSequence) r10, (CharSequence) r11);
        }

        public CharSequence i(View r10) {
            return q.b(r10);
        }

        public void j(View r10, CharSequence r11) {
            q.h(r10, r11);
        }

        public boolean k(CharSequence r10, CharSequence r11) {
            return !TextUtils.equals(r10, r11);
        }
    }

    public class c extends f {
        public c(int r10, Class r11, int r12, int r13) {
            super(r10, r11, r12, r13);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ Object d(View r10) {
            return i(r10);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ void e(View r10, Object r11) {
            j(r10, (CharSequence) r11);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ boolean h(Object r10, Object r11) {
            return k((CharSequence) r10, (CharSequence) r11);
        }

        public CharSequence i(View r10) {
            return s.a(r10);
        }

        public void j(View r10, CharSequence r11) {
            s.b(r10, r11);
        }

        public boolean k(CharSequence r10, CharSequence r11) {
            return !TextUtils.equals(r10, r11);
        }
    }

    public class d extends f {
        public d(int r10, Class r11, int r12) {
            super(r10, r11, r12);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ Object d(View r10) {
            return i(r10);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ void e(View r10, Object r11) {
            j(r10, (Boolean) r11);
        }

        @Override // androidx.core.view.ViewCompat.f
        public /* bridge */ /* synthetic */ boolean h(Object r10, Object r11) {
            return k((Boolean) r10, (Boolean) r11);
        }

        public Boolean i(View r10) {
            return Boolean.valueOf(q.c(r10));
        }

        public void j(View r10, Boolean r11) {
            q.g(r10, r11.booleanValue());
        }

        public boolean k(Boolean r10, Boolean r11) {
            return !a(r10, r11);
        }
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap f2691a;

        public e() {
            this.f2691a = new WeakHashMap();
        }

        public void a(View r10) {
            WeakHashMap r11 = this.f2691a;
            if (r10.isShown() == true) goto L5;
        L7:
            boolean r12 = false;
        L8:
            r11.put(r10, Boolean.valueOf(r12));
            r10.addOnAttachStateChangeListener(this);
            if (k.b(r10) == false) goto L12;
            b(r10);
            return;
        L12:
            return;
        L5:
            if (r10.getWindowVisibility() != 0) goto L7;
            r12 = true;
            goto L8
        }

        public final void b(View r10) {
            r10.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void c(View r10) {
            this.f2691a.remove(r10);
            r10.removeOnAttachStateChangeListener(this);
            d(r10);
        }

        public final void d(View r10) {
            h.o(r10.getViewTreeObserver(), this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            b(r10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f2693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2695d;

        public f(int r10, Class r11, int r12) {
            this(r10, r11, 0, r12);
        }

        public boolean a(Boolean r10, Boolean r11) {
            if (r10 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r11 != null) goto L10;
        L12:
            boolean r13 = false;
        L13:
            if (r12 == r13) goto L15;
            return false;
        L15:
            return true;
        L10:
            if (r11.booleanValue() == false) goto L12;
            r13 = true;
            goto L13
        L5:
            if (r10.booleanValue() == false) goto L7;
            r12 = true;
            goto L8
        }

        public final boolean b() {
            return true;
        }

        public final boolean c() {
            if (Build.VERSION.SDK_INT < this.f2694c) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract Object d(View r10);

        public abstract void e(View r10, Object r11);

        public Object f(View r10) {
            if (c() == false) goto L7;
            return d(r10);
        L7:
            if (b() == false) goto L11;
            Object r11 = r10.getTag(this.f2692a);
            if (this.f2693b.isInstance(r11) == false) goto L13;
            return r11;
        L13:
            return null;
        L11:
            return null;
        }

        public void g(View r10, Object r11) {
            if (c() == false) goto L6;
            e(r10, r11);
            return;
        L6:
            if (b() == true) goto L8;
            return;
        L8:
            if (h(f(r10), r11) == false) goto L13;
            ViewCompat.j(r10);
            r10.setTag(this.f2692a, r11);
            ViewCompat.Y(r10, this.f2695d);
            return;
        }

        public abstract boolean h(Object r10, Object r11);

        public f(int r10, Class r11, int r12, int r13) {
            this.f2692a = r10;
            this.f2693b = r11;
            this.f2695d = r12;
            this.f2694c = r13;
        }
    }

    public static class g {
        @DoNotInline
        public static boolean a(@NonNull View r10) {
            return r10.hasOnClickListeners();
        }
    }

    public static class h {
        @DoNotInline
        public static AccessibilityNodeProvider a(View r10) {
            return r10.getAccessibilityNodeProvider();
        }

        @DoNotInline
        public static boolean b(View r10) {
            return r10.getFitsSystemWindows();
        }

        @DoNotInline
        public static int c(View r10) {
            return r10.getImportantForAccessibility();
        }

        @DoNotInline
        public static int d(View r10) {
            return r10.getMinimumHeight();
        }

        @DoNotInline
        public static int e(View r10) {
            return r10.getMinimumWidth();
        }

        @DoNotInline
        public static ViewParent f(View r10) {
            return r10.getParentForAccessibility();
        }

        @DoNotInline
        public static int g(View r10) {
            return r10.getWindowSystemUiVisibility();
        }

        @DoNotInline
        public static boolean h(View r10) {
            return r10.hasOverlappingRendering();
        }

        @DoNotInline
        public static boolean i(View r10) {
            return r10.hasTransientState();
        }

        @DoNotInline
        public static boolean j(View r10, int r11, Bundle r12) {
            return r10.performAccessibilityAction(r11, r12);
        }

        @DoNotInline
        public static void k(View r10) {
            r10.postInvalidateOnAnimation();
        }

        @DoNotInline
        public static void l(View r10, int r11, int r12, int r13, int r14) {
            r10.postInvalidateOnAnimation(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void m(View r10, Runnable r11) {
            r10.postOnAnimation(r11);
        }

        @DoNotInline
        public static void n(View r10, Runnable r11, long r12) {
            r10.postOnAnimationDelayed(r11, r12);
        }

        @DoNotInline
        public static void o(ViewTreeObserver r10, ViewTreeObserver.OnGlobalLayoutListener r11) {
            r10.removeOnGlobalLayoutListener(r11);
        }

        @DoNotInline
        public static void p(View r10) {
            r10.requestFitSystemWindows();
        }

        @DoNotInline
        public static void q(View r10, Drawable r11) {
            r10.setBackground(r11);
        }

        @DoNotInline
        public static void r(View r10, boolean r11) {
            r10.setHasTransientState(r11);
        }

        @DoNotInline
        public static void s(View r10, int r11) {
            r10.setImportantForAccessibility(r11);
        }
    }

    public static class i {
        @DoNotInline
        public static int a() {
            return View.generateViewId();
        }

        @DoNotInline
        public static Display b(@NonNull View r10) {
            return r10.getDisplay();
        }

        @DoNotInline
        public static int c(View r10) {
            return r10.getLabelFor();
        }

        @DoNotInline
        public static int d(View r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        public static int e(View r10) {
            return r10.getPaddingEnd();
        }

        @DoNotInline
        public static int f(View r10) {
            return r10.getPaddingStart();
        }

        @DoNotInline
        public static boolean g(View r10) {
            return r10.isPaddingRelative();
        }

        @DoNotInline
        public static void h(View r10, int r11) {
            r10.setLabelFor(r11);
        }

        @DoNotInline
        public static void i(View r10, Paint r11) {
            r10.setLayerPaint(r11);
        }

        @DoNotInline
        public static void j(View r10, int r11) {
            r10.setLayoutDirection(r11);
        }

        @DoNotInline
        public static void k(View r10, int r11, int r12, int r13, int r14) {
            r10.setPaddingRelative(r11, r12, r13, r14);
        }
    }

    public static class j {
        @DoNotInline
        public static Rect a(@NonNull View r10) {
            return r10.getClipBounds();
        }

        @DoNotInline
        public static boolean b(@NonNull View r10) {
            return r10.isInLayout();
        }

        @DoNotInline
        public static void c(@NonNull View r10, Rect r11) {
            r10.setClipBounds(r11);
        }
    }

    public static class k {
        @DoNotInline
        public static int a(View r10) {
            return r10.getAccessibilityLiveRegion();
        }

        @DoNotInline
        public static boolean b(@NonNull View r10) {
            return r10.isAttachedToWindow();
        }

        @DoNotInline
        public static boolean c(@NonNull View r10) {
            return r10.isLaidOut();
        }

        @DoNotInline
        public static boolean d(@NonNull View r10) {
            return r10.isLayoutDirectionResolved();
        }

        @DoNotInline
        public static void e(ViewParent r10, View r11, View r12, int r13) {
            r10.notifySubtreeAccessibilityStateChanged(r11, r12, r13);
        }

        @DoNotInline
        public static void f(View r10, int r11) {
            r10.setAccessibilityLiveRegion(r11);
        }

        @DoNotInline
        public static void g(AccessibilityEvent r10, int r11) {
            r10.setContentChangeTypes(r11);
        }
    }

    public static class l {
        @DoNotInline
        public static WindowInsets a(View r10, WindowInsets r11) {
            return r10.dispatchApplyWindowInsets(r11);
        }

        @DoNotInline
        public static WindowInsets b(View r10, WindowInsets r11) {
            return r10.onApplyWindowInsets(r11);
        }

        @DoNotInline
        public static void c(View r10) {
            r10.requestApplyInsets();
        }
    }

    public static class m {

        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public WindowInsetsCompat f2696a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f2697b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ OnApplyWindowInsetsListener f2698c;

            public a(View r10, OnApplyWindowInsetsListener r11) {
                this.f2697b = r10;
                this.f2698c = r11;
                this.f2696a = null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
                WindowInsetsCompat r12 = WindowInsetsCompat.z(r11, r10);
                this.f2696a = r12;
                return this.f2698c.onApplyWindowInsets(r10, r12).x();
            }
        }

        @DoNotInline
        public static void a(@NonNull WindowInsets r10, @NonNull View r11) {
            View.OnApplyWindowInsetsListener r12 = (View.OnApplyWindowInsetsListener) r11.getTag(R$id.tag_window_insets_animation_callback);
            if (r12 == null) goto L6;
            r12.onApplyWindowInsets(r11, r10);
            return;
        }

        @DoNotInline
        public static WindowInsetsCompat b(@NonNull View r10, @NonNull WindowInsetsCompat r11, @NonNull Rect r12) {
            WindowInsets r13 = r11.x();
            if (r13 != null) goto L5;
            r12.setEmpty();
            return r11;
        L5:
            return WindowInsetsCompat.z(r10.computeSystemWindowInsets(r13, r12), r10);
        }

        @DoNotInline
        public static boolean c(@NonNull View r10, float r11, float r12, boolean r13) {
            return r10.dispatchNestedFling(r11, r12, r13);
        }

        @DoNotInline
        public static boolean d(@NonNull View r10, float r11, float r12) {
            return r10.dispatchNestedPreFling(r11, r12);
        }

        @DoNotInline
        public static boolean e(View r10, int r11, int r12, int[] r13, int[] r14) {
            return r10.dispatchNestedPreScroll(r11, r12, r13, r14);
        }

        @DoNotInline
        public static boolean f(View r10, int r11, int r12, int r13, int r14, int[] r15) {
            return r10.dispatchNestedScroll(r11, r12, r13, r14, r15);
        }

        @DoNotInline
        public static ColorStateList g(View r10) {
            return r10.getBackgroundTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode h(View r10) {
            return r10.getBackgroundTintMode();
        }

        @DoNotInline
        public static float i(View r10) {
            return r10.getElevation();
        }

        @Nullable
        @DoNotInline
        public static WindowInsetsCompat j(@NonNull View r10) {
            return WindowInsetsCompat.a.a(r10);
        }

        @DoNotInline
        public static String k(View r10) {
            return r10.getTransitionName();
        }

        @DoNotInline
        public static float l(View r10) {
            return r10.getTranslationZ();
        }

        @DoNotInline
        public static float m(@NonNull View r10) {
            return r10.getZ();
        }

        @DoNotInline
        public static boolean n(View r10) {
            return r10.hasNestedScrollingParent();
        }

        @DoNotInline
        public static boolean o(View r10) {
            return r10.isImportantForAccessibility();
        }

        @DoNotInline
        public static boolean p(View r10) {
            return r10.isNestedScrollingEnabled();
        }

        @DoNotInline
        public static void q(View r10, ColorStateList r11) {
            r10.setBackgroundTintList(r11);
        }

        @DoNotInline
        public static void r(View r10, PorterDuff.Mode r11) {
            r10.setBackgroundTintMode(r11);
        }

        @DoNotInline
        public static void s(View r10, float r11) {
            r10.setElevation(r11);
        }

        @DoNotInline
        public static void t(View r10, boolean r11) {
            r10.setNestedScrollingEnabled(r11);
        }

        @DoNotInline
        public static void u(@NonNull View r10, @Nullable OnApplyWindowInsetsListener r11) {
            if (r11 != null) goto L5;
            r10.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r10.getTag(R$id.tag_window_insets_animation_callback));
            return;
        L5:
            r10.setOnApplyWindowInsetsListener(new a(r10, r11));
        }

        @DoNotInline
        public static void v(View r10, String r11) {
            r10.setTransitionName(r11);
        }

        @DoNotInline
        public static void w(View r10, float r11) {
            r10.setTranslationZ(r11);
        }

        @DoNotInline
        public static void x(@NonNull View r10, float r11) {
            r10.setZ(r11);
        }

        @DoNotInline
        public static boolean y(View r10, int r11) {
            return r10.startNestedScroll(r11);
        }

        @DoNotInline
        public static void z(View r10) {
            r10.stopNestedScroll();
        }
    }

    public static class n {
        @Nullable
        public static WindowInsetsCompat a(@NonNull View r10) {
            WindowInsets r11 = r10.getRootWindowInsets();
            if (r11 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r12 = WindowInsetsCompat.y(r11);
            r12.w(r12);
            r12.d(r10.getRootView());
            return r12;
        }

        @DoNotInline
        public static int b(@NonNull View r10) {
            return r10.getScrollIndicators();
        }

        @DoNotInline
        public static void c(@NonNull View r10, int r11) {
            r10.setScrollIndicators(r11);
        }

        @DoNotInline
        public static void d(@NonNull View r10, int r11, int r12) {
            r10.setScrollIndicators(r11, r12);
        }
    }

    public static class o {
        @DoNotInline
        public static void a(@NonNull View r10) {
            r10.cancelDragAndDrop();
        }

        @DoNotInline
        public static void b(View r10) {
            r10.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        public static void c(View r10) {
            r10.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        public static void d(@NonNull View r10, PointerIcon r11) {
            r10.setPointerIcon(r11);
        }

        @DoNotInline
        public static boolean e(@NonNull View r10, @Nullable ClipData r11, @NonNull View.DragShadowBuilder r12, @Nullable Object r13, int r14) {
            return r10.startDragAndDrop(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void f(@NonNull View r10, @NonNull View.DragShadowBuilder r11) {
            r10.updateDragShadow(r11);
        }
    }

    public static class p {
        @DoNotInline
        public static void a(@NonNull View r10, Collection<View> r11, int r12) {
            r10.addKeyboardNavigationClusters(r11, r12);
        }

        @DoNotInline
        public static int b(View r10) {
            return r10.getImportantForAutofill();
        }

        @DoNotInline
        public static int c(@NonNull View r10) {
            return r10.getNextClusterForwardId();
        }

        @DoNotInline
        public static boolean d(@NonNull View r10) {
            return r10.hasExplicitFocusable();
        }

        @DoNotInline
        public static boolean e(@NonNull View r10) {
            return r10.isFocusedByDefault();
        }

        @DoNotInline
        public static boolean f(View r10) {
            return r10.isImportantForAutofill();
        }

        @DoNotInline
        public static boolean g(@NonNull View r10) {
            return r10.isKeyboardNavigationCluster();
        }

        @DoNotInline
        public static View h(@NonNull View r10, View r11, int r12) {
            return r10.keyboardNavigationClusterSearch(r11, r12);
        }

        @DoNotInline
        public static boolean i(@NonNull View r10) {
            return r10.restoreDefaultFocus();
        }

        @DoNotInline
        public static void j(@NonNull View r10, String... r11) {
            r10.setAutofillHints(r11);
        }

        @DoNotInline
        public static void k(@NonNull View r10, boolean r11) {
            r10.setFocusedByDefault(r11);
        }

        @DoNotInline
        public static void l(View r10, int r11) {
            r10.setImportantForAutofill(r11);
        }

        @DoNotInline
        public static void m(@NonNull View r10, boolean r11) {
            r10.setKeyboardNavigationCluster(r11);
        }

        @DoNotInline
        public static void n(View r10, int r11) {
            r10.setNextClusterForwardId(r11);
        }

        @DoNotInline
        public static void o(@NonNull View r10, CharSequence r11) {
            r10.setTooltipText(r11);
        }
    }

    public static class q {
        @DoNotInline
        public static void a(@NonNull View r10, @NonNull final OnUnhandledKeyEventListenerCompat r11) {
            int r12 = R$id.tag_unhandled_key_listeners;
            SimpleArrayMap r13 = (SimpleArrayMap) r10.getTag(r12);
            if (r13 != null) goto L5;
            r13 = new SimpleArrayMap();
            r10.setTag(r12, r13);
        L5:
            Objects.requireNonNull(r11);
            View.OnUnhandledKeyEventListener r14 = new androidx.core.view.m(r11);
            r13.put(r11, r14);
            r10.addOnUnhandledKeyEventListener(r14);
        }

        @DoNotInline
        public static CharSequence b(View r10) {
            return r10.getAccessibilityPaneTitle();
        }

        @DoNotInline
        public static boolean c(View r10) {
            return r10.isAccessibilityHeading();
        }

        @DoNotInline
        public static boolean d(View r10) {
            return r10.isScreenReaderFocusable();
        }

        @DoNotInline
        public static void e(@NonNull View r10, @NonNull OnUnhandledKeyEventListenerCompat r11) {
            SimpleArrayMap r12 = (SimpleArrayMap) r10.getTag(R$id.tag_unhandled_key_listeners);
            if (r12 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r13 = (View.OnUnhandledKeyEventListener) r12.get(r11);
            if (r13 == null) goto L9;
            r10.removeOnUnhandledKeyEventListener(r13);
            return;
        }

        @DoNotInline
        public static <T> T f(View r10, int r11) {
            return (T) r10.requireViewById(r11);
        }

        @DoNotInline
        public static void g(View r10, boolean r11) {
            r10.setAccessibilityHeading(r11);
        }

        @DoNotInline
        public static void h(View r10, CharSequence r11) {
            r10.setAccessibilityPaneTitle(r11);
        }

        @DoNotInline
        public static void i(View r10, boolean r11) {
            r10.setScreenReaderFocusable(r11);
        }
    }

    public static class r {
        @DoNotInline
        public static View.AccessibilityDelegate a(View r10) {
            return r10.getAccessibilityDelegate();
        }

        @DoNotInline
        public static List<Rect> b(View r10) {
            return r10.getSystemGestureExclusionRects();
        }

        @DoNotInline
        public static void c(@NonNull View r10, @NonNull Context r11, @NonNull int[] r12, @Nullable AttributeSet r13, @NonNull TypedArray r14, int r15, int r16) {
            r10.saveAttributeDataForStyleable(r11, r12, r13, r14, r15, r16);
        }

        @DoNotInline
        public static void d(View r10, List<Rect> r11) {
            r10.setSystemGestureExclusionRects(r11);
        }
    }

    public static class s {
        @DoNotInline
        public static CharSequence a(View r10) {
            return r10.getStateDescription();
        }

        @DoNotInline
        public static void b(View r10, CharSequence r11) {
            r10.setStateDescription(r11);
        }
    }

    public static final class t {
        @Nullable
        @DoNotInline
        public static String[] a(@NonNull View r10) {
            return r10.getReceiveContentMimeTypes();
        }

        @Nullable
        @DoNotInline
        public static ContentInfoCompat b(@NonNull View r10, @NonNull ContentInfoCompat r11) {
            ContentInfo r12 = r11.f();
            ContentInfo r13 = r10.performReceiveContent(r12);
            if (r13 != null) goto L6;
            return null;
        L6:
            if (r13 != r12) goto L9;
            return r11;
        L9:
            return ContentInfoCompat.g(r13);
        }

        @DoNotInline
        public static void c(@NonNull View r10, @Nullable String[] r11, @Nullable OnReceiveContentListener r12) {
            if (r12 != null) goto L4;
            r10.setOnReceiveContentListener(r11, null);
            return;
        L4:
            r10.setOnReceiveContentListener(r11, new u(r12));
        }
    }

    public static final class u implements android.view.OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OnReceiveContentListener f2699a;

        public u(@NonNull OnReceiveContentListener r10) {
            this.f2699a = r10;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View r10, ContentInfo r11) {
            ContentInfoCompat r12 = ContentInfoCompat.g(r11);
            ContentInfoCompat r13 = this.f2699a.onReceiveContent(r10, r12);
            if (r13 != null) goto L6;
            return null;
        L6:
            if (r13 != r12) goto L9;
            return r11;
        L9:
            return r13.f();
        }
    }

    static {
        f2685a = new AtomicInteger(1);
        f2686b = null;
        f2687c = false;
        f2688d = new int[]{R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};
        f2689e = new androidx.core.view.l();
        f2690f = new e();
    }

    public static int A(View r10) {
        return i.d(r10);
    }

    public static void A0(View r10, int r11) {
        h.s(r10, r11);
    }

    public static int B(View r10) {
        return h.d(r10);
    }

    public static void B0(View r10, int r11) {
        p.l(r10, r11);
    }

    public static int C(View r10) {
        return h.e(r10);
    }

    public static void C0(View r10, OnApplyWindowInsetsListener r11) {
        m.u(r10, r11);
    }

    public static String[] D(View r10) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return t.a(r10);
    L7:
        return (String[]) r10.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static void D0(View r10, int r11, int r12, int r13, int r14) {
        i.k(r10, r11, r12, r13, r14);
    }

    public static int E(View r10) {
        return i.e(r10);
    }

    public static void E0(View r10, androidx.core.view.k r11) {
        if (r11 == null) goto L4;
        Object r12 = r11.a();
    L5:
        o.d(r10, (PointerIcon) r12);
        return;
    L4:
        r12 = null;
        goto L5
    }

    public static int F(View r10) {
        return i.f(r10);
    }

    public static void F0(View r10, int r11, int r12) {
        n.d(r10, r11, r12);
    }

    public static ViewParent G(View r10) {
        return h.f(r10);
    }

    public static void G0(View r10, CharSequence r11) {
        L0().g(r10, r11);
    }

    public static WindowInsetsCompat H(View r10) {
        return n.a(r10);
    }

    public static void H0(View r10, String r11) {
        m.v(r10, r11);
    }

    public static CharSequence I(View r10) {
        return (CharSequence) L0().f(r10);
    }

    public static void I0(View r10, float r11) {
        m.w(r10, r11);
    }

    public static String J(View r10) {
        return m.k(r10);
    }

    public static void J0(View r10) {
        if (y(r10) != 0) goto L5;
        A0(r10, 1);
    L5:
        ViewParent r11 = r10.getParent();
    L7:
        if ((r11 instanceof View) == false) goto L15;
        if (y((View) r11) == 4) goto L10;
        r11 = r11.getParent();
        goto L7
    L10:
        A0(r10, 2);
        return;
    }

    public static float K(View r10) {
        return m.l(r10);
    }

    public static void K0(View r10, float r11) {
        m.x(r10, r11);
    }

    public static int L(View r10) {
        return h.g(r10);
    }

    public static f L0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static float M(View r10) {
        return m.m(r10);
    }

    public static void M0(View r10) {
        m.z(r10);
    }

    public static boolean N(View r10) {
        if (m(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean O(View r10) {
        return g.a(r10);
    }

    public static boolean P(View r10) {
        return h.h(r10);
    }

    public static boolean Q(View r10) {
        return h.i(r10);
    }

    public static boolean R(View r10) {
        Boolean r11 = (Boolean) b().f(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.booleanValue() == false) goto L7;
        return true;
    }

    public static boolean S(View r10) {
        return k.b(r10);
    }

    public static boolean T(View r10) {
        return k.c(r10);
    }

    public static boolean U(View r10) {
        return m.p(r10);
    }

    public static boolean V(View r10) {
        return i.g(r10);
    }

    public static boolean W(View r10) {
        Boolean r11 = (Boolean) o0().f(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.booleanValue() == false) goto L7;
        return true;
    }

    public static /* synthetic */ ContentInfoCompat X(ContentInfoCompat r10) {
        return r10;
    }

    public static void Y(View r10, int r11) {
        AccessibilityManager r12 = (AccessibilityManager) r10.getContext().getSystemService("accessibility");
        if (r12.isEnabled() == true) goto L6;
        return;
    L6:
        if (o(r10) != null) goto L8;
    L12:
        boolean r13 = false;
    L13:
        int r14 = 32;
        if (n(r10) != 0) goto L26;
        if (r13 == true) goto L26;
        if (r11 != 32) goto L20;
        AccessibilityEvent r15 = AccessibilityEvent.obtain();
        r10.onInitializeAccessibilityEvent(r15);
        r15.setEventType(32);
        k.g(r15, r11);
        r15.setSource(r10);
        r10.onPopulateAccessibilityEvent(r15);
        r15.getText().add(o(r10));
        r12.sendAccessibilityEvent(r15);
        return;
    L20:
        if (r10.getParent() != null) goto L35;
        return;
    L35:
        k.e(r10.getParent(), r10, r10, r11);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        Log.e("ViewCompat", r10.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
        return;
    L26:
        AccessibilityEvent r16 = AccessibilityEvent.obtain();
        if (r13 == true) goto L30;
        r14 = 2048;
    L30:
        r16.setEventType(r14);
        k.g(r16, r11);
        if (r13 == false) goto L33;
        r16.getText().add(o(r10));
        J0(r10);
    L33:
        r10.sendAccessibilityEventUnchecked(r16);
        return;
    L8:
        if (r10.isShown() == false) goto L12;
        if (r10.getWindowVisibility() != 0) goto L12;
        r13 = true;
        goto L13
    }

    public static void Z(View r10, int r11) {
        r10.offsetLeftAndRight(r11);
    }

    public static /* synthetic */ ContentInfoCompat a(ContentInfoCompat r10) {
        return X(r10);
    }

    public static void a0(View r10, int r11) {
        r10.offsetTopAndBottom(r11);
    }

    public static f b() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static WindowInsetsCompat b0(View r10, WindowInsetsCompat r11) {
        WindowInsets r12 = r11.x();
        if (r12 == null) goto L8;
        WindowInsets r13 = l.b(r10, r12);
        if (r13.equals(r12) == true) goto L8;
        return WindowInsetsCompat.z(r13, r10);
    L8:
        return r11;
    }

    public static int c(View r10, CharSequence r11, AccessibilityViewCommand r12) {
        int r13 = q(r10, r11);
        if (r13 == (-1)) goto L5;
        d(r10, new AccessibilityNodeInfoCompat.a(r13, r11, r12));
    L5:
        return r13;
    }

    public static void c0(View r10, AccessibilityNodeInfoCompat r11) {
        r10.onInitializeAccessibilityNodeInfo(r11.A0());
    }

    public static void d(View r10, AccessibilityNodeInfoCompat.a r11) {
        j(r10);
        k0(r11.b(), r10);
        p(r10).add(r11);
        Y(r10, 0);
    }

    public static f d0() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static androidx.core.view.r e(View r10) {
        if (f2686b != null) goto L5;
        f2686b = new WeakHashMap();
    L5:
        androidx.core.view.r r11 = (androidx.core.view.r) f2686b.get(r10);
        if (r11 != null) goto L9;
        androidx.core.view.r r12 = new androidx.core.view.r(r10);
        f2686b.put(r10, r12);
        return r12;
    L9:
        return r11;
    }

    public static boolean e0(View r10, int r11, Bundle r12) {
        return h.j(r10, r11, r12);
    }

    public static boolean f(View r10, int r11) {
        return r10.canScrollVertically(r11);
    }

    public static ContentInfoCompat f0(View r10, ContentInfoCompat r11) {
        if (Log.isLoggable("ViewCompat", 3) == false) goto L6;
        Log.d("ViewCompat", "performReceiveContent: " + r11 + ", view=" + r10.getClass().getSimpleName() + "[" + r10.getId() + "]");
    L6:
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        OnReceiveContentListener r12 = (OnReceiveContentListener) r10.getTag(R$id.tag_on_receive_content_listener);
        if (r12 == null) goto L17;
        ContentInfoCompat r13 = r12.onReceiveContent(r10, r11);
        if (r13 != null) goto L15;
        return null;
    L15:
        return w(r10).onReceiveContent(r13);
    L17:
        return w(r10).onReceiveContent(r11);
    L8:
        return t.b(r10, r11);
    }

    public static WindowInsetsCompat g(View r10, WindowInsetsCompat r11, Rect r12) {
        return m.b(r10, r11, r12);
    }

    public static void g0(View r10) {
        h.k(r10);
    }

    public static WindowInsetsCompat h(View r10, WindowInsetsCompat r11) {
        WindowInsets r12 = r11.x();
        if (r12 == null) goto L8;
        WindowInsets r13 = l.a(r10, r12);
        if (r13.equals(r12) == true) goto L8;
        return WindowInsetsCompat.z(r13, r10);
    L8:
        return r11;
    }

    public static void h0(View r10, Runnable r11) {
        h.m(r10, r11);
    }

    public static boolean i(View r10, KeyEvent r11) {
        return false;
    }

    public static void i0(View r10, Runnable r11, long r12) {
        h.n(r10, r11, r12);
    }

    public static void j(View r10) {
        androidx.core.view.a r11 = l(r10);
        if (r11 != null) goto L5;
        r11 = new androidx.core.view.a();
    L5:
        p0(r10, r11);
    }

    public static void j0(View r10, int r11) {
        k0(r11, r10);
        Y(r10, 0);
    }

    public static int k() {
        return i.a();
    }

    public static void k0(int r10, View r11) {
        List r12 = p(r11);
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L12;
        if (((AccessibilityNodeInfoCompat.a) r12.get(r13)).b() == r10) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        r12.remove(r13);
        return;
    }

    public static androidx.core.view.a l(View r10) {
        View.AccessibilityDelegate r11 = m(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        if ((r11 instanceof androidx.core.view.a.C0020a) == false) goto L11;
        return ((androidx.core.view.a.C0020a) r11).f2733a;
    L11:
        return new androidx.core.view.a(r11);
    }

    public static void l0(View r10, AccessibilityNodeInfoCompat.a r11, CharSequence r12, AccessibilityViewCommand r13) {
        if (r13 != null) goto L5;
        if (r12 != null) goto L5;
        j0(r10, r11.b());
        return;
    L5:
        d(r10, r11.a(r12, r13));
    }

    public static View.AccessibilityDelegate m(View r10) {
        return r.a(r10);
    }

    public static void m0(View r10) {
        l.c(r10);
    }

    public static int n(View r10) {
        return k.a(r10);
    }

    public static void n0(View r10, Context r11, int[] r12, AttributeSet r13, TypedArray r14, int r15, int r16) {
        r.c(r10, r11, r12, r13, r14, r15, r16);
    }

    public static CharSequence o(View r10) {
        return (CharSequence) d0().f(r10);
    }

    public static f o0() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static List p(View r10) {
        int r11 = R$id.tag_accessibility_actions;
        ArrayList r12 = (ArrayList) r10.getTag(r11);
        if (r12 != null) goto L6;
        ArrayList r13 = new ArrayList();
        r10.setTag(r11, r13);
        return r13;
    L6:
        return r12;
    }

    public static void p0(View r10, androidx.core.view.a r11) {
        if (r11 == null) goto L4;
    L6:
        if (r11 != null) goto L8;
        View.AccessibilityDelegate r12 = null;
    L9:
        r10.setAccessibilityDelegate(r12);
        return;
    L8:
        r12 = r11.getBridge();
        goto L9
    L4:
        if ((m(r10) instanceof androidx.core.view.a.C0020a) == false) goto L6;
        r11 = new androidx.core.view.a();
        goto L6
    }

    public static int q(View r10, CharSequence r11) {
        List r12 = p(r10);
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L10;
        if (TextUtils.equals(r11, ((AccessibilityNodeInfoCompat.a) r12.get(r13)).c()) == true) goto L8;
        r13 = r13 + 1;
        goto L4
    L8:
        return ((AccessibilityNodeInfoCompat.a) r12.get(r13)).b();
    L10:
        int r14 = -1;
        int r15 = 0;
    L11:
        int[] r16 = f2688d;
        if (r15 >= r16.length) goto L25;
        if (r14 != (-1)) goto L25;
        int r17 = r16[r15];
        int r18 = 0;
        boolean r19 = true;
    L16:
        if (r18 >= r12.size()) goto L22;
        if (((AccessibilityNodeInfoCompat.a) r12.get(r18)).b() == r17) goto L20;
        boolean r20 = true;
    L21:
        r19 = r19 & r20;
        r18 = r18 + 1;
        goto L16
    L20:
        r20 = false;
        goto L21
    L22:
        if (r19 == false) goto L24;
        r14 = r17;
    L24:
        r15 = r15 + 1;
    L25:
        return r14;
    }

    public static void q0(View r10, boolean r11) {
        b().g(r10, Boolean.valueOf(r11));
    }

    public static ColorStateList r(View r10) {
        return m.g(r10);
    }

    public static void r0(View r10, int r11) {
        k.f(r10, r11);
    }

    public static PorterDuff.Mode s(View r10) {
        return m.h(r10);
    }

    public static void s0(View r10, CharSequence r11) {
        d0().g(r10, r11);
        if (r11 == null) goto L5;
        f2690f.a(r10);
        return;
    L5:
        f2690f.c(r10);
    }

    public static Rect t(View r10) {
        return j.a(r10);
    }

    public static void t0(View r10, Drawable r11) {
        h.q(r10, r11);
    }

    public static Display u(View r10) {
        return i.b(r10);
    }

    public static void u0(View r10, ColorStateList r11) {
        m.q(r10, r11);
    }

    public static float v(View r10) {
        return m.i(r10);
    }

    public static void v0(View r10, PorterDuff.Mode r11) {
        m.r(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static OnReceiveContentViewBehavior w(View r10) {
        if ((r10 instanceof OnReceiveContentViewBehavior) == false) goto L7;
        return (OnReceiveContentViewBehavior) r10;
    L7:
        return f2689e;
    }

    public static void w0(View r10, Rect r11) {
        j.c(r10, r11);
    }

    public static boolean x(View r10) {
        return h.b(r10);
    }

    public static void x0(View r10, float r11) {
        m.s(r10, r11);
    }

    public static int y(View r10) {
        return h.c(r10);
    }

    public static void y0(View r10, boolean r11) {
        r10.setFitsSystemWindows(r11);
    }

    public static int z(View r10) {
        return p.b(r10);
    }

    public static void z0(View r10, boolean r11) {
        h.r(r10, r11);
    }
}
