package xd;

import ad.b;
import ad.j;
import ad.m;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.text.Regex;
import okhttp3.Response;
import okhttp3.f;
import okhttp3.g;
import okhttp3.h;
import sd.z;
import xd.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j<T> implements xd.b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final q f13800a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13801b;

    /* renamed from: c, reason: collision with root package name */
    public final b.a f13802c;

    /* renamed from: d, reason: collision with root package name */
    public final f<ad.t, T> f13803d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f13804e;
    public ad.b h;

    /* renamed from: j, reason: collision with root package name */
    public Throwable f13805j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13806k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ad.c {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f13807g;

        public a(d dVar) {
            this.f13807g = dVar;
        }

        @Override // ad.c
        public final void onFailure(ad.b bVar, IOException iOException) {
            try {
                this.f13807g.a(j.this, iOException);
            } catch (Throwable th) {
                retrofit2.b.m(th);
                th.printStackTrace();
            }
        }

        @Override // ad.c
        public final void onResponse(ad.b bVar, Response response) {
            d dVar = this.f13807g;
            j jVar = j.this;
            try {
                try {
                    dVar.b(jVar, jVar.d(response));
                } catch (Throwable th) {
                    retrofit2.b.m(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                retrofit2.b.m(th2);
                try {
                    dVar.a(jVar, th2);
                } catch (Throwable th3) {
                    retrofit2.b.m(th3);
                    th3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends ad.t {

        /* renamed from: b, reason: collision with root package name */
        public final ad.t f13808b;

        /* renamed from: c, reason: collision with root package name */
        public final z f13809c;

        /* renamed from: d, reason: collision with root package name */
        public IOException f13810d;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends sd.n {
            public a(sd.h hVar) {
                super(hVar);
            }

            @Override // sd.n, sd.e0
            public final long read(sd.e eVar, long j10) throws IOException {
                try {
                    return super.read(eVar, j10);
                } catch (IOException e10) {
                    b.this.f13810d = e10;
                    throw e10;
                }
            }
        }

        public b(ad.t tVar) {
            this.f13808b = tVar;
            this.f13809c = new z(new a(tVar.w()));
        }

        @Override // ad.t
        public final long a() {
            return this.f13808b.a();
        }

        @Override // ad.t, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f13808b.close();
        }

        @Override // ad.t
        public final ad.l o() {
            return this.f13808b.o();
        }

        @Override // ad.t
        public final sd.h w() {
            return this.f13809c;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends ad.t {

        /* renamed from: b, reason: collision with root package name */
        public final ad.l f13812b;

        /* renamed from: c, reason: collision with root package name */
        public final long f13813c;

        public c(ad.l lVar, long j10) {
            this.f13812b = lVar;
            this.f13813c = j10;
        }

        @Override // ad.t
        public final long a() {
            return this.f13813c;
        }

        @Override // ad.t
        public final ad.l o() {
            return this.f13812b;
        }

        @Override // ad.t
        public final sd.h w() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public j(q qVar, Object[] objArr, b.a aVar, f<ad.t, T> fVar) {
        this.f13800a = qVar;
        this.f13801b = objArr;
        this.f13802c = aVar;
        this.f13803d = fVar;
    }

    @Override // xd.b
    public final void K(d<T> dVar) {
        ad.b bVar;
        Throwable th;
        synchronized (this) {
            try {
                if (this.f13806k) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f13806k = true;
                bVar = this.h;
                th = this.f13805j;
                if (bVar == null && th == null) {
                    try {
                        ad.b bVarB = b();
                        this.h = bVarB;
                        bVar = bVarB;
                    } catch (Throwable th2) {
                        th = th2;
                        retrofit2.b.m(th);
                        this.f13805j = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f13804e) {
            bVar.cancel();
        }
        bVar.Q(new a(dVar));
    }

    @Override // xd.b
    public final synchronized okhttp3.h a() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return c().a();
    }

    public final ad.b b() {
        okhttp3.g gVarI;
        q qVar = this.f13800a;
        n<?>[] nVarArr = qVar.f13882j;
        Object[] objArr = this.f13801b;
        int length = objArr.length;
        if (length != nVarArr.length) {
            throw new IllegalArgumentException(ai.onnxruntime.a.j(")", nVarArr.length, com.stepos.core.ota.d.k(length, "Argument count (", ") doesn't match expected count (")));
        }
        p pVar = new p(qVar.f13876c, qVar.f13875b, qVar.f13877d, qVar.f13878e, qVar.f13879f, qVar.f13880g, qVar.h, qVar.f13881i);
        if (qVar.f13883k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(objArr[i10]);
            nVarArr[i10].a(pVar, objArr[i10]);
        }
        g.a aVar = pVar.f13865d;
        if (aVar != null) {
            gVarI = aVar.b();
        } else {
            String str = pVar.f13864c;
            okhttp3.g gVar = pVar.f13863b;
            gVarI = gVar.i(str);
            if (gVarI == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + gVar + ", Relative: " + pVar.f13864c);
            }
        }
        ad.s aVar2 = pVar.f13871k;
        if (aVar2 == null) {
            j.a aVar3 = pVar.f13870j;
            if (aVar3 != null) {
                aVar2 = new ad.j(aVar3.f98a, aVar3.f99b);
            } else {
                m.a aVar4 = pVar.f13869i;
                if (aVar4 != null) {
                    ArrayList arrayList2 = aVar4.f114c;
                    if (arrayList2.isEmpty()) {
                        throw new IllegalStateException("Multipart body must have at least one part.");
                    }
                    aVar2 = new ad.m(aVar4.f112a, aVar4.f113b, bd.l.l(arrayList2));
                } else if (pVar.h) {
                    aVar2 = ad.s.create((ad.l) null, new byte[0]);
                }
            }
        }
        ad.l lVar = pVar.f13868g;
        f.a aVar5 = pVar.f13867f;
        if (lVar != null) {
            if (aVar2 != null) {
                aVar2 = new p.a(aVar2, lVar);
            } else {
                Regex regex = bd.d.f3219a;
                aVar5.a("Content-Type", lVar.f100a);
            }
        }
        h.a aVar6 = pVar.f13866e;
        aVar6.getClass();
        aVar6.f10998a = gVarI;
        aVar6.f11000c = aVar5.b().e();
        aVar6.c(pVar.f13862a, aVar2);
        aVar6.d(i.class, new i(qVar.f13874a, arrayList));
        return this.f13802c.a(new okhttp3.h(aVar6));
    }

    public final ad.b c() throws IOException {
        ad.b bVar = this.h;
        if (bVar != null) {
            return bVar;
        }
        Throwable th = this.f13805j;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            ad.b bVarB = b();
            this.h = bVarB;
            return bVarB;
        } catch (IOException | Error | RuntimeException e10) {
            retrofit2.b.m(e10);
            this.f13805j = e10;
            throw e10;
        }
    }

    @Override // xd.b
    public final void cancel() {
        ad.b bVar;
        this.f13804e = true;
        synchronized (this) {
            bVar = this.h;
        }
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public final Object clone() {
        return new j(this.f13800a, this.f13801b, this.f13802c, this.f13803d);
    }

    public final r<T> d(Response response) throws IOException {
        ad.t tVar = response.f10893j;
        Response.Builder builder = new Response.Builder(response);
        builder.f10907g = new c(tVar.o(), tVar.a());
        Response responseA = builder.a();
        boolean z = responseA.r;
        int i10 = responseA.f10891d;
        if (i10 < 200 || i10 >= 300) {
            try {
                sd.e eVar = new sd.e();
                tVar.w().d0(eVar);
                new bd.g(tVar.o(), tVar.a(), eVar);
                if (z) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new r<>(responseA, null);
            } finally {
                tVar.close();
            }
        }
        if (i10 == 204 || i10 == 205) {
            if (z) {
                return new r<>(responseA, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        b bVar = new b(tVar);
        try {
            T tA = this.f13803d.a(bVar);
            if (z) {
                return new r<>(responseA, tA);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e10) {
            IOException iOException = bVar.f13810d;
            if (iOException == null) {
                throw e10;
            }
            throw iOException;
        }
    }

    @Override // xd.b
    public final boolean isCanceled() {
        boolean z = true;
        if (this.f13804e) {
            return true;
        }
        synchronized (this) {
            try {
                ad.b bVar = this.h;
                if (bVar == null || !bVar.isCanceled()) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // xd.b
    /* renamed from: clone */
    public final xd.b mo179clone() {
        return new j(this.f13800a, this.f13801b, this.f13802c, this.f13803d);
    }
}
