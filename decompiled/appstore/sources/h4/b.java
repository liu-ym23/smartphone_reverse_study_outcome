package h4;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class b extends f4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HeartBeatReactListener f20326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f20327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicBoolean f20328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f20329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f20330f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20331a;

        public a(b r10) {
            this.f20331a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.b(this.f20331a).getAndSet(false) == false) goto L8;
            b.c(this.f20331a);
            if (b.d(this.f20331a) == null) goto L9;
            Logger.d("WsChannelSdk_ok", "心跳超时，准备断开重连");
            b.d(this.f20331a).onHeartBeatTimeout();
            g4.a.a().onPingTimeout();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: h4.b$b, reason: collision with other inner class name */
    public class RunnableC0265b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20332a;

        public RunnableC0265b(b r10) {
            this.f20332a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.d(this.f20332a) == null) goto L6;
            b.e(this.f20332a);
            b.d(this.f20332a).onSendPing();
            return;
        }
    }

    public b(h4.a r10) {
        super(r10);
        this.f20328d = new AtomicBoolean(false);
        this.f20329e = new a(this);
        this.f20330f = new RunnableC0265b(this);
    }

    public static /* synthetic */ AtomicBoolean b(b r10) {
        return r10.f20328d;
    }

    public static /* synthetic */ void c(b r10) {
        r10.f();
    }

    public static /* synthetic */ HeartBeatReactListener d(b r10) {
        return r10.f20326b;
    }

    public static /* synthetic */ void e(b r10) {
        r10.g();
    }

    @Override // f4.a
    public void a(HeartBeatReactListener r10, Handler r11) {
        this.f20326b = r10;
        this.f20327c = r11;
    }

    public final void f() {
        this.f20327c.removeCallbacks(this.f20329e);
        this.f20327c.removeCallbacks(this.f20330f);
        this.f20328d.set(false);
    }

    public final void g() {
        long r10 = ((h4.a) this.f19472a).a();
        Logger.d("WsChannelSdk_ok", "interval :" + r10 + " ms,下次心跳时间为: " + j4.a.d(System.currentTimeMillis() + r10));
        this.f20327c.removeCallbacks(this.f20330f);
        this.f20327c.postDelayed(this.f20330f, r10);
    }

    public final void h(Response r13) {
        if (((h4.a) this.f19472a).a() == (-1)) goto L6;
        return;
    L6:
        if (r13 != null) goto L9;
        ((h4.a) this.f19472a).d(270000);
        return;
    L9:
        String r14 = r13.f("Handshake-Options");
        if (r14 == null) goto L22;
        String[] r15 = r14.split(";");
        int r10 = r15.length;
        long r11 = -1;
        int r12 = 0;
    L12:
        if (r12 >= r10) goto L24;
        String r16 = r15[r12];
        if (TextUtils.isEmpty(r16) == true) goto L21;
        String[] r17 = r16.split("=");
        if ("ping-interval".equals(r17[0]) == false) goto L21;
        r11 = Long.parseLong(r17[1]) * 1000;
    L20:
        r11 = 270000;
    L21:
        r12 = r12 + 1;
    L24:
        if (r11 != (-1)) goto L26;
        ((h4.a) this.f19472a).d(270000);
        return;
    L26:
        ((h4.a) this.f19472a).d(r11);
        return;
    L22:
        r11 = -1;
        goto L24
    }

    public final void i() {
        this.f20328d.set(true);
        this.f20327c.removeCallbacks(this.f20329e);
        this.f20327c.postDelayed(this.f20329e, ((h4.a) this.f19472a).b());
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r10) {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r10) {
        Logger.d("WsChannelSdk_ok", "连接成功，开始计时发送ping");
        h(r10);
        g();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        Logger.d("WsChannelSdk_ok", "断开连接，停止计时发送ping");
        f();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.d("WsChannelSdk_ok", "ping已发送，开始等待pong");
        i();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        Logger.d("WsChannelSdk_ok", "收到pong");
        this.f20328d.set(false);
        this.f20327c.removeCallbacks(this.f20329e);
        g4.a.a().onPingSuccess();
    }
}
