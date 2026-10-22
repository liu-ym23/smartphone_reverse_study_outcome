package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f3991d = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Std extends FromStringDeserializer<Object> {

        /* renamed from: e, reason: collision with root package name */
        public final int f3992e;

        public Std(Class<?> cls, int i10) {
            super(cls);
            this.f3992e = i10;
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            int i10 = this.f3992e;
            if (i10 == 3) {
                return URI.create("");
            }
            if (i10 != 8) {
                return null;
            }
            return Locale.ROOT;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j0(com.fasterxml.jackson.databind.DeserializationContext r7, java.lang.String r8) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, com.fasterxml.jackson.databind.exc.ValueInstantiationException {
            /*
                Method dump skipped, instructions count: 324
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.Std.j0(com.fasterxml.jackson.databind.DeserializationContext, java.lang.String):java.lang.Object");
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public final Object l0(DeserializationContext deserializationContext) {
            return j(deserializationContext);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class StringBuilderDeserializer extends FromStringDeserializer<Object> {
        public StringBuilderDeserializer() {
            super(StringBuilder.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            String strF1 = jsonParser.f1();
            return strF1 != null ? new StringBuilder(strF1) : super.d(jsonParser, deserializationContext);
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            return new StringBuilder();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public final Object j0(DeserializationContext deserializationContext, String str) {
            return new StringBuilder(str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
        public final LogicalType o() {
            return LogicalType.f4436m;
        }
    }

    public static FromStringDeserializer<?> m0(Class<?> cls) {
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
                return null;
            }
            i10 = 12;
        }
        return new Std(cls, i10);
    }

    @Override // b3.c
    public T d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        String strF1 = jsonParser.f1();
        Class<?> cls = this.f4054a;
        if (strF1 == null) {
            JsonToken jsonTokenK = jsonParser.K();
            if (jsonTokenK == JsonToken.START_OBJECT) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (jsonTokenK == JsonToken.START_ARRAY) {
                return B(jsonParser, deserializationContext);
            }
            if (jsonTokenK != JsonToken.VALUE_EMBEDDED_OBJECT) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            T t8 = (T) jsonParser.K0();
            if (t8 != null) {
                return cls.isAssignableFrom(t8.getClass()) ? t8 : (T) k0(deserializationContext, t8);
            }
        } else {
            if (!strF1.isEmpty()) {
                String strTrim = strF1.trim();
                if (!strTrim.isEmpty()) {
                    try {
                        return (T) j0(deserializationContext, strTrim);
                    } catch (IllegalArgumentException | MalformedURLException e10) {
                        String message = e10.getMessage();
                        InvalidFormatException invalidFormatExceptionW = deserializationContext.W(strTrim, cls, message != null ? "not a valid textual representation, problem: ".concat(message) : "not a valid textual representation");
                        invalidFormatExceptionW.initCause(e10);
                        throw invalidFormatExceptionW;
                    }
                }
            }
            CoercionAction coercionActionM = deserializationContext.m(o(), cls, CoercionInputShape.f3809e);
            if (coercionActionM == CoercionAction.f3796a) {
                deserializationContext.P(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", A());
                throw null;
            }
            if (coercionActionM != CoercionAction.f3798c) {
                return coercionActionM == CoercionAction.f3799d ? (T) j(deserializationContext) : (T) l0(deserializationContext);
            }
        }
        return null;
    }

    public abstract Object j0(DeserializationContext deserializationContext, String str);

    public Object k0(DeserializationContext deserializationContext, Object obj) throws MismatchedInputException {
        deserializationContext.P(this, "Don't know how to convert embedded Object of type %s into %s", obj.getClass().getName(), this.f4054a.getName());
        throw null;
    }

    public Object l0(DeserializationContext deserializationContext) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public LogicalType o() {
        return LogicalType.f4439p;
    }
}
