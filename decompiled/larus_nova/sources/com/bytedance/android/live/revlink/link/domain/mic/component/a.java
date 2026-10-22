package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FollowComponent f98461a;

    public a(FollowComponent r100) {
        this.f98461a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        NextLiveData<Boolean> r101 = this.f98461a.f98454b;
        if (((Integer) r100).intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        r101.setValue(Boolean.valueOf(r102));
        return;
    L5:
        r102 = false;
        goto L6
    }
}
