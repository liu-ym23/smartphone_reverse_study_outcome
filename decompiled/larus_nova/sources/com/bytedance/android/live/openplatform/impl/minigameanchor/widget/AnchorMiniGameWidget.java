package com.bytedance.android.live.openplatform.impl.minigameanchor.widget;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.openplatform.impl.minigameanchor.context.LiveAnchorMiniGameContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/widget/AnchorMiniGameWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniGameWidget extends RoomWidget {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f85278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveAnchorMiniGameContext f85279c;

    public AnchorMiniGameWidget() {
        this.f85278b = "AnchorMiniGameWidget";
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.RoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        Logger.d(this.f85278b, WidgetCostModule.TYPE_ON_CREATE);
        if (this.context != null) goto L5;
        return;
    L5:
        LiveAnchorMiniGameContext r100 = new LiveAnchorMiniGameContext(this.context, this.dataCenter, this.containerView);
        this.f85279c = r100;
        r100.dispatchLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        Logger.d(this.f85278b, LiveCommonConstants.REASON_ON_DEDTROY);
        LiveAnchorMiniGameContext r100 = this.f85279c;
        if (r100 == null) goto L6;
        r100.dispatchLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    }
}
