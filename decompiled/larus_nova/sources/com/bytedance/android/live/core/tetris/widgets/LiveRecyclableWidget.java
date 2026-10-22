package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public abstract class LiveRecyclableWidget extends LiveWidget implements a {
    public static final String ALOG_TAG_WIDGET = "ttlive_widget";
    private final String TAG;
    private boolean alive;
    private Object[] args;
    private boolean clearAfterDestroyed;
    private boolean initialized;
    private boolean onAsyncLoading;
    private boolean recyclable;

    public String getNitaTag() {
        return "";
    }

    public void handleRoomVisible() {
    }

    public boolean isRecyclableOnRotation() {
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        this.alive = true;
        super.onCreate();
        if (this.initialized == true) goto L13;
        onInit(this.args);
        f r100 = this.widgetLifeCycleObserver;
        if (r100 == null) goto L12;
        List<? extends e80.a> r101 = r100.f65984a;
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        ((e80.a) r102.next()).g(r100.f65985b);
    L12:
        this.initialized = true;
    L13:
        onLoad(this.args);
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L16;
        handleRoomVisible();
    L16:
        f r103 = this.widgetLifeCycleObserver;
        if (r103 == null) goto L33;
        List<? extends e80.a> r104 = r103.f65984a;
        if (r104 == null) goto L24;
        Iterator<T> r105 = r104.iterator();
    L22:
        if (r105.hasNext() == false) goto L24;
        ((e80.a) r105.next()).onLoad(r103.f65985b);
    L24:
        Widget r106 = r103.f65985b;
        if (r106 == null) goto L27;
        DataCenter r107 = r106.dataCenter;
    L28:
        if (r107 != null) goto L34;
        f.a(WidgetCostModule.TYPE_ON_LOAD);
        return;
    L34:
        return;
    L27:
        r107 = null;
        goto L28
    }

    public abstract void onInit(Object[] r100);

    public abstract void onLoad(Object[] r100);

    public abstract void onUnload();

    @Override // com.bytedance.android.live.core.tetris.widgets.a
    public final void setRecyclable() {
        this.recyclable = true;
    }

    public void slideRecyclerListToEnd() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.a
    public final void clearAfterDestroyed() {
        if (this.alive == false) goto L6;
        this.clearAfterDestroyed = true;
        return;
    L6:
        if (this.isDestroyed == false) goto L10;
        onClear();
        return;
    }

    public boolean isScreenPortrait() {
        DataCenter r100 = this.dataCenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return ((Boolean) r100.get("data_is_portrait", Boolean.FALSE)).booleanValue();
    }

    public void onClear() {
        f r100 = this.widgetLifeCycleObserver;
        if (r100 == null) goto L10;
        List<? extends e80.a> r101 = r100.f65984a;
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        ((e80.a) r102.next()).a(r100.f65985b);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public LiveRecyclableWidget() {
        this.TAG = getClass().getSimpleName();
        this.recyclable = false;
    }

    public boolean isScreenLandscape() {
        return !isScreenPortrait();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        if (getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L36;
        View r100 = this.contentView;
        if (r100 == null) goto L12;
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L12;
        r101.removeView(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e(ALOG_TAG_WIDGET, getClass().getSimpleName().concat(" destroy crash."), e);
    L12:
        releaseSubWidgetManager();
    L36:
        onUnload();     // Catch: Exception -> L23
        f r102 = this.widgetLifeCycleObserver;     // Catch: Exception -> L23
        if (r102 == null) goto L25;
        List<? extends e80.a> r103 = r102.f65984a;     // Catch: Exception -> L23
        if (r103 == null) goto L25;
        Iterator<T> r104 = r103.iterator();     // Catch: Exception -> L23
    L20:
        if (r104.hasNext() == false) goto L25;
        ((e80.a) r104.next()).j(r102.f65985b);     // Catch: Exception -> L23
    L25:
        super.onDestroy();
        this.dataCenter = null;
        if (getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L28;
        this.containerView = null;
        setWidgetCallback(null);
        this.args = null;
        this.context = null;
    L28:
        this.alive = false;
        if (this.clearAfterDestroyed == false) goto L31;
    L32:
        onClear();
        this.initialized = false;
        return;
    L31:
        if (this.recyclable == false) goto L32;
        return;
    L23:
        e = move-exception;
        SafetyGuard.a(null, e, "LiveRecyclableWidget onUnload error");
        goto L25
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public void onMergeUnLoad() {
        super.onMergeUnLoad();
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L16;
        View r100 = this.contentView;
        if (r100 == null) goto L12;
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L12;
        r101.removeView(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e(ALOG_TAG_WIDGET, getClass().getSimpleName().concat(" destroy crash."), e);
    L12:
        releaseSubWidgetManager();
        this.containerView = null;
        setWidgetCallback(null);
        this.args = null;
        this.context = null;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.a
    public final boolean isAlive() {
        return this.alive;
    }

    public boolean isAsyncLoading() {
        return this.onAsyncLoading;
    }

    public final boolean isInitialized() {
        return this.initialized;
    }

    public Boolean recylerViewIsBottom() {
        return Boolean.FALSE;
    }

    public void enqueueRunnableToMainThread(Runnable r100) {
        if (k60.b.a() == false) goto L5;
        i0.i(c50.b.b(this.dataCenter), r100);
        return;
    L5:
        r100.run();
    }

    public final void setArgs(Object[] r100) {
        this.args = r100;
    }

    public void setIsAsyncLoading(Boolean r100) {
        this.onAsyncLoading = r100.booleanValue();
    }
}
