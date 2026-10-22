package com.bytedance.android.live.core.arch.mvi.widgetcompat;

import com.bytedance.android.livesdk.utils.a2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements a2<DataContext> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MVIDataWidget f64751a;

    @Override // com.bytedance.android.livesdk.utils.a2
    public final DataCenter getDataCenter() {
        return this.f64751a.dataCenter;
    }

    public a(MVIDataWidget r100) {
        this.f64751a = r100;
    }
}
