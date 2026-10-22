package com.alipay.sdk.m.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public class g implements com.alipay.sdk.m.b.b {

    public static /* synthetic */ class a {
    }

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f25252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f25253b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public IBinder a() throws InterruptedException {
            if (this.f25252a == true) goto L7;
            this.f25252a = true;
            return this.f25253b.poll(5, TimeUnit.SECONDS);
        L7:
            throw new IllegalStateException();
        }

        public b() {
            this.f25252a = false;
            this.f25253b = new LinkedBlockingQueue();
        }

        public /* synthetic */ b(a r100) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            this.f25253b.put(r101);     // Catch: InterruptedException -> L4
            return;
        }
    }

    public g() {
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context r100) {
        b r101 = new b(null);
        Intent r102 = new Intent();
        r102.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (r100.bindService(r102, r101, 1) == true) goto L12;
    L11:
        return null;
    L12:
        String r103 = com.alipay.sdk.m.k0.a.AbstractBinderC0485a.a(r101.a()).a();     // Catch: Throwable -> L7 Exception -> L10
        r100.unbindService(r101);
        return r103;
    L10:
        r100.unbindService(r101);
    L7:
        th = move-exception;
        r100.unbindService(r101);
        throw th;
    }
}
