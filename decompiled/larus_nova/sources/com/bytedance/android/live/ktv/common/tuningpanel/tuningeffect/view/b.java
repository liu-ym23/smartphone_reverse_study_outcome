package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import androidx.recyclerview.widget.DiffUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningEffectAdapter f70542a;

    public b(TuningEffectAdapter r100) {
        this.f70542a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((DiffUtil.DiffResult) r100).dispatchUpdatesTo(this.f70542a);
    }
}
