package e2;

import e2.C3975b;

/* loaded from: classes2.dex */
public abstract class l {

    public static abstract class a {
        public abstract l a();

        public abstract a b(b2.b bVar);

        public abstract a c(b2.c<?> cVar);

        public abstract a d(b2.d<?, byte[]> dVar);

        public abstract a e(m mVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new C3975b.C0393b();
    }

    public abstract b2.b b();

    public abstract b2.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    public abstract b2.d<?, byte[]> e();

    public abstract m f();

    public abstract String g();
}
