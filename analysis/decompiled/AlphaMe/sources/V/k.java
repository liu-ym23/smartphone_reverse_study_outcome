package V;

import S.C0095a;
import S.InterfaceC0106l;
import S.r;
import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0268o;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.C0267n;
import androidx.datastore.preferences.protobuf.F;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class k implements InterfaceC0106l {

    /* renamed from: a, reason: collision with root package name */
    public static final k f1927a = new k();

    public final b a(FileInputStream input) throws C0095a {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            U.f fVarL = U.f.l(input);
            Intrinsics.checkNotNullExpressionValue(fVarL, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
            g[] pairs = new g[0];
            Intrinsics.checkNotNullParameter(pairs, "pairs");
            b bVar = new b(false);
            g[] pairs2 = (g[]) Arrays.copyOf(pairs, 0);
            Intrinsics.checkNotNullParameter(pairs2, "pairs");
            bVar.c();
            if (pairs2.length > 0) {
                g gVar = pairs2[0];
                throw null;
            }
            Map mapJ = fVarL.j();
            Intrinsics.checkNotNullExpressionValue(mapJ, "preferencesProto.preferencesMap");
            for (Map.Entry entry : mapJ.entrySet()) {
                String name = (String) entry.getKey();
                U.j value = (U.j) entry.getValue();
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                int iX = value.x();
                switch (iX == 0 ? -1 : j.$EnumSwitchMapping$0[t.h.a(iX)]) {
                    case -1:
                        throw new C0095a("Value case is null.");
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 1:
                        f key = com.airbnb.lottie.h.e(name);
                        Boolean boolValueOf = Boolean.valueOf(value.p());
                        Intrinsics.checkNotNullParameter(key, "key");
                        bVar.d(key, boolValueOf);
                        break;
                    case 2:
                        f key2 = com.airbnb.lottie.h.o(name);
                        Float fValueOf = Float.valueOf(value.s());
                        Intrinsics.checkNotNullParameter(key2, "key");
                        bVar.d(key2, fValueOf);
                        break;
                    case 3:
                        f key3 = com.airbnb.lottie.h.l(name);
                        Double dValueOf = Double.valueOf(value.r());
                        Intrinsics.checkNotNullParameter(key3, "key");
                        bVar.d(key3, dValueOf);
                        break;
                    case 4:
                        f key4 = com.airbnb.lottie.h.s(name);
                        Integer numValueOf = Integer.valueOf(value.t());
                        Intrinsics.checkNotNullParameter(key4, "key");
                        bVar.d(key4, numValueOf);
                        break;
                    case 5:
                        f key5 = com.airbnb.lottie.h.x(name);
                        Long lValueOf = Long.valueOf(value.u());
                        Intrinsics.checkNotNullParameter(key5, "key");
                        bVar.d(key5, lValueOf);
                        break;
                    case 6:
                        f key6 = com.airbnb.lottie.h.I(name);
                        String strV = value.v();
                        Intrinsics.checkNotNullExpressionValue(strV, "value.string");
                        Intrinsics.checkNotNullParameter(key6, "key");
                        bVar.d(key6, strV);
                        break;
                    case 7:
                        Intrinsics.checkNotNullParameter(name, "name");
                        f key7 = new f(name);
                        C cK = value.w().k();
                        Intrinsics.checkNotNullExpressionValue(cK, "value.stringSet.stringsList");
                        Set set = CollectionsKt.toSet(cK);
                        Intrinsics.checkNotNullParameter(key7, "key");
                        bVar.d(key7, set);
                        break;
                    case 8:
                        throw new C0095a("Value not set.");
                }
            }
            return new b(MapsKt.toMutableMap(bVar.a()), true);
        } catch (F e4) {
            Intrinsics.checkNotNullParameter("Unable to parse preferences proto.", "message");
            throw new C0095a("Unable to parse preferences proto.", e4);
        }
    }

    public final Unit b(Object obj, r rVar) {
        A a4;
        Map mapA = ((h) obj).a();
        U.d dVarK = U.f.k();
        for (Map.Entry entry : mapA.entrySet()) {
            f fVar = (f) entry.getKey();
            Object value = entry.getValue();
            String str = fVar.f1923a;
            if (value instanceof Boolean) {
                U.i iVarY = U.j.y();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                iVarY.c();
                U.j.m((U.j) iVarY.f3552b, zBooleanValue);
                a4 = iVarY.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setBoolean(value).build()");
            } else if (value instanceof Float) {
                U.i iVarY2 = U.j.y();
                float fFloatValue = ((Number) value).floatValue();
                iVarY2.c();
                U.j.n((U.j) iVarY2.f3552b, fFloatValue);
                a4 = iVarY2.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setFloat(value).build()");
            } else if (value instanceof Double) {
                U.i iVarY3 = U.j.y();
                double dDoubleValue = ((Number) value).doubleValue();
                iVarY3.c();
                U.j.l((U.j) iVarY3.f3552b, dDoubleValue);
                a4 = iVarY3.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setDouble(value).build()");
            } else if (value instanceof Integer) {
                U.i iVarY4 = U.j.y();
                int iIntValue = ((Number) value).intValue();
                iVarY4.c();
                U.j.o((U.j) iVarY4.f3552b, iIntValue);
                a4 = iVarY4.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setInteger(value).build()");
            } else if (value instanceof Long) {
                U.i iVarY5 = U.j.y();
                long jLongValue = ((Number) value).longValue();
                iVarY5.c();
                U.j.i((U.j) iVarY5.f3552b, jLongValue);
                a4 = iVarY5.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setLong(value).build()");
            } else if (value instanceof String) {
                U.i iVarY6 = U.j.y();
                iVarY6.c();
                U.j.j((U.j) iVarY6.f3552b, (String) value);
                a4 = iVarY6.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setString(value).build()");
            } else {
                if (!(value instanceof Set)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("PreferencesSerializer does not support type: ", value.getClass().getName()));
                }
                U.i iVarY7 = U.j.y();
                U.g gVarL = U.h.l();
                gVarL.c();
                U.h.i((U.h) gVarL.f3552b, (Set) value);
                iVarY7.c();
                U.j.k((U.j) iVarY7.f3552b, gVarL);
                a4 = iVarY7.a();
                Intrinsics.checkNotNullExpressionValue(a4, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
            }
            dVarK.getClass();
            str.getClass();
            dVarK.c();
            U.f.i((U.f) dVarK.f3552b).put(str, (U.j) a4);
        }
        U.f fVar2 = (U.f) dVarK.a();
        int iA = fVar2.a();
        Logger logger = AbstractC0268o.f3518d;
        if (iA > 4096) {
            iA = 4096;
        }
        C0267n c0267n = new C0267n(rVar, iA);
        fVar2.c(c0267n);
        if (c0267n.f3513h > 0) {
            c0267n.h0();
        }
        return Unit.INSTANCE;
    }
}
