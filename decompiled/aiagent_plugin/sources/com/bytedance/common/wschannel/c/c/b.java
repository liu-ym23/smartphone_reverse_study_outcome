package com.bytedance.common.wschannel.c.c;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.c.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.ad;

/* JADX INFO: compiled from: NormalHeartBeatPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.common.wschannel.c.a<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f6808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f6809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f6810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f6811e;
    private Runnable f;

    @Override // com.bytedance.common.wschannel.c.d
    public void a(com.bytedance.common.wschannel.c.a.a r1) {
    }

    static /* synthetic */ AtomicBoolean a(b r0) {
        return r0.f6810d;
    }

    static /* synthetic */ void b(b r0) {
        r0.d();
    }

    static /* synthetic */ c c(b r0) {
        return r0.f6808b;
    }

    static /* synthetic */ void d(b r0) {
        r0.e();
    }

    public b(a r2) {
        super(r2);
        this.f6810d = new AtomicBoolean(false);
        this.f6811e = new AnonymousClass1(this);
        this.f = new AnonymousClass2(this);
    }

    @Override // com.bytedance.common.wschannel.c.a
    public void a(c r3, Handler r4) {
        this.f6808b = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        this.f6809c = r4;
    }

    @Override // com.bytedance.common.wschannel.c.d
    public void a() {
        Logger.d("WsChannelSdk_ok", "receive pong");
        this.f6810d.set(false);
        this.f6809c.removeCallbacks(this.f6811e);
        com.bytedance.common.wschannel.c.b.a.a().b();
    }

    @Override // com.bytedance.common.wschannel.c.d
    public void b() {
        Logger.d("WsChannelSdk_ok", "ping sent，waiting for pong");
        f();
    }

    @Override // com.bytedance.common.wschannel.c.d
    public void a(ad r3) {
        Logger.d("WsChannelSdk_ok", "connect success，ready to send ping");
        b(r3);
        e();
    }

    @Override // com.bytedance.common.wschannel.c.d
    public void c() {
        Logger.d("WsChannelSdk_ok", "disconnected，stop to send ping");
        d();
    }

    private void b(ad r14) {
        if (((a) ZeusTransformUtils.preCheckCast(this.f6792a, a.class, "com.obric.aiagent.plugin")).a() == (-1)) goto L6;
        return;
    L6:
        if (r14 != null) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(this.f6792a, a.class, "com.obric.aiagent.plugin")).a(270000);
        return;
    L9:
        String r15 = r14.b("Handshake-Options");
        if (r15 == null) goto L22;
        String[] r16 = r15.split(";");
        int r5 = r16.length;
        long r8 = -1;
        int r7 = 0;
    L12:
        if (r7 >= r5) goto L24;
        String r10 = r16[r7];
        if (TextUtils.isEmpty(r10) == true) goto L21;
        String[] r11 = r10.split("=");
        if ("ping-interval".equals(r11[0]) == false) goto L21;
        r8 = Long.parseLong(r11[1]) * 1000;
    L20:
        r8 = 270000;
    L21:
        r7 = r7 + 1;
    L24:
        if (r8 != (-1)) goto L26;
        ((a) ZeusTransformUtils.preCheckCast(this.f6792a, a.class, "com.obric.aiagent.plugin")).a(270000);
        return;
    L26:
        ((a) ZeusTransformUtils.preCheckCast(this.f6792a, a.class, "com.obric.aiagent.plugin")).a(r8);
        return;
    L22:
        r8 = -1;
        goto L24
    }

    private void d() {
        this.f6809c.removeCallbacks(this.f6811e);
        this.f6809c.removeCallbacks(this.f);
        this.f6810d.set(false);
    }

    private void e() {
        long r0 = ((a) ZeusTransformUtils.preCheckCast(this.f6792a, a.class, "com.obric.aiagent.plugin")).a();
        Logger.d("WsChannelSdk_ok", "interval :" + r0 + " ms,the next time to send heartbeat is " + com.bytedance.common.wschannel.e.c.a(System.currentTimeMillis() + r0));
        this.f6809c.removeCallbacks(this.f);
        this.f6809c.postDelayed(this.f, r0);
    }

    private void f() {
        this.f6810d.set(true);
        this.f6809c.removeCallbacks(this.f6811e);
        this.f6809c.postDelayed(this.f6811e, ((a) ZeusTransformUtils.preCheckCast(this.f6792a, a.class, "com.obric.aiagent.plugin")).b());
    }
}
