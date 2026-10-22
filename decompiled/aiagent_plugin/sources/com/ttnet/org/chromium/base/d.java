package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ContextUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final String TAG = "ContextUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37698a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f37699b;

    /* JADX INFO: compiled from: ContextUtils.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SharedPreferences f37700a;

        static /* synthetic */ SharedPreferences a() {
            return f37700a;
        }

        static {
            f37700a = d.c();
        }
    }

    static {
    }

    public d() {
    }

    static /* synthetic */ SharedPreferences c() {
        return d();
    }

    public static Context a() {
        return f37699b;
    }

    public static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f37698a == true) goto L12;
        Context r0 = f37699b;
        if (r0 == null) goto L12;
        if (r0 == r4) goto L12;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r0, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == r4) goto L12;
        throw new AssertionError();
    L12:
        b(r4);
    }

    private static SharedPreferences d() {
        s r0 = s.b();
        SharedPreferences r1 = PreferenceManager.getDefaultSharedPreferences(f37699b);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L16;
    L13:
        throw th;
    L16:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static SharedPreferences b() {
        return a.a();
    }

    private static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f37698a == true) goto L9;
        if (r3 != null) goto L9;
        throw new AssertionError();
    L9:
        if (BuildConfig.ENABLE_ASSERTS == true) goto L11;
    L13:
        f37699b = r3;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == false) goto L13;
        r3 = new ContextWrapper(r3);
        goto L13
    }

    public static Intent a(Context r6, PluginBroadcastReceiver r7, IntentFilter r8) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, r8, null, null, 4);
    }

    private static Intent a(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return com.ttnet.org.chromium.base.compat.c.registerReceiver(r0, r7, r8, r9, r10, r11);
    L7:
        return ZeusTransformUtils.registerReceiver(r0, r7, r8, r9, r10, "com.obric.aiagent.plugin");
    }
}
