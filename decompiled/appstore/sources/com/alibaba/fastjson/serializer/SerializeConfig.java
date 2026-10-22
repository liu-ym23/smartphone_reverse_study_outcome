package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class SerializeConfig {
    public static final SerializeConfig globalInstance = null;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<ObjectSerializer> serializers;
    protected String typeKey;

    static {
        globalInstance = new SerializeConfig();
    }

    public SerializeConfig() {
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        IdentityHashMap<ObjectSerializer> r10 = new IdentityHashMap(1024);
        this.serializers = r10;
        r10.put(Boolean.class, BooleanCodec.instance);
        MiscCodec r11 = MiscCodec.instance;
        r10.put(Character.class, r11);
        r10.put(Byte.class, IntegerCodec.instance);
        r10.put(Short.class, IntegerCodec.instance);
        r10.put(Integer.class, IntegerCodec.instance);
        r10.put(Long.class, IntegerCodec.instance);
        NumberCodec r12 = NumberCodec.instance;
        r10.put(Float.class, r12);
        r10.put(Double.class, r12);
        r10.put(Number.class, r12);
        BigDecimalCodec r13 = BigDecimalCodec.instance;
        r10.put(BigDecimal.class, r13);
        r10.put(BigInteger.class, r13);
        r10.put(String.class, StringCodec.instance);
        r10.put(Object[].class, ArrayCodec.instance);
        r10.put(Class.class, r11);
        r10.put(SimpleDateFormat.class, r11);
        r10.put(Locale.class, r11);
        r10.put(Currency.class, r11);
        r10.put(TimeZone.class, r11);
        r10.put(UUID.class, r11);
        r10.put(URI.class, r11);
        r10.put(URL.class, r11);
        r10.put(Pattern.class, r11);
        r10.put(Charset.class, r11);
    }

    public static final SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public ObjectSerializer get(Class<?> r10) {
        boolean r11 = true;
        ObjectSerializer r12 = this.serializers.get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        if (Map.class.isAssignableFrom(r10) == false) goto L8;
        this.serializers.put(r10, new MapSerializer());
    L72:
        return this.serializers.get(r10);
    L8:
        if (List.class.isAssignableFrom(r10) == false) goto L11;
        this.serializers.put(r10, new ListSerializer());
        goto L72
    L11:
        if (Collection.class.isAssignableFrom(r10) == false) goto L14;
        this.serializers.put(r10, CollectionCodec.instance);
        goto L72
    L14:
        if (Date.class.isAssignableFrom(r10) == false) goto L17;
        this.serializers.put(r10, DateCodec.instance);
        goto L72
    L17:
        if (JSONAware.class.isAssignableFrom(r10) == false) goto L20;
        this.serializers.put(r10, MiscCodec.instance);
        goto L72
    L20:
        if (JSONSerializable.class.isAssignableFrom(r10) == false) goto L23;
        this.serializers.put(r10, MiscCodec.instance);
        goto L72
    L23:
        if (JSONStreamAware.class.isAssignableFrom(r10) == false) goto L26;
        this.serializers.put(r10, MiscCodec.instance);
        goto L72
    L26:
        if (r10.isEnum() == true) goto L70;
        Class<? super Object> r13 = r10.getSuperclass();
        if (r13 == null) goto L35;
        if (r13 == Object.class) goto L35;
        if (r13.isEnum() == true) goto L70;
    L35:
        if (r10.isArray() == false) goto L38;
        Class<?> r14 = r10.getComponentType();
        this.serializers.put(r10, new ArraySerializer(r14, get(r14)));
        goto L72
    L38:
        if (Throwable.class.isAssignableFrom(r10) == false) goto L41;
        JavaBeanSerializer r15 = new JavaBeanSerializer(r10, this.propertyNamingStrategy);
        r15.features |= SerializerFeature.WriteClassName.mask;
        this.serializers.put(r10, r15);
        goto L72
    L41:
        if (TimeZone.class.isAssignableFrom(r10) == false) goto L44;
        this.serializers.put(r10, MiscCodec.instance);
        goto L72
    L44:
        if (Charset.class.isAssignableFrom(r10) == false) goto L47;
        this.serializers.put(r10, MiscCodec.instance);
        goto L72
    L47:
        if (Enumeration.class.isAssignableFrom(r10) == false) goto L50;
        this.serializers.put(r10, MiscCodec.instance);
        goto L72
    L50:
        if (Calendar.class.isAssignableFrom(r10) == false) goto L52;
        this.serializers.put(r10, DateCodec.instance);
        goto L72
    L52:
        Class<?>[] r16 = r10.getInterfaces();
        int r17 = r16.length;
        boolean r18 = false;
        int r19 = 0;
    L53:
        if (r19 >= r17) goto L63;
        Class<?> r20 = r16[r19];
        if (r20.getName().equals("net.sf.cglib.proxy.Factory") == true) goto L64;
        if (r20.getName().equals("org.springframework.cglib.proxy.Factory") == true) goto L64;
        if (r20.getName().equals("javassist.util.proxy.ProxyObject") == true) goto L61;
        r19 = r19 + 1;
        goto L53
    L61:
        r18 = true;
        r11 = false;
    L64:
        if (r11 == true) goto L68;
        if (r18 == true) goto L68;
        this.serializers.put(r10, new JavaBeanSerializer(r10, this.propertyNamingStrategy));
    L68:
        ObjectSerializer r21 = get(r10.getSuperclass());
        this.serializers.put(r10, r21);
        return r21;
    L63:
        r11 = false;
    L70:
        this.serializers.put(r10, new EnumSerializer());
        goto L72
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean put(Type r10, ObjectSerializer r11) {
        return this.serializers.put(r10, r11);
    }

    public ObjectSerializer registerIfNotExists(Class<?> r10) {
        return registerIfNotExists(r10, r10.getModifiers(), false, true, true, true);
    }

    public void setTypeKey(String r10) {
        this.typeKey = r10;
    }

    public ObjectSerializer registerIfNotExists(Class<?> r13, int r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        ObjectSerializer r10 = this.serializers.get(r13);
        if (r10 != null) goto L6;
        JavaBeanSerializer r11 = new JavaBeanSerializer(r13, r14, null, r15, r16, r17, r18, this.propertyNamingStrategy);
        this.serializers.put(r13, r11);
        return r11;
    L6:
        return r10;
    }
}
