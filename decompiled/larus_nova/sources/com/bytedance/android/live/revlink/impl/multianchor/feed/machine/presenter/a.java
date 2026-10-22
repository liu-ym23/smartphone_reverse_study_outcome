package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.y4;
import com.bytedance.android.livesdk.message.model.v8;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f94230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f94231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f94232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f94233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p0 f94234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<List<p>> f94235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<p> f94236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f94237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f94238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d f94239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f94240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f94241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<r, Unit> f94242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<r, Unit> f94243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<r, Unit> f94244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<r, Unit> f94245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final z21.a f94246q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final InterfaceC1455a f94247r;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a$a, reason: collision with other inner class name */
    public interface InterfaceC1455a {
        void a();

        void d(long r100);

        void e(x21.a r100);

        i f();

        x21.d getState();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f94248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f94249b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f94248a == r101.f94248a) goto L8;
            return false;
        L8:
            if (this.f94249b == r101.f94249b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f94248a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f94249b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "ReqListParam(roomId=" + this.f94248a + ", channelId=" + this.f94249b + ")";
        }

        public b(long r100, long r101) {
            this.f94248a = r100;
            this.f94249b = r101;
        }
    }

    public final x21.f e() {
        Long r100 = this.f94238i;
        x21.d r101 = this.f94247r.getState();
        if (r100 == null) goto L6;
        return new x21.f(r100.longValue(), true);
    L6:
        if ((r101 instanceof x21.d.a) == false) goto L9;
        x21.f r102 = ((x21.d.a) r101).f562208b;
        return new x21.f(r102.f562211a, r102.f562212b);
    L9:
        return new x21.f(com.bytedance.live.kmp.util.e.a(), false);
    }

    public static x21.g c(c1 r100) {
        long r101 = af2.d.b(r100);
        if (r100.getPunishStartTimeMs() == 0) goto L6;
        long r102 = r100.getPunishStartTimeMs();
    L10:
        return new x21.g(r102, (int) r101, r100);
    L6:
        if (r100.getStartTimeMs() == 0) goto L8;
        r102 = r100.getStartTimeMs() + (r100.getDuration() * ((long) 1000));
        goto L10
    L8:
        r102 = System.currentTimeMillis();
        goto L10
    }

    public final void b(Function1<? super r, Unit> r110) {
        IRoom r100 = this.f94246q.f569770a;
        if (r100 == null) goto L5;
        long r101 = r100.getId();
    L6:
        long r102 = this.f94232c;
        String r103 = null;
        if (r101 != 0) goto L9;
    L11:
        b r104 = null;
    L12:
        if (r104 != null) goto L14;
        return;
    L14:
        if (this.f94231b == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L34;
        long r111 = r104.f94248a;
        long r105 = r104.f94249b;
        d r106 = new d(this, r110);
        r31.a r107 = (r31.a) this.f94237h.getValue();
        if (r107 == null) goto L35;
        long r108 = 4;
        IRoom r112 = this.f94246q.f569770a;
        if (r112 == null) goto L25;
        IBaseUser r113 = r112.getOwnerKt();
        if (r113 == null) goto L25;
        r103 = r113.getIdString();
    L25:
        Observable r114 = r107.O(r105, r108, 7, false, "multi_anchor_feed_view", r111, r103);
        if (r114 == null) goto L36;
        Observable r115 = r114.compose(RxUtil.rxSchedulerHelper());
        if (r115 == null) goto L37;
        Disposable r116 = r115.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.b(this, r106), new c(r106));
        if (r116 == null) goto L38;
        this.f94230a.add(r116);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L9:
        if (r102 == 0) goto L11;
        r104 = new b(r101, r102);
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public final void d(mx0.a r100) {
        if (this.f94233d == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r101 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90885b);
        final FeedMultiMachinePresenter$onStartMessageListen$1 r102 = new FeedMultiMachinePresenter$onStartMessageListen$1(this);
        Disposable r103 = r101.subscribe(new g(r102));
        if (r103 == null) goto L8;
        RxUtilKt.c(r103, this.f94230a);
    L8:
        Observable r104 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90888e);
        final FeedMultiMachinePresenter$onStartMessageListen$2 r105 = new FeedMultiMachinePresenter$onStartMessageListen$2(this);
        Disposable r106 = r104.subscribe(new g(r105));
        if (r106 == null) goto L11;
        RxUtilKt.c(r106, this.f94230a);
    L11:
        Observable r107 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90889f);
        final FeedMultiMachinePresenter$onStartMessageListen$3 r108 = new FeedMultiMachinePresenter$onStartMessageListen$3(this);
        Disposable r109 = r107.subscribe(new g(r108));
        if (r109 == null) goto L14;
        RxUtilKt.c(r109, this.f94230a);
    L14:
        Observable r110 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90895l);
        final FeedMultiMachinePresenter$onStartMessageListen$4 r111 = new FeedMultiMachinePresenter$onStartMessageListen$4(this);
        Disposable r112 = r110.subscribe(new g(r111));
        if (r112 == null) goto L17;
        RxUtilKt.c(r112, this.f94230a);
    L17:
        Observable r113 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90890g);
        final FeedMultiMachinePresenter$onStartMessageListen$5 r114 = new FeedMultiMachinePresenter$onStartMessageListen$5(this);
        Disposable r115 = r113.subscribe(new g(r114));
        if (r115 == null) goto L20;
        RxUtilKt.c(r115, this.f94230a);
    L20:
        this.f94233d = true;
    }

    public final void f(x21.a r100) {
        if ((r100 instanceof x21.i) == false) goto L5;
        this.f94238i = null;
    L5:
        this.f94247r.e(r100);
    }

    public a(z21.a r100, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "machine");
        this.f94246q = r100;
        this.f94247r = r101;
        this.f94230a = new CompositeDisposable();
        this.f94235f = new MutableLiveData();
        this.f94236g = new ArrayList();
        this.f94237h = LazyKt.lazy(FeedMultiMachinePresenter$linkNetwork$2.INSTANCE);
        this.f94240k = new f(this);
        this.f94241l = new e(this);
        this.f94242m = new FeedMultiMachinePresenter$onClientPkTimeOut$1(this);
        this.f94243n = new FeedMultiMachinePresenter$onPullLinkMicListFromServer$1(this);
        this.f94244o = new FeedMultiMachinePresenter$onPkStandEndMsg$1(this);
        this.f94245p = new FeedMultiMachinePresenter$onSecKillMsg$1(this);
    }

    public static final void a(a r110, yh6.c r111) {
        r110.getClass();
        if ((r111 instanceof r0) == false) goto L19;
        c5 r112 = (c5) ((vh7.c) r111).castTo(c5.class);
        u1 r100 = r112.getBattleSetting();
        if (r100 == null) goto L96;
        long r101 = r100.getBattleId();
        long r102 = r100.getStartTimeMs();
        long r103 = r100.getDuration();
        if (r102 > 0) goto L10;
        return;
    L10:
        if (r103 <= 0) goto L97;
        x21.d r104 = r110.f94247r.getState();
        if ((r104 instanceof x21.d.c) == true) goto L15;
    L17:
        r110.f(new x21.a.c(new x21.h(r101, r102, (int) r103, r100), r112));
        return;
    L15:
        if (r102 >= ((x21.d.c) r104).f562210b.f562218c) goto L17;
        return;
    L97:
        return;
    L96:
        return;
    L19:
        if ((r111 instanceof v8) == false) goto L39;
        a5 r113 = (a5) ((vh7.c) r111).castTo(a5.class);
        x21.d r105 = r110.f94247r.getState();
        if ((r105 instanceof x21.d.c) == false) goto L80;
        long r106 = ((x21.d.c) r105).f562210b.f562217b;
        u1 r107 = r113.getBattleSetting();
        if (r107 != null) goto L25;
        return;
    L25:
        if (r106 != r107.getBattleId()) goto L99;
        r110.f94247r.a();
        int r114 = r113.getEndReason();
        if (r114 != 0) goto L30;
        r110.b(r110.f94244o);
        return;
    L30:
        if (r114 != 13) goto L32;
        r110.f(new x21.a.C8186a(r110.e()));
        return;
    L32:
        if (r114 == 6) goto L35;
        if (r114 == 7) goto L35;
        return;
    L35:
        r110.b(r110.f94245p);
        return;
    L99:
        return;
    L80:
        return;
    L39:
        if ((r111 instanceof h1) == false) goto L48;
        if (((int) ((i6) ((h1) r111).castTo(i6.class)).getType2()) != 7) goto L85;
        x21.d r115 = r110.f94247r.getState();
        if ((r115 instanceof x21.d.c) == false) goto L45;
    L46:
        r110.f(new x21.a.b(r110.e()));
        return;
    L45:
        if ((r115 instanceof x21.d.b) == true) goto L46;
        return;
    L85:
        return;
    L48:
        if ((r111 instanceof f2) == false) goto L68;
        c8 r116 = (c8) ((vh7.c) r111).castTo(c8.class);
        x21.d r108 = r110.f94247r.getState();
        long r109 = r116.getLinkStartTime();
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r117 = r110.f94239j;
        if (r117 == null) goto L53;
        r117.f(r116.getAnchorInfoMap());
    L53:
        if ((r108 instanceof x21.d.a) == false) goto L63;
        x21.f r118 = ((x21.d.a) r108).f562208b;
        if (r118.f562212b == true) goto L57;
    L59:
        r110.f94247r.d(r109);
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r119 = r110.f94239j;
        if (r119 == null) goto L88;
        r119.e(r109);
        return;
    L88:
        return;
    L57:
        if (r109 >= r118.f562211a) goto L59;
        return;
    L63:
        if ((r108 instanceof x21.d.C8188d) == false) goto L90;
        r110.f94238i = Long.valueOf(r109);
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r120 = r110.f94239j;
        if (r120 == null) goto L91;
        r120.e(r109);
        return;
    L91:
        return;
    L90:
        return;
    L68:
        if ((r111 instanceof y4) == false) goto L93;
        y4 r121 = (y4) r111;
        x21.d r122 = r110.f94247r.getState();
        if ((r122 instanceof x21.d.b) == false) goto L94;
        long r123 = ((x21.d.b) r122).f562209b.f562215c.getBattleId();
        u1 r124 = r121.getBattleSetting();
        if (r124 != null) goto L74;
        return;
    L74:
        if (r123 != r124.getBattleId()) goto L102;
        r110.f(new x21.a.C8186a(r110.e()));
        return;
    L102:
        return;
    L94:
        return;
    }
}
