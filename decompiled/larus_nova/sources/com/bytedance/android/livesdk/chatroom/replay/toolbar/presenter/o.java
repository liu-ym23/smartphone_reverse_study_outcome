package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends a {
    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public final boolean f() {
        return true;
    }

    public o(LifecycleOwner r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, r101);
    }
}
