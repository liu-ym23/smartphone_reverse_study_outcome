package com.bytedance.android.live.revlink.scopeui;

import android.content.res.Configuration;
import b03.b;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import j11.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/scopeui/KmpWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KmpWidget extends LiveWidget {
    public abstract b wq(Object r100);

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void enableSubWidgetManager() {
        super.enableSubWidgetManager();
        WidgetManager r100 = this.subWidgetManager;
        if ((r100 instanceof RecyclableWidgetManager) == true) goto L5;
        r100 = null;
    L5:
        RecyclableWidgetManager r101 = (RecyclableWidgetManager) r100;
        if (r101 == null) goto L9;
        r101.f65951h = true;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
        a r100 = a.f496860d;
        r100.getClass();
        if (((Boolean) a.f496859c.getValue(r100, a.f496857a[1])).booleanValue() == false) goto L6;
        this.widgetCallback = null;
        return;
    }

    public KmpWidget() {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        wq(r100);
    }
}
