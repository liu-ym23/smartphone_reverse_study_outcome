package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.network;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "SessionGlobalConfigNetTask";
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }

    @Override // gs2.a
    public final void run() {
        a.a();
    }
}
