package com.bytedance.android.ec.core.anchorv3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/core/anchorv3/i;", "", "", "enableOpt", "Z", "b", "()Z", "enableOptMainThread", "e", "enableDelayOnStop", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "endTaskDelayDuration", "J", "h", "()J", "enableOptV2", ce.f26391f, "enableOptLaunchState", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "enableOptLaunchFrame", "c", "enableOptPreload", "f", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("enable_delay_on_stop")
    private final boolean enableDelayOnStop;

    @SerializedName("enable_opt")
    private final boolean enableOpt;

    @SerializedName("enable_opt_launch_frame")
    private final Boolean enableOptLaunchFrame;

    @SerializedName("enable_opt_launch_state")
    private final Boolean enableOptLaunchState;

    @SerializedName("enable_opt_main_thread")
    private final boolean enableOptMainThread;

    @SerializedName("enable_opt_preload")
    private final Boolean enableOptPreload;

    @SerializedName("enable_opt_v2")
    private final boolean enableOptV2;

    @SerializedName("end_task_delay_duration")
    private final long endTaskDelayDuration;

    public i() {
        this(false, false, false, false, null, 255);
    }

    public final boolean a() {
        return this.enableDelayOnStop;
    }

    public final boolean b() {
        return this.enableOpt;
    }

    public final Boolean c() {
        return this.enableOptLaunchFrame;
    }

    public final Boolean d() {
        return this.enableOptLaunchState;
    }

    public final boolean e() {
        return this.enableOptMainThread;
    }

    public final Boolean f() {
        return this.enableOptPreload;
    }

    public final boolean g() {
        return this.enableOptV2;
    }

    public final long h() {
        return this.endTaskDelayDuration;
    }

    public i(boolean r100, boolean r101, boolean r102, boolean r103, Boolean r104, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r110 & 8) == 0) goto L14;
        long r105 = 300;
    L16:
        if ((r110 & 16) == 0) goto L19;
        r103 = false;
    L19:
        if ((r110 & 128) == 0) goto L21;
        r104 = null;
    L21:
        this.enableOpt = r100;
        this.enableOptMainThread = r101;
        this.enableDelayOnStop = r102;
        this.endTaskDelayDuration = r105;
        this.enableOptV2 = r103;
        this.enableOptLaunchState = null;
        this.enableOptLaunchFrame = null;
        this.enableOptPreload = r104;
        return;
    L14:
        r105 = 0;
        goto L16
    }
}
