package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class M {

    /* renamed from: c, reason: collision with root package name */
    public static final String f16188c = C1604s2.m("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: d, reason: collision with root package name */
    public static M f16189d;

    /* renamed from: a, reason: collision with root package name */
    public String f16190a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f16191b;

    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16192a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16193b;

        public a(String str, int i10) {
            this.f16192a = str;
            this.f16193b = i10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String strD = B0.d(this.f16192a);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            if ((this.f16193b & 1) > 0) {
                try {
                    if (Settings.System.canWrite(M.this.f16191b)) {
                        Settings.System.putString(M.this.f16191b.getContentResolver(), M.this.f16190a, strD);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f16193b & 16) > 0) {
                C1539c0.a(M.this.f16191b, M.this.f16190a, strD);
            }
            if ((this.f16193b & 256) > 0) {
                SharedPreferences.Editor editorEdit = M.this.f16191b.getSharedPreferences(M.f16188c, 0).edit();
                editorEdit.putString(M.this.f16190a, strD);
                editorEdit.apply();
            }
        }
    }

    public M(Context context) {
        this.f16191b = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            new b(Looper.getMainLooper(), this);
        } else {
            new b(this);
        }
    }

    public static M b(Context context) {
        if (f16189d == null) {
            synchronized (M.class) {
                try {
                    if (f16189d == null) {
                        f16189d = new M(context);
                    }
                } finally {
                }
            }
        }
        return f16189d;
    }

    public final void d(String str) {
        this.f16190a = str;
    }

    public final synchronized void e(String str, int i10) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i10).start();
            return;
        }
        String strD = B0.d(str);
        if (!TextUtils.isEmpty(strD)) {
            if ((i10 & 1) > 0) {
                try {
                    Settings.System.putString(this.f16191b.getContentResolver(), this.f16190a, strD);
                } catch (Exception unused) {
                }
            }
            if ((i10 & 16) > 0) {
                C1539c0.a(this.f16191b, this.f16190a, strD);
            }
            if ((i10 & 256) > 0) {
                SharedPreferences.Editor editorEdit = this.f16191b.getSharedPreferences(f16188c, 0).edit();
                editorEdit.putString(this.f16190a, strD);
                editorEdit.apply();
            }
        }
    }

    public final void g(String str) {
        e(str, 272);
    }

    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<M> f16195a;

        public b(M m10) {
            this.f16195a = new WeakReference<>(m10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            M m10 = this.f16195a.get();
            if (m10 == null || message == null || (obj = message.obj) == null) {
                return;
            }
            m10.e((String) obj, message.what);
        }

        public b(Looper looper, M m10) {
            super(looper);
            this.f16195a = new WeakReference<>(m10);
        }
    }
}
