package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements dw.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<dw.h, IVideoFloatManager.VideoFloatManagerListener> f125447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f125448b;

    @Override // dw.g
    public final boolean isFloatViewShowing() {
        return this.f125448b.isFloatViewShowing();
    }

    @Override // dw.g
    public final void stopFloatView() {
        this.f125448b.stopFloatView();
    }

    public m() {
        this.f125447a = new HashMap();
        this.f125448b = new k();
    }

    @Override // dw.g
    public final void c(com.bytedance.android.gamecp.business.gamedetail.m r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        IVideoFloatManager.VideoFloatManagerListener r101 = this.f125447a.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        this.f125448b.removeFloatViewStatusObserver(r101);
        this.f125447a.remove(r100);
    }

    @Override // dw.g
    public final void d(com.bytedance.android.gamecp.business.gamedetail.m r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        l r101 = new l(r100);
        this.f125447a.put(r100, r101);
        this.f125448b.addFloatViewStatusObserver(r101);
    }

    @Override // dw.g
    public final void b(Context r100, HashMap r101) {
        this.f125448b.showFloatViewNow(r100, null, true, false, null, r101);
    }

    @Override // dw.g
    public final void a(DialogFragment r100, FrameLayout r110, boolean r111, boolean r112, HashMap r113) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r110, "rootView");
        this.f125448b.showFloatViewNow(r100, r110, null, r111, r112, null, r113);
    }
}
