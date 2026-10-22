package com.obric.apptools.sdk.base.kv;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface IKvStore {
    Map<String, ?> all();

    boolean contains(String r1);

    int count();

    boolean getBoolean(String r1, boolean r2);

    int getInt(String r1, int r2);

    long getLong(String r1, long r2);

    String getString(String r1, String r2);

    Set<String> getStringSet(String r1, Set<String> r2);

    boolean isDebug();

    void remove(String r1);

    void setBoolean(String r1, boolean r2);

    void setInt(String r1, int r2);

    void setLong(String r1, long r2);

    void setString(String r1, String r2);

    void setStringSet(String r1, Set<String> r2);
}
