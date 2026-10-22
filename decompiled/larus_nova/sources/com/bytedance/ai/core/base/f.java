package com.bytedance.ai.core.base;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f36147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Integer, Unit> f36148b;

    public void h(int r100) {
    }

    public void j(int r100) {
    }

    public final void f() {
        int r100 = this.f36147a.decrementAndGet();
        Function1<? super Integer, Unit> r101 = this.f36148b;
        if (r101 == null) goto L5;
        r101.invoke(Integer.valueOf(r100));
    L5:
        h(r100);
    }

    public final void g() {
        int r100 = this.f36147a.incrementAndGet();
        Function1<? super Integer, Unit> r101 = this.f36148b;
        if (r101 == null) goto L5;
        r101.invoke(Integer.valueOf(r100));
    L5:
        j(r100);
    }

    public f() {
        this.f36147a = new AtomicInteger(0);
    }
}
