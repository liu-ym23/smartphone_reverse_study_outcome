package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LivePreviewStreamSurfaceViewConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class xj0 extends SSettingKey<LivePreviewStreamSurfaceViewConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xj0 f121610a = null;

    static {
        f121610a = new xj0();
    }

    public xj0() {
        super("live_preview_surface_render", "预览流SurfaceView", new LivePreviewStreamSurfaceViewConfig(), new LivePreviewStreamSurfaceViewConfig());
    }
}
