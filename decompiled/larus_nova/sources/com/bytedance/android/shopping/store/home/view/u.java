package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f184748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f184749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewParent f184750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f184751d;

    public u(ViewParent r100, View r101) {
        this.f184748a = 0.25f;
        this.f184749b = 0.2f;
        this.f184750c = r100;
        this.f184751d = r101;
    }

    public final void a() {
        int r100 = v.f184752a;
        float r101 = this.f184748a;
        float r102 = this.f184749b;
        int r103 = ((FrameLayout) this.f184750c).getMeasuredHeight();
        Context r104 = this.f184751d.getContext();
        float r105 = r103;
        int r106 = (int) (r101 * r105);
        int r107 = (int) (r102 * r105);
        FrameLayout r108 = new FrameLayout(r104);
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View r109 = new View(r104);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-1, r106);
        ViewCompat.setBackground(r109, ResourcesCompat.getDrawable(r104.getResources(), R.drawable.shopping_bg_store_live_room_foreground_top_down, r104.getTheme()));
        r108.addView(r109, r110);
        View r111 = new View(r104);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, r107);
        r112.gravity = 80;
        ViewCompat.setBackground(r111, ResourcesCompat.getDrawable(r104.getResources(), R.drawable.shopping_bg_store_live_room_foreground_bottom_up, r104.getTheme()));
        r108.addView(r111, r112);
        r108.setTag("shadowView");
        ViewParent r113 = this.f184750c;
        ((FrameLayout) r113).addView(r108, ((FrameLayout) r113).indexOfChild(this.f184751d) + 1);
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
