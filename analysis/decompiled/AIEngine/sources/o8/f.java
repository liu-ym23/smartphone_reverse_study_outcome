package o8;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import kotlinx.serialization.UnknownFieldException;
import mb.y;
import tc.b1;
import tc.i0;
import tc.r0;
import tc.x;
import vc.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {
    public static final b Companion = new b();

    /* renamed from: a, reason: collision with root package name */
    public final String f10803a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10804b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f10805c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10806d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10807e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10808f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10809g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10810i;

    /* renamed from: j, reason: collision with root package name */
    public final String f10811j;

    /* renamed from: k, reason: collision with root package name */
    public final String f10812k;

    /* renamed from: l, reason: collision with root package name */
    public final String f10813l;

    /* renamed from: m, reason: collision with root package name */
    public final String f10814m;

    /* renamed from: n, reason: collision with root package name */
    public final Boolean f10815n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a implements x<f> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10816a;
        private static final rc.e descriptor;

        static {
            a aVar = new a();
            f10816a = aVar;
            r0 r0Var = new r0("com.stepos.common.utils.filestorage.models.TosCallbackBody", aVar, 14);
            r0Var.k("Status", false);
            r0Var.k("fileId", true);
            r0Var.k("fileSize", true);
            r0Var.k("downloadUrl", true);
            r0Var.k("code", true);
            r0Var.k("message", true);
            r0Var.k("auditStatus", true);
            r0Var.k("auditDecision", true);
            r0Var.k("auditRiskLevel", true);
            r0Var.k("auditSuggestText", true);
            r0Var.k("sensitiveStatus", true);
            r0Var.k("sensitiveDecision", true);
            r0Var.k("sensitiveLevel", true);
            r0Var.k("detectPassed", true);
            descriptor = r0Var;
        }

        @Override // pc.c
        public final void a(k kVar, Object obj) {
            f value = (f) obj;
            kotlin.jvm.internal.g.f(value, "value");
            Boolean bool = value.f10815n;
            String str = value.f10814m;
            rc.e eVar = descriptor;
            sc.c cVarB = kVar.b(eVar);
            String str2 = value.f10803a;
            String str3 = value.f10813l;
            String str4 = value.f10812k;
            String str5 = value.f10811j;
            String str6 = value.f10810i;
            String str7 = value.h;
            String str8 = value.f10809g;
            String str9 = value.f10808f;
            String str10 = value.f10807e;
            String str11 = value.f10806d;
            Long l10 = value.f10805c;
            String str12 = value.f10804b;
            cVarB.u(eVar, 0, str2);
            if (cVarB.x(eVar) || str12 != null) {
                cVarB.e(eVar, 1, b1.f12964a, str12);
            }
            if (cVarB.x(eVar) || l10 != null) {
                cVarB.e(eVar, 2, i0.f12992a, l10);
            }
            if (cVarB.x(eVar) || str11 != null) {
                cVarB.e(eVar, 3, b1.f12964a, str11);
            }
            if (cVarB.x(eVar) || str10 != null) {
                cVarB.e(eVar, 4, b1.f12964a, str10);
            }
            if (cVarB.x(eVar) || str9 != null) {
                cVarB.e(eVar, 5, b1.f12964a, str9);
            }
            if (cVarB.x(eVar) || str8 != null) {
                cVarB.e(eVar, 6, b1.f12964a, str8);
            }
            if (cVarB.x(eVar) || str7 != null) {
                cVarB.e(eVar, 7, b1.f12964a, str7);
            }
            if (cVarB.x(eVar) || str6 != null) {
                cVarB.e(eVar, 8, b1.f12964a, str6);
            }
            if (cVarB.x(eVar) || str5 != null) {
                cVarB.e(eVar, 9, b1.f12964a, str5);
            }
            if (cVarB.x(eVar) || str4 != null) {
                cVarB.e(eVar, 10, b1.f12964a, str4);
            }
            if (cVarB.x(eVar) || str3 != null) {
                cVarB.e(eVar, 11, b1.f12964a, str3);
            }
            if (cVarB.x(eVar) || str != null) {
                cVarB.e(eVar, 12, b1.f12964a, str);
            }
            if (cVarB.x(eVar) || bool != null) {
                cVarB.e(eVar, 13, tc.g.f12981a, bool);
            }
            cVarB.a(eVar);
        }

        @Override // pc.a
        public final Object b(sc.d dVar) {
            Long l10;
            Boolean bool;
            Long l11;
            rc.e eVar = descriptor;
            sc.b bVarB = dVar.b(eVar);
            String str = null;
            Boolean bool2 = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            Long l12 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String strQ = null;
            int i10 = 0;
            boolean z = true;
            while (z) {
                String str12 = str5;
                int iF = bVarB.f(eVar);
                switch (iF) {
                    case -1:
                        l10 = l12;
                        z = false;
                        str5 = str12;
                        l12 = l10;
                    case 0:
                        bool = bool2;
                        l11 = l12;
                        strQ = bVarB.q(eVar, 0);
                        i10 |= 1;
                        str5 = str12;
                        l12 = l11;
                        bool2 = bool;
                    case 1:
                        bool = bool2;
                        l11 = l12;
                        str5 = (String) bVarB.r(eVar, 1, b1.f12964a, str12);
                        i10 |= 2;
                        l12 = l11;
                        bool2 = bool;
                    case 2:
                        bool = bool2;
                        l12 = (Long) bVarB.r(eVar, 2, i0.f12992a, l12);
                        i10 |= 4;
                        str5 = str12;
                        bool2 = bool;
                    case 3:
                        l10 = l12;
                        str6 = (String) bVarB.r(eVar, 3, b1.f12964a, str6);
                        i10 |= 8;
                        str5 = str12;
                        l12 = l10;
                    case 4:
                        l10 = l12;
                        str7 = (String) bVarB.r(eVar, 4, b1.f12964a, str7);
                        i10 |= 16;
                        str5 = str12;
                        l12 = l10;
                    case 5:
                        l10 = l12;
                        str8 = (String) bVarB.r(eVar, 5, b1.f12964a, str8);
                        i10 |= 32;
                        str5 = str12;
                        l12 = l10;
                    case 6:
                        l10 = l12;
                        str9 = (String) bVarB.r(eVar, 6, b1.f12964a, str9);
                        i10 |= 64;
                        str5 = str12;
                        l12 = l10;
                    case 7:
                        l10 = l12;
                        str10 = (String) bVarB.r(eVar, 7, b1.f12964a, str10);
                        i10 |= TraceIdKeys.MAX_LENGTH;
                        str5 = str12;
                        l12 = l10;
                    case 8:
                        l10 = l12;
                        str11 = (String) bVarB.r(eVar, 8, b1.f12964a, str11);
                        i10 |= 256;
                        str5 = str12;
                        l12 = l10;
                    case 9:
                        l10 = l12;
                        str = (String) bVarB.r(eVar, 9, b1.f12964a, str);
                        i10 |= VadSessionManager.FRAME_BYTES;
                        str5 = str12;
                        l12 = l10;
                    case 10:
                        l10 = l12;
                        str3 = (String) bVarB.r(eVar, 10, b1.f12964a, str3);
                        i10 |= 1024;
                        str5 = str12;
                        l12 = l10;
                    case 11:
                        l10 = l12;
                        str4 = (String) bVarB.r(eVar, 11, b1.f12964a, str4);
                        i10 |= 2048;
                        str5 = str12;
                        l12 = l10;
                    case 12:
                        l10 = l12;
                        str2 = (String) bVarB.r(eVar, 12, b1.f12964a, str2);
                        i10 |= 4096;
                        str5 = str12;
                        l12 = l10;
                    case 13:
                        l10 = l12;
                        bool2 = (Boolean) bVarB.r(eVar, 13, tc.g.f12981a, bool2);
                        i10 |= PcmDumpBudget.HARD_MAX_DIR_MB;
                        str5 = str12;
                        l12 = l10;
                    default:
                        throw new UnknownFieldException(iF);
                }
            }
            Long l13 = l12;
            bVarB.a(eVar);
            return new f(i10, strQ, str5, l13, str6, str7, str8, str9, str10, str11, str, str3, str4, str2, bool2);
        }

        @Override // tc.x
        public final pc.a<?>[] c() {
            b1 b1Var = b1.f12964a;
            return new pc.a[]{b1Var, qc.a.a(b1Var), qc.a.a(i0.f12992a), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(b1Var), qc.a.a(tc.g.f12981a)};
        }

        @Override // pc.c
        public final rc.e d() {
            return descriptor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        public final pc.a<f> serializer() {
            return a.f10816a;
        }
    }

    public /* synthetic */ f(int i10, String str, String str2, Long l10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool) {
        if (1 != (i10 & 1)) {
            y.P(i10, 1, a.f10816a.d());
            throw null;
        }
        this.f10803a = str;
        if ((i10 & 2) == 0) {
            this.f10804b = null;
        } else {
            this.f10804b = str2;
        }
        if ((i10 & 4) == 0) {
            this.f10805c = null;
        } else {
            this.f10805c = l10;
        }
        if ((i10 & 8) == 0) {
            this.f10806d = null;
        } else {
            this.f10806d = str3;
        }
        if ((i10 & 16) == 0) {
            this.f10807e = null;
        } else {
            this.f10807e = str4;
        }
        if ((i10 & 32) == 0) {
            this.f10808f = null;
        } else {
            this.f10808f = str5;
        }
        if ((i10 & 64) == 0) {
            this.f10809g = null;
        } else {
            this.f10809g = str6;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) == 0) {
            this.h = null;
        } else {
            this.h = str7;
        }
        if ((i10 & 256) == 0) {
            this.f10810i = null;
        } else {
            this.f10810i = str8;
        }
        if ((i10 & VadSessionManager.FRAME_BYTES) == 0) {
            this.f10811j = null;
        } else {
            this.f10811j = str9;
        }
        if ((i10 & 1024) == 0) {
            this.f10812k = null;
        } else {
            this.f10812k = str10;
        }
        if ((i10 & 2048) == 0) {
            this.f10813l = null;
        } else {
            this.f10813l = str11;
        }
        if ((i10 & 4096) == 0) {
            this.f10814m = null;
        } else {
            this.f10814m = str12;
        }
        if ((i10 & PcmDumpBudget.HARD_MAX_DIR_MB) == 0) {
            this.f10815n = null;
        } else {
            this.f10815n = bool;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.g.b(this.f10803a, fVar.f10803a) && kotlin.jvm.internal.g.b(this.f10804b, fVar.f10804b) && kotlin.jvm.internal.g.b(this.f10805c, fVar.f10805c) && kotlin.jvm.internal.g.b(this.f10806d, fVar.f10806d) && kotlin.jvm.internal.g.b(this.f10807e, fVar.f10807e) && kotlin.jvm.internal.g.b(this.f10808f, fVar.f10808f) && kotlin.jvm.internal.g.b(this.f10809g, fVar.f10809g) && kotlin.jvm.internal.g.b(this.h, fVar.h) && kotlin.jvm.internal.g.b(this.f10810i, fVar.f10810i) && kotlin.jvm.internal.g.b(this.f10811j, fVar.f10811j) && kotlin.jvm.internal.g.b(this.f10812k, fVar.f10812k) && kotlin.jvm.internal.g.b(this.f10813l, fVar.f10813l) && kotlin.jvm.internal.g.b(this.f10814m, fVar.f10814m) && kotlin.jvm.internal.g.b(this.f10815n, fVar.f10815n);
    }

    public final int hashCode() {
        int iHashCode = this.f10803a.hashCode() * 31;
        String str = this.f10804b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.f10805c;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.f10806d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10807e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f10808f;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f10809g;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.h;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f10810i;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f10811j;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f10812k;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f10813l;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f10814m;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool = this.f10815n;
        return iHashCode13 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("TosCallbackBody(status=", this.f10803a, ", fileId=", this.f10804b, ", fileSize=");
        sbS.append(this.f10805c);
        sbS.append(", downloadUrl=");
        sbS.append(this.f10806d);
        sbS.append(", code=");
        ai.onnxruntime.a.z(sbS, this.f10807e, ", message=", this.f10808f, ", auditStatus=");
        ai.onnxruntime.a.z(sbS, this.f10809g, ", auditDecision=", this.h, ", auditRiskLevel=");
        ai.onnxruntime.a.z(sbS, this.f10810i, ", auditSuggestText=", this.f10811j, ", sensitiveStatus=");
        ai.onnxruntime.a.z(sbS, this.f10812k, ", sensitiveDecision=", this.f10813l, ", sensitiveLevel=");
        sbS.append(this.f10814m);
        sbS.append(", detectPassed=");
        sbS.append(this.f10815n);
        sbS.append(")");
        return sbS.toString();
    }

    public f() {
        this.f10803a = "OK";
        this.f10804b = null;
        this.f10805c = null;
        this.f10806d = null;
        this.f10807e = null;
        this.f10808f = null;
        this.f10809g = null;
        this.h = null;
        this.f10810i = null;
        this.f10811j = null;
        this.f10812k = null;
        this.f10813l = null;
        this.f10814m = null;
        this.f10815n = null;
    }
}
