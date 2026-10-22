package com.bytedance.android.live.openplatform.impl.minigamecommon.context;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lr0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001'B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "containerView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "appExited", "", "appStopped", "getContainerView", "()Landroid/view/ViewGroup;", "value", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "miniGameInstance", "getMiniGameInstance", "()Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "setMiniGameInstance", "(Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;)V", "miniGameLifecycleChangeListeners", "", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/OnMiniGameLifecycleChangeListener;", "notifyMiniGameLifecycleChange", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/OnMiniGameLifecycleChangeListener$MiniGameLifecycle;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onMiniGameInstanceCreate", "instance", "onMiniGameInstanceDestroy", "registerMiniGameLifecycleChangeListener", "listener", "tryClearMiniGameInstance", "type", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext$StopType;", "unregisterMiniGameLifecycleChangeListener", "StopType", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniGameContext extends OpenPlatformContext {
    private boolean appExited;
    private boolean appStopped;
    private final ViewGroup containerView;
    private MiniAppInstance miniGameInstance;
    private final List<OnMiniGameLifecycleChangeListener> miniGameLifecycleChangeListeners;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext$StopType;", "", "ON_GAME_EXIT", "ON_MINI_GAME_STOP", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StopType extends Enum<StopType> {
        public static final StopType ON_GAME_EXIT = null;
        public static final StopType ON_MINI_GAME_STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StopType[] f85359a = null;

        static {
            StopType r100 = new StopType("ON_GAME_EXIT", 0);
            ON_GAME_EXIT = r100;
            StopType r101 = new StopType("ON_MINI_GAME_STOP", 1);
            ON_MINI_GAME_STOP = r101;
            f85359a = new StopType[]{r100, r101};
        }

        public static StopType valueOf(String r100) {
            return (StopType) r27.a.a(StopType.class, r100);
        }

        public static StopType[] values() {
            return (StopType[]) f85359a.clone();
        }

        public StopType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext, androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public void onMiniGameInstanceDestroy() {
        notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnDestroy);
        ((BridgeContextService) getService(BridgeContextService.class)).f();
        this.miniGameLifecycleChangeListeners.clear();
        if (isAnchor() == true) goto L13;
        SchemaInfo.b r100 = SchemaInfo.f83978s;
        MiniAppInstance r101 = this.miniGameInstance;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getSchema();
    L8:
        r100.getClass();
        SchemaInfo r104 = SchemaInfo.b.b(r103);
        if (r104 == null) goto L12;
        r102 = r104.d();
    L12:
        if (Intrinsics.areEqual(r102, "smallrocker_exp") == true) goto L13;
        return;
    L7:
        r103 = null;
    L13:
        BridgeContextService r105 = (BridgeContextService) getService(BridgeContextService.class);
        Bundle r106 = new Bundle();
        r106.putString("from", "live_stop");
        Unit r107 = Unit.INSTANCE;
        r105.g("command_kill_minigame", r106);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        if (isAnchor() == false) goto L5;
        Pair r100 = d.a(MiniGameContext$onCreate$pair$1.INSTANCE);
    L6:
        ((MiniGameDataContext) r100.getFirst()).share();
        autoDispose((Disposable) r100.getSecond());
        return;
    L5:
        r100 = d.a(MiniGameContext$onCreate$pair$2.INSTANCE);
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        setMiniGameInstance(null);
        this.miniGameLifecycleChangeListeners.clear();
    }

    public final ViewGroup getContainerView() {
        return this.containerView;
    }

    public final MiniAppInstance getMiniGameInstance() {
        return this.miniGameInstance;
    }

    public final void notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Iterator<T> r101 = this.miniGameLifecycleChangeListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L21;
        OnMiniGameLifecycleChangeListener r102 = (OnMiniGameLifecycleChangeListener) r101.next();
        int r103 = a.f85361a[r100.ordinal()];
        if (r103 != 1) goto L8;
        r102.a();
        goto L4
    L8:
        if (r103 != 2) goto L10;
        r102.e();
        goto L4
    L10:
        if (r103 != 3) goto L12;
        r102.c();
        goto L4
    L12:
        if (r103 != 4) goto L14;
        r102.d();
        goto L4
    L14:
        if (r103 != 5) goto L4;
        r102.b();
        goto L4
    }

    public void onMiniGameInstanceCreate(MiniAppInstance r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnCreate);
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_game_interrupt", new lr0.d(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_game_exit", new c(this));
    }

    public final void registerMiniGameLifecycleChangeListener(OnMiniGameLifecycleChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.miniGameLifecycleChangeListeners.add(r100);
    }

    public final void setMiniGameInstance(MiniAppInstance r100) {
        if (r100 == null) goto L4;
        this.miniGameInstance = r100;
        onMiniGameInstanceCreate(r100);
        return;
    L4:
        onMiniGameInstanceDestroy();
        this.miniGameInstance = null;
        this.appExited = false;
        this.appStopped = false;
    }

    public final void tryClearMiniGameInstance(StopType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = a.f85362b[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.appExited = true;
        return;
    L5:
        if (r101 != 2) goto L11;
        this.appStopped = true;
        return;
    }

    public final void unregisterMiniGameLifecycleChangeListener(OnMiniGameLifecycleChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.miniGameLifecycleChangeListeners.remove(r100);
    }

    public MiniGameContext(Context r100, DataCenter r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.containerView = r102;
        this.miniGameLifecycleChangeListeners = new ArrayList();
    }
}
