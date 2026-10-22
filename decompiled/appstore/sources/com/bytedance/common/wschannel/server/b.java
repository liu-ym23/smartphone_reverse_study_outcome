package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IMessageHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static AtomicBoolean f7107i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClientMsgSender f7111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BlockingQueue f7112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExecutorService f7113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f7114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Future f7115h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IWsChannelClient f7116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f7117b;

        public a(b r10, IWsChannelClient r11) {
            this.f7117b = r10;
            this.f7116a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7116a.sendMessage(com.bytedance.common.wschannel.server.a.l(b.a(this.f7117b)).g());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.b$b, reason: collision with other inner class name */
    public class RunnableC0090b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f7118a;

        public RunnableC0090b(b r10) {
            this.f7118a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("MessageDispatcher");     // Catch: Throwable -> L11
        L3:
            Thread.currentThread();     // Catch: Throwable -> L11
            if (Thread.interrupted() == true) goto L13;
            b.b().getAndSet(true);     // Catch: Throwable -> L11
            WsChannelService.a r10 = (WsChannelService.a) b.c(this.f7118a).take();     // Catch: Throwable -> L11
            b.d(this.f7118a, r10);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L11
        L13:
            b.b().getAndSet(false);
            return;
        L11:
            th = move-exception;
            th.printStackTrace();
            goto L13
        }
    }

    static {
        f7107i = new AtomicBoolean(true);
    }

    public b(Context r10, Map r11, Map r12) {
        this.f7112e = new LinkedBlockingQueue();
        this.f7113f = Executors.newSingleThreadExecutor();
        this.f7114g = e();
        this.f7115h = null;
        this.f7108a = r10;
        this.f7109b = r11;
        this.f7110c = r12;
        this.f7111d = new ClientMsgSender(r10, WsClientService.class);
        h();
    }

    public static /* synthetic */ Context a(b r10) {
        return r10.f7108a;
    }

    public static /* synthetic */ AtomicBoolean b() {
        return f7107i;
    }

    public static /* synthetic */ BlockingQueue c(b r10) {
        return r10.f7112e;
    }

    public static /* synthetic */ void d(b r10, WsChannelService.a r11) {
        r10.f(r11);
    }

    public final Runnable e() {
        return new RunnableC0090b(this);
    }

    public final void f(WsChannelService.a r10) {
        if (r10 == null) goto L56;
        byte[] r11 = r10.f7090b;
        if (r11 == null) goto L58;
    L10:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L41;
        Logger.e("WsChannelSdk", "不支持的消息协议，忽略此消息");
        return;
    L41:
        th.printStackTrace();
        return;
    L8:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelService", "data = " + j4.a.a(r11) + " data.length = " + r11.length);     // Catch: Throwable -> L10
    L12:
        WsChannelMsg r12 = e4.a.a().decode(r11);     // Catch: Throwable -> L10
        if (r12 != WsChannelMsg.EMPTY) goto L15;
        return;
    L15:
        r12.setChannelId(r10.f7089a);     // Catch: Throwable -> L10
        r12.setReplayToComponentName(new ComponentName(this.f7108a, WsChannelService.class));     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L18;
        Logger.d("WsChannelService", "version =  seqId = " + r12.getSeqId() + " logId = " + r12.getLogId() + " wsChannelMsg = " + r12.toString());     // Catch: Throwable -> L10
    L18:
        Map r13 = this.f7110c;     // Catch: Throwable -> L10
        if (r13 != null) goto L21;
        return;
    L21:
        if (r13.size() <= 0) goto L55;
        Iterator r14 = this.f7110c.entrySet().iterator();     // Catch: Throwable -> L10
    L24:
        if (r14.hasNext() == false) goto L59;
        IWsApp r15 = (IWsApp) ((Map.Entry) r14.next()).getValue();     // Catch: Throwable -> L10
        if (r15 == null) goto L24;
        if (r15.getChannelId() != r12.getChannelId()) goto L24;
        Intent r16 = new Intent();     // Catch: Throwable -> L34
        r16.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L34
        r16.setComponent(new ComponentName(this.f7108a, WsClientService.class));     // Catch: Throwable -> L34
        r16.putExtra(WsConstants.KEY_PAYLOAD, r12);     // Catch: Throwable -> L34
        i(r16);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        goto L24
    L59:
        return;
    L55:
        return;
    L58:
        return;
    }

    public void g(SocketState r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f7109b.put(Integer.valueOf(r10.getChannelId()), r10);
        Intent r11 = new Intent();     // Catch: Throwable -> L7
        r11.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r11.setComponent(new ComponentName(this.f7108a, WsClientService.class));     // Catch: Throwable -> L7
        r11.putExtra(WsConstants.KEY_CONNECTION, r10);     // Catch: Throwable -> L7
        i(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public final void h() {
        if (this.f7114g != null) goto L10;
        this.f7114g = e();
    L10:
        this.f7115h = this.f7113f.submit(this.f7114g);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public final void i(Intent r10) {
        this.f7111d.b(r10);
    }

    public void j() {
        Intent r10 = new Intent();     // Catch: Throwable -> L4
        r10.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r10.setComponent(new ComponentName(this.f7108a, WsClientService.class));     // Catch: Throwable -> L4
        r10.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f7109b.values()));     // Catch: Throwable -> L4
        i(r10);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void k() {
        this.f7111d.c();
    }

    public final void l(IWsChannelClient r10) {
        if (com.bytedance.common.wschannel.b.d(this.f7108a).g() == true) goto L5;
        return;
    L5:
        com.bytedance.common.wschannel.server.a.l(this.f7108a).p(new a(this, r10));
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r10, int r11, JSONObject r12) {
        if (r12 != null) goto L10;
        return;
    L10:
        r12.put(WsConstants.KEY_CHANNEL_ID, r11);     // Catch: JSONException -> L6
    L8:
        g(SocketState.fromJson(r12));
        l(r10);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r10, byte[] r11) {
        if (r11 != null) goto L9;
        return;
    L9:
        WsChannelService.a r12 = new WsChannelService.a();     // Catch: Throwable -> L6
        r12.f7089a = r10;     // Catch: Throwable -> L6
        r12.f7090b = r11;     // Catch: Throwable -> L6
        this.f7112e.offer(r12);     // Catch: Throwable -> L6
        f7107i.getAndSet(true);     // Catch: Throwable -> L6
        h();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }
}
