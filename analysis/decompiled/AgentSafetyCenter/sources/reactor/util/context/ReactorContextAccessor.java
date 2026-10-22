package reactor.util.context;

import io.micrometer.context.ContextAccessor;
import io.modelcontextprotocol.spec.e;
import java.lang.invoke.VarHandle;
import java.util.Map;
import java.util.function.Predicate;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class ReactorContextAccessor implements ContextAccessor<ContextView, Context> {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$readValues$0(Predicate predicate, Map map, Object obj, Object obj2) {
        if (predicate.test(obj)) {
            map.put(obj, obj2);
        }
    }

    public void readValues(ContextView contextView, Predicate<Object> predicate, Map<Object, Object> map) {
        e eVar = new e(3);
        eVar.f6359g = predicate;
        eVar.f6358f = map;
        VarHandle.storeStoreFence();
        contextView.forEach(eVar);
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

    public Context writeValues(Map<Object, Object> map, Context context) {
        return context.putAllMap(map);
    }

    public /* bridge */ /* synthetic */ void readValues(Object obj, Predicate predicate, Map map) {
        readValues((ContextView) obj, (Predicate<Object>) predicate, (Map<Object, Object>) map);
    }
}
