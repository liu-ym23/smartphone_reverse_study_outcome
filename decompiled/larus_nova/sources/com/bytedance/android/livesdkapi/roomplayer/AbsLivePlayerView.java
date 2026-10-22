package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import is0.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated(message = "不要使用它作为播放器的外部引用，目前存在是为了兼容其他地方的调用，直接使用 LivePlayerView")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020!H\u0016J-\u0010\"\u001a\u00020\u001d2#\u0010#\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0$H&J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020!H\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "liveStatusController", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerStatusController;", "getLiveStatusController", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerStatusController;", "renderView", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "getRenderView", "()Lcom/bytedance/android/livesdkapi/view/IRenderView;", "setRenderView", "(Lcom/bytedance/android/livesdkapi/view/IRenderView;)V", "scaleType", "getScaleType", "()I", "setScaleType", "(I)V", "attachSurfaceView", "", "detachSurfaceView", "detachSurfaceViewNotCheck", "isCheckedRenderViewParent", "", "saveFrame", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", SimplayerImageStrategy.RESULT_BITMAP, "shouldCheckRenderViewParent", "check", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLivePlayerView extends FrameLayout {
    private final ILivePlayerStatusController liveStatusController;

    public abstract void attachSurfaceView();

    public abstract void detachSurfaceView();

    public abstract ILivePlayerClient getClient();

    public abstract IRenderView getRenderView();

    public abstract int getScaleType();

    public boolean isCheckedRenderViewParent() {
        return false;
    }

    public abstract void saveFrame(Function1<? super Bitmap, Unit> r100);

    public abstract void setRenderView(IRenderView r100);

    public abstract void setScaleType(int r100);

    public void shouldCheckRenderViewParent(boolean r100) {
    }

    public void detachSurfaceViewNotCheck() {
        detachSurfaceView();
    }

    public final ILivePlayerStatusController getLiveStatusController() {
        return this.liveStatusController;
    }

    public AbsLivePlayerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.liveStatusController = c.c().getPlayerLiveStatusController(this);
    }
}
