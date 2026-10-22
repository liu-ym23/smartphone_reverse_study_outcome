package com.bytedance.android.livesdk.chatroom.replay.toolbar.descriptor;

import com.bytedance.android.livesdk.chatroom.replay.toolbar.widget.ReplayScheduleCloseWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends i<uq1.b> {
    public f() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ReplayScheduleCloseWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.f551178e;
    }
}
