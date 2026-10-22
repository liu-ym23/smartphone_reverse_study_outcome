package H0;

import java.util.Queue;

/* loaded from: classes.dex */
public class m<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final X0.g<b<A>, B> f1997a;

    class a extends X0.g<b<A>, B> {
        a(long j5) {
            super(j5);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // X0.g
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b<A> bVar, B b6) {
            bVar.c();
        }
    }

    static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f1999d = X0.k.f(0);

        /* renamed from: a, reason: collision with root package name */
        private int f2000a;

        /* renamed from: b, reason: collision with root package name */
        private int f2001b;

        /* renamed from: c, reason: collision with root package name */
        private A f2002c;

        private b() {
        }

        static <A> b<A> a(A a6, int i5, int i6) {
            b<A> bVar;
            Queue<b<?>> queue = f1999d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a6, i5, i6);
            return bVar;
        }

        private void b(A a6, int i5, int i6) {
            this.f2002c = a6;
            this.f2001b = i5;
            this.f2000a = i6;
        }

        public void c() {
            Queue<b<?>> queue = f1999d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f2001b == bVar.f2001b && this.f2000a == bVar.f2000a && this.f2002c.equals(bVar.f2002c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f2000a * 31) + this.f2001b) * 31) + this.f2002c.hashCode();
        }
    }

    public m(long j5) {
        this.f1997a = new a(j5);
    }

    public B a(A a6, int i5, int i6) {
        b<A> bVarA = b.a(a6, i5, i6);
        B bG = this.f1997a.g(bVarA);
        bVarA.c();
        return bG;
    }

    public void b(A a6, int i5, int i6, B b6) {
        this.f1997a.k(b.a(a6, i5, i6), b6);
    }
}
