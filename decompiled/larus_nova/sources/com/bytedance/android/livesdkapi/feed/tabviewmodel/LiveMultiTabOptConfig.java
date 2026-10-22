package com.bytedance.android.livesdkapi.feed.tabviewmodel;

import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/LiveMultiTabOptConfig;", "", "()V", "reusePlayerView", "", "getReusePlayerView", "()Z", "setReusePlayerView", "(Z)V", "usePostRun", "getUsePostRun", "setUsePostRun", "usePreEnterRoom", "getUsePreEnterRoom", "setUsePreEnterRoom", "usePrePullStream", "getUsePrePullStream", "setUsePrePullStream", "useWidgetCache", "getUseWidgetCache", "setUseWidgetCache", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMultiTabOptConfig {
    public static final Companion Companion = null;
    private static final LiveMultiTabOptConfig DEFAULT_CONFIG = null;
    private static final Lazy config$delegate = null;

    @SerializedName("reuse_live_player_view")
    private boolean reusePlayerView;

    @SerializedName("use_post_run")
    private boolean usePostRun;

    @SerializedName("use_pre_enter_room")
    private boolean usePreEnterRoom;

    @SerializedName("use_pre_pull_stream")
    private boolean usePrePullStream;

    @SerializedName("use_widget_cache")
    private boolean useWidgetCache;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/LiveMultiTabOptConfig$Companion;", "", "()V", "DEFAULT_CONFIG", "Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/LiveMultiTabOptConfig;", "config", "getConfig$annotations", "getConfig", "()Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/LiveMultiTabOptConfig;", "config$delegate", "Lkotlin/Lazy;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getConfig$annotations() {
        }

        public final LiveMultiTabOptConfig getConfig() {
            return (LiveMultiTabOptConfig) LiveMultiTabOptConfig.access$getConfig$cp().getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public LiveMultiTabOptConfig() {
    }

    public static final LiveMultiTabOptConfig getConfig() {
        return Companion.getConfig();
    }

    static {
        Companion = new Companion(null);
        DEFAULT_CONFIG = new LiveMultiTabOptConfig();
        config$delegate = LazyKt.lazy(LiveMultiTabOptConfig$Companion$config$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getConfig$cp() {
        return config$delegate;
    }

    public static final /* synthetic */ LiveMultiTabOptConfig access$getDEFAULT_CONFIG$cp() {
        return DEFAULT_CONFIG;
    }

    public final boolean getReusePlayerView() {
        return this.reusePlayerView;
    }

    public final boolean getUsePostRun() {
        return this.usePostRun;
    }

    public final boolean getUsePreEnterRoom() {
        return this.usePreEnterRoom;
    }

    public final boolean getUsePrePullStream() {
        return this.usePrePullStream;
    }

    public final boolean getUseWidgetCache() {
        return this.useWidgetCache;
    }

    public final void setReusePlayerView(boolean r100) {
        this.reusePlayerView = r100;
    }

    public final void setUsePostRun(boolean r100) {
        this.usePostRun = r100;
    }

    public final void setUsePreEnterRoom(boolean r100) {
        this.usePreEnterRoom = r100;
    }

    public final void setUsePrePullStream(boolean r100) {
        this.usePrePullStream = r100;
    }

    public final void setUseWidgetCache(boolean r100) {
        this.useWidgetCache = r100;
    }
}
