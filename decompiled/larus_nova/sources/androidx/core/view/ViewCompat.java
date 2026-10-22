package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
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
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.ReplaceWith;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = null;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = null;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 28) goto L8;
            Iterator<Map.Entry<View, Boolean>> r100 = this.mPanesToVisible.entrySet().iterator();
        L6:
            if (r100.hasNext() == false) goto L10;
            checkPaneVisibility(r100.next());
            goto L6
        L10:
            return;
        }

        public AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        private void checkPaneVisibility(Map.Entry<View, Boolean> r100) {
            View r101 = r100.getKey();
            boolean r102 = r100.getValue().booleanValue();
            if (r101.isShown() == true) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r102 == r103) goto L14;
            if (r103 == false) goto L11;
            int r104 = 16;
        L12:
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r101, r104);
            r100.setValue(Boolean.valueOf(r103));
            return;
        L11:
            r104 = 32;
            goto L12
        L14:
            return;
        L5:
            if (r101.getWindowVisibility() != 0) goto L7;
            r103 = true;
            goto L8
        }

        private void registerForLayoutCallback(View r100) {
            r100.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View r100) {
            r100.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public void addAccessibilityPane(View r100) {
            WeakHashMap<View, Boolean> r101 = this.mPanesToVisible;
            if (r100.isShown() == true) goto L5;
        L7:
            boolean r102 = false;
        L8:
            r101.put(r100, Boolean.valueOf(r102));
            r100.addOnAttachStateChangeListener(this);
            if (r100.isAttachedToWindow() == false) goto L12;
            registerForLayoutCallback(r100);
            return;
        L12:
            return;
        L5:
            if (r100.getWindowVisibility() != 0) goto L7;
            r102 = true;
            goto L8
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
            registerForLayoutCallback(r100);
        }

        public void removeAccessibilityPane(View r100) {
            this.mPanesToVisible.remove(r100);
            r100.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r100);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        public abstract T frameworkGet(View r100);

        public abstract void frameworkSet(View r100, T r101);

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT < this.mFrameworkMinimumSdk) goto L5;
            return true;
        L5:
            return false;
        }

        public T get(View r100) {
            if (frameworkAvailable() == true) goto L5;
            T r101 = (T) r100.getTag(this.mTagKey);
            if (this.mType.isInstance(r101) == false) goto L9;
            return r101;
        L9:
            return null;
        L5:
            return frameworkGet(r100);
        }

        public boolean booleanNullToFalseEquals(Boolean r100, Boolean r101) {
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r101 != null) goto L10;
        L12:
            boolean r103 = false;
        L13:
            if (r102 == r103) goto L17;
            return false;
        L17:
            return true;
        L10:
            if (r101.booleanValue() == false) goto L12;
            r103 = true;
            goto L13
        L5:
            if (r100.booleanValue() == false) goto L7;
            r102 = true;
            goto L8
        }

        public void set(View r100, T r101) {
            if (frameworkAvailable() == false) goto L6;
            frameworkSet(r100, r101);
            return;
        L6:
            if (shouldUpdate(get(r100), r101) == false) goto L10;
            ViewCompat.ensureAccessibilityDelegateCompat(r100);
            r100.setTag(this.mTagKey, r101);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r100, this.mContentChangeType);
            return;
        }

        public boolean shouldUpdate(T r100, T r101) {
            return !r101.equals(r100);
        }

        public AccessibilityViewProperty(int r100, Class<T> r101, int r102) {
            this(r100, r101, 0, r102);
        }

        public AccessibilityViewProperty(int r100, Class<T> r101, int r102, int r103) {
            this.mTagKey = r100;
            this.mType = r101;
            this.mContentChangeType = r102;
            this.mFrameworkMinimumSdk = r103;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        public static void requestApplyInsets(View r100) {
            r100.requestApplyInsets();
        }

        public static WindowInsets dispatchApplyWindowInsets(View r100, WindowInsets r101) {
            return r100.dispatchApplyWindowInsets(r101);
        }

        public static WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
            return r100.onApplyWindowInsets(r101);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ColorStateList getBackgroundTintList(View r100) {
            return r100.getBackgroundTintList();
        }

        public static PorterDuff.Mode getBackgroundTintMode(View r100) {
            return r100.getBackgroundTintMode();
        }

        public static float getElevation(View r100) {
            return r100.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View r100) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(r100);
        }

        public static String getTransitionName(View r100) {
            return r100.getTransitionName();
        }

        public static float getTranslationZ(View r100) {
            return r100.getTranslationZ();
        }

        public static float getZ(View r100) {
            return r100.getZ();
        }

        public static boolean hasNestedScrollingParent(View r100) {
            return r100.hasNestedScrollingParent();
        }

        public static boolean isImportantForAccessibility(View r100) {
            return r100.isImportantForAccessibility();
        }

        public static boolean isNestedScrollingEnabled(View r100) {
            return r100.isNestedScrollingEnabled();
        }

        public static void stopNestedScroll(View r100) {
            r100.stopNestedScroll();
        }

        public static void callCompatInsetAnimationCallback(WindowInsets r100, View r101) {
            View.OnApplyWindowInsetsListener r102 = (View.OnApplyWindowInsetsListener) r101.getTag(R.id.tag_window_insets_animation_callback);
            if (r102 == null) goto L6;
            r102.onApplyWindowInsets(r101, r100);
            return;
        }

        public static void setBackgroundTintList(View r100, ColorStateList r101) {
            r100.setBackgroundTintList(r101);
        }

        public static void setBackgroundTintMode(View r100, PorterDuff.Mode r101) {
            r100.setBackgroundTintMode(r101);
        }

        public static void setElevation(View r100, float r101) {
            r100.setElevation(r101);
        }

        public static void setNestedScrollingEnabled(View r100, boolean r101) {
            r100.setNestedScrollingEnabled(r101);
        }

        public static void setOnApplyWindowInsetsListener(final View r100, final OnApplyWindowInsetsListener r101) {
            if (Build.VERSION.SDK_INT >= 30) goto L5;
            r100.setTag(R.id.tag_on_apply_window_listener, r101);
        L5:
            if (r101 != null) goto L8;
            r100.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r100.getTag(R.id.tag_window_insets_animation_callback));
            return;
        L8:
            r100.setOnApplyWindowInsetsListener(new AnonymousClass1(r100, r101));
        }

        public static void setTransitionName(View r100, String r101) {
            r100.setTransitionName(r101);
        }

        public static void setTranslationZ(View r100, float r101) {
            r100.setTranslationZ(r101);
        }

        public static void setZ(View r100, float r101) {
            r100.setZ(r101);
        }

        public static boolean startNestedScroll(View r100, int r101) {
            return r100.startNestedScroll(r101);
        }

        public static WindowInsetsCompat computeSystemWindowInsets(View r100, WindowInsetsCompat r101, Rect r102) {
            WindowInsets r103 = r101.toWindowInsets();
            if (r103 != null) goto L5;
            r102.setEmpty();
            return r101;
        L5:
            return WindowInsetsCompat.toWindowInsetsCompat(r100.computeSystemWindowInsets(r103, r102), r100);
        }

        public static boolean dispatchNestedPreFling(View r100, float r101, float r102) {
            return r100.dispatchNestedPreFling(r101, r102);
        }

        public static boolean dispatchNestedFling(View r100, float r101, float r102, boolean r103) {
            return r100.dispatchNestedFling(r101, r102, r103);
        }

        public static boolean dispatchNestedPreScroll(View r100, int r101, int r102, int[] r103, int[] r104) {
            return r100.dispatchNestedPreScroll(r101, r102, r103, r104);
        }

        public static boolean dispatchNestedScroll(View r100, int r101, int r102, int r103, int r104, int[] r105) {
            return r100.dispatchNestedScroll(r101, r102, r103, r104, r105);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat getRootWindowInsets(View r100) {
            WindowInsets r101 = r100.getRootWindowInsets();
            if (r101 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r102 = WindowInsetsCompat.toWindowInsetsCompat(r101);
            r102.setRootWindowInsets(r102);
            r102.copyRootViewBounds(r100.getRootView());
            return r102;
        }

        public static int getScrollIndicators(View r100) {
            return r100.getScrollIndicators();
        }

        public static void setScrollIndicators(View r100, int r101) {
            r100.setScrollIndicators(r101);
        }

        public static void setScrollIndicators(View r100, int r101, int r102) {
            r100.setScrollIndicators(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void cancelDragAndDrop(View r100) {
            r100.cancelDragAndDrop();
        }

        public static void dispatchFinishTemporaryDetach(View r100) {
            r100.dispatchFinishTemporaryDetach();
        }

        public static void dispatchStartTemporaryDetach(View r100) {
            r100.dispatchStartTemporaryDetach();
        }

        public static void setPointerIcon(View r100, PointerIcon r101) {
            r100.setPointerIcon(r101);
        }

        public static void updateDragShadow(View r100, View.DragShadowBuilder r101) {
            r100.updateDragShadow(r101);
        }

        public static boolean startDragAndDrop(View r100, ClipData r101, View.DragShadowBuilder r102, Object r103, int r104) {
            return r100.startDragAndDrop(r101, r102, r103, r104);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static AutofillId getAutofillId(View r100) {
            return r100.getAutofillId();
        }

        public static int getImportantForAutofill(View r100) {
            return r100.getImportantForAutofill();
        }

        public static int getNextClusterForwardId(View r100) {
            return r100.getNextClusterForwardId();
        }

        public static boolean hasExplicitFocusable(View r100) {
            return r100.hasExplicitFocusable();
        }

        public static boolean isFocusedByDefault(View r100) {
            return r100.isFocusedByDefault();
        }

        public static boolean isImportantForAutofill(View r100) {
            return r100.isImportantForAutofill();
        }

        public static boolean isKeyboardNavigationCluster(View r100) {
            return r100.isKeyboardNavigationCluster();
        }

        public static boolean restoreDefaultFocus(View r100) {
            return r100.restoreDefaultFocus();
        }

        public static void setAutofillHints(View r100, String... r101) {
            r100.setAutofillHints(r101);
        }

        public static void setFocusedByDefault(View r100, boolean r101) {
            r100.setFocusedByDefault(r101);
        }

        public static void setImportantForAutofill(View r100, int r101) {
            r100.setImportantForAutofill(r101);
        }

        public static void setKeyboardNavigationCluster(View r100, boolean r101) {
            r100.setKeyboardNavigationCluster(r101);
        }

        public static void setNextClusterForwardId(View r100, int r101) {
            r100.setNextClusterForwardId(r101);
        }

        public static void setTooltipText(View r100, CharSequence r101) {
            r100.setTooltipText(r101);
        }

        public static void addKeyboardNavigationClusters(View r100, Collection<View> r101, int r102) {
            r100.addKeyboardNavigationClusters(r101, r102);
        }

        public static View keyboardNavigationClusterSearch(View r100, View r101, int r102) {
            return r100.keyboardNavigationClusterSearch(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CharSequence getAccessibilityPaneTitle(View r100) {
            return r100.getAccessibilityPaneTitle();
        }

        public static boolean isAccessibilityHeading(View r100) {
            return r100.isAccessibilityHeading();
        }

        public static boolean isScreenReaderFocusable(View r100) {
            return r100.isScreenReaderFocusable();
        }

        public static void addOnUnhandledKeyEventListener(View r100, final OnUnhandledKeyEventListenerCompat r101) {
            SimpleArrayMap r102 = (SimpleArrayMap) r100.getTag(R.id.tag_unhandled_key_listeners);
            if (r102 != null) goto L5;
            r102 = new SimpleArrayMap();
            r100.setTag(R.id.tag_unhandled_key_listeners, r102);
        L5:
            Objects.requireNonNull(r101);
            View.OnUnhandledKeyEventListener r103 = new k(r101);
            r102.put(r101, r103);
            r100.addOnUnhandledKeyEventListener(r103);
        }

        public static void removeOnUnhandledKeyEventListener(View r100, OnUnhandledKeyEventListenerCompat r101) {
            SimpleArrayMap r102 = (SimpleArrayMap) r100.getTag(R.id.tag_unhandled_key_listeners);
            if (r102 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r103 = (View.OnUnhandledKeyEventListener) r102.get(r101);
            if (r103 == null) goto L9;
            r100.removeOnUnhandledKeyEventListener(r103);
            return;
        }

        public static <T> T requireViewById(View r100, int r101) {
            return (T) r100.requireViewById(r101);
        }

        public static void setAccessibilityHeading(View r100, boolean r101) {
            r100.setAccessibilityHeading(r101);
        }

        public static void setAccessibilityPaneTitle(View r100, CharSequence r101) {
            r100.setAccessibilityPaneTitle(r101);
        }

        public static void setAutofillId(View r100, AutofillIdCompat r101) {
            if (r101 != null) goto L4;
            AutofillId r102 = null;
        L5:
            r100.setAutofillId(r102);
            return;
        L4:
            r102 = r101.toAutofillId();
            goto L5
        }

        public static void setScreenReaderFocusable(View r100, boolean r101) {
            r100.setScreenReaderFocusable(r101);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static View.AccessibilityDelegate getAccessibilityDelegate(View r100) {
            return r100.getAccessibilityDelegate();
        }

        public static ContentCaptureSession getContentCaptureSession(View r100) {
            return r100.getContentCaptureSession();
        }

        public static List<Rect> getSystemGestureExclusionRects(View r100) {
            return r100.getSystemGestureExclusionRects();
        }

        public static void setContentCaptureSession(View r100, ContentCaptureSessionCompat r101) {
            if (r101 != null) goto L4;
            ContentCaptureSession r102 = null;
        L5:
            r100.setContentCaptureSession(r102);
            return;
        L4:
            r102 = r101.toContentCaptureSession();
            goto L5
        }

        public static void setSystemGestureExclusionRects(View r100, List<Rect> r101) {
            r100.setSystemGestureExclusionRects(r101);
        }

        public static void saveAttributeDataForStyleable(View r100, Context r101, int[] r102, AttributeSet r103, TypedArray r104, int r105, int r106) {
            r100.saveAttributeDataForStyleable(r101, r102, r103, r104, r105, r106);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static int getImportantForContentCapture(View r100) {
            return r100.getImportantForContentCapture();
        }

        public static CharSequence getStateDescription(View r100) {
            return r100.getStateDescription();
        }

        public static WindowInsetsControllerCompat getWindowInsetsController(View r100) {
            WindowInsetsController r101 = r100.getWindowInsetsController();
            if (r101 != null) goto L7;
            return null;
        L7:
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(r101);
        }

        public static boolean isImportantForContentCapture(View r100) {
            return r100.isImportantForContentCapture();
        }

        public static void setImportantForContentCapture(View r100, int r101) {
            r100.setImportantForContentCapture(r101);
        }

        public static void setStateDescription(View r100, CharSequence r101) {
            r100.setStateDescription(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] getReceiveContentMimeTypes(View r100) {
            return r100.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View r100, ContentInfoCompat r101) {
            ContentInfo r102 = r101.toContentInfo();
            ContentInfo r103 = r100.performReceiveContent(r102);
            if (r103 != null) goto L6;
            return null;
        L6:
            if (r103 != r102) goto L9;
            return r101;
        L9:
            return ContentInfoCompat.toContentInfoCompat(r103);
        }

        public static void setOnReceiveContentListener(View r100, String[] r101, OnReceiveContentListener r102) {
            if (r102 != null) goto L4;
            r100.setOnReceiveContentListener(r101, null);
            return;
        L4:
            r100.setOnReceiveContentListener(r101, new OnReceiveContentListenerAdapter(r102));
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener mJetpackListener;

        public OnReceiveContentListenerAdapter(OnReceiveContentListener r100) {
            this.mJetpackListener = r100;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View r100, ContentInfo r101) {
            ContentInfoCompat r102 = ContentInfoCompat.toContentInfoCompat(r101);
            ContentInfoCompat r103 = this.mJetpackListener.onReceiveContent(r100, r102);
            if (r103 != null) goto L6;
            return null;
        L6:
            if (r103 != r102) goto L9;
            return r101;
        L9:
            return r103.toContentInfo();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View r100, KeyEvent r101);
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;
        private WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            sViewsWithListeners = new ArrayList();
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys != null) goto L6;
            this.mCapturedKeys = new SparseArray();
        L6:
            return this.mCapturedKeys;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> r100 = this.mViewsContainingListeners;
            if (r100 == null) goto L5;
            r100.clear();
        L5:
            ArrayList<WeakReference<View>> r101 = sViewsWithListeners;
            if (r101.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r101);
        L24:
            th = move-exception;
            throw th;
        L10:
            if (this.mViewsContainingListeners != null) goto L12;
            this.mViewsContainingListeners = new WeakHashMap();     // Catch: Throwable -> L24
        L12:
            int r102 = r101.size() - 1;     // Catch: Throwable -> L24
        L13:
            if (r102 < 0) goto L22;
            ArrayList<WeakReference<View>> r103 = sViewsWithListeners;     // Catch: Throwable -> L24
            View r104 = r103.get(r102).get();     // Catch: Throwable -> L24
            if (r104 != null) goto L17;
            r103.remove(r102);     // Catch: Throwable -> L24
        L21:
            r102 = r102 - 1;     // Catch: Throwable -> L24
            goto L13
        L17:
            this.mViewsContainingListeners.put(r104, Boolean.TRUE);     // Catch: Throwable -> L24
            ViewParent r105 = r104.getParent();     // Catch: Throwable -> L24
        L19:
            if ((r105 instanceof View) == false) goto L21;
            this.mViewsContainingListeners.put((View) r105, Boolean.TRUE);     // Catch: Throwable -> L24
            r105 = r105.getParent();     // Catch: Throwable -> L24
            goto L19
        L22:
            monitor-exit(r101);     // Catch: Throwable -> L24
        }

        public UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        public static UnhandledKeyEventManager at(View r100) {
            UnhandledKeyEventManager r101 = (UnhandledKeyEventManager) r100.getTag(R.id.tag_unhandled_key_event_manager);
            if (r101 != null) goto L6;
            UnhandledKeyEventManager r102 = new UnhandledKeyEventManager();
            r100.setTag(R.id.tag_unhandled_key_event_manager, r102);
            return r102;
        L6:
            return r101;
        }

        public static void registerListeningView(View r100) {
            ArrayList<WeakReference<View>> r101 = sViewsWithListeners;
            monitor-enter(r101);
            Iterator<WeakReference<View>> r102 = r101.iterator();     // Catch: Throwable -> L14
        L6:
            if (r102.hasNext() == false) goto L11;
            if (r102.next().get() != r100) goto L6;
            monitor-exit(r101);     // Catch: Throwable -> L14
            return;
        L11:
            sViewsWithListeners.add(new WeakReference(r100));     // Catch: Throwable -> L14
            monitor-exit(r101);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public static void unregisterListeningView(View r100) {
            ArrayList<WeakReference<View>> r101 = sViewsWithListeners;
            monitor-enter(r101);
            int r102 = 0;
        L18:
            ArrayList<WeakReference<View>> r103 = sViewsWithListeners;     // Catch: Throwable -> L15
            if (r102 >= r103.size()) goto L13;
            if (r103.get(r102).get() == r100) goto L9;
            r102 = r102 + 1;     // Catch: Throwable -> L15
            goto L18
        L9:
            r103.remove(r102);     // Catch: Throwable -> L15
            monitor-exit(r101);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r101);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public boolean preDispatch(KeyEvent r100) {
            WeakReference<KeyEvent> r101 = this.mLastDispatchedPreViewKeyEvent;
            if (r101 != null) goto L5;
        L7:
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(r100);
            SparseArray<WeakReference<View>> r102 = getCapturedKeys();
            if (r100.getAction() != 1) goto L12;
            int r103 = r102.indexOfKey(r100.getKeyCode());
            if (r103 < 0) goto L12;
            WeakReference<View> r104 = r102.valueAt(r103);
            r102.removeAt(r103);
        L13:
            if (r104 != null) goto L15;
            r104 = r102.get(r100.getKeyCode());
        L15:
            if (r104 == null) goto L22;
            View r105 = r104.get();
            if (r105 != null) goto L19;
        L21:
            return true;
        L19:
            if (r105.isAttachedToWindow() == false) goto L21;
            onUnhandledKeyEvent(r105, r100);
            goto L21
        L22:
            return false;
        L12:
            r104 = null;
            goto L13
        L5:
            if (r101.get() != r100) goto L7;
            return false;
        }

        private View dispatchInOrder(View r100, KeyEvent r101) {
            WeakHashMap<View, Boolean> r102 = this.mViewsContainingListeners;
            if (r102 != null) goto L5;
        L18:
            return null;
        L5:
            if (r102.containsKey(r100) == false) goto L18;
            if ((r100 instanceof ViewGroup) == false) goto L16;
            ViewGroup r103 = (ViewGroup) r100;
            int r104 = r103.getChildCount() - 1;
        L10:
            if (r104 < 0) goto L16;
            View r105 = dispatchInOrder(r103.getChildAt(r104), r101);
            if (r105 != null) goto L13;
            r104 = r104 - 1;
            goto L10
        L13:
            return r105;
        L16:
            if (onUnhandledKeyEvent(r100, r101) == false) goto L18;
            return r100;
        }

        private boolean onUnhandledKeyEvent(View r100, KeyEvent r101) {
            ArrayList r102 = (ArrayList) r100.getTag(R.id.tag_unhandled_key_listeners);
            if (r102 == null) goto L10;
            int r103 = r102.size() - 1;
        L5:
            if (r103 < 0) goto L14;
            if (((OnUnhandledKeyEventListenerCompat) ListProtector.get(r102, r103)).onUnhandledKeyEvent(r100, r101) == true) goto L8;
            r103 = r103 - 1;
            goto L5
        L8:
            return true;
        L14:
            return false;
        L10:
            return false;
        }

        public boolean dispatch(View r100, KeyEvent r101) {
            if (r101.getAction() != 0) goto L5;
            recalcViewsWithUnhandled();
        L5:
            View r102 = dispatchInOrder(r100, r101);
            if (r101.getAction() != 0) goto L12;
            int r103 = r101.getKeyCode();
            if (r102 == null) goto L12;
            if (KeyEvent.isModifierKey(r103) == true) goto L12;
            getCapturedKeys().put(r103, new WeakReference(r102));
        L12:
            if (r102 == null) goto L14;
            return true;
        L14:
            return false;
        }
    }

    public static /* synthetic */ ContentInfoCompat a(ContentInfoCompat r100) {
        return lambda$static$0(r100);
    }

    private static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat r100) {
        return r100;
    }

    static {
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new j();
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        final Class<Boolean> r100 = Boolean.class;
        final int r101 = 28;
        final int r102 = R.id.tag_accessibility_heading;
        return new AnonymousClass4(r102, r100, r101);
    }

    private static void bindTempDetach() {
        sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);     // Catch: NoSuchMethodException -> L5
        sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);     // Catch: NoSuchMethodException -> L5
    L3:
        sTempDetachBound = true;
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect != null) goto L5;
        sThreadLocalRect = new ThreadLocal();
    L5:
        Rect r100 = sThreadLocalRect.get();
        if (r100 != null) goto L8;
        r100 = new Rect();
        sThreadLocalRect.set(r100);
    L8:
        r100.setEmpty();
        return r100;
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        final Class<CharSequence> r100 = CharSequence.class;
        final int r101 = 8;
        final int r102 = 28;
        final int r103 = R.id.tag_accessibility_pane_title;
        return new AnonymousClass2(r103, r100, r101, r102);
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        final Class<Boolean> r100 = Boolean.class;
        final int r101 = 28;
        final int r102 = R.id.tag_screen_reader_focusable;
        return new AnonymousClass1(r102, r100, r101);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        final Class<CharSequence> r100 = CharSequence.class;
        final int r101 = 64;
        final int r102 = 30;
        final int r103 = R.id.tag_state_description;
        return new AnonymousClass3(r103, r100, r101, r102);
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public ViewCompat() {
    }

    public static ViewPropertyAnimatorCompat animate(View r100) {
        if (sViewPropertyAnimatorMap != null) goto L5;
        sViewPropertyAnimatorMap = new WeakHashMap();
    L5:
        ViewPropertyAnimatorCompat r101 = sViewPropertyAnimatorMap.get(r100);
        if (r101 != null) goto L9;
        ViewPropertyAnimatorCompat r102 = new ViewPropertyAnimatorCompat(r100);
        sViewPropertyAnimatorMap.put(r100, r102);
        return r102;
    L9:
        return r101;
    }

    public static void cancelDragAndDrop(View r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.cancelDragAndDrop(r100);
        return;
    }

    public static void dispatchFinishTemporaryDetach(View r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchFinishTemporaryDetach(r100);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r101 = sDispatchFinishTemporaryDetach;
        if (r101 != null) goto L16;
        r100.onFinishTemporaryDetach();
        return;
    L16:
        r101.invoke(r100, new Object[0]);     // Catch: Exception -> L15
        return;
    }

    public static void dispatchStartTemporaryDetach(View r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchStartTemporaryDetach(r100);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r101 = sDispatchStartTemporaryDetach;
        if (r101 != null) goto L16;
        r100.onStartTemporaryDetach();
        return;
    L16:
        r101.invoke(r100, new Object[0]);     // Catch: Exception -> L15
        return;
    }

    public static void enableAccessibleClickableSpanSupport(View r100) {
        ensureAccessibilityDelegateCompat(r100);
    }

    public static void ensureAccessibilityDelegateCompat(View r100) {
        AccessibilityDelegateCompat r101 = getAccessibilityDelegate(r100);
        if (r101 != null) goto L5;
        r101 = new AccessibilityDelegateCompat();
    L5:
        setAccessibilityDelegate(r100, r101);
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View r100) {
        View.AccessibilityDelegate r101 = getAccessibilityDelegateInternal(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((r101 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L11;
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) r101).mCompat;
    L11:
        return new AccessibilityDelegateCompat(r101);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View r100) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getAccessibilityDelegate(r100);
    L7:
        return getAccessibilityDelegateThroughReflection(r100);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View r100) {
        if (sAccessibilityDelegateCheckFailed == false) goto L6;
        return null;
    L6:
        if (sAccessibilityDelegateField != null) goto L20;
        Field r101 = View.class.getDeclaredField("mAccessibilityDelegate");     // Catch: Throwable -> L9
        sAccessibilityDelegateField = r101;     // Catch: Throwable -> L9
        r101.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    L20:
        Object r102 = sAccessibilityDelegateField.get(r100);     // Catch: Throwable -> L16
        if ((r102 instanceof View.AccessibilityDelegate) == false) goto L15;
        return (View.AccessibilityDelegate) r102;
    L15:
        return null;
    L16:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    }

    @ReplaceWith(expression = "view.getAccessibilityLiveRegion()")
    public static int getAccessibilityLiveRegion(View r100) {
        return r100.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r100) {
        AccessibilityNodeProvider r101 = r100.getAccessibilityNodeProvider();
        if (r101 != null) goto L5;
        return null;
    L5:
        return new AccessibilityNodeProviderCompat(r101);
    }

    public static CharSequence getAccessibilityPaneTitle(View r100) {
        return paneTitleProperty().get(r100);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r100) {
        ArrayList r101 = (ArrayList) r100.getTag(R.id.tag_accessibility_actions);
        if (r101 != null) goto L6;
        ArrayList r102 = new ArrayList();
        r100.setTag(R.id.tag_accessibility_actions, r102);
        return r102;
    L6:
        return r101;
    }

    @ReplaceWith(expression = "view.getAlpha()")
    public static float getAlpha(View r100) {
        return r100.getAlpha();
    }

    public static AutofillIdCompat getAutofillId(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(r100));
    }

    public static ColorStateList getBackgroundTintList(View r100) {
        return Api21Impl.getBackgroundTintList(r100);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View r100) {
        return Api21Impl.getBackgroundTintMode(r100);
    }

    @ReplaceWith(expression = "view.getClipBounds()")
    public static Rect getClipBounds(View r100) {
        return r100.getClipBounds();
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View r100) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        ContentCaptureSession r101 = Api29Impl.getContentCaptureSession(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(r101, r100);
    L9:
        return null;
    }

    @ReplaceWith(expression = "view.getDisplay()")
    public static Display getDisplay(View r100) {
        return r100.getDisplay();
    }

    public static float getElevation(View r100) {
        return Api21Impl.getElevation(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior getFallback(View r100) {
        if ((r100 instanceof OnReceiveContentViewBehavior) == false) goto L7;
        return (OnReceiveContentViewBehavior) r100;
    L7:
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @ReplaceWith(expression = "view.getFitsSystemWindows()")
    public static boolean getFitsSystemWindows(View r100) {
        return r100.getFitsSystemWindows();
    }

    @ReplaceWith(expression = "view.getImportantForAccessibility()")
    public static int getImportantForAccessibility(View r100) {
        return r100.getImportantForAccessibility();
    }

    public static int getImportantForAutofill(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getImportantForAutofill(r100);
    }

    public static int getImportantForContentCapture(View r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return 0;
    L5:
        return Api30Impl.getImportantForContentCapture(r100);
    }

    @ReplaceWith(expression = "view.getLabelFor()")
    public static int getLabelFor(View r100) {
        return r100.getLabelFor();
    }

    @ReplaceWith(expression = "view.getLayerType()")
    public static int getLayerType(View r100) {
        return r100.getLayerType();
    }

    @ReplaceWith(expression = "view.getLayoutDirection()")
    public static int getLayoutDirection(View r100) {
        return r100.getLayoutDirection();
    }

    @ReplaceWith(expression = "view.getMatrix()")
    public static Matrix getMatrix(View r100) {
        return r100.getMatrix();
    }

    @ReplaceWith(expression = "view.getMeasuredHeightAndState()")
    public static int getMeasuredHeightAndState(View r100) {
        return r100.getMeasuredHeightAndState();
    }

    @ReplaceWith(expression = "view.getMeasuredState()")
    public static int getMeasuredState(View r100) {
        return r100.getMeasuredState();
    }

    @ReplaceWith(expression = "view.getMeasuredWidthAndState()")
    public static int getMeasuredWidthAndState(View r100) {
        return r100.getMeasuredWidthAndState();
    }

    @ReplaceWith(expression = "view.getMinimumHeight()")
    public static int getMinimumHeight(View r100) {
        return r100.getMinimumHeight();
    }

    @ReplaceWith(expression = "view.getMinimumWidth()")
    public static int getMinimumWidth(View r100) {
        return r100.getMinimumWidth();
    }

    public static int getNextClusterForwardId(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return -1;
    L5:
        return Api26Impl.getNextClusterForwardId(r100);
    }

    public static String[] getOnReceiveContentMimeTypes(View r100) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.getReceiveContentMimeTypes(r100);
    L7:
        return (String[]) r100.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @ReplaceWith(expression = "view.getOverScrollMode()")
    public static int getOverScrollMode(View r100) {
        return r100.getOverScrollMode();
    }

    @ReplaceWith(expression = "view.getPaddingEnd()")
    public static int getPaddingEnd(View r100) {
        return r100.getPaddingEnd();
    }

    @ReplaceWith(expression = "view.getPaddingStart()")
    public static int getPaddingStart(View r100) {
        return r100.getPaddingStart();
    }

    @ReplaceWith(expression = "view.getParentForAccessibility()")
    public static ViewParent getParentForAccessibility(View r100) {
        return r100.getParentForAccessibility();
    }

    @ReplaceWith(expression = "view.getPivotX()")
    public static float getPivotX(View r100) {
        return r100.getPivotX();
    }

    @ReplaceWith(expression = "view.getPivotY()")
    public static float getPivotY(View r100) {
        return r100.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getRootWindowInsets(r100);
    L7:
        return Api21Impl.getRootWindowInsets(r100);
    }

    @ReplaceWith(expression = "view.getRotation()")
    public static float getRotation(View r100) {
        return r100.getRotation();
    }

    @ReplaceWith(expression = "view.getRotationX()")
    public static float getRotationX(View r100) {
        return r100.getRotationX();
    }

    @ReplaceWith(expression = "view.getRotationY()")
    public static float getRotationY(View r100) {
        return r100.getRotationY();
    }

    @ReplaceWith(expression = "view.getScaleX()")
    public static float getScaleX(View r100) {
        return r100.getScaleX();
    }

    @ReplaceWith(expression = "view.getScaleY()")
    public static float getScaleY(View r100) {
        return r100.getScaleY();
    }

    public static int getScrollIndicators(View r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 0;
    L5:
        return Api23Impl.getScrollIndicators(r100);
    }

    public static CharSequence getStateDescription(View r100) {
        return stateDescriptionProperty().get(r100);
    }

    public static List<Rect> getSystemGestureExclusionRects(View r100) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getSystemGestureExclusionRects(r100);
    L7:
        return Collections.emptyList();
    }

    public static String getTransitionName(View r100) {
        return Api21Impl.getTransitionName(r100);
    }

    @ReplaceWith(expression = "view.getTranslationX()")
    public static float getTranslationX(View r100) {
        return r100.getTranslationX();
    }

    @ReplaceWith(expression = "view.getTranslationY()")
    public static float getTranslationY(View r100) {
        return r100.getTranslationY();
    }

    public static float getTranslationZ(View r100) {
        return Api21Impl.getTranslationZ(r100);
    }

    public static WindowInsetsControllerCompat getWindowInsetsController(View r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Context r101 = r100.getContext();
    L8:
        if ((r101 instanceof ContextWrapper) == false) goto L16;
        if ((r101 instanceof Activity) == true) goto L11;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L8
    L11:
        Window r102 = ((Activity) r101).getWindow();
        if (r102 != null) goto L14;
        return null;
    L14:
        return WindowCompat.getInsetsController(r102, r100);
    L16:
        return null;
    L5:
        return Api30Impl.getWindowInsetsController(r100);
    }

    @ReplaceWith(expression = "view.getWindowSystemUiVisibility()")
    public static int getWindowSystemUiVisibility(View r100) {
        return r100.getWindowSystemUiVisibility();
    }

    @ReplaceWith(expression = "view.getX()")
    public static float getX(View r100) {
        return r100.getX();
    }

    @ReplaceWith(expression = "view.getY()")
    public static float getY(View r100) {
        return r100.getY();
    }

    public static float getZ(View r100) {
        return Api21Impl.getZ(r100);
    }

    public static boolean hasAccessibilityDelegate(View r100) {
        if (getAccessibilityDelegateInternal(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasExplicitFocusable(View r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasExplicitFocusable(r100);
    L7:
        return r100.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(View r100) {
        return Api21Impl.hasNestedScrollingParent(r100);
    }

    @ReplaceWith(expression = "view.hasOnClickListeners()")
    public static boolean hasOnClickListeners(View r100) {
        return r100.hasOnClickListeners();
    }

    @ReplaceWith(expression = "view.hasOverlappingRendering()")
    public static boolean hasOverlappingRendering(View r100) {
        return r100.hasOverlappingRendering();
    }

    @ReplaceWith(expression = "view.hasTransientState()")
    public static boolean hasTransientState(View r100) {
        return r100.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View r100) {
        Boolean r101 = accessibilityHeadingProperty().get(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.booleanValue() == false) goto L7;
        return true;
    }

    @ReplaceWith(expression = "view.isAttachedToWindow()")
    public static boolean isAttachedToWindow(View r100) {
        return r100.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isFocusedByDefault(r100);
    }

    public static boolean isImportantForAccessibility(View r100) {
        return Api21Impl.isImportantForAccessibility(r100);
    }

    public static boolean isImportantForAutofill(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return true;
    L5:
        return Api26Impl.isImportantForAutofill(r100);
    }

    public static boolean isImportantForContentCapture(View r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return false;
    L5:
        return Api30Impl.isImportantForContentCapture(r100);
    }

    @ReplaceWith(expression = "view.isInLayout()")
    public static boolean isInLayout(View r100) {
        return r100.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isKeyboardNavigationCluster(r100);
    }

    @ReplaceWith(expression = "view.isLaidOut()")
    public static boolean isLaidOut(View r100) {
        return r100.isLaidOut();
    }

    @ReplaceWith(expression = "view.isLayoutDirectionResolved()")
    public static boolean isLayoutDirectionResolved(View r100) {
        return r100.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(View r100) {
        return Api21Impl.isNestedScrollingEnabled(r100);
    }

    @ReplaceWith(expression = "view.isOpaque()")
    public static boolean isOpaque(View r100) {
        return r100.isOpaque();
    }

    @ReplaceWith(expression = "view.isPaddingRelative()")
    public static boolean isPaddingRelative(View r100) {
        return r100.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View r100) {
        Boolean r101 = screenReaderFocusableProperty().get(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.booleanValue() == false) goto L7;
        return true;
    }

    @ReplaceWith(expression = "view.jumpDrawablesToCurrentState()")
    public static void jumpDrawablesToCurrentState(View r100) {
        r100.jumpDrawablesToCurrentState();
    }

    @ReplaceWith(expression = "view.postInvalidateOnAnimation()")
    public static void postInvalidateOnAnimation(View r100) {
        r100.postInvalidateOnAnimation();
    }

    public static void requestApplyInsets(View r100) {
        Api20Impl.requestApplyInsets(r100);
    }

    public static boolean restoreDefaultFocus(View r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.restoreDefaultFocus(r100);
    L7:
        return r100.requestFocus();
    }

    private static void setImportantForAccessibilityIfNeeded(View r100) {
        if (r100.getImportantForAccessibility() != 0) goto L6;
        r100.setImportantForAccessibility(1);
        return;
    }

    public static void stopNestedScroll(View r100) {
        Api21Impl.stopNestedScroll(r100);
    }

    private static void tickleInvalidationFlag(View r100) {
        float r101 = r100.getTranslationY();
        r100.setTranslationY(1.0f + r101);
        r100.setTranslationY(r101);
    }

    private static void addAccessibilityAction(View r100, AccessibilityNodeInfoCompat.AccessibilityActionCompat r101) {
        ensureAccessibilityDelegateCompat(r100);
        removeActionWithId(r101.getId(), r100);
        getActionList(r100).add(r101);
        notifyViewAccessibilityStateChangedIfNeeded(r100, 0);
    }

    public static void addOnUnhandledKeyEventListener(View r100, OnUnhandledKeyEventListenerCompat r101) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.addOnUnhandledKeyEventListener(r100, r101);
        return;
    L6:
        ArrayList r102 = (ArrayList) r100.getTag(R.id.tag_unhandled_key_listeners);
        if (r102 != null) goto L9;
        r102 = new ArrayList();
        r100.setTag(R.id.tag_unhandled_key_listeners, r102);
    L9:
        r102.add(r101);
        if (r102.size() != 1) goto L13;
        UnhandledKeyEventManager.registerListeningView(r100);
        return;
    }

    @ReplaceWith(expression = "view.canScrollHorizontally(direction)")
    public static boolean canScrollHorizontally(View r100, int r101) {
        return r100.canScrollHorizontally(r101);
    }

    @ReplaceWith(expression = "view.canScrollVertically(direction)")
    public static boolean canScrollVertically(View r100, int r101) {
        return r100.canScrollVertically(r101);
    }

    public static int combineMeasuredStates(int r100, int r101) {
        return View.combineMeasuredStates(r100, r101);
    }

    private static void compatOffsetLeftAndRight(View r100, int r101) {
        r100.offsetLeftAndRight(r101);
        if (r100.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r100);
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r102);
        return;
    L9:
        return;
    }

    private static void compatOffsetTopAndBottom(View r100, int r101) {
        r100.offsetTopAndBottom(r101);
        if (r100.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r100);
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r102);
        return;
    L9:
        return;
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        WindowInsets r102 = r101.toWindowInsets();
        if (r102 == null) goto L8;
        WindowInsets r103 = Api20Impl.dispatchApplyWindowInsets(r100, r102);
        if (r103.equals(r102) == true) goto L8;
        return WindowInsetsCompat.toWindowInsetsCompat(r103, r100);
    L8:
        return r101;
    }

    public static boolean dispatchUnhandledKeyEventBeforeCallback(View r100, KeyEvent r101) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r100).dispatch(r100, r101);
    }

    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View r100, KeyEvent r101) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r100).preDispatch(r101);
    }

    private static int getAvailableActionIdFromResources(View r100, CharSequence r101) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r102 = getActionList(r100);
        int r103 = 0;
    L4:
        if (r103 >= r102.size()) goto L10;
        if (TextUtils.equals(r101, ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ListProtector.get(r102, r103)).getLabel()) == true) goto L8;
        r103 = r103 + 1;
        goto L4
    L8:
        return ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ListProtector.get(r102, r103)).getId();
    L10:
        int r104 = 0;
        int r105 = -1;
    L11:
        int[] r106 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
        if (r104 >= r106.length) goto L25;
        if (r105 != (-1)) goto L25;
        int r107 = r106[r104];
        int r108 = 0;
        boolean r109 = true;
    L16:
        if (r108 >= r102.size()) goto L22;
        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ListProtector.get(r102, r108)).getId() == r107) goto L20;
        boolean r110 = true;
    L21:
        r109 = r109 & r110;
        r108 = r108 + 1;
        goto L16
    L20:
        r110 = false;
        goto L21
    L22:
        if (r109 == false) goto L24;
        r105 = r107;
    L24:
        r104 = r104 + 1;
    L25:
        return r105;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(View r100, int r101) {
        if ((r100 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r100).hasNestedScrollingParent(r101);
        return false;
    L5:
        if (r101 == 0) goto L7;
        return false;
    L7:
        return hasNestedScrollingParent(r100);
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(View r100, int r101) {
        AccessibilityManager r102 = (AccessibilityManager) r100.getContext().getSystemService("accessibility");
        if (r102.isEnabled() == true) goto L6;
        return;
    L6:
        if (getAccessibilityPaneTitle(r100) != null) goto L8;
    L12:
        boolean r103 = false;
    L13:
        int r104 = 32;
        if (r100.getAccessibilityLiveRegion() != 0) goto L25;
        if (r103 == true) goto L25;
        if (r101 != 32) goto L20;
        AccessibilityEvent r105 = AccessibilityEvent.obtain();
        r100.onInitializeAccessibilityEvent(r105);
        r105.setEventType(32);
        r105.setContentChangeTypes(r101);
        r105.setSource(r100);
        r100.onPopulateAccessibilityEvent(r105);
        r105.getText().add(getAccessibilityPaneTitle(r100));
        r102.sendAccessibilityEvent(r105);
        return;
    L20:
        if (r100.getParent() != null) goto L34;
        return;
    L34:
        r100.getParent().notifySubtreeAccessibilityStateChanged(r100, r100, r101);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        r100.getParent().getClass();
        return;
    L25:
        AccessibilityEvent r106 = AccessibilityEvent.obtain();
        if (r103 == true) goto L29;
        r104 = 2048;
    L29:
        r106.setEventType(r104);
        r106.setContentChangeTypes(r101);
        if (r103 == false) goto L32;
        r106.getText().add(getAccessibilityPaneTitle(r100));
        setImportantForAccessibilityIfNeeded(r100);
    L32:
        r100.sendAccessibilityEventUnchecked(r106);
        return;
    L8:
        if (r100.isShown() == false) goto L12;
        if (r100.getWindowVisibility() != 0) goto L12;
        r103 = true;
        goto L13
    }

    public static void offsetLeftAndRight(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.offsetLeftAndRight(r101);
        return;
    L5:
        Rect r102 = getEmptyTempRect();
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == false) goto L8;
        View r104 = (View) r103;
        r102.set(r104.getLeft(), r104.getTop(), r104.getRight(), r104.getBottom());
        boolean r105 = !r102.intersects(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    L9:
        compatOffsetLeftAndRight(r100, r101);
        if (r105 == true) goto L12;
        return;
    L12:
        if (r102.intersect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom()) == false) goto L17;
        ((View) r103).invalidate(r102);
        return;
    L17:
        return;
    L8:
        r105 = false;
        goto L9
    }

    public static void offsetTopAndBottom(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.offsetTopAndBottom(r101);
        return;
    L5:
        Rect r102 = getEmptyTempRect();
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == false) goto L8;
        View r104 = (View) r103;
        r102.set(r104.getLeft(), r104.getTop(), r104.getRight(), r104.getBottom());
        boolean r105 = !r102.intersects(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    L9:
        compatOffsetTopAndBottom(r100, r101);
        if (r105 == true) goto L12;
        return;
    L12:
        if (r102.intersect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom()) == false) goto L17;
        ((View) r103).invalidate(r102);
        return;
    L17:
        return;
    L8:
        r105 = false;
        goto L9
    }

    public static WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        WindowInsets r102 = r101.toWindowInsets();
        if (r102 == null) goto L8;
        WindowInsets r103 = Api20Impl.onApplyWindowInsets(r100, r102);
        if (r103.equals(r102) == true) goto L8;
        return WindowInsetsCompat.toWindowInsetsCompat(r103, r100);
    L8:
        return r101;
    }

    @ReplaceWith(expression = "v.onInitializeAccessibilityEvent(event)")
    public static void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        r100.onInitializeAccessibilityEvent(r101);
    }

    @ReplaceWith(expression = "v.onInitializeAccessibilityNodeInfo(info.unwrap())")
    public static void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        r100.onInitializeAccessibilityNodeInfo(r101.unwrap());
    }

    @ReplaceWith(expression = "v.onPopulateAccessibilityEvent(event)")
    public static void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
        r100.onPopulateAccessibilityEvent(r101);
    }

    public static boolean performHapticFeedback(View r100, int r101) {
        int r102 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(r101);
        if (r102 != (-1)) goto L7;
        return false;
    L7:
        return r100.performHapticFeedback(r102);
    }

    public static ContentInfoCompat performReceiveContent(View r100, ContentInfoCompat r101) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Objects.toString(r101);
        r100.getClass();
        r100.getId();
    L6:
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        OnReceiveContentListener r102 = (OnReceiveContentListener) r100.getTag(R.id.tag_on_receive_content_listener);
        if (r102 == null) goto L17;
        ContentInfoCompat r103 = r102.onReceiveContent(r100, r101);
        if (r103 != null) goto L15;
        return null;
    L15:
        return getFallback(r100).onReceiveContent(r103);
    L17:
        return getFallback(r100).onReceiveContent(r101);
    L8:
        return Api31Impl.performReceiveContent(r100, r101);
    }

    @ReplaceWith(expression = "view.postOnAnimation(action)")
    public static void postOnAnimation(View r100, Runnable r101) {
        r100.postOnAnimation(r101);
    }

    public static void removeAccessibilityAction(View r100, int r101) {
        removeActionWithId(r101, r100);
        notifyViewAccessibilityStateChangedIfNeeded(r100, 0);
    }

    private static void removeActionWithId(int r100, View r101) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r102 = getActionList(r101);
        int r103 = 0;
    L4:
        if (r103 >= r102.size()) goto L12;
        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ListProtector.get(r102, r103)).getId() == r100) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        ListProtector.remove(r102, r103);
        return;
    }

    public static void removeOnUnhandledKeyEventListener(View r100, OnUnhandledKeyEventListenerCompat r101) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.removeOnUnhandledKeyEventListener(r100, r101);
        return;
    L6:
        ArrayList r102 = (ArrayList) r100.getTag(R.id.tag_unhandled_key_listeners);
        if (r102 == null) goto L12;
        r102.remove(r101);
        if (r102.size() != 0) goto L13;
        UnhandledKeyEventManager.unregisterListeningView(r100);
        return;
    L13:
        return;
    }

    public static <T extends View> T requireViewById(View r100, int r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r102 = (T) r100.findViewById(r101);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    L5:
        return (T) Api28Impl.requireViewById(r100, r101);
    }

    public static void setAccessibilityDelegate(View r100, AccessibilityDelegateCompat r101) {
        if (r101 == null) goto L4;
    L6:
        setImportantForAccessibilityIfNeeded(r100);
        if (r101 != null) goto L9;
        View.AccessibilityDelegate r102 = null;
    L10:
        r100.setAccessibilityDelegate(r102);
        return;
    L9:
        r102 = r101.getBridge();
        goto L10
    L4:
        if ((getAccessibilityDelegateInternal(r100) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L6;
        r101 = new AccessibilityDelegateCompat();
        goto L6
    }

    public static void setAccessibilityHeading(View r100, boolean r101) {
        accessibilityHeadingProperty().set(r100, Boolean.valueOf(r101));
    }

    @ReplaceWith(expression = "view.setAccessibilityLiveRegion(mode)")
    public static void setAccessibilityLiveRegion(View r100, int r101) {
        r100.setAccessibilityLiveRegion(r101);
    }

    public static void setAccessibilityPaneTitle(View r100, CharSequence r101) {
        paneTitleProperty().set(r100, r101);
        if (r101 == null) goto L5;
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(r100);
        return;
    L5:
        sAccessibilityPaneVisibilityManager.removeAccessibilityPane(r100);
    }

    @ReplaceWith(expression = "view.setActivated(activated)")
    public static void setActivated(View r100, boolean r101) {
        r100.setActivated(r101);
    }

    @ReplaceWith(expression = "view.setAlpha(value)")
    public static void setAlpha(View r100, float r101) {
        r100.setAlpha(r101);
    }

    public static void setAutofillHints(View r100, String... r101) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setAutofillHints(r100, r101);
        return;
    }

    public static void setAutofillId(View r100, AutofillIdCompat r101) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setAutofillId(r100, r101);
        return;
    }

    @ReplaceWith(expression = "view.setBackground(background)")
    public static void setBackground(View r100, Drawable r101) {
        r100.setBackground(r101);
    }

    public static void setBackgroundTintList(View r100, ColorStateList r101) {
        int r102 = Build.VERSION.SDK_INT;
        Api21Impl.setBackgroundTintList(r100, r101);
        if (r102 != 21) goto L18;
        Drawable r103 = r100.getBackground();
        if (Api21Impl.getBackgroundTintList(r100) == null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r103 == null) goto L19;
        if (r104 == true) goto L14;
        return;
    L14:
        if (r103.isStateful() == false) goto L16;
        r103.setState(r100.getDrawableState());
    L16:
        r100.setBackground(r103);
        return;
    L19:
        return;
    L7:
        if (Api21Impl.getBackgroundTintMode(r100) != null) goto L10;
        r104 = false;
        goto L11
    }

    public static void setBackgroundTintMode(View r100, PorterDuff.Mode r101) {
        int r102 = Build.VERSION.SDK_INT;
        Api21Impl.setBackgroundTintMode(r100, r101);
        if (r102 != 21) goto L18;
        Drawable r103 = r100.getBackground();
        if (Api21Impl.getBackgroundTintList(r100) == null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r103 == null) goto L19;
        if (r104 == true) goto L14;
        return;
    L14:
        if (r103.isStateful() == false) goto L16;
        r103.setState(r100.getDrawableState());
    L16:
        r100.setBackground(r103);
        return;
    L19:
        return;
    L7:
        if (Api21Impl.getBackgroundTintMode(r100) != null) goto L10;
        r104 = false;
        goto L11
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup r100, boolean r101) {
        if (sChildrenDrawingOrderMethod == null) goto L12;
    L10:
        sChildrenDrawingOrderMethod.invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L12:
        sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
    L5:
        sChildrenDrawingOrderMethod.setAccessible(true);
        goto L10
    }

    @ReplaceWith(expression = "view.setClipBounds(clipBounds)")
    public static void setClipBounds(View r100, Rect r101) {
        r100.setClipBounds(r101);
    }

    public static void setContentCaptureSession(View r100, ContentCaptureSessionCompat r101) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setContentCaptureSession(r100, r101);
        return;
    }

    public static void setElevation(View r100, float r101) {
        Api21Impl.setElevation(r100, r101);
    }

    @ReplaceWith(expression = "view.setFitsSystemWindows(fitSystemWindows)")
    public static void setFitsSystemWindows(View r100, boolean r101) {
        r100.setFitsSystemWindows(r101);
    }

    public static void setFocusedByDefault(View r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setFocusedByDefault(r100, r101);
        return;
    }

    @ReplaceWith(expression = "view.setHasTransientState(hasTransientState)")
    public static void setHasTransientState(View r100, boolean r101) {
        r100.setHasTransientState(r101);
    }

    @ReplaceWith(expression = "view.setImportantForAccessibility(mode)")
    public static void setImportantForAccessibility(View r100, int r101) {
        r100.setImportantForAccessibility(r101);
    }

    public static void setImportantForAutofill(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setImportantForAutofill(r100, r101);
        return;
    }

    public static void setImportantForContentCapture(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setImportantForContentCapture(r100, r101);
        return;
    }

    public static void setKeyboardNavigationCluster(View r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setKeyboardNavigationCluster(r100, r101);
        return;
    }

    @ReplaceWith(expression = "view.setLabelFor(labeledId)")
    public static void setLabelFor(View r100, int r101) {
        r100.setLabelFor(r101);
    }

    @ReplaceWith(expression = "view.setLayerPaint(paint)")
    public static void setLayerPaint(View r100, Paint r101) {
        r100.setLayerPaint(r101);
    }

    @ReplaceWith(expression = "view.setLayoutDirection(layoutDirection)")
    public static void setLayoutDirection(View r100, int r101) {
        r100.setLayoutDirection(r101);
    }

    public static void setNestedScrollingEnabled(View r100, boolean r101) {
        Api21Impl.setNestedScrollingEnabled(r100, r101);
    }

    public static void setNextClusterForwardId(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setNextClusterForwardId(r100, r101);
        return;
    }

    public static void setOnApplyWindowInsetsListener(View r100, OnApplyWindowInsetsListener r101) {
        Api21Impl.setOnApplyWindowInsetsListener(r100, r101);
    }

    @ReplaceWith(expression = "view.setOverScrollMode(overScrollMode)")
    public static void setOverScrollMode(View r100, int r101) {
        r100.setOverScrollMode(r101);
    }

    @ReplaceWith(expression = "view.setPivotX(value)")
    public static void setPivotX(View r100, float r101) {
        r100.setPivotX(r101);
    }

    @ReplaceWith(expression = "view.setPivotY(value)")
    public static void setPivotY(View r100, float r101) {
        r100.setPivotY(r101);
    }

    public static void setPointerIcon(View r100, PointerIconCompat r101) {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r101 == null) goto L6;
        Object r102 = r101.getPointerIcon();
    L7:
        Api24Impl.setPointerIcon(r100, (PointerIcon) r102);
        return;
    L6:
        r102 = null;
        goto L7
    }

    @ReplaceWith(expression = "view.setRotation(value)")
    public static void setRotation(View r100, float r101) {
        r100.setRotation(r101);
    }

    @ReplaceWith(expression = "view.setRotationX(value)")
    public static void setRotationX(View r100, float r101) {
        r100.setRotationX(r101);
    }

    @ReplaceWith(expression = "view.setRotationY(value)")
    public static void setRotationY(View r100, float r101) {
        r100.setRotationY(r101);
    }

    @ReplaceWith(expression = "view.setSaveFromParentEnabled(enabled)")
    public static void setSaveFromParentEnabled(View r100, boolean r101) {
        r100.setSaveFromParentEnabled(r101);
    }

    @ReplaceWith(expression = "view.setScaleX(value)")
    public static void setScaleX(View r100, float r101) {
        r100.setScaleX(r101);
    }

    @ReplaceWith(expression = "view.setScaleY(value)")
    public static void setScaleY(View r100, float r101) {
        r100.setScaleY(r101);
    }

    public static void setScreenReaderFocusable(View r100, boolean r101) {
        screenReaderFocusableProperty().set(r100, Boolean.valueOf(r101));
    }

    public static void setScrollIndicators(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r100, r101);
        return;
    }

    public static void setStateDescription(View r100, CharSequence r101) {
        stateDescriptionProperty().set(r100, r101);
    }

    public static void setSystemGestureExclusionRects(View r100, List<Rect> r101) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setSystemGestureExclusionRects(r100, r101);
        return;
    }

    public static void setTooltipText(View r100, CharSequence r101) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setTooltipText(r100, r101);
        return;
    }

    public static void setTransitionName(View r100, String r101) {
        Api21Impl.setTransitionName(r100, r101);
    }

    @ReplaceWith(expression = "view.setTranslationX(value)")
    public static void setTranslationX(View r100, float r101) {
        r100.setTranslationX(r101);
    }

    @ReplaceWith(expression = "view.setTranslationY(value)")
    public static void setTranslationY(View r100, float r101) {
        r100.setTranslationY(r101);
    }

    public static void setTranslationZ(View r100, float r101) {
        Api21Impl.setTranslationZ(r100, r101);
    }

    public static void setWindowInsetsAnimationCallback(View r100, WindowInsetsAnimationCompat.Callback r101) {
        WindowInsetsAnimationCompat.setCallback(r100, r101);
    }

    @ReplaceWith(expression = "view.setX(value)")
    public static void setX(View r100, float r101) {
        r100.setX(r101);
    }

    @ReplaceWith(expression = "view.setY(value)")
    public static void setY(View r100, float r101) {
        r100.setY(r101);
    }

    public static void setZ(View r100, float r101) {
        Api21Impl.setZ(r100, r101);
    }

    public static boolean startNestedScroll(View r100, int r101) {
        return Api21Impl.startNestedScroll(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(View r100, int r101) {
        if ((r100 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r100).stopNestedScroll(r101);
        return;
    L5:
        if (r101 != 0) goto L9;
        stopNestedScroll(r100);
        return;
    }

    public static void updateDragShadow(View r100, View.DragShadowBuilder r101) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.updateDragShadow(r100, r101);
        return;
    }

    public static int addAccessibilityAction(View r100, CharSequence r101, AccessibilityViewCommand r102) {
        int r103 = getAvailableActionIdFromResources(r100, r101);
        if (r103 == (-1)) goto L5;
        addAccessibilityAction(r100, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r103, r101, r102));
    L5:
        return r103;
    }

    public static void addKeyboardNavigationClusters(View r100, Collection<View> r101, int r102) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.addKeyboardNavigationClusters(r100, r101, r102);
        return;
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View r100, WindowInsetsCompat r101, Rect r102) {
        return Api21Impl.computeSystemWindowInsets(r100, r101, r102);
    }

    public static boolean dispatchNestedPreFling(View r100, float r101, float r102) {
        return Api21Impl.dispatchNestedPreFling(r100, r101, r102);
    }

    public static View keyboardNavigationClusterSearch(View r100, View r101, int r102) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.keyboardNavigationClusterSearch(r100, r101, r102);
    }

    @ReplaceWith(expression = "view.performAccessibilityAction(action, arguments)")
    public static boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
        return r100.performAccessibilityAction(r101, r102);
    }

    public static boolean performHapticFeedback(View r100, int r101, int r102) {
        int r103 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(r101);
        if (r103 != (-1)) goto L7;
        return false;
    L7:
        return r100.performHapticFeedback(r103, r102);
    }

    @ReplaceWith(expression = "view.postOnAnimationDelayed(action, delayMillis)")
    public static void postOnAnimationDelayed(View r100, Runnable r101, long r102) {
        r100.postOnAnimationDelayed(r101, r102);
    }

    public static int resolveSizeAndState(int r100, int r101, int r102) {
        return View.resolveSizeAndState(r100, r101, r102);
    }

    @ReplaceWith(expression = "view.setLayerType(layerType, paint)")
    public static void setLayerType(View r100, int r101, Paint r102) {
        r100.setLayerType(r101, r102);
    }

    public static void setOnReceiveContentListener(View r100, String[] r101, OnReceiveContentListener r102) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        Api31Impl.setOnReceiveContentListener(r100, r101, r102);
        return;
    L6:
        if (r101 != null) goto L8;
    L9:
        r101 = null;
    L10:
        boolean r103 = false;
        if (r102 == null) goto L16;
        if (r101 == null) goto L14;
        boolean r104 = true;
    L15:
        Preconditions.checkArgument(r104, "When the listener is set, MIME types must also be set");
        goto L16
    L14:
        r104 = false;
    L16:
        if (r101 == null) goto L24;
        int r105 = r101.length;
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L23;
        if (r101[r106].startsWith("*") == true) goto L21;
        r106 = r106 + 1;
        goto L18
    L21:
        r103 = true;
    L23:
        Preconditions.checkArgument(!r103, "A MIME type set here must not start with *: " + Arrays.toString(r101));
    L24:
        r100.setTag(R.id.tag_on_receive_content_mime_types, r101);
        r100.setTag(R.id.tag_on_receive_content_listener, r102);
        return;
    L8:
        if (r101.length != 0) goto L10;
        goto L9
    }

    public static void setScrollIndicators(View r100, int r101, int r102) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r100, r101, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(View r100, int r101, int r102) {
        if ((r100 instanceof NestedScrollingChild2) == true) goto L5;
        if (r102 == 0) goto L8;
        return false;
    L8:
        return startNestedScroll(r100, r101);
    L5:
        return ((NestedScrollingChild2) r100).startNestedScroll(r101, r102);
    }

    public static boolean dispatchNestedFling(View r100, float r101, float r102, boolean r103) {
        return Api21Impl.dispatchNestedFling(r100, r101, r102, r103);
    }

    public static void replaceAccessibilityAction(View r100, AccessibilityNodeInfoCompat.AccessibilityActionCompat r101, CharSequence r102, AccessibilityViewCommand r103) {
        if (r103 != null) goto L5;
        if (r102 != null) goto L5;
        removeAccessibilityAction(r100, r101.getId());
        return;
    L5:
        addAccessibilityAction(r100, r101.createReplacementAction(r102, r103));
    }

    public static boolean dispatchNestedPreScroll(View r100, int r101, int r102, int[] r103, int[] r104) {
        return Api21Impl.dispatchNestedPreScroll(r100, r101, r102, r103, r104);
    }

    @ReplaceWith(expression = "view.postInvalidateOnAnimation(left, top, right, bottom)")
    public static void postInvalidateOnAnimation(View r100, int r101, int r102, int r103, int r104) {
        r100.postInvalidateOnAnimation(r101, r102, r103, r104);
    }

    @ReplaceWith(expression = "view.setPaddingRelative(start, top, end, bottom)")
    public static void setPaddingRelative(View r100, int r101, int r102, int r103, int r104) {
        r100.setPaddingRelative(r101, r102, r103, r104);
    }

    public static boolean startDragAndDrop(View r100, ClipData r101, View.DragShadowBuilder r102, Object r103, int r104) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.startDragAndDrop(r100, r101, r102, r103, r104);
    L7:
        return r100.startDrag(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(View r100, int r101, int r102, int[] r110, int[] r111, int r112) {
        if ((r100 instanceof NestedScrollingChild2) == true) goto L5;
        if (r112 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    L5:
        return ((NestedScrollingChild2) r100).dispatchNestedPreScroll(r101, r102, r110, r111, r112);
    }

    public static boolean dispatchNestedScroll(View r100, int r101, int r102, int r103, int r104, int[] r105) {
        return Api21Impl.dispatchNestedScroll(r100, r101, r102, r103, r104, r105);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(View r100, int r101, int r110, int r111, int r112, int[] r113, int r114) {
        if ((r100 instanceof NestedScrollingChild2) == true) goto L5;
        if (r114 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    L5:
        return ((NestedScrollingChild2) r100).dispatchNestedScroll(r101, r110, r111, r112, r113, r114);
    }

    public static void saveAttributeDataForStyleable(View r100, Context r101, int[] r102, AttributeSet r103, TypedArray r104, int r105, int r106) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.saveAttributeDataForStyleable(r100, r101, r102, r103, r104, r105, r106);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(View r110, int r111, int r112, int r113, int r114, int[] r115, int r116, int[] r117) {
        if ((r110 instanceof NestedScrollingChild3) == false) goto L5;
        ((NestedScrollingChild3) r110).dispatchNestedScroll(r111, r112, r113, r114, r115, r116, r117);
        return;
    L5:
        dispatchNestedScroll(r110, r111, r112, r113, r114, r115, r116);
    }
}
