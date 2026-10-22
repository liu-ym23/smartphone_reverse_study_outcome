package com.alibaba.fastjson.parser.deserializer;

import androidx.collection.SieveCacheKt;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes28.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = null;

    public NumberDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        instance = new NumberDeserializer();
    }

    /* JADX WARN: Type inference failed for: r5v28, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONLexer r103 = r100.lexer;
        if (r103.token() != 2) goto L46;
        if (r101 != Double.TYPE) goto L7;
    L43:
        String r104 = r103.numberString();
        r103.nextToken(16);
        return (T) Double.valueOf(CastDoubleProtector.parseDouble(r104));
    L7:
        if (r101 == Double.class) goto L43;
        long r105 = r103.longValue();
        r103.nextToken(16);
        if (r101 == Short.TYPE) goto L36;
        if (r101 == Short.class) goto L36;
        if (r101 == Byte.TYPE) goto L28;
        if (r101 == Byte.class) goto L28;
        if (r105 < SieveCacheKt.NodeMetaAndPreviousMask) goto L26;
        if (r105 > SieveCacheKt.NodeLinkMask) goto L26;
        return (T) Integer.valueOf((int) r105);
    L26:
        return (T) Long.valueOf(r105);
    L28:
        if (r105 > 127) goto L34;
        if (r105 < (-128)) goto L34;
        return (T) Byte.valueOf((byte) r105);
    L34:
        throw new JSONException("short overflow : " + r105);
    L36:
        if (r105 > 32767) goto L42;
        if (r105 < (-32768)) goto L42;
        return (T) Short.valueOf((short) r105);
    L42:
        throw new JSONException("short overflow : " + r105);
    L46:
        if (r103.token() != 3) goto L74;
        if (r101 != Double.TYPE) goto L50;
    L71:
        String r106 = r103.numberString();
        r103.nextToken(16);
        return (T) Double.valueOf(CastDoubleProtector.parseDouble(r106));
    L50:
        if (r101 == Double.class) goto L71;
        if (r101 != Short.TYPE) goto L55;
    L69:
        BigDecimal r107 = r103.decimalValue();
        r103.nextToken(16);
        return (T) Short.valueOf(TypeUtils.shortValue(r107));
    L55:
        if (r101 == Short.class) goto L69;
        if (r101 != Byte.TYPE) goto L60;
    L67:
        BigDecimal r108 = r103.decimalValue();
        r103.nextToken(16);
        return (T) Byte.valueOf(TypeUtils.byteValue(r108));
    L60:
        if (r101 == Byte.class) goto L67;
        ?? r109 = (T) r103.decimalValue();
        r103.nextToken(16);
        if (r103.isEnabled(Feature.UseBigDecimal) == false) goto L66;
        return r109;
    L66:
        return (T) Double.valueOf(r109.doubleValue());
    L74:
        if (r103.token() == 18) goto L76;
    L84:
        Object r110 = r100.parse();
        if (r110 != null) goto L88;
        return null;
    L88:
        if (r101 != Double.TYPE) goto L90;
    L119:
        return (T) TypeUtils.castToDouble(r110);
    L116:
        e = move-exception;
        throw new JSONException("parseDouble error, field : " + r102, e);
    L90:
        if (r101 == Double.class) goto L119;
        if (r101 != Short.TYPE) goto L95;
    L123:
        return (T) TypeUtils.castToShort(r110);
    L111:
        e = move-exception;
        throw new JSONException("parseShort error, field : " + r102, e);
    L95:
        if (r101 == Short.class) goto L123;
        if (r101 != Byte.TYPE) goto L100;
    L121:
        return (T) TypeUtils.castToByte(r110);
    L106:
        e = move-exception;
        throw new JSONException("parseByte error, field : " + r102, e);
    L100:
        if (r101 == Byte.class) goto L121;
        return (T) TypeUtils.castToBigDecimal(r110);
    L76:
        if ("NaN".equals(r103.stringVal()) == false) goto L84;
        r103.nextToken();
        if (r101 != Double.class) goto L81;
        return (T) Double.valueOf(Double.NaN);
    L81:
        if (r101 == Float.class) goto L83;
        return null;
    L83:
        return (T) Float.valueOf(Float.NaN);
    }
}
