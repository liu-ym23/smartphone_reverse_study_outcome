package com.bytedance.android.livehostapi.business.depend.share;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/LiveFansDataSource;", "", "sourceType", "", "highPriorityData", "", "Lcom/bytedance/android/livehostapi/business/depend/share/LiveFansContactData;", "lowPriorityData", "(ILjava/util/List;Ljava/util/List;)V", "getHighPriorityData", "()Ljava/util/List;", "getLowPriorityData", "getSourceType", "()I", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFansDataSource {
    private final List<LiveFansContactData> highPriorityData;
    private final List<LiveFansContactData> lowPriorityData;
    private final int sourceType;

    public final List<LiveFansContactData> getHighPriorityData() {
        return this.highPriorityData;
    }

    public final List<LiveFansContactData> getLowPriorityData() {
        return this.lowPriorityData;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public LiveFansDataSource(int r100, List<LiveFansContactData> r101, List<LiveFansContactData> r102) {
        Intrinsics.checkNotNullParameter(r101, "highPriorityData");
        this.sourceType = r100;
        this.highPriorityData = r101;
        this.lowPriorityData = r102;
    }

    public /* synthetic */ LiveFansDataSource(int r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
