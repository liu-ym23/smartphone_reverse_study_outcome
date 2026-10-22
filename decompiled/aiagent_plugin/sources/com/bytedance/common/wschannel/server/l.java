package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: compiled from: WsChannelMsgHandler.java */
/* JADX INFO: loaded from: classes.dex */
class l implements com.bytedance.common.wschannel.channel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f7082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f7084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClientMsgSender f7085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7086e;
    private b f;
    private BlockingQueue<WsChannelService.a> g;
    private ExecutorService h;
    private Runnable i;
    private Future<?> j;

    static /* synthetic */ BlockingQueue a(l r0) {
        return r0.g;
    }

    static /* synthetic */ void a(l r0, WsChannelService.a r1) {
        r0.a(r1);
    }

    static /* synthetic */ AtomicBoolean c() {
        return f7082a;
    }

    static {
        f7082a = new AtomicBoolean(true);
    }

    l(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.g = new LinkedBlockingQueue();
        this.h = Executors.newSingleThreadExecutor();
        this.i = e();
        this.j = null;
        this.f7083b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f7084c = r4;
        this.f7085d = new ClientMsgSender(r5, WsClientService.class);
        this.f7086e = true;
        d();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(int r4, byte[] r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        WsChannelService.a r2 = new WsChannelService.a(r4, r5, f());     // Catch: Throwable -> L6
        this.g.offer(r2);     // Catch: Throwable -> L6
        f7082a.getAndSet(true);     // Catch: Throwable -> L6
        d();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(int r4, WsChannelMsg r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        WsChannelService.a r2 = new WsChannelService.a(r4, r5, f());     // Catch: Throwable -> L6
        this.g.offer(r2);     // Catch: Throwable -> L6
        f7082a.getAndSet(true);     // Catch: Throwable -> L6
        d();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(IWsChannelClient r3, int r4, JSONObject r5) {
        IWsChannelClient r6 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L13;
        return;
    L13:
        r5.put(WsConstants.KEY_CHANNEL_ID, r4);     // Catch: JSONException -> L7
    L9:
        SocketState r7 = SocketState.fromJson(r5);
        a(r6, r7);
        a(r6);
        if (Logger.debug() == false) goto L15;
        Logger.d("WsChannelService", "onConnection: state=" + r7.connectionState + " | type=" + r7.connectionType + " | error=" + r7.error);
        return;
    L15:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private void a(IWsChannelClient r3) {
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.wschannel.m.a(this.f7083b).h() == true) goto L5;
        return;
    L5:
        this.f.a(r4);
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(IWsChannelClient r4, SocketState r5) {
        IWsChannelClient r6 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r4, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.f7084c.f7033c.put(Integer.valueOf(r5.getChannelId()), r5);
        Intent r7 = new Intent();     // Catch: Throwable -> L8
        r7.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L8
        r7.setComponent(new ComponentName(this.f7083b, WsClientService.class));     // Catch: Throwable -> L8
        r7.putExtra(WsConstants.KEY_CONNECTION, r5);     // Catch: Throwable -> L8
        a(r7);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(ServiceConnectEvent r5) {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r0.setComponent(new ComponentName(this.f7083b, WsClientService.class));     // Catch: Throwable -> L4
        r0.putExtra(WsConstants.KEY_SERVICE, r5);     // Catch: Throwable -> L4
        a(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private void d() {
        if (this.i != null) goto L10;
        this.i = e();
    L10:
        this.j = this.h.submit(this.i);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private Runnable e() {
        return new AnonymousClass1(this);
    }

    private void a(WsChannelService.a r12) {
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.f7028b != null) goto L11;
        if (r12.f7030d != null) goto L11;
        return;
    L11:
        if (r12.f7030d == null) goto L13;
        boolean r1 = true;
    L60:
        long r5 = f();     // Catch: Throwable -> L52
        if (r1 == false) goto L18;
        WsChannelMsg r2 = r12.f7030d;     // Catch: Throwable -> L52
    L22:
        long r7 = f();     // Catch: Throwable -> L52
        if (r2 != WsChannelMsg.EMPTY) goto L25;
    L50:
        Logger.e("WsChannelService", "handleMessage decode msg is EMPTY!");     // Catch: Throwable -> L52
        return;
    L25:
        if (c.a(r2) == true) goto L50;
        r2.setNewMsgTimeHolder(new NewMsgTimeHolder(r12.f7029c, r5, r7));     // Catch: Throwable -> L52
        r2.setChannelId(r12.f7027a);     // Catch: Throwable -> L52
        r2.setReplayToComponentName(new ComponentName(this.f7083b, WsChannelService.class));     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L31;
        Logger.d("WsChannelService", "version =  seqId = " + r2.getSeqId() + " logId = " + r2.getLogId() + " wsChannelMsg = " + r2.toString());     // Catch: Throwable -> L52
    L31:
        if (this.f7084c.f7031a != null) goto L33;
    L48:
        Logger.e("WsChannelService", "mKeeper.mWsAppMap is empty!");     // Catch: Throwable -> L52
        return;
    L33:
        if (this.f7084c.f7031a.size() <= 0) goto L48;
        Iterator<Map.Entry<Integer, IWsApp>> r13 = this.f7084c.f7031a.entrySet().iterator();     // Catch: Throwable -> L52
    L37:
        if (r13.hasNext() == false) goto L70;
        IWsApp r3 = (IWsApp) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), IWsApp.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (r3 == null) goto L40;
        if (r3.getChannelId() != r2.getChannelId()) goto L37;
        Intent r4 = new Intent();     // Catch: Throwable -> L46
        r4.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L46
        r4.setComponent(new ComponentName(this.f7083b, WsClientService.class));     // Catch: Throwable -> L46
        r4.putExtra("payload", r2);     // Catch: Throwable -> L46
        a(r4);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Logger.e("WsChannelService", "deliver fail,reason:" + th);     // Catch: Throwable -> L52
        goto L37
    L40:
        Logger.e("WsChannelService", "wsApp is null!");     // Catch: Throwable -> L52
        goto L37
    L70:
        return;
    L18:
        byte[] r6 = r12.f7028b;     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L21;
        Logger.d("WsChannelService", "data = " + com.bytedance.common.wschannel.e.c.a(r6) + " data.length = " + r6.length);     // Catch: Throwable -> L52
    L21:
        r2 = com.bytedance.common.wschannel.a.b.a().a(r6);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, ProtocolException.class) == false) goto L56;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L56:
        th.printStackTrace();
        return;
    L13:
        r1 = false;
        goto L60
    }

    private long f() {
        if (this.f7086e == true) goto L5;
        return 0;
    L5:
        return com.bytedance.common.wschannel.e.b.a();
    }

    private void a(Intent r1) {
        this.f7085d.a(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void b() {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r0.setComponent(new ComponentName(this.f7083b, WsClientService.class));     // Catch: Throwable -> L4
        r0.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f7084c.f7033c.values()));     // Catch: Throwable -> L4
        a(r0);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(WsChannelMsg r5, boolean r6) {
        ComponentName r1 = r5.getReplayToComponentName();
        if (r1 == null) goto L17;
        byte[] r7 = r5.getPayload();     // Catch: Throwable -> L12
        if (r7 != null) goto L7;
        r7 = new byte[1];     // Catch: Throwable -> L12
    L7:
        Intent r2 = new Intent();     // Catch: Throwable -> L12
        r2.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L12
        r2.setComponent(r1);     // Catch: Throwable -> L12
        r2.putExtra(WsConstants.KEY_SEND_RESULT, r6);     // Catch: Throwable -> L12
        r2.putExtra(WsConstants.KEY_PAYLOAD_MD5, com.bytedance.common.utility.d.b(r7));     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelService", "send result = " + r6 + " payloadMd5 = " + r2.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L12
    L10:
        ZeusTransformUtils.startService(this.f7083b, r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a() {
        this.f7085d.a();
    }

    void a(b r1) {
        this.f = r1;
    }
}
