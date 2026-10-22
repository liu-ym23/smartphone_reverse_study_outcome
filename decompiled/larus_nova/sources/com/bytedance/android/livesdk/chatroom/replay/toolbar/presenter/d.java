package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f110159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f110160b;

    public d(a r100, View r101) {
        this.f110159a = r100;
        this.f110160b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (v.a() == false) goto L5;
        r101.printStackTrace();
    L5:
        ALogger.e("VS_TOOLBAR", "do onApplyButtonCountForMetricsZero in error scope,e:" + r101);
        NextLiveData<Integer> r102 = this.f110159a.f110152f;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L8;
        Integer r104 = Integer.valueOf(r103.intValue() - 1);
    L9:
        r102.setValue(r104);
        View r105 = this.f110160b;
        if (r105 == null) goto L13;
        r105.setVisibility(8);
        return;
    L13:
        return;
    L8:
        r104 = null;
        goto L9
    }
}
