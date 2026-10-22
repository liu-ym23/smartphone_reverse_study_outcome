package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.liveinteract.plantform.model.u0;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
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
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class p extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a f76735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ch0.j> f76736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Boolean> f76737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f76738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SeiAppData f76739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f76740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BehaviorSubject<SeiAppData> f76741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f76742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f76743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f76744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public eg6.b f76745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d f76746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DataCenter f76747n;

    public static final class a {
    }

    public static final class b extends eg6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f76748a;

        public b(p r100) {
            this.f76748a = r100;
        }

        @Override // eg6.a, eg6.c
        public final void i(String r110) {
            p r111 = this.f76748a;
            if ((!((ArrayList) r111.f76736c).isEmpty()) == false) goto L9;
            gh0.a.b("SeiHandlerV3", "clear", 4);
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r100 = r111.f76746m;
            if (r100 == null) goto L7;
            r100.m("SeiHandlerV3", r111.hashCode(), "clear", false, false);
        L7:
            ((ArrayList) r111.f76736c).clear();
            ((LinkedHashMap) r111.f76737d).clear();
            r111.a().h1(r111.f76737d);
            r111.c();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.f76743j = false;
        this.f76742i.clear();
        eg6.b r100 = this.f76745l;
        if (r100 == null) goto L6;
        r100.s(this.f76744k);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        if (this.f76743j == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.f76743j = true;
        eg6.b r101 = this.f76745l;
        if (r101 == null) goto L8;
        r101.h0(this.f76744k);
    L8:
        Observable r102 = this.f76741h.distinctUntilChanged().map(new w(this)).share();
        Observable r103 = r102.filter(u.f76753a).map(v.f76754a);
        Observable r104 = r102.filter(x.f76756a).map(y.f76757a).sample(this.f76738e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        this.f76742i.add(r103.filter(new q(this)).subscribe(new r(this)));
        this.f76742i.add(r104.filter(new s(this)).subscribe(new t(this)));
        if (MultiLinkLoadWidgetUtils.g() == true) goto L11;
    L13:
        r100 = false;
    L15:
        if (r100 == true) goto L64;
    L37:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r105 = this.f76746m;
        if (r105 != null) goto L40;
        return;
    L40:
        if (r105.getShowFrom() != 0) goto L69;
        IRoomModuleService r106 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        long r107 = 0;
        if (r106 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.room.backend.g r108 = r106.getLiveRoomBackendUtils();
        if (r108 == null) goto L51;
        Room r109 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.f76747n, null, 2).getCurrentRoom();
        if (r109 == null) goto L49;
        long r110 = r109.getId();
    L50:
        r108.f(r110, u0.class, new SeiHandlerV3$initSeiAppData$1(this));
        goto L51
    L49:
        r110 = 0;
    L51:
        IRoomModuleService r111 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r111 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.room.backend.g r112 = r111.getLiveRoomBackendUtils();
        if (r112 == null) goto L68;
        com.bytedance.android.livesdk.chatroom.o r113 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.f76747n, null, 2);
        if (r113 == null) goto L62;
        com.bytedance.live.datacontext.m<IRoom> r114 = r113.getRoom();
        if (r114 == null) goto L62;
        IRoom r115 = r114.getValue();
        if (r115 == null) goto L62;
        r107 = r115.getId();
    L62:
        r112.f(r107, v0.class, new SeiHandlerV3$initSeiAppData$2(this));
        return;
    L68:
        return;
    L67:
        return;
    L69:
        return;
    L64:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r116 = this.f76746m;     // Catch: Exception -> L35
        if (r116 == null) goto L19;
        DataCenter r117 = this.f76747n;     // Catch: Exception -> L35
        r116.getShowFrom();     // Catch: Exception -> L35
        ILivePlayerClient r118 = r116.o(r117);     // Catch: Exception -> L35
    L20:
        if (r118 == null) goto L24;
        LivePlayerClientContext r119 = r118.context();     // Catch: Exception -> L35
        if (r119 == null) goto L24;
        String r120 = r119.getLastLayoutSei();     // Catch: Exception -> L35
    L25:
        DataCenter r121 = this.f76747n;     // Catch: Exception -> L35
        StringBuilder r122 = new StringBuilder("showFrom=");     // Catch: Exception -> L35
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r123 = this.f76746m;     // Catch: Exception -> L35
        if (r123 == null) goto L28;
        Integer r124 = Integer.valueOf(r123.getShowFrom());     // Catch: Exception -> L35
    L29:
        r122.append(r124);     // Catch: Exception -> L35
        r122.append(" initSeiAppData with lastLayoutSei ");     // Catch: Exception -> L35
        r122.append(r120);     // Catch: Exception -> L35
        MultiLinkLoadWidgetUtils.n(r121, "SeiHandlerV3", r122.toString());     // Catch: Exception -> L35
        if (r120 == null) goto L37;
        JSONObject r125 = new JSONObject(r120);     // Catch: Exception -> L35
        if (r125.has("app_data") == false) goto L37;
        String r126 = StringsKt.replace$default(JSONObjectProtectorUtils.getString(r125, "app_data"), "\\\\", "", false, 4, null);     // Catch: Exception -> L35
        d(com.bytedance.android.live.liveinteract.api.utils.j.a(new JSONObject(r126), r126));     // Catch: Exception -> L35
        goto L37
    L28:
        r124 = null;
    L24:
        r120 = null;
        goto L25
    L19:
        r118 = null;
    L35:
        e = move-exception;
        ALogger.e("SeiHandlerV3", "initSeiAppData error", e);
        goto L37
    L11:
        if (vm2.h.W().lastLayoutSei() == false) goto L13;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a b(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.j> r100 = this.f76736c;
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

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void d(SeiAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        List<SeiRegion> r101 = r100.getGrids();
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L6:
        if (r102 <= 0) goto L13;
        List<SeiRegion> r103 = r100.getGrids();
        if (r103 == null) goto L13;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        SeiRegion r105 = (SeiRegion) r104.next();
        r105.getInteractId();
        r105.isTalking();
    L13:
        this.f76741h.onNext(r100);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b
    public final void e(eg6.b r100) {
        eg6.b r101 = this.f76745l;
        if (r101 == null) goto L5;
        r101.s(this.f76744k);
    L5:
        this.f76745l = r100;
        if (this.f76743j == false) goto L10;
        if (r100 == null) goto L11;
        r100.h0(this.f76744k);
        return;
    L11:
        return;
    }

    public p(eg6.b r100, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r101, DataCenter r102) {
        this.f76745l = r100;
        this.f76746m = r101;
        this.f76747n = r102;
        this.f76735b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(0, 0, 0, 0);
        this.f76736c = new ArrayList();
        this.f76737d = new LinkedHashMap();
        this.f76738e = v2.f65430a.getValue().getSeiHandlerSamplingIntervalMs();
        this.f76740g = new AtomicLong(-1);
        this.f76741h = BehaviorSubject.create();
        this.f76742i = new CompositeDisposable();
        this.f76744k = new b(this);
    }
}
