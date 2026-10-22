package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f45703a;

    public b(e r100) {
        this.f45703a = r100;
    }

    public final void a() {
        e r100 = this.f45703a;
        r100.f45715h = r100.d(r100.f45715h);
        e r101 = this.f45703a;
        int r102 = r101.f45715h;
        if (r102 >= 0) goto L5;
    L7:
        this.f45703a.g();
        return;
    L5:
        if (r102 >= r101.f45708a.size()) goto L7;
        e r103 = this.f45703a;
        int r104 = r103.f45716i;
        int r105 = (r104 + 1) % 2;
        r103.f45716i = r105;
        r103.i(r105, ListProtector.get(r103.f45708a, r103.f45715h));
        View r106 = r103.f(r105);
        View r107 = r103.f(r104);
        Animator r108 = r103.b(r106);
        r108.addListener(new c(r103, r106));
        r108.start();
        Unit r109 = Unit.INSTANCE;
        r103.f45712e = r108;
        Animator r110 = r103.c(r107);
        r110.addListener(new d(r103, r107));
        r110.start();
        r103.f45713f = r110;
        e r111 = this.f45703a;
        int r112 = r111.f45715h;
        long r113 = r111.e();
        b r114 = new b(r111);
        r111.f45714g.postDelayed(r114, r113);
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
