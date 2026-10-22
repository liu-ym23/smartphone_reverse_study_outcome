package com.bytedance.ai.model.widgets;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k0 implements ix7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebEngineAssem f37062a;

    public k0(WebEngineAssem r100) {
        this.f37062a = r100;
    }

    @Override // ix7.f
    public final void onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f37062a.f36986q == false) goto L42;
        int r100 = r110.getAction();
        boolean r101 = false;
        if (r100 != 0) goto L7;
        this.f37062a.f36989t = (int) r110.getY();
        this.f37062a.f36992w = r110.getPointerId(0);
        return;
    L7:
        if (r100 != 1) goto L9;
    L38:
        WebEngineAssem r111 = this.f37062a;
        r111.f36993x = false;
        r111.f36992w = -1;
        return;
    L9:
        if (r100 != 2) goto L11;
    L35:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("WebViewAssem", "exception in onTouchEvent. " + e.getStackTrace());
        return;
    L14:
        if (r110.findPointerIndex(this.f37062a.f36992w) != (-1)) goto L17;
        com.bytedance.ai.utils.g.f37637a.e("WebViewAssem", "invalid pointerId = " + this.f37062a.f36992w + " in onTouchEvent");     // Catch: IllegalArgumentException -> L35
        return;
    L17:
        int r112 = (int) r110.getY(this.f37062a.f36992w);     // Catch: IllegalArgumentException -> L35
        WebEngineAssem r102 = this.f37062a;     // Catch: IllegalArgumentException -> L35
        int r113 = r112 - r102.f36989t;     // Catch: IllegalArgumentException -> L35
        if (r102.f36993x == true) goto L22;
        int r103 = Math.abs(r113);     // Catch: IllegalArgumentException -> L35
        WebEngineAssem r104 = this.f37062a;     // Catch: IllegalArgumentException -> L35
        if (r103 <= r104.f36991v) goto L22;
        r104.f36993x = true;     // Catch: IllegalArgumentException -> L35
    L22:
        WebEngineAssem r105 = this.f37062a;     // Catch: IllegalArgumentException -> L35
        if (r105.f36993x == false) goto L43;
        if (r113 == 0) goto L44;
        if (r113 >= 0) goto L27;
        r101 = true;
    L27:
        r105.f36990u = r101;     // Catch: IllegalArgumentException -> L35
        com.bytedance.ai.utils.g r106 = com.bytedance.ai.utils.g.f37637a;     // Catch: IllegalArgumentException -> L35
        r106.d("WebViewAssem", "----pullUp detected: " + this.f37062a.f36990u + ", offset: " + r113);     // Catch: IllegalArgumentException -> L35
        WebEngineAssem r114 = this.f37062a;     // Catch: IllegalArgumentException -> L35
        if (r114.f36987r == false) goto L31;
        r114.f36987r = !r114.f36990u;     // Catch: IllegalArgumentException -> L35
        r106.d("WebViewAssem", "####isReachTop: " + this.f37062a.f36987r);     // Catch: IllegalArgumentException -> L35
        return;
    L31:
        if (r114.f36988s == false) goto L33;
        r114.f36988s = r114.f36990u;     // Catch: IllegalArgumentException -> L35
        r106.d("WebViewAssem", "####isReachBottom: " + this.f37062a.f36988s);     // Catch: IllegalArgumentException -> L35
        return;
    L33:
        r106.d("WebViewAssem", "isReachTop: " + this.f37062a.f36987r + ", isReachBottom: " + this.f37062a.f36988s);     // Catch: IllegalArgumentException -> L35
        return;
    L44:
        return;
    L43:
        return;
    L11:
        if (r100 == 3) goto L38;
        return;
    }

    @Override // ix7.f
    public final Boolean a(int r100, boolean r101) {
        WebEngineAssem r102 = this.f37062a;
        if (r102.f36986q == true) goto L7;
        return null;
    L7:
        if (r100 > 0) goto L9;
    L12:
        if (r100 < 0) goto L14;
    L17:
        com.bytedance.ai.utils.g.f37637a.d("WebViewAssem", "canScrollVertically: " + r100 + ", enable: " + r101 + ", result: true");
        return Boolean.TRUE;
    L14:
        if (r102.f36988s == false) goto L17;
        com.bytedance.ai.utils.g.f37637a.d("WebViewAssem", "canScrollVertically: " + r100 + ", enable: " + r101 + ", result: false");
        return Boolean.FALSE;
    L9:
        if (r102.f36987r == false) goto L12;
        com.bytedance.ai.utils.g.f37637a.d("WebViewAssem", "canScrollVertically: " + r100 + ", enable: " + r101 + ", result: false");
        return Boolean.FALSE;
    }
}
