package z9;

import H4.o;
import java.util.List;

/* renamed from: z9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2200b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final h f6993a;
    public final Z7.d b;
    public final String c;

    public C2200b(h hVar, Z7.d kClass) {
        kotlin.jvm.internal.k.f(kClass, "kClass");
        this.f6993a = hVar;
        this.b = kClass;
        this.c = hVar.f6995a + '<' + kClass.m() + '>';
    }

    @Override // z9.g
    public final boolean b() {
        return false;
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.f6993a.c(name);
    }

    @Override // z9.g
    public final int d() {
        return this.f6993a.c;
    }

    @Override // z9.g
    public final String e(int i) {
        return this.f6993a.f[i];
    }

    public final boolean equals(Object obj) {
        C2200b c2200b = obj instanceof C2200b ? (C2200b) obj : null;
        return c2200b != null && this.f6993a.equals(c2200b.f6993a) && kotlin.jvm.internal.k.b(c2200b.b, this.b);
    }

    @Override // z9.g
    public final List f(int i) {
        return this.f6993a.h[i];
    }

    @Override // z9.g
    public final g g(int i) {
        return this.f6993a.g[i];
    }

    @Override // z9.g
    public final List getAnnotations() {
        return this.f6993a.d;
    }

    @Override // z9.g
    public final o getKind() {
        return this.f6993a.b;
    }

    @Override // z9.g
    public final String h() {
        return this.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    @Override // z9.g
    public final boolean i(int i) {
        return this.f6993a.i[i];
    }

    @Override // z9.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.b + ", original: " + this.f6993a + ')';
    }
}
