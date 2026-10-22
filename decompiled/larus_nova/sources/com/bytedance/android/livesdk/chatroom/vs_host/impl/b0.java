package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements vr1.y, com.bytedance.android.scope.o {
    public b0() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.y
    public final NextLiveData<Boolean> a(DataCenter r100) {
        if (r100 == null) goto L8;
        p0 r101 = (p0) r100.get("zygote_event_hub", null);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getStartPull();
    L8:
        return null;
    }

    @Override // vr1.y
    public final NextLiveData<Boolean> c(DataCenter r100) {
        if (r100 == null) goto L8;
        p0 r101 = (p0) r100.get("zygote_event_hub", null);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getShowLiveEnd();
    L8:
        return null;
    }

    @Override // vr1.y
    public final NextLiveData<Boolean> d(DataCenter r100) {
        if (r100 == null) goto L8;
        p0 r101 = (p0) r100.get("zygote_event_hub", null);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSwitchStreamDataEvent();
    L8:
        return null;
    }
}
