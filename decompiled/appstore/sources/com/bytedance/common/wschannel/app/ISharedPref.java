package com.bytedance.common.wschannel.app;

/* JADX INFO: loaded from: classes.dex */
public interface ISharedPref {
    boolean getBoolean(String r10, boolean r11);

    float getFloat(String r10, float r11);

    int getInt(String r10, int r11);

    long getLong(String r10, long r11);

    String getString(String r10, String r11);

    void putBoolean(String r10, boolean r11);

    void putFloat(String r10, float r11);

    void putInt(String r10, int r11);

    void putLong(String r10, long r11);

    void putString(String r10, String r11);
}
