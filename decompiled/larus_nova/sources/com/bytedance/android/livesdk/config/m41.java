package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/m41;", "", "", "switch", "Z", "d", "()Z", "", "smoothDuration", "I", "c", "()I", "loadmoreStyleFix", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "toastNoSlide", "e", "slideFirstItem", "b", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m41 {

    @SerializedName("loadmore_style_fix")
    private final boolean loadmoreStyleFix;

    @SerializedName("slide_first_item")
    private final boolean slideFirstItem;

    @SerializedName("smooth_duration")
    private final int smoothDuration;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final boolean f81switch;

    @SerializedName("toast_no_slide")
    private final boolean toastNoSlide;

    public m41() {
        this.f81switch = true;
        this.smoothDuration = -1;
        this.slideFirstItem = true;
    }

    public final boolean a() {
        return this.loadmoreStyleFix;
    }

    public final boolean b() {
        return this.slideFirstItem;
    }

    public final int c() {
        return this.smoothDuration;
    }

    public final boolean d() {
        return this.f81switch;
    }

    public final boolean e() {
        return this.toastNoSlide;
    }
}
