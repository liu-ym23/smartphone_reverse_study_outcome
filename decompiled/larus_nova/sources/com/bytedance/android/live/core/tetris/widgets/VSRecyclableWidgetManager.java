package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/VSRecyclableWidgetManager;", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSRecyclableWidgetManager extends RecyclableWidgetManager {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f65953l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f65954k;

    public static final class a {
    }

    static {
    }

    public VSRecyclableWidgetManager() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager, com.bytedance.ies.sdk.widgets.WidgetManager
    public final void continueLoad(Widget r100, ViewGroup r101, View r102) {
        b r103 = this.f65954k;
        if (r103 == null) goto L5;
        r103.intercept();
        return;
    L5:
        super.continueLoad(r100, r101, r102);
    }
}
