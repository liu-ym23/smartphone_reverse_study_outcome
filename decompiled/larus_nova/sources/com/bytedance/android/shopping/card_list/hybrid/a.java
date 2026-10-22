package com.bytedance.android.shopping.card_list.hybrid;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f171634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f171635b;

    public a(Window r100, Ref.ObjectRef r101) {
        this.f171634a = r100;
        this.f171635b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, android.view.View] */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Ref.ObjectRef r100 = this.f171635b;
        if (((View) r100.element) != null) goto L10;
        View r101 = this.f171634a.getDecorView();
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L9;
        c.a(r102, "getDecorView");
    L9:
        r100.element = r101.findViewById(R.id.statusBarBackground);
    L10:
        View r103 = (View) this.f171635b.element;
        Drawable r104 = null;
        if (r103 == null) goto L13;
        Drawable r105 = r103.getBackground();
    L15:
        if ((r105 instanceof ColorDrawable) == true) goto L19;
        View r106 = (View) this.f171635b.element;
        if (r106 == null) goto L19;
        r106.setBackground(new ColorDrawable(0));
    L19:
        View r107 = (View) this.f171635b.element;
        if (r107 == null) goto L22;
        r104 = r107.getBackground();
    L22:
        ColorDrawable r108 = (ColorDrawable) r104;
        if (r108 == null) goto L27;
        r108.setColor(0);
        return true;
    L27:
        return true;
    L13:
        r105 = null;
        goto L15
    }
}
