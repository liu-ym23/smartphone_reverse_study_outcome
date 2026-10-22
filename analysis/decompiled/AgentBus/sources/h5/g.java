package h5;

import d7.r;
import fi.iki.elonen.NanoHTTPD;
import ia.d0;
import ia.f1;
import ia.w1;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import p7.n;
import q7.k;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f4201a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4202b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.g f4203c;

    /* renamed from: d, reason: collision with root package name */
    public final a7.d f4204d;

    /* renamed from: e, reason: collision with root package name */
    public final n f4205e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f4206f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f4207g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicLong f4208h;

    /* renamed from: i, reason: collision with root package name */
    public final na.d f4209i;

    /* renamed from: j, reason: collision with root package name */
    public w1 f4210j;

    public g(int i2, long j2, long j4, k5.a aVar, k5.g gVar, a7.d dVar) {
        c cVar = new c(2, null, 0);
        this.f4201a = i2;
        this.f4202b = j4;
        this.f4203c = gVar;
        this.f4204d = dVar;
        this.f4205e = cVar;
        this.f4206f = new ConcurrentHashMap();
        this.f4207g = new ConcurrentHashMap();
        this.f4208h = new AtomicLong(0L);
        this.f4209i = d0.b(f1.plus(d0.c(), aVar.f5617b));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:34|(1:52)|35|36|50|37|(1:61)(5:40|41|47|32|(2:48|49)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d2, code lost:
    
        r9 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
    
        r9.f4203c.a("InvocationMapper", "watchdog cb crash", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00ce -> B:41:0x00cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(h5.g r17, i7.c r18) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.g.a(h5.g, i7.c):java.lang.Object");
    }

    public static d b(g gVar, String str) {
        e eVar = e.DONE;
        gVar.getClass();
        k.e(str, "downstreamId");
        k.e(eVar, "state");
        d dVar = (d) gVar.f4206f.remove(str);
        if (dVar == null) {
            return null;
        }
        gVar.f4207g.remove(dVar.f4186b);
        return d.a(dVar, eVar);
    }

    public final d c(String str, String str2, String str3, Long l6, String str4, String str5) {
        k.e(str, "upstreamId");
        k.e(str2, "upstreamConnId");
        k.e(str3, "downstreamConnId");
        ConcurrentHashMap concurrentHashMap = this.f4206f;
        int size = concurrentHashMap.size();
        ConcurrentHashMap concurrentHashMap2 = this.f4207g;
        int i2 = this.f4201a;
        if (size >= i2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Collection collectionValues = concurrentHashMap.values();
            k.d(collectionValues, "<get-values>(...)");
            Iterator it = r.m1(collectionValues).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                Iterator it2 = it;
                if (jCurrentTimeMillis - dVar.f4192h > dVar.f4189e + NanoHTTPD.SOCKET_READ_TIMEOUT) {
                    concurrentHashMap.remove(dVar.f4185a);
                    concurrentHashMap2.remove(dVar.f4186b);
                }
                it = it2;
            }
            if (concurrentHashMap.size() >= i2) {
                throw new IllegalStateException(a1.a.f(i2, "InvocationMapper full (", ")"));
            }
        }
        String strH = a1.a.h("iv-", this.f4208h.incrementAndGet());
        d dVar2 = new d(strH, str, str2, str3, l6.longValue(), str4, str5, System.currentTimeMillis(), e.PENDING);
        concurrentHashMap.put(strH, dVar2);
        concurrentHashMap2.put(str, strH);
        return dVar2;
    }
}
