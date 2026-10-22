package com.bytedance.android.livesdk.quitroom.interceptors;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class AbsNewQuitRoomDialogFrequencyController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f156900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f156901b;

    public static boolean a(long r100) {
        long r101 = AbsNewQuitRoomDialogFrequencyController$isToday$1.INSTANCE.invoke(r100);
        long r102 = TimeUnit.DAYS.toMillis(1) + r101;
        long r103 = Calendar.getInstance().getTimeInMillis();
        if (r101 <= r103) goto L6;
    L8:
        return false;
    L6:
        if (r102 <= r103) goto L8;
        return true;
    }

    public AbsNewQuitRoomDialogFrequencyController(int r100, NewQuitDialogShowFrequencyInterceptor$impl$2.a r101) {
        Intrinsics.checkNotNullParameter(r101, "callTimeHolder");
        this.f156900a = r100;
        this.f156901b = r101;
    }
}
