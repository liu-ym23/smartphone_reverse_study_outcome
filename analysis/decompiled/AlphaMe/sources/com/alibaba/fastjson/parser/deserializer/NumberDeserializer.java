package com.alibaba.fastjson.parser.deserializer;

import androidx.room.AbstractC0351g;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v9, types: [T, java.lang.Number, java.lang.Object, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strNumberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(strNumberString));
            }
            long jLongValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                if (jLongValue > 32767 || jLongValue < -32768) {
                    throw new JSONException(AbstractC0351g.n("short overflow : ", jLongValue));
                }
                return (T) Short.valueOf((short) jLongValue);
            }
            if (type != Byte.TYPE && type != Byte.class) {
                return (jLongValue < -2147483648L || jLongValue > 2147483647L) ? (T) Long.valueOf(jLongValue) : (T) Integer.valueOf((int) jLongValue);
            }
            if (jLongValue > 127 || jLongValue < -128) {
                throw new JSONException(AbstractC0351g.n("short overflow : ", jLongValue));
            }
            return (T) Byte.valueOf((byte) jLongValue);
        }
        if (jSONLexer.token() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String strNumberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(strNumberString2));
            }
            ?? r12 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type != Short.TYPE && type != Short.class) {
                return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r12.byteValue()) : r12;
            }
            if (r12.compareTo(BigDecimal.valueOf(32767L)) <= 0 && r12.compareTo(BigDecimal.valueOf(-32768L)) >= 0) {
                return (T) Short.valueOf(r12.shortValue());
            }
            throw new JSONException("short overflow : " + ((Object) r12));
        }
        Object obj2 = defaultJSONParser.parse();
        if (obj2 == null) {
            return null;
        }
        if (type == Double.TYPE || type == Double.class) {
            try {
                return (T) TypeUtils.castToDouble(obj2);
            } catch (Exception e4) {
                throw new JSONException(AbstractC0351g.o("parseDouble error, field : ", obj), e4);
            }
        }
        if (type == Short.TYPE || type == Short.class) {
            try {
                return (T) TypeUtils.castToShort(obj2);
            } catch (Exception e5) {
                throw new JSONException(AbstractC0351g.o("parseShort error, field : ", obj), e5);
            }
        }
        if (type != Byte.TYPE && type != Byte.class) {
            return (T) TypeUtils.castToBigDecimal(obj2);
        }
        try {
            return (T) TypeUtils.castToByte(obj2);
        } catch (Exception e6) {
            throw new JSONException(AbstractC0351g.o("parseByte error, field : ", obj), e6);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
