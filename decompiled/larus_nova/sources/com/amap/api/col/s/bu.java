package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26337a = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static bu f26338f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f26339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f26341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f26342e;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<bu> f26346a;

        public a(bu r100) {
            this.f26346a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            bu r101 = this.f26346a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100 == null) goto L11;
            Object r102 = r100.obj;
            if (r102 == null) goto L12;
            bu.a(r101, (String) r102, r100.what);
            return;
        L12:
            return;
        }

        public a(Looper r100, bu r101) {
            super(r100);
            this.f26346a = new WeakReference(r101);
        }
    }

    static {
        f26337a = bs.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    private bu(Context r100) {
        this.f26341d = r100.getApplicationContext();
        if (Looper.myLooper() != null) goto L6;
        this.f26342e = new a(Looper.getMainLooper(), this);
        return;
    L6:
        this.f26342e = new a(this);
    }

    public static bu a(Context r100) {
        if (f26338f != null) goto L15;
        monitor-enter(bu.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f26338f != null) goto L9;
        f26338f = new bu(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(bu.class);     // Catch: Throwable -> L11
    L15:
        return f26338f;
    }

    public final void b(String r100) {
        List<String> r101 = this.f26339b;
        if (r101 == null) goto L5;
        r101.clear();
        this.f26339b.add(r100);
    L5:
        a(r100, 273);
    }

    public static /* synthetic */ Context a(bu r100) {
        return r100.f26341d;
    }

    public static /* synthetic */ String b(bu r100) {
        return r100.f26340c;
    }

    public final void a(String r100) {
        this.f26340c = r100;
    }

    private synchronized void a(final String r100, final int r101) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        ThreadMethodProxy.start(new AnonymousClass1(this, r100, r101));     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L8:
        String r102 = ca.b(r100);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r102) == false) goto L11;
    L26:
        monitor-exit(this);
        return;
    L11:
        if ((r101 & 1) <= 0) goto L19;
        if (Build.VERSION.SDK_INT < 23) goto L15;
        Settings.System.putString(this.f26341d.getContentResolver(), this.f26340c, r102);     // Catch: Exception -> L17 Throwable -> L28
    L32:
        goto L19
    L15:
        Settings.System.putString(this.f26341d.getContentResolver(), this.f26340c, r102);     // Catch: Exception -> L17 Throwable -> L28
    L19:
        if ((r101 & 16) <= 0) goto L22;
        bw.a(this.f26341d, this.f26340c, r102);     // Catch: Throwable -> L28
    L22:
        if ((r101 & 256) <= 0) goto L26;
        SharedPreferences.Editor r103 = this.f26341d.getSharedPreferences(f26337a, 0).edit();     // Catch: Throwable -> L28
        r103.putString(this.f26340c, r102);     // Catch: Throwable -> L28
        r103.apply();     // Catch: Throwable -> L28
        monitor-exit(this);
    }

    public static /* synthetic */ void a(bu r100, String r101, int r102) {
        r100.a(r101, r102);
    }
}
