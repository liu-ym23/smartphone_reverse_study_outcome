package c9;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import z8.b0;
import z8.b1;
import z8.c1;
import z8.d0;
import z8.f0;
import z8.i0;
import z8.j0;
import z8.k0;
import z8.m;
import z8.n0;
import z8.p0;
import z8.q;
import z8.r0;
import z8.s;
import z8.u0;
import z8.v;
import z8.v0;
import z8.x;

/* loaded from: classes.dex */
public final class a extends f9.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2087a;

    public /* synthetic */ a(int i2) {
        this.f2087a = i2;
    }

    @Override // f9.w
    public final Object a(f9.e eVar, f9.h hVar) {
        switch (this.f2087a) {
            case 0:
                return new c(eVar);
            case 1:
                return new d(eVar);
            case 2:
                return new f(eVar, hVar);
            case 3:
                return new k(eVar, hVar);
            case 4:
                return new j(eVar);
            case 5:
                return new z8.f(eVar, hVar);
            case 6:
                return new z8.d(eVar, hVar);
            case 7:
                return new z8.c(eVar, hVar);
            case 8:
                return new z8.i(eVar, hVar);
            case 9:
                return new z8.k(eVar, hVar);
            case 10:
                return new m(eVar, hVar);
            case 11:
                return new q(eVar, hVar);
            case 12:
                return new s(eVar, hVar);
            case 13:
                return new v(eVar, hVar);
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return new x(eVar, hVar);
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return new b0(eVar, hVar);
            case 16:
                return new d0(eVar, hVar);
            case 17:
                return new f0(eVar, hVar);
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                return new j0(eVar, hVar);
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                return new i0(eVar);
            case 20:
                return new k0(eVar);
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                return new p0(eVar, hVar);
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                return new n0(eVar, hVar);
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                return new r0(eVar, hVar);
            case 24:
                return new u0(eVar, hVar);
            case 25:
                return new v0(eVar, hVar);
            case 26:
                return new z8.x0(eVar, hVar);
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return new b1(eVar);
            default:
                return new c1(eVar, hVar);
        }
    }
}
