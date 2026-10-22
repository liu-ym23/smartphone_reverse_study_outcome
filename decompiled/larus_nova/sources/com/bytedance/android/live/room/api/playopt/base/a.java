package com.bytedance.android.live.room.api.playopt.base;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f99054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PropertyOwner<Boolean> f99055b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PropertyOwner f99056c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PropertyOwner<Boolean> f99057d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PropertyOwner f99058e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PropertyOwner<Boolean> f99059f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PropertyOwner f99060g = null;

    static {
        f99054a = Keva.getRepo("play_opt_store");
        long r100 = TopSpeedModeUtils.d().e();
        long r101 = BaseConstants.Time.DAY;
        PropertyOwner<Boolean> r102 = new PropertyOwner(Boolean.valueOf(a("top_speed_switch", r100 * r101)));
        f99055b = r102;
        f99056c = r102;
        PropertyOwner<Boolean> r103 = new PropertyOwner(Boolean.valueOf(a("picture_quality_switch", TopSpeedModeUtils.d().e() * r101)));
        f99057d = r103;
        f99058e = r103;
        PropertyOwner<Boolean> r104 = new PropertyOwner(Boolean.valueOf(a("base_function_switch", TopSpeedModeUtils.d().e() * r101)));
        f99059f = r104;
        f99060g = r104;
    }

    public static void b(boolean r100) {
        f99055b.a(Boolean.valueOf(r100));
        Keva r101 = f99054a;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append(',');
        r102.append(System.currentTimeMillis());
        r101.storeString("top_speed_switch", r102.toString());
        TopSpeedModeManager.f99061l.e();
    }

    public static boolean a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "switchKey");
        List r102 = StringsKt.split$default(f99054a.getString(r100, ""), new String[]{","}, false, 0, 6, null);
        boolean r103 = false;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.size() < 2) goto L7;
        boolean r104 = true;
    L8:
        Long r105 = null;
        if (r104 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L42;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(Boolean.parseBoolean((String) ListProtector.get(r102, 0))));     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r107) == false) goto L21;
        r107 = null;
    L21:
        if (Intrinsics.areEqual((Boolean) r107, Boolean.TRUE) == false) goto L43;
        Long r108 = StringsKt.toLongOrNull((String) ListProtector.get(r102, 1));
        if (r108 == null) goto L38;
        if (r108.longValue() <= 0) goto L27;
        boolean r109 = true;
    L28:
        if (r109 == false) goto L30;
        r105 = r108;
    L30:
        if (r105 == null) goto L38;
        if (Long.valueOf(System.currentTimeMillis() - r105.longValue()).longValue() < r101) goto L34;
        boolean r110 = true;
    L35:
        if (r110 != true) goto L38;
        r103 = true;
        goto L38
    L34:
        r110 = false;
        goto L35
    L27:
        r109 = false;
    L38:
        return !r103;
    L43:
        return false;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L42:
        return false;
    L7:
        r104 = false;
        goto L8
    }
}
