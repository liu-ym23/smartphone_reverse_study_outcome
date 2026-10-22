package B9;

import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public final class c0 implements z9.g, InterfaceC0184k {

    /* renamed from: a, reason: collision with root package name */
    public final z9.g f236a;
    public final String b;
    public final Set c;

    public c0(z9.g original) {
        kotlin.jvm.internal.k.f(original, "original");
        this.f236a = original;
        this.b = original.h() + '?';
        this.c = T.b(original);
    }

    @Override // B9.InterfaceC0184k
    public final Set a() {
        return this.c;
    }

    @Override // z9.g
    public final boolean b() {
        return true;
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.f236a.c(name);
    }

    @Override // z9.g
    public final int d() {
        return this.f236a.d();
    }

    @Override // z9.g
    public final String e(int i) {
        return this.f236a.e(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return kotlin.jvm.internal.k.b(this.f236a, ((c0) obj).f236a);
        }
        return false;
    }

    @Override // z9.g
    public final List f(int i) {
        return this.f236a.f(i);
    }

    @Override // z9.g
    public final z9.g g(int i) {
        return this.f236a.g(i);
    }

    @Override // z9.g
    public final List getAnnotations() {
        return this.f236a.getAnnotations();
    }

    @Override // z9.g
    public final H4.o getKind() {
        return this.f236a.getKind();
    }

    @Override // z9.g
    public final String h() {
        return this.b;
    }

    public final int hashCode() {
        return this.f236a.hashCode() * 31;
    }

    @Override // z9.g
    public final boolean i(int i) {
        return this.f236a.i(i);
    }

    @Override // z9.g
    public final boolean isInline() {
        return this.f236a.isInline();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f236a);
        sb.append('?');
        return sb.toString();
    }
}
