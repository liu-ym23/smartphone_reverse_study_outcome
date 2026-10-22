package com.bytedance.android.livesdkapi.xlive;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RJ\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R\u001a\u00106\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0014\"\u0004\b8\u0010\u0016R\u001a\u00109\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\b¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdkapi/xlive/XLivePlayerViewConfig;", "", "()V", "bizDomain", "", "getBizDomain", "()Ljava/lang/String;", "setBizDomain", "(Ljava/lang/String;)V", "enterLiveSource", "getEnterLiveSource", "setEnterLiveSource", "extraConfigs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExtraConfigs", "()Ljava/util/HashMap;", ITTVideoEngineEventSource.KEY_MUTE, "", "getMute", "()Z", "setMute", "(Z)V", "playerEventListener", "Lkotlin/Function2;", "Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "Lkotlin/ParameterName;", "name", "eventHub", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "getPlayerEventListener", "()Lkotlin/jvm/functions/Function2;", "setPlayerEventListener", "(Lkotlin/jvm/functions/Function2;)V", "resolution", "getResolution", "setResolution", "roomId", "getRoomId", "setRoomId", "scaleType", "", "getScaleType", "()I", "setScaleType", "(I)V", "scene", "getScene", "setScene", "shareFromOther", "getShareFromOther", "setShareFromOther", "shareToOther", "getShareToOther", "setShareToOther", "streamData", "getStreamData", "setStreamData", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XLivePlayerViewConfig {
    private String bizDomain;
    private String enterLiveSource;
    private final HashMap<String, Object> extraConfigs;
    private boolean mute;
    private Function2<? super IRoomEventHub, ? super LifecycleOwner, Unit> playerEventListener;
    private String resolution;
    private String roomId;
    private int scaleType;
    private String scene;
    private boolean shareFromOther;
    private boolean shareToOther;
    private String streamData;

    public XLivePlayerViewConfig() {
        this.roomId = "";
        this.bizDomain = "";
        this.scene = "lynx_preview";
        this.streamData = "";
        this.playerEventListener = XLivePlayerViewConfig$playerEventListener$1.INSTANCE;
        this.scaleType = 2;
        this.mute = true;
        this.resolution = "";
        this.extraConfigs = new HashMap();
        this.enterLiveSource = "";
    }

    public final String getBizDomain() {
        return this.bizDomain;
    }

    public final String getEnterLiveSource() {
        return this.enterLiveSource;
    }

    public final HashMap<String, Object> getExtraConfigs() {
        return this.extraConfigs;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final Function2<IRoomEventHub, LifecycleOwner, Unit> getPlayerEventListener() {
        return this.playerEventListener;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final int getScaleType() {
        return this.scaleType;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean getShareFromOther() {
        return this.shareFromOther;
    }

    public final boolean getShareToOther() {
        return this.shareToOther;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final void setBizDomain(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizDomain = r100;
    }

    public final void setEnterLiveSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterLiveSource = r100;
    }

    public final void setMute(boolean r100) {
        this.mute = r100;
    }

    public final void setPlayerEventListener(Function2<? super IRoomEventHub, ? super LifecycleOwner, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.playerEventListener = r100;
    }

    public final void setResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolution = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setScaleType(int r100) {
        this.scaleType = r100;
    }

    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void setShareFromOther(boolean r100) {
        this.shareFromOther = r100;
    }

    public final void setShareToOther(boolean r100) {
        this.shareToOther = r100;
    }

    public final void setStreamData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamData = r100;
    }
}
