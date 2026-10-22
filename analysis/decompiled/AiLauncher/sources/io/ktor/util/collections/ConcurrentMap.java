package io.ktor.util.collections;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import q9.e;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u00020\u00162\u0014\u0010\u001c\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u0013J\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0002¢\u0006\u0004\b%\u0010\u000fJ\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\"R&\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/0.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00028\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lio/ktor/util/collections/ConcurrentMap;", "Key", "Value", "", "", "initialCapacity", "<init>", "(I)V", "key", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Ljava/lang/Object;Lp9/a;)Ljava/lang/Object;", "", "containsKey", "(Ljava/lang/Object;)Z", UxipConstants.f30680s, "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "LY8/t;", "clear", "()V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "()I", "", "other", "equals", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "delegate", "Ljava/util/concurrent/ConcurrentHashMap;", "getSize", ContentDisposition.Parameters.Size, "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, e {
    private final ConcurrentHashMap<Key, Value> delegate;

    public ConcurrentMap() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object computeIfAbsent$lambda$0(InterfaceC5063a interfaceC5063a, Object obj) {
        return interfaceC5063a.invoke();
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    public final Value computeIfAbsent(Key key, final InterfaceC5063a<? extends Value> block) {
        p.i(block, "block");
        ConcurrentHashMap<Key, Value> concurrentHashMap = this.delegate;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.util.collections.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConcurrentMap.computeIfAbsent$lambda$0(block, obj);
            }
        };
        return concurrentHashMap.computeIfAbsent(key, new Function() { // from class: io.ktor.util.collections.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return interfaceC5074l.invoke(obj);
            }
        });
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.delegate.containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Key, Value>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (other instanceof Map) {
            return p.d(other, this.delegate);
        }
        return false;
    }

    @Override // java.util.Map
    public Value get(Object key) {
        return this.delegate.get(key);
    }

    public Set<Map.Entry<Key, Value>> getEntries() {
        Set<Map.Entry<Key, Value>> setEntrySet = this.delegate.entrySet();
        p.h(setEntrySet, "<get-entries>(...)");
        return setEntrySet;
    }

    public Set<Key> getKeys() {
        Set<Key> setKeySet = this.delegate.keySet();
        p.h(setKeySet, "<get-keys>(...)");
        return setKeySet;
    }

    public int getSize() {
        return this.delegate.size();
    }

    public Collection<Value> getValues() {
        Collection<Value> collectionValues = this.delegate.values();
        p.h(collectionValues, "<get-values>(...)");
        return collectionValues;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Key> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public Value put(Key key, Value value) {
        return this.delegate.put(key, value);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Key, ? extends Value> from) {
        p.i(from, "from");
        this.delegate.putAll(from);
    }

    @Override // java.util.Map
    public Value remove(Object key) {
        return this.delegate.remove(key);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return "ConcurrentMapJvm by " + this.delegate;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public ConcurrentMap(int i10) {
        this.delegate = new ConcurrentHashMap<>(i10);
    }

    @Override // java.util.Map
    public boolean remove(Object key, Object value) {
        return this.delegate.remove(key, value);
    }

    public /* synthetic */ ConcurrentMap(int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? 32 : i10);
    }
}
