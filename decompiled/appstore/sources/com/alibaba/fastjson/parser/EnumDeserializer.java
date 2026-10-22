package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    protected final Enum[] values;

    public EnumDeserializer(Class<?> r10) {
        this.enumClass = r10;
        this.values = (Enum[]) r10.getEnumConstants();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        JSONLexer r13 = r10.lexer;     // Catch: Exception -> L11 JSONException -> L13
        int r14 = r13.token;     // Catch: Exception -> L11 JSONException -> L13
        if (r14 != 2) goto L18;
        int r15 = r13.intValue();     // Catch: Exception -> L11 JSONException -> L13
        r13.nextToken(16);     // Catch: Exception -> L11 JSONException -> L13
        if (r15 < 0) goto L16;
        Object[] r16 = this.values;     // Catch: Exception -> L11 JSONException -> L13
        if (r15 > r16.length) goto L16;
        return (T) r16[r15];
    L16:
        throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + r15);     // Catch: Exception -> L11 JSONException -> L13
    L18:
        if (r14 != 4) goto L25;
        String r17 = r13.stringVal();     // Catch: Exception -> L11 JSONException -> L13
        r13.nextToken(16);     // Catch: Exception -> L11 JSONException -> L13
        if (r17.length() != 0) goto L23;
        return null;
    L23:
        return (T) Enum.valueOf(this.enumClass, r17);
    L25:
        if (r14 != 8) goto L29;
        r13.nextToken(16);     // Catch: Exception -> L11 JSONException -> L13
        return null;
    L29:
        throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + r10.parse());     // Catch: Exception -> L11 JSONException -> L13
    L13:
        e = move-exception;
        throw e;
    L11:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }
}
