package s;

import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a<E> extends List<E>, Collection, ac.a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: s.a$a, reason: collision with other inner class name */
    public static final class C0138a<E> extends mb.c<E> implements a<E> {

        /* renamed from: a, reason: collision with root package name */
        public final a<E> f11824a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11825b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11826c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0138a(a<? extends E> aVar, int i10, int i11) {
            this.f11824a = aVar;
            this.f11825b = i10;
            jd.b.l(i10, i11, aVar.size());
            this.f11826c = i11 - i10;
        }

        @Override // mb.a
        public final int a() {
            return this.f11826c;
        }

        @Override // java.util.List
        public final E get(int i10) {
            jd.b.j(i10, this.f11826c);
            return this.f11824a.get(this.f11825b + i10);
        }

        @Override // mb.c, java.util.List
        public final List subList(int i10, int i11) {
            jd.b.l(i10, i11, this.f11826c);
            int i12 = this.f11825b;
            return new C0138a(this.f11824a, i10 + i12, i12 + i11);
        }
    }
}
