package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIgnoreProperties {

    public static class Value implements JacksonAnnotationValue<JsonIgnoreProperties>, Serializable {
        protected static final Value EMPTY = null;
        private static final long serialVersionUID = 1;
        protected final boolean _allowGetters;
        protected final boolean _allowSetters;
        protected final boolean _ignoreUnknown;
        protected final Set<String> _ignored;
        protected final boolean _merge;

        static {
            EMPTY = new Value(Collections.emptySet(), false, false, false, true);
        }

        public Value(Set<String> r3, boolean r4, boolean r5, boolean r6, boolean r7) {
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L5;
            this._ignored = Collections.emptySet();
        L6:
            this._ignoreUnknown = r4;
            this._allowGetters = r5;
            this._allowSetters = r6;
            this._merge = r7;
            return;
        L5:
            this._ignored = r8;
            goto L6
        }

        public static Value from(JsonIgnoreProperties r4) {
            JsonIgnoreProperties r5 = (JsonIgnoreProperties) ZeusTransformUtils.wrapperContextForParams(r4, JsonIgnoreProperties.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L7;
            return EMPTY;
        L7:
            return construct(_asSet(r5.value()), r5.ignoreUnknown(), r5.allowGetters(), r5.allowSetters(), false);
        }

        public static Value construct(Set<String> r6, boolean r7, boolean r8, boolean r9, boolean r10) {
            Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
            if (_empty(r1, r7, r8, r9, r10) == false) goto L7;
            return EMPTY;
        L7:
            return new Value(r1, r7, r8, r9, r10);
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value merge(Value r0, Value r1) {
            if (r0 != null) goto L5;
            return r1;
        L5:
            return r0.withOverrides(r1);
        }

        public static Value mergeAll(Value... r4) {
            int r0 = r4.length;
            Value r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            Value r3 = r4[r2];
            if (r3 == null) goto L10;
            if (r1 == null) goto L9;
            r3 = r1.withOverrides(r3);
        L9:
            r1 = r3;
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            return r1;
        }

        public static Value forIgnoredProperties(Set<String> r2) {
            Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
            return EMPTY.withIgnored(r3);
        }

        public static Value forIgnoredProperties(String... r1) {
            if (r1.length != 0) goto L7;
            return EMPTY;
        L7:
            return EMPTY.withIgnored(_asSet(r1));
        }

        public static Value forIgnoreUnknown(boolean r0) {
            if (r0 == false) goto L5;
            return EMPTY.withIgnoreUnknown();
        L5:
            return EMPTY.withoutIgnoreUnknown();
        }

        public Value withOverrides(Value r6) {
            if (r6 != null) goto L4;
            return this;
        L4:
            if (r6 != EMPTY) goto L7;
            return this;
        L7:
            if (r6._merge == true) goto L10;
            return r6;
        L10:
            if (_equals(this, r6) == false) goto L12;
            return this;
        L12:
            Set<String> r0 = _merge(this._ignored, r6._ignored);
            boolean r2 = false;
            if (this._ignoreUnknown == false) goto L15;
        L18:
            boolean r1 = true;
        L20:
            if (this._allowGetters == false) goto L22;
        L25:
            boolean r4 = true;
        L27:
            if (this._allowSetters == false) goto L29;
        L30:
            r2 = true;
        L32:
            return construct(r0, r1, r4, r2, true);
        L29:
            if (r6._allowSetters == false) goto L32;
        L22:
            if (r6._allowGetters == true) goto L25;
            r4 = false;
            goto L27
        L15:
            if (r6._ignoreUnknown == true) goto L18;
            r1 = false;
            goto L20
        }

        public Value withIgnored(Set<String> r4) {
            return construct((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withIgnored(String... r4) {
            return construct(_asSet(r4), this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withoutIgnored() {
            return construct(null, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withIgnoreUnknown() {
            if (this._ignoreUnknown == false) goto L6;
            return this;
        L6:
            return construct(this._ignored, true, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withoutIgnoreUnknown() {
            if (this._ignoreUnknown == true) goto L6;
            return this;
        L6:
            return construct(this._ignored, false, this._allowGetters, this._allowSetters, this._merge);
        }

        public Value withAllowGetters() {
            if (this._allowGetters == false) goto L6;
            return this;
        L6:
            return construct(this._ignored, this._ignoreUnknown, true, this._allowSetters, this._merge);
        }

        public Value withoutAllowGetters() {
            if (this._allowGetters == true) goto L6;
            return this;
        L6:
            return construct(this._ignored, this._ignoreUnknown, false, this._allowSetters, this._merge);
        }

        public Value withAllowSetters() {
            if (this._allowSetters == false) goto L6;
            return this;
        L6:
            return construct(this._ignored, this._ignoreUnknown, this._allowGetters, true, this._merge);
        }

        public Value withoutAllowSetters() {
            if (this._allowSetters == true) goto L6;
            return this;
        L6:
            return construct(this._ignored, this._ignoreUnknown, this._allowGetters, false, this._merge);
        }

        public Value withMerge() {
            if (this._merge == false) goto L6;
            return this;
        L6:
            return construct(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, true);
        }

        public Value withoutMerge() {
            if (this._merge == true) goto L6;
            return this;
        L6:
            return construct(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, false);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonIgnoreProperties> valueFor() {
            return JsonIgnoreProperties.class;
        }

        public Object readResolve() {
            if (_empty(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge) == true) goto L5;
            return this;
        L5:
            return EMPTY;
        }

        public Set<String> getIgnored() {
            return this._ignored;
        }

        public Set<String> findIgnoredForSerialization() {
            if (this._allowGetters == false) goto L7;
            return Collections.emptySet();
        L7:
            return this._ignored;
        }

        public Set<String> findIgnoredForDeserialization() {
            if (this._allowSetters == false) goto L7;
            return Collections.emptySet();
        L7:
            return this._ignored;
        }

        public boolean getIgnoreUnknown() {
            return this._ignoreUnknown;
        }

        public boolean getAllowGetters() {
            return this._allowGetters;
        }

        public boolean getAllowSetters() {
            return this._allowSetters;
        }

        public boolean getMerge() {
            return this._merge;
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", new Object[]{this._ignored, Boolean.valueOf(this._ignoreUnknown), Boolean.valueOf(this._allowGetters), Boolean.valueOf(this._allowSetters), Boolean.valueOf(this._merge)});
        }

        public int hashCode() {
            int r0 = this._ignored.size();
            if (this._ignoreUnknown == false) goto L5;
            int r1 = 1;
        L6:
            int r2 = r0 + r1;
            if (this._allowGetters == false) goto L9;
            int r3 = 3;
        L10:
            int r4 = r2 + r3;
            if (this._allowSetters == false) goto L13;
            int r5 = 7;
        L14:
            int r6 = r4 + r5;
            if (this._merge == false) goto L17;
            int r7 = 11;
        L19:
            return r6 + r7;
        L17:
            r7 = -13;
            goto L19
        L13:
            r5 = -11;
            goto L14
        L9:
            r3 = -7;
            goto L10
        L5:
            r1 = -3;
            goto L6
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

        private static boolean _equals(Value r2, Value r3) {
            if (r2._ignoreUnknown == r3._ignoreUnknown) goto L5;
        L13:
            return false;
        L5:
            if (r2._merge != r3._merge) goto L13;
            if (r2._allowGetters != r3._allowGetters) goto L13;
            if (r2._allowSetters != r3._allowSetters) goto L13;
            if (r2._ignored.equals(r3._ignored) == false) goto L13;
            return true;
        }

        private static Set<String> _asSet(String[] r4) {
            if (r4 == null) goto L11;
            if (r4.length == 0) goto L11;
            HashSet r0 = new HashSet(r4.length);
            int r1 = r4.length;
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L9;
            r0.add(r4[r2]);
            r2 = r2 + 1;
            goto L7
        L9:
            return r0;
        L11:
            return Collections.emptySet();
        }

        private static Set<String> _merge(Set<String> r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            if (r5.isEmpty() == false) goto L6;
            return r6;
        L6:
            if (r6.isEmpty() == false) goto L8;
            return r5;
        L8:
            HashSet r0 = new HashSet(r5.size() + r6.size());
            r0.addAll(r5);
            r0.addAll(r6);
            return r0;
        }

        private static boolean _empty(Set<String> r3, boolean r4, boolean r5, boolean r6, boolean r7) {
            Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            Value r0 = EMPTY;
            if (r4 == r0._ignoreUnknown) goto L5;
            return false;
        L5:
            if (r5 == r0._allowGetters) goto L7;
            return false;
        L7:
            if (r6 == r0._allowSetters) goto L9;
            return false;
        L9:
            if (r7 != r0._merge) goto L18;
            if (r8 != null) goto L12;
        L13:
            return true;
        L12:
            if (r8.size() == 0) goto L13;
            return false;
        L18:
            return false;
        }
    }

    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};
}
