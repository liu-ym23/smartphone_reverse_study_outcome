package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = 0;
    public static final String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = null;
    public static final String VERSION = "1.1.56";
    public static Locale defaultLocale;
    public static TimeZone defaultTimeZone;

    static {
        defaultTimeZone = TimeZone.getDefault();
        defaultLocale = Locale.getDefault();
        DEFAULT_PARSER_FEATURE = (Feature.UseBigDecimal.mask | Feature.SortFeidFastMatch.mask) | Feature.IgnoreNotMatch.mask;
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        DEFAULT_GENERATE_FEATURE = ((SerializerFeature.QuoteFieldNames.mask | SerializerFeature.SkipTransientField.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.SortField.mask;
    }

    public JSON() {
    }

    public static final Object parse(String r10) {
        return parse(r10, DEFAULT_PARSER_FEATURE);
    }

    public static final JSONArray parseArray(String r10) {
        JSONArray r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r12 = new DefaultJSONParser(r10, ParserConfig.global);
        JSONLexer r13 = r12.lexer;
        int r14 = r13.token();
        if (r14 != 8) goto L9;
        r13.nextToken();
    L12:
        r12.close();
        return r11;
    L9:
        if (r14 == 20) goto L12;
        r11 = new JSONArray();
        r12.parseArray(r11);
        r12.handleResovleTask(r11);
        goto L12
    }

    public static final JSONObject parseObject(String r10, Feature... r11) {
        return (JSONObject) parse(r10, r11);
    }

    public static final Object toJSON(Object r10) {
        return toJSON(r10, SerializeConfig.globalInstance);
    }

    public static final byte[] toJSONBytes(Object r10, SerializerFeature... r11) {
        SerializeWriter r12 = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, r11);
        new JSONSerializer(r12, SerializeConfig.globalInstance).write(r10);     // Catch: Throwable -> L6
        byte[] r13 = r12.toBytes("UTF-8");     // Catch: Throwable -> L6
        r12.close();
        return r13;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }

    public static final String toJSONString(Object r10) {
        return toJSONString(r10, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, new SerializerFeature[0]);
    }

    public static final String toJSONStringWithDateFormat(Object r10, String r11, SerializerFeature... r12) {
        return toJSONString(r10, SerializeConfig.globalInstance, null, r11, DEFAULT_GENERATE_FEATURE, r12);
    }

    public static final String toJSONStringZ(Object r10, SerializeConfig r11, SerializerFeature... r12) {
        return toJSONString(r10, SerializeConfig.globalInstance, null, null, 0, r12);
    }

    public static final <T> T toJavaObject(JSON r10, Class<T> r11) {
        return (T) TypeUtils.cast(r10, r11, ParserConfig.global);
    }

    public static final void writeJSONStringTo(Object r10, Writer r11, SerializerFeature... r12) {
        SerializeWriter r13 = new SerializeWriter(r11, DEFAULT_GENERATE_FEATURE, r12);
        new JSONSerializer(r13, SerializeConfig.globalInstance).write(r10);     // Catch: Throwable -> L6
        r13.close();
        return;
    L6:
        th = move-exception;
        r13.close();
        throw th;
    }

    public String toString() {
        return toJSONString();
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable r10) {
        SerializeWriter r11 = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        new JSONSerializer(r11, SerializeConfig.globalInstance).write(this);     // Catch: Throwable -> L6 IOException -> L8
        r10.append(r11.toString());     // Catch: Throwable -> L6 IOException -> L8
        r11.close();
        return;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static final Object parse(String r10, int r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r12 = new DefaultJSONParser(r10, ParserConfig.global, r11);
        Object r13 = r12.parse(null);
        r12.handleResovleTask(r13);
        r12.close();
        return r13;
    }

    public static final JSONObject parseObject(String r10) {
        Object r11 = parse(r10);
        if ((r11 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r11;
    L7:
        return (JSONObject) toJSON(r11);
    }

    @Deprecated
    public static final Object toJSON(Object r10, ParserConfig r11) {
        return toJSON(r10, SerializeConfig.globalInstance);
    }

    public static final String toJSONString(Object r10, SerializerFeature... r11) {
        return toJSONString(r10, DEFAULT_GENERATE_FEATURE, r11);
    }

    public <T> T toJavaObject(Class<T> r10) {
        return (T) TypeUtils.cast(this, r10, ParserConfig.getGlobalInstance());
    }

    public static Object toJSON(Object r10, SerializeConfig r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof JSON) == false) goto L10;
        return (JSON) r10;
    L10:
        if ((r10 instanceof Map) == false) goto L17;
        Map r12 = (Map) r10;
        JSONObject r13 = new JSONObject(r12.size());
        Iterator r14 = r12.entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.put2(TypeUtils.castToString(r15.getKey()), toJSON(r15.getValue()));
        goto L13
    L15:
        return r13;
    L17:
        if ((r10 instanceof Collection) == false) goto L23;
        Collection r16 = (Collection) r10;
        JSONArray r17 = new JSONArray(r16.size());
        Iterator r18 = r16.iterator();
    L20:
        if (r18.hasNext() == false) goto L22;
        r17.add(toJSON(r18.next()));
        goto L20
    L22:
        return r17;
    L23:
        Class<?> r19 = r10.getClass();
        if (r19.isEnum() == false) goto L28;
        return ((Enum) r10).name();
    L28:
        if (r19.isArray() == false) goto L34;
        int r20 = Array.getLength(r10);
        JSONArray r21 = new JSONArray(r20);
        int r22 = 0;
    L30:
        if (r22 >= r20) goto L32;
        r21.add(toJSON(Array.get(r10, r22)));
        r22 = r22 + 1;
        goto L30
    L32:
        return r21;
    L34:
        if (ParserConfig.isPrimitive(r19) == false) goto L36;
        return r10;
    L36:
        ObjectSerializer r23 = r11.get(r19);
        if ((r23 instanceof JavaBeanSerializer) == false) goto L49;
        JavaBeanSerializer r24 = (JavaBeanSerializer) r23;
        JSONObject r25 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r26 = r24.getFieldValuesMap(r10).entrySet().iterator();     // Catch: Exception -> L44
    L41:
        if (r26.hasNext() == false) goto L46;
        Map.Entry<String, Object> r27 = r26.next();     // Catch: Exception -> L44
        r25.put2(r27.getKey(), toJSON(r27.getValue()));     // Catch: Exception -> L44
        goto L41
    L46:
        return r25;
    L44:
        e = move-exception;
        throw new JSONException("toJSON error", e);
    L49:
        return null;
    }

    public static final String toJSONString(Object r10, int r11, SerializerFeature... r12) {
        return toJSONString(r10, SerializeConfig.globalInstance, null, null, r11, r12);
    }

    public static final String toJSONString(Object r10, SerializeFilter r11, SerializerFeature... r12) {
        return toJSONString(r10, SerializeConfig.globalInstance, new SerializeFilter[]{r11}, null, DEFAULT_GENERATE_FEATURE, r12);
    }

    public static final String toJSONString(Object r10, SerializeFilter[] r11, SerializerFeature... r12) {
        return toJSONString(r10, SerializeConfig.globalInstance, r11, null, DEFAULT_GENERATE_FEATURE, r12);
    }

    public static final Object parse(byte[] r10, Feature... r11) {
        return parseObject(new String(r10, "UTF-8"), r11);
    L4:
        e = move-exception;
        throw new JSONException("UTF-8 not support", e);
    }

    public static final <T> T parseObject(String r10, TypeReference<T> r11, Feature... r12) {
        return (T) parseObject(r10, r11.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, r12);
    }

    public static final byte[] toJSONBytes(Object r10, SerializeConfig r11, SerializerFeature... r12) {
        SerializeWriter r13 = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, r12);
        new JSONSerializer(r13, r11).write(r10);     // Catch: Throwable -> L6
        byte[] r14 = r13.toBytes("UTF-8");     // Catch: Throwable -> L6
        r13.close();
        return r14;
    L6:
        th = move-exception;
        r13.close();
        throw th;
    }

    public static final String toJSONString(Object r10, SerializeConfig r11, SerializerFeature... r12) {
        return toJSONString(r10, r11, null, null, DEFAULT_GENERATE_FEATURE, r12);
    }

    public static final <T> T parseObject(String r10, Class<T> r11, Feature... r12) {
        return (T) parseObject(r10, r11, ParserConfig.global, DEFAULT_PARSER_FEATURE, r12);
    }

    public static final String toJSONString(Object r10, SerializeConfig r11, SerializeFilter r12, SerializerFeature... r13) {
        return toJSONString(r10, r11, new SerializeFilter[]{r12}, null, DEFAULT_GENERATE_FEATURE, r13);
    }

    public static final Object parse(String r10, Feature... r11) {
        int r12 = DEFAULT_PARSER_FEATURE;
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L6;
        r12 = r12 | r11[r14].mask;
        r14 = r14 + 1;
        goto L3
    L6:
        return parse(r10, r12);
    }

    public static final <T> T parseObject(String r10, Class<T> r11, ParseProcess r12, Feature... r13) {
        return (T) parseObject(r10, r11, ParserConfig.global, r12, DEFAULT_PARSER_FEATURE, r13);
    }

    public static final String toJSONString(Object r10, SerializeConfig r11, SerializeFilter[] r12, SerializerFeature... r13) {
        return toJSONString(r10, r11, r12, null, DEFAULT_GENERATE_FEATURE, r13);
    }

    public static final <T> List<T> parseArray(String r10, Class<T> r11) {
        ArrayList r12 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r13 = new DefaultJSONParser(r10, ParserConfig.global);
        JSONLexer r14 = r13.lexer;
        int r15 = r14.token();
        if (r15 != 8) goto L9;
        r14.nextToken();
    L14:
        r13.close();
        return r12;
    L9:
        if (r15 == 20) goto L11;
    L13:
        r12 = new ArrayList();
        r13.parseArray(r11, r12);
        r13.handleResovleTask(r12);
        goto L14
    L11:
        if (r14.isBlankInput() == false) goto L13;
        goto L13
    }

    public static final <T> T parseObject(String r10, Type r11, Feature... r12) {
        return (T) parseObject(r10, r11, ParserConfig.global, DEFAULT_PARSER_FEATURE, r12);
    }

    public static final String toJSONString(Object r10, boolean r11) {
        if (r11 == true) goto L6;
        return toJSONString(r10);
    L6:
        return toJSONString(r10, new SerializerFeature[]{SerializerFeature.PrettyFormat});
    }

    public static final <T> T parseObject(String r10, Type r11, ParseProcess r12, Feature... r13) {
        return (T) parseObject(r10, r11, ParserConfig.global, r12, DEFAULT_PARSER_FEATURE, r13);
    }

    public static final <T> T parseObject(String r10, Type r11, int r12, Feature... r13) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L8;
        r12 = r12 | r13[r15].mask;
        r15 = r15 + 1;
        goto L6
    L8:
        DefaultJSONParser r16 = new DefaultJSONParser(r10, ParserConfig.global, r12);
        T r17 = (T) r16.parseObject(r11);
        r16.handleResovleTask(r17);
        r16.close();
        return r17;
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        SerializeWriter r10 = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        new JSONSerializer(r10, SerializeConfig.globalInstance).write(this);     // Catch: Throwable -> L6
        String r11 = r10.toString();     // Catch: Throwable -> L6
        r10.close();
        return r11;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    }

    public static String toJSONString(Object r10, SerializeConfig r11, SerializeFilter[] r12, String r13, int r14, SerializerFeature... r15) {
        SerializeWriter r16 = new SerializeWriter(null, r14, r15);
        JSONSerializer r17 = new JSONSerializer(r16, r11);     // Catch: Throwable -> L7
        int r18 = r15.length;     // Catch: Throwable -> L7
        int r19 = 0;
        int r20 = 0;
    L5:
        if (r20 >= r18) goto L9;
        r17.config(r15[r20], true);     // Catch: Throwable -> L7
        r20 = r20 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        if (r13 != null) goto L11;
    L13:
        if (r12 == null) goto L38;
        int r21 = r12.length;     // Catch: Throwable -> L7
    L15:
        if (r19 >= r21) goto L38;
        SerializeFilter r22 = r12[r19];     // Catch: Throwable -> L7
        if (r22 != null) goto L20;
    L37:
        r19 = r19 + 1;     // Catch: Throwable -> L7
        goto L15
    L20:
        if ((r22 instanceof PropertyPreFilter) == false) goto L23;
        r17.getPropertyPreFilters().add((PropertyPreFilter) r22);     // Catch: Throwable -> L7
    L23:
        if ((r22 instanceof NameFilter) == false) goto L26;
        r17.getNameFilters().add((NameFilter) r22);     // Catch: Throwable -> L7
    L26:
        if ((r22 instanceof ValueFilter) == false) goto L29;
        r17.getValueFilters().add((ValueFilter) r22);     // Catch: Throwable -> L7
    L29:
        if ((r22 instanceof PropertyFilter) == false) goto L32;
        r17.getPropertyFilters().add((PropertyFilter) r22);     // Catch: Throwable -> L7
    L32:
        if ((r22 instanceof BeforeFilter) == false) goto L35;
        r17.getBeforeFilters().add((BeforeFilter) r22);     // Catch: Throwable -> L7
    L35:
        if ((r22 instanceof AfterFilter) == false) goto L37;
        r17.getAfterFilters().add((AfterFilter) r22);     // Catch: Throwable -> L7
    L38:
        r17.write(r10);     // Catch: Throwable -> L7
        String r23 = r16.toString();     // Catch: Throwable -> L7
        r16.close();
        return r23;
    L11:
        if (r13.length() == 0) goto L13;
        r17.setDateFormat(r13);     // Catch: Throwable -> L7
        r17.config(SerializerFeature.WriteDateUseDateFormat, true);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r16.close();
        throw th;
    }

    public static final <T> T parseObject(String r10, Type r11, ParserConfig r12, int r13, Feature... r14) {
        return (T) parseObject(r10, r11, r12, null, r13, r14);
    }

    public static final List<Object> parseArray(String r10, Type[] r11) {
        List<Object> r12 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r13 = new DefaultJSONParser(r10, ParserConfig.global);
        Object[] r14 = r13.parseArray(r11);
        if (r14 == null) goto L9;
        r12 = Arrays.asList(r14);
    L9:
        r13.handleResovleTask(r12);
        r13.close();
        return r12;
    }

    public static final <T> T parseObject(String r10, Type r11, ParserConfig r12, ParseProcess r13, int r14, Feature... r15) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r16 = r15.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        r14 = r14 | r15[r17].mask;
        r17 = r17 + 1;
        goto L6
    L8:
        DefaultJSONParser r18 = new DefaultJSONParser(r10, r12, r14);
        if ((r13 instanceof ExtraTypeProvider) == false) goto L12;
        r18.getExtraTypeProviders().add((ExtraTypeProvider) r13);
    L12:
        if ((r13 instanceof ExtraProcessor) == false) goto L15;
        r18.getExtraProcessors().add((ExtraProcessor) r13);
    L15:
        if ((r13 instanceof FieldTypeResolver) == false) goto L17;
        r18.fieldTypeResolver = (FieldTypeResolver) r13;
    L17:
        T r19 = (T) r18.parseObject(r11);
        r18.handleResovleTask(r19);
        r18.close();
        return r19;
    }

    public static final <T> T parseObject(byte[] r10, Type r11, Feature... r12) {
        return (T) parseObject(new String(r10, "UTF-8"), r11, r12);
    L5:
        throw new JSONException("UTF-8 not support");
    }

    public static final <T> T parseObject(char[] r10, int r11, Type r12, Feature... r13) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length == 0) goto L14;
        int r14 = DEFAULT_PARSER_FEATURE;
        int r15 = r13.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L9;
        r14 = r14 | r13[r16].mask;
        r16 = r16 + 1;
        goto L7
    L9:
        DefaultJSONParser r17 = new DefaultJSONParser(r10, r11, ParserConfig.global, r14);
        T r18 = (T) r17.parseObject(r12);
        r17.handleResovleTask(r18);
        r17.close();
        return r18;
    L14:
        return null;
    }

    public static final <T> T parseObject(String r10, Class<T> r11) {
        return (T) parseObject(r10, r11, new Feature[0]);
    }
}
