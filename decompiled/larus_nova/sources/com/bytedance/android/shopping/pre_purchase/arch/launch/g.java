package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class g<I extends j, O extends j> implements i<I> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f180668e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> f180669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f180670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super I, ? extends Map<String, String>> f180671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g<?, ?> f180672d;

    public static final class a {
        public static void a(e r100, g r101, j r102) {
            Intrinsics.checkNotNullParameter(r100, "launchContext");
            Intrinsics.checkNotNullParameter(r102, "input");
            if (r101 != null) goto L5;
            return;
        L5:
            r101.a(r100, r102);
        }
    }

    static {
    }

    public g() {
        this.f180669a = new CopyOnWriteArrayList();
    }

    public final void b(com.bytedance.android.shopping.pre_purchase.arch.launch.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f180669a.add(r100);
    }

    public final void c(e r100, I r101) {
        Intrinsics.checkNotNullParameter(r100, "launchContext");
        Intrinsics.checkNotNullParameter(r101, "input");
        Function1<? super I, ? extends Map<String, String>> r102 = this.f180671c;
        if (r102 == null) goto L5;
        Map<String, String> r103 = r102.invoke(r101);
    L6:
        h r104 = this.f180670b;
        if (r104 == null) goto L9;
        r104.e(getName(), r103);
    L9:
        Iterator<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> r105 = this.f180669a.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O> r106 = r105.next();
        List<String> r107 = r100.f180663d;
        if (r107 == null) goto L17;
        if (r107.contains(r106.getName().getValue()) == true) goto L11;
    L17:
        r106.b(r100, r101);
        goto L11
    L18:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void d(e r100, f<? extends O> r101) {
        Intrinsics.checkNotNullParameter(r100, "launchContext");
        Intrinsics.checkNotNullParameter(r101, "result");
        if ((r101 instanceof f.b) == false) goto L18;
        f.b r102 = (f.b) r101;
        T r103 = r102.f180667a;
        h r104 = this.f180670b;
        if (r104 == null) goto L7;
        r104.d();
    L7:
        Iterator<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> r105 = this.f180669a.iterator();
    L9:
        if (r105.hasNext() == false) goto L16;
        com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O> r106 = r105.next();
        List<String> r107 = r100.f180663d;
        if (r107 == null) goto L15;
        if (r107.contains(r106.getName().getValue()) == true) goto L9;
    L15:
        r106.a(r100, r103);
        goto L9
    L16:
        a.a(r100, this.f180672d, r102.f180667a);
        return;
    L18:
        if ((r101 instanceof f.a) == false) goto L44;
        Throwable r108 = ((f.a) r101).f180665a;
        h r109 = this.f180670b;
        if (r109 == null) goto L22;
        r109.h(r108);
    L22:
        Iterator<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> r110 = this.f180669a.iterator();
    L24:
        if (r110.hasNext() == false) goto L45;
        com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O> r111 = r110.next();
        List<String> r112 = r100.f180663d;
        if (r112 == null) goto L30;
        if (r112.contains(r111.getName().getValue()) == true) goto L24;
    L30:
        r111.c(r100);
        goto L24
    L45:
        return;
    }
}
