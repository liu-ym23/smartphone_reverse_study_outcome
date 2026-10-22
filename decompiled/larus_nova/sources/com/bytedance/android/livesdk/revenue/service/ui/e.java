package com.bytedance.android.livesdk.revenue.service.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements c {
    public e() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.ui.c
    public final f C9(DataCenter r100, int r101, Context r110, View r111, aq2.a r112) {
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "cardConfig");
        return new f(new RevCardWindow(r100, r110, r101, r111, r112));
    }
}
