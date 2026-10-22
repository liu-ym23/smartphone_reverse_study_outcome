package com.bytedance.common.wschannel.c;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CompensateHeartBeatManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.common.wschannel.c.a.a f6798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f6799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.impl.ok.b.b f6800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f6801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f6802e;
    private Runnable f;

    /* JADX INFO: compiled from: CompensateHeartBeatManager.java */
    public interface a {
        void a();
    }

    static /* synthetic */ AtomicBoolean a(b r0) {
        return r0.f6799b;
    }

    static /* synthetic */ a b(b r0) {
        return r0.f6801d;
    }

    public b(a r3, Handler r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        this.f6799b = new AtomicBoolean(false);
        this.f = new AnonymousClass1(this);
        this.f6801d = r5;
        this.f6802e = r4;
    }

    public void a(com.bytedance.common.wschannel.channel.impl.ok.b.b r3) {
        this.f6800c = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
    }

    public void a(com.bytedance.common.wschannel.c.a.a r3) {
        if (this.f6799b.get() == true) goto L14;
        boolean r0 = false;
        if (b(r3) == false) goto L7;
        Logger.d("WsChannelSdk_ok", "Switch the foreground in the background, send compensation ping");
        r0 = true;
    L7:
        if (r0 == false) goto L14;
        com.bytedance.common.wschannel.channel.impl.ok.b.b r1 = this.f6800c;     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        r1.e();     // Catch: Exception -> L12
        c();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        this.f6798a = r3;
    }

    public boolean a() {
        return this.f6799b.get();
    }

    public void b() {
        Logger.d("WsChannelSdk_ok", "After compensating for ping, received pong");
        this.f6799b.set(false);
        this.f6802e.removeCallbacks(this.f);
    }

    private boolean b(com.bytedance.common.wschannel.c.a.a r2) {
        if (this.f6798a == com.bytedance.common.wschannel.c.a.a.f6794b) goto L5;
    L7:
        return false;
    L5:
        if (r2 != com.bytedance.common.wschannel.c.a.a.f6793a) goto L7;
        return true;
    }

    private void c() {
        this.f6799b.set(true);
        this.f6802e.removeCallbacks(this.f);
        this.f6802e.postDelayed(this.f, 5000);
    }
}
