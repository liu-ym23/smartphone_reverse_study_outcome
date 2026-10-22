package com.baidu.sec.privacy.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sec.privacy.f.c;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashSet;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f33497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f33498b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SharedPreferences f33499c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static SharedPreferences.Editor f33500d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f33501e = "sofire";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static HashSet<Integer> f33502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static HashSet<Integer> f33503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f33504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static SharedPreferences.OnSharedPreferenceChangeListener f33505i;

    /* JADX INFO: renamed from: com.baidu.sec.privacy.d.a$a, reason: collision with other inner class name */
    public class SharedPreferencesOnSharedPreferenceChangeListenerC0669a implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: renamed from: com.baidu.sec.privacy.d.a$a$a, reason: collision with other inner class name */
        public class RunnableC0670a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SharedPreferences f33506a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f33507b;

            @Override // java.lang.Runnable
            public void run() {
                com_baidu_sec_privacy_d_a$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_baidu_sec_privacy_d_a$a$a__run$___twin___() {
                a.c(this.f33506a.getString(this.f33507b, ""));
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_sec_privacy_d_a$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0670a r100) {
                r100.com_baidu_sec_privacy_d_a$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0670a(SharedPreferencesOnSharedPreferenceChangeListenerC0669a r100, SharedPreferences r101, String r102) {
                this.f33506a = r101;
                this.f33507b = r102;
            }
        }

        public SharedPreferencesOnSharedPreferenceChangeListenerC0669a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences r100, String r101) {
            if (b.f33509b.equals(r101) == true) goto L5;
            return;
        L5:
            ThreadMethodProxy.start(new PthreadThreadV2(new RunnableC0670a(this, r100, r101), "privacy/d/a$a"));
        }
    }

    static {
        f33502f = new HashSet();
        f33503g = new HashSet();
        f33504h = true;
        f33505i = new SharedPreferencesOnSharedPreferenceChangeListenerC0669a();
    }

    public static void c() {
        if (f33497a.optInt("0", 1) != 1) goto L5;
        f33498b = true;
    L6:
        JSONArray r100 = f33497a.optJSONArray("1");
        if (r100 == null) goto L12;
        int r101 = r100.length();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L12;
        f33502f.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, r102)));     // Catch: JSONException -> L23
    L11:
        r102 = r102 + 1;
    L12:
        JSONArray r103 = f33497a.optJSONArray("3");
        if (r103 == null) goto L19;
        int r104 = r103.length();
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L19;
        f33503g.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r103, r105)));     // Catch: JSONException -> L24
    L17:
        r105 = r105 + 1;
    L19:
        if (f33497a.optInt("4", 1) != 1) goto L21;
        f33504h = true;
        return;
    L21:
        f33504h = false;
        return;
    L5:
        f33498b = false;
        goto L6
    }

    public static boolean a() {
        return f33498b;
    }

    public static boolean b() {
        return f33504h;
    }

    public static boolean a(int r100) {
        return f33503g.contains(Integer.valueOf(r100));
    L4:
        th = move-exception;
        c.a(th);
        return false;
    }

    public static void b(String r100) {
        SharedPreferences r101 = com.baidu.sec.privacy.b.b.a().getSharedPreferences("prv_config", 0);     // Catch: Throwable -> L4
        f33499c = r101;     // Catch: Throwable -> L4
        f33500d = r101.edit();     // Catch: Throwable -> L4
        f33501e = r100;     // Catch: Throwable -> L4
        c(b.a(r100, f33505i));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.a(th);
    }

    public static void c(String r100) {
        f33497a = null;     // Catch: Throwable -> L9
        f33502f.clear();     // Catch: Throwable -> L9
        f33503g.clear();     // Catch: Throwable -> L9
        f33504h = true;     // Catch: Throwable -> L9
        f33497a = new JSONObject(r100);     // Catch: Throwable -> L6
    L7:
        c();     // Catch: Throwable -> L9
        return;
    L6:
        f33497a = new JSONObject();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        c.a(th);
    }

    public static boolean a(String r100) {
        return f33499c.contains(r100);
    }

    public static boolean b(int r100) {
    L9:
        th = move-exception;
        c.a(th);
        return false;
    L4:
        if (b.b(f33501e) == true) goto L6;
        return false;
    L6:
        return !f33502f.contains(Integer.valueOf(r100));
    }

    public static String a(String r100, String r101) {
        String r102 = f33499c.getString(r100, r101);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r102) == false) goto L13;
        return r101;
    L13:
        return com.baidu.sec.privacy.f.a.a(r102);
    L7:
        return r101;
    L8:
        th = move-exception;
        c.a(th);
        return r101;
    }

    public static void b(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return;
    L10:
        f33500d.putString(r100, com.baidu.sec.privacy.f.a.a(r101.getBytes()));     // Catch: Throwable -> L7
        f33500d.putLong(r100 + "la_in", System.currentTimeMillis());     // Catch: Throwable -> L7
        f33500d.commit();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        c.a(th);
    }

    public static int a(String r100, int r101) {
        return f33499c.getInt(r100, r101);
    }

    public static void b(String r100, int r101) {
        f33500d.putInt(r100, r101);     // Catch: Throwable -> L4
        f33500d.putLong(r100 + "la_in", System.currentTimeMillis());     // Catch: Throwable -> L4
        f33500d.commit();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.a(th);
    }

    public static long a(String r100, long r101) {
        return f33499c.getLong(r100, r101);
    }
}
