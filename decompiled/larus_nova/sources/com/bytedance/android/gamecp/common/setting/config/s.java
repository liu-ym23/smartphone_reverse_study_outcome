package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/s;", "", "", "start_limit_download_rate", "Z", "getStart_limit_download_rate", "()Z", "", "check_performance_interval", "J", "getCheck_performance_interval", "()J", "default_rate_under_good_net", "getDefault_rate_under_good_net", "default_rate_under_bad_net", "getDefault_rate_under_bad_net", "", "fluctuate_count_max", "I", "getFluctuate_count_max", "()I", "", "up_ratio", FaceService.girlLabel, "getUp_ratio", "()F", "down_ratio", "getDown_ratio", "max_block_ratio", "getMax_block_ratio", "experimentMode", "getExperimentMode", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("check_performance_interval")
    private final long check_performance_interval;

    @SerializedName("default_rate_under_bad_net")
    private final long default_rate_under_bad_net;

    @SerializedName("default_rate_under_good_net")
    private final long default_rate_under_good_net;

    @SerializedName("down_ratio")
    private final float down_ratio;

    @SerializedName("experiment_mode")
    private final int experimentMode;

    @SerializedName("fluctuate_count_max")
    private final int fluctuate_count_max;

    @SerializedName("max_block_ratio")
    private final float max_block_ratio;

    @SerializedName("start_limit_download_rate")
    private final boolean start_limit_download_rate;

    @SerializedName("up_ratio")
    private final float up_ratio;

    public s() {
        this.start_limit_download_rate = false;
        this.check_performance_interval = 2500;
        this.default_rate_under_good_net = 1500000;
        this.default_rate_under_bad_net = 500000;
        this.fluctuate_count_max = 3;
        this.up_ratio = 1.2f;
        this.down_ratio = 0.7f;
        this.max_block_ratio = 0.05f;
        this.experimentMode = 0;
    }
}
