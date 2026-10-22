package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = 0;
    public static String DEFAULT_TYPE_KEY = null;
    public static String DEFFAULT_DATE_FORMAT = null;
    public static final String VERSION = "1.2.83";
    private static final ThreadLocal<byte[]> bytesLocal = null;
    private static final ThreadLocal<char[]> charsLocal = null;
    public static Locale defaultLocale;
    public static TimeZone defaultTimeZone;
    static final SerializeFilter[] emptyFilters = null;
    private static final ConcurrentHashMap<Type, Type> mixInsMapper = null;

    public JSON() {
    }

    public static void clearMixInAnnotations() {
        mixInsMapper.clear();
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        SerializeWriter r100 = new SerializeWriter();
        new JSONSerializer(r100).write(this);     // Catch: Throwable -> L6
        String r101 = r100.toString();     // Catch: Throwable -> L6
        r100.close();
        return r101;
    L6:
        th = move-exception;
        r100.close();
        throw th;
    }

    static {
        defaultTimeZone = TimeZone.getDefault();
        defaultLocale = Locale.getDefault();
        DEFAULT_TYPE_KEY = "@type";
        emptyFilters = new SerializeFilter[0];
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        mixInsMapper = new ConcurrentHashMap(16);
        DEFAULT_PARSER_FEATURE = (((((((Feature.AutoCloseSource.getMask() | 0) | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask();
        DEFAULT_GENERATE_FEATURE = (((0 | SerializerFeature.QuoteFieldNames.getMask()) | SerializerFeature.SkipTransientField.getMask()) | SerializerFeature.WriteEnumUsingName.getMask()) | SerializerFeature.SortField.getMask();
        config(IOUtils.DEFAULT_PROPERTIES);
        bytesLocal = new ThreadLocal();
        charsLocal = new ThreadLocal();
    }

    public String toString() {
        return toJSONString();
    }

    private static byte[] allocateBytes(int r100) {
        ThreadLocal<byte[]> r101 = bytesLocal;
        byte[] r102 = r101.get();
        if (r102 != null) goto L9;
        if (r100 > 65536) goto L13;
        byte[] r103 = new byte[65536];
        r101.set(r103);
        return r103;
    L13:
        return new byte[r100];
    L9:
        if (r102.length < r100) goto L11;
        return r102;
    L11:
        return new byte[r100];
    }

    private static char[] allocateChars(int r100) {
        ThreadLocal<char[]> r101 = charsLocal;
        char[] r102 = r101.get();
        if (r102 != null) goto L9;
        if (r100 > 65536) goto L13;
        char[] r103 = new char[65536];
        r101.set(r103);
        return r103;
    L13:
        return new char[r100];
    L9:
        if (r102.length < r100) goto L11;
        return r102;
    L11:
        return new char[r100];
    }

    private static void config(Properties r100) {
        String r101 = r100.getProperty("fastjson.serializerFeatures.MapSortField");
        int r102 = SerializerFeature.MapSortField.getMask();
        if ("true".equals(r101) == false) goto L6;
        DEFAULT_GENERATE_FEATURE |= r102;
    L9:
        if ("true".equals(r100.getProperty("parser.features.NonStringKeyAsString")) == false) goto L12;
        DEFAULT_PARSER_FEATURE |= Feature.NonStringKeyAsString.getMask();
    L12:
        if ("true".equals(r100.getProperty("parser.features.ErrorOnEnumNotMatch")) == false) goto L14;
    L15:
        DEFAULT_PARSER_FEATURE |= Feature.ErrorOnEnumNotMatch.getMask();
    L17:
        if ("false".equals(r100.getProperty("fastjson.asmEnable")) == false) goto L20;
        ParserConfig.global.setAsmEnable(false);
        SerializeConfig.globalInstance.setAsmEnable(false);
        return;
    L20:
        return;
    L14:
        if ("true".equals(r100.getProperty("fastjson.parser.features.ErrorOnEnumNotMatch")) == false) goto L17;
    L6:
        if ("false".equals(r101) == false) goto L9;
        DEFAULT_GENERATE_FEATURE &= ~r102;
        goto L9
    }

    public static Type getMixInAnnotations(Type r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return mixInsMapper.get(r100);
    }

    public static boolean isValid(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L34:
        return false;
    L5:
        if (r100.length() == 0) goto L34;
        JSONScanner r102 = new JSONScanner(r100);
        r102.nextToken();     // Catch: Throwable -> L30 Exception -> L33
        int r103 = r102.token();     // Catch: Throwable -> L30 Exception -> L33
        if (r103 == 12) goto L20;
        if (r103 == 14) goto L17;
        switch(r103) {
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            default: goto L14;
        };
    L14:
        r102.close();
        return false;
    L16:
        r102.nextToken();     // Catch: Throwable -> L30 Exception -> L33
    L24:
    L26:
        if (r102.token() != 20) goto L28;
        r101 = true;
    L28:
        r102.close();
        return r101;
    L17:
        r102.skipArray(true);     // Catch: Throwable -> L30 Exception -> L33
        goto L24
    L20:
        if (r102.getCurrent() != 26) goto L23;
        r102.close();
        return false;
    L23:
        r102.skipObject(true);     // Catch: Throwable -> L30 Exception -> L33
    L33:
        r102.close();
    L30:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static boolean isValidArray(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L22:
        return false;
    L5:
        if (r100.length() == 0) goto L22;
        JSONScanner r102 = new JSONScanner(r100);
        r102.nextToken();     // Catch: Throwable -> L18 Exception -> L21
        if (r102.token() != 14) goto L16;
        r102.skipArray(true);     // Catch: Throwable -> L18 Exception -> L21
    L12:
        if (r102.token() != 20) goto L14;
        r101 = true;
    L14:
        r102.close();
        return r101;
    L16:
        r102.close();
        return false;
    L21:
        r102.close();
    L18:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static boolean isValidObject(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L28:
        return false;
    L5:
        if (r100.length() == 0) goto L28;
        JSONScanner r102 = new JSONScanner(r100);
        r102.nextToken();     // Catch: Throwable -> L24 Exception -> L27
        if (r102.token() == 12) goto L12;
        r102.close();
        return false;
    L12:
        if (r102.getCurrent() != 26) goto L16;
        r102.close();
        return false;
    L16:
        r102.skipObject(true);     // Catch: Throwable -> L24 Exception -> L27
    L18:
        if (r102.token() != 20) goto L20;
        r101 = true;
    L20:
        r102.close();
        return r101;
    L27:
        r102.close();
    L24:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static Object parse(String r100) {
        return parse(r100, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String r100) {
        return parseArray(r100, ParserConfig.global);
    }

    public static JSONObject parseObject(String r100) {
        Object r101 = parse(r100);
        if ((r101 instanceof JSONObject) == true) goto L5;
        return (JSONObject) toJSON(r101);
    L8:
        e = move-exception;
        throw new JSONException("can not cast to JSONObject.", e);
    L5:
        return (JSONObject) r101;
    }

    public static void removeMixInAnnotations(Type r100) {
        if (r100 == null) goto L5;
        mixInsMapper.remove(r100);
        return;
    }

    public static void setDefaultTypeKey(String r100) {
        DEFAULT_TYPE_KEY = r100;
        ParserConfig.global.symbolTable.addSymbol(r100, 0, r100.length(), r100.hashCode(), true);
    }

    public static Object toJSON(Object r100) {
        return toJSON(r100, SerializeConfig.globalInstance);
    }

    public static String toJSONString(Object r100) {
        return toJSONString(r100, emptyFilters, new SerializerFeature[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(Class<T> r100) {
        if (r100 != JSONArray.class) goto L5;
    L13:
        return this;
    L5:
        if (r100 == JSON.class) goto L13;
        if (r100 == Collection.class) goto L13;
        if (r100 == List.class) goto L13;
        return (T) TypeUtils.cast(this, r100, ParserConfig.getGlobalInstance());
    }

    public String toString(SerializerFeature... r100) {
        SerializeWriter r101 = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, r100);
        new JSONSerializer(r101).write(this);     // Catch: Throwable -> L6
        String r102 = r101.toString();     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();
        throw th;
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable r100) {
        SerializeWriter r101 = new SerializeWriter();
        new JSONSerializer(r101).write(this);     // Catch: Throwable -> L6 IOException -> L8
        r100.append(r101.toString());     // Catch: Throwable -> L6 IOException -> L8
        r101.close();
        return;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r101.close();
        throw th;
    }

    public <T> T toJavaObject(TypeReference r100) {
        if (r100 == null) goto L4;
        Type r101 = r100.getType();
    L6:
        return (T) TypeUtils.cast(this, r101, ParserConfig.getGlobalInstance());
    L4:
        r101 = null;
        goto L6
    }

    public <T> T toJavaObject(Type r100) {
        return (T) TypeUtils.cast(this, r100, ParserConfig.getGlobalInstance());
    }

    public static void addMixInAnnotations(Type r100, Type r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        mixInsMapper.put(r100, r101);
        return;
    L7:
        return;
    }

    public static <T> void handleResovleTask(DefaultJSONParser r100, T r101) {
        r100.handleResovleTask(r101);
    }

    public static Object parse(byte[] r100, Feature... r101) {
        char[] r102 = allocateChars(r100.length);
        int r103 = IOUtils.decodeUTF8(r100, 0, r100.length, r102);
        if (r103 >= 0) goto L7;
        return null;
    L7:
        return parse(new String(r102, 0, r103), r101);
    }

    public static JSONArray parseArray(String r100, ParserConfig r101) {
        JSONArray r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r103 = new DefaultJSONParser(r100, r101);
        JSONLexer r104 = r103.lexer;
        if (r104.token() != 8) goto L9;
        r104.nextToken();
    L14:
        r103.close();
        return r102;
    L9:
        if (r104.token() == 20) goto L11;
    L13:
        r102 = new JSONArray();
        r103.parseArray(r102);
        r103.handleResovleTask(r102);
        goto L14
    L11:
        if (r104.isBlankInput() == false) goto L13;
        goto L13
    }

    public static <T> T parseObject(String r100, Class<T> r101) {
        return (T) parseObject(r100, r101, new Feature[0]);
    }

    public static Object toJSON(Object r100, SerializeConfig r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof JSON) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof Map) == false) goto L23;
        Map r102 = (Map) r100;
        int r103 = r102.size();
        if ((r102 instanceof LinkedHashMap) == false) goto L14;
        Map r104 = new LinkedHashMap(r103);
    L17:
        JSONObject r105 = new JSONObject(r104);
        Iterator r106 = r102.entrySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.put2(TypeUtils.castToString(r107.getKey()), toJSON(r107.getValue(), r101));
        goto L19
    L21:
        return r105;
    L14:
        if ((r102 instanceof TreeMap) == false) goto L16;
        r104 = new TreeMap();
        goto L17
    L16:
        r104 = new HashMap(r103);
        goto L17
    L23:
        if ((r100 instanceof Collection) == false) goto L30;
        Collection r108 = (Collection) r100;
        JSONArray r109 = new JSONArray(r108.size());
        Iterator r110 = r108.iterator();
    L26:
        if (r110.hasNext() == false) goto L28;
        r109.add(toJSON(r110.next(), r101));
        goto L26
    L28:
        return r109;
    L30:
        if ((r100 instanceof JSONSerializable) == true) goto L32;
        Class<?> r111 = r100.getClass();
        if (r111.isEnum() == true) goto L36;
        boolean r112 = false;
        int r113 = 0;
        int r114 = 0;
        if (r111.isArray() == false) goto L44;
        int r115 = Array.getLength(r100);
        JSONArray r116 = new JSONArray(r115);
    L40:
        if (r113 >= r115) goto L42;
        r116.add(toJSON(Array.get(r100, r113)));
        r113 = r113 + 1;
        goto L40
    L42:
        return r116;
    L44:
        if (ParserConfig.isPrimitive2(r111) == false) goto L46;
        return r100;
    L46:
        ObjectSerializer r117 = r101.getObjectWriter(r111);
        if ((r117 instanceof JavaBeanSerializer) == false) goto L70;
        JavaBeanSerializer r118 = (JavaBeanSerializer) r117;
        JSONType r119 = r118.getJSONType();
        if (r119 == null) goto L59;
        SerializerFeature[] r120 = r119.serialzeFeatures();
        int r121 = r120.length;
        boolean r122 = false;
    L51:
        if (r114 >= r121) goto L58;
        SerializerFeature r123 = r120[r114];
        if (r123 != SerializerFeature.SortField) goto L55;
    L56:
        r122 = true;
    L57:
        r114 = r114 + 1;
        goto L51
    L55:
        if (r123 != SerializerFeature.MapSortField) goto L57;
    L58:
        r112 = r122;
    L59:
        JSONObject r124 = new JSONObject(r112);
        Iterator<Map.Entry<String, Object>> r125 = r118.getFieldValuesMap(r100).entrySet().iterator();     // Catch: Exception -> L66
    L62:
        if (r125.hasNext() == false) goto L65;
        Map.Entry<String, Object> r126 = r125.next();     // Catch: Exception -> L66
        r124.put2(r126.getKey(), toJSON(r126.getValue(), r101));     // Catch: Exception -> L66
        goto L62
    L65:
        return r124;
    L66:
        e = move-exception;
        throw new JSONException("toJSON error", e);
    L70:
        return parse(toJSONString(r100, r101, new SerializerFeature[0]));
    L36:
        return ((Enum) r100).name();
    L32:
        return parse(toJSONString(r100));
    }

    public static byte[] toJSONBytes(Object r100, SerializerFeature... r101) {
        return toJSONBytes(r100, DEFAULT_GENERATE_FEATURE, r101);
    }

    public static String toJSONString(Object r100, boolean r101) {
        if (r101 == true) goto L6;
        return toJSONString(r100);
    L6:
        return toJSONString(r100, new SerializerFeature[]{SerializerFeature.PrettyFormat});
    }

    public static <T> T toJavaObject(JSON r100, Class<T> r101) {
        return (T) TypeUtils.cast(r100, r101, ParserConfig.getGlobalInstance());
    }

    public static Object parse(String r100, Feature... r101) {
        int r102 = DEFAULT_PARSER_FEATURE;
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102 = Feature.config(r102, r101[r104], true);
        r104 = r104 + 1;
        goto L3
    L6:
        return parse(r100, r102);
    }

    public static <T> List<T> parseArray(String r100, Class<T> r101) {
        return parseArray(r100, r101, ParserConfig.global);
    }

    public static JSONObject parseObject(String r100, Feature... r101) {
        return (JSONObject) parse(r100, r101);
    }

    public static Object toJSON(Object r100, ParserConfig r101) {
        return toJSON(r100, SerializeConfig.globalInstance);
    }

    public static String toJSONString(Object r100, SerializerFeature... r101) {
        return toJSONString(r100, DEFAULT_GENERATE_FEATURE, r101);
    }

    public static Object parse(String r100, int r101) {
        return parse(r100, ParserConfig.getGlobalInstance(), r101);
    }

    public static List<Object> parseArray(String r100, Type[] r101) {
        return parseArray(r100, r101, ParserConfig.global);
    }

    public static Object parse(String r100, ParserConfig r101) {
        return parse(r100, r101, DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String r100, ParserConfig r101, Feature... r102) {
        int r103 = DEFAULT_PARSER_FEATURE;
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        r103 = Feature.config(r103, r102[r105], true);
        r105 = r105 + 1;
        goto L3
    L6:
        return parse(r100, r101, r103);
    }

    public static <T> List<T> parseArray(String r100, Class<T> r101, ParserConfig r102) {
        ArrayList r103 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r104 = new DefaultJSONParser(r100, r102);
        JSONLexer r105 = r104.lexer;
        int r106 = r105.token();
        if (r106 != 8) goto L9;
        r105.nextToken();
    L14:
        r104.close();
        return r103;
    L9:
        if (r106 == 20) goto L11;
    L13:
        r103 = new ArrayList();
        r104.parseArray(r101, r103);
        r104.handleResovleTask(r103);
        goto L14
    L11:
        if (r105.isBlankInput() == false) goto L13;
        goto L13
    }

    public static <T> T parseObject(String r100, Class<T> r101, Feature... r102) {
        return (T) parseObject(r100, r101, ParserConfig.global, null, DEFAULT_PARSER_FEATURE, r102);
    }

    public static byte[] toJSONBytes(Object r100, SerializeFilter r101, SerializerFeature... r102) {
        return toJSONBytes(r100, SerializeConfig.globalInstance, new SerializeFilter[]{r101}, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static String toJSONString(Object r100, int r101, SerializerFeature... r102) {
        SerializeWriter r103 = new SerializeWriter(null, r101, r102);
        new JSONSerializer(r103).write(r100);     // Catch: Throwable -> L16
        String r104 = r103.toString();     // Catch: Throwable -> L16
        int r105 = r104.length();     // Catch: Throwable -> L16
        if (r105 <= 0) goto L14;
        int r106 = r105 - 1;     // Catch: Throwable -> L16
        if (r104.charAt(r106) != '.') goto L14;
        if ((r100 instanceof Number) == false) goto L14;
        if (r103.isEnabled(SerializerFeature.WriteClassName) == true) goto L14;
        String r107 = r104.substring(0, r106);     // Catch: Throwable -> L16
        r103.close();
        return r107;
    L14:
        r103.close();
        return r104;
    L16:
        th = move-exception;
        r103.close();
        throw th;
    }

    public static String toJSONStringWithDateFormat(Object r100, String r101, SerializerFeature... r102) {
        return toJSONString(r100, SerializeConfig.globalInstance, null, r101, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static String toJSONStringZ(Object r100, SerializeConfig r101, SerializerFeature... r102) {
        return toJSONString(r100, r101, emptyFilters, null, 0, r102);
    }

    public static final int writeJSONString(OutputStream r100, Object r101, SerializerFeature... r102) throws IOException {
        return writeJSONString(r100, r101, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static void writeJSONStringTo(Object r100, Writer r101, SerializerFeature... r102) {
        writeJSONString(r101, r100, r102);
    }

    public static Object parse(String r100, ParserConfig r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r103 = new DefaultJSONParser(r100, r101, r102);
        Object r104 = r103.parse();
        r103.handleResovleTask(r104);
        r103.close();
        return r104;
    }

    public static List<Object> parseArray(String r100, Type[] r101, ParserConfig r102) {
        List<Object> r103 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        DefaultJSONParser r104 = new DefaultJSONParser(r100, r102);
        Object[] r105 = r104.parseArray(r101);
        if (r105 == null) goto L9;
        r103 = Arrays.asList(r105);
    L9:
        r104.handleResovleTask(r103);
        r104.close();
        return r103;
    }

    public static <T> T parseObject(byte[] r100, Type r101, Feature... r102) {
        return (T) parseObject(r100, 0, r100.length, IOUtils.UTF8, r101, r102);
    }

    public static byte[] toJSONBytes(Object r100, SerializeConfig r101, SerializerFeature... r102) {
        return toJSONBytes(r100, r101, emptyFilters, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static String toJSONString(Object r100, SerializeFilter r101, SerializerFeature... r102) {
        return toJSONString(r100, SerializeConfig.globalInstance, new SerializeFilter[]{r101}, null, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static void writeJSONString(Writer r100, Object r101, SerializerFeature... r102) {
        writeJSONString(r100, r101, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static <T> T parseObject(String r100, TypeReference<T> r101, Feature... r102) {
        return (T) parseObject(r100, r101.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, r102);
    }

    public static byte[] toJSONBytes(Object r100, SerializeFilter[] r101, SerializerFeature... r102) {
        return toJSONBytes(r100, SerializeConfig.globalInstance, r101, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static String toJSONString(Object r100, SerializeFilter[] r101, SerializerFeature... r102) {
        return toJSONString(r100, SerializeConfig.globalInstance, r101, null, DEFAULT_GENERATE_FEATURE, r102);
    }

    public static <T> T parseObject(String r100, Type r101, Feature... r102) {
        return (T) parseObject(r100, r101, ParserConfig.global, DEFAULT_PARSER_FEATURE, r102);
    }

    public static byte[] toJSONBytes(Object r100, int r101, SerializerFeature... r102) {
        return toJSONBytes(r100, SerializeConfig.globalInstance, r101, r102);
    }

    public static String toJSONString(Object r100, SerializeConfig r101, SerializerFeature... r102) {
        return toJSONString(r100, r101, null, r102);
    }

    public static <T> T parseObject(InputStream r100, Type r101, Feature... r102) throws IOException {
        return (T) parseObject(r100, IOUtils.UTF8, r101, r102);
    }

    public static <T> T parseObject(char[] r100, int r101, Type r102, Feature... r103) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L14;
        int r104 = DEFAULT_PARSER_FEATURE;
        int r105 = r103.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104 = Feature.config(r104, r103[r106], true);
        r106 = r106 + 1;
        goto L7
    L9:
        DefaultJSONParser r107 = new DefaultJSONParser(r100, r101, ParserConfig.getGlobalInstance(), r104);
        T r108 = (T) r107.parseObject(r102);
        r107.handleResovleTask(r108);
        r107.close();
        return r108;
    L14:
        return null;
    }

    public static byte[] toJSONBytes(Object r100, SerializeConfig r101, SerializeFilter r102, SerializerFeature... r103) {
        return toJSONBytes(r100, r101, new SerializeFilter[]{r102}, DEFAULT_GENERATE_FEATURE, r103);
    }

    public static String toJSONString(Object r100, SerializeConfig r101, SerializeFilter r102, SerializerFeature... r110) {
        return toJSONString(r100, r101, new SerializeFilter[]{r102}, null, DEFAULT_GENERATE_FEATURE, r110);
    }

    public static void writeJSONString(Writer r100, Object r101, int r102, SerializerFeature... r103) {
        SerializeWriter r104 = new SerializeWriter(r100, r102, r103);
        new JSONSerializer(r104).write(r101);     // Catch: Throwable -> L6
        r104.close();
        return;
    L6:
        th = move-exception;
        r104.close();
        throw th;
    }

    public static <T> T parseObject(String r100, Type r101, int r102, Feature... r103) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r102 = Feature.config(r102, r103[r105], true);
        r105 = r105 + 1;
        goto L6
    L8:
        DefaultJSONParser r106 = new DefaultJSONParser(r100, ParserConfig.getGlobalInstance(), r102);
        T r107 = (T) r106.parseObject(r101);
        r106.handleResovleTask(r107);
        r106.close();
        return r107;
    }

    public static byte[] toJSONBytes(Object r100, SerializeConfig r101, int r102, SerializerFeature... r103) {
        return toJSONBytes(r100, r101, emptyFilters, r102, r103);
    }

    public static String toJSONString(Object r100, SerializeConfig r101, SerializeFilter[] r102, SerializerFeature... r103) {
        return toJSONString(r100, r101, r102, null, DEFAULT_GENERATE_FEATURE, r103);
    }

    public static final int writeJSONString(OutputStream r100, Object r101, int r110, SerializerFeature... r111) throws IOException {
        return writeJSONString(r100, IOUtils.UTF8, r101, SerializeConfig.globalInstance, null, null, r110, r111);
    }

    public static <T> T parseObject(String r100, Class<T> r101, ParseProcess r102, Feature... r103) {
        return (T) parseObject(r100, r101, ParserConfig.global, r102, DEFAULT_PARSER_FEATURE, r103);
    }

    public static final int writeJSONString(OutputStream r100, Charset r101, Object r110, SerializerFeature... r111) throws IOException {
        return writeJSONString(r100, r101, r110, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, r111);
    }

    public static <T> T parseObject(String r100, Type r101, ParseProcess r102, Feature... r103) {
        return (T) parseObject(r100, r101, ParserConfig.global, r102, DEFAULT_PARSER_FEATURE, r103);
    }

    public static <T> T parseObject(String r100, Type r101, ParserConfig r102, Feature... r103) {
        return (T) parseObject(r100, r101, r102, null, DEFAULT_PARSER_FEATURE, r103);
    }

    public static <T> T parseObject(InputStream r100, Charset r101, Type r102, Feature... r103) throws IOException {
        return (T) parseObject(r100, r101, r102, ParserConfig.global, r103);
    }

    public static Object parse(byte[] r100, int r101, int r102, CharsetDecoder r103, int r104) {
        r103.reset();
        char[] r105 = allocateChars((int) (((double) r102) * ((double) r103.maxCharsPerByte())));
        ByteBuffer r106 = ByteBuffer.wrap(r100, r101, r102);
        CharBuffer r107 = CharBuffer.wrap(r105);
        IOUtils.decode(r103, r106, r107);
        DefaultJSONParser r108 = new DefaultJSONParser(r105, r107.position(), ParserConfig.getGlobalInstance(), r104);
        Object r109 = r108.parse();
        r108.handleResovleTask(r109);
        r108.close();
        return r109;
    }

    public static <T> T parseObject(InputStream r100, Charset r101, Type r102, ParserConfig r110, Feature... r111) throws IOException {
        return (T) parseObject(r100, r101, r102, r110, null, DEFAULT_PARSER_FEATURE, r111);
    }

    public static byte[] toJSONBytes(Object r100, SerializeConfig r101, SerializeFilter[] r102, int r103, SerializerFeature... r110) {
        return toJSONBytes(r100, r101, r102, null, r103, r110);
    }

    public static Object parse(byte[] r100, int r101, int r102, CharsetDecoder r103, Feature... r104) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L14;
        int r105 = DEFAULT_PARSER_FEATURE;
        int r106 = r104.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L10;
        r105 = Feature.config(r105, r104[r107], true);
        r107 = r107 + 1;
        goto L7
    L10:
        return parse(r100, r101, r102, r103, r105);
    L14:
        return null;
    }

    public static <T> T parseObject(String r100, Type r101, ParserConfig r102, int r103, Feature... r110) {
        return (T) parseObject(r100, r101, r102, null, r103, r110);
    }

    public static <T> T parseObject(String r100, Type r101, ParserConfig r102, ParseProcess r103, int r104, Feature... r105) {
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if (r100.length() == 0) goto L24;
        if (r105 == null) goto L11;
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        r104 = r104 | r105[r107].mask;
        r107 = r107 + 1;
    L11:
        DefaultJSONParser r108 = new DefaultJSONParser(r100, r102, r104);
        if (r103 != null) goto L14;
    L22:
        T r109 = (T) r108.parseObject(r101, null);
        r108.handleResovleTask(r109);
        r108.close();
        return r109;
    L14:
        if ((r103 instanceof ExtraTypeProvider) == false) goto L17;
        r108.getExtraTypeProviders().add((ExtraTypeProvider) r103);
    L17:
        if ((r103 instanceof ExtraProcessor) == false) goto L20;
        r108.getExtraProcessors().add((ExtraProcessor) r103);
    L20:
        if ((r103 instanceof FieldTypeResolver) == false) goto L22;
        r108.setFieldTypeResolver((FieldTypeResolver) r103);
        goto L22
    }

    public static byte[] toJSONBytes(Object r100, SerializeConfig r101, SerializeFilter[] r102, String r110, int r111, SerializerFeature... r112) {
        return toJSONBytes(IOUtils.UTF8, r100, r101, r102, r110, r111, r112);
    }

    public static String toJSONString(Object r100, SerializeConfig r101, SerializeFilter[] r102, String r103, int r104, SerializerFeature... r105) {
        SerializeWriter r106 = new SerializeWriter(null, r104, r105);
        JSONSerializer r107 = new JSONSerializer(r106, r101);     // Catch: Throwable -> L15
        if (r103 != null) goto L6;
    L8:
        if (r102 == null) goto L12;
        int r108 = r102.length;     // Catch: Throwable -> L15
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L12;
        r107.addFilter(r102[r109]);     // Catch: Throwable -> L15
        r109 = r109 + 1;     // Catch: Throwable -> L15
    L12:
        r107.write(r100);     // Catch: Throwable -> L15
        String r110 = r106.toString();     // Catch: Throwable -> L15
        r106.close();
        return r110;
    L6:
        if (r103.length() == 0) goto L8;
        r107.setDateFormat(r103);     // Catch: Throwable -> L15
        r107.config(SerializerFeature.WriteDateUseDateFormat, true);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r106.close();
        throw th;
    }

    public static <T> T parseObject(byte[] r100, int r101, int r102, CharsetDecoder r103, Type r104, Feature... r105) {
        r103.reset();
        char[] r106 = allocateChars((int) (((double) r102) * ((double) r103.maxCharsPerByte())));
        ByteBuffer r107 = ByteBuffer.wrap(r100, r101, r102);
        CharBuffer r108 = CharBuffer.wrap(r106);
        IOUtils.decode(r103, r107, r108);
        return (T) parseObject(r106, r108.position(), r104, r105);
    }

    public static <T> T parseObject(byte[] r100, int r110, int r111, Charset r112, Type r113, Feature... r114) {
        return (T) parseObject(r100, r110, r111, r112, r113, ParserConfig.global, null, DEFAULT_PARSER_FEATURE, r114);
    }

    public static <T> T parseObject(InputStream r100, Charset r110, Type r111, ParserConfig r112, ParseProcess r113, int r114, Feature... r115) throws IOException {
        if (r110 != null) goto L4;
        r110 = IOUtils.UTF8;
    L4:
        Charset r101 = r110;
        byte[] r116 = allocateBytes(65536);
        int r102 = 0;
    L5:
        int r103 = r100.read(r116, r102, r116.length - r102);
        if (r103 == (-1)) goto L8;
        r102 = r102 + r103;
        if (r102 != r116.length) goto L5;
        byte[] r104 = new byte[(r116.length * 3) / 2];
        System.arraycopy(r116, 0, r104, 0, r116.length);
        r116 = r104;
        goto L5
    L8:
        return (T) parseObject(r116, 0, r102, r101, r111, r112, r113, r114, r115);
    }

    public static byte[] toJSONBytes(Charset r100, Object r101, SerializeConfig r102, SerializeFilter[] r103, String r104, int r105, SerializerFeature... r106) {
        SerializeWriter r107 = new SerializeWriter(null, r105, r106);
        JSONSerializer r108 = new JSONSerializer(r107, r102);     // Catch: Throwable -> L15
        if (r104 != null) goto L6;
    L8:
        if (r103 == null) goto L12;
        int r109 = r103.length;     // Catch: Throwable -> L15
        int r110 = 0;
    L10:
        if (r110 >= r109) goto L12;
        r108.addFilter(r103[r110]);     // Catch: Throwable -> L15
        r110 = r110 + 1;     // Catch: Throwable -> L15
    L12:
        r108.write(r101);     // Catch: Throwable -> L15
        byte[] r111 = r107.toBytes(r100);     // Catch: Throwable -> L15
        r107.close();
        return r111;
    L6:
        if (r104.length() == 0) goto L8;
        r108.setDateFormat(r104);     // Catch: Throwable -> L15
        r108.config(SerializerFeature.WriteDateUseDateFormat, true);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r107.close();
        throw th;
    }

    public static byte[] toJSONBytesWithFastJsonConfig(Charset r100, Object r101, SerializeConfig r102, SerializeFilter[] r103, String r104, int r105, SerializerFeature... r106) {
        SerializeWriter r107 = new SerializeWriter(null, r105, r106);
        JSONSerializer r108 = new JSONSerializer(r107, r102);     // Catch: Throwable -> L15
        if (r104 != null) goto L6;
    L8:
        if (r103 == null) goto L12;
        int r109 = r103.length;     // Catch: Throwable -> L15
        int r110 = 0;
    L10:
        if (r110 >= r109) goto L12;
        r108.addFilter(r103[r110]);     // Catch: Throwable -> L15
        r110 = r110 + 1;     // Catch: Throwable -> L15
    L12:
        r108.write(r101);     // Catch: Throwable -> L15
        byte[] r111 = r107.toBytes(r100);     // Catch: Throwable -> L15
        r107.close();
        return r111;
    L6:
        if (r104.length() == 0) goto L8;
        r108.setFastJsonConfigDateFormatPattern(r104);     // Catch: Throwable -> L15
        r108.config(SerializerFeature.WriteDateUseDateFormat, true);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r107.close();
        throw th;
    }

    public static <T> T parseObject(byte[] r100, Charset r110, Type r111, ParserConfig r112, ParseProcess r113, int r114, Feature... r115) {
        return (T) parseObject(r100, 0, r100.length, r110, r111, r112, r113, r114, r115);
    }

    public static final int writeJSONString(OutputStream r100, Charset r101, Object r102, SerializeConfig r103, SerializeFilter[] r104, String r105, int r106, SerializerFeature... r107) throws IOException {
        SerializeWriter r108 = new SerializeWriter(null, r106, r107);
        JSONSerializer r109 = new JSONSerializer(r108, r103);     // Catch: Throwable -> L15
        if (r105 != null) goto L6;
    L8:
        if (r104 == null) goto L12;
        int r110 = r104.length;     // Catch: Throwable -> L15
        int r111 = 0;
    L10:
        if (r111 >= r110) goto L12;
        r109.addFilter(r104[r111]);     // Catch: Throwable -> L15
        r111 = r111 + 1;     // Catch: Throwable -> L15
    L12:
        r109.write(r102);     // Catch: Throwable -> L15
        int r112 = r108.writeToEx(r100, r101);     // Catch: Throwable -> L15
        r108.close();
        return r112;
    L6:
        if (r105.length() == 0) goto L8;
        r109.setDateFormat(r105);     // Catch: Throwable -> L15
        r109.config(SerializerFeature.WriteDateUseDateFormat, true);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r108.close();
        throw th;
    }

    public static final int writeJSONStringWithFastJsonConfig(OutputStream r100, Charset r101, Object r102, SerializeConfig r103, SerializeFilter[] r104, String r105, int r106, SerializerFeature... r107) throws IOException {
        SerializeWriter r108 = new SerializeWriter(null, r106, r107);
        JSONSerializer r109 = new JSONSerializer(r108, r103);     // Catch: Throwable -> L15
        if (r105 != null) goto L6;
    L8:
        if (r104 == null) goto L12;
        int r110 = r104.length;     // Catch: Throwable -> L15
        int r111 = 0;
    L10:
        if (r111 >= r110) goto L12;
        r109.addFilter(r104[r111]);     // Catch: Throwable -> L15
        r111 = r111 + 1;     // Catch: Throwable -> L15
    L12:
        r109.write(r102);     // Catch: Throwable -> L15
        int r112 = r108.writeToEx(r100, r101);     // Catch: Throwable -> L15
        r108.close();
        return r112;
    L6:
        if (r105.length() == 0) goto L8;
        r109.setFastJsonConfigDateFormatPattern(r105);     // Catch: Throwable -> L15
        r109.config(SerializerFeature.WriteDateUseDateFormat, true);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r108.close();
        throw th;
    }

    public static <T> T parseObject(byte[] r100, int r101, int r102, Charset r110, Type r111, ParserConfig r112, ParseProcess r113, int r114, Feature... r115) {
        if (r110 != null) goto L4;
        r110 = IOUtils.UTF8;
    L4:
        InputStreamReader r103 = null;
        if (r110 != IOUtils.UTF8) goto L26;
        char[] r116 = allocateChars(r100.length);
        int r104 = IOUtils.decodeUTF8(r100, r101, r102, r116);
        if (r104 < 0) goto L32;
        String r105 = null;
    L20:
        if (r105 != null) goto L23;
        if (r104 >= 0) goto L23;
        return null;
    L23:
        if (r105 != null) goto L25;
        r105 = new String(r116, 0, r104);
    L25:
        String r106 = r105;
    L30:
        return (T) parseObject(r106, r111, r112, r113, r114, r115);
    L32:
        InputStreamReader r107 = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(r100, r101, r102)), "UTF-8");     // Catch: Throwable -> L13 Exception -> L16
    L34:
        r105 = IOUtils.readAll(r107);     // Catch: Throwable -> L11 Exception -> L31
        IOUtils.close(r107);
        goto L20
    L11:
        th = th;
        r103 = r107;
    L14:
        IOUtils.close(r103);
        throw th;
    L17:
        IOUtils.close(r107);
        return null;
    L16:
        r107 = null;
    L13:
        th = th;
        goto L14
    L26:
        if (r102 >= 0) goto L28;
        return null;
    L28:
        r106 = new String(r100, r101, r102, r110);
        goto L30
    }
}
