package com.bytedance.keva;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaPrivateImpl extends KevaImpl {
    public KevaPrivateImpl(String r10, int r11) {
        super(r10, r11);
    }

    private Object fetchObject(String r10, Object r11) {
        KevaImpl.KevaValueWrapper r12 = this.mValueMap.get(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r12.offset != 0) goto L8;
        return r11;
    L8:
        return r12.value;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r10) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r11 = this.mValueMap.get(r10);     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
    L10:
        boolean r12 = false;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r12;
    L6:
        if (r11.offset == 0) goto L10;
        r12 = true;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r10 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L9
        int r11 = 0;
    L5:
        if (r10.hasNext() == false) goto L11;
        if (r10.next().getValue().offset == 0) goto L5;
        r11 = r11 + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
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
    public /* bridge */ /* synthetic */ void erase(String r10) {
        super.erase(r10);
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r10, boolean r11) {
        return ((Boolean) fetchObject(r10, Boolean.valueOf(r11))).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r11, byte[] r12, int r13, boolean r14) {
        KevaImpl.KevaValueWrapper r10 = this.mValueMap.get(r11);
        if (r10 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r10.offset == 0) goto L17;
        if (r10.loaded == true) goto L16;
        byte[] r15 = fetchBytes(this.mHandle, r11, r10.offset, r12, r13);
        if (r14 == true) goto L13;
        if (r15 == r12) goto L14;
        r10.value = r15;
        r10.loaded = true;
    L14:
        return r15;
    L13:
        r10.value = null;
        r10.loaded = false;
        goto L14
    L16:
        return (byte[]) r10.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r10, double r11) {
        return ((Double) fetchObject(r10, Double.valueOf(r11))).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r10, float r11) {
        return ((Float) fetchObject(r10, Float.valueOf(r11))).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r10, int r11) {
        return ((Integer) fetchObject(r10, Integer.valueOf(r11))).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r10, long r11) {
        return ((Long) fetchObject(r10, Long.valueOf(r11))).longValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r10, String r11, boolean r12) {
        KevaImpl.KevaValueWrapper r13 = this.mValueMap.get(r10);
        if (r13 != null) goto L5;
    L17:
        return r11;
    L5:
        if (r13.offset == 0) goto L17;
        if (r13.loaded == true) goto L16;
        String r14 = fetchString(this.mHandle, r10, r13.offset, r11);
        if (r12 == true) goto L13;
        if (r14 == r11) goto L14;
        r13.value = r14;
        r13.loaded = true;
    L14:
        return r14;
    L13:
        r13.value = null;
        r13.loaded = false;
        goto L14
    L16:
        return (String) r13.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r11, String[] r12, boolean r13) {
        KevaImpl.KevaValueWrapper r10 = this.mValueMap.get(r11);
        if (r10 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r10.offset == 0) goto L17;
        if (r10.loaded == true) goto L16;
        String[] r14 = fetchStringArray(this.mHandle, r11, r10.offset, r12, 3);
        if (r13 == true) goto L13;
        if (r14 == r12) goto L14;
        r10.value = r14;
        r10.loaded = true;
    L14:
        return r14;
    L13:
        r10.value = null;
        r10.loaded = false;
        goto L14
    L16:
        return (String[]) r10.value;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        Map<String, ?> r10 = generateOutMap();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r10, boolean r11) {
        return super.getBoolean(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r10, byte[] r11) {
        return super.getBytes(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r10, byte[] r11) {
        return super.getBytesJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r10, double r11) {
        return super.getDouble(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r10, float r11) {
        return super.getFloat(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r10, int r11) {
        return super.getInt(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r10, long r11) {
        return super.getLong(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r10, String r11) {
        return super.getString(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r10, String[] r11) {
        return super.getStringArray(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r10, String[] r11) {
        return super.getStringArrayJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r10, String r11) {
        return super.getStringJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r10, Set r11) {
        return super.getStringSet(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r10, Set r11) {
        return super.getStringSetJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r10) {
        super.registerChangeListener(r10);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r10, boolean r11) {
        super.storeBoolean(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r10, byte[] r11) {
        super.storeBytes(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r10, byte[] r11) {
        super.storeBytesJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r10, double r11) {
        super.storeDouble(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r10, float r11) {
        super.storeFloat(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r10, int r11) {
        super.storeInt(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r10, long r11) {
        super.storeLong(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r10, String r11) {
        super.storeString(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r10, String[] r11) {
        super.storeStringArray(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r10, String[] r11) {
        super.storeStringArrayJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r10, String r11) {
        super.storeStringJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r10, Set r11) {
        super.storeStringSet(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r10, Set r11) {
        super.storeStringSetJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r10) {
        super.unRegisterChangeListener(r10);
    }
}
