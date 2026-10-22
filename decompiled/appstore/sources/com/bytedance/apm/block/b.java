package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.FluencySwitchListener;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class b extends a implements IActivityLifeObserver, FluencySwitchListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f6368d;

    public b() {
        this.f6368d = j.v();
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r10) {
        super.a(r10);
        if (this.f6367c == false) goto L6;
        this.f6368d.D(r10);
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void b(long r10, long r11, long r12, long r13, boolean r14) {
        super.b(r10, r11, r12, r13, r14);
        if (this.f6367c == false) goto L6;
        this.f6368d.C(r14);
        return;
    }

    public void f() {
        ActivityLifeObserver.getInstance().register(this);
        w0.h.a(this);
        this.f6368d.y();
        g1.d.A().u(this);
        g1.d.A().L();
        this.f6366b = true;
        if (w0.c.B() == false) goto L6;
        s1.c.b("BlockDetector", new String[]{"BlockDetector init: "});
        return;
    }

    public void g(IBlockListener r10) {
        this.f6368d.J(r10);
    }

    public void h(long r10) {
        this.f6368d.I(r10);
    }

    public void i(boolean r10) {
        this.f6368d.N(r10);
    }

    public void j(boolean r10) {
        this.f6368d.R(r10);
    }

    public void k(boolean r10) {
        this.f6368d.S(r10);
    }

    public void l() {
        if (this.f6366b == true) goto L5;
        return;
    L5:
        if (this.f6367c == true) goto L13;
        this.f6367c = true;
        if (w0.c.B() == false) goto L12;
        s1.c.b("BlockDetector", new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

    public void m() {
        if (this.f6367c == true) goto L5;
        return;
    L5:
        this.f6367c = false;
        this.f6368d.C(false);
        if (w0.c.B() == false) goto L9;
        s1.c.b("BlockDetector", new String[]{"BlockDetector stop: "});
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        m();
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        l();
    }

    @Override // com.bytedance.apm.FluencySwitchListener
    public void onRefresh(h1.e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r11 = r10.b();
        long r12 = r10.c();
        boolean r13 = r10.h();
        boolean r14 = r10.e();
        this.f6368d.L(r13);
        this.f6368d.I(r11);
        this.f6368d.Q(r12);
        this.f6368d.K(r14);
        this.f6368d.O(r10.f());
        j r15 = this.f6368d;
        if (w0.c.H() == false) goto L7;
    L10:
        boolean r16 = true;
    L11:
        r15.P(r16);
        return;
    L7:
        if (r10.i() == true) goto L10;
        r16 = false;
        goto L11
    }
}
