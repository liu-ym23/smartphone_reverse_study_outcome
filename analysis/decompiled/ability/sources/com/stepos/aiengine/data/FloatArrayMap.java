package com.stepos.aiengine.data;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u001b¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/aiengine/data/FloatArrayMap;", "", "", "", "", "map", AppAgent.CONSTRUCT, "(Ljava/util/Map;)V", "id", "vector", "LC7/r;", "put", "(Ljava/lang/String;[F)V", "get", "(Ljava/lang/String;)[F", "remove", "", "containsKey", "(Ljava/lang/String;)Z", "", "keys", "()Ljava/util/Set;", "", "size", "()I", "isEmpty", "()Z", "", "toMap", "()Ljava/util/Map;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatArrayMap {

    /* renamed from: a, reason: collision with root package name */
    public final Map f3526a;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatArrayMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final boolean containsKey(String id) {
        k.f(id, "id");
        return this.f3526a.containsKey(id);
    }

    public final float[] get(String id) {
        k.f(id, "id");
        return (float[]) this.f3526a.get(id);
    }

    public final boolean isEmpty() {
        return this.f3526a.isEmpty();
    }

    public final Set<String> keys() {
        return this.f3526a.keySet();
    }

    public final void put(String id, float[] vector) {
        k.f(id, "id");
        k.f(vector, "vector");
        this.f3526a.put(id, vector);
    }

    public final float[] remove(String id) {
        k.f(id, "id");
        return (float[]) this.f3526a.remove(id);
    }

    public final int size() {
        return this.f3526a.size();
    }

    public final Map<String, float[]> toMap() {
        return a.Y(this.f3526a);
    }

    public FloatArrayMap(Map<String, float[]> map) {
        k.f(map, "map");
        this.f3526a = map;
    }

    public /* synthetic */ FloatArrayMap(Map map, int i, e eVar) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }
}
