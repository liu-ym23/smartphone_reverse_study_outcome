package stepai.aios.guiagent.tracer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import stepai.aios.guiagent.tracer.GuiTaskTracer;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"stepai/aios/guiagent/tracer/GuiTaskTracer$nodeTraces$1", "Ljava/util/LinkedHashMap;", "", "Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalNodeTrace;", "removeEldestEntry", "", "eldest", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiTaskTracer$nodeTraces$1 extends LinkedHashMap<String, GuiTaskTracer.InternalNodeTrace> {
    final /* synthetic */ GuiTaskTracer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskTracer$nodeTraces$1(GuiTaskTracer guiTaskTracer) {
        super(16, 0.75f, true);
        this.this$0 = guiTaskTracer;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof GuiTaskTracer.InternalNodeTrace) {
            return containsValue((GuiTaskTracer.InternalNodeTrace) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, GuiTaskTracer.InternalNodeTrace>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<String, GuiTaskTracer.InternalNodeTrace>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (GuiTaskTracer.InternalNodeTrace) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<GuiTaskTracer.InternalNodeTrace> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, GuiTaskTracer.InternalNodeTrace> eldest) {
        boolean z10 = size() > ((GuiTracerConfig) this.this$0.configRef.get()).getMaxTaskTraces();
        if (z10 && eldest != null) {
            TraceScreenshotStore.INSTANCE.deleteSession(eldest.getKey());
        }
        return z10;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<GuiTaskTracer.InternalNodeTrace> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    public /* bridge */ boolean containsValue(GuiTaskTracer.InternalNodeTrace internalNodeTrace) {
        return super.containsValue((Object) internalNodeTrace);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ GuiTaskTracer.InternalNodeTrace get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public final /* bridge */ GuiTaskTracer.InternalNodeTrace getOrDefault(Object obj, GuiTaskTracer.InternalNodeTrace internalNodeTrace) {
        return !(obj instanceof String) ? internalNodeTrace : getOrDefault((String) obj, internalNodeTrace);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ GuiTaskTracer.InternalNodeTrace remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    public /* bridge */ GuiTaskTracer.InternalNodeTrace get(String str) {
        return (GuiTaskTracer.InternalNodeTrace) super.get((Object) str);
    }

    public /* bridge */ GuiTaskTracer.InternalNodeTrace getOrDefault(String str, GuiTaskTracer.InternalNodeTrace internalNodeTrace) {
        return (GuiTaskTracer.InternalNodeTrace) super.getOrDefault((Object) str, (String) internalNodeTrace);
    }

    public /* bridge */ GuiTaskTracer.InternalNodeTrace remove(String str) {
        return (GuiTaskTracer.InternalNodeTrace) super.remove((Object) str);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof GuiTaskTracer.InternalNodeTrace)) {
            return remove((String) obj, (GuiTaskTracer.InternalNodeTrace) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, GuiTaskTracer.InternalNodeTrace internalNodeTrace) {
        return super.remove((Object) str, (Object) internalNodeTrace);
    }
}
