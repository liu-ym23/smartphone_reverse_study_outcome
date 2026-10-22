package tc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e0<K, V> extends k0<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {

    /* renamed from: c, reason: collision with root package name */
    public final d0 f12974c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0() {
        super(0);
        b1 b1Var = b1.f12964a;
        uc.i iVar = uc.i.f13211a;
        v0 keyDesc = b1.f12965b;
        rc.f valueDesc = uc.i.f13212b;
        kotlin.jvm.internal.g.f(keyDesc, "keyDesc");
        kotlin.jvm.internal.g.f(valueDesc, "valueDesc");
        this.f12974c = new d0(keyDesc, valueDesc);
    }

    @Override // pc.c
    public final rc.e d() {
        return this.f12974c;
    }

    @Override // tc.a
    public final Object e() {
        return new LinkedHashMap();
    }

    @Override // tc.a
    public final int f(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        kotlin.jvm.internal.g.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // tc.a
    public final Iterator g(Object obj) {
        Map map = (Map) obj;
        kotlin.jvm.internal.g.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // tc.a
    public final int h(Object obj) {
        Map map = (Map) obj;
        kotlin.jvm.internal.g.f(map, "<this>");
        return map.size();
    }

    @Override // tc.a
    public final Object k(Object obj) {
        kotlin.jvm.internal.g.f(null, "<this>");
        return new LinkedHashMap((Map) null);
    }

    @Override // tc.a
    public final Object l(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        kotlin.jvm.internal.g.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
