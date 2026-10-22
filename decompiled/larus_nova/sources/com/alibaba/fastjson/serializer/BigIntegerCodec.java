package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class BigIntegerCodec implements ObjectSerializer, ObjectDeserializer {
    private static final BigInteger HIGH = null;
    private static final BigInteger LOW = null;
    public static final BigIntegerCodec instance = null;

    public BigIntegerCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        LOW = BigInteger.valueOf(-9007199254740991L);
        HIGH = BigInteger.valueOf(9007199254740991L);
        instance = new BigIntegerCodec();
    }

    public static <T> T deserialze(DefaultJSONParser r100) {
        JSONLexer r101 = r100.lexer;
        if (r101.token() != 2) goto L10;
        String r102 = r101.numberString();
        r101.nextToken(16);
        if (r102.length() > 65535) goto L9;
        return (T) new BigInteger(r102);
    L9:
        throw new JSONException("decimal overflow");
    L10:
        Object r103 = r100.parse();
        if (r103 != null) goto L14;
        return null;
    L14:
        return (T) TypeUtils.castToBigInteger(r103);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L6;
        r105.writeNull(SerializerFeature.WriteNullNumberAsZero);
        return;
    L6:
        BigInteger r106 = (BigInteger) r101;
        String r107 = r106.toString();
        if (r107.length() >= 16) goto L9;
    L16:
        r105.write(r107);
        return;
    L9:
        if (SerializerFeature.isEnabled(r104, r105.features, SerializerFeature.BrowserCompatible) == false) goto L16;
        if (r106.compareTo(LOW) >= 0) goto L13;
    L14:
        r105.writeString(r107);
        return;
    L13:
        if (r106.compareTo(HIGH) <= 0) goto L16;
        goto L14
    }
}
