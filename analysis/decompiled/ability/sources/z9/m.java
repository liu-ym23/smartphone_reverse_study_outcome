package z9;

import H4.o;
import java.util.List;

/* loaded from: classes4.dex */
public final class m implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f6997a;
    public final String b;

    public m(String str, g original) {
        kotlin.jvm.internal.k.f(original, "original");
        this.f6997a = original;
        this.b = str;
    }

    @Override // z9.g
    public final boolean b() {
        return this.f6997a.b();
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.f6997a.c(name);
    }

    @Override // z9.g
    public final int d() {
        return this.f6997a.d();
    }

    @Override // z9.g
    public final String e(int i) {
        return this.f6997a.e(i);
    }

    @Override // z9.g
    public final List f(int i) {
        return this.f6997a.f(i);
    }

    @Override // z9.g
    public final g g(int i) {
        return this.f6997a.g(i);
    }

    @Override // z9.g
    public final List getAnnotations() {
        return this.f6997a.getAnnotations();
    }

    @Override // z9.g
    public final o getKind() {
        return this.f6997a.getKind();
    }

    @Override // z9.g
    public final String h() {
        return this.b;
    }

    @Override // z9.g
    public final boolean i(int i) {
        return this.f6997a.i(i);
    }

    @Override // z9.g
    public final boolean isInline() {
        return this.f6997a.isInline();
    }
}
