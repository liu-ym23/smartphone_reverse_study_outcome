package xd;

import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import xd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements c<Object, b<?>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Type f13792a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f13793b;

    public g(Type type, Executor executor) {
        this.f13792a = type;
        this.f13793b = executor;
    }

    @Override // xd.c
    public final Type a() {
        return this.f13792a;
    }

    @Override // xd.c
    public final Object b(j jVar) {
        Executor executor = this.f13793b;
        return executor == null ? jVar : new h.a(executor, jVar);
    }
}
