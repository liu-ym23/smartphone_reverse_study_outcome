package reactor.util.context;

import io.micrometer.context.ContextAccessor;
import io.modelcontextprotocol.spec.f;
import java.util.Map;
import java.util.function.Predicate;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public final class ReactorContextAccessor implements ContextAccessor<ContextView, Context> {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$readValues$0(Predicate predicate, Map map, Object obj, Object obj2) {
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

    public void readValues(ContextView contextView, Predicate<Object> predicate, Map<Object, Object> map) {
        contextView.forEach(new f(3, predicate, map));
    }

    public Context writeValues(Map<Object, Object> map, Context context) {
        return context.putAllMap(map);
    }
}
