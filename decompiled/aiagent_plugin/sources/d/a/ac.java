package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ac implements d.h.b.a.a, Serializable, Map {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac f38346a = null;

    static {
        f38346a = new ac();
    }

    public int a() {
        return 0;
    }

    public Void a(Object r1) {
        return null;
    }

    public boolean a(Void r1) {
        d.h.b.o.e(r1, "value");
        return false;
    }

    public Void b(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "{}";
    }

    private ac() {
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return false;
    L7:
        return a((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.Map
    public final Set<Map.Entry> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public /* synthetic */ Object get(Object r1) {
        return a(r1);
    }

    @Override // java.util.Map
    public final Set<Object> keySet() {
        return c();
    }

    @Override // java.util.Map
    public /* synthetic */ Object remove(Object r1) {
        return b(r1);
    }

    @Override // java.util.Map
    public final int size() {
        return a();
    }

    @Override // java.util.Map
    public final Collection values() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Map.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    public Set<Map.Entry> b() {
        return (Set) ZeusTransformUtils.preCheckCast(ad.f38347a, Set.class, "com.obric.aiagent.plugin");
    }

    public Set<Object> c() {
        return (Set) ZeusTransformUtils.preCheckCast(ad.f38347a, Set.class, "com.obric.aiagent.plugin");
    }

    public Collection d() {
        return (Collection) ZeusTransformUtils.preCheckCast(ab.f38345a, Collection.class, "com.obric.aiagent.plugin");
    }
}
