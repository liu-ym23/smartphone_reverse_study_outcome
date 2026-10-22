package b3;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.AbstractDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.NameTransformer;
import e3.i;
import java.util.Collection;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c<T> implements i {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a extends c<Object> {
    }

    @Override // e3.i
    public T a(DeserializationContext deserializationContext) {
        return null;
    }

    public abstract T d(JsonParser jsonParser, DeserializationContext deserializationContext);

    public T e(JsonParser jsonParser, DeserializationContext deserializationContext, T t8) throws InvalidDefinitionException {
        deserializationContext.v(this);
        return d(jsonParser, deserializationContext);
    }

    public Object f(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) {
        return bVar.b(jsonParser, deserializationContext);
    }

    public final Object g(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) throws InvalidDefinitionException {
        deserializationContext.v(this);
        return f(jsonParser, deserializationContext, bVar);
    }

    public SettableBeanProperty h(String str) {
        StringBuilder sbQ = a0.a.q("Cannot handle managed/back reference '", str, "': type: value deserializer of type ");
        sbQ.append(getClass().getName());
        sbQ.append(" does not support them");
        throw new IllegalArgumentException(sbQ.toString());
    }

    public AccessPattern i() {
        return AccessPattern.f4493c;
    }

    public Object j(DeserializationContext deserializationContext) {
        return a(deserializationContext);
    }

    public Collection<Object> k() {
        return null;
    }

    public ObjectIdReader l() {
        return null;
    }

    public Class<?> m() {
        return null;
    }

    public boolean n() {
        return this instanceof AbstractDeserializer;
    }

    public LogicalType o() {
        return null;
    }

    public Boolean p(DeserializationConfig deserializationConfig) {
        return null;
    }

    public c<T> q(NameTransformer nameTransformer) {
        return this;
    }
}
