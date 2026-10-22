package reactor.util.context;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public interface ContextView {
    default void forEach(final BiConsumer<Object, Object> biConsumer) {
        stream().forEach(new Consumer() { // from class: reactor.util.context.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                biConsumer.accept(entry.getKey(), entry.getValue());
            }
        });
    }

    default <T> T get(Class<T> cls) {
        T t10 = (T) get((Object) cls);
        if (cls.isInstance(t10)) {
            return t10;
        }
        throw new NoSuchElementException("Context does not contain a value of type " + cls.getName());
    }

    <T> T get(Object obj);

    @Nullable
    default <T> T getOrDefault(Object obj, @Nullable T t10) {
        return !hasKey(obj) ? t10 : (T) get(obj);
    }

    default <T> Optional<T> getOrEmpty(Object obj) {
        return hasKey(obj) ? Optional.of(get(obj)) : Optional.empty();
    }

    boolean hasKey(Object obj);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    Stream<Map.Entry<Object, Object>> stream();
}
