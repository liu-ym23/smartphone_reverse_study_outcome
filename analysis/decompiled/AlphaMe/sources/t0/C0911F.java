package t0;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0911F {

    /* renamed from: a, reason: collision with root package name */
    public final r f15320a;

    /* renamed from: b, reason: collision with root package name */
    public final E0.a f15321b;

    public C0911F(r processor, E0.a workTaskExecutor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
        this.f15320a = processor;
        this.f15321b = workTaskExecutor;
    }

    public final void a(x workSpecId, int i4) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f15321b.a(new C0.p(this.f15320a, workSpecId, false, i4));
    }
}
