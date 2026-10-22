package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface JsonObjectFormatVisitor extends JsonFormatVisitorWithSerializerProvider {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Base implements JsonObjectFormatVisitor {
        protected SerializerProvider _provider;

        public Base(SerializerProvider serializerProvider) {
            this._provider = serializerProvider;
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWithSerializerProvider
        public SerializerProvider getProvider() {
            return this._provider;
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWithSerializerProvider
        public void setProvider(SerializerProvider serializerProvider) {
            this._provider = serializerProvider;
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor
        public void optionalProperty(String str, JsonFormatVisitable jsonFormatVisitable, JavaType javaType) {
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor
        public void property(String str, JsonFormatVisitable jsonFormatVisitable, JavaType javaType) {
        }

        public Base() {
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor
        public void optionalProperty(BeanProperty beanProperty) {
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor
        public void property(BeanProperty beanProperty) {
        }
    }

    void optionalProperty(BeanProperty beanProperty);

    void optionalProperty(String str, JsonFormatVisitable jsonFormatVisitable, JavaType javaType);

    void property(BeanProperty beanProperty);

    void property(String str, JsonFormatVisitable jsonFormatVisitable, JavaType javaType);
}
