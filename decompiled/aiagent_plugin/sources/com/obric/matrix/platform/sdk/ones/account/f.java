package com.obric.matrix.platform.sdk.ones.account;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OAccountManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends d implements com.obric.matrix.platform.sdk.ones.account.a.b {
    private static final String TAG = "AccountSDK_OAccountManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f33622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f33623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Map<String, String> f33624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<com.obric.matrix.platform.sdk.ones.account.a.c> f33625d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static g f33626e;
    private static final Set<com.obric.matrix.platform.sdk.ones.account.a.c> f = null;
    private static Handler g;
    private static Handler h;

    /* JADX INFO: compiled from: OAccountManager.kt */
    public static final class a extends g {
        a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.g
        public void a(Runnable r2) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
            o.e(r1, "runnable");
            f.g().post(r1);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.g, com.obric.matrix.platform.sdk.ones.account.a.c
        public void b() {
            super.b();
            a(f.TAG, "SecureAccountStatusListener onLogin");
            Set r4 = f.h();
            monitor-enter(r4);
            Iterator r0 = f.h().iterator();     // Catch: Throwable -> L11
        L6:
            if (r0.hasNext() == false) goto L8;
            ((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin")).b();     // Catch: Throwable -> L11
            goto L6
        L8:
            x r1 = x.f38692a;     // Catch: Throwable -> L11
            monitor-exit(r4);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.g, com.obric.matrix.platform.sdk.ones.account.a.c
        public void a(int r5) {
            super.a(r5);
            a(f.TAG, "SecureAccountStatusListener onLogout logoutScene = " + r5);
            Set r4 = f.h();
            monitor-enter(r4);
            Iterator r0 = f.h().iterator();     // Catch: Throwable -> L11
        L6:
            if (r0.hasNext() == false) goto L8;
            ((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin")).a(r5);     // Catch: Throwable -> L11
            goto L6
        L8:
            x r6 = x.f38692a;     // Catch: Throwable -> L11
            monitor-exit(r4);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.g, com.obric.matrix.platform.sdk.ones.account.a.c
        public void a() {
            super.a();
            a(f.TAG, "SecureAccountStatusListener onAccountInfoUpdate");
            Set r4 = f.h();
            monitor-enter(r4);
            Iterator r0 = f.h().iterator();     // Catch: Throwable -> L11
        L6:
            if (r0.hasNext() == false) goto L8;
            ((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L11
            goto L6
        L8:
            x r1 = x.f38692a;     // Catch: Throwable -> L11
            monitor-exit(r4);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    /* JADX INFO: renamed from: lambda$X6rnw_-7xNbKgsF-5oW3nsWvffA, reason: not valid java name */
    public static /* synthetic */ void m948lambda$X6rnw_7xNbKgsF5oW3nsWvffA() {
        i();
    }

    private f() {
    }

    public static final /* synthetic */ Handler g() {
        return h;
    }

    public static final /* synthetic */ Set h() {
        return f;
    }

    static {
        f33622a = new f();
        f33625d = (Set) ZeusTransformUtils.preCheckCast(new CopyOnWriteArraySet(), Set.class, "com.obric.aiagent.plugin");
        f33626e = (g) ZeusTransformUtils.preCheckCast(new a(), g.class, "com.obric.aiagent.plugin");
        f = (Set) ZeusTransformUtils.preCheckCast(new CopyOnWriteArraySet(), Set.class, "com.obric.aiagent.plugin");
        g = new Handler(Looper.getMainLooper());
        HandlerThread r0 = new HandlerThread("OAccountManager");
        r0.start();
        h = new Handler(r0.getLooper());
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.b
    public void a(boolean r2) {
        c();
        f33626e.c();
        if (r2 == false) goto L5;
        a($$Lambda$f$X6rnw_7xNbKgsF5oW3nsWvffA.INSTANCE);
        return;
    L5:
        a();
    }

    private static final void i() {
        f33622a.a();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.b
    public synchronized b d() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (f33623b != null) goto L6;
        e();     // Catch: Throwable -> L9
    L6:
        b r0 = f33623b;     // Catch: Throwable -> L9
        o.a(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void e() {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        ContentProviderClient r1 = 0;
        Boolean r2 = null;
        ContentProviderClient r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f33619a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient("com.obric.common.account.provider");     // Catch: Throwable -> L17 Exception -> L19
        if (r3 != null) goto L40;
        Bundle r0 = null;
    L11:
        if (r0 == null) goto L13;
        f33623b = c.a(new b(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null), r0);     // Catch: Exception -> L8 Throwable -> L30
    L14:
        if (r3 == null) goto L24;
    L15:
        r3.close();     // Catch: Throwable -> L35
    L24:
        StringBuilder r4 = new StringBuilder().append("updateAccountInfo loginState: ");     // Catch: Throwable -> L35
        b r5 = f33623b;     // Catch: Throwable -> L35
        if (r5 == null) goto L27;
        r2 = Boolean.valueOf(r5.a());     // Catch: Throwable -> L35
    L27:
        com.obric.matrix.platform.sdk.ones.account.b.a.b(TAG, r4.append(r2).toString());     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L13:
        f33623b = new b(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Exception -> L8 Throwable -> L30
        com.obric.matrix.platform.sdk.ones.account.b.a.d(TAG, "updateAccountInfo getAccountInfo: result is null");     // Catch: Exception -> L8 Throwable -> L30
        goto L14
    L40:
        r0 = ZeusProviderTransform.call(r3, "com.obric.common.account.provider", "getAccountInfo", null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 Throwable -> L30
    L8:
        e = e;
    L21:
        f33623b = new b(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Throwable -> L30
        com.obric.matrix.platform.sdk.ones.account.b.a.f33614a.b(TAG, "updateAccountInfo getAccountInfo err: " + e, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        if (r3 == null) goto L24;
    L30:
        th = th;
        r1 = "com.obric.aiagent.plugin";
    L32:
        if (r1 == 0) goto L34;
        r1.close();     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L19:
        e = e;
        r3 = null;
    L17:
        th = th;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public synchronized void f() {
        monitor-enter(this);
        ContentProviderClient r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f33619a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        Integer r1 = null;
        ContentProviderClient r2 = r0.getContentResolver().acquireUnstableContentProviderClient("com.obric.common.account.provider");     // Catch: Throwable -> L21 Exception -> L23
        if (r2 != null) goto L43;
        Bundle r3 = null;
    L11:
        if (r3 == null) goto L17;
        Serializable r4 = r3.getSerializable("tokenMap");     // Catch: Exception -> L8 Throwable -> L34
        if (r4 == null) goto L16;
        f33624c = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 Throwable -> L34
    L18:
        if (r2 == null) goto L28;
    L19:
        r2.close();     // Catch: Throwable -> L38
    L28:
        StringBuilder r5 = new StringBuilder().append("updateXttTokenMap: ");     // Catch: Throwable -> L38
        Map<String, String> r6 = f33624c;     // Catch: Throwable -> L38
        if (r6 == null) goto L31;
        r1 = Integer.valueOf(r6.size());     // Catch: Throwable -> L38
    L31:
        com.obric.matrix.platform.sdk.ones.account.b.a.a(TAG, r5.append(r1).toString());     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L8 Throwable -> L34
    L17:
        f33624c = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 Throwable -> L34
        com.obric.matrix.platform.sdk.ones.account.b.a.c(TAG, "getXttTokenMap: result is null");     // Catch: Exception -> L8 Throwable -> L34
        goto L18
    L43:
        r3 = ZeusProviderTransform.call(r2, "com.obric.common.account.provider", "getTokenMap", null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 Throwable -> L34
    L8:
        e = e;
    L25:
        f33624c = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        com.obric.matrix.platform.sdk.ones.account.b.a.f33614a.b(TAG, "getXttTokenMap: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        if (r2 == null) goto L28;
    L34:
        Throwable th = th;
    L35:
        if (r0 == 0) goto L37;
        r0.close();     // Catch: Throwable -> L38
    L37:
        throw th;     // Catch: Throwable -> L38
    L23:
        e = e;
        r2 = null;
    L21:
        th = move-exception;
        th = th;
        r0 = 0;
    L38:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.b
    public void a(com.obric.matrix.platform.sdk.ones.account.a.c r2) {
        com.obric.matrix.platform.sdk.ones.account.a.c r1 = (com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin");
        o.e(r1, "accountStatusListener");
        Set<com.obric.matrix.platform.sdk.ones.account.a.c> r3 = f33625d;
        monitor-enter(r3);
        r3.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.b
    public void b(com.obric.matrix.platform.sdk.ones.account.a.c r2) {
        com.obric.matrix.platform.sdk.ones.account.a.c r1 = (com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin");
        o.e(r1, "accountStatusListener");
        Set<com.obric.matrix.platform.sdk.ones.account.a.c> r3 = f33625d;
        monitor-enter(r3);
        r3.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, com.obric.matrix.platform.sdk.ones.account.a.c
    public void b() {
        super.b();
        a();
        Set<com.obric.matrix.platform.sdk.ones.account.a.c> r4 = f33625d;
        monitor-enter(r4);
        Iterator<com.obric.matrix.platform.sdk.ones.account.a.c> r0 = r4.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        ((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin")).b();     // Catch: Throwable -> L11
        goto L6
    L8:
        x r1 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, com.obric.matrix.platform.sdk.ones.account.a.c
    public void a(int r5) {
        super.a(r5);
        a();
        Set<com.obric.matrix.platform.sdk.ones.account.a.c> r4 = f33625d;
        monitor-enter(r4);
        Iterator<com.obric.matrix.platform.sdk.ones.account.a.c> r0 = r4.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        ((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin")).a(r5);     // Catch: Throwable -> L11
        goto L6
    L8:
        x r6 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, com.obric.matrix.platform.sdk.ones.account.a.c
    public void a() {
        super.a();
        e();
        f();
        Set<com.obric.matrix.platform.sdk.ones.account.a.c> r4 = f33625d;
        monitor-enter(r4);
        Iterator<com.obric.matrix.platform.sdk.ones.account.a.c> r0 = r4.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        ((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L11
        goto L6
    L8:
        x r1 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d
    public void a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        o.e(r1, "runnable");
        h.post(r1);
    }
}
