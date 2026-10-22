package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class DateCodec implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = null;

    static {
        instance = new DateCodec();
    }

    private DateCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.Calendar] */
    public <T> T cast(DefaultJSONParser r10, Type r11, Object r12, Object r13, String r14) {
        if (r13 != 0) goto L6;
        return null;
    L6:
        if ((r13 instanceof Date) == false) goto L9;
        return r13;
    L9:
        if ((r13 instanceof Number) == false) goto L13;
        return (T) new Date(((Number) r13).longValue());
    L13:
        if ((r13 instanceof String) == false) goto L40;
        String r15 = (String) r13;
        if (r15.length() != 0) goto L17;
        return null;
    L17:
        JSONLexer r16 = new JSONLexer(r15);
    L27:
        th = move-exception;
        r16.close();
        throw th;
    L19:
        if (r16.scanISO8601DateIfMatch(false) == false) goto L29;
        ?? r17 = (T) r16.calendar;
        if (r11 != Calendar.class) goto L24;
        r16.close();
        return r17;
    L24:
        T r18 = (T) r17.getTime();
        r16.close();
        return r18;
    L29:
        r16.close();
        if (r14 == null) goto L32;
        DateFormat r19 = new SimpleDateFormat(r14);
    L43:
        return (T) r19.parse(r15);
    L36:
        return (T) new Date(Long.parseLong(r15));
    L32:
        r19 = r10.getDateFormat();
        goto L43
    L40:
        throw new JSONException("parse error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        return (T) deserialze(r10, r11, r12, null);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r18, Object r19, Object r20, Type r21) throws IOException {
        SerializeWriter r10 = r18.out;
        if (r19 != null) goto L7;
        r10.writeNull();
        return;
    L7:
        if ((r10.features & SerializerFeature.WriteClassName.mask) == 0) goto L16;
        if (r19.getClass() == r21) goto L16;
        if (r19.getClass() != Date.class) goto L13;
        r10.write("new Date(");
        r10.writeLong(((Date) r19).getTime());
        r10.write(41);
        return;
    L13:
        r10.write(123);
        r10.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
        r18.write(r19.getClass().getName());
        r10.write(44);
        r10.writeFieldName("val", false);
        r10.writeLong(((Date) r19).getTime());
        r10.write(125);
        return;
    L16:
        if ((r19 instanceof Calendar) == false) goto L18;
        Date r11 = ((Calendar) r19).getTime();
    L20:
        if ((r10.features & SerializerFeature.WriteDateUseDateFormat.mask) == 0) goto L26;
        DateFormat r12 = r18.getDateFormat();
        if (r12 != null) goto L24;
        r12 = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, r18.locale);
        r12.setTimeZone(r18.timeZone);
    L24:
        r10.writeString(r12.format(r11));
        return;
    L26:
        long r13 = r11.getTime();
        int r14 = r10.features;
        if ((SerializerFeature.UseISO8601DateFormat.mask & r14) == 0) goto L44;
        SerializerFeature r15 = SerializerFeature.UseSingleQuotes;
        if ((r14 & r15.mask) == 0) goto L31;
        r10.write(39);
    L32:
        Calendar r16 = Calendar.getInstance(r18.timeZone, r18.locale);
        r16.setTimeInMillis(r13);
        int r17 = r16.get(1);
        int r22 = r16.get(2) + 1;
        int r23 = r16.get(5);
        int r24 = r16.get(11);
        int r25 = r16.get(12);
        int r110 = r16.get(13);
        int r26 = r16.get(14);
        if (r26 == 0) goto L35;
        char[] r27 = "0000-00-00T00:00:00.000".toCharArray();
        SerializeWriter.getChars(r26, 23, r27);
        SerializeWriter.getChars(r110, 19, r27);
        SerializeWriter.getChars(r25, 16, r27);
        SerializeWriter.getChars(r24, 13, r27);
        SerializeWriter.getChars(r23, 10, r27);
        SerializeWriter.getChars(r22, 7, r27);
        SerializeWriter.getChars(r17, 4, r27);
    L40:
        r10.write(r27);
        if ((r10.features & r15.mask) == 0) goto L43;
        r10.write(39);
        return;
    L43:
        r10.write(34);
        return;
    L35:
        if (r110 != 0) goto L39;
        if (r25 != 0) goto L39;
        if (r24 != 0) goto L39;
        r27 = "0000-00-00".toCharArray();
        SerializeWriter.getChars(r23, 10, r27);
        SerializeWriter.getChars(r22, 7, r27);
        SerializeWriter.getChars(r17, 4, r27);
    L39:
        r27 = "0000-00-00T00:00:00".toCharArray();
        SerializeWriter.getChars(r110, 19, r27);
        SerializeWriter.getChars(r25, 16, r27);
        SerializeWriter.getChars(r24, 13, r27);
        SerializeWriter.getChars(r23, 10, r27);
        SerializeWriter.getChars(r22, 7, r27);
        SerializeWriter.getChars(r17, 4, r27);
        goto L40
    L31:
        r10.write(34);
        goto L32
    L44:
        r10.writeLong(r13);
        return;
    L18:
        r11 = (Date) r19;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, java.util.Calendar] */
    public <T> T deserialze(DefaultJSONParser r12, Type r13, Object r14, String r15) {
        JSONLexer r10 = r12.lexer;
        int r11 = r10.token();
        if (r11 != 2) goto L7;
        Object r16 = Long.valueOf(r10.longValue());
        r10.nextToken(16);
        Object r17 = r16;
    L5:
        Object r18 = r17;
    L50:
        T r19 = (T) cast(r12, r13, r14, r18, r15);
        if (r13 == Calendar.class) goto L53;
        return r19;
    L53:
        if ((r19 instanceof Calendar) == false) goto L55;
        return r19;
    L55:
        Date r110 = (Date) r19;
        if (r110 != null) goto L58;
        return null;
    L58:
        ?? r111 = (T) Calendar.getInstance(r10.timeZone, r10.locale);
        r111.setTime(r110);
        return r111;
    L7:
        if (r11 != 4) goto L19;
        String r20 = r10.stringVal();
        r10.nextToken(16);
        r17 = r20;
        if ((r10.features & Feature.AllowISO8601DateFormat.mask) == 0) goto L5;
        JSONLexer r21 = new JSONLexer(r20);
        Object r22 = r20;
        if (r21.scanISO8601DateIfMatch(true) == false) goto L17;
        ?? r23 = (T) r21.calendar;
        if (r13 != Calendar.class) goto L16;
        r21.close();
        return r23;
    L16:
        r22 = r23.getTime();
    L17:
        r21.close();
        r17 = r22;
        goto L5
    L19:
        if (r11 != 8) goto L22;
        r10.nextToken();
        r18 = null;
        goto L50
    L22:
        if (r11 != 12) goto L39;
        r10.nextToken();
        if (r10.token() != 4) goto L37;
        if (JSON.DEFAULT_TYPE_KEY.equals(r10.stringVal()) == false) goto L31;
        r10.nextToken();
        r12.accept(17);
        Type r24 = TypeUtils.loadClass(r10.stringVal(), r12.config.defaultClassLoader);
        if (r24 == null) goto L30;
        r13 = r24;
    L30:
        r12.accept(4);
        r12.accept(16);
    L31:
        r10.nextTokenWithChar(':');
        int r25 = r10.token();
        if (r25 != 2) goto L35;
        long r26 = r10.longValue();
        r10.nextToken();
        Object r27 = Long.valueOf(r26);
        r12.accept(13);
        r17 = r27;
        goto L5
    L35:
        throw new JSONException("syntax error : " + JSONToken.name(r25));
    L37:
        throw new JSONException("syntax error");
    L39:
        if (r12.resolveStatus != 2) goto L49;
        r12.resolveStatus = 0;
        r12.accept(16);
        if (r10.token() != 4) goto L48;
        if ("val".equals(r10.stringVal()) == false) goto L46;
        r10.nextToken();
        r12.accept(17);
        Object r28 = r12.parse();
        r12.accept(13);
        r17 = r28;
        goto L5
    L46:
        throw new JSONException("syntax error");
    L48:
        throw new JSONException("syntax error");
    L49:
        r17 = r12.parse();
        goto L5
    }
}
