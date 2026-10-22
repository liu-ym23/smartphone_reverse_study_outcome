package y3;

import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import androidx.datastore.preferences.protobuf.z;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kb.l;
import t.o;
import x3.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {
    public static b a(FileInputStream fileInputStream) throws v3.b {
        byte[] bArr;
        try {
            x3.e eVarP = x3.e.p(fileInputStream);
            b bVar = new b(false);
            f[] fVarArr = (f[]) Arrays.copyOf(new f[0], 0);
            bVar.b();
            if (fVarArr.length > 0) {
                f fVar = fVarArr[0];
                throw null;
            }
            Map mapN = eVarP.n();
            mapN.getClass();
            for (Map.Entry entry : mapN.entrySet()) {
                String str = (String) entry.getKey();
                i iVar = (i) entry.getValue();
                str.getClass();
                iVar.getClass();
                int iD = iVar.D();
                switch (iD == 0 ? -1 : g.f15892a[s.f.c(iD)]) {
                    case -1:
                        throw new v3.b("Value case is null.", null);
                    case 0:
                    default:
                        g5.f.a();
                        return null;
                    case 1:
                        bVar.e(o.b(str), Boolean.valueOf(iVar.u()));
                        break;
                    case 2:
                        e eVar = new e();
                        eVar.f15891a = str;
                        VarHandle.storeStoreFence();
                        bVar.e(eVar, Float.valueOf(iVar.y()));
                        break;
                    case 3:
                        e eVar2 = new e();
                        eVar2.f15891a = str;
                        VarHandle.storeStoreFence();
                        bVar.e(eVar2, Double.valueOf(iVar.x()));
                        break;
                    case 4:
                        e eVar3 = new e();
                        eVar3.f15891a = str;
                        VarHandle.storeStoreFence();
                        bVar.e(eVar3, Integer.valueOf(iVar.z()));
                        break;
                    case 5:
                        bVar.e(o.k(str), Long.valueOf(iVar.A()));
                        break;
                    case 6:
                        e eVarN = o.n(str);
                        String strB = iVar.B();
                        strB.getClass();
                        bVar.e(eVarN, strB);
                        break;
                    case 7:
                        e eVar4 = new e();
                        eVar4.f15891a = str;
                        VarHandle.storeStoreFence();
                        w wVarO = iVar.C().o();
                        wVarO.getClass();
                        bVar.e(eVar4, l.O0(wVarO));
                        break;
                    case 8:
                        e eVar5 = new e();
                        eVar5.f15891a = str;
                        VarHandle.storeStoreFence();
                        androidx.datastore.preferences.protobuf.f fVarV = iVar.v();
                        int size = fVarV.size();
                        if (size == 0) {
                            bArr = x.f1219b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            fVarV.d(size, bArr2);
                            bArr = bArr2;
                        }
                        bArr.getClass();
                        bVar.e(eVar5, bArr);
                        break;
                    case 9:
                        throw new v3.b("Value not set.", null);
                }
            }
            return new b(new LinkedHashMap(bVar.a()), true);
        } catch (z e10) {
            throw new v3.b("Unable to parse preferences proto.", e10);
        }
    }

    public static void b(Object obj, od.h hVar) throws IOException {
        v vVarA;
        Map mapA = ((b) obj).a();
        x3.c cVarO = x3.e.o();
        for (Map.Entry entry : mapA.entrySet()) {
            e eVar = (e) entry.getKey();
            Object value = entry.getValue();
            String str = eVar.f15891a;
            if (value instanceof Boolean) {
                x3.h hVarE = i.E();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                hVarE.c();
                i.r((i) hVarE.f1206f, zBooleanValue);
                vVarA = hVarE.a();
            } else if (value instanceof Float) {
                x3.h hVarE2 = i.E();
                float fFloatValue = ((Number) value).floatValue();
                hVarE2.c();
                i.s((i) hVarE2.f1206f, fFloatValue);
                vVarA = hVarE2.a();
            } else if (value instanceof Double) {
                x3.h hVarE3 = i.E();
                double dDoubleValue = ((Number) value).doubleValue();
                hVarE3.c();
                i.p((i) hVarE3.f1206f, dDoubleValue);
                vVarA = hVarE3.a();
            } else if (value instanceof Integer) {
                x3.h hVarE4 = i.E();
                int iIntValue = ((Number) value).intValue();
                hVarE4.c();
                i.t((i) hVarE4.f1206f, iIntValue);
                vVarA = hVarE4.a();
            } else if (value instanceof Long) {
                x3.h hVarE5 = i.E();
                long jLongValue = ((Number) value).longValue();
                hVarE5.c();
                i.m((i) hVarE5.f1206f, jLongValue);
                vVarA = hVarE5.a();
            } else if (value instanceof String) {
                x3.h hVarE6 = i.E();
                hVarE6.c();
                i.n((i) hVarE6.f1206f, (String) value);
                vVarA = hVarE6.a();
            } else if (value instanceof Set) {
                x3.h hVarE7 = i.E();
                x3.f fVarP = x3.g.p();
                fVarP.c();
                x3.g.m((x3.g) fVarP.f1206f, (Set) value);
                hVarE7.c();
                i.o((i) hVarE7.f1206f, (x3.g) fVarP.a());
                vVarA = hVarE7.a();
            } else {
                if (!(value instanceof byte[])) {
                    od.f.e("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                    return;
                }
                x3.h hVarE8 = i.E();
                byte[] bArr = (byte[]) value;
                androidx.datastore.preferences.protobuf.f fVarC = androidx.datastore.preferences.protobuf.f.c(0, bArr.length, bArr);
                hVarE8.c();
                i.q((i) hVarE8.f1206f, fVarC);
                vVarA = hVarE8.a();
            }
            cVarO.getClass();
            cVarO.c();
            x3.e.m((x3.e) cVarO.f1206f).put(str, (i) vVarA);
        }
        x3.e eVar2 = (x3.e) cVarO.a();
        int iA = eVar2.a(null);
        Logger logger = androidx.datastore.preferences.protobuf.l.f1148f;
        if (iA > 4096) {
            iA = 4096;
        }
        androidx.datastore.preferences.protobuf.l lVar = new androidx.datastore.preferences.protobuf.l();
        if (iA < 0) {
            g5.f.s("bufferSize must be >= 0");
            return;
        }
        int iMax = Math.max(iA, 20);
        lVar.f1151b = new byte[iMax];
        lVar.f1152c = iMax;
        lVar.f1154e = hVar;
        VarHandle.storeStoreFence();
        eVar2.b(lVar);
        if (lVar.f1153d > 0) {
            lVar.k();
        }
    }
}
