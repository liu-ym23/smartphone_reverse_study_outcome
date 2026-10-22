package p9;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class u extends q9.c {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f5568a = new AtomicReference(null);

    @Override // q9.c
    public final boolean a(q9.a aVar) {
        AtomicReference atomicReference = this.f5568a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(e.c);
        return true;
    }

    @Override // q9.c
    public final H7.c[] b(q9.a aVar) {
        this.f5568a.set(null);
        return q9.b.f5623a;
    }
}
