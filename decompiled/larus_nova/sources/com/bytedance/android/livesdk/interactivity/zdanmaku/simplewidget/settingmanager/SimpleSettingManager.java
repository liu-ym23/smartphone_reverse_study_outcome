package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.bk0;
import com.bytedance.android.livesdk.config.hk0;
import com.bytedance.android.livesdk.config.nk0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import p22.n;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class SimpleSettingManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f141793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f141794b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f141795c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f141796d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Disposable f141797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f141798f = null;

    public SimpleSettingManager() {
    }

    static {
        f141793a = new com.bytedance.android.livesdk.sharedpref.e("live_user_operate_base_simple_danmaku_setting_state", 0);
        f141794b = new com.bytedance.android.livesdk.sharedpref.e("live_danmaku_checked_old_version", Boolean.FALSE);
        f141795c = LazyKt.lazy(SimpleSettingManager$defaultSettingBeforeAB$2.INSTANCE);
        f141796d = LazyKt.lazy(SimpleSettingManager$defaultSettingWithAB$2.INSTANCE);
        f141798f = new AtomicBoolean(false);
    }

    public static o b() {
        int r100 = -1;
        if (hk0.f120384a.getValue().booleanValue() == false) goto L80;
        long r101 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e<o> r102 = l42.a.f507339z;
        o r103 = r102.getValue();
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = f141794b;
        if (r104.getValue().booleanValue() == true) goto L12;
        if (r103 != null) goto L8;
    L11:
        com.bytedance.android.livesdk.sharedpref.f.d(r104, Boolean.TRUE);
        goto L12
    L8:
        if (d(r103, (o) f141795c.getValue()) == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = f141793a;
        r105.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r105, 2);
        i.d("check old version, is same, set to un operated");
        goto L11
    L10:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r106 = f141793a;
        r106.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r106, 1);
        i.d("check old version, is not same, set to operated");
    L12:
        Boolean r107 = l42.a.A.getValue();
        Integer r108 = f141793a.getValue();
        if (r108 != null) goto L16;
    L18:
        boolean r110 = false;
    L19:
        if (r108 != null) goto L22;
    L23:
        if (r108 != null) goto L26;
    L28:
        boolean r109 = false;
    L30:
        int r111 = i.f141754a;
        i.d("isUserOperated: " + r107 + ", isUserOperatedBaseSettingState: " + r108 + ", spSetting: " + r103);
        if (r103 != null) goto L33;
        r103 = (o) f141796d.getValue();
    L41:
        nk0 r112 = nk0.f120841a;
        if (r112.getValue().booleanValue() == true) goto L49;
        if (r107.booleanValue() == true) goto L49;
        if (r103.f() == false) goto L49;
        r103.h(false);
    L49:
        if (r107.booleanValue() == false) goto L52;
    L78:
        i.d("get simple setting new done in " + (System.currentTimeMillis() - r101) + "ms");
        return r103;
    L52:
        if (r112.getValue().booleanValue() == false) goto L78;
        LivePreviewDanmakuConfig r113 = LivePreviewDanmakuConfig.Companion.getConfig();
        IMiddlewareUserService r114 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r114 == null) goto L61;
        com.bytedance.android.livesdk.user.e r115 = r114.user();
        if (r115 == null) goto L61;
        IBaseUser r116 = r115.b();
        if (r116 == null) goto L61;
        r100 = r116.getAgeRange();
    L61:
        float r117 = z0.b(false);
        i.d("currentUserAgeLevel: " + r100 + ", deviceScore: " + r117 + ", config: " + r113.getDebugString());
        if (bk0.f119876a.getValue().booleanValue() == true) goto L64;
        if (r100 >= 0) goto L73;
    L77:
        i.d("result setting: " + r103);
        f141798f.set(true);
        goto L78
    L73:
        if (r100 > r113.getAgeLevel()) goto L77;
        if (r117 <= r113.getDeviceScore()) goto L77;
        r103.h(true);
        goto L77
    L64:
        if (r113.getAgeLevelList().contains(Integer.valueOf(r100)) == true) goto L66;
    L70:
        r103.h(false);
        goto L77
    L66:
        if (r117 <= r113.getFromDeviceScore()) goto L70;
        if (r117 > r113.getToDeviceScore()) goto L70;
        r103.h(true);
        goto L77
    L33:
        if (r110 == false) goto L35;
        i.d("get setting, is user operated base setting");
        goto L41
    L35:
        if (r109 == false) goto L40;
        Lazy r118 = f141796d;
        if (d(r103, (o) r118.getValue()) == true) goto L39;
        o r119 = (o) r118.getValue();
        r103.j(r119.d());
        r103.k(r119.e());
        r103.i(r119.c());
        r103.g(r119.b());
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
    L39:
        i.d("get setting, is user un operated base setting, new setting: " + r103);
        goto L41
    L40:
        i.b("get setting else, no reach here");
        goto L41
    L26:
        if (r108.intValue() != 0) goto L28;
    L29:
        r109 = true;
        goto L30
    L22:
        if (r108.intValue() == 2) goto L29;
    L16:
        if (r108.intValue() != 1) goto L18;
        r110 = true;
        goto L19
    L80:
        Boolean r120 = l42.a.A.getValue();
        o r121 = l42.a.f507338y.getValue();
        nk0 r122 = nk0.f120841a;
        if (r122.getValue().booleanValue() == true) goto L88;
        if (r120.booleanValue() == true) goto L88;
        if (r121.f() == false) goto L88;
        r121.h(false);
    L88:
        if (r120.booleanValue() == false) goto L90;
    L110:
        return r121;
    L90:
        if (r121.f() == true) goto L110;
        if (r122.getValue().booleanValue() == true) goto L95;
        return r121;
    L95:
        LivePreviewDanmakuConfig r123 = LivePreviewDanmakuConfig.Companion.getConfig();
        IMiddlewareUserService r124 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r124 == null) goto L102;
        com.bytedance.android.livesdk.user.e r125 = r124.user();
        if (r125 == null) goto L102;
        IBaseUser r126 = r125.b();
        if (r126 == null) goto L102;
        r100 = r126.getAgeRange();
    L102:
        float r127 = z0.b(false);
        if (r100 >= 0) goto L105;
    L109:
        f141798f.set(true);
        goto L110
    L105:
        if (r100 > r123.getAgeLevel()) goto L109;
        if (r127 <= r123.getDeviceScore()) goto L109;
        r121.h(true);
        goto L109
    }

    public static o c() {
        AtomicBoolean r100 = f141798f;
        if (r100.get() == false) goto L6;
        i.d("get simple setting async, has prefetched");
        return b();
    L6:
        long r101 = System.currentTimeMillis();
        if (r100.get() == true) goto L15;
        Disposable r102 = f141797e;
        if (r102 != null) goto L12;
    L14:
        f141797e = Single.fromCallable(d.f141802a).subscribeOn(Schedulers.io()).subscribe(e.f141803a, f.f141804a);
        goto L15
    L12:
        if (r102.isDisposed() == true) goto L14;
    L15:
        o r103 = o.a((o) f141796d.getValue());
        int r104 = i.f141754a;
        i.d("get simple setting async done in " + (System.currentTimeMillis() - r101) + "ms");
        return r103;
    }

    public static void e(o r100) {
        xs2.b.a().post(new b(r100));
    }

    public static n a(o r110, int r111) {
        int r100 = UtilityKotlinExtentionsKt.i(60);
        Intrinsics.checkNotNullParameter(r110, "danmakuSetting");
        boolean r101 = r110.f();
        int r102 = r110.d();
        float r103 = r110.c();
        if (r103 != 0.8f) goto L7;
        float r104 = UtilityKotlinExtentionsKt.h(17);
    L5:
        float r105 = r104;
        if (r110.c() >= 1.0f) goto L22;
        int r106 = UtilityKotlinExtentionsKt.i(6);
    L24:
        return new n(r101, r111, r102, r105, r106, r100, (UtilityKotlinExtentionsKt.h(52) * r110.e()) / 1000.0f, r110.b(), r110.c() * UtilityKotlinExtentionsKt.h(15.0f));
    L22:
        r106 = UtilityKotlinExtentionsKt.i(4);
        goto L24
    L7:
        if (r103 != 0.9f) goto L10;
        r104 = UtilityKotlinExtentionsKt.h(12);
        goto L5
    L10:
        if (r103 != 1.0f) goto L13;
        r104 = UtilityKotlinExtentionsKt.h(21);
        goto L5
    L13:
        if (r103 != 1.2f) goto L16;
        r104 = UtilityKotlinExtentionsKt.h(24);
        goto L5
    L16:
        if (r103 != 1.4f) goto L18;
        r104 = UtilityKotlinExtentionsKt.h(29);
        goto L5
    L18:
        r104 = UtilityKotlinExtentionsKt.h(21);
        goto L5
    }

    public static boolean d(o r100, o r101) {
        if (r100.d() == r101.d()) goto L5;
    L11:
        return false;
    L5:
        if (r100.e() != r101.e()) goto L11;
        if (r100.c() != r101.c()) goto L11;
        if (r100.b() != r101.b()) goto L11;
        return true;
    }

    public static void f(o r100, ChangeSettingSource r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r101.isBaseSetting() == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = f141793a;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, 1);
    L6:
        if (r101 != ChangeSettingSource.SETTING_PANEL_RESET) goto L8;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = f141793a;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, 2);
    L8:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = l42.a.A;
        Boolean r105 = Boolean.TRUE;
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
        com.bytedance.android.livesdk.sharedpref.e<o> r106 = l42.a.f507339z;
        r106.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r106, r100);
    }
}
