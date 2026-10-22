package h1;

import D7.N;
import F0.d;
import H4.o;
import com.bytedance.services.apm.api.IHttpService;
import g1.AbstractC1451a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import k1.AbstractC1620b;

/* renamed from: h1.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1481b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f4540a = new AtomicInteger(0);
    public static boolean b = true;
    public static String c;

    public static d a(String str, byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        HashMap map = new HashMap();
        if (bArr.length > 128) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        S0.b.F(gZIPOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        map.put("Content-Encoding", "gzip");
                        bArr = byteArray;
                    } catch (Throwable th) {
                        th = th;
                        S0.b.F(gZIPOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = null;
                }
            } catch (IOException unused) {
            }
        }
        return new d(N.d(str, AbstractC1451a.N()), map, bArr);
    }

    public static void b(String str, String str2, Throwable th) {
        if (b) {
            AtomicInteger atomicInteger = f4540a;
            if (atomicInteger.get() >= 3) {
                return;
            }
            atomicInteger.incrementAndGet();
            s1.b.a(cc.dd.ee.kk.ff.c.f2142a).c(new C1480a(str, str2, th));
        }
    }

    public static void c(String str, byte[] bArr) {
        if (!D2.b.f(AbstractC1451a.b)) {
            if (AbstractC1451a.f4467a) {
                o.f("APM-CustomException", "network unreachable");
                return;
            }
            return;
        }
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            d dVarA = a(str, bArr);
            HashMap map = dVarA.b;
            String str2 = dVarA.f532a;
            if (AbstractC1451a.f4467a) {
                o.f("APM-CustomException", "http request:url:" + str2 + " headers:" + map);
            }
            ((IHttpService) AbstractC1620b.a(IHttpService.class)).doPost(str2, dVarA.c, map);
        } catch (Throwable th) {
            if (AbstractC1451a.f4467a) {
                th.printStackTrace();
            }
        }
    }
}
