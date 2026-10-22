package com.bytedance.android.livesdk.jsbridge.methods;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class t3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.pushstream.d f142207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f142208b;

    public static final class a extends tp2.b {
        public a() {
        }
    }

    public t3(com.bytedance.android.live.pushstream.d r100, String r101) {
        this.f142207a = r100;
        this.f142208b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        xs2.b.a().post(new zg1.n1(this.f142207a, new a(), false, 0, false, this.f142208b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
