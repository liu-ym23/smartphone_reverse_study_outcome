package com.bumptech.glide.manager;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements c {
    private static final String TAG = "ConnectivityMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c.a f3896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f3897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f3898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PluginBroadcastReceiver f3900e;

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    e(Context r3, c.a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        c.a r6 = (c.a) ZeusTransformUtils.wrapperContextForParams(r4, c.a.class, "com.obric.aiagent.plugin");
        this.f3900e = new AnonymousClass1(this);
        this.f3898c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f3896a = r6;
    }

    private void a() {
        if (this.f3899d == false) goto L5;
        return;
    L5:
        this.f3897b = a(this.f3898c);
        ZeusTransformUtils.registerReceiver(this.f3898c, this.f3900e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), "com.obric.aiagent.plugin");     // Catch: SecurityException -> L8
        this.f3899d = true;     // Catch: SecurityException -> L8
        return;
    L8:
        e = move-exception;
        if (a(TAG, 5) == false) goto L15;
        a(TAG, "Failed to register", e);
        return;
    }

    private void b() {
        if (this.f3899d == true) goto L5;
        return;
    L5:
        ZeusTransformUtils.unregisterReceiver(this.f3898c, this.f3900e, "com.obric.aiagent.plugin");
        this.f3899d = false;
    }

    boolean a(Context r3) {
        NetworkInfo r2 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: RuntimeException -> L10
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.isConnected() == false) goto L8;
        return true;
    L10:
        e = move-exception;
        if (a(TAG, 5) == false) goto L14;
        a(TAG, "Failed to determine connectivity status when connectivity changed", e);
    L14:
        return true;
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        b();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
