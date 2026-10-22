package com.bytedance.android.live.room.api.playopt.topspeed;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.playopt.topspeed.log.TopSpeedTrace;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import com.bytedance.android.livesdkapi.service.IPerfBalanceServiceKt;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l61.b;

/* JADX INFO: loaded from: classes47.dex */
public final class TopSpeedModeManager {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TopSpeedModeManager f99061l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<Boolean> f99062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f99063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f99064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f99065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<Integer> f99066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner<Integer> f99067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner<Boolean> f99068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner<Boolean> f99069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, List<g61.a>> f99070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PropertyOwner<Integer> f99071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PropertyOwner<String> f99072k;

    public static final class a {
    }

    public final IPerfBalanceService b() {
        return (IPerfBalanceService) this.f99063b.getValue();
    }

    static {
        f99061l = new TopSpeedModeManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a() {
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99056c.f64752a).booleanValue() == true) goto L5;
    L18:
        return 0;
    L5:
        if (TopSpeedModeUtils.a() == false) goto L18;
        PropertyOwner r100 = com.bytedance.android.live.room.api.playopt.base.a.f99058e;
        if (((Boolean) r100.f64752a).booleanValue() == false) goto L12;
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99060g.f64752a).booleanValue() == false) goto L12;
        return 4;
    L12:
        if (((Boolean) r100.f64752a).booleanValue() == false) goto L15;
        return 3;
    L15:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99060g.f64752a).booleanValue() == false) goto L17;
        return 2;
    L17:
        return 1;
    }

    public TopSpeedModeManager() {
        new CompositeDisposable();
        Boolean r100 = Boolean.FALSE;
        this.f99062a = new e("is_close_by_user", r100);
        this.f99063b = LazyKt.lazy(TopSpeedModeManager$balanceService$2.INSTANCE);
        this.f99064c = new LinkedHashSet();
        this.f99066e = new PropertyOwner(0);
        this.f99067f = new PropertyOwner(0);
        this.f99068g = new PropertyOwner(r100);
        this.f99069h = new PropertyOwner(r100);
        this.f99070i = new HashMap();
        this.f99071j = new PropertyOwner(0);
        this.f99072k = new PropertyOwner("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        if (TopSpeedModeUtils.a() == true) goto L5;
        return;
    L5:
        this.f99064c.clear();
        if (TopSpeedModeUtils.d().j() == true) goto L8;
    L15:
        this.f99065d = a();
        IPerfBalanceService r100 = b();
        if (r100 == null) goto L18;
        r100.updateFastModePermission(this.f99065d);
    L18:
        TopSpeedTrace.f99079b.a("TopSpeedAuthCode init update:::  code :  " + this.f99065d);
        IPerfBalanceService r101 = b();
        if (r101 == null) goto L21;
        r101.subscribePerfCode(new TopSpeedModeManager$init$1(this));
    L21:
        IPerfBalanceService r102 = b();
        if (r102 == null) goto L24;
        r102.subscribeProcess(new TopSpeedModeManager$init$2(this));
    L24:
        IPerfBalanceService r103 = b();
        if (r103 == null) goto L27;
        r103.subscribeNotify(new TopSpeedModeManager$init$3(this));
    L27:
        IPerfBalanceService r104 = b();
        if (r104 == null) goto L31;
        r104.subscribeUserSceneChanged(new TopSpeedModeManager$init$4(this));
        return;
    L31:
        return;
    L8:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99056c.f64752a).booleanValue() == true) goto L15;
        if (TopSpeedModeUtils.d().h() == true) goto L12;
        com.bytedance.android.live.room.api.playopt.base.a.b(true);
        goto L15
    L12:
        if (this.f99062a.getValue().booleanValue() == true) goto L15;
        com.bytedance.android.live.room.api.playopt.base.a.b(true);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        int r100 = a();
        if (r100 == this.f99065d) goto L14;
        this.f99065d = r100;
        IPerfBalanceService r101 = b();
        if (r101 == null) goto L8;
        r101.updateFastModePermission(this.f99065d);
    L8:
        if (this.f99065d != 0) goto L10;
    L11:
        this.f99064c.clear();
    L12:
        TopSpeedTrace.f99079b.a("更新用户授权:::  " + this.f99065d);
        return;
    L10:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99060g.f64752a).booleanValue() == false) goto L12;
    }

    public final void d(b r100, g61.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "listener");
        String r102 = IPerfBalanceServiceKt.PREFIX_RESOURCE + r100.getKey();
        if (this.f99070i.containsKey(r102) == false) goto L8;
        List<g61.a> r103 = this.f99070i.get(r102);
        if (r103 == null) goto L7;
        r103.add(r101);
    L7:
        ALogger.i("LiveTopSpeedLog", "the scene " + r102 + " add listener");
        return;
    L8:
        this.f99070i.put(r102, CollectionsKt.mutableListOf(new g61.a[]{r101}));
        ALogger.i("LiveTopSpeedLog", "the scene " + r102 + " register");
        IPerfBalanceService r104 = b();
        if (r104 == null) goto L13;
        r104.registerAtomicAbility(r102, "community", new com.bytedance.android.live.room.api.playopt.topspeed.a(r102));
        return;
    }
}
