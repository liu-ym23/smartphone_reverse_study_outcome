package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/RecordBacktrackCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordBacktrackCompositeWidget extends MiddlewareRoomWidget {
    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (this.dataCenter.get("data_backtrack_service", null) != null) goto L6;
        DataCenter r100 = this.dataCenter;
        r100.put("data_backtrack_service", new zf1.b0(r100, zf1.c.b(getContext())));
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        IAnchorBacktrackService r100 = (IAnchorBacktrackService) this.dataCenter.get("data_backtrack_service", null);
        if (r100 == null) goto L6;
        r100.release();
        this.dataCenter.put("data_backtrack_service", null);
        return;
    }

    public RecordBacktrackCompositeWidget() {
    }
}
