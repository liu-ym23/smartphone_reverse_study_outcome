package R;

import H.h;
import U.f;
import U.g;
import U.i;
import ca.AbstractC0897f;
import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1136a = 0;

    static {
        h2.d dVar = W.a.f1470a;
    }

    public static void a(V.a aVar, Exception exc) {
        try {
            int iE = S0.b.e(exc);
            i iVar = aVar.b;
            i iVar2 = aVar.b;
            iVar.f1248a = 2;
            f fVar = iVar.f1249j;
            fVar.b = iE;
            fVar.f1245a = S0.b.s(Thread.currentThread().getStackTrace());
            iVar2.f1249j.d = exc.getClass().getName();
            iVar2.f1249j.c = exc.getClass().getName() + ":" + exc.getMessage();
        } catch (Throwable unused) {
        }
    }

    public static void b(V.a aVar, HttpURLConnection httpURLConnection) throws IOException {
        int responseCode;
        int contentLength = httpURLConnection.getContentLength();
        if (contentLength >= 0) {
            aVar.a(contentLength);
        }
        try {
            responseCode = httpURLConnection.getResponseCode();
        } catch (IOException | NullPointerException unused) {
            responseCode = 0;
        }
        i iVar = aVar.b;
        g gVar = iVar.e;
        gVar.f1246a = responseCode;
        gVar.e = AbstractC0897f.h(h.f711a);
        if (responseCode < 400) {
            iVar.f1248a = 3;
            return;
        }
        iVar.f1248a = 1;
        iVar.f1249j.f1245a = S0.b.s(Thread.currentThread().getStackTrace());
        iVar.f1249j.b = responseCode;
    }
}
