package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import m4.b;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionClassManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f7137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicReference f7138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicReference f7139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f7140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7141f;

    public interface ConnectionClassStateChangeListener {
        void onBandwidthStateChange(ConnectionQuality r10);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConnectionClassManager f7142a = null;

        static {
            f7142a = new ConnectionClassManager();
        }
    }

    public ConnectionClassManager() {
        this.f7136a = new b(0.05d);
        this.f7137b = false;
        this.f7138c = new AtomicReference(ConnectionQuality.UNKNOWN);
        this.f7140e = new ArrayList();
    }

    public static ConnectionClassManager c() {
        return a.f7142a;
    }

    public synchronized void a(long r10, long r11) {
        monitor-enter(this);
        double r12 = ((r10 * 1.0d) / r11) * 8.0d;
        if (r11 != 0) goto L6;
    L28:
        monitor-exit(this);
        return;
    L6:
        if (r12 < 3.0d) goto L28;
        if (Logger.debug() == false) goto L11;
        Logger.d("ConnectionClassManager", "bytes = " + r10 + " timeInMs = " + r11 + " bandwidth = " + r12);     // Catch: Throwable -> L30
    L11:
        this.f7136a.a(r12);     // Catch: Throwable -> L30
        if (this.f7137b == false) goto L24;
        this.f7141f++;     // Catch: Throwable -> L30
        if (b() == this.f7139d.get()) goto L17;
        this.f7137b = false;     // Catch: Throwable -> L30
        this.f7141f = 1;     // Catch: Throwable -> L30
    L17:
        if (this.f7141f >= 5.0d) goto L19;
    L21:
        monitor-exit(this);
        return;
    L19:
        if (h() == false) goto L21;
        this.f7137b = false;     // Catch: Throwable -> L30
        this.f7141f = 1;     // Catch: Throwable -> L30
        this.f7138c.set(this.f7139d.get());     // Catch: Throwable -> L30
        e();     // Catch: Throwable -> L30
        goto L21
    L24:
        if (this.f7138c.get() == b()) goto L26;
        this.f7137b = true;     // Catch: Throwable -> L30
        this.f7139d = new AtomicReference(b());     // Catch: Throwable -> L30
    L26:
        monitor-exit(this);
    }

    public synchronized ConnectionQuality b() {
        monitor-enter(this);
        b r10 = this.f7136a;     // Catch: Throwable -> L8
        if (r10 != null) goto L19;
        ConnectionQuality r11 = ConnectionQuality.UNKNOWN;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L19:
        ConnectionQuality r12 = d(r10.b());     // Catch: Throwable -> L13
        monitor-exit(this);
        return r12;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L8
        return ConnectionQuality.UNKNOWN;
    L8:
        th = move-exception;
        throw th;
    }

    public final ConnectionQuality d(double r10) {
        if (r10 >= 0.0d) goto L7;
        return ConnectionQuality.UNKNOWN;
    L7:
        if (r10 >= 28.0d) goto L11;
        return ConnectionQuality.POOR;
    L11:
        if (r10 >= 112.0d) goto L15;
        return ConnectionQuality.MODERATE;
    L15:
        if (r10 >= 560.0d) goto L19;
        return ConnectionQuality.GOOD;
    L19:
        return ConnectionQuality.EXCELLENT;
    }

    public final void e() {
        int r10 = this.f7140e.size();     // Catch: Throwable -> L6
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        ((ConnectionClassStateChangeListener) this.f7140e.get(r11)).onBandwidthStateChange((ConnectionQuality) this.f7138c.get());     // Catch: Throwable -> L6
        r11 = r11 + 1;
        goto L3
    L12:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public ConnectionQuality f(ConnectionClassStateChangeListener r10) {
        if (r10 == null) goto L5;
        this.f7140e.add(r10);
    L5:
        return (ConnectionQuality) this.f7138c.get();
    }

    public void g(ConnectionClassStateChangeListener r10) {
        if (r10 == null) goto L5;
        this.f7140e.remove(r10);
        return;
    }

    public final boolean h() {
        if (this.f7136a != null) goto L31;
        return false;
    L31:
        ConnectionQuality r10 = (ConnectionQuality) this.f7138c.get();     // Catch: Throwable -> L26
        double r11 = 28.0d;
        if (ConnectionQuality.POOR != r10) goto L8;
        double r12 = 0.0d;
    L17:
        double r13 = this.f7136a.b();     // Catch: Throwable -> L26
        if (r13 <= r11) goto L24;
        if (r13 <= (r11 * 1.25d)) goto L30;
        return true;
    L30:
        return false;
    L24:
        if (r13 >= (r12 * 0.8d)) goto L30;
        return true;
    L8:
        r12 = 112.0d;
        if (ConnectionQuality.MODERATE != r10) goto L11;
    L10:
        double r14 = r11;
        r11 = r12;
        r12 = r14;
        goto L17
    L11:
        r11 = 560.0d;
        if (ConnectionQuality.GOOD == r10) goto L17;
        if (ConnectionQuality.EXCELLENT != r10) goto L28;
        r12 = 3.4028234663852886E38d;
        goto L10
    L28:
        return true;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L30
    }
}
