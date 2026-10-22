package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.AbsWsClientService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ClientMsgSender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f7014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends AbsWsClientService> f7015b;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.ClientMsgSender$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class OSender implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicInteger f7016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClientMsgSender f7017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f7018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Messenger f7019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final LinkedBlockingDeque<Intent> f7020e;
        private ServiceConnection f;
        private boolean g;
        private final Object h;
        private final Runnable i;
        private final Runnable j;

        private class MessengerServiceConnection implements ServiceConnection {
            final /* synthetic */ OSender this$1;

            private MessengerServiceConnection(OSender r1) {
                this.this$1 = r1;
            }

            /* synthetic */ MessengerServiceConnection(OSender r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r4) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r4.toString());
            L5:
                Object r0 = OSender.a(this.this$1);
                monitor-enter(r0);
                if (r4 != null) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L10:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L13
                OSender.a(this.this$1, null);     // Catch: Throwable -> L13
                OSender.a(this.this$1, null);     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L13
                OSender.a(this.this$1, false);     // Catch: Throwable -> L13
                OSender.e(this.this$1);     // Catch: Throwable -> L13
                OSender.f(this.this$1);     // Catch: Throwable -> L13
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r4, IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r4.toString());
            L5:
                Object r0 = OSender.a(this.this$1);
                monitor-enter(r0);
                OSender.f(this.this$1);     // Catch: Throwable -> L20
                if (r4 == null) goto L18;
                if (r6 == null) goto L18;
                OSender.a(this.this$1, new Messenger(r6));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                OSender.g(this.this$1);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
                OSender.a(this.this$1, false);     // Catch: Throwable -> L20
                monitor-exit(r0);     // Catch: Throwable -> L20
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L20
            L18:
                monitor-exit(r0);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            }
        }

        static /* synthetic */ ServiceConnection a(OSender r2, ServiceConnection r3) {
            ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
            r2.f = r4;
            return r4;
        }

        static /* synthetic */ Messenger a(OSender r0, Messenger r1) {
            r0.f7019d = r1;
            return r1;
        }

        static /* synthetic */ Object a(OSender r0) {
            return r0.h;
        }

        static /* synthetic */ boolean a(OSender r0, boolean r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ boolean b(OSender r0) {
            return r0.g;
        }

        static /* synthetic */ ServiceConnection c(OSender r0) {
            return r0.f;
        }

        static /* synthetic */ Context d(OSender r0) {
            return r0.f7018c;
        }

        static /* synthetic */ void e(OSender r0) {
            r0.g();
        }

        static /* synthetic */ void f(OSender r0) {
            r0.e();
        }

        static /* synthetic */ void g(OSender r0) {
            r0.b();
        }

        OSender(ClientMsgSender r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f7017b = r3;
            this.f7020e = new LinkedBlockingDeque();
            this.g = false;
            this.h = new Object();
            this.i = new AnonymousClass1(this);
            this.j = new AnonymousClass2(this);
            this.f7016a = new AtomicInteger(0);
            this.f7018c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.b
        public void a(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r4.putExtra(WsConstants.MSG_COUNT, this.f7016a.addAndGet(1));
        L7:
            Object r0 = this.h;
            monitor-enter(r0);
            g();     // Catch: Throwable -> L19
            this.f7020e.offer(r4);     // Catch: Throwable -> L19
            if (this.f7019d == null) goto L12;
            b();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L12:
            if (this.g == false) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L15:
            c();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.b
        public void a() {
            if (this.f7020e.size() > 0) goto L5;
            return;
        L5:
            if (this.f7019d != null) goto L21;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r0 = this.h;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L9:
            if (this.f7020e.size() > 0) goto L11;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L11:
            if (this.f7019d != null) goto L13;
            c();     // Catch: Throwable -> L15
            goto L13
        }

        private void b() {
        L17:
        L14:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.f7020e.peek() == null) goto L12;
            Intent r0 = (Intent) ZeusTransformUtils.preCheckCast(this.f7020e.poll(), Intent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            if (r0 == null) goto L6;
            b(r0);     // Catch: Throwable -> L9 DeadObjectException -> L11
        L11:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L14
            this.f7019d = null;     // Catch: Throwable -> L14
            this.f7020e.offerFirst(r0);     // Catch: Throwable -> L14
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L14
            goto L17
        L6:
            return;
        L12:
            f();     // Catch: Throwable -> L14
        }

        private void b(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r4);
        L7:
            Messenger r3 = this.f7019d;
            Message r0 = new Message();
            r0.what = WsConstants.MSG_INTENT;
            r0.getData().putParcelable(WsConstants.DATA_INTENT, r4);
            if (r3 != null) goto L10;
            return;
        L10:
            r3.send(r0);
        }

        private void c() {
            if (Logger.debug() == false) goto L12;
            Logger.d("WsChannelSdk", "doBindService");
        L12:
            ZeusTransformUtils.startService(this.f7018c, new Intent(this.f7018c, ClientMsgSender.a(this.f7017b)), "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        L14:
            this.f = new MessengerServiceConnection(this, null);     // Catch: Throwable -> L8
            ZeusTransformUtils.bindService(this.f7018c, new Intent(this.f7018c, ClientMsgSender.a(this.f7017b)), this.f, 1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            d();     // Catch: Throwable -> L8
            this.g = true;     // Catch: Throwable -> L8
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            e();
            this.g = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        private void d() {
            e();
            com.bytedance.common.wschannel.g.a().b().postDelayed(this.i, TimeUnit.SECONDS.toMillis(7));
        }

        private void e() {
            com.bytedance.common.wschannel.g.a().b().removeCallbacks(this.i);
        }

        private synchronized void f() {
            monitor-enter(this);
            g();     // Catch: Throwable -> L6
            com.bytedance.common.wschannel.g.a().b().postDelayed(this.j, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void g() {
            com.bytedance.common.wschannel.g.a().b().removeCallbacks(this.j);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    private class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClientMsgSender f7023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f7024b;

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.b
        public void a() {
        }

        a(ClientMsgSender r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f7023a = r3;
            this.f7024b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.b
        public void a(Intent r4) {
            r4.setComponent(new ComponentName(this.f7024b, ClientMsgSender.a(this.f7023a)));     // Catch: Throwable -> L4
            ZeusTransformUtils.startService(this.f7024b, r4, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public interface b {
        void a();

        void a(Intent r1);
    }

    static /* synthetic */ Class a(ClientMsgSender r0) {
        return r0.f7015b;
    }

    public ClientMsgSender(Context r3, Class<? extends AbsWsClientService> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L7:
        this.f7014a = new a(this, r5);
    L8:
        this.f7015b = r4;
        return;
    L5:
        if (r5.getApplicationInfo().targetSdkVersion < 26) goto L7;
        this.f7014a = new OSender(this, r5);
        goto L8
    }

    public void a(Intent r1) {
        this.f7014a.a(r1);
    }

    public void a() {
        this.f7014a.a();
    }
}
