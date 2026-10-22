package com.bytedance.android.livesdkapi.distribution.externalinjectcomponent;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u0004H&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u00020 H&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IExternalInjectComponent;", "", "()V", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "eventBus", "Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IRoomEventBus;", "getEventBus", "()Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IRoomEventBus;", "setEventBus", "(Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IRoomEventBus;)V", "roomInfoProvider", "Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IRoomInfoProvider;", "getRoomInfoProvider", "()Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IRoomInfoProvider;", "setRoomInfoProvider", "(Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IRoomInfoProvider;)V", "getLayoutView", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "tag", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IExternalInjectComponent {
    private ViewGroup container;
    private Context context;
    private IRoomEventBus eventBus;
    private IRoomInfoProvider roomInfoProvider;

    public IExternalInjectComponent() {
    }

    public abstract ViewGroup getLayoutView();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract String tag();

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final Context getContext() {
        return this.context;
    }

    public final IRoomEventBus getEventBus() {
        return this.eventBus;
    }

    public final IRoomInfoProvider getRoomInfoProvider() {
        return this.roomInfoProvider;
    }

    public final void setContainer(ViewGroup r100) {
        this.container = r100;
    }

    public final void setContext(Context r100) {
        this.context = r100;
    }

    public final void setEventBus(IRoomEventBus r100) {
        this.eventBus = r100;
    }

    public final void setRoomInfoProvider(IRoomInfoProvider r100) {
        this.roomInfoProvider = r100;
    }
}
