package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f153104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f153105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f153106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f153107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f153108e = null;

    public static final class a implements Runnable {
        public a() {
        }

        public static void a() {
            if (p.f153104a == true) goto L5;
            ECLiveEntranceMonitor.trace("Cart not visible; isAnchor=" + p.f153107d + " isFirstLoad=" + p.f153105b, "ECLiveCartStateChecker", true);
            new com.bytedance.android.livesdk.livecommerce.event.p(p.f153107d, p.f153105b, p.f153106c).k();
            return;
        L5:
            new com.bytedance.android.livesdk.livecommerce.event.q(p.f153107d, p.f153105b).k();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f153105b = true;
        f153108e = new a();
    }
}
