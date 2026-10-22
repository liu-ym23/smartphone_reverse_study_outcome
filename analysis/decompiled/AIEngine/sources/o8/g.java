package o8;

import kotlinx.serialization.UnknownFieldException;
import mb.y;
import tc.b1;
import tc.r0;
import tc.x;
import uc.r;
import uc.s;
import vc.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {
    public static final b Companion = new b();

    /* renamed from: a, reason: collision with root package name */
    public final String f10817a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10818b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10819c;

    /* renamed from: d, reason: collision with root package name */
    public final r f10820d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a implements x<g> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10821a;
        private static final rc.e descriptor;

        static {
            a aVar = new a();
            f10821a = aVar;
            r0 r0Var = new r0("com.stepos.common.utils.filestorage.models.UploadBinding", aVar, 4);
            r0Var.k("bizRefType", false);
            r0Var.k("bizRefId", false);
            r0Var.k("bindingRole", false);
            r0Var.k("metadata", true);
            descriptor = r0Var;
        }

        @Override // pc.c
        public final void a(k kVar, Object obj) {
            g value = (g) obj;
            kotlin.jvm.internal.g.f(value, "value");
            rc.e eVar = descriptor;
            sc.c cVarB = kVar.b(eVar);
            String str = value.f10817a;
            r rVar = value.f10820d;
            cVarB.u(eVar, 0, str);
            cVarB.u(eVar, 1, value.f10818b);
            cVarB.u(eVar, 2, value.f10819c);
            if (cVarB.x(eVar) || rVar != null) {
                cVarB.e(eVar, 3, s.f13222a, rVar);
            }
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
            r rVar = null;
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
                } else {
                    if (iF != 3) {
                        throw new UnknownFieldException(iF);
                    }
                    rVar = (r) bVarB.r(eVar, 3, s.f13222a, rVar);
                    i10 |= 8;
                }
            }
            bVarB.a(eVar);
            return new g(i10, strQ, strQ2, strQ3, rVar);
        }

        @Override // tc.x
        public final pc.a<?>[] c() {
            pc.a<?> aVarA = qc.a.a(s.f13222a);
            b1 b1Var = b1.f12964a;
            return new pc.a[]{b1Var, b1Var, b1Var, aVarA};
        }

        @Override // pc.c
        public final rc.e d() {
            return descriptor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        public final pc.a<g> serializer() {
            return a.f10821a;
        }
    }

    public /* synthetic */ g(int i10, String str, String str2, String str3, r rVar) {
        if (7 != (i10 & 7)) {
            y.P(i10, 7, a.f10821a.d());
            throw null;
        }
        this.f10817a = str;
        this.f10818b = str2;
        this.f10819c = str3;
        if ((i10 & 8) == 0) {
            this.f10820d = null;
        } else {
            this.f10820d = rVar;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.g.b(this.f10817a, gVar.f10817a) && kotlin.jvm.internal.g.b(this.f10818b, gVar.f10818b) && kotlin.jvm.internal.g.b(this.f10819c, gVar.f10819c) && kotlin.jvm.internal.g.b(this.f10820d, gVar.f10820d);
    }

    public final int hashCode() {
        int iA = v1.d.a(v1.d.a(this.f10817a.hashCode() * 31, 31, this.f10818b), 31, this.f10819c);
        r rVar = this.f10820d;
        return iA + (rVar == null ? 0 : rVar.f13221a.hashCode());
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("UploadBinding(bizRefType=", this.f10817a, ", bizRefId=", this.f10818b, ", bindingRole=");
        sbS.append(this.f10819c);
        sbS.append(", metadata=");
        sbS.append(this.f10820d);
        sbS.append(")");
        return sbS.toString();
    }
}
