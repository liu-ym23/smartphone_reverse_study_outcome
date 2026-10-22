package g1;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.c;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.c;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.u;
import f1.a;
import g1.a;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f8948a = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8949a;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[6] = 3;
            iArr[2] = 4;
            iArr[3] = 5;
            iArr[4] = 6;
            iArr[5] = 7;
            iArr[7] = 8;
            f8949a = iArr;
        }
    }

    public final MutablePreferences a(FileInputStream fileInputStream) throws CorruptionException {
        try {
            f1.a aVarR = f1.a.r(fileInputStream);
            MutablePreferences mutablePreferences = new MutablePreferences(false, 1);
            a.b[] pairs = (a.b[]) Arrays.copyOf(new a.b[0], 0);
            g.f(pairs, "pairs");
            if (mutablePreferences.f1707b.get()) {
                throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
            }
            if (pairs.length > 0) {
                pairs[0].getClass();
                mutablePreferences.c(null, null);
                throw null;
            }
            Map<String, PreferencesProto$Value> mapP = aVarR.p();
            g.e(mapP, "preferencesProto.preferencesMap");
            for (Map.Entry<String, PreferencesProto$Value> entry : mapP.entrySet()) {
                String name = entry.getKey();
                PreferencesProto$Value value = entry.getValue();
                g.e(name, "name");
                g.e(value, "value");
                PreferencesProto$Value.ValueCase valueCaseD = value.D();
                switch (valueCaseD == null ? -1 : a.f8949a[valueCaseD.ordinal()]) {
                    case -1:
                        throw new CorruptionException("Value case is null.", null);
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 1:
                        mutablePreferences.c(new a.C0083a<>(name), Boolean.valueOf(value.v()));
                        break;
                    case 2:
                        mutablePreferences.c(new a.C0083a<>(name), Float.valueOf(value.y()));
                        break;
                    case 3:
                        mutablePreferences.c(new a.C0083a<>(name), Double.valueOf(value.x()));
                        break;
                    case 4:
                        mutablePreferences.c(new a.C0083a<>(name), Integer.valueOf(value.z()));
                        break;
                    case 5:
                        mutablePreferences.c(new a.C0083a<>(name), Long.valueOf(value.A()));
                        break;
                    case 6:
                        a.C0083a<?> c0083aV = a4.a.v(name);
                        String strB = value.B();
                        g.e(strB, "value.string");
                        mutablePreferences.c(c0083aV, strB);
                        break;
                    case 7:
                        a.C0083a<?> c0083a = new a.C0083a<>(name);
                        u.c cVarQ = value.C().q();
                        g.e(cVarQ, "value.stringSet.stringsList");
                        mutablePreferences.c(c0083a, kotlin.collections.a.R0(cVarQ));
                        break;
                    case 8:
                        throw new CorruptionException("Value not set.", null);
                }
            }
            return new MutablePreferences(kotlin.collections.b.o0(mutablePreferences.a()), true);
        } catch (InvalidProtocolBufferException e10) {
            throw new CorruptionException("Unable to parse preferences proto.", e10);
        }
    }

    public final n b(Object obj, c.b bVar) {
        PreferencesProto$Value preferencesProto$ValueG;
        Map<a.C0083a<?>, Object> mapA = ((g1.a) obj).a();
        a.C0078a c0078aQ = f1.a.q();
        for (Map.Entry<a.C0083a<?>, Object> entry : mapA.entrySet()) {
            a.C0083a<?> key = entry.getKey();
            Object value = entry.getValue();
            String str = key.f8947a;
            if (value instanceof Boolean) {
                PreferencesProto$Value.a aVarE = PreferencesProto$Value.E();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                aVarE.i();
                PreferencesProto$Value.s((PreferencesProto$Value) aVarE.f1747b, zBooleanValue);
                preferencesProto$ValueG = aVarE.g();
            } else if (value instanceof Float) {
                PreferencesProto$Value.a aVarE2 = PreferencesProto$Value.E();
                float fFloatValue = ((Number) value).floatValue();
                aVarE2.i();
                PreferencesProto$Value.t((PreferencesProto$Value) aVarE2.f1747b, fFloatValue);
                preferencesProto$ValueG = aVarE2.g();
            } else if (value instanceof Double) {
                PreferencesProto$Value.a aVarE3 = PreferencesProto$Value.E();
                double dDoubleValue = ((Number) value).doubleValue();
                aVarE3.i();
                PreferencesProto$Value.q((PreferencesProto$Value) aVarE3.f1747b, dDoubleValue);
                preferencesProto$ValueG = aVarE3.g();
            } else if (value instanceof Integer) {
                PreferencesProto$Value.a aVarE4 = PreferencesProto$Value.E();
                int iIntValue = ((Number) value).intValue();
                aVarE4.i();
                PreferencesProto$Value.u((PreferencesProto$Value) aVarE4.f1747b, iIntValue);
                preferencesProto$ValueG = aVarE4.g();
            } else if (value instanceof Long) {
                PreferencesProto$Value.a aVarE5 = PreferencesProto$Value.E();
                long jLongValue = ((Number) value).longValue();
                aVarE5.i();
                PreferencesProto$Value.n((PreferencesProto$Value) aVarE5.f1747b, jLongValue);
                preferencesProto$ValueG = aVarE5.g();
            } else if (value instanceof String) {
                PreferencesProto$Value.a aVarE6 = PreferencesProto$Value.E();
                aVarE6.i();
                PreferencesProto$Value.o((PreferencesProto$Value) aVarE6.f1747b, (String) value);
                preferencesProto$ValueG = aVarE6.g();
            } else {
                if (!(value instanceof Set)) {
                    throw new IllegalStateException(g.k(value.getClass().getName(), "PreferencesSerializer does not support type: "));
                }
                PreferencesProto$Value.a aVarE7 = PreferencesProto$Value.E();
                c.a aVarR = androidx.datastore.preferences.c.r();
                aVarR.i();
                androidx.datastore.preferences.c.o((androidx.datastore.preferences.c) aVarR.f1747b, (Set) value);
                aVarE7.i();
                PreferencesProto$Value.p((PreferencesProto$Value) aVarE7.f1747b, aVarR);
                preferencesProto$ValueG = aVarE7.g();
            }
            c0078aQ.getClass();
            str.getClass();
            c0078aQ.i();
            f1.a.o((f1.a) c0078aQ.f1747b).put(str, preferencesProto$ValueG);
        }
        f1.a aVarG = c0078aQ.g();
        int iC = aVarG.c();
        Logger logger = CodedOutputStream.f1721c;
        if (iC > 4096) {
            iC = 4096;
        }
        CodedOutputStream.c cVar = new CodedOutputStream.c(bVar, iC);
        aVarG.f(cVar);
        if (cVar.f1726g > 0) {
            cVar.Y();
        }
        return n.f10413a;
    }
}
