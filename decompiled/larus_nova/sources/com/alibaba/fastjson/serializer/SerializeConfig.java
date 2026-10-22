package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.support.moneta.MonetaCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import me.ele.lancet.base.annotations.Skip;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class SerializeConfig {
    private static boolean awtError;
    public static final SerializeConfig globalInstance = null;
    private static boolean guavaError;
    private static boolean jdk8Error;
    private static boolean jodaError;
    private static boolean oracleJdbcError;
    private static boolean springfoxError;
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private long[] denyClasses;
    private final boolean fieldBased;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectSerializer>> mixInSerializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        globalInstance = new SerializeConfig();
        awtError = false;
        jdk8Error = false;
        oracleJdbcError = false;
        springfoxError = false;
        guavaError = false;
        jodaError = false;
    }

    public SerializeConfig() {
        this(8192);
    }

    private void initSerializers() {
        put(Boolean.class, BooleanCodec.instance);
        put(Character.class, CharacterCodec.instance);
        put(Byte.class, IntegerCodec.instance);
        put(Short.class, IntegerCodec.instance);
        put(Integer.class, IntegerCodec.instance);
        put(Long.class, LongCodec.instance);
        put(Float.class, FloatCodec.instance);
        put(Double.class, DoubleSerializer.instance);
        put(BigDecimal.class, BigDecimalCodec.instance);
        put(BigInteger.class, BigIntegerCodec.instance);
        put(String.class, StringCodec.instance);
        put(byte[].class, PrimitiveArraySerializer.instance);
        put(short[].class, PrimitiveArraySerializer.instance);
        put(int[].class, PrimitiveArraySerializer.instance);
        put(long[].class, PrimitiveArraySerializer.instance);
        put(float[].class, PrimitiveArraySerializer.instance);
        put(double[].class, PrimitiveArraySerializer.instance);
        put(boolean[].class, PrimitiveArraySerializer.instance);
        put(char[].class, PrimitiveArraySerializer.instance);
        put(Object[].class, ObjectArrayCodec.instance);
        MiscCodec r100 = MiscCodec.instance;
        put(Class.class, r100);
        put(SimpleDateFormat.class, r100);
        put(Currency.class, new MiscCodec());
        put(TimeZone.class, r100);
        put(InetAddress.class, r100);
        put(Inet4Address.class, r100);
        put(Inet6Address.class, r100);
        put(InetSocketAddress.class, r100);
        put(File.class, r100);
        AppendableSerializer r101 = AppendableSerializer.instance;
        put(Appendable.class, r101);
        put(StringBuffer.class, r101);
        put(StringBuilder.class, r101);
        ToStringSerializer r102 = ToStringSerializer.instance;
        put(Charset.class, r102);
        put(Pattern.class, r102);
        put(Locale.class, r102);
        put(URI.class, r102);
        put(URL.class, r102);
        put(UUID.class, r102);
        AtomicCodec r103 = AtomicCodec.instance;
        put(AtomicBoolean.class, r103);
        put(AtomicInteger.class, r103);
        put(AtomicLong.class, r103);
        ReferenceCodec r104 = ReferenceCodec.instance;
        put(AtomicReference.class, r104);
        put(AtomicIntegerArray.class, r103);
        put(AtomicLongArray.class, r103);
        put(WeakReference.class, r104);
        put(SoftReference.class, r104);
        put(LinkedList.class, CollectionCodec.instance);
    }

    public void clearSerializers() {
        this.serializers.clear();
        initSerializers();
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public ObjectSerializer getEnumSerializer() {
        return EnumSerializer.instance;
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public SerializeConfig(boolean r100) {
        this(8192, r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo r100) throws Exception {
        JavaBeanSerializer r101 = this.asmFactory.createJavaBeanSerializer(r100);
        int r102 = 0;
    L3:
        FieldSerializer[] r103 = r101.sortedGetters;
        if (r102 >= r103.length) goto L11;
        Class<?> r104 = r103[r102].fieldInfo.fieldClass;
        if (r104.isEnum() == false) goto L10;
        if ((getObjectWriter(r104) instanceof EnumSerializer) == true) goto L10;
        r101.writeDirect = false;
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return r101;
    }

    private static Member getEnumValueField(Class r100) {
        Method[] r101 = r100.getMethods();
        int r102 = r101.length;
        int r103 = 0;
        Field r104 = null;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L13;
        Method r106 = r101[r105];
        if (r106.getReturnType() == Void.class) goto L12;
        if (((JSONField) r106.getAnnotation(JSONField.class)) == null) goto L12;
        if (r104 != null) goto L10;
        r104 = r106;
        goto L12
    L10:
        return null;
    L12:
        r105 = r105 + 1;
        goto L3
    L13:
        Field[] r107 = r100.getFields();
        int r108 = r107.length;
    L14:
        if (r103 >= r108) goto L21;
        Field r109 = r107[r103];
        if (((JSONField) r109.getAnnotation(JSONField.class)) == null) goto L20;
        if (r104 != null) goto L18;
        r104 = r109;
        goto L20
    L18:
        return null;
    L20:
        r103 = r103 + 1;
        goto L14
    L21:
        return r104;
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Class<? extends Enum> r103 = r100[r102];
        put(r103, createJavaBeanSerializer(r103));
        r102 = r102 + 1;
        goto L3
    }

    public ObjectSerializer createJavaBeanSerializer(SerializeBeanInfo r110) {
        JSONType r100 = r110.jsonType;
        boolean r101 = false;
        if (this.asm == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 == null) goto L37;
        Class<?> r103 = r100.serializer();
        if (r103 == Void.class) goto L17;
        Object r104 = r103.newInstance();     // Catch: Throwable -> L15
        if ((r104 instanceof ObjectSerializer) == false) goto L17;
        return (ObjectSerializer) r104;
    L17:
        if (r100.asm() == true) goto L19;
        r102 = false;
    L19:
        if (r102 == false) goto L33;
        SerializerFeature[] r105 = r100.serialzeFeatures();
        int r106 = r105.length;
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L33;
        SerializerFeature r108 = r105[r107];
        if (SerializerFeature.WriteNonStringValueAsString == r108) goto L32;
        if (SerializerFeature.WriteEnumUsingToString == r108) goto L32;
        if (SerializerFeature.NotWriteDefaultValue == r108) goto L32;
        if (SerializerFeature.BrowserCompatible == r108) goto L32;
        r107 = r107 + 1;
    L32:
        r102 = false;
    L33:
        if (r102 == false) goto L37;
        if (r100.serialzeFilters().length == 0) goto L37;
        r102 = false;
    L37:
        Class<?> r109 = r110.beanType;
        if (Modifier.isPublic(r109.getModifiers()) == false) goto L40;
        if (r102 == false) goto L45;
        if (this.asmFactory.classLoader.isExternalClass(r109) == false) goto L45;
    L48:
        r102 = false;
    L49:
        if (r102 == true) goto L51;
    L53:
        if (r102 == true) goto L55;
    L57:
        if (r102 == false) goto L119;
        FieldInfo[] r111 = r110.fields;
        int r112 = r111.length;
        int r113 = 0;
    L59:
        if (r113 >= r112) goto L119;
        FieldInfo r114 = r111[r113];
        Field r115 = r114.field;
        if (r115 != null) goto L63;
    L65:
        Method r116 = r114.method;
        if (r116 == null) goto L71;
        if (r116.getReturnType().equals(r114.fieldClass) == true) goto L71;
    L120:
        if (r101 == false) goto L133;
        JavaBeanSerializer r117 = createASMSerializer(r110);     // Catch: Throwable -> L124 OutOfMemoryError -> L127 Throwable -> L134
        if (r117 == null) goto L133;
        return r117;
    L127:
        e = move-exception;
        if (e.getMessage().indexOf("Metaspace") == (-1)) goto L133;
        throw e;
    L124:
        th = move-exception;
        throw new JSONException("create asm serializer error, verson 1.2.83, class " + r109, th);
    L133:
        return new JavaBeanSerializer(r110);
    L71:
        if (r114.fieldClass.isEnum() == true) goto L73;
    L75:
        JSONField r118 = r114.getAnnotation();
        if (r118 == null) goto L118;
        String r119 = r118.format();
        if (r119.length() == 0) goto L85;
        if (r114.fieldClass != String.class) goto L120;
        if ("trim".equals(r119) == false) goto L120;
    L85:
        if (ASMUtils.checkName(r118.name()) == false) goto L120;
        if (r118.jsonDirect() == true) goto L120;
        if (r118.serializeUsing() != Void.class) goto L120;
        if (r118.unwrapped() == true) goto L120;
        SerializerFeature[] r120 = r118.serialzeFeatures();
        int r121 = r120.length;
        int r122 = 0;
    L94:
        if (r122 >= r121) goto L109;
        SerializerFeature r123 = r120[r122];
        if (SerializerFeature.WriteNonStringValueAsString == r123) goto L107;
        if (SerializerFeature.WriteEnumUsingToString == r123) goto L107;
        if (SerializerFeature.NotWriteDefaultValue == r123) goto L107;
        if (SerializerFeature.BrowserCompatible == r123) goto L107;
        if (SerializerFeature.WriteClassName == r123) goto L107;
        r122 = r122 + 1;
    L107:
        r102 = false;
    L109:
        if (TypeUtils.isAnnotationPresentOneToMany(r116) == true) goto L120;
        if (TypeUtils.isAnnotationPresentManyToMany(r116) == true) goto L120;
        if (r118.defaultValue() == null) goto L118;
        if ("".equals(r118.defaultValue()) == false) goto L120;
    L118:
        r113 = r113 + 1;
        goto L59
    L73:
        if (get(r114.fieldClass) == EnumSerializer.instance) goto L75;
    L63:
        if (r115.getType().equals(r114.fieldClass) == true) goto L65;
    L119:
        r101 = r102;
        goto L120
    L55:
        if (r110.beanType.isInterface() == false) goto L57;
        r102 = false;
        goto L57
    L51:
        if (ASMUtils.checkName(r109.getSimpleName()) == true) goto L53;
        r102 = false;
    L45:
        if (r109 == Serializable.class) goto L48;
        if (r109 != Object.class) goto L49;
    L40:
        return new JavaBeanSerializer(r110);
    L5:
        if (this.fieldBased == true) goto L7;
        r102 = true;
        goto L8
    }

    public final ObjectSerializer get(Type r100) {
        Type r101 = JSON.getMixInAnnotations(r100);
        if (r101 == null) goto L5;
        IdentityHashMap<Type, ObjectSerializer> r102 = this.mixInSerializers.get(r100);
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.get(r101);
    L5:
        return this.serializers.get(r100);
    }

    public ObjectSerializer getObjectWriter(Class<?> r100) {
        return getObjectWriter(r100, true);
    }

    public void register(Module r100) {
        this.modules.add(r100);
    }

    public void setAsmEnable(boolean r100) {
        if (ASMUtils.IS_ANDROID == false) goto L5;
        return;
    L5:
        this.asm = r100;
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy r100) {
        this.propertyNamingStrategy = r100;
    }

    public void setTypeKey(String r100) {
        this.typeKey = r100;
    }

    public SerializeConfig(int r100) {
        this(r100, false);
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> r100) {
        String r101 = r100.getName();
        long r102 = TypeUtils.fnv1a_64(r101);
        if (Arrays.binarySearch(this.denyClasses, r102) >= 0) goto L13;
        SerializeBeanInfo r103 = TypeUtils.buildBeanInfo(r100, null, this.propertyNamingStrategy, this.fieldBased);
        if (r103.fields.length != 0) goto L11;
        if (Iterable.class.isAssignableFrom(r100) == false) goto L11;
        return MiscCodec.instance;
    L11:
        return createJavaBeanSerializer(r103);
    L13:
        throw new JSONException("not support class : ".concat(r101));
    }

    public SerializeConfig(int r100, boolean r101) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.denyClasses = new long[]{4165360493669296979L, 4446674157046724083L};
        this.modules = new ArrayList();
        this.fieldBased = r101;
        this.serializers = new IdentityHashMap(r100);
        this.mixInSerializers = new IdentityHashMap(16);
    L7:
        this.asm = false;
    L8:
        initSerializers();
        return;
    L4:
        if (this.asm == false) goto L8;
        this.asmFactory = new ASMSerializerFactory();     // Catch: Throwable -> L7
        goto L8
    }

    public void addFilter(Class<?> r100, SerializeFilter r101) {
        Object r102 = getObjectWriter(r100);
        if ((r102 instanceof SerializeFilterable) == false) goto L12;
        SerializeFilterable r103 = (SerializeFilterable) r102;
        if (this != globalInstance) goto L7;
    L10:
        r103.addFilter(r101);
        return;
    L7:
        if (r103 != MapSerializer.instance) goto L10;
        MapSerializer r104 = new MapSerializer();
        put(r100, r104);
        r104.addFilter(r101);
        return;
    }

    public ObjectSerializer getObjectWriter(Class<?> r210, boolean r211) {
        ObjectSerializer r100 = get(r210);
        if (r100 == null) goto L283;
        return r100;
    L283:
        Iterator r101 = ServiceLoader.load(AutowiredObjectSerializer.class, ThreadMethodProxy.currentThread().getContextClassLoader()).iterator();     // Catch: ClassCastException -> L16
    L7:
        if (r101.hasNext() == false) goto L17;
        Object r102 = r101.next();     // Catch: ClassCastException -> L16
        if ((r102 instanceof AutowiredObjectSerializer) == false) goto L7;
        AutowiredObjectSerializer r103 = (AutowiredObjectSerializer) r102;     // Catch: ClassCastException -> L16
        Iterator<Type> r104 = r103.getAutowiredFor().iterator();     // Catch: ClassCastException -> L16
    L13:
        if (r104.hasNext() == false) goto L7;
        put(r104.next(), r103);     // Catch: ClassCastException -> L16
    L17:
        ObjectSerializer r105 = get(r210);
        if (r105 != null) goto L33;
        ClassLoader r106 = JSON.class.getClassLoader();
        if (r106 == ThreadMethodProxy.currentThread().getContextClassLoader()) goto L33;
        Iterator r107 = ServiceLoader.load(AutowiredObjectSerializer.class, r106).iterator();     // Catch: ClassCastException -> L276
    L23:
        if (r107.hasNext() == false) goto L32;
        Object r108 = r107.next();     // Catch: ClassCastException -> L276
        if ((r108 instanceof AutowiredObjectSerializer) == false) goto L23;
        AutowiredObjectSerializer r109 = (AutowiredObjectSerializer) r108;     // Catch: ClassCastException -> L276
        Iterator<Type> r110 = r109.getAutowiredFor().iterator();     // Catch: ClassCastException -> L276
    L29:
        if (r110.hasNext() == false) goto L23;
        put(r110.next(), r109);     // Catch: ClassCastException -> L276
    L32:
        r105 = get(r210);
    L33:
        Iterator<Module> r111 = this.modules.iterator();
    L35:
        if (r111.hasNext() == false) goto L40;
        r105 = r111.next().createSerializer(this, r210);
        if (r105 == null) goto L35;
        put(r210, r105);
        return r105;
    L40:
        if (r105 != null) goto L329;
        String r112 = r210.getName();
        if (Map.class.isAssignableFrom(r210) == false) goto L45;
        r105 = MapSerializer.instance;
        put(r210, r105);
    L273:
        if (r105 == null) goto L275;
        return r105;
    L275:
        return get(r210);
    L45:
        if (List.class.isAssignableFrom(r210) == false) goto L48;
        r105 = ListSerializer.instance;
        put(r210, r105);
        goto L273
    L48:
        if (Collection.class.isAssignableFrom(r210) == false) goto L51;
        r105 = CollectionCodec.instance;
        put(r210, r105);
        goto L273
    L51:
        if (Date.class.isAssignableFrom(r210) == false) goto L54;
        r105 = DateCodec.instance;
        put(r210, r105);
        goto L273
    L54:
        if (JSONAware.class.isAssignableFrom(r210) == false) goto L57;
        r105 = JSONAwareSerializer.instance;
        put(r210, r105);
        goto L273
    L57:
        if (JSONSerializable.class.isAssignableFrom(r210) == false) goto L60;
        r105 = JSONSerializableSerializer.instance;
        put(r210, r105);
        goto L273
    L60:
        if (JSONStreamAware.class.isAssignableFrom(r210) == false) goto L62;
        r105 = MiscCodec.instance;
        put(r210, r105);
        goto L273
    L62:
        Class<?> r113 = null;
        Member r114 = null;
        r114 = null;
        r114 = null;
        if (r210.isEnum() == false) goto L84;
        Class r115 = (Class) JSON.getMixInAnnotations(r210);
        if (r115 == null) goto L67;
        JSONType r116 = (JSONType) TypeUtils.getAnnotation(r115, JSONType.class);
    L68:
        if (r116 != null) goto L70;
    L72:
        if (r115 == null) goto L80;
        Member r117 = getEnumValueField(r115);
        if (r117 != null) goto L281;
    L81:
        if (r114 == null) goto L83;
        r105 = new EnumSerializer(r114);
        put(r210, r105);
        goto L273
    L83:
        r105 = getEnumSerializer();
        put(r210, r105);
        goto L273
    L281:
        if ((r117 instanceof Method) == false) goto L81;
        Method r118 = (Method) r117;     // Catch: Exception -> L79
        r114 = r210.getMethod(r118.getName(), r118.getParameterTypes());     // Catch: Exception -> L79
        goto L81
    L80:
        r114 = getEnumValueField(r210);
        goto L81
    L70:
        if (r116.serializeEnumAsJavaBean() == false) goto L72;
        r105 = createJavaBeanSerializer(r210);
        put(r210, r105);
        goto L273
    L67:
        r116 = (JSONType) TypeUtils.getAnnotation(r210, JSONType.class);
        goto L68
    L84:
        Class<? super Object> r119 = r210.getSuperclass();
        if (r119 == null) goto L95;
        if (r119.isEnum() == false) goto L95;
        JSONType r120 = (JSONType) TypeUtils.getAnnotation(r119, JSONType.class);
        if (r120 != null) goto L91;
    L93:
        r105 = getEnumSerializer();
        put(r210, r105);
        goto L273
    L91:
        if (r120.serializeEnumAsJavaBean() == false) goto L93;
        r105 = createJavaBeanSerializer(r210);
        put(r210, r105);
    L95:
        if (r210.isArray() == false) goto L98;
        Class<?> r121 = r210.getComponentType();
        ObjectSerializer r122 = new ArraySerializer(r121, getObjectWriter(r121));
        put(r210, r122);
        r105 = r122;
        goto L273
    L98:
        if (Throwable.class.isAssignableFrom(r210) == false) goto L101;
        SerializeBeanInfo r123 = TypeUtils.buildBeanInfo(r210, null, this.propertyNamingStrategy);
        r123.features |= SerializerFeature.WriteClassName.mask;
        ObjectSerializer r124 = new JavaBeanSerializer(r123);
        put(r210, r124);
        r105 = r124;
        goto L273
    L101:
        if (TimeZone.class.isAssignableFrom(r210) == false) goto L103;
    L272:
        r105 = MiscCodec.instance;
        put(r210, r105);
        goto L273
    L103:
        if (Map.Entry.class.isAssignableFrom(r210) == true) goto L272;
        if (Appendable.class.isAssignableFrom(r210) == false) goto L109;
        r105 = AppendableSerializer.instance;
        put(r210, r105);
        goto L273
    L109:
        if (Charset.class.isAssignableFrom(r210) == false) goto L112;
        r105 = ToStringSerializer.instance;
        put(r210, r105);
        goto L273
    L112:
        if (Enumeration.class.isAssignableFrom(r210) == false) goto L115;
        r105 = EnumerationSerializer.instance;
        put(r210, r105);
        goto L273
    L115:
        if (Calendar.class.isAssignableFrom(r210) == false) goto L117;
    L271:
        r105 = CalendarCodec.instance;
        put(r210, r105);
        goto L273
    L117:
        if (XMLGregorianCalendar.class.isAssignableFrom(r210) == true) goto L271;
        if (TypeUtils.isClob(r210) == false) goto L123;
        r105 = ClobSerializer.instance;
        put(r210, r105);
        goto L273
    L123:
        if (TypeUtils.isPath(r210) == false) goto L126;
        r105 = ToStringSerializer.instance;
        put(r210, r105);
        goto L273
    L126:
        if (Iterator.class.isAssignableFrom(r210) == false) goto L129;
        r105 = MiscCodec.instance;
        put(r210, r105);
        goto L273
    L129:
        if (Node.class.isAssignableFrom(r210) == false) goto L131;
        r105 = MiscCodec.instance;
        put(r210, r105);
        goto L273
    L131:
        int r125 = 0;
        if (r112.startsWith("java.awt.") == false) goto L146;
        if (AwtCodec.support(r210) == false) goto L146;
        if (awtError == true) goto L146;
        String[] r126 = {"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"};     // Catch: Throwable -> L144
        int r127 = 0;
    L138:
        if (r127 >= 4) goto L146;
        String r128 = r126[r127];     // Catch: Throwable -> L144
        if (r128.equals(r112) == true) goto L141;
        r127 = r127 + 1;
        goto L138
    L141:
        Type r129 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r128);     // Catch: Throwable -> L144
        r105 = AwtCodec.instance;     // Catch: Throwable -> L144
        put(r129, r105);     // Catch: Throwable -> L144
        return r105;
    L144:
        awtError = true;
    L146:
        if (jdk8Error == true) goto L178;
        if (r112.startsWith("java.time.") == false) goto L150;
    L293:
        String[] r130 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"};     // Catch: Throwable -> L176
        int r131 = 0;
    L156:
        if (r131 >= 11) goto L162;
        String r132 = r130[r131];     // Catch: Throwable -> L176
        if (r132.equals(r112) == true) goto L159;
        r131 = r131 + 1;     // Catch: Throwable -> L176
        goto L156
    L159:
        Type r133 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r132);     // Catch: Throwable -> L176
        ObjectSerializer r134 = Jdk8DateCodec.instance;     // Catch: Throwable -> L176
        put(r133, r134);     // Catch: Throwable -> L176
        return r134;
    L162:
        String[] r135 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};     // Catch: Throwable -> L176
        int r136 = 0;
    L163:
        if (r136 >= 4) goto L169;
        String r137 = r135[r136];     // Catch: Throwable -> L176
        if (r137.equals(r112) == true) goto L166;
        r136 = r136 + 1;     // Catch: Throwable -> L176
        goto L163
    L166:
        Type r138 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r137);     // Catch: Throwable -> L176
        ObjectSerializer r139 = OptionalCodec.instance;     // Catch: Throwable -> L176
        put(r138, r139);     // Catch: Throwable -> L176
        return r139;
    L169:
        String[] r140 = {"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"};     // Catch: Throwable -> L176
        int r141 = 0;
    L170:
        if (r141 >= 2) goto L178;
        String r142 = r140[r141];     // Catch: Throwable -> L176
        if (r142.equals(r112) == true) goto L173;
        r141 = r141 + 1;
        goto L170
    L173:
        Type r143 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r142);     // Catch: Throwable -> L176
        ObjectSerializer r144 = AdderSerializer.instance;     // Catch: Throwable -> L176
        put(r143, r144);     // Catch: Throwable -> L176
        return r144;
    L176:
        jdk8Error = true;
        goto L178
    L150:
        if (r112.startsWith("java.util.Optional") == true) goto L293;
        if (r112.equals("java.util.concurrent.atomic.LongAdder") == true) goto L293;
        if (r112.equals("java.util.concurrent.atomic.DoubleAdder") == true) goto L293;
    L178:
        if (oracleJdbcError == true) goto L190;
        if (r112.startsWith("oracle.sql.") == false) goto L190;
        String[] r145 = {"oracle.sql.DATE", "oracle.sql.TIMESTAMP"};     // Catch: Throwable -> L188
        int r146 = 0;
    L182:
        if (r146 >= 2) goto L190;
        String r147 = r145[r146];     // Catch: Throwable -> L188
        if (r147.equals(r112) == true) goto L185;
        r146 = r146 + 1;
        goto L182
    L185:
        Type r148 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r147);     // Catch: Throwable -> L188
        r105 = DateCodec.instance;     // Catch: Throwable -> L188
        put(r148, r105);     // Catch: Throwable -> L188
        return r105;
    L188:
        oracleJdbcError = true;
    L190:
        if (springfoxError == true) goto L197;
        if (r112.equals("springfox.documentation.spring.web.json.Json") == false) goto L197;
        Type r149 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("springfox.documentation.spring.web.json.Json");     // Catch: ClassNotFoundException -> L195
        r105 = SwaggerJsonSerializer.instance;     // Catch: ClassNotFoundException -> L195
        put(r149, r105);     // Catch: ClassNotFoundException -> L195
        return r105;
    L195:
        springfoxError = true;
    L197:
        if (guavaError == true) goto L210;
        if (r112.startsWith("com.google.common.collect.") == false) goto L210;
        String[] r150 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};     // Catch: ClassNotFoundException -> L208
        int r151 = 0;
    L202:
        if (r151 >= 5) goto L210;
        String r152 = r150[r151];     // Catch: ClassNotFoundException -> L208
        if (r152.equals(r112) == true) goto L205;
        r151 = r151 + 1;
        goto L202
    L205:
        Type r153 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r152);     // Catch: ClassNotFoundException -> L208
        r105 = GuavaCodec.instance;     // Catch: ClassNotFoundException -> L208
        put(r153, r105);     // Catch: ClassNotFoundException -> L208
        return r105;
    L208:
        guavaError = true;
    L210:
        if (r112.equals("net.sf.json.JSONNull") == false) goto L214;
        ObjectSerializer r154 = MiscCodec.instance;
        put(r210, r154);
        return r154;
    L214:
        if (r112.equals("org.json.JSONObject") == false) goto L218;
        ObjectSerializer r155 = JSONObjectCodec.instance;
        put(r210, r155);
        return r155;
    L218:
        if (jodaError == true) goto L230;
        if (r112.startsWith("org.joda.") == false) goto L230;
        String[] r156 = {"org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.DateTime", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.UTCDateTimeZone", "org.joda.time.tz.CachedDateTimeZone", "org.joda.time.tz.FixedDateTimeZone"};     // Catch: ClassNotFoundException -> L228
        int r157 = 0;
    L222:
        if (r157 >= 11) goto L230;
        String r158 = r156[r157];     // Catch: ClassNotFoundException -> L228
        if (r158.equals(r112) == true) goto L225;
        r157 = r157 + 1;
        goto L222
    L225:
        Type r159 = INVOKESTATIC_com_alibaba_fastjson_serializer_SerializeConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r158);     // Catch: ClassNotFoundException -> L228
        r105 = JodaCodec.instance;     // Catch: ClassNotFoundException -> L228
        put(r159, r105);     // Catch: ClassNotFoundException -> L228
        return r105;
    L228:
        jodaError = true;
    L230:
        if ("java.nio.HeapByteBuffer".equals(r112) == false) goto L234;
        ObjectSerializer r160 = ByteBufferCodec.instance;
        put(r210, r160);
        return r160;
    L234:
        if ("org.javamoney.moneta.Money".equals(r112) == false) goto L238;
        ObjectSerializer r161 = MonetaCodec.instance;
        put(r210, r161);
        return r161;
    L238:
        if ("com.google.protobuf.Descriptors$FieldDescriptor".equals(r112) == false) goto L241;
        ObjectSerializer r162 = ToStringSerializer.instance;
        put(r210, r162);
        return r162;
    L241:
        Class<?>[] r163 = r210.getInterfaces();
        if (r163.length != 1) goto L248;
        if (r163[0].isAnnotation() == false) goto L248;
        put(r210, AnnotationSerializer.instance);
        return AnnotationSerializer.instance;
    L248:
        if (TypeUtils.isProxy(r210) == false) goto L252;
        ObjectSerializer r164 = getObjectWriter(r210.getSuperclass());
        put(r210, r164);
        return r164;
    L252:
        if (Proxy.isProxyClass(r210) == true) goto L254;
    L269:
        if (r211 == false) goto L273;
        r105 = createJavaBeanSerializer(r210);
        put(r210, r105);
        goto L273
    L254:
        if (r163.length != 2) goto L256;
        r113 = r163[1];
    L266:
        if (r113 == null) goto L269;
        ObjectSerializer r165 = getObjectWriter(r113);
        put(r210, r165);
        return r165;
    L256:
        int r166 = r163.length;
        Class<?> r167 = null;
    L257:
        if (r125 >= r166) goto L265;
        Class<?> r168 = r163[r125];
        if (r168.getName().startsWith("org.springframework.aop.") == true) goto L264;
        if (r167 != null) goto L266;
        r167 = r168;
    L264:
        r125 = r125 + 1;
        goto L257
    L265:
        r113 = r167;
        goto L266
    L329:
        return r105;
    }

    public boolean put(Type r100, ObjectSerializer r101) {
        Type r102 = JSON.getMixInAnnotations(r100);
        if (r102 == null) goto L10;
        IdentityHashMap<Type, ObjectSerializer> r103 = this.mixInSerializers.get(r100);
        if (r103 != null) goto L8;
        r103 = new IdentityHashMap(4);
        this.mixInSerializers.put(r100, r103);
    L8:
        return r103.put(r102, r101);
    L10:
        return this.serializers.put(r100, r101);
    }

    public boolean put(Object r100, Object r101) {
        return put((Type) r100, (ObjectSerializer) r101);
    }

    public void config(Class<?> r100, SerializerFeature r101, boolean r102) {
        ObjectSerializer r103 = getObjectWriter(r100, false);
        if (r103 != null) goto L11;
        SerializeBeanInfo r104 = TypeUtils.buildBeanInfo(r100, null, this.propertyNamingStrategy);
        if (r102 == false) goto L7;
        int r105 = r104.features;
        r104.features = r101.mask | r105;
    L8:
        put(r100, createJavaBeanSerializer(r104));
        return;
    L7:
        int r106 = r104.features;
        r104.features = (~r101.mask) & r106;
        goto L8
    L11:
        if ((r103 instanceof JavaBeanSerializer) == false) goto L23;
        SerializeBeanInfo r107 = ((JavaBeanSerializer) r103).beanInfo;
        int r108 = r107.features;
        if (r102 == false) goto L15;
        r107.features = r101.mask | r108;
    L17:
        if (r108 != r107.features) goto L20;
        return;
    L20:
        if (r103.getClass() == JavaBeanSerializer.class) goto L24;
        put(r100, createJavaBeanSerializer(r107));
        return;
    L24:
        return;
    L15:
        r107.features = (~r101.mask) & r108;
        goto L17
    }
}
