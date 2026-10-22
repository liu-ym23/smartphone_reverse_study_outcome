package io.ktor.util;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J!\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u00122\u0014\u0010\u0017\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\rJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R&\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000)0%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lio/ktor/util/CaseInsensitiveMap;", "", "Value", "", "", "<init>", "()V", "key", "", "containsKey", "(Ljava/lang/String;)Z", UxipConstants.f30680s, "containsValue", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "()Z", "LY8/t;", "clear", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "putAll", "(Ljava/util/Map;)V", "remove", "other", "equals", "", "hashCode", "()I", "Lio/ktor/util/CaseInsensitiveString;", "delegate", "Ljava/util/Map;", "getSize", ContentDisposition.Parameters.Size, "", "getKeys", "()Ljava/util/Set;", "keys", "", "getEntries", "entries", "", "getValues", "()Ljava/util/Collection;", "values", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, q9.e {
    private final Map<CaseInsensitiveString, Value> delegate = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map.Entry _get_entries_$lambda$3(Map.Entry DelegatingMutableSet) {
        kotlin.jvm.internal.p.i(DelegatingMutableSet, "$this$DelegatingMutableSet");
        return new Entry(((CaseInsensitiveString) DelegatingMutableSet.getKey()).getContent(), DelegatingMutableSet.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map.Entry _get_entries_$lambda$4(Map.Entry DelegatingMutableSet) {
        kotlin.jvm.internal.p.i(DelegatingMutableSet, "$this$DelegatingMutableSet");
        return new Entry(TextKt.caseInsensitive((String) DelegatingMutableSet.getKey()), DelegatingMutableSet.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _get_keys_$lambda$1(CaseInsensitiveString DelegatingMutableSet) {
        kotlin.jvm.internal.p.i(DelegatingMutableSet, "$this$DelegatingMutableSet");
        return DelegatingMutableSet.getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CaseInsensitiveString _get_keys_$lambda$2(String DelegatingMutableSet) {
        kotlin.jvm.internal.p.i(DelegatingMutableSet, "$this$DelegatingMutableSet");
        return TextKt.caseInsensitive(DelegatingMutableSet);
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        return this.delegate.containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Value>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (other == null || !(other instanceof CaseInsensitiveMap)) {
            return false;
        }
        return kotlin.jvm.internal.p.d(((CaseInsensitiveMap) other).delegate, this.delegate);
    }

    @Override // java.util.Map
    public final /* bridge */ Value get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public Set<Map.Entry<String, Value>> getEntries() {
        return new DelegatingMutableSet(this.delegate.entrySet(), new InterfaceC5074l() { // from class: io.ktor.util.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CaseInsensitiveMap._get_entries_$lambda$3((Map.Entry) obj);
            }
        }, new InterfaceC5074l() { // from class: io.ktor.util.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CaseInsensitiveMap._get_entries_$lambda$4((Map.Entry) obj);
            }
        });
    }

    public Set<String> getKeys() {
        return new DelegatingMutableSet(this.delegate.keySet(), new InterfaceC5074l() { // from class: io.ktor.util.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CaseInsensitiveMap._get_keys_$lambda$1((CaseInsensitiveString) obj);
            }
        }, new InterfaceC5074l() { // from class: io.ktor.util.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CaseInsensitiveMap._get_keys_$lambda$2((String) obj);
            }
        });
    }

    public int getSize() {
        return this.delegate.size();
    }

    public Collection<Value> getValues() {
        return this.delegate.values();
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
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        return put2(str, (String) obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Value> from) {
        kotlin.jvm.internal.p.i(from, "from");
        for (Map.Entry<? extends String, ? extends Value> entry : from.entrySet()) {
            put2(entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Value remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public boolean containsKey(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        return this.delegate.containsKey(new CaseInsensitiveString(key));
    }

    public Value get(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        return this.delegate.get(TextKt.caseInsensitive(key));
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Value put2(String key, Value value) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        return this.delegate.put(TextKt.caseInsensitive(key), value);
    }

    public Value remove(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        return this.delegate.remove(TextKt.caseInsensitive(key));
    }
}
