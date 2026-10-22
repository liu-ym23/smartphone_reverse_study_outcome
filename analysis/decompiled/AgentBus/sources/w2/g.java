package w2;

import a4.u;
import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.m;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import androidx.datastore.preferences.protobuf.y;
import d7.r;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import ob.b0;
import ob.c0;
import ob.d0;
import ob.e0;
import q7.k;
import v2.h;
import v2.i;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f10656a = new g();

    public final b a(e0 e0Var) throws s2.b {
        byte[] bArr;
        try {
            v2.e eVarO = v2.e.o(new d0(e0Var));
            b bVar = new b(false);
            e[] eVarArr = (e[]) Arrays.copyOf(new e[0], 0);
            k.e(eVarArr, "pairs");
            bVar.b();
            if (eVarArr.length > 0) {
                e eVar = eVarArr[0];
                throw null;
            }
            Map mapM = eVarO.m();
            k.d(mapM, "preferencesProto.preferencesMap");
            for (Map.Entry entry : mapM.entrySet()) {
                String str = (String) entry.getKey();
                i iVar = (i) entry.getValue();
                k.d(str, "name");
                k.d(iVar, "value");
                int iC = iVar.C();
                switch (iC == 0 ? -1 : f.$EnumSwitchMapping$0[n.f.d(iC)]) {
                    case -1:
                        throw new s2.b("Value case is null.", null);
                    case 0:
                    default:
                        throw new u();
                    case 1:
                        bVar.c(new d(str), Boolean.valueOf(iVar.t()));
                        break;
                    case 2:
                        bVar.c(new d(str), Float.valueOf(iVar.x()));
                        break;
                    case 3:
                        bVar.c(new d(str), Double.valueOf(iVar.w()));
                        break;
                    case 4:
                        bVar.c(new d(str), Integer.valueOf(iVar.y()));
                        break;
                    case 5:
                        bVar.c(new d(str), Long.valueOf(iVar.z()));
                        break;
                    case 6:
                        d dVar = new d(str);
                        String strA = iVar.A();
                        k.d(strA, "value.string");
                        bVar.c(dVar, strA);
                        break;
                    case 7:
                        d dVar2 = new d(str);
                        x xVarN = iVar.B().n();
                        k.d(xVarN, "value.stringSet.stringsList");
                        bVar.c(dVar2, r.q1(xVarN));
                        break;
                    case 8:
                        d dVar3 = new d(str);
                        androidx.datastore.preferences.protobuf.g gVarU = iVar.u();
                        int size = gVarU.size();
                        if (size == 0) {
                            bArr = y.f969b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            gVarU.i(size, bArr2);
                            bArr = bArr2;
                        }
                        k.d(bArr, "value.bytes.toByteArray()");
                        bVar.c(dVar3, bArr);
                        break;
                    case 9:
                        throw new s2.b("Value not set.", null);
                }
            }
            return new b(d7.e0.b0(bVar.a()), true);
        } catch (a0 e10) {
            throw new s2.b("Unable to parse preferences proto.", e10);
        }
    }

    public final void b(Object obj, c0 c0Var) throws IOException {
        w wVarA;
        Map mapA = ((b) obj).a();
        v2.c cVarN = v2.e.n();
        for (Map.Entry entry : mapA.entrySet()) {
            d dVar = (d) entry.getKey();
            Object value = entry.getValue();
            String str = dVar.f10655a;
            if (value instanceof Boolean) {
                h hVarD = i.D();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                hVarD.c();
                i.q((i) hVarD.f960g, zBooleanValue);
                wVarA = hVarD.a();
            } else if (value instanceof Float) {
                h hVarD2 = i.D();
                float fFloatValue = ((Number) value).floatValue();
                hVarD2.c();
                i.r((i) hVarD2.f960g, fFloatValue);
                wVarA = hVarD2.a();
            } else if (value instanceof Double) {
                h hVarD3 = i.D();
                double dDoubleValue = ((Number) value).doubleValue();
                hVarD3.c();
                i.o((i) hVarD3.f960g, dDoubleValue);
                wVarA = hVarD3.a();
            } else if (value instanceof Integer) {
                h hVarD4 = i.D();
                int iIntValue = ((Number) value).intValue();
                hVarD4.c();
                i.s((i) hVarD4.f960g, iIntValue);
                wVarA = hVarD4.a();
            } else if (value instanceof Long) {
                h hVarD5 = i.D();
                long jLongValue = ((Number) value).longValue();
                hVarD5.c();
                i.l((i) hVarD5.f960g, jLongValue);
                wVarA = hVarD5.a();
            } else if (value instanceof String) {
                h hVarD6 = i.D();
                hVarD6.c();
                i.m((i) hVarD6.f960g, (String) value);
                wVarA = hVarD6.a();
            } else if (value instanceof Set) {
                h hVarD7 = i.D();
                v2.f fVarO = v2.g.o();
                fVarO.c();
                v2.g.l((v2.g) fVarO.f960g, (Set) value);
                hVarD7.c();
                i.n((i) hVarD7.f960g, (v2.g) fVarO.a());
                wVarA = hVarD7.a();
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                }
                h hVarD8 = i.D();
                byte[] bArr = (byte[]) value;
                androidx.datastore.preferences.protobuf.g gVarH = androidx.datastore.preferences.protobuf.g.h(bArr, 0, bArr.length);
                hVarD8.c();
                i.p((i) hVarD8.f960g, gVarH);
                wVarA = hVarD8.a();
            }
            cVarN.getClass();
            str.getClass();
            cVarN.c();
            v2.e.l((v2.e) cVarN.f960g).put(str, (i) wVarA);
        }
        v2.e eVar = (v2.e) cVarN.a();
        b0 b0Var = new b0(c0Var);
        int iA = eVar.a(null);
        Logger logger = m.f901h;
        if (iA > 4096) {
            iA = 4096;
        }
        m mVar = new m(b0Var, iA);
        eVar.b(mVar);
        if (mVar.f906f > 0) {
            mVar.v();
        }
    }
}
