package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends eh0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ch0.j> f76700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Boolean> f76701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f76702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SeiAppData f76703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f76704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BehaviorSubject<SeiAppData> f76705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f76706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f76707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f76708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public eg6.b f76709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d f76710l;

    public static final class a {
    }

    public static final class b extends eg6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76711a;

        public b(e r100) {
            this.f76711a = r100;
        }

        @Override // eg6.a, eg6.c
        public final void i(String r100) {
            e r101 = this.f76711a;
            if ((!((ArrayList) r101.f76700b).isEmpty()) == false) goto L9;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r102 = r101.f76710l;
            if (r102 == null) goto L7;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r102, "RemoteSeiHandlerV2", r101.hashCode(), "clear", false, 24);
        L7:
            ((ArrayList) r101.f76700b).clear();
            ((LinkedHashMap) r101.f76701c).clear();
            r101.c();
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        eg6.b r100 = this.f76709k;
        if (r100 == null) goto L5;
        r100.h0(this.f76708j);
    L5:
        this.f76706h = true;
        Observable r101 = this.f76705g.distinctUntilChanged().map(new l(this)).share();
        Observable r102 = r101.filter(j.f76716a).map(k.f76717a);
        Observable r103 = r101.filter(m.f76719a).map(n.f76720a).sample(this.f76702d, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        Disposable r104 = r102.filter(new f(this)).subscribe(new g(this));
        this.f76707i.add(r104);
        Disposable r105 = r103.filter(new h(this)).subscribe(new i(this));
        this.f76707i.add(r105);
    }

    @Override // eh0.c
    public final void detach() {
        this.f76707i.clear();
        eg6.b r100 = this.f76709k;
        if (r100 == null) goto L5;
        r100.s(this.f76708j);
    L5:
        this.f76706h = false;
    }

    @Override // eh0.a, eh0.c
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a a(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.j> r100 = this.f76700b;
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
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r105, r104, r106);
    }

    public final void d(SeiAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        String r101 = r100.getChannelId();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r102 = this.f76710l;
        Long r103 = null;
        if (r102 == null) goto L7;
        IRoom r104 = r102.getRoom();
        if (r104 == null) goto L7;
        Long r105 = Long.valueOf(r104.getId());
    L9:
        if ((!Intrinsics.areEqual(r101, String.valueOf(r105))) == false) goto L17;
        StringBuilder r106 = new StringBuilder("sei channel id wrong ");
        r106.append(r100.getChannelId());
        r106.append(" room ");
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r107 = this.f76710l;
        if (r107 == null) goto L15;
        IRoom r108 = r107.getRoom();
        if (r108 == null) goto L15;
        r103 = Long.valueOf(r108.getId());
    L15:
        r106.append(r103);
        ALogger.d("RemoteSeiHandlerV2", r106.toString());
        return;
    L17:
        this.f76705g.onNext(r100);
        return;
    L7:
        r105 = null;
        goto L9
    }

    public e(eg6.b r100, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r101) {
        this.f76709k = r100;
        this.f76710l = r101;
        this.f76700b = new ArrayList();
        this.f76701c = new LinkedHashMap();
        this.f76702d = v2.f65430a.getValue().getSeiHandlerSamplingIntervalMs();
        this.f76704f = new AtomicLong(-1);
        this.f76705g = BehaviorSubject.create();
        this.f76707i = new CompositeDisposable();
        this.f76708j = new b(this);
    }
}
