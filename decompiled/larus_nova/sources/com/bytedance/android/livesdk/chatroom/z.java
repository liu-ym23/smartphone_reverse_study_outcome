package com.bytedance.android.livesdk.chatroom;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeRootViewChangeManager f119323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f119324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f119325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f119326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f119327e;

    public z(LandscapeRootViewChangeManager r100, int r101, int r102) {
        this.f119323a = r100;
        this.f119324b = 0;
        this.f119325c = 0;
        this.f119326d = r101;
        this.f119327e = r102;
    }

    public final void a() {
        Rect r100 = new Rect();
        this.f119323a.f105041r.setEnabled(true);
        this.f119323a.f105041r.getHitRect(r100);
        r100.top -= this.f119324b;
        r100.bottom += this.f119325c;
        r100.left -= this.f119326d;
        r100.right += this.f119327e;
        TouchDelegate r101 = new TouchDelegate(r100, this.f119323a.f105041r);
        if ((this.f119323a.f105041r.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r102 = this.f119323a.f105041r.getParent();
        if (r102 == null) goto L8;
        ((ViewGroup) r102).setTouchDelegate(r101);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
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
}
