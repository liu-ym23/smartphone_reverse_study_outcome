package com.bytedance.android.live.revenue.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/common/TimeFormatters;", "", "", "MM_SS", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract enum TimeFormatters extends Enum<TimeFormatters> {
    public static final TimeFormatters MM_SS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimeFormatters[] f90809a = null;

    static {
        final String r100 = "MM_SS";
        final int r101 = 0;
        TimeFormatters r102 = new MM_SS(r100, r101);
        MM_SS = r102;
        f90809a = new TimeFormatters[]{r102};
    }

    public TimeFormatters() {
        throw null;
    }

    public static TimeFormatters valueOf(String r100) {
        return (TimeFormatters) r27.a.a(TimeFormatters.class, r100);
    }

    public static TimeFormatters[] values() {
        return (TimeFormatters[]) f90809a.clone();
    }

    public abstract /* synthetic */ String invoke(u0 r100);

    public TimeFormatters(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
