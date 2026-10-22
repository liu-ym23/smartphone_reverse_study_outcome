package reactor.util.context;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class Context2 implements CoreContext {
    final Object key1;
    final Object key2;
    final Object value1;
    final Object value2;

    public Context2(Object obj, Object obj2, Object obj3, Object obj4) {
        Objects.requireNonNull(obj, "key1");
        if (obj.equals(obj3)) {
            f.p("Key #1 (", obj, ") is duplicated");
            throw null;
        }
        this.key1 = obj;
        Objects.requireNonNull(obj2, "value1");
        this.value1 = obj2;
        Objects.requireNonNull(obj3, "key2");
        this.key2 = obj3;
        Objects.requireNonNull(obj4, "value2");
        this.value2 = obj4;
    }

    @Override // reactor.util.context.Context
    public Context delete(Object obj) {
        Objects.requireNonNull(obj, "key");
        boolean zEquals = this.key1.equals(obj);
        Object obj2 = this.key2;
        return zEquals ? new Context1(obj2, this.value2) : obj2.equals(obj) ? new Context1(this.key1, this.value1) : this;
    }

    @Override // reactor.util.context.ContextView
    public void forEach(BiConsumer<Object, Object> biConsumer) {
        biConsumer.accept(this.key1, this.value1);
        biConsumer.accept(this.key2, this.value2);
    }

    @Override // reactor.util.context.ContextView
    public <T> T get(Object obj) {
        if (this.key1.equals(obj)) {
            return (T) this.value1;
        }
        if (this.key2.equals(obj)) {
            return (T) this.value2;
        }
        g5.f.m(k0.a.l(obj, "Context does not contain key: "));
        return null;
    }

    @Override // reactor.util.context.ContextView
    public boolean hasKey(Object obj) {
        return this.key1.equals(obj) || this.key2.equals(obj);
    }

    @Override // reactor.util.context.Context
    public Context put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        Objects.requireNonNull(obj2, "value");
        boolean zEquals = this.key1.equals(obj);
        Object obj3 = this.key2;
        if (zEquals) {
            return new Context2(obj, obj2, obj3, this.value2);
        }
        boolean zEquals2 = obj3.equals(obj);
        Object obj4 = this.key1;
        return zEquals2 ? new Context2(obj4, this.value1, obj, obj2) : new Context3(obj4, this.value1, this.key2, this.value2, obj, obj2);
    }

    @Override // reactor.util.context.CoreContext
    public Context putAllInto(Context context) {
        return context.put(this.key1, this.value1).put(this.key2, this.value2);
    }

    @Override // reactor.util.context.ContextView
    public int size() {
        return 2;
    }

    @Override // reactor.util.context.ContextView
    public Stream<Map.Entry<Object, Object>> stream() {
        return Stream.of((Object[]) new Map.Entry[]{new AbstractMap.SimpleImmutableEntry(this.key1, this.value1), new AbstractMap.SimpleImmutableEntry(this.key2, this.value2)});
    }

    public String toString() {
        return "Context2{" + this.key1 + '=' + this.value1 + ", " + this.key2 + '=' + this.value2 + '}';
    }

    @Override // reactor.util.context.CoreContext
    public void unsafePutAllInto(ContextN contextN) {
        contextN.accept(this.key1, this.value1);
        contextN.accept(this.key2, this.value2);
    }
}
