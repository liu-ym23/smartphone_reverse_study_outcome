package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.IllformedLocaleException;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes2.dex */
public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {

    public static class Std extends FromStringDeserializer<Object> {
        protected static final String LOCALE_EXT_MARKER = "_#";
        public static final int STD_CHARSET = 9;
        public static final int STD_CLASS = 4;
        public static final int STD_CURRENCY = 6;
        public static final int STD_FILE = 1;
        public static final int STD_INET_ADDRESS = 11;
        public static final int STD_INET_SOCKET_ADDRESS = 12;
        public static final int STD_JAVA_TYPE = 5;
        public static final int STD_LOCALE = 8;
        public static final int STD_PATTERN = 7;
        public static final int STD_TIME_ZONE = 10;
        public static final int STD_URI = 3;
        public static final int STD_URL = 2;
        private static final long serialVersionUID = 1;
        protected final int _kind;

        public Std(Class<?> cls, int i10) {
            super(cls);
            this._kind = i10;
        }

        private Locale _deSerializeBCP47Locale(String str, int i10, String str2, String str3, int i11) {
            String strSubstring = "";
            if (i11 > 0 && i11 > i10) {
                try {
                    strSubstring = str.substring(i10 + 1, i11);
                } catch (IllformedLocaleException unused) {
                    return new Locale(str2, str3, "");
                }
            }
            String strSubstring2 = str.substring(i11 + 2);
            int iIndexOf = strSubstring2.indexOf(95);
            if (iIndexOf < 0) {
                int iIndexOf2 = strSubstring2.indexOf(45);
                return iIndexOf2 < 0 ? new Locale.Builder().setLanguage(str2).setRegion(str3).setVariant(strSubstring).setScript(strSubstring2).build() : new Locale.Builder().setLanguage(str2).setRegion(str3).setVariant(strSubstring).setExtension(strSubstring2.charAt(0), strSubstring2.substring(iIndexOf2 + 1)).build();
            }
            int length = strSubstring2.length();
            Locale.Builder script = new Locale.Builder().setLanguage(str2).setRegion(str3).setVariant(strSubstring).setScript(strSubstring2.substring(0, iIndexOf));
            int i12 = iIndexOf + 1;
            if (i12 < length) {
                script = script.setExtension(strSubstring2.charAt(i12), strSubstring2.substring(Math.min(length, iIndexOf + 3)));
            }
            return script.build();
        }

        private Locale _deserializeLocale(String str, DeserializationContext deserializationContext) throws IOException {
            int i_firstHyphenOrUnderscore = _firstHyphenOrUnderscore(str);
            if (i_firstHyphenOrUnderscore < 0) {
                return new Locale(str);
            }
            String strSubstring = str.substring(0, i_firstHyphenOrUnderscore);
            String strSubstring2 = str.substring(i_firstHyphenOrUnderscore + 1);
            int i_firstHyphenOrUnderscore2 = _firstHyphenOrUnderscore(strSubstring2);
            if (i_firstHyphenOrUnderscore2 < 0) {
                return new Locale(strSubstring, strSubstring2);
            }
            String strSubstring3 = strSubstring2.substring(0, i_firstHyphenOrUnderscore2);
            int iIndexOf = strSubstring2.indexOf(LOCALE_EXT_MARKER);
            return iIndexOf < 0 ? new Locale(strSubstring, strSubstring3, strSubstring2.substring(i_firstHyphenOrUnderscore2 + 1)) : _deSerializeBCP47Locale(strSubstring2, i_firstHyphenOrUnderscore2, strSubstring, strSubstring3, iIndexOf);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            switch (this._kind) {
                case 1:
                    return new File(str);
                case 2:
                    return new URL(str);
                case 3:
                    return URI.create(str);
                case 4:
                    try {
                        return deserializationContext.findClass(str);
                    } catch (Exception e10) {
                        return deserializationContext.handleInstantiationProblem(this._valueClass, str, ClassUtil.getRootCause(e10));
                    }
                case 5:
                    return deserializationContext.getTypeFactory().constructFromCanonical(str);
                case 6:
                    try {
                        return Currency.getInstance(str);
                    } catch (IllegalArgumentException unused) {
                        return deserializationContext.handleWeirdStringValue(this._valueClass, str, "Unrecognized currency", new Object[0]);
                    }
                case 7:
                    try {
                        return Pattern.compile(str);
                    } catch (PatternSyntaxException e11) {
                        return deserializationContext.handleWeirdStringValue(this._valueClass, str, "Invalid Pattern, problem: " + e11.getDescription(), new Object[0]);
                    }
                case 8:
                    return _deserializeLocale(str, deserializationContext);
                case 9:
                    return Charset.forName(str);
                case 10:
                    return TimeZone.getTimeZone(str);
                case 11:
                    return InetAddress.getByName(str);
                case 12:
                    if (str.startsWith("[")) {
                        int iLastIndexOf = str.lastIndexOf(93);
                        if (iLastIndexOf == -1) {
                            throw new InvalidFormatException(deserializationContext.getParser(), "Bracketed IPv6 address must contain closing bracket", str, (Class<?>) InetSocketAddress.class);
                        }
                        int iIndexOf = str.indexOf(58, iLastIndexOf);
                        return new InetSocketAddress(str.substring(0, iLastIndexOf + 1), iIndexOf > -1 ? Integer.parseInt(str.substring(iIndexOf + 1)) : 0);
                    }
                    int iIndexOf2 = str.indexOf(58);
                    if (iIndexOf2 >= 0) {
                        int i10 = iIndexOf2 + 1;
                        if (str.indexOf(58, i10) < 0) {
                            return new InetSocketAddress(str.substring(0, iIndexOf2), Integer.parseInt(str.substring(i10)));
                        }
                    }
                    return new InetSocketAddress(str, 0);
                default:
                    VersionUtil.throwInternal();
                    return null;
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserializeFromEmptyStringDefault(DeserializationContext deserializationContext) throws IOException {
            return getEmptyValue(deserializationContext);
        }

        public int _firstHyphenOrUnderscore(String str) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == '_' || cCharAt == '-') {
                    return i10;
                }
            }
            return -1;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public boolean _shouldTrim() {
            return this._kind != 7;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            int i10 = this._kind;
            return i10 != 3 ? i10 != 8 ? super.getEmptyValue(deserializationContext) : Locale.ROOT : URI.create("");
        }
    }

    public static class StringBufferDeserializer extends FromStringDeserializer<Object> {
        public StringBufferDeserializer() {
            super(StringBuffer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            return new StringBuffer(str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String valueAsString = jsonParser.getValueAsString();
            return valueAsString != null ? _deserialize(valueAsString, deserializationContext) : super.deserialize(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) {
            return new StringBuffer();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public LogicalType logicalType() {
            return LogicalType.Textual;
        }
    }

    public static class StringBuilderDeserializer extends FromStringDeserializer<Object> {
        public StringBuilderDeserializer() {
            super(StringBuilder.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            return new StringBuilder(str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String valueAsString = jsonParser.getValueAsString();
            return valueAsString != null ? _deserialize(valueAsString, deserializationContext) : super.deserialize(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
            return new StringBuilder();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public LogicalType logicalType() {
            return LogicalType.Textual;
        }
    }

    public FromStringDeserializer(Class<?> cls) {
        super(cls);
    }

    public static FromStringDeserializer<?> findDeserializer(Class<?> cls) {
        int i10;
        if (cls == File.class) {
            i10 = 1;
        } else if (cls == URL.class) {
            i10 = 2;
        } else if (cls == URI.class) {
            i10 = 3;
        } else if (cls == Class.class) {
            i10 = 4;
        } else if (cls == JavaType.class) {
            i10 = 5;
        } else if (cls == Currency.class) {
            i10 = 6;
        } else if (cls == Pattern.class) {
            i10 = 7;
        } else if (cls == Locale.class) {
            i10 = 8;
        } else if (cls == Charset.class) {
            i10 = 9;
        } else if (cls == TimeZone.class) {
            i10 = 10;
        } else if (cls == InetAddress.class) {
            i10 = 11;
        } else {
            if (cls != InetSocketAddress.class) {
                if (cls == StringBuilder.class) {
                    return new StringBuilderDeserializer();
                }
                if (cls == StringBuffer.class) {
                    return new StringBufferDeserializer();
                }
                return null;
            }
            i10 = 12;
        }
        return new Std(cls, i10);
    }

    public static Class<?>[] types() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, JavaType.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class, StringBuffer.class};
    }

    public abstract T _deserialize(String str, DeserializationContext deserializationContext) throws IOException;

    public T _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) throws IOException {
        deserializationContext.reportInputMismatch(this, "Don't know how to convert embedded Object of type %s into %s", obj.getClass().getName(), this._valueClass.getName());
        return null;
    }

    @Deprecated
    public final T _deserializeFromEmptyString() throws IOException {
        return null;
    }

    public Object _deserializeFromEmptyStringDefault(DeserializationContext deserializationContext) throws IOException {
        return getNullValue(deserializationContext);
    }

    public Object _deserializeFromOther(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        if (jsonToken == JsonToken.START_ARRAY) {
            return _deserializeFromArray(jsonParser, deserializationContext);
        }
        if (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
            return deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
        Object embeddedObject = jsonParser.getEmbeddedObject();
        if (embeddedObject == null) {
            return null;
        }
        return this._valueClass.isAssignableFrom(embeddedObject.getClass()) ? embeddedObject : _deserializeEmbedded(embeddedObject, deserializationContext);
    }

    public boolean _shouldTrim() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString = jsonParser.getValueAsString();
        if (valueAsString == null) {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            if (jsonTokenCurrentToken != JsonToken.START_OBJECT) {
                return (T) _deserializeFromOther(jsonParser, deserializationContext, jsonTokenCurrentToken);
            }
            valueAsString = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }
        if (valueAsString.isEmpty()) {
            return (T) _deserializeFromEmptyString(deserializationContext);
        }
        if (_shouldTrim()) {
            String strTrim = valueAsString.trim();
            if (strTrim != valueAsString && strTrim.isEmpty()) {
                return (T) _deserializeFromEmptyString(deserializationContext);
            }
            valueAsString = strTrim;
        }
        try {
            return _deserialize(valueAsString, deserializationContext);
        } catch (IllegalArgumentException | MalformedURLException e10) {
            String message = e10.getMessage();
            String str = "not a valid textual representation";
            if (message != null) {
                str = "not a valid textual representation, problem: " + message;
            }
            throw deserializationContext.weirdStringException(valueAsString, this._valueClass, str).withCause(e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.OtherScalar;
    }

    public Object _deserializeFromEmptyString(DeserializationContext deserializationContext) throws IOException {
        CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), this._valueClass, CoercionInputShape.EmptyString);
        if (coercionActionFindCoercionAction == CoercionAction.Fail) {
            deserializationContext.reportInputMismatch(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", _coercedTypeDesc());
        }
        return coercionActionFindCoercionAction == CoercionAction.AsNull ? getNullValue(deserializationContext) : coercionActionFindCoercionAction == CoercionAction.AsEmpty ? getEmptyValue(deserializationContext) : _deserializeFromEmptyStringDefault(deserializationContext);
    }
}
