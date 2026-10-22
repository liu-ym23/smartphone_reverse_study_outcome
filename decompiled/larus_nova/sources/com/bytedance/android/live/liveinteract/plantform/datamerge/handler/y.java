package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class y extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a f76549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ch0.j> f76550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f76551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SeiAppData f76552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f76553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BehaviorSubject<SeiAppData> f76554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f76555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f76556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f76557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public eg6.b f76558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DataCenter f76559l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f76560a;

        public b(y r100) {
            this.f76560a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ch0.d r101 = (ch0.d) r100;
            this.f76560a.a().l1().getClass();
        }
    }

    public static final class c extends eg6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f76561a;

        public c(y r100) {
            this.f76561a = r100;
        }

        @Override // eg6.a, eg6.c
        public final void i(String r100) {
            y r101 = this.f76561a;
            if ((!((ArrayList) r101.f76550c).isEmpty()) == false) goto L6;
            gh0.a.b("SeiHandlerV2", "clear", 4);
            ((ArrayList) r101.f76550c).clear();
            r101.c();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.f76555h.clear();
        eg6.b r100 = this.f76558k;
        if (r100 == null) goto L5;
        r100.s(this.f76557j);
    L5:
        this.f76556i = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        RxUtilKt.c(a().a1().subscribe(new b(this)), this.f76555h);
        eg6.b r100 = this.f76558k;
        if (r100 == null) goto L5;
        r100.h0(this.f76557j);
    L5:
        Observable r101 = this.f76554g.distinctUntilChanged().map(new d0(this)).share();
        this.f76555h.add(Observable.merge(r101.filter(b0.f76424a).map(c0.f76425a), r101.filter(e0.f76431a).map(f0.f76432a).sample(this.f76551d, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())).filter(new z(this)).subscribe(new a0(this)));
        IRoomModuleService r102 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        long r103 = 0;
        if (r102 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.room.backend.g r104 = r102.getLiveRoomBackendUtils();
        if (r104 == null) goto L14;
        Room r105 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.f76559l, null, 2).getCurrentRoom();
        if (r105 == null) goto L12;
        long r106 = r105.getId();
    L13:
        r104.f(r106, u0.class, new SeiHandlerV2$initSeiAppData$1(this));
        goto L14
    L12:
        r106 = 0;
    L14:
        IRoomModuleService r107 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r107 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.room.backend.g r108 = r107.getLiveRoomBackendUtils();
        if (r108 == null) goto L24;
        com.bytedance.live.datacontext.m<IRoom> r109 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.f76559l, null, 2).getRoom();
        if (r109 == null) goto L23;
        IRoom r110 = r109.getValue();
        if (r110 == null) goto L23;
        r103 = r110.getId();
    L23:
        r108.f(r103, v0.class, new SeiHandlerV2$initSeiAppData$2(this));
    L24:
        this.f76556i = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.j> r100 = this.f76550c;
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        r101.put(((ch0.j) r103).f23744a, r103);
        goto L4
    L6:
        List<ch0.e> r111 = r110;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
        boolean r105 = false;
        ch0.e r106 = null;
    L8:
        if (r112.hasNext() == false) goto L23;
        ch0.e r107 = (ch0.e) r112.next();
        ch0.j r108 = (ch0.j) r101.get(r107.f23724a.getInteractId());
        if (r107.d(r108) == false) goto L12;
        boolean r109 = r105;
        ch0.e r113 = r107;
    L13:
        IBaseUser r114 = r113.f23724a.getUser();
        if (r114 == null) goto L16;
        String r115 = r114.getIdString();
    L18:
        if (Intrinsics.areEqual(r115, gh0.a.c()) == false) goto L21;
        if (r113 == r107) goto L21;
        r106 = r113;
    L21:
        r104.add(r113);
        r105 = r109;
        goto L8
    L16:
        r115 = null;
        goto L18
    L12:
        r113 = ch0.e.a(r107, null, null, r108, null, 11);
        r109 = true;
        goto L13
    L23:
        return new h.a(r105, r104, r106);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void d(SeiAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        this.f76554g.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void e(eg6.b r100) {
        eg6.b r101 = this.f76558k;
        if (r101 == null) goto L5;
        r101.s(this.f76557j);
    L5:
        this.f76558k = r100;
        if (this.f76556i == false) goto L10;
        if (r100 == null) goto L11;
        r100.h0(this.f76557j);
        return;
    L11:
        return;
    }

    public y(eg6.b r100, DataCenter r101) {
        this.f76558k = r100;
        this.f76559l = r101;
        this.f76549b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0);
        this.f76550c = new ArrayList();
        this.f76551d = v2.f65430a.getValue().getSeiHandlerSamplingIntervalMs();
        this.f76553f = new AtomicLong(-1);
        this.f76554g = BehaviorSubject.create();
        this.f76555h = new CompositeDisposable();
        this.f76557j = new c(this);
    }
}
