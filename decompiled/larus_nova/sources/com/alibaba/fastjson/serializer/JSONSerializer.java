package com.alibaba.fastjson.serializer;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class JSONSerializer extends SerializeFilterable {
    protected final SerializeConfig config;
    protected SerialContext context;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private String fastJsonConfigDateFormatPattern;
    private String indent;
    private int indentCount;
    protected Locale locale;
    public final SerializeWriter out;
    protected IdentityHashMap<Object, SerialContext> references;
    protected TimeZone timeZone;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
    }

    public void close() {
        this.out.close();
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat != null) goto L8;
        String r100 = this.dateFormatPattern;
        if (r100 == null) goto L8;
        this.dateFormat = generateDateFormat(r100);
    L8:
        return this.dateFormat;
    }

    public String getDateFormatPattern() {
        DateFormat r100 = this.dateFormat;
        if ((r100 instanceof SimpleDateFormat) == false) goto L7;
        return ((SimpleDateFormat) r100).toPattern();
    L7:
        return this.dateFormatPattern;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void popContext() {
        SerialContext r100 = this.context;
        if (r100 == null) goto L6;
        this.context = r100.parent;
        return;
    }

    public void println() {
        this.out.write(10);
        int r100 = 0;
    L4:
        if (r100 >= this.indentCount) goto L6;
        this.out.write(this.indent);
        r100 = r100 + 1;
        goto L4
    }

    public String toString() {
        return this.out.toString();
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public SerialContext getContext() {
        return this.context;
    }

    public String getFastJsonConfigDateFormatPattern() {
        return this.fastJsonConfigDateFormatPattern;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public SerializeConfig getMapping() {
        return this.config;
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public JSONSerializer(SerializeConfig r100) {
        this(new SerializeWriter(), r100);
    }

    private DateFormat generateDateFormat(String r100) {
        SimpleDateFormat r101 = new SimpleDateFormat(r100, this.locale);
        r101.setTimeZone(this.timeZone);
        return r101;
    }

    public boolean checkValue(SerializeFilterable r100) {
        List<ValueFilter> r101 = this.valueFilters;
        if (r101 != null) goto L5;
    L6:
        List<ContextValueFilter> r102 = this.contextValueFilters;
        if (r102 != null) goto L9;
    L10:
        List<ValueFilter> r103 = r100.valueFilters;
        if (r103 != null) goto L13;
    L14:
        List<ContextValueFilter> r104 = r100.contextValueFilters;
        if (r104 == null) goto L19;
        if (r104.size() <= 0) goto L19;
    L20:
        return true;
    L19:
        if (this.out.writeNonStringValueAsString == true) goto L20;
        return false;
    L13:
        if (r103.size() > 0) goto L20;
    L9:
        if (r102.size() > 0) goto L20;
    L5:
        if (r101.size() > 0) goto L20;
        goto L6
    }

    public boolean containsReference(Object r100) {
        IdentityHashMap<Object, SerialContext> r101 = this.references;
        if (r101 != null) goto L5;
        return false;
    L5:
        SerialContext r102 = r101.get(r100);
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r100 != Collections.emptyMap()) goto L11;
        return false;
    L11:
        Object r103 = r102.fieldName;
        if (r103 != null) goto L14;
    L17:
        return true;
    L14:
        if ((r103 instanceof Integer) == true) goto L17;
        if ((r103 instanceof String) == true) goto L17;
        return false;
    }

    public ObjectSerializer getObjectWriter(Class<?> r100) {
        return this.config.getObjectWriter(r100);
    }

    public boolean hasNameFilters(SerializeFilterable r100) {
        List<NameFilter> r101 = this.nameFilters;
        if (r101 != null) goto L5;
    L6:
        List<NameFilter> r102 = r100.nameFilters;
        if (r102 != null) goto L9;
    L11:
        return false;
    L9:
        if (r102.size() <= 0) goto L11;
    L10:
        return true;
    L5:
        if (r101.size() > 0) goto L10;
        goto L6
    }

    public boolean hasPropertyFilters(SerializeFilterable r100) {
        List<PropertyFilter> r101 = this.propertyFilters;
        if (r101 != null) goto L5;
    L6:
        List<PropertyFilter> r102 = r100.propertyFilters;
        if (r102 != null) goto L9;
    L11:
        return false;
    L9:
        if (r102.size() <= 0) goto L11;
    L10:
        return true;
    L5:
        if (r101.size() > 0) goto L10;
        goto L6
    }

    public boolean isEnabled(SerializerFeature r100) {
        return this.out.isEnabled(r100);
    }

    public void setContext(SerialContext r100) {
        this.context = r100;
    }

    public void setDateFormat(String r100) {
        this.dateFormatPattern = r100;
        if (this.dateFormat == null) goto L6;
        this.dateFormat = null;
        return;
    }

    public void setFastJsonConfigDateFormatPattern(String r100) {
        this.fastJsonConfigDateFormatPattern = r100;
    }

    public final void write(Object r100) {
        if (r100 != null) goto L11;
        this.out.writeNull();
        return;
    L11:
        getObjectWriter(r100.getClass()).write(this, r100, null, null, 0);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public void writeReference(Object r100) {
        SerialContext r101 = this.context;
        if (r100 != r101.object) goto L6;
        this.out.write("{\"$ref\":\"@\"}");
        return;
    L6:
        SerialContext r102 = r101.parent;
        if (r102 == null) goto L12;
        if (r100 != r102.object) goto L12;
        this.out.write("{\"$ref\":\"..\"}");
        return;
    L12:
        SerialContext r103 = r101.parent;
        if (r103 == null) goto L15;
        r101 = r103;
        goto L12
    L15:
        if (r100 != r101.object) goto L17;
        this.out.write("{\"$ref\":\"$\"}");
        return;
    L17:
        this.out.write("{\"$ref\":\"");
        String r104 = this.references.get(r100).toString();
        this.out.write(r104);
        this.out.write("\"}");
    }

    public JSONSerializer(SerializeWriter r100) {
        this(r100, SerializeConfig.getGlobalInstance());
    }

    public void setDateFormat(DateFormat r100) {
        this.dateFormat = r100;
        if (this.dateFormatPattern == null) goto L6;
        this.dateFormatPattern = null;
        return;
    }

    public final void write(String r100) {
        StringCodec.instance.write(this, r100);
    }

    public JSONSerializer(SerializeWriter r100, SerializeConfig r101) {
        this.indentCount = 0;
        this.indent = "\t";
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = r100;
        this.config = r101;
    }

    public static void write(Writer r100, Object r101) {
        SerializeWriter r102 = new SerializeWriter();
        new JSONSerializer(r102).write(r101);     // Catch: Throwable -> L6 IOException -> L8
        r102.writeTo(r100);     // Catch: Throwable -> L6 IOException -> L8
        r102.close();
        return;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public void config(SerializerFeature r100, boolean r101) {
        this.out.config(r100, r101);
    }

    public final boolean isWriteClassName(Type r100, Object r101) {
        if (this.out.isEnabled(SerializerFeature.WriteClassName) == false) goto L12;
        if (r100 == null) goto L6;
    L11:
        return true;
    L6:
        if (this.out.isEnabled(SerializerFeature.NotWriteRootClassName) == false) goto L11;
        SerialContext r102 = this.context;
        if (r102 == null) goto L12;
        if (r102.parent != null) goto L11;
    L12:
        return false;
    }

    public void setContext(Object r100, Object r101) {
        setContext(this.context, r100, r101, 0);
    }

    public final void writeAs(Object r100, Class r101) {
        if (r100 != null) goto L11;
        this.out.writeNull();
        return;
    L11:
        getObjectWriter(r101).write(this, r100, null, null, 0);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public final void writeWithFieldName(Object r100, Object r101) {
        writeWithFieldName(r100, r101, null, 0);
    }

    public final void writeWithFormat(Object r100, String r101) {
        if ((r100 instanceof Date) == false) goto L25;
        if ("unixtime".equals(r101) == false) goto L9;
        long r102 = ((Date) r100).getTime() / 1000;
        this.out.writeInt((int) r102);
        return;
    L9:
        if ("millis".equals(r101) == false) goto L12;
        this.out.writeLong(((Date) r100).getTime());
        return;
    L12:
        DateFormat r103 = getDateFormat();
        if (r103 != null) goto L22;
        if (r101 != null) goto L63;
        String r104 = this.fastJsonConfigDateFormatPattern;
        if (r104 == null) goto L21;
        r103 = generateDateFormat(r104);
        goto L22
    L21:
        r103 = generateDateFormat(JSON.DEFFAULT_DATE_FORMAT);
        goto L22
    L63:
        r103 = generateDateFormat(r101);     // Catch: IllegalArgumentException -> L17
    L17:
        r103 = generateDateFormat(r101.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"));
    L22:
        String r105 = r103.format((Date) r100);
        this.out.writeString(r105);
        return;
    L25:
        if ((r100 instanceof byte[]) == false) goto L51;
        byte[] r106 = (byte[]) r100;
        if (DownloadHelper.GZIP.equals(r101) == false) goto L29;
    L35:
        GZIPOutputStream r107 = null;
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L43 IOException -> L45
        if (r106.length >= 512) goto L39;
        GZIPOutputStream r109 = new GZIPOutputStream(r108, r106.length);     // Catch: Throwable -> L43 IOException -> L45
    L40:
        r107 = r109;
        r107.write(r106);     // Catch: Throwable -> L43 IOException -> L45
        r107.finish();     // Catch: Throwable -> L43 IOException -> L45
        this.out.writeByteArray(r108.toByteArray());     // Catch: Throwable -> L43 IOException -> L45
        IOUtils.close(r107);
        return;
    L39:
        r109 = new GZIPOutputStream(r108);     // Catch: Throwable -> L43 IOException -> L45
    L45:
        e = move-exception;
        throw new JSONException("write gzipBytes error", e);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        IOUtils.close(r107);
        throw th;
    L29:
        if ("gzip,base64".equals(r101) == true) goto L35;
        if ("hex".equals(r101) == false) goto L34;
        this.out.writeHex(r106);
        return;
    L34:
        this.out.writeByteArray(r106);
        return;
    L51:
        if ((r100 instanceof Collection) == false) goto L61;
        Collection r110 = (Collection) r100;
        Iterator r111 = r110.iterator();
        this.out.write(91);
        int r112 = 0;
    L54:
        if (r112 >= r110.size()) goto L59;
        Object r113 = r111.next();
        if (r112 == 0) goto L58;
        this.out.write(44);
    L58:
        writeWithFormat(r113, r101);
        r112 = r112 + 1;
        goto L54
    L59:
        this.out.write(93);
        return;
    L61:
        write(r100);
    }

    public static void write(SerializeWriter r100, Object r101) {
        new JSONSerializer(r100).write(r101);
    }

    public final void writeKeyValue(char r100, String r101, Object r102) {
        if (r100 == 0) goto L4;
        this.out.write(r100);
    L4:
        this.out.writeFieldName(r101);
        write(r102);
    }

    public void setContext(SerialContext r100, Object r101, Object r102, int r110) {
        setContext(r100, r101, r102, r110, 0);
    }

    public final void writeWithFieldName(Object r100, Object r101, Type r110, int r111) {
        if (r100 != null) goto L5;
        this.out.writeNull();     // Catch: IOException -> L7
        return;
    L5:
        getObjectWriter(r100.getClass()).write(this, r100, r101, r110, r111);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public void setContext(SerialContext r100, Object r101, Object r110, int r111, int r112) {
        if (this.out.disableCircularReferenceDetect == false) goto L5;
        return;
    L5:
        this.context = new SerialContext(r100, r101, r110, r111, r112);
        if (this.references != null) goto L8;
        this.references = new IdentityHashMap();
    L8:
        this.references.put(r101, this.context);
    }
}
