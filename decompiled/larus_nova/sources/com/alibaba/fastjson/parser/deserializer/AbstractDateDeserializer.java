package com.alibaba.fastjson.parser.deserializer;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes28.dex */
public abstract class AbstractDateDeserializer extends ContextObjectDeserializer {
    public abstract <T> T cast(DefaultJSONParser r100, Type r101, Object r102, Object r103);

    public AbstractDateDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100, r101, r102, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r110, Type r111, Object r112, String r113, int r114) {
        JSONLexer r100 = r110.lexer;
        if (r100.token() != 2) goto L8;
        long r101 = r100.longValue();
        r100.nextToken(16);
        if ("unixtime".equals(r113) == false) goto L7;
        r101 = r101 * 1000;
    L7:
        Object r115 = Long.valueOf(r101);
    L103:
        return (T) cast(r110, r111, r112, r115);
    L8:
        Object r102 = null;
        if (r100.token() != 4) goto L70;
        String r103 = r100.stringVal();
        if (r113 != null) goto L13;
    L61:
        if (r102 != null) goto L72;
        r100.nextToken(16);
        Object r104 = r103;
        if (r100.isEnabled(Feature.AllowISO8601DateFormat) == false) goto L68;
        JSONScanner r116 = new JSONScanner(r103);
        Object r105 = r103;
        if (r116.scanISO8601DateIfMatch() == false) goto L67;
        r105 = r116.getCalendar().getTime();
    L67:
        r116.close();
        r104 = r105;
    L68:
        r115 = r104;
    L72:
        r115 = r102;
        goto L103
    L13:
        if ("yyyy-MM-dd HH:mm:ss.SSSSSSSSS".equals(r113) == true) goto L15;
    L108:
        SimpleDateFormat r106 = new SimpleDateFormat(r113, r110.lexer.getLocale());     // Catch: IllegalArgumentException -> L22
    L31:
        if (JSON.defaultTimeZone == null) goto L104;
        r106.setTimeZone(r110.lexer.getTimeZone());
    L104:
        Object r107 = r106.parse(r103);     // Catch: ParseException -> L35
    L36:
        if (r107 == null) goto L38;
    L52:
        if (r107 == null) goto L54;
        r102 = r107;
        goto L61
    L54:
        if (r113.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") == false) goto L61;
        if (r103.length() != 19) goto L61;
        SimpleDateFormat r117 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", JSON.defaultLocale);     // Catch: ParseException -> L59
        r117.setTimeZone(JSON.defaultTimeZone);     // Catch: ParseException -> L59
        r102 = r117.parse(r103);     // Catch: ParseException -> L59
        goto L61
    L38:
        if (JSON.defaultLocale != Locale.CHINA) goto L52;
        SimpleDateFormat r108 = new SimpleDateFormat(r113, Locale.US);     // Catch: IllegalArgumentException -> L41
    L48:
        r108.setTimeZone(r110.lexer.getTimeZone());
        r107 = r108.parse(r103);     // Catch: ParseException -> L51
    L51:
        r107 = null;
    L41:
        e = move-exception;
        r108 = r106;
        if (r113.contains(ExifInterface.GPS_DIRECTION_TRUE) == false) goto L48;
        r108 = new SimpleDateFormat(r113.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), r110.lexer.getLocale());     // Catch: IllegalArgumentException -> L47
    L47:
        throw e;
    L35:
        r107 = null;
    L22:
        e = move-exception;
        if (r113.contains(ExifInterface.GPS_DIRECTION_TRUE) == true) goto L114;
        r106 = null;
        goto L31
    L114:
        r106 = new SimpleDateFormat(r113.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), r110.lexer.getLocale());     // Catch: IllegalArgumentException -> L28
    L28:
        throw e;
    L15:
        if ((r111 instanceof Class) == false) goto L108;
        if (((Class) r111).getName().equals("java.sql.Timestamp") == false) goto L108;
        return (T) TypeUtils.castToTimestamp(r103);
    L70:
        if (r100.token() != 8) goto L74;
        r100.nextToken();
        goto L72
    L74:
        if (r100.token() != 12) goto L91;
        r100.nextToken();
        if (r100.token() != 4) goto L89;
        if (JSON.DEFAULT_TYPE_KEY.equals(r100.stringVal()) == false) goto L83;
        r100.nextToken();
        r110.accept(17);
        Type r118 = r110.getConfig().checkAutoType(r100.stringVal(), null, r100.getFeatures());
        if (r118 == null) goto L82;
        r111 = r118;
    L82:
        r110.accept(4);
        r110.accept(16);
    L83:
        r100.nextTokenWithColon(2);
        if (r100.token() != 2) goto L87;
        long r119 = r100.longValue();
        r100.nextToken();
        Object r120 = Long.valueOf(r119);
        r110.accept(13);
        r115 = r120;
        goto L103
    L87:
        throw new JSONException("syntax error : " + r100.tokenName());
    L89:
        throw new JSONException("syntax error");
    L91:
        if (r110.getResolveStatus() != 2) goto L101;
        r110.setResolveStatus(0);
        r110.accept(16);
        if (r100.token() != 4) goto L100;
        if ("val".equals(r100.stringVal()) == false) goto L98;
        r100.nextToken();
        r110.accept(17);
        Object r121 = r110.parse();
        r110.accept(13);
        r115 = r121;
        goto L103
    L98:
        throw new JSONException("syntax error");
    L100:
        throw new JSONException("syntax error");
    L101:
        r115 = r110.parse();
        goto L103
    }
}
