package com.stepos.core.ability.pipeline;

import a0.a;
import b6.e;
import b6.i;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b;
import kotlin.jvm.internal.g;
import v6.c;
import v6.d;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TypeAdapter {
    public static final TypeAdapter INSTANCE = new TypeAdapter();
    private static final Map<Pair<Class<? extends d>, Class<? extends c>>, l<d, c>> rules = b.g0(new Pair(new Pair(d.q.class, c.g.class), new e(24)), new Pair(new Pair(d.b.class, c.a.class), new i(27)), new Pair(new Pair(d.l.class, c.d.class), new e(25)), new Pair(new Pair(d.e.class, c.g.class), new i(28)));

    private TypeAdapter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c rules$lambda$0(d o10) {
        g.f(o10, "o");
        return new c.g(((d.q) o10).f13487a, null, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c rules$lambda$2(d o10) {
        g.f(o10, "o");
        d.b bVar = (d.b) o10;
        float[] fArr = bVar.f13430a;
        ArrayList arrayList = new ArrayList(fArr.length);
        int i10 = 0;
        for (float f8 : fArr) {
            arrayList.add(Short.valueOf((short) (f8 * AsrCloudWsSession.PCM_FULL_SCALE)));
        }
        short[] sArr = new short[arrayList.size()];
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            sArr[i10] = ((Number) obj).shortValue();
            i10++;
        }
        return new c.a(sArr, bVar.f13431b, null, null, null, 508);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c rules$lambda$3(d o10) {
        g.f(o10, "o");
        d.l lVar = (d.l) o10;
        return new c.d(a.f("raw://", lVar.f13459b, lVar.f13460c, "x"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c rules$lambda$4(d o10) {
        Collection collectionO0;
        g.f(o10, "o");
        float[] fArr = ((d.e) o10).f13435a;
        g.f(fArr, "<this>");
        if (8 >= fArr.length) {
            collectionO0 = mb.l.o0(fArr);
        } else {
            ArrayList arrayList = new ArrayList(8);
            int i10 = 0;
            for (float f8 : fArr) {
                arrayList.add(Float.valueOf(f8));
                i10++;
                if (i10 == 8) {
                    break;
                }
            }
            collectionO0 = arrayList;
        }
        return new c.g(a.k("[", kotlin.collections.a.z0(collectionO0, null, null, null, null, 63), "…]"), null, 6);
    }

    public final c adapt(d output, Class<? extends c> inputType) {
        g.f(output, "output");
        g.f(inputType, "inputType");
        l<d, c> lVar = rules.get(new Pair(output.getClass(), inputType));
        if (lVar != null) {
            return lVar.invoke(output);
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.l("No TypeAdapter: ", output.getClass().getSimpleName(), " → ", inputType.getSimpleName()));
    }

    public final boolean canAdapt(Class<? extends d> outputType, Class<? extends c> inputType) {
        g.f(outputType, "outputType");
        g.f(inputType, "inputType");
        return rules.containsKey(new Pair(outputType, inputType));
    }
}
