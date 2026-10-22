package com.fasterxml.jackson.annotation;

import androidx.activity.b;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonTypeInfo {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        SIMPLE_NAME("@type"),
        DEDUCTION(null),
        CUSTOM(null);

        private final String _defaultPropertyName;

        Id(String str) {
            this._defaultPropertyName = str;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static abstract class None {
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Value implements JacksonAnnotationValue<JsonTypeInfo>, Serializable {
        protected static final Value EMPTY = new Value(Id.NONE, As.PROPERTY, null, null, false, null);
        private static final long serialVersionUID = 1;
        protected final Class<?> _defaultImpl;
        protected final Id _idType;
        protected final boolean _idVisible;
        protected final As _inclusionType;
        protected final String _propertyName;
        protected final Boolean _requireTypeIdForSubtypes;

        public Value(Id id2, As as, String str, Class<?> cls, boolean z10, Boolean bool) {
            this._defaultImpl = cls;
            this._idType = id2;
            this._inclusionType = as;
            this._propertyName = str;
            this._idVisible = z10;
            this._requireTypeIdForSubtypes = bool;
        }

        private static <T> boolean _equal(T t10, T t11) {
            if (t10 == null) {
                return t11 == null;
            }
            if (t11 == null) {
                return false;
            }
            return t10.equals(t11);
        }

        private static boolean _equals(Value value, Value value2) {
            return value._idType == value2._idType && value._inclusionType == value2._inclusionType && value._defaultImpl == value2._defaultImpl && value._idVisible == value2._idVisible && _equal(value._propertyName, value2._propertyName) && _equal(value._requireTypeIdForSubtypes, value2._requireTypeIdForSubtypes);
        }

        public static Value construct(Id id2, As as, String str, Class<?> cls, boolean z10, Boolean bool) {
            if (str == null || str.isEmpty()) {
                str = id2 != null ? id2.getDefaultPropertyName() : "";
            }
            String str2 = str;
            if (cls == null || cls.isAnnotation()) {
                cls = null;
            }
            return new Value(id2, as, str2, cls, z10, bool);
        }

        public static Value from(JsonTypeInfo jsonTypeInfo) {
            if (jsonTypeInfo == null) {
                return null;
            }
            return construct(jsonTypeInfo.use(), jsonTypeInfo.include(), jsonTypeInfo.property(), jsonTypeInfo.defaultImpl(), jsonTypeInfo.visible(), jsonTypeInfo.requireTypeIdForSubtypes().asBoolean());
        }

        public static boolean isEnabled(Value value) {
            Id id2;
            return (value == null || (id2 = value._idType) == null || id2 == Id.NONE) ? false : true;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == getClass() && _equals(this, (Value) obj);
        }

        public Class<?> getDefaultImpl() {
            return this._defaultImpl;
        }

        public Id getIdType() {
            return this._idType;
        }

        public boolean getIdVisible() {
            return this._idVisible;
        }

        public As getInclusionType() {
            return this._inclusionType;
        }

        public String getPropertyName() {
            return this._propertyName;
        }

        public Boolean getRequireTypeIdForSubtypes() {
            return this._requireTypeIdForSubtypes;
        }

        public int hashCode() {
            Id id2 = this._idType;
            int iHashCode = ((id2 != null ? id2.hashCode() : 0) + 31) * 31;
            As as = this._inclusionType;
            int iHashCode2 = (iHashCode + (as != null ? as.hashCode() : 0)) * 31;
            String str = this._propertyName;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Class<?> cls = this._defaultImpl;
            return ((((iHashCode3 + (cls != null ? cls.hashCode() : 0)) * 31) + (this._requireTypeIdForSubtypes.booleanValue() ? 11 : -17)) * 31) + (this._idVisible ? 11 : -17);
        }

        public String toString() {
            Id id2 = this._idType;
            As as = this._inclusionType;
            String str = this._propertyName;
            Class<?> cls = this._defaultImpl;
            String name = cls == null ? "NULL" : cls.getName();
            boolean z10 = this._idVisible;
            Boolean bool = this._requireTypeIdForSubtypes;
            StringBuilder sb2 = new StringBuilder("JsonTypeInfo.Value(idType=");
            sb2.append(id2);
            sb2.append(",includeAs=");
            sb2.append(as);
            sb2.append(",propertyName=");
            b.u(sb2, str, ",defaultImpl=", name, ",idVisible=");
            sb2.append(z10);
            sb2.append(",requireTypeIdForSubtypes=");
            sb2.append(bool);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonTypeInfo> valueFor() {
            return JsonTypeInfo.class;
        }

        public Value withDefaultImpl(Class<?> cls) {
            return cls == this._defaultImpl ? this : new Value(this._idType, this._inclusionType, this._propertyName, cls, this._idVisible, this._requireTypeIdForSubtypes);
        }

        public Value withIdType(Id id2) {
            return id2 == this._idType ? this : new Value(id2, this._inclusionType, this._propertyName, this._defaultImpl, this._idVisible, this._requireTypeIdForSubtypes);
        }

        public Value withIdVisible(boolean z10) {
            return z10 == this._idVisible ? this : new Value(this._idType, this._inclusionType, this._propertyName, this._defaultImpl, z10, this._requireTypeIdForSubtypes);
        }

        public Value withInclusionType(As as) {
            return as == this._inclusionType ? this : new Value(this._idType, as, this._propertyName, this._defaultImpl, this._idVisible, this._requireTypeIdForSubtypes);
        }

        public Value withPropertyName(String str) {
            return str == this._propertyName ? this : new Value(this._idType, this._inclusionType, str, this._defaultImpl, this._idVisible, this._requireTypeIdForSubtypes);
        }

        public Value withRequireTypeIdForSubtypes(Boolean bool) {
            return this._requireTypeIdForSubtypes == bool ? this : new Value(this._idType, this._inclusionType, this._propertyName, this._defaultImpl, this._idVisible, bool);
        }
    }

    Class<?> defaultImpl() default JsonTypeInfo.class;

    As include() default As.PROPERTY;

    String property() default "";

    OptBoolean requireTypeIdForSubtypes() default OptBoolean.DEFAULT;

    Id use();

    boolean visible() default false;
}
