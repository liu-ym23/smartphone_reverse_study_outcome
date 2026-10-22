package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ArrayCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.NumberCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class ParserConfig {
    public static ParserConfig global;
    public ClassLoader defaultClassLoader;
    private final IdentityHashMap<ObjectDeserializer> derializers;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;

    static {
        global = new ParserConfig();
    }

    public ParserConfig() {
        IdentityHashMap<ObjectDeserializer> r10 = new IdentityHashMap(1024);
        this.derializers = r10;
        this.symbolTable = new SymbolTable(16384);
        MiscCodec r11 = MiscCodec.instance;
        r10.put(SimpleDateFormat.class, r11);
        DateCodec r12 = DateCodec.instance;
        r10.put(Date.class, r12);
        r10.put(Calendar.class, r12);
        r10.put(Map.class, MapDeserializer.instance);
        r10.put(HashMap.class, MapDeserializer.instance);
        r10.put(LinkedHashMap.class, MapDeserializer.instance);
        r10.put(TreeMap.class, MapDeserializer.instance);
        r10.put(ConcurrentMap.class, MapDeserializer.instance);
        r10.put(ConcurrentHashMap.class, MapDeserializer.instance);
        CollectionCodec r13 = CollectionCodec.instance;
        r10.put(Collection.class, r13);
        r10.put(List.class, r13);
        r10.put(ArrayList.class, r13);
        JavaObjectDeserializer r14 = JavaObjectDeserializer.instance;
        r10.put(Object.class, r14);
        r10.put(String.class, StringCodec.instance);
        r10.put(Character.TYPE, r11);
        r10.put(Character.class, r11);
        Class r15 = Byte.TYPE;
        NumberCodec r16 = NumberCodec.instance;
        r10.put(r15, r16);
        r10.put(Byte.class, r16);
        r10.put(Short.TYPE, r16);
        r10.put(Short.class, r16);
        r10.put(Integer.TYPE, IntegerCodec.instance);
        r10.put(Integer.class, IntegerCodec.instance);
        r10.put(Long.TYPE, IntegerCodec.instance);
        r10.put(Long.class, IntegerCodec.instance);
        BigDecimalCodec r17 = BigDecimalCodec.instance;
        r10.put(BigInteger.class, r17);
        r10.put(BigDecimal.class, r17);
        r10.put(Float.TYPE, r16);
        r10.put(Float.class, r16);
        r10.put(Double.TYPE, r16);
        r10.put(Double.class, r16);
        Class r18 = Boolean.TYPE;
        BooleanCodec r19 = BooleanCodec.instance;
        r10.put(r18, r19);
        r10.put(Boolean.class, r19);
        r10.put(Class.class, r11);
        ArrayCodec r20 = ArrayCodec.instance;
        r10.put(char[].class, r20);
        r10.put(Object[].class, r20);
        r10.put(UUID.class, r11);
        r10.put(TimeZone.class, r11);
        r10.put(Locale.class, r11);
        r10.put(Currency.class, r11);
        r10.put(URI.class, r11);
        r10.put(URL.class, r11);
        r10.put(Pattern.class, r11);
        r10.put(Charset.class, r11);
        r10.put(Number.class, r16);
        r10.put(StackTraceElement.class, r11);
        r10.put(Serializable.class, r14);
        r10.put(Cloneable.class, r14);
        r10.put(Comparable.class, r14);
        r10.put(Closeable.class, r14);
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public static boolean isPrimitive(Class<?> r10) {
        if (r10.isPrimitive() == false) goto L5;
    L36:
        return true;
    L5:
        if (r10 == Boolean.class) goto L36;
        if (r10 == Character.class) goto L36;
        if (r10 == Byte.class) goto L36;
        if (r10 == Short.class) goto L36;
        if (r10 == Integer.class) goto L36;
        if (r10 == Long.class) goto L36;
        if (r10 == Float.class) goto L36;
        if (r10 == Double.class) goto L36;
        if (r10 == BigInteger.class) goto L36;
        if (r10 == BigDecimal.class) goto L36;
        if (r10 == String.class) goto L36;
        if (r10 == Date.class) goto L36;
        if (r10 == java.sql.Date.class) goto L36;
        if (r10 == Time.class) goto L36;
        if (r10 == Timestamp.class) goto L36;
        return false;
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig r10, Class<?> r11, FieldInfo r12) {
        Class<?> r13 = r12.fieldClass;
        if (r13 == List.class) goto L14;
        if (r13 == ArrayList.class) goto L14;
        if (r13.isArray() == false) goto L12;
        if (r13.getComponentType().isPrimitive() == false) goto L14;
    L12:
        return new DefaultFieldDeserializer(r10, r11, r12);
    L14:
        return new ListTypeFieldDeserializer(r10, r11, r12);
    }

    public ObjectDeserializer getDeserializer(Type r10) {
        ObjectDeserializer r11 = this.derializers.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        if ((r10 instanceof Class) == false) goto L10;
        return getDeserializer((Class) r10, r10);
    L10:
        if ((r10 instanceof ParameterizedType) == false) goto L18;
        Type r12 = ((ParameterizedType) r10).getRawType();
        if ((r12 instanceof Class) == false) goto L16;
        return getDeserializer((Class) r12, r10);
    L16:
        return getDeserializer(r12);
    L18:
        return JavaObjectDeserializer.instance;
    }

    public void putDeserializer(Type r10, ObjectDeserializer r11) {
        this.derializers.put(r10, r11);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> r10) {
        return registerIfNotExists(r10, r10.getModifiers(), false, true, true, true);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> r10, int r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        ObjectDeserializer r16 = this.derializers.get(r10);
        if (r16 == null) goto L5;
        return r16;
    L5:
        JavaBeanDeserializer r17 = new JavaBeanDeserializer(this, r10, r10, JavaBeanInfo.build(r10, r11, r10, r12, r13, r14, r15, this.propertyNamingStrategy));
        putDeserializer(r10, r17);
        return r17;
    }

    public ObjectDeserializer getDeserializer(Class<?> r10, Type r11) {
        ObjectDeserializer r12 = this.derializers.get(r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        if (r11 != null) goto L7;
        r11 = r10;
    L7:
        ObjectDeserializer r13 = this.derializers.get(r11);
        if (r13 == null) goto L11;
        return r13;
    L11:
        if (isPrimitive(r10) == true) goto L19;
        JSONType r14 = (JSONType) r10.getAnnotation(JSONType.class);
        if (r14 == null) goto L19;
        Class<?> r15 = r14.mappingTo();
        if (r15 == Void.class) goto L19;
        return getDeserializer(r15, r15);
    L19:
        if ((r11 instanceof WildcardType) == false) goto L21;
    L24:
        r13 = this.derializers.get(r10);
    L25:
        if (r13 == null) goto L27;
        return r13;
    L27:
        ObjectDeserializer r16 = this.derializers.get(r11);
        if (r16 == null) goto L31;
        return r16;
    L31:
        if (r10.isEnum() == false) goto L34;
        ObjectDeserializer r17 = new EnumDeserializer(r10);
    L58:
        putDeserializer(r11, r17);
        return r17;
    L34:
        if (r10.isArray() == false) goto L37;
        r17 = ArrayCodec.instance;
        goto L58
    L37:
        if (r10 != Set.class) goto L39;
    L57:
        r17 = CollectionCodec.instance;
        goto L58
    L39:
        if (r10 == HashSet.class) goto L57;
        if (r10 == Collection.class) goto L57;
        if (r10 == List.class) goto L57;
        if (r10 == ArrayList.class) goto L57;
        if (Collection.class.isAssignableFrom(r10) == false) goto L51;
        r17 = CollectionCodec.instance;
        goto L58
    L51:
        if (Map.class.isAssignableFrom(r10) == false) goto L54;
        r17 = MapDeserializer.instance;
        goto L58
    L54:
        if (Throwable.class.isAssignableFrom(r10) == false) goto L56;
        r17 = new ThrowableDeserializer(this, r10);
        goto L58
    L56:
        r17 = new JavaBeanDeserializer(this, r10, r11);
        goto L58
    L21:
        if ((r11 instanceof TypeVariable) == true) goto L24;
        if ((r11 instanceof ParameterizedType) == false) goto L25;
        goto L24
    }
}
