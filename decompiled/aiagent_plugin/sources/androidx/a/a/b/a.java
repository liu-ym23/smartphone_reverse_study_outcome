package androidx.a.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<K, b.c<K, V>> f99b;

    public a() {
        this.f99b = new HashMap();
    }

    @Override // androidx.a.a.b.b
    public b.c<K, V> a(K r2) {
        return (b.c) ZeusTransformUtils.preCheckCast(this.f99b.get(r2), b.c.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.a.a.b.b
    public V a(K r2, V r3) {
        b.c<K, V> r0 = a(r2);
        if (r0 != null) goto L5;
        this.f99b.put(r2, b(r2, r3));
        return null;
    L5:
        return r0.f105b;
    }

    @Override // androidx.a.a.b.b
    public V b(K r2) {
        V r0 = (V) super.b(r2);
        this.f99b.remove(r2);
        return r0;
    }

    public boolean c(K r1) {
        return this.f99b.containsKey(r1);
    }

    public Map.Entry<K, V> d(K r2) {
        if (c(r2) == true) goto L5;
        return null;
    L5:
        return ((b.c) ZeusTransformUtils.preCheckCast(this.f99b.get(r2), b.c.class, "com.obric.aiagent.plugin")).f107d;
    }
}
