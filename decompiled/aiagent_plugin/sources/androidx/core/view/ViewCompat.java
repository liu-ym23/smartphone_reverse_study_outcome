package androidx.core.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
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
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat {
    private static final String TAG = "ViewCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f1388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f1389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f1391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1392e;
    private static WeakHashMap<View, String> f;
    private static WeakHashMap<View, ae> g;
    private static Field h;
    private static boolean i;
    private static ThreadLocal<Rect> j;
    private static final int[] k = null;
    private static final v l = null;
    private static final AccessibilityPaneVisibilityManager m = null;

    static class AccessibilityPaneVisibilityManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
        }

        AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 28) goto L8;
            Iterator<Map.Entry<View, Boolean>> r0 = this.mPanesToVisible.entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            checkPaneVisibility((View) ZeusTransformUtils.preCheckCast(r1.getKey(), View.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            goto L6
        L10:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            registerForLayoutCallback(r1);
        }

        void addAccessibilityPane(View r3) {
            WeakHashMap<View, Boolean> r0 = this.mPanesToVisible;
            if (r3.isShown() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.put(r3, Boolean.valueOf(r1));
            r3.addOnAttachStateChangeListener(this);
            if (f.b(r3) == false) goto L12;
            registerForLayoutCallback(r3);
            return;
        L12:
            return;
        L5:
            if (r3.getWindowVisibility() != 0) goto L7;
            r1 = true;
            goto L8
        }

        void removeAccessibilityPane(View r2) {
            this.mPanesToVisible.remove(r2);
            r2.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r2);
        }

        private void checkPaneVisibility(View r2, boolean r3) {
            if (r2.isShown() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r3 == r0) goto L14;
            if (r0 == false) goto L11;
            int r4 = 16;
        L12:
            ViewCompat.h(r2, r4);
            this.mPanesToVisible.put(r2, Boolean.valueOf(r0));
            return;
        L11:
            r4 = 32;
            goto L12
        L14:
            return;
        L5:
            if (r2.getWindowVisibility() != 0) goto L7;
            r0 = true;
            goto L8
        }

        private void registerForLayoutCallback(View r1) {
            r1.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View r1) {
            c.a(r1.getViewTreeObserver(), this);
        }
    }

    private static final class OnReceiveContentListenerAdapter implements OnReceiveContentListener {
        private final u mJetpackListener;

        OnReceiveContentListenerAdapter(u r3) {
            this.mJetpackListener = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View r2, ContentInfo r3) {
            androidx.core.view.b r0 = androidx.core.view.b.a(r3);
            androidx.core.view.b r1 = this.mJetpackListener.a(r2, r0);
            if (r1 != null) goto L6;
            return null;
        L6:
            if (r1 != r0) goto L9;
            return r3;
        L9:
            return r1.a();
        }
    }

    static abstract class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f1394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1396d;

        abstract void a(View r1, T r2);

        abstract T b(View r1);

        a(int r2, Class<T> r3, int r4) {
            this(r2, r3, 0, r4);
        }

        a(int r1, Class<T> r2, int r3, int r4) {
            this.f1393a = r1;
            this.f1394b = r2;
            this.f1396d = r3;
            this.f1395c = r4;
        }

        void b(View r2, T r3) {
            if (a() == false) goto L6;
            a(r2, r3);
            return;
        L6:
            if (b() == true) goto L8;
            return;
        L8:
            if (a(c(r2), r3) == false) goto L13;
            ViewCompat.d(r2);
            r2.setTag(this.f1393a, r3);
            ViewCompat.h(r2, this.f1396d);
            return;
        }

        T c(View r2) {
            if (a() == false) goto L7;
            return b(r2);
        L7:
            if (b() == false) goto L11;
            T r3 = (T) r2.getTag(this.f1393a);
            if (ZeusTransformUtils.instanceOf(this.f1394b, r3) == false) goto L13;
            return r3;
        L13:
            return null;
        L11:
            return null;
        }

        private boolean a() {
            if (Build.VERSION.SDK_INT < this.f1395c) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean b() {
            if (Build.VERSION.SDK_INT < 19) goto L5;
            return true;
        L5:
            return false;
        }

        boolean a(T r1, T r2) {
            return !r2.equals(r1);
        }

        boolean b(Boolean r2, Boolean r3) {
            if (r2 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r3 != null) goto L10;
        L12:
            boolean r5 = false;
        L13:
            if (r4 != r5) goto L16;
            return true;
        L16:
            return false;
        L10:
            if (r3.booleanValue() == false) goto L12;
            r5 = true;
            goto L13
        L5:
            if (r2.booleanValue() == false) goto L7;
            r4 = true;
            goto L8
        }
    }

    static class b {
        static boolean a(View r0) {
            return r0.hasOnClickListeners();
        }
    }

    static class c {
        static boolean a(View r0) {
            return r0.hasTransientState();
        }

        static void a(View r0, boolean r1) {
            r0.setHasTransientState(r1);
        }

        static void b(View r0) {
            r0.postInvalidateOnAnimation();
        }

        static void a(View r0, int r1, int r2, int r3, int r4) {
            r0.postInvalidateOnAnimation(r1, r2, r3, r4);
        }

        static void a(View r2, Runnable r3) {
            r2.postOnAnimation((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));
        }

        static void a(View r2, Runnable r3, long r4) {
            r2.postOnAnimationDelayed((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), r4);
        }

        static int c(View r0) {
            return r0.getImportantForAccessibility();
        }

        static void a(View r0, int r1) {
            r0.setImportantForAccessibility(r1);
        }

        static AccessibilityNodeProvider d(View r0) {
            return r0.getAccessibilityNodeProvider();
        }

        static ViewParent e(View r0) {
            return r0.getParentForAccessibility();
        }

        static int f(View r0) {
            return r0.getMinimumWidth();
        }

        static int g(View r0) {
            return r0.getMinimumHeight();
        }

        static int h(View r0) {
            return r0.getWindowSystemUiVisibility();
        }

        static void i(View r0) {
            r0.requestFitSystemWindows();
        }

        static boolean j(View r0) {
            return r0.getFitsSystemWindows();
        }

        static boolean a(View r0, int r1, Bundle r2) {
            return r0.performAccessibilityAction(r1, r2);
        }

        static boolean k(View r0) {
            return r0.hasOverlappingRendering();
        }

        static void a(View r0, Drawable r1) {
            r0.setBackground(r1);
        }

        static void a(ViewTreeObserver r2, ViewTreeObserver.OnGlobalLayoutListener r3) {
            r2.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin"));
        }
    }

    static class d {
        static Display a(View r0) {
            return r0.getDisplay();
        }

        static int a() {
            return View.generateViewId();
        }

        static int b(View r0) {
            return r0.getLabelFor();
        }

        static void a(View r0, int r1) {
            r0.setLabelFor(r1);
        }

        static void a(View r0, Paint r1) {
            r0.setLayerPaint(r1);
        }

        static int c(View r0) {
            return r0.getLayoutDirection();
        }

        static void b(View r0, int r1) {
            r0.setLayoutDirection(r1);
        }

        static int d(View r0) {
            return r0.getPaddingStart();
        }

        static int e(View r0) {
            return r0.getPaddingEnd();
        }

        static void a(View r0, int r1, int r2, int r3, int r4) {
            r0.setPaddingRelative(r1, r2, r3, r4);
        }

        static boolean f(View r0) {
            return r0.isPaddingRelative();
        }
    }

    static class e {
        static boolean a(View r0) {
            return r0.isInLayout();
        }

        static void a(View r0, Rect r1) {
            r0.setClipBounds(r1);
        }

        static Rect b(View r0) {
            return r0.getClipBounds();
        }
    }

    static class f {
        static boolean a(View r0) {
            return r0.isLaidOut();
        }

        static boolean b(View r0) {
            return r0.isAttachedToWindow();
        }

        static boolean c(View r0) {
            return r0.isLayoutDirectionResolved();
        }

        static int d(View r0) {
            return r0.getAccessibilityLiveRegion();
        }

        static void a(View r0, int r1) {
            r0.setAccessibilityLiveRegion(r1);
        }

        static void a(AccessibilityEvent r0, int r1) {
            r0.setContentChangeTypes(r1);
        }

        static void a(ViewParent r2, View r3, View r4, int r5) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.aiagent.plugin")).notifySubtreeAccessibilityStateChanged(r3, r4, r5);
        }
    }

    static class g {
        static void a(View r0) {
            r0.requestApplyInsets();
        }

        static WindowInsets a(View r0, WindowInsets r1) {
            return r0.onApplyWindowInsets(r1);
        }

        static WindowInsets b(View r0, WindowInsets r1) {
            return r0.dispatchApplyWindowInsets(r1);
        }
    }

    private static class h {
        public static al a(View r0) {
            return al.a.a(r0);
        }

        static al a(View r1, al r2, Rect r3) {
            WindowInsets r0 = r2.m();
            if (r0 != null) goto L5;
            r3.setEmpty();
            return r2;
        L5:
            return al.a(r1.computeSystemWindowInsets(r0, r3), r1);
        }

        static void a(final View r4, t r5) {
            final t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 30) goto L5;
            r4.setTag(ZeusTransformUtils.mapRes(R.id.tag_on_apply_window_listener, DbHelper.COL_ID, "tag_on_apply_window_listener"), r6);
        L5:
            if (r6 != null) goto L8;
            r4.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_window_insets_animation_callback, DbHelper.COL_ID, "tag_window_insets_animation_callback")), View.OnApplyWindowInsetsListener.class, "com.obric.aiagent.plugin"));
            return;
        L8:
            r4.setOnApplyWindowInsetsListener(new ViewCompat$Api21Impl$1(r4, r6));
        }

        static void a(WindowInsets r3, View r4) {
            View.OnApplyWindowInsetsListener r0 = (View.OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_window_insets_animation_callback, DbHelper.COL_ID, "tag_window_insets_animation_callback")), View.OnApplyWindowInsetsListener.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L6;
            r0.onApplyWindowInsets(r4, r3);
            return;
        }

        static boolean a(View r0, float r1, float r2, boolean r3) {
            return r0.dispatchNestedFling(r1, r2, r3);
        }

        static boolean a(View r0, float r1, float r2) {
            return r0.dispatchNestedPreFling(r1, r2);
        }

        static float b(View r0) {
            return r0.getZ();
        }

        static void a(View r0, float r1) {
            r0.setZ(r1);
        }

        static void b(View r0, float r1) {
            r0.setElevation(r1);
        }

        static void c(View r0, float r1) {
            r0.setTranslationZ(r1);
        }

        static float c(View r0) {
            return r0.getTranslationZ();
        }

        static void a(View r0, String r1) {
            r0.setTransitionName(r1);
        }

        static boolean d(View r0) {
            return r0.isImportantForAccessibility();
        }

        static float e(View r0) {
            return r0.getElevation();
        }

        static String f(View r0) {
            return r0.getTransitionName();
        }

        static void a(View r0, ColorStateList r1) {
            r0.setBackgroundTintList(r1);
        }

        static ColorStateList g(View r0) {
            return r0.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View r0) {
            return r0.getBackgroundTintMode();
        }

        static void a(View r0, PorterDuff.Mode r1) {
            r0.setBackgroundTintMode(r1);
        }

        static void a(View r0, boolean r1) {
            r0.setNestedScrollingEnabled(r1);
        }

        static boolean i(View r0) {
            return r0.isNestedScrollingEnabled();
        }

        static boolean a(View r0, int r1) {
            return r0.startNestedScroll(r1);
        }

        static void j(View r0) {
            r0.stopNestedScroll();
        }

        static boolean k(View r0) {
            return r0.hasNestedScrollingParent();
        }

        static boolean a(View r0, int r1, int r2, int r3, int r4, int[] r5) {
            return r0.dispatchNestedScroll(r1, r2, r3, r4, r5);
        }

        static boolean a(View r0, int r1, int r2, int[] r3, int[] r4) {
            return r0.dispatchNestedPreScroll(r1, r2, r3, r4);
        }
    }

    private static class i {
        public static al a(View r1) {
            WindowInsets r0 = r1.getRootWindowInsets();
            if (r0 != null) goto L6;
            return null;
        L6:
            al r2 = al.a(r0);
            r2.a(r2);
            r2.a(r1.getRootView());
            return r2;
        }

        static void a(View r0, int r1) {
            r0.setScrollIndicators(r1);
        }

        static void a(View r0, int r1, int r2) {
            r0.setScrollIndicators(r1, r2);
        }

        static int b(View r0) {
            return r0.getScrollIndicators();
        }
    }

    static class j {
        static void a(View r0, PointerIcon r1) {
            r0.setPointerIcon(r1);
        }

        static boolean a(View r0, ClipData r1, View.DragShadowBuilder r2, Object r3, int r4) {
            return r0.startDragAndDrop(r1, r2, r3, r4);
        }

        static void a(View r0) {
            r0.cancelDragAndDrop();
        }

        static void a(View r0, View.DragShadowBuilder r1) {
            r0.updateDragShadow(r1);
        }

        static void b(View r0) {
            r0.dispatchStartTemporaryDetach();
        }

        static void c(View r0) {
            r0.dispatchFinishTemporaryDetach();
        }
    }

    static class k {
        static void a(View r0, String... r1) {
            r0.setAutofillHints(r1);
        }

        static void a(View r2, CharSequence r3) {
            r2.setTooltipText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static int a(View r0) {
            return r0.getNextClusterForwardId();
        }

        static void a(View r0, int r1) {
            r0.setNextClusterForwardId(r1);
        }

        static boolean b(View r0) {
            return r0.isKeyboardNavigationCluster();
        }

        static void a(View r0, boolean r1) {
            r0.setKeyboardNavigationCluster(r1);
        }

        static boolean c(View r0) {
            return r0.isFocusedByDefault();
        }

        static void b(View r0, boolean r1) {
            r0.setFocusedByDefault(r1);
        }

        static View a(View r0, View r1, int r2) {
            return r0.keyboardNavigationClusterSearch(r1, r2);
        }

        static void a(View r2, Collection<View> r3, int r4) {
            r2.addKeyboardNavigationClusters((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), r4);
        }

        static boolean d(View r0) {
            return r0.restoreDefaultFocus();
        }

        static boolean e(View r0) {
            return r0.hasExplicitFocusable();
        }

        static int f(View r0) {
            return r0.getImportantForAutofill();
        }

        static void b(View r0, int r1) {
            r0.setImportantForAutofill(r1);
        }

        static boolean g(View r0) {
            return r0.isImportantForAutofill();
        }

        public static AutofillId h(View r0) {
            return r0.getAutofillId();
        }
    }

    static class l {
        static <T> T a(View r0, int r1) {
            return (T) r0.requireViewById(r1);
        }

        static CharSequence a(View r0) {
            return r0.getAccessibilityPaneTitle();
        }

        static void a(View r2, CharSequence r3) {
            r2.setAccessibilityPaneTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static void a(View r0, boolean r1) {
            r0.setAccessibilityHeading(r1);
        }

        static boolean b(View r0) {
            return r0.isAccessibilityHeading();
        }

        static boolean c(View r0) {
            return r0.isScreenReaderFocusable();
        }

        static void b(View r0, boolean r1) {
            r0.setScreenReaderFocusable(r1);
        }

        static void a(View r5, p r6) {
            final p r7 = (p) ZeusTransformUtils.wrapperContextForParams(r6, p.class, "com.obric.aiagent.plugin");
            androidx.b.g r0 = (androidx.b.g) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, DbHelper.COL_ID, "tag_unhandled_key_listeners")), androidx.b.g.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new androidx.b.g();
            r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, DbHelper.COL_ID, "tag_unhandled_key_listeners"), r0);
        L5:
            Objects.requireNonNull(r7);
            View.OnUnhandledKeyEventListener r1 = new $$Lambda$CVxWt0X8CeSmxdzfymit7O7z4(r7);
            r0.put(r7, r1);
            r5.addOnUnhandledKeyEventListener(r1);
        }

        static void b(View r4, p r5) {
            p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
            androidx.b.g r0 = (androidx.b.g) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, DbHelper.COL_ID, "tag_unhandled_key_listeners")), androidx.b.g.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r7 = (View.OnUnhandledKeyEventListener) ZeusTransformUtils.preCheckCast(r0.get(r6), View.OnUnhandledKeyEventListener.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L9;
            r4.removeOnUnhandledKeyEventListener(r7);
            return;
        }

        public static void a(View r0, AutofillId r1) {
            r0.setAutofillId(r1);
        }
    }

    private static class m {
        static void a(View r9, Context r10, int[] r11, AttributeSet r12, TypedArray r13, int r14, int r15) {
            r9.saveAttributeDataForStyleable((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), r11, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin"), r13, r14, r15);
        }

        static View.AccessibilityDelegate a(View r0) {
            return r0.getAccessibilityDelegate();
        }

        static void a(View r2, List<Rect> r3) {
            r2.setSystemGestureExclusionRects((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        static List<Rect> b(View r0) {
            return r0.getSystemGestureExclusionRects();
        }

        static ContentCaptureSession c(View r0) {
            return r0.getContentCaptureSession();
        }

        static void a(View r0, ContentCaptureSession r1) {
            r0.setContentCaptureSession(r1);
        }
    }

    private static class n {
        public static am a(View r0) {
            WindowInsetsController r1 = r0.getWindowInsetsController();
            if (r1 != null) goto L7;
            return null;
        L7:
            return am.a(r1);
        }

        static void a(View r2, CharSequence r3) {
            r2.setStateDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static CharSequence b(View r0) {
            return r0.getStateDescription();
        }

        static void a(View r0, int r1) {
            r0.setImportantForContentCapture(r1);
        }

        static boolean c(View r0) {
            return r0.isImportantForContentCapture();
        }

        static int d(View r0) {
            return r0.getImportantForContentCapture();
        }
    }

    private static final class o {
        public static void a(View r2, String[] r3, u r4) {
            u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
            r2.setOnReceiveContentListener(r3, null);
            return;
        L5:
            r2.setOnReceiveContentListener(r3, new OnReceiveContentListenerAdapter(r5));
        }

        public static String[] a(View r0) {
            return r0.getReceiveContentMimeTypes();
        }

        public static androidx.core.view.b a(View r1, androidx.core.view.b r2) {
            ContentInfo r0 = r2.a();
            ContentInfo r3 = r1.performReceiveContent(r0);
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3 != r0) goto L9;
            return r2;
        L9:
            return androidx.core.view.b.a(r3);
        }
    }

    public interface p {
        boolean a(View r1, KeyEvent r2);
    }

    static class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f1397a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f1399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WeakReference<KeyEvent> f1400d;

        q() {
            this.f1398b = null;
            this.f1399c = null;
            this.f1400d = null;
        }

        static {
            f1397a = new ArrayList();
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.f1399c != null) goto L6;
            this.f1399c = new SparseArray();
        L6:
            return this.f1399c;
        }

        static q a(View r5) {
            q r0 = (q) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_event_manager, DbHelper.COL_ID, "tag_unhandled_key_event_manager")), q.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L6;
            q r1 = new q();
            r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_event_manager, DbHelper.COL_ID, "tag_unhandled_key_event_manager"), r1);
            return r1;
        L6:
            return r0;
        }

        boolean a(View r2, KeyEvent r3) {
            if (r3.getAction() != 0) goto L5;
            b();
        L5:
            View r4 = b(r2, r3);
            if (r3.getAction() != 0) goto L12;
            int r5 = r3.getKeyCode();
            if (r4 == null) goto L12;
            if (KeyEvent.isModifierKey(r5) == true) goto L12;
            a().put(r5, new WeakReference(r4));
        L12:
            if (r4 == null) goto L14;
            return true;
        L14:
            return false;
        }

        private View b(View r5, KeyEvent r6) {
            WeakHashMap<View, Boolean> r0 = this.f1398b;
            if (r0 != null) goto L5;
        L18:
            return null;
        L5:
            if (r0.containsKey(r5) == false) goto L18;
            if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L16;
            ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
            int r2 = r1.getChildCount() - 1;
        L10:
            if (r2 < 0) goto L16;
            View r3 = b(r1.getChildAt(r2), r6);
            if (r3 != null) goto L13;
            r2 = r2 - 1;
            goto L10
        L13:
            return r3;
        L16:
            if (c(r5, r6) == false) goto L18;
            return r5;
        }

        boolean a(KeyEvent r8) {
            WeakReference<KeyEvent> r0 = this.f1400d;
            if (r0 != null) goto L5;
        L7:
            this.f1400d = new WeakReference(r8);
            WeakReference r1 = null;
            SparseArray<WeakReference<View>> r2 = a();
            if (r8.getAction() != 1) goto L12;
            int r3 = r2.indexOfKey(r8.getKeyCode());
            if (r3 < 0) goto L12;
            r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r2.valueAt(r3), WeakReference.class, "com.obric.aiagent.plugin");
            r2.removeAt(r3);
        L12:
            if (r1 != null) goto L14;
            r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r2.get(r8.getKeyCode()), WeakReference.class, "com.obric.aiagent.plugin");
        L14:
            if (r1 == null) goto L21;
            View r4 = (View) ZeusTransformUtils.preCheckCast(r1.get(), View.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L18;
        L20:
            return true;
        L18:
            if (ViewCompat.I(r4) == false) goto L20;
            c(r4, r8);
            goto L20
        L21:
            return false;
        L5:
            if (r0.get() != r8) goto L7;
            return false;
        }

        private boolean c(View r6, KeyEvent r7) {
            ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(r6.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, DbHelper.COL_ID, "tag_unhandled_key_listeners")), ArrayList.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
            int r0 = r5.size() - 1;
        L5:
            if (r0 < 0) goto L14;
            if (((p) ZeusTransformUtils.preCheckCast(r5.get(r0), p.class, "com.obric.aiagent.plugin")).a(r6, r7) == true) goto L8;
            r0 = r0 - 1;
            goto L5
        L8:
            return true;
        L14:
            return false;
        L10:
            return false;
        }

        private void b() {
            WeakHashMap<View, Boolean> r0 = this.f1398b;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            ArrayList<WeakReference<View>> r1 = f1397a;
            if (r1.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r1);
        L24:
            th = move-exception;
            throw th;
        L10:
            if (this.f1398b != null) goto L12;
            this.f1398b = new WeakHashMap();     // Catch: Throwable -> L24
        L12:
            int r2 = r1.size() - 1;     // Catch: Throwable -> L24
        L13:
            if (r2 < 0) goto L22;
            ArrayList<WeakReference<View>> r3 = f1397a;     // Catch: Throwable -> L24
            View r4 = (View) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.get(r2), WeakReference.class, "com.obric.aiagent.plugin")).get(), View.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            if (r4 != null) goto L17;
            r3.remove(r2);     // Catch: Throwable -> L24
        L21:
            r2 = r2 - 1;     // Catch: Throwable -> L24
            goto L13
        L17:
            this.f1398b.put(r4, Boolean.TRUE);     // Catch: Throwable -> L24
            ViewParent r5 = r4.getParent();     // Catch: Throwable -> L24
        L19:
            if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L21;
            this.f1398b.put((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), Boolean.TRUE);     // Catch: Throwable -> L24
            r5 = r5.getParent();     // Catch: Throwable -> L24
            goto L19
        L22:
            monitor-exit(r1);     // Catch: Throwable -> L24
        }
    }

    private static /* synthetic */ androidx.core.view.b a(androidx.core.view.b r0) {
        return r0;
    }

    public static /* synthetic */ androidx.core.view.b lambda$QhzcxWTRJabqsbSv8VDdbIobnLo(androidx.core.view.b r0) {
        return a(r0);
    }

    static {
        f1388a = new AtomicInteger(1);
        g = null;
        i = false;
        k = new int[]{ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_0, DbHelper.COL_ID, "accessibility_custom_action_0"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_1, DbHelper.COL_ID, "accessibility_custom_action_1"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_2, DbHelper.COL_ID, "accessibility_custom_action_2"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_3, DbHelper.COL_ID, "accessibility_custom_action_3"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_4, DbHelper.COL_ID, "accessibility_custom_action_4"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_5, DbHelper.COL_ID, "accessibility_custom_action_5"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_6, DbHelper.COL_ID, "accessibility_custom_action_6"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_7, DbHelper.COL_ID, "accessibility_custom_action_7"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_8, DbHelper.COL_ID, "accessibility_custom_action_8"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_9, DbHelper.COL_ID, "accessibility_custom_action_9"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_10, DbHelper.COL_ID, "accessibility_custom_action_10"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_11, DbHelper.COL_ID, "accessibility_custom_action_11"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_12, DbHelper.COL_ID, "accessibility_custom_action_12"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_13, DbHelper.COL_ID, "accessibility_custom_action_13"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_14, DbHelper.COL_ID, "accessibility_custom_action_14"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_15, DbHelper.COL_ID, "accessibility_custom_action_15"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_16, DbHelper.COL_ID, "accessibility_custom_action_16"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_17, DbHelper.COL_ID, "accessibility_custom_action_17"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_18, DbHelper.COL_ID, "accessibility_custom_action_18"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_19, DbHelper.COL_ID, "accessibility_custom_action_19"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_20, DbHelper.COL_ID, "accessibility_custom_action_20"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_21, DbHelper.COL_ID, "accessibility_custom_action_21"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_22, DbHelper.COL_ID, "accessibility_custom_action_22"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_23, DbHelper.COL_ID, "accessibility_custom_action_23"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_24, DbHelper.COL_ID, "accessibility_custom_action_24"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_25, DbHelper.COL_ID, "accessibility_custom_action_25"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_26, DbHelper.COL_ID, "accessibility_custom_action_26"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_27, DbHelper.COL_ID, "accessibility_custom_action_27"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_28, DbHelper.COL_ID, "accessibility_custom_action_28"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_29, DbHelper.COL_ID, "accessibility_custom_action_29"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_30, DbHelper.COL_ID, "accessibility_custom_action_30"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_31, DbHelper.COL_ID, "accessibility_custom_action_31")};
        l = $$Lambda$ViewCompat$QhzcxWTRJabqsbSv8VDdbIobnLo.INSTANCE;
        m = new AccessibilityPaneVisibilityManager();
    }

    private static Rect b() {
        if (j != null) goto L5;
        j = new ThreadLocal();
    L5:
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(j.get(), Rect.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        r0 = new Rect();
        j.set(r0);
    L8:
        r0.setEmpty();
        return r0;
    }

    public static void a(View r9, Context r10, int[] r11, AttributeSet r12, TypedArray r13, int r14, int r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L6;
        m.a(r9, r3, r11, r5, r13, r14, r15);
        return;
    }

    @Deprecated
    public static boolean a(View r0, int r1) {
        return r0.canScrollVertically(r1);
    }

    public static void a(View r0, androidx.core.view.accessibility.b r1) {
        r0.onInitializeAccessibilityNodeInfo(r1.a());
    }

    public static void a(View r2, AccessibilityDelegateCompat r3) {
        if (r3 == null) goto L4;
    L6:
        T(r2);
        if (r3 != null) goto L9;
        View.AccessibilityDelegate r4 = null;
    L10:
        r2.setAccessibilityDelegate(r4);
        return;
    L9:
        r4 = r3.a();
        goto L10
    L4:
        if (ZeusTransformUtils.instanceOf(O(r2), AccessibilityDelegateCompat.AccessibilityDelegateAdapter.class) == false) goto L6;
        r3 = new AccessibilityDelegateCompat();
        goto L6
    }

    public static int a(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return k.f(r2);
    }

    public static void b(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        k.b(r2, r3);
        return;
    }

    public static boolean b(View r0) {
        if (O(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static AccessibilityDelegateCompat c(View r2) {
        View.AccessibilityDelegate r3 = O(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, AccessibilityDelegateCompat.AccessibilityDelegateAdapter.class) == false) goto L11;
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) ZeusTransformUtils.preCheckCast(r3, AccessibilityDelegateCompat.AccessibilityDelegateAdapter.class, "com.obric.aiagent.plugin")).mCompat;
    L11:
        return new AccessibilityDelegateCompat(r3);
    }

    static void d(View r1) {
        AccessibilityDelegateCompat r0 = c(r1);
        if (r0 != null) goto L5;
        r0 = new AccessibilityDelegateCompat();
    L5:
        a(r1, r0);
    }

    private static View.AccessibilityDelegate O(View r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return m.a(r2);
    L7:
        return P(r2);
    }

    private static View.AccessibilityDelegate P(View r4) {
        if (i == false) goto L6;
        return null;
    L6:
        if (h == null) goto L20;
    L18:
        Object r5 = h.get(r4);     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r5, View.AccessibilityDelegate.class) == false) goto L15;
        return (View.AccessibilityDelegate) ZeusTransformUtils.preCheckCast(r5, View.AccessibilityDelegate.class, "com.obric.aiagent.plugin");
    L15:
        return null;
    L16:
        i = true;
        return null;
    L20:
        Field r0 = View.class.getDeclaredField("mAccessibilityDelegate");     // Catch: Throwable -> L9
        h = r0;     // Catch: Throwable -> L9
        r0.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        i = true;
        return null;
    }

    public static boolean e(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return c.a(r2);
    }

    public static void a(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        c.a(r2, r3);
        return;
    }

    public static void f(View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        c.b(r2);
        return;
    L5:
        r2.postInvalidate();
    }

    public static void a(View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        c.a(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.postInvalidate(r3, r4, r5, r6);
    }

    public static void a(View r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        c.a(r2, r4);
        return;
    L5:
        r2.postDelayed(r4, ValueAnimator.getFrameDelay());
    }

    public static void a(View r2, Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        c.a(r2, r5, r4);
        return;
    L5:
        r2.postDelayed(r5, ValueAnimator.getFrameDelay() + r4);
    }

    public static int g(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return c.c(r2);
    }

    public static void c(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        c.a(r2, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        return;
    L8:
        if (r3 != 4) goto L10;
        r3 = 2;
    L10:
        c.a(r2, r3);
    }

    public static boolean a(View r2, int r3, Bundle r4) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return c.a(r2, r3, r4);
    }

    public static int a(View r2, CharSequence r3, androidx.core.view.accessibility.d r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        androidx.core.view.accessibility.d r6 = (androidx.core.view.accessibility.d) ZeusTransformUtils.wrapperContextForParams(r4, androidx.core.view.accessibility.d.class, "com.obric.aiagent.plugin");
        int r0 = c(r2, r5);
        if (r0 == (-1)) goto L5;
        a(r2, new androidx.core.view.accessibility.b.a(r0, r5, r6));
    L5:
        return r0;
    }

    private static int c(View r10, CharSequence r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        List<androidx.core.view.accessibility.b.a> r13 = Q(r10);
        int r2 = 0;
    L4:
        if (r2 >= r13.size()) goto L10;
        if (TextUtils.equals(r12, ((androidx.core.view.accessibility.b.a) ZeusTransformUtils.preCheckCast(r13.get(r2), androidx.core.view.accessibility.b.a.class, "com.obric.aiagent.plugin")).b()) == true) goto L8;
        r2 = r2 + 1;
        goto L4
    L8:
        return ((androidx.core.view.accessibility.b.a) ZeusTransformUtils.preCheckCast(r13.get(r2), androidx.core.view.accessibility.b.a.class, "com.obric.aiagent.plugin")).a();
    L10:
        int r3 = -1;
        int r4 = 0;
    L11:
        int[] r5 = k;
        if (r4 >= r5.length) goto L25;
        if (r3 != (-1)) goto L25;
        int r6 = r5[r4];
        int r7 = 0;
        boolean r8 = true;
    L16:
        if (r7 >= r13.size()) goto L22;
        if (((androidx.core.view.accessibility.b.a) ZeusTransformUtils.preCheckCast(r13.get(r7), androidx.core.view.accessibility.b.a.class, "com.obric.aiagent.plugin")).a() == r6) goto L20;
        boolean r9 = true;
    L21:
        r8 = r8 & r9;
        r7 = r7 + 1;
        goto L16
    L20:
        r9 = false;
        goto L21
    L22:
        if (r8 == false) goto L24;
        r3 = r6;
    L24:
        r4 = r4 + 1;
    L25:
        return r3;
    }

    public static void a(View r2, androidx.core.view.accessibility.b.a r3, CharSequence r4, androidx.core.view.accessibility.d r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        androidx.core.view.accessibility.d r7 = (androidx.core.view.accessibility.d) ZeusTransformUtils.wrapperContextForParams(r5, androidx.core.view.accessibility.d.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        if (r6 != null) goto L6;
        d(r2, r3.a());
        return;
    L6:
        a(r2, r3.a(r6, r7));
    }

    private static void a(View r2, androidx.core.view.accessibility.b.a r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        d(r2);
        a(r3.a(), r2);
        Q(r2).add(r3);
        h(r2, 0);
        return;
    }

    public static void d(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        a(r3, r2);
        h(r2, 0);
        return;
    }

    private static void a(int r4, View r5) {
        List<androidx.core.view.accessibility.b.a> r6 = Q(r5);
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L12;
        if (((androidx.core.view.accessibility.b.a) ZeusTransformUtils.preCheckCast(r6.get(r0), androidx.core.view.accessibility.b.a.class, "com.obric.aiagent.plugin")).a() == r4) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        r6.remove(r0);
        return;
    }

    private static List<androidx.core.view.accessibility.b.a> Q(View r5) {
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_actions, DbHelper.COL_ID, "tag_accessibility_actions")), ArrayList.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_actions, DbHelper.COL_ID, "tag_accessibility_actions"), r1);
        return r1;
    L6:
        return r0;
    }

    public static void a(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L6;
        e().b(r2, r4);
        return;
    }

    public static CharSequence h(View r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(e().c(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public static void a(View r2, Paint r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        d.a(r2, r3);
        return;
    L5:
        r2.setLayerType(r2.getLayerType(), r3);
        r2.invalidate();
    }

    public static int i(View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return d.c(r2);
    }

    public static ViewParent j(View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return c.e(r2);
    L7:
        return r2.getParent();
    }

    public static int k(View r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return f.d(r2);
    }

    public static void e(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        f.a(r2, r3);
        return;
    }

    public static int l(View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return d.d(r2);
    L7:
        return r2.getPaddingLeft();
    }

    public static int m(View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return d.e(r2);
    L7:
        return r2.getPaddingRight();
    }

    public static void b(View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        d.a(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.setPadding(r3, r4, r5, r6);
    }

    public static int n(View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return c.f(r3);
    L7:
        if (f1390c == false) goto L19;
    L11:
        Field r0 = f1389b;
        if (r0 != null) goto L21;
        return 0;
    L21:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L23:
        return 0;
    L19:
        Field r1 = View.class.getDeclaredField("mMinWidth");     // Catch: NoSuchFieldException -> L17
        f1389b = r1;     // Catch: NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        f1390c = true;
        goto L11
    }

    public static int o(View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return c.g(r3);
    L7:
        if (f1392e == false) goto L19;
    L11:
        Field r0 = f1391d;
        if (r0 != null) goto L21;
        return 0;
    L21:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L23:
        return 0;
    L19:
        Field r1 = View.class.getDeclaredField("mMinHeight");     // Catch: NoSuchFieldException -> L17
        f1391d = r1;     // Catch: NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        f1392e = true;
        goto L11
    }

    public static ae p(View r3) {
        if (g != null) goto L5;
        g = new WeakHashMap();
    L5:
        ae r0 = (ae) ZeusTransformUtils.preCheckCast(g.get(r3), ae.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
        ae r1 = new ae(r3);
        g.put(r3, r1);
        return r1;
    L9:
        return r0;
    }

    public static void a(View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        h.b(r2, r3);
        return;
    }

    public static float q(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return h.e(r2);
    }

    public static void b(View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        h.c(r2, r3);
        return;
    }

    public static float r(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return h.c(r2);
    }

    public static void a(View r2, String r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        h.a(r2, r3);
        return;
    L6:
        if (f != null) goto L8;
        f = new WeakHashMap();
    L8:
        f.put(r2, r3);
    }

    public static String s(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        WeakHashMap<View, String> r0 = f;
        if (r0 != null) goto L11;
        return null;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r0.get(r2), String.class, "com.obric.aiagent.plugin");
    L5:
        return h.f(r2);
    }

    @Deprecated
    public static int t(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return c.h(r2);
    }

    public static void u(View r2) {
        if (Build.VERSION.SDK_INT < 20) goto L6;
        g.a(r2);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        c.i(r2);
        return;
    }

    public static boolean v(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return c.j(r2);
    }

    @Deprecated
    public static void b(View r0, boolean r1) {
        r0.setFitsSystemWindows(r1);
    }

    public static void a(View r2, t r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        h.a(r2, r4);
        return;
    }

    public static al a(View r2, al r3) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r0 = r3.m();
        if (r0 == null) goto L10;
        WindowInsets r1 = g.a(r2, r0);
        if (r1.equals(r0) == true) goto L10;
        return al.a(r1, r2);
    L10:
        return r3;
    }

    public static al b(View r2, al r3) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r0 = r3.m();
        if (r0 == null) goto L10;
        WindowInsets r1 = g.b(r2, r0);
        if (r1.equals(r0) == true) goto L10;
        return al.a(r1, r2);
    L10:
        return r3;
    }

    public static al w(View r2) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return i.a(r2);
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        return h.a(r2);
    }

    public static al a(View r2, al r3, Rect r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return r3;
    L5:
        return h.a(r2, r3, r4);
    }

    @Deprecated
    public static am x(View r4) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Object r0 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        Context r1 = (Context) r0;
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L11;
        r0 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L7
    L11:
        Window r2 = ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r2 != null) goto L14;
        return null;
    L14:
        return ai.a(r2, r4);
    L16:
        return null;
    L5:
        return n.a(r4);
    }

    public static void a(View r0, WindowInsetsAnimationCompat.b r1) {
        WindowInsetsAnimationCompat.a(r0, r1);
    }

    public static String[] y(View r3) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return o.a(r3);
    L7:
        return (String[]) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_on_receive_content_mime_types, DbHelper.COL_ID, "tag_on_receive_content_mime_types")), String[].class, "com.obric.aiagent.plugin");
    }

    public static androidx.core.view.b a(View r3, androidx.core.view.b r4) {
        if (a(TAG, 3) == false) goto L6;
        a(TAG, "performReceiveContent: " + r4 + ", view=" + r3.getClass().getSimpleName() + "[" + r3.getId() + "]");
    L6:
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        u r0 = (u) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_on_receive_content_listener, DbHelper.COL_ID, "tag_on_receive_content_listener")), u.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L17;
        androidx.core.view.b r5 = r0.a(r3, r4);
        if (r5 != null) goto L15;
        return null;
    L15:
        return R(r3).onReceiveContent(r5);
    L17:
        return R(r3).onReceiveContent(r4);
    L8:
        return o.a(r3, r4);
    }

    private static v R(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, v.class) == false) goto L7;
        return (v) ZeusTransformUtils.preCheckCast(r2, v.class, "com.obric.aiagent.plugin");
    L7:
        return l;
    }

    public static boolean z(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return true;
    L5:
        return c.k(r2);
    }

    public static boolean A(View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return d.f(r2);
    }

    public static void a(View r2, Drawable r3) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        c.a(r2, r3);
        return;
    L5:
        r2.setBackgroundDrawable(r3);
    }

    public static ColorStateList B(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return h.g(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, y.class) == true) goto L11;
        return null;
    L11:
        return ((y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.aiagent.plugin")).getSupportBackgroundTintList();
    }

    public static void a(View r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L20;
        h.a(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L23;
        Drawable r4 = r2.getBackground();
        if (h.g(r2) == null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r4 == null) goto L24;
        if (r0 == true) goto L16;
        return;
    L16:
        if (r4.isStateful() == false) goto L18;
        r4.setState(r2.getDrawableState());
    L18:
        c.a(r2, r4);
        return;
    L24:
        return;
    L9:
        if (h.h(r2) != null) goto L12;
        r0 = false;
        goto L13
    L23:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r2, y.class) == false) goto L27;
        ((y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.aiagent.plugin")).setSupportBackgroundTintList(r3);
        return;
    }

    public static PorterDuff.Mode C(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return h.h(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, y.class) == true) goto L11;
        return null;
    L11:
        return ((y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.aiagent.plugin")).getSupportBackgroundTintMode();
    }

    public static void a(View r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L20;
        h.a(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L23;
        Drawable r4 = r2.getBackground();
        if (h.g(r2) == null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r4 == null) goto L24;
        if (r0 == true) goto L16;
        return;
    L16:
        if (r4.isStateful() == false) goto L18;
        r4.setState(r2.getDrawableState());
    L18:
        c.a(r2, r4);
        return;
    L24:
        return;
    L9:
        if (h.h(r2) != null) goto L12;
        r0 = false;
        goto L13
    L23:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r2, y.class) == false) goto L27;
        ((y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.aiagent.plugin")).setSupportBackgroundTintMode(r3);
        return;
    }

    public static boolean D(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return h.i(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.view.l.class) == true) goto L9;
        return false;
    L9:
        return ((androidx.core.view.l) ZeusTransformUtils.preCheckCast(r2, androidx.core.view.l.class, "com.obric.aiagent.plugin")).isNestedScrollingEnabled();
    }

    public static void E(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        h.j(r2);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.view.l.class) == false) goto L10;
        ((androidx.core.view.l) ZeusTransformUtils.preCheckCast(r2, androidx.core.view.l.class, "com.obric.aiagent.plugin")).stopNestedScroll();
        return;
    }

    public static boolean F(View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return f.a(r2);
    L7:
        if (r2.getWidth() > 0) goto L9;
    L11:
        return false;
    L9:
        if (r2.getHeight() <= 0) goto L11;
        return true;
    }

    public static float G(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return h.b(r2);
    }

    public static void c(View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        h.a(r2, r3);
        return;
    }

    public static void f(View r7, int r8) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r7.offsetTopAndBottom(r8);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        Rect r0 = b();
        boolean r1 = false;
        ViewParent r2 = r7.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L10;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        r0.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
        r1 = !r0.intersects(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom());
    L10:
        i(r7, r8);
        if (r1 == true) goto L13;
        return;
    L13:
        if (r0.intersect(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom()) == false) goto L19;
        ((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).invalidate(r0);
        return;
    L19:
        return;
    L15:
        i(r7, r8);
    }

    private static void i(View r1, int r2) {
        r1.offsetTopAndBottom(r2);
        if (r1.getVisibility() != 0) goto L8;
        S(r1);
        ViewParent r3 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L9;
        S((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        return;
    }

    public static void g(View r7, int r8) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r7.offsetLeftAndRight(r8);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        Rect r0 = b();
        boolean r1 = false;
        ViewParent r2 = r7.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L10;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        r0.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
        r1 = !r0.intersects(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom());
    L10:
        j(r7, r8);
        if (r1 == true) goto L13;
        return;
    L13:
        if (r0.intersect(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom()) == false) goto L19;
        ((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).invalidate(r0);
        return;
    L19:
        return;
    L15:
        j(r7, r8);
    }

    private static void j(View r1, int r2) {
        r1.offsetLeftAndRight(r2);
        if (r1.getVisibility() != 0) goto L8;
        S(r1);
        ViewParent r3 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L9;
        S((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        return;
    }

    private static void S(View r2) {
        float r0 = r2.getTranslationY();
        r2.setTranslationY(1.0f + r0);
        r2.setTranslationY(r0);
    }

    public static void a(View r2, Rect r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        e.a(r2, r3);
        return;
    }

    public static Rect H(View r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return e.b(r2);
    }

    public static boolean I(View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return f.b(r2);
    L7:
        if (r2.getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean J(View r2) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return false;
    L5:
        return b.a(r2);
    }

    public static void a(View r2, int r3, int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        i.a(r2, r3, r4);
        return;
    }

    public static void a(View r2, w r3) {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r3 == null) goto L6;
        Object r4 = r3.a();
    L7:
        j.a(r2, (PointerIcon) ZeusTransformUtils.preCheckCast(r4, PointerIcon.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        r4 = null;
        goto L7
    }

    public static Display K(View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return d.a(r2);
    L7:
        if (I(r2) == true) goto L9;
        return null;
    L9:
        return ((WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
    }

    public static int a() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L6:
        AtomicInteger r0 = f1388a;
        int r1 = r0.get();
        int r2 = r1 + 1;
        if (r2 <= 16777215) goto L10;
        r2 = 1;
    L10:
        if (r0.compareAndSet(r1, r2) == false) goto L6;
        return r1;
    L5:
        return d.a();
    }

    static boolean a(View r2, KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return q.a(r2).a(r3);
    }

    static boolean b(View r2, KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return q.a(r2).a(r2, r3);
    }

    public static void c(View r1, boolean r2) {
        c().b(r1, Boolean.valueOf(r2));
    }

    public static boolean L(View r2) {
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(c().c(r2), Boolean.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.booleanValue() == false) goto L7;
        return true;
    }

    private static a<Boolean> c() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_screen_reader_focusable, DbHelper.COL_ID, "tag_screen_reader_focusable");
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass1(r1, r2, r3);
    }

    public static void b(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L9;
        d().b(r2, r4);
        if (r4 == null) goto L7;
        m.addAccessibilityPane(r2);
        return;
    L7:
        m.removeAccessibilityPane(r2);
        return;
    }

    public static CharSequence M(View r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(d().c(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static a<CharSequence> d() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_accessibility_pane_title, DbHelper.COL_ID, "tag_accessibility_pane_title");
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 8;
        final int r4 = 28;
        return new AnonymousClass2(r1, r2, r3, r4);
    }

    private static a<CharSequence> e() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_state_description, DbHelper.COL_ID, "tag_state_description");
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 64;
        final int r4 = 30;
        return new AnonymousClass3(r1, r2, r3, r4);
    }

    public static boolean N(View r2) {
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(f().c(r2), Boolean.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.booleanValue() == false) goto L7;
        return true;
    }

    public static void d(View r1, boolean r2) {
        f().b(r1, Boolean.valueOf(r2));
    }

    private static a<Boolean> f() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_accessibility_heading, DbHelper.COL_ID, "tag_accessibility_heading");
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass4(r1, r2, r3);
    }

    static void h(View r4, int r5) {
        AccessibilityManager r0 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.aiagent.plugin");
        if (r0.isEnabled() == true) goto L6;
        return;
    L6:
        if (M(r4) != null) goto L8;
    L12:
        boolean r1 = false;
    L13:
        int r3 = 32;
        if (k(r4) != 0) goto L26;
        if (r1 == true) goto L26;
        if (r5 != 32) goto L20;
        AccessibilityEvent r2 = AccessibilityEvent.obtain();
        r4.onInitializeAccessibilityEvent(r2);
        r2.setEventType(32);
        f.a(r2, r5);
        r2.setSource(r4);
        r4.onPopulateAccessibilityEvent(r2);
        r2.getText().add(M(r4));
        r0.sendAccessibilityEvent(r2);
        return;
    L20:
        if (r4.getParent() != null) goto L35;
        return;
    L35:
        f.a(r4.getParent(), r4, r4, r5);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        a(TAG, r4.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
        return;
    L26:
        AccessibilityEvent r6 = AccessibilityEvent.obtain();
        if (r1 == true) goto L30;
        r3 = 2048;
    L30:
        r6.setEventType(r3);
        f.a(r6, r5);
        if (r1 == false) goto L33;
        r6.getText().add(M(r4));
        T(r4);
    L33:
        r4.sendAccessibilityEventUnchecked(r6);
        return;
    L8:
        if (r4.isShown() == false) goto L12;
        if (r4.getWindowVisibility() != 0) goto L12;
        r1 = true;
        goto L13
    }

    private static void T(View r1) {
        if (g(r1) != 0) goto L6;
        c(r1, 1);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
