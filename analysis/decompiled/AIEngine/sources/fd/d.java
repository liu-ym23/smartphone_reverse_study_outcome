package fd;

import ad.u;
import java.io.IOException;
import okhttp3.Response;
import sd.c0;
import sd.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface d {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void b();

        void cancel();

        u d();

        void f(okhttp3.internal.connection.d dVar, IOException iOException);
    }

    void a();

    e0 b(Response response);

    long c(Response response);

    void cancel();

    c0 d(okhttp3.h hVar, long j10);

    void e(okhttp3.h hVar);

    Response.Builder f(boolean z);

    void g();

    a h();

    okhttp3.f i();
}
