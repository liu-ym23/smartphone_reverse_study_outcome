package com.bytedance.common.wschannel;

import android.content.Context;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: WsChannelImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.c f6964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.b f6965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.d f6966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.common.wschannel.client.j f6967e;
    private final Context f;
    private SsWsApp g;
    private com.bytedance.common.wschannel.b.c h;
    private AtomicBoolean i;
    private ConcurrentHashMap<Integer, Boolean> j;
    private boolean k;

    j(Context r4, com.bytedance.common.wschannel.client.j r5, a r6, com.bytedance.common.wschannel.app.c r7, com.bytedance.common.wschannel.app.d r8, com.bytedance.common.wschannel.app.b r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.client.j r11 = (com.bytedance.common.wschannel.client.j) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.common.wschannel.client.j.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.c r12 = (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.d r13 = (com.bytedance.common.wschannel.app.d) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.app.d.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.b r14 = (com.bytedance.common.wschannel.app.b) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.common.wschannel.app.b.class, "com.obric.aiagent.plugin");
        this.i = new AtomicBoolean(false);
        this.j = new ConcurrentHashMap();
        this.f = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        this.f6967e = r11;
        this.f6963a = r6;
        this.f6964b = r12;
        this.f6966d = r13;
        this.f6965c = r14;
        this.g = l.a(r6);
    }

    @Override // com.bytedance.common.wschannel.i
    public int a() {
        return this.f6963a.f6756a;
    }

    @Override // com.bytedance.common.wschannel.i
    public void b() {
        this.f6967e.a(this.f, this.f6963a.f6756a);
        this.i.set(true);
    }

    @Override // com.bytedance.common.wschannel.i
    public void a(a r3) {
        if (r3 == null) goto L11;
        if (r3.f6756a != this.f6963a.f6756a) goto L11;
        if (this.i.get() == false) goto L8;
        return;
    L8:
        this.f6963a = r3;
        SsWsApp r4 = l.a(r3);
        this.g = r4;
        this.f6967e.b(this.f, r4);
        return;
    L11:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    @Override // com.bytedance.common.wschannel.i
    public boolean c() {
        if (this.h != com.bytedance.common.wschannel.b.c.f6780e) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.common.wschannel.i
    public void a(WsChannelMsg r3, f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        if (r3.getChannelId() != this.f6963a.f6756a) goto L12;
        if (this.i.get() == false) goto L9;
        if (r5 == null) goto L13;
        r5.onSendResult(r3, false);
        return;
    L13:
        return;
    L9:
        this.f6967e.a(this.f, new MainProcessMsg(r3, r5));
        return;
    L12:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    void d() {
        this.f6967e.a(this.f, this.g);
    }

    void a(WsChannelMsg r8) {
        if (this.f6964b == null) goto L9;
        if (r8.isAckMsg() == true) goto L9;
        this.f6964b.a(r8);
        return;
    L9:
        if (this.f6965c != null) goto L11;
        return;
    L11:
        if (r8.isAckMsg() == false) goto L15;
        com.bytedance.common.wschannel.b.d r0 = new com.bytedance.common.wschannel.b.d(r8.getUUID(), r8.getChannelId(), r8.getService(), r8.getMethod(), r8.getLogInfo());
        r0.a(r8.getState());
        this.f6965c.a(r0);
        return;
    }

    void a(com.bytedance.common.wschannel.b.b r2, JSONObject r3) {
        com.bytedance.common.wschannel.app.c r0 = this.f6964b;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
    L6:
        if (r2.f6774b == com.bytedance.common.wschannel.b.c.f6779d) goto L8;
        return;
    L8:
        if (this.i.get() == false) goto L12;
        l.b(a());
        return;
    }

    void a(ServiceConnectEvent r1) {
        com.bytedance.common.wschannel.app.d r0 = this.f6966d;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    void a(com.bytedance.common.wschannel.b.c r1, boolean r2) {
        this.h = r1;
        this.k = r2;
    }

    void b(ServiceConnectEvent r2) {
        this.j.put(Integer.valueOf(r2.getServiceId()), Boolean.valueOf(r2.isServiceConnected()));
    }

    void a(WsChannelMsg r3, boolean r4) {
        if (ZeusTransformUtils.instanceOf(r3, MainProcessMsg.class) == false) goto L8;
        WsChannelMsg r2 = ((MainProcessMsg) ZeusTransformUtils.preCheckCast(r3, MainProcessMsg.class, "com.obric.aiagent.plugin")).getOrigin();
        f r5 = ((MainProcessMsg) ZeusTransformUtils.preCheckCast(r3, MainProcessMsg.class, "com.obric.aiagent.plugin")).getListener();
        if (r5 == null) goto L9;
        r5.onSendResult(r2, r4);
        return;
    L9:
        return;
    }
}
