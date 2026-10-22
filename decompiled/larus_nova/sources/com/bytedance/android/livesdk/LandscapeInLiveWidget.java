package com.bytedance.android.livesdk;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/LandscapeInLiveWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeInLiveWidget extends LiveRecyclableWidget implements Observer<KVData> {
    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_landscape_in_live;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.removeObserver("need_hide_landscape_in_live_widget", this);
        return;
    }

    public LandscapeInLiveWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == false) goto L8;
        return;
    L8:
        if (TextUtils.equals(r101.getKey(), "need_hide_landscape_in_live_widget") == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual((Boolean) r101.getData(Boolean.FALSE), Boolean.TRUE) == false) goto L21;
        ViewGroup r102 = this.containerView;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.getVisibility() != 0) goto L23;
        ViewGroup r103 = this.containerView;
        if (r103 == null) goto L24;
        r103.setVisibility(4);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L5;
        r101.put("need_hide_landscape_in_live_widget", Boolean.TRUE);
    L5:
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L9;
        r102.observe("need_hide_landscape_in_live_widget", this);
        return;
    }
}
