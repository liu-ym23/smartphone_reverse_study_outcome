package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;

/* JADX INFO: loaded from: classes28.dex */
public class TimeDeserializer implements ObjectDeserializer {
    public static final TimeDeserializer instance = null;

    public TimeDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        instance = new TimeDeserializer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONLexer r103 = r100.lexer;
        if (r103.token() != 16) goto L18;
        r103.nextToken(4);
        if (r103.token() != 4) goto L17;
        r103.nextTokenWithColon(2);
        if (r103.token() != 2) goto L15;
        long r104 = r103.longValue();
        r103.nextToken(13);
        if (r103.token() != 13) goto L13;
        r103.nextToken(16);
        return (T) new Time(r104);
    L13:
        throw new JSONException("syntax error");
    L15:
        throw new JSONException("syntax error");
    L17:
        throw new JSONException("syntax error");
    L18:
        T r105 = (T) r100.parse();
        if (r105 != 0) goto L22;
        return null;
    L22:
        if ((r105 instanceof Time) == false) goto L25;
        return r105;
    L25:
        if ((r105 instanceof BigDecimal) == false) goto L29;
        return (T) new Time(TypeUtils.longValue((BigDecimal) r105));
    L29:
        if ((r105 instanceof Number) == false) goto L33;
        return (T) new Time(((Number) r105).longValue());
    L33:
        if ((r105 instanceof String) == false) goto L57;
        String r106 = (String) r105;
        if (r106.length() != 0) goto L37;
        return null;
    L37:
        JSONScanner r107 = new JSONScanner(r106);
        if (r107.scanISO8601DateIfMatch() == false) goto L40;
        long r108 = r107.getCalendar().getTimeInMillis();
    L54:
        r107.close();
        return (T) new Time(r108);
    L40:
        boolean r109 = false;
        int r110 = 0;
    L42:
        if (r110 >= r106.length()) goto L49;
        char r111 = r106.charAt(r110);
        if (r111 < '0') goto L50;
        if (r111 > '9') goto L50;
        r110 = r110 + 1;
    L50:
        if (r109 == true) goto L53;
        r107.close();
        return (T) Time.valueOf(r106);
    L53:
        r108 = CastLongProtector.parseLong(r106);
        goto L54
    L49:
        r109 = true;
        goto L50
    L57:
        throw new JSONException("parse error");
    }
}
