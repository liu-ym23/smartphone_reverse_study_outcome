package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance;

    static {
        instance = new IntegerCodec();
    }

    private IntegerCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        JSONLexer r13 = r10.lexer;
        int r14 = r13.token();
        if (r14 != 8) goto L7;
        r13.nextToken(16);
        return null;
    L7:
        if (r14 != 2) goto L20;
        if (r11 == Long.TYPE) goto L17;
        if (r11 == Long.class) goto L17;
        T r15 = (T) Integer.valueOf(r13.intValue());
    L18:
        r13.nextToken(16);
        return r15;
    L14:
        e = move-exception;
        throw new JSONException("int value overflow, field : " + r12, e);
    L17:
        r15 = (T) Long.valueOf(r13.longValue());
        goto L18
    L20:
        if (r14 != 3) goto L28;
        BigDecimal r16 = r13.decimalValue();
        r13.nextToken(16);
        if (r11 == Long.TYPE) goto L27;
        if (r11 == Long.class) goto L27;
        Object r17 = Integer.valueOf(r16.intValue());
    L46:
        return (T) r17;
    L27:
        r17 = Long.valueOf(r16.longValue());
        goto L46
    L28:
        r17 = r10.parse();
    L34:
        e = move-exception;
        throw new JSONException("cast error, field : " + r12 + ", value " + r17, e);
    L30:
        if (r11 == Long.TYPE) goto L36;
        if (r11 == Long.class) goto L36;
        r17 = TypeUtils.castToInt(r17);     // Catch: Exception -> L34
    L43:
    L36:
        r17 = TypeUtils.castToLong(r17);     // Catch: Exception -> L34
        goto L43
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        Number r15 = (Number) r11;
        if (r15 != null) goto L10;
        if ((r14.features & SerializerFeature.WriteNullNumberAsZero.mask) == 0) goto L7;
        r14.write(48);
        return;
    L7:
        r14.writeNull();
        return;
    L10:
        if ((r11 instanceof Long) == false) goto L12;
        r14.writeLong(r15.longValue());
    L14:
        if ((r14.features & SerializerFeature.WriteClassName.mask) == 0) goto L31;
        Class<?> r16 = r15.getClass();
        if (r16 != Byte.class) goto L19;
        r14.write(66);
        return;
    L19:
        if (r16 != Short.class) goto L22;
        r14.write(83);
        return;
    L22:
        if (r16 != Long.class) goto L34;
        long r17 = r15.longValue();
        if (r17 <= 2147483647L) goto L26;
        return;
    L26:
        if (r17 < (-2147483648L)) goto L36;
        if (r13 == Long.class) goto L37;
        r14.write(76);
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L31:
        return;
    L12:
        r14.writeInt(r15.intValue());
        goto L14
    }
}
