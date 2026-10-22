package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

import bytekn.foundation.logger.a;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftPreloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<GiftPreloadResType, k<?>> f128195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CompositeDisposable f128196b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f128197c = false;

    static {
        HashMap<GiftPreloadResType, k<?>> r100 = new HashMap();
        f128195a = r100;
        f128196b = new CompositeDisposable();
        f128197c = ((Boolean) GiftPreloadSettingsKt.f128182f.getValue()).booleanValue();
        r100.put(GiftPreloadResType.ITEM_LIST_DATA, new m());
        r100.put(GiftPreloadResType.ICON_ANIMATOR_URI, new l());
    }

    public static Object a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        if (f128197c == true) goto L5;
        return null;
    L5:
        k<?> r101 = f128195a.get(r100.f128223b);
        if (r101 == null) goto L12;
        Object r102 = r101.d(r100);
        if ((r102 instanceof Object) == true) goto L11;
        return null;
    L11:
        return r102;
    L12:
        return null;
    }

    public static void b(final h r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        if (f128197c == false) goto L5;
        Collection<k<?>> r101 = f128195a.values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        if (((k) r104).c(r100) == false) goto L14;
        r102.add(r104);
        goto L14
    L18:
        Iterator r105 = r102.iterator();
    L20:
        if (r105.hasNext() == false) goto L22;
        final k r106 = (k) r105.next();
        RxUtilKt.c(Single.fromCallable(new g(new GiftPreloadManager$preload$$inlined$forEach$lambda$1(r106, r100))).subscribeOn(Schedulers.computation()).subscribe(), f128196b);
        goto L20
    L22:
        int r107 = a.f21803a;
        Objects.toString(r100);
        return;
    L5:
        if (GiftPreloadSettingsKt.b().e() == false) goto L30;
        final k<?> r108 = f128195a.get(GiftPreloadResType.GIFT_ICON);
        if (r108 != null) goto L9;
        return;
    L9:
        if (r108.c(r100) != true) goto L32;
        RxUtilKt.c(Single.fromCallable(new g(new GiftPreloadManager$preload$1(r108, r100))).subscribeOn(Schedulers.computation()).subscribe(), f128196b);
        return;
    L32:
        return;
    }

    public static void c(k r100) {
        Intrinsics.checkNotNullParameter(r100, "preloader");
        f128195a.put(r100.a(), r100);
    }

    public static void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "preloader");
        f128195a.remove(r100.a());
    }
}
