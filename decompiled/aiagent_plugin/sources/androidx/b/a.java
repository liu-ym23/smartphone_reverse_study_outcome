package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f<K, V> f519a;

    public a() {
    }

    public a(int r1) {
        super(r1);
    }

    public a(g r1) {
        super(r1);
    }

    private f<K, V> b() {
        if (this.f519a != null) goto L6;
        this.f519a = new AnonymousClass1(this);
    L6:
        return this.f519a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        a(this.h + r5.size());
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    public boolean a(Collection<?> r3) {
        return f.c(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }
}
