package com.stepos.core.ability.pipeline;

import android.util.Log;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.factory.AbilityFactory;
import h0.e;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.l;
import mb.m;
import p6.a;
import p6.d;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PipelineBuilder {
    private final String TAG = "PipelineBuilder";
    private final List<String> stageIds = new ArrayList();

    private final Class<? extends c> resolveInputType(d<?, ?> dVar) {
        Object obj;
        Type[] actualTypeArguments;
        try {
            Type[] genericInterfaces = dVar.getClass().getGenericInterfaces();
            g.e(genericInterfaces, "getGenericInterfaces(...)");
            ArrayList arrayList = new ArrayList();
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    arrayList.add(type);
                }
            }
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i10);
                i10++;
                if (g.b(((ParameterizedType) obj).getRawType(), d.class)) {
                    break;
                }
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            Object obj2 = (parameterizedType == null || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null) ? null : (Type) l.g0(actualTypeArguments, 0);
            Class<? extends c> cls = obj2 instanceof Class ? (Class) obj2 : null;
            return cls == null ? c.class : cls;
        } catch (Exception unused) {
            return c.class;
        }
    }

    private final Class<? extends v6.d> resolveOutputType(d<?, ?> dVar) {
        Object obj;
        Type[] actualTypeArguments;
        try {
            Type[] genericInterfaces = dVar.getClass().getGenericInterfaces();
            g.e(genericInterfaces, "getGenericInterfaces(...)");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    arrayList.add(type);
                }
            }
            int size = arrayList.size();
            while (true) {
                if (i10 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i10);
                i10++;
                if (g.b(((ParameterizedType) obj).getRawType(), d.class)) {
                    break;
                }
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            Object obj2 = (parameterizedType == null || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null) ? null : (Type) l.g0(actualTypeArguments, 1);
            Class<? extends v6.d> cls = obj2 instanceof Class ? (Class) obj2 : null;
            return cls == null ? v6.d.class : cls;
        } catch (Exception unused) {
            return v6.d.class;
        }
    }

    public final Pipeline build() {
        if (this.stageIds.isEmpty()) {
            throw new IllegalArgumentException("Pipeline must have at least one stage");
        }
        List<String> list = this.stageIds;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        int i10 = 0;
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                m.f0();
                throw null;
            }
            String str = (String) obj;
            a abilityConfig = AbilityManager.INSTANCE.getAbilityConfig(str);
            if (abilityConfig == null) {
                throw new IllegalArgumentException(a0.a.k("Ability not registered: '", str, "'"));
            }
            d<?, ?> dVarCreateAbility = AbilityFactory.INSTANCE.createAbility(abilityConfig);
            arrayList.add(new PipelineStage(i11, str, dVarCreateAbility, resolveInputType(dVarCreateAbility), resolveOutputType(dVarCreateAbility)));
            i11 = i12;
        }
        int size = arrayList.size() - 1;
        while (i10 < size) {
            PipelineStage pipelineStage = (PipelineStage) arrayList.get(i10);
            int i13 = i10 + 1;
            PipelineStage pipelineStage2 = (PipelineStage) arrayList.get(i13);
            if (!TypeAdapter.INSTANCE.canAdapt(pipelineStage.getOutputType(), pipelineStage2.getInputType())) {
                throw new IllegalArgumentException(com.stepos.core.ota.d.j(ai.onnxruntime.a.s("Type mismatch between '", pipelineStage.getAbilityId(), "' and '", pipelineStage2.getAbilityId(), "': "), pipelineStage.getOutputType().getSimpleName(), " → ", pipelineStage2.getInputType().getSimpleName(), " — add rule to TypeAdapter"));
            }
            Log.d(this.TAG, com.stepos.core.ota.d.j(e.d(i10, "Stage[", i13, "→", "]: "), pipelineStage.getOutputType().getSimpleName(), " → ", pipelineStage2.getInputType().getSimpleName(), " ✓"));
            i10 = i13;
        }
        return new Pipeline(arrayList);
    }

    public final PipelineBuilder pipe(String abilityId) {
        g.f(abilityId, "abilityId");
        this.stageIds.add(abilityId);
        return this;
    }
}
