package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.n;
import com.bytedance.android.live.profit.fansclub.r;
import com.bytedance.android.live.profit.fansclub.s;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j40.k0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import yz0.l;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f87406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f87407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f87408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f87409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f87410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f87411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yz0.k f87412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f87413h;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final boolean A() {
        if (k0.f497249a.getValue().booleanValue() == false) goto L14;
        String r100 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        if (TextUtils.equals(r100, f()) == true) goto L10;
    L12:
        return false;
    L10:
        if (TextUtils.isEmpty(f()) == true) goto L12;
        return true;
    L14:
        return this.f87412g.isAnchor();
    }

    public final Context getContext() {
        Context r100 = this.f87407b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final IRoom getRoom() {
        return this.f87412g.getRoom();
    }

    public final com.bytedance.android.live.profit.fansclub.b i() {
        com.bytedance.android.live.profit.fansclub.o r100 = yt0.d.a(this.f87411f).a();
        if (r100 == null) goto L9;
        m<? extends com.bytedance.android.live.profit.fansclub.g> r101 = r100.getProfile();
        if (r101 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.g r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.f87296a;
    L9:
        return null;
    }

    public final com.bytedance.android.livesdk.revenue.service.user.a n() {
        return (com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f87408c.clear();
    }

    public final com.bytedance.android.live.profit.vip.h q() {
        com.bytedance.android.live.profit.vip.e r100 = yt0.d.a(this.f87411f).b();
        if (r100 == null) goto L7;
        m<? extends com.bytedance.android.live.profit.vip.h> r101 = r100.getSubscribeInfo();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    public final boolean w() {
        com.bytedance.android.live.profit.fansclub.o r100 = yt0.d.a(this.f87411f).a();
        if (r100 == null) goto L7;
        m<? extends r> r101 = r100.getShopFansClubData();
        if (r101 == null) goto L7;
        r r102 = r101.getValue();
    L8:
        if (r102 == null) goto L14;
        s r103 = r102.userData;
        if (r103 == null) goto L14;
        if (r103.joinStatus != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        r102 = null;
        goto L8
    }

    public final boolean x() {
        if (this.f87410e == false) goto L5;
    L21:
        return false;
    L5:
        if (getRoom().isMergeVSRoom() == true) goto L21;
        if (A() == false) goto L12;
        Boolean r100 = (Boolean) ((Map) wt0.c.f561180c.getValue(null, wt0.c.f561178a[1])).get(f());
        if (r100 == null) goto L21;
        return r100.booleanValue();
    L12:
        IBaseUser r101 = getRoom().getOwner();
        if (r101 == null) goto L17;
        g0 r102 = r101.getSubscribe();
        if (r102 == null) goto L17;
        long r103 = r102.getOpen();
    L19:
        if (r103 != 1) goto L21;
        return true;
    L17:
        r103 = 0;
        goto L19
    }

    public final boolean E() {
        if (x() == true) goto L6;
        return false;
    L6:
        if (F() == false) goto L8;
        boolean r100 = w();
    L15:
        if (c() == true) goto L17;
        if (r100 == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        com.bytedance.android.live.profit.fansclub.o r101 = yt0.d.a(this.f87411f).a();
        if (r101 != null) goto L11;
    L13:
        r100 = false;
        goto L15
    L11:
        if (r101.isMember() != true) goto L13;
        r100 = true;
        goto L15
    }

    public final boolean F() {
        IRoomAuthStatus r100 = getRoom().getRoomAuthStatus();
        if (r100 == null) goto L5;
        Long r101 = Long.valueOf(r100.getEcomFansClubAuth());
    L7:
        if (((int) r101.longValue()) != 1) goto L13;
        boolean r102 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        if (((n) com.bytedance.android.live.revenue.core.util.h.d(n.class)).enableEcomFansClubReverse() == true) goto L13;
        if (getRoom().isMergeVSRoom() == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean I() {
        if (A() == false) goto L6;
        return true;
    L6:
        return ((br2.a) vh6.c.b(br2.a.class)).Tg(getRoom().getOwner(), getRoom());
    }

    public final boolean K() {
        if (x() == true) goto L5;
    L7:
        return false;
    L5:
        if (E() == true) goto L7;
        return true;
    }

    public final boolean L() {
        if (getRoom().isMergeVSRoom() == false) goto L15;
        com.bytedance.android.live.profit.fansclub.o r100 = yt0.d.a(this.f87411f).a();
        if (r100 == null) goto L11;
        m<? extends Integer> r101 = r100.getScene();
        if (r101 == null) goto L11;
        Integer r102 = r101.getValue();
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
    L13:
        if (r103 != 2) goto L15;
        return true;
    L11:
        r103 = 1;
    L15:
        return false;
    }

    public final boolean N() {
        com.bytedance.android.live.profit.vip.h r100 = q();
        if (r100 == null) goto L5;
        int r101 = r100.f89143k;
    L6:
        if (r101 != 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public final boolean c() {
        IRoom r100 = getRoom();
        Intrinsics.checkNotNullParameter(r100, "$this$allowFansClub");
        if (r100.getRoomAuthStatus() == null) goto L8;
        IRoomAuthStatus r101 = r100.getRoomAuthStatus();
        Intrinsics.checkNotNull(r101);
        if (r101.enableFansClub() == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d() {
        if (A() == false) goto L5;
        return false;
    L5:
        u0 r100 = u0.f90999f;
        com.bytedance.tools.kcp.spongepreference.runtime.a r101 = com.bytedance.android.live.profit.fansclub.f.f87293c;
        KProperty<?>[] r102 = com.bytedance.android.live.profit.fansclub.f.f87291a;
        if (s0.c(new u0(((Number) r101.getValue(null, r102[1])).longValue())) == true) goto L9;
        long r103 = t0.b().f91006a;
        r101.setValue(null, r102[1], Long.valueOf(r103));
        ArrayList r104 = new ArrayList();
        r104.add(f());
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        com.bytedance.android.live.profit.fansclub.f.f87294d.setValue(null, r102[2], r104);
        return true;
    L9:
        com.bytedance.tools.kcp.spongepreference.runtime.a r105 = com.bytedance.android.live.profit.fansclub.f.f87294d;
        List r106 = (List) r105.getValue(null, r102[2]);
        if (r106.size() < 3) goto L12;
        return false;
    L12:
        if (r106.contains(f()) == true) goto L17;
        r106.add(f());
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.setValue(null, r102[2], r106);
        return true;
    L17:
        return false;
    }

    public final String f() {
        IBaseUser r100 = getRoom().getOwner();
        if (r100 == null) goto L6;
        String r101 = r100.getIdString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final com.bytedance.android.live.base.model.user.j g() {
        IBaseUser r100 = getRoom().getOwner();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCommonVipInfo();
    }

    public final long h() {
        com.bytedance.android.live.base.model.user.j r100 = g();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getType();
    }

    public final com.bytedance.android.live.profit.fansclub.j j() {
        com.bytedance.android.live.profit.fansclub.b r100 = i();
        if (r100 == null) goto L7;
        com.bytedance.android.live.profit.fansclub.j r101 = r100.f87278c;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new com.bytedance.android.live.profit.fansclub.j(0);
    }

    public final long k() {
        return getRoom().getId();
    }

    public final long o() {
        com.bytedance.android.live.profit.vip.h r100 = q();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f89142j;
    }

    public final int s() {
        com.bytedance.android.live.profit.vip.h r100 = q();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f89136d;
    }

    public static final /* synthetic */ DataCenter a(i r100) {
        DataCenter r101 = r100.f87406a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r101;
    }

    public final void y(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f87407b = r100;
        this.f87406a = r101;
        com.bytedance.android.live.profit.fansclub.o r102 = yt0.d.a(this.f87411f).a();
        if (r102 == null) goto L5;
        RxUtilKt.c(r102.getProfile().a().subscribe(new a(this)), this.f87408c);
        RxUtilKt.c(r102.getShopFansClubData().a().subscribe(new b(this)), this.f87408c);
    L5:
        com.bytedance.android.live.profit.vip.e r103 = yt0.d.a(this.f87411f).b();
        if (r103 == null) goto L8;
        RxUtilKt.c(r103.getSubscribeInfo().a().subscribe(new c(this)), this.f87408c);
    L8:
        RxUtilKt.c(n().followStateChanged().filter(new d(this)).subscribe(new e(this)), this.f87408c);
        RxUtilKt.c(n().m().subscribe(new f(this)), this.f87408c);
        if (((Boolean) com.bytedance.android.live.profit.fansclub.i.f87306g.getValue(null, com.bytedance.android.live.profit.fansclub.i.f87300a[5])).booleanValue() == false) goto L17;
        com.bytedance.live.datacontext.n<IRoom> r104 = this.f87413h.getRoomContext().getInteractionDataPrepared();
        EntranceDataSource$subscribeEvent$6 r105 = new EntranceDataSource$subscribeEvent$6(this);
        IRoom r106 = r104.getValue();
        if (r106 == null) goto L13;
        r105.invoke2(r106);
        goto L17
    L13:
        Disposable r107 = RxUtilKt.h(r104.a()).subscribe(new g(r105));
        if (r107 == null) goto L17;
        RxUtilKt.c(r107, this.f87408c);
    L17:
        if (g() == null) goto L25;
        l r108 = (l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), l.class);
        if (r108 == null) goto L25;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r109 = yz0.h.a.a(r108, com.bytedance.android.live.revenue.common.message.b.O, false, 6);
        if (r109 == null) goto L25;
        Disposable r110 = r109.subscribe(new h(this));
        if (r110 == null) goto L25;
        RxUtilKt.c(r110, this.f87408c);
    L25:
        EntranceMVIFacade r111 = fu0.b.b(r101);
        if (r111 == null) goto L29;
        r111.a(new eu0.k(r101));
        return;
    }

    public i(com.bytedance.android.live.revenue.core.a r100, yz0.k r101, com.bytedance.android.livesdk.revenue.service.room.c r102) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "revRoomService");
        this.f87411f = r100;
        this.f87412g = r101;
        this.f87413h = r102;
        this.f87408c = new CompositeDisposable();
        this.f87410e = true;
    }

    public final void J(IBaseUser r100, String r101, boolean r102, Function1<? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (A() == false) goto L5;
        r103.invoke(Boolean.TRUE);
        return;
    L5:
        ((br2.a) vh6.c.b(br2.a.class)).Cc(r100, r101, getRoom(), r103);
    }
}
