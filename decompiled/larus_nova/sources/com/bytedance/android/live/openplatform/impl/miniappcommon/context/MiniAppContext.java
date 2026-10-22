package com.bytedance.android.live.openplatform.impl.miniappcommon.context;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
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
import kotlin.jvm.internal.Intrinsics;
import vq0.b;
import vq0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/MiniAppContext;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "appExited", "", "appStopped", "value", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "miniAppInstance", "getMiniAppInstance", "()Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "setMiniAppInstance", "(Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;)V", "miniAppLifecycleChangeListeners", "", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/OnMiniAppLifecycleChangeListener;", "notifyMiniAppLifecycleChange", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/OnMiniAppLifecycleChangeListener$MiniAppLifecycle;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onMiniAppInstanceCreate", "instance", "onMiniAppInstanceDestroy", "registerMiniAppLifecycleChangeListener", "listener", "tryClearMiniAppInstance", "type", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/MiniAppContext$StopType;", "unregisterMiniAppLifecycleChangeListener", "StopType", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppContext extends OpenPlatformContext {
    private boolean appExited;
    private boolean appStopped;
    private MiniAppInstance miniAppInstance;
    private final List<OnMiniAppLifecycleChangeListener> miniAppLifecycleChangeListeners;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/MiniAppContext$StopType;", "", "ON_APP_EXIT", "ON_MINI_APP_STOP", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StopType extends Enum<StopType> {
        public static final StopType ON_APP_EXIT = null;
        public static final StopType ON_MINI_APP_STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StopType[] f85010a = null;

        static {
            StopType r100 = new StopType("ON_APP_EXIT", 0);
            ON_APP_EXIT = r100;
            StopType r101 = new StopType("ON_MINI_APP_STOP", 1);
            ON_MINI_APP_STOP = r101;
            f85010a = new StopType[]{r100, r101};
        }

        public static StopType valueOf(String r100) {
            return (StopType) r27.a.a(StopType.class, r100);
        }

        public static StopType[] values() {
            return (StopType[]) f85010a.clone();
        }

        public StopType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext, androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public void onMiniAppInstanceDestroy() {
        notifyMiniAppLifecycleChange(OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnDestroy);
        ((BridgeContextService) getService(BridgeContextService.class)).f();
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        if (isAnchor() == false) goto L5;
        Pair r100 = d.a(MiniAppContext$onCreate$pair$1.INSTANCE);
    L6:
        ((MiniAppDataContext) r100.getFirst()).share();
        autoDispose((Disposable) r100.getSecond());
        return;
    L5:
        r100 = d.a(MiniAppContext$onCreate$pair$2.INSTANCE);
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        setMiniAppInstance(null);
        this.miniAppLifecycleChangeListeners.clear();
    }

    public final MiniAppInstance getMiniAppInstance() {
        return this.miniAppInstance;
    }

    public final void notifyMiniAppLifecycleChange(OnMiniAppLifecycleChangeListener.MiniAppLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Iterator<T> r101 = this.miniAppLifecycleChangeListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        OnMiniAppLifecycleChangeListener r102 = (OnMiniAppLifecycleChangeListener) r101.next();
        int r103 = a.f85012a[r100.ordinal()];
        if (r103 != 1) goto L8;
        r102.b();
        goto L4
    L8:
        if (r103 != 2) goto L10;
        r102.c();
        goto L4
    L10:
        if (r103 != 3) goto L12;
        r102.a();
        goto L4
    L12:
        if (r103 != 4) goto L4;
        r102.d();
        goto L4
    }

    public void onMiniAppInstanceCreate(MiniAppInstance r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        notifyMiniAppLifecycleChange(OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnCreate);
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_click_more", new vq0.d(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_app_resume", new b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_app_stop", new c(this));
    }

    public final void registerMiniAppLifecycleChangeListener(OnMiniAppLifecycleChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.miniAppLifecycleChangeListeners.add(r100);
    }

    public final void setMiniAppInstance(MiniAppInstance r100) {
        if (r100 == null) goto L4;
        this.miniAppInstance = r100;
        onMiniAppInstanceCreate(r100);
        return;
    L4:
        onMiniAppInstanceDestroy();
        this.miniAppInstance = null;
        this.appExited = false;
        this.appStopped = false;
    }

    public final void tryClearMiniAppInstance(StopType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = a.f85013b[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.appExited = true;
    L10:
        if (this.appExited == true) goto L12;
        return;
    L12:
        if (this.appStopped == false) goto L16;
        setMiniAppInstance(null);
        return;
    L16:
        return;
    L5:
        if (r101 != 2) goto L10;
        this.appStopped = true;
        goto L10
    }

    public final void unregisterMiniAppLifecycleChangeListener(OnMiniAppLifecycleChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.miniAppLifecycleChangeListeners.remove(r100);
    }

    public MiniAppContext(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.miniAppLifecycleChangeListeners = new ArrayList();
    }
}
