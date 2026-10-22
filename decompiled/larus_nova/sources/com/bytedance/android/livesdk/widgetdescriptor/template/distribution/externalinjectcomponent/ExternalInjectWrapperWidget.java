package com.bytedance.android.livesdk.widgetdescriptor.template.distribution.externalinjectcomponent;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IExternalInjectComponent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/widgetdescriptor/template/distribution/externalinjectcomponent/ExternalInjectWrapperWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalInjectWrapperWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IExternalInjectComponent f162492a;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final View getLayoutView() {
        IExternalInjectComponent r100 = this.f162492a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLayoutView();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        IExternalInjectComponent r100 = this.f162492a;
        if (r100 == null) goto L9;
        ViewGroup r101 = this.containerView;
        if ((r101 instanceof ViewGroup) == true) goto L7;
        r101 = null;
    L7:
        r100.setContainer(r101);
        r100.setContext(this.context);
        r100.onCreate();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        IExternalInjectComponent r100 = this.f162492a;
        if (r100 == null) goto L14;
        r100.onDestroy();
    L14:
        ViewGroup r101 = this.containerView;     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        r101.removeAllViews();     // Catch: Exception -> L9
        return;
    L12:
        return;
    L9:
        e = move-exception;
        if (v.a() == false) goto L16;
        throw e;
    }

    public ExternalInjectWrapperWidget() {
    }
}
