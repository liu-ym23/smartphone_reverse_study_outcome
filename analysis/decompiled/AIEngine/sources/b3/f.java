package b3;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class f<T> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a extends f<Object> {
    }

    public Class<T> c() {
        return null;
    }

    public boolean d(h hVar, T t8) {
        return false;
    }

    public boolean e() {
        return this instanceof UnwrappingBeanSerializer;
    }

    public abstract void f(T t8, JsonGenerator jsonGenerator, h hVar);

    /* JADX WARN: Multi-variable type inference failed */
    public void g(T t8, JsonGenerator jsonGenerator, h hVar, k3.e eVar) {
        Class clsC = c();
        if (clsC == null) {
            clsC = t8.getClass();
        }
        hVar.i(clsC, h0.e.c("Type id handling not implemented for type ", clsC.getName(), " (by serializer of type ", getClass().getName(), ")"));
        throw null;
    }

    public boolean i() {
        return false;
    }

    public f<T> h(NameTransformer nameTransformer) {
        return this;
    }
}
