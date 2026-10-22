package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.ttvideoengine.Resolution;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class MvPlayController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f146000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f146001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f146002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f146003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super KtvMvPlayer, Unit> f146004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Unit> f146005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function5<? super String, ? super Long, ? super String, ? super String, ? super Integer, Unit> f146006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function3<? super String, ? super Long, ? super String, Boolean> f146007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super l, Unit> f146008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f146009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super String, Unit> f146010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final KtvMvPlayer f146011l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final KtvMvModel f146012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.mv.b f146013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f146014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<y> f146015p;

    public static final class a<T> implements IMediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvPlayController f146016a;

        public a(MvPlayController r100) {
            this.f146016a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer.OnErrorListener
        public final void a(AbsPlayer r100, int r101, int r102, String r110) {
            com.bytedance.android.live.ktv.common.util.g.c("playError:" + r110);
            MvPlayController r103 = this.f146016a;
            Function5<? super String, ? super Long, ? super String, ? super String, ? super Integer, Unit> r104 = r103.f146006g;
            if (r104 == null) goto L6;
            Unit r105 = r104.invoke(r103.f146011l.n(), null, null, r110, Integer.valueOf(r101));
            return;
        }
    }

    public static final class b<T> implements IMediaPlayer.OnFirstFrameListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvPlayController f146017a;

        public b(MvPlayController r100) {
            this.f146017a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer.OnFirstFrameListener
        public final void a(AbsPlayer r100) {
            boolean r101 = r100 instanceof KtvMvPlayer;
            if (r101 == true) goto L5;
            AbsPlayer r102 = null;
        L6:
            KtvMvPlayer r103 = (KtvMvPlayer) r102;
            if (r103 == null) goto L9;
            int r104 = r103.o().getDuration();
        L10:
            l r105 = this.f146017a.f146002c;
            if (r105 == null) goto L13;
            r105.f146064a = Integer.valueOf(r104);
        L13:
            MvPlayController r106 = this.f146017a;
            l r107 = r106.f146002c;
            if (r107 == null) goto L18;
            ed r108 = MvPlayController.a(r106, r107, 0);
            if (r108 == null) goto L18;
            this.f146017a.f146013n.b(r108);
        L18:
            Function1<? super KtvMvPlayer, Unit> r109 = this.f146017a.f146004e;
            if (r109 == null) goto L23;
            if (r101 == true) goto L22;
            r100 = null;
        L22:
            Unit r110 = r109.invoke((KtvMvPlayer) r100);
        L23:
            this.f146017a.f146001b = 1;
            return;
        L9:
            r104 = 0;
            goto L10
        L5:
            r102 = r100;
            goto L6
        }
    }

    public static final class c<T> implements IMediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvPlayController f146018a;

        public c(MvPlayController r100) {
            this.f146018a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer.OnPreparedListener
        public final void a(IMediaPlayer r100) {
            AbsPlayer r101 = (AbsPlayer) r100;
            String r102 = null;
            if ((r101 instanceof KtvMvPlayer) == true) goto L5;
            r101 = null;
        L5:
            KtvMvPlayer r103 = (KtvMvPlayer) r101;
            if (r103 == null) goto L8;
            r102 = r103.n();
        L8:
            Function1<? super String, Unit> r104 = this.f146018a.f146005f;
            if (r104 == null) goto L12;
            Unit r105 = r104.invoke(r102);
            return;
        }
    }

    public static final class d {
    }

    static {
    }

    public final void c() {
        this.f146011l.pause();
        com.bytedance.android.live.ktv.common.util.g.d("pause play");
        this.f146001b = 2;
        this.f146000a = true;
    }

    public final void d() {
        com.bytedance.android.live.ktv.common.util.g.g("playDefaultMv");
        final KtvMvModel r100 = this.f146012m;
        final Function1<l, Unit> r101 = new MvPlayController$playDefaultMv$1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "cb");
        l r102 = r100.f145944i;
        if (r102 == null) goto L5;
        r101.invoke(r102);
        return;
    L5:
        String r103 = r100.f145940e;
        Function1<l, Unit> r104 = new KtvMvModel$getDefaultMvInfo$1(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "vId");
        Long r105 = r100.f145946k;
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfoByVid:" + r103 + "---" + r105);
        if (r105 == null) goto L10;
        r105.longValue();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getAtmosphereVideoInfoByVid(r105, r103, null, null, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r100, r104), new g(r100, r103)), r100.f145937b);
        return;
    }

    public static boolean b(y r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$checkMvInfoValid");
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r101.f146069f == r100.f146208b) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(r101.f146070g, r100.f146210d) == false) goto L10;
        return true;
    }

    public static final ed a(MvPlayController r100, l r101, int r102) {
        r100.getClass();
        Integer r103 = r101.f146064a;
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        r100.f146009j = r104;
        if (r104 <= 0) goto L18;
        List<ed> r105 = r101.f146071h;
        if (r105 == null) goto L18;
        if ((!r105.isEmpty()) != true) goto L18;
        int r106 = (int) ((r102 / r100.f146009j) * r101.f146071h.size());
        if (r106 < r101.f146071h.size()) goto L20;
        r106 = r101.f146071h.size() - 1;
    L20:
        return (ed) ListProtector.get(r101.f146071h, r106);
    L18:
        return null;
    L5:
        r104 = r100.f146011l.o().getDuration();
        r101.f146064a = Integer.valueOf(r100.f146011l.o().getDuration());
        Unit r107 = Unit.INSTANCE;
        goto L6
    }

    public MvPlayController(KtvMvPlayer r100, KtvMvModel r101, com.bytedance.android.livesdk.ktvimpl.mv.b r102, Integer r103, Function0<y> r104) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "mvModel");
        Intrinsics.checkNotNullParameter(r102, "dynamicBgController");
        this.f146011l = r100;
        this.f146012m = r101;
        this.f146013n = r102;
        this.f146014o = r103;
        this.f146015p = r104;
        r100.o().setIsMute(true);
        r100.setLooping(true);
        r101.f145941f = new AnonymousClass1(this);
        r100.f145959k = new AnonymousClass2(this);
        r101.f145942g = new AnonymousClass3(this);
        r100.f451187e = new a(this);
        r102.f146048e = new AnonymousClass5(this);
        r100.f451188f = new b(this);
        r100.k(new AnonymousClass7(this));
        r100.f451186d = new c(this);
    }

    public static boolean e(MvPlayController r100, l r101, boolean r102, Integer r110, int r111) {
        boolean r103 = false;
        if ((r111 & 1) == 0) goto L6;
        r102 = false;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r110 = null;
    L8:
        r100.getClass();
        com.bytedance.android.live.ktv.common.util.g.g("播放playInfo：" + r101);
        if (r110 != null) goto L12;
    L19:
        KtvMvPlayer r112 = r100.f146011l;
        KtvMvModel r104 = r100.f146012m;
        String r105 = r101.f146067d;
        String r106 = r101.f146068e;
        Long r107 = r101.f146076m;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "vid");
        u r108 = new u(r105, r106, r107);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r108, "request");
        com.bytedance.android.live.ktv.common.util.g.d("requestPlayByVid：" + r108.f146203a);
        if (Intrinsics.areEqual(r108.f146203a, r112.o().getVideoID()) == false) goto L23;
        if (r102 == true) goto L23;
        com.bytedance.android.live.ktv.common.util.g.d("requestPlay：same vid");
    L31:
        if (r103 == false) goto L39;
        r100.f146001b = 1;
        Function1<? super l, Unit> r109 = r100.f146008i;
        if (r109 == null) goto L35;
        Unit r113 = r109.invoke(r101);
    L35:
        r100.f146012m.f145936a = r101.f146067d;
        r100.f146002c = r101;
        return r103;
    L39:
        return r103;
    L23:
        r112.o().setVideoID(r108.f146203a);
        r112.o().setPlayAPIVersion(2, null);
        r112.o().setDataSource(new i(r112, r108));
        Long r114 = r108.f146205c;
        if (r114 != null) goto L26;
    L30:
        r112.m(r108.f146203a);
        r112.o().configResolution(Resolution.High);
        r112.f145962n = Long.valueOf(System.currentTimeMillis());
        r112.o().play();
        r103 = true;
        goto L31
    L26:
        if (r112.f145974z == false) goto L30;
        long r115 = r114.longValue();
        if (r115 <= 0) goto L30;
        r112.o().setStartTime((int) r115);
        goto L30
    L12:
        if (r110.intValue() != 2) goto L19;
        String r116 = r101.f146066c;
        if (r116 == null) goto L37;
        r100.f146011l.q(new t(r116, null, null, 14));
        r100.f146001b = 1;
        Function1<? super l, Unit> r117 = r100.f146008i;
        if (r117 == null) goto L18;
        Unit r118 = r117.invoke(r101);
    L18:
        r100.f146012m.f145936a = r101.f146067d;
        r100.f146002c = r101;
        return true;
    L37:
        return false;
    }
}
