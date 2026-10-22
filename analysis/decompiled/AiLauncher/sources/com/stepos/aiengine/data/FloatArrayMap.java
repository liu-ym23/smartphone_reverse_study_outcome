package com.stepos.aiengine.data;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u001b¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/data/FloatArrayMap;", "", "", "", "", C3081a.FOCUS_MAP_NAME, "<init>", "(Ljava/util/Map;)V", "id", "vector", "LY8/t;", "put", "(Ljava/lang/String;[F)V", "get", "(Ljava/lang/String;)[F", "remove", "", "containsKey", "(Ljava/lang/String;)Z", "", "keys", "()Ljava/util/Set;", "", ContentDisposition.Parameters.Size, "()I", "isEmpty", "()Z", "", "toMap", "()Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatArrayMap {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, float[]> map;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatArrayMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final boolean containsKey(String id) {
        p.i(id, "id");
        return this.map.containsKey(id);
    }

    public final float[] get(String id) {
        p.i(id, "id");
        return this.map.get(id);
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final Set<String> keys() {
        return this.map.keySet();
    }

    public final void put(String id, float[] vector) {
        p.i(id, "id");
        p.i(vector, "vector");
        this.map.put(id, vector);
    }

    public final float[] remove(String id) {
        p.i(id, "id");
        return this.map.remove(id);
    }

    public final int size() {
        return this.map.size();
    }

    public final Map<String, float[]> toMap() {
        return a.A(this.map);
    }

    public FloatArrayMap(Map<String, float[]> map) {
        p.i(map, "map");
        this.map = map;
    }

    public /* synthetic */ FloatArrayMap(Map map, int i10, i iVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map);
    }
}
