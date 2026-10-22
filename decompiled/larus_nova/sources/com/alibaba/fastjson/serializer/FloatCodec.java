package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes3.dex */
public class FloatCodec implements ObjectSerializer, ObjectDeserializer {
    public static FloatCodec instance;
    private NumberFormat decimalFormat;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        instance = new FloatCodec();
    }

    public FloatCodec() {
    }

    public FloatCodec(String r100) {
        this(new DecimalFormat(r100));
    }

    public static <T> T deserialze(DefaultJSONParser r100) {
        JSONLexer r101 = r100.lexer;
        if (r101.token() != 2) goto L7;
        String r102 = r101.numberString();
        r101.nextToken(16);
        return (T) Float.valueOf(CastFloatProtector.parseFloat(r102));
    L7:
        if (r101.token() != 3) goto L10;
        float r103 = r101.floatValue();
        r101.nextToken(16);
        return (T) Float.valueOf(r103);
    L10:
        Object r104 = r100.parse();
        if (r104 != null) goto L15;
        return null;
    L15:
        return (T) TypeUtils.castToFloat(r104);
    }

    public FloatCodec(DecimalFormat r100) {
        this.decimalFormat = r100;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100);
    L4:
        e = move-exception;
        throw new JSONException("parseLong error, field : " + r102, e);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L6;
        r105.writeNull(SerializerFeature.WriteNullNumberAsZero);
        return;
    L6:
        float r106 = ((Float) r101).floatValue();
        NumberFormat r107 = this.decimalFormat;
        if (r107 == null) goto L9;
        r105.write(r107.format(r106));
        return;
    L9:
        r105.writeFloat(r106, true);
    }
}
