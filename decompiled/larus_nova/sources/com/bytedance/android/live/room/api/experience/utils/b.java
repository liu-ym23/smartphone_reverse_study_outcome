package com.bytedance.android.live.room.api.experience.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f98914a = null;

    static {
        f98914a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        IStrategyService r101 = (IStrategyService) k.f(IStrategyService.class);
        if (r101 == null) goto L8;
        LiveData<T> r102 = r101.getFactor("live_push_consume_advice", Boolean.FALSE, true, true);
        if (r102 == null) goto L8;
        Boolean r103 = (Boolean) r102.getValue();
        if (r103 == null) goto L8;
    L9:
        r100.onNext(r103);
        return;
    L8:
        r103 = Boolean.FALSE;
        goto L9
    }
}
