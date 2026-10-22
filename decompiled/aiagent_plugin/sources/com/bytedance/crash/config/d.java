package com.bytedance.crash.config;

import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: InnerConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ConfigManager implements com.bytedance.services.slardar.config.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f7281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IConfigManager f7282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f7283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f7284d;

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
    }

    static /* synthetic */ void a(d r0) {
        r0.e();
    }

    public d(com.bytedance.crash.monitor.f r1) {
        super(r1);
        this.f7284d = false;
        this.f7283c = new AnonymousClass1(this);
    }

    @Override // com.bytedance.crash.config.ConfigManager
    public void b() {
        if (com.bytedance.crash.o.b.b() == true) goto L14;
        super.b();
        return;
    L14:
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        this.f7282b = r0;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.registerConfigListener(this);     // Catch: Throwable -> L11
    L9:
        DefaultWorkThread.postDelayed(this.f7283c, 2000);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        super.b();
        r.b(th);
    }

    private void e() {
        r.b("tryGetConfigFromApm isReady:" + this.f7284d);
        if (this.f7284d == false) goto L5;
        return;
    L5:
        r.b("tryGetConfigFromApm mTryCount:" + this.f7281a);
        if (this.f7281a < 30) goto L9;
        DefaultWorkThread.removeCallbacks(this.f7283c);
        super.b();
    L14:
        this.f7281a++;
        return;
    L9:
        if (this.f7282b != null) goto L13;
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");
        this.f7282b = r0;
        if (r0 == null) goto L13;
        r0.registerConfigListener(this);
    L13:
        DefaultWorkThread.removeCallbacks(this.f7283c);
        DefaultWorkThread.postDelayed(this.f7283c, 2000);
        goto L14
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(final JSONObject r1, boolean r2) {
        this.f7284d = true;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new AnonymousClass2(this, r1));
    }
}
