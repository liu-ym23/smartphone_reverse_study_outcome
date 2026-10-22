package com.bytedance.android.ec.core.imagex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"duration", "", DyPayConstant.KEY_START_TIME, "endTime", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1 extends Lambda implements Function2<Long, Long, Long> {
    public static final FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1 INSTANCE = null;

    static {
        INSTANCE = new FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1();
    }

    public FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1() {
        super(2);
    }

    public final long invoke(long r100, long r101) {
        if (r100 > 0) goto L5;
    L7:
        return -1;
    L5:
        if (r101 < r100) goto L7;
        return r101 - r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(Long r100, Long r101) {
        return Long.valueOf(invoke(r100.longValue(), r101.longValue()));
    }
}
