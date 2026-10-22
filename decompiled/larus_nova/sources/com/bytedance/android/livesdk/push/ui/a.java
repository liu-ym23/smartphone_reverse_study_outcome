package com.bytedance.android.livesdk.push.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f156870a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.push.ui.a$a, reason: collision with other inner class name */
    public static final class C2395a {
        public C2395a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f156871a;

        public b(a r100) {
            this.f156871a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f156871a.getClass();     // Catch: Throwable -> L4
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
        new C2395a();
    }

    public a() {
        new b(this);
    }
}
