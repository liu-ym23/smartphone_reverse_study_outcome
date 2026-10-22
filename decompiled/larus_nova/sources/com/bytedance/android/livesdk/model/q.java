package com.bytedance.android.livesdk.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/model/q;", "", "", "", "delayIntervalList", "Ljava/util/List;", "getDelayIntervalList", "()Ljava/util/List;", "setDelayIntervalList", "(Ljava/util/List;)V", "", "retryableCodes", "getRetryableCodes", "setRetryableCodes", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("delay_second_list")
    private List<Long> delayIntervalList;

    @SerializedName("retryable_codes")
    private List<Integer> retryableCodes;

    public q() {
    }

    public final boolean a(Integer r100) {
        if (r100 == null) goto L8;
        r100.intValue();
        List<Integer> r101 = this.retryableCodes;
        if (r101 != null) goto L7;
        r101 = CollectionsKt.emptyList();
    L7:
        return r101.contains(r100);
    L8:
        return false;
    }

    public final long b(int r100) {
        List<Long> r101 = this.delayIntervalList;
        if (r101 != null) goto L6;
        return -1;
    L6:
        if (r100 < r101.size()) goto L8;
        return -1;
    L8:
        return ((Number) ListProtector.get(r101, r100)).longValue();
    }

    public final boolean c(int r100) {
        List<Long> r101 = this.delayIntervalList;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 >= r101.size()) goto L10;
        return false;
    L10:
        return true;
    }
}
