package com.bytedance.android.livesdk.dislike.tip;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.keva.Keva;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static Keva e() {
        return Keva.getRepo("live_optimize_recommend_tip");
    }

    public static String f() {
        Date r100 = new Date();
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(r100);
    }

    public static String a() {
        return e().getString("key_optimize_recommend_use_last_date", "");
    }

    public static long b() {
        String r100 = a();
        if (TextUtils.equals(r100, "") == false) goto L7;
        e().storeString("key_optimize_recommend_use_last_date", f());
        return 0;
    L7:
        return g(r100, f());
    }

    @JvmStatic
    public static final String c() {
        return e().getString("key_optimize_recommend_tip_show_last_date", "");
    }

    @JvmStatic
    public static final long d() {
        String r100 = c();
        if (TextUtils.equals(r100, "") == false) goto L7;
        return Long.MAX_VALUE;
    L7:
        return g(r100, f());
    }

    static {
    }

    public static Date h(String r100) {
        Object r101 = null;
        if (r100 != null) goto L18;
        return null;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(r100));     // Catch: Throwable -> L7
    L9:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        b0.o().getClass();
        g.e("LiveOptimizeRecommendTipKeva", r104);
    L13:
        if (Result.m9455isFailureimpl(r103) == true) goto L17;
        r101 = r103;
    L17:
        return (Date) r101;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static long g(String r100, String r101) {
        Date r102 = h(r100);
        Date r103 = h(r101);
        if (r102 == null) goto L10;
        if (r103 == null) goto L12;
        long r104 = r103.getTime() - r102.getTime();
        TimeUnit r105 = TimeUnit.DAYS;
        if (r104 > 0) goto L9;
        return 0;
    L9:
        return r105.convert(r104, TimeUnit.MILLISECONDS);
    L12:
        return 0;
    L10:
        return 0;
    }
}
