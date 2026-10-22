package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.j;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.m;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.server.i;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.squareup.wire.Wire;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.h;
import java.io.Closeable;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: WsOkClient.java */
/* JADX INFO: loaded from: classes.dex */
class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f6861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.impl.ok.d f6862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private z f6863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6864e;
    private ab f;
    private boolean g;
    private Map<String, Object> h;
    private Handler i;
    private com.bytedance.common.wschannel.channel.impl.ok.b.c j;
    private d k;
    private com.bytedance.common.wschannel.channel.impl.ok.b.a l;
    private boolean m;
    private com.bytedance.common.wschannel.c.a n;
    private com.bytedance.common.wschannel.c.b o;

    /* JADX INFO: compiled from: WsOkClient.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f6876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f6877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z f6878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bytedance.common.wschannel.channel.impl.ok.a.b f6879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bytedance.common.wschannel.c.a f6880e;

        a(Context r3) {
            this.f6876a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        a a(com.bytedance.common.wschannel.channel.impl.ok.a.b r3) {
            this.f6879d = (com.bytedance.common.wschannel.channel.impl.ok.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.impl.ok.a.b.class, "com.obric.aiagent.plugin");
            return this;
        }

        a a(com.bytedance.common.wschannel.c.a r1) {
            if (r1 == null) goto L4;
            this.f6880e = r1;
        L4:
            return this;
        }

        public c a() {
            return new c(new b(this.f6876a, this.f6877b, this.f6878c, this.f6879d, this.f6880e), null);
        }
    }

    /* JADX INFO: compiled from: WsOkClient.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f6881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f6882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z f6883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bytedance.common.wschannel.channel.impl.ok.a.b f6884d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bytedance.common.wschannel.c.a f6885e;

        static /* synthetic */ Context a(b r0) {
            return r0.f6881a;
        }

        static /* synthetic */ List a(b r2, List r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            r2.f6882b = r4;
            return r4;
        }

        static /* synthetic */ z b(b r0) {
            return r0.f6883c;
        }

        static /* synthetic */ com.bytedance.common.wschannel.c.a c(b r0) {
            return r0.f6885e;
        }

        static /* synthetic */ List d(b r0) {
            return r0.f6882b;
        }

        static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.a.b e(b r0) {
            return r0.f6884d;
        }

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.f6885e + ", mContext=" + this.f6881a + ", wsUrls=" + this.f6882b + ", mOkHttpClient=" + this.f6883c + ", mRetryPolicy=" + this.f6884d + '}';
        }

        b(Context r3, List<String> r4, z r5, com.bytedance.common.wschannel.channel.impl.ok.a.b r6, com.bytedance.common.wschannel.c.a r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            com.bytedance.common.wschannel.channel.impl.ok.a.b r10 = (com.bytedance.common.wschannel.channel.impl.ok.a.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.common.wschannel.channel.impl.ok.a.b.class, "com.obric.aiagent.plugin");
            this.f6881a = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.f6882b = r9;
            this.f6883c = r5;
            this.f6884d = r10;
            this.f6885e = r7;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.impl.ok.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WsOkClient.java */
    private class C0156c extends com.bytedance.common.wschannel.channel.impl.ok.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f6886a;

        private boolean a(int r1) {
            if (r1 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r1 == 414) goto L13;
            if (r1 == 511) goto L13;
            if (r1 == 512) goto L13;
            if (r1 == 513) goto L13;
            return false;
        }

        private C0156c(c r1) {
            this.f6886a = r1;
        }

        /* synthetic */ C0156c(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ boolean a(C0156c r0, int r1) {
            return r0.a(r1);
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void a(com.bytedance.common.wschannel.channel.impl.ok.b.b r3, final ad r4) {
            final com.bytedance.common.wschannel.channel.impl.ok.b.b r5 = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
            Runnable r0 = new AnonymousClass1(this, r5, r4);
            c.a(this.f6886a, r0);
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void a(com.bytedance.common.wschannel.channel.impl.ok.b.b r3, final h r4) {
            com.bytedance.common.wschannel.channel.impl.ok.b.b r5 = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
            c.a(this.f6886a, new AnonymousClass2(this, r4));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void a(com.bytedance.common.wschannel.channel.impl.ok.b.b r3, final String r4) {
            com.bytedance.common.wschannel.channel.impl.ok.b.b r5 = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
            c.a(this.f6886a, new AnonymousClass3(this, r4));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void a(com.bytedance.common.wschannel.channel.impl.ok.b.b r3, int r4, String r5) {
            super.a((com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin"), r4, r5);
            c.a(this.f6886a, new AnonymousClass4(this));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void b(com.bytedance.common.wschannel.channel.impl.ok.b.b r8, final int r9, final String r10) {
            final com.bytedance.common.wschannel.channel.impl.ok.b.b r2 = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
            final String r3 = c.a(this.f6886a, r2);
            c.a(this.f6886a, new AnonymousClass5(this, r2, r3, r9, r10));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void a(com.bytedance.common.wschannel.channel.impl.ok.b.b r8, Throwable r9, ad r10) {
            final com.bytedance.common.wschannel.channel.impl.ok.b.b r5 = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
            final String r2 = c.a(this.f6886a, r5);
            final int r3 = c.a(this.f6886a, r10);
            String r11 = c.b(this.f6886a, r3);
            if (j.a(r11) == true) goto L5;
        L8:
            final String r4 = r11;
            final Pair<String, Long> r6 = c.j(this.f6886a).a(r10);
            c.a(this.f6886a, r10);
            c.a(this.f6886a, new AnonymousClass6(this, r2, r3, r4, r5, r6));
            return;
        L5:
            if (j.a(r9.getMessage()) == false) goto L7;
            r11 = Log.getStackTraceString(r9);
            goto L8
        L7:
            r11 = r9.getMessage();
            goto L8
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.b.c
        public void b(com.bytedance.common.wschannel.channel.impl.ok.b.b r2, h r3) {
            final com.bytedance.common.wschannel.channel.impl.ok.b.b r4 = (com.bytedance.common.wschannel.channel.impl.ok.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.common.wschannel.channel.impl.ok.b.b.class, "com.obric.aiagent.plugin");
            c.a(this.f6886a, new AnonymousClass7(this, r4));
        }
    }

    /* JADX INFO: compiled from: WsOkClient.java */
    interface d {
        void a(h r1);

        void a(String r1);

        void a(String r1, int r2, String r3);

        void a(ad r1);

        void b(String r1);

        void b(String r1, int r2, String r3);
    }

    private String c(int r1) {
        if (r1 != 0) goto L5;
        return "success";
    L5:
        if (r1 != 404) goto L8;
        return "uri not found";
    L8:
        if (r1 != 409) goto L11;
        return "fpid not registered";
    L11:
        if (r1 != 410) goto L14;
        return "invalid device id";
    L14:
        if (r1 != 411) goto L17;
        return "appid not registered";
    L17:
        if (r1 != 412) goto L20;
        return "websocket protocol not support";
    L20:
        if (r1 != 413) goto L23;
        return "the device already connected";
    L23:
        if (r1 != 414) goto L26;
        return "server can't accept more connection,try again later";
    L26:
        if (r1 != 415) goto L29;
        return "device was blocked";
    L29:
        if (r1 != 416) goto L32;
        return "parameter error";
    L32:
        if (r1 != 417) goto L35;
        return "authentication failed";
    L35:
        if (r1 != 510) goto L38;
        return "server internal error";
    L38:
        if (r1 != 511) goto L41;
        return "server is busy，try again later";
    L41:
        if (r1 != 512) goto L44;
        return "server is shutting down";
    L44:
        if (r1 != 513) goto L47;
        return "auth server is error";
    L47:
        if (r1 != 514) goto L49;
        return "auth return error";
    L49:
        return "";
    }

    /* synthetic */ c(b r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ int a(c r0, ad r1) {
        return r0.a(r1);
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.b.a a(c r0, com.bytedance.common.wschannel.channel.impl.ok.b.a r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ String a(c r2, ah r3) {
        return r2.a((ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(c r0) {
        r0.k();
    }

    static /* synthetic */ void a(c r0, int r1) {
        r0.b(r1);
    }

    static /* synthetic */ void a(c r0, long r1, String r3, boolean r4) {
        r0.a(r1, r3, r4);
    }

    static /* synthetic */ void a(c r2, Closeable r3) {
        r2.a((Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(c r2, Runnable r3) {
        r2.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(c r0, byte[] r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ String b(c r0, int r1) {
        return r0.c(r1);
    }

    static /* synthetic */ void b(c r0) {
        r0.l();
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ void c(c r0) {
        r0.e();
    }

    static /* synthetic */ Handler d(c r0) {
        return r0.i;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.b.a e(c r0) {
        return r0.l;
    }

    static /* synthetic */ com.bytedance.common.wschannel.c.a f(c r0) {
        return r0.n;
    }

    static /* synthetic */ void g(c r0) {
        r0.f();
    }

    static /* synthetic */ d h(c r0) {
        return r0.k;
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.m;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.d j(c r0) {
        return r0.f6862c;
    }

    static /* synthetic */ boolean k(c r0) {
        return r0.g;
    }

    static /* synthetic */ void l(c r0) {
        r0.h();
    }

    static /* synthetic */ com.bytedance.common.wschannel.c.b m(c r0) {
        return r0.o;
    }

    private c(b r4) {
        this.f6864e = 3;
        this.h = new ConcurrentHashMap();
        this.i = new WeakHandler(Looper.myLooper(), this);
        this.j = new C0156c(this, null);
        this.f6861b = r4;
        this.f6860a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r4), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f6863d = b.b(r4);
        com.bytedance.common.wschannel.c.a r5 = b.c(r4);
        this.n = r5;
        if (r5 != null) goto L5;
        this.n = new com.bytedance.common.wschannel.c.c.b(new com.bytedance.common.wschannel.c.c.a().c());
    L5:
        this.n.a(new AnonymousClass1(this), this.i);
        this.o = new com.bytedance.common.wschannel.c.b(new AnonymousClass2(this), this.i);
    }

    private void a(String r6) {
        if (a(this.f6860a) == true) goto L6;
        a(r6, 1, "network error", true);
        return;
    L6:
        int r0 = b();
        if (r0 == 4) goto L24;
        if (r0 == 1) goto L25;
        b(r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.k == null) goto L16;
        this.k.a(r6, 4, Log.getStackTraceString(th));
    L16:
        if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage()) == false) goto L26;
        String r2 = this.f6862c.a();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        Logger.d("WsChannelSdk_ok", th.getMessage() + ":" + r6 + ", try next url:" + r2);
        a(0, r2, true);
        return;
    L20:
        Logger.d("WsChannelSdk_ok", "All urls are dropped, stop retry.");
        this.f6862c.b();
        return;
    L26:
        return;
    L25:
        return;
    }

    private void a(long r6, String r8, boolean r9) {
        this.i.removeMessages(1);
        if (a(this.f6860a) == true) goto L7;
        a(r8, 1, "network error", r9);
        Logger.d("WsChannelSdk_ok", "network not available，cancel retry");
        return;
    L7:
        if (this.g == false) goto L11;
        Logger.d("WsChannelSdk_ok", "close manually");
        return;
    L11:
        if (r6 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r6 + " , url :" + r8);
        Logger.d("WsChannelSdk_ok", "retry finished，waiting the next time to reconnect");
        Bundle r0 = new Bundle();
        r0.putString("method", "tryReconnect");
        r0.putLong("interval", r6);
        a(r8, 2, "retry failed", r9);
        r8 = this.f6862c.c();
    L17:
        Logger.d("WsChannelSdk_ok", "the next time to reconnect is " + com.bytedance.common.wschannel.e.c.a(System.currentTimeMillis() + r6));
        Message r10 = new Message();
        r10.what = 1;
        r10.obj = r8;
        this.i.sendMessageDelayed(r10, r6);
        return;
    L13:
        if (j.a(r8) == true) goto L16;
        b(5);
        goto L17
    }

    void a() {
        a(new AnonymousClass3(this));
    }

    private void e() {
        this.i.removeMessages(2);
        this.i.removeMessages(1);
        this.i.removeMessages(3);
        this.i.removeMessages(5);
        f();
        g();
    }

    private void f() {
        h();
        this.i.removeMessages(1);
    }

    private boolean g() {
        int r0 = b();
        if (r0 != 3) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 == 5) goto L23;
        this.n.c();
        com.bytedance.common.wschannel.channel.impl.ok.b.a r3 = this.l;
        if (r3 == null) goto L22;
        Message r4 = this.i.obtainMessage(6, r3);
        this.i.sendMessageDelayed(r4, 1000);
        if (r0 != 4) goto L15;
        this.l.b(1000, "normal close");
        b(6);
        return false;
    L15:
        this.l.b();
        b(3);
        if (r0 == 1) goto L19;
        return true;
    L19:
        return false;
    L22:
        return true;
    L23:
        return true;
    }

    private void b(String r7) {
        if (this.f6863d != null) goto L5;
        z.a r0 = new z.a();
        r0.b(Collections.singletonList(aa.f39695c));
        this.f6863d = a(r0).E();
    L5:
        Map<String, Object> r1 = this.h;
        String r8 = a(r7, r1);
        if (r1 == null) goto L8;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r1.get(WsConstants.KEY_HEADERS), Map.class, "com.obric.aiagent.plugin");
    L10:
        if (j.a(r8) == false) goto L13;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L13:
        j();
        Logger.d("WsChannelSdk_ok", "try tu open socket:" + r8);
        ab r3 = this.f;
        if (r3 != null) goto L16;
    L17:
        ab.a r4 = new ab.a().b("Sec-Websocket-Protocol", "pbbp").b("x-support-ack", "1").a(r8);
        if (r2 == null) goto L23;
        Iterator r5 = r2.entrySet().iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r4.b((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.aiagent.plugin"));
    L23:
        this.f = r4.b();
    L24:
        b(1);
        com.bytedance.common.wschannel.channel.impl.ok.b.a r9 = com.bytedance.common.wschannel.channel.impl.ok.b.a.a(this.f, m.a(this.f6860a).f(), this.j);
        this.l = r9;
        r9.a(this.f6863d);
        this.o.a(this.l);
        d r10 = this.k;
        if (r10 == null) goto L29;
        r10.a(r8);
        return;
    L29:
        return;
    L16:
        if (r8.equals(r3.a().toString()) == true) goto L24;
    L8:
        r2 = null;
        goto L10
    }

    private void h() {
        com.bytedance.common.wschannel.channel.impl.ok.d r0 = this.f6862c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    private String c(String r2) {
        if (l.a().b() == true) goto L19;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.m r1 = new com.bytedance.frameworks.baselib.network.http.ok3.impl.b.m(r2, "GET");
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.e r3 = l.a().a(r1);
        if (r3 != null) goto L7;
    L24:
        return r2;
    L7:
        if (r2.equals(r3.f8444a) == true) goto L24;
        if (r3.f8444a.isEmpty() == false) goto L16;
        if (r3.f8445b.isEmpty() == true) goto L16;
        throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
    L16:
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r3.f8444a) == false) goto L24;
        return r3.f8444a;
    L19:
        Logger.d("WsChannelSdk_ok", "fallback to host replace map");
        String r4 = l.a().b(r2);
        if (r2.equals(r4) == true) goto L24;
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r4) == false) goto L24;
        return r4;
    }

    private String a(String r10, Map<String, Object> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r10) == true) goto L44;
        if (r12 == null) goto L44;
        String r0 = com.bytedance.common.wschannel.e.c.a(String.valueOf(r12.get(WsConstants.KEY_FPID)) + String.valueOf(r12.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r12.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder r13 = Uri.parse(r10).buildUpon();
        Iterator r4 = r12.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L29;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r5.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r5.getKey(), CharSequence.class, "com.obric.aiagent.plugin"), WsConstants.KEY_HEADERS) == true) goto L8;
        if (r5.getValue() != null) goto L20;
        String r7 = "";
    L21:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");
        if (j.a(WsConstants.KEY_APP_KEY, r6) == true) goto L8;
        if (j.a(r6, "extra") == true) goto L8;
        if (j.a(WsConstants.KEY_APP_VERSION, r6) == true) goto L27;
        r13.appendQueryParameter(r6, r7);
        goto L8
    L27:
        r13.appendQueryParameter("version_code", r7);
        goto L8
    L20:
        r7 = r5.getValue().toString();
        goto L21
    L29:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.get("extra"), String.class, "com.obric.aiagent.plugin");
        if (j.a(r14) == true) goto L39;
        String[] r15 = r14.split("&");
        int r1 = r15.length;
        int r3 = 0;
    L32:
        if (r3 >= r1) goto L39;
        String r8 = r15[r3];
        if (TextUtils.isEmpty(r8) == true) goto L38;
        String[] r9 = r8.split("=");
        if (r9.length != 2) goto L38;
        r13.appendQueryParameter(r9[0], Uri.decode(r9[1]));
    L38:
        r3 = r3 + 1;
    L39:
        r13.appendQueryParameter("access_key", r0);
        r13.appendQueryParameter("ne", String.valueOf(i()));
        String r16 = r13.build().toString();
        Logger.d("WsChannelSdk_ok", "origin url: " + r16);
        String r17 = c(r16);     // Catch: Exception -> L42
        Logger.d("WsChannelSdk_ok", "Dispatch final url: " + r17);     // Catch: Exception -> L42
        return r17;
    L42:
        e = move-exception;
        throw e;
    L44:
        return "";
    }

    private int i() {
        i.a r2 = i.b(this.f6860a);
        if (r2 != null) goto L6;
        return 0;
    L6:
        if (r2 != i.a.f7071a) goto L9;
        return 0;
    L9:
        if (r2 != i.a.f7075e) goto L13;
        return 1;
    L13:
        if (r2 != i.a.f7073c) goto L17;
        return 2;
    L17:
        if (r2 != i.a.f7074d) goto L20;
        return 3;
    L20:
        return 4;
    }

    synchronized int b() {
        monitor-enter(this);
        int r0 = this.f6864e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    boolean c() {
        if (b() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private synchronized void b(int r4) {
        monitor-enter(this);
        this.f6864e = r4;     // Catch: Throwable -> L24
        String r0 = "";
        if (r4 != 1) goto L7;
        r0 = "connecting";
    L21:
        Logger.d("WsChannelSdk_ok", "current status is :" + r0);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L7:
        if (r4 != 2) goto L10;
        r0 = "connect failed";
        goto L21
    L10:
        if (r4 != 3) goto L13;
        r0 = "connection close ";
        goto L21
    L13:
        if (r4 != 4) goto L16;
        r0 = "connected";
        goto L21
    L16:
        if (r4 != 5) goto L19;
        r0 = "retry...";
        goto L21
    L19:
        if (r4 != 6) goto L21;
        r0 = "half-close status";
    L24:
        th = move-exception;
        throw th;
    }

    void a(Map<String, Object> r3) {
        Map<? extends String, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        r4.remove(WsConstants.KEY_CHANNEL_ID);
        this.h.putAll(r4);
    }

    private boolean a(Context r2) {
        return i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.what;
        if (r0 != 1) goto L11;
        if (c() == false) goto L9;
        return;
    L9:
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        a((String) ZeusTransformUtils.preCheckCast(r7.obj, String.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (r0 != 2) goto L17;
        this.i.removeMessages(2);     // Catch: Throwable -> L14
        this.i.removeMessages(1);     // Catch: Throwable -> L14
        b.a(this.f6861b, (List) ZeusTransformUtils.preCheckCast(r7.obj, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        this.g = false;     // Catch: Throwable -> L14
        this.f6862c = new com.bytedance.common.wschannel.channel.impl.ok.d(b.d(this.f6861b), b.e(this.f6861b));     // Catch: Throwable -> L14
        f();     // Catch: Throwable -> L14
        a(this.f6862c.c());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if (r0 != 3) goto L32;
        this.i.removeMessages(2);
        this.i.removeMessages(1);
        if (c() == false) goto L21;
        return;
    L21:
        f();
        if (a(this.f6860a) == true) goto L24;
        Logger.d("WsChannelSdk_ok", "network changed! but the network is not available，do not retry");
        return;
    L24:
        if (g() == false) goto L29;
        com.bytedance.common.wschannel.channel.impl.ok.d r8 = this.f6862c;
        if (r8 != null) goto L28;
        return;
    L28:
        a(r8.c());
        return;
    L29:
        this.m = true;
        return;
    L32:
        if (r0 != 5) goto L39;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.obj, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L36;
        com.bytedance.common.wschannel.c.a.a r9 = com.bytedance.common.wschannel.c.a.a.f6793a;
    L37:
        this.o.a(r9);
        this.n.a(r9);
        return;
    L36:
        r9 = com.bytedance.common.wschannel.c.a.a.f6794b;
        goto L37
    L39:
        if (r0 != 7) goto L60;
        this.i.removeMessages(2);     // Catch: Throwable -> L45
        this.i.removeMessages(1);     // Catch: Throwable -> L45
        b.a(this.f6861b, (List) ZeusTransformUtils.preCheckCast(r7.obj, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L45
        this.g = false;     // Catch: Throwable -> L45
        this.f6862c = new com.bytedance.common.wschannel.channel.impl.ok.d(b.d(this.f6861b), b.e(this.f6861b));     // Catch: Throwable -> L45
        f();     // Catch: Throwable -> L45
        if (g() == false) goto L43;
        a(this.f6862c.c());     // Catch: Throwable -> L45
    L48:
        return;
    L43:
        this.m = true;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void j() {
        com.bytedance.common.wschannel.channel.impl.ok.b.a r2 = this.l;
        if (r2 == null) goto L6;
        r2.c(1000, "normal close");
        return;
    }

    void a(Map<String, Object> r3, List<String> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        a(new AnonymousClass4(this, r5, r6));
    }

    void a(int r2) {
        this.i.obtainMessage(3, Integer.valueOf(r2)).sendToTarget();
    }

    private boolean a(h r1) {
        return a(r1);
    }

    private boolean a(Object r3) {
        Logger.d("WsChannelSdk_ok", "send msg : " + r3);
        if (this.l != null) goto L5;
    L12:
        return false;
    L5:
        if (c() == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L10;
        return this.l.b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L12;
        return this.l.d((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    boolean a(byte[] r1) {
        return a(h.a(r1));
    }

    void a(d r3) {
        this.k = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
    }

    private String a(ah r2) {
        ah r1 = (ah) ZeusTransformUtils.wrapperContextForParams(r2, ah.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        ab r3 = r1.a();
        if (r3 == null) goto L12;
        v r4 = r3.a();
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4.toString();
    L12:
        return "";
    L10:
        return "";
    }

    void d() {
        this.i.removeMessages(2);
        this.i.removeMessages(1);
        this.i.removeMessages(3);
        this.i.removeMessages(5);
        a(new AnonymousClass5(this));
    }

    void a(boolean r2) {
        this.i.obtainMessage(5, Boolean.valueOf(r2)).sendToTarget();
    }

    private int a(ad r1) {
        if (r1 != null) goto L9;
        return -1;
    L9:
        return Integer.parseInt(r1.b("Handshake-Status"));
    L11:
        return -1;
    }

    private void a(Closeable r2) {
        Closeable r1 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    private void a(String r2, int r3, String r4, boolean r5) {
        b(2);
        h();
        d r1 = this.k;
        if (r1 == null) goto L7;
        if (r5 == false) goto L8;
        r1.a(r2, r3, r4);
        return;
    L8:
        return;
    }

    private void k() {
        ab r0 = this.f;
        if (r0 == null) goto L7;
        d r1 = this.k;
        if (r1 == null) goto L7;
        r1.a(r0.a().toString(), 3, "heatbeat timeout");
    L7:
        Pair<String, Long> r2 = this.f6862c.a(null);
        e();
        j();
        a(0, (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin"), true);
    }

    private void l() {
        this.i.post(new AnonymousClass6(this));
    }

    void b(Map<String, Object> r3, List<String> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        a(new AnonymousClass7(this, r5, r6));
    }

    private static z.a a(z.a r5) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L15:
        return r5;
    L5:
        if (Build.VERSION.SDK_INT >= 22) goto L15;
        SSLContext r1 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r1.init(null, null, null);     // Catch: Exception -> L13
        r5 = a(r5, r1);     // Catch: Exception -> L9
    L11:
        okhttp3.l r2 = new okhttp3.l.a(okhttp3.l.f40166c).a(new ag[]{ag.f39731c}).a();     // Catch: Exception -> L13
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L13
        r3.add(r2);     // Catch: Exception -> L13
        r3.add(okhttp3.l.f40167d);     // Catch: Exception -> L13
        r3.add(okhttp3.l.f40168e);     // Catch: Exception -> L13
        r5.a(r3);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        a("WsChannelSdk_ok", "Error while setting TLS 1.2 with two parameter func", e);     // Catch: Exception -> L13
        r5.a(new com.bytedance.common.wschannel.channel.impl.ok.b(r1.getSocketFactory()));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        a("WsChannelSdk_ok", "Error while setting TLS 1.2", e);
        goto L15
    }

    private static z.a a(z.a r5, SSLContext r6) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.aiagent.plugin"));
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        if (ZeusTransformUtils.instanceOf(r1[0], X509TrustManager.class) == false) goto L9;
        r5.a(new com.bytedance.common.wschannel.channel.impl.ok.b(r6.getSocketFactory()), (X509TrustManager) ZeusTransformUtils.preCheckCast(r1[0], X509TrustManager.class, "com.obric.aiagent.plugin"));
        return r5;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    private void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.i.post(r4);
    }

    private void b(byte[] r10) {
        Logger.d("WsChannelSdk_ok", "enter sendMessageAckIfNeeded");
        Frame r11 = (Frame) ZeusTransformUtils.preCheckCast(Frame.ADAPTER.decode(r10), Frame.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(Wire.get(r11.headers, Collections.emptyList()), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L41;
        boolean r2 = false;
        String r3 = null;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        Frame.b r4 = (Frame.b) ZeusTransformUtils.preCheckCast(r1.next(), Frame.b.class, "com.obric.aiagent.plugin");
        if (r4.f6989b.equals(WsConstants.KEY_NEED_ACK) == false) goto L16;
        if (r4.f6990c.equals("1") == false) goto L16;
        r2 = true;
    L16:
        if (r4.f6989b.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L18;
    L20:
        if (r2 == false) goto L9;
        if (TextUtils.isEmpty(r3) == true) goto L9;
    L18:
        if (TextUtils.isEmpty(r4.f6990c) == true) goto L20;
        r3 = r4.f6990c;
    L23:
        if (r2 == true) goto L25;
        return;
    L25:
        ArrayList r5 = new ArrayList();
        r5.add(new Frame.b.a().a(WsConstants.KEY_IS_ACK).b("1").a());
        r5.add(new Frame.b.a().a(WsConstants.KEY_ACK_ID).b((String) ZeusTransformUtils.preCheckCast(Wire.get(r11.logidnew, ""), String.class, "com.obric.aiagent.plugin")).a());
        r5.add(new Frame.b.a().a(WsConstants.KEY_ACK_CODE).b("0").a());
        if (TextUtils.isEmpty(r3) == true) goto L28;
        r5.add(new Frame.b.a().a(WsConstants.KEY_FRONTIER_MSGID).b(r3).a());
    L28:
        Frame.a r12 = new Frame.a().a((Long) ZeusTransformUtils.preCheckCast(Wire.get(r11.seqid, Frame.DEFAULT_SEQID), Long.class, "com.obric.aiagent.plugin")).b((Long) ZeusTransformUtils.preCheckCast(Wire.get(r11.logid, Frame.DEFAULT_LOGID), Long.class, "com.obric.aiagent.plugin")).a((Integer) ZeusTransformUtils.preCheckCast(Wire.get(r11.service, Frame.DEFAULT_SERVICE), Integer.class, "com.obric.aiagent.plugin")).b((Integer) ZeusTransformUtils.preCheckCast(Wire.get(r11.method, Frame.DEFAULT_METHOD), Integer.class, "com.obric.aiagent.plugin")).c((String) ZeusTransformUtils.preCheckCast(Wire.get(r11.logidnew, ""), String.class, "com.obric.aiagent.plugin")).a(r5);
        a(Frame.ADAPTER.encode(r12.a()));
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
