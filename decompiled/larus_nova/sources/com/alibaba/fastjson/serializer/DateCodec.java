package com.alibaba.fastjson.serializer;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes28.dex */
public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer {
    public static final DateCodec instance = null;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        instance = new DateCodec();
    }

    public DateCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v17, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r5v25, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(DefaultJSONParser r100, Type r101, Object r102, Object r103) {
        if (r103 != 0) goto L6;
        return null;
    L6:
        if ((r103 instanceof Date) == false) goto L9;
        return r103;
    L9:
        if ((r103 instanceof BigDecimal) == false) goto L13;
        return (T) new Date(TypeUtils.longValue((BigDecimal) r103));
    L13:
        if ((r103 instanceof Number) == false) goto L17;
        return (T) new Date(((Number) r103).longValue());
    L17:
        if ((r103 instanceof String) == false) goto L92;
        String r104 = (String) r103;
        if (r104.length() != 0) goto L22;
        return null;
    L22:
        if (r104.length() == 23) goto L24;
    L26:
        JSONScanner r105 = new JSONScanner(r104);
    L88:
        th = move-exception;
        r105.close();
        throw th;
    L28:
        if (r105.scanISO8601DateIfMatch(false) == false) goto L36;
        ?? r106 = (T) r105.getCalendar();
        if (r101 != Calendar.class) goto L33;
        r105.close();
        return r106;
    L33:
        T r107 = (T) r106.getTime();
        r105.close();
        return r107;
    L36:
        r105.close();
        String r108 = r100.getDateFomartPattern();
        if (r104.length() != r108.length()) goto L39;
    L50:
        boolean r109 = true;
    L51:
        if (r109 == false) goto L57;
        return (T) r100.getDateFormat().parse(r104);
    L57:
        if (r104.startsWith("/Date(") == false) goto L62;
        if (r104.endsWith(")/") == false) goto L62;
        r104 = r104.substring(6, r104.length() - 2);
    L62:
        if ("0000-00-00".equals(r104) == false) goto L64;
        return null;
    L64:
        if ("0000-00-00T00:00:00".equalsIgnoreCase(r104) == false) goto L66;
        return null;
    L66:
        if ("0001-01-01T00:00:00+08:00".equalsIgnoreCase(r104) == true) goto L101;
        int r110 = r104.lastIndexOf(124);
        if (r110 <= 20) goto L87;
        TimeZone r111 = TimeZone.getTimeZone(r104.substring(r110 + 1));
        if ("GMT".equals(r111.getID()) == true) goto L87;
        JSONScanner r112 = new JSONScanner(r104.substring(0, r110));
    L83:
        th = move-exception;
        r112.close();
        throw th;
    L74:
        if (r112.scanISO8601DateIfMatch(false) == false) goto L82;
        ?? r113 = (T) r112.getCalendar();
        r113.setTimeZone(r111);     // Catch: Throwable -> L83
        if (r101 != Calendar.class) goto L79;
        r112.close();
        return r113;
    L79:
        T r114 = (T) r113.getTime();
        r112.close();
        return r114;
    L82:
        r112.close();
    L87:
        return (T) new Date(CastLongProtector.parseLong(r104));
    L101:
        return null;
    L39:
        if (r104.length() != 22) goto L43;
        if (r108.equals("yyyyMMddHHmmssSSSZ") == true) goto L50;
    L43:
        if (r104.indexOf(84) != (-1)) goto L45;
    L49:
        r109 = false;
        goto L51
    L45:
        if (r108.contains("'T'") == false) goto L49;
        if ((r104.length() + 2) != r108.length()) goto L49;
    L24:
        if (r104.endsWith(" 000") == false) goto L26;
        r104 = r104.substring(0, 19);
        goto L26
    L92:
        throw new JSONException("parse error");
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r110, Object r111, Object r112, Type r210, int r211) throws IOException {
        SerializeWriter r100 = r110.out;
        if (r111 != null) goto L6;
        r100.writeNull();
        return;
    L6:
        Class<?> r101 = r111.getClass();
        if (r101 != java.sql.Date.class) goto L17;
        if (r100.isEnabled(SerializerFeature.WriteDateUseDateFormat) == true) goto L17;
        long r102 = ((java.sql.Date) r111).getTime();
        if (((r102 + ((long) r110.timeZone.getOffset(r102))) % 86400000) != 0) goto L17;
        if (SerializerFeature.isEnabled(r100.features, r211, SerializerFeature.WriteClassName) == true) goto L17;
        r100.writeString(r111.toString());
        return;
    L17:
        if (r101 != Time.class) goto L31;
        long r113 = ((Time) r111).getTime();
        if ("unixtime".equals(r110.getDateFormatPattern()) == false) goto L23;
        r100.writeLong(r113 / 1000);
        return;
    L23:
        if ("millis".equals(r110.getDateFormatPattern()) == false) goto L27;
        r100.writeLong(r113);
        return;
    L27:
        if (r113 >= 86400000) goto L31;
        r100.writeString(r111.toString());
        return;
    L31:
        if (r101 != Timestamp.class) goto L33;
        int r103 = ((Timestamp) r111).getNanos();
    L35:
        if ((r111 instanceof Date) == false) goto L37;
        Date r104 = (Date) r111;
    L39:
        if ("unixtime".equals(r110.getDateFormatPattern()) == false) goto L43;
        r100.writeLong(r104.getTime() / 1000);
        return;
    L43:
        if ("millis".equals(r110.getDateFormatPattern()) == false) goto L47;
        r100.writeLong(r104.getTime());
        return;
    L47:
        if (r100.isEnabled(SerializerFeature.WriteDateUseDateFormat) == false) goto L57;
        DateFormat r105 = r110.getDateFormat();
        if (r105 != null) goto L54;
        String r106 = r110.getFastJsonConfigDateFormatPattern();
        if (r106 != null) goto L53;
        r106 = JSON.DEFFAULT_DATE_FORMAT;
    L53:
        SimpleDateFormat r107 = new SimpleDateFormat(r106, r110.locale);
        r107.setTimeZone(r110.timeZone);
        r105 = r107;
    L54:
        r100.writeString(r105.format(r104));
        return;
    L57:
        if (r100.isEnabled(SerializerFeature.WriteClassName) == true) goto L59;
    L65:
        long r108 = r104.getTime();
        if (r100.isEnabled(SerializerFeature.UseISO8601DateFormat) == true) goto L68;
        r100.writeLong(r108);
        return;
    L68:
        if (r100.isEnabled(SerializerFeature.UseSingleQuotes) == false) goto L70;
        int r109 = 39;
    L71:
        r100.write(r109);
        Calendar r114 = Calendar.getInstance(r110.timeZone, r110.locale);
        r114.setTimeInMillis(r108);
        int r115 = r114.get(1);
        int r116 = r114.get(2) + 1;
        int r117 = r114.get(5);
        int r118 = r114.get(11);
        int r119 = r114.get(12);
        int r120 = r114.get(13);
        int r121 = r114.get(14);
        if (r103 <= 0) goto L74;
        char[] r122 = "0000-00-00 00:00:00.000000000".toCharArray();
        IOUtils.getChars(r103, 29, r122);
        IOUtils.getChars(r120, 19, r122);
        IOUtils.getChars(r119, 16, r122);
        IOUtils.getChars(r118, 13, r122);
        IOUtils.getChars(r117, 10, r122);
        IOUtils.getChars(r116, 7, r122);
        IOUtils.getChars(r115, 4, r122);
    L83:
        if (r103 <= 0) goto L92;
        int r123 = 0;
    L85:
        if (r123 >= 9) goto L90;
        if (r122[(r122.length - r123) - 1] != '0') goto L90;
        r123 = r123 + 1;
    L90:
        r100.write(r122, 0, r122.length - r123);
        r100.write(r109);
        return;
    L92:
        r100.write(r122);
        float r124 = r114.getTimeZone().getOffset(r114.getTimeInMillis()) / 3600000.0f;
        int r125 = (int) r124;
        if (r125 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L96;
        r100.write(90);
    L106:
        r100.write(r109);
        return;
    L96:
        if (r125 <= 9) goto L98;
        r100.write(43);
        r100.writeInt(r125);
    L105:
        r100.write(58);
        r100.append(String.format("%02d", new Object[]{Integer.valueOf((int) (Math.abs(r124 - r125) * 60.0f))}));
        goto L106
    L98:
        if (r125 <= 0) goto L101;
        r100.write(43);
        r100.write(48);
        r100.writeInt(r125);
        goto L105
    L101:
        if (r125 >= (-9)) goto L103;
        r100.write(45);
        r100.writeInt(-r125);
        goto L105
    L103:
        if (r125 >= 0) goto L105;
        r100.write(45);
        r100.write(48);
        r100.writeInt(-r125);
        goto L105
    L74:
        if (r121 == 0) goto L77;
        char[] r126 = "0000-00-00T00:00:00.000".toCharArray();
        IOUtils.getChars(r121, 23, r126);
        IOUtils.getChars(r120, 19, r126);
        IOUtils.getChars(r119, 16, r126);
        IOUtils.getChars(r118, 13, r126);
        IOUtils.getChars(r117, 10, r126);
        IOUtils.getChars(r116, 7, r126);
        IOUtils.getChars(r115, 4, r126);
        r122 = r126;
        goto L83
    L77:
        if (r120 != 0) goto L81;
        if (r119 != 0) goto L81;
        if (r118 != 0) goto L81;
        char[] r127 = "0000-00-00".toCharArray();
        IOUtils.getChars(r117, 10, r127);
        IOUtils.getChars(r116, 7, r127);
        IOUtils.getChars(r115, 4, r127);
        r122 = r127;
    L81:
        r122 = "0000-00-00T00:00:00".toCharArray();
        IOUtils.getChars(r120, 19, r122);
        IOUtils.getChars(r119, 16, r122);
        IOUtils.getChars(r118, 13, r122);
        IOUtils.getChars(r117, 10, r122);
        IOUtils.getChars(r116, 7, r122);
        IOUtils.getChars(r115, 4, r122);
        goto L83
    L70:
        r109 = 34;
        goto L71
    L59:
        if (r101 == r210) goto L65;
        if (r101 != Date.class) goto L63;
        r100.write("new Date(");
        r100.writeLong(((Date) r111).getTime());
        r100.write(41);
        return;
    L63:
        r100.write(123);
        r100.writeFieldName(JSON.DEFAULT_TYPE_KEY);
        r110.write(r101.getName());
        r100.writeFieldValue(',', "val", ((Date) r111).getTime());
        r100.write(125);
        return;
    L37:
        r104 = TypeUtils.castToDate(r111);
        goto L39
    L33:
        r103 = 0;
        goto L35
    }
}
