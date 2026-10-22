package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.util.List;

/* loaded from: classes2.dex */
public class PotentialCreator {
    private static final PropertyName[] NO_NAMES = new PropertyName[0];
    private final AnnotatedWithParams _creator;
    private JsonCreator.Mode _creatorMode;
    private PropertyName[] _explicitParamNames;
    private PropertyName[] _implicitParamNames;
    private final boolean _isAnnotated;
    private List<BeanPropertyDefinition> _propertyDefs;

    public PotentialCreator(AnnotatedWithParams annotatedWithParams, JsonCreator.Mode mode) {
        this._creator = annotatedWithParams;
        this._isAnnotated = mode != null;
        this._creatorMode = mode == null ? JsonCreator.Mode.DEFAULT : mode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void assignPropertyDefs(List<? extends BeanPropertyDefinition> list) {
        this._propertyDefs = list;
    }

    public AnnotatedWithParams creator() {
        return this._creator;
    }

    public JsonCreator.Mode creatorMode() {
        return this._creatorMode;
    }

    public JsonCreator.Mode creatorModeOrDefault() {
        JsonCreator.Mode mode = this._creatorMode;
        return mode == null ? JsonCreator.Mode.DEFAULT : mode;
    }

    public PropertyName explicitName(int i10) {
        return this._explicitParamNames[i10];
    }

    public boolean hasExplicitNames() {
        int length = this._explicitParamNames.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this._explicitParamNames[i10] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNameFor(int i10) {
        return (this._explicitParamNames[i10] == null && this._implicitParamNames[i10] == null) ? false : true;
    }

    public boolean hasNameOrInjectForAllParams(MapperConfig<?> mapperConfig) {
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        int length = this._implicitParamNames.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!hasNameFor(i10) && (annotationIntrospector == null || annotationIntrospector.findInjectableValue(this._creator.getParameter(i10)) == null)) {
                return false;
            }
        }
        return true;
    }

    public PropertyName implicitName(int i10) {
        return this._implicitParamNames[i10];
    }

    public String implicitNameSimple(int i10) {
        PropertyName propertyName = this._implicitParamNames[i10];
        if (propertyName == null) {
            return null;
        }
        return propertyName.getSimpleName();
    }

    public PotentialCreator introspectParamNames(MapperConfig<?> mapperConfig) {
        if (this._implicitParamNames == null) {
            int parameterCount = this._creator.getParameterCount();
            if (parameterCount == 0) {
                PropertyName[] propertyNameArr = NO_NAMES;
                this._explicitParamNames = propertyNameArr;
                this._implicitParamNames = propertyNameArr;
                return this;
            }
            this._explicitParamNames = new PropertyName[parameterCount];
            this._implicitParamNames = new PropertyName[parameterCount];
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            for (int i10 = 0; i10 < parameterCount; i10++) {
                AnnotatedParameter parameter = this._creator.getParameter(i10);
                String strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(parameter);
                if (strFindImplicitPropertyName != null && !strFindImplicitPropertyName.isEmpty()) {
                    this._implicitParamNames[i10] = PropertyName.construct(strFindImplicitPropertyName);
                }
                PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(parameter);
                if (propertyNameFindNameForDeserialization != null && !propertyNameFindNameForDeserialization.isEmpty()) {
                    this._explicitParamNames[i10] = propertyNameFindNameForDeserialization;
                }
            }
        }
        return this;
    }

    public boolean isAnnotated() {
        return this._isAnnotated;
    }

    public PotentialCreator overrideMode(JsonCreator.Mode mode) {
        this._creatorMode = mode;
        return this;
    }

    public AnnotatedParameter param(int i10) {
        return this._creator.getParameter(i10);
    }

    public int paramCount() {
        return this._creator.getParameterCount();
    }

    public BeanPropertyDefinition[] propertyDefs() {
        List<BeanPropertyDefinition> list = this._propertyDefs;
        if (list == null || list.isEmpty()) {
            return new BeanPropertyDefinition[0];
        }
        List<BeanPropertyDefinition> list2 = this._propertyDefs;
        return (BeanPropertyDefinition[]) list2.toArray(new BeanPropertyDefinition[list2.size()]);
    }

    public String toString() {
        return "(mode=" + this._creatorMode + ")" + this._creator;
    }

    public PotentialCreator introspectParamNames(MapperConfig<?> mapperConfig, PropertyName[] propertyNameArr) {
        if (this._implicitParamNames == null) {
            int parameterCount = this._creator.getParameterCount();
            if (parameterCount == 0) {
                PropertyName[] propertyNameArr2 = NO_NAMES;
                this._explicitParamNames = propertyNameArr2;
                this._implicitParamNames = propertyNameArr2;
                return this;
            }
            this._explicitParamNames = new PropertyName[parameterCount];
            this._implicitParamNames = propertyNameArr;
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            for (int i10 = 0; i10 < parameterCount; i10++) {
                PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(this._creator.getParameter(i10));
                if (propertyNameFindNameForDeserialization != null && !propertyNameFindNameForDeserialization.isEmpty()) {
                    this._explicitParamNames[i10] = propertyNameFindNameForDeserialization;
                }
            }
        }
        return this;
    }
}
