package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
final class ServiceBlockBinder<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f37356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f37357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a<SERVICE, RESULT> f37358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f37359d;

    class Conn implements ServiceConnection {
        private final CountDownLatch latch;
        private final a<SERVICE, RESULT> mListener;
        SERVICE service;
        final /* synthetic */ ServiceBlockBinder this$0;

        Conn(ServiceBlockBinder r3, CountDownLatch r4, a<SERVICE, RESULT> r5) {
            a<SERVICE, RESULT> r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.latch = r4;
            this.mListener = r6;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
            com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "ServiceBlockBinder#onServiceConnected " + r4);
            this.service = this.mListener.b(r6);     // Catch: Throwable -> L8
            this.latch.countDown();     // Catch: Exception -> L6
        L18:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "ServiceBlockBinder#onServiceConnected", th);     // Catch: Throwable -> L12
            this.latch.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.latch.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L17
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "ServiceBlockBinder#onServiceDisconnected" + r4);
            this.latch.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    interface a<T, RESULT> {
        RESULT a(T r1);

        T b(IBinder r1);
    }

    ServiceBlockBinder(Context r3, Intent r4, a<SERVICE, RESULT> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a<SERVICE, RESULT> r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        this.f37359d = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f37357b = r4;
        this.f37358c = r7;
        this.f37356a = new CountDownLatch(1);
    }

    RESULT a() {
        ServiceBlockBinder<SERVICE, RESULT>.Conn r1 = new Conn(this, this.f37356a, this.f37358c);     // Catch: Throwable -> L9
        ZeusTransformUtils.bindService(this.f37359d, this.f37357b, r1, 1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        this.f37356a.await();     // Catch: Throwable -> L9
        RESULT r0 = this.f37358c.a(r1.service);     // Catch: Throwable -> L7
        a(r1);
        return r0;
    L7:
        th = th;
    L17:
        th.printStackTrace();     // Catch: Throwable -> L14
        a(r1);
        return null;
    L14:
        th = move-exception;
        a(r1);
        throw th;
    L9:
        th = th;
        r1 = null;
        goto L17
    }

    private void a(ServiceBlockBinder<SERVICE, RESULT>.Conn r2) {
        if (r2 == null) goto L10;
        ZeusTransformUtils.unbindService(this.f37359d, r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
