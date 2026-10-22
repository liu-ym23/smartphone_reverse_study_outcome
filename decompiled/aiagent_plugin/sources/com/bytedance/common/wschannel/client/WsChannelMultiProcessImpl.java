package com.bytedance.common.wschannel.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.m;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessImpl implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6920c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Messenger f6921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f6922b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f6923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6924e;
    private long f;
    private WeakReference<Context> g;
    private final LinkedBlockingDeque<j.a> h;

    class MessengerServiceConnection implements ServiceConnection {
        final /* synthetic */ WsChannelMultiProcessImpl this$0;

        MessengerServiceConnection(WsChannelMultiProcessImpl r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r6) {
            if (r6 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r6.toString());
        L13:
            this.this$0.f6921a = null;     // Catch: Throwable -> L9
            WsChannelMultiProcessImpl.c(this.this$0).clear();     // Catch: Throwable -> L9
            WsChannelMultiProcessImpl.b(this.this$0, r6);     // Catch: Throwable -> L9
        L11:
            WsChannelMultiProcessImpl.a(this.this$0, 2, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.d(this.this$0));
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L11
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName r5, IBinder r6) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L19;
            if (r7 != null) goto L7;
            return;
        L7:
            if (Logger.debug() == false) goto L18;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r5.toString() + ", " + WsChannelMultiProcessImpl.a());
        L18:
            this.this$0.f6921a = new Messenger(r7);     // Catch: Throwable -> L14
            if (WsChannelMultiProcessImpl.a() == false) goto L12;
            com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r5));     // Catch: Throwable -> L14
        L16:
            WsChannelMultiProcessImpl.a(this.this$0, SystemClock.uptimeMillis());
            WsChannelMultiProcessImpl.a(this.this$0, 0, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.a(this.this$0));
            return;
        L12:
            WsChannelMultiProcessImpl.a(this.this$0, r5);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.printStackTrace();
            goto L16
        }
    }

    static {
    }

    public WsChannelMultiProcessImpl() {
        this.f6923d = new AnonymousClass1(this);
        this.f6924e = 0;
        this.f = 0;
        this.h = new LinkedBlockingDeque();
    }

    static /* synthetic */ long a(WsChannelMultiProcessImpl r2) {
        return r2.f6924e;
    }

    static /* synthetic */ long a(WsChannelMultiProcessImpl r0, long r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ WeakReference a(WsChannelMultiProcessImpl r0, WeakReference r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ void a(WsChannelMultiProcessImpl r0, int r1, long r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(WsChannelMultiProcessImpl r0, ComponentName r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a() {
        return f6920c;
    }

    static /* synthetic */ WeakReference b(WsChannelMultiProcessImpl r0) {
        return r0.g;
    }

    static /* synthetic */ void b(WsChannelMultiProcessImpl r0, ComponentName r1) {
        r0.d(r1);
    }

    static /* synthetic */ LinkedBlockingDeque c(WsChannelMultiProcessImpl r0) {
        return r0.h;
    }

    static /* synthetic */ long d(WsChannelMultiProcessImpl r2) {
        return r2.f;
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3, boolean r4, boolean r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L5;
        a(r6, r5);
        return;
    L5:
        com.bytedance.common.utility.a.c.a(new AnonymousClass2(this, r6));
    }

    private void a(Context r3, final boolean r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.common.utility.a.c.a(new AnonymousClass3(this, r5, r4));
    }

    private synchronized void a(ComponentName r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f6921a != null) goto L6;
        b(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        c(r2);     // Catch: Throwable -> L9
        goto L7
    }

    private void a(ComponentName r2, Message r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r3.toString() + " , + what = " + r3.what);
    L7:
        Messenger r1 = this.f6921a;
        if (r1 != null) goto L10;
        return;
    L10:
        r1.send(r3);
    }

    private void b(ComponentName r5) {
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L24;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(r0.get(), Context.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r5 != null) goto L19;
        return;
    L19:
        Intent r2 = new Intent();     // Catch: Throwable -> L18
        r2.setComponent(r5);     // Catch: Throwable -> L18
        ZeusTransformUtils.startService(r1, r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L21:
        Intent r3 = new Intent();     // Catch: Throwable -> L15
        r3.setComponent(r5);     // Catch: Throwable -> L15
        MessengerServiceConnection r6 = new MessengerServiceConnection(this);     // Catch: Throwable -> L15
        this.f6922b = r6;     // Catch: Throwable -> L15
        b();     // Catch: Throwable -> L15
        ZeusTransformUtils.bindService(r1, r3, r6, 1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void b() {
        this.f6924e = SystemClock.uptimeMillis();
        if (WsConstants.getBindWsChannelServiceListener() != null) goto L5;
        return;
    L5:
        com.bytedance.common.wschannel.g.a().b().postDelayed(this.f6923d, 10000);
    }

    private void a(int r1, long r2) {
        com.bytedance.common.wschannel.app.a r0 = WsConstants.getBindWsChannelServiceListener();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2);
    }

    private void c(ComponentName r6) {
        if (r6 != null) goto L17;
        return;
    L17:
        if (this.h.peek() == null) goto L27;
        j.a r0 = (j.a) ZeusTransformUtils.preCheckCast(this.h.poll(), j.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 == null) goto L8;
        Message r1 = new Message();     // Catch: Throwable -> L16
        r1.what = r0.f6940c;     // Catch: Throwable -> L16
        r1.getData().putParcelable(r0.f6938a, r0.f6939b);     // Catch: Throwable -> L16
        a(r6, r1);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.f6921a = null;     // Catch: Throwable -> L16
        this.h.offerFirst(r0);     // Catch: Throwable -> L16
        a(3, SystemClock.uptimeMillis() - this.f);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L17
    L8:
        return;
    L27:
        return;
    }

    private synchronized void d(ComponentName r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    private void a(Context r5, IWsApp r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        IWsApp r8 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r6, IWsApp.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L24;
        if (r8 == null) goto L25;
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L9;
    L10:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d("WsChannelSdk", "register wsApp = " + r8.toString());
    L15:
        if (m.a(r7).c() == true) goto L22;
        return;
    L22:
        ComponentName r1 = new ComponentName(r7, WsChannelService.class);     // Catch: Throwable -> L19
        j.a r9 = new j.a();     // Catch: Throwable -> L19
        r9.f6938a = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L19
        r9.f6939b = r8;     // Catch: Throwable -> L19
        r9.f6940c = 0;     // Catch: Throwable -> L19
        this.h.offer(r9);     // Catch: Throwable -> L19
        a(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        if (r0.get() != null) goto L12;
    L25:
        return;
    }

    private void b(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L8;
    L9:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L11:
        if (Logger.debug() == false) goto L18;
        Logger.d("WsChannelSdk", "unregister channelId = " + r6);
    L18:
        ComponentName r1 = new ComponentName(r7, WsChannelService.class);     // Catch: Throwable -> L15
        j.a r8 = new j.a();     // Catch: Throwable -> L15
        r8.f6938a = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L15
        r8.f6939b = new IntegerParcelable(r6);     // Catch: Throwable -> L15
        r8.f6940c = 1;     // Catch: Throwable -> L15
        this.h.offer(r8);     // Catch: Throwable -> L15
        a(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
        goto L9
    }

    private void b(Context r5, IWsApp r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        IWsApp r8 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r6, IWsApp.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L24;
        if (r8 == null) goto L25;
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L9;
    L10:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d("WsChannelSdk", "sendParameterChange wsApp = " + r8.toString());
    L15:
        if (m.a(r7).c() == true) goto L22;
        return;
    L22:
        ComponentName r1 = new ComponentName(r7, WsChannelService.class);     // Catch: Throwable -> L19
        j.a r9 = new j.a();     // Catch: Throwable -> L19
        r9.f6938a = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L19
        r9.f6939b = r8;     // Catch: Throwable -> L19
        r9.f6940c = 4;     // Catch: Throwable -> L19
        this.h.offer(r9);     // Catch: Throwable -> L19
        a(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        if (r0.get() != null) goto L12;
    L25:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r5, WsChannelMsg r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L24;
        if (r6 == null) goto L25;
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L9;
    L10:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d("WsChannelSdk", "sendPayload wsChannelMsg = " + r6.toString());
    L15:
        if (m.a(r7).c() == true) goto L22;
        return;
    L22:
        ComponentName r1 = new ComponentName(r7, WsChannelService.class);     // Catch: Throwable -> L19
        j.a r8 = new j.a();     // Catch: Throwable -> L19
        r8.f6938a = "payload";     // Catch: Throwable -> L19
        r8.f6939b = r6;     // Catch: Throwable -> L19
        r8.f6940c = 5;     // Catch: Throwable -> L19
        this.h.offer(r8);     // Catch: Throwable -> L19
        a(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        if (r0.get() != null) goto L12;
    L25:
        return;
    }

    private void c(Context r5, final int r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        if (r6 > 0) goto L6;
        return;
    L6:
        if (r6 > 3) goto L23;
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L11;
    L12:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L14:
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r6);
    L17:
        if (m.a(r7).c() == true) goto L19;
        return;
    L19:
        com.bytedance.common.utility.a.c.a(new AnonymousClass4(this, r7, r6));
        return;
    L11:
        if (r0.get() != null) goto L14;
    L23:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r5, SsWsApp r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L8;
    L9:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L11:
        if (m.a(r7).c() == true) goto L13;
        return;
    L13:
        if (r6 == null) goto L16;
        a(r7, r6);
        return;
    L16:
        return;
    L8:
        if (r0.get() != null) goto L11;
        goto L9
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelSdk", "unRegisterApp");
    L8:
        b(r5, r4);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void b(Context r5, SsWsApp r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        if (r6 == null) goto L20;
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L9;
    L10:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d("WsChannelSdk", "onParameterChange" + r6.toString());
    L15:
        if (m.a(r7).c() == true) goto L17;
        return;
    L17:
        b(r7, r6);
        return;
    L9:
        if (r0.get() != null) goto L12;
    L20:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3) {
        c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 1);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void b(Context r3) {
        c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 2);
    }
}
