package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyValue;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.IOException;
import java.util.BitSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PropertyValueBuffer {
    protected PropertyValue _anyParamBuffered;
    protected final SettableAnyProperty _anyParamSetter;
    protected PropertyValue _buffered;
    protected final DeserializationContext _context;
    protected final Object[] _creatorParameters;
    protected Object _idValue;
    protected final ObjectIdReader _objectIdReader;
    protected int _paramsNeeded;
    protected int _paramsSeen;
    protected final BitSet _paramsSeenBig;
    protected final JsonParser _parser;

    public PropertyValueBuffer(JsonParser jsonParser, DeserializationContext deserializationContext, int i, ObjectIdReader objectIdReader, SettableAnyProperty settableAnyProperty) {
        this._parser = jsonParser;
        this._context = deserializationContext;
        this._paramsNeeded = i;
        this._objectIdReader = objectIdReader;
        this._creatorParameters = new Object[i];
        if (i < 32) {
            this._paramsSeenBig = null;
        } else {
            this._paramsSeenBig = new BitSet();
        }
        if (settableAnyProperty == null || settableAnyProperty.getParameterIndex() < 0) {
            this._anyParamSetter = null;
        } else {
            this._anyParamSetter = settableAnyProperty;
        }
    }

    private Object _createAndSetAnySetterValue() throws JsonMappingException {
        Object objCreateParameterObject = this._anyParamSetter.createParameterObject();
        for (PropertyValue propertyValue = this._anyParamBuffered; propertyValue != null; propertyValue = propertyValue.next) {
            try {
                propertyValue.setValue(objCreateParameterObject);
            } catch (JsonMappingException e10) {
                throw e10;
            } catch (IOException e11) {
                throw JsonMappingException.fromUnexpectedIOE(e11);
            }
        }
        return objCreateParameterObject;
    }

    public Object _findMissing(SettableBeanProperty settableBeanProperty) throws DatabindException {
        if (this._anyParamSetter != null && settableBeanProperty.getCreatorIndex() == this._anyParamSetter.getParameterIndex() && this._anyParamBuffered != null) {
            return null;
        }
        if (settableBeanProperty.getInjectableValueId() != null) {
            return this._context.findInjectableValue(settableBeanProperty.getInjectableValueId(), settableBeanProperty, null);
        }
        if (settableBeanProperty.isRequired()) {
            this._context.reportInputMismatch(settableBeanProperty, "Missing required creator property '%s' (index %d)", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex()));
        }
        if (this._context.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            this._context.reportInputMismatch(settableBeanProperty, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex()));
        }
        try {
            Object absentValue = settableBeanProperty.getNullValueProvider().getAbsentValue(this._context);
            return absentValue != null ? absentValue : settableBeanProperty.getValueDeserializer().getAbsentValue(this._context);
        } catch (DatabindException e10) {
            AnnotatedMember member = settableBeanProperty.getMember();
            if (member != null) {
                e10.prependPath(member.getDeclaringClass(), settableBeanProperty.getName());
            }
            throw e10;
        }
    }

    public boolean assignParameter(SettableBeanProperty settableBeanProperty, Object obj) {
        int creatorIndex = settableBeanProperty.getCreatorIndex();
        this._creatorParameters[creatorIndex] = obj;
        BitSet bitSet = this._paramsSeenBig;
        if (bitSet == null) {
            int i = this._paramsSeen;
            int i3 = (1 << creatorIndex) | i;
            if (i != i3) {
                this._paramsSeen = i3;
                int i10 = this._paramsNeeded - 1;
                this._paramsNeeded = i10;
                if (i10 <= 0) {
                    return this._objectIdReader == null || this._idValue != null;
                }
            }
        } else if (!bitSet.get(creatorIndex)) {
            this._paramsSeenBig.set(creatorIndex);
            this._paramsNeeded--;
        }
        return false;
    }

    public void bufferAnyParameterProperty(SettableAnyProperty settableAnyProperty, String str, Object obj) {
        this._anyParamBuffered = new PropertyValue.AnyParameter(this._anyParamBuffered, obj, settableAnyProperty, str);
    }

    public void bufferAnyProperty(SettableAnyProperty settableAnyProperty, String str, Object obj) {
        this._buffered = new PropertyValue.Any(this._buffered, obj, settableAnyProperty, str);
    }

    public void bufferMapProperty(Object obj, Object obj2) {
        this._buffered = new PropertyValue.Map(this._buffered, obj2, obj);
    }

    public void bufferProperty(SettableBeanProperty settableBeanProperty, Object obj) {
        this._buffered = new PropertyValue.Regular(this._buffered, obj, settableBeanProperty);
    }

    public PropertyValue buffered() {
        return this._buffered;
    }

    public Object getParameter(SettableBeanProperty settableBeanProperty) throws DatabindException {
        Object obj_createAndSetAnySetterValue;
        boolean zHasParameter = hasParameter(settableBeanProperty);
        Object[] objArr = this._creatorParameters;
        if (zHasParameter) {
            obj_createAndSetAnySetterValue = objArr[settableBeanProperty.getCreatorIndex()];
        } else {
            int creatorIndex = settableBeanProperty.getCreatorIndex();
            Object obj_findMissing = _findMissing(settableBeanProperty);
            objArr[creatorIndex] = obj_findMissing;
            obj_createAndSetAnySetterValue = obj_findMissing;
        }
        if (obj_createAndSetAnySetterValue == null && this._anyParamSetter != null && settableBeanProperty.getCreatorIndex() == this._anyParamSetter.getParameterIndex()) {
            obj_createAndSetAnySetterValue = _createAndSetAnySetterValue();
        }
        return (obj_createAndSetAnySetterValue == null && this._context.isEnabled(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)) ? this._context.reportInputMismatch(settableBeanProperty, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex())) : obj_createAndSetAnySetterValue;
    }

    public Object[] getParameters(SettableBeanProperty[] settableBeanPropertyArr) throws MismatchedInputException {
        if (this._paramsNeeded > 0) {
            if (this._paramsSeenBig != null) {
                int length = this._creatorParameters.length;
                int i = 0;
                while (true) {
                    int iNextClearBit = this._paramsSeenBig.nextClearBit(i);
                    if (iNextClearBit >= length) {
                        break;
                    }
                    this._creatorParameters[iNextClearBit] = _findMissing(settableBeanPropertyArr[iNextClearBit]);
                    i = iNextClearBit + 1;
                }
            } else {
                int i3 = this._paramsSeen;
                int length2 = this._creatorParameters.length;
                int i10 = 0;
                while (i10 < length2) {
                    if ((i3 & 1) == 0) {
                        this._creatorParameters[i10] = _findMissing(settableBeanPropertyArr[i10]);
                    }
                    i10++;
                    i3 >>= 1;
                }
            }
        }
        SettableAnyProperty settableAnyProperty = this._anyParamSetter;
        if (settableAnyProperty != null) {
            this._creatorParameters[settableAnyProperty.getParameterIndex()] = _createAndSetAnySetterValue();
        }
        if (this._context.isEnabled(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)) {
            for (int i11 = 0; i11 < settableBeanPropertyArr.length; i11++) {
                if (this._creatorParameters[i11] == null) {
                    SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i11];
                    this._context.reportInputMismatch(settableBeanProperty, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", settableBeanProperty.getName(), Integer.valueOf(settableBeanPropertyArr[i11].getCreatorIndex()));
                }
            }
        }
        return this._creatorParameters;
    }

    public Object handleIdValue(DeserializationContext deserializationContext, Object obj) {
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null) {
            Object obj2 = this._idValue;
            if (obj2 != null) {
                deserializationContext.findObjectId(obj2, objectIdReader.generator, objectIdReader.resolver).bindItem(obj);
                SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
                if (settableBeanProperty != null) {
                    return settableBeanProperty.setAndReturn(obj, this._idValue);
                }
            } else {
                deserializationContext.reportUnresolvedObjectId(objectIdReader, obj);
            }
        }
        return obj;
    }

    public final boolean hasParameter(SettableBeanProperty settableBeanProperty) {
        int creatorIndex = settableBeanProperty.getCreatorIndex();
        BitSet bitSet = this._paramsSeenBig;
        if (bitSet == null) {
            if (((this._paramsSeen >> creatorIndex) & 1) == 1) {
                return true;
            }
        } else if (bitSet.get(creatorIndex)) {
            return true;
        }
        SettableAnyProperty settableAnyProperty = this._anyParamSetter;
        return settableAnyProperty != null && creatorIndex == settableAnyProperty.getParameterIndex();
    }

    public boolean isComplete() {
        return this._paramsNeeded <= 0;
    }

    public boolean readIdProperty(String str) {
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader == null || !str.equals(objectIdReader.propertyName.getSimpleName())) {
            return false;
        }
        this._idValue = this._objectIdReader.readObjectReference(this._parser, this._context);
        return true;
    }

    @Deprecated
    public PropertyValueBuffer(JsonParser jsonParser, DeserializationContext deserializationContext, int i, ObjectIdReader objectIdReader) {
        this(jsonParser, deserializationContext, i, objectIdReader, null);
    }
}
