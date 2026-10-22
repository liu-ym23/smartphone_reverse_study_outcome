package com.bytedance.crash.tracker;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.crash.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BatteryTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f7772b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7773a;

    public a() {
    }

    static /* synthetic */ int a(a r0, int r1) {
        r0.f7773a = r1;
        return r1;
    }

    static a a() {
        if (f7772b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7772b != null) goto L9;
        f7772b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7772b;
    }

    private void registerReceiver() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        ZeusTransformUtils.registerReceiver(r0, new AnonymousClass1(this), new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        return;
    }

    public static int b() {
        return a().f7773a;
    }

    public static void c() {
        a().registerReceiver();
    }
}
