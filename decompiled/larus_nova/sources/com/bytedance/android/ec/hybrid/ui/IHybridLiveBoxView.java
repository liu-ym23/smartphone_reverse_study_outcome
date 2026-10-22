package com.bytedance.android.ec.hybrid.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H&J\u001e\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0014H&J\u0012\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\nH&J\b\u0010\u001a\u001a\u00020\nH&J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0014\u0010\u001c\u001a\u00020\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014H&JN\u0010\u001e\u001a\u00020\u00102D\u0010\u001f\u001a@\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00100 H&J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0014H&J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\nH&J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0014H&J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0014H&J\u0012\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0014H&J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202H&J\u0014\u00103\u001a\u00020\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014H&JN\u00104\u001a\u00020\u00102D\u00105\u001a@\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(6\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00100 H&J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0014H&R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/IHybridLiveBoxView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sharePlayer", "", "getSharePlayer", "()Z", "setSharePlayer", "(Z)V", MapMonitorConst.EVENT_DESTROY, "", "enterDetail", "params", "", "", "", "handleObjectfit", "objectfit", "handlePoster", "hidePoster", "playing", "preCreatePlayerView", "releasePlayerClient", "scene", "saveFrameV2", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "extraInfo", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setLiveData", "liveData", "setMute", ITTVideoEngineEventSource.KEY_MUTE, "setPoster", "poster", "setRoomID", "roomID", "setStreamData", "streamData", "setVolume", ITTVideoEngineEventSource.KEY_VOLUME, "", "stopPlayerClient", "stream", "sendCustomEvents", "type", "switchResolution", "resolution", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IHybridLiveBoxView extends FrameLayout {
    private volatile boolean sharePlayer;

    public IHybridLiveBoxView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public IHybridLiveBoxView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public abstract void destroy();

    public abstract void enterDetail(Map<String, ? extends Object> r100);

    public abstract void handleObjectfit(String r100);

    public abstract void handlePoster(boolean r100);

    public abstract boolean playing();

    public void preCreatePlayerView() {
    }

    public abstract void releasePlayerClient(String r100);

    public abstract void saveFrameV2(Function2<? super Map<String, ? extends Object>, ? super Bitmap, Unit> r100);

    public abstract void setLiveData(String r100);

    public abstract void setMute(boolean r100);

    public abstract void setPoster(String r100);

    public abstract void setRoomID(String r100);

    public abstract void setStreamData(String r100);

    public abstract void setVolume(float r100);

    public abstract void stopPlayerClient(String r100);

    public abstract void stream(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100);

    public abstract void switchResolution(String r100);

    public final boolean getSharePlayer() {
        return this.sharePlayer;
    }

    public final void setSharePlayer(boolean r100) {
        this.sharePlayer = r100;
    }

    public IHybridLiveBoxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public static /* synthetic */ void handlePoster$default(IHybridLiveBoxView r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.handlePoster(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePoster");
    }

    public static /* synthetic */ void releasePlayerClient$default(IHybridLiveBoxView r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.releasePlayerClient(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: releasePlayerClient");
    }

    public static /* synthetic */ void stopPlayerClient$default(IHybridLiveBoxView r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.stopPlayerClient(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopPlayerClient");
    }

    public /* synthetic */ IHybridLiveBoxView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
