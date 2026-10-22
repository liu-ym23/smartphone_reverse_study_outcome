package com.bytedance.android.livesdkapi.feed.tabviewmodel;

import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/MultiTabContainerConfig;", "", "()V", "enableAlphaClear", "", "getEnableAlphaClear", "()Z", "setEnableAlphaClear", "(Z)V", "enableGestureIntercept", "getEnableGestureIntercept", "setEnableGestureIntercept", "endRoomLeakFix", "getEndRoomLeakFix", "setEndRoomLeakFix", "solution", "", "getSolution", "()I", "setSolution", "(I)V", "videoMemoryLeakFix", "getVideoMemoryLeakFix", "setVideoMemoryLeakFix", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTabContainerConfig {
    private static final MultiTabContainerConfig ALL_CLOSE = null;
    public static final Companion Companion = null;
    private static final MultiTabContainerConfig DEFAULT_CONFIG = null;

    @SerializedName("enable_alpha_clear_switch")
    private boolean enableAlphaClear;

    @SerializedName("public_screen_area_gesture_switch")
    private boolean enableGestureIntercept;

    @SerializedName("end_room_task_memory_leak")
    private boolean endRoomLeakFix;

    @SerializedName("landscape_solution")
    private int solution;

    @SerializedName("video_camera_manager_memory_leak")
    private boolean videoMemoryLeakFix;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/MultiTabContainerConfig$Companion;", "", "()V", "ALL_CLOSE", "Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/MultiTabContainerConfig;", "DEFAULT_CONFIG", "getConfig", "getSolution", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final MultiTabContainerConfig getConfig() {
            IMiddlewareLiveService r100 = TTLiveServiceMiddleware.getLiveService();
            if (r100 == null) goto L7;
            Boolean r101 = (Boolean) r100.getLiveSettingValue("livesdk_multi_tab_container_config_all", Boolean.TRUE);
            if (r101 == null) goto L7;
            boolean r102 = r101.booleanValue();
        L8:
            if (r102 == false) goto L10;
            IMiddlewareLiveService r103 = TTLiveServiceMiddleware.getLiveService();
            if (r103 == null) goto L16;
            MultiTabContainerConfig r104 = (MultiTabContainerConfig) r103.getLiveSettingValue("livesdk_multi_tab_container_config", MultiTabContainerConfig.access$getDEFAULT_CONFIG$cp());
            if (r104 == null) goto L16;
            return r104;
        L16:
            return MultiTabContainerConfig.access$getDEFAULT_CONFIG$cp();
        L10:
            return MultiTabContainerConfig.access$getALL_CLOSE$cp();
        L7:
            r102 = true;
            goto L8
        }

        public final int getSolution() {
            return getConfig().getSolution();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT_CONFIG = new MultiTabContainerConfig();
        MultiTabContainerConfig r100 = new MultiTabContainerConfig();
        r100.enableAlphaClear = false;
        r100.enableGestureIntercept = false;
        r100.videoMemoryLeakFix = false;
        r100.endRoomLeakFix = false;
        ALL_CLOSE = r100;
    }

    public MultiTabContainerConfig() {
        this.solution = 2;
        this.enableAlphaClear = true;
        this.enableGestureIntercept = true;
        this.videoMemoryLeakFix = true;
        this.endRoomLeakFix = true;
    }

    public static final /* synthetic */ MultiTabContainerConfig access$getALL_CLOSE$cp() {
        return ALL_CLOSE;
    }

    public static final /* synthetic */ MultiTabContainerConfig access$getDEFAULT_CONFIG$cp() {
        return DEFAULT_CONFIG;
    }

    public final boolean getEnableAlphaClear() {
        return this.enableAlphaClear;
    }

    public final boolean getEnableGestureIntercept() {
        return this.enableGestureIntercept;
    }

    public final boolean getEndRoomLeakFix() {
        return this.endRoomLeakFix;
    }

    public final int getSolution() {
        return this.solution;
    }

    public final boolean getVideoMemoryLeakFix() {
        return this.videoMemoryLeakFix;
    }

    public final void setEnableAlphaClear(boolean r100) {
        this.enableAlphaClear = r100;
    }

    public final void setEnableGestureIntercept(boolean r100) {
        this.enableGestureIntercept = r100;
    }

    public final void setEndRoomLeakFix(boolean r100) {
        this.endRoomLeakFix = r100;
    }

    public final void setSolution(int r100) {
        this.solution = r100;
    }

    public final void setVideoMemoryLeakFix(boolean r100) {
        this.videoMemoryLeakFix = r100;
    }
}
