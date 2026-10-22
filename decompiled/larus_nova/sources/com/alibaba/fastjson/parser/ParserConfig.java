package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumCreatorDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.ByteBufferCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.GuavaCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.JodaCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.support.moneta.MonetaCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.Function;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ModuleUtil;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT = false;
    private static final String[] AUTO_TYPE_ACCEPT_LIST = null;
    public static final String[] DENYS = null;
    public static final String[] DENYS_INTERNAL = null;
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    public static final String DENY_PROPERTY_INTERNAL = "fastjson.parser.deny.internal";
    private static final long[] INTERNAL_WHITELIST_HASHCODES = null;
    public static final boolean SAFE_MODE = false;
    public static final String SAFE_MODE_PROPERTY = "fastjson.parser.safeMode";
    private static boolean awtError;
    public static ParserConfig global;
    private static boolean guavaError;
    private static Function<Class<?>, Boolean> isPrimitiveFuncation;
    private static boolean jdk8Error;
    private static boolean jodaError;
    private long[] acceptHashCodes;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private volatile List<AutoTypeCheckHandler> autoTypeCheckHandlers;
    private boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    protected ClassLoader defaultClassLoader;
    private long[] denyHashCodes;
    private final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    private final Callable<Void> initDeserializersWithJavaSql;
    private long[] internalDenyHashCodes;
    private boolean jacksonCompatible;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectDeserializer>> mixInDeserializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    private boolean safeMode;
    public final SymbolTable symbolTable;
    private final ConcurrentMap<String, Class<?>> typeMapping;

    public interface AutoTypeCheckHandler {
        Class<?> handler(String r100, Class<?> r101, int r102);
    }

    public ParserConfig() {
        this(false);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        DENYS_INTERNAL = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY_INTERNAL));
        DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
        AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));
        SAFE_MODE = "true".equals(IOUtils.getStringProperty(SAFE_MODE_PROPERTY));
        String[] r100 = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (r100 != null) goto L5;
        r100 = new String[0];
    L5:
        AUTO_TYPE_ACCEPT_LIST = r100;
        INTERNAL_WHITELIST_HASHCODES = new long[]{-6976602508726000783L, -6293031534589903644L, 59775428743665658L, 7267793227937552092L};
        global = new ParserConfig();
        awtError = false;
        jdk8Error = false;
        jodaError = false;
        guavaError = false;
        isPrimitiveFuncation = new AnonymousClass2();
    }

    private void initDeserializers() {
        IdentityHashMap<Type, ObjectDeserializer> r100 = this.deserializers;
        MiscCodec r101 = MiscCodec.instance;
        r100.put(SimpleDateFormat.class, r101);
        IdentityHashMap<Type, ObjectDeserializer> r102 = this.deserializers;
        CalendarCodec r103 = CalendarCodec.instance;
        r102.put(Calendar.class, r103);
        this.deserializers.put(XMLGregorianCalendar.class, r103);
        this.deserializers.put(JSONObject.class, MapDeserializer.instance);
        IdentityHashMap<Type, ObjectDeserializer> r104 = this.deserializers;
        CollectionCodec r105 = CollectionCodec.instance;
        r104.put(JSONArray.class, r105);
        this.deserializers.put(Map.class, MapDeserializer.instance);
        this.deserializers.put(HashMap.class, MapDeserializer.instance);
        this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.deserializers.put(TreeMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.deserializers.put(Collection.class, r105);
        this.deserializers.put(List.class, r105);
        this.deserializers.put(ArrayList.class, r105);
        IdentityHashMap<Type, ObjectDeserializer> r106 = this.deserializers;
        JavaObjectDeserializer r107 = JavaObjectDeserializer.instance;
        r106.put(Object.class, r107);
        this.deserializers.put(String.class, StringCodec.instance);
        this.deserializers.put(StringBuffer.class, StringCodec.instance);
        this.deserializers.put(StringBuilder.class, StringCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> r108 = this.deserializers;
        Class r109 = Character.TYPE;
        CharacterCodec r110 = CharacterCodec.instance;
        r108.put(r109, r110);
        this.deserializers.put(Character.class, r110);
        IdentityHashMap<Type, ObjectDeserializer> r111 = this.deserializers;
        Class r112 = Byte.TYPE;
        NumberDeserializer r113 = NumberDeserializer.instance;
        r111.put(r112, r113);
        this.deserializers.put(Byte.class, r113);
        this.deserializers.put(Short.TYPE, r113);
        this.deserializers.put(Short.class, r113);
        this.deserializers.put(Integer.TYPE, IntegerCodec.instance);
        this.deserializers.put(Integer.class, IntegerCodec.instance);
        this.deserializers.put(Long.TYPE, LongCodec.instance);
        this.deserializers.put(Long.class, LongCodec.instance);
        this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.deserializers.put(Float.TYPE, FloatCodec.instance);
        this.deserializers.put(Float.class, FloatCodec.instance);
        this.deserializers.put(Double.TYPE, r113);
        this.deserializers.put(Double.class, r113);
        IdentityHashMap<Type, ObjectDeserializer> r114 = this.deserializers;
        Class r115 = Boolean.TYPE;
        BooleanCodec r116 = BooleanCodec.instance;
        r114.put(r115, r116);
        this.deserializers.put(Boolean.class, r116);
        this.deserializers.put(Class.class, r101);
        this.deserializers.put(char[].class, new CharArrayCodec());
        this.deserializers.put(AtomicBoolean.class, r116);
        this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.deserializers.put(AtomicLong.class, LongCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> r117 = this.deserializers;
        ReferenceCodec r118 = ReferenceCodec.instance;
        r117.put(AtomicReference.class, r118);
        this.deserializers.put(WeakReference.class, r118);
        this.deserializers.put(SoftReference.class, r118);
        this.deserializers.put(UUID.class, r101);
        this.deserializers.put(TimeZone.class, r101);
        this.deserializers.put(Locale.class, r101);
        this.deserializers.put(Currency.class, r101);
        this.deserializers.put(Inet4Address.class, r101);
        this.deserializers.put(Inet6Address.class, r101);
        this.deserializers.put(InetSocketAddress.class, r101);
        this.deserializers.put(File.class, r101);
        this.deserializers.put(URI.class, r101);
        this.deserializers.put(URL.class, r101);
        this.deserializers.put(Pattern.class, r101);
        this.deserializers.put(Charset.class, r101);
        this.deserializers.put(JSONPath.class, r101);
        this.deserializers.put(Number.class, r113);
        IdentityHashMap<Type, ObjectDeserializer> r119 = this.deserializers;
        AtomicCodec r120 = AtomicCodec.instance;
        r119.put(AtomicIntegerArray.class, r120);
        this.deserializers.put(AtomicLongArray.class, r120);
        this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.deserializers.put(Serializable.class, r107);
        this.deserializers.put(Cloneable.class, r107);
        this.deserializers.put(Comparable.class, r107);
        this.deserializers.put(Closeable.class, r107);
        this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
        ModuleUtil.callWhenHasJavaSql(this.initDeserializersWithJavaSql);
    }

    public void clearDeserializers() {
        this.deserializers.clear();
        initDeserializers();
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.deserializers;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public boolean isJacksonCompatible() {
        return this.jacksonCompatible;
    }

    public boolean isSafeMode() {
        return this.safeMode;
    }

    public ParserConfig(ASMDeserializerFactory r100) {
        this(r100, null, false);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alibaba_fastjson_parser_ParserConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ IdentityHashMap access$000(ParserConfig r100) {
        return r100.deserializers;
    }

    private void addItemsToAccept(String[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
    L6:
        if (r101 >= r100.length) goto L8;
        addAccept(r100[r101]);
        r101 = r101 + 1;
        goto L6
    }

    private void addItemsToDeny(String[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
    L6:
        if (r101 >= r100.length) goto L8;
        addDeny(r100[r101]);
        r101 = r101 + 1;
        goto L6
    }

    private void addItemsToDeny0(String[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
    L6:
        if (r101 >= r100.length) goto L8;
        addDenyInternal(r100[r101]);
        r101 = r101 + 1;
        goto L6
    }

    public static boolean isPrimitive2(Class<?> r100) {
        if (r100.isPrimitive() == false) goto L5;
    L32:
        boolean r101 = true;
    L33:
        Boolean r102 = Boolean.valueOf(r101);
        if (r102.booleanValue() == true) goto L36;
        r102 = (Boolean) ModuleUtil.callWhenHasJavaSql(isPrimitiveFuncation, r100);
    L36:
        if (r102 != null) goto L38;
        return false;
    L38:
        return r102.booleanValue();
    L5:
        if (r100 == Boolean.class) goto L32;
        if (r100 == Character.class) goto L32;
        if (r100 == Byte.class) goto L32;
        if (r100 == Short.class) goto L32;
        if (r100 == Integer.class) goto L32;
        if (r100 == Long.class) goto L32;
        if (r100 == Float.class) goto L32;
        if (r100 == Double.class) goto L32;
        if (r100 == BigInteger.class) goto L32;
        if (r100 == BigDecimal.class) goto L32;
        if (r100 == String.class) goto L32;
        if (r100 == Date.class) goto L32;
        if (r100.isEnum() == true) goto L32;
        r101 = false;
        goto L33
    }

    private static String[] splitItemsFormProperty(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() > 0) goto L6;
        return null;
    L6:
        return r100.split(",");
    }

    public void addAccept(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() == 0) goto L12;
        long r101 = TypeUtils.fnv1a_64(r100);
        if (Arrays.binarySearch(this.acceptHashCodes, r101) < 0) goto L9;
        return;
    L9:
        long[] r102 = this.acceptHashCodes;
        int r103 = r102.length + 1;
        long[] r104 = new long[r103];
        r104[r103 - 1] = r101;
        System.arraycopy(r102, 0, r104, 0, r102.length);
        Arrays.sort(r104);
        this.acceptHashCodes = r104;
        return;
    }

    public void addAutoTypeCheckHandler(AutoTypeCheckHandler r100) {
        List r101 = this.autoTypeCheckHandlers;
        if (r101 != null) goto L5;
        r101 = new CopyOnWriteArrayList();
        this.autoTypeCheckHandlers = r101;
    L5:
        r101.add(r100);
    }

    public void addDeny(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() == 0) goto L12;
        long r101 = TypeUtils.fnv1a_64(r100);
        if (Arrays.binarySearch(this.denyHashCodes, r101) < 0) goto L9;
        return;
    L9:
        long[] r102 = this.denyHashCodes;
        int r103 = r102.length + 1;
        long[] r104 = new long[r103];
        r104[r103 - 1] = r101;
        System.arraycopy(r102, 0, r104, 0, r102.length);
        Arrays.sort(r104);
        this.denyHashCodes = r104;
        return;
    }

    public void addDenyInternal(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() == 0) goto L16;
        long r101 = TypeUtils.fnv1a_64(r100);
        long[] r102 = this.internalDenyHashCodes;
        if (r102 != null) goto L11;
        this.internalDenyHashCodes = new long[]{r101};
        return;
    L11:
        if (Arrays.binarySearch(r102, r101) < 0) goto L13;
        return;
    L13:
        long[] r103 = this.internalDenyHashCodes;
        int r104 = r103.length + 1;
        long[] r105 = new long[r104];
        r105[r104 - 1] = r101;
        System.arraycopy(r103, 0, r105, 0, r103.length);
        Arrays.sort(r105);
        this.internalDenyHashCodes = r105;
        return;
    }

    public Class<?> checkAutoType(Class r100) {
        if (get(r100) == null) goto L6;
        return r100;
    L6:
        return checkAutoType(r100.getName(), null, JSON.DEFAULT_PARSER_FEATURE);
    }

    public void configFromPropety(Properties r100) {
        addItemsToDeny(splitItemsFormProperty(r100.getProperty(DENY_PROPERTY)));
        addItemsToAccept(splitItemsFormProperty(r100.getProperty(AUTOTYPE_ACCEPT)));
        String r101 = r100.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
        if ("true".equals(r101) == false) goto L6;
        this.autoTypeSupport = true;
        return;
    L6:
        if ("false".equals(r101) == false) goto L10;
        this.autoTypeSupport = false;
        return;
    }

    public ObjectDeserializer get(Type r100) {
        Type r101 = JSON.getMixInAnnotations(r100);
        if (r101 == null) goto L5;
        IdentityHashMap<Type, ObjectDeserializer> r102 = this.mixInDeserializers.get(r100);
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.get(r101);
    L5:
        return this.deserializers.get(r100);
    }

    public ObjectDeserializer getDeserializer(Type r100) {
        ObjectDeserializer r101 = get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        if ((r100 instanceof Class) == false) goto L10;
        return getDeserializer((Class) r100, r100);
    L10:
        if ((r100 instanceof ParameterizedType) == false) goto L18;
        Type r102 = ((ParameterizedType) r100).getRawType();
        if ((r102 instanceof Class) == false) goto L16;
        return getDeserializer((Class) r102, r100);
    L16:
        return getDeserializer(r102);
    L18:
        if ((r100 instanceof WildcardType) == false) goto L24;
        Type[] r103 = ((WildcardType) r100).getUpperBounds();
        if (r103.length != 1) goto L24;
        return getDeserializer(r103[0]);
    L24:
        return JavaObjectDeserializer.instance;
    }

    public ObjectDeserializer getEnumDeserializer(Class<?> r100) {
        return new EnumDeserializer(r100);
    }

    public void initJavaBeanDeserializers(Class<?>... r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L11;
        Class<?> r103 = r100[r102];
        if (r103 == null) goto L10;
        putDeserializer(r103, createJavaBeanDeserializer(r103, r103));
    L10:
        r102 = r102 + 1;
        goto L5
    }

    public boolean isPrimitive(Class<?> r100) {
        return isPrimitive2(r100);
    }

    public void register(Module r100) {
        this.modules.add(r100);
    }

    public void setAsmEnable(boolean r100) {
        this.asmEnable = r100;
    }

    public void setAutoTypeSupport(boolean r100) {
        this.autoTypeSupport = r100;
    }

    public void setDefaultClassLoader(ClassLoader r100) {
        this.defaultClassLoader = r100;
    }

    public void setJacksonCompatible(boolean r100) {
        this.jacksonCompatible = r100;
    }

    public void setSafeMode(boolean r100) {
        this.safeMode = r100;
    }

    public ParserConfig(ClassLoader r100) {
        this(null, r100, false);
    }

    public ObjectDeserializer getDeserializer(FieldInfo r100) {
        return getDeserializer(r100.fieldClass, r100.fieldType);
    }

    public ParserConfig(boolean r100) {
        this(null, null, r100);
    }

    private static Method getEnumCreator(Class r100, Class r101) {
        Method[] r102 = r100.getMethods();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        Method r105 = r102[r104];
        if (Modifier.isStatic(r105.getModifiers()) == false) goto L13;
        if (r105.getReturnType() != r101) goto L13;
        if (r105.getParameterTypes().length != 1) goto L13;
        if (((JSONCreator) r105.getAnnotation(JSONCreator.class)) == null) goto L13;
        return r105;
    L13:
        r104 = r104 + 1;
        goto L3
    L14:
        return null;
    }

    public static Field getFieldFromCache(String r100, Map<String, Field> r101) {
        Field r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = r101.get("_" + r100);
    L5:
        if (r102 != null) goto L7;
        r102 = r101.get("m_" + r100);
    L7:
        if (r102 != null) goto L31;
        char r103 = r100.charAt(0);
        if (r103 < 'a') goto L13;
        if (r103 > 'z') goto L13;
        char[] r104 = r100.toCharArray();
        r104[0] = (char) (r104[0] - ' ');
        r102 = r101.get(new String(r104));
    L13:
        if (r100.length() <= 2) goto L32;
        char r105 = r100.charAt(1);
        if (r103 < 'a') goto L33;
        if (r103 <= 'z') goto L18;
        return r102;
    L18:
        if (r105 >= 'A') goto L20;
        return r102;
    L20:
        if (r105 > 'Z') goto L36;
        Iterator<Map.Entry<String, Field>> r106 = r101.entrySet().iterator();
    L23:
        if (r106.hasNext() == false) goto L37;
        Map.Entry<String, Field> r107 = r106.next();
        if (r100.equalsIgnoreCase(r107.getKey()) == false) goto L23;
        return r107.getValue();
    L37:
        return r102;
    L36:
        return r102;
    L33:
        return r102;
    L32:
        return r102;
    L31:
        return r102;
    }

    public static void parserAllFieldToCache(Class<?> r100, Map<String, Field> r101) {
        Field[] r102 = r100.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        Field r105 = r102[r104];
        String r106 = r105.getName();
        if (r101.containsKey(r106) == true) goto L7;
        r101.put(r106, r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L9:
        if (r100.getSuperclass() != null) goto L11;
        return;
    L11:
        if (r100.getSuperclass() == Object.class) goto L18;
        parserAllFieldToCache(r100.getSuperclass(), r101);
        return;
    }

    public Class<?> checkAutoType(String r100, Class<?> r101) {
        return checkAutoType(r100, r101, JSON.DEFAULT_PARSER_FEATURE);
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> r110, Type r111) {
        boolean r100 = this.asmEnable & (!this.fieldBased);
        boolean r101 = false;
        if (r100 == false) goto L30;
        JSONType r102 = (JSONType) TypeUtils.getAnnotation(r110, JSONType.class);
        if (r102 == null) goto L19;
        Class<?> r103 = r102.deserializer();
        if (r103 == Void.class) goto L14;
        Object r104 = r103.newInstance();     // Catch: Throwable -> L12
        if ((r104 instanceof ObjectDeserializer) == false) goto L14;
        return (ObjectDeserializer) r104;
    L14:
        if (r102.asm() == true) goto L16;
    L18:
        r100 = false;
        goto L19
    L16:
        if (r102.parseFeatures().length != 0) goto L18;
        r100 = true;
    L19:
        if (r100 == false) goto L30;
        Class<?> r105 = JavaBeanInfo.getBuilderClass(r110, r102);
        if (r105 != null) goto L24;
        r105 = r110;
    L24:
        if (Modifier.isPublic(r105.getModifiers()) == false) goto L25;
        r105 = r105.getSuperclass();
        if (r105 == Object.class) goto L30;
        if (r105 != null) goto L24;
    L25:
        r100 = false;
    L30:
        if (r110.getTypeParameters().length == 0) goto L32;
        r100 = false;
    L32:
        if (r100 == false) goto L38;
        ASMDeserializerFactory r106 = this.asmFactory;
        if (r106 == null) goto L38;
        if (r106.classLoader.isExternalClass(r110) == false) goto L38;
        r100 = false;
    L38:
        if (r100 == false) goto L40;
        r100 = ASMUtils.checkName(r110.getSimpleName());
    L40:
        if (r100 == true) goto L42;
    L96:
        if (r100 == true) goto L98;
    L102:
        if (r100 == true) goto L104;
    L106:
        r101 = r100;
    L107:
        if (r101 == false) goto L109;
        JavaBeanInfo r107 = JavaBeanInfo.build(r110, r111, this.propertyNamingStrategy);
        return this.asmFactory.createJavaBeanDeserializer(this, r107);
    L113:
        e = move-exception;
        throw new JSONException("create asm deserializer error, ".concat(r110.getName()), e);
    L117:
        return new JavaBeanDeserializer(this, r107);
    L119:
        return new JavaBeanDeserializer(this, r110, r111);
    L109:
        return new JavaBeanDeserializer(this, r110, r111);
    L104:
        if (TypeUtils.isXmlField(r110) == false) goto L106;
    L98:
        if (r110.isMemberClass() == false) goto L102;
        if (Modifier.isStatic(r110.getModifiers()) == true) goto L102;
        r100 = false;
        goto L102
    L42:
        if (r110.isInterface() == false) goto L44;
        r100 = false;
    L44:
        JavaBeanInfo r108 = JavaBeanInfo.build(r110, r111, this.propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, this.jacksonCompatible);
        if (r100 == true) goto L47;
    L49:
        Constructor<?> r109 = r108.defaultConstructor;
        if (r100 == false) goto L55;
        if (r109 != null) goto L55;
        if (r110.isInterface() == true) goto L55;
        r100 = false;
    L55:
        FieldInfo[] r112 = r108.fields;
        int r113 = r112.length;
        int r114 = 0;
    L56:
        if (r114 >= r113) goto L96;
        FieldInfo r115 = r112[r114];
        if (r115.getOnly == true) goto L59;
        Class<?> r116 = r115.fieldClass;
        if (Modifier.isPublic(r116.getModifiers()) == false) goto L59;
        if (r116.isMemberClass() == false) goto L69;
        if (Modifier.isStatic(r116.getModifiers()) == false) goto L59;
    L69:
        if (r115.getMember() != null) goto L71;
    L73:
        JSONField r117 = r115.getAnnotation();
        if (r117 != null) goto L76;
    L85:
        Method r118 = r115.method;
        if (r118 == null) goto L91;
        if (r118.getParameterTypes().length > 1) goto L59;
    L91:
        if (r116.isEnum() == false) goto L95;
        if ((getDeserializer(r116) instanceof EnumDeserializer) == false) goto L59;
    L95:
        r114 = r114 + 1;
        goto L56
    L76:
        if (ASMUtils.checkName(r117.name()) == false) goto L59;
        if (r117.format().length() != 0) goto L59;
        if (r117.deserializeUsing() != Void.class) goto L59;
        if (r117.parseFeatures().length != 0) goto L59;
        if (r117.unwrapped() == true) goto L59;
    L71:
        if (ASMUtils.checkName(r115.getMember().getName()) == true) goto L73;
    L59:
        r100 = false;
        goto L96
    L47:
        if (r108.fields.length <= 200) goto L49;
        r100 = false;
        goto L49
    }

    public ObjectDeserializer getDeserializer(Class<?> r210, Type r211) {
        Type r100 = r211;
        ObjectDeserializer r101 = get(r100);
        if (r101 == null) goto L5;
    L7:
        if (r101 == null) goto L9;
        return r101;
    L9:
        if (r100 != null) goto L11;
        r100 = r210;
    L11:
        ObjectDeserializer r102 = get(r100);
        if (r102 == null) goto L14;
        return r102;
    L14:
        JSONType r103 = (JSONType) TypeUtils.getAnnotation(r210, JSONType.class);
        if (r103 == null) goto L21;
        Class<?> r104 = r103.mappingTo();
        if (r104 == Void.class) goto L21;
        return getDeserializer(r104, r104);
    L21:
        if ((r100 instanceof WildcardType) == false) goto L23;
    L26:
        r102 = get(r210);
    L27:
        if (r102 == null) goto L29;
        return r102;
    L29:
        Iterator<Module> r105 = this.modules.iterator();
    L31:
        if (r105.hasNext() == false) goto L36;
        r102 = r105.next().createDeserializer(this, r210);
        if (r102 == null) goto L31;
        putDeserializer(r100, r102);
        return r102;
    L36:
        String r106 = r210.getName().replace(Typography.dollar, '.');
        int r107 = 0;
        if (r106.startsWith("java.awt.") == false) goto L52;
        if (AwtCodec.support(r210) == false) goto L52;
        if (awtError == true) goto L52;
        String[] r108 = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
        int r109 = 0;
    L43:
        if (r109 >= 4) goto L50;
        String r110 = r108[r109];     // Catch: Throwable -> L49
        if (r110.equals(r106) == true) goto L46;
        r109 = r109 + 1;
        goto L43
    L46:
        Type r111 = INVOKESTATIC_com_alibaba_fastjson_parser_ParserConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r110);     // Catch: Throwable -> L49
        ObjectDeserializer r112 = AwtCodec.instance;     // Catch: Throwable -> L49
        putDeserializer(r111, r112);     // Catch: Throwable -> L49
        return r112;
    L49:
        awtError = true;
    L50:
        r102 = AwtCodec.instance;
    L52:
        if (jdk8Error == true) goto L74;
    L72:
        jdk8Error = true;
        goto L74
    L54:
        if (r106.startsWith("java.time.") == false) goto L64;
        String[] r113 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};     // Catch: Throwable -> L72
        int r114 = 0;
    L57:
        if (r114 >= 12) goto L74;
        String r115 = r113[r114];     // Catch: Throwable -> L72
        if (r115.equals(r106) == true) goto L60;
        r114 = r114 + 1;     // Catch: Throwable -> L72
        goto L57
    L60:
        Type r116 = INVOKESTATIC_com_alibaba_fastjson_parser_ParserConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r115);     // Catch: Throwable -> L72
        ObjectDeserializer r117 = Jdk8DateCodec.instance;     // Catch: Throwable -> L72
        putDeserializer(r116, r117);     // Catch: Throwable -> L72
        return r117;
    L64:
        if (r106.startsWith("java.util.Optional") == false) goto L74;
        String[] r118 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};     // Catch: Throwable -> L72
        int r119 = 0;
    L66:
        if (r119 >= 4) goto L74;
        String r120 = r118[r119];     // Catch: Throwable -> L72
        if (r120.equals(r106) == true) goto L69;
        r119 = r119 + 1;
        goto L66
    L69:
        Type r121 = INVOKESTATIC_com_alibaba_fastjson_parser_ParserConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r120);     // Catch: Throwable -> L72
        ObjectDeserializer r122 = OptionalCodec.instance;     // Catch: Throwable -> L72
        putDeserializer(r121, r122);     // Catch: Throwable -> L72
        return r122;
    L74:
        if (jodaError == true) goto L87;
    L85:
        jodaError = true;
        goto L87
    L76:
        if (r106.startsWith("org.joda.time.") == false) goto L87;
        String[] r123 = {"org.joda.time.DateTime", "org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.format.DateTimeFormatter"};     // Catch: Throwable -> L85
        int r124 = 0;
    L79:
        if (r124 >= 9) goto L87;
        String r125 = r123[r124];     // Catch: Throwable -> L85
        if (r125.equals(r106) == true) goto L82;
        r124 = r124 + 1;
        goto L79
    L82:
        Type r126 = INVOKESTATIC_com_alibaba_fastjson_parser_ParserConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r125);     // Catch: Throwable -> L85
        r102 = JodaCodec.instance;     // Catch: Throwable -> L85
        putDeserializer(r126, r102);     // Catch: Throwable -> L85
        return r102;
    L87:
        if (guavaError == true) goto L100;
        if (r106.startsWith("com.google.common.collect.") == false) goto L100;
        String[] r127 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};     // Catch: ClassNotFoundException -> L98
        int r128 = 0;
    L92:
        if (r128 >= 5) goto L100;
        String r129 = r127[r128];     // Catch: ClassNotFoundException -> L98
        if (r129.equals(r106) == true) goto L95;
        r128 = r128 + 1;
        goto L92
    L95:
        Type r130 = INVOKESTATIC_com_alibaba_fastjson_parser_ParserConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r129);     // Catch: ClassNotFoundException -> L98
        r102 = GuavaCodec.instance;     // Catch: ClassNotFoundException -> L98
        putDeserializer(r130, r102);     // Catch: ClassNotFoundException -> L98
        return r102;
    L98:
        guavaError = true;
    L100:
        if (r106.equals("java.nio.ByteBuffer") == false) goto L103;
        r102 = ByteBufferCodec.instance;
        putDeserializer(r210, r102);
    L103:
        if (r106.equals("java.nio.file.Path") == false) goto L106;
        r102 = MiscCodec.instance;
        putDeserializer(r210, r102);
    L106:
        if (r210 != Map.Entry.class) goto L109;
        r102 = MiscCodec.instance;
        putDeserializer(r210, r102);
    L109:
        if (r106.equals("org.javamoney.moneta.Money") == false) goto L196;
        r102 = MonetaCodec.instance;
        putDeserializer(r210, r102);
    L196:
        Iterator r131 = ServiceLoader.load(AutowiredObjectDeserializer.class, ThreadMethodProxy.currentThread().getContextClassLoader()).iterator();     // Catch: Exception -> L120
    L114:
        if (r131.hasNext() == false) goto L121;
        AutowiredObjectDeserializer r132 = (AutowiredObjectDeserializer) r131.next();     // Catch: Exception -> L120
        Iterator<Type> r133 = r132.getAutowiredFor().iterator();     // Catch: Exception -> L120
    L117:
        if (r133.hasNext() == false) goto L114;
        putDeserializer(r133.next(), r132);     // Catch: Exception -> L120
    L121:
        if (r102 != null) goto L123;
        r102 = get(r100);
    L123:
        if (r102 == null) goto L126;
        return r102;
    L126:
        if (r210.isEnum() == false) goto L158;
        if (this.jacksonCompatible == false) goto L136;
        Method[] r134 = r210.getMethods();
        int r135 = r134.length;
    L130:
        if (r107 >= r135) goto L136;
        if (TypeUtils.isJacksonCreator(r134[r107]) == true) goto L133;
        r107 = r107 + 1;
        goto L130
    L133:
        ObjectDeserializer r136 = createJavaBeanDeserializer(r210, r100);
        putDeserializer(r100, r136);
        return r136;
    L136:
        Class<?> r137 = (Class) JSON.getMixInAnnotations(r210);
        if (r137 == null) goto L139;
        Class<?> r138 = r137;
    L140:
        JSONType r139 = (JSONType) TypeUtils.getAnnotation(r138, JSONType.class);
        if (r139 != null) goto L203;
    L146:
        if (r137 == null) goto L152;
        Method r140 = getEnumCreator(r137, r210);
        if (r140 != null) goto L201;
    L151:
        Method r141 = null;
    L153:
        if (r141 == null) goto L156;
        ObjectDeserializer r142 = new EnumCreatorDeserializer(r141);
        putDeserializer(r210, r142);
        return r142;
    L156:
        ObjectDeserializer r143 = getEnumDeserializer(r210);
    L189:
        putDeserializer(r100, r143);
        return r143;
    L201:
        r141 = r210.getMethod(r140.getName(), r140.getParameterTypes());     // Catch: Exception -> L191
    L152:
        r141 = getEnumCreator(r210, r210);
        goto L153
    L203:
        ObjectDeserializer r144 = (ObjectDeserializer) r139.deserializer().newInstance();     // Catch: Throwable -> L145
        putDeserializer(r210, r144);     // Catch: Throwable -> L145
        return r144;
    L139:
        r138 = r210;
        goto L140
    L158:
        if (r210.isArray() == false) goto L161;
        r143 = ObjectArrayCodec.instance;
        goto L189
    L161:
        if (r210 != Set.class) goto L163;
    L188:
        r143 = CollectionCodec.instance;
        goto L189
    L163:
        if (r210 == HashSet.class) goto L188;
        if (r210 == Collection.class) goto L188;
        if (r210 == List.class) goto L188;
        if (r210 == ArrayList.class) goto L188;
        if (Collection.class.isAssignableFrom(r210) == false) goto L175;
        r143 = CollectionCodec.instance;
        goto L189
    L175:
        if (Map.class.isAssignableFrom(r210) == false) goto L178;
        r143 = MapDeserializer.instance;
        goto L189
    L178:
        if (Throwable.class.isAssignableFrom(r210) == false) goto L182;
        ObjectDeserializer r145 = new ThrowableDeserializer(this, r210);
    L180:
        r143 = r145;
        goto L189
    L182:
        if (PropertyProcessable.class.isAssignableFrom(r210) == false) goto L185;
        r145 = new PropertyProcessableDeserializer(r210);
        goto L180
    L185:
        if (r210 != InetAddress.class) goto L187;
        r143 = MiscCodec.instance;
        goto L189
    L187:
        r143 = createJavaBeanDeserializer(r210, r100);
        goto L189
    L23:
        if ((r100 instanceof TypeVariable) == true) goto L26;
        if ((r100 instanceof ParameterizedType) == false) goto L27;
    L5:
        if ((r100 instanceof ParameterizedTypeImpl) == false) goto L7;
        r101 = get(TypeReference.intern((ParameterizedTypeImpl) r100));
        goto L7
    }

    public void putDeserializer(Type r100, ObjectDeserializer r101) {
        Type r102 = JSON.getMixInAnnotations(r100);
        if (r102 == null) goto L8;
        IdentityHashMap<Type, ObjectDeserializer> r103 = this.mixInDeserializers.get(r100);
        if (r103 != null) goto L7;
        r103 = new IdentityHashMap(4);
        this.mixInDeserializers.put(r100, r103);
    L7:
        r103.put(r102, r101);
        return;
    L8:
        this.deserializers.put(r100, r101);
    }

    public void register(String r100, Class r101) {
        this.typeMapping.putIfAbsent(r100, r101);
    }

    private ParserConfig(ASMDeserializerFactory r100, ClassLoader r101, boolean r102) {
        this.deserializers = new IdentityHashMap();
        this.mixInDeserializers = new IdentityHashMap(16);
        this.typeMapping = new ConcurrentHashMap(16, 0.75f, 1);
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.jacksonCompatible = false;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.modules = new ArrayList();
        this.safeMode = SAFE_MODE;
        this.denyHashCodes = new long[]{-9164606388214699518L, -8754006975464705441L, -8720046426850100497L, -8649961213709896794L, -8614556368991373401L, -8382625455832334425L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6088208984980396913L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4733542790109620528L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, TypeUtils.fnv1a_64_magic_hashcode, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1800035667138631116L, -1650485814983027158L, -1589194880214235129L, -1363634950764737555L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -803541446955902575L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 860052378298585747L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1268707909007641340L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3058452313624178956L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3740226159580918099L, 3794316665763266033L, 3977090344859527316L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4215053018660518963L, 4241163808635564644L, 4254584350247334433L, 4319304524795015394L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5120543992130540564L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5916409771425455946L, 5944107969236155580L, 6007332606592876737L, 6090377589998869205L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7164889056054194741L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8711531061028787095L, 8735538376409180149L, 8838294710098435315L, 8861402923078831179L, 9140390920032557669L, 9140416208800006522L, 9144212112462101475L};
        long[] r103 = new long[AUTO_TYPE_ACCEPT_LIST.length];
        int r104 = 0;
    L3:
        String[] r105 = AUTO_TYPE_ACCEPT_LIST;
        if (r104 >= r105.length) goto L6;
        r103[r104] = TypeUtils.fnv1a_64(r105[r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        Arrays.sort(r103);
        this.acceptHashCodes = r103;
        this.initDeserializersWithJavaSql = new AnonymousClass1(this);
        this.fieldBased = r102;
        if (r100 == null) goto L9;
    L15:
        this.asmFactory = r100;
        if (r100 != null) goto L18;
        this.asmEnable = false;
    L18:
        initDeserializers();
        addItemsToDeny(DENYS);
        addItemsToDeny0(DENYS_INTERNAL);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
        return;
    L9:
        if (ASMUtils.IS_ANDROID == true) goto L15;
        if (r101 != null) goto L13;
        r100 = new ASMDeserializerFactory(new ASMClassLoader());     // Catch: Throwable -> L14
    L20:
        goto L15
    L13:
        r100 = new ASMDeserializerFactory(r101);     // Catch: Throwable -> L14
        goto L20
    }

    public Class<?> checkAutoType(String r100, Class<?> r101, int r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.autoTypeCheckHandlers == null) goto L14;
        Iterator<AutoTypeCheckHandler> r103 = this.autoTypeCheckHandlers.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Class<?> r104 = r103.next().handler(r100, r101, r102);
        if (r104 == null) goto L9;
        return r104;
    L14:
        throw new JSONException("safeMode not support autoType : ".concat(r100));
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig r100, JavaBeanInfo r101, FieldInfo r102) {
        Class<?> r103 = r101.clazz;
        Class<?> r104 = r102.fieldClass;
        JSONField r105 = r102.getAnnotation();
        Class<?> r106 = null;
        if (r105 == null) goto L8;
        Class<?> r107 = r105.deserializeUsing();
        if (r107 == Void.class) goto L8;
        r106 = r107;
    L8:
        if (r106 != null) goto L16;
        if (r104 == List.class) goto L14;
        if (r104 != ArrayList.class) goto L16;
    L14:
        return new ArrayListTypeFieldDeserializer(r100, r103, r102);
    L16:
        return new DefaultFieldDeserializer(r100, r103, r102);
    }
}
