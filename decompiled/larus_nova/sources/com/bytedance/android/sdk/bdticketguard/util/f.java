package com.bytedance.android.sdk.bdticketguard.util;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SerialAsyncRetryExecutor f164058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f164059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f164060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f164061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f164062e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f164063a;

        public a(f r100) {
            this.f164063a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f164063a;     // Catch: Throwable -> L4
            r100.f164058a.f164041e.add(new SerialAsyncRetryExecutor.a(r100.f164061d, r100.f164062e + 1, r100.f164060c));     // Catch: Throwable -> L4
            SerialAsyncRetryExecutor.a(this.f164063a.f164058a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(SerialAsyncRetryExecutor r100, long r101, int r102, b r103, int r104) {
        this.f164058a = r100;
        this.f164059b = r101;
        this.f164060c = r102;
        this.f164061d = r103;
        this.f164062e = r104;
    }

    public final void a() {
        this.f164058a.f164040d.set(false);
        if (this.f164059b >= 0) goto L5;
    L7:
        SerialAsyncRetryExecutor.a(this.f164058a);
        return;
    L5:
        if (this.f164060c != this.f164058a.f164039c.get()) goto L7;
        this.f164058a.b().schedule(new a(this), this.f164059b, TimeUnit.MILLISECONDS);
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
