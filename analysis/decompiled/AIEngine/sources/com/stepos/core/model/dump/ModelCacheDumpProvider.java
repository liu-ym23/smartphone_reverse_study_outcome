package com.stepos.core.model.dump;

import a0.a;
import b7.j;
import com.stepos.base.model.b;
import com.stepos.core.common.log.BaseDumpProvider;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.d;
import h0.e;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.m;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCacheDumpProvider extends BaseDumpProvider {
    public ModelCacheDumpProvider() {
        super("ModelCache", LogModule.MODEL);
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider
    public void dumpContent(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        ModelCacheImpl modelCacheImpl = j.f3087b;
        if (modelCacheImpl == null) {
            writer.println("  (ModelCache not initialized)");
            return;
        }
        writer.println("  loaded   : " + modelCacheImpl.size() + " / " + modelCacheImpl.capacity());
        writer.println("  memoryMb : " + modelCacheImpl.getTotalMemoryMb() + " / " + (modelCacheImpl.getAvailableMemoryMb() + modelCacheImpl.getTotalMemoryMb()));
        writer.println(a.d(modelCacheImpl.getMissCount(), ", miss=", ")", d.l("  hitRate  : ", modelCacheImpl.getHitCount(), String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(modelCacheImpl.getHitRate() * ((float) 100))}, 1)), "%  (hit=")));
        long jD = b.f6348a.d();
        if (jD >= 0) {
            writer.println("  dmaBufMb : " + jD + " (process /proc/self/maps dmabuf+fastrpc)");
        }
        writer.println();
        writer.println("  Loaded models:");
        List<d7.b> allModelInfo = modelCacheImpl.getAllModelInfo();
        int iA0 = v.a0(m.Z(allModelInfo, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (Object obj : allModelInfo) {
            linkedHashMap.put(((d7.b) obj).f8400a, obj);
        }
        for (String str : modelCacheImpl.getLoadedModels()) {
            d7.b bVar = (d7.b) linkedHashMap.get(str);
            if (bVar != null) {
                long j10 = bVar.f8411m;
                String strH = j10 >= 0 ? ai.onnxruntime.a.h(j10, "  dma=", "MB") : "";
                String str2 = bVar.f8400a;
                int refCount = modelCacheImpl.getRefCount(str2);
                int i10 = bVar.f8406g;
                StringBuilder sbF = e.f("    ", str2, "  ref=", refCount, "  mem=");
                sbF.append(i10);
                sbF.append("MB");
                sbF.append(strH);
                writer.println(sbF.toString());
            } else {
                writer.println(ai.onnxruntime.a.i("    ", modelCacheImpl.getRefCount(str), str, "  ref=", "  mem=?MB  (modelInfo missing)"));
            }
        }
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        ModelCacheImpl modelCacheImpl = j.f3087b;
        if (modelCacheImpl == null) {
            writer.println("ModelCache: not initialized");
            return;
        }
        int size = modelCacheImpl.size();
        int iCapacity = modelCacheImpl.capacity();
        String str = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(modelCacheImpl.getHitRate() * 100)}, 1));
        StringBuilder sbD = e.d(size, "ModelCache: ", iCapacity, "/", " loaded, hitRate=");
        sbD.append(str);
        sbD.append("%");
        writer.println(sbD.toString());
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "ModelCache: model cache status, memory usage, hit rate, per-model ref count";
    }
}
