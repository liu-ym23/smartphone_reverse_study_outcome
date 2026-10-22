package com.bytedance.android.shopping.store.home.api;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/StoreUIParam;", "Ljava/io/Serializable;", "()V", "canShowFloatLive", "", "getCanShowFloatLive", "()Z", "setCanShowFloatLive", "(Z)V", "hasHeaderLive", "getHasHeaderLive", "setHasHeaderLive", "hasHeaderVideo", "getHasHeaderVideo", "setHasHeaderVideo", "isTopMode", "setTopMode", "liveDefaultMute", "getLiveDefaultMute", "setLiveDefaultMute", "liveStyle", "", "getLiveStyle", "()Ljava/lang/Integer;", "setLiveStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "materialTitle", "", "getMaterialTitle", "()Ljava/lang/String;", "setMaterialTitle", "(Ljava/lang/String;)V", ITTVideoEngineEventSource.KEY_VOLUME, "getVolume", "setVolume", "copyFrom", "", "other", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreUIParam implements Serializable {
    private boolean canShowFloatLive;
    private boolean hasHeaderLive;
    private boolean hasHeaderVideo;
    private boolean isTopMode;
    private boolean liveDefaultMute;
    private Integer liveStyle;
    private String materialTitle;
    private Integer volume;

    public StoreUIParam() {
        this.materialTitle = "";
        this.canShowFloatLive = true;
        this.liveDefaultMute = true;
    }

    public final boolean getCanShowFloatLive() {
        return this.canShowFloatLive;
    }

    public final boolean getHasHeaderLive() {
        return this.hasHeaderLive;
    }

    public final boolean getHasHeaderVideo() {
        return this.hasHeaderVideo;
    }

    public final boolean getLiveDefaultMute() {
        return this.liveDefaultMute;
    }

    public final Integer getLiveStyle() {
        return this.liveStyle;
    }

    public final String getMaterialTitle() {
        return this.materialTitle;
    }

    public final Integer getVolume() {
        return this.volume;
    }

    public final boolean isTopMode() {
        return this.isTopMode;
    }

    public final void copyFrom(StoreUIParam r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        this.isTopMode = r100.isTopMode;
        this.hasHeaderLive = r100.hasHeaderLive;
        this.hasHeaderVideo = r100.hasHeaderVideo;
        this.materialTitle = r100.materialTitle;
        this.liveDefaultMute = r100.liveDefaultMute;
        this.liveStyle = r100.liveStyle;
        this.volume = r100.volume;
    }

    public final void setCanShowFloatLive(boolean r100) {
        this.canShowFloatLive = r100;
    }

    public final void setHasHeaderLive(boolean r100) {
        this.hasHeaderLive = r100;
    }

    public final void setHasHeaderVideo(boolean r100) {
        this.hasHeaderVideo = r100;
    }

    public final void setLiveDefaultMute(boolean r100) {
        this.liveDefaultMute = r100;
    }

    public final void setLiveStyle(Integer r100) {
        this.liveStyle = r100;
    }

    public final void setMaterialTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.materialTitle = r100;
    }

    public final void setTopMode(boolean r100) {
        this.isTopMode = r100;
    }

    public final void setVolume(Integer r100) {
        this.volume = r100;
    }
}
