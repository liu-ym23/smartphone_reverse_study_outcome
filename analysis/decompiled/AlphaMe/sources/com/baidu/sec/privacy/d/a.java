package com.baidu.sec.privacy.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sec.privacy.f.c;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static JSONObject f9408a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9409b = true;

    /* renamed from: c, reason: collision with root package name */
    public static SharedPreferences f9410c = null;

    /* renamed from: d, reason: collision with root package name */
    public static SharedPreferences.Editor f9411d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f9412e = "sofire";

    /* renamed from: f, reason: collision with root package name */
    public static HashSet<Integer> f9413f = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    public static HashSet<Integer> f9414g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    public static boolean f9415h = true;

    /* renamed from: i, reason: collision with root package name */
    public static SharedPreferences.OnSharedPreferenceChangeListener f9416i = new SharedPreferencesOnSharedPreferenceChangeListenerC0050a();

    /* renamed from: com.baidu.sec.privacy.d.a$a, reason: collision with other inner class name */
    public class SharedPreferencesOnSharedPreferenceChangeListenerC0050a implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* renamed from: com.baidu.sec.privacy.d.a$a$a, reason: collision with other inner class name */
        public class RunnableC0051a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SharedPreferences f9417a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f9418b;

            public RunnableC0051a(SharedPreferencesOnSharedPreferenceChangeListenerC0050a sharedPreferencesOnSharedPreferenceChangeListenerC0050a, SharedPreferences sharedPreferences, String str) {
                this.f9417a = sharedPreferences;
                this.f9418b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.c(this.f9417a.getString(this.f9418b, ""));
            }
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (b.f9420b.equals(str)) {
                new Thread(new RunnableC0051a(this, sharedPreferences, str)).start();
            }
        }
    }

    public static boolean a() {
        return f9409b;
    }

    public static void b(String str) {
        try {
            SharedPreferences sharedPreferences = com.baidu.sec.privacy.b.b.a().getSharedPreferences("prv_config", 0);
            f9410c = sharedPreferences;
            f9411d = sharedPreferences.edit();
            f9412e = str;
            c(b.a(str, f9416i));
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void c(String str) {
        try {
            f9408a = null;
            f9413f.clear();
            f9414g.clear();
            f9415h = true;
            try {
                f9408a = new JSONObject(str);
            } catch (Throwable unused) {
                f9408a = new JSONObject();
            }
            c();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static boolean a(int i4) {
        try {
            return f9414g.contains(Integer.valueOf(i4));
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static String a(String str, String str2) {
        try {
            String string = f9410c.getString(str, str2);
            if (TextUtils.isEmpty(string)) {
                return str2;
            }
            try {
                return com.baidu.sec.privacy.f.a.a(string);
            } catch (Exception unused) {
                return str2;
            }
        } catch (Throwable th) {
            c.a(th);
            return str2;
        }
    }

    public static boolean b(int i4) {
        try {
            if (b.b(f9412e)) {
                return !f9413f.contains(Integer.valueOf(i4));
            }
            return false;
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static boolean a(String str) {
        return f9410c.contains(str);
    }

    public static long a(String str, long j4) {
        return f9410c.getLong(str, j4);
    }

    public static void c() {
        if (f9408a.optInt("0", 1) == 1) {
            f9409b = true;
        } else {
            f9409b = false;
        }
        JSONArray jSONArrayOptJSONArray = f9408a.optJSONArray("1");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                try {
                    f9413f.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i4)));
                } catch (JSONException unused) {
                }
            }
        }
        JSONArray jSONArrayOptJSONArray2 = f9408a.optJSONArray("3");
        if (jSONArrayOptJSONArray2 != null) {
            int length2 = jSONArrayOptJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                try {
                    f9414g.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i5)));
                } catch (JSONException unused2) {
                }
            }
        }
        if (f9408a.optInt("4", 1) == 1) {
            f9415h = true;
        } else {
            f9415h = false;
        }
    }

    public static int a(String str, int i4) {
        return f9410c.getInt(str, i4);
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            f9411d.putString(str, com.baidu.sec.privacy.f.a.a(str2.getBytes()));
            f9411d.putLong(str + "la_in", System.currentTimeMillis());
            f9411d.commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void b(String str, int i4) {
        try {
            f9411d.putInt(str, i4);
            f9411d.putLong(str + "la_in", System.currentTimeMillis());
            f9411d.commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static boolean b() {
        return f9415h;
    }
}
