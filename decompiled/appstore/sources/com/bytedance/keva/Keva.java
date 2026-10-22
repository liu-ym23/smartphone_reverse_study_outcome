package com.bytedance.keva;

import android.content.Context;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Keva {

    public interface OnChangeListener {
        void onChanged(Keva r10, String r11);
    }

    public Keva() {
    }

    public static void forceInit() {
        KevaImpl.forceInitImpl();
    }

    public static Keva getRepo(String r10) {
        return KevaImpl.getRepo(r10, 0);
    }

    public static Keva getRepoFromSp(Context r10, String r11, int r12) {
        return KevaImpl.getRepoFromSp(r10, r11, r12);
    }

    public static Keva getRepoFromSpSync(Context r10, String r11, int r12) {
        return KevaImpl.getRepoFromSpSync(r10, r11, r12);
    }

    public static Keva getRepoSync(String r10, int r11) {
        return KevaImpl.getRepoSync(r10, r11);
    }

    public static boolean isRepoPorted(String r10) {
        return KevaImpl.isRepoPorted(r10);
    }

    @Deprecated
    public int calculateSize() {
        return count();
    }

    public abstract void clear();

    public abstract boolean contains(String r10);

    public abstract int count();

    public abstract void dump();

    public abstract void erase(String r10);

    public abstract Map<String, ?> getAll();

    public abstract boolean getBoolean(String r10, boolean r11);

    public abstract byte[] getBytes(String r10, byte[] r11);

    public abstract byte[] getBytesJustDisk(String r10, byte[] r11);

    public abstract double getDouble(String r10, double r11);

    public abstract float getFloat(String r10, float r11);

    public abstract int getInt(String r10, int r11);

    public abstract long getLong(String r10, long r11);

    public abstract String getString(String r10, String r11);

    public abstract String[] getStringArray(String r10, String[] r11);

    public abstract String[] getStringArrayJustDisk(String r10, String[] r11);

    public abstract String getStringJustDisk(String r10, String r11);

    public abstract Set<String> getStringSet(String r10, Set<String> r11);

    public abstract Set<String> getStringSetJustDisk(String r10, Set<String> r11);

    public abstract String name();

    public abstract void registerChangeListener(OnChangeListener r10);

    public abstract void storeBoolean(String r10, boolean r11);

    public abstract void storeBytes(String r10, byte[] r11);

    public abstract void storeBytesJustDisk(String r10, byte[] r11);

    public abstract void storeDouble(String r10, double r11);

    public abstract void storeFloat(String r10, float r11);

    public abstract void storeInt(String r10, int r11);

    public abstract void storeLong(String r10, long r11);

    public abstract void storeString(String r10, String r11);

    public abstract void storeStringArray(String r10, String[] r11);

    public abstract void storeStringArrayJustDisk(String r10, String[] r11);

    public abstract void storeStringJustDisk(String r10, String r11);

    public abstract void storeStringSet(String r10, Set<String> r11);

    public abstract void storeStringSetJustDisk(String r10, Set<String> r11);

    public abstract void unRegisterChangeListener(OnChangeListener r10);

    public static Keva getRepo(String r10, int r11) {
        return KevaImpl.getRepo(r10, r11);
    }
}
