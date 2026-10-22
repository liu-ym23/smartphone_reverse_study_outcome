package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;
import c0.C0574d;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class L implements InterfaceC0537q, Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final String f10820a;

    /* renamed from: b, reason: collision with root package name */
    private final J f10821b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10822c;

    public L(String str, J j5) {
        j4.k.g(str, "key");
        j4.k.g(j5, "handle");
        this.f10820a = str;
        this.f10821b = j5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        j4.k.g(interfaceC0539t, "source");
        j4.k.g(aVar, "event");
        if (aVar == AbstractC0533m.a.ON_DESTROY) {
            this.f10822c = false;
            interfaceC0539t.getLifecycle().d(this);
        }
    }

    public final void v(C0574d c0574d, AbstractC0533m abstractC0533m) {
        j4.k.g(c0574d, "registry");
        j4.k.g(abstractC0533m, "lifecycle");
        if (this.f10822c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f10822c = true;
        abstractC0533m.a(this);
        c0574d.h(this.f10820a, this.f10821b.c());
    }

    public final J w() {
        return this.f10821b;
    }

    public final boolean x() {
        return this.f10822c;
    }
}
