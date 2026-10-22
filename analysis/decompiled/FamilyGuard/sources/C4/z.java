package C4;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class z extends E {

    /* renamed from: f, reason: collision with root package name */
    public static final y f981f = y.b("multipart/mixed");

    /* renamed from: g, reason: collision with root package name */
    public static final y f982g = y.b("multipart/alternative");

    /* renamed from: h, reason: collision with root package name */
    public static final y f983h = y.b("multipart/digest");

    /* renamed from: i, reason: collision with root package name */
    public static final y f984i = y.b("multipart/parallel");

    /* renamed from: j, reason: collision with root package name */
    public static final y f985j = y.b("multipart/form-data");

    /* renamed from: k, reason: collision with root package name */
    private static final byte[] f986k = {58, 32};

    /* renamed from: l, reason: collision with root package name */
    private static final byte[] f987l = {13, 10};

    /* renamed from: m, reason: collision with root package name */
    private static final byte[] f988m = {45, 45};

    /* renamed from: a, reason: collision with root package name */
    private final L4.h f989a;

    /* renamed from: b, reason: collision with root package name */
    private final y f990b;

    /* renamed from: c, reason: collision with root package name */
    private final y f991c;

    /* renamed from: d, reason: collision with root package name */
    private final List<b> f992d;

    /* renamed from: e, reason: collision with root package name */
    private long f993e = -1;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final L4.h f994a;

        /* renamed from: b, reason: collision with root package name */
        private y f995b;

        /* renamed from: c, reason: collision with root package name */
        private final List<b> f996c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(@Nullable v vVar, E e6) {
            return b(b.a(vVar, e6));
        }

        public a b(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f996c.add(bVar);
            return this;
        }

        public z c() {
            if (this.f996c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new z(this.f994a, this.f995b, this.f996c);
        }

        public a d(y yVar) {
            if (yVar == null) {
                throw new NullPointerException("type == null");
            }
            if (yVar.d().equals("multipart")) {
                this.f995b = yVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + yVar);
        }

        public a(String str) {
            this.f995b = z.f981f;
            this.f996c = new ArrayList();
            this.f994a = L4.h.h(str);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        final v f997a;

        /* renamed from: b, reason: collision with root package name */
        final E f998b;

        private b(@Nullable v vVar, E e6) {
            this.f997a = vVar;
            this.f998b = e6;
        }

        public static b a(@Nullable v vVar, E e6) {
            if (e6 == null) {
                throw new NullPointerException("body == null");
            }
            if (vVar != null && vVar.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (vVar == null || vVar.c("Content-Length") == null) {
                return new b(vVar, e6);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    z(L4.h hVar, y yVar, List<b> list) {
        this.f989a = hVar;
        this.f990b = yVar;
        this.f991c = y.b(yVar + "; boundary=" + hVar.C());
        this.f992d = D4.e.t(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long i(@Nullable L4.f fVar, boolean z5) throws EOFException {
        L4.e eVar;
        if (z5) {
            fVar = new L4.e();
            eVar = fVar;
        } else {
            eVar = 0;
        }
        int size = this.f992d.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = this.f992d.get(i5);
            v vVar = bVar.f997a;
            E e6 = bVar.f998b;
            fVar.write(f988m);
            fVar.R(this.f989a);
            fVar.write(f987l);
            if (vVar != null) {
                int iH = vVar.h();
                for (int i6 = 0; i6 < iH; i6++) {
                    fVar.H(vVar.e(i6)).write(f986k).H(vVar.i(i6)).write(f987l);
                }
            }
            y yVarB = e6.b();
            if (yVarB != null) {
                fVar.H("Content-Type: ").H(yVarB.toString()).write(f987l);
            }
            long jA = e6.a();
            if (jA != -1) {
                fVar.H("Content-Length: ").r0(jA).write(f987l);
            } else if (z5) {
                eVar.u();
                return -1L;
            }
            byte[] bArr = f987l;
            fVar.write(bArr);
            if (z5) {
                j5 += jA;
            } else {
                e6.h(fVar);
            }
            fVar.write(bArr);
        }
        byte[] bArr2 = f988m;
        fVar.write(bArr2);
        fVar.R(this.f989a);
        fVar.write(bArr2);
        fVar.write(f987l);
        if (!z5) {
            return j5;
        }
        long size2 = j5 + eVar.size();
        eVar.u();
        return size2;
    }

    @Override // C4.E
    public long a() throws EOFException {
        long j5 = this.f993e;
        if (j5 != -1) {
            return j5;
        }
        long jI = i(null, true);
        this.f993e = jI;
        return jI;
    }

    @Override // C4.E
    public y b() {
        return this.f991c;
    }

    @Override // C4.E
    public void h(L4.f fVar) throws EOFException {
        i(fVar, false);
    }
}
