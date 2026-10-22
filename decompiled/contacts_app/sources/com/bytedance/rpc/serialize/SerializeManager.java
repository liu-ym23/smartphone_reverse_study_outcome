package com.bytedance.rpc.serialize;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldFrom;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.annotation.RpcFieldTo;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.internal.TypeUtils;
import com.bytedance.rpc.transport.TransportInput;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SerializeManager {
    private static final Pattern CHARSET = null;
    private String ACCEPT;
    private boolean mAllowResolvedFactory;
    private final Map<SerializeType, SerializeFactory> mSerializerFactory;

    public SerializeManager() {
        this.ACCEPT = "";
        this.mSerializerFactory = new HashMap(2);
        this.mAllowResolvedFactory = true;
    }

    public void registerSerializeFactory(SerializeFactory r6) {
        if (r6 == null) goto L21;
        SerializeType r0 = r6.getSerializeType();
        if (r0 == null) goto L24;
        Map<SerializeType, SerializeFactory> r1 = this.mSerializerFactory;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.mSerializerFactory.put(r0, r6) != null) goto L16;
        String r7 = this.ACCEPT;     // Catch: Throwable -> L18
        if (r7 != null) goto L12;
    L15:
        this.ACCEPT = r0.getContentType();     // Catch: Throwable -> L18
        goto L16
    L12:
        if (r7.length() == 0) goto L15;
        this.ACCEPT = String.format("%s,%s", new Object[]{this.ACCEPT, r0.getContentType()});     // Catch: Throwable -> L18
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    }

    public void removeSerializeFactory(SerializeType r5) {
        if (r5 == null) goto L23;
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (this.mAllowResolvedFactory == false) goto L9;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L20
    L9:
        if (this.mSerializerFactory.remove(r5) == null) goto L18;
        StringBuilder r6 = new StringBuilder(this.ACCEPT.length());     // Catch: Throwable -> L20
        Iterator<SerializeType> r1 = this.mSerializerFactory.keySet().iterator();     // Catch: Throwable -> L20
    L12:
        if (r1.hasNext() == false) goto L15;
        r6.append(r1.next().getContentType()).append(',');     // Catch: Throwable -> L20
        goto L12
    L15:
        if (r6.length() <= 0) goto L17;
        r6.deleteCharAt(r6.length() - 1);     // Catch: Throwable -> L20
    L17:
        this.ACCEPT = r6.toString();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    }

    public TransportInput createTransportInput(final byte[] r2, final SerializeType r3) {
        return new AnonymousClass1(this, r3, r2);
    }

    public SerializeFactory getSerializeFactory(SerializeType r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Map<SerializeType, SerializeFactory> r1 = this.mSerializerFactory;
        monitor-enter(r1);
        SerializeFactory r2 = this.mSerializerFactory.get(r4);     // Catch: Throwable -> L18
        if (r2 == null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r2;
    L12:
        if (this.mAllowResolvedFactory == false) goto L16;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L18
        SerializeFactory r3 = this.mSerializerFactory.get(r4);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r3;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public SerializeType[] getSupportedSerializeType() {
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mAllowResolvedFactory == false) goto L7;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L12
    L7:
        int r1 = this.mSerializerFactory.size();     // Catch: Throwable -> L12
        SerializeType[] r2 = new SerializeType[r1];     // Catch: Throwable -> L12
        if (r1 <= 0) goto L10;
        this.mSerializerFactory.keySet().toArray(r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    public String getAcceptContentTypes() {
        if (this.mAllowResolvedFactory == false) goto L15;
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAllowResolvedFactory == false) goto L9;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.ACCEPT;
    }

    public void clear() {
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
        this.mAllowResolvedFactory = false;     // Catch: Throwable -> L8
        this.mSerializerFactory.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isSerializeSupported(SerializeType r3) {
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAllowResolvedFactory == false) goto L7;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L10
    L7:
        boolean r2 = this.mSerializerFactory.containsKey(r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    private void resolveFactoryFromDependencies() {
        if (this.mSerializerFactory.get(SerializeType.JSON) != null) goto L6;
        registerSerializeFactory(createFactory("com.bytedance.rpc.serialize.JsonSerializeFactory"));
    L6:
        if (this.mSerializerFactory.get(SerializeType.PB) != null) goto L13;
        SerializeFactory r0 = createFactory("com.bytedance.rpc.serialize.PbSerializeFactory");
        SerializeFactory r2 = createFactory("com.bytedance.rpc.serialize.WireSerializeFactory");
        if (r0 == null) goto L11;
        if (r2 == null) goto L11;
        registerSerializeFactory(new SerializeFactoryContainer(r0.getSerializeType(), new SerializeFactory[]{r0, r2}));
    L11:
        registerSerializeFactory(r0);
        registerSerializeFactory(r2);
    L13:
        if (this.mSerializerFactory.get(SerializeType.THRIFT) != null) goto L15;
        registerSerializeFactory(createFactory("com.bytedance.rpc.serialize.ThriftSerializeFactory"));
    L15:
        Object r1 = TypeUtils.instance("com.bytedance.rpc.rxjava.RxJavaInvokeInterceptor");
        if ((r1 instanceof RpcInvokeInterceptor) == false) goto L18;
        RpcService.addRpcInvokeInterceptor((RpcInvokeInterceptor) r1);
    L18:
        this.mAllowResolvedFactory = false;
    }

    private SerializeFactory createFactory(String r1) {
        Object r0 = TypeUtils.instance(r1);
        if ((r0 instanceof SerializeFactory) == true) goto L7;
        return null;
    L7:
        return (SerializeFactory) r0;
    }

    public SerializeType parserDeserializerType(String r7, Type r8, SerializeType r9) {
        SerializeType r6 = SerializeType.parser(r7);
        if (r6 != null) goto L13;
        if (r7 == null) goto L13;
        String[] r0 = SerializeType.getTypeAndSubType(r7);
        if (r0.length <= 0) goto L13;
        SerializeType[] r1 = SerializeType.values();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L13;
        SerializeType r4 = r1[r3];
        if (Arrays.equals(r0, r4.getTypeAndSubType()) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        r6 = r4;
    L13:
        if (r6 == null) goto L15;
    L21:
        if (r6 != null) goto L24;
        return r9;
    L24:
        return r6;
    L15:
        if (r8 != String.class) goto L21;
        if (r7.contains("text") == false) goto L19;
    L20:
        r6 = SerializeType.JSON;
        goto L21
    L19:
        if (r7.contains("html") == false) goto L21;
        goto L20
    }

    private static Object convertNumber(Type r1, String r2) {
        if ((r1 instanceof Class) == false) goto L42;
        Class<?> r3 = (Class) r1;
    L37:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        if (Integer.class.isAssignableFrom(r3) == true) goto L36;
        if (Integer.TYPE.isAssignableFrom(r3) == true) goto L36;
        if (Long.class.isAssignableFrom(r3) == true) goto L34;
        if (Long.TYPE.isAssignableFrom(r3) == true) goto L34;
        if (Float.class.isAssignableFrom(r3) == true) goto L32;
        if (Float.TYPE.isAssignableFrom(r3) == true) goto L32;
        if (Double.class.isAssignableFrom(r3) == true) goto L30;
        if (Double.TYPE.isAssignableFrom(r3) == true) goto L30;
        if (BigDecimal.class.isAssignableFrom(r3) == true) goto L28;
        return null;
    L28:
        return new BigDecimal(r2);
    L30:
        return Double.valueOf(Double.parseDouble(r2));
    L32:
        return Float.valueOf(Float.parseFloat(r2));
    L34:
        return Long.valueOf(Long.parseLong(r2));
    L36:
        return Integer.valueOf(Integer.parseInt(r2));
    L42:
        return null;
    }

    public static void fillResult(Object r7, Map<String, String> r8) {
        if (r7.getClass().getAnnotation(RpcFieldModify.class) != null) goto L5;
        return;
    L5:
        Field[] r0 = r7.getClass().getDeclaredFields();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length <= 0) goto L51;
        int r1 = r0.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L52;
        Field r3 = r0[r2];
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L38;
        RpcField r4 = (RpcField) r3.getAnnotation(RpcField.class);
        RpcFieldFrom r5 = (RpcFieldFrom) r3.getAnnotation(RpcFieldFrom.class);
        if (r4 != null) goto L18;
        if (r5 != null) goto L17;
        FieldType r6 = null;
    L19:
        if (r6 == null) goto L38;
        if (r6 != FieldType.HEADER) goto L38;
        SerializedName r9 = (SerializedName) r3.getAnnotation(SerializedName.class);     // Catch: Exception -> L36
        if (r9 != null) goto L26;
        String r10 = r3.getName();     // Catch: Exception -> L36
    L27:
        String r11 = r8.get(r10);     // Catch: Exception -> L36
        if (r11 == null) goto L38;
        r3.setAccessible(true);     // Catch: Exception -> L36
        if (CharSequence.class.isAssignableFrom(r3.getType()) == false) goto L32;
        r3.set(r7, r11);     // Catch: Exception -> L36
        goto L38
    L32:
        Object r12 = convertNumber(r3.getType(), r11);     // Catch: Exception -> L36
        if (r12 == null) goto L38;
        r3.set(r7, r12);     // Catch: Exception -> L36
        goto L38
    L26:
        r10 = r9.value();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L17:
        r6 = r5.value();
        goto L19
    L18:
        r6 = r4.value();
    L38:
        r2 = r2 + 1;
        goto L10
    L52:
        return;
    }

    public static void dump(Object r7, Map<String, String> r8, Map<String, String> r9, Map<String, Object> r10) {
        if (r7 == null) goto L59;
        if (r8 != null) goto L7;
        if (r9 != null) goto L7;
        if (r10 != null) goto L7;
        return;
    L7:
        Field[] r0 = r7.getClass().getDeclaredFields();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length <= 0) goto L74;
        int r1 = r0.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L76;
        Field r3 = r0[r2];
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L58;
        RpcField r4 = (RpcField) r3.getAnnotation(RpcField.class);
        RpcFieldTo r5 = (RpcFieldTo) r3.getAnnotation(RpcFieldTo.class);
        if (r4 != null) goto L20;
        if (r5 != null) goto L19;
        FieldType r6 = null;
    L21:
        if (r6 == null) goto L58;
        r3.setAccessible(true);     // Catch: Exception -> L56
        Object r11 = r3.get(r7);     // Catch: Exception -> L56
        if (r11 == null) goto L58;
        if (r6 == FieldType.HEADER) goto L42;
        if (r6 == FieldType.QUERY) goto L42;
        if (r6 != FieldType.BODY) goto L58;
        if (r10 == null) goto L58;
        SerializedName r12 = (SerializedName) r3.getAnnotation(SerializedName.class);     // Catch: Exception -> L56
        if (r12 != null) goto L39;
        String r13 = r3.getName();     // Catch: Exception -> L56
    L40:
        r10.put(r13, convertIfEnum(r11));     // Catch: Exception -> L56
        goto L58
    L39:
        r13 = r12.value();     // Catch: Exception -> L56
    L42:
        if (r6 != FieldType.HEADER) goto L44;
        Map<String, String> r14 = r8;
    L45:
        if (r14 == null) goto L58;
        if ((r11 instanceof Map) == false) goto L50;
        dumpMap(r14, (Map) r11);     // Catch: Exception -> L56
        goto L58
    L50:
        SerializedName r15 = (SerializedName) r3.getAnnotation(SerializedName.class);     // Catch: Exception -> L56
        if (r15 != null) goto L53;
        String r16 = r3.getName();     // Catch: Exception -> L56
    L54:
        r14.put(r16, String.valueOf(convertIfEnum(r11)));     // Catch: Exception -> L56
        goto L58
    L53:
        r16 = r15.value();     // Catch: Exception -> L56
        goto L54
    L44:
        r14 = r9;
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L19:
        r6 = r5.value();
        goto L21
    L20:
        r6 = r4.value();
    L58:
        r2 = r2 + 1;
        goto L12
    L76:
        return;
    L74:
        return;
    }

    public static Map<String, String> dumpQuery(Object r13, Map<String, String> r14) throws Exception {
        if (r14 != null) goto L5;
        r14 = new HashMap(8);
    L5:
        if ((r13 instanceof Object[]) == false) goto L7;
        Object[] r15 = (Object[]) r13;
    L8:
        int r0 = r15.length;
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L64;
        Object r4 = r15[r3];
        if (r4 == null) goto L63;
        Class<?> r5 = r4.getClass();
        if (Map.class.isAssignableFrom(r5) == false) goto L17;
        dumpMap(r14, (Map) r4);
        goto L63
    L17:
        if (JsonObject.class.isAssignableFrom(r5) == false) goto L20;
        dumpJson(r14, (JsonObject) r4);
        goto L63
    L20:
        if (JSONObject.class.isAssignableFrom(r5) == false) goto L22;
        dumpJSON(r14, (JSONObject) r4);
        goto L63
    L22:
        Field[] r6 = r4.getClass().getDeclaredFields();
        if (r6 == null) goto L63;
        if (r6.length <= 0) goto L63;
        int r7 = r6.length;
        int r8 = 0;
    L27:
        if (r8 >= r7) goto L63;
        Field r9 = r6[r8];
        if (Modifier.isStatic(r9.getModifiers()) == true) goto L62;
        if (r9.getAnnotation(RpcFieldTo.class) != null) goto L62;
        if (r9.getAnnotation(RpcField.class) != null) goto L62;
        r9.setAccessible(true);
        Object r10 = r9.get(r4);
        if (r10 == null) goto L62;
        if ((r10 instanceof Map) == false) goto L42;
        dumpMap(r14, (Map) r10);
        goto L62
    L42:
        if ((r10 instanceof List) == false) goto L57;
        SerializedName r11 = (SerializedName) r9.getAnnotation(SerializedName.class);
        if (r11 != null) goto L46;
        String r12 = r9.getName();
    L47:
        StringBuilder r16 = new StringBuilder();
        Iterator r17 = ((List) r10).iterator();
    L49:
        if (r17.hasNext() == false) goto L53;
        Object r18 = r17.next();
        if (r18 == null) goto L49;
        r16.append(convertIfEnum(r18).toString()).append(SimContactsConstants.EMAIL_SEP);
        goto L49
    L53:
        String r19 = r16.toString();
        if (r19.length() <= 0) goto L56;
        r19 = r19.substring(0, r19.length() - 1);
    L56:
        r14.put(r12, r19);
        goto L62
    L46:
        r12 = r11.value();
        goto L47
    L57:
        SerializedName r110 = (SerializedName) r9.getAnnotation(SerializedName.class);
        if (r110 != null) goto L60;
        String r20 = r9.getName();
    L61:
        r14.put(r20, String.valueOf(convertIfEnum(r10)));
        goto L62
    L60:
        r20 = r110.value();
    L62:
        r8 = r8 + 1;
    L63:
        r3 = r3 + 1;
        goto L9
    L64:
        return r14;
    L7:
        r15 = new Object[]{r13};
        goto L8
    }

    private static Object convertIfEnum(Object r2) throws NoSuchFieldException {
        if ((r2 instanceof Enum) == false) goto L13;
        SerializedName r0 = (SerializedName) r2.getClass().getField(String.valueOf(r2)).getAnnotation(SerializedName.class);
        if (r0 != null) goto L7;
        String r1 = null;
    L8:
        if (r1 != null) goto L10;
        return r2;
    L10:
        if (r1.length() > 0) goto L12;
        return r2;
    L12:
        return r1;
    L7:
        r1 = r0.value();
        goto L8
    L13:
        return r2;
    }

    private static void dumpMap(Map<String, String> r2, Map<?, ?> r3) {
        if (r3.isEmpty() == true) goto L11;
        Iterator<Map.Entry<?, ?>> r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L19;
        Map.Entry<?, ?> r0 = r4.next();
        Object r1 = r0.getKey();
        Object r5 = r0.getValue();
        if (r1 == null) goto L6;
        if (r5 == null) goto L6;
        r2.put(String.valueOf(r1), String.valueOf(r5));
        goto L6
    L19:
        return;
    }

    private static void dumpJson(Map<String, String> r2, JsonObject r3) {
        Set<Map.Entry<String, JsonElement>> r4 = r3.entrySet();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.size() <= 0) goto L21;
        Iterator<Map.Entry<String, JsonElement>> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L22;
        Map.Entry<String, JsonElement> r0 = r5.next();
        String r1 = r0.getKey();
        JsonElement r6 = r0.getValue();
        if (r1 == null) goto L8;
        if (r6 == null) goto L8;
        r2.put(r1, r6.getAsString());
        goto L8
    L22:
        return;
    }

    private static void dumpJSON(Map<String, String> r3, JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length() == 0) goto L21;
        Iterator<String> r0 = r4.keys();
    L8:
        if (r0.hasNext() == false) goto L22;
        String r1 = r0.next();
        Object r2 = r4.opt(r1);
        if (r1 == null) goto L8;
        if (r2 == null) goto L8;
        r3.put(r1, String.valueOf(r2));
        goto L8
    L22:
        return;
    }

    static {
        CHARSET = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    public static String parseCharset(String r1, String r2) {
        Matcher r3 = CHARSET.matcher(r1);
        if (r3.find() == true) goto L5;
        return r2;
    L5:
        return r3.group(1).replaceAll("[\"\\\\]", "");
    }
}
