package com.stepos.core.ota.storage;

import a9.a;
import com.tencent.mmkv.MMKV;
import gc.o;
import gc.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelsVersionStore {
    private static final String MMKV_ID = "ota_models_version";
    public static final ModelsVersionStore INSTANCE = new ModelsVersionStore();
    private static final d kv$delegate = b.b(new a(26));

    private ModelsVersionStore() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final void clear() {
        getKv().clearAll();
    }

    public final void clearPluginsFor(String baseModelType) {
        g.f(baseModelType, "baseModelType");
        String str = "ver_" + baseModelType + ".";
        String[] strArrA = getKv().a();
        if (strArrA != null) {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (String str2 : strArrA) {
                g.c(str2);
                if (o.k0(str2, str, false)) {
                    arrayList.add(str2);
                }
            }
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                INSTANCE.getKv().p((String) obj);
            }
        }
    }

    public final List<String> getAllRegisteredModels() {
        String[] strArrA = getKv().a();
        if (strArrA == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (String str : strArrA) {
            g.c(str);
            if (o.k0(str, "ver_", false) && !q.l0(str, ".", false)) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            String str2 = (String) obj;
            g.c(str2);
            arrayList2.add(q.z0(str2, "ver_"));
        }
        return arrayList2;
    }

    public final int getPluginVersion(String baseModelType, String plugin) {
        g.f(baseModelType, "baseModelType");
        g.f(plugin, "plugin");
        return getKv().e(0, ai.onnxruntime.a.l("ver_", baseModelType, ".", plugin));
    }

    public final int getVersionCode(String modelType) {
        g.f(modelType, "modelType");
        return getKv().e(0, "ver_".concat(modelType));
    }

    public final void setPluginVersion(String baseModelType, String plugin, int i10) {
        g.f(baseModelType, "baseModelType");
        g.f(plugin, "plugin");
        getKv().i(i10, ai.onnxruntime.a.l("ver_", baseModelType, ".", plugin));
    }

    public final void setVersionCode(String modelType, int i10) {
        g.f(modelType, "modelType");
        getKv().i(i10, "ver_".concat(modelType));
    }
}
