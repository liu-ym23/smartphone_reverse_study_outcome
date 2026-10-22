package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.config.ik1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends com.bytedance.android.live.broadcastgame.xplay.screendetect.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f62376k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f62377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f62378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f62379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long[] f62380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f62381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f62382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f62383j;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f62384a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L6;
            this.f62384a.b("no frame receive, during " + this.f62384a.h().a());
            f.i(this.f62384a, "ttlive_xplay_anchor_screen_detect_no_frame", 0, "during", 2);
            return;
        }

        public b(f r100, Looper r101) {
            this.f62384a = r100;
            super(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void f() {
        if (this.f62377d == true) goto L5;
        return;
    L5:
        this.f62377d = false;
        if (this.f62379f == 0) goto L8;
    L10:
        this.f62383j.removeCallbacksAndMessages(null);
        long[] r100 = this.f62380g;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L11:
        if (r102 >= r101) goto L13;
        long r104 = r100[r102];
        this.f62380g[r103] = 0;
        r102 = r102 + 1;
        r103 = r103 + 1;
        goto L11
    L13:
        this.f62379f = 0;
        this.f62382i = 0;
        this.f62378e = 0;
        this.f62381h = 0;
        return;
    L8:
        if ((System.currentTimeMillis() - this.f62378e) <= h().a()) goto L10;
        b("onStop, not receive frame");
        i(this, "ttlive_xplay_anchor_screen_detect_no_frame", 0, "onStop", 2);
        goto L10
    }

    public final ik1.a h() {
        return this.f62358a.a();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void e() {
        if (h().b() == true) goto L6;
        return;
    L6:
        if (this.f62377d == false) goto L8;
        return;
    L8:
        this.f62377d = true;
        this.f62378e = System.currentTimeMillis();
        this.f62381h = 0;
        this.f62383j.sendEmptyMessageDelayed(1, h().a());
    }

    public f(c r100) {
        super(r100);
        this.f62380g = new long[h().d()];
        this.f62383j = new b(this, Looper.getMainLooper());
    }

    public static void i(final f r100, String r101, int r102, String r103, int r110) {
        if ((r110 & 2) == 0) goto L5;
        final int r104 = -1;
    L7:
        if ((r110 & 4) == 0) goto L9;
        r103 = "";
    L9:
        final String r105 = r103;
        r100.getClass();
        final long r106 = System.currentTimeMillis();
        long r107 = r100.f62382i;
        if (r107 != 0) goto L12;
    L14:
        r100.f62382i = r106;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a.d(r100, r101, com.bytedance.android.live.broadcastgame.xplay.screendetect.a.a(r100, new XplayAnchorScreenDetector$reportDetectRes$1(r100, r104, r105, r106)));
        return;
    L12:
        if (((r106 - r107) / ((long) 1000)) >= r100.h().e()) goto L14;
        return;
    L5:
        r104 = r102;
        goto L7
    }
}
