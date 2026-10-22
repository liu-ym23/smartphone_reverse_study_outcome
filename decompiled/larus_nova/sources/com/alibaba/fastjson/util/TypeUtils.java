package com.alibaba.fastjson.util;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sdk.m.u.i;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.vivo.push.PushClientConstants;
import el9.a;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class TypeUtils {
    private static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = null;
    private static Object OPTIONAL_EMPTY = null;
    private static boolean OPTIONAL_ERROR = false;
    private static Function<Map<String, Class<?>>, Void> addBaseClassMappingsFunction = null;
    private static BiFunction<Object, Class, Object> castFunction = null;
    private static Function<Object, Object> castToSqlDateFunction = null;
    private static Function<Object, Object> castToSqlTimeFunction = null;
    public static Function<Object, Object> castToTimestampFunction = null;
    private static volatile boolean classXmlAccessorType_error = false;
    private static Class<? extends Annotation> class_JacksonCreator = null;
    private static boolean class_JacksonCreator_error = false;
    private static Class<? extends Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static volatile Class class_XmlAccessType = null;
    private static volatile Class class_XmlAccessorType = null;
    private static Class class_deque = null;
    public static boolean compatibleWithFieldName = false;
    public static boolean compatibleWithJavaBean = false;
    private static volatile Field field_XmlAccessType_FIELD = null;
    private static volatile Object field_XmlAccessType_FIELD_VALUE = null;
    public static final long fnv1a_64_magic_hashcode = -3750763034362895579L;
    public static final long fnv1a_64_magic_prime = 1099511628211L;
    private static Function<Class, Boolean> isClobFunction;
    private static final Set<String> isProxyClassNames = null;
    private static volatile Map<Class, String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile Constructor kotlin_kclass_constructor;
    private static volatile Method kotlin_kclass_getConstructors;
    private static volatile Method kotlin_kfunction_getParameters;
    private static volatile Method kotlin_kparameter_getName;
    private static volatile Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static ConcurrentMap<String, Class<?>> mappings;
    private static Method method_HibernateIsInitialized;
    private static boolean method_HibernateIsInitialized_error;
    private static volatile Method method_XmlAccessorType_value;
    private static Class<?> optionalClass;
    private static boolean optionalClassInited;
    private static Method oracleDateMethod;
    private static boolean oracleDateMethodInited;
    private static Method oracleTimestampMethod;
    private static boolean oracleTimestampMethodInited;
    private static Class<?> pathClass;
    private static boolean pathClass_error;
    private static final Map primitiveTypeMap = null;
    private static boolean setAccessibleEnable;
    private static Class<? extends Annotation> transientClass;
    private static boolean transientClassInited;

    public static class MethodInheritanceComparator implements Comparator<Method> {
        public MethodInheritanceComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Method r100, Method r101) {
            int r102 = r100.getName().compareTo(r101.getName());
            if (r102 == 0) goto L5;
            return r102;
        L5:
            Class<?> r103 = r100.getReturnType();
            Class<?> r104 = r101.getReturnType();
            if (r103.equals(r104) == false) goto L9;
            return 0;
        L9:
            if (r103.isAssignableFrom(r104) == false) goto L13;
            return -1;
        L13:
            if (r104.isAssignableFrom(r103) == false) goto L16;
            return 1;
        L16:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Method r100, Method r101) {
            return compare2(r100, r101);
        }
    }

    public TypeUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int num(char r100, char r101) {
        if (r100 >= '0') goto L5;
        return -1;
    L5:
        if (r100 > '9') goto L12;
        if (r101 < '0') goto L13;
        if (r101 <= '9') goto L9;
        return -1;
    L9:
        return ((r100 - '0') * 10) + (r101 - '0');
    L13:
        return -1;
    L12:
        return -1;
    }

    public static int num(char r100, char r101, char r102, char r103) {
        if (r100 >= '0') goto L5;
        return -1;
    L5:
        if (r100 > '9') goto L16;
        if (r101 < '0') goto L17;
        if (r101 > '9') goto L18;
        if (r102 < '0') goto L19;
        if (r102 > '9') goto L20;
        if (r103 < '0') goto L21;
        if (r103 <= '9') goto L13;
        return -1;
    L13:
        return ((((r100 - '0') * 1000) + ((r101 - '0') * 100)) + ((r102 - '0') * 10)) + (r103 - '0');
    L21:
        return -1;
    L20:
        return -1;
    L19:
        return -1;
    L18:
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    public static int num(char r100, char r101, char r102, char r103, char r104, char r105, char r106, char r107, char r110) {
        if (r100 >= '0') goto L5;
        return -1;
    L5:
        if (r100 > '9') goto L26;
        if (r101 < '0') goto L27;
        if (r101 > '9') goto L28;
        if (r102 < '0') goto L29;
        if (r102 > '9') goto L30;
        if (r103 < '0') goto L31;
        if (r103 > '9') goto L32;
        if (r104 < '0') goto L33;
        if (r104 > '9') goto L34;
        if (r105 < '0') goto L35;
        if (r105 > '9') goto L36;
        if (r106 < '0') goto L37;
        if (r106 > '9') goto L38;
        if (r107 < '0') goto L39;
        if (r107 > '9') goto L40;
        if (r110 < '0') goto L41;
        if (r110 <= '9') goto L23;
        return -1;
    L23:
        return (((((((((r100 - '0') * 100000000) + ((r101 - '0') * 10000000)) + ((r102 - '0') * 1000000)) + ((r103 - '0') * 100000)) + ((r104 - '0') * 10000)) + ((r105 - '0') * 1000)) + ((r106 - '0') * 100)) + ((r107 - '0') * 10)) + (r110 - '0');
    L41:
        return -1;
    L40:
        return -1;
    L39:
        return -1;
    L38:
        return -1;
    L37:
        return -1;
    L36:
        return -1;
    L35:
        return -1;
    L34:
        return -1;
    L33:
        return -1;
    L32:
        return -1;
    L31:
        return -1;
    L30:
        return -1;
    L29:
        return -1;
    L28:
        return -1;
    L27:
        return -1;
    L26:
        return -1;
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put(ItemStyle.ITEM_STYLE_DOUBLE, Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        int r100 = 0;
        Class<?>[] r101 = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, java.util.IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, SimpleDateFormat.class, JSONObject.class, JSONPObject.class, JSONArray.class};
    L3:
        if (r100 >= 69) goto L9;
        Class<?> r102 = r101[r100];
        if (r102 == null) goto L8;
        mappings.put(r102.getName(), r102);
    L8:
        r100 = r100 + 1;
        goto L3
    L9:
        ModuleUtil.callWhenHasJavaSql(addBaseClassMappingsFunction, mappings);
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    static {
        NUMBER_WITH_TRAILING_ZEROS_PATTERN = PatternProtector.compile("\\.0*$");
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        setAccessibleEnable = true;
        oracleTimestampMethodInited = false;
        oracleDateMethodInited = false;
        optionalClassInited = false;
        transientClassInited = false;
        class_OneToMany = null;
        class_OneToMany_error = false;
        class_ManyToMany = null;
        class_ManyToMany_error = false;
        method_HibernateIsInitialized = null;
        method_HibernateIsInitialized_error = false;
        mappings = new ConcurrentHashMap(256, 0.75f, 1);
        pathClass_error = false;
        class_JacksonCreator = null;
        class_JacksonCreator_error = false;
        class_XmlAccessType = null;
        class_XmlAccessorType = null;
        classXmlAccessorType_error = false;
        method_XmlAccessorType_value = null;
        field_XmlAccessType_FIELD = null;
        field_XmlAccessType_FIELD_VALUE = null;
        class_deque = null;
        compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));     // Catch: Throwable -> L7
        compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));     // Catch: Throwable -> L7
    L9:
        class_deque = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.util.Deque");     // Catch: Throwable -> L8
    L5:
        isClobFunction = new AnonymousClass1();
        castToSqlDateFunction = new AnonymousClass2();
        castToSqlTimeFunction = new AnonymousClass3();
        castToTimestampFunction = new AnonymousClass4();
        castFunction = new AnonymousClass5();
        addBaseClassMappingsFunction = new AnonymousClass6();
        addBaseClassMappings();
        final int r100 = 8;
        primitiveTypeMap = new AnonymousClass7(r100);
        final int r101 = 6;
        isProxyClassNames = new AnonymousClass8(r101);
        OPTIONAL_ERROR = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static byte byteValue(BigDecimal r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.scale();
        if (r101 < (-100)) goto L12;
        if (r101 > 100) goto L12;
        return r100.byteValue();
    L12:
        return r100.byteValueExact();
    }

    public static BigDecimal castToBigDecimal(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Float) == false) goto L13;
        Float r101 = (Float) r100;
        if (Float.isNaN(r101.floatValue()) == false) goto L10;
    L11:
        return null;
    L10:
        if (Float.isInfinite(r101.floatValue()) == true) goto L11;
    L32:
        String r102 = r100.toString();
        if (r102.length() != 0) goto L35;
    L43:
        return null;
    L35:
        if (r102.equalsIgnoreCase("null") == true) goto L43;
        if (r102.length() > 65535) goto L42;
        return new BigDecimal(r102);
    L42:
        throw new JSONException("decimal overflow");
    L13:
        if ((r100 instanceof Double) == false) goto L20;
        Double r103 = (Double) r100;
        if (Double.isNaN(r103.doubleValue()) == false) goto L17;
    L18:
        return null;
    L17:
        if (Double.isInfinite(r103.doubleValue()) == false) goto L32;
    L20:
        if ((r100 instanceof BigDecimal) == false) goto L24;
        return (BigDecimal) r100;
    L24:
        if ((r100 instanceof BigInteger) == false) goto L28;
        return new BigDecimal((BigInteger) r100);
    L28:
        if ((r100 instanceof Map) == false) goto L32;
        if (((Map) r100).size() != 0) goto L32;
        return null;
    }

    public static BigInteger castToBigInteger(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Float) == false) goto L16;
        Float r101 = (Float) r100;
        if (Float.isNaN(r101.floatValue()) == false) goto L10;
    L14:
        return null;
    L10:
        if (Float.isInfinite(r101.floatValue()) == true) goto L14;
        return BigInteger.valueOf(r101.longValue());
    L16:
        if ((r100 instanceof Double) == false) goto L26;
        Double r102 = (Double) r100;
        if (Double.isNaN(r102.doubleValue()) == false) goto L20;
    L24:
        return null;
    L20:
        if (Double.isInfinite(r102.doubleValue()) == true) goto L24;
        return BigInteger.valueOf(r102.longValue());
    L26:
        if ((r100 instanceof BigInteger) == false) goto L30;
        return (BigInteger) r100;
    L30:
        if ((r100 instanceof BigDecimal) == false) goto L37;
        BigDecimal r103 = (BigDecimal) r100;
        int r104 = r103.scale();
        if (r104 <= (-1000)) goto L37;
        if (r104 >= 1000) goto L37;
        return r103.toBigInteger();
    L37:
        String r105 = r100.toString();
        if (r105.length() != 0) goto L40;
    L48:
        return null;
    L40:
        if (r105.equalsIgnoreCase("null") == true) goto L48;
        if (r105.length() > 65535) goto L47;
        return new BigInteger(r105);
    L47:
        throw new JSONException("decimal overflow");
    }

    public static Boolean castToBoolean(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Boolean) == true) goto L8;
        boolean r101 = false;
        if ((r100 instanceof BigDecimal) == false) goto L17;
        if (intValue((BigDecimal) r100) != 1) goto L15;
        r101 = true;
    L15:
        return Boolean.valueOf(r101);
    L17:
        if ((r100 instanceof Number) == false) goto L24;
        if (((Number) r100).intValue() != 1) goto L22;
        r101 = true;
    L22:
        return Boolean.valueOf(r101);
    L24:
        if ((r100 instanceof String) == false) goto L61;
        String r102 = (String) r100;
        if (r102.length() != 0) goto L28;
    L59:
        return null;
    L28:
        if ("null".equals(r102) == true) goto L59;
        if ("NULL".equals(r102) == true) goto L59;
        if ("true".equalsIgnoreCase(r102) == true) goto L58;
        if ("1".equals(r102) == true) goto L58;
        if ("false".equalsIgnoreCase(r102) == true) goto L56;
        if ("0".equals(r102) == true) goto L56;
        if ("Y".equalsIgnoreCase(r102) == true) goto L54;
        if (ExifInterface.GPS_DIRECTION_TRUE.equals(r102) == true) goto L54;
        if (FaceService.girlLabel.equalsIgnoreCase(r102) == true) goto L52;
        if ("N".equals(r102) == false) goto L61;
    L52:
        return Boolean.FALSE;
    L54:
        return Boolean.TRUE;
    L56:
        return Boolean.FALSE;
    L58:
        return Boolean.TRUE;
    L61:
        throw new JSONException("can not cast to boolean, value : " + r100);
    L8:
        return (Boolean) r100;
    }

    public static Byte castToByte(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof BigDecimal) == false) goto L10;
        return Byte.valueOf(byteValue((BigDecimal) r100));
    L10:
        if ((r100 instanceof Number) == false) goto L14;
        return Byte.valueOf(((Number) r100).byteValue());
    L14:
        if ((r100 instanceof String) == false) goto L26;
        String r101 = (String) r100;
        if (r101.length() != 0) goto L18;
    L24:
        return null;
    L18:
        if ("null".equals(r101) == true) goto L24;
        if ("NULL".equals(r101) == true) goto L24;
        return Byte.valueOf(CastByteProtector.parseByte(r101));
    L26:
        if ((r100 instanceof Boolean) == false) goto L30;
        return Byte.valueOf(((Boolean) r100).booleanValue() ? 1 : 0);
    L30:
        throw new JSONException("can not cast to byte, value : " + r100);
    }

    public static byte[] castToBytes(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return (byte[]) r100;
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return IOUtils.decodeBase64((String) r100);
    L11:
        throw new JSONException("can not cast to byte[], value : " + r100);
    }

    public static Character castToChar(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Character) == false) goto L10;
        return (Character) r100;
    L10:
        if ((r100 instanceof String) == false) goto L21;
        String r101 = (String) r100;
        if (r101.length() != 0) goto L15;
        return null;
    L15:
        if (r101.length() != 1) goto L19;
        return Character.valueOf(r101.charAt(0));
    L19:
        throw new JSONException("can not cast to char, value : " + r100);
    L21:
        throw new JSONException("can not cast to char, value : " + r100);
    }

    public static Date castToDate(Object r100) {
        return castToDate(r100, null);
    }

    public static Double castToDouble(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Number) == false) goto L10;
        return Double.valueOf(((Number) r100).doubleValue());
    L10:
        if ((r100 instanceof String) == false) goto L25;
        String r101 = r100.toString();
        if (r101.length() != 0) goto L14;
    L23:
        return null;
    L14:
        if ("null".equals(r101) == true) goto L23;
        if ("NULL".equals(r101) == true) goto L23;
        if (r101.indexOf(44) == (-1)) goto L22;
        r101 = r101.replaceAll(",", "");
    L22:
        return Double.valueOf(CastDoubleProtector.parseDouble(r101));
    L25:
        if ((r100 instanceof Boolean) == false) goto L33;
        if (((Boolean) r100).booleanValue() == false) goto L29;
        double r102 = 1.0d;
    L31:
        return Double.valueOf(r102);
    L29:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L31
    L33:
        throw new JSONException("can not cast to double, value : " + r100);
    }

    public static Float castToFloat(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Number) == false) goto L10;
        return Float.valueOf(((Number) r100).floatValue());
    L10:
        if ((r100 instanceof String) == false) goto L25;
        String r101 = r100.toString();
        if (r101.length() != 0) goto L14;
    L23:
        return null;
    L14:
        if ("null".equals(r101) == true) goto L23;
        if ("NULL".equals(r101) == true) goto L23;
        if (r101.indexOf(44) == (-1)) goto L22;
        r101 = r101.replaceAll(",", "");
    L22:
        return Float.valueOf(CastFloatProtector.parseFloat(r101));
    L25:
        if ((r100 instanceof Boolean) == false) goto L33;
        if (((Boolean) r100).booleanValue() == false) goto L29;
        float r102 = 1.0f;
    L31:
        return Float.valueOf(r102);
    L29:
        r102 = 0.0f;
        goto L31
    L33:
        throw new JSONException("can not cast to float, value : " + r100);
    }

    public static Integer castToInt(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Integer) == false) goto L10;
        return (Integer) r100;
    L10:
        if ((r100 instanceof BigDecimal) == false) goto L14;
        return Integer.valueOf(intValue((BigDecimal) r100));
    L14:
        if ((r100 instanceof Number) == false) goto L18;
        return Integer.valueOf(((Number) r100).intValue());
    L18:
        if ((r100 instanceof String) == false) goto L36;
        String r101 = (String) r100;
        if (r101.length() != 0) goto L22;
    L34:
        return null;
    L22:
        if ("null".equals(r101) == true) goto L34;
        if ("NULL".equals(r101) == true) goto L34;
        if (r101.indexOf(44) == (-1)) goto L29;
        r101 = r101.replaceAll(",", "");
    L29:
        Matcher r102 = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(r101);
        if (r102.find() == false) goto L33;
        r101 = r102.replaceAll("");
    L33:
        return Integer.valueOf(CastIntegerProtector.parseInt(r101));
    L36:
        if ((r100 instanceof Boolean) == false) goto L40;
        return Integer.valueOf(((Boolean) r100).booleanValue() ? 1 : 0);
    L40:
        if ((r100 instanceof Map) == false) goto L50;
        Map r103 = (Map) r100;
        if (r103.size() != 2) goto L50;
        if (r103.containsKey("andIncrement") == false) goto L50;
        if (r103.containsKey("andDecrement") == false) goto L50;
        Iterator r104 = r103.values().iterator();
        r104.next();
        return castToInt(r104.next());
    L50:
        throw new JSONException("can not cast to int, value : " + r100);
    }

    public static Long castToLong(Object r100) {
        Calendar r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof BigDecimal) == false) goto L10;
        return Long.valueOf(longValue((BigDecimal) r100));
    L10:
        if ((r100 instanceof Number) == false) goto L14;
        return Long.valueOf(((Number) r100).longValue());
    L14:
        if ((r100 instanceof String) == false) goto L36;
        String r102 = (String) r100;
        if (r102.length() != 0) goto L18;
    L34:
        return null;
    L18:
        if ("null".equals(r102) == true) goto L34;
        if ("NULL".equals(r102) == true) goto L34;
        if (r102.indexOf(44) == (-1)) goto L55;
        r102 = r102.replaceAll(",", "");
    L55:
        return Long.valueOf(CastLongProtector.parseLong(r102));
    L27:
        JSONScanner r103 = new JSONScanner(r102);
        if (r103.scanISO8601DateIfMatch(false) == false) goto L30;
        r101 = r103.getCalendar();
    L30:
        r103.close();
        if (r101 == null) goto L36;
        return Long.valueOf(r101.getTimeInMillis());
    L36:
        if ((r100 instanceof Map) == false) goto L46;
        Map r104 = (Map) r100;
        if (r104.size() != 2) goto L46;
        if (r104.containsKey("andIncrement") == false) goto L46;
        if (r104.containsKey("andDecrement") == false) goto L46;
        Iterator r105 = r104.values().iterator();
        r105.next();
        return castToLong(r105.next());
    L46:
        if ((r100 instanceof Boolean) == false) goto L54;
        if (((Boolean) r100).booleanValue() == false) goto L50;
        long r106 = 1;
    L52:
        return Long.valueOf(r106);
    L50:
        r106 = 0;
        goto L52
    L54:
        throw new JSONException("can not cast to long, value : " + r100);
    }

    public static Short castToShort(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof BigDecimal) == false) goto L10;
        return Short.valueOf(shortValue((BigDecimal) r100));
    L10:
        if ((r100 instanceof Number) == false) goto L14;
        return Short.valueOf(((Number) r100).shortValue());
    L14:
        if ((r100 instanceof String) == false) goto L26;
        String r101 = (String) r100;
        if (r101.length() != 0) goto L18;
    L24:
        return null;
    L18:
        if ("null".equals(r101) == true) goto L24;
        if ("NULL".equals(r101) == true) goto L24;
        return Short.valueOf(CastShortProtector.parseShort(r101));
    L26:
        if ((r100 instanceof Boolean) == false) goto L30;
        return Short.valueOf(((Boolean) r100).booleanValue() ? 1 : 0);
    L30:
        throw new JSONException("can not cast to short, value : " + r100);
    }

    public static Object castToSqlDate(Object r100) {
        return ModuleUtil.callWhenHasJavaSql(castToSqlDateFunction, r100);
    }

    public static Object castToSqlTime(Object r100) {
        return ModuleUtil.callWhenHasJavaSql(castToSqlTimeFunction, r100);
    }

    public static String castToString(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    public static Object castToTimestamp(Object r100) {
        return ModuleUtil.callWhenHasJavaSql(castToTimestampFunction, r100);
    }

    public static Type checkPrimitiveArray(GenericArrayType r100) {
        Type r101 = r100.getGenericComponentType();
        String r102 = "[";
    L4:
        if ((r101 instanceof GenericArrayType) == false) goto L7;
        r101 = ((GenericArrayType) r101).getGenericComponentType();
        r102 = r102 + r102;
        goto L4
    L7:
        if ((r101 instanceof Class) == false) goto L18;
        Class r103 = (Class) r101;
        if (r103.isPrimitive() == false) goto L19;
        String r104 = (String) primitiveTypeMap.get(r103);     // Catch: ClassNotFoundException -> L14
        if (r104 == null) goto L20;
        return INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102 + r104);
    L20:
        return r100;
    L21:
        return r100;
    L19:
        return r100;
    L18:
        return r100;
    }

    public static Collection createCollection(Type r100) {
        Class<?> r101 = getRawClass(r100);
        if (r101 == AbstractCollection.class) goto L39;
        if (r101 == Collection.class) goto L39;
        if (r101.isAssignableFrom(HashSet.class) == false) goto L11;
        return new HashSet();
    L11:
        if (r101.isAssignableFrom(LinkedHashSet.class) == false) goto L14;
        return new LinkedHashSet();
    L14:
        if (r101.isAssignableFrom(TreeSet.class) == false) goto L17;
        return new TreeSet();
    L17:
        if (r101.isAssignableFrom(ArrayList.class) == false) goto L20;
        return new ArrayList();
    L20:
        if (r101.isAssignableFrom(EnumSet.class) == false) goto L27;
        if ((r100 instanceof ParameterizedType) == false) goto L24;
        Type r102 = ((ParameterizedType) r100).getActualTypeArguments()[0];
    L46:
        return EnumSet.noneOf((Class) r102);
    L24:
        r102 = Object.class;
        goto L46
    L27:
        if (r101.isAssignableFrom(Queue.class) == true) goto L47;
        Class<?> r103 = class_deque;
        if (r103 != null) goto L31;
    L40:
        return (Collection) r101.newInstance();
    L36:
        throw new JSONException("create instance error, class ".concat(r101.getName()));
    L31:
        if (r101.isAssignableFrom(r103) == false) goto L40;
    L47:
        return new LinkedList();
    L39:
        return new ArrayList();
    }

    public static Set createSet(Type r100) {
        Class<?> r101 = getRawClass(r100);
        if (r101 == AbstractCollection.class) goto L28;
        if (r101 == Collection.class) goto L28;
        if (r101.isAssignableFrom(HashSet.class) == false) goto L11;
        return new HashSet();
    L11:
        if (r101.isAssignableFrom(LinkedHashSet.class) == false) goto L14;
        return new LinkedHashSet();
    L14:
        if (r101.isAssignableFrom(TreeSet.class) == false) goto L17;
        return new TreeSet();
    L17:
        if (r101.isAssignableFrom(EnumSet.class) == true) goto L19;
        return (Set) r101.newInstance();
    L26:
        throw new JSONException("create instance error, class ".concat(r101.getName()));
    L19:
        if ((r100 instanceof ParameterizedType) == false) goto L21;
        Type r102 = ((ParameterizedType) r100).getActualTypeArguments()[0];
    L34:
        return EnumSet.noneOf((Class) r102);
    L21:
        r102 = Object.class;
    L28:
        return new HashSet();
    }

    public static String decapitalize(String r100) {
        if (r100 != null) goto L4;
    L15:
        return r100;
    L4:
        if (r100.length() == 0) goto L15;
        if (r100.length() > 1) goto L9;
    L13:
        char[] r101 = r100.toCharArray();
        r101[0] = Character.toLowerCase(r101[0]);
        return new String(r101);
    L9:
        if (Character.isUpperCase(r100.charAt(1)) == false) goto L13;
        if (Character.isUpperCase(r100.charAt(0)) == false) goto L13;
        return r100;
    }

    public static long fnv1a_64(String r100) {
        long r101 = fnv1a_64_magic_hashcode;
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L6;
        r101 = (r101 ^ ((long) r100.charAt(r102))) * fnv1a_64_magic_prime;
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static long fnv1a_64_extract(String r100) {
        long r101 = fnv1a_64_magic_hashcode;
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L17;
        char r103 = r100.charAt(r102);
        if (r103 == '_') goto L16;
        if (r103 == '-') goto L16;
        if (r103 >= 'A') goto L13;
    L15:
        r101 = (r101 ^ ((long) r103)) * fnv1a_64_magic_prime;
        goto L16
    L13:
        if (r103 > 'Z') goto L15;
        r103 = (char) (r103 + ' ');
    L16:
        r102 = r102 + 1;
        goto L4
    L17:
        return r101;
    }

    public static long fnv1a_64_lower(String r100) {
        long r101 = fnv1a_64_magic_hashcode;
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L11;
        char r103 = r100.charAt(r102);
        if (r103 < 'A') goto L10;
        if (r103 > 'Z') goto L10;
        r103 = (char) (r103 + ' ');
    L10:
        r101 = (r101 ^ ((long) r103)) * fnv1a_64_magic_prime;
        r102 = r102 + 1;
        goto L4
    L11:
        return r101;
    }

    public static Class<?> getClass(Type r100) {
        if (r100.getClass() != Class.class) goto L7;
        return (Class) r100;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return getClass(((ParameterizedType) r100).getRawType());
    L11:
        if ((r100 instanceof TypeVariable) == false) goto L19;
        Type r101 = ((TypeVariable) r100).getBounds()[0];
        if ((r101 instanceof Class) == false) goto L17;
        return (Class) r101;
    L17:
        return getClass(r101);
    L19:
        if ((r100 instanceof WildcardType) == false) goto L24;
        Type[] r102 = ((WildcardType) r100).getUpperBounds();
        if (r102.length == 1) goto L23;
        return Object.class;
    L23:
        return getClass(r102[0]);
    L24:
        return Object.class;
    }

    public static Class<?> getClassFromMapping(String r100) {
        return mappings.get(r100);
    }

    public static Class<?> getCollectionItemClass(Type r100) {
        if ((r100 instanceof ParameterizedType) == false) goto L18;
        Type r101 = ((ParameterizedType) r100).getActualTypeArguments()[0];
        if ((r101 instanceof WildcardType) == false) goto L10;
        Type[] r102 = ((WildcardType) r101).getUpperBounds();
        if (r102.length != 1) goto L10;
        r101 = r102[0];
    L10:
        if ((r101 instanceof Class) == false) goto L17;
        Class<?> r103 = (Class) r101;
        if (Modifier.isPublic(r103.getModifiers()) == false) goto L15;
        return r103;
    L15:
        throw new JSONException("can not create ASMParser");
    L17:
        throw new JSONException("can not create ASMParser");
    L18:
        return Object.class;
    }

    private static Type getCollectionItemType(ParameterizedType r100) {
        Type r101 = r100.getRawType();
        Type[] r102 = r100.getActualTypeArguments();
        if (r101 == Collection.class) goto L5;
        Class r103 = (Class) r101;
        Map<TypeVariable, Type> r104 = createActualTypeMap(r103.getTypeParameters(), r102);
        Type r105 = getCollectionSuperType(r103);
        if ((r105 instanceof ParameterizedType) == false) goto L14;
        Class<?> r106 = getRawClass(r105);
        Type[] r107 = ((ParameterizedType) r105).getActualTypeArguments();
        if (r107.length <= 0) goto L12;
        return getCollectionItemType(makeParameterizedType(r106, r107, r104));
    L12:
        return getCollectionItemType(r106);
    L14:
        return getCollectionItemType((Class) r105);
    L5:
        return getWildcardTypeUpperBounds(r102[0]);
    }

    private static Type getCollectionSuperType(Class<?> r100) {
        Type[] r101 = r100.getGenericInterfaces();
        int r102 = r101.length;
        Type r103 = null;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L11;
        Type r105 = r101[r104];
        Class<?> r106 = getRawClass(r105);
        if (r106 == Collection.class) goto L6;
        if (Collection.class.isAssignableFrom(r106) == false) goto L10;
        r103 = r105;
    L10:
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L11:
        if (r103 == null) goto L13;
        return r103;
    L13:
        return r100.getGenericSuperclass();
    }

    public static Type getGenericParamType(Type r100) {
        if ((r100 instanceof ParameterizedType) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof Class) == true) goto L8;
        return r100;
    L8:
        return getGenericParamType(((Class) r100).getGenericSuperclass());
    }

    public static String[] getKoltinConstructorParameters(Class r100) {
        if (kotlin_kclass_constructor != null) goto L10;
        if (kotlin_class_klass_error == true) goto L10;
        kotlin_kclass_constructor = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(new Class[]{Class.class});     // Catch: Throwable -> L8
    L8:
        kotlin_class_klass_error = true;
    L10:
        if (kotlin_kclass_constructor != null) goto L13;
        return null;
    L13:
        if (kotlin_kclass_getConstructors != null) goto L20;
        if (kotlin_class_klass_error == true) goto L20;
        kotlin_kclass_getConstructors = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);     // Catch: Throwable -> L18
    L18:
        kotlin_class_klass_error = true;
    L20:
        if (kotlin_kfunction_getParameters != null) goto L27;
        if (kotlin_class_klass_error == true) goto L27;
        kotlin_kfunction_getParameters = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.reflect.KFunction").getMethod("getParameters", new Class[0]);     // Catch: Throwable -> L25
    L25:
        kotlin_class_klass_error = true;
    L27:
        if (kotlin_kparameter_getName != null) goto L34;
        if (kotlin_class_klass_error == true) goto L34;
        kotlin_kparameter_getName = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);     // Catch: Throwable -> L32
    L32:
        kotlin_class_klass_error = true;
    L34:
        if (kotlin_error == false) goto L57;
        return null;
    L57:
        Iterator r101 = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(new Object[]{r100}), new Object[0])).iterator();     // Catch: Throwable -> L54
        Object r102 = null;
    L38:
        if (r101.hasNext() == false) goto L46;
        Object r103 = r101.next();     // Catch: Throwable -> L54
        List r104 = (List) kotlin_kfunction_getParameters.invoke(r103, new Object[0]);     // Catch: Throwable -> L54
        if (r102 != null) goto L42;
    L44:
        r102 = r103;
    L45:
        r101.hasNext();     // Catch: Throwable -> L54
        goto L38
    L42:
        if (r104.size() != 0) goto L44;
    L46:
        if (r102 != null) goto L48;
        return null;
    L48:
        List r105 = (List) kotlin_kfunction_getParameters.invoke(r102, new Object[0]);     // Catch: Throwable -> L54
        String[] r106 = new String[r105.size()];     // Catch: Throwable -> L54
        int r107 = 0;
    L49:
        if (r107 >= r105.size()) goto L53;
        r106[r107] = (String) kotlin_kparameter_getName.invoke(ListProtector.get(r105, r107), new Object[0]);     // Catch: Throwable -> L54
        r107 = r107 + 1;
        goto L49
    L53:
        return r106;
    L54:
        th = move-exception;
        th.printStackTrace();
        kotlin_error = true;
        return null;
    }

    public static Constructor getKotlinConstructor(Constructor[] r100) {
        return getKotlinConstructor(r100, null);
    }

    public static Annotation[][] getParameterAnnotations(Constructor r110) {
        Annotation[][] r100 = r110.getParameterAnnotations();
        Type r101 = JSON.getMixInAnnotations(r110.getDeclaringClass());
        Constructor r102 = null;
        if ((r101 instanceof Class) == false) goto L5;
        Class r103 = (Class) r101;
    L6:
        if (r103 == null) goto L27;
        Class<?>[] r111 = r110.getParameterTypes();
        ArrayList r104 = new ArrayList(2);
        Class<?> r105 = r103.getEnclosingClass();
    L8:
        if (r105 == null) goto L10;
        r104.add(r105);
        r105 = r105.getEnclosingClass();
        goto L8
    L10:
        int r106 = r104.size();
        Class r107 = r103;
    L11:
        if (r107 == null) goto L22;
        if (r107 == Object.class) goto L22;
        if (r106 == 0) goto L19;
        Class<?>[] r108 = new Class[r111.length + r106];     // Catch: NoSuchMethodException -> L21
        System.arraycopy(r111, 0, r108, r106, r111.length);     // Catch: NoSuchMethodException -> L21
        int r109 = r106;
    L16:
        if (r109 <= 0) goto L18;
        int r112 = r109 - 1;     // Catch: NoSuchMethodException -> L21
        r108[r112] = (Class) ListProtector.get(r104, r112);     // Catch: NoSuchMethodException -> L21
        r109 = r109 - 1;     // Catch: NoSuchMethodException -> L21
        goto L16
    L18:
        Constructor r113 = r103.getDeclaredConstructor(r108);     // Catch: NoSuchMethodException -> L21
    L20:
        r102 = r113;
        goto L22
    L19:
        r113 = r103.getDeclaredConstructor(r111);     // Catch: NoSuchMethodException -> L21
    L21:
        r106 = r106 - 1;
        r107 = r107.getSuperclass();
    L22:
        if (r102 != null) goto L24;
        return r100;
    L24:
        Annotation[][] r114 = r102.getParameterAnnotations();
        if (r114 == null) goto L27;
        return r114;
    L27:
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public static int getParserFeatures(Class<?> r100) {
        JSONType r101 = (JSONType) getAnnotation(r100, JSONType.class);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return Feature.of(r101.parseFeatures());
    }

    public static String getPropertyNameByMethodName(String r100) {
        return Character.toLowerCase(r100.charAt(3)) + r100.substring(4);
    }

    public static Class<?> getRawClass(Type r100) {
        if ((r100 instanceof Class) == false) goto L7;
        return (Class) r100;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return getRawClass(((ParameterizedType) r100).getRawType());
    L11:
        if ((r100 instanceof WildcardType) == false) goto L19;
        Type[] r101 = ((WildcardType) r100).getUpperBounds();
        if (r101.length != 1) goto L17;
        return getRawClass(r101[0]);
    L17:
        throw new JSONException(AlarmSessionType.TODO);
    L19:
        throw new JSONException(AlarmSessionType.TODO);
    }

    public static int getSerializeFeatures(Class<?> r100) {
        JSONType r101 = (JSONType) getAnnotation(r100, JSONType.class);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return SerializerFeature.of(r101.serialzeFeatures());
    }

    private static Type getWildcardTypeUpperBounds(Type r100) {
        if ((r100 instanceof WildcardType) == false) goto L9;
        Type[] r101 = ((WildcardType) r100).getUpperBounds();
        if (r101.length > 0) goto L10;
        return Object.class;
    L10:
        return r101[0];
    L9:
        return r100;
    }

    public static Annotation getXmlAccessorType(Class r100) {
        if (class_XmlAccessorType != null) goto L10;
        if (classXmlAccessorType_error == true) goto L10;
        class_XmlAccessorType = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("javax.xml.bind.annotation.XmlAccessorType");     // Catch: Throwable -> L8
    L8:
        classXmlAccessorType_error = true;
    L10:
        if (class_XmlAccessorType != null) goto L14;
        return null;
    L14:
        return getAnnotation(r100, class_XmlAccessorType);
    }

    public static int intValue(BigDecimal r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.scale();
        if (r101 < (-100)) goto L12;
        if (r101 > 100) goto L12;
        return r100.intValue();
    L12:
        return r100.intValueExact();
    }

    public static boolean isAnnotationPresentManyToMany(Method r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (class_ManyToMany != null) goto L13;
        if (class_ManyToMany_error == true) goto L13;
        class_ManyToMany = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("javax.persistence.ManyToMany");     // Catch: Throwable -> L11
    L11:
        class_ManyToMany_error = true;
    L13:
        if (class_ManyToMany != null) goto L15;
        return false;
    L15:
        if (r100.isAnnotationPresent(class_OneToMany) == false) goto L17;
    L18:
        return true;
    L17:
        if (r100.isAnnotationPresent(class_ManyToMany) == true) goto L18;
        return false;
    }

    public static boolean isAnnotationPresentOneToMany(Method r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (class_OneToMany == null) goto L8;
    L12:
        Class<? extends Annotation> r101 = class_OneToMany;
        if (r101 != null) goto L15;
        return false;
    L15:
        if (r100.isAnnotationPresent(r101) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        if (class_OneToMany_error == true) goto L12;
        class_OneToMany = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("javax.persistence.OneToMany");     // Catch: Throwable -> L11
    L11:
        class_OneToMany_error = true;
        goto L12
    }

    public static boolean isClob(Class r100) {
        Boolean r101 = (Boolean) ModuleUtil.callWhenHasJavaSql(isClobFunction, r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }

    public static boolean isGenericParamType(Type r100) {
        if ((r100 instanceof ParameterizedType) == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof Class) == false) goto L14;
        Type r101 = ((Class) r100).getGenericSuperclass();
        if (r101 != Object.class) goto L10;
    L12:
        return false;
    L10:
        if (isGenericParamType(r101) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public static boolean isHibernateInitialized(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (method_HibernateIsInitialized == null) goto L8;
    L12:
        Method r101 = method_HibernateIsInitialized;
        if (r101 != null) goto L20;
    L16:
        return true;
    L20:
        return ((Boolean) r101.invoke(null, new Object[]{r100})).booleanValue();
    L8:
        if (method_HibernateIsInitialized_error == true) goto L12;
        method_HibernateIsInitialized = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("org.hibernate.Hibernate").getMethod("isInitialized", new Class[]{Object.class});     // Catch: Throwable -> L11
    L11:
        method_HibernateIsInitialized_error = true;
        goto L12
    }

    public static boolean isJacksonCreator(Method r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (class_JacksonCreator == null) goto L8;
    L12:
        Class<? extends Annotation> r101 = class_JacksonCreator;
        if (r101 != null) goto L15;
        return false;
    L15:
        if (r100.isAnnotationPresent(r101) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        if (class_JacksonCreator_error == true) goto L12;
        class_JacksonCreator = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.fasterxml.jackson.annotation.JsonCreator");     // Catch: Throwable -> L11
    L11:
        class_JacksonCreator_error = true;
        goto L12
    }

    public static boolean isKotlin(Class r100) {
        if (kotlin_metadata != null) goto L10;
        if (kotlin_metadata_error == true) goto L10;
        kotlin_metadata = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.Metadata");     // Catch: Throwable -> L8
    L8:
        kotlin_metadata_error = true;
    L10:
        if (kotlin_metadata != null) goto L12;
    L14:
        return false;
    L12:
        if (r100.isAnnotationPresent(kotlin_metadata) == false) goto L14;
        return true;
    }

    public static boolean isNumber(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L18;
        char r102 = r100.charAt(r101);
        if (r102 != '+') goto L8;
    L15:
        if (r101 == 0) goto L17;
        return false;
    L17:
        r101 = r101 + 1;
        goto L4
    L8:
        if (r102 == '-') goto L15;
        if (r102 < '0') goto L14;
        if (r102 <= '9') goto L17;
    L14:
        return false;
    L18:
        return true;
    }

    public static boolean isPath(Class<?> r100) {
        if (pathClass == null) goto L5;
    L9:
        Class<?> r101 = pathClass;
        if (r101 != null) goto L12;
        return false;
    L12:
        return r101.isAssignableFrom(r100);
    L5:
        if (pathClass_error == true) goto L9;
        pathClass = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.nio.file.Path");     // Catch: Throwable -> L8
    L8:
        pathClass_error = true;
        goto L9
    }

    public static boolean isProxy(Class<?> r100) {
        Class<?>[] r101 = r100.getInterfaces();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = r101[r103].getName();
        if (isProxyClassNames.contains(r104) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isTransient(Method r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (transientClassInited == false) goto L20;
    L13:
        Class<? extends Annotation> r101 = transientClass;
        if (r101 != null) goto L16;
        return false;
    L16:
        if (getAnnotation(r100, r101) == null) goto L23;
        return true;
    L23:
        return false;
    L20:
        transientClass = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.beans.Transient");     // Catch: Throwable -> L9 Exception -> L19
    L9:
        th = move-exception;
        transientClassInited = true;
        throw th;
    L12:
        transientClassInited = true;
        goto L13
    }

    public static boolean isXmlField(Class r100) {
        if (class_XmlAccessorType != null) goto L10;
        if (classXmlAccessorType_error == true) goto L10;
        class_XmlAccessorType = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("javax.xml.bind.annotation.XmlAccessorType");     // Catch: Throwable -> L8
    L8:
        classXmlAccessorType_error = true;
    L10:
        if (class_XmlAccessorType != null) goto L12;
        return false;
    L12:
        Annotation r101 = getAnnotation(r100, class_XmlAccessorType);
        if (r101 != null) goto L16;
        return false;
    L16:
        if (method_XmlAccessorType_value != null) goto L23;
        if (classXmlAccessorType_error == true) goto L23;
        method_XmlAccessorType_value = class_XmlAccessorType.getMethod("value", new Class[0]);     // Catch: Throwable -> L21
    L21:
        classXmlAccessorType_error = true;
    L23:
        if (method_XmlAccessorType_value != null) goto L26;
        return false;
    L26:
        if (classXmlAccessorType_error == false) goto L51;
    L30:
        Object r102 = null;
    L31:
        if (r102 != null) goto L34;
        return false;
    L34:
        if (class_XmlAccessType != null) goto L41;
        if (classXmlAccessorType_error == true) goto L41;
        class_XmlAccessType = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("javax.xml.bind.annotation.XmlAccessType");     // Catch: Throwable -> L39
        field_XmlAccessType_FIELD = class_XmlAccessType.getField("FIELD");     // Catch: Throwable -> L39
        field_XmlAccessType_FIELD_VALUE = field_XmlAccessType_FIELD.get(null);     // Catch: Throwable -> L39
    L39:
        classXmlAccessorType_error = true;
    L41:
        if (r102 == field_XmlAccessType_FIELD_VALUE) goto L53;
        return false;
    L53:
        return true;
    L51:
        r102 = method_XmlAccessorType_value.invoke(r101, new Object[0]);     // Catch: Throwable -> L29
    L29:
        classXmlAccessorType_error = true;
        goto L30
    }

    public static Class<?> loadClass(String r100) {
        return loadClass(r100, null);
    }

    public static long longExtractValue(Number r100) {
        if ((r100 instanceof BigDecimal) == false) goto L7;
        return ((BigDecimal) r100).longValueExact();
    L7:
        return r100.longValue();
    }

    public static long longValue(BigDecimal r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.scale();
        if (r101 < (-100)) goto L12;
        if (r101 > 100) goto L12;
        return r100.longValue();
    L12:
        return r100.longValueExact();
    }

    public static Object optionalEmpty(Type r100) {
        if (OPTIONAL_ERROR == false) goto L5;
        return null;
    L5:
        Class<?> r101 = getClass(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = r101.getName();
        if ("java.util.Optional".equals(r102) == true) goto L11;
        return null;
    L11:
        if (OPTIONAL_EMPTY != null) goto L16;
        OPTIONAL_EMPTY = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102).getMethod("empty", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
    L14:
        OPTIONAL_ERROR = true;
    L16:
        return OPTIONAL_EMPTY;
    }

    public static double parseDouble(String r100) {
        int r101 = r100.length();
        if (r101 > 10) goto L5;
        int r102 = 0;
        long r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L7:
        if (r102 >= r101) goto L26;
        char r106 = r100.charAt(r102);
        if (r106 != '-') goto L13;
        if (r102 != 0) goto L13;
        r104 = true;
    L23:
        r102 = r102 + 1;
    L13:
        if (r106 != '.') goto L19;
        if (r105 != 0) goto L16;
        r105 = (r101 - r102) - 1;
        goto L23
    L16:
        return CastDoubleProtector.parseDouble(r100);
    L19:
        if (r106 < '0') goto L25;
        if (r106 > '9') goto L25;
        r103 = (r103 * 10) + ((long) (r106 - '0'));
    L25:
        return CastDoubleProtector.parseDouble(r100);
    L26:
        if (r104 == false) goto L28;
        r103 = -r103;
    L28:
        switch(r105) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L31;
            default: goto L30;
        };
    L31:
        double r107 = r103;
        double r108 = 1.0E9d;
    L33:
        return r107 / r108;
    L34:
        r107 = r103;
        r108 = 1.0E8d;
        goto L33
    L35:
        r107 = r103;
        r108 = 1.0E7d;
        goto L33
    L36:
        r107 = r103;
        r108 = 1000000.0d;
        goto L33
    L37:
        r107 = r103;
        r108 = 100000.0d;
        goto L33
    L38:
        r107 = r103;
        r108 = 10000.0d;
        goto L33
    L39:
        r107 = r103;
        r108 = 1000.0d;
        goto L33
    L40:
        r107 = r103;
        r108 = 100.0d;
        goto L33
    L41:
        r107 = r103;
        r108 = 10.0d;
        goto L33
    L30:
        return CastDoubleProtector.parseDouble(r100);
    L43:
        return r103;
    L5:
        return CastDoubleProtector.parseDouble(r100);
    }

    public static float parseFloat(String r100) {
        int r101 = r100.length();
        if (r101 >= 10) goto L5;
        int r102 = 0;
        long r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L7:
        if (r102 >= r101) goto L26;
        char r106 = r100.charAt(r102);
        if (r106 != '-') goto L13;
        if (r102 != 0) goto L13;
        r104 = true;
    L23:
        r102 = r102 + 1;
    L13:
        if (r106 != '.') goto L19;
        if (r105 != 0) goto L16;
        r105 = (r101 - r102) - 1;
        goto L23
    L16:
        return CastFloatProtector.parseFloat(r100);
    L19:
        if (r106 < '0') goto L25;
        if (r106 > '9') goto L25;
        r103 = (r103 * 10) + ((long) (r106 - '0'));
    L25:
        return CastFloatProtector.parseFloat(r100);
    L26:
        if (r104 == false) goto L28;
        r103 = -r103;
    L28:
        switch(r105) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L31;
            default: goto L30;
        };
    L31:
        float r107 = r103;
        float r108 = 1.0E9f;
    L33:
        return r107 / r108;
    L34:
        r107 = r103;
        r108 = 1.0E8f;
        goto L33
    L35:
        r107 = r103;
        r108 = 1.0E7f;
        goto L33
    L36:
        r107 = r103;
        r108 = 1000000.0f;
        goto L33
    L37:
        r107 = r103;
        r108 = 100000.0f;
        goto L33
    L38:
        r107 = r103;
        r108 = 10000.0f;
        goto L33
    L39:
        r107 = r103;
        r108 = 1000.0f;
        goto L33
    L40:
        r107 = r103;
        r108 = 100.0f;
        goto L33
    L41:
        r107 = r103;
        r108 = 10.0f;
        goto L33
    L30:
        return CastFloatProtector.parseFloat(r100);
    L43:
        return r103;
    L5:
        return CastFloatProtector.parseFloat(r100);
    }

    public static void setAccessible(AccessibleObject r100) {
        if (setAccessibleEnable == true) goto L6;
        return;
    L6:
        if (r100.isAccessible() == false) goto L13;
        return;
    L13:
        r100.setAccessible(true);     // Catch: Throwable -> L11
        return;
    L11:
        setAccessibleEnable = false;
    }

    public static short shortValue(BigDecimal r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.scale();
        if (r101 < (-100)) goto L12;
        if (r101 > 100) goto L12;
        return r100.shortValue();
    L12:
        return r100.shortValueExact();
    }

    public static Locale toLocale(String r100) {
        String[] r101 = r100.split("_");
        if (r101.length != 1) goto L7;
        return new Locale(r101[0]);
    L7:
        if (r101.length != 2) goto L11;
        return new Locale(r101[0], r101[1]);
    L11:
        return new Locale(r101[0], r101[1], r101[2]);
    }

    public static Type unwrapOptional(Type r100) {
        if (optionalClassInited == true) goto L12;
        optionalClass = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.util.Optional");     // Catch: Throwable -> L7 Exception -> L17
    L7:
        th = move-exception;
        optionalClassInited = true;
        throw th;
    L10:
        optionalClassInited = true;
    L12:
        if ((r100 instanceof ParameterizedType) == false) goto L20;
        ParameterizedType r101 = (ParameterizedType) r100;
        if (r101.getRawType() == optionalClass) goto L16;
        return r100;
    L16:
        return r101.getActualTypeArguments()[0];
    L20:
        return r100;
    }

    public static Type getCollectionItemType(Type r100) {
        if ((r100 instanceof ParameterizedType) == false) goto L7;
        return getCollectionItemType((ParameterizedType) r100);
    L7:
        if ((r100 instanceof Class) == true) goto L9;
        return Object.class;
    L9:
        return getCollectionItemType((Class) r100);
    }

    public static Annotation[][] getParameterAnnotations(Method r100) {
        Annotation[][] r101 = r100.getParameterAnnotations();
        Type r102 = JSON.getMixInAnnotations(r100.getDeclaringClass());
        Method r103 = null;
        if ((r102 instanceof Class) == false) goto L5;
        Class r104 = (Class) r102;
    L6:
        if (r104 == null) goto L19;
        String r105 = r100.getName();
        Class<?>[] r106 = r100.getParameterTypes();
    L8:
        if (r104 == null) goto L14;
        if (r104 == Object.class) goto L14;
        r103 = r104.getDeclaredMethod(r105, r106);     // Catch: NoSuchMethodException -> L13
    L13:
        r104 = r104.getSuperclass();
    L14:
        if (r103 != null) goto L16;
        return r101;
    L16:
        Annotation[][] r107 = r103.getParameterAnnotations();
        if (r107 == null) goto L19;
        return r107;
    L19:
        return r101;
    L5:
        r104 = null;
        goto L6
    }

    private static Type getCollectionItemType(Class<?> r100) {
        if (r100.getName().startsWith("java.") == false) goto L6;
        return Object.class;
    L6:
        return getCollectionItemType(getCollectionSuperType(r100));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static void addMapping(String r100, Class<?> r101) {
        mappings.put(r100, r101);
    }

    public static Date castToDate(Object r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Date) == false) goto L10;
        return (Date) r100;
    L10:
        if ((r100 instanceof Calendar) == false) goto L14;
        return ((Calendar) r100).getTime();
    L14:
        if ((r100 instanceof BigDecimal) == false) goto L18;
        return new Date(longValue((BigDecimal) r100));
    L18:
        if ((r100 instanceof Number) == false) goto L25;
        long r102 = ((Number) r100).longValue();
        if ("unixtime".equals(r101) == false) goto L23;
        r102 = r102 * 1000;
    L23:
        return new Date(r102);
    L25:
        if ((r100 instanceof String) == false) goto L83;
        String r103 = (String) r100;
        JSONScanner r104 = new JSONScanner(r103);
    L80:
        th = move-exception;
        r104.close();
        throw th;
    L28:
        if (r104.scanISO8601DateIfMatch(false) == false) goto L32;
        Date r105 = r104.getCalendar().getTime();     // Catch: Throwable -> L80
        r104.close();
        return r105;
    L32:
        r104.close();
        if (r103.startsWith("/Date(") == false) goto L38;
        if (r103.endsWith(")/") == false) goto L38;
        r103 = r103.substring(6, r103.length() - 2);
    L38:
        if (r103.indexOf(45) <= 0) goto L40;
    L47:
        if (r101 != null) goto L75;
        int r106 = r103.length();
        if (r106 != JSON.DEFFAULT_DATE_FORMAT.length()) goto L51;
    L74:
        r101 = JSON.DEFFAULT_DATE_FORMAT;
        goto L75
    L51:
        if (r106 != 22) goto L56;
        if (JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ") == true) goto L74;
    L56:
        if (r106 != 10) goto L59;
        r101 = "yyyy-MM-dd";
        goto L75
    L59:
        if (r106 != 19) goto L62;
        r101 = "yyyy-MM-dd HH:mm:ss";
        goto L75
    L62:
        if (r106 != 29) goto L69;
        if (r103.charAt(26) != ':') goto L69;
        if (r103.charAt(28) != '0') goto L69;
        r101 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    L69:
        if (r106 == 23) goto L71;
    L73:
        r101 = "yyyy-MM-dd HH:mm:ss.SSS";
        goto L75
    L71:
        if (r103.charAt(19) != ',') goto L73;
        r101 = "yyyy-MM-dd HH:mm:ss,SSS";
    L75:
        SimpleDateFormat r107 = new SimpleDateFormat(r101, JSON.defaultLocale);
        r107.setTimeZone(JSON.defaultTimeZone);
        return r107.parse(r103);
    L79:
        throw new JSONException("can not cast to Date, value : ".concat(r103));
    L40:
        if (r103.indexOf(43) > 0) goto L47;
        if (r101 != null) goto L47;
        if (r103.length() != 0) goto L46;
        return null;
    L46:
        long r108 = CastLongProtector.parseLong(r103);
    L85:
        if (r108 != (-1)) goto L125;
        Class<?> r109 = r100.getClass();
        if ("oracle.sql.TIMESTAMP".equals(r109.getName()) == false) goto L105;
        if (oracleTimestampMethod == null) goto L91;
    L134:
        return (Date) oracleTimestampMethod.invoke(r100, new Object[0]);
    L101:
        e = move-exception;
        throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
    L91:
        if (oracleTimestampMethodInited == true) goto L134;
        oracleTimestampMethod = r109.getMethod("toJdbc", new Class[0]);     // Catch: Throwable -> L94 NoSuchMethodException -> L126
    L94:
        th = move-exception;
        oracleTimestampMethodInited = true;
        throw th;
    L97:
        oracleTimestampMethodInited = true;
        goto L134
    L105:
        if ("oracle.sql.DATE".equals(r109.getName()) == false) goto L123;
        if (oracleDateMethod == null) goto L109;
    L132:
        return (Date) oracleDateMethod.invoke(r100, new Object[0]);
    L119:
        e = move-exception;
        throw new JSONException("can not cast oracle.sql.DATE to Date", e);
    L109:
        if (oracleDateMethodInited == true) goto L132;
        oracleDateMethod = r109.getMethod("toJdbc", new Class[0]);     // Catch: Throwable -> L112 NoSuchMethodException -> L127
    L112:
        th = move-exception;
        oracleDateMethodInited = true;
        throw th;
    L115:
        oracleDateMethodInited = true;
        goto L132
    L123:
        throw new JSONException("can not cast to Date, value : " + r100);
    L125:
        return new Date(r108);
    L83:
        r108 = -1;
        goto L85
    }

    public static <T> T castToJavaBean(Object r100, Class<T> r101) {
        return (T) cast(r100, r101, ParserConfig.getGlobalInstance());
    }

    public static List<FieldInfo> computeGetters(Class<?> r100, Map<String, String> r101) {
        return computeGetters(r100, r101, true);
    }

    private static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] r100, Type[] r101) {
        int r102 = r100.length;
        HashMap r103 = new HashMap(r102);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103.put(r100[r104], r101[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    private static Type getActualType(Type r100, Map<TypeVariable, Type> r101) {
        if ((r100 instanceof TypeVariable) == false) goto L7;
        return r101.get(r100);
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return makeParameterizedType(getRawClass(r100), ((ParameterizedType) r100).getActualTypeArguments(), r101);
    L11:
        if ((r100 instanceof GenericArrayType) == true) goto L13;
        return r100;
    L13:
        return new GenericArrayTypeImpl(getActualType(((GenericArrayType) r100).getGenericComponentType(), r101));
    }

    public static <A extends Annotation> A getAnnotation(Class<?> r100, Class<A> r101) {
        A r102 = (A) r100.getAnnotation(r101);
        Type r103 = JSON.getMixInAnnotations(r100);
        if ((r103 instanceof Class) == false) goto L5;
        Class r104 = (Class) r103;
    L6:
        int r105 = 0;
        if (r104 == null) goto L20;
        A r106 = (A) r104.getAnnotation(r101);
        Annotation[] r107 = r104.getAnnotations();
        if (r106 == null) goto L11;
    L18:
        if (r106 == null) goto L20;
        return r106;
    L11:
        if (r107.length <= 0) goto L18;
        int r108 = r107.length;
        int r109 = 0;
    L13:
        if (r109 >= r108) goto L18;
        r106 = (A) r107[r109].annotationType().getAnnotation(r101);
        if (r106 != null) goto L18;
        r109 = r109 + 1;
    L20:
        Annotation[] r110 = r100.getAnnotations();
        if (r102 == null) goto L23;
    L30:
        return r102;
    L23:
        if (r110.length <= 0) goto L30;
        int r111 = r110.length;
    L25:
        if (r105 >= r111) goto L30;
        r102 = (A) r110[r105].annotationType().getAnnotation(r101);
        if (r102 != null) goto L30;
        r105 = r105 + 1;
        goto L25
    L5:
        r104 = null;
        goto L6
    }

    public static Constructor getKotlinConstructor(Constructor[] r100, String[] r101) {
        int r102 = r100.length;
        Constructor r103 = null;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L20;
        Constructor r105 = r100[r104];
        Class<?>[] r106 = r105.getParameterTypes();
        if (r101 == null) goto L10;
        if (r106.length == r101.length) goto L10;
    L19:
        r104 = r104 + 1;
    L10:
        if (r106.length > 0) goto L12;
    L14:
        if (r103 != null) goto L16;
    L18:
        r103 = r105;
        goto L19
    L16:
        if (r103.getParameterTypes().length < r106.length) goto L18;
    L12:
        if (r106[r106.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker") == false) goto L14;
    L20:
        return r103;
    }

    public static JSONField getSuperMethodAnnotation(Class<?> r110, Method r111) {
        Class<?>[] r100 = r110.getInterfaces();
        if (r100.length <= 0) goto L29;
        Class<?>[] r101 = r111.getParameterTypes();
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L29;
        Method[] r104 = r100[r103].getMethods();
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L28;
        Method r107 = r104[r106];
        Class<?>[] r112 = r107.getParameterTypes();
        if (r112.length != r101.length) goto L27;
        if (r107.getName().equals(r111.getName()) == false) goto L27;
        int r113 = 0;
    L16:
        if (r113 >= r101.length) goto L21;
        if (r112[r113].equals(r101[r113]) == false) goto L19;
        r113 = r113 + 1;
        goto L16
    L19:
        boolean r114 = false;
    L22:
        if (r114 == false) goto L27;
        JSONField r108 = (JSONField) getAnnotation(r107, JSONField.class);
        if (r108 == null) goto L27;
        return r108;
    L21:
        r114 = true;
    L27:
        r106 = r106 + 1;
        goto L7
    L28:
        r103 = r103 + 1;
    L29:
        Class<? super Object> r115 = r110.getSuperclass();
        if (r115 != null) goto L33;
        return null;
    L33:
        if (Modifier.isAbstract(r115.getModifiers()) == false) goto L56;
        Class<?>[] r109 = r111.getParameterTypes();
        Method[] r116 = r115.getMethods();
        int r117 = r116.length;
        int r118 = 0;
    L35:
        if (r118 >= r117) goto L56;
        Method r119 = r116[r118];
        Class<?>[] r120 = r119.getParameterTypes();
        if (r120.length != r109.length) goto L55;
        if (r119.getName().equals(r111.getName()) == false) goto L55;
        int r121 = 0;
    L44:
        if (r121 >= r109.length) goto L49;
        if (r120[r121].equals(r109[r121]) == false) goto L47;
        r121 = r121 + 1;
        goto L44
    L47:
        boolean r122 = false;
    L50:
        if (r122 == false) goto L55;
        JSONField r123 = (JSONField) getAnnotation(r119, JSONField.class);
        if (r123 == null) goto L55;
        return r123;
    L49:
        r122 = true;
    L55:
        r118 = r118 + 1;
    L56:
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> r100, String r101) {
        JSONType r102 = (JSONType) getAnnotation(r100, JSONType.class);
        if (r102 == null) goto L20;
        String[] r103 = r102.includes();
        if (r103.length <= 0) goto L13;
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        if (r101.equals(r103[r105]) == true) goto L10;
        r105 = r105 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    L13:
        String[] r106 = r102.ignores();
        int r107 = r106.length;
        int r108 = 0;
    L14:
        if (r108 >= r107) goto L20;
        if (r101.equals(r106[r108]) == true) goto L17;
        r108 = r108 + 1;
        goto L14
    L17:
        return true;
    L20:
        if (r100.getSuperclass() != Object.class) goto L22;
    L25:
        return false;
    L22:
        if (r100.getSuperclass() == null) goto L25;
        return isJSONTypeIgnore(r100.getSuperclass(), r101);
    }

    private static boolean isKotlinIgnore(Class r100, String r101) {
        if (kotlinIgnores != null) goto L10;
        if (kotlinIgnores_error == true) goto L10;
        HashMap r102 = new HashMap();     // Catch: Throwable -> L8
        r102.put(INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});     // Catch: Throwable -> L8
        r102.put(INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});     // Catch: Throwable -> L8
        r102.put(INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});     // Catch: Throwable -> L8
        r102.put(INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});     // Catch: Throwable -> L8
        r102.put(INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});     // Catch: Throwable -> L8
        kotlinIgnores = r102;     // Catch: Throwable -> L8
    L8:
        kotlinIgnores_error = true;
    L10:
        if (kotlinIgnores != null) goto L12;
        return false;
    L12:
        String[] r103 = kotlinIgnores.get(r100);
        if (r103 != null) goto L15;
    L17:
        return false;
    L15:
        if (Arrays.binarySearch(r103, r101) < 0) goto L17;
        return true;
    }

    public static Class<?> loadClass(String r100, ClassLoader r101) {
        return loadClass(r100, r101, false);
    }

    public static <A extends Annotation> A getAnnotation(Method r100, Class<A> r101) {
        A r102 = (A) r100.getAnnotation(r101);
        Type r103 = JSON.getMixInAnnotations(r100.getDeclaringClass());
        Method r104 = null;
        if ((r103 instanceof Class) == false) goto L5;
        Class r105 = (Class) r103;
    L6:
        if (r105 == null) goto L19;
        String r106 = r100.getName();
        Class<?>[] r107 = r100.getParameterTypes();
    L8:
        if (r105 == null) goto L14;
        if (r105 == Object.class) goto L14;
        r104 = r105.getDeclaredMethod(r106, r107);     // Catch: NoSuchMethodException -> L13
    L13:
        r105 = r105.getSuperclass();
    L14:
        if (r104 != null) goto L16;
        return r102;
    L16:
        A r108 = (A) r104.getAnnotation(r101);
        if (r108 == null) goto L19;
        return r108;
    L19:
        return r102;
    L5:
        r105 = null;
        goto L6
    }

    public static <A extends Annotation> A getAnnotation(Field r100, Class<A> r101) {
        A r102 = (A) r100.getAnnotation(r101);
        Type r103 = JSON.getMixInAnnotations(r100.getDeclaringClass());
        Field r104 = null;
        if ((r103 instanceof Class) == false) goto L5;
        Class r105 = (Class) r103;
    L6:
        if (r105 == null) goto L19;
        String r106 = r100.getName();
    L8:
        if (r105 == null) goto L14;
        if (r105 == Object.class) goto L14;
        r104 = r105.getDeclaredField(r106);     // Catch: NoSuchFieldException -> L13
    L13:
        r105 = r105.getSuperclass();
    L14:
        if (r104 != null) goto L16;
        return r102;
    L16:
        A r107 = (A) r104.getAnnotation(r101);
        if (r107 == null) goto L19;
        return r107;
    L19:
        return r102;
    L5:
        r105 = null;
        goto L6
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> r100, Map<String, String> r101, PropertyNamingStrategy r102) {
        return buildBeanInfo(r100, r101, r102, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object r100, Class<T> r101, ParserConfig r102) {
        int r103 = 0;
        if (r100 == 0) goto L5;
        if (r101 == null) goto L189;
        if (r101 != r100.getClass()) goto L38;
        return r100;
    L38:
        if ((r100 instanceof Map) == false) goto L50;
        if (r101 != Map.class) goto L42;
        return r100;
    L42:
        Map r104 = (Map) r100;
        if (r101 != Object.class) goto L48;
        if (r104.containsKey(JSON.DEFAULT_TYPE_KEY) == true) goto L48;
        return r100;
    L48:
        return (T) castToJavaBean(r104, r101, r102);
    L50:
        if (r101.isArray() == false) goto L63;
        if ((r100 instanceof Collection) == false) goto L59;
        Collection r105 = (Collection) r100;
        T r106 = (T) Array.newInstance(r101.getComponentType(), r105.size());
        Iterator r107 = r105.iterator();
    L55:
        if (r107.hasNext() == false) goto L57;
        Array.set(r106, r103, cast(r107.next(), r101.getComponentType(), r102));
        r103 = r103 + 1;
        goto L55
    L57:
        return r106;
    L59:
        if (r101 != byte[].class) goto L63;
        return (T) castToBytes(r100);
    L63:
        if (r101.isAssignableFrom(r100.getClass()) == false) goto L66;
        return r100;
    L66:
        if (r101 == Boolean.TYPE) goto L187;
        if (r101 == Boolean.class) goto L187;
        if (r101 == Byte.TYPE) goto L185;
        if (r101 == Byte.class) goto L185;
        if (r101 == Character.TYPE) goto L183;
        if (r101 == Character.class) goto L183;
        if (r101 == Short.TYPE) goto L181;
        if (r101 == Short.class) goto L181;
        if (r101 == Integer.TYPE) goto L179;
        if (r101 == Integer.class) goto L179;
        if (r101 == Long.TYPE) goto L177;
        if (r101 == Long.class) goto L177;
        if (r101 == Float.TYPE) goto L175;
        if (r101 == Float.class) goto L175;
        if (r101 == Double.TYPE) goto L173;
        if (r101 == Double.class) goto L173;
        if (r101 != String.class) goto L110;
        return (T) castToString(r100);
    L110:
        if (r101 != BigDecimal.class) goto L114;
        return (T) castToBigDecimal(r100);
    L114:
        if (r101 != BigInteger.class) goto L118;
        return (T) castToBigInteger(r100);
    L118:
        if (r101 == Date.class) goto L120;
        T r108 = (T) ModuleUtil.callWhenHasJavaSql(castFunction, r100, r101);
        if (r108 == null) goto L125;
        return r108;
    L125:
        if (r101.isEnum() == false) goto L129;
        return (T) castToEnum(r100, r101, r102);
    L129:
        if (Calendar.class.isAssignableFrom(r101) == false) goto L140;
        Date r109 = castToDate(r100);
        if (r101 != Calendar.class) goto L190;
        Object r110 = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
    L135:
        ((Calendar) r110).setTime(r109);
        return (T) r110;
    L190:
        r110 = (T) ((Calendar) r101.newInstance());
    L137:
        e = move-exception;
        throw new JSONException("can not cast to : ".concat(r101.getName()), e);
    L140:
        String r111 = r101.getName();
        if (r111.equals("javax.xml.datatype.XMLGregorianCalendar") == false) goto L145;
        Date r112 = castToDate(r100);
        Calendar r113 = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
        r113.setTime(r112);
        return (T) CalendarCodec.instance.createXMLGregorianCalendar(r113);
    L145:
        if ((r100 instanceof String) == false) goto L167;
        String r114 = (String) r100;
        if (r114.length() != 0) goto L149;
    L165:
        return null;
    L149:
        if ("null".equals(r114) == true) goto L165;
        if ("NULL".equals(r114) == true) goto L165;
        if (r101 != Currency.class) goto L158;
        return (T) Currency.getInstance(r114);
    L158:
        if (r101 != Locale.class) goto L162;
        return (T) toLocale(r114);
    L162:
        if (r111.startsWith("java.time.") == false) goto L167;
        return (T) JSON.parseObject(JSON.toJSONString(r114), r101);
    L167:
        if (r102.get(r101) == null) goto L171;
        return (T) JSON.parseObject(JSON.toJSONString(r100), r101);
    L171:
        throw new JSONException("can not cast to : ".concat(r101.getName()));
    L120:
        return (T) castToDate(r100);
    L173:
        return (T) castToDouble(r100);
    L175:
        return (T) castToFloat(r100);
    L177:
        return (T) castToLong(r100);
    L179:
        return (T) castToInt(r100);
    L181:
        return (T) castToShort(r100);
    L183:
        return (T) castToChar(r100);
    L185:
        return (T) castToByte(r100);
    L187:
        return (T) castToBoolean(r100);
    L189:
        throw new IllegalArgumentException("clazz is null");
    L5:
        if (r101 != Integer.TYPE) goto L9;
        return (T) 0;
    L9:
        if (r101 != Long.TYPE) goto L13;
        return (T) 0L;
    L13:
        if (r101 != Short.TYPE) goto L17;
        return (T) (short) 0;
    L17:
        if (r101 != Byte.TYPE) goto L21;
        return (T) (byte) 0;
    L21:
        if (r101 != Float.TYPE) goto L25;
        return (T) Float.valueOf(0.0f);
    L25:
        if (r101 != Double.TYPE) goto L29;
        return (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L29:
        if (r101 == Boolean.TYPE) goto L31;
        return null;
    L31:
        return (T) Boolean.FALSE;
    }

    public static <T> T castToEnum(Object r100, Class<T> r101, ParserConfig r102) {
    L31:
        e = move-exception;
        throw new JSONException("can not cast to : ".concat(r101.getName()), e);
    L4:
        if ((r100 instanceof String) == false) goto L18;
        String r103 = (String) r100;     // Catch: Exception -> L31
        if (r103.length() != 0) goto L9;
        return null;
    L9:
        if (r102 != null) goto L11;
        r102 = ParserConfig.getGlobalInstance();     // Catch: Exception -> L31
    L11:
        ObjectDeserializer r104 = r102.getDeserializer(r101);     // Catch: Exception -> L31
        if ((r104 instanceof EnumDeserializer) == false) goto L16;
        return (T) ((EnumDeserializer) r104).getEnumByHashCode(fnv1a_64(r103));
    L16:
        return (T) r27.a.a(r101, r103);
    L18:
        if ((r100 instanceof BigDecimal) == false) goto L24;
        int r105 = intValue((BigDecimal) r100);     // Catch: Exception -> L31
        T[] r106 = r101.getEnumConstants();     // Catch: Exception -> L31
        if (r105 >= r106.length) goto L24;
        return r106[r105];
    L24:
        if ((r100 instanceof Number) == false) goto L30;
        int r107 = ((Number) r100).intValue();     // Catch: Exception -> L31
        T[] r108 = r101.getEnumConstants();     // Catch: Exception -> L31
        if (r107 >= r108.length) goto L30;
        return r108[r107];
    L30:
        throw new JSONException("can not cast to : ".concat(r101.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T castToJavaBean(Map<String, Object> r100, Class<T> r101, ParserConfig r102) {
        int r103 = 0;
        if (r101 != StackTraceElement.class) goto L14;
        String r104 = (String) r100.get(PushClientConstants.TAG_CLASS_NAME);     // Catch: Exception -> L87
        String r105 = (String) r100.get("methodName");     // Catch: Exception -> L87
        String r106 = (String) r100.get("fileName");     // Catch: Exception -> L87
        Number r107 = (Number) r100.get("lineNumber");     // Catch: Exception -> L87
        if (r107 != null) goto L9;
    L13:
        return (T) new StackTraceElement(r104, r105, r106, r103);
    L9:
        if ((r107 instanceof BigDecimal) == false) goto L11;
        r103 = ((BigDecimal) r107).intValueExact();     // Catch: Exception -> L87
        goto L13
    L11:
        r103 = r107.intValue();     // Catch: Exception -> L87
        goto L13
    L14:
        Object r108 = r100.get(JSON.DEFAULT_TYPE_KEY);     // Catch: Exception -> L87
        JavaBeanDeserializer r109 = null;
        if ((r108 instanceof String) == false) goto L28;
        String r110 = (String) r108;     // Catch: Exception -> L87
        if (r102 != null) goto L19;
        r102 = ParserConfig.global;     // Catch: Exception -> L87
    L19:
        Class<?> r111 = r102.checkAutoType(r110, null);     // Catch: Exception -> L87
        if (r111 == null) goto L26;
        if (r111.equals(r101) == true) goto L28;
        return (T) castToJavaBean(r100, r111, r102);
    L26:
        throw new ClassNotFoundException(r110 + " not found");     // Catch: Exception -> L87
    L28:
        if (r101.isInterface() == false) goto L42;
        if ((r100 instanceof JSONObject) == false) goto L32;
        JSONObject r112 = (JSONObject) r100;     // Catch: Exception -> L87
    L33:
        if (r102 != null) goto L36;
        r102 = ParserConfig.getGlobalInstance();     // Catch: Exception -> L87
    L36:
        if (r102.get(r101) == null) goto L40;
        return (T) JSON.parseObject(JSON.toJSONString(r112), r101);
    L40:
        return (T) Proxy.newProxyInstance(ThreadMethodProxy.currentThread().getContextClassLoader(), new Class[]{r101}, r112);
    L32:
        r112 = new JSONObject(r100);     // Catch: Exception -> L87
        goto L33
    L42:
        if (r101 != Locale.class) goto L53;
        Object r113 = r100.get("language");     // Catch: Exception -> L87
        Object r114 = r100.get(DistrictSearchQuery.KEYWORDS_COUNTRY);     // Catch: Exception -> L87
        if ((r113 instanceof String) == false) goto L53;
        String r115 = (String) r113;     // Catch: Exception -> L87
        if ((r114 instanceof String) == true) goto L48;
        if (r114 != null) goto L53;
        return (T) new Locale(r115);
    L48:
        return (T) new Locale(r115, (String) r114);
    L53:
        if (r101 != String.class) goto L59;
        if ((r100 instanceof JSONObject) == false) goto L59;
        return (T) r100.toString();
    L59:
        if (r101 != JSON.class) goto L64;
        if ((r100 instanceof JSONObject) == false) goto L64;
        return r100;
    L64:
        if (r101 != LinkedHashMap.class) goto L71;
        if ((r100 instanceof JSONObject) == false) goto L71;
        T r116 = (T) ((JSONObject) r100).getInnerMap();
        if ((r116 instanceof LinkedHashMap) == false) goto L71;
        return r116;
    L71:
        if (r101.isInstance(r100) == false) goto L74;
        return r100;
    L74:
        if (r101 == JSONObject.class) goto L76;
        if (r102 != null) goto L79;
        r102 = ParserConfig.getGlobalInstance();     // Catch: Exception -> L87
    L79:
        ObjectDeserializer r117 = r102.getDeserializer(r101);     // Catch: Exception -> L87
        if ((r117 instanceof JavaBeanDeserializer) == false) goto L82;
        r109 = (JavaBeanDeserializer) r117;     // Catch: Exception -> L87
    L82:
        if (r109 == null) goto L86;
        return (T) r109.createInstance(r100, r102);
    L86:
        throw new JSONException("can not get javaBeanDeserializer. ".concat(r101.getName()));     // Catch: Exception -> L87
    L76:
        return (T) new JSONObject(r100);
    L87:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public static List<FieldInfo> computeGetters(Class<?> r100, Map<String, String> r101, boolean r102) {
        JSONType r103 = (JSONType) getAnnotation(r100, JSONType.class);
        HashMap r104 = new HashMap();
        ParserConfig.parserAllFieldToCache(r100, r104);
        return computeGetters(r100, r103, r101, r104, r102, PropertyNamingStrategy.CamelCase);
    }

    public static Field getField(Class<?> r100, String r101, Field[] r102) {
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L21;
        Field r105 = r102[r104];
        String r106 = r105.getName();
        if (r101.equals(r106) == true) goto L6;
        if (r101.length() <= 2) goto L20;
        char r107 = r101.charAt(0);
        if (r107 < 'a') goto L20;
        if (r107 > 'z') goto L20;
        char r108 = r101.charAt(1);
        if (r108 < 'A') goto L20;
        if (r108 > 'Z') goto L20;
        if (r101.equalsIgnoreCase(r106) == false) goto L20;
        return r105;
    L20:
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L21:
        Class<? super Object> r109 = r100.getSuperclass();
        if (r109 != null) goto L24;
        return null;
    L24:
        if (r109 != Object.class) goto L26;
        return null;
    L26:
        return getField(r109, r101, r109.getDeclaredFields());
    }

    private static List<FieldInfo> getFieldInfos(Class<?> r100, boolean r101, Map<String, FieldInfo> r102) {
        ArrayList r103 = new ArrayList();
        JSONType r104 = (JSONType) getAnnotation(r100, JSONType.class);
        if (r104 == null) goto L5;
        String[] r105 = r104.orders();
    L6:
        if (r105 != null) goto L8;
    L20:
        r103.addAll(r102.values());
        if (r101 == false) goto L23;
        Collections.sort(r103);
    L23:
        return r103;
    L8:
        if (r105.length <= 0) goto L20;
        LinkedHashMap r106 = new LinkedHashMap(r102.size());
        Iterator<FieldInfo> r107 = r102.values().iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        FieldInfo r108 = r107.next();
        r106.put(r108.name, r108);
        goto L11
    L13:
        int r109 = r105.length;
        int r110 = 0;
    L14:
        if (r110 >= r109) goto L19;
        String r111 = r105[r110];
        FieldInfo r112 = (FieldInfo) r106.get(r111);
        if (r112 == null) goto L18;
        r103.add(r112);
        r106.remove(r111);
    L18:
        r110 = r110 + 1;
        goto L14
    L19:
        r103.addAll(r106.values());
        goto L23
    L5:
        r105 = null;
        goto L6
    }

    public static Class<?> loadClass(String r100, ClassLoader r101, boolean r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        if (r100.length() > 198) goto L42;
        Class<?> r103 = mappings.get(r100);
        if (r103 == null) goto L12;
        return r103;
    L12:
        if (r100.charAt(0) != '[') goto L16;
        return Array.newInstance(loadClass(r100.substring(1), r101), 0).getClass();
    L16:
        if (r100.startsWith("L") == true) goto L18;
    L21:
        if (r101 != null) goto L51;
    L49:
        ClassLoader r104 = ThreadMethodProxy.currentThread().getContextClassLoader();     // Catch: Throwable -> L45
        if (r104 == null) goto L53;
        if (r104 == r101) goto L53;
        Class<?> r105 = INVOKEVIRTUAL_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r104, r100);     // Catch: Throwable -> L45
        if (r102 == true) goto L47;
    L36:
        return r105;
    L47:
        mappings.put(r100, r105);     // Catch: Throwable -> L35
    L35:
        r103 = r105;
    L53:
        r103 = INVOKESTATIC_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L46
        if (r102 == false) goto L40;
        mappings.put(r100, r103);     // Catch: Throwable -> L46
    L40:
        return r103;
    L51:
        r103 = INVOKEVIRTUAL_com_alibaba_fastjson_util_TypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, r100);     // Catch: Throwable -> L26
        if (r102 == false) goto L25;
        mappings.put(r100, r103);     // Catch: Throwable -> L26
    L25:
        return r103;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L49
    L18:
        if (r100.endsWith(i.f25853b) == false) goto L21;
        return loadClass(r100.substring(1, r100.length() - 1), r101);
    L42:
        throw new JSONException("illegal className : ".concat(r100));
    }

    private static ParameterizedType makeParameterizedType(Class<?> r100, Type[] r101, Map<TypeVariable, Type> r102) {
        int r103 = r101.length;
        Type[] r104 = new Type[r103];
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L6;
        r104[r105] = getActualType(r101[r105], r102);
        r105 = r105 + 1;
        goto L3
    L6:
        return new ParameterizedTypeImpl(r104, null, r100);
    }

    /* JADX WARN: Type inference failed for: r6v14, types: [T, java.util.Map$Entry] */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v9, types: [T, java.util.HashMap] */
    public static <T> T cast(Object r100, ParameterizedType r101, ParserConfig r102) {
        Type r103 = r101.getRawType();
        if (r103 != List.class) goto L5;
    L6:
        Type r104 = r101.getActualTypeArguments()[0];
        if ((r100 instanceof List) == false) goto L22;
        List r105 = (List) r100;
        ?? r106 = (T) new ArrayList(r105.size());
        Iterator r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L20;
        Object r108 = r107.next();
        if ((r104 instanceof Class) == false) goto L18;
        if (r108 != null) goto L15;
    L17:
        Object r109 = cast(r108, (Class) r104, r102);
    L19:
        r106.add(r109);
        goto L10
    L15:
        if (r108.getClass() != JSONObject.class) goto L17;
        r109 = ((JSONObject) r108).toJavaObject((Class) r104, r102, 0);
        goto L19
    L18:
        r109 = cast(r108, r104, r102);
        goto L19
    L20:
        return r106;
    L22:
        if (r103 != Set.class) goto L24;
    L33:
        Type r110 = r101.getActualTypeArguments()[0];
        if ((r100 instanceof Iterable) == true) goto L36;
    L59:
        if (r103 != Map.class) goto L61;
    L62:
        Type r111 = r101.getActualTypeArguments()[0];
        Type r112 = r101.getActualTypeArguments()[1];
        if ((r100 instanceof Map) == false) goto L70;
        ?? r113 = (T) new HashMap();
        Iterator r114 = ((Map) r100).entrySet().iterator();
    L66:
        if (r114.hasNext() == false) goto L68;
        Map.Entry r115 = (Map.Entry) r114.next();
        r113.put(cast(r115.getKey(), r111, r102), cast(r115.getValue(), r112, r102));
        goto L66
    L68:
        return r113;
    L70:
        if ((r100 instanceof String) == true) goto L72;
    L74:
        Type[] r116 = r101.getActualTypeArguments();
        if (r116.length != 1) goto L81;
        if ((r101.getActualTypeArguments()[0] instanceof WildcardType) == false) goto L81;
        return (T) cast(r100, r103, r102);
    L81:
        if (r103 != Map.Entry.class) goto L93;
        if ((r100 instanceof Map) == false) goto L93;
        Map r117 = (Map) r100;
        if (r117.size() != 1) goto L93;
        ?? r118 = (T) ((Map.Entry) r117.entrySet().iterator().next());
        Object r119 = r118.getValue();
        if (r116.length == 2) goto L89;
    L91:
        return r118;
    L89:
        if ((r119 instanceof Map) == false) goto L91;
        r118.setValue(cast(r119, r116[1], r102));
    L93:
        if ((r103 instanceof Class) == false) goto L101;
        if (r102 != null) goto L96;
        r102 = ParserConfig.global;
    L96:
        ObjectDeserializer r120 = r102.getDeserializer(r103);
        if (r120 == null) goto L101;
        return (T) r120.deserialze(new DefaultJSONParser(JSON.toJSONString(r100), r102), r101, null);
    L101:
        throw new JSONException("can not cast to : " + r101);
    L72:
        if (((String) r100).length() != 0) goto L74;
        return null;
    L61:
        if (r103 != HashMap.class) goto L70;
    L36:
        if (r103 != Set.class) goto L38;
    L44:
        T r121 = (T) new HashSet();
    L45:
        Iterator<T> r122 = ((Iterable) r100).iterator();
    L47:
        if (r122.hasNext() == false) goto L57;
        T r123 = r122.next();
        if ((r110 instanceof Class) == false) goto L55;
        if (r123 != null) goto L52;
    L54:
        Object r124 = cast(r123, (Class) r110, r102);
    L56:
        ((Collection) r121).add(r124);
        goto L47
    L52:
        if (r123.getClass() != JSONObject.class) goto L54;
        r124 = ((JSONObject) r123).toJavaObject((Class) r110, r102, 0);
        goto L56
    L55:
        r124 = cast(r123, r110, r102);
        goto L56
    L57:
        return r121;
    L38:
        if (r103 == HashSet.class) goto L44;
        if (r103 != TreeSet.class) goto L43;
        r121 = (T) new TreeSet();
        goto L45
    L43:
        r121 = (T) new ArrayList();
        goto L45
    L24:
        if (r103 == HashSet.class) goto L33;
        if (r103 == TreeSet.class) goto L33;
        if (r103 == Collection.class) goto L33;
        if (r103 == List.class) goto L33;
        if (r103 != ArrayList.class) goto L59;
    L5:
        if (r103 != ArrayList.class) goto L22;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object r100, Type r101, ParserConfig r102) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r101 instanceof Class) == false) goto L10;
        return (T) cast(r100, (Class) r101, r102);
    L10:
        if ((r101 instanceof ParameterizedType) == false) goto L14;
        return (T) cast(r100, (ParameterizedType) r101, r102);
    L14:
        if ((r100 instanceof String) == false) goto L23;
        String r103 = (String) r100;
        if (r103.length() != 0) goto L18;
    L21:
        return null;
    L18:
        if ("null".equals(r103) == true) goto L21;
        if ("NULL".equals(r103) == true) goto L21;
    L23:
        if ((r101 instanceof TypeVariable) == false) goto L26;
        return r100;
    L26:
        throw new JSONException("can not cast to : " + r101);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> r110, Map<String, String> r111, PropertyNamingStrategy r112, boolean r113) {
        JSONType r100 = (JSONType) getAnnotation(r110, JSONType.class);
        String r101 = null;
        if (r100 == null) goto L36;
        String[] r102 = r100.orders();
        String r103 = r100.typeName();
        if (r103.length() != 0) goto L7;
        r103 = null;
    L7:
        PropertyNamingStrategy r104 = r100.naming();
        if (r104 != PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue) goto L11;
        r104 = r112;
    L11:
        int r105 = SerializerFeature.of(r100.serialzeFeatures());
        Class<? super Object> r106 = r110.getSuperclass();
        String r114 = null;
    L12:
        if (r106 == null) goto L22;
        if (r106 == Object.class) goto L22;
        JSONType r115 = (JSONType) getAnnotation(r106, JSONType.class);
        if (r115 == null) goto L22;
        r114 = r115.typeKey();
        if (r114.length() != 0) goto L22;
        r106 = r106.getSuperclass();
    L22:
        Class<?>[] r107 = r110.getInterfaces();
        int r116 = r107.length;
        int r117 = 0;
    L23:
        if (r117 >= r116) goto L30;
        JSONType r118 = (JSONType) getAnnotation(r107[r117], JSONType.class);
        if (r118 == null) goto L29;
        r114 = r118.typeKey();
        if (r114.length() != 0) goto L30;
    L29:
        r117 = r117 + 1;
    L30:
        if (r114 != null) goto L32;
    L34:
        r101 = r114;
    L35:
        String r119 = r101;
        String[] r108 = r102;
        String r120 = r103;
        PropertyNamingStrategy r121 = r104;
        int r122 = r105;
    L37:
        HashMap r123 = new HashMap();
        ParserConfig.parserAllFieldToCache(r110, r123);
        if (r113 == false) goto L40;
        List<FieldInfo> r109 = computeGettersWithFieldBase(r110, r111, false, r121);
    L41:
        FieldInfo[] r124 = new FieldInfo[r109.size()];
        r109.toArray(r124);
        if (r108 != null) goto L44;
    L48:
        ArrayList r125 = new ArrayList(r109);
        Collections.sort(r125);
        List<FieldInfo> r126 = r125;
    L49:
        FieldInfo[] r127 = new FieldInfo[r126.size()];
        r126.toArray(r127);
        if (Arrays.equals(r127, r124) == false) goto L52;
        FieldInfo[] r128 = r124;
    L54:
        return new SerializeBeanInfo(r110, r100, r120, r119, r122, r124, r128);
    L52:
        r128 = r127;
        goto L54
    L44:
        if (r108.length == 0) goto L48;
        if (r113 == false) goto L47;
        r126 = computeGettersWithFieldBase(r110, r111, true, r121);
        goto L49
    L47:
        r126 = computeGetters(r110, r100, r111, r123, true, r121);
        goto L49
    L40:
        r109 = computeGetters(r110, r100, r111, r123, false, r121);
        goto L41
    L32:
        if (r114.length() != 0) goto L34;
    L36:
        r121 = r112;
        r108 = null;
        r120 = null;
        r119 = null;
        r122 = 0;
        goto L37
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> r100, Map<String, String> r101, boolean r102, PropertyNamingStrategy r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        Class<?> r105 = r100;
    L3:
        if (r105 == null) goto L6;
        computeFields(r105, r101, r103, r104, r105.getDeclaredFields());
        r105 = r105.getSuperclass();
        goto L3
    L6:
        return getFieldInfos(r100, r102, r104);
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> r100, String r101, String r102, int r103) {
        if (compatibleWithFieldName == true) goto L5;
        return r102;
    L5:
        if (r100.containsKey(r102) == true) goto L11;
        String r104 = r101.substring(r103);
        if (r100.containsKey(r104) == true) goto L9;
        return r102;
    L9:
        return r104;
    L11:
        return r102;
    }

    private static void computeFields(Class<?> r210, Map<String, String> r211, PropertyNamingStrategy r212, Map<String, FieldInfo> r213, Field[] r214) {
        int r100 = r214.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L30;
        Field r110 = r214[r101];
        if (Modifier.isStatic(r110.getModifiers()) == true) goto L29;
        JSONField r111 = (JSONField) getAnnotation(r110, JSONField.class);
        String r102 = r110.getName();
        String r103 = null;
        if (r111 != null) goto L10;
        String r112 = null;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L20:
        if (r211 == null) goto L24;
        r102 = r211.get(r102);
        if (r102 == null) goto L29;
    L24:
        if (r212 == null) goto L26;
        r102 = r212.translate(r102);
    L26:
        String r116 = r102;
        if (r213.containsKey(r116) == true) goto L29;
        r213.put(r116, new FieldInfo(r116, null, r110, r210, null, r113, r114, r115, null, r111, r112));
        goto L29
    L10:
        if (r111.serialize() == false) goto L29;
        int r104 = r111.ordinal();
        int r117 = SerializerFeature.of(r111.serialzeFeatures());
        int r118 = Feature.of(r111.parseFeatures());
        if (r111.name().length() == 0) goto L16;
        r102 = r111.name();
    L16:
        if (r111.label().length() == 0) goto L18;
        r103 = r111.label();
    L18:
        r112 = r103;
        r113 = r104;
        r114 = r117;
        r115 = r118;
    L29:
        r101 = r101 + 1;
        goto L3
    }

    public static List<FieldInfo> computeGetters(Class<?> r410, JSONType r411, Map<String, String> r412, Map<String, Field> r413, boolean r414, PropertyNamingStrategy r415) {
        r410 = r410;
        Map<String, String> r110 = r412;
        PropertyNamingStrategy r111 = r415;
        LinkedHashMap r112 = new LinkedHashMap();
        boolean r113 = isKotlin(r410);
        Annotation[][] r100 = (Annotation[][]) null;
        Method[] r114 = r410.getMethods();
        Arrays.sort(r114, new MethodInheritanceComparator());     // Catch: Throwable -> L275
    L4:
        int r101 = r114.length;
        Constructor<?>[] r102 = null;
        String[] r103 = null;
        short[] r104 = null;
        Annotation[][] r105 = null;
        int r106 = 0;
    L5:
        if (r106 >= r101) goto L273;
        Method r107 = r114[r106];
        String r108 = r107.getName();
        String r115 = null;
        if (Modifier.isStatic(r107.getModifiers()) == false) goto L10;
    L8:
        String[] r116 = r103;
    L9:
        int r210 = r106;
        r101 = r101;
        r114 = r114;
        LinkedHashMap r109 = r112;
    L272:
        r106 = r210 + 1;
        r112 = r109;
        r103 = r116;
        r101 = r101;
        r114 = r114;
        goto L5
    L10:
        Class<?> r117 = r107.getReturnType();
        if (r117.equals(Void.TYPE) == true) goto L8;
        if (r107.getParameterTypes().length != 0) goto L8;
        if (r117 == ClassLoader.class) goto L8;
        if (r117 == InputStream.class) goto L8;
        if (r117 == Reader.class) goto L8;
        if (r108.equals("getMetaClass") == false) goto L28;
        r116 = r103;
        if (r117.getName().equals("groovy.lang.MetaClass") == true) goto L9;
    L30:
        if (r108.equals("getSuppressed") == true) goto L32;
    L34:
        if (r113 == true) goto L36;
    L38:
        Boolean r118 = Boolean.FALSE;
        JSONField r119 = (JSONField) getAnnotation(r107, JSONField.class);
        if (r119 != null) goto L41;
        r119 = getSuperMethodAnnotation(r410, r107);
    L41:
        Boolean r211 = r118;
        LinkedHashMap r212 = r112;
        if (r119 != null) goto L89;
        if (r113 == false) goto L89;
        if (r102 != null) goto L56;
        r102 = r410.getDeclaredConstructors();
        Constructor r213 = getKotlinConstructor(r102);
        if (r213 == null) goto L56;
        r105 = getParameterAnnotations(r213);
        String[] r120 = getKoltinConstructorParameters(r410);
        if (r120 == null) goto L57;
        String[] r121 = new String[r120.length];
        short r122 = 0;
        System.arraycopy(r120, 0, r121, 0, r120.length);
        Arrays.sort(r121);
        short[] r123 = new short[r120.length];
    L51:
        if (r122 >= r120.length) goto L53;
        r123[Arrays.binarySearch(r121, r120[r122])] = r122;
        r122 = (short) (r122 + 1);
        goto L51
    L53:
        r120 = r121;
        r105 = r105;
        r104 = r123;
        r102 = r102;
    L57:
        if (r120 == null) goto L86;
        if (r104 == null) goto L86;
        if (r108.startsWith(MonitorConstants.CONNECT_TYPE_GET) == false) goto L86;
        String r124 = decapitalize(r108.substring(3));
        int r125 = Arrays.binarySearch(r120, r124);
        Constructor<?>[] r214 = r102;
        r210 = r106;
        if (r125 >= 0) goto L70;
        int r126 = 0;
    L65:
        if (r126 >= r120.length) goto L70;
        if (r124.equalsIgnoreCase(r120[r126]) == true) goto L68;
        r126 = r126 + 1;
        goto L65
    L68:
        r125 = r126;
    L70:
        if (r125 < 0) goto L85;
        Annotation[] r127 = r105[r104[r125]];
        if (r127 == null) goto L80;
        int r128 = r127.length;
        short[] r129 = r104;
        int r130 = 0;
    L74:
        Annotation[][] r215 = r105;
        if (r130 >= r128) goto L81;
        Annotation r131 = r127[r130];
        Annotation[] r216 = r127;
        if ((r131 instanceof JSONField) == true) goto L78;
        r130 = r130 + 1;
        r105 = r215;
        r127 = r216;
        goto L74
    L78:
        r119 = (JSONField) r131;
    L81:
        if (r119 != null) goto L87;
        Field r132 = ParserConfig.getFieldFromCache(r124, r413);
        if (r132 == null) goto L87;
        JSONField r217 = (JSONField) getAnnotation(r132, JSONField.class);
    L88:
        Annotation[][] r218 = r215;
        short[] r219 = r129;
        r116 = r120;
    L90:
        if (r217 != null) goto L92;
        int r133 = 0;
        int r134 = 0;
        int r135 = 0;
    L108:
        if (r108.startsWith(MonitorConstants.CONNECT_TYPE_GET) == true) goto L110;
        LinkedHashMap r136 = r212;
        int r137 = 3;
    L197:
        if (r108.startsWith("is") == true) goto L199;
    L267:
        r410 = r410;
    L268:
        r110 = r412;
    L269:
        r111 = r415;
    L270:
        r109 = r136;
    L271:
        r102 = r214;
        r104 = r219;
        r105 = r218;
        goto L272
    L199:
        if (r108.length() < r137) goto L267;
        if (r117 != Boolean.TYPE) goto L204;
    L206:
        char r138 = r108.charAt(2);
        if (Character.isUpperCase(r138) == false) goto L214;
        if (compatibleWithJavaBean == false) goto L211;
        String r139 = decapitalize(r108.substring(2));
    L212:
        String r140 = getPropertyNameByCompatibleFieldName(r413, r108, r139, 2);
    L224:
        Field r141 = null;
    L230:
        if (isJSONTypeIgnore(r410, r140) == true) goto L268;
        if (r141 != null) goto L234;
        r141 = ParserConfig.getFieldFromCache(r140, r413);
    L234:
        if (r141 != null) goto L236;
        r141 = ParserConfig.getFieldFromCache(r108, r413);
    L236:
        if (r141 == null) goto L255;
        JSONField r142 = (JSONField) getAnnotation(r141, JSONField.class);
        if (r142 != null) goto L240;
        r110 = r412;
        int r143 = r133;
        int r144 = r134;
        int r145 = r135;
        JSONField r146 = r142;
    L256:
        if (r110 == null) goto L260;
        r140 = r110.get(r140);
        if (r140 == null) goto L269;
    L260:
        r111 = r415;
        if (r111 == null) goto L263;
        r140 = r111.translate(r140);
    L263:
        String r147 = r140;
        if (r136.containsKey(r147) == true) goto L270;
        r109 = r136;
        r109.put(r147, new FieldInfo(r147, r107, r141, r410, null, r144, r143, r145, r217, r146, r115));
        goto L271
    L240:
        if (r142.serialize() == false) goto L268;
        int r148 = r142.ordinal();
        int r149 = SerializerFeature.of(r142.serialzeFeatures());
        int r150 = Feature.of(r142.parseFeatures());
        if (r142.name().length() == 0) goto L249;
        r140 = r142.name();
        r110 = r412;
        if (r110 == null) goto L251;
        r140 = r110.get(r140);
        if (r140 == null) goto L269;
    L251:
        if (r142.label().length() == 0) goto L253;
        r146 = r142;
        r143 = r149;
        r145 = r150;
        r115 = r142.label();
        r144 = r148;
        goto L256
    L253:
        r144 = r148;
        r146 = r142;
        r143 = r149;
        r145 = r150;
        goto L256
    L249:
        r110 = r412;
        goto L251
    L255:
        r110 = r412;
        r143 = r133;
        r144 = r134;
        r145 = r135;
        r146 = null;
        goto L256
    L211:
        r139 = Character.toLowerCase(r108.charAt(2)) + r108.substring(r137);
        goto L212
    L214:
        if (r138 != '_') goto L222;
        String r151 = r108.substring(r137);
        r141 = r413.get(r151);
        if (r141 != null) goto L220;
        r140 = r108.substring(2);
        r141 = ParserConfig.getFieldFromCache(r140, r413);
        if (r141 != null) goto L230;
        r140 = r151;
        goto L230
    L220:
        r140 = r151;
        goto L230
    L222:
        if (r138 != 'f') goto L225;
        r140 = r108.substring(2);
        goto L224
    L225:
        r140 = r108.substring(2);
        r141 = ParserConfig.getFieldFromCache(r140, r413);
        if (r141 != null) goto L230;
    L204:
        if (r117 == Boolean.class) goto L206;
    L110:
        if (r108.length() >= 4) goto L113;
    L111:
        r109 = r212;
        r111 = r415;
        goto L271
    L113:
        if (r108.equals("getClass") == true) goto L111;
        if (r108.equals("getDeclaringClass") == true) goto L118;
    L120:
        char r152 = r108.charAt(3);
        if (Character.isUpperCase(r152) == true) goto L144;
        if (r152 > 512) goto L144;
        if (r152 != '_') goto L132;
        String r153 = r108.substring(3);
        Field r154 = r413.get(r153);
        if (r154 != null) goto L150;
        String r155 = r108.substring(4);
        Field r156 = ParserConfig.getFieldFromCache(r155, r413);
        if (r156 == null) goto L142;
        r153 = r155;
    L142:
        r154 = r156;
    L150:
        if (isJSONTypeIgnore(r410, r153) == true) goto L111;
        if (r154 != null) goto L154;
        r154 = ParserConfig.getFieldFromCache(r153, r413);
    L154:
        if (r154 != null) goto L163;
        if (r153.length() <= 1) goto L163;
        char r157 = r153.charAt(1);
        if (r157 < 'A') goto L163;
        if (r157 > 'Z') goto L163;
        r154 = ParserConfig.getFieldFromCache(decapitalize(r108.substring(3)), r413);
    L163:
        Field r158 = r154;
        if (r158 == null) goto L183;
        JSONField r159 = (JSONField) getAnnotation(r158, JSONField.class);
        if (r159 != null) goto L168;
        JSONField r160 = r159;
    L184:
        int r220 = r134;
    L185:
        if (r110 == null) goto L190;
        r153 = r110.get(r153);
        if (r153 == null) goto L111;
    L190:
        if (r415 != null) goto L192;
    L194:
        r137 = 3;
        r136 = r212;
        r136.put(r153, new FieldInfo(r153, r107, r158, r410, null, r220, r133, r135, r217, r160, r115));
        r133 = r133;
        r134 = r220;
        r135 = r135;
        r115 = r115;
        goto L197
    L192:
        if (r211.booleanValue() == true) goto L194;
        r153 = r415.translate(r153);
        goto L194
    L168:
        if (r159.serialize() == false) goto L111;
        int r161 = r159.ordinal();
        int r162 = SerializerFeature.of(r159.serialzeFeatures());
        int r163 = Feature.of(r159.parseFeatures());
        if (r159.name().length() == 0) goto L177;
        Boolean r164 = Boolean.TRUE;
        String r165 = r159.name();
        if (r110 == null) goto L179;
        r165 = r110.get(r165);
        if (r165 == null) goto L111;
    L179:
        if (r159.label().length() == 0) goto L181;
        r115 = r159.label();
    L181:
        r220 = r161;
        r135 = r163;
        r115 = r115;
        r133 = r162;
        String r310 = r165;
        r160 = r159;
        r211 = r164;
        r153 = r310;
        goto L185
    L177:
        r165 = r153;
        r164 = r211;
        goto L179
    L183:
        r160 = null;
        goto L184
    L132:
        if (r152 != 'f') goto L135;
        r153 = r108.substring(3);
    L148:
        r154 = null;
        goto L150
    L135:
        if (r108.length() >= 5) goto L137;
    L139:
        r153 = r108.substring(3);
        r156 = ParserConfig.getFieldFromCache(r153, r413);
        if (r156 != null) goto L142;
    L137:
        if (Character.isUpperCase(r108.charAt(4)) == false) goto L139;
        r153 = decapitalize(r108.substring(3));
    L144:
        if (compatibleWithJavaBean == false) goto L146;
        String r166 = decapitalize(r108.substring(3));
    L147:
        r153 = getPropertyNameByCompatibleFieldName(r413, r108, r166, 3);
        goto L148
    L146:
        r166 = getPropertyNameByMethodName(r108);
        goto L147
    L118:
        if (r410.isEnum() == false) goto L120;
    L92:
        if (r217.serialize() == true) goto L94;
    L93:
        r101 = r101;
        r114 = r114;
        r109 = r212;
        goto L271
    L94:
        int r167 = r217.ordinal();
        int r168 = SerializerFeature.of(r217.serialzeFeatures());
        r135 = Feature.of(r217.parseFeatures());
        if (r217.name().length() == 0) goto L103;
        String r169 = r217.name();
        if (r110 == null) goto L101;
        r169 = r110.get(r169);
        if (r169 == null) goto L93;
    L101:
        String r170 = r169;
        r101 = r101;
        r114 = r114;
        r212 = r212;
        r212.put(r170, new FieldInfo(r170, r107, null, r410, null, r167, r168, r135, r217, null, null));
        goto L111
    L103:
        if (r217.label().length() == 0) goto L105;
        r115 = r217.label();
    L105:
        r133 = r168;
        r134 = r167;
    L87:
        r217 = r119;
        goto L88
    L80:
        r129 = r104;
        r215 = r105;
        goto L81
    L85:
        r129 = r104;
        r215 = r105;
    L86:
        r214 = r102;
        r129 = r104;
        r215 = r105;
        r210 = r106;
    L56:
        r120 = r116;
    L89:
        r117 = r117;
        r210 = r106;
        r214 = r102;
        r219 = r104;
        r218 = r105;
        r217 = r119;
        goto L90
    L36:
        if (isKotlinIgnore(r410, r108) == false) goto L38;
    L32:
        if (r107.getDeclaringClass() != Throwable.class) goto L34;
    L28:
        r116 = r103;
        goto L30
    L273:
        LinkedHashMap r171 = r112;
        computeFields(r410, r110, r111, r171, r410.getFields());
        return getFieldInfos(r410, r414, r171);
    }
}
