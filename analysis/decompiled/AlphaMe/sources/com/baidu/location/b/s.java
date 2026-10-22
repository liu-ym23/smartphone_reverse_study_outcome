package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static Object f5454a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static s f5455b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f5456c;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences f5457d = null;

    public s() {
        this.f5456c = null;
        if (com.baidu.location.f.getServiceContext() != null) {
            this.f5456c = a(com.baidu.location.f.getServiceContext());
        }
    }

    public synchronized long a(String str, long j4) {
        SharedPreferences sharedPreferences = this.f5456c;
        if (sharedPreferences != null) {
            try {
                j4 = sharedPreferences.getLong(str, j4);
            } catch (Exception unused) {
            }
        }
        return j4;
    }

    public SharedPreferences b(Context context) {
        if (this.f5457d == null && context != null) {
            try {
                this.f5457d = context.getSharedPreferences("MapCoreServicePregck", 0);
            } catch (Exception e4) {
                e4.printStackTrace();
                this.f5457d = null;
            }
        }
        return this.f5457d;
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("MapCoreServicePreIA", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public synchronized void b(String str, long j4) {
        SharedPreferences sharedPreferences = this.f5456c;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putLong(str, j4);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static s a() {
        s sVar;
        synchronized (f5454a) {
            try {
                if (f5455b == null) {
                    f5455b = new s();
                }
                sVar = f5455b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public synchronized void b(String str, String str2) {
        SharedPreferences sharedPreferences = this.f5456c;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(str, str2);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public synchronized String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f5456c;
        if (sharedPreferences != null) {
            try {
                str2 = sharedPreferences.getString(str, str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }
}
