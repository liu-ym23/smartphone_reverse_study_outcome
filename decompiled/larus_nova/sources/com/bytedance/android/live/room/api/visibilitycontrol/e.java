package com.bytedance.android.live.room.api.visibilitycontrol;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f99177a;

    public e(f r100) {
        this.f99177a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f99177a.f99179b.onNext(Unit.INSTANCE);
    }
}
