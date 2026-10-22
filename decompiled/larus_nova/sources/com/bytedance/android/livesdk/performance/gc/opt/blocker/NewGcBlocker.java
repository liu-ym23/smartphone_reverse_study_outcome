package com.bytedance.android.livesdk.performance.gc.opt.blocker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.t1;
import com.bytedance.android.livesdkapi.model.LiveGcControllerConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vn2.e;

/* JADX INFO: loaded from: classes11.dex */
public final class NewGcBlocker implements com.bytedance.android.livesdk.performance.gc.opt.blocker.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveGcControllerConfig f154609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f154610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f154611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f154612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f154613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f154614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f154615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f154616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f154617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f154618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f154619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PthreadHandlerThreadV2 f154620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f154621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f154622n;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGcBlocker f154623a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            super.handleMessage(r110);
            NewGcBlocker r100 = this.f154623a;
            int r111 = r110.what;
            r100.getClass();
            if (r111 != 1) goto L5;
            int r101 = e.f556452a;
        L33:
            if (r111 != 99) goto L35;
            return;
        L35:
            if (r100.f154610b == false) goto L41;
            b r112 = r100.f154619k;
            if (r112 == null) goto L42;
            r112.sendMessageDelayed(r112.obtainMessage(99), 100);
            return;
        L42:
            return;
        L41:
            return;
        L5:
            if (r111 != 2) goto L7;
            int r102 = e.f556452a;
            goto L33
        L7:
            if (r111 != 3) goto L9;
            int r103 = e.f556452a;
            goto L33
        L9:
            if (r111 == 4) goto L14;
            if (r111 != 99) goto L33;
            Runtime.getRuntime().totalMemory();
            Runtime.getRuntime().freeMemory();
            Runtime.getRuntime().maxMemory();
            goto L33
        L14:
            if (r100.f154614f == false) goto L33;
            if ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) > (Runtime.getRuntime().maxMemory() * r100.f154617i)) goto L18;
        L27:
            b r104 = r100.f154619k;
            if (r104 == null) goto L33;
            r104.sendMessageDelayed(r104.obtainMessage(4), r100.f154615g);
            goto L33
        L18:
            if (r100.f154621m.get() == true) goto L27;
            if (r100.f154618j <= 0) goto L27;
            if ((System.currentTimeMillis() - r100.f154618j) <= r100.f154616h) goto L27;
            b r105 = r100.f154619k;
            if (r105 == null) goto L26;
            r105.removeMessages(3);
            r105.sendMessage(r105.obtainMessage(3));
        L26:
            r100.f154618j = System.currentTimeMillis();
            goto L27
        }

        public b(NewGcBlocker r100, Looper r101) {
            this.f154623a = r100;
            super(r101);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGcBlocker f154624a;

        public c(NewGcBlocker r100) {
            this.f154624a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f154624a.f154621m.set(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void prepare() {
        if (this.f154620l != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("live-gc-opt");
        this.f154620l = r100;
        ThreadMethodProxy.start(r100);
    L6:
        if (this.f154619k != null) goto L8;
        PthreadHandlerThreadV2 r101 = this.f154620l;
        Intrinsics.checkNotNull(r101);
        this.f154619k = new b(this, r101.getLooper());
    L8:
        b r102 = this.f154619k;
        if (r102 != null) goto L11;
    L18:
        this.f154618j = System.currentTimeMillis();
        return;
    L11:
        if (this.f154612d == false) goto L13;
    L14:
        r102.sendMessage(r102.obtainMessage(1));
    L16:
        if (this.f154614f == false) goto L18;
        r102.sendMessageDelayed(r102.obtainMessage(4), this.f154615g);
        goto L18
    L13:
        if (this.f154613e == false) goto L16;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void release() {
        b r100 = this.f154619k;
        if (r100 == null) goto L7;
        r100.removeMessages(3);
        r100.removeMessages(4);
        r100.removeMessages(1);
        r100.sendMessage(r100.obtainMessage(2));
        if (this.f154609a.getNeedGcAfterRelease() == false) goto L7;
        r100.sendMessage(r100.obtainMessage(3));
    L7:
        PthreadHandlerThreadV2 r101 = this.f154620l;
        if (r101 == null) goto L10;
        r101.quitSafely();
    L10:
        this.f154620l = null;
        this.f154619k = null;
        this.f154621m.set(false);
    }

    public NewGcBlocker() {
        LiveGcControllerConfig r100 = t1.f158504a.getValue();
        this.f154609a = r100;
        this.f154610b = r100.getDebug();
        Runtime.getRuntime().maxMemory();
        r100.getNewMaxHeapLimitPercent();
        boolean r101 = false;
        if (r100.getGcBlockerStrategy() != 0) goto L5;
        boolean r102 = true;
    L6:
        this.f154611c = r102;
        if (r100.getGcBlockerStrategy() != 1) goto L9;
        boolean r103 = true;
    L10:
        this.f154612d = r103;
        if (r100.getGcBlockerStrategy() != 2) goto L13;
        r101 = true;
    L13:
        this.f154613e = r101;
        this.f154614f = r100.getOpenCheckHeapLoop();
        this.f154615g = r100.getCheckHeapLoopInterval();
        this.f154616h = r100.getForceGcInterval();
        this.f154617i = r100.getCheckForceGcPercent();
        this.f154621m = new AtomicBoolean();
        this.f154622n = LazyKt.lazy(NewGcBlocker$oldGcBlocker$2.INSTANCE);
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void a(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.f154611c == false) goto L8;
        b r101 = this.f154619k;
        if (r101 == null) goto L10;
        r101.removeMessages(1);
        r101.removeMessages(2);
        r101.sendMessage(r101.obtainMessage(1));
    L10:
        this.f154621m.set(true);
        return;
    L8:
        if (this.f154613e == false) goto L10;
        ((d) this.f154622n.getValue()).a(r100);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void b(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.f154611c == false) goto L8;
        b r101 = this.f154619k;
        if (r101 == null) goto L10;
        r101.removeMessages(1);
        r101.removeMessages(2);
        r101.sendMessage(r101.obtainMessage(2));
    L10:
        this.f154621m.set(false);
        return;
    L8:
        if (this.f154613e == false) goto L10;
        ((d) this.f154622n.getValue()).b(r100);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void requestBlockGc(int r100) {
        if (this.f154611c == false) goto L8;
        b r101 = this.f154619k;
        if (r101 == null) goto L10;
        r101.removeMessages(1);
        r101.removeMessages(2);
        r101.sendMessage(r101.obtainMessage(1));
        r101.sendMessageDelayed(r101.obtainMessage(2), r100);
    L10:
        this.f154621m.set(true);
        b r102 = this.f154619k;
        if (r102 == null) goto L14;
        r102.postDelayed(new c(this), r100);
        return;
    L14:
        return;
    L8:
        if (this.f154613e == false) goto L10;
        ((d) this.f154622n.getValue()).requestBlockGc(r100);
        goto L10
    }
}
