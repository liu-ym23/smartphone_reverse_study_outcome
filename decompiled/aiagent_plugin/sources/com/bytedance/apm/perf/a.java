package com.bytedance.apm.perf;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractPerfCollector.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.bytedance.apm.thread.b.InterfaceC0118b, com.bytedance.services.apm.api.d, com.bytedance.services.slardar.config.a {
    private static final String TAG = "AbstractPerfCollector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4742e;
    protected String g;

    public void a(JSONObject r1) {
    }

    public void b() {
    }

    public abstract boolean c();

    public void c_() {
    }

    public abstract long d();

    public void e() {
    }

    public void m() {
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityPause(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    public void onActivityResume(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onChange(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    public a() {
    }

    public final void j() {
        if (this.f4740c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.g) == true) goto L12;
        this.f4740c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f4739b = !ActivityLifeObserver.getInstance().isForeground();
        b();
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).registerConfigListener(this);
        if (com.bytedance.apm.c.i() == false) goto L13;
        com.bytedance.apm.h.e.d(TAG, new String[]{"perf init: " + this.g});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    private final void a() {
        if (this.f4741d == true) goto L7;
        this.f4741d = true;
        if (c() == false) goto L7;
        com.bytedance.apm.thread.b.a().a(this);
    L7:
        e();
        this.f4742e = System.currentTimeMillis();
    }

    public final void k() {
        if (this.f4741d == false) goto L7;
        this.f4741d = false;
        if (c() == false) goto L7;
        com.bytedance.apm.thread.b.a().b(this);
    L7:
        c_();
    }

    public final void l() {
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).unregisterConfigListener(this);
        m();
    }

    @Override // com.bytedance.apm.thread.b.InterfaceC0118b
    public final void onTimeEvent(long r5) {
        long r0 = d();
        if (r0 > 0) goto L5;
        return;
    L5:
        if ((r5 - this.f4742e) > r0) goto L7;
        return;
    L7:
        if (this.f4738a == false) goto L12;
        e();
        this.f4742e = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
        JSONObject r3 = r1.optJSONObject("performance_modules");
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = r3.optJSONObject(this.g);
        if (r4 != null) goto L8;
        return;
    L8:
        a(r4);
    }

    public void onReady() {
        this.f4738a = true;
        a();
    }

    public boolean n() {
        return this.f4739b;
    }

    public void onFront(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.f4739b = false;
        if (com.bytedance.apm.c.f() == true) goto L5;
        return;
    L5:
        if (this.f4738a == false) goto L9;
        a();
        return;
    }

    public void onBackground(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.f4739b = true;
        if (com.bytedance.apm.c.f() == false) goto L6;
        k();
        return;
    }

    public void a(com.bytedance.apm.d.b.e r1) {
        b.a(r1);
        b.a(r1, r1.e());
        com.bytedance.apm.d.a.a.c().a(r1);
    }
}
