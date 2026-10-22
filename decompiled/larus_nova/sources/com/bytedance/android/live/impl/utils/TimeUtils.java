package com.bytedance.android.live.impl.utils;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class TimeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f69315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f69316b = null;

    static {
        f69315a = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        f69316b = LazyKt.lazy(TimeUtils$calendar$2.INSTANCE);
    }

    public static String b(long r100) {
        Date r101 = new Date(r100);     // Catch: Exception -> L4
        return f69315a.format(r101);
    L4:
        e = move-exception;
        boolean r102 = a.f69317a;
        a.b("LFM-FeatureManager", new TimeUtils$getDate$1(e), e);
        return "";
    }

    public static long c(String r100) {
        Intrinsics.checkNotNullParameter(r100, BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        Date r101 = f69315a.parse(r100);     // Catch: Exception -> L5
        Lazy r102 = f69316b;     // Catch: Exception -> L5
        ((Calendar) r102.getValue()).setTime(r101);     // Catch: Exception -> L5
        return ((Calendar) r102.getValue()).getTimeInMillis();
    L5:
        e = move-exception;
        boolean r103 = a.f69317a;
        a.b("LFM-FeatureManager", TimeUtils$getMsFromDay$1.INSTANCE, e);
        return System.currentTimeMillis();
    }

    public static long a(long r100, long r101) {
        return (r101 - r100) / ((long) BaseConstants.Time.DAY);
    }
}
