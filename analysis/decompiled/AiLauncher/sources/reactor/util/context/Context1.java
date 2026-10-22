package reactor.util.context;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.AbstractMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/* loaded from: classes5.dex */
final class Context1 implements CoreContext {
    final Object key;
    final Object value;

    public Context1(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        this.key = obj;
        Objects.requireNonNull(obj2, UxipConstants.f30680s);
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
        throw new NoSuchElementException("Context does not contain key: " + obj);
    }

    @Override // reactor.util.context.ContextView
    public boolean hasKey(Object obj) {
        return this.key.equals(obj);
    }

    @Override // reactor.util.context.Context
    public Context put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        Objects.requireNonNull(obj2, UxipConstants.f30680s);
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
