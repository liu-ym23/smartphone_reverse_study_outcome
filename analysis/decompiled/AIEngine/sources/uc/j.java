package uc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements rc.e {

    /* renamed from: a, reason: collision with root package name */
    public final lb.d f13213a;

    public j(zb.a<? extends rc.e> aVar) {
        this.f13213a = kotlin.b.b(aVar);
    }

    public final rc.e a() {
        return (rc.e) this.f13213a.getValue();
    }

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        return a().c(name);
    }

    @Override // rc.e
    public final rc.i d() {
        return a().d();
    }

    @Override // rc.e
    public final int e() {
        return a().e();
    }

    @Override // rc.e
    public final String f(int i10) {
        return a().f(i10);
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        return a().g(i10);
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return EmptyList.f10001a;
    }

    @Override // rc.e
    public final rc.e h(int i10) {
        return a().h(i10);
    }

    @Override // rc.e
    public final String i() {
        return a().i();
    }

    @Override // rc.e
    public final boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        return a().j(i10);
    }
}
