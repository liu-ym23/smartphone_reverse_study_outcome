package reactor.util.context;

import java.util.AbstractMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
final class Context5 implements CoreContext {
    final Object key1;
    final Object key2;
    final Object key3;
    final Object key4;
    final Object key5;
    final Object value1;
    final Object value2;
    final Object value3;
    final Object value4;
    final Object value5;

    public Context5(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Context4.checkKeys(obj, obj3, obj5, obj7, obj9);
        Objects.requireNonNull(obj, "key1");
        this.key1 = obj;
        Objects.requireNonNull(obj2, "value1");
        this.value1 = obj2;
        Objects.requireNonNull(obj3, "key2");
        this.key2 = obj3;
        Objects.requireNonNull(obj4, "value2");
        this.value2 = obj4;
        Objects.requireNonNull(obj5, "key3");
        this.key3 = obj5;
        Objects.requireNonNull(obj6, "value3");
        this.value3 = obj6;
        Objects.requireNonNull(obj7, "key4");
        this.key4 = obj7;
        Objects.requireNonNull(obj8, "value4");
        this.value4 = obj8;
        Objects.requireNonNull(obj9, "key5");
        this.key5 = obj9;
        Objects.requireNonNull(obj10, "value5");
        this.value5 = obj10;
    }

    @Override // reactor.util.context.Context
    public Context delete(Object obj) {
        Objects.requireNonNull(obj, "key");
        return this.key1.equals(obj) ? new Context4(this.key2, this.value2, this.key3, this.value3, this.key4, this.value4, this.key5, this.value5) : this.key2.equals(obj) ? new Context4(this.key1, this.value1, this.key3, this.value3, this.key4, this.value4, this.key5, this.value5) : this.key3.equals(obj) ? new Context4(this.key1, this.value1, this.key2, this.value2, this.key4, this.value4, this.key5, this.value5) : this.key4.equals(obj) ? new Context4(this.key1, this.value1, this.key2, this.value2, this.key3, this.value3, this.key5, this.value5) : this.key5.equals(obj) ? new Context4(this.key1, this.value1, this.key2, this.value2, this.key3, this.value3, this.key4, this.value4) : this;
    }

    @Override // reactor.util.context.ContextView
    public void forEach(BiConsumer<Object, Object> biConsumer) {
        biConsumer.accept(this.key1, this.value1);
        biConsumer.accept(this.key2, this.value2);
        biConsumer.accept(this.key3, this.value3);
        biConsumer.accept(this.key4, this.value4);
        biConsumer.accept(this.key5, this.value5);
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
        if (this.key4.equals(obj)) {
            return (T) this.value4;
        }
        if (this.key5.equals(obj)) {
            return (T) this.value5;
        }
        throw new NoSuchElementException(androidx.appfunctions.metadata.a.j(obj, "Context does not contain key: "));
    }

    @Override // reactor.util.context.ContextView
    public boolean hasKey(Object obj) {
        return this.key1.equals(obj) || this.key2.equals(obj) || this.key3.equals(obj) || this.key4.equals(obj) || this.key5.equals(obj);
    }

    @Override // reactor.util.context.Context
    public Context put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        Objects.requireNonNull(obj2, "value");
        return this.key1.equals(obj) ? new Context5(obj, obj2, this.key2, this.value2, this.key3, this.value3, this.key4, this.value4, this.key5, this.value5) : this.key2.equals(obj) ? new Context5(this.key1, this.value1, obj, obj2, this.key3, this.value3, this.key4, this.value4, this.key5, this.value5) : this.key3.equals(obj) ? new Context5(this.key1, this.value1, this.key2, this.value2, obj, obj2, this.key4, this.value4, this.key5, this.value5) : this.key4.equals(obj) ? new Context5(this.key1, this.value1, this.key2, this.value2, this.key3, this.value3, obj, obj2, this.key5, this.value5) : this.key5.equals(obj) ? new Context5(this.key1, this.value1, this.key2, this.value2, this.key3, this.value3, this.key4, this.value4, obj, obj2) : new ContextN(this.key1, this.value1, this.key2, this.value2, this.key3, this.value3, this.key4, this.value4, this.key5, this.value5, obj, obj2);
    }

    @Override // reactor.util.context.CoreContext
    public Context putAllInto(Context context) {
        return context.put(this.key1, this.value1).put(this.key2, this.value2).put(this.key3, this.value3).put(this.key4, this.value4).put(this.key5, this.value5);
    }

    @Override // reactor.util.context.ContextView
    public int size() {
        return 5;
    }

    @Override // reactor.util.context.ContextView
    public Stream<Map.Entry<Object, Object>> stream() {
        return Stream.of((Object[]) new Map.Entry[]{new AbstractMap.SimpleImmutableEntry(this.key1, this.value1), new AbstractMap.SimpleImmutableEntry(this.key2, this.value2), new AbstractMap.SimpleImmutableEntry(this.key3, this.value3), new AbstractMap.SimpleImmutableEntry(this.key4, this.value4), new AbstractMap.SimpleImmutableEntry(this.key5, this.value5)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Context5{");
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
        sb.append(this.value3);
        sb.append(", ");
        sb.append(this.key4);
        sb.append('=');
        sb.append(this.value4);
        sb.append(", ");
        sb.append(this.key5);
        sb.append('=');
        return androidx.compose.foundation.b.t(sb, this.value5, '}');
    }

    @Override // reactor.util.context.CoreContext
    public void unsafePutAllInto(ContextN contextN) {
        contextN.accept(this.key1, this.value1);
        contextN.accept(this.key2, this.value2);
        contextN.accept(this.key3, this.value3);
        contextN.accept(this.key4, this.value4);
        contextN.accept(this.key5, this.value5);
    }
}
