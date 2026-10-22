package C0;

import android.content.Context;

/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final D0.j f320a = new D0.j();

    /* renamed from: b, reason: collision with root package name */
    public final B0.r f321b;

    static {
        s0.t.f("WorkForegroundRunnable");
    }

    public t(Context context, B0.r rVar, s0.s sVar, u uVar, E0.a aVar) {
        this.f321b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4 = this.f321b.f183q;
        this.f320a.j(null);
    }
}
