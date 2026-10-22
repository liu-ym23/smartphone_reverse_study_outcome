package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/g0;", "", "", "touchDownEnable", "Z", "d", "()Z", "clickIconEnable", "b", "changeTabEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "scrollListEnable", "c", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("change_tab_enable")
    private final boolean changeTabEnable;

    @SerializedName("click_icon_enable")
    private final boolean clickIconEnable;

    @SerializedName("scroll_list_enable")
    private final boolean scrollListEnable;

    @SerializedName("touch_down_enable")
    private final boolean touchDownEnable;

    public g0() {
    }

    public final boolean e() {
        if (this.touchDownEnable == false) goto L5;
    L12:
        return true;
    L5:
        if (this.clickIconEnable == true) goto L12;
        if (this.changeTabEnable == true) goto L12;
        if (this.scrollListEnable == true) goto L12;
        return false;
    }

    public final boolean a() {
        return this.changeTabEnable;
    }

    public final boolean b() {
        return this.clickIconEnable;
    }

    public final boolean c() {
        return this.scrollListEnable;
    }

    public final boolean d() {
        return this.touchDownEnable;
    }
}
