package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.app.dataholder.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class q2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f117344a;

    public q2(p2 r100) {
        this.f117344a = r100;
    }

    @Override // com.bytedance.android.livesdk.app.dataholder.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        ALogger.w("ClearScreenWaterTetris", "called link state observer from ToolbarClearScreenBehavior. state: " + r101);
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.intValue() != 2) goto L9;
        this.f117344a.getClass();
        return;
    }
}
