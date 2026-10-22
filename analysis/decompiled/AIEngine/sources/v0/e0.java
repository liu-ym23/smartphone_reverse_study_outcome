package v0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import v0.a;
import v0.c;
import v0.m0;
import w0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, h0> f13274a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f13275b = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: c, reason: collision with root package name */
    public static final a0 f13276c = new a0();

    /* renamed from: d, reason: collision with root package name */
    public static final a f13277d = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f13279a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f13280b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13281c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13282d;

        public b(int i10, Class<T> cls, int i11, int i12) {
            this.f13279a = i10;
            this.f13280b = cls;
            this.f13282d = i11;
            this.f13281c = i12;
        }

        public abstract T a(View view);

        public abstract void b(View view, T t8);

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(View view, T t8) {
            Object tag;
            int i10 = Build.VERSION.SDK_INT;
            int i11 = this.f13281c;
            if (i10 >= i11) {
                b(view, t8);
                return;
            }
            int i12 = Build.VERSION.SDK_INT;
            int i13 = this.f13279a;
            if (i12 >= i11) {
                tag = a(view);
            } else {
                tag = view.getTag(i13);
                if (!this.f13280b.isInstance(tag)) {
                    tag = null;
                }
            }
            if (d(tag, t8)) {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                View.AccessibilityDelegate accessibilityDelegateA = h.a(view);
                v0.a aVar = accessibilityDelegateA != null ? accessibilityDelegateA instanceof a.C0151a ? ((a.C0151a) accessibilityDelegateA).f13251a : new v0.a(accessibilityDelegateA) : null;
                if (aVar == null) {
                    aVar = new v0.a();
                }
                e0.j(view, aVar);
                view.setTag(i13, t8);
                e0.e(this.f13282d, view);
            }
        }

        public abstract boolean d(T t8, T t10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void b(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r f13283a;

            public a(View view, r rVar) {
                this.f13283a = rVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.f13283a.g(view, m0.h(view, windowInsets)).g();
            }
        }

        public static m0 a(View view, m0 m0Var, Rect rect) {
            WindowInsets windowInsetsG = m0Var.g();
            if (windowInsetsG != null) {
                return m0.h(view, view.computeSystemWindowInsets(windowInsetsG, rect));
            }
            rect.setEmpty();
            return m0Var;
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
            return view.getZ();
        }

        public static boolean g(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void h(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void i(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void j(View view, float f8) {
            view.setElevation(f8);
        }

        public static void k(View view, r rVar) {
            a aVar = rVar != null ? new a(view, rVar) : null;
            if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
                return;
            }
            if (aVar != null) {
                view.setOnApplyWindowInsetsListener(aVar);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            }
        }

        public static void l(View view, String str) {
            view.setTransitionName(str);
        }

        public static void m(View view) {
            view.stopNestedScroll();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {
        public static m0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            m0 m0VarH = m0.h(null, rootWindowInsets);
            m0.m mVar = m0VarH.f13309a;
            mVar.r(m0VarH);
            mVar.d(view.getRootView());
            return m0VarH;
        }

        public static void b(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i10) {
            view.setImportantForAutofill(i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class h {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class i {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class j {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static v0.c b(View view, v0.c cVar) {
            ContentInfo contentInfoA = cVar.f13253a.a();
            Objects.requireNonNull(contentInfoA);
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoA);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoA ? cVar : new v0.c(new c.d(contentInfoPerformReceiveContent));
        }
    }

    @Deprecated
    public static h0 a(View view) {
        if (f13274a == null) {
            f13274a = new WeakHashMap<>();
        }
        h0 h0Var = f13274a.get(view);
        if (h0Var != null) {
            return h0Var;
        }
        h0 h0Var2 = new h0(view);
        f13274a.put(view, h0Var2);
        return h0Var2;
    }

    public static m0 b(View view, m0 m0Var) {
        WindowInsets windowInsetsG = m0Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsA = i.a(view, windowInsetsG);
            if (!windowInsetsA.equals(windowInsetsG)) {
                return m0.h(view, windowInsetsA);
            }
        }
        return m0Var;
    }

    public static ArrayList c(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] d(androidx.appcompat.widget.k kVar) {
        return Build.VERSION.SDK_INT >= 31 ? j.a(kVar) : (String[]) kVar.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void e(int i10, View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = g.a(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i10);
                if (z) {
                    accessibilityEventObtain.getText().add(g.a(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                        return;
                    } catch (AbstractMethodError e10) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e10);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i10);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(g.a(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static m0 f(View view, m0 m0Var) {
        WindowInsets windowInsetsG = m0Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsA = c.a(view, windowInsetsG);
            if (!windowInsetsA.equals(windowInsetsG)) {
                return m0.h(view, windowInsetsA);
            }
        }
        return m0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static v0.c g(View view, v0.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return j.b(view, cVar);
        }
        s sVar = (s) view.getTag(R.id.tag_on_receive_content_listener);
        t tVar = f13276c;
        if (sVar == null) {
            if (view instanceof t) {
                tVar = (t) view;
            }
            return tVar.a(cVar);
        }
        v0.c cVarA = sVar.a(view, cVar);
        if (cVarA == null) {
            return null;
        }
        if (view instanceof t) {
            tVar = (t) view;
        }
        return tVar.a(cVarA);
    }

    public static void h(int i10, View view) {
        ArrayList arrayListC = c(view);
        for (int i11 = 0; i11 < arrayListC.size(); i11++) {
            if (((b.a) arrayListC.get(i11)).a() == i10) {
                arrayListC.remove(i11);
                return;
            }
        }
    }

    public static void i(View view, b.a aVar, w0.d dVar) {
        b.a aVar2 = new b.a(null, aVar.f13543b, null, dVar, aVar.f13544c);
        View.AccessibilityDelegate accessibilityDelegateA = h.a(view);
        v0.a aVar3 = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof a.C0151a ? ((a.C0151a) accessibilityDelegateA).f13251a : new v0.a(accessibilityDelegateA);
        if (aVar3 == null) {
            aVar3 = new v0.a();
        }
        j(view, aVar3);
        h(aVar2.a(), view);
        c(view).add(aVar2);
        e(0, view);
    }

    public static void j(View view, v0.a aVar) {
        if (aVar == null && (h.a(view) instanceof a.C0151a)) {
            aVar = new v0.a();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    public static void k(View view, CharSequence charSequence) {
        new b0(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).c(view, charSequence);
        a aVar = f13277d;
        if (charSequence == null) {
            aVar.f13278a.remove(view);
            view.removeOnAttachStateChangeListener(aVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(aVar);
        } else {
            aVar.f13278a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(aVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f13278a = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
