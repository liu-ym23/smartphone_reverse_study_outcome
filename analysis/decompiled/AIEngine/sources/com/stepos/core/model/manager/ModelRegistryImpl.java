package com.stepos.core.model.manager;

import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelRegistryImpl implements b7.f {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ModelRegistry";
    private final ConcurrentHashMap<String, b7.k> registry = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public void clear() {
        this.registry.clear();
        Log.i(TAG, "Registry cleared");
    }

    @Override // b7.f
    public boolean contains(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.registry.containsKey(modelId);
    }

    public List<b7.k> findByProtocol(ProtocolType protocolType) {
        kotlin.jvm.internal.g.f(protocolType, "protocolType");
        Collection<b7.k> collectionValues = this.registry.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((b7.k) obj).c(protocolType)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public List<b7.k> findByTag(String tag) {
        kotlin.jvm.internal.g.f(tag, "tag");
        Collection<b7.k> collectionValues = this.registry.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((b7.k) obj).h.contains(tag)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // b7.f
    public b7.k get(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.registry.get(modelId);
    }

    public List<b7.k> getAll() {
        Collection<b7.k> collectionValues = this.registry.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        return kotlin.collections.a.O0(collectionValues);
    }

    public List<String> getAvailableModels() {
        int i10;
        Collection<b7.k> collectionValues = this.registry.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            b7.k kVar = (b7.k) next;
            if (new File(kVar.f3091b).exists() || gc.o.e0(kVar.f3091b, ".json", false)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(mb.m.Z(arrayList, 10));
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            arrayList2.add(((b7.k) obj).f3090a);
        }
        return arrayList2;
    }

    @Override // b7.f
    public void register(b7.k config) {
        kotlin.jvm.internal.g.f(config, "config");
        ConcurrentHashMap<String, b7.k> concurrentHashMap = this.registry;
        String str = config.f3090a;
        if (concurrentHashMap.put(str, config) != null) {
            a0.a.A("Model replaced: ", str, TAG);
        } else {
            a0.a.y("Model registered: ", str, TAG);
        }
    }

    public int size() {
        return this.registry.size();
    }

    public boolean unregister(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        if (this.registry.remove(modelId) == null) {
            return false;
        }
        Log.i(TAG, "Model unregistered: ".concat(modelId));
        return true;
    }
}
