package o8;

import kotlinx.serialization.UnknownFieldException;
import mb.y;
import tc.b1;
import tc.r0;
import tc.x;
import vc.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {
    public static final b Companion = new b();

    /* renamed from: a, reason: collision with root package name */
    public final String f10790a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10791b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10792c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a implements x<c> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10793a;
        private static final rc.e descriptor;

        static {
            a aVar = new a();
            f10793a = aVar;
            r0 r0Var = new r0("com.stepos.common.utils.filestorage.models.CreateUploadSessionResponse", aVar, 3);
            r0Var.k("fileId", false);
            r0Var.k("uploadUrl", false);
            r0Var.k("expiresAt", false);
            descriptor = r0Var;
        }

        @Override // pc.c
        public final void a(k kVar, Object obj) {
            c value = (c) obj;
            kotlin.jvm.internal.g.f(value, "value");
            rc.e eVar = descriptor;
            sc.c cVarB = kVar.b(eVar);
            cVarB.u(eVar, 0, value.f10790a);
            cVarB.u(eVar, 1, value.f10791b);
            cVarB.u(eVar, 2, value.f10792c);
            cVarB.a(eVar);
        }

        @Override // pc.a
        public final Object b(sc.d dVar) {
            rc.e eVar = descriptor;
            sc.b bVarB = dVar.b(eVar);
            String strQ = null;
            boolean z = true;
            int i10 = 0;
            String strQ2 = null;
            String strQ3 = null;
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
                } else {
                    if (iF != 2) {
                        throw new UnknownFieldException(iF);
                    }
                    strQ3 = bVarB.q(eVar, 2);
                    i10 |= 4;
                }
            }
            bVarB.a(eVar);
            return new c(strQ, i10, strQ2, strQ3);
        }

        @Override // tc.x
        public final pc.a<?>[] c() {
            b1 b1Var = b1.f12964a;
            return new pc.a[]{b1Var, b1Var, b1Var};
        }

        @Override // pc.c
        public final rc.e d() {
            return descriptor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        public final pc.a<c> serializer() {
            return a.f10793a;
        }
    }

    public /* synthetic */ c(String str, int i10, String str2, String str3) {
        if (7 != (i10 & 7)) {
            y.P(i10, 7, a.f10793a.d());
            throw null;
        }
        this.f10790a = str;
        this.f10791b = str2;
        this.f10792c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.g.b(this.f10790a, cVar.f10790a) && kotlin.jvm.internal.g.b(this.f10791b, cVar.f10791b) && kotlin.jvm.internal.g.b(this.f10792c, cVar.f10792c);
    }

    public final int hashCode() {
        return this.f10792c.hashCode() + v1.d.a(this.f10790a.hashCode() * 31, 31, this.f10791b);
    }

    public final String toString() {
        return ai.onnxruntime.a.o(ai.onnxruntime.a.s("CreateUploadSessionResponse(fileId=", this.f10790a, ", uploadUrl=", this.f10791b, ", expiresAt="), this.f10792c, ")");
    }
}
