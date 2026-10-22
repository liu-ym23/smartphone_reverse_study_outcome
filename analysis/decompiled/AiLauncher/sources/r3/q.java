package r3;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import r3.C5207a;

/* loaded from: classes2.dex */
public final class q extends PhantomReference implements C5207a.InterfaceC0515a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f38808a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f38809b;

    public /* synthetic */ q(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, p pVar) {
        super(obj, referenceQueue);
        this.f38808a = set;
        this.f38809b = runnable;
    }

    @Override // r3.C5207a.InterfaceC0515a
    public final void clean() {
        if (this.f38808a.remove(this)) {
            clear();
            this.f38809b.run();
        }
    }
}
