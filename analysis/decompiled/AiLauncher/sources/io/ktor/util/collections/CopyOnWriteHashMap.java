package io.ktor.util.collections;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.utils.io.InternalAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@InternalAPI
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u000bJ)\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/util/collections/CopyOnWriteHashMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<init>", "()V", "key", UxipConstants.f30680s, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "LY8/t;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "Lkotlin/Function1;", "producer", "computeIfAbsent", "(Ljava/lang/Object;Lp9/l;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CopyOnWriteHashMap<K, V> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater current$FU = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    private volatile /* synthetic */ Object current = kotlin.collections.a.i();

    public final V computeIfAbsent(K key, InterfaceC5074l<? super K, ? extends V> producer) {
        Map map;
        HashMap map2;
        V vInvoke;
        p.i(key, "key");
        p.i(producer, "producer");
        do {
            map = (Map) this.current;
            V v10 = (V) map.get(key);
            if (v10 != null) {
                return v10;
            }
            map2 = new HashMap(map);
            vInvoke = producer.invoke(key);
            map2.put(key, vInvoke);
        } while (!current$FU.compareAndSet(this, map, map2));
        return vInvoke;
    }

    public final V get(K key) {
        p.i(key, "key");
        return (V) ((Map) this.current).get(key);
    }

    public final V put(K key, V value) {
        Map map;
        HashMap map2;
        V v10;
        p.i(key, "key");
        p.i(value, "value");
        do {
            map = (Map) this.current;
            if (map.get(key) == value) {
                return value;
            }
            map2 = new HashMap(map);
            v10 = (V) map2.put(key, value);
        } while (!current$FU.compareAndSet(this, map, map2));
        return v10;
    }

    public final V remove(K key) {
        Map map;
        HashMap map2;
        V v10;
        p.i(key, "key");
        do {
            map = (Map) this.current;
            if (map.get(key) == null) {
                return null;
            }
            map2 = new HashMap(map);
            v10 = (V) map2.remove(key);
        } while (!current$FU.compareAndSet(this, map, map2));
        return v10;
    }

    public final void set(K key, V value) {
        p.i(key, "key");
        p.i(value, "value");
        put(key, value);
    }
}
