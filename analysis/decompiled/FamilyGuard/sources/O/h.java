package O;

import L.k;
import N.f;
import N.h;
import O.d;
import V3.l;
import V3.v;
import W3.C0403n;
import com.stepos.minor.Minor;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements k<d> {

    /* renamed from: a, reason: collision with root package name */
    public static final h f4291a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final String f4292b = "preferences_pb";

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4293a;

        static {
            int[] iArr = new int[h.b.values().length];
            iArr[h.b.BOOLEAN.ordinal()] = 1;
            iArr[h.b.FLOAT.ordinal()] = 2;
            iArr[h.b.DOUBLE.ordinal()] = 3;
            iArr[h.b.INTEGER.ordinal()] = 4;
            iArr[h.b.LONG.ordinal()] = 5;
            iArr[h.b.STRING.ordinal()] = 6;
            iArr[h.b.STRING_SET.ordinal()] = 7;
            iArr[h.b.VALUE_NOT_SET.ordinal()] = 8;
            f4293a = iArr;
        }
    }

    private h() {
    }

    private final void d(String str, N.h hVar, O.a aVar) throws L.a {
        h.b bVarA0 = hVar.a0();
        switch (bVarA0 == null ? -1 : a.f4293a[bVarA0.ordinal()]) {
            case -1:
                throw new L.a("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new l();
            case 1:
                aVar.i(f.a(str), Boolean.valueOf(hVar.S()));
                return;
            case 2:
                aVar.i(f.c(str), Float.valueOf(hVar.V()));
                return;
            case 3:
                aVar.i(f.b(str), Double.valueOf(hVar.U()));
                return;
            case 4:
                aVar.i(f.d(str), Integer.valueOf(hVar.W()));
                return;
            case 5:
                aVar.i(f.e(str), Long.valueOf(hVar.X()));
                return;
            case 6:
                d.a<String> aVarF = f.f(str);
                String strY = hVar.Y();
                j4.k.f(strY, "value.string");
                aVar.i(aVarF, strY);
                return;
            case 7:
                d.a<Set<String>> aVarG = f.g(str);
                List<String> listP = hVar.Z().P();
                j4.k.f(listP, "value.stringSet.stringsList");
                aVar.i(aVarG, C0403n.X(listP));
                return;
            case 8:
                throw new L.a("Value not set.", null, 2, null);
        }
    }

    private final N.h g(Object obj) {
        if (obj instanceof Boolean) {
            N.h hVarBuild = N.h.b0().B(((Boolean) obj).booleanValue()).build();
            j4.k.f(hVarBuild, "newBuilder().setBoolean(value).build()");
            return hVarBuild;
        }
        if (obj instanceof Float) {
            N.h hVarBuild2 = N.h.b0().D(((Number) obj).floatValue()).build();
            j4.k.f(hVarBuild2, "newBuilder().setFloat(value).build()");
            return hVarBuild2;
        }
        if (obj instanceof Double) {
            N.h hVarBuild3 = N.h.b0().C(((Number) obj).doubleValue()).build();
            j4.k.f(hVarBuild3, "newBuilder().setDouble(value).build()");
            return hVarBuild3;
        }
        if (obj instanceof Integer) {
            N.h hVarBuild4 = N.h.b0().E(((Number) obj).intValue()).build();
            j4.k.f(hVarBuild4, "newBuilder().setInteger(value).build()");
            return hVarBuild4;
        }
        if (obj instanceof Long) {
            N.h hVarBuild5 = N.h.b0().F(((Number) obj).longValue()).build();
            j4.k.f(hVarBuild5, "newBuilder().setLong(value).build()");
            return hVarBuild5;
        }
        if (obj instanceof String) {
            N.h hVarBuild6 = N.h.b0().G((String) obj).build();
            j4.k.f(hVarBuild6, "newBuilder().setString(value).build()");
            return hVarBuild6;
        }
        if (!(obj instanceof Set)) {
            throw new IllegalStateException(j4.k.m("PreferencesSerializer does not support type: ", obj.getClass().getName()));
        }
        N.h hVarBuild7 = N.h.b0().H(N.g.Q().B((Set) obj)).build();
        j4.k.f(hVarBuild7, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
        return hVarBuild7;
    }

    @Override // L.k
    public Object b(InputStream inputStream, Z3.e<? super d> eVar) throws L.a {
        N.f fVarA = N.d.f4170a.a(inputStream);
        O.a aVarB = e.b(new d.b[0]);
        Map<String, N.h> mapN = fVarA.N();
        j4.k.f(mapN, "preferencesProto.preferencesMap");
        for (Map.Entry<String, N.h> entry : mapN.entrySet()) {
            String key = entry.getKey();
            N.h value = entry.getValue();
            h hVar = f4291a;
            j4.k.f(key, Minor.COLUMN_NAME);
            j4.k.f(value, "value");
            hVar.d(key, value, aVarB);
        }
        return aVarB.d();
    }

    @Override // L.k
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public d a() {
        return e.a();
    }

    public final String f() {
        return f4292b;
    }

    @Override // L.k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object c(d dVar, OutputStream outputStream, Z3.e<? super v> eVar) {
        Map<d.a<?>, Object> mapA = dVar.a();
        f.a aVarQ = N.f.Q();
        for (Map.Entry<d.a<?>, Object> entry : mapA.entrySet()) {
            aVarQ.B(entry.getKey().a(), g(entry.getValue()));
        }
        aVarQ.build().p(outputStream);
        return v.f5542a;
    }
}
