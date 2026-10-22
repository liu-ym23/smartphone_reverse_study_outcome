package com.bytedance.android.livesdk.config;

import androidx.camera.core.RetryPolicy;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/config/b3;", "", "", "group", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setGroup", "(I)V", "", "entranceGuideDuration", "J", "getEntranceGuideDuration", "()J", "setEntranceGuideDuration", "(J)V", "entranceGuideShowType", "getEntranceGuideShowType", "setEntranceGuideShowType", "slideGuideDuration", "getSlideGuideDuration", "setSlideGuideDuration", "slideGuideNTime", "getSlideGuideNTime", "setSlideGuideNTime", "slideGuideYTime", "getSlideGuideYTime", "setSlideGuideYTime", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b3 {

    @SerializedName("entrance_guide_duration")
    private long entranceGuideDuration;

    @SerializedName("entrance_guide_show_type")
    private int entranceGuideShowType;

    @SerializedName("group")
    private int group;

    @SerializedName("slide_guide_duration")
    private long slideGuideDuration;

    @SerializedName("slide_guide_n_time")
    private long slideGuideNTime;

    @SerializedName("slide_guide_y_time")
    private long slideGuideYTime;

    public static final class a {
    }

    static {
    }

    public b3() {
        this.entranceGuideDuration = 9000;
        this.slideGuideDuration = 5000;
        this.slideGuideNTime = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.slideGuideYTime = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
    }

    public final int a() {
        return this.group;
    }
}
