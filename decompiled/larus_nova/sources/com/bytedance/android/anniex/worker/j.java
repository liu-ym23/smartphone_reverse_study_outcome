package com.bytedance.android.anniex.worker;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import me7.l;
import me7.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements com.bytedance.sdk.xbridge.cn.protocol.g<ReadableMap, ReadableMap> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41514a = null;

        static {
            int[] r100 = new int[DefaultType.values().length];
            r100[DefaultType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DefaultType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f41514a = r100;
        }
    }

    public static final class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f41515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class<? extends XBaseModel> f41516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap<String, Object> f41517c;

        public b(j r100, Class<? extends XBaseModel> r101, HashMap<String, Object> r102) {
            this.f41515a = r100;
            this.f41516b = r101;
            this.f41517c = r102;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            if (Intrinsics.areEqual(r101.getName(), "toJSON") == true) goto L5;
            XBridgeParamField r103 = (XBridgeParamField) r101.getAnnotation(XBridgeParamField.class);
            Object r104 = this.f41517c.get(r103.keyPath());
            return this.f41515a.e(r104, r103);
        L5:
            return new JSONObject(this.f41515a.g(this.f41516b, this.f41517c));
        }
    }

    public j() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final Map d(ReadableMap r100) {
        ReadableMap r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        return h.c((JavaOnlyMap) r101);
    }

    public final int f(Object r100) {
        if ((r100 instanceof Number) == true) goto L5;
        if (r100 != null) goto L10;
        throw new IllegalInputParamException("the key is null");
    L10:
        throw new IllegalInputParamException("the key is not a number");
    L5:
        return ((Number) r100).intValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final /* bridge */ /* synthetic */ Map b(ReadableMap r100, Class r101) {
        return k(r100, r101);
    }

    public final Object e(Object r100, XBridgeParamField r101) {
        boolean r102 = false;
        Class<? extends XBaseModel> r103 = null;
        if ((r100 instanceof Map) == false) goto L10;
        if (r101 == null) goto L6;
        KClass r104 = Reflection.getOrCreateKotlinClass(r101.nestedClassType());
    L8:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L10;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L17;
        if (r101 == null) goto L15;
        r103 = r101.nestedClassType();
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        return j(r103, ((ReadableMap) r100).toHashMap());
    L17:
        if ((r100 instanceof List) == false) goto L24;
        if (r101 == null) goto L20;
        KClass r106 = Reflection.getOrCreateKotlinClass(r101.nestedClassType());
    L22:
        if (Intrinsics.areEqual(r106, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L24;
        r102 = true;
        goto L24
    L20:
        r106 = null;
    L24:
        if (r102 == false) goto L34;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List r107 = (List) r100;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L27:
        if (r109.hasNext() == false) goto L40;
        Object r110 = r109.next();
        if (r101 == null) goto L31;
        Class<? extends XBaseModel> r111 = r101.nestedClassType();
    L32:
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        r108.add(j(r111, ((ReadableMap) r110).toHashMap()));
        goto L27
    L31:
        r111 = null;
        goto L32
    L40:
        return r108;
    L34:
        h.f41506a.getClass();
        return h.h(r100);
    L6:
        r104 = null;
    L10:
        r105 = false;
        goto L12
    }

    public final HashMap<String, Object> g(Class<? extends XBaseModel> r100, HashMap<String, Object> r110) {
        HashMap<String, Object> r101 = null;
        if (r100 == null) goto L17;
        Method[] r102 = r100.getDeclaredMethods();
        if (r102 == null) goto L17;
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L18;
        Method r106 = r102[r105];
        XBridgeParamField r107 = (XBridgeParamField) r106.getAnnotation(XBridgeParamField.class);
        if (r107 == null) goto L13;
        boolean r108 = true;
        if (r107.isGetter() != true) goto L13;
    L14:
        if (r108 == false) goto L16;
        r103.add(r106);
    L16:
        r105 = r105 + 1;
    L13:
        r108 = false;
    L18:
        if (r103 == null) goto L43;
        r101 = new HashMap();
        Iterator r109 = r103.iterator();
    L21:
        if (r109.hasNext() == false) goto L43;
        Method r111 = (Method) r109.next();
        XBridgeParamField r112 = (XBridgeParamField) r111.getAnnotation(XBridgeParamField.class);
        Object r113 = r110.get(r112.keyPath());
        if (r113 == null) goto L25;
    L27:
        String r114 = r112.keyPath();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r112.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L33;
        if ((r113 instanceof ReadableMap) == false) goto L33;
        Object r115 = g(r112.nestedClassType(), ((ReadableMap) r113).toHashMap());
    L42:
        r101.put(r114, r115);
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r112.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == false) goto L35;
    L41:
        r115 = r110.get(r112.keyPath());
        goto L42
    L35:
        if ((r113 instanceof ReadableArray) == false) goto L41;
        ArrayList<Object> r116 = ((ReadableArray) r113).toArrayList();
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L38:
        if (r118.hasNext() == false) goto L40;
        Object r119 = r118.next();
        Class<? extends XBaseModel> r120 = r112.nestedClassType();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        r117.add(g(r120, ((ReadableMap) r119).toHashMap()));
        goto L38
    L40:
        r115 = r117;
        goto L42
    L25:
        if (r112.defaultValue().type() == DefaultType.NONE) goto L27;
        r110.put(r112.keyPath(), h(r111, r112));
    L43:
        return r101;
    L17:
        r103 = null;
        goto L18
    }

    public final Object h(Method r100, XBridgeParamField r101) {
        Class<?> r102 = r100.getReturnType();
        boolean r103 = true;
        if (Intrinsics.areEqual(r102, Number.class) == false) goto L15;
        DefaultType r104 = r101.defaultValue().type();
        int r105 = a.f41514a[r104.ordinal()];
        if (r105 == 1) goto L25;
        if (r105 == 2) goto L24;
        if (r105 == 3) goto L23;
        return Integer.valueOf(r101.defaultValue().intValue());
    L23:
        return Integer.valueOf(r101.defaultValue().intValue());
    L24:
        return Long.valueOf(r101.defaultValue().longValue());
    L25:
        return Double.valueOf(r101.defaultValue().doubleValue());
    L15:
        if (Intrinsics.areEqual(r102, Boolean.TYPE) == true) goto L18;
        r103 = Intrinsics.areEqual(r102, Boolean.class);
    L18:
        if (r103 == false) goto L21;
        return Boolean.valueOf(r101.defaultValue().boolValue());
    L21:
        return r101.defaultValue().stringValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HashMap<String, Pair<Method, XBridgeParamField>> i(Class<? extends XBaseModel> r110, HashMap<String, Object> r111) {
        if (r110 == null) goto L130;
        Method[] r112 = r110.getDeclaredMethods();
        if (r112 == null) goto L177;
        HashMap<String, Pair<Method, XBridgeParamField>> r100 = new HashMap();
        int r101 = r112.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        Method r103 = r112[r102];
        XBridgeParamField r104 = (XBridgeParamField) r103.getAnnotation(XBridgeParamField.class);
        if (r104 == null) goto L10;
        r100.put(r104.keyPath(), new Pair(r103, r104));
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator<Map.Entry<String, Pair<Method, XBridgeParamField>>> r105 = r100.entrySet().iterator();
    L12:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L22;
        Map.Entry<String, Pair<Method, XBridgeParamField>> r107 = r105.next();
        if (r111.get(r107.getKey()) == null) goto L17;
    L19:
        r106 = false;
    L20:
        if (r106 == false) goto L12;
        r113.put(r107.getKey(), r107.getValue());
        goto L12
    L17:
        if (r107.getValue().getSecond().defaultValue().type() == DefaultType.NONE) goto L19;
    L22:
        Iterator r114 = r113.entrySet().iterator();
    L24:
        if (r114.hasNext() == false) goto L26;
        Map.Entry r108 = (Map.Entry) r114.next();
        r111.put(r108.getKey(), h((Method) ((Pair) r108.getValue()).getFirst(), (XBridgeParamField) ((Pair) r108.getValue()).getSecond()));
        goto L24
    L26:
        Iterator<Map.Entry<String, Pair<Method, XBridgeParamField>>> r115 = r100.entrySet().iterator();
    L28:
        if (r115.hasNext() == false) goto L129;
        Map.Entry<String, Pair<Method, XBridgeParamField>> r109 = r115.next();
        XBridgeParamField r116 = r109.getValue().getSecond();
        Method r117 = r109.getValue().getFirst();
        Object r118 = r111.get(r109.getKey());
        if (r116.required() == false) goto L35;
        if (r118 != null) goto L35;
        throw new IllegalInputParamException(r109.getKey() + " param is missing from input");
    L35:
        Class<?> r119 = r117.getReturnType();
        if (Intrinsics.areEqual(r119, String.class) == false) goto L44;
        if (r118 != null) goto L39;
    L78:
        if (r118 == null) goto L28;
        if (r116.isEnum() == false) goto L28;
        Class<?> r120 = r117.getReturnType();
        if (Intrinsics.areEqual(r120, String.class) == true) goto L83;
        if (Intrinsics.areEqual(r120, Number.class) == true) goto L90;
        if (Intrinsics.areEqual(r120, Map.class) == false) goto L28;
        XBridgeStringEnum r121 = (XBridgeStringEnum) r117.getAnnotation(XBridgeStringEnum.class);
        if (r121 != null) goto L99;
        XBridgeIntEnum r122 = (XBridgeIntEnum) r117.getAnnotation(XBridgeIntEnum.class);
        if (r122 == null) goto L28;
        int[] r123 = r122.option();
        Map r124 = (Map) r118;
        if (r124.isEmpty() == true) goto L124;
        Iterator r125 = r124.entrySet().iterator();
    L120:
        if (r125.hasNext() == false) goto L124;
        if ((!ArraysKt.contains(r123, f(((Map.Entry) r125.next()).getValue()))) == false) goto L120;
        boolean r126 = true;
    L125:
        if (r126 == false) goto L28;
        throw new IllegalInputParamException(r109.getKey() + " has wrong value.should be one of " + ArraysKt.asList(r123) + " but got " + r118);
    L124:
        r126 = false;
        goto L125
    L99:
        String[] r127 = r121.option();
        Map r128 = (Map) r118;
        if (r128.isEmpty() == true) goto L108;
        Iterator r129 = r128.entrySet().iterator();
    L104:
        if (r129.hasNext() == false) goto L108;
        if ((!ArraysKt.contains(r127, ((Map.Entry) r129.next()).getValue())) == false) goto L104;
        boolean r130 = true;
    L109:
        if (r130 == false) goto L28;
        throw new IllegalInputParamException(r109.getKey() + " has wrong type.should be one of " + ArraysKt.asList(r127) + " but got " + r118);
    L108:
        r130 = false;
        goto L109
    L90:
        int[] r131 = ((XBridgeIntEnum) r117.getAnnotation(XBridgeIntEnum.class)).option();
        if (ArraysKt.contains(r131, f(r118)) == true) goto L28;
        throw new IllegalInputParamException(r109.getKey() + " has wrong value.should be one of " + ArraysKt.asList(r131) + " but got " + r118);
    L83:
        String[] r132 = ((XBridgeStringEnum) r117.getAnnotation(XBridgeStringEnum.class)).option();
        if (ArraysKt.contains(r132, r118) == true) goto L28;
        throw new IllegalInputParamException(r109.getKey() + " has wrong type.should be one of " + ArraysKt.asList(r132) + " but got " + r118);
    L39:
        if ((r118 instanceof String) == true) goto L78;
        throw new IllegalInputParamException(r109.getKey() + " param has wrong declared type. except string,but " + r118.getClass());
    L44:
        if (Intrinsics.areEqual(r119, Number.class) == false) goto L52;
        if (r118 == null) goto L78;
        if ((r118 instanceof Number) == true) goto L78;
        throw new IllegalInputParamException(r109.getKey() + " param has wrong declared type. except number,but " + r118.getClass());
    L52:
        if (Intrinsics.areEqual(r119, Boolean.class) == false) goto L54;
        boolean r133 = true;
    L55:
        if (r133 == false) goto L63;
        if (r118 == null) goto L78;
        if ((r118 instanceof Boolean) == true) goto L78;
        throw new IllegalInputParamException(r109.getKey() + " param has wrong declared type. except boolean,but " + r118.getClass());
    L63:
        if (Intrinsics.areEqual(r119, List.class) == false) goto L71;
        if (r118 == null) goto L78;
        if ((r118 instanceof List) == true) goto L78;
        throw new IllegalInputParamException(r109.getKey() + " param has wrong declared type. except List ,but " + r118.getClass());
    L71:
        if (Intrinsics.areEqual(r119, Map.class) == false) goto L78;
        if (r118 == null) goto L78;
        if ((r118 instanceof Map) == true) goto L78;
        throw new IllegalInputParamException(r109.getKey() + " param has wrong declared type. except Map ,but " + r118.getClass());
    L54:
        r133 = Intrinsics.areEqual(r119, Boolean.TYPE);
        goto L55
    L129:
        return r100;
    L177:
        return null;
    L130:
        return null;
    }

    public final Object j(Class<? extends XBaseModel> r100, HashMap<String, Object> r101) throws IllegalInputParamException {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (i(r100, r101) != null) goto L9;
        return null;
    L9:
        return Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new b(this, r100, r101));
    }

    public final Map<String, Object> k(ReadableMap r100, Class<? extends IDLXBridgeMethod> r101) throws IllegalInputParamException {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        me7.f r102 = o.f513548a.get(r101);
        if (r102 == null) goto L11;
        int r103 = i.f41508a;
        HashMap<String, Object> r104 = r100.toHashMap();
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        me7.g r105 = i.e(r102.f513526c, r104);
        if (r105 == null) goto L33;
        LinkedHashMap r106 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator<T> r107 = r104.entrySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L35;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.put(r108.getKey(), i.a(r108.getValue(), r105.f513530b.get(r108.getKey()), r102));
        goto L9
    L35:
        return r106;
    L33:
        return null;
    L11:
        Class<? extends XBaseModel> r109 = l.a(r101);
        if (r109 != null) goto L16;
        r109 = id7.e.c(r101);
        if (r109 != null) goto L16;
        return null;
    L16:
        HashMap<String, Object> r110 = r100.toHashMap();
        HashMap<String, Pair<Method, XBridgeParamField>> r111 = i(r109, r110);
        if (r111 == null) goto L34;
        LinkedHashMap r112 = new LinkedHashMap(MapsKt.mapCapacity(r110.size()));
        Iterator<T> r113 = r110.entrySet().iterator();
    L21:
        if (r113.hasNext() == false) goto L28;
        Map.Entry r114 = (Map.Entry) r113.next();
        Object r115 = r114.getKey();
        Pair<Method, XBridgeParamField> r116 = r111.get(r114.getKey());
        if (r116 == null) goto L25;
        XBridgeParamField r117 = r116.getSecond();
    L26:
        r112.put(r115, e(r114.getValue(), r117));
        goto L21
    L25:
        r117 = null;
        goto L26
    L28:
        return r112;
    L34:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final ReadableMap a(Map r100, Class r101, le7.a<ReadableMap> r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Object r103 = r100.get("__jsb2__data__");
        if (r103 == null) goto L6;
        return h.e((JSONObject) r103);
    L6:
        return h.f(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final Map c(ReadableMap r100, Class r101, String r102) {
        ReadableMap r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "nameSpace");
        return k(r103, r101);
    }
}
