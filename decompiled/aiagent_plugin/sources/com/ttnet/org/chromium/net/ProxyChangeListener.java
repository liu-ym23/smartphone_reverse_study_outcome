package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class ProxyChangeListener {
    private static final String TAG = "ProxyChangeListener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37843a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f37844b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Looper f37845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f37846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f37847e;
    private ProxyReceiver f;
    private PluginBroadcastReceiver g;
    private a h;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.ProxyChangeListener$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ProxyReceiver extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxyChangeListener f37848a;

        public static /* synthetic */ void lambda$sP2Vi6cifkGkOg8Yh3UN3MCDeHA(ProxyReceiver r0, Intent r1) {
            r0.a(r1);
        }

        private ProxyReceiver(ProxyChangeListener r1) {
            this.f37848a = r1;
        }

        /* synthetic */ ProxyReceiver(ProxyChangeListener r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void onReceive(Context r4, final Intent r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (r5.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.a(this.f37848a).postDelayed(new $$Lambda$ProxyChangeListener$ProxyReceiver$sP2Vi6cifkGkOg8Yh3UN3MCDeHA(this, r5), 1000);
            return;
        }

        private /* synthetic */ void a(Intent r1) {
            ProxyChangeListener.a(this.f37848a, ProxyChangeListener.b(r1));
        }
    }

    public interface a {
        void a();
    }

    interface b {
        void a(long r1, ProxyChangeListener r3);

        void a(long r1, ProxyChangeListener r3, String r4, int r5, String r6, String[] r7);
    }

    private static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f37849e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String[] f37853d;

        static /* synthetic */ c a(ProxyInfo r0) {
            return b(r0);
        }

        public c(String r1, int r2, String r3, String[] r4) {
            this.f37850a = r1;
            this.f37851b = r2;
            this.f37852c = r3;
            this.f37853d = r4;
        }

        private static c b(ProxyInfo r6) {
            String r0 = null;
            if (r6 != null) goto L5;
            return null;
        L5:
            String r1 = r6.getHost();
            Uri r2 = r6.getPacFileUrl();
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            int r4 = r6.getPort();
            if (Uri.EMPTY.equals(r2) == true) goto L13;
            r0 = r2.toString();
        L13:
            return new c(r1, r4, r0, r6.getExclusionList());
        }

        static {
            f37849e = new c("", 0, "", new String[0]);
        }
    }

    static {
    }

    public static /* synthetic */ void lambda$AcE_tvxbT23s9aUa1nhjbcDEHPc(ProxyChangeListener r0, Intent r1) {
        r0.e(r1);
    }

    static /* synthetic */ Handler a(ProxyChangeListener r0) {
        return r0.f37846d;
    }

    static /* synthetic */ void a(ProxyChangeListener r0, c r1) {
        r0.a(r1);
    }

    static /* synthetic */ c b(Intent r0) {
        return c(r0);
    }

    private ProxyChangeListener() {
        Looper r0 = Looper.myLooper();
        this.f37845c = r0;
        this.f37846d = new Handler(r0);
    }

    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    public static String getProperty(String r0) {
        return System.getProperty(r0);
    }

    public void start(long r6) {
        TraceEvent r0 = TraceEvent.a("ProxyChangeListener.start");
        b();     // Catch: Throwable -> L14
        if (f37843a == false) goto L6;
    L10:
        this.f37847e = r6;     // Catch: Throwable -> L14
        registerReceiver();     // Catch: Throwable -> L14
        if (r0 == null) goto L24;
        r0.close();
        return;
    L24:
        return;
    L6:
        if (this.f37847e == 0) goto L10;
        throw new AssertionError();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r0 != null) goto L22;
    L20:
        throw th;
    L22:
        r0.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    public void stop() {
        b();
        this.f37847e = 0;
        unregisterReceiver();
    }

    private static c c(Intent r9) {
        Bundle r10 = r9.getExtras();
        if (r10 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L24;
        return c.a((ProxyInfo) ZeusTransformUtils.preCheckCast(r10.get("android.intent.extra.PROXY_INFO"), ProxyInfo.class, "com.obric.aiagent.plugin"));
    L24:
        Object r11 = r10.get("proxy");     // Catch: Throwable -> L21
        if (r11 != null) goto L13;
        return null;
    L13:
        Class r2 = ZeusTransformUtils.forName("android.net.ProxyProperties", "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Method r4 = r2.getDeclaredMethod("getHost", new Class[0]);     // Catch: Throwable -> L21
        Method r5 = r2.getDeclaredMethod("getPort", new Class[0]);     // Catch: Throwable -> L21
        Method r6 = r2.getDeclaredMethod("getExclusionList", new Class[0]);     // Catch: Throwable -> L21
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.invoke(r11, new Object[0]), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r5.invoke(r11, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L21
        String[] r12 = ((String) ZeusTransformUtils.preCheckCast(r6.invoke(r11, new Object[0]), String.class, "com.obric.aiagent.plugin")).split(",");     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT < 19) goto L20;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r2.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(r11, new Object[0]), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r13) == true) goto L20;
        return new c(r7, r8, r13, r12);
    L20:
        return new c(r7, r8, null, r12);
    L21:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Using no proxy configuration due to exception:" + e, new Object[0]);
        return null;
    }

    private void a(c r10) {
        b();
        if (f37844b == true) goto L5;
        return;
    L5:
        a r0 = this.h;
        if (r0 == null) goto L9;
        r0.a();
    L9:
        if (this.f37847e != 0) goto L11;
        return;
    L11:
        if (r10 == null) goto L13;
        s.a().a(this.f37847e, this, r10.f37850a, r10.f37851b, r10.f37852c, r10.f37853d);
        return;
    L13:
        s.a().a(this.f37847e, this);
    }

    private c d(Intent r3) {
        ProxyInfo r2 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getDefaultProxy();
        if (r2 != null) goto L7;
        return c.f37849e;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if ("localhost".equals(r2.getHost()) == false) goto L15;
        if (r2.getPort() != (-1)) goto L15;
        return c(r3);
    L15:
        return c.a(r2);
    }

    void a(final Intent r3) {
        this.f37846d.postDelayed(new $$Lambda$ProxyChangeListener$AcE_tvxbT23s9aUa1nhjbcDEHPc(this, r3), 1000);
    }

    private /* synthetic */ void e(Intent r1) {
        a(d(r1));
    }

    private void registerReceiver() {
        b();
        boolean r0 = f37843a;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.PROXY_CHANGE");
        this.f = new ProxyReceiver(this, null);
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        com.ttnet.org.chromium.base.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f, r1);
        return;
    L18:
        com.ttnet.org.chromium.base.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f, new IntentFilter());
        this.g = new r(this);
        com.ttnet.org.chromium.base.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.g, r1);
        return;
    L11:
        if (this.g == null) goto L15;
        throw new AssertionError();
    L5:
        if (this.f == null) goto L9;
        throw new AssertionError();
    }

    private void unregisterReceiver() {
        b();
        if (f37843a == false) goto L5;
    L9:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f, "com.obric.aiagent.plugin");
        if (this.g == null) goto L12;
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.g, "com.obric.aiagent.plugin");
    L12:
        this.f = null;
        this.g = null;
        return;
    L5:
        if (this.f != null) goto L9;
        throw new AssertionError();
    }

    private boolean a() {
        if (this.f37845c != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private void b() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (a() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    }
}
