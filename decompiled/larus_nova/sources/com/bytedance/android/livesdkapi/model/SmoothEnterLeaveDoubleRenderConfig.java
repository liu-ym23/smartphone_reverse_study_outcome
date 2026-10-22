package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SmoothEnterLeaveDoubleRenderConfig;", "", "()V", "enableSmoothEnter", "", "enableSmoothLeave", "enableVS", "enterMethod", "", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "forceResetDelay", "", "getForceResetDelay", "()J", "setForceResetDelay", "(J)V", "fromMerge", "getFromMerge", "setFromMerge", "newSurfaceRenderedDelay", "getNewSurfaceRenderedDelay", "setNewSurfaceRenderedDelay", "surfaceControlBitmapSmoothEnter", "getSurfaceControlBitmapSmoothEnter", "()Z", "setSurfaceControlBitmapSmoothEnter", "(Z)V", "surfaceControlBitmapSmoothLeave", "getSurfaceControlBitmapSmoothLeave", "setSurfaceControlBitmapSmoothLeave", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothEnterLeaveDoubleRenderConfig {

    @SerializedName("smooth_enter")
    public boolean enableSmoothEnter;

    @SerializedName("smooth_leave")
    public boolean enableSmoothLeave;

    @SerializedName("enable_vs")
    public boolean enableVS;

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName("force_reset_delay")
    private long forceResetDelay;

    @SerializedName("from_scene")
    private String fromMerge;

    @SerializedName("new_surface_rendered_delay")
    private long newSurfaceRenderedDelay;

    @SerializedName("surface_control_bitmap_smooth_enter")
    private boolean surfaceControlBitmapSmoothEnter;

    @SerializedName("surface_control_bitmap_smooth_leave")
    private boolean surfaceControlBitmapSmoothLeave;

    public SmoothEnterLeaveDoubleRenderConfig() {
        this.enableVS = true;
        this.fromMerge = "";
        this.enterMethod = "|live_cell|";
        this.forceResetDelay = 300;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final long getForceResetDelay() {
        return this.forceResetDelay;
    }

    public final String getFromMerge() {
        return this.fromMerge;
    }

    public final long getNewSurfaceRenderedDelay() {
        return this.newSurfaceRenderedDelay;
    }

    public final boolean getSurfaceControlBitmapSmoothEnter() {
        return this.surfaceControlBitmapSmoothEnter;
    }

    public final boolean getSurfaceControlBitmapSmoothLeave() {
        return this.surfaceControlBitmapSmoothLeave;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setForceResetDelay(long r100) {
        this.forceResetDelay = r100;
    }

    public final void setFromMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromMerge = r100;
    }

    public final void setNewSurfaceRenderedDelay(long r100) {
        this.newSurfaceRenderedDelay = r100;
    }

    public final void setSurfaceControlBitmapSmoothEnter(boolean r100) {
        this.surfaceControlBitmapSmoothEnter = r100;
    }

    public final void setSurfaceControlBitmapSmoothLeave(boolean r100) {
        this.surfaceControlBitmapSmoothLeave = r100;
    }
}
