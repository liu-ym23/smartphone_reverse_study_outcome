package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAutoDetect {

    /* JADX INFO: renamed from: com.fasterxml.jackson.annotation.JsonAutoDetect$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility = null;
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor = null;

        static {
            int[] r0 = new int[PropertyAccessor.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor = r0;
            r0[PropertyAccessor.CREATOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.FIELD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L41:
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.GETTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L55:
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.IS_GETTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L37:
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L45:
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.SETTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L47:
            $SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[PropertyAccessor.ALL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r5 = new int[Visibility.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility = r5;
            r5[Visibility.ANY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L39:
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L43:
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.NON_PRIVATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L53:
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.PROTECTED_AND_PUBLIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L33:
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.PUBLIC_ONLY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    public static class Value implements JacksonAnnotationValue<JsonAutoDetect>, Serializable {
        protected static final Value DEFAULT = null;
        private static final Visibility DEFAULT_FIELD_VISIBILITY = null;
        protected static final Value NO_OVERRIDES = null;
        private static final long serialVersionUID = 1;
        protected final Visibility _creatorVisibility;
        protected final Visibility _fieldVisibility;
        protected final Visibility _getterVisibility;
        protected final Visibility _isGetterVisibility;
        protected final Visibility _setterVisibility;

        static {
            Visibility r1 = Visibility.PUBLIC_ONLY;
            DEFAULT_FIELD_VISIBILITY = r1;
            DEFAULT = new Value(r1, Visibility.PUBLIC_ONLY, Visibility.PUBLIC_ONLY, Visibility.ANY, Visibility.PUBLIC_ONLY);
            NO_OVERRIDES = new Value(Visibility.DEFAULT, Visibility.DEFAULT, Visibility.DEFAULT, Visibility.DEFAULT, Visibility.DEFAULT);
        }

        private Value(Visibility r1, Visibility r2, Visibility r3, Visibility r4, Visibility r5) {
            this._fieldVisibility = r1;
            this._getterVisibility = r2;
            this._isGetterVisibility = r3;
            this._setterVisibility = r4;
            this._creatorVisibility = r5;
        }

        public static Value defaultVisibility() {
            return DEFAULT;
        }

        public static Value noOverrides() {
            return NO_OVERRIDES;
        }

        public static Value from(JsonAutoDetect r4) {
            JsonAutoDetect r5 = (JsonAutoDetect) ZeusTransformUtils.wrapperContextForParams(r4, JsonAutoDetect.class, "com.obric.aiagent.plugin");
            return construct(r5.fieldVisibility(), r5.getterVisibility(), r5.isGetterVisibility(), r5.setterVisibility(), r5.creatorVisibility());
        }

        public static Value construct(PropertyAccessor r6, Visibility r7) {
            Visibility r0 = Visibility.DEFAULT;
            Visibility r1 = Visibility.DEFAULT;
            Visibility r2 = Visibility.DEFAULT;
            Visibility r3 = Visibility.DEFAULT;
            Visibility r4 = Visibility.DEFAULT;
            int r8 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[r6.ordinal()];
            if (r8 != 1) goto L5;
            r4 = r7;
        L14:
            r7 = r0;
        L21:
            return construct(r7, r1, r2, r3, r4);
        L5:
            if (r8 == 2) goto L21;
            if (r8 != 3) goto L9;
            r1 = r7;
            goto L14
        L9:
            if (r8 != 4) goto L11;
            r2 = r7;
            goto L14
        L11:
            if (r8 != 6) goto L13;
            r3 = r7;
            goto L14
        L13:
            if (r8 != 7) goto L14;
            r1 = r7;
            r2 = r1;
            r3 = r2;
            r4 = r3;
            goto L21
        }

        public static Value construct(Visibility r7, Visibility r8, Visibility r9, Visibility r10, Visibility r11) {
            Value r0 = _predefined(r7, r8, r9, r10, r11);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new Value(r7, r8, r9, r10, r11);
        }

        public Value withFieldVisibility(Visibility r4) {
            return construct(r4, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility);
        }

        public Value withGetterVisibility(Visibility r4) {
            return construct(this._fieldVisibility, r4, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility);
        }

        public Value withIsGetterVisibility(Visibility r4) {
            return construct(this._fieldVisibility, this._getterVisibility, r4, this._setterVisibility, this._creatorVisibility);
        }

        public Value withSetterVisibility(Visibility r4) {
            return construct(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, r4, this._creatorVisibility);
        }

        public Value withCreatorVisibility(Visibility r4) {
            return construct(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, r4);
        }

        public static Value merge(Value r0, Value r1) {
            if (r0 != null) goto L5;
            return r1;
        L5:
            return r0.withOverrides(r1);
        }

        public Value withOverrides(Value r6) {
            if (r6 != null) goto L4;
            return this;
        L4:
            if (r6 == NO_OVERRIDES) goto L28;
            if (r6 != this) goto L8;
            return this;
        L8:
            if (_equals(this, r6) == false) goto L10;
            return this;
        L10:
            Visibility r0 = r6._fieldVisibility;
            if (r0 != Visibility.DEFAULT) goto L13;
            r0 = this._fieldVisibility;
        L13:
            Visibility r1 = r6._getterVisibility;
            if (r1 != Visibility.DEFAULT) goto L16;
            r1 = this._getterVisibility;
        L16:
            Visibility r2 = r6._isGetterVisibility;
            if (r2 != Visibility.DEFAULT) goto L19;
            r2 = this._isGetterVisibility;
        L19:
            Visibility r3 = r6._setterVisibility;
            if (r3 != Visibility.DEFAULT) goto L22;
            r3 = this._setterVisibility;
        L22:
            Visibility r7 = r6._creatorVisibility;
            if (r7 != Visibility.DEFAULT) goto L26;
            r7 = this._creatorVisibility;
        L26:
            return construct(r0, r1, r2, r3, r7);
        L28:
            return this;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonAutoDetect> valueFor() {
            return JsonAutoDetect.class;
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

        public Visibility getSetterVisibility() {
            return this._setterVisibility;
        }

        public Visibility getCreatorVisibility() {
            return this._creatorVisibility;
        }

        public Object readResolve() {
            Value r0 = _predefined(this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility);
            if (r0 != null) goto L6;
            return this;
        L6:
            return r0;
        }

        public String toString() {
            return String.format("JsonAutoDetect.Value(fields=%s,getters=%s,isGetters=%s,setters=%s,creators=%s)", new Object[]{this._fieldVisibility, this._getterVisibility, this._isGetterVisibility, this._setterVisibility, this._creatorVisibility});
        }

        public int hashCode() {
            int r0 = (this._fieldVisibility.ordinal() + 1) ^ (((this._getterVisibility.ordinal() * 3) - (this._isGetterVisibility.ordinal() * 7)) + (this._setterVisibility.ordinal() * 11));
            return (this._creatorVisibility.ordinal() * 13) ^ r0;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() != getClass()) goto L14;
            if (_equals(this, (Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.aiagent.plugin")) == false) goto L14;
            return true;
        L14:
            return false;
        }

        private static Value _predefined(Visibility r1, Visibility r2, Visibility r3, Visibility r4, Visibility r5) {
            if (r1 != DEFAULT_FIELD_VISIBILITY) goto L14;
            Value r6 = DEFAULT;
            if (r2 == r6._getterVisibility) goto L7;
            return null;
        L7:
            if (r3 == r6._isGetterVisibility) goto L9;
            return null;
        L9:
            if (r4 == r6._setterVisibility) goto L11;
            return null;
        L11:
            if (r5 != r6._creatorVisibility) goto L29;
            return r6;
        L29:
            return null;
        L14:
            if (r1 == Visibility.DEFAULT) goto L16;
            return null;
        L16:
            if (r2 == Visibility.DEFAULT) goto L18;
            return null;
        L18:
            if (r3 == Visibility.DEFAULT) goto L20;
            return null;
        L20:
            if (r4 == Visibility.DEFAULT) goto L22;
            return null;
        L22:
            if (r5 == Visibility.DEFAULT) goto L24;
            return null;
        L24:
            return NO_OVERRIDES;
        }

        private static boolean _equals(Value r2, Value r3) {
            if (r2._fieldVisibility == r3._fieldVisibility) goto L5;
        L13:
            return false;
        L5:
            if (r2._getterVisibility != r3._getterVisibility) goto L13;
            if (r2._isGetterVisibility != r3._isGetterVisibility) goto L13;
            if (r2._setterVisibility != r3._setterVisibility) goto L13;
            if (r2._creatorVisibility != r3._creatorVisibility) goto L13;
            return true;
        }
    }

    public static final enum Visibility extends Enum<Visibility> {
        private static final /* synthetic */ Visibility[] $VALUES = null;
        public static final Visibility ANY = null;
        public static final Visibility DEFAULT = null;
        public static final Visibility NONE = null;
        public static final Visibility NON_PRIVATE = null;
        public static final Visibility PROTECTED_AND_PUBLIC = null;
        public static final Visibility PUBLIC_ONLY = null;

        private Visibility(String r1, int r2) {
            super(r1, r2);
        }

        public static Visibility valueOf(String r2) {
            return (Visibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(Visibility.class, r2), Visibility.class, "com.obric.aiagent.plugin");
        }

        public static Visibility[] values() {
            return (Visibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Visibility[].class, "com.obric.aiagent.plugin");
        }

        static {
            Visibility r0 = new Visibility("ANY", 0);
            ANY = r0;
            Visibility r1 = new Visibility("NON_PRIVATE", 1);
            NON_PRIVATE = r1;
            Visibility r3 = new Visibility("PROTECTED_AND_PUBLIC", 2);
            PROTECTED_AND_PUBLIC = r3;
            Visibility r5 = new Visibility("PUBLIC_ONLY", 3);
            PUBLIC_ONLY = r5;
            Visibility r7 = new Visibility("NONE", 4);
            NONE = r7;
            Visibility r9 = new Visibility("DEFAULT", 5);
            DEFAULT = r9;
            $VALUES = new Visibility[]{r0, r1, r3, r5, r7, r9};
        }

        public boolean isVisible(Member r3) {
            Member r4 = (Member) ZeusTransformUtils.wrapperContextForParams(r3, Member.class, "com.obric.aiagent.plugin");
            int r2 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[ordinal()];
            if (r2 != 1) goto L5;
            return true;
        L5:
            if (r2 == 3) goto L18;
            if (r2 == 4) goto L13;
            if (r2 == 5) goto L16;
            return false;
        L16:
            return Modifier.isPublic(r4.getModifiers());
        L13:
            if (Modifier.isProtected(r4.getModifiers()) == false) goto L16;
            return true;
        L18:
            return !Modifier.isPrivate(r4.getModifiers());
        }
    }

    Visibility creatorVisibility() default Visibility.DEFAULT;

    Visibility fieldVisibility() default Visibility.DEFAULT;

    Visibility getterVisibility() default Visibility.DEFAULT;

    Visibility isGetterVisibility() default Visibility.DEFAULT;

    Visibility setterVisibility() default Visibility.DEFAULT;
}
