package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ThrowableDeserializer extends BeanDeserializer {
    protected static final String PROP_NAME_LOCALIZED_MESSAGE = "localizedMessage";
    protected static final String PROP_NAME_MESSAGE = "message";
    protected static final String PROP_NAME_SUPPRESSED = "suppressed";
    private static final long serialVersionUID = 1;

    public ThrowableDeserializer(BeanDeserializer beanDeserializer, NameTransformer nameTransformer) {
        super(beanDeserializer, nameTransformer);
        this._vanillaProcessing = false;
    }

    private Throwable _instantiate(DeserializationContext deserializationContext, boolean z10, String str) {
        if (!z10) {
            return (Throwable) this._valueInstantiator.createUsingDefault(deserializationContext);
        }
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        return str != null ? (Throwable) valueInstantiator.createFromString(deserializationContext, str) : (Throwable) valueInstantiator.createFromString(deserializationContext, null);
    }

    public static ThrowableDeserializer construct(DeserializationContext deserializationContext, BeanDeserializer beanDeserializer) {
        return new ThrowableDeserializer(beanDeserializer, null);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializer, com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        }
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._beanType.isAbstract()) {
            return deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), jsonParser, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean zCanCreateFromString = this._valueInstantiator.canCreateFromString();
        boolean zCanCreateUsingDefault = this._valueInstantiator.canCreateUsingDefault();
        if (!zCanCreateFromString && !zCanCreateUsingDefault) {
            return deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), jsonParser, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
        }
        int i = 0;
        Throwable th_instantiate = null;
        Object[] objArrCopyOf = null;
        Throwable[] thArr = null;
        while (!jsonParser.hasToken(JsonToken.END_OBJECT)) {
            String strCurrentName = jsonParser.currentName();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            jsonParser.nextToken();
            if (settableBeanPropertyFind != null) {
                if (!"cause".equals(settableBeanPropertyFind.getName()) || !jsonParser.hasToken(JsonToken.VALUE_NULL)) {
                    if (th_instantiate != null) {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, th_instantiate);
                    } else {
                        if (objArrCopyOf == null) {
                            int size = this._beanProperties.size();
                            objArrCopyOf = new Object[size + size];
                        } else if (i == objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, i + 16);
                        }
                        int i3 = i + 1;
                        objArrCopyOf[i] = settableBeanPropertyFind;
                        i += 2;
                        objArrCopyOf[i3] = settableBeanPropertyFind.deserialize(jsonParser, deserializationContext);
                    }
                }
            } else if ("message".equalsIgnoreCase(strCurrentName)) {
                th_instantiate = _instantiate(deserializationContext, zCanCreateFromString, jsonParser.getValueAsString());
            } else {
                Set<String> set = this._ignorableProps;
                if (set != null && set.contains(strCurrentName)) {
                    jsonParser.skipChildren();
                } else if (PROP_NAME_SUPPRESSED.equalsIgnoreCase(strCurrentName)) {
                    thArr = jsonParser.hasToken(JsonToken.VALUE_NULL) ? null : (Throwable[]) deserializationContext.findRootValueDeserializer(deserializationContext.constructType(Throwable[].class)).deserialize(jsonParser, deserializationContext);
                } else if (PROP_NAME_LOCALIZED_MESSAGE.equalsIgnoreCase(strCurrentName)) {
                    jsonParser.skipChildren();
                } else if (this._anySetter != null) {
                    if (th_instantiate == null) {
                        th_instantiate = _instantiate(deserializationContext, zCanCreateFromString, null);
                    }
                    this._anySetter.deserializeAndSet(jsonParser, deserializationContext, th_instantiate, strCurrentName);
                } else if ("message".equalsIgnoreCase(strCurrentName)) {
                    jsonParser.skipChildren();
                } else {
                    handleUnknownProperty(jsonParser, deserializationContext, th_instantiate, strCurrentName);
                }
            }
            jsonParser.nextToken();
        }
        if (th_instantiate == null) {
            th_instantiate = _instantiate(deserializationContext, zCanCreateFromString, null);
        }
        if (objArrCopyOf != null) {
            for (int i10 = 0; i10 < i; i10 += 2) {
                ((SettableBeanProperty) objArrCopyOf[i10]).set(th_instantiate, objArrCopyOf[i10 + 1]);
            }
        }
        if (thArr != null) {
            for (Throwable th : thArr) {
                if (th != null) {
                    th_instantiate.addSuppressed(th);
                }
            }
        }
        return th_instantiate;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializer, com.fasterxml.jackson.databind.deser.BeanDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer nameTransformer) {
        return getClass() != ThrowableDeserializer.class ? this : new ThrowableDeserializer(this, nameTransformer);
    }

    @Deprecated
    public ThrowableDeserializer(BeanDeserializer beanDeserializer) {
        this(beanDeserializer, null);
    }
}
