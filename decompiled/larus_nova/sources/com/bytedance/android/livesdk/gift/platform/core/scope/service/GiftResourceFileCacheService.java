package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftResourceFileCacheService implements com.bytedance.android.scope.o, dy0.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f131393p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f131394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f131395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f131396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m97.a f131397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f131398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f131399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f131400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f131401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f131402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f131403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f131404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f131405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f131406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f131407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f131408o;

    public static final class a {
    }

    static {
    }

    public final uy0.b g() {
        return (uy0.b) this.f131408o.getValue();
    }

    public final com.bytedance.android.livesdk.gift.configmodel.f h() {
        return (com.bytedance.android.livesdk.gift.configmodel.f) this.f131400g.getValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final String f() {
        String r100 = this.f131407n;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L21;
        if (com.bytedance.android.livesdk.gift.platform.business.i.b().getEnable() == false) goto L13;
        this.f131407n = new AssetsFileCacheFactory().c();
        goto L21
    L13:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r102 = GiftResourceManagerFactory.a();
        if (r102 == null) goto L18;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r103 = r102.a();
        if (r103 == null) goto L18;
        String r104 = r103.a();
    L19:
        this.f131407n = r104;
    L18:
        r104 = null;
    L21:
        return this.f131407n;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        m97.a r100 = this.f131397d;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public GiftResourceFileCacheService() {
        this.f131394a = "keva_delete";
        this.f131395b = "";
        this.f131396c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f131400g = LazyKt.lazy(GiftResourceFileCacheService$findOprConfig$2.INSTANCE);
        this.f131401h = -1;
        int r100 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f131406m = BehaviorSubject.createDefault(Boolean.FALSE);
        this.f131408o = LazyKt.lazy(GiftResourceFileCacheService$fileService$2.INSTANCE);
    }

    public final void x() {
        if (h().getEnable() == true) goto L7;
        jy0.b.c("GiftAssetClean", "setting未开启", null, 4);
        this.f131406m.onNext(Boolean.TRUE);
        return;
    L7:
        if (this.f131398e == false) goto L9;
        return;
    L9:
        boolean r100 = true;
        this.f131398e = true;
        StringBuilder r101 = new StringBuilder();
        int r102 = uy0.a.f552061a;
        String r103 = f();
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        r101.append(uy0.a.a(r103));
        r101.append("zip");
        String r104 = r101.toString();
        jy0.b.a("GiftAssetClean", "makeDownloadDir, " + r104);
        if (g().Y4(r104) == true) goto L15;
        boolean r105 = ((uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class)).k3(r104);
    L16:
        if (r105 == false) goto L19;
        this.f131395b = r104;
    L19:
        if (h().o3() == false) goto L31;
        String r106 = f();
        if (r106 != null) goto L23;
    L26:
        if (r100 == true) goto L31;
        if (g().Y4(r106) == false) goto L31;
        com.bytedance.android.live.revenue.platform.file.impl.a r107 = g().H2(r106, new h2(this));
        r107.b();
        Unit r108 = Unit.INSTANCE;
        this.f131397d = r107;
        goto L31
    L23:
        if (r106.length() == 0) goto L26;
        r100 = false;
    L31:
        int r109 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r110 = Single.create(new e2(this));
        int r111 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        r110.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f2(this), g2.f131568a);
        return;
    L15:
        this.f131395b = r104;
        r105 = false;
        goto L16
    }

    public final String a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        StringBuilder r101 = new StringBuilder();
        int r102 = uy0.a.f552061a;
        r101.append(uy0.a.a(this.f131395b));
        r101.append(r100.f129101k);
        return r101.toString();
    }
}
