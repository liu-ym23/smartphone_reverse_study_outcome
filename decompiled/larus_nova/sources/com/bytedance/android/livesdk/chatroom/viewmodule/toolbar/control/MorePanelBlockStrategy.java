package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class MorePanelBlockStrategy implements e {
    public MorePanelBlockStrategy() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.e
    public final void a(final a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "dialogInterface");
        Intrinsics.checkNotNullParameter(r101, "requestInterface");
        ALogger.i("MorePanelDynamic", "MorePanelBlockStrategy");
        r101.requestData(2, new MorePanelBlockStrategy$openDialog$1(r100), new MorePanelBlockStrategy$openDialog$2(r100));
    }
}
