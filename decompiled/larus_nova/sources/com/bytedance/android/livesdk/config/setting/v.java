package com.bytedance.android.livesdk.config.setting;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/config/setting/v;", "", "", "rightDisableOptEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setRightDisableOptEnable", "(Z)V", "", "topDisablePercent", FaceService.girlLabel, "f", "()F", "setTopDisablePercent", "(F)V", "rightDisablePercent", "b", "setRightDisablePercent", "rightDisablePercentWithCard", "c", "setRightDisablePercentWithCard", "slideAngleOptEnable", "e", "setSlideAngleOptEnable", "slideAngle", "d", "setSlideAngle", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f121218a = null;

    @SerializedName("right_disable_opt_enable")
    private boolean rightDisableOptEnable;

    @SerializedName("right_disable_percent")
    private float rightDisablePercent;

    @SerializedName("right_disable_percent_with_card")
    private float rightDisablePercentWithCard;

    @SerializedName("slide_angle")
    private float slideAngle;

    @SerializedName("slide_angle_opt_enable")
    private boolean slideAngleOptEnable;

    @SerializedName("top_disable_percent")
    private float topDisablePercent;

    public static final class a {
        public a() {
        }
    }

    static {
        f121218a = new a();
    }

    public v() {
        this.slideAngle = 180.0f;
    }

    public final boolean a() {
        return this.rightDisableOptEnable;
    }

    public final float b() {
        return this.rightDisablePercent;
    }

    public final float c() {
        return this.rightDisablePercentWithCard;
    }

    public final float d() {
        return this.slideAngle;
    }

    public final boolean e() {
        return this.slideAngleOptEnable;
    }

    public final float f() {
        return this.topDisablePercent;
    }
}
