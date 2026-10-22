package s9;

import m9.InterfaceC1733z;

/* renamed from: s9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1923c implements InterfaceC1733z {

    /* renamed from: a, reason: collision with root package name */
    public final H7.h f5997a;

    public C1923c(H7.h hVar) {
        this.f5997a = hVar;
    }

    @Override // m9.InterfaceC1733z
    public final H7.h getCoroutineContext() {
        return this.f5997a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f5997a + ')';
    }
}
