package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface JsonAutoDetect {

    /* renamed from: com.fasterxml.jackson.annotation.JsonAutoDetect$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility;
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor;

        static {
            int[] iArr = new int[PropertyAccessor.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor = iArr;
            try {
                iArr[PropertyAccessor.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.IS_GETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.SETTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.CREATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.SCALAR_CONSTRUCTOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.ALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[Visibility.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility = iArr2;
            try {
                iArr2[Visibility.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.NON_PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.PROTECTED_AND_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.PUBLIC_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum Visibility {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean isVisible(Member member) {
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[ordinal()];
            if (i == 1) {
                return true;
            }
            if (i == 3) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (i != 4) {
                if (i != 5) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    Visibility creatorVisibility() default Visibility.DEFAULT;

    Visibility fieldVisibility() default Visibility.DEFAULT;

    Visibility getterVisibility() default Visibility.DEFAULT;

    Visibility isGetterVisibility() default Visibility.DEFAULT;

    Visibility scalarConstructorVisibility() default Visibility.DEFAULT;

    Visibility setterVisibility() default Visibility.DEFAULT;

    public static class Value implements JacksonAnnotationValue<JsonAutoDetect>, Serializable {
        protected static final Value DEFAULT;
        private static final Visibility DEFAULT_FIELD_VISIBILITY;
        protected static final Value NO_OVERRIDES;
        private static final long serialVersionUID = 1;
        protected final Visibility _creatorVisibility;
        protected final Visibility _fieldVisibility;
        protected final Visibility _getterVisibility;
        protected final Visibility _isGetterVisibility;
        protected final Visibility _scalarConstructorVisibility;
        protected final Visibility _setterVisibility;

        static {
            Visibility visibility = Visibility.PUBLIC_ONLY;
            DEFAULT_FIELD_VISIBILITY = visibility;
            DEFAULT = new Value(visibility, visibility, visibility, Visibility.ANY, visibility, Visibility.NON_PRIVATE);
            Visibility visibility2 = Visibility.DEFAULT;
            NO_OVERRIDES = new Value(visibility2, visibility2, visibility2, visibility2, visibility2, visibility2);
        }

        private Value(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5, Visibility visibility6) {
            this._fieldVisibility = visibility;
            this._getterVisibility = visibility2;
            this._isGetterVisibility = visibility3;
            this._setterVisibility = visibility4;
            this._creatorVisibility = visibility5;
            this._scalarConstructorVisibility = visibility6;
        }

        private static boolean _equals(Value value, Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5, Visibility visibility6) {
            return value._fieldVisibility == visibility && value._getterVisibility == visibility2 && value._isGetterVisibility == visibility3 && value._setterVisibility == visibility4 && value._creatorVisibility == visibility5 && value._scalarConstructorVisibility == visibility6;
        }

        private static Visibility _override(Visibility visibility, Visibility visibility2) {
            return visibility2 == Visibility.DEFAULT ? visibility : visibility2;
        }

        private static Value _predefined(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5, Visibility visibility6) {
            if (visibility == DEFAULT_FIELD_VISIBILITY) {
                Value value = DEFAULT;
                if (visibility2 == value._getterVisibility && visibility3 == value._isGetterVisibility && visibility4 == value._setterVisibility && visibility5 == value._creatorVisibility && visibility6 == value._scalarConstructorVisibility) {
                    return value;
                }
                return null;
            }
            Visibility visibility7 = Visibility.DEFAULT;
            if (visibility == visibility7 && visibility2 == visibility7 && visibility3 == visibility7 && visibility4 == visibility7 && visibility5 == visibility7 && visibility6 == visibility7) {
                return NO_OVERRIDES;
            }
            return null;
        }

        public static Value construct(PropertyAccessor propertyAccessor, Visibility visibility) {
            Visibility visibility2;
            Visibility visibility3;
            Visibility visibility4;
            Visibility visibility5;
            Visibility visibility6;
            Visibility visibility7;
            Visibility visibility8 = Visibility.DEFAULT;
            switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[propertyAccessor.ordinal()]) {
                case 1:
                    visibility2 = visibility;
                    visibility3 = visibility8;
                    visibility4 = visibility3;
                    visibility5 = visibility4;
                    visibility6 = visibility5;
                    visibility7 = visibility6;
                    break;
                case 2:
                    visibility3 = visibility;
                    visibility2 = visibility8;
                    visibility4 = visibility2;
                    visibility5 = visibility4;
                    visibility6 = visibility5;
                    visibility7 = visibility6;
                    break;
                case 3:
                    visibility4 = visibility;
                    visibility2 = visibility8;
                    visibility3 = visibility2;
                    visibility5 = visibility3;
                    visibility6 = visibility5;
                    visibility7 = visibility6;
                    break;
                case 4:
                    visibility5 = visibility;
                    visibility2 = visibility8;
                    visibility3 = visibility2;
                    visibility4 = visibility3;
                    visibility6 = visibility4;
                    visibility7 = visibility6;
                    break;
                case 5:
                    visibility6 = visibility;
                    visibility2 = visibility8;
                    visibility3 = visibility2;
                    visibility4 = visibility3;
                    visibility5 = visibility4;
                    visibility7 = visibility5;
                    break;
                case 6:
                    visibility7 = visibility;
                    visibility2 = visibility8;
                    visibility3 = visibility2;
                    visibility4 = visibility3;
                    visibility5 = visibility4;
                    visibility6 = visibility5;
                    break;
                case 7:
                default:
                    visibility2 = visibility8;
                    visibility3 = visibility2;
                    visibility4 = visibility3;
                    visibility5 = visibility4;
                    visibility6 = visibility5;
                    visibility7 = visibility6;
                    break;
                case 8:
                    visibility2 = visibility;
                    visibility3 = visibility2;
                    visibility4 = visibility3;
                    visibility5 = visibility4;
                    visibility6 = visibility5;
                    visibility7 = visibility6;
                    break;
            }
            return construct(visibility2, visibility3, visibility4, visibility5, visibility6, visibility7);
        }

        public static Value defaultVisibility() {
            return DEFAULT;
        }

        public static Value from(JsonAutoDetect jsonAutoDetect) {
            return construct(jsonAutoDetect.fieldVisibility(), jsonAutoDetect.getterVisibility(), jsonAutoDetect.isGetterVisibility(), jsonAutoDetect.setterVisibility(), jsonAutoDetect.creatorVisibility(), jsonAutoDetect.scalarConstructorVisibility());
        }

        public static Value merge(Value value, Value value2) {
            return value == null ? value2 : value.withOverrides(value2);
        }

        public static Value noOverrides() {
            return NO_OVERRIDES;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            return _equals(this, value._fieldVisibility, value._getterVisibility, value._isGetterVisibility, value._setterVisibility, value._creatorVisibility, value._scalarConstructorVisibility);
        }

        public Visibility getCreatorVisibility() {
            return this._creatorVisibility;
        }

        public Visibility getFieldVisibility() {
            return this._fieldVisibility;
        }

        public Visibility getGetterVisibility() {
            return this._getterVisibility;
        }

        public Visibility getIsGetterVisibility() {
            return this._isGetterVisibility;
        }

        public Visibility getScalarConstructorVisibility() {
            return this._scalarConstructorVisibility;
        }

        public Visibility getSetterVisibility() {
            return this._setterVisibility;
        }

        public int hashCode() {
            return ((this._scalarConstructorVisibility.ordinal() * 17) + (this._creatorVisibility.ordinal() * 13)) ^ ((this._fieldVisibility.ordinal() + 1) ^ ((this._setterVisibility.ordinal() * 11) + ((this._getterVisibility.ordinal() * 3) - (this._isGetterVisibility.ordinal() * 7))));
        }

        public Object readResolve() {
            Value value_predefined = _predefined(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility, this._scalarConstructorVisibility);
            return value_predefined == null ? this : value_predefined;
        }

        public String toString() {
            return "JsonAutoDetect.Value(fields=" + this._fieldVisibility + ",getters=" + this._getterVisibility + ",isGetters=" + this._isGetterVisibility + ",setters=" + this._setterVisibility + ",creators=" + this._creatorVisibility + ",scalarConstructors=" + this._scalarConstructorVisibility + ")";
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonAutoDetect> valueFor() {
            return JsonAutoDetect.class;
        }

        public Value withCreatorVisibility(Visibility visibility) {
            return construct(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, visibility, this._scalarConstructorVisibility);
        }

        public Value withFieldVisibility(Visibility visibility) {
            return construct(visibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility, this._scalarConstructorVisibility);
        }

        public Value withGetterVisibility(Visibility visibility) {
            return construct(this._fieldVisibility, visibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility, this._scalarConstructorVisibility);
        }

        public Value withIsGetterVisibility(Visibility visibility) {
            return construct(this._fieldVisibility, this._getterVisibility, visibility, this._setterVisibility, this._creatorVisibility, this._scalarConstructorVisibility);
        }

        public Value withOverrides(Value value) {
            if (value == null || value == NO_OVERRIDES || value == this) {
                return this;
            }
            Visibility visibility_override = _override(this._fieldVisibility, value._fieldVisibility);
            Visibility visibility_override2 = _override(this._getterVisibility, value._getterVisibility);
            Visibility visibility_override3 = _override(this._isGetterVisibility, value._isGetterVisibility);
            Visibility visibility_override4 = _override(this._setterVisibility, value._setterVisibility);
            Visibility visibility_override5 = _override(this._creatorVisibility, value._creatorVisibility);
            Visibility visibility_override6 = _override(this._scalarConstructorVisibility, value._scalarConstructorVisibility);
            return _equals(this, visibility_override, visibility_override2, visibility_override3, visibility_override4, visibility_override5, visibility_override6) ? this : construct(visibility_override, visibility_override2, visibility_override3, visibility_override4, visibility_override5, visibility_override6);
        }

        public Value withScalarConstructorVisibility(Visibility visibility) {
            return construct(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility, visibility);
        }

        public Value withSetterVisibility(Visibility visibility) {
            return construct(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, visibility, this._creatorVisibility, this._scalarConstructorVisibility);
        }

        public static Value construct(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5) {
            return construct(visibility, visibility2, visibility3, visibility4, visibility5, Visibility.DEFAULT);
        }

        public static Value construct(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5, Visibility visibility6) {
            Value value_predefined = _predefined(visibility, visibility2, visibility3, visibility4, visibility5, visibility6);
            return value_predefined == null ? new Value(visibility, visibility2, visibility3, visibility4, visibility5, visibility6) : value_predefined;
        }
    }
}
