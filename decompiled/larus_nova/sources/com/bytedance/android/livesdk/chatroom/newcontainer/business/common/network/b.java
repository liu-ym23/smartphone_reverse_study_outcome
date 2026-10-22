package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.network;

import com.bytedance.android.live.room.e;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.room.Task.base.a<d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "PlayerDnsOptInitTask";
    }

    @Override // gs2.a
    public final void run() {
        e r100 = is0.c.c().dnsOptimizer();
        if (r100 == null) goto L6;
        r100.sync();
        return;
    }

    public b() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
