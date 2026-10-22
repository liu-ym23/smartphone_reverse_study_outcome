package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface a {
        al a(View r1, al r2, b r3);
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13491d;

        public b(int r1, int r2, int r3, int r4) {
            this.f13488a = r1;
            this.f13489b = r2;
            this.f13490c = r3;
            this.f13491d = r4;
        }

        public b(b r2) {
            this.f13488a = r2.f13488a;
            this.f13489b = r2.f13489b;
            this.f13490c = r2.f13490c;
            this.f13491d = r2.f13491d;
        }

        public void a(View r4) {
            ViewCompat.b(r4, this.f13488a, this.f13489b, this.f13490c, this.f13491d);
        }
    }

    public static PorterDuff.Mode a(int r1, PorterDuff.Mode r2) {
        if (r1 == 3) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 9) goto L17;
        switch(r1) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r2;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }

    public static boolean a(View r1) {
        if (ViewCompat.i(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static float a(Context r2, int r3) {
        return TypedValue.applyDimension(1, r3, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    public static void b(final View r1) {
        r1.requestFocus();
        r1.post(new AnonymousClass1(r1));
    }

    public static void a(View r4, AttributeSet r5, int r6, int r7, a r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        final a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.Insets, r6, r7);
        final boolean r12 = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Insets_paddingBottomSystemWindowInsets, "styleable", "Insets_paddingBottomSystemWindowInsets"), false);
        final boolean r1 = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Insets_paddingLeftSystemWindowInsets, "styleable", "Insets_paddingLeftSystemWindowInsets"), false);
        final boolean r13 = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Insets_paddingRightSystemWindowInsets, "styleable", "Insets_paddingRightSystemWindowInsets"), false);
        r11.recycle();
        a(r4, new AnonymousClass2(r12, r1, r13, r10));
    }

    public static void a(View r5, a r6) {
        final a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        final b r0 = new b(ViewCompat.l(r5), r5.getPaddingTop(), ViewCompat.m(r5), r5.getPaddingBottom());
        ViewCompat.a(r5, new AnonymousClass3(r7, r0));
        c(r5);
    }

    public static void c(View r1) {
        if (ViewCompat.I(r1) == false) goto L5;
        ViewCompat.u(r1);
        return;
    L5:
        r1.addOnAttachStateChangeListener(new ViewUtils$4());
    }

    public static float d(View r3) {
        ViewParent r4 = r3.getParent();
        float r0 = 0.0f;
    L4:
        if (ZeusTransformUtils.instanceOf(r4, View.class) == false) goto L6;
        r0 = r0 + ViewCompat.q((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        r4 = r4.getParent();
        goto L4
    L6:
        return r0;
    }

    public static q e(View r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L10;
        return new p(r2);
    L10:
        return ViewOverlayApi14.a(r2);
    }

    public static ViewGroup f(View r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        View r1 = r5.getRootView();
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1.findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        return r2;
    L8:
        if (r1 != r5) goto L10;
    L13:
        return null;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L13;
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    public static q g(View r0) {
        return e(f(r0));
    }

    public static void a(View r2, ViewTreeObserver.OnGlobalLayoutListener r3) {
        ViewTreeObserver.OnGlobalLayoutListener r4 = (ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.getViewTreeObserver().addOnGlobalLayoutListener(r4);
        return;
    }

    public static void b(View r2, ViewTreeObserver.OnGlobalLayoutListener r3) {
        ViewTreeObserver.OnGlobalLayoutListener r4 = (ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        a(r2.getViewTreeObserver(), r4);
        return;
    }

    public static void a(ViewTreeObserver r2, ViewTreeObserver.OnGlobalLayoutListener r3) {
        ViewTreeObserver.OnGlobalLayoutListener r4 = (ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        r2.removeOnGlobalLayoutListener(r4);
        return;
    L5:
        r2.removeGlobalOnLayoutListener(r4);
    }

    public static Integer h(View r2) {
        if (ZeusTransformUtils.instanceOf(r2.getBackground(), ColorDrawable.class) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r2.getBackground(), ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
    }
}
