package com.baidu.mshield.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface FI {
    byte[] ad(byte[] r100, byte[] r101);

    byte[] ae(byte[] r100, byte[] r101);

    boolean chh(Context r100, String r101);

    void cm(String r100, String r101, String r102, Callback r103, Class<?>[] r104, Object... r105);

    Pair<Integer, Object> cmsi(int r100, String r101, Class<?>[] r102, Object... r103);

    SharedPreferences getCustomMutiProcessSharedPreferences(Context r100, String r101);

    SharedPreferences getPlatformPrivateSharedPreferences(Context r100);

    SharedPreferences getPlatformSharedSharedPreferences(Context r100);

    Map<Integer, String> gpd();

    String gs(String r100);

    String gta(Context r100);

    String gzd(Context r100);

    String p(String r100);

    void r(String r100, IntentFilter r101, String r102, String r103);

    byte[] rd(byte[] r100, byte[] r101);

    byte[] re(byte[] r100, byte[] r101);

    void rf(Context r100);

    void s(int r100, boolean r101);

    void sp(String r100, boolean r101);

    void u(String r100);

    void ur(String r100, IntentFilter r101, String r102, String r103);
}
