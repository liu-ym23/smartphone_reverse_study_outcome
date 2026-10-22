package com.alibaba.fastjson.serializer;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes28.dex */
public class CalendarCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer {
    public static final CalendarCodec instance = null;
    private DatatypeFactory dateFactory;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    static {
        instance = new CalendarCodec();
    }

    public CalendarCodec() {
    }

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar r100) {
        if (this.dateFactory != null) goto L10;
        this.dateFactory = DatatypeFactory.newInstance();     // Catch: DatatypeConfigurationException -> L6
    L6:
        e = move-exception;
        throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e);
    L10:
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) r100);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100, r101, r102, null, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer r100, Object r101, BeanContext r102) throws IOException {
        SerializeWriter r103 = r100.out;
        String r104 = r102.getFormat();
        Calendar r105 = (Calendar) r101;
        if (r104.equals("unixtime") == false) goto L6;
        r103.writeInt((int) (r105.getTimeInMillis() / 1000));
        return;
    L6:
        SimpleDateFormat r106 = new SimpleDateFormat(r104);
        r106.setTimeZone(r100.timeZone);
        r103.writeString(r106.format(r105.getTime()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102, String r110, int r111) {
        T r103 = (T) DateCodec.instance.deserialze(r100, r101, r102, r110, r111);
        if ((r103 instanceof Calendar) == false) goto L5;
        return r103;
    L5:
        Date r104 = (Date) r103;
        if (r104 != null) goto L9;
        return null;
    L9:
        JSONLexer r105 = r100.lexer;
        ?? r106 = (T) Calendar.getInstance(r105.getTimeZone(), r105.getLocale());
        r106.setTime(r104);
        if (r101 == XMLGregorianCalendar.class) goto L12;
        return r106;
    L12:
        return (T) createXMLGregorianCalendar((GregorianCalendar) r106);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r110, Object r111, Object r210, Type r211, int r212) throws IOException {
        SerializeWriter r100 = r110.out;
        if (r111 != null) goto L7;
        r100.writeNull();
        return;
    L7:
        if ((r111 instanceof XMLGregorianCalendar) == false) goto L9;
        Calendar r101 = ((XMLGregorianCalendar) r111).toGregorianCalendar();
    L11:
        if (r100.isEnabled(SerializerFeature.UseISO8601DateFormat) == true) goto L13;
        r110.write(r101.getTime());
        return;
    L13:
        if (r100.isEnabled(SerializerFeature.UseSingleQuotes) == false) goto L15;
        char r102 = '\'';
    L16:
        r100.append(r102);
        int r103 = r101.get(1);
        int r104 = r101.get(2) + 1;
        int r105 = r101.get(5);
        int r106 = r101.get(11);
        int r107 = r101.get(12);
        int r112 = r101.get(13);
        int r113 = r101.get(14);
        if (r113 == 0) goto L20;
        char[] r114 = "0000-00-00T00:00:00.000".toCharArray();
        IOUtils.getChars(r113, 23, r114);
        IOUtils.getChars(r112, 19, r114);
        IOUtils.getChars(r107, 16, r114);
        IOUtils.getChars(r106, 13, r114);
        IOUtils.getChars(r105, 10, r114);
        IOUtils.getChars(r104, 7, r114);
        IOUtils.getChars(r103, 4, r114);
    L25:
        r100.write(r114);
        float r108 = r101.getTimeZone().getOffset(r101.getTimeInMillis()) / 3600000.0f;
        int r109 = (int) r108;
        if (r109 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        r100.write(90);
    L40:
        r100.append(r102);
        return;
    L29:
        if (r109 <= 9) goto L32;
        r100.write(43);
        r100.writeInt(r109);
    L39:
        r100.write(58);
        r100.append(String.format("%02d", new Object[]{Integer.valueOf((int) ((r108 - r109) * 60.0f))}));
        goto L40
    L32:
        if (r109 <= 0) goto L35;
        r100.write(43);
        r100.write(48);
        r100.writeInt(r109);
        goto L39
    L35:
        if (r109 >= (-9)) goto L37;
        r100.write(45);
        r100.writeInt(r109);
        goto L39
    L37:
        if (r109 >= 0) goto L39;
        r100.write(45);
        r100.write(48);
        r100.writeInt(-r109);
        goto L39
    L20:
        if (r112 != 0) goto L24;
        if (r107 != 0) goto L24;
        if (r106 != 0) goto L24;
        r114 = "0000-00-00".toCharArray();
        IOUtils.getChars(r105, 10, r114);
        IOUtils.getChars(r104, 7, r114);
        IOUtils.getChars(r103, 4, r114);
    L24:
        r114 = "0000-00-00T00:00:00".toCharArray();
        IOUtils.getChars(r112, 19, r114);
        IOUtils.getChars(r107, 16, r114);
        IOUtils.getChars(r106, 13, r114);
        IOUtils.getChars(r105, 10, r114);
        IOUtils.getChars(r104, 7, r114);
        IOUtils.getChars(r103, 4, r114);
        goto L25
    L15:
        r102 = Typography.quote;
        goto L16
    L9:
        r101 = (Calendar) r111;
        goto L11
    }
}
