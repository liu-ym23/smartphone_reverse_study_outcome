package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Surface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.ed;
import com.ss.ttvideoengine.PreloaderVidItem;
import com.ss.ttvideoengine.TTVideoEngine;
import fd2.c0;
import fd2.d0;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class MvServiceImpl implements fd2.p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f146019k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f146020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KtvMvPlayer f146021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KtvMvModel f146022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final lb0.b f146023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MvPlayController f146024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.music.download.s f146025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PreloaderVidItem f146026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f146027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f146028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f146029j;

    public static final class a {
    }

    static {
    }

    @Override // fd2.p
    public final void a() {
        KtvMvModel r100 = this.f146022c;
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // fd2.p
    public final int getPlayState() {
        return this.f146024e.f146001b;
    }

    @Override // fd2.p
    public final void release() {
        this.f146022c.e();
        this.f146029j.dispose();
        MvPlayController r100 = this.f146024e;
        r100.f146011l.release();
        r100.f146001b = 0;
        b r101 = r100.f146013n;
        ValueAnimator r102 = r101.f146046c;
        if (r102 == null) goto L5;
        r102.end();
    L5:
        ValueAnimator r103 = r101.f146047d;
        if (r103 == null) goto L9;
        r103.end();
        return;
    }

    @Override // fd2.p
    public final lb0.b b() {
        return this.f146023d;
    }

    @Override // fd2.p
    public final void c(Surface r100) {
        this.f146021b.setSurface(r100);
    }

    @Override // fd2.p
    public final c0 d(d0 r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        l r111 = this.f146022c.b(new y(r110.f476483a, r110.f476484b, r110.f476485c, r110.f476486d, Integer.valueOf(r110.f476487e)));
        if (r111 != null) goto L6;
        return null;
    L6:
        String r100 = this.f146020a;
        if (r100 == null) goto L10;
        int r101 = com.bytedance.android.live.ktv.common.music.download.s.f70100a;
        String r102 = com.bytedance.android.live.ktv.common.music.download.s.a.a(r111.f146067d, r100);
        if (r102 == null) goto L10;
    L11:
        String r103 = r102;
        String r104 = r111.f146067d;
        List<ed> r105 = r111.f146071h;
        Integer r112 = r111.f146064a;
        if (r112 == null) goto L14;
        long r106 = r112.intValue();
    L16:
        return new c0(r104, r105, r103, r106);
    L14:
        r106 = 0;
    L10:
        r102 = r111.f146065b;
        goto L11
    }

    @Override // fd2.p
    public final void e(int r100) {
        ALogger.i("MvServiceImpl", "sendPlayCmd:" + r100);
        if (r100 != 0) goto L5;
        this.f146024e.c();
        return;
    L5:
        if (r100 != 1) goto L7;
        MvPlayController r101 = this.f146024e;
        if (r101.f146000a == false) goto L22;
        r101.f146011l.r();
        r101.f146001b = 1;
        return;
    L22:
        return;
    L7:
        if (r100 != 2) goto L24;
        MvPlayController r102 = this.f146024e;
        r102.f146011l.stop();
        r102.f146001b = 0;
        b r103 = r102.f146013n;
        ValueAnimator r104 = r103.f146046c;
        if (r104 == null) goto L12;
        r104.end();
    L12:
        ValueAnimator r105 = r103.f146047d;
        if (r105 == null) goto L20;
        r105.end();
        return;
    L20:
        return;
    }

    @Override // fd2.p
    public final void f(d0 r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        ALogger.i("MvServiceImpl", "fetchPlay:" + r110);
        l r100 = this.f146022c.b(new y(r110.f476483a, r110.f476484b, r110.f476485c, r110.f476486d, Integer.valueOf(r110.f476487e)));
        if (r100 == null) goto L15;
        String r101 = r100.f146066c;
        if (r110.f476487e != 2) goto L14;
        if (r101 != null) goto L8;
    L11:
        boolean r111 = true;
    L12:
        if (r111 == true) goto L14;
        MvPlayController r112 = this.f146024e;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r101, "url");
        r112.f146011l.q(new t(r101, null, null, 14));
        r112.f146001b = 1;
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r111 = false;
    L14:
        MvPlayController r113 = this.f146024e;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r100, "info");
        MvPlayController.e(r113, r100, true, null, 2);
        return;
    L15:
        MvPlayController r102 = this.f146024e;
        y r103 = new y(r110.f476483a, r110.f476484b, r110.f476485c, r110.f476486d, Integer.valueOf(r110.f476487e));
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "songMvParam");
        if (r103.f146212f != null) goto L18;
        r103.f146212f = r102.f146014o;
    L18:
        r102.f146012m.c(r103, new MvPlayController$fetchAndPlay$1(r102));
    }

    public MvServiceImpl(Long r100, int r101) {
        Context r102 = jc1.a.b();
        if (r102 != null) goto L7;
        r102 = com.bytedance.android.live.core.utils.a.d();
        if (r102 != null) goto L7;
        r102 = jc1.a.b();
    L7:
        KtvMvPlayer r103 = new KtvMvPlayer(r102, null);
        this.f146021b = r103;
        KtvMvModel r104 = new KtvMvModel(r100, null);
        this.f146022c = r104;
        lb0.b r105 = new lb0.b();
        this.f146023d = r105;
        this.f146024e = new MvPlayController(r103, r104, new b(r105), Integer.valueOf(r101), null);
        this.f146025f = new com.bytedance.android.live.ktv.common.music.download.s();
        this.f146027h = ((Boolean) vm2.h.f556206p3.getValue(null, vm2.h.f556082a[222(0xde, float:3.11E-43)])).booleanValue();
        this.f146029j = new CompositeDisposable();
    }

    @Override // fd2.p
    public final void g(d0 r110, Long r111, fd2.o r112) {
        Intrinsics.checkNotNullParameter(r110, "param");
        PreloaderVidItem r100 = this.f146026g;
        if (r100 == null) goto L5;
        String r101 = r100.mVideoId;
    L6:
        if (r101 == null) goto L8;
        this.f146021b.getClass();
        Intrinsics.checkNotNullParameter(r101, "vId");
        TTVideoEngine.cancelPreloadTaskByVideoId(r101);
    L8:
        com.bytedance.android.live.ktv.common.util.g.d("prefechMvInfo:" + r110);
        this.f146022c.c(new y(r110.f476483a, r110.f476484b, r110.f476485c, r110.f476486d, Integer.valueOf(r110.f476487e)), new MvServiceImpl$prefechMvInfo$1(this, r112, r110, r111));
        return;
    L5:
        r101 = null;
        goto L6
    }
}
