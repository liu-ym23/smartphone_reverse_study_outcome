package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

/* loaded from: classes.dex */
public class SerializeConfig {
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private final boolean fieldBased;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean awtError = false;
    private static boolean jdk8Error = false;
    private static boolean oracleJdbcError = false;
    private static boolean springfoxError = false;
    private static boolean guavaError = false;
    private static boolean jsonnullError = false;

    public SerializeConfig() {
        this(1024);
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        JavaBeanSerializer javaBeanSerializerCreateJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        int i4 = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = javaBeanSerializerCreateJavaBeanSerializer.sortedGetters;
            if (i4 >= fieldSerializerArr.length) {
                return javaBeanSerializerCreateJavaBeanSerializer;
            }
            Class<?> cls = fieldSerializerArr[i4].fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                javaBeanSerializerCreateJavaBeanSerializer.writeDirect = false;
            }
            i4++;
        }
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        Object objectWriter = getObjectWriter(cls);
        if (objectWriter instanceof SerializeFilterable) {
            SerializeFilterable serializeFilterable = (SerializeFilterable) objectWriter;
            if (this == globalInstance || serializeFilterable != MapSerializer.instance) {
                serializeFilterable.addFilter(serializeFilter);
                return;
            }
            MapSerializer mapSerializer = new MapSerializer();
            put((Type) cls, (ObjectSerializer) mapSerializer);
            mapSerializer.addFilter(serializeFilter);
        }
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z4) throws ClassNotFoundException {
        ObjectSerializer objectWriter = getObjectWriter(cls, false);
        if (objectWriter == null) {
            SerializeBeanInfo serializeBeanInfoBuildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy);
            if (z4) {
                serializeBeanInfoBuildBeanInfo.features = serializerFeature.mask | serializeBeanInfoBuildBeanInfo.features;
            } else {
                serializeBeanInfoBuildBeanInfo.features = (~serializerFeature.mask) & serializeBeanInfoBuildBeanInfo.features;
            }
            put((Type) cls, createJavaBeanSerializer(serializeBeanInfoBuildBeanInfo));
            return;
        }
        if (objectWriter instanceof JavaBeanSerializer) {
            SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
            int i4 = serializeBeanInfo.features;
            if (z4) {
                serializeBeanInfo.features = serializerFeature.mask | i4;
            } else {
                serializeBeanInfo.features = (~serializerFeature.mask) & i4;
            }
            if (i4 == serializeBeanInfo.features || objectWriter.getClass() == JavaBeanSerializer.class) {
                return;
            }
            put((Type) cls, createJavaBeanSerializer(serializeBeanInfo));
        }
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            put((Type) cls, createJavaBeanSerializer(cls));
        }
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        SerializeBeanInfo serializeBeanInfoBuildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy, this.fieldBased);
        return (serializeBeanInfoBuildBeanInfo.fields.length == 0 && Iterable.class.isAssignableFrom(cls)) ? MiscCodec.instance : createJavaBeanSerializer(serializeBeanInfoBuildBeanInfo);
    }

    public final ObjectSerializer get(Type type) {
        return this.serializers.get(type);
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return getObjectWriter(cls, true);
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public boolean put(Object obj, Object obj2) {
        return put((Type) obj, (ObjectSerializer) obj2);
    }

    public void setAsmEnable(boolean z4) {
        if (ASMUtils.IS_ANDROID) {
            return;
        }
        this.asm = z4;
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        this.propertyNamingStrategy = propertyNamingStrategy;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    public SerializeConfig(boolean z4) {
        this(1024, z4);
    }

    private ObjectSerializer getObjectWriter(Class<?> cls, boolean z4) throws ClassNotFoundException {
        ClassLoader classLoader;
        ObjectSerializer objectSerializerCreateJavaBeanSerializer = this.serializers.get(cls);
        if (objectSerializerCreateJavaBeanSerializer == null) {
            try {
                for (Object obj : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                    if (obj instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer = (AutowiredObjectSerializer) obj;
                        Iterator<Type> it = autowiredObjectSerializer.getAutowiredFor().iterator();
                        while (it.hasNext()) {
                            put(it.next(), (ObjectSerializer) autowiredObjectSerializer);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
            objectSerializerCreateJavaBeanSerializer = this.serializers.get(cls);
        }
        if (objectSerializerCreateJavaBeanSerializer == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (Object obj2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
                    if (obj2 instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer2 = (AutowiredObjectSerializer) obj2;
                        Iterator<Type> it2 = autowiredObjectSerializer2.getAutowiredFor().iterator();
                        while (it2.hasNext()) {
                            put(it2.next(), (ObjectSerializer) autowiredObjectSerializer2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            objectSerializerCreateJavaBeanSerializer = this.serializers.get(cls);
        }
        if (objectSerializerCreateJavaBeanSerializer != null) {
            return objectSerializerCreateJavaBeanSerializer;
        }
        String name = cls.getName();
        if (Map.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = MapSerializer.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (List.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = ListSerializer.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (Collection.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = CollectionCodec.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (Date.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = DateCodec.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (JSONAware.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = JSONAwareSerializer.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (JSONSerializable.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = JSONSerializableSerializer.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (JSONStreamAware.class.isAssignableFrom(cls)) {
            objectSerializerCreateJavaBeanSerializer = MiscCodec.instance;
            put((Type) cls, objectSerializerCreateJavaBeanSerializer);
        } else if (cls.isEnum() || (cls.getSuperclass() != null && cls.getSuperclass().isEnum())) {
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
            if (jSONType == null || !jSONType.serializeEnumAsJavaBean()) {
                objectSerializerCreateJavaBeanSerializer = EnumSerializer.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else {
                objectSerializerCreateJavaBeanSerializer = createJavaBeanSerializer(cls);
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            }
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            ObjectSerializer arraySerializer = new ArraySerializer(componentType, getObjectWriter(componentType));
            put((Type) cls, arraySerializer);
            objectSerializerCreateJavaBeanSerializer = arraySerializer;
        } else {
            Class<?> cls2 = null;
            if (Throwable.class.isAssignableFrom(cls)) {
                SerializeBeanInfo serializeBeanInfoBuildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy);
                serializeBeanInfoBuildBeanInfo.features |= SerializerFeature.WriteClassName.mask;
                ObjectSerializer javaBeanSerializer = new JavaBeanSerializer(serializeBeanInfoBuildBeanInfo);
                put((Type) cls, javaBeanSerializer);
                objectSerializerCreateJavaBeanSerializer = javaBeanSerializer;
            } else if (TimeZone.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = MiscCodec.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (Appendable.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = AppendableSerializer.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (Charset.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = ToStringSerializer.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (Enumeration.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = EnumerationSerializer.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (Calendar.class.isAssignableFrom(cls) || XMLGregorianCalendar.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = CalendarCodec.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (Clob.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = ClobSeriliazer.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (TypeUtils.isPath(cls)) {
                objectSerializerCreateJavaBeanSerializer = ToStringSerializer.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else if (Iterator.class.isAssignableFrom(cls)) {
                objectSerializerCreateJavaBeanSerializer = MiscCodec.instance;
                put((Type) cls, objectSerializerCreateJavaBeanSerializer);
            } else {
                int i4 = 0;
                if (name.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
                    try {
                        String[] strArr = {"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"};
                        for (int i5 = 0; i5 < 4; i5++) {
                            String str = strArr[i5];
                            if (str.equals(name)) {
                                Type cls3 = Class.forName(str);
                                objectSerializerCreateJavaBeanSerializer = AwtCodec.instance;
                                put(cls3, objectSerializerCreateJavaBeanSerializer);
                                return objectSerializerCreateJavaBeanSerializer;
                            }
                        }
                    } catch (Throwable unused3) {
                        awtError = true;
                    }
                }
                if (!jdk8Error && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                    try {
                        String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                        for (int i6 = 0; i6 < 11; i6++) {
                            String str2 = strArr2[i6];
                            if (str2.equals(name)) {
                                Type cls4 = Class.forName(str2);
                                ObjectSerializer objectSerializer = Jdk8DateCodec.instance;
                                put(cls4, objectSerializer);
                                return objectSerializer;
                            }
                        }
                        String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                        for (int i7 = 0; i7 < 4; i7++) {
                            String str3 = strArr3[i7];
                            if (str3.equals(name)) {
                                Type cls5 = Class.forName(str3);
                                ObjectSerializer objectSerializer2 = OptionalCodec.instance;
                                put(cls5, objectSerializer2);
                                return objectSerializer2;
                            }
                        }
                        String[] strArr4 = {"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"};
                        for (int i8 = 0; i8 < 2; i8++) {
                            String str4 = strArr4[i8];
                            if (str4.equals(name)) {
                                Type cls6 = Class.forName(str4);
                                ObjectSerializer objectSerializer3 = AdderSerializer.instance;
                                put(cls6, objectSerializer3);
                                return objectSerializer3;
                            }
                        }
                    } catch (Throwable unused4) {
                        jdk8Error = true;
                    }
                }
                if (!oracleJdbcError && name.startsWith("oracle.sql.")) {
                    try {
                        String[] strArr5 = {"oracle.sql.DATE", "oracle.sql.TIMESTAMP"};
                        for (int i9 = 0; i9 < 2; i9++) {
                            String str5 = strArr5[i9];
                            if (str5.equals(name)) {
                                Type cls7 = Class.forName(str5);
                                objectSerializerCreateJavaBeanSerializer = DateCodec.instance;
                                put(cls7, objectSerializerCreateJavaBeanSerializer);
                                return objectSerializerCreateJavaBeanSerializer;
                            }
                        }
                    } catch (Throwable unused5) {
                        oracleJdbcError = true;
                    }
                }
                if (!springfoxError && name.equals("springfox.documentation.spring.web.json.Json")) {
                    try {
                        Type cls8 = Class.forName("springfox.documentation.spring.web.json.Json");
                        objectSerializerCreateJavaBeanSerializer = SwaggerJsonSerializer.instance;
                        put(cls8, objectSerializerCreateJavaBeanSerializer);
                        return objectSerializerCreateJavaBeanSerializer;
                    } catch (ClassNotFoundException unused6) {
                        springfoxError = true;
                    }
                }
                if (!guavaError && name.startsWith("com.google.common.collect.")) {
                    try {
                        String[] strArr6 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                        for (int i10 = 0; i10 < 4; i10++) {
                            String str6 = strArr6[i10];
                            if (str6.equals(name)) {
                                Type cls9 = Class.forName(str6);
                                objectSerializerCreateJavaBeanSerializer = GuavaCodec.instance;
                                put(cls9, objectSerializerCreateJavaBeanSerializer);
                                return objectSerializerCreateJavaBeanSerializer;
                            }
                        }
                    } catch (ClassNotFoundException unused7) {
                        guavaError = true;
                    }
                }
                if (!jsonnullError && name.equals("net.sf.json.JSONNull")) {
                    try {
                        Type cls10 = Class.forName("net.sf.json.JSONNull");
                        objectSerializerCreateJavaBeanSerializer = MiscCodec.instance;
                        put(cls10, objectSerializerCreateJavaBeanSerializer);
                        return objectSerializerCreateJavaBeanSerializer;
                    } catch (ClassNotFoundException unused8) {
                        jsonnullError = true;
                    }
                }
                Class<?>[] interfaces = cls.getInterfaces();
                if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                    return AnnotationSerializer.instance;
                }
                if (TypeUtils.isProxy(cls)) {
                    ObjectSerializer objectWriter = getObjectWriter(cls.getSuperclass());
                    put((Type) cls, objectWriter);
                    return objectWriter;
                }
                if (Proxy.isProxyClass(cls)) {
                    if (interfaces.length != 2) {
                        int length = interfaces.length;
                        Class<?> cls11 = null;
                        while (true) {
                            if (i4 >= length) {
                                cls2 = cls11;
                                break;
                            }
                            Class<?> cls12 = interfaces[i4];
                            if (!cls12.getName().startsWith("org.springframework.aop.")) {
                                if (cls11 != null) {
                                    break;
                                }
                                cls11 = cls12;
                            }
                            i4++;
                        }
                    } else {
                        cls2 = interfaces[1];
                    }
                    if (cls2 != null) {
                        ObjectSerializer objectWriter2 = getObjectWriter(cls2);
                        put((Type) cls, objectWriter2);
                        return objectWriter2;
                    }
                }
                if (z4) {
                    objectSerializerCreateJavaBeanSerializer = createJavaBeanSerializer(cls);
                    put((Type) cls, objectSerializerCreateJavaBeanSerializer);
                }
            }
        }
        return objectSerializerCreateJavaBeanSerializer == null ? this.serializers.get(cls) : objectSerializerCreateJavaBeanSerializer;
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public SerializeConfig(int i4) {
        this(i4, false);
    }

    public SerializeConfig(int i4, boolean z4) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.fieldBased = z4;
        this.serializers = new IdentityHashMap<>(i4);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.asm = false;
        }
        put(Boolean.class, (ObjectSerializer) BooleanCodec.instance);
        put(Character.class, (ObjectSerializer) CharacterCodec.instance);
        put(Byte.class, (ObjectSerializer) IntegerCodec.instance);
        put(Short.class, (ObjectSerializer) IntegerCodec.instance);
        put(Integer.class, (ObjectSerializer) IntegerCodec.instance);
        put(Long.class, (ObjectSerializer) LongCodec.instance);
        put(Float.class, (ObjectSerializer) FloatCodec.instance);
        put(Double.class, (ObjectSerializer) DoubleSerializer.instance);
        put(BigDecimal.class, (ObjectSerializer) BigDecimalCodec.instance);
        put(BigInteger.class, (ObjectSerializer) BigIntegerCodec.instance);
        put(String.class, (ObjectSerializer) StringCodec.instance);
        put(byte[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(short[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(int[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(long[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(float[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(double[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(boolean[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(char[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(Object[].class, (ObjectSerializer) ObjectArrayCodec.instance);
        MiscCodec miscCodec = MiscCodec.instance;
        put(Class.class, (ObjectSerializer) miscCodec);
        put(SimpleDateFormat.class, (ObjectSerializer) miscCodec);
        put(Currency.class, (ObjectSerializer) new MiscCodec());
        put(TimeZone.class, (ObjectSerializer) miscCodec);
        put(InetAddress.class, (ObjectSerializer) miscCodec);
        put(Inet4Address.class, (ObjectSerializer) miscCodec);
        put(Inet6Address.class, (ObjectSerializer) miscCodec);
        put(InetSocketAddress.class, (ObjectSerializer) miscCodec);
        put(File.class, (ObjectSerializer) miscCodec);
        AppendableSerializer appendableSerializer = AppendableSerializer.instance;
        put(Appendable.class, (ObjectSerializer) appendableSerializer);
        put(StringBuffer.class, (ObjectSerializer) appendableSerializer);
        put(StringBuilder.class, (ObjectSerializer) appendableSerializer);
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        put(Charset.class, (ObjectSerializer) toStringSerializer);
        put(Pattern.class, (ObjectSerializer) toStringSerializer);
        put(Locale.class, (ObjectSerializer) toStringSerializer);
        put(URI.class, (ObjectSerializer) toStringSerializer);
        put(URL.class, (ObjectSerializer) toStringSerializer);
        put(UUID.class, (ObjectSerializer) toStringSerializer);
        AtomicCodec atomicCodec = AtomicCodec.instance;
        put(AtomicBoolean.class, (ObjectSerializer) atomicCodec);
        put(AtomicInteger.class, (ObjectSerializer) atomicCodec);
        put(AtomicLong.class, (ObjectSerializer) atomicCodec);
        ReferenceCodec referenceCodec = ReferenceCodec.instance;
        put(AtomicReference.class, (ObjectSerializer) referenceCodec);
        put(AtomicIntegerArray.class, (ObjectSerializer) atomicCodec);
        put(AtomicLongArray.class, (ObjectSerializer) atomicCodec);
        put(WeakReference.class, (ObjectSerializer) referenceCodec);
        put(SoftReference.class, (ObjectSerializer) referenceCodec);
        put(LinkedList.class, (ObjectSerializer) CollectionCodec.instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x011c A[EDGE_INSN: B:111:0x011c->B:99:0x011c BREAK  A[LOOP:1: B:52:0x008c->B:97:0x0116], EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.fastjson.serializer.ObjectSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo r14) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo):com.alibaba.fastjson.serializer.ObjectSerializer");
    }
}
