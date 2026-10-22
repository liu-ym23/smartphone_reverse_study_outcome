package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class ServiceBlockBinder<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f6386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f6387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a<SERVICE, RESULT> f6388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f6389d;

    class Conn implements ServiceConnection {
        private final CountDownLatch latch;
        private final a<SERVICE, RESULT> mListener;
        SERVICE service;
        final /* synthetic */ ServiceBlockBinder this$0;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r1) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r1) {
        }

        Conn(ServiceBlockBinder r3, CountDownLatch r4, a<SERVICE, RESULT> r5) {
            a<SERVICE, RESULT> r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.latch = r4;
            this.mListener = r6;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceConnected " + r3);
            this.service = this.mListener.b(r5);     // Catch: Throwable -> L8
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
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceConnected #Throwable " + th);     // Catch: Throwable -> L12
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
        public void onServiceDisconnected(ComponentName r3) {
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceDisconnected" + r3);
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
        this.f6389d = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f6387b = r4;
        this.f6388c = r7;
        this.f6386a = new CountDownLatch(1);
    }

    RESULT a() {
        ServiceBlockBinder<SERVICE, RESULT>.Conn r1 = new Conn(this, this.f6386a, this.f6388c);     // Catch: Throwable -> L12
        if (ZeusTransformUtils.bindService(this.f6389d, this.f6387b, r1, 1, "com.obric.aiagent.plugin") == false) goto L11;
        this.f6386a.await();     // Catch: Throwable -> L12
        RESULT r0 = this.f6388c.a(r1.service);     // Catch: Throwable -> L9
        a(r1);
        return r0;
    L9:
        th = th;
    L20:
        th.printStackTrace();     // Catch: Throwable -> L17
        a(r1);
    L16:
        return null;
    L17:
        th = move-exception;
        a(r1);
        throw th;
    L11:
        a(null);
    L12:
        th = th;
        r1 = null;
        goto L20
    }

    private void a(ServiceBlockBinder<SERVICE, RESULT>.Conn r2) {
        if (r2 == null) goto L10;
        ZeusTransformUtils.unbindService(this.f6389d, r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
