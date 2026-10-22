package com.bytedance.android.live.profit.scoreboard.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00060\u0007j\u0002`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/r;", "", "", "isCreator", "Z", "c", "()Z", "", "Lcom/bytedance/android/livesdk/utils/TimeSpanSec;", "displayTimeAfterFinish", "J", "b", "()J", "Lcom/bytedance/android/livesdk/utils/TimestampSec;", "actualFinishTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("actual_finish_time")
    private final long actualFinishTime;

    @SerializedName("display_time_after_finish")
    private final long displayTimeAfterFinish;

    @SerializedName("is_creator")
    private final boolean isCreator;

    public r() {
        this(false, 7);
    }

    public final long a() {
        return this.actualFinishTime;
    }

    public final long b() {
        return this.displayTimeAfterFinish;
    }

    public final boolean c() {
        return this.isCreator;
    }

    public r(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this.isCreator = r100;
        this.displayTimeAfterFinish = 0;
        this.actualFinishTime = 0;
    }
}
