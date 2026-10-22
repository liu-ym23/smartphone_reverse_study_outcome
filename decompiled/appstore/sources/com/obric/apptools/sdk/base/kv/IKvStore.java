package com.obric.apptools.sdk.base.kv;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface IKvStore {
    Map<String, ?> all();

    boolean contains(String r10);

    int count();

    boolean getBoolean(String r10, boolean r11);

    int getInt(String r10, int r11);

    long getLong(String r10, long r11);

    String getString(String r10, String r11);

    Set<String> getStringSet(String r10, Set<String> r11);

    boolean isDebug();

    void remove(String r10);

    void setBoolean(String r10, boolean r11);

    void setInt(String r10, int r11);

    void setLong(String r10, long r11);

    void setString(String r10, String r11);

    void setStringSet(String r10, Set<String> r11);
}
