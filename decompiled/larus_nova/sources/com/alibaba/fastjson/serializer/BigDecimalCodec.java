package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    static final BigDecimal HIGH = null;
    static final BigDecimal LOW = null;
    public static final BigDecimalCodec instance = null;

    public BigDecimalCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        LOW = BigDecimal.valueOf(-9007199254740991L);
        HIGH = BigDecimal.valueOf(9007199254740991L);
        instance = new BigDecimalCodec();
    }

    public static <T> T deserialze(DefaultJSONParser r100) {
        JSONLexer r101 = r100.lexer;
        if (r101.token() != 2) goto L7;
        T r102 = (T) r101.decimalValue();
        r101.nextToken(16);
        return r102;
    L7:
        if (r101.token() != 3) goto L10;
        T r103 = (T) r101.decimalValue();
        r101.nextToken(16);
        return r103;
    L10:
        Object r104 = r100.parse();
        if (r104 != null) goto L14;
        return null;
    L14:
        return (T) TypeUtils.castToBigDecimal(r104);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100);
    L4:
        e = move-exception;
        throw new JSONException("parseDecimal error, field : " + r102, e);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L5;
        r105.writeNull(SerializerFeature.WriteNullNumberAsZero);
        return;
    L5:
        BigDecimal r106 = (BigDecimal) r101;
        int r107 = r106.scale();
        if (SerializerFeature.isEnabled(r104, r105.features, SerializerFeature.WriteBigDecimalAsPlain) == true) goto L8;
    L12:
        String r108 = r106.toString();
    L13:
        if (r107 == 0) goto L15;
    L24:
        r105.write(r108);
        if (r105.isEnabled(SerializerFeature.WriteClassName) == true) goto L27;
        return;
    L27:
        if (r103 != BigDecimal.class) goto L29;
        return;
    L29:
        if (r106.scale() != 0) goto L35;
        r105.write(46);
        return;
    L35:
        return;
    L15:
        if (r108.length() < 16) goto L24;
        if (SerializerFeature.isEnabled(r104, r105.features, SerializerFeature.BrowserCompatible) == false) goto L24;
        if (r106.compareTo(LOW) >= 0) goto L21;
    L22:
        r105.writeString(r108);
        return;
    L21:
        if (r106.compareTo(HIGH) <= 0) goto L24;
    L8:
        if (r107 < (-100)) goto L12;
        if (r107 >= 100) goto L12;
        r108 = r106.toPlainString();
        goto L13
    }
}
