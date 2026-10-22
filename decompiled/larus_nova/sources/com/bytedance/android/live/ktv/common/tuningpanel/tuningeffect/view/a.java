package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import androidx.recyclerview.widget.DiffUtil;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningEffectAdapter f70541a;

    public a(TuningEffectAdapter r100) {
        this.f70541a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<DiffUtil.DiffResult> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        TuningEffectAdapter r101 = this.f70541a;
        r100.onSuccess(DiffUtil.calculateDiff(new TuningEffectAdapter.DiffCallback(r101.f70526b, r101.f70525a)));
    }
}
