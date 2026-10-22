package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.server.NetworkUtils;
import java.io.Closeable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class WsOkClient implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f6906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.common.wschannel.channel.impl.ok.b f6907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OkHttpClient f6908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Request f6910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f6912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f6913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c4.a f6914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WsStatusListener f6915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.common.wschannel.channel.impl.ok.ws.a f6916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f4.a f6918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CompensateHeartBeatManager f6919o;

    public interface WsStatusListener {
        void onClosed(String r10, int r11, String r12);

        void onConnecting(String r10);

        void onFailure(String r10, int r11, String r12);

        void onMessage(String r10);

        void onMessage(ByteString r10);

        void onOpen(Response r10);
    }

    public class a implements HeartBeatReactListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6920a;

        public a(WsOkClient r10) {
            this.f6920a = r10;
        }

        @Override // com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener
        public void onHeartBeatTimeout() {
            WsOkClient.t(this.f6920a);
        }

        @Override // com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener
        public void onSendPing() {
            WsOkClient.u(this.f6920a);
        }
    }

    public class b implements CompensateHeartBeatManager.OnHeartBeatTimeoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6921a;

        public b(WsOkClient r10) {
            this.f6921a = r10;
        }

        @Override // com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager.OnHeartBeatTimeoutListener
        public void onTimeout() {
            WsOkClient.t(this.f6921a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6922a;

        public c(WsOkClient r10) {
            this.f6922a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsOkClient.w(this.f6922a, true);
            WsOkClient.x(this.f6922a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f6923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f6924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6925c;

        public d(WsOkClient r10, Map r11, List r12) {
            this.f6925c = r10;
            this.f6923a = r11;
            this.f6924b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.f6925c.E();
            if (r10 != 4) goto L5;
        L11:
            Log.d("WsChannelSdk_ok", "cancel connect :,current state = " + r10);
            return;
        L5:
            if (r10 == 1) goto L11;
            if (r10 == 5) goto L11;
            this.f6925c.Y(this.f6923a);
            WsOkClient r11 = this.f6925c;
            r11.handleMsg(WsOkClient.a(r11).obtainMessage(2, this.f6924b));
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6926a;

        public e(WsOkClient r10) {
            this.f6926a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6926a.b0();
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6927a;

        public f(WsOkClient r10) {
            this.f6927a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L6:
            th = move-exception;
            g4.a.a().onPingFail(th);     // Catch: Throwable -> L12
        L8:
            WsOkClient.d(this.f6927a).onPingSendSuccess();
            return;
        L12:
            th = move-exception;
            WsOkClient.d(this.f6927a).onPingSendSuccess();
            throw th;
        L3:
            if (WsOkClient.b(this.f6927a) == null) goto L8;
            Logger.d("WsChannelSdk_ok", "发送ping");     // Catch: Throwable -> L6
            WsOkClient.b(this.f6927a).sendPing(ByteString.EMPTY);     // Catch: Throwable -> L6
            goto L8
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f6928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f6929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6930c;

        public g(WsOkClient r10, Map r11, List r12) {
            this.f6930c = r10;
            this.f6928a = r11;
            this.f6929b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6930c.Y(this.f6928a);
            WsOkClient r10 = this.f6930c;
            r10.handleMsg(WsOkClient.a(r10).obtainMessage(7, this.f6929b));
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f6932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OkHttpClient f6933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RetryPolicy f6934d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f4.a f6935e;

        public h(Context r10) {
            this.f6931a = r10;
        }

        public WsOkClient a() {
            return new WsOkClient(new i(this.f6931a, this.f6932b, this.f6933c, this.f6934d, this.f6935e), null);
        }

        public h b(f4.a r10) {
            if (r10 == null) goto L4;
            this.f6935e = r10;
        L4:
            return this;
        }

        public h c(RetryPolicy r10) {
            this.f6934d = r10;
            return this;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f6937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OkHttpClient f6938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RetryPolicy f6939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f4.a f6940e;

        public i(Context r10, List r11, OkHttpClient r12, RetryPolicy r13, f4.a r14) {
            this.f6936a = r10;
            this.f6937b = r11;
            this.f6938c = r12;
            this.f6939d = r13;
            this.f6940e = r14;
        }

        public static /* synthetic */ Context a(i r10) {
            return r10.f6936a;
        }

        public static /* synthetic */ OkHttpClient b(i r10) {
            return r10.f6938c;
        }

        public static /* synthetic */ f4.a c(i r10) {
            return r10.f6940e;
        }

        public static /* synthetic */ List d(i r10) {
            return r10.f6937b;
        }

        public static /* synthetic */ List e(i r10, List r11) {
            r10.f6937b = r11;
            return r11;
        }

        public static /* synthetic */ RetryPolicy f(i r10) {
            return r10.f6939d;
        }

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.f6940e + ", mContext=" + this.f6936a + ", wsUrls=" + this.f6937b + ", mOkHttpClient=" + this.f6938c + ", mRetryPolicy=" + this.f6939d + '}';
        }
    }

    public class j extends c4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsOkClient f6941a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CustomHeartBeatWebSocket f6942a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Response f6943b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ j f6944c;

            public a(j r10, CustomHeartBeatWebSocket r11, Response r12) {
                this.f6944c = r10;
                this.f6942a = r11;
                this.f6943b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onOpen--------");
                if (WsOkClient.b(this.f6944c.f6941a) != this.f6942a) goto L8;
                WsOkClient.e(this.f6944c.f6941a, 4);
                WsOkClient.f(this.f6944c.f6941a);
                WsOkClient.d(this.f6944c.f6941a).onConnected(this.f6943b);
                if (WsOkClient.g(this.f6944c.f6941a) == null) goto L9;
                WsOkClient.g(this.f6944c.f6941a).onOpen(this.f6943b);
                return;
            L9:
                return;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ByteString f6945a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j f6946b;

            public b(j r10, ByteString r11) {
                this.f6946b = r10;
                this.f6945a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onMessage--------");
                if (WsOkClient.g(this.f6946b.f6941a) == null) goto L6;
                WsOkClient.g(this.f6946b.f6941a).onMessage(this.f6945a);
                return;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f6947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j f6948b;

            public c(j r10, String r11) {
                this.f6948b = r10;
                this.f6947a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onMessage--------");
                if (WsOkClient.g(this.f6948b.f6941a) == null) goto L6;
                WsOkClient.g(this.f6948b.f6941a).onMessage(this.f6947a);
                return;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f6949a;

            public d(j r10) {
                this.f6949a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onClosing--------");
                WsOkClient.e(this.f6949a.f6941a, 6);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CustomHeartBeatWebSocket f6950a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f6951b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f6952c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f6953d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ j f6954e;

            public e(j r10, CustomHeartBeatWebSocket r11, String r12, int r13, String r14) {
                this.f6954e = r10;
                this.f6950a = r11;
                this.f6951b = r12;
                this.f6952c = r13;
                this.f6953d = r14;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onClosed--------");
                if (WsOkClient.b(this.f6954e.f6941a) != this.f6950a) goto L15;
                WsOkClient.e(this.f6954e.f6941a, 3);
                WsOkClient.c(this.f6954e.f6941a, null);
                WsOkClient.d(this.f6954e.f6941a).onDisconnected();
                if (WsOkClient.g(this.f6954e.f6941a) == null) goto L8;
                WsOkClient.g(this.f6954e.f6941a).onClosed(this.f6951b, this.f6952c, this.f6953d);
            L8:
                if (WsOkClient.j(this.f6954e.f6941a) == false) goto L12;
                WsOkClient.k(this.f6954e.f6941a, false);
                WsOkClient r10 = this.f6954e.f6941a;
                WsOkClient.m(r10, WsOkClient.l(r10).c());
                return;
            L12:
                if (WsOkClient.v(this.f6954e.f6941a) == true) goto L16;
                Pair r11 = WsOkClient.l(this.f6954e.f6941a).b(null);
                WsOkClient.n(this.f6954e.f6941a, ((Long) r11.second).longValue(), (String) r11.first, true);
                return;
            L16:
                return;
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f6955a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f6956b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f6957c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ CustomHeartBeatWebSocket f6958d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Pair f6959e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ j f6960f;

            public f(j r10, String r11, int r12, String r13, CustomHeartBeatWebSocket r14, Pair r15) {
                this.f6960f = r10;
                this.f6955a = r11;
                this.f6956b = r12;
                this.f6957c = r13;
                this.f6958d = r14;
                this.f6959e = r15;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("WsChannelSdk_ok", "----------onFailure--------");
                if (WsOkClient.g(this.f6960f.f6941a) == null) goto L6;
                WsOkClient.g(this.f6960f.f6941a).onFailure(this.f6955a, this.f6956b, this.f6957c);
            L6:
                if (WsOkClient.j(this.f6960f.f6941a) == false) goto L10;
                WsOkClient.k(this.f6960f.f6941a, false);
                WsOkClient r10 = this.f6960f.f6941a;
                WsOkClient.m(r10, WsOkClient.l(r10).c());
                return;
            L10:
                if (WsOkClient.b(this.f6960f.f6941a) == this.f6958d) goto L14;
                Logger.d("WsChannelSdk_ok", "socket已过期");
                return;
            L14:
                if (j.h(this.f6960f, this.f6956b) == false) goto L16;
                WsOkClient.d(this.f6960f.f6941a).onDisconnected();
                WsOkClient.n(this.f6960f.f6941a, ((Long) this.f6959e.second).longValue(), (String) this.f6959e.first, false);
                return;
            L16:
                WsOkClient.e(this.f6960f.f6941a, 2);
                WsOkClient.r(this.f6960f.f6941a);
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CustomHeartBeatWebSocket f6961a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j f6962b;

            public g(j r10, CustomHeartBeatWebSocket r11) {
                this.f6962b = r10;
                this.f6961a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f6961a == WsOkClient.b(this.f6962b.f6941a)) goto L6;
                return;
            L6:
                if (WsOkClient.s(this.f6962b.f6941a).d() == false) goto L9;
                WsOkClient.s(this.f6962b.f6941a).e();
                return;
            L9:
                WsOkClient.d(this.f6962b.f6941a).onReceivePong();
            }
        }

        public j(WsOkClient r10) {
            this.f6941a = r10;
        }

        public static /* synthetic */ boolean h(j r10, int r11) {
            return r10.i(r11);
        }

        @Override // c4.a
        public void a(CustomHeartBeatWebSocket r10, int r11, String r12) {
            String r13 = WsOkClient.i(this.f6941a, r10);
            WsOkClient.h(this.f6941a, new e(this, r10, r13, r11, r12));
        }

        @Override // c4.a
        public void b(CustomHeartBeatWebSocket r10, int r11, String r12) {
            super.b(r10, r11, r12);
            WsOkClient.h(this.f6941a, new d(this));
        }

        @Override // c4.a
        public void c(CustomHeartBeatWebSocket r10, Throwable r11, Response r12) {
            String r13 = WsOkClient.i(this.f6941a, r10);
            int r14 = WsOkClient.o(this.f6941a, r12);
            String r15 = WsOkClient.p(this.f6941a, r14);
            if (com.bytedance.common.utility.e.b(r15) == true) goto L5;
            String r16 = r15;
        L10:
            Pair r17 = WsOkClient.l(this.f6941a).b(r12);
            WsOkClient.q(this.f6941a, r12);
            WsOkClient.h(this.f6941a, new f(this, r13, r14, r16, r10, r17));
            return;
        L5:
            if (com.bytedance.common.utility.e.b(r11.getMessage()) == false) goto L8;
            String r18 = Log.getStackTraceString(r11);
        L7:
            r16 = r18;
            goto L10
        L8:
            r18 = r11.getMessage();
            goto L7
        }

        @Override // c4.a
        public void d(CustomHeartBeatWebSocket r10, String r11) {
            WsOkClient.h(this.f6941a, new c(this, r11));
        }

        @Override // c4.a
        public void e(CustomHeartBeatWebSocket r10, ByteString r11) {
            WsOkClient.h(this.f6941a, new b(this, r11));
        }

        @Override // c4.a
        public void f(CustomHeartBeatWebSocket r10, Response r11) {
            a r12 = new a(this, r10, r11);
            WsOkClient.h(this.f6941a, r12);
        }

        @Override // c4.a
        public void g(CustomHeartBeatWebSocket r10, ByteString r11) {
            WsOkClient.h(this.f6941a, new g(this, r10));
        }

        public final boolean i(int r10) {
            if (r10 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r10 == 414) goto L13;
            if (r10 == 511) goto L13;
            if (r10 == 512) goto L13;
            if (r10 == 513) goto L13;
            return false;
        }

        public /* synthetic */ j(WsOkClient r10, a r11) {
            this(r10);
        }
    }

    public /* synthetic */ WsOkClient(i r10, a r11) {
        this(r10);
    }

    private void S(Runnable r10) {
        this.f6913i.post(r10);
    }

    public static /* synthetic */ Handler a(WsOkClient r10) {
        return r10.f6913i;
    }

    public static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.ws.a b(WsOkClient r10) {
        return r10.f6916l;
    }

    public static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.ws.a c(WsOkClient r10, com.bytedance.common.wschannel.channel.impl.ok.ws.a r11) {
        r10.f6916l = r11;
        return r11;
    }

    public static /* synthetic */ f4.a d(WsOkClient r10) {
        return r10.f6918n;
    }

    public static /* synthetic */ void e(WsOkClient r10, int r11) {
        r10.Z(r11);
    }

    public static /* synthetic */ void f(WsOkClient r10) {
        r10.y();
    }

    public static /* synthetic */ WsStatusListener g(WsOkClient r10) {
        return r10.f6915k;
    }

    public static /* synthetic */ void h(WsOkClient r10, Runnable r11) {
        r10.S(r11);
    }

    public static /* synthetic */ String i(WsOkClient r10, WebSocket r11) {
        return r10.U(r11);
    }

    public static /* synthetic */ boolean j(WsOkClient r10) {
        return r10.f6917m;
    }

    public static /* synthetic */ boolean k(WsOkClient r10, boolean r11) {
        r10.f6917m = r11;
        return r11;
    }

    public static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.b l(WsOkClient r10) {
        return r10.f6907c;
    }

    public static /* synthetic */ void m(WsOkClient r10, String r11) {
        r10.d0(r11);
    }

    public static /* synthetic */ void n(WsOkClient r10, long r11, String r12, boolean r13) {
        r10.e0(r11, r12, r13);
    }

    public static /* synthetic */ int o(WsOkClient r10, Response r11) {
        return r10.F(r11);
    }

    public static /* synthetic */ String p(WsOkClient r10, int r11) {
        return r10.G(r11);
    }

    public static /* synthetic */ void q(WsOkClient r10, Closeable r11) {
        r10.T(r11);
    }

    public static /* synthetic */ void r(WsOkClient r10) {
        r10.R();
    }

    public static /* synthetic */ CompensateHeartBeatManager s(WsOkClient r10) {
        return r10.f6919o;
    }

    public static /* synthetic */ void t(WsOkClient r10) {
        r10.P();
    }

    public static /* synthetic */ void u(WsOkClient r10) {
        r10.Q();
    }

    public static /* synthetic */ boolean v(WsOkClient r10) {
        return r10.f6911g;
    }

    public static /* synthetic */ boolean w(WsOkClient r10, boolean r11) {
        r10.f6911g = r11;
        return r11;
    }

    public static /* synthetic */ void x(WsOkClient r10) {
        r10.c0();
    }

    public final String A(String r10, Map r11) {
        if (TextUtils.isEmpty(r10) == true) goto L38;
        if (r11 == null) goto L38;
        String r12 = j4.a.h(String.valueOf(r11.get(WsConstants.KEY_FPID)) + String.valueOf(r11.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r11.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder r13 = Uri.parse(r10).buildUpon();
        Iterator r14 = r11.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L26;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (r15 == null) goto L8;
        if (TextUtils.isEmpty((CharSequence) r15.getKey()) == true) goto L8;
        if (r15.getValue() != null) goto L17;
        String r16 = "";
    L18:
        String r17 = (String) r15.getKey();
        if (com.bytedance.common.utility.e.a(WsConstants.KEY_APP_KEY, r17) == true) goto L8;
        if (com.bytedance.common.utility.e.a(r17, WsConstants.KEY_EXTRA) == true) goto L8;
        if (com.bytedance.common.utility.e.a("app_version", r17) == true) goto L24;
        r13.appendQueryParameter(r17, r16);
        goto L8
    L24:
        r13.appendQueryParameter("version_code", r16);
        goto L8
    L17:
        r16 = r15.getValue().toString();
        goto L18
    L26:
        String r18 = (String) r11.get(WsConstants.KEY_EXTRA);
        if (com.bytedance.common.utility.e.b(r18) == true) goto L36;
        String[] r19 = r18.split("&");
        int r20 = r19.length;
        int r21 = 0;
    L29:
        if (r21 >= r20) goto L36;
        String r22 = r19[r21];
        if (TextUtils.isEmpty(r22) == true) goto L35;
        String[] r23 = r22.split("=");
        if (r23.length != 2) goto L35;
        r13.appendQueryParameter(r23[0], r23[1]);
    L35:
        r21 = r21 + 1;
    L36:
        r13.appendQueryParameter("access_key", r12);
        r13.appendQueryParameter("ne", String.valueOf(K()));
        return r13.build().toString();
    L38:
        return "";
    }

    public void B() {
        this.f6913i.removeMessages(2);
        this.f6913i.removeMessages(1);
        this.f6913i.removeMessages(3);
        this.f6913i.removeMessages(5);
        S(new e(this));
    }

    public final boolean C() {
        int r10 = E();
        if (r10 != 3) goto L5;
        return true;
    L5:
        if (r10 != 2) goto L7;
        return true;
    L7:
        if (r10 == 5) goto L23;
        this.f6918n.onDisconnected();
        com.bytedance.common.wschannel.channel.impl.ok.ws.a r11 = this.f6916l;
        if (r11 == null) goto L22;
        Message r12 = this.f6913i.obtainMessage(6, r11);
        this.f6913i.sendMessageDelayed(r12, 1000);
        if (r10 != 4) goto L15;
        this.f6916l.close(1000, "normal close");
        Z(6);
        return false;
    L15:
        this.f6916l.cancel();
        Z(3);
        if (r10 == 1) goto L19;
        return true;
    L19:
        return false;
    L22:
        return true;
    L23:
        return true;
    }

    public final void D() {
        com.bytedance.common.wschannel.channel.impl.ok.ws.a r10 = this.f6916l;
        if (r10 == null) goto L6;
        r10.d(1000, "normal close");
        return;
    }

    public synchronized int E() {
        monitor-enter(this);
        int r10 = this.f6909e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final int F(Response r10) {
        if (r10 != null) goto L9;
        return -1;
    L9:
        return Integer.parseInt(r10.f("Handshake-Status"));
    L11:
        return -1;
    }

    public final String G(int r10) {
        if (r10 != 0) goto L5;
        return "成功";
    L5:
        if (r10 != 404) goto L8;
        return "uri不存在";
    L8:
        if (r10 != 409) goto L11;
        return "fpid没有注册";
    L11:
        if (r10 != 410) goto L14;
        return "非法的设备id";
    L14:
        if (r10 != 411) goto L17;
        return "appid还没有注册";
    L17:
        if (r10 != 412) goto L20;
        return "websocket子协议不支持";
    L20:
        if (r10 != 413) goto L23;
        return "该设备已经建立连接";
    L23:
        if (r10 != 414) goto L26;
        return "服务器不能接受更多连接，可重试";
    L26:
        if (r10 != 415) goto L29;
        return "设备被限时禁止连接";
    L29:
        if (r10 != 416) goto L32;
        return "参数不正确";
    L32:
        if (r10 != 417) goto L35;
        return "鉴权失败";
    L35:
        if (r10 != 510) goto L38;
        return "服务器内部错误";
    L38:
        if (r10 != 511) goto L41;
        return "服务器忙，可稍后重试";
    L41:
        if (r10 != 512) goto L44;
        return "服务器正在关机";
    L44:
        if (r10 != 513) goto L47;
        return "auth服务异常";
    L47:
        if (r10 != 514) goto L49;
        return "auth服务返回失败";
    L49:
        return "";
    }

    public final void H(String r10) {
        if (this.f6908d != null) goto L5;
        this.f6908d = new OkHttpClient.Builder().m(Collections.singletonList(Protocol.HTTP_1_1)).c();
    L5:
        String r11 = A(r10, this.f6912h);
        if (com.bytedance.common.utility.e.b(r11) == false) goto L9;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L9:
        D();
        Logger.d("WsChannelSdk_ok", "尝试打开长连接:" + r11);
        Request r12 = this.f6910f;
        if (r12 != null) goto L12;
    L13:
        this.f6910f = new Request.a().a("Sec-Websocket-Protocol", "pbbp").j(r11).b();
    L14:
        Z(1);
        com.bytedance.common.wschannel.channel.impl.ok.ws.a r13 = com.bytedance.common.wschannel.channel.impl.ok.ws.a.f(this.f6910f, com.bytedance.common.wschannel.b.d(this.f6905a).b(), this.f6914j);
        this.f6916l = r13;
        r13.e(this.f6908d);
        this.f6919o.f(this.f6916l);
        WsStatusListener r14 = this.f6915k;
        if (r14 == null) goto L18;
        r14.onConnecting(r11);
        return;
    L18:
        return;
    L12:
        if (r11.equals(r12.k().toString()) == true) goto L14;
        goto L13
    }

    public boolean I() {
        if (E() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean J(Context r10) {
        return NetworkUtils.c(r10);
    }

    public final int K() {
        NetworkUtils.NetworkType r10 = NetworkUtils.b(this.f6905a);
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10 != NetworkUtils.NetworkType.NONE) goto L9;
        return 0;
    L9:
        if (r10 != NetworkUtils.NetworkType.WIFI) goto L13;
        return 1;
    L13:
        if (r10 != NetworkUtils.NetworkType.MOBILE_2G) goto L17;
        return 2;
    L17:
        if (r10 != NetworkUtils.NetworkType.MOBILE_3G) goto L20;
        return 3;
    L20:
        return 4;
    }

    public final void L(String r10, int r11, String r12, boolean r13) {
        Z(2);
        R();
        WsStatusListener r14 = this.f6915k;
        if (r14 == null) goto L7;
        if (r13 == false) goto L8;
        r14.onFailure(r10, r11, r12);
        return;
    L8:
        return;
    }

    public void M(boolean r10) {
        this.f6913i.obtainMessage(5, Boolean.valueOf(r10)).sendToTarget();
    }

    public void N(int r10) {
        this.f6913i.obtainMessage(3, Integer.valueOf(r10)).sendToTarget();
    }

    public void O(Map r10, List r11) {
        if (r11.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        S(new g(this, r10, r11));
    }

    public final void P() {
        Request r10 = this.f6910f;
        if (r10 == null) goto L7;
        WsStatusListener r11 = this.f6915k;
        if (r11 == null) goto L7;
        r11.onFailure(r10.k().toString(), 3, "心跳超时");
    L7:
        Pair r12 = this.f6907c.b(null);
        c0();
        D();
        e0(0, (String) r12.first, true);
    }

    public final void Q() {
        this.f6913i.post(new f(this));
    }

    public final void R() {
        com.bytedance.common.wschannel.channel.impl.ok.b r10 = this.f6907c;
        if (r10 == null) goto L6;
        r10.d();
        return;
    }

    public final void T(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public final String U(WebSocket r10) {
        if (r10 == null) goto L9;
        Request r11 = r10.request();
        if (r11 == null) goto L11;
        HttpUrl r12 = r11.k();
        if (r12 != null) goto L8;
        return "";
    L8:
        return r12.toString();
    L11:
        return "";
    L9:
        return "";
    }

    public final boolean V(Object r10) {
        Logger.d("WsChannelSdk_ok", "send msg : " + r10);
        if (this.f6916l != null) goto L5;
    L12:
        return false;
    L5:
        if (I() == false) goto L12;
        if ((r10 instanceof String) == false) goto L10;
        return this.f6916l.send((String) r10);
    L10:
        if ((r10 instanceof ByteString) == false) goto L12;
        return this.f6916l.send((ByteString) r10);
    }

    public final boolean W(ByteString r10) {
        return V(r10);
    }

    public boolean X(byte[] r10) {
        return W(ByteString.of(r10));
    }

    public void Y(Map r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.remove(WsConstants.KEY_CHANNEL_ID);
        this.f6912h.putAll(r10);
    }

    public final synchronized void Z(int r10) {
        monitor-enter(this);
        this.f6909e = r10;     // Catch: Throwable -> L6
        String r11 = "";
        if (r10 != 1) goto L9;
        r11 = "连接中";
    L23:
        Logger.d("WsChannelSdk_ok", "目前状态:" + r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L9:
        if (r10 != 2) goto L12;
        r11 = "连接失败";
        goto L23
    L12:
        if (r10 != 3) goto L15;
        r11 = "连接关闭";
        goto L23
    L15:
        if (r10 != 4) goto L18;
        r11 = "已连接";
        goto L23
    L18:
        if (r10 != 5) goto L21;
        r11 = "重试中";
        goto L23
    L21:
        if (r10 != 6) goto L23;
        r11 = "半关闭状态";
    L6:
        th = move-exception;
        throw th;
    }

    public void a0(WsStatusListener r10) {
        this.f6915k = r10;
    }

    public void b0() {
        S(new c(this));
    }

    public final void c0() {
        this.f6913i.removeMessages(2);
        this.f6913i.removeMessages(1);
        this.f6913i.removeMessages(3);
        this.f6913i.removeMessages(5);
        y();
        C();
    }

    public final void d0(String r10) {
        if (J(this.f6905a) == true) goto L6;
        L(r10, 1, "网络错误", true);
        return;
    L6:
        int r11 = E();
        if (r11 == 4) goto L18;
        if (r11 == 1) goto L19;
        H(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.f6915k == null) goto L20;
        this.f6915k.onFailure(r10, 4, Log.getStackTraceString(th));
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void e0(long r10, String r11, boolean r12) {
        this.f6913i.removeMessages(1);
        if (J(this.f6905a) == true) goto L7;
        L(r11, 1, "网络错误", r12);
        Logger.d("WsChannelSdk_ok", "网路不连通，取消重试");
        return;
    L7:
        if (this.f6911g == false) goto L11;
        Logger.d("WsChannelSdk_ok", "手动关闭");
        return;
    L11:
        if (r10 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r10 + " , url :" + r11);
        Logger.d("WsChannelSdk_ok", "这一轮重试结束，等待下一轮重试");
        Bundle r13 = new Bundle();
        r13.putString("method", "tryReconnect");
        r13.putLong("interval", r10);
        L(r11, 2, "重试失败", r12);
        r11 = this.f6907c.c();
    L17:
        Logger.d("WsChannelSdk_ok", "下一次重试时间: " + j4.a.d(System.currentTimeMillis() + r10));
        Message r14 = new Message();
        r14.what = 1;
        r14.obj = r11;
        this.f6913i.sendMessageDelayed(r14, r10);
        return;
    L13:
        if (com.bytedance.common.utility.e.b(r11) == true) goto L16;
        Z(5);
        goto L17
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.what;
        if (r11 != 1) goto L11;
        if (I() == false) goto L9;
        return;
    L9:
        this.f6913i.removeMessages(1);
        this.f6913i.removeMessages(2);
        d0((String) r10.obj);
        return;
    L11:
        if (r11 != 2) goto L17;
        this.f6913i.removeMessages(2);     // Catch: Throwable -> L14
        this.f6913i.removeMessages(1);     // Catch: Throwable -> L14
        i.e(this.f6906b, (List) r10.obj);     // Catch: Throwable -> L14
        this.f6911g = false;     // Catch: Throwable -> L14
        this.f6907c = new com.bytedance.common.wschannel.channel.impl.ok.b(i.d(this.f6906b), i.f(this.f6906b));     // Catch: Throwable -> L14
        y();     // Catch: Throwable -> L14
        d0(this.f6907c.c());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if (r11 != 3) goto L32;
        this.f6913i.removeMessages(2);
        this.f6913i.removeMessages(1);
        if (I() == false) goto L21;
        return;
    L21:
        y();
        if (J(this.f6905a) == true) goto L24;
        Logger.d("WsChannelSdk_ok", "网络变化，但网络不通，不尝试重连");
        return;
    L24:
        if (C() == false) goto L29;
        com.bytedance.common.wschannel.channel.impl.ok.b r12 = this.f6907c;
        if (r12 != null) goto L28;
        return;
    L28:
        d0(r12.c());
        return;
    L29:
        this.f6917m = true;
        return;
    L32:
        if (r11 != 5) goto L39;
        if (((Boolean) r10.obj).booleanValue() == false) goto L36;
        AppState r13 = AppState.STATE_FOREGROUND;
    L37:
        this.f6919o.g(r13);
        this.f6918n.onAppStateUpdate(r13);
        return;
    L36:
        r13 = AppState.STATE_BACKGROUND;
        goto L37
    L39:
        if (r11 != 7) goto L61;
        this.f6913i.removeMessages(2);     // Catch: Throwable -> L43
        this.f6913i.removeMessages(1);     // Catch: Throwable -> L43
        i.e(this.f6906b, (List) r10.obj);     // Catch: Throwable -> L43
        this.f6911g = false;     // Catch: Throwable -> L43
        this.f6907c = new com.bytedance.common.wschannel.channel.impl.ok.b(i.d(this.f6906b), i.f(this.f6906b));     // Catch: Throwable -> L43
        y();     // Catch: Throwable -> L43
        if (C() == false) goto L45;
        d0(this.f6907c.c());     // Catch: Throwable -> L43
    L49:
        return;
    L45:
        this.f6917m = true;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void y() {
        R();
        this.f6913i.removeMessages(1);
    }

    public void z(Map r10, List r11) {
        if (r11.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        S(new d(this, r10, r11));
    }

    public WsOkClient(i r10) {
        this.f6909e = 3;
        this.f6912h = new ConcurrentHashMap();
        this.f6913i = new WeakHandler(Looper.myLooper(), this);
        this.f6914j = new j(this, null);
        this.f6906b = r10;
        this.f6905a = i.a(r10);
        this.f6908d = i.b(r10);
        f4.a r11 = i.c(r10);
        this.f6918n = r11;
        if (r11 != null) goto L5;
        this.f6918n = new h4.b(new h4.a().c());
    L5:
        this.f6918n.a(new a(this), this.f6913i);
        this.f6919o = new CompensateHeartBeatManager(new b(this), this.f6913i);
    }
}
