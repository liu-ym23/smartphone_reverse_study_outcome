package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BlockDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a implements com.bytedance.apm.h, com.bytedance.services.apm.api.d {
    private static final String TAG = "BlockDetector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f4353c;

    @Override // com.bytedance.services.apm.api.d
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityPause(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
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

    public b() {
        this.f4353c = l.a();
    }

    public void b() {
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.apm.i.a(this);
        this.f4353c.b();
        com.bytedance.apm.block.trace.f.a().a(this);
        com.bytedance.apm.block.trace.f.a().d();
        this.f4351a = true;
        if (com.bytedance.apm.c.i() == false) goto L6;
        com.bytedance.apm.h.e.d(TAG, new String[]{"BlockDetector init: "});
        return;
    }

    public void a(boolean r1) {
        this.f4353c.a(r1);
    }

    @Override // com.bytedance.apm.h
    public void a(com.bytedance.apm.config.e r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        long r0 = r8.f();
        long r2 = r8.e();
        boolean r4 = r8.b();
        boolean r5 = r8.a();
        this.f4353c.b(r4);
        this.f4353c.b(r0);
        this.f4353c.c(r2);
        this.f4353c.f(r5);
        this.f4353c.d(r8.h());
        l r7 = this.f4353c;
        if (com.bytedance.apm.c.a() == false) goto L7;
    L10:
        boolean r9 = true;
    L11:
        r7.e(r9);
        return;
    L7:
        if (r8.d() == true) goto L10;
        r9 = false;
        goto L11
    }

    public void c() {
        if (this.f4351a == true) goto L5;
        return;
    L5:
        if (this.f4352b == true) goto L13;
        this.f4352b = true;
        if (com.bytedance.apm.c.i() == false) goto L12;
        com.bytedance.apm.h.e.d(TAG, new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

    public void d() {
        if (this.f4352b == true) goto L5;
        return;
    L5:
        this.f4352b = false;
        this.f4353c.c(false);
        if (com.bytedance.apm.c.i() == false) goto L9;
        com.bytedance.apm.h.e.d(TAG, new String[]{"BlockDetector stop: "});
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void a(long r1, long r3, long r5, long r7, boolean r9) {
        super.a(r1, r3, r5, r7, r9);
        if (this.f4352b == false) goto L6;
        this.f4353c.c(r9);
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r2) {
        super.a(r2);
        if (this.f4352b == false) goto L6;
        this.f4353c.a(r2);
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void onBackground(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        d();
    }

    @Override // com.bytedance.services.apm.api.d
    public void onFront(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        c();
    }

    public void a(long r1) {
        this.f4353c.b(r1);
    }

    public void b(boolean r1) {
        this.f4353c.g(r1);
    }

    public void c(boolean r1) {
        this.f4353c.h(r1);
    }

    public void a(com.bytedance.apm.g.c r3) {
        com.bytedance.apm.g.c r4 = (com.bytedance.apm.g.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.g.c.class, "com.obric.aiagent.plugin");
        this.f4353c.a(r4);
    }
}
