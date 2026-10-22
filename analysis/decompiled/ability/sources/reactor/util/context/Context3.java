package reactor.util.context;

import java.util.AbstractMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
final class Context3 implements CoreContext {
    final Object key1;
    final Object key2;
    final Object key3;
    final Object value1;
    final Object value2;
    final Object value3;

    public Context3(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Objects.requireNonNull(obj, "key1");
        if (obj.equals(obj3) || obj.equals(obj5)) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.s(obj, "Key #1 (", ") is duplicated"));
        }
        Objects.requireNonNull(obj3, "key2");
        if (obj3.equals(obj5)) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.s(obj3, "Key #2 (", ") is duplicated"));
        }
        this.key1 = obj;
        Objects.requireNonNull(obj2, "value1");
        this.value1 = obj2;
        this.key2 = obj3;
        Objects.requireNonNull(obj4, "value2");
        this.value2 = obj4;
        Objects.requireNonNull(obj5, "key3");
        this.key3 = obj5;
        Objects.requireNonNull(obj6, "value3");
        this.value3 = obj6;
    }

    @Override // reactor.util.context.Context
    public Context delete(Object obj) {
        Objects.requireNonNull(obj, "key");
        return this.key1.equals(obj) ? new Context2(this.key2, this.value2, this.key3, this.value3) : this.key2.equals(obj) ? new Context2(this.key1, this.value1, this.key3, this.value3) : this.key3.equals(obj) ? new Context2(this.key1, this.value1, this.key2, this.value2) : this;
    }

    @Override // reactor.util.context.ContextView
    public void forEach(BiConsumer<Object, Object> biConsumer) {
        biConsumer.accept(this.key1, this.value1);
        biConsumer.accept(this.key2, this.value2);
        biConsumer.accept(this.key3, this.value3);
    }

    @Override // reactor.util.context.ContextView
    public <T> T get(Object obj) {
        if (this.key1.equals(obj)) {
            return (T) this.value1;
        }
        if (this.key2.equals(obj)) {
            return (T) this.value2;
        }
        if (this.key3.equals(obj)) {
            return (T) this.value3;
        }
        throw new NoSuchElementException(androidx.appfunctions.metadata.a.j(obj, "Context does not contain key: "));
    }

    @Override // reactor.util.context.ContextView
    public boolean hasKey(Object obj) {
        return this.key1.equals(obj) || this.key2.equals(obj) || this.key3.equals(obj);
    }

    @Override // reactor.util.context.Context
    public Context put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        Objects.requireNonNull(obj2, "value");
        return this.key1.equals(obj) ? new Context3(obj, obj2, this.key2, this.value2, this.key3, this.value3) : this.key2.equals(obj) ? new Context3(this.key1, this.value1, obj, obj2, this.key3, this.value3) : this.key3.equals(obj) ? new Context3(this.key1, this.value1, this.key2, this.value2, obj, obj2) : new Context4(this.key1, this.value1, this.key2, this.value2, this.key3, this.value3, obj, obj2);
    }

    @Override // reactor.util.context.CoreContext
    public Context putAllInto(Context context) {
        return context.put(this.key1, this.value1).put(this.key2, this.value2).put(this.key3, this.value3);
    }

    @Override // reactor.util.context.ContextView
    public int size() {
        return 3;
    }

    @Override // reactor.util.context.ContextView
    public Stream<Map.Entry<Object, Object>> stream() {
        return Stream.of((Object[]) new Map.Entry[]{new AbstractMap.SimpleImmutableEntry(this.key1, this.value1), new AbstractMap.SimpleImmutableEntry(this.key2, this.value2), new AbstractMap.SimpleImmutableEntry(this.key3, this.value3)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Context3{");
        sb.append(this.key1);
        sb.append('=');
        sb.append(this.value1);
        sb.append(", ");
        sb.append(this.key2);
        sb.append('=');
        sb.append(this.value2);
        sb.append(", ");
        sb.append(this.key3);
        sb.append('=');
        return androidx.compose.foundation.b.t(sb, this.value3, '}');
    }

    @Override // reactor.util.context.CoreContext
    public void unsafePutAllInto(ContextN contextN) {
        contextN.accept(this.key1, this.value1);
        contextN.accept(this.key2, this.value2);
        contextN.accept(this.key3, this.value3);
    }
}
