package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends T> f45708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f45709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f45710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f45711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f45712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f45713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f45714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f45715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f45716i;

    public abstract Animator b(View r100);

    public abstract Animator c(View r100);

    public abstract View f(int r100);

    public void g() {
    }

    public abstract void i(int r100, T r101);

    public void a() {
        this.f45714g.removeCallbacksAndMessages(null);
        Animator r100 = this.f45712e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Animator r101 = this.f45713f;
        if (r101 == null) goto L9;
        r101.cancel();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        if (this.f45708a.isEmpty() == false) goto L6;
        return;
    L6:
        if ((this instanceof com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b) == false) goto L8;
        this.f45715h = -1;
        this.f45716i = -1;
        f(0).setVisibility(8);
        f(1).setVisibility(8);
    L9:
        long r100 = this.f45709b;
        b r101 = new b(this);
        this.f45714g.postDelayed(r101, r100);
        return;
    L8:
        this.f45715h = 0;
        this.f45716i = 0;
        f(0).setVisibility(0);
        f(1).setVisibility(8);
        i(0, ListProtector.get(this.f45708a, 0));
        goto L9
    }

    public e() {
        this.f45708a = new ArrayList();
        this.f45714g = new Handler(Looper.getMainLooper());
    }

    public long e() {
        return this.f45710c;
    }

    public static void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        r100.setAlpha(1.0f);
        r100.setTranslationX(0.0f);
        r100.setTranslationY(0.0f);
    }

    public int d(int r100) {
        int r101 = r100 + 1;
        if (r101 >= this.f45708a.size()) goto L5;
        return r101;
    L5:
        if (this.f45711d == true) goto L7;
        return -1;
    L7:
        return r101 % this.f45708a.size();
    }
}
