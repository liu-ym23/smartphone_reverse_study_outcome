package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.app.Activity;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.projectmode.EmptyDebugWidget;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements yr1.e, com.bytedance.android.scope.o {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yr1.e
    public final Class<? extends Widget> c() {
        ILiveSdkProjectModeService r100 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r100 == null) goto L6;
        Class<? extends LiveRecyclableWidget> r101 = r100.getDebugTestInfoElementClass();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return EmptyDebugWidget.class;
    }

    @Override // yr1.e
    public final void a(Activity r100) {
        ILiveSdkProjectModeService r101 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r101 == null) goto L6;
        r101.showLiveDebugDialog(r100);
        return;
    }
}
