package m0;

import a6.w;
import androidx.datastore.preferences.protobuf.l;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.x;
import androidx.datastore.preferences.protobuf.z;
import c5.m;
import j0.x0;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.jvm.internal.p;
import l0.i;
import l0.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f3893a = new h();

    public final b a(FileInputStream fileInputStream) throws j0.b {
        byte[] bArr;
        try {
            l0.f fVarO = l0.f.o(fileInputStream);
            b bVar = new b(false);
            d[] pairs = (d[]) Arrays.copyOf(new d[0], 0);
            p.e(pairs, "pairs");
            bVar.c();
            if (pairs.length > 0) {
                d dVar = pairs[0];
                throw null;
            }
            Map mapM = fVarO.m();
            p.d(mapM, "preferencesProto.preferencesMap");
            for (Map.Entry entry : mapM.entrySet()) {
                String name = (String) entry.getKey();
                j value = (j) entry.getValue();
                p.d(name, "name");
                p.d(value, "value");
                int iC = value.C();
                switch (iC == 0 ? -1 : g.f3892a[m.f.a(iC)]) {
                    case -1:
                        throw new j0.b("Value case is null.", null);
                    case 0:
                    default:
                        throw new w();
                    case 1:
                        bVar.e(new c(name), Boolean.valueOf(value.t()));
                        break;
                    case 2:
                        bVar.e(new c(name), Float.valueOf(value.x()));
                        break;
                    case 3:
                        bVar.e(new c(name), Double.valueOf(value.w()));
                        break;
                    case 4:
                        bVar.e(new c(name), Integer.valueOf(value.y()));
                        break;
                    case 5:
                        bVar.e(new c(name), Long.valueOf(value.z()));
                        break;
                    case 6:
                        c cVar = new c(name);
                        String strA = value.A();
                        p.d(strA, "value.string");
                        bVar.e(cVar, strA);
                        break;
                    case 7:
                        c cVar2 = new c(name);
                        androidx.datastore.preferences.protobuf.w wVarN = value.B().n();
                        p.d(wVarN, "value.stringSet.stringsList");
                        bVar.e(cVar2, m.R0(wVarN));
                        break;
                    case 8:
                        c cVar3 = new c(name);
                        androidx.datastore.preferences.protobuf.g gVarU = value.u();
                        int size = gVarU.size();
                        if (size == 0) {
                            bArr = x.f580b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            gVarU.i(bArr2, size);
                            bArr = bArr2;
                        }
                        p.d(bArr, "value.bytes.toByteArray()");
                        bVar.e(cVar3, bArr);
                        break;
                    case 9:
                        throw new j0.b("Value not set.", null);
                }
            }
            return new b(new LinkedHashMap(bVar.a()), true);
        } catch (z e9) {
            throw new j0.b("Unable to parse preferences proto.", e9);
        }
    }

    public final void b(Object obj, x0 x0Var) throws IOException {
        v vVarA;
        Map mapA = ((e) obj).a();
        l0.d dVarN = l0.f.n();
        for (Map.Entry entry : mapA.entrySet()) {
            c cVar = (c) entry.getKey();
            Object value = entry.getValue();
            String str = cVar.f3891a;
            if (value instanceof Boolean) {
                i iVarD = j.D();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                iVarD.c();
                j.q((j) iVarD.f567b, zBooleanValue);
                vVarA = iVarD.a();
            } else if (value instanceof Float) {
                i iVarD2 = j.D();
                float fFloatValue = ((Number) value).floatValue();
                iVarD2.c();
                j.r((j) iVarD2.f567b, fFloatValue);
                vVarA = iVarD2.a();
            } else if (value instanceof Double) {
                i iVarD3 = j.D();
                double dDoubleValue = ((Number) value).doubleValue();
                iVarD3.c();
                j.o((j) iVarD3.f567b, dDoubleValue);
                vVarA = iVarD3.a();
            } else if (value instanceof Integer) {
                i iVarD4 = j.D();
                int iIntValue = ((Number) value).intValue();
                iVarD4.c();
                j.s((j) iVarD4.f567b, iIntValue);
                vVarA = iVarD4.a();
            } else if (value instanceof Long) {
                i iVarD5 = j.D();
                long jLongValue = ((Number) value).longValue();
                iVarD5.c();
                j.l((j) iVarD5.f567b, jLongValue);
                vVarA = iVarD5.a();
            } else if (value instanceof String) {
                i iVarD6 = j.D();
                iVarD6.c();
                j.m((j) iVarD6.f567b, (String) value);
                vVarA = iVarD6.a();
            } else if (value instanceof Set) {
                i iVarD7 = j.D();
                l0.g gVarO = l0.h.o();
                gVarO.c();
                l0.h.l((l0.h) gVarO.f567b, (Set) value);
                iVarD7.c();
                j.n((j) iVarD7.f567b, (l0.h) gVarO.a());
                vVarA = iVarD7.a();
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalStateException(f.b(value, "PreferencesSerializer does not support type: "));
                }
                i iVarD8 = j.D();
                byte[] bArr = (byte[]) value;
                androidx.datastore.preferences.protobuf.g gVarH = androidx.datastore.preferences.protobuf.g.h(0, bArr.length, bArr);
                iVarD8.c();
                j.p((j) iVarD8.f567b, gVarH);
                vVarA = iVarD8.a();
            }
            dVarN.getClass();
            dVarN.c();
            l0.f.l((l0.f) dVarN.f567b).put(str, (j) vVarA);
        }
        l0.f fVar = (l0.f) dVarN.a();
        int iA = fVar.a(null);
        Logger logger = l.f507f;
        if (iA > 4096) {
            iA = 4096;
        }
        l lVar = new l(x0Var, iA);
        fVar.b(lVar);
        if (lVar.d > 0) {
            lVar.t0();
        }
    }
}
