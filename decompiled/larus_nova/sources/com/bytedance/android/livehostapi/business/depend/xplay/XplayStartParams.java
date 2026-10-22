package com.bytedance.android.livehostapi.business.depend.xplay;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010$\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010,\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010/\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001a\u00102\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR\u001a\u00105\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001aR&\u00108\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R&\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u001a\u0010A\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\u001a\u0010D\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\u001a\u0010G\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001e\"\u0004\bI\u0010 R&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010;\"\u0004\bL\u0010=R\u001a\u0010M\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0018\"\u0004\bN\u0010\u001aR\u001a\u0010O\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010\u001aR&\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010;\"\u0004\bS\u0010=R\u001a\u0010T\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0018\"\u0004\bV\u0010\u001aR\u001a\u0010W\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001e\"\u0004\bY\u0010 R\u001a\u0010Z\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u001e\"\u0004\b\\\u0010 R\u001a\u0010]\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\f\"\u0004\b_\u0010\u000eR\u001a\u0010`\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0018\"\u0004\bb\u0010\u001aR\u001a\u0010c\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0018\"\u0004\be\u0010\u001aR\u001a\u0010f\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u001e\"\u0004\bh\u0010 R\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u001e\"\u0004\bq\u0010 R\u001a\u0010r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\f\"\u0004\bt\u0010\u000e¨\u0006u"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/XplayStartParams;", "", "()V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "channel", "", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "cloudPlayers", "", "getCloudPlayers", "()Ljava/util/List;", "setCloudPlayers", "(Ljava/util/List;)V", "disableAudioFocus", "", "getDisableAudioFocus", "()Z", "setDisableAudioFocus", "(Z)V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "eglContext", "getEglContext", "()Ljava/lang/Object;", "setEglContext", "(Ljava/lang/Object;)V", "enableAudioFrame", "getEnableAudioFrame", "setEnableAudioFrame", "enableExternalRender", "getEnableExternalRender", "setEnableExternalRender", "enableFrameSEIData", "getEnableFrameSEIData", "setEnableFrameSEIData", "enableRTCMulti", "getEnableRTCMulti", "setEnableRTCMulti", "enableVideoFrame", "getEnableVideoFrame", "setEnableVideoFrame", "extraToGame", "", "getExtraToGame", "()Ljava/util/Map;", "setExtraToGame", "(Ljava/util/Map;)V", "extraToServer", "getExtraToServer", "setExtraToServer", "forwardInfo", "getForwardInfo", "setForwardInfo", "gameId", "getGameId", "setGameId", "heightRatio", "getHeightRatio", "setHeightRatio", "innerExtra", "getInnerExtra", "setInnerExtra", "isFromLiveBasicModule", "setFromLiveBasicModule", "isUseTextureView", "setUseTextureView", "monitorCommonParams", "getMonitorCommonParams", "setMonitorCommonParams", "muteAudioPlayback", "getMuteAudioPlayback", "setMuteAudioPlayback", "renderBackgroundColor", "getRenderBackgroundColor", "setRenderBackgroundColor", "roomGuestType", "getRoomGuestType", "setRoomGuestType", "subscribeMixInfo", "getSubscribeMixInfo", "setSubscribeMixInfo", "useApplicationContext", "getUseApplicationContext", "setUseApplicationContext", "useFullScreen", "getUseFullScreen", "setUseFullScreen", "videoFrameFormat", "getVideoFrameFormat", "setVideoFrameFormat", "videoSimulcast", "Lorg/json/JSONArray;", "getVideoSimulcast", "()Lorg/json/JSONArray;", "setVideoSimulcast", "(Lorg/json/JSONArray;)V", "widthRatio", "getWidthRatio", "setWidthRatio", "xToken", "getXToken", "setXToken", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayStartParams {
    private Context applicationContext;
    private String channel;
    private List<String> cloudPlayers;
    private boolean disableAudioFocus;
    private int displayHeight;
    private int displayWidth;
    private Object eglContext;
    private boolean enableAudioFrame;
    private boolean enableExternalRender;
    private boolean enableFrameSEIData;
    private boolean enableRTCMulti;
    private boolean enableVideoFrame;
    private Map<String, ? extends Object> extraToGame;
    private Map<String, ? extends Object> extraToServer;
    private String forwardInfo;
    private String gameId;
    private int heightRatio;
    private Map<String, ? extends Object> innerExtra;
    private boolean isFromLiveBasicModule;
    private boolean isUseTextureView;
    private Map<String, ? extends Object> monitorCommonParams;
    private boolean muteAudioPlayback;
    private int renderBackgroundColor;
    private int roomGuestType;
    private String subscribeMixInfo;
    private boolean useApplicationContext;
    private boolean useFullScreen;
    private int videoFrameFormat;
    private JSONArray videoSimulcast;
    private int widthRatio;
    private String xToken;

    public XplayStartParams() {
        this.gameId = "";
        this.channel = "";
        this.xToken = "";
        this.extraToGame = new LinkedHashMap();
        this.extraToServer = new LinkedHashMap();
        this.monitorCommonParams = new LinkedHashMap();
        this.innerExtra = new LinkedHashMap();
        this.videoFrameFormat = 1;
        this.cloudPlayers = new ArrayList();
        this.forwardInfo = "";
        this.subscribeMixInfo = "";
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final List<String> getCloudPlayers() {
        return this.cloudPlayers;
    }

    public final boolean getDisableAudioFocus() {
        return this.disableAudioFocus;
    }

    public final int getDisplayHeight() {
        return this.displayHeight;
    }

    public final int getDisplayWidth() {
        return this.displayWidth;
    }

    public final Object getEglContext() {
        return this.eglContext;
    }

    public final boolean getEnableAudioFrame() {
        return this.enableAudioFrame;
    }

    public final boolean getEnableExternalRender() {
        return this.enableExternalRender;
    }

    public final boolean getEnableFrameSEIData() {
        return this.enableFrameSEIData;
    }

    public final boolean getEnableRTCMulti() {
        return this.enableRTCMulti;
    }

    public final boolean getEnableVideoFrame() {
        return this.enableVideoFrame;
    }

    public final Map<String, Object> getExtraToGame() {
        return this.extraToGame;
    }

    public final Map<String, Object> getExtraToServer() {
        return this.extraToServer;
    }

    public final String getForwardInfo() {
        return this.forwardInfo;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final int getHeightRatio() {
        return this.heightRatio;
    }

    public final Map<String, Object> getInnerExtra() {
        return this.innerExtra;
    }

    public final Map<String, Object> getMonitorCommonParams() {
        return this.monitorCommonParams;
    }

    public final boolean getMuteAudioPlayback() {
        return this.muteAudioPlayback;
    }

    public final int getRenderBackgroundColor() {
        return this.renderBackgroundColor;
    }

    public final int getRoomGuestType() {
        return this.roomGuestType;
    }

    public final String getSubscribeMixInfo() {
        return this.subscribeMixInfo;
    }

    public final boolean getUseApplicationContext() {
        return this.useApplicationContext;
    }

    public final boolean getUseFullScreen() {
        return this.useFullScreen;
    }

    public final int getVideoFrameFormat() {
        return this.videoFrameFormat;
    }

    public final JSONArray getVideoSimulcast() {
        return this.videoSimulcast;
    }

    public final int getWidthRatio() {
        return this.widthRatio;
    }

    public final String getXToken() {
        return this.xToken;
    }

    public final boolean isFromLiveBasicModule() {
        return this.isFromLiveBasicModule;
    }

    public final boolean isUseTextureView() {
        return this.isUseTextureView;
    }

    public final void setApplicationContext(Context r100) {
        this.applicationContext = r100;
    }

    public final void setChannel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channel = r100;
    }

    public final void setCloudPlayers(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cloudPlayers = r100;
    }

    public final void setDisableAudioFocus(boolean r100) {
        this.disableAudioFocus = r100;
    }

    public final void setDisplayHeight(int r100) {
        this.displayHeight = r100;
    }

    public final void setDisplayWidth(int r100) {
        this.displayWidth = r100;
    }

    public final void setEglContext(Object r100) {
        this.eglContext = r100;
    }

    public final void setEnableAudioFrame(boolean r100) {
        this.enableAudioFrame = r100;
    }

    public final void setEnableExternalRender(boolean r100) {
        this.enableExternalRender = r100;
    }

    public final void setEnableFrameSEIData(boolean r100) {
        this.enableFrameSEIData = r100;
    }

    public final void setEnableRTCMulti(boolean r100) {
        this.enableRTCMulti = r100;
    }

    public final void setEnableVideoFrame(boolean r100) {
        this.enableVideoFrame = r100;
    }

    public final void setExtraToGame(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraToGame = r100;
    }

    public final void setExtraToServer(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraToServer = r100;
    }

    public final void setForwardInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forwardInfo = r100;
    }

    public final void setFromLiveBasicModule(boolean r100) {
        this.isFromLiveBasicModule = r100;
    }

    public final void setGameId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameId = r100;
    }

    public final void setHeightRatio(int r100) {
        this.heightRatio = r100;
    }

    public final void setInnerExtra(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.innerExtra = r100;
    }

    public final void setMonitorCommonParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.monitorCommonParams = r100;
    }

    public final void setMuteAudioPlayback(boolean r100) {
        this.muteAudioPlayback = r100;
    }

    public final void setRenderBackgroundColor(int r100) {
        this.renderBackgroundColor = r100;
    }

    public final void setRoomGuestType(int r100) {
        this.roomGuestType = r100;
    }

    public final void setSubscribeMixInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subscribeMixInfo = r100;
    }

    public final void setUseApplicationContext(boolean r100) {
        this.useApplicationContext = r100;
    }

    public final void setUseFullScreen(boolean r100) {
        this.useFullScreen = r100;
    }

    public final void setUseTextureView(boolean r100) {
        this.isUseTextureView = r100;
    }

    public final void setVideoFrameFormat(int r100) {
        this.videoFrameFormat = r100;
    }

    public final void setVideoSimulcast(JSONArray r100) {
        this.videoSimulcast = r100;
    }

    public final void setWidthRatio(int r100) {
        this.widthRatio = r100;
    }

    public final void setXToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.xToken = r100;
    }
}
