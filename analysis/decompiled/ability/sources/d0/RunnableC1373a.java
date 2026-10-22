package d0;

import c0.AbstractC0867a;
import m0.C1668b;

/* renamed from: d0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1373a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4283a;
    public final /* synthetic */ long b;

    public RunnableC1373a(b bVar, boolean z10, long j5) {
        this.f4283a = z10;
        this.b = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0867a.f2067a.c(new C1668b(this.f4283a, null, System.currentTimeMillis(), this.b));
    }
}
