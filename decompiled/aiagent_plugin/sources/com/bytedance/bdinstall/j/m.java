package com.bytedance.bdinstall.j;

import android.content.Context;
import android.content.IntentFilter;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: NetworkStatusProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile PluginBroadcastReceiver f6318a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile m f6319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile com.bytedance.common.utility.i.b f6320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f6321e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6322b;

    static /* synthetic */ Context a(m r0) {
        return r0.f6322b;
    }

    static /* synthetic */ com.bytedance.common.utility.i.b a(com.bytedance.common.utility.i.b r0) {
        f6320d = r0;
        return r0;
    }

    static /* synthetic */ com.bytedance.common.utility.i.b c() {
        return f6320d;
    }

    static {
        f6320d = com.bytedance.common.utility.i.b.f6737c;
        f6321e = new AtomicInteger(0);
    }

    public static m a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f6319c != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6319c != null) goto L9;
        f6319c = new m(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f6319c;
    }

    private m(Context r3) {
        this.f6322b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        d();
    }

    public static void a() {
        f6321e.incrementAndGet();
        com.bytedance.bdinstall.t.a("NetworkStatusProvider increment reference count");
    }

    private void d() {
        com.bytedance.bdinstall.t.a("NetworkStatusProvider init monitor...");
        f6320d = com.bytedance.common.utility.i.e(this.f6322b);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        f6318a = new AnonymousClass1(this);
        ZeusTransformUtils.registerReceiver(this.f6322b, f6318a, r0, "com.obric.aiagent.plugin");
    }

    public com.bytedance.common.utility.i.b b() {
        return f6320d;
    }
}
