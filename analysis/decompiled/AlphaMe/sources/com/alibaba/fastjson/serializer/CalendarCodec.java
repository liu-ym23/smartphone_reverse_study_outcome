package com.alibaba.fastjson.serializer;

import ch.qos.logback.core.CoreConstants;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/* loaded from: classes.dex */
public class CalendarCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CalendarCodec instance = new CalendarCodec();
    private DatatypeFactory dateFactory;

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar calendar) {
        if (this.dateFactory == null) {
            try {
                this.dateFactory = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e4) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e4);
            }
        }
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t4 = (T) DateCodec.instance.deserialze(defaultJSONParser, type, obj);
        if (t4 instanceof Calendar) {
            return t4;
        }
        Date date = (Date) t4;
        if (date == null) {
            return null;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        ?? r22 = (T) Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
        r22.setTime(date);
        return type == XMLGregorianCalendar.class ? (T) createXMLGregorianCalendar((GregorianCalendar) r22) : r22;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        if (!serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            jSONSerializer.write(gregorianCalendar.getTime());
            return;
        }
        char c4 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
        serializeWriter.append(c4);
        int i5 = gregorianCalendar.get(1);
        int i6 = gregorianCalendar.get(2) + 1;
        int i7 = gregorianCalendar.get(5);
        int i8 = gregorianCalendar.get(11);
        int i9 = gregorianCalendar.get(12);
        int i10 = gregorianCalendar.get(13);
        int i11 = gregorianCalendar.get(14);
        if (i11 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            IOUtils.getChars(i11, 23, charArray);
            IOUtils.getChars(i10, 19, charArray);
            IOUtils.getChars(i9, 16, charArray);
            IOUtils.getChars(i8, 13, charArray);
            IOUtils.getChars(i7, 10, charArray);
            IOUtils.getChars(i6, 7, charArray);
            IOUtils.getChars(i5, 4, charArray);
        } else if (i10 == 0 && i9 == 0 && i8 == 0) {
            charArray = "0000-00-00".toCharArray();
            IOUtils.getChars(i7, 10, charArray);
            IOUtils.getChars(i6, 7, charArray);
            IOUtils.getChars(i5, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            IOUtils.getChars(i10, 19, charArray);
            IOUtils.getChars(i9, 16, charArray);
            IOUtils.getChars(i8, 13, charArray);
            IOUtils.getChars(i7, 10, charArray);
            IOUtils.getChars(i6, 7, charArray);
            IOUtils.getChars(i5, 4, charArray);
        }
        serializeWriter.write(charArray);
        int rawOffset = gregorianCalendar.getTimeZone().getRawOffset() / CoreConstants.MILLIS_IN_ONE_HOUR;
        if (rawOffset == 0) {
            serializeWriter.append((CharSequence) "Z");
        } else if (rawOffset > 0) {
            serializeWriter.append((CharSequence) "+").append((CharSequence) String.format("%02d", Integer.valueOf(rawOffset))).append((CharSequence) ":00");
        } else {
            serializeWriter.append((CharSequence) "-").append((CharSequence) String.format("%02d", Integer.valueOf(-rawOffset))).append((CharSequence) ":00");
        }
        serializeWriter.append(c4);
    }
}
