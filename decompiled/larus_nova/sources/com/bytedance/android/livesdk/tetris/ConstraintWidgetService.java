package com.bytedance.android.livesdk.tetris;

import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.layer.core.layout.IConstraintWidgetService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/tetris/ConstraintWidgetService;", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/IConstraintWidgetService;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "layout", "Landroid/view/View;", "view", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/b$a;", "getViewWidget", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ConstraintWidgetService implements IConstraintWidgetService {
    public ConstraintWidgetService() {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.IConstraintWidgetService
    public com.bytedance.android.live.core.tetris.layer.core.layout.b.a getViewWidget(ConstraintLayout r100, View r101) {
        if (r100 == null) goto L8;
        ConstraintWidget r102 = r100.getViewWidget(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new com.bytedance.android.live.core.tetris.layer.core.layout.b.a(r102.getLeft(), r102.getRight(), r102.getTop(), r102.getBottom());
    L8:
        return null;
    }
}
