package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/z;", "", "", "aheadAntiReentryEnable", "Z", "getAheadAntiReentryEnable", "()Z", "setAheadAntiReentryEnable", "(Z)V", "", "aheadAntiReentryDuration", "J", "getAheadAntiReentryDuration", "()J", "setAheadAntiReentryDuration", "(J)V", "lockAheadActOrientation", "getLockAheadActOrientation", "setLockAheadActOrientation", "aheadActNextResumeFinish", "getAheadActNextResumeFinish", "setAheadActNextResumeFinish", "aheadInitActLaunchTimeout", "getAheadInitActLaunchTimeout", "setAheadInitActLaunchTimeout", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("ahead_act_next_resume_finish")
    private boolean aheadActNextResumeFinish;

    @SerializedName("anti_reentry_check_duration")
    private long aheadAntiReentryDuration;

    @SerializedName("ahead_reentry_check")
    private boolean aheadAntiReentryEnable;

    @SerializedName("ahead_init_act_launch_timeout")
    private long aheadInitActLaunchTimeout;

    @SerializedName("lock_ahead_act_orientation")
    private boolean lockAheadActOrientation;

    public z() {
        this.aheadAntiReentryEnable = true;
        this.aheadAntiReentryDuration = 5000;
        this.lockAheadActOrientation = true;
        this.aheadActNextResumeFinish = true;
        this.aheadInitActLaunchTimeout = 2000;
    }
}
