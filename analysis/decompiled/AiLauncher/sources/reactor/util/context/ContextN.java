package reactor.util.context;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ContextN extends LinkedHashMap<Object, Object> implements CoreContext, BiConsumer<Object, Object>, Consumer<Map.Entry<Object, Object>> {
    public ContextN(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        super(6, 1.0f);
        accept(obj, obj2);
        accept(obj3, obj4);
        accept(obj5, obj6);
        accept(obj7, obj8);
        accept(obj9, obj10);
        accept(obj11, obj12);
    }

    public static /* synthetic */ void h(Context[] contextArr, Object obj, Object obj2) {
        contextArr[0] = contextArr[0].put(obj, obj2);
    }

    @Override // reactor.util.context.Context
    public Context delete(Object obj) {
        Objects.requireNonNull(obj, "key");
        if (!hasKey(obj)) {
            return this;
        }
        int size = size() - 1;
        if (size != 5) {
            ContextN contextN = new ContextN(this);
            contextN.remove(obj);
            return contextN;
        }
        Map.Entry[] entryArr = new Map.Entry[size];
        int i10 = 0;
        for (Map.Entry<Object, Object> entry : entrySet()) {
            if (!entry.getKey().equals(obj)) {
                entryArr[i10] = entry;
                i10++;
            }
        }
        return new Context5(entryArr[0].getKey(), entryArr[0].getValue(), entryArr[1].getKey(), entryArr[1].getValue(), entryArr[2].getKey(), entryArr[2].getValue(), entryArr[3].getKey(), entryArr[3].getValue(), entryArr[4].getKey(), entryArr[4].getValue());
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map, reactor.util.context.ContextView
    public Object get(Object obj) {
        Object obj2 = super.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        throw new NoSuchElementException("Context does not contain key: " + obj);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map, reactor.util.context.ContextView
    @Nullable
    public Object getOrDefault(Object obj, @Nullable Object obj2) {
        Object obj3 = super.get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // reactor.util.context.ContextView
    public boolean hasKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<?, ?> map) {
        super.putAll(map);
    }

    @Override // reactor.util.context.CoreContext
    public Context putAllInto(Context context) {
        if (!(context instanceof CoreContext)) {
            final Context[] contextArr = {context};
            forEach(new BiConsumer() { // from class: reactor.util.context.b
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ContextN.h(contextArr, obj, obj2);
                }
            });
            return contextArr[0];
        }
        ContextN contextN = new ContextN(context.size() + size());
        ((CoreContext) context).unsafePutAllInto(contextN);
        contextN.putAll((Map<?, ?>) this);
        return contextN;
    }

    @Override // reactor.util.context.Context
    public Context putAllMap(Map<?, ?> map) {
        if (map.isEmpty()) {
            return this;
        }
        ContextN contextN = new ContextN(this);
        map.forEach(contextN);
        return contextN;
    }

    @Override // reactor.util.context.ContextView
    public Stream<Map.Entry<Object, Object>> stream() {
        return entrySet().stream().map(new Function() { // from class: reactor.util.context.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new AbstractMap.SimpleImmutableEntry((Map.Entry) obj);
            }
        });
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return "ContextN" + super.toString();
    }

    @Override // reactor.util.context.CoreContext
    public void unsafePutAllInto(ContextN contextN) {
        contextN.putAll((Map<?, ?>) this);
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key");
        Objects.requireNonNull(obj2, UxipConstants.f30680s);
        super.put((ContextN) obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Context put(Object obj, Object obj2) {
        ContextN contextN = new ContextN(this);
        contextN.accept(obj, obj2);
        return contextN;
    }

    @Override // reactor.util.context.CoreContext, reactor.util.context.Context
    public Context putAll(ContextView contextView) {
        if (contextView.isEmpty()) {
            return this;
        }
        ContextN contextN = new ContextN(this);
        if (contextView instanceof CoreContext) {
            ((CoreContext) contextView).unsafePutAllInto(contextN);
            return contextN;
        }
        ((Stream) contextView.stream().sequential()).forEach(contextN);
        return contextN;
    }

    @Override // java.util.function.Consumer
    public void accept(Map.Entry<Object, Object> entry) {
        accept(entry.getKey(), entry.getValue());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextN(Map<Object, Object> map) {
        super(map);
        Objects.requireNonNull(map, "originalToCopy");
    }

    public ContextN(int i10) {
        super(i10, 1.0f);
    }
}
