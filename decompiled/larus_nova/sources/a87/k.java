package a87;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public interface k {
    float a(String r100);

    boolean contains(String r100);

    SharedPreferences.Editor edit();

    boolean getBoolean(String r100);

    boolean getBoolean(String r100, boolean r101);

    float getFloat(String r100, float r101);

    int getInt(String r100);

    int getInt(String r100, int r101);

    long getLong(String r100);

    long getLong(String r100, long r101);

    String getString(String r100);

    String getString(String r100, String r101);

    void registerValChanged(Context r100, String r101, String r102, j77.a r103);

    void unregisterValChanged(j77.a r100);
}
