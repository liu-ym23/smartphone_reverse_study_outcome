package reactor.util.context;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public interface ContextView {
    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$forEach$0(BiConsumer biConsumer, Map.Entry entry) {
        biConsumer.accept(entry.getKey(), entry.getValue());
    }

    default void forEach(final BiConsumer<Object, Object> biConsumer) {
        stream().forEach(new Consumer() { // from class: reactor.util.context.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ContextView.lambda$forEach$0(biConsumer, (Map.Entry) obj);
            }
        });
    }

    default <T> T get(Class<T> cls) {
        T t9 = (T) get((Object) cls);
        if (cls.isInstance(t9)) {
            return t9;
        }
        throw new NoSuchElementException("Context does not contain a value of type ".concat(cls.getName()));
    }

    <T> T get(Object obj);

    @Nullable
    default <T> T getOrDefault(Object obj, @Nullable T t9) {
        return !hasKey(obj) ? t9 : (T) get(obj);
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
