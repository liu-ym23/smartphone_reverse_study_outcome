package com.bytedance.android.gamecp.hybrid_impl.lynx.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.common.utility.reflect.Reflect;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends com.lynx.tasm.behavior.ui.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f57698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f57699c;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final Activity c() {
        Activity r100 = this.f57698b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if ((getContext() instanceof Activity) == false) goto L12;
        Context r101 = getContext();
        if (r101 == null) goto L11;
        this.f57698b = (Activity) r101;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L12:
        View r102 = this;
    L14:
        if (r102.getParent() == null) goto L29;
        if ((r102.getParent() instanceof View) == false) goto L29;
        Object r103 = r102.getParent();
        if (r103 == null) goto L27;
        r102 = (View) r103;
        if ((r102.getContext() instanceof Activity) == false) goto L14;
        Context r104 = r102.getContext();
        if (r104 == null) goto L25;
        this.f57698b = (Activity) r104;
        goto L29
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L29:
        return this.f57698b;
    }

    public final Float getMonitorDuration() {
        b r100 = this.f57699c;
        if (r100 == null) goto L8;
        float r101 = r100.f57696c;
        if (r100.f57695b <= 0) goto L10;
        r101 = r101 + ((System.currentTimeMillis() - r100.f57695b) / 1000.0f);
    L10:
        return Float.valueOf(r101);
    L8:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b r100 = this.f57699c;
        if (r100 == null) goto L11;
        Activity r101 = c();
        if (r100.f57694a == true) goto L12;
        if (r101 == null) goto L13;
        Application r102 = r101.getApplication();
        if (r102 == null) goto L14;
        r100.f57694a = true;
        r100.a();
        r102.registerActivityLifecycleCallbacks(r100);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r100 = this.f57699c;
        if (r100 == null) goto L11;
        Activity r101 = c();
        if (r100.f57694a == false) goto L12;
        if (r101 == null) goto L13;
        Application r102 = r101.getApplication();
        if (r102 == null) goto L14;
        r100.f57694a = false;
        r102.unregisterActivityLifecycleCallbacks(r100);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L8;
    L22:
        if (this.f57697a == false) goto L24;
    L25:
        return true;
    L24:
        if (super.onTouchEvent(r100) == true) goto L25;
        return false;
    L8:
        if (r100.getAction() != 1) goto L22;
    L10:
        if ((System.currentTimeMillis() - ((long) 0)) <= 500) goto L22;
        if (Build.VERSION.SDK_INT < 29) goto L27;
        View.AccessibilityDelegate r101 = getAccessibilityDelegate();
        if (r101 == null) goto L22;
        r101.sendAccessibilityEvent(this, 1);
        goto L22
    L27:
        View.AccessibilityDelegate r102 = (View.AccessibilityDelegate) Reflect.on(this).get("mAccessibilityDelegate", new Class[]{View.AccessibilityDelegate.class});     // Catch: Throwable -> L18
    L19:
        if (r102 == null) goto L22;
        r102.sendAccessibilityEvent(this, 1);
    L18:
        r102 = null;
        goto L19
    L5:
        if (r100.getAction() == 0) goto L10;
        goto L6
    }
}
