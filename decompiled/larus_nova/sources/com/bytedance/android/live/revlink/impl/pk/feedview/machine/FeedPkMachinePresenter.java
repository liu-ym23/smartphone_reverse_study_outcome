package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.android.livesdk.message.model.v8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedPkMachinePresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f96527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f96528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mx0.a f96529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f96530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f96531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f96532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends yh6.c> f96533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f96534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f96535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f96536j;

    public final void e() {
        List<? extends yh6.c> r100 = this.f96533g;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        g((yh6.c) r101.next());
    L8:
        this.f96533g = null;
    }

    public final p f() {
        l r100 = this.f96536j.getState();
        if ((r100 instanceof l.a) == false) goto L6;
        p r101 = ((l.a) r100).f96580c;
        return new p(r101.f96586a, r101.f96587b);
    L6:
        if ((r100 instanceof l.d) == false) goto L11;
        Long r102 = this.f96534h;
        if (r102 != null) goto L15;
        p r103 = new p(com.bytedance.live.kmp.util.e.a(), false);
    L13:
        return r103;
    L15:
        return new p(r102.longValue(), true);
    L11:
        r103 = new p(com.bytedance.live.kmp.util.e.a(), false);
        goto L13
    }

    public FeedPkMachinePresenter(FeedPkStateMachine.b r100) {
        Intrinsics.checkNotNullParameter(r100, "machine");
        this.f96536j = r100;
        this.f96527a = new CompositeDisposable();
        this.f96535i = LazyKt.lazy(FeedPkMachinePresenter$linkNetwork$2.INSTANCE);
    }

    public final void c(mx0.a r100) {
        if (this.f96530d == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r101 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90888e);
        final FeedPkMachinePresenter$doMessageListen$1 r102 = new FeedPkMachinePresenter$doMessageListen$1(this);
        Disposable r103 = r101.subscribe(new a(r102));
        if (r103 == null) goto L8;
        RxUtilKt.c(r103, this.f96527a);
    L8:
        Observable r104 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90889f);
        final FeedPkMachinePresenter$doMessageListen$2 r105 = new FeedPkMachinePresenter$doMessageListen$2(this);
        Disposable r106 = r104.subscribe(new a(r105));
        if (r106 == null) goto L11;
        RxUtilKt.c(r106, this.f96527a);
    L11:
        Observable r107 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90895l);
        final FeedPkMachinePresenter$doMessageListen$3 r108 = new FeedPkMachinePresenter$doMessageListen$3(this);
        Disposable r109 = r107.subscribe(new a(r108));
        if (r109 == null) goto L14;
        RxUtilKt.c(r109, this.f96527a);
    L14:
        Observable r110 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90890g);
        final FeedPkMachinePresenter$doMessageListen$4 r111 = new FeedPkMachinePresenter$doMessageListen$4(this);
        Disposable r112 = r110.subscribe(new a(r111));
        if (r112 == null) goto L17;
        RxUtilKt.c(r112, this.f96527a);
    L17:
        this.f96530d = true;
    }

    public final void g(yh6.c r110) {
        if ((r110 instanceof r0) == false) goto L19;
        c5 r111 = (c5) ((vh7.c) r110).castTo(c5.class);
        u1 r100 = r111.getBattleSetting();
        if (r100 == null) goto L74;
        long r101 = r100.getBattleId();
        long r102 = r100.getStartTimeMs();
        long r112 = r100.getDuration();
        if (r102 > 0) goto L10;
        return;
    L10:
        if (r112 <= 0) goto L75;
        l r103 = this.f96536j.getState();
        if ((r103 instanceof l.c) == true) goto L15;
    L17:
        i(new e.a(new c(new v(r101, r102, (int) r112, r100, r111.getSkinConfig(), r111.getSkinType()), r111)));
        return;
    L15:
        if (r102 >= ((l.c) r103).f96582c.f96602c) goto L17;
        return;
    L75:
        return;
    L74:
        return;
    L19:
        if ((r110 instanceof v8) == false) goto L51;
        a5 r113 = (a5) ((vh7.c) r110).castTo(a5.class);
        l r104 = this.f96536j.getState();
        if ((r104 instanceof l.c) == false) goto L64;
        long r105 = ((l.c) r104).f96582c.f96601b;
        u1 r106 = r113.getBattleSetting();
        if (r106 != null) goto L25;
        return;
    L25:
        if (r105 != r106.getBattleId()) goto L77;
        this.f96536j.a();
        int r107 = r113.getEndReason();
        if (r107 != 0) goto L30;
        Intrinsics.checkNotNullParameter(r113, "message");
        u1 r108 = r113.getBattleSetting();
        if (r108 != null) goto L44;
    L46:
        u1 r109 = r113.getBattleSetting();
        if (r109 == null) goto L79;
        i(new e.d(new b(b(r109, r113.getSkinConfig(), r113.getSkinType()), r113)));
        return;
    L79:
        return;
    L44:
        if (af2.d.d(r108) != true) goto L46;
        i(new e.c(f()));
        return;
    L30:
        if (r107 != 4) goto L32;
    L40:
        i(new e.k(f()));
        return;
    L32:
        if (r107 == 16) goto L40;
        if (r107 != 6) goto L36;
        Intrinsics.checkNotNullParameter(r113, "message");
        RxUtilKt.c(Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r113)), this.f96527a);
        return;
    L36:
        if (r107 != 7) goto L78;
        h(r113);
        return;
    L78:
        return;
    L77:
        return;
    L64:
        return;
    L51:
        if ((r110 instanceof f2) == false) goto L71;
        c8 r114 = (c8) ((vh7.c) r110).castTo(c8.class);
        Long r115 = this.f96534h;
        if (r115 == null) goto L55;
        long r116 = r115.longValue();
    L57:
        if ((r114.getLinkStartTime() - r116) < 0) goto L72;
        this.f96534h = Long.valueOf(r114.getLinkStartTime());
        if ((this.f96536j.getState() instanceof l.a) == false) goto L73;
        this.f96536j.d(r114.getLinkStartTime());
        return;
    L73:
        return;
    L72:
        return;
    L55:
        r116 = 0;
        goto L57
    }

    public final void h(a5 r100) {
        l r101 = this.f96536j.getState();
        if ((r101 instanceof l.c) == false) goto L19;
        long r102 = ((l.c) r101).f96582c.f96601b;
        u1 r103 = r100.getBattleSetting();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r102 != r103.getBattleId()) goto L22;
        u1 r104 = r100.getBattleSetting();
        if (r104 != null) goto L12;
    L14:
        u1 r105 = r100.getBattleSetting();
        if (r105 != null) goto L17;
        return;
    L17:
        i(new e.m(new z(b(r105, r100.getSkinConfig(), r100.getSkinType()), r100)));
        return;
    L12:
        if (af2.d.d(r104) != true) goto L14;
        i(new e.l(f()));
        return;
    L22:
        return;
    }

    public final void i(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTargetLink");
        if ((r100 instanceof e.g) == false) goto L5;
    L18:
        boolean r101 = true;
    L19:
        if (r101 == false) goto L21;
        this.f96534h = null;
    L21:
        this.f96536j.f(r100);
        return;
    L5:
        if ((r100 instanceof e.h) == true) goto L18;
        if ((r100 instanceof e.C1483e) == true) goto L18;
        if ((r100 instanceof e.l) == true) goto L18;
        if ((r100 instanceof e.c) == true) goto L18;
        if ((r100 instanceof e.b) == true) goto L18;
        if ((r100 instanceof e.k) == true) goto L18;
        r101 = false;
        goto L19
    }

    public static final void a(FeedPkMachinePresenter r100, c3 r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        c1 r102 = r101.getBattleSetting();
    L6:
        if (r102 != null) goto L18;
        l r103 = r100.f96536j.getState();
        if ((r103 instanceof l.c) == false) goto L22;
        IBaseBattleSetting r104 = ((l.c) r103).f96582c.f96604e;
        if (r101 == null) goto L12;
        x2 r105 = r101.getSkinConfig();
    L13:
        if (r101 == null) goto L15;
        int r106 = r101.getSkinType();
    L16:
        r100.i(new e.f(new x(b(r104, r105, r106), null)));
        return;
    L15:
        r106 = 0;
        goto L16
    L12:
        r105 = null;
        goto L13
    L22:
        return;
    L18:
        if (af2.d.d(r102) == false) goto L20;
        r100.i(new e.C1483e(r100.f()));
        return;
    L20:
        r100.i(new e.f(new x(b(r102, r101.getSkinConfig(), r101.getSkinType()), r101)));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void d(IRoom r110, com.bytedance.android.live.revlink.impl.pk.feedview.machine.a r111) {
        a9 r100 = ((IRoomLinkExt) r110.castTo(IRoomLinkExt.class)).getLinkMicInfo();
        if (r100 == null) goto L5;
        long r101 = r100.getChannelId();
    L6:
        long r102 = r101;
        r31.a r103 = (r31.a) this.f96535i.getValue();
        if (r103 == null) goto L20;
        long r104 = 2;
        if (com.bytedance.android.live.revlink.impl.global.b.r() == null) goto L11;
        String r105 = d21.d.c(PkDoubleAudienceDataContext.BattleStatsFromType.Feed.ordinal());
    L12:
        Observable r112 = r103.O(r102, r104, 1, true, r105, r110.getRoomId(), iz.a.a(r110.getOwner()));
        if (r112 == null) goto L21;
        Observable r113 = r112.compose(RxUtil.rxSchedulerHelper());
        if (r113 == null) goto L22;
        Disposable r114 = r113.subscribe(new f(r111), new g(r111));
        if (r114 == null) goto L23;
        this.f96527a.add(r114);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r105 = null;
        goto L12
    L20:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public static s b(IBaseBattleSetting r110, x2 r111, int r112) {
        if (r110.getPunishDuration() == 0) goto L5;
        long r100 = r110.getPunishDuration();
    L7:
        if (r110.getPunishStartTimeMs() == 0) goto L11;
        long r101 = r110.getPunishStartTimeMs();
    L15:
        return new s(r101, (int) r100, r110, r111, r112);
    L11:
        if (r110.getStartTimeMs() == 0) goto L13;
        r101 = r110.getStartTimeMs() + (r110.getDuration() * ((long) 1000));
        goto L15
    L13:
        r101 = System.currentTimeMillis();
        goto L15
    L5:
        r100 = af2.d.a(r110);
        goto L7
    }
}
