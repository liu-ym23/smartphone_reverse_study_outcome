package com.bytedance.crash.e;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;

/* JADX INFO: compiled from: GameCrash.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7445a;

    /* JADX INFO: renamed from: com.bytedance.crash.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GameCrash.java */
    static class RunnableC0163a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f7446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f7450e;

        RunnableC0163a(String r1, long r2, String r4, String r5, String r6) {
            this.f7449d = r1;
            this.f7446a = r2;
            this.f7447b = r4;
            this.f7448c = r5;
            this.f7450e = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.crash.monitor.a r0 = h.a();
            if (r0 != null) goto L5;
            return;
        L5:
            boolean r7 = false;
            com.bytedance.crash.entity.a r8 = c.a(r0, this.f7449d, this.f7446a, this.f7447b, this.f7448c, this.f7450e);     // Catch: Throwable -> L10
            r7 = com.bytedance.crash.upload.b.a(o.a(CrashType.GAME, r8.a().b()), r8.c());     // Catch: Throwable -> L10
        L7:
            if (r7 == true) goto L13;
            r.b("upload failed!");
            return;
        }
    }

    public static void a(String r8, String r9, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L10;
        if (TextUtils.isEmpty(r9) == false) goto L10;
        if (TextUtils.isEmpty(r8) == false) goto L10;
        return;
    L10:
        if (f7445a == false) goto L12;
        return;
    L12:
        long r3 = System.currentTimeMillis();
        DefaultWorkThread.post(new RunnableC0163a(Thread.currentThread().getName(), r3, r8, r9, r10));
    }

    public static void a(boolean r0) {
        f7445a = r0;
    }
}
