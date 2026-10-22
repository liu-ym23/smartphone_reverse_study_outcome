package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListCacheRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.normal.utils.GiftImageFormat;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.keva_store.RevDataStoreKevaUtil;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.keva.Keva;
import com.bytedance.live.kmp.core.KmpEnv;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class d1 implements com.bytedance.android.scope.o, yz0.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f131499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f131501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f131502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.d0 f131503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f131504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f131505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f131506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f131507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f131508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final yz0.k f131509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final GiftListRepository f131510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GiftListCacheRepo f131511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AssetsService f131512n;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ArrayList<String> r100 = w12.b.f557895a;
        boolean r101 = ((Boolean) GiftImageFormat.f129798a.getValue()).booleanValue();
        String r102 = com.bytedance.android.livesdk.gift.platform.business.i.h().c0();
        String r103 = com.bytedance.android.livesdk.gift.platform.business.i.h().A2();
        w12.b.f557897c = r101;
        if (r102 == null) goto L5;
        w12.b.f557899e = r102;
    L5:
        if (r103 == null) goto L8;
        w12.b.f557900f = r103;
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (this.f131504f.isDisposed() == true) goto L6;
        this.f131504f.dispose();
    L6:
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().getEnable() == false) goto L18;
        long r100 = this.f131499a;
        if (r100 <= 0) goto L12;
        Keva r101 = (Keva) RevDataStoreKevaUtil.f130725a.getValue();
        if (r101 == null) goto L12;
        r101.storeLong("last_consume_time", r100);
    L12:
        long r102 = this.f131500b;
        if (r102 <= 0) goto L19;
        Keva r103 = (Keva) RevDataStoreKevaUtil.f130725a.getValue();
        if (r103 == null) goto L20;
        r103.storeLong("last_consume_fail_time", r102);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // yz0.m
    public final void i() {
        long r100 = System.currentTimeMillis();
        yz0.k r101 = this.f131509k;
        if (r101 == null) goto L6;
        r101.xc(r100);
    L6:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 1) goto L9;
        this.f131511m.f();
    L9:
        if (this.f131510l.f() != true) goto L11;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L18;
        if (this.f131503e.f() != 1) goto L20;
        d("onRoomReady");
    L20:
        KmpEnv r103 = KmpEnv.f255139a;
        if (KmpEnv.b() == false) goto L47;
        List<IToolbarComponentData> r104 = this.f131509k.getToolbarDataList();
        Boolean r105 = null;
        if (r104 == null) goto L37;
        Iterator<T> r106 = r104.iterator();
    L26:
        if (r106.hasNext() == false) goto L33;
        Object r107 = r106.next();
        if (((IToolbarComponentData) r107).getId() != 30) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == false) goto L26;
    L35:
        if (((IToolbarComponentData) r107) == null) goto L37;
        r105 = Boolean.TRUE;
        goto L37
    L30:
        r108 = false;
        goto L31
    L33:
        r107 = null;
    L37:
        if (r105 != null) goto L39;
    L40:
        d("DLite-onRoomReady");
        return;
    L39:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == true) goto L40;
        return;
    L47:
        return;
    L18:
        if (this.f131503e.g() != 1) goto L20;
        d("onRoomReady");
        goto L20
    L11:
        r102 = false;
        goto L13
    }

    @Override // yz0.m
    public final void onViewReady() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().e() == false) goto L8;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L8;
        GiftManagerKt.f130762z.getClass();
        GiftManagerKt.C();
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 2) goto L10;
        this.f131511m.f();
    L10:
        boolean r100 = true;
        if (this.f131510l.f() == true) goto L15;
        r100 = false;
    L15:
        if (r100 == true) goto L20;
        if (this.f131503e.f() != 2) goto L23;
        d("onViewReady");
    L23:
        if (this.f131503e.c() != 2) goto L26;
        f("GiftListRoomService-onViewReady");
        return;
    L26:
        return;
    L20:
        if (this.f131503e.g() != 2) goto L23;
        d("onViewReady");
        goto L23
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 4) goto L5;
        this.f131511m.f();
    L5:
        boolean r100 = true;
        if (this.f131510l.f() == true) goto L10;
        r100 = false;
    L10:
        if (r100 == true) goto L15;
        if (this.f131503e.f() != 4) goto L18;
        d("onWidgetLoaded");
    L18:
        if (this.f131503e.c() != 4) goto L21;
        f("GiftListRoomService-onWidgetLoaded");
        return;
    L21:
        return;
    L15:
        if (this.f131503e.g() != 4) goto L18;
        d("onWidgetLoaded");
        goto L18
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService] */
    @Override // yz0.m
    public final void x() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 3) goto L5;
        this.f131511m.f();
    L5:
        int r100 = 0;
        if (this.f131510l.f() != true) goto L8;
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == true) goto L15;
        if (this.f131503e.f() != 3) goto L39;
        d("onP0WidgetLoaded");
    L39:
        if (this.f131503e.c() != 3) goto L42;
        f("GiftListRoomService-onP0WidgetLoaded");
        return;
    L42:
        if (this.f131503e.c() != 5) goto L57;
        long r103 = this.f131503e.a();
        if (this.f131503e.e() == false) goto L58;
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        i12.e r105 = i12.o.b();
        if (r105 == null) goto L49;
        r102 = com.bytedance.android.scope.m.f163449e.d(r105, GiftDataStorageService.class);
    L49:
        ?? r106 = (GiftDataStorageService) r102;
        r104.element = r106;
        if (r106 == 0) goto L52;
        r100 = r106.f131276p;
    L52:
        if (r100 > 0) goto L59;
        this.f131508j = 1;
        Disposable r107 = Observable.timer(r103, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b1(this, r104));
        this.f131506h = r107;
        CompositeDisposable r108 = this.f131504f;
        Intrinsics.checkNotNull(r107);
        r108.add(r107);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L15:
        if (this.f131503e.g() != 3) goto L18;
        d("onP0WidgetLoaded");
        goto L39
    L18:
        if (this.f131503e.g() != 5) goto L39;
        if (this.f131501c == true) goto L39;
        if (this.f131503e.e() == false) goto L39;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L39;
        long r109 = this.f131503e.b();
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        i12.e r111 = i12.o.b();
        if (r111 == null) goto L30;
        Object r112 = com.bytedance.android.scope.m.f163449e.d(r111, GiftDataStorageService.class);
    L31:
        ?? r113 = (GiftDataStorageService) r112;
        r110.element = r113;
        if (r113 == 0) goto L34;
        int r114 = r113.f131276p;
    L35:
        if (r114 > 0) goto L39;
        this.f131507i = 1;
        Disposable r115 = Observable.timer(r109, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c1(this, r110));
        this.f131505g = r115;
        CompositeDisposable r116 = this.f131504f;
        Intrinsics.checkNotNull(r115);
        r116.add(r115);
        goto L39
    L34:
        r114 = 0;
        goto L35
    L30:
        r112 = null;
        goto L31
    L8:
        r101 = false;
        goto L9
    }

    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "traceFlag");
        IRoom r100 = this.f131509k.getRoom();
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = r100.getRoomLayout();
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("trace", r110);
        IRoomAuthStatus r112 = r100.getMRoomAuthStatus();
        if (r112 != null) goto L8;
    L10:
        r111.put("enable_gift", "0");
    L11:
        this.f131501c = true;
        long r102 = r100.getRoomId();
        boolean r103 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
        IBaseUser r113 = r100.getOwner();
        if (r113 == null) goto L15;
        Intrinsics.checkNotNullParameter(r113, "$this$secUidExt");
        String r114 = r113.getCastSecUid();
        if (r114 == null) goto L15;
    L16:
        GiftListRepo.h(null, r102, 2, r103, r114, 0, (int) r101, r111);
        return;
    L15:
        r114 = "";
        goto L16
    L8:
        if (r112.getEnableGift() != true) goto L10;
        r111.put("enable_gift", "1");
        goto L11
    }

    public final void d(String r100) {
        if (this.f131501c == false) goto L6;
        return;
    L6:
        if (this.f131503e.e() == true) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L11;
        return;
    L11:
        i12.e r101 = i12.o.b();
        if (r101 == null) goto L14;
        Object r102 = com.bytedance.android.scope.m.f163449e.d(r101, GiftDataStorageService.class);
    L15:
        GiftDataStorageService r103 = (GiftDataStorageService) r102;
        boolean r104 = false;
        if (r103 == null) goto L18;
        int r105 = r103.f131276p;
    L19:
        if (r105 <= 0) goto L22;
        return;
    L22:
        if (this.f131510l.f() != true) goto L25;
        r104 = true;
    L25:
        if (this.f131503e.d() == true) goto L31;
        long r106 = this.f131510l.f130571n & 1;
        if (r104 == false) goto L31;
        if (r106 != 1) goto L31;
        return;
    L31:
        this.f131501c = true;
        a(r100);
        return;
    L18:
        r105 = 0;
        goto L19
    L14:
        r102 = null;
        goto L15
    }

    public final void f(String r100) {
        if (this.f131503e.e() == true) goto L5;
        return;
    L5:
        yz0.k r101 = this.f131509k;
        Long r102 = null;
        if (r101 == null) goto L8;
        Boolean r103 = Boolean.valueOf(r101.isAnchor());
    L9:
        boolean r104 = r103.booleanValue();
        yz0.k r105 = this.f131509k;
        if (r105 == null) goto L14;
        IRoom r106 = r105.getRoom();
        if (r106 == null) goto L14;
        r102 = Long.valueOf(r106.getRoomId());
    L14:
        c(2, r104, r102.longValue(), r100);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public d1(yz0.k r100, GiftListRepository r101, GiftListCacheRepo r102, AssetsService r103) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "giftListRepository");
        Intrinsics.checkNotNullParameter(r102, "listGlobalCacheRepo");
        Intrinsics.checkNotNullParameter(r103, "assetsService");
        this.f131509k = r100;
        this.f131510l = r101;
        this.f131511m = r102;
        this.f131512n = r103;
        this.f131499a = -1;
        this.f131500b = -1;
        this.f131503e = (com.bytedance.android.livesdk.gift.configmodel.d0) com.bytedance.android.livesdk.gift.platform.core.h.H0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[84]);
        this.f131504f = new CompositeDisposable();
    }

    public final void c(int r100, boolean r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "trace");
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (r100 == 2) goto L8;
        this.f131512n.S0(r100, r101, String.valueOf(r102), r103);
        return;
    L8:
        if (this.f131502d == false) goto L10;
        return;
    L10:
        this.f131502d = true;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L13;
        return;
    L13:
        this.f131512n.S0(r100, r101, String.valueOf(r102), r103);
    }
}
