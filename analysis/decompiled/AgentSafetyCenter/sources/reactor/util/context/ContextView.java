package reactor.util.context;

import g5.f;
import java.lang.invoke.VarHandle;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface ContextView {
    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$forEach$0(BiConsumer biConsumer, Map.Entry entry) {
        biConsumer.accept(entry.getKey(), entry.getValue());
    }

    default void forEach(BiConsumer<Object, Object> biConsumer) {
        Stream<Map.Entry<Object, Object>> stream = stream();
        c cVar = new c();
        cVar.f10910c = biConsumer;
        VarHandle.storeStoreFence();
        stream.forEach(cVar);
    }

    default <T> T get(Class<T> cls) {
        T t10 = (T) get((Object) cls);
        if (cls.isInstance(t10)) {
            return t10;
        }
        f.m("Context does not contain a value of type ".concat(cls.getName()));
        return null;
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
