package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* loaded from: classes2.dex */
public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    private static final long serialVersionUID = 1;
    protected final JsonDeserializer<?> _adapterDeserializer;

    public static final class Adapter {
        public String classLoaderName;
        public String declaringClass;
        public String format;
        public String moduleName;
        public String moduleVersion;
        public boolean nativeMethod;
        public String className = "";
        public String fileName = "";
        public String methodName = "";
        public int lineNumber = -1;
    }

    @Deprecated
    public StackTraceElementDeserializer() {
        this(null);
    }

    public static JsonDeserializer<?> construct(DeserializationContext deserializationContext) throws JsonMappingException {
        return deserializationContext == null ? new StackTraceElementDeserializer() : new StackTraceElementDeserializer(deserializationContext.findNonContextualValueDeserializer(deserializationContext.constructType(Adapter.class)));
    }

    public StackTraceElement constructValue(DeserializationContext deserializationContext, Adapter adapter) {
        return constructValue(deserializationContext, adapter.className, adapter.methodName, adapter.fileName, adapter.lineNumber, adapter.moduleName, adapter.moduleVersion, adapter.classLoaderName);
    }

    public StackTraceElementDeserializer(JsonDeserializer<?> jsonDeserializer) {
        super((Class<?>) StackTraceElement.class);
        this._adapterDeserializer = jsonDeserializer;
    }

    @Deprecated
    public StackTraceElement constructValue(DeserializationContext deserializationContext, String str, String str2, String str3, int i10, String str4, String str5) {
        return constructValue(deserializationContext, str, str2, str3, i10, str4, str5, null);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public StackTraceElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        if (jsonTokenCurrentToken == JsonToken.START_OBJECT || jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            JsonDeserializer<?> jsonDeserializer = this._adapterDeserializer;
            return constructValue(deserializationContext, jsonDeserializer == null ? (Adapter) deserializationContext.readValue(jsonParser, Adapter.class) : (Adapter) jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (jsonTokenCurrentToken != JsonToken.START_ARRAY || !deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            return (StackTraceElement) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
        jsonParser.nextToken();
        StackTraceElement stackTraceElementDeserialize = deserialize(jsonParser, deserializationContext);
        if (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            handleMissingEndArrayForSingle(jsonParser, deserializationContext);
        }
        return stackTraceElementDeserialize;
    }

    public StackTraceElement constructValue(DeserializationContext deserializationContext, String str, String str2, String str3, int i10, String str4, String str5, String str6) {
        return new StackTraceElement(str, str2, str3, i10);
    }
}
