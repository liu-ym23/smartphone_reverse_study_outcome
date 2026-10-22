package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdkapi.model.PlayerModularizationConfig;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerSurfaceRenderConfig;
import com.bytedance.android.livesdkapi.view.IExtraRenderView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.KeepSurfaceTextureRenderView;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0004¤\u0001¥\u0001Bk\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0002\u0010\u0011BK\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0016B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001aB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0002\u0010\u001cJ\u000e\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020(J\u000e\u0010f\u001a\u00020d2\u0006\u0010g\u001a\u00020BJ\b\u0010h\u001a\u00020dH\u0002J\b\u0010i\u001a\u00020dH\u0016J\u0006\u0010j\u001a\u00020dJ\b\u0010k\u001a\u00020dH\u0002J\n\u0010l\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010m\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010n\u001a\u00020dH\u0016J\b\u0010o\u001a\u00020dH\u0016J\u0006\u0010p\u001a\u00020dJ\u0006\u0010q\u001a\u00020dJ\b\u0010r\u001a\u0004\u0018\u00010sJ\u0014\u0010t\u001a\u0004\u0018\u00010u2\b\u0010v\u001a\u0004\u0018\u00010wH\u0002J\u001a\u0010x\u001a\u00020d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010y\u001a\u00020\fH\u0016J\u0006\u0010z\u001a\u00020\fJ\u0006\u0010{\u001a\u00020\fJ\u0006\u0010|\u001a\u00020\fJ\u001a\u0010}\u001a\u00020d2\u0006\u0010~\u001a\u00020\u001e2\b\b\u0002\u0010\u007f\u001a\u00020\fH\u0002J\t\u0010\u0080\u0001\u001a\u00020dH\u0014J\t\u0010\u0081\u0001\u001a\u00020dH\u0014J\u0007\u0010\u0082\u0001\u001a\u00020dJ\u0019\u0010\u0083\u0001\u001a\u00020d2\u0007\u0010\u0084\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020\fJ\t\u0010\u0086\u0001\u001a\u00020dH\u0002J\u0007\u0010\u0087\u0001\u001a\u00020dJ\u000f\u0010\u0088\u0001\u001a\u00020d2\u0006\u0010e\u001a\u00020(J\u000f\u0010\u0089\u0001\u001a\u00020d2\u0006\u0010g\u001a\u00020BJ\u0007\u0010\u008a\u0001\u001a\u00020dJ\u0007\u0010\u008b\u0001\u001a\u00020dJ4\u0010\u008c\u0001\u001a\u00020d2+\b\u0002\u0010\u008d\u0001\u001a$\u0012\u0017\u0012\u00150\u008f\u0001¢\u0006\u000f\b\u0090\u0001\u0012\n\b\u0091\u0001\u0012\u0005\b\b(\u0092\u0001\u0012\u0004\u0012\u00020d\u0018\u00010\u008e\u0001J3\u0010\u0093\u0001\u001a\u00020d2(\u0010\u0094\u0001\u001a#\u0012\u0018\u0012\u0016\u0018\u00010s¢\u0006\u000f\b\u0090\u0001\u0012\n\b\u0091\u0001\u0012\u0005\b\b(\u0095\u0001\u0012\u0004\u0012\u00020d0\u008e\u0001H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020d2\u0007\u0010\u0097\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020d2\u0007\u0010\u0099\u0001\u001a\u00020\fH\u0016J\u0011\u0010\u009a\u0001\u001a\u00020d2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001J\u0007\u0010\u009d\u0001\u001a\u00020dJ\t\u0010\u009e\u0001\u001a\u00020dH\u0002J\t\u0010\u009f\u0001\u001a\u00020dH\u0002J\u0012\u0010 \u0001\u001a\u00020d2\u0007\u0010¡\u0001\u001a\u00020+H\u0007J\u0010\u0010¢\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u001eR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010?\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010A\u001a\u0012\u0012\u0004\u0012\u00020B0'j\b\u0012\u0004\u0012\u00020B`)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u001c\u0010I\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00106\"\u0004\bR\u00108R\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010H\u001a\u0004\bU\u0010VR$\u0010Y\u001a\u00020%2\u0006\u0010X\u001a\u00020%8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bZ\u0010K\"\u0004\b[\u0010MR$\u0010\\\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "defStyle", "", "roomId", "", "userId", "useSurface", "", "sharePlayer", "pseudoLiving", "firstShow", "reusePlayerClient", "(Landroid/content/Context;Landroid/util/AttributeSet;IJJZZZZZ)V", "clientType", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;", "clientScene", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientScene;", "(Landroid/content/Context;Landroid/util/AttributeSet;IJLcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientScene;Z)V", "config", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;", "(Landroid/content/Context;Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_Config", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;)V", "TAG", "", "TYPE_NPRMAL", "TYPE_VS_FIRST_SHOW", "VIEW_TYPE_KEEP_TEXTURE", "VIEW_TYPE_SURFACE", "VIEW_TYPE_TEXTURE", "_renderView", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "attachSurfaceListenerList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView$AttachSurfaceViewListener;", "Lkotlin/collections/ArrayList;", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "setClient", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;)V", "getConfig", "()Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;", "setConfig", "(Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;)V", "detachFromWindowTime", "getDetachFromWindowTime", "()J", "setDetachFromWindowTime", "(J)V", "extraRenderView", "Lcom/bytedance/android/livesdkapi/view/IExtraRenderView;", "getExtraRenderView", "()Lcom/bytedance/android/livesdkapi/view/IExtraRenderView;", "setExtraRenderView", "(Lcom/bytedance/android/livesdkapi/view/IExtraRenderView;)V", "firstFrameRenderObs", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "interceptorList", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView$OperateInterceptor;", "livePlayerService", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerService;", "getLivePlayerService", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerService;", "livePlayerService$delegate", "Lkotlin/Lazy;", "mainCameraRenderView", "getMainCameraRenderView", "()Lcom/bytedance/android/livesdkapi/view/IRenderView;", "setMainCameraRenderView", "(Lcom/bytedance/android/livesdkapi/view/IRenderView;)V", "mainHandler", "Landroid/os/Handler;", "notVisibleTime", "getNotVisibleTime", "setNotVisibleTime", "optimizeConfig", "Lcom/bytedance/android/livesdkapi/model/PlayerOptimizeConfig;", "getOptimizeConfig", "()Lcom/bytedance/android/livesdkapi/model/PlayerOptimizeConfig;", "optimizeConfig$delegate", "value", "renderView", "getRenderView", "setRenderView", "scaleType", "getScaleType", "()I", "setScaleType", "(I)V", "sharePlayerController", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerShareController;", "addAttachSurfaceViewListener", "", "listener", "addOperateInterceptor", "interceptor", "attachRenderView", "attachSurfaceView", "cancelRunningDelayStopOrRelease", "checkAbnormalSurfaceViewCase", "createExtraRenderView", "createRenderView", "detachSurfaceView", "detachSurfaceViewNotCheck", "directRunningDelayStopOrRelease", "disableDelayStopOrRelease", "getPreSceneRenderBitmap", "Landroid/graphics/Bitmap;", "getSurfaceViewPos", "Landroid/graphics/Rect;", BaseSwitches.V, "Landroid/view/View;", "initXmlAttrs", "isCheckedRenderViewParent", "isEnableDelayStopOrRelease", "isInDelayStopOrRelease", "isSameScene", "logPlayerView", "msg", "simple", "onAttachedToWindow", "onDetachedFromWindow", "pause", "recreateRenderView", "isVrScene", "isSubCamera", "registerFirstRender", "release", "removeAttachSurfaceViewListener", "removeOperateInterceptor", "resetRenderView", "resume", "resumePlay", "eventListener", "Lkotlin/Function1;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/ParameterName;", "name", "lifecycleOwner", "saveFrame", "callback", SimplayerImageStrategy.RESULT_BITMAP, "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "shouldCheckRenderViewParent", "check", "start", "request", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "stop", "trySetRenderViewVideoSize", "unregisterFirstRender", "updateClient", "livePlayer", "updateIdentifier", LocationMonitorConst.IDENTIFIER, "AttachSurfaceViewListener", "OperateInterceptor", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerView extends AbsLivePlayerView {
    private final String TAG;
    private final int TYPE_NPRMAL;
    private final int TYPE_VS_FIRST_SHOW;
    private final int VIEW_TYPE_KEEP_TEXTURE;
    private final int VIEW_TYPE_SURFACE;
    private final int VIEW_TYPE_TEXTURE;
    private IRenderView _renderView;
    private final ArrayList<AttachSurfaceViewListener> attachSurfaceListenerList;
    private ILivePlayerClient client;
    private LivePlayerConfig config;
    private long detachFromWindowTime;
    private IExtraRenderView extraRenderView;
    private Observer<Boolean> firstFrameRenderObs;
    private final ArrayList<OperateInterceptor> interceptorList;
    private final Lazy livePlayerService$delegate;
    private IRenderView mainCameraRenderView;
    private Handler mainHandler;
    private long notVisibleTime;
    private final Lazy optimizeConfig$delegate;
    private LivePlayerShareController sharePlayerController;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView$AttachSurfaceViewListener;", "", "onAttachSurfaceView", "", "onDetachSurfaceView", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface AttachSurfaceViewListener {
        void onAttachSurfaceView();

        void onDetachSurfaceView();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView$OperateInterceptor;", "", "interceptSetVisible", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OperateInterceptor {
        boolean interceptSetVisible();
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[IRenderView.RenderViewType.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[IRenderView.RenderViewType.KEEP_TEXTURE_RENDER_VIEW.ordinal()] = 1;
            r100[IRenderView.RenderViewType.SURFACE_VIEW.ordinal()] = 2;
        }
    }

    private final PlayerOptimizeConfig getOptimizeConfig() {
        return (PlayerOptimizeConfig) this.optimizeConfig$delegate.getValue();
    }

    public final ILivePlayerService getLivePlayerService() {
        return (ILivePlayerService) this.livePlayerService$delegate.getValue();
    }

    public final void cancelRunningDelayStopOrRelease() {
        this.sharePlayerController.cancelRunningDelayStopOrRelease();
    }

    public final void directRunningDelayStopOrRelease() {
        this.sharePlayerController.directRunningDelayStopOrRelease();
    }

    public final void disableDelayStopOrRelease() {
        this.sharePlayerController.disableDelayStopOrRelease();
    }

    public final Bitmap getPreSceneRenderBitmap() {
        return this.sharePlayerController.getPreSceneLastRenderFrameBitmap();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public IRenderView getRenderView() {
        IRenderView r100 = this._renderView;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_renderView");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public boolean isCheckedRenderViewParent() {
        return this.sharePlayerController.isCheckRenderViewParent$live_player_api_saasRelease();
    }

    public final boolean isEnableDelayStopOrRelease() {
        return this.sharePlayerController.getEnableDelayStopOrRelease();
    }

    public final boolean isInDelayStopOrRelease() {
        return this.sharePlayerController.isInDelayStopOrRelease();
    }

    private final void attachRenderView() {
        if (getRenderView().getSelfView().getId() != (-1)) goto L5;
        getRenderView().getSelfView().setId(R.id.ttlive_player_render_view);
    L5:
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        r100.gravity = this.config.getRenderViewGravity();
        addView(getRenderView().getSelfView(), r100);
    }

    private final void checkAbnormalSurfaceViewCase() {
        Rect r100 = getSurfaceViewPos(getRenderView().getSelfView());
        int r101 = INVOKEVIRTUAL_com_bytedance_android_livesdkapi_roomplayer_LivePlayerView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).heightPixels;
        if (((PlayerSurfaceRenderConfig) getLivePlayerService().getConfig(PlayerSurfaceRenderConfig.class)).isCheckAbnormalCaseAdd() == false) goto L9;
        if (r100 == null) goto L9;
        if (r100.centerX() != 0) goto L9;
        r100.toString();
        return;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.centerX() >= r101) goto L24;
        r100.toString();
        getRenderView().setVisibility(8);
        getRenderView().setVisibility(0);
        if (getClient().gameExtraRenderController().isEnable() == false) goto L15;
    L16:
        IExtraRenderView r102 = this.extraRenderView;
        if (r102 == null) goto L19;
        r102.setVisibility(8);
    L19:
        IExtraRenderView r103 = this.extraRenderView;
        if (r103 == null) goto L26;
        r103.setVisibility(0);
        return;
    L26:
        return;
    L15:
        if (getClient().multiRenderController().isEnable() == true) goto L16;
        return;
    }

    private final IExtraRenderView createExtraRenderView() {
        return getClient().createExtraRenderView(getContext());
    }

    private final void registerFirstRender() {
        if (getOptimizeConfig().getPlayerBitmapLeakFix() == true) goto L6;
        return;
    L6:
        if (this.firstFrameRenderObs != null) goto L9;
        Observer<Boolean> r100 = new LivePlayerView$registerFirstRender$observer$1(this);
        getClient().getEventHub().getSurfaceReadyFirstFrameRender().observeForever(r100);
        this.firstFrameRenderObs = r100;
        return;
    }

    private final void trySetRenderViewVideoSize() {
        Pair<Integer, Integer> r100 = getClient().getVideoSizeOnCreateRenderView();
        if (r100 == null) goto L10;
        getRenderView().setVideoSize(r100.getFirst().intValue(), r100.getSecond().intValue());
        if (r100.getFirst().intValue() > r100.getSecond().intValue()) goto L7;
        return;
    L7:
        if (getOptimizeConfig().getOptimizeStartStreamSize() == false) goto L20;
        getRenderView().setScaleType(0);
        return;
    L20:
        return;
    L10:
        if (getClient().context().isSharedClient() == true) goto L12;
        return;
    L12:
        if (getOptimizeConfig().getSetVideoSizeWithSharePlayer() != true) goto L23;
        Pair<Integer, Integer> r101 = getClient().getVideoSize();
        if (r101.getFirst().intValue() != 0) goto L16;
        return;
    L16:
        if (r101.getSecond().intValue() == 0) goto L25;
        getRenderView().setVideoSize(r101.getFirst().intValue(), r101.getSecond().intValue());
        return;
    L25:
        return;
    }

    private final void unregisterFirstRender() {
        if (getOptimizeConfig().getPlayerBitmapLeakFix() == true) goto L6;
        return;
    L6:
        if (this.firstFrameRenderObs == null) goto L9;
        MutableLiveData<Boolean> r100 = getClient().getEventHub().getSurfaceReadyFirstFrameRender();
        Observer<Boolean> r101 = this.firstFrameRenderObs;
        Intrinsics.checkNotNull(r101);
        r100.removeObserver(r101);
        this.firstFrameRenderObs = null;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void attachSurfaceView() {
        if ((getRenderView() instanceof SurfaceView) == false) goto L8;
        logPlayerView$default(this, "attachSurfaceView", false, 2, null);
        setTranslationX(0.0f);
        Iterator<AttachSurfaceViewListener> r100 = this.attachSurfaceListenerList.iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        r100.next().onAttachSurfaceView();
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void detachSurfaceView() {
        if ((getRenderView() instanceof SurfaceView) == false) goto L19;
        int r100 = INVOKEVIRTUAL_com_bytedance_android_livesdkapi_roomplayer_LivePlayerView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).heightPixels;
        float r101 = getTranslationX();
        Boolean r102 = null;
        logPlayerView$default(this, "detachSurfaceView", false, 2, null);
        setTranslationX(r100 * 5.0f);
        Iterator<AttachSurfaceViewListener> r103 = this.attachSurfaceListenerList.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r103.next().onDetachSurfaceView();
        goto L6
    L9:
        if (r101 != getTranslationX()) goto L11;
        return;
    L11:
        PlayerSurfaceRenderConfig r104 = (PlayerSurfaceRenderConfig) getLivePlayerService().getConfig(PlayerSurfaceRenderConfig.class);
        if (r104 == null) goto L15;
        r102 = Boolean.valueOf(r104.isCheckAbnormalCase());
    L15:
        if (r102.booleanValue() != true) goto L20;
        this.mainHandler.postDelayed(new AnonymousClass1(this), 100);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void detachSurfaceViewNotCheck() {
        if ((getRenderView() instanceof SurfaceView) == false) goto L8;
        logPlayerView$default(this, "detachSurfaceViewNotCheck", false, 2, null);
        setTranslationX(INVOKEVIRTUAL_com_bytedance_android_livesdkapi_roomplayer_LivePlayerView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).heightPixels * 5.0f);
        Iterator<AttachSurfaceViewListener> r100 = this.attachSurfaceListenerList.iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        r100.next().onDetachSurfaceView();
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public int getScaleType() {
        return getRenderView().getScaleType();
    }

    public final boolean isSameScene() {
        return Intrinsics.areEqual(getClient().context().getUseScene(), this.config.getScene());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PlayerModularizationConfig r100 = (PlayerModularizationConfig) getLivePlayerService().getConfig(PlayerModularizationConfig.class);
        if (r100 != null) goto L5;
    L7:
        registerFirstRender();
        ILivePlayerClient r101 = getClient();
        Object r102 = getParent();
        if (r102 == null) goto L12;
        r101.updateContextPage((View) r102);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L5:
        if (r100.getEnableV1() != true) goto L7;
        getClient().bindRenderView(getRenderView());
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.detachFromWindowTime = SystemClock.elapsedRealtime();
        logPlayerView("onDetachedFromWindow", false);
        getLivePlayerService().checkAudioMixedEvent(getClient(), 2);
        unregisterFirstRender();
    }

    public final void pause() {
        getClient().pause();
    }

    public final void release() {
        PlayerModularizationConfig r100 = (PlayerModularizationConfig) getLivePlayerService().getConfig(PlayerModularizationConfig.class);
        if (r100 != null) goto L5;
    L12:
        getClient().release();
        return;
    L5:
        if (r100.getEnableV2() != true) goto L12;
        if (Intrinsics.areEqual(getClient().context().getUseScene(), this.config.getScene()) == false) goto L9;
        getClient().release();
        return;
    L9:
        IPlayerLogger r101 = getClient().logger();
        if (r101 == null) goto L15;
        ILivePlayerSpmLogger.DefaultImpls.logLifeCycle$default(r101, "scene[" + this.config.getScene() + "] != use_scene[" + getClient().context().getUseScene() + "]! release failed!", null, false, 6, null);
        return;
    }

    public final void resetRenderView() {
        removeAllViews();
        IRenderView r100 = this.mainCameraRenderView;
        if (r100 == null) goto L6;
        setRenderView(r100);
    L6:
        if (getClient().context().isSharedClient() == true) goto L8;
    L14:
        attachRenderView();
        return;
    L8:
        if (getOptimizeConfig().getSetVideoSizeWithSharePlayer() != true) goto L14;
        Pair<Integer, Integer> r101 = getClient().getVideoSize();
        if (r101.getFirst().intValue() == 0) goto L14;
        if (r101.getSecond().intValue() == 0) goto L14;
        getRenderView().setVideoSize(r101.getFirst().intValue(), r101.getSecond().intValue());
        goto L14
    }

    public final void resume() {
        getClient().resume();
    }

    public final void stop() {
        PlayerModularizationConfig r100 = (PlayerModularizationConfig) getLivePlayerService().getConfig(PlayerModularizationConfig.class);
        if (r100 != null) goto L5;
    L12:
        getClient().stop();
        return;
    L5:
        if (r100.getEnableV2() != true) goto L12;
        if (Intrinsics.areEqual(getClient().context().getUseScene(), this.config.getScene()) == false) goto L9;
        getClient().stop();
        return;
    L9:
        IPlayerLogger r101 = getClient().logger();
        if (r101 == null) goto L15;
        ILivePlayerSpmLogger.DefaultImpls.logLifeCycle$default(r101, "scene[" + this.config.getScene() + "] != use_scene[" + getClient().context().getUseScene() + "]! stop failed!", null, false, 6, null);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public ILivePlayerClient getClient() {
        return this.client;
    }

    public final LivePlayerConfig getConfig() {
        return this.config;
    }

    public final long getDetachFromWindowTime() {
        return this.detachFromWindowTime;
    }

    public final IExtraRenderView getExtraRenderView() {
        return this.extraRenderView;
    }

    public final IRenderView getMainCameraRenderView() {
        return this.mainCameraRenderView;
    }

    public final long getNotVisibleTime() {
        return this.notVisibleTime;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_livesdkapi_roomplayer_LivePlayerView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ void access$checkAbnormalSurfaceViewCase(LivePlayerView r100) {
        r100.checkAbnormalSurfaceViewCase();
    }

    public static final /* synthetic */ LivePlayerShareController access$getSharePlayerController$p(LivePlayerView r100) {
        return r100.sharePlayerController;
    }

    public static final /* synthetic */ void access$unregisterFirstRender(LivePlayerView r100) {
        r100.unregisterFirstRender();
    }

    private final IRenderView createRenderView(Context r100) {
        IRenderView.RenderViewType r101 = this.config.getRenderViewType();
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        IRenderView r103 = new KeepSurfaceTextureRenderView(r100);
    L9:
        r103.setPlayerLogger(getClient().logger());
        return r103;
    L5:
        if (r102 == 2) goto L7;
        r103 = new TextureRenderView(r100);
        goto L9
    L7:
        r103 = new SurfaceRenderView(r100);
        goto L9
    }

    private final Rect getSurfaceViewPos(View r100) {
        if (r100 != null) goto L5;
    L23:
        return null;
    L5:
        if ((r100 instanceof SurfaceView) == false) goto L23;
        Class<? super Object> r101 = ((SurfaceView) r100).getClass().getSuperclass();     // Catch: Exception -> L21
        if (r101 == null) goto L10;
        Field r102 = r101.getDeclaredField("mRTLastReportedPosition");     // Catch: Exception -> L21
    L11:
        if (r102 == null) goto L13;
        r102.setAccessible(true);     // Catch: Exception -> L21
    L13:
        if (r102 == null) goto L15;
        Object r103 = r102.get(r100);     // Catch: Exception -> L21
    L16:
        if (r103 == null) goto L20;
        return (Rect) r103;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Exception -> L21
    L15:
        r103 = null;
        goto L16
    L10:
        r102 = null;
    L21:
        e = move-exception;
        e.toString();
        goto L23
    }

    public final void addAttachSurfaceViewListener(AttachSurfaceViewListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.attachSurfaceListenerList.contains(r100) == true) goto L6;
        this.attachSurfaceListenerList.add(r100);
        return;
    }

    public final void addOperateInterceptor(OperateInterceptor r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.interceptorList.add(r100);
    }

    public final void removeAttachSurfaceViewListener(AttachSurfaceViewListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.attachSurfaceListenerList.remove(r100);
    }

    public final void removeOperateInterceptor(OperateInterceptor r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.interceptorList.remove(r100);
    }

    public final void resumePlay(Function1<? super LifecycleOwner, Unit> r100) {
        this.sharePlayerController.resumePlay(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void saveFrame(Function1<? super Bitmap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        getClient().saveFrame(r100);
    }

    public void setClient(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.client = r100;
    }

    public final void setConfig(LivePlayerConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.config = r100;
    }

    public final void setDetachFromWindowTime(long r100) {
        this.detachFromWindowTime = r100;
    }

    public final void setExtraRenderView(IExtraRenderView r100) {
        this.extraRenderView = r100;
    }

    public final void setMainCameraRenderView(IRenderView r100) {
        this.mainCameraRenderView = r100;
    }

    public final void setNotVisibleTime(long r100) {
        this.notVisibleTime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void setRenderView(IRenderView r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this._renderView = r100;
        getClient().bindRenderView(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void setScaleType(int r100) {
        getRenderView().setScaleType(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (r100 != 0) goto L9;
        Iterator<T> r101 = this.interceptorList.iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        if (((OperateInterceptor) r101.next()).interceptSetVisible() == false) goto L5;
        return;
    L9:
        super.setVisibility(r100);
        if (r100 == 0) goto L12;
        this.notVisibleTime = SystemClock.elapsedRealtime();
    L12:
        logPlayerView("player view setVisibility " + r100, false);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView
    public void shouldCheckRenderViewParent(boolean r100) {
        this.sharePlayerController.setCheckRenderViewParent$live_player_api_saasRelease(r100);
    }

    public final void start(LiveRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        getClient().stream(r100, null);
    }

    @Deprecated(message = "处理特定问题，未经验证不建议乱改")
    public final void updateClient(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "livePlayer");
        setClient(r100);
    }

    public final boolean updateIdentifier(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        return getLivePlayerService().updatePlayerIdentifier(getClient(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePlayerView(Context r210, AttributeSet r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        LivePlayerConfig r100 = new LivePlayerConfig(ILivePlayerScene.Companion.scene("xml"), null, null, false, null, false, false, null, false, 0, false, 2046, null);
        r100.setEncrypt(true);
        Unit r101 = Unit.INSTANCE;
        this(r210, r211, 0, r100, 4, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ void access$setSharePlayerController$p(LivePlayerView r100, LivePlayerShareController r101) {
        r100.sharePlayerController = r101;
    }

    private final void initXmlAttrs(AttributeSet r100, Context r101) {
        if (r100 != null) goto L28;
        return;
    L28:
        TypedArray r102 = r101.obtainStyledAttributes(r100, new int[]{R.attr.share_from_other, R.attr.share_to_other, R.attr.ttlive_player_renderview_type, R.attr.ttlive_player_scene, R.attr.ttlive_player_type});     // Catch: Exception -> L27
        String r103 = r102.getString(3);     // Catch: Throwable -> L23
        if (r103 == null) goto L8;
        this.config.setScene(ILivePlayerScene.Companion.scene(r103));     // Catch: Throwable -> L23
    L8:
        int r104 = r102.getInt(4, this.TYPE_NPRMAL);     // Catch: Throwable -> L23
        if (r104 != this.TYPE_NPRMAL) goto L12;
        this.config.setType(PlayerClientType.NORMAL);     // Catch: Throwable -> L23
    L14:
        int r105 = r102.getInt(2, this.VIEW_TYPE_TEXTURE);     // Catch: Throwable -> L23
        LivePlayerConfig r106 = this.config;     // Catch: Throwable -> L23
        if (r105 != this.VIEW_TYPE_SURFACE) goto L18;
        IRenderView.RenderViewType r107 = IRenderView.RenderViewType.SURFACE_VIEW;     // Catch: Throwable -> L23
    L21:
        r106.setRenderViewType(r107);     // Catch: Throwable -> L23
        this.config.setShareToOther(r102.getBoolean(1, false));     // Catch: Throwable -> L23
        this.config.setShareFromOther(r102.getBoolean(0, false));     // Catch: Throwable -> L23
        r102.recycle();     // Catch: Exception -> L27
        return;
        goto L32
    L18:
        if (r105 != this.VIEW_TYPE_KEEP_TEXTURE) goto L20;
        r107 = IRenderView.RenderViewType.KEEP_TEXTURE_RENDER_VIEW;     // Catch: Throwable -> L23
        goto L21
    L20:
        r107 = IRenderView.RenderViewType.TEXTURE_VIEW;     // Catch: Throwable -> L23
        goto L21
    L12:
        if (r104 != this.TYPE_VS_FIRST_SHOW) goto L14;
        this.config.setType(PlayerClientType.FIRST_SHOW);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r102.recycle();     // Catch: Exception -> L27
        throw th;     // Catch: Exception -> L27
    }

    private final void logPlayerView(String r100, boolean r101) {
        IPlayerLogger r102 = getClient().logger();
        if (r102 == null) goto L6;
        r102.logPlayerView("scene:" + this.config.getScene().getScene() + ' ' + r100, null, r101);
        return;
    }

    public final void recreateRenderView(boolean r100, boolean r101) {
        IRenderView r102 = getRenderView();
        if (getClient().getRenderView() != null) goto L5;
    L12:
        setRenderView(createRenderView(getContext()));
    L13:
        if (r100 == false) goto L16;
        if (r101 == false) goto L16;
        getRenderView().setVrMode(r100);
        getRenderView().setVrStyle(10001);
    L16:
        if (r101 == true) goto L18;
        this.mainCameraRenderView = getRenderView();
    L19:
        removeAllViews();
        if (getClient().context().isSharedClient() == true) goto L22;
    L28:
        attachRenderView();
        return;
    L22:
        if (getOptimizeConfig().getSetVideoSizeWithSharePlayer() != true) goto L28;
        Pair<Integer, Integer> r103 = getClient().getVideoSize();
        if (r103.getFirst().intValue() == 0) goto L28;
        if (r103.getSecond().intValue() == 0) goto L28;
        getRenderView().setVideoSize(r103.getFirst().intValue(), r103.getSecond().intValue());
        goto L28
    L18:
        this.mainCameraRenderView = r102;
        goto L19
    L5:
        if (getClient().context().isSharedClient() == false) goto L12;
        if (this.config.getReusePreSceneTextureRenderView() == false) goto L12;
        IRenderView r104 = this.sharePlayerController.usePreSceneTextureRenderView();
        if (r104 != null) goto L11;
        r104 = createRenderView(getContext());
    L11:
        setRenderView(r104);
        goto L13
    }

    public LivePlayerView(Context r100, LivePlayerConfig r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "config");
        this(r100, null, 0, r110, 6, null);
    }

    public LivePlayerView(Context r210, AttributeSet r211, int r212, LivePlayerConfig r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r213, "_Config");
        super(r210, r211, r212);
        this.TAG = "live_player_view";
        this.TYPE_NPRMAL = 1;
        this.TYPE_VS_FIRST_SHOW = 2;
        this.VIEW_TYPE_TEXTURE = 3;
        this.VIEW_TYPE_SURFACE = 4;
        this.VIEW_TYPE_KEEP_TEXTURE = 5;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.config = new LivePlayerConfig(ILivePlayerScene.Companion.preview(), null, null, false, null, false, false, null, false, 0, false, 2046, null);
        this.livePlayerService$delegate = LazyKt.lazy(LivePlayerView$livePlayerService$2.INSTANCE);
        this.optimizeConfig$delegate = LazyKt.lazy(new LivePlayerView$optimizeConfig$2(this));
        this.interceptorList = new ArrayList();
        this.attachSurfaceListenerList = new ArrayList();
        this.config = r213;
        initXmlAttrs(r211, r210);
        ILivePlayerClient r100 = this.config.getClient();
        if (r100 != null) goto L5;
        r100 = getLivePlayerService().createClient(this.config);
    L5:
        setClient(r100);
        if (r210.getApplicationContext() == null) goto L8;
        getClient().setApplicationContext(r210.getApplicationContext());
    L8:
        this.sharePlayerController = new LivePlayerShareController(this);
        if (getClient().context().isSharedClient() == false) goto L12;
        getClient().context().setPreviewSurfaceView(getClient().getRenderView() instanceof SurfaceRenderView);
    L12:
        if (getClient().getRenderView() != null) goto L14;
    L21:
        setRenderView(createRenderView(r210));
    L23:
        if (this.config.isVrRoom() == false) goto L25;
        getRenderView().setVrMode(this.config.isVrRoom());
        getRenderView().setVrStyle(10001);
    L25:
        trySetRenderViewVideoSize();
        attachRenderView();
        if (this.config.getObserverLiveStatus() == false) goto L28;
        getLiveStatusController().observeLiveStatus(getClient());
    L28:
        IExtraRenderView r101 = createExtraRenderView();
        this.extraRenderView = r101;
        if (r101 == null) goto L31;
        addView(r101.selfView());
    L31:
        logPlayerView$default(this, this.config.getScene() + " player view create, bind client@" + getClient().hashCode(), false, 2, null);
        return;
    L14:
        if (getClient().context().isSharedClient() == false) goto L21;
        if (this.config.getReusePreSceneTextureRenderView() == false) goto L21;
        IRenderView r102 = this.sharePlayerController.usePreSceneTextureRenderView();
        if (r102 != null) goto L20;
        r102 = createRenderView(r210);
    L20:
        setRenderView(r102);
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void resumePlay$default(LivePlayerView r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.resumePlay(r101);
    }

    public /* synthetic */ LivePlayerView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public static /* synthetic */ void logPlayerView$default(LivePlayerView r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        r100.logPlayerView(r101, r102);
    }

    public /* synthetic */ LivePlayerView(Context r100, AttributeSet r101, int r102, LivePlayerConfig r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, r103);
    }

    @Deprecated(message = "兼容旧的API")
    public LivePlayerView(Context r110, AttributeSet r111, int r112, long r210, PlayerClientType r211, PlayerClientScene r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "clientType");
        Intrinsics.checkNotNullParameter(r212, "clientScene");
        ILivePlayerScene r100 = ILivePlayerScene.Companion.scene(r212.getScene());
        String r101 = String.valueOf(r210);
        boolean r102 = false;
        ILivePlayerClient r103 = null;
        boolean r104 = false;
        boolean r105 = false;
        if (r213 == false) goto L5;
        IRenderView.RenderViewType r106 = IRenderView.RenderViewType.SURFACE_VIEW;
    L6:
        this(r110, r111, r112, new LivePlayerConfig(r100, r101, r211, r102, r103, r104, r105, r106, false, 0, false, 1912, null));
        return;
    L5:
        r106 = IRenderView.RenderViewType.TEXTURE_VIEW;
        goto L6
    }

    public /* synthetic */ LivePlayerView(Context r110, AttributeSet r111, int r112, long r113, PlayerClientType r114, PlayerClientScene r115, boolean r116, int r117, DefaultConstructorMarker r210) {
        if ((r117 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r117 & 16) == 0) goto L13;
        PlayerClientType r102 = PlayerClientType.NORMAL;
    L15:
        if ((r117 & 32) == 0) goto L17;
        PlayerClientScene r103 = PlayerClientScene.PREVIEW;
    L19:
        if ((r117 & 64) == 0) goto L21;
        boolean r104 = false;
    L22:
        this(r110, r100, r101, r113, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Deprecated(message = "兼容旧的API")
    public LivePlayerView(Context r110, AttributeSet r111, int r112, long r210, long r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILivePlayerScene r100 = ILivePlayerScene.Companion.preview();
        String r101 = String.valueOf(r210);
        if (r215 == false) goto L5;
        PlayerClientType r102 = PlayerClientType.FIRST_SHOW;
    L6:
        this(r110, r111, r112, new LivePlayerConfig(r100, r101, r102, false, null, false, false, null, false, 0, false, 2040, null));
        return;
    L5:
        r102 = PlayerClientType.NORMAL;
        goto L6
    }

    public /* synthetic */ LivePlayerView(Context r110, AttributeSet r111, int r112, long r113, long r114, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L6:
        boolean r101 = false;
        if ((r215 & 4) == 0) goto L9;
        int r102 = 0;
    L10:
        long r103 = 0;
        if ((r215 & 8) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r215 & 16) != 0) goto L19;
        r103 = r114;
    L19:
        if ((r215 & 32) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r215 & 64) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r215 & 128) == 0) goto L29;
        boolean r115 = false;
    L31:
        if ((r215 & 256) == 0) goto L33;
        boolean r116 = false;
    L35:
        if ((r215 & 512) != 0) goto L38;
        r101 = r214;
    L38:
        this(r110, r100, r102, r104, r103, r105, r106, r115, r116, r101);
        return;
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L13:
        r104 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L10
    L5:
        r100 = r111;
        goto L6
    }
}
