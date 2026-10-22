package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.backend;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/backend/BackendTaskConfigSwitch;", "", "()V", "drawEnterDelayTime", "", "enable", "", "preloadClickEnterEnable", "preloadDrawEnterEnable", "canPreBackendWhenClick", "canPreBackendWhenDraw", "canUseBackendTask", "getDelayBackendWhenDraw", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackendTaskConfigSwitch {

    @SerializedName("draw_enter_delay_time")
    private int drawEnterDelayTime;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("preload_click_enter_enable")
    private boolean preloadClickEnterEnable;

    @SerializedName("preload_draw_enter_enable")
    private boolean preloadDrawEnterEnable;

    public BackendTaskConfigSwitch() {
    }

    public final boolean canPreBackendWhenClick() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.preloadClickEnterEnable == false) goto L7;
        return true;
    }

    public final boolean canPreBackendWhenDraw() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.preloadDrawEnterEnable == false) goto L7;
        return true;
    }

    public final boolean canUseBackendTask() {
        return this.enable;
    }

    public final int getDelayBackendWhenDraw() {
        return this.drawEnterDelayTime;
    }
}
