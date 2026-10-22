package z4;

import s4.AbstractC1071f0;

/* renamed from: z4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1354f extends AbstractC1071f0 {

    /* renamed from: d, reason: collision with root package name */
    private final int f24110d;

    /* renamed from: e, reason: collision with root package name */
    private final int f24111e;

    /* renamed from: f, reason: collision with root package name */
    private final long f24112f;

    /* renamed from: g, reason: collision with root package name */
    private final String f24113g;

    /* renamed from: h, reason: collision with root package name */
    private ExecutorC1349a f24114h = h0();

    public C1354f(int i5, int i6, long j5, String str) {
        this.f24110d = i5;
        this.f24111e = i6;
        this.f24112f = j5;
        this.f24113g = str;
    }

    private final ExecutorC1349a h0() {
        return new ExecutorC1349a(this.f24110d, this.f24111e, this.f24112f, this.f24113g);
    }

    @Override // s4.AbstractC1056E
    public void Y(Z3.i iVar, Runnable runnable) {
        ExecutorC1349a.v(this.f24114h, runnable, null, false, 6, null);
    }

    public final void j0(Runnable runnable, i iVar, boolean z5) {
        this.f24114h.u(runnable, iVar, z5);
    }
}
