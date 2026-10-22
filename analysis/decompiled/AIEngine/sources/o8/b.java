package o8;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlinx.serialization.UnknownFieldException;
import mb.y;
import o8.g;
import tc.b1;
import tc.c0;
import tc.i0;
import tc.r0;
import tc.x;
import vc.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static final C0118b Companion = new C0118b();
    public static final pc.a<Object>[] h = {null, null, null, null, null, null, new tc.d(g.a.f10821a)};

    /* renamed from: a, reason: collision with root package name */
    public final String f10782a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10783b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10784c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10785d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f10786e;

    /* renamed from: f, reason: collision with root package name */
    public final Integer f10787f;

    /* renamed from: g, reason: collision with root package name */
    public final List<g> f10788g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a implements x<b> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10789a;
        private static final rc.e descriptor;

        static {
            a aVar = new a();
            f10789a = aVar;
            r0 r0Var = new r0("com.stepos.common.utils.filestorage.models.CreateUploadSessionRequest", aVar, 7);
            r0Var.k("bizCode", false);
            r0Var.k("sourceType", false);
            r0Var.k("fileName", false);
            r0Var.k("contentType", false);
            r0Var.k("fileSize", true);
            r0Var.k("expiresSeconds", true);
            r0Var.k("bindings", true);
            descriptor = r0Var;
        }

        @Override // pc.c
        public final void a(k kVar, Object obj) {
            b value = (b) obj;
            kotlin.jvm.internal.g.f(value, "value");
            rc.e eVar = descriptor;
            sc.c cVarB = kVar.b(eVar);
            pc.a<Object>[] aVarArr = b.h;
            String str = value.f10782a;
            List<g> list = value.f10788g;
            Integer num = value.f10787f;
            Long l10 = value.f10786e;
            cVarB.u(eVar, 0, str);
            cVarB.u(eVar, 1, value.f10783b);
            cVarB.u(eVar, 2, value.f10784c);
            cVarB.u(eVar, 3, value.f10785d);
            if (cVarB.x(eVar) || l10 != null) {
                cVarB.e(eVar, 4, i0.f12992a, l10);
            }
            if (cVarB.x(eVar) || num != null) {
                cVarB.e(eVar, 5, c0.f12966a, num);
            }
            if (cVarB.x(eVar) || !kotlin.jvm.internal.g.b(list, EmptyList.f10001a)) {
                cVarB.g(eVar, 6, aVarArr[6], list);
            }
            cVarB.a(eVar);
        }

        @Override // pc.a
        public final Object b(sc.d dVar) {
            rc.e eVar = descriptor;
            sc.b bVarB = dVar.b(eVar);
            pc.a<Object>[] aVarArr = b.h;
            int i10 = 0;
            String strQ = null;
            String strQ2 = null;
            String strQ3 = null;
            String strQ4 = null;
            Long l10 = null;
            Integer num = null;
            List list = null;
            boolean z = true;
            while (z) {
                int iF = bVarB.f(eVar);
                switch (iF) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        strQ = bVarB.q(eVar, 0);
                        i10 |= 1;
                        break;
                    case 1:
                        strQ2 = bVarB.q(eVar, 1);
                        i10 |= 2;
                        break;
                    case 2:
                        strQ3 = bVarB.q(eVar, 2);
                        i10 |= 4;
                        break;
                    case 3:
                        strQ4 = bVarB.q(eVar, 3);
                        i10 |= 8;
                        break;
                    case 4:
                        l10 = (Long) bVarB.r(eVar, 4, i0.f12992a, l10);
                        i10 |= 16;
                        break;
                    case 5:
                        num = (Integer) bVarB.r(eVar, 5, c0.f12966a, num);
                        i10 |= 32;
                        break;
                    case 6:
                        list = (List) bVarB.c(eVar, 6, aVarArr[6], list);
                        i10 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iF);
                }
            }
            bVarB.a(eVar);
            return new b(i10, strQ, strQ2, strQ3, strQ4, l10, num, list);
        }

        @Override // tc.x
        public final pc.a<?>[] c() {
            pc.a<?>[] aVarArr = b.h;
            pc.a<?> aVarA = qc.a.a(i0.f12992a);
            pc.a<?> aVarA2 = qc.a.a(c0.f12966a);
            pc.a<?> aVar = aVarArr[6];
            b1 b1Var = b1.f12964a;
            return new pc.a[]{b1Var, b1Var, b1Var, b1Var, aVarA, aVarA2, aVar};
        }

        @Override // pc.c
        public final rc.e d() {
            return descriptor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: o8.b$b, reason: collision with other inner class name */
    public static final class C0118b {
        public final pc.a<b> serializer() {
            return a.f10789a;
        }
    }

    public b(int i10, String str, String str2, String str3, String str4, Long l10, Integer num, List list) {
        if (15 != (i10 & 15)) {
            y.P(i10, 15, a.f10789a.d());
            throw null;
        }
        this.f10782a = str;
        this.f10783b = str2;
        this.f10784c = str3;
        this.f10785d = str4;
        if ((i10 & 16) == 0) {
            this.f10786e = null;
        } else {
            this.f10786e = l10;
        }
        if ((i10 & 32) == 0) {
            this.f10787f = null;
        } else {
            this.f10787f = num;
        }
        if ((i10 & 64) == 0) {
            this.f10788g = EmptyList.f10001a;
        } else {
            this.f10788g = list;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.g.b(this.f10782a, bVar.f10782a) && kotlin.jvm.internal.g.b(this.f10783b, bVar.f10783b) && kotlin.jvm.internal.g.b(this.f10784c, bVar.f10784c) && kotlin.jvm.internal.g.b(this.f10785d, bVar.f10785d) && kotlin.jvm.internal.g.b(this.f10786e, bVar.f10786e) && kotlin.jvm.internal.g.b(this.f10787f, bVar.f10787f) && kotlin.jvm.internal.g.b(this.f10788g, bVar.f10788g);
    }

    public final int hashCode() {
        int iA = v1.d.a(v1.d.a(v1.d.a(this.f10782a.hashCode() * 31, 31, this.f10783b), 31, this.f10784c), 31, this.f10785d);
        Long l10 = this.f10786e;
        int iHashCode = (iA + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.f10787f;
        return this.f10788g.hashCode() + ((iHashCode + (num != null ? num.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("CreateUploadSessionRequest(bizCode=", this.f10782a, ", sourceType=", this.f10783b, ", fileName=");
        ai.onnxruntime.a.z(sbS, this.f10784c, ", contentType=", this.f10785d, ", fileSize=");
        sbS.append(this.f10786e);
        sbS.append(", expiresSeconds=");
        sbS.append(this.f10787f);
        sbS.append(", bindings=");
        sbS.append(this.f10788g);
        sbS.append(")");
        return sbS.toString();
    }

    public b(String bizCode, String sourceType, String fileName, String str, Long l10, List bindings) {
        kotlin.jvm.internal.g.f(bizCode, "bizCode");
        kotlin.jvm.internal.g.f(sourceType, "sourceType");
        kotlin.jvm.internal.g.f(fileName, "fileName");
        kotlin.jvm.internal.g.f(bindings, "bindings");
        this.f10782a = bizCode;
        this.f10783b = sourceType;
        this.f10784c = fileName;
        this.f10785d = str;
        this.f10786e = l10;
        this.f10787f = null;
        this.f10788g = bindings;
    }
}
