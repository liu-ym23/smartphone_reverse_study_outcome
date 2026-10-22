package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/b0;", "", "", "canShowHoverMsg", "Z", "b", "()Z", "setCanShowHoverMsg", "(Z)V", "canPinHoverMsg", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCanPinHoverMsg", "", "showDuration", "I", "d", "()I", "setShowDuration", "(I)V", "pinDuration", "c", "setPinDuration", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("can_pin")
    private boolean canPinHoverMsg;

    @SerializedName("can_show")
    private boolean canShowHoverMsg;

    @SerializedName("pin_duration")
    private int pinDuration;

    @SerializedName("show_duration")
    private int showDuration;

    public b0() {
        this.showDuration = 30;
        this.pinDuration = 10;
    }

    public final boolean a() {
        return this.canPinHoverMsg;
    }

    public final boolean b() {
        return this.canShowHoverMsg;
    }

    public final int c() {
        return this.pinDuration;
    }

    public final int d() {
        return this.showDuration;
    }
}
