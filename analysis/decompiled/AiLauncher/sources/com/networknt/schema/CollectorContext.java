package com.networknt.schema;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class CollectorContext {
    private final Map<Object, Object> data;

    public CollectorContext() {
        this(new HashMap());
    }

    public <T> T computeIfAbsent(Object obj, Function<Object, Object> function) {
        return (T) this.data.computeIfAbsent(obj, function);
    }

    public <T> T get(Object obj) {
        return (T) this.data.get(obj);
    }

    public Map<Object, Object> getData() {
        return this.data;
    }

    public <T> T put(Object obj, Object obj2) {
        return (T) this.data.put(obj, obj2);
    }

    public CollectorContext(Map<Object, Object> map) {
        this.data = map;
    }
}
