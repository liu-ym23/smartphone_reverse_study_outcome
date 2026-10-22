package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.common.utility.Logger;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenuelink/AnchorLinkLoadWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkLoadWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f91709a;

    public AnchorLinkLoadWidget() {
        this.f91709a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        wq(true);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r100 = this.f91709a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        wq(false);
    }

    public final void wq(boolean r100) {
        StringBuilder r101 = new StringBuilder("component ");
        if (r100 == false) goto L5;
        String r102 = "load";
    L6:
        r101.append(r102);
        r101.append(" success, elementType is ");
        r101.append(getElementType());
        r101.append(", class is AnchorLinkLoadWidget");
        Logger.i("InteractionFrameworkTracer", r101.toString());
        return;
    L5:
        r102 = "unload";
        goto L6
    }
}
