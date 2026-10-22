package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerStallMonitorConfig;", "", "stallReportFrequent", "", "(I)V", "getStallReportFrequent", "()I", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerStallMonitorConfig {

    @SerializedName("stall_report_frequent")
    private final int stallReportFrequent;

    public PlayerStallMonitorConfig() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final int getStallReportFrequent() {
        return this.stallReportFrequent;
    }

    public PlayerStallMonitorConfig(int r100) {
        this.stallReportFrequent = r100;
    }

    public /* synthetic */ PlayerStallMonitorConfig(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 10;
    L5:
        this(r100);
    }
}
