package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SurfaceViewSmoothConfig;", "", "supportSurfaceSmoothEnter", "", "(Z)V", "getSupportSurfaceSmoothEnter", "()Z", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SurfaceViewSmoothConfig {

    @SerializedName("support_surface_smooth_enter")
    private final boolean supportSurfaceSmoothEnter;

    public SurfaceViewSmoothConfig() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public final boolean getSupportSurfaceSmoothEnter() {
        return this.supportSurfaceSmoothEnter;
    }

    public SurfaceViewSmoothConfig(boolean r100) {
        this.supportSurfaceSmoothEnter = r100;
    }

    public /* synthetic */ SurfaceViewSmoothConfig(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
