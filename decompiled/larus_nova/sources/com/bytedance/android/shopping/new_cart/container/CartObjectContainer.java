package com.bytedance.android.shopping.new_cart.container;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes13.dex */
public final class CartObjectContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.new_cart.components.a>, com.bytedance.android.shopping.new_cart.components.a> f178931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.new_cart.components.a>, Function0<com.bytedance.android.shopping.new_cart.components.a>> f178932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NewCartActivity f178933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CartViewModel f178934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f178935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f178936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f178937g;

    public final Context getContext() {
        NewCartActivity r100 = this.f178933c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Fragment r101 = this.f178936f;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getContext();
    }

    public final NewCartActivity getActivity() {
        return this.f178933c;
    }

    public final <T extends com.bytedance.android.shopping.new_cart.components.a> T a(KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        com.bytedance.android.shopping.new_cart.components.a r101 = null;
        if (this.f178931a.containsKey(r100) == false) goto L9;
        com.bytedance.android.shopping.new_cart.components.a r102 = this.f178931a.get(r100);
        if ((r102 instanceof com.bytedance.android.shopping.new_cart.components.a) == false) goto L20;
        r101 = r102;
    L20:
        return (T) r101;
    L9:
        Function0<com.bytedance.android.shopping.new_cart.components.a> r103 = this.f178932b.get(r100);
        if (r103 == null) goto L12;
        com.bytedance.android.shopping.new_cart.components.a r104 = r103.invoke();
    L13:
        if (r104 == null) goto L16;
        this.f178931a.put(r100, r104);
        b(r104);
    L16:
        if ((r104 instanceof com.bytedance.android.shopping.new_cart.components.a) == true) goto L19;
        return null;
    L19:
        return (T) r104;
    L12:
        r104 = null;
        goto L13
    }

    public final void b(com.bytedance.android.shopping.new_cart.components.a r100) {
        NewCartActivity r101 = this.f178933c;
        if (r101 == null) goto L6;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L6;
    L10:
        if (r102 == null) goto L25;
        Lifecycle.State r103 = r102.getCurrentState();
        int r104 = r.f179021a[r103.ordinal()];
        if (r104 != 2) goto L14;
        r100.h();
        return;
    L14:
        if (r104 != 3) goto L16;
        r100.h();
        r100.l();
        return;
    L16:
        if (r104 != 4) goto L18;
        r100.h();
        r100.l();
        r100.k();
        return;
    L18:
        if (r104 != 5) goto L29;
        r100.h();
        r100.l();
        r100.k();
        r100.j();
        r100.m();
        r100.i();
        return;
    L29:
        return;
    L25:
        return;
    L6:
        Fragment r105 = this.f178936f;
        if (r105 == null) goto L9;
        r102 = r105.getLifecycle();
        goto L10
    L9:
        r102 = null;
        goto L10
    }

    public final <T extends com.bytedance.android.shopping.new_cart.components.a> void c(KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r100, Boolean r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r102, "func");
        this.f178932b.put(r100, r102);
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L11;
        Function0<com.bytedance.android.shopping.new_cart.components.a> r103 = this.f178932b.get(r100);
        if (r103 == null) goto L7;
        com.bytedance.android.shopping.new_cart.components.a r104 = r103.invoke();
    L8:
        if (r104 == null) goto L12;
        this.f178931a.put(r100, r104);
        b(r104);
        return;
    L12:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public CartObjectContainer(CartViewModel r100, NewCartActivity r101, b r102, Fragment r103, w r104) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r104, "screenSizeService");
        this.f178934d = r100;
        this.f178935e = r102;
        this.f178936f = r103;
        this.f178937g = r104;
        this.f178931a = new ConcurrentHashMap();
        this.f178932b = new ConcurrentHashMap();
        this.f178933c = r101;
        if (r101 == null) goto L6;
        Lifecycle r105 = r101.getLifecycle();
        if (r105 == null) goto L6;
    L9:
        if (r105 == null) goto L12;
        r105.addObserver(new AnonymousClass1(this));
        return;
    L12:
        return;
    L6:
        if (r103 == null) goto L8;
        r105 = r103.getLifecycle();
        goto L9
    L8:
        r105 = null;
        goto L9
    }
}
