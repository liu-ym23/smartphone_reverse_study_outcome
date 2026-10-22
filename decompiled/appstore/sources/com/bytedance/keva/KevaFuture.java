package com.bytedance.keva;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class KevaFuture extends Keva {
    private KevaImpl mFallBackInstance;
    private FutureTask<KevaImpl> mFuture;
    private int mMode;
    private String mName;

    public KevaFuture(String r10, int r11, Callable<KevaImpl> r12) {
        this.mName = r10;
        this.mMode = r11;
        FutureTask<KevaImpl> r13 = new FutureTask(r12);
        this.mFuture = r13;
        KevaImpl.sExecutor.execute(r13);
    }

    private KevaImpl obtain() {
        return this.mFuture.get();
    L4:
        e = move-exception;
        KevaMonitor r10 = KevaImpl.sMonitor;
        r10.logDebug("fail to obtain keva future instance");
        r10.reportThrowable(5, this.mName, null, null, e);
        if (this.mFallBackInstance != null) goto L9;
        KevaImpl r11 = KevaImpl.getEmptyRepoImpl(this.mName, this.mMode);
        this.mFallBackInstance = r11;
        r11.init(false);
    L9:
        return this.mFallBackInstance;
    }

    public void checkMode(int r10) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().checkMode(r10);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        obtain().clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r10) {
        return obtain().contains(r10);
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        return obtain().count();
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        obtain().dump();
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r10) {
        obtain().erase(r10);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return obtain().getAll();
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r10, boolean r11) {
        return obtain().getBoolean(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r10, byte[] r11) {
        return obtain().getBytes(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r10, byte[] r11) {
        return obtain().getBytesJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r10, double r11) {
        return obtain().getDouble(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r10, float r11) {
        return obtain().getFloat(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r10, int r11) {
        return obtain().getInt(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r10, long r11) {
        return obtain().getLong(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r10, String r11) {
        return obtain().getString(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r10, String[] r11) {
        return obtain().getStringArray(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r10, String[] r11) {
        return obtain().getStringArrayJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r10, String r11) {
        return obtain().getStringJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r10, Set<String> r11) {
        return obtain().getStringSet(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r10, Set<String> r11) {
        return obtain().getStringSetJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return obtain().name();
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r10) {
        obtain().registerChangeListener(r10);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r10, boolean r11) {
        obtain().storeBoolean(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r10, byte[] r11) {
        obtain().storeBytes(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r10, byte[] r11) {
        obtain().storeBytesJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r10, double r11) {
        obtain().storeDouble(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r10, float r11) {
        obtain().storeFloat(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r10, int r11) {
        obtain().storeInt(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r10, long r11) {
        obtain().storeLong(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r10, String r11) {
        obtain().storeString(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r10, String[] r11) {
        obtain().storeStringArray(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r10, String[] r11) {
        obtain().storeStringArrayJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r10, String r11) {
        obtain().storeStringJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r10, Set<String> r11) {
        obtain().storeStringSet(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r10, Set<String> r11) {
        obtain().storeStringSetJustDisk(r10, r11);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r10) {
        obtain().unRegisterChangeListener(r10);
    }
}
