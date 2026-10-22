package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = null;
    private DecimalFormat decimalFormat;

    static {
        instance = new NumberCodec();
    }

    private NumberCodec() {
        this.decimalFormat = null;
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        JSONLexer r13 = r10.lexer;
        int r14 = r13.token();
        if (r14 != 2) goto L37;
        if (r11 == Double.TYPE) goto L34;
        if (r11 == Double.class) goto L34;
        if (r11 == Float.TYPE) goto L32;
        if (r11 == Float.class) goto L32;
        long r15 = r13.longValue();
        r13.nextToken(16);
        if (r11 == Short.TYPE) goto L31;
        if (r11 == Short.class) goto L31;
        if (r11 == Byte.TYPE) goto L29;
        if (r11 == Byte.class) goto L29;
        if (r15 < (-2147483648L)) goto L27;
        if (r15 > 2147483647L) goto L27;
        return (T) Integer.valueOf((int) r15);
    L27:
        return (T) Long.valueOf(r15);
    L29:
        return (T) Byte.valueOf((byte) r15);
    L31:
        return (T) Short.valueOf((short) r15);
    L32:
        String r16 = r13.numberString();
        r13.nextToken(16);
        return (T) Float.valueOf(Float.parseFloat(r16));
    L34:
        String r17 = r13.numberString();
        r13.nextToken(16);
        return (T) Double.valueOf(Double.parseDouble(r17));
    L37:
        if (r14 == 3) goto L39;
        Object r18 = r10.parse();
        if (r18 != null) goto L68;
        return null;
    L68:
        if (r11 == Double.TYPE) goto L92;
        if (r11 == Double.class) goto L92;
        if (r11 == Float.TYPE) goto L90;
        if (r11 == Float.class) goto L90;
        if (r11 == Short.TYPE) goto L88;
        if (r11 == Short.class) goto L88;
        if (r11 == Byte.TYPE) goto L86;
        if (r11 == Byte.class) goto L86;
        return (T) TypeUtils.castToBigDecimal(r18);
    L86:
        return (T) TypeUtils.castToByte(r18);
    L88:
        return (T) TypeUtils.castToShort(r18);
    L90:
        return (T) TypeUtils.castToFloat(r18);
    L92:
        return (T) TypeUtils.castToDouble(r18);
    L39:
        if (r11 == Double.TYPE) goto L61;
        if (r11 == Double.class) goto L61;
        if (r11 == Float.TYPE) goto L59;
        if (r11 == Float.class) goto L59;
        ?? r19 = (T) r13.decimalValue();
        r13.nextToken(16);
        if (r11 == Short.TYPE) goto L58;
        if (r11 == Short.class) goto L58;
        if (r11 == Byte.TYPE) goto L56;
        if (r11 == Byte.class) goto L56;
        return r19;
    L56:
        return (T) Byte.valueOf(r19.byteValue());
    L58:
        return (T) Short.valueOf(r19.shortValue());
    L59:
        String r20 = r13.numberString();
        r13.nextToken(16);
        return (T) Float.valueOf(Float.parseFloat(r20));
    L61:
        String r21 = r13.numberString();
        r13.nextToken(16);
        return (T) Double.valueOf(Double.parseDouble(r21));
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
        if ((r11 instanceof Float) == false) goto L24;
        float r15 = ((Float) r11).floatValue();
        if (Float.isNaN(r15) == false) goto L15;
        r14.writeNull();
        return;
    L15:
        if (Float.isInfinite(r15) == false) goto L17;
        r14.writeNull();
        return;
    L17:
        String r16 = Float.toString(r15);
        if (r16.endsWith(".0") == false) goto L20;
        r16 = r16.substring(0, r16.length() - 2);
    L20:
        r14.write(r16);
        if ((r14.features & SerializerFeature.WriteClassName.mask) == 0) goto L43;
        r14.write(70);
        return;
    L43:
        return;
    L24:
        double r17 = ((Double) r11).doubleValue();
        if (Double.isNaN(r17) == false) goto L28;
        r14.writeNull();
        return;
    L28:
        if (Double.isInfinite(r17) == false) goto L30;
        r14.writeNull();
        return;
    L30:
        DecimalFormat r18 = this.decimalFormat;
        if (r18 != null) goto L35;
        String r19 = Double.toString(r17);
        if (r19.endsWith(".0") == false) goto L36;
        r19 = r19.substring(0, r19.length() - 2);
    L36:
        r14.append(r19);
        if ((r14.features & SerializerFeature.WriteClassName.mask) == 0) goto L46;
        r14.write(68);
        return;
    L46:
        return;
    L35:
        r19 = r18.format(r17);
        goto L36
    }

    public NumberCodec(DecimalFormat r10) {
        this.decimalFormat = r10;
    }

    public NumberCodec(String r10) {
        this(new DecimalFormat(r10));
    }
}
