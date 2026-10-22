package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements e {
    public g() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.e
    public final void a(a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "dialogInterface");
        Intrinsics.checkNotNullParameter(r101, "requestInterface");
        ALogger.i("MorePanelDynamic", "MorePanelOnlyLocalDataStrategy");
        r100.a();
    }
}
