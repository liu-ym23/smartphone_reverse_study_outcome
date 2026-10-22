package com.bytedance.android.livesdk.gift.grouplive.component.repo;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import com.bytedance.android.livesdk.gift.model.v0;
import com.bytedance.android.livesdk.message.model.t5;
import com.bytedance.android.livesdk.message.model.t7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.n;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import iy0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import yz0.h;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: classes9.dex */
public final class GroupComponentRepo implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f126324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f126325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f126326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f126327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GroupComponentDataStore f126328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f126329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f126330g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupComponentRepo f126331a;

        public a(GroupComponentRepo r100) {
            this.f126331a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            t7 r101 = (t7) r100;
            m0 r102 = r101.getCommonData();
            if (r102 == null) goto L5;
            long r103 = r102.getCreateTime();
        L6:
            GroupComponentRepo r104 = this.f126331a;
            if (r104.f126325b >= r103) goto L10;
            r104.f126325b = r103;
            List<v0> r105 = r101.getGroupContainerList();
            List<ty1.b> r106 = GroupComponentRepo.a(this.f126331a, r105, r103);
            this.f126331a.f126328e.S(r106);
            return;
        L10:
            return;
        L5:
            r103 = 0;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupComponentRepo f126332a;

        public b(GroupComponentRepo r100) {
            this.f126332a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            t7 r101 = (t7) r100;
            m0 r102 = r101.getCommonData();
            if (r102 == null) goto L5;
            long r103 = r102.getCreateTime();
        L6:
            GroupComponentRepo r104 = this.f126332a;
            if (r104.f126325b >= r103) goto L10;
            r104.f126325b = r103;
            List<v0> r105 = r101.getGroupContainerList();
            List<ty1.b> r106 = GroupComponentRepo.a(this.f126332a, r105, r103);
            this.f126332a.f126328e.S(r106);
            return;
        L10:
            return;
        L5:
            r103 = 0;
            goto L6
        }
    }

    public static final class c implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupComponentRepo f126333a;

        public c(GroupComponentRepo r100) {
            this.f126333a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            jy0.b.c("GroupLiveRts Old", "get rtc meesage " + r100.getMessageId(), null, 4);
            if ((r100 instanceof t5) == false) goto L12;
            t5 r101 = (t5) r100;
            m0 r102 = r101.getCommonData();
            if (r102 == null) goto L7;
            long r103 = r102.getCreateTime();
        L8:
            GroupComponentRepo r104 = this.f126333a;
            if (r104.f126325b >= r103) goto L13;
            r104.f126325b = r103;
            this.f126333a.f126328e.S(GroupComponentRepo.a(this.f126333a, r101.getGroupContainerList(), r103));
            return;
        L13:
            return;
        L7:
            r103 = 0;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupComponentRepo f126334a;

        public d(GroupComponentRepo r100) {
            this.f126334a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            this.f126334a.c();
        }
    }

    public final void c() {
        if (((Boolean) qy1.a.f535177b.getValue(null, qy1.a.f535176a[0])).booleanValue() == false) goto L6;
        d(true);
        return;
    L6:
        if (e.b(this.f126327d.getRoom()) == false) goto L15;
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(this.f126327d.getRoom().getId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r103 == null) goto L10;
        r102.put("room_id", r103);
    L10:
        String r104 = this.f126327d.getRoom().getAnchorId();
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r104 == null) goto L13;
        r102.put("anchor_id", r104);
    L13:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        Disposable r105 = ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/anchor/group_live/get_container/", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(v0.class)))), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c).subscribeOn(Schedulers.io()).map(new com.bytedance.android.livesdk.gift.grouplive.component.repo.a(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.grouplive.component.repo.b(this), com.bytedance.android.livesdk.gift.grouplive.component.repo.c.f126337a);
        this.f126324a.add(r105);
        d(false);
        return;
    L15:
        if (e.b(this.f126327d.getRoom()) == true) goto L20;
        d(true);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        n<IRoom> r100 = this.f126329f.getInteractionDataPrepared();
        if (r100.getValue() == null) goto L5;
        c();
        return;
    L5:
        Disposable r101 = r100.a().subscribe(new d(this));
        if (r101 == null) goto L10;
        RxUtilKt.c(r101, this.f126324a);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f126324a.clear();
    }

    public final void d(boolean r100) {
        jy0.b.c("GroupLiveRts Old", "handleMessage isGroupLive: " + e.b(this.f126327d.getRoom()) + " GROUP_LIVE_CONTAINER_RTS: " + qy1.a.a(), null, 4);
        if (e.b(this.f126327d.getRoom()) == false) goto L7;
        if (qy1.a.a() == false) goto L7;
        return;
    L7:
        if (((Boolean) qy1.a.f535183h.getValue(null, qy1.a.f535176a[6])).booleanValue() == true) goto L9;
    L11:
        l r101 = this.f126330g;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(h.a.a(r101, com.bytedance.android.live.revenue.common.message.b.P, r100, 4).subscribe(new b(this)), this.f126324a);
    L13:
        if (this.f126329f.isAnchor().getValue().booleanValue() == false) goto L17;
        final c r102 = new c(this);
        this.f126329f.getRtcRoomInfo().a(new GroupComponentRepo$handleMessage$3(this, r102));
        return;
    L17:
        return;
    L9:
        if (this.f126329f.isAnchor().getValue().booleanValue() == true) goto L11;
        l r103 = this.f126330g;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(r103.Dm(com.bytedance.android.live.revenue.common.message.b.P, r100).subscribe(new a(this)), this.f126324a);
        goto L13
    }

    public static final List a(GroupComponentRepo r110, List r111, long r112) {
        r110.getClass();
        ArrayList r100 = new ArrayList();
        Iterator r101 = r111.iterator();
    L4:
        if (r101.hasNext() == false) goto L24;
        v0 r102 = (v0) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        ty1.a r104 = (ty1.a) GsonHelper.get().fromJson(r102.getPositionJson(), ty1.a.class);     // Catch: Throwable -> L18
        if (r104 == null) goto L15;
        ty1.c r105 = r104.a();     // Catch: Throwable -> L18
        if (r105 == null) goto L16;
        float r106 = r104.c() / r104.d();     // Catch: Throwable -> L18
        ty1.c r107 = r104.a();     // Catch: Throwable -> L18
        if (r107 == null) goto L13;
        float r108 = r107.f547961a;     // Catch: Throwable -> L18
    L14:
        r105.f547961a = r106 * r108;     // Catch: Throwable -> L18
        goto L16
    L13:
        r108 = 1.0f;
    L16:
        Object r109 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L20:
        ty1.a r113 = new ty1.a();
        if (Result.m9455isFailureimpl(r109) == false) goto L23;
        r109 = r113;
    L23:
        r100.add(new ty1.b(r102.getType(), r102.getPriority(), r102.getContainerPayload(), (ty1.a) r109, r102.getUrl(), r102.getFoldUrl(), r102.getHorizontalUrl(), r102.getCanAdjustPosition(), r112));
        goto L4
    L15:
        r104 = new ty1.a();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L24:
        return r100;
    }

    public GroupComponentRepo(k r100, GroupComponentDataStore r101, com.bytedance.android.livesdk.revenue.room.a r102, l r103) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "dataStore");
        Intrinsics.checkNotNullParameter(r102, "roomContext");
        Intrinsics.checkNotNullParameter(r103, "roomMessageService");
        this.f126327d = r100;
        this.f126328e = r101;
        this.f126329f = r102;
        this.f126330g = r103;
        this.f126324a = new CompositeDisposable();
        this.f126325b = -1;
    }
}
