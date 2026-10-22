package com.bytedance.android.livesdk.quitroom.interceptors;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"dayStart", "", "time", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class AbsNewQuitRoomDialogFrequencyController$isToday$1 extends Lambda implements Function1<Long, Long> {
    public static final AbsNewQuitRoomDialogFrequencyController$isToday$1 INSTANCE = null;

    static {
        INSTANCE = new AbsNewQuitRoomDialogFrequencyController$isToday$1();
    }

    public AbsNewQuitRoomDialogFrequencyController$isToday$1() {
        super(1);
    }

    public final long invoke(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        r101.set(10, 0);
        r101.set(9, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        r101.set(14, 0);
        return r101.getTimeInMillis();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Long r100) {
        return Long.valueOf(invoke(r100.longValue()));
    }
}
