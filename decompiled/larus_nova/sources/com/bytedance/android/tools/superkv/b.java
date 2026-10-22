package com.bytedance.android.tools.superkv;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f187610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f187611b;

    public static class a implements j {
        public a() {
        }

        @Override // com.bytedance.android.tools.superkv.j
        public final void onLog(int r100, String r101) {
            if (r100 != 1) goto L5;
            boolean r102 = b.f187610a;
            return;
        L5:
            if (r100 != 2) goto L7;
            boolean r103 = b.f187610a;
            return;
        L7:
            if (r100 == 3) goto L9;
            boolean r104 = b.f187610a;
            return;
        L9:
            boolean r105 = b.f187610a;
        }

        @Override // com.bytedance.android.tools.superkv.j
        public final void onLog(int r100, String r101, Throwable r102) {
            boolean r103 = b.f187610a;
        }
    }

    static {
        Process.myPid();
        f187610a = false;
        f187611b = new a();
    }

    public static void a(String r100) {
        f187611b.onLog(3, c(r100));
    }

    public static String c(String r100) {
        return "@Thread: {" + Process.myPid() + "," + ThreadMethodProxy.currentThread().getName() + "}, msg: " + r100;
    }

    public static void e(Throwable r100) {
        if (f187610a == true) goto L11;
        if (r100.getMessage() != null) goto L7;
        String r101 = "No message.";
    L8:
        b(r101, r100);
        return;
    L7:
        r101 = r100.getMessage();
        goto L8
    L11:
        throw new KVException(r100);
    }

    public static void b(String r100, Throwable r101) {
        f187611b.onLog(3, c(r100), r101);
    }

    public static void d(String r100, Throwable r101) {
        if (f187610a == true) goto L7;
        b(r100, r101);
        return;
    L7:
        throw new KVException(r100, r101);
    }
}
