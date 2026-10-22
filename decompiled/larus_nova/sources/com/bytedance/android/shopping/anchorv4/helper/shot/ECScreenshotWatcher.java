package com.bytedance.android.shopping.anchorv4.helper.shot;

import android.app.Activity;
import android.os.Build;
import com.bytedance.common.utility.DeviceUtils;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class ECScreenshotWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f166975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f166976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f166977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f166978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Activity f166979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f166980f;

    public static final class a {
    }

    static {
    }

    public ECScreenshotWatcher(Activity r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f166979e = r100;
        this.f166980f = r101;
        this.f166975a = LazyKt.lazy(ECScreenshotWatcher$checker$2.INSTANCE);
        this.f166976b = LazyKt.lazy(new ECScreenshotWatcher$internalObserver$2(this));
        this.f166977c = LazyKt.lazy(new ECScreenshotWatcher$externalObserver$2(this));
        this.f166978d = -1;
    }

    public final void a(long r100, String r110) {
        com.bytedance.android.shopping.anchorv4.helper.shot.a r101 = (com.bytedance.android.shopping.anchorv4.helper.shot.a) this.f166975a.getValue();
        long r102 = this.f166978d;
        r101.getClass();
        boolean r103 = false;
        if (r102 < 0) goto L48;
        long r104 = r100 * ((long) 1000);
        if (r102 > r104) goto L48;
        if ((System.currentTimeMillis() - r104) > 10000) goto L48;
        if (r110 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L48;
        if (r101.f166983a.contains(r110) == false) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == true) goto L48;
        Locale r107 = Locale.ROOT;
        if (r110 == null) goto L59;
        String r108 = r110.toLowerCase(r107);
        String[] r109 = com.bytedance.android.shopping.anchorv4.helper.shot.a.f166981b;
        int r111 = r109.length;
        int r112 = 0;
    L30:
        if (r112 >= r111) goto L35;
        if (StringsKt.contains$default(r108, r109[r112], false, 2, null) == true) goto L33;
        r112 = r112 + 1;
        goto L30
    L33:
        boolean r113 = true;
    L36:
        if (r113 == false) goto L39;
    L46:
        r103 = true;
        goto L48
    L39:
        if (DeviceUtils.isHuawei() == false) goto L48;
        if (StringsKt.contains$default(r108, "/dcim/camera/", false, 2, null) == false) goto L48;
        String[] r114 = com.bytedance.android.shopping.anchorv4.helper.shot.a.f166982c;
        int r115 = r114.length;
        int r116 = 0;
    L43:
        if (r116 >= r115) goto L48;
        if (StringsKt.contains$default(r108, r114[r116], false, 2, null) == true) goto L46;
        r116 = r116 + 1;
        goto L43
    L35:
        r113 = false;
        goto L36
    L59:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L23:
        r101.f166983a.add(r110);
        r106 = false;
        goto L24
    L14:
        if (r110.length() == 0) goto L17;
        r105 = false;
    L48:
        if (r103 == true) goto L50;
        return;
    L50:
        if (Build.VERSION.SDK_INT >= 34) goto L54;
        e r117 = this.f166980f;
        if (r117 == null) goto L54;
        r117.onChange();
    L54:
        e r118 = this.f166980f;
        if (r118 == null) goto L65;
        r118.a(r110);
        return;
    }
}
