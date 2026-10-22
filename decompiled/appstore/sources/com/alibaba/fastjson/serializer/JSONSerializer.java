package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class JSONSerializer {
    protected List<AfterFilter> afterFilters;
    protected List<BeforeFilter> beforeFilters;
    public final SerializeConfig config;
    protected SerialContext context;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private int indentCount;
    public Locale locale;
    protected List<NameFilter> nameFilters;
    public final SerializeWriter out;
    protected List<PropertyFilter> propertyFilters;
    protected List<PropertyPreFilter> propertyPreFilters;
    protected IdentityHashMap<Object, SerialContext> references;
    public TimeZone timeZone;
    protected List<ValueFilter> valueFilters;

    public JSONSerializer() {
        this(new SerializeWriter(null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY), SerializeConfig.globalInstance);
    }

    public static Object processValue(JSONSerializer r10, Object r11, Object r12, Object r13) {
        List<ValueFilter> r14 = r10.valueFilters;
        if (r14 == null) goto L12;
        if (r12 != null) goto L6;
    L8:
        Iterator<ValueFilter> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        r13 = r15.next().process(r11, (String) r12, r13);
        goto L10
    L6:
        if ((r12 instanceof String) == true) goto L8;
        r12 = JSON.toJSONString(r12);
    L12:
        return r13;
    }

    public static final void write(Writer r10, Object r11) {
        SerializeWriter r12 = new SerializeWriter(null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        new JSONSerializer(r12, SerializeConfig.globalInstance).write(r11);     // Catch: Throwable -> L6 IOException -> L8
        r12.writeTo(r10);     // Catch: Throwable -> L6 IOException -> L8
        r12.close();
        return;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public boolean apply(Object r10, Object r11, Object r12) {
        List<PropertyFilter> r13 = this.propertyFilters;
        if (r13 != null) goto L5;
        return true;
    L5:
        if (r11 != null) goto L7;
    L9:
        Iterator<PropertyFilter> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L16;
        if (r14.next().apply(r10, (String) r11, r12) == true) goto L11;
        return false;
    L16:
        return true;
    L7:
        if ((r11 instanceof String) == true) goto L9;
        r11 = JSON.toJSONString(r11);
        goto L9
    }

    public boolean applyName(Object r10, Object r11) {
        List<PropertyPreFilter> r12 = this.propertyPreFilters;
        if (r12 != null) goto L5;
        return true;
    L5:
        Iterator<PropertyPreFilter> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L17;
        PropertyPreFilter r14 = r13.next();
        if (r11 == null) goto L14;
        if ((r11 instanceof String) == true) goto L14;
        r11 = JSON.toJSONString(r11);
    L14:
        if (r14.apply(this, r10, (String) r11) == true) goto L7;
        return false;
    L17:
        return true;
    }

    public void close() {
        this.out.close();
    }

    public void config(SerializerFeature r10, boolean r11) {
        this.out.config(r10, r11);
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters != null) goto L6;
        this.afterFilters = new ArrayList();
    L6:
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters != null) goto L6;
        this.beforeFilters = new ArrayList();
    L6:
        return this.beforeFilters;
    }

    public SerialContext getContext() {
        return this.context;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat != null) goto L8;
        if (this.dateFormatPattern == null) goto L8;
        SimpleDateFormat r10 = new SimpleDateFormat(this.dateFormatPattern, this.locale);
        this.dateFormat = r10;
        r10.setTimeZone(this.timeZone);
    L8:
        return this.dateFormat;
    }

    public String getDateFormatPattern() {
        DateFormat r10 = this.dateFormat;
        if ((r10 instanceof SimpleDateFormat) == false) goto L7;
        return ((SimpleDateFormat) r10).toPattern();
    L7:
        return this.dateFormatPattern;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters != null) goto L6;
        this.nameFilters = new ArrayList();
    L6:
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters != null) goto L6;
        this.propertyFilters = new ArrayList();
    L6:
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters != null) goto L6;
        this.propertyPreFilters = new ArrayList();
    L6:
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters != null) goto L6;
        this.valueFilters = new ArrayList();
    L6:
        return this.valueFilters;
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void println() {
        this.out.write(10);
        int r10 = 0;
    L4:
        if (r10 >= this.indentCount) goto L6;
        this.out.write(9);
        r10 = r10 + 1;
        goto L4
    }

    public Object processKey(Object r10, Object r11, Object r12) {
        List<NameFilter> r13 = this.nameFilters;
        if (r13 == null) goto L12;
        if (r11 != null) goto L6;
    L8:
        Iterator<NameFilter> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r11 = r14.next().process(r10, (String) r11, r12);
        goto L10
    L6:
        if ((r11 instanceof String) == true) goto L8;
        r11 = JSON.toJSONString(r11);
    L12:
        return r11;
    }

    public void setContext(SerialContext r10, Object r11, Object r12, int r13) {
        if ((this.out.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0) goto L9;
        this.context = new SerialContext(r10, r11, r12, r13);
        if (this.references != null) goto L7;
        this.references = new IdentityHashMap();
    L7:
        this.references.put(r11, this.context);
        return;
    }

    public void setDateFormat(DateFormat r10) {
        this.dateFormat = r10;
        if (this.dateFormatPattern == null) goto L6;
        this.dateFormatPattern = null;
        return;
    }

    public String toString() {
        return this.out.toString();
    }

    public final void writeKeyValue(char r10, String r11, Object r12) {
        if (r10 == 0) goto L4;
        this.out.write(r10);
    L4:
        this.out.writeFieldName(r11, true);
        write(r12);
    }

    public void writeReference(Object r10) {
        SerialContext r11 = this.context;
        if (r10 != r11.object) goto L6;
        this.out.write("{\"$ref\":\"@\"}");
        return;
    L6:
        SerialContext r12 = r11.parent;
        if (r12 == null) goto L12;
        if (r10 != r12.object) goto L12;
        this.out.write("{\"$ref\":\"..\"}");
        return;
    L12:
        SerialContext r13 = r11.parent;
        if (r13 == null) goto L15;
        r11 = r13;
        goto L12
    L15:
        if (r10 != r11.object) goto L18;
        this.out.write("{\"$ref\":\"$\"}");
        return;
    L18:
        String r14 = this.references.get(r10).toString();
        this.out.write("{\"$ref\":\"");
        this.out.write(r14);
        this.out.write("\"}");
    }

    public final void writeWithFieldName(Object r10, Object r11) {
        writeWithFieldName(r10, r11, null, 0);
    }

    public final void writeWithFormat(Object r10, String r11) {
        if ((r10 instanceof Date) == false) goto L9;
        DateFormat r12 = getDateFormat();
        if (r12 != null) goto L7;
        r12 = new SimpleDateFormat(r11, this.locale);
        r12.setTimeZone(this.timeZone);
    L7:
        String r13 = r12.format((Date) r10);
        this.out.writeString(r13);
        return;
    L9:
        write(r10);
    }

    public JSONSerializer(SerializeWriter r10) {
        this(r10, SerializeConfig.globalInstance);
    }

    public final void writeWithFieldName(Object r10, Object r11, Type r12, int r13) {
        if (r10 != null) goto L7;
        this.out.writeNull();     // Catch: IOException -> L5
        return;
    L7:
        Class<?> r14 = r10.getClass();     // Catch: IOException -> L5
        this.config.get(r14).write(this, r10, r11, r12);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public JSONSerializer(SerializeConfig r10) {
        this(new SerializeWriter(null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY), r10);
    }

    public JSONSerializer(SerializeWriter r10, SerializeConfig r11) {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.indentCount = 0;
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = r10;
        this.config = r11;
        this.timeZone = JSON.defaultTimeZone;
    }

    public void setDateFormat(String r10) {
        this.dateFormatPattern = r10;
        if (this.dateFormat == null) goto L6;
        this.dateFormat = null;
        return;
    }

    public static final void write(SerializeWriter r10, Object r11) {
        new JSONSerializer(r10, SerializeConfig.globalInstance).write(r11);
    }

    public final void write(Object r10) {
        if (r10 != null) goto L5;
        this.out.writeNull();
        return;
    L5:
        Class<?> r11 = r10.getClass();
        this.config.get(r11).write(this, r10, null, null);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public final void write(String r10) {
        if (r10 != null) goto L8;
        SerializeWriter r11 = this.out;
        if ((r11.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) goto L6;
        r11.writeString("");
        return;
    L6:
        r11.writeNull();
        return;
    L8:
        SerializeWriter r12 = this.out;
        if ((r12.features & SerializerFeature.UseSingleQuotes.mask) == 0) goto L11;
        r12.writeStringWithSingleQuote(r10);
        return;
    L11:
        r12.writeStringWithDoubleQuote(r10, 0, true);
    }
}
