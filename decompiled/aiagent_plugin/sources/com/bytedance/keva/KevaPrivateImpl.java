package com.bytedance.keva;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaPrivateImpl extends KevaImpl {
    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ Map buildNewMap(Map r3) {
        return super.buildNewMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva.ClearMemory
    public /* bridge */ /* synthetic */ void clearMemory(int r1) {
        super.clearMemory(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void dump() {
        super.dump();
    }

    @Override // com.bytedance.keva.KevaImpl
    public /* bridge */ /* synthetic */ void dumpNative() {
        super.dumpNative();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void erase(String r1) {
        super.erase(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r1, boolean r2) {
        return super.getBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r1, byte[] r2) {
        return super.getBytes(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r1, byte[] r2) {
        return super.getBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r1, double r2) {
        return super.getDouble(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r1, float r2) {
        return super.getFloat(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r1, int r2) {
        return super.getInt(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r1, long r2) {
        return super.getLong(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r1, String r2) {
        return super.getString(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r1, String[] r2) {
        return super.getStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r1, String[] r2) {
        return super.getStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r1, String r2) {
        return super.getStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ Set getStringSet(String r3, Set r4) {
        return super.getStringSet(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ Set getStringSetJustDisk(String r3, Set r4) {
        return super.getStringSetJustDisk(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ void registerChangeListener(Keva.OnChangeListener r3) {
        super.registerChangeListener((Keva.OnChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Keva.OnChangeListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r1, boolean r2) {
        super.storeBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r1, byte[] r2) {
        super.storeBytes(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r1, byte[] r2) {
        super.storeBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r1, double r2) {
        super.storeDouble(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r1, float r2) {
        super.storeFloat(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r1, int r2) {
        super.storeInt(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r1, long r2) {
        super.storeLong(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r1, String r2) {
        super.storeString(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r1, String[] r2) {
        super.storeStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r1, String[] r2) {
        super.storeStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r1, String r2) {
        super.storeStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ void storeStringSet(String r3, Set r4) {
        super.storeStringSet(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ void storeStringSetJustDisk(String r3, Set r4) {
        super.storeStringSetJustDisk(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r3) {
        super.unRegisterChangeListener((Keva.OnChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Keva.OnChangeListener.class, "com.obric.aiagent.plugin"));
    }

    KevaPrivateImpl(String r1, String r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r1, int r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(fetchObject(r1, Integer.valueOf(r2)), Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r1, long r2) {
        return ((Long) ZeusTransformUtils.preCheckCast(fetchObject(r1, Long.valueOf(r2)), Long.class, "com.obric.aiagent.plugin")).longValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r1, float r2) {
        return ((Float) ZeusTransformUtils.preCheckCast(fetchObject(r1, Float.valueOf(r2)), Float.class, "com.obric.aiagent.plugin")).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r1, boolean r2) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(fetchObject(r1, Boolean.valueOf(r2)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r1, double r2) {
        return ((Double) ZeusTransformUtils.preCheckCast(fetchObject(r1, Double.valueOf(r2)), Double.class, "com.obric.aiagent.plugin")).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r12, String r13, boolean r14) {
        KevaImpl.KevaValueWrapper r0 = (KevaImpl.KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.get(r12), KevaImpl.KevaValueWrapper.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L17:
        return r13;
    L5:
        if (r0.offset == 0) goto L17;
        int r1 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r1;
        r0.accessIndex = r1;
        if (r0.loaded == true) goto L16;
        String r11 = fetchString(this.mHandle, r12, r0.offset, r13);
        if (r14 == true) goto L13;
        if (r11 == r13) goto L14;
        r0.value = r11;
        r0.loaded = true;
    L14:
        return r11;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (String) ZeusTransformUtils.preCheckCast(r0.value, String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r13, String[] r14, boolean r15) {
        KevaImpl.KevaValueWrapper r0 = (KevaImpl.KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.get(r13), KevaImpl.KevaValueWrapper.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L17:
        return r14;
    L5:
        if (r0.offset == 0) goto L17;
        int r1 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r1;
        r0.accessIndex = r1;
        if (r0.loaded == true) goto L16;
        String[] r12 = fetchStringArray(this.mHandle, r13, r0.offset, r14, 3);
        if (r15 == true) goto L13;
        if (r12 == r14) goto L14;
        r0.value = r12;
        r0.loaded = true;
    L14:
        return r12;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.value, String[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r11, byte[] r12, int r13, boolean r14) {
        KevaImpl.KevaValueWrapper r8 = (KevaImpl.KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.get(r11), KevaImpl.KevaValueWrapper.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r8.offset == 0) goto L17;
        int r1 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r1;
        r8.accessIndex = r1;
        if (r8.loaded == true) goto L16;
        byte[] r0 = fetchBytes(this.mHandle, r11, r8.offset, r12, r13);
        if (r14 == true) goto L13;
        if (r0 == r12) goto L14;
        r8.value = r0;
        r8.loaded = true;
    L14:
        return r0;
    L13:
        r8.value = null;
        r8.loaded = false;
        goto L14
    L16:
        return (byte[]) ZeusTransformUtils.preCheckCast(r8.value, byte[].class, "com.obric.aiagent.plugin");
    }

    private Object fetchObject(String r5, Object r6) {
        KevaImpl.KevaValueWrapper r4 = (KevaImpl.KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.get(r5), KevaImpl.KevaValueWrapper.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return r6;
    L5:
        if (r4.offset != 0) goto L8;
        return r6;
    L8:
        return r4.value;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        Map<String, ?> r0 = buildNewMap(new HashMap());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r5) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r6 = (KevaImpl.KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.get(r5), KevaImpl.KevaValueWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r6 != null) goto L6;
    L8:
        boolean r7 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r7;
    L6:
        if (r6.offset == 0) goto L8;
        r7 = true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L9;
        if (((KevaImpl.KevaValueWrapper) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), KevaImpl.KevaValueWrapper.class, "com.obric.aiagent.plugin")).offset == 0) goto L5;
        r1 = r1 + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }
}
