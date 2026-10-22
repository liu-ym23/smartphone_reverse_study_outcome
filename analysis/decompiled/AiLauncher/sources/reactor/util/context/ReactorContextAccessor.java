package reactor.util.context;

import io.micrometer.context.ContextAccessor;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public final class ReactorContextAccessor implements ContextAccessor<ContextView, Context> {
    public static /* synthetic */ void a(Predicate predicate, Map map, Object obj, Object obj2) {
        if (predicate.test(obj)) {
            map.put(obj, obj2);
        }
    }

    public /* bridge */ /* synthetic */ void readValues(Object obj, Predicate predicate, Map map) {
        readValues((ContextView) obj, (Predicate<Object>) predicate, (Map<Object, Object>) map);
    }

    public Class<? extends ContextView> readableType() {
        return ContextView.class;
    }

    public /* bridge */ /* synthetic */ Object writeValues(Map map, Object obj) {
        return writeValues((Map<Object, Object>) map, (Context) obj);
    }

    public Class<? extends Context> writeableType() {
        return Context.class;
    }

    @Nullable
    public <T> T readValue(ContextView contextView, Object obj) {
        return (T) contextView.getOrDefault(obj, null);
    }

    public void readValues(ContextView contextView, final Predicate<Object> predicate, final Map<Object, Object> map) {
        contextView.forEach(new BiConsumer() { // from class: reactor.util.context.e
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ReactorContextAccessor.a(predicate, map, obj, obj2);
            }
        });
    }

    public Context writeValues(Map<Object, Object> map, Context context) {
        return context.putAllMap(map);
    }
}
