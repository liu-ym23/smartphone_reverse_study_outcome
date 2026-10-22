package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class CompensateHeartBeatManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppState f7034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f7035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CustomHeartBeatWebSocket f7036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnHeartBeatTimeoutListener f7037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f7038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f7039f;

    public interface OnHeartBeatTimeoutListener {
        void onTimeout();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompensateHeartBeatManager f7040a;

        public a(CompensateHeartBeatManager r10) {
            this.f7040a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CompensateHeartBeatManager.a(this.f7040a).getAndSet(false) == false) goto L8;
            Logger.d("WsChannelSdk_ok", "补偿ping发生了超时，准备重连");
            if (CompensateHeartBeatManager.b(this.f7040a) == null) goto L9;
            CompensateHeartBeatManager.b(this.f7040a).onTimeout();
            return;
        L9:
            return;
        }
    }

    public CompensateHeartBeatManager(OnHeartBeatTimeoutListener r10, Handler r11) {
        this.f7035b = new AtomicBoolean(false);
        this.f7039f = new a(this);
        this.f7037d = r10;
        this.f7038e = r11;
    }

    public static /* synthetic */ AtomicBoolean a(CompensateHeartBeatManager r10) {
        return r10.f7035b;
    }

    public static /* synthetic */ OnHeartBeatTimeoutListener b(CompensateHeartBeatManager r10) {
        return r10.f7037d;
    }

    public final boolean c(AppState r10) {
        if (this.f7034a == AppState.STATE_BACKGROUND) goto L5;
    L7:
        return false;
    L5:
        if (r10 != AppState.STATE_FOREGROUND) goto L7;
        return true;
    }

    public boolean d() {
        return this.f7035b.get();
    }

    public void e() {
        Logger.d("WsChannelSdk_ok", "补偿ping之后接受到了pong");
        this.f7035b.set(false);
        this.f7038e.removeCallbacks(this.f7039f);
    }

    public void f(CustomHeartBeatWebSocket r10) {
        this.f7036c = r10;
    }

    public void g(AppState r10) {
        if (this.f7035b.get() == false) goto L5;
    L13:
        this.f7034a = r10;
        return;
    L5:
        if (c(r10) == false) goto L13;
        Logger.d("WsChannelSdk_ok", "后台切换前台，发送补偿ping");
        CustomHeartBeatWebSocket r11 = this.f7036c;     // Catch: Exception -> L11
        if (r11 == null) goto L13;
        r11.sendPing(ByteString.EMPTY);     // Catch: Exception -> L11
        h();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public final void h() {
        this.f7035b.set(true);
        this.f7038e.removeCallbacks(this.f7039f);
        this.f7038e.postDelayed(this.f7039f, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
    }
}
