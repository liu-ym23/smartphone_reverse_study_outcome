package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Observable;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s0 {
    public static final long b(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$naturalDayDiff");
        Calendar r101 = Calendar.getInstance();
        e(r101);
        long r102 = r101.getTimeInMillis();
        Calendar r103 = Calendar.getInstance();
        r103.setTimeInMillis(r100.f91006a);
        e(r103);
        return (r102 - r103.getTimeInMillis()) / u0.f90998e;
    }

    public static final boolean c(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isToday");
        Calendar r101 = Calendar.getInstance();
        e(r101);
        long r102 = r101.getTimeInMillis();
        Calendar r103 = Calendar.getInstance();
        r103.add(5, 1);
        e(r103);
        long r104 = r103.getTimeInMillis();
        long r105 = r100.f91006a;
        if (r102 <= r105) goto L6;
    L8:
        return false;
    L6:
        if (r104 <= r105) goto L8;
        return true;
    }

    public static final void d(Calendar r100) {
        r100.set(11, 23);
        r100.set(12, 59);
        r100.set(13, 59);
    }

    public static final void e(Calendar r100) {
        r100.set(11, 0);
        r100.set(12, 0);
        r100.set(13, 0);
        r100.set(14, 0);
    }

    public static final Observable<Long> a(u0 r100, u0 r101) {
        Intrinsics.checkNotNullParameter(r100, "total");
        Intrinsics.checkNotNullParameter(r101, VideoThumbInfo.KEY_INTERVAL);
        return RxUtilKt.d(r100.f91006a, r101.f91006a);
    }
}
