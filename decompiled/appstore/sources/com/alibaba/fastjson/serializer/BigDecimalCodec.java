package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BigDecimalCodec instance = null;

    static {
        instance = new BigDecimalCodec();
    }

    private BigDecimalCodec() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        JSONLexer r13 = r10.lexer;
        int r14 = r13.token();
        if (r14 != 2) goto L10;
        if (r11 != BigInteger.class) goto L7;
        String r15 = r13.numberString();
        r13.nextToken(16);
        return (T) new BigInteger(r15, 10);
    L7:
        T r16 = (T) r13.decimalValue();
        r13.nextToken(16);
        return r16;
    L10:
        if (r14 != 3) goto L16;
        ?? r17 = (T) r13.decimalValue();
        r13.nextToken(16);
        if (r11 == BigInteger.class) goto L14;
        return r17;
    L14:
        return (T) r17.toBigInteger();
    L16:
        Object r18 = r10.parse();
        if (r18 != null) goto L20;
        return null;
    L20:
        if (r11 != BigInteger.class) goto L24;
        return (T) TypeUtils.castToBigInteger(r18);
    L24:
        return (T) TypeUtils.castToBigDecimal(r18);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        if (r11 != null) goto L10;
        if ((r14.features & SerializerFeature.WriteNullNumberAsZero.mask) == 0) goto L7;
        r14.write(48);
        return;
    L7:
        r14.writeNull();
        return;
    L10:
        if ((r11 instanceof BigInteger) == false) goto L13;
        r14.write(((BigInteger) r11).toString());
        return;
    L13:
        BigDecimal r15 = (BigDecimal) r11;
        r14.write(r15.toString());
        if ((r14.features & SerializerFeature.WriteClassName.mask) != 0) goto L16;
        return;
    L16:
        if (r13 != BigDecimal.class) goto L18;
        return;
    L18:
        if (r15.scale() != 0) goto L24;
        r14.write(46);
        return;
    }
}
