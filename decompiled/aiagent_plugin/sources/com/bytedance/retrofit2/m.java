package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class m extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f9560a;

    /* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
    static final class a<T> implements e<T>, q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Executor f9564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e<T> f9565b;

        public /* synthetic */ Object clone() {
            return d();
        }

        a(Executor r3, e<T> r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            e<T> r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
            this.f9564a = r5;
            this.f9565b = r6;
        }

        @Override // com.bytedance.retrofit2.e
        public void a(h<T> r3) {
            final h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            an.a(r4, "callback == null");
            this.f9565b.a(new AnonymousClass1(this, r4));
        }

        @Override // com.bytedance.retrofit2.e
        @Deprecated
        public ak a() {
            return this.f9565b.a();
        }

        @Override // com.bytedance.retrofit2.e
        public void b() {
            this.f9565b.b();
        }

        @Override // com.bytedance.retrofit2.e
        public boolean c() {
            return this.f9565b.c();
        }

        @Override // com.bytedance.retrofit2.e
        public e<T> d() {
            return new a(this.f9564a, this.f9565b.d());
        }

        @Override // com.bytedance.retrofit2.e
        public com.bytedance.retrofit2.b.c e() {
            return this.f9565b.e();
        }

        @Override // com.bytedance.retrofit2.q
        public void f() {
            if (ZeusTransformUtils.instanceOf(this.f9565b, q.class) == false) goto L6;
            ((q) ZeusTransformUtils.preCheckCast(this.f9565b, q.class, "com.obric.aiagent.plugin")).f();
            return;
        }
    }

    m(Executor r3) {
        this.f9560a = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.retrofit2.f.a
    public f<?, ?> a(Type r3, Annotation[] r4, ab r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        final Executor r1 = null;
        if (a(r6) == e.class) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L14;
        final Type r7 = an.e(r6);
        if (an.a(r4, ah.class) == true) goto L12;
        r1 = this.f9560a;
    L12:
        return new AnonymousClass1(this, r7, r1);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
