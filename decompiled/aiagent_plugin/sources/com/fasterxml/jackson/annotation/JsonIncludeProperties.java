package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIncludeProperties {

    public static class Value implements JacksonAnnotationValue<JsonIncludeProperties>, Serializable {
        protected static final Value ALL = null;
        private static final long serialVersionUID = 1;
        protected final Set<String> _included;

        static {
            ALL = new Value(null);
        }

        public Value(Set<String> r3) {
            this._included = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        }

        public static Value from(JsonIncludeProperties r2) {
            JsonIncludeProperties r3 = (JsonIncludeProperties) ZeusTransformUtils.wrapperContextForParams(r2, JsonIncludeProperties.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L7;
            return ALL;
        L7:
            return new Value(_asSet(r3.value()));
        }

        public static Value all() {
            return ALL;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonIncludeProperties> valueFor() {
            return JsonIncludeProperties.class;
        }

        public Set<String> getIncluded() {
            return this._included;
        }

        public Value withOverrides(Value r5) {
            if (r5 == null) goto L22;
            Set<String> r0 = r5.getIncluded();
            if (r0 != null) goto L7;
            return this;
        L7:
            if (this._included != null) goto L9;
            return r5;
        L9:
            HashSet r6 = new HashSet();
            Iterator<String> r1 = r0.iterator();
        L11:
            if (r1.hasNext() == false) goto L16;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
            if (this._included.contains(r2) == false) goto L11;
            r6.add(r2);
            goto L11
        L16:
            return new Value(r6);
        L22:
            return this;
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", new Object[]{this._included});
        }

        public int hashCode() {
            Set<String> r0 = this._included;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() != getClass()) goto L14;
            if (_equals(this._included, ((Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.aiagent.plugin"))._included) == false) goto L14;
            return true;
        L14:
            return false;
        }

        private static boolean _equals(Set<String> r2, Set<String> r3) {
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L8;
            if (r5 != null) goto L6;
            return true;
        L6:
            return false;
        L8:
            return r4.equals(r5);
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
    }

    String[] value() default {};
}
