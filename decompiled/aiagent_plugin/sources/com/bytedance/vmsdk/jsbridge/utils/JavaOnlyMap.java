package com.bytedance.vmsdk.jsbridge.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    private static final String TAG = "JavaOnlyMap";

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public /* bridge */ /* synthetic */ ReadableArray getArray(String r1) {
        return getArray(r1);
    }

    public static JavaOnlyMap a(Map r2) {
        return new JavaOnlyMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    private JavaOnlyMap(Map r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public JavaOnlyMap() {
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean hasKey(String r1) {
        return containsKey(r1);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean isNull(String r1) {
        if (get(r1) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean getBoolean(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == true) goto L5;
        if (r2 == null) goto L13;
        if (r2.getClass() == null) goto L13;
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + r3);
    L13:
        throw new NullPointerException("key: " + r3);
    L5:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public double getDouble(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == true) goto L5;
        if (r2 == null) goto L13;
        if (r2.getClass() == null) goto L13;
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r3);
    L13:
        throw new NullPointerException("key: " + r3);
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public long getLong(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == true) goto L5;
        if (r2 == null) goto L13;
        if (r2.getClass() == null) goto L13;
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to java.lang.Long, key: " + r3);
    L13:
        throw new NullPointerException("key: " + r3);
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int getInt(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == true) goto L5;
        if (r2 == null) goto L13;
        if (r2.getClass() == null) goto L13;
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r3);
    L13:
        throw new NullPointerException("key: " + r3);
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public String getString(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r2.getClass() != null) goto L11;
        return null;
    L11:
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to java.lang.String, key: " + r3);
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMap getMap(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, ReadableMap.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r2.getClass() != null) goto L11;
        return null;
    L11:
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r3);
    L5:
        return (ReadableMap) ZeusTransformUtils.preCheckCast(r2, ReadableMap.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean getBoolean(String r1, boolean r2) {
        Object r0 = get(r1);
        if (ZeusTransformUtils.instanceOf(r0, Boolean.class) == true) goto L5;
        return r2;
    L5:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public double getDouble(String r1, double r2) {
        Object r0 = get(r1);
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == true) goto L5;
        return r2;
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int getInt(String r1, int r2) {
        Object r0 = get(r1);
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == true) goto L5;
        return r2;
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public long getLong(String r1, long r2) {
        Object r0 = get(r1);
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == true) goto L5;
        return r2;
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public String getString(String r1, String r2) {
        Object r0 = get(r1);
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        return r2;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableArray getArray(String r3, ReadableArray r4) {
        ReadableArray r5 = (ReadableArray) ZeusTransformUtils.wrapperContextForParams(r4, ReadableArray.class, "com.obric.aiagent.plugin");
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, ReadableArray.class) == true) goto L5;
        return r5;
    L5:
        return (ReadableArray) ZeusTransformUtils.preCheckCast(r2, ReadableArray.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMap getMap(String r3, ReadableMap r4) {
        ReadableMap r5 = (ReadableMap) ZeusTransformUtils.wrapperContextForParams(r4, ReadableMap.class, "com.obric.aiagent.plugin");
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, ReadableMap.class) == true) goto L5;
        return r5;
    L5:
        return (ReadableMap) ZeusTransformUtils.preCheckCast(r2, ReadableMap.class, "com.obric.aiagent.plugin");
    }

    ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public JavaOnlyArray getArray(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, JavaOnlyArray.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r2.getClass() != null) goto L11;
        return null;
    L11:
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + r3);
    L5:
        return (JavaOnlyArray) ZeusTransformUtils.preCheckCast(r2, JavaOnlyArray.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public byte[] getByteArray(String r1, byte[] r2) {
        Object r0 = get(r1);
        if ((r0 instanceof byte[]) == true) goto L5;
        return r2;
    L5:
        return (byte[]) ZeusTransformUtils.preCheckCast(r0, byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public byte[] getByteArray(String r4) {
        Object r3 = get(r4);
        if ((r3 instanceof byte[]) == true) goto L5;
        if (r3 != null) goto L8;
        return null;
    L8:
        if (r3.getClass() != null) goto L11;
        return null;
    L11:
        throw new ClassCastException(r3.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + r4);
    L5:
        return (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public NativeHostObject getNativeHostObject(String r3) {
        Object r2 = get(r3);
        if (ZeusTransformUtils.instanceOf(r2, NativeHostObject.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r2.getClass() != null) goto L11;
        return null;
    L11:
        throw new ClassCastException(r2.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + r3);
    L5:
        return (NativeHostObject) ZeusTransformUtils.preCheckCast(r2, NativeHostObject.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public b getDynamic(String r1) {
        return d.a(this, r1);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableType getType(String r4) {
        Object r3 = get(r4);
        if (r3 != null) goto L7;
        return ReadableType.Null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L11;
        return ReadableType.Int;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, Long.class) == false) goto L15;
        return ReadableType.Long;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(r3, Character.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L24;
        return ReadableType.String;
    L24:
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if (ZeusTransformUtils.instanceOf(r3, ReadableMap.class) == false) goto L32;
        return ReadableType.Map;
    L32:
        if (ZeusTransformUtils.instanceOf(r3, ReadableArray.class) == false) goto L36;
        return ReadableType.Array;
    L36:
        if ((r3 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L44;
        return ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).getType();
    L44:
        if (ZeusTransformUtils.instanceOf(r3, NativeHostObject.class) == false) goto L48;
        return ReadableType.NativeHostObject;
    L48:
        throw new IllegalArgumentException("Invalid value " + r3.toString() + " for key " + r4 + "contained in JavaOnlyMap");
    L50:
        return ReadableType.Number;
    }

    public int getTypeIndex(String r1) {
        return getType(r1).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putBoolean(String r1, boolean r2) {
        put(r1, Boolean.valueOf(r2));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putDouble(String r1, double r2) {
        put(r1, Double.valueOf(r2));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putInt(String r1, int r2) {
        put(r1, Integer.valueOf(r2));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putLong(String r1, long r2) {
        put(r1, Long.valueOf(r2));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putString(String r1, String r2) {
        put(r1, r2);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putNull(String r2) {
        put(r2, null);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putMap(String r3, WritableMap r4) {
        put(r3, (WritableMap) ZeusTransformUtils.wrapperContextForParams(r4, WritableMap.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int size() {
        return super.size();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void merge(ReadableMap r3) {
        putAll((JavaOnlyMap) ZeusTransformUtils.preCheckCast((ReadableMap) ZeusTransformUtils.wrapperContextForParams(r3, ReadableMap.class, "com.obric.aiagent.plugin"), JavaOnlyMap.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putArray(String r3, WritableArray r4) {
        put(r3, (WritableArray) ZeusTransformUtils.wrapperContextForParams(r4, WritableArray.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putByteArrayAsString(byte[] r2, byte[] r3) {
        put(new String(r2), new String(r3));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putByteArray(String r1, byte[] r2) {
        put(r1, r2);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putNativeHostObject(String r3, NativeHostObject r4) {
        put(r3, (NativeHostObject) ZeusTransformUtils.wrapperContextForParams(r4, NativeHostObject.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return new HashMap(this);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public androidx.b.a<String, Object> toArrayMap() {
        androidx.b.a<String, Object> r0 = new androidx.b.a();
        r0.putAll(this);
        return r0;
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }
}
