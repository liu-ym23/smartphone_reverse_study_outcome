package com.bytedance.android.shopping.store.tabkit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.store.tabkit.view.RightItemView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f186557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f186558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f186559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f186560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f186561e;

    public b(FrameLayout.LayoutParams r100, RightItemView r101, Ref.IntRef r102, Ref.IntRef r103, View r104) {
        this.f186557a = r100;
        this.f186558b = r101;
        this.f186559c = r102;
        this.f186560d = r103;
        this.f186561e = r104;
    }

    public final void a() {
        this.f186557a.gravity = 5;
        View r100 = this.f186558b;
        if (r100 != null) goto L5;
    L14:
        FrameLayout.LayoutParams r101 = this.f186557a;
        r101.setMargins(this.f186560d.element, r101.topMargin, this.f186559c.element, r101.bottomMargin);
        this.f186561e.requestLayout();
        return;
    L5:
        if (e.a(r100) != true) goto L14;
        Ref.IntRef r102 = this.f186559c;
        int r103 = this.f186558b.getWidth();
        ViewGroup.LayoutParams r104 = this.f186558b.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r104 = null;
    L9:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L12;
        int r106 = r105.rightMargin;
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
