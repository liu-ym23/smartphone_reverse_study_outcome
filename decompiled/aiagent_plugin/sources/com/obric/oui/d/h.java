package com.obric.oui.d;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: ViewUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private static final String TAG = "ViewUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f35017a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f35018b = 0.0f;

    private h() {
    }

    public static final void a(View r5, d.h.a.b<? super View, x> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "visitor");
        if (r5 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L14;
        int r0 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
    L8:
        if (r0 >= r2) goto L18;
        int r3 = r0 + 1;
        View r1 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r0);
        if (r1 == null) goto L13;
        r7.invoke(r1);
    L13:
        r0 = r3;
        goto L8
    L18:
        return;
    }

    public static final int a(int r3, float r4) {
        if (r4 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r3;
    L8:
        float r5 = n.a(r4, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r3) * r5), Color.red(r3), Color.green(r3), Color.blue(r3));
    L5:
        r1 = false;
        goto L6
    }

    public final void a(TextView r1) {
        o.e(r1, "<this>");
        r1.setSingleLine();
        r1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r1.setMarqueeRepeatLimit(-1);
        r1.setHorizontalFadingEdgeEnabled(true);
        r1.setSelected(true);
    }

    public final void b(TextView r1) {
        o.e(r1, "<this>");
        r1.setSingleLine();
        r1.setEllipsize(TextUtils.TruncateAt.END);
        r1.setHorizontalFadingEdgeEnabled(false);
        r1.setSelected(false);
    }

    public final ViewGroup a(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        o.e(r2, "activity");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").getDecorView().findViewById(R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "getActivityContentView, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (ViewGroup) ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    public final ViewGroup a(Dialog r4) {
        o.e(r4, "dialog");
        Window r5 = r4.getWindow();     // Catch: Exception -> L11
        if (r5 == null) goto L16;
        View r6 = r5.getDecorView();     // Catch: Exception -> L11
        if (r6 == null) goto L17;
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r6.findViewById(R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
    L17:
        return null;
    L16:
        return null;
    L11:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "getDialogContentView, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (ViewGroup) ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(View r6, MotionEvent r7) {
        o.e(r6, "<this>");
        o.e(r7, "ev");
        float r5 = r7.getRawX();
        float r8 = r7.getRawY();
        int[] r0 = new int[2];
        r6.getLocationOnScreen(r0);
        if (r5 < r0[0]) goto L11;
        if (r8 < r0[1]) goto L11;
        if (r5 > (r0[0] + r6.getWidth())) goto L11;
        if (r8 > (r0[1] + r6.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }

    public final void a(Canvas r5, j r6, RectF r7, float r8) {
        o.e(r5, "canvas");
        o.e(r6, "shadow");
        o.e(r7, "rect");
        if (r6.g() <= 0.0f) goto L5;
        r8 = r6.g();
    L5:
        Path r4 = new Path();
        l.f34562a.a(r4, r7, r8);
        int r1 = r5.save();
        RectF r2 = new RectF(r7);
        r2.offset(r6.c(), r6.d());
        r2.inset(-r6.e(), -r6.e());
        r5.clipOutPath(r4);
        r6.f().setColor(r6.a());
        if (r6.b() <= 0.0f) goto L8;
        r6.f().setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r6.b(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
    L8:
        l.a(r5, r2, r8, r6.f());
        r5.restoreToCount(r1);
    }

    public final void a(Context r10, int r11, j r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        o.e(r12, "baseShadow");
        TypedArray r14 = r13.obtainStyledAttributes(r11, com.obric.aiagent.plugin.R.styleable.OUILayout);
        o.c(r14, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        a(r14, r12, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OUILayout_oui_firstShadowColor, "styleable", "OUILayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OUILayout_oui_firstShadowBlur, "styleable", "OUILayout_oui_firstShadowBlur"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OUILayout_oui_firstOffsetX, "styleable", "OUILayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OUILayout_oui_firstOffsetY, "styleable", "OUILayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OUILayout_oui_firstShadowSpread, "styleable", "OUILayout_oui_firstShadowSpread"));
        r14.recycle();
    }

    private final void a(TypedArray r1, j r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.a(r1.getColor(r3, Color.parseColor("#00000000")));
        r2.a(r1.getDimension(r4, 0.0f));
        r2.b(r1.getDimension(r5, 0.0f));
        r2.c(r1.getDimension(r6, 0.0f));
        r2.d(r1.getDimension(r7, 0.0f));
    }

    static {
        f35017a = new h();
        f35018b = 1.2f;
    }

    public static final boolean a(float r1) {
        if (r1 < f35018b) goto L5;
        return true;
    L5:
        return false;
    }
}
