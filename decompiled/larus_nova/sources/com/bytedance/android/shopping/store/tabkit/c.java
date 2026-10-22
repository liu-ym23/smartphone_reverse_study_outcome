package com.bytedance.android.shopping.store.tabkit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f186627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f186628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f186629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f186630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f186631e;

    public c(View r100, Ref.IntRef r101, FrameLayout.LayoutParams r102, Ref.IntRef r103, View r104) {
        this.f186627a = r100;
        this.f186628b = r101;
        this.f186629c = r102;
        this.f186630d = r103;
        this.f186631e = r104;
    }

    public final void a() {
        View r100 = this.f186627a;
        if (r100 != null) goto L5;
    L14:
        FrameLayout.LayoutParams r101 = this.f186629c;
        r101.gravity = 3;
        r101.setMargins(this.f186628b.element, r101.topMargin, this.f186630d.element, r101.bottomMargin);
        this.f186631e.requestLayout();
        return;
    L5:
        if (e.a(r100) != true) goto L14;
        Ref.IntRef r102 = this.f186628b;
        int r103 = this.f186627a.getWidth();
        ViewGroup.LayoutParams r104 = this.f186627a.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r104 = null;
    L9:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L12;
        int r106 = r105.leftMargin;
    L13:
        r102.element = r103 + r106;
        goto L14
    L12:
        r106 = 0;
        goto L13
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
