package o8;

import kotlinx.serialization.UnknownFieldException;
import mb.y;
import tc.b1;
import tc.i0;
import tc.r0;
import tc.x;
import vc.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static final b Companion = new b();

    /* renamed from: a, reason: collision with root package name */
    public final String f10794a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10795b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10796c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10797d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10798e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a implements x<d> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10799a;
        private static final rc.e descriptor;

        static {
            a aVar = new a();
            f10799a = aVar;
            r0 r0Var = new r0("com.stepos.common.utils.filestorage.models.DownloadUrlResponse", aVar, 5);
            r0Var.k("downloadModel", false);
            r0Var.k("downloadUrl", false);
            r0Var.k("contentType", false);
            r0Var.k("fileSize", false);
            r0Var.k("expiresAt", false);
            descriptor = r0Var;
        }

        @Override // pc.c
        public final void a(k kVar, Object obj) {
            d value = (d) obj;
            kotlin.jvm.internal.g.f(value, "value");
            rc.e eVar = descriptor;
            sc.c cVarB = kVar.b(eVar);
            cVarB.u(eVar, 0, value.f10794a);
            cVarB.u(eVar, 1, value.f10795b);
            cVarB.u(eVar, 2, value.f10796c);
            cVarB.y(eVar, 3, value.f10797d);
            cVarB.u(eVar, 4, value.f10798e);
            cVarB.a(eVar);
        }

        @Override // pc.a
        public final Object b(sc.d dVar) {
            rc.e eVar = descriptor;
            sc.b bVarB = dVar.b(eVar);
            int i10 = 0;
            String strQ = null;
            String strQ2 = null;
            String strQ3 = null;
            String strQ4 = null;
            long jW = 0;
            boolean z = true;
            while (z) {
                int iF = bVarB.f(eVar);
                if (iF == -1) {
                    z = false;
                } else if (iF == 0) {
                    strQ = bVarB.q(eVar, 0);
                    i10 |= 1;
                } else if (iF == 1) {
                    strQ2 = bVarB.q(eVar, 1);
                    i10 |= 2;
                } else if (iF == 2) {
                    strQ3 = bVarB.q(eVar, 2);
                    i10 |= 4;
                } else if (iF == 3) {
                    jW = bVarB.w(eVar, 3);
                    i10 |= 8;
                } else {
                    if (iF != 4) {
                        throw new UnknownFieldException(iF);
                    }
                    strQ4 = bVarB.q(eVar, 4);
                    i10 |= 16;
                }
            }
            bVarB.a(eVar);
            return new d(i10, strQ, strQ2, strQ3, jW, strQ4);
        }

        @Override // tc.x
        public final pc.a<?>[] c() {
            b1 b1Var = b1.f12964a;
            return new pc.a[]{b1Var, b1Var, b1Var, i0.f12992a, b1Var};
        }

        @Override // pc.c
        public final rc.e d() {
            return descriptor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        public final pc.a<d> serializer() {
            return a.f10799a;
        }
    }

    public /* synthetic */ d(int i10, String str, String str2, String str3, long j10, String str4) {
        if (31 != (i10 & 31)) {
            y.P(i10, 31, a.f10799a.d());
            throw null;
        }
        this.f10794a = str;
        this.f10795b = str2;
        this.f10796c = str3;
        this.f10797d = j10;
        this.f10798e = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.g.b(this.f10794a, dVar.f10794a) && kotlin.jvm.internal.g.b(this.f10795b, dVar.f10795b) && kotlin.jvm.internal.g.b(this.f10796c, dVar.f10796c) && this.f10797d == dVar.f10797d && kotlin.jvm.internal.g.b(this.f10798e, dVar.f10798e);
    }

    public final int hashCode() {
        return this.f10798e.hashCode() + a0.a.c(v1.d.a(v1.d.a(this.f10794a.hashCode() * 31, 31, this.f10795b), 31, this.f10796c), this.f10797d, 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("DownloadUrlResponse(downloadModel=", this.f10794a, ", downloadUrl=", this.f10795b, ", contentType=");
        com.stepos.core.ota.d.p(this.f10797d, this.f10796c, ", fileSize=", sbS);
        return ai.onnxruntime.a.p(sbS, ", expiresAt=", this.f10798e, ")");
    }
}
