package com.bytedance.android.shopping.pre_purchase.arch.launch;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f180651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f180652b;

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void d() {
        this.f180651a.a().d();
        if (this.f180652b.f180672d == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L14;
        c r101 = this.f180651a;
        Iterator<d> r102 = r101.f180653a.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().c();
        goto L9
    L11:
        r101.a().c();
        return;
    L14:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void h(Throwable r100) {
        this.f180651a.a().h(r100);
        this.f180651a.b(r100);
    }

    public b(c r100, g r101) {
        this.f180651a = r100;
        this.f180652b = r101;
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void e(StageName r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f180651a.a().e(r100, r101);
    }
}
