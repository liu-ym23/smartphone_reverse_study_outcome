package com.bytedance.android.livesdkapi.announcement;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceCalendarInfo;", "", DyPayConstant.KEY_START_TIME, "", "title", "", "descroption", "(JLjava/lang/String;Ljava/lang/String;)V", "getDescroption", "()Ljava/lang/String;", "getStartTime", "()J", "getTitle", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnounceCalendarInfo {
    private final String descroption;
    private final long startTime;
    private final String title;

    public final String getDescroption() {
        return this.descroption;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public AnnounceCalendarInfo(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "descroption");
        this.startTime = r100;
        this.title = r101;
        this.descroption = r102;
    }
}
