package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E9.W;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import ma.C4926f;

/* loaded from: classes5.dex */
public interface f {

    public interface a {
        void a();

        void b(ga.e eVar, ga.b bVar, ga.e eVar2);

        void c(ga.e eVar, Object obj);

        void d(ga.e eVar, C4926f c4926f);

        b e(ga.e eVar);

        a f(ga.e eVar, ga.b bVar);
    }

    public interface b {
        void a();

        void b(C4926f c4926f);

        void c(ga.b bVar, ga.e eVar);

        a d(ga.b bVar);

        void e(Object obj);
    }

    public interface c {
        void a();

        a b(ga.b bVar, W w10);
    }

    public interface d {
        e a(ga.e eVar, String str);

        c b(ga.e eVar, String str, Object obj);
    }

    public interface e extends c {
        a c(int i10, ga.b bVar, W w10);
    }

    void a(d dVar, byte[] bArr);

    KotlinClassHeader b();

    void c(c cVar, byte[] bArr);

    String getLocation();

    ga.b j();
}
