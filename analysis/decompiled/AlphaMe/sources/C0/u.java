package C0;

import androidx.work.impl.WorkDatabase;
import s0.InterfaceC0853k;

/* loaded from: classes.dex */
public final class u implements InterfaceC0853k {

    /* renamed from: a, reason: collision with root package name */
    public final E0.a f322a;

    /* renamed from: b, reason: collision with root package name */
    public final A0.a f323b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.u f324c;

    static {
        s0.t.f("WMFgUpdater");
    }

    public u(WorkDatabase workDatabase, A0.a aVar, E0.a aVar2) {
        this.f323b = aVar;
        this.f322a = aVar2;
        this.f324c = workDatabase.g();
    }
}
