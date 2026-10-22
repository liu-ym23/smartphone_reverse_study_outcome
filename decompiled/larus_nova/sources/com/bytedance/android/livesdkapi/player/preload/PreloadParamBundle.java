package com.bytedance.android.livesdkapi.player.preload;

import com.bytedance.android.livesdkapi.model.AdaptiveGradingRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001e\u0010'\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010*\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001c\u00101\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010!\"\u0004\b3\u0010#R\u001a\u00104\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010!\"\u0004\b6\u0010#R\u001c\u00107\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/preload/PreloadParamBundle;", "", "()V", "adaptiveGradingRequest", "Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;", "getAdaptiveGradingRequest", "()Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;", "setAdaptiveGradingRequest", "(Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;)V", "audioAddr", "", "getAudioAddr", "()Ljava/lang/Long;", "setAudioAddr", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "enableSetAudioAddrAfterPlay", "", "getEnableSetAudioAddrAfterPlay", "()Ljava/lang/Boolean;", "setEnableSetAudioAddrAfterPlay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableTextureRender", "", "getEnableTextureRender", "()Ljava/lang/Integer;", "setEnableTextureRender", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enterLiveSource", "", "getEnterLiveSource", "()Ljava/lang/String;", "setEnterLiveSource", "(Ljava/lang/String;)V", "enterType", "getEnterType", "setEnterType", "inBackground", "getInBackground", "setInBackground", "isMatchRoom", "()Z", "setMatchRoom", "(Z)V", "openSei", "getOpenSei", "setOpenSei", "resolution", "getResolution", "setResolution", "streamInfoJson", "getStreamInfoJson", "setStreamInfoJson", "triggerType", "getTriggerType", "setTriggerType", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadParamBundle {
    private AdaptiveGradingRequest adaptiveGradingRequest;
    private Long audioAddr;
    private Boolean enableSetAudioAddrAfterPlay;
    private Integer enableTextureRender;
    private String enterLiveSource;
    private String enterType;
    private Boolean inBackground;
    private boolean isMatchRoom;
    private Boolean openSei;
    private String resolution;
    private String streamInfoJson;
    private String triggerType;

    public PreloadParamBundle() {
        this.streamInfoJson = "";
    }

    public final AdaptiveGradingRequest getAdaptiveGradingRequest() {
        return this.adaptiveGradingRequest;
    }

    public final Long getAudioAddr() {
        return this.audioAddr;
    }

    public final Boolean getEnableSetAudioAddrAfterPlay() {
        return this.enableSetAudioAddrAfterPlay;
    }

    public final Integer getEnableTextureRender() {
        return this.enableTextureRender;
    }

    public final String getEnterLiveSource() {
        return this.enterLiveSource;
    }

    public final String getEnterType() {
        return this.enterType;
    }

    public final Boolean getInBackground() {
        return this.inBackground;
    }

    public final Boolean getOpenSei() {
        return this.openSei;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getStreamInfoJson() {
        return this.streamInfoJson;
    }

    public final String getTriggerType() {
        return this.triggerType;
    }

    public final boolean isMatchRoom() {
        return this.isMatchRoom;
    }

    public final void setAdaptiveGradingRequest(AdaptiveGradingRequest r100) {
        this.adaptiveGradingRequest = r100;
    }

    public final void setAudioAddr(Long r100) {
        this.audioAddr = r100;
    }

    public final void setEnableSetAudioAddrAfterPlay(Boolean r100) {
        this.enableSetAudioAddrAfterPlay = r100;
    }

    public final void setEnableTextureRender(Integer r100) {
        this.enableTextureRender = r100;
    }

    public final void setEnterLiveSource(String r100) {
        this.enterLiveSource = r100;
    }

    public final void setEnterType(String r100) {
        this.enterType = r100;
    }

    public final void setInBackground(Boolean r100) {
        this.inBackground = r100;
    }

    public final void setMatchRoom(boolean r100) {
        this.isMatchRoom = r100;
    }

    public final void setOpenSei(Boolean r100) {
        this.openSei = r100;
    }

    public final void setResolution(String r100) {
        this.resolution = r100;
    }

    public final void setStreamInfoJson(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamInfoJson = r100;
    }

    public final void setTriggerType(String r100) {
        this.triggerType = r100;
    }
}
