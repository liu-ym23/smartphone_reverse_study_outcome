package com.obric.oui.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import androidx.annotation.RestrictTo;
import com.obric.common.oui.R$id;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f17619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakHashMap f17620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f17621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f17622d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f17623e;

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
        boolean onUnhandledKeyEvent(View r10, KeyEvent r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap f17624a;

        public a() {
            this.f17624a = new WeakHashMap();
        }

        public final void a(View r10) {
            r10.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            a(r10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }
    }

    public static class b {

        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public WindowInsetsCompat f17625a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f17626b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ OnApplyWindowInsetsListener f17627c;

            public a(View r10, OnApplyWindowInsetsListener r11) {
                this.f17626b = r10;
                this.f17627c = r11;
                this.f17625a = null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
                WindowInsetsCompat r12 = WindowInsetsCompat.n(r11, r10);
                this.f17625a = r12;
                return this.f17627c.onApplyWindowInsets(r10, r12).l();
            }
        }

        public static void a(View r10, OnApplyWindowInsetsListener r11) {
            if (r11 != null) goto L5;
            r10.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r10.getTag(R$id.o_tag_window_insets_animation_callback));
            return;
        L5:
            r10.setOnApplyWindowInsetsListener(new a(r10, r11));
        }
    }

    public static class c {
        public static WindowInsetsCompat a(View r10) {
            WindowInsets r11 = r10.getRootWindowInsets();
            if (r11 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r12 = WindowInsetsCompat.m(r11);
            r12.k(r12);
            r12.d(r10.getRootView());
            return r12;
        }
    }

    static {
        f17619a = new AtomicInteger(1);
        f17620b = null;
        f17621c = false;
        f17622d = new int[]{R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};
        f17623e = new a();
    }

    public static WindowInsetsCompat a(View r10) {
        return c.a(r10);
    }

    public static void b(View r10, OnApplyWindowInsetsListener r11) {
        b.a(r10, r11);
    }
}
