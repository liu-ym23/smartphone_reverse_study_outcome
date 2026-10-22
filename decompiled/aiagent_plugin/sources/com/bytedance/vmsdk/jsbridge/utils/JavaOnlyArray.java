package com.bytedance.vmsdk.jsbridge.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray {
    private static final String TAG = "JavaOnlyArray";

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public /* bridge */ /* synthetic */ ReadableArray getArray(int r1) {
        return getArray(r1);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public /* bridge */ /* synthetic */ ReadableMap getMap(int r1) {
        return getMap(r1);
    }

    public static JavaOnlyArray a(Object... r1) {
        if (r1 != null) goto L6;
        return new JavaOnlyArray();
    L6:
        return new JavaOnlyArray(Arrays.asList(r1));
    }

    public JavaOnlyArray(List r3) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public JavaOnlyArray() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public int size() {
        return super.size();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public boolean isNull(int r1) {
        if (get(r1) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public double getDouble(int r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(get(r2), Number.class, "com.obric.aiagent.plugin")).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public byte getByte(int r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(get(r2), Number.class, "com.obric.aiagent.plugin")).byteValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public short getShort(int r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(get(r2), Number.class, "com.obric.aiagent.plugin")).shortValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public long getLong(int r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(get(r2), Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public char getChar(int r2) {
        return (char) ((Number) ZeusTransformUtils.preCheckCast(get(r2), Number.class, "com.obric.aiagent.plugin")).shortValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public int getInt(int r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(get(r2), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public String getString(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(get(r2), String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public JavaOnlyArray getArray(int r2) {
        return (JavaOnlyArray) ZeusTransformUtils.preCheckCast(get(r2), JavaOnlyArray.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public boolean getBoolean(int r2) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(get(r2), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public JavaOnlyMap getMap(int r2) {
        return (JavaOnlyMap) ZeusTransformUtils.preCheckCast(get(r2), JavaOnlyMap.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public byte[] getByteArray(int r2) {
        return (byte[]) ZeusTransformUtils.preCheckCast(get(r2), byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public NativeHostObject getNativeHostObject(int r2) {
        return (NativeHostObject) ZeusTransformUtils.preCheckCast(get(r2), NativeHostObject.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public b getDynamic(int r1) {
        return c.a(this, r1);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public ReadableType getType(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return ReadableType.Null;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, Boolean.class) == false) goto L11;
        return ReadableType.Boolean;
    L11:
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == false) goto L15;
        return ReadableType.Int;
    L15:
        if (ZeusTransformUtils.instanceOf(r0, Long.class) == false) goto L19;
        return ReadableType.Long;
    L19:
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r0, Character.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L28;
        return ReadableType.String;
    L28:
        if (ZeusTransformUtils.instanceOf(r0, ReadableArray.class) == false) goto L32;
        return ReadableType.Array;
    L32:
        if (ZeusTransformUtils.instanceOf(r0, ReadableMap.class) == false) goto L36;
        return ReadableType.Map;
    L36:
        if ((r0 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if (ZeusTransformUtils.instanceOf(r0, NativeHostObject.class) == true) goto L42;
        return null;
    L42:
        return ReadableType.NativeHostObject;
    L46:
        return ReadableType.Number;
    }

    public int getTypeIndex(int r1) {
        return getType(r1).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushBoolean(boolean r1) {
        add(Boolean.valueOf(r1));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushDouble(double r1) {
        add(Double.valueOf(r1));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushInt(int r1) {
        add(Integer.valueOf(r1));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushLong(long r1) {
        add(Long.valueOf(r1));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushString(String r1) {
        add(r1);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushByteArrayAsString(byte[] r2) {
        add(new String(r2));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushArray(WritableArray r3) {
        add((WritableArray) ZeusTransformUtils.wrapperContextForParams(r3, WritableArray.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushMap(WritableMap r3) {
        add((WritableMap) ZeusTransformUtils.wrapperContextForParams(r3, WritableMap.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushNull() {
        add(null);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushByteArray(byte[] r1) {
        add(r1);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void putNativeHostObject(NativeHostObject r3) {
        add((NativeHostObject) ZeusTransformUtils.wrapperContextForParams(r3, NativeHostObject.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        super.clear();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public ArrayList<Object> toArrayList() {
        return new ArrayList(this);
    }

    public Object getAt(int r1) {
        return get(r1);
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }
}
