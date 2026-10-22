package com.bytedance.android.gamecp.common.track.monitor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Pair;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56838a;

    public e(a r100) {
        this.f56838a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean r100) {
        WeakReference<View> r101 = this.f56838a.f56812b;
        if (r101 == null) goto L55;
        View r102 = r101.get();
        if (r102 == null) goto L57;
        a r103 = this.f56838a;
        r103.f56815e = r100;
        boolean r104 = r103.f56814d;
        if (r104 == false) goto L39;
        if (r100 == true) goto L39;
        if ((r102.getContext() instanceof Activity) == false) goto L17;
        Context r105 = r102.getContext();
        if (r105 == null) goto L16;
        Activity r106 = (Activity) r105;
    L34:
        if (r106 != null) goto L36;
    L38:
        a r107 = this.f56838a;
        r107.f56814d = false;
        r107.f56819i = false;
        r107.g(false);
    L45:
        a r108 = this.f56838a;
        if (r108.f56815e == false) goto L48;
        r108.a();
        return;
    L48:
        r108.h();
        return;
    L36:
        if (r106.isFinishing() != true) goto L38;
        int r109 = a.f56810y;
        a.C0914a.a(r102, true);
        goto L38
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L17:
        View r110 = r102;
    L19:
        if (r110.getParent() == null) goto L33;
        if ((r110.getParent() instanceof View) == false) goto L33;
        Object r111 = r110.getParent();
        if (r111 == null) goto L32;
        r110 = (View) r111;
        if ((r110.getContext() instanceof Activity) == false) goto L19;
        Context r112 = r110.getContext();
        if (r112 == null) goto L30;
        r106 = (Activity) r112;
        goto L34
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L33:
        r106 = null;
    L39:
        if (r100 == false) goto L45;
        if (r104 == true) goto L45;
        Pair<Boolean, Float> r113 = r103.f();
        if (r113.getFirst().booleanValue() == false) goto L44;
        a r114 = this.f56838a;
        boolean r115 = r113.getFirst().booleanValue();
        r113.getSecond().floatValue();
        r114.g(r115);
    L44:
        a r116 = this.f56838a;
        r116.f56814d = r113.getFirst().booleanValue();
        goto L45
    L57:
        return;
    }
}
