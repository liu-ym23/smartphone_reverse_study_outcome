package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class UnwrappedPropertyHandler {
    public static final String JSON_UNWRAPPED_NAME_PREFIX = "@JsonUnwrapped/";
    protected final List<SettableBeanProperty> _creatorProperties;
    protected final List<SettableBeanProperty> _properties;

    public UnwrappedPropertyHandler() {
        this._creatorProperties = new ArrayList();
        this._properties = new ArrayList();
    }

    public static PropertyName creatorParamName(int i) {
        return new PropertyName(a.j(i, JSON_UNWRAPPED_NAME_PREFIX));
    }

    private List<SettableBeanProperty> renameProperties(Collection<SettableBeanProperty> collection, NameTransformer nameTransformer) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (SettableBeanProperty settableBeanProperty : collection) {
            if (settableBeanProperty == null) {
                arrayList.add(null);
            } else {
                arrayList.add(settableBeanProperty.unwrapped(nameTransformer));
            }
        }
        return arrayList;
    }

    public void addCreatorProperty(SettableBeanProperty settableBeanProperty) {
        this._creatorProperties.add(settableBeanProperty);
    }

    public void addProperty(SettableBeanProperty settableBeanProperty) {
        this._properties.add(settableBeanProperty);
    }

    public Object processUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) {
        for (SettableBeanProperty settableBeanProperty : this._properties) {
            JsonParser jsonParserAsParser = tokenBuffer.asParser(jsonParser.streamReadConstraints());
            jsonParserAsParser.nextToken();
            settableBeanProperty.deserializeAndSet(jsonParserAsParser, deserializationContext, obj);
        }
        return obj;
    }

    public PropertyValueBuffer processUnwrappedCreatorProperties(JsonParser jsonParser, DeserializationContext deserializationContext, PropertyValueBuffer propertyValueBuffer, TokenBuffer tokenBuffer) {
        for (SettableBeanProperty settableBeanProperty : this._creatorProperties) {
            JsonParser jsonParserAsParser = tokenBuffer.asParser(jsonParser.streamReadConstraints());
            jsonParserAsParser.nextToken();
            propertyValueBuffer.assignParameter(settableBeanProperty, settableBeanProperty.deserialize(jsonParserAsParser, deserializationContext));
        }
        return propertyValueBuffer;
    }

    public UnwrappedPropertyHandler renameAll(NameTransformer nameTransformer) {
        return new UnwrappedPropertyHandler(renameProperties(this._creatorProperties, nameTransformer), renameProperties(this._properties, nameTransformer));
    }

    @Deprecated
    public UnwrappedPropertyHandler(List<SettableBeanProperty> list) {
        this(new ArrayList(), list);
    }

    public UnwrappedPropertyHandler(List<SettableBeanProperty> list, List<SettableBeanProperty> list2) {
        this._creatorProperties = list;
        this._properties = list2;
    }
}
