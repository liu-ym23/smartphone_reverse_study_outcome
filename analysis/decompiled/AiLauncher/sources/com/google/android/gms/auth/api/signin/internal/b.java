package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.C1669j;
import io.ktor.sse.ServerSentEventKt;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final Lock f19480c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static b f19481d;

    /* renamed from: a, reason: collision with root package name */
    public final Lock f19482a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f19483b;

    public b(Context context) {
        this.f19483b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        C1669j.k(context);
        Lock lock = f19480c;
        lock.lock();
        try {
            if (f19481d == null) {
                f19481d = new b(context.getApplicationContext());
            }
            b bVar = f19481d;
            lock.unlock();
            return bVar;
        } catch (Throwable th) {
            f19480c.unlock();
            throw th;
        }
    }

    public static final String d(String str, String str2) {
        return str + ServerSentEventKt.COLON + str2;
    }

    public GoogleSignInAccount b() {
        String strC;
        String strC2 = c("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strC2) && (strC = c(d("googleSignInAccount", strC2))) != null) {
            try {
                return GoogleSignInAccount.zab(strC);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final String c(String str) {
        this.f19482a.lock();
        try {
            return this.f19483b.getString(str, null);
        } finally {
            this.f19482a.unlock();
        }
    }
}
