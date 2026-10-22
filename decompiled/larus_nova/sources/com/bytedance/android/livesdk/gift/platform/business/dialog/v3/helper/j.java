package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f127427a = null;

    public static final class a {
        public a() {
        }

        public static boolean a(int r100, long r101) {
            if (r100 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumDay.getValue()) goto L6;
            return s0.c(new u0(r101));
        L6:
            if (r100 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumWeek.getValue()) goto L14;
            Intrinsics.checkNotNullParameter(new u0(r101), "$this$isCurWeek");
            Calendar r102 = Calendar.getInstance();
            r102.setFirstDayOfWeek(2);
            r102.set(7, r102.getFirstDayOfWeek());
            s0.e(r102);
            long r103 = r102.getTimeInMillis();
            Calendar r104 = Calendar.getInstance();
            r104.setFirstDayOfWeek(2);
            r104.set(7, r104.getFirstDayOfWeek() + 6);
            s0.d(r104);
            long r105 = r104.getTimeInMillis();
            if (r103 <= r101) goto L11;
        L29:
            return false;
        L11:
            if (r105 <= r101) goto L29;
        L28:
            return true;
        L14:
            if (r100 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumMonth.getValue()) goto L22;
            Intrinsics.checkNotNullParameter(new u0(r101), "$this$isCurMonth");
            Calendar r106 = Calendar.getInstance();
            r106.set(r106.get(1), r106.get(2), 1);
            s0.e(r106);
            long r107 = r106.getTimeInMillis();
            Calendar r108 = Calendar.getInstance();
            r108.set(r108.get(1), r108.get(2), 1);
            r108.roll(5, -1);
            s0.d(r108);
            long r109 = r108.getTimeInMillis();
            if (r107 > r101) goto L29;
            if (r109 <= r101) goto L29;
        L22:
            if (r100 != IGiftExposureAnimInfo.FreqCtlIntervalEnum.FreqCtlIntervalEnumYear.getValue()) goto L29;
            Intrinsics.checkNotNullParameter(new u0(r101), "$this$isCurYear");
            Calendar r110 = Calendar.getInstance();
            r110.set(6, 1);
            s0.e(r110);
            long r111 = r110.getTimeInMillis();
            Calendar r112 = Calendar.getInstance();
            r112.set(6, 1);
            r112.roll(6, -1);
            s0.d(r112);
            long r113 = r112.getTimeInMillis();
            if (r111 > r101) goto L29;
            if (r113 <= r101) goto L29;
            goto L28
        }
    }

    static {
        f127427a = new a();
    }
}
