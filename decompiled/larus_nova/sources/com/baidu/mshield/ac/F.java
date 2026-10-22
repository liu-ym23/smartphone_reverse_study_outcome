package com.baidu.mshield.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import com.baidu.mshield.sharedpreferences.a;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.utility.d;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class F implements FI {
    private static F instance;

    @Override // com.baidu.mshield.ac.FI
    public boolean chh(Context r100, String r101) {
        return false;
    }

    @Override // com.baidu.mshield.ac.FI
    public void cm(String r100, String r101, String r102, Callback r103, Class<?>[] r104, Object... r105) {
    }

    @Override // com.baidu.mshield.ac.FI
    public Pair<Integer, Object> cmsi(int r100, String r101, Class<?>[] r102, Object... r103) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public Map<Integer, String> gpd() {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public String gs(String r100) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public String gta(Context r100) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public String p(String r100) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public void r(String r100, IntentFilter r101, String r102, String r103) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void rf(Context r100) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void s(int r100, boolean r101) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void sp(String r100, boolean r101) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void u(String r100) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void ur(String r100, IntentFilter r101, String r102, String r103) {
    }

    public static synchronized F getInstance() {
        monitor-enter(F.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new F();     // Catch: Throwable -> L10
    L7:
        F r100 = instance;     // Catch: Throwable -> L10
        monitor-exit(F.class);
        return r100;
    }

    private F() {
    }

    @Override // com.baidu.mshield.ac.FI
    public SharedPreferences getPlatformPrivateSharedPreferences(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return a.a(r100).w();
    }

    @Override // com.baidu.mshield.ac.FI
    public SharedPreferences getPlatformSharedSharedPreferences(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return a.a(r100).x();
    }

    @Override // com.baidu.mshield.ac.FI
    public String gzd(Context r100) {
        return c.b(r100);
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] ad(byte[] r100, byte[] r101) {
        if (r101 != null) goto L20;
    L19:
        return null;
    L20:
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L19
    L5:
        if (r101.length <= 0) goto L19;
        if (r100 == null) goto L19;
        if (r100.length <= 0) goto L19;
        byte[] r102 = com.baidu.mshield.b.f.a.a(r100, r101);     // Catch: Throwable -> L17
        if (r102 != null) goto L13;
    L15:
        return new byte[0];
    L13:
        if (r102.length <= 0) goto L15;
        return r102;
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] ae(byte[] r100, byte[] r101) {
        if (r101 != null) goto L20;
    L19:
        return null;
    L20:
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L19
    L5:
        if (r101.length <= 0) goto L19;
        if (r100 == null) goto L19;
        if (r100.length <= 0) goto L19;
        byte[] r102 = com.baidu.mshield.b.f.a.b(r100, r101);     // Catch: Throwable -> L17
        if (r102 != null) goto L13;
    L15:
        return new byte[0];
    L13:
        if (r102.length <= 0) goto L15;
        return r102;
    }

    @Override // com.baidu.mshield.ac.FI
    public SharedPreferences getCustomMutiProcessSharedPreferences(Context r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return a.a(r100).c(r101);
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] rd(byte[] r100, byte[] r101) {
        if (r101 != null) goto L20;
    L19:
        return null;
    L20:
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L19
    L5:
        if (r101.length <= 0) goto L19;
        if (r100 == null) goto L19;
        if (r100.length <= 0) goto L19;
        byte[] r102 = d.a(r100, r101);     // Catch: Throwable -> L17
        if (r102 != null) goto L13;
    L15:
        return new byte[0];
    L13:
        if (r102.length <= 0) goto L15;
        return r102;
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] re(byte[] r100, byte[] r101) {
        if (r101 != null) goto L20;
    L19:
        return null;
    L20:
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L19
    L5:
        if (r101.length <= 0) goto L19;
        if (r100 == null) goto L19;
        if (r100.length <= 0) goto L19;
        byte[] r102 = d.b(r100, r101);     // Catch: Throwable -> L17
        if (r102 != null) goto L13;
    L15:
        return new byte[0];
    L13:
        if (r102.length <= 0) goto L15;
        return r102;
    }
}
