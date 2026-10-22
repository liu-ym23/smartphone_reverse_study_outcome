package r3;

import java.util.HashMap;
import java.util.Map;

/* renamed from: r3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5211e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final Map f38763a = new HashMap();

    public abstract V a(K k10);

    public V b(K k10) {
        synchronized (this.f38763a) {
            try {
                if (this.f38763a.containsKey(k10)) {
                    return (V) this.f38763a.get(k10);
                }
                V vA = a(k10);
                this.f38763a.put(k10, vA);
                return vA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
