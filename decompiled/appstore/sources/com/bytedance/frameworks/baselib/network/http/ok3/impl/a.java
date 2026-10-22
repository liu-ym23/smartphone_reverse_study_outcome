package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor;

/* JADX INFO: loaded from: classes.dex */
public class a implements LifeCycleMonitor.AppStateListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7312c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifeCycleMonitor f7313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f7314b;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.a$a, reason: collision with other inner class name */
    public class C0095a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7315a;

        public C0095a(a r10) {
            this.f7315a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (isInitialStickyBroadcast() == false) goto L6;
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == true) goto L8;
            return;
        L8:
            com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().v();
        }
    }

    static {
    }

    public a() {
        this.f7313a = new LifeCycleMonitor();
        this.f7314b = new C0095a(this);
    }

    public void a(Context r10) {
        c(r10);
        b(r10);
    }

    public final void b(Context r10) {
        Logger.d(f7312c, "register activity forground and background switch Callback");
        if ((r10 instanceof Application) == false) goto L8;
        Application r11 = (Application) r10;
        if (r11 == null) goto L9;
        this.f7313a.e(this);
        r11.registerActivityLifecycleCallbacks(this.f7313a);
        return;
    L9:
        return;
    }

    public final void c(Context r10) {
        if (r10 == null) goto L5;
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r10.registerReceiver(this.f7314b, r11);
        Logger.d(f7312c, "register network state changed completed");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().w();
    }
}
