package com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/broadcast/v2/component/comp/AbsShellWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShellWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f105405a;

    public void wq() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
        d r100 = this.f105405a;
        if (r100 != null) goto L5;
    L7:
        wq();
        return;
    L5:
        if (r100.f105446c != true) goto L7;
    }

    public AbsShellWidget() {
    }
}
