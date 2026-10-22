package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net")
@UsedByReflection("WebView embedders call this to override proxy settings")
public class ProxyChangeListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f18432g = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f18433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f18434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProxyReceiver f18436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BroadcastReceiver f18437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Delegate f18438f;

    public interface Delegate {
        void proxySettingsChanged();
    }

    public interface Natives {
        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChanged(long r10, ProxyChangeListener r11);

        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChangedTo(long r10, ProxyChangeListener r11, String r12, int r13, String r14, String[] r15);
    }

    @UsedByReflection("WebView embedders call this to override proxy settings")
    public class ProxyReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProxyChangeListener f18439a;

        public ProxyReceiver(ProxyChangeListener r10) {
            this.f18439a = r10;
        }

        public static /* synthetic */ void a(ProxyReceiver r10, Intent r11) {
            r10.b(r11);
        }

        public final /* synthetic */ void b(Intent r10) {
            ProxyChangeListener.d(this.f18439a, ProxyChangeListener.c(r10));
        }

        @Override // android.content.BroadcastReceiver
        @UsedByReflection("WebView embedders call this to override proxy settings")
        public void onReceive(Context r10, final Intent r11) {
            if (r11.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.b(this.f18439a, new p(this, r11));
            return;
        }

        public /* synthetic */ ProxyReceiver(ProxyChangeListener r10, a r11) {
            this(r10);
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f18440e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f18443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String[] f18444d;

        static {
            f18440e = new b("", 0, "", new String[0]);
        }

        public b(String r10, int r11, String r12, String[] r13) {
            this.f18441a = r10;
            this.f18442b = r11;
            this.f18443c = r12;
            this.f18444d = r13;
        }

        public static /* synthetic */ b a(ProxyInfo r10) {
            return b(r10);
        }

        public static b b(ProxyInfo r10) {
            String r11 = null;
            if (r10 != null) goto L5;
            return null;
        L5:
            Uri r12 = r10.getPacFileUrl();
            String r13 = r10.getHost();
            int r14 = r10.getPort();
            if (Uri.EMPTY.equals(r12) == true) goto L10;
            r11 = r12.toString();
        L10:
            return new b(r13, r14, r11, r10.getExclusionList());
        }
    }

    static {
    }

    private ProxyChangeListener() {
        Looper r10 = Looper.myLooper();
        this.f18433a = r10;
        this.f18434b = new Handler(r10);
    }

    public static /* synthetic */ void a(ProxyChangeListener r10, Intent r11) {
        r10.h(r11);
    }

    public static /* synthetic */ void b(ProxyChangeListener r10, Runnable r11) {
        r10.l(r11);
    }

    public static /* synthetic */ b c(Intent r10) {
        return f(r10);
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    public static /* synthetic */ void d(ProxyChangeListener r10, b r11) {
        r10.j(r11);
    }

    public static b f(Intent r10) {
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L7;
        return null;
    L7:
        return b.a((ProxyInfo) r11.get("android.intent.extra.PROXY_INFO"));
    }

    @CalledByNative
    public static String getProperty(String r10) {
        return System.getProperty(r10);
    }

    public final void e() {
        if (com.ttnet.org.chromium.base.c.f18315a == true) goto L5;
        return;
    L5:
        if (i() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    }

    public final b g(Intent r10) {
        ProxyInfo r11 = ((ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity")).getDefaultProxy();
        if (r11 != null) goto L7;
        return b.f18440e;
    L7:
        return b.a(r11);
    }

    public final /* synthetic */ void h(Intent r10) {
        j(g(r10));
    }

    public final boolean i() {
        if (this.f18433a != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j(b r10) {
        e();
        if (f18432g == true) goto L5;
        return;
    L5:
        Delegate r11 = this.f18438f;
        if (r11 == null) goto L9;
        r11.proxySettingsChanged();
    L9:
        if (this.f18435c != 0) goto L11;
        return;
    L11:
        if (r10 == null) goto L13;
        q.b().proxySettingsChangedTo(this.f18435c, this, r10.f18441a, r10.f18442b, r10.f18443c, r10.f18444d);
        return;
    L13:
        q.b().proxySettingsChanged(this.f18435c, this);
    }

    public final void k() {
        e();
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.PROXY_CHANGE");
        this.f18436d = new ProxyReceiver(this, null);
        com.ttnet.org.chromium.base.e.d().registerReceiver(this.f18436d, new IntentFilter());
        this.f18437e = new n(this);
        com.ttnet.org.chromium.base.e.d().registerReceiver(this.f18437e, r10);
    }

    public final void l(Runnable r10) {
        if (i() == false) goto L5;
        r10.run();
        return;
    L5:
        this.f18434b.post(r10);
    }

    public final void m() {
        e();
        com.ttnet.org.chromium.base.e.d().unregisterReceiver(this.f18436d);
        if (this.f18437e == null) goto L5;
        com.ttnet.org.chromium.base.e.d().unregisterReceiver(this.f18437e);
    L5:
        this.f18436d = null;
        this.f18437e = null;
    }

    public void n(final Intent r10) {
        l(new o(this, r10));
    }

    @CalledByNative
    public void start(long r10) {
        e();
        this.f18435c = r10;
        k();
    }

    @CalledByNative
    public void stop() {
        e();
        this.f18435c = 0;
        m();
    }
}
