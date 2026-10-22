package com.bytedance.android.livesdk.livecommerce.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.IronPromotionListTopCategoryWidget$createExpandView$view$1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f153086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f153087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f153088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f153089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f153090e;

    public final void a() {
        Rect r100 = new Rect();
        this.f153086a.getHitRect(r100);
        r100.top += this.f153087b;
        r100.bottom += this.f153088c;
        r100.left += this.f153089d;
        r100.right += this.f153090e;
        TouchDelegate r101 = new TouchDelegate(r100, this.f153086a);
        if ((this.f153086a.getParent() instanceof View) == false) goto L6;
        ((View) this.f153086a.getParent()).setTouchDelegate(r101);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(IronPromotionListTopCategoryWidget$createExpandView$view$1 r100, int r101, int r102) {
        this.f153086a = r100;
        this.f153087b = 0;
        this.f153088c = 0;
        this.f153089d = r101;
        this.f153090e = r102;
    }
}
