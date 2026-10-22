package reactor.util.context;

import g5.f;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class Context1 implements CoreContext {
    final Object key;
    final Object value;

    public Context1(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        this.key = obj;
        Objects.requireNonNull(obj2, "value");
        this.value = obj2;
    }

    @Override // reactor.util.context.Context
    public Context delete(Object obj) {
        Objects.requireNonNull(obj, "key");
        return this.key.equals(obj) ? Context.empty() : this;
    }

    @Override // reactor.util.context.ContextView
    public void forEach(BiConsumer<Object, Object> biConsumer) {
        biConsumer.accept(this.key, this.value);
    }

    @Override // reactor.util.context.ContextView
    public <T> T get(Object obj) {
        if (hasKey(obj)) {
            return (T) this.value;
        }
        f.m(k0.a.l(obj, "Context does not contain key: "));
        return null;
    }

    @Override // reactor.util.context.ContextView
    public boolean hasKey(Object obj) {
        return this.key.equals(obj);
    }

    @Override // reactor.util.context.Context
    public Context put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        Objects.requireNonNull(obj2, "value");
        return this.key.equals(obj) ? new Context1(obj, obj2) : new Context2(this.key, this.value, obj, obj2);
    }

    @Override // reactor.util.context.CoreContext
    public Context putAllInto(Context context) {
        return context.put(this.key, this.value);
    }

    @Override // reactor.util.context.ContextView
    public int size() {
        return 1;
    }

    @Override // reactor.util.context.ContextView
    public Stream<Map.Entry<Object, Object>> stream() {
        return Stream.of(new AbstractMap.SimpleImmutableEntry(this.key, this.value));
    }

    public String toString() {
        return "Context1{" + this.key + '=' + this.value + '}';
    }

    @Override // reactor.util.context.CoreContext
    public void unsafePutAllInto(ContextN contextN) {
        contextN.accept(this.key, this.value);
    }
}
