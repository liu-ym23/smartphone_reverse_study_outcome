package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/n7;", "", "", "disableIconAnimator", "Z", "b", "()Z", "setDisableIconAnimator", "(Z)V", "disableDiggAnimator", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDisableDiggAnimator", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n7 {

    @SerializedName("disable_digg_animator")
    private boolean disableDiggAnimator;

    @SerializedName("disable_icon_animator")
    private boolean disableIconAnimator;

    public n7() {
    }

    public final boolean a() {
        return this.disableDiggAnimator;
    }

    public final boolean b() {
        return this.disableIconAnimator;
    }
}
