package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f146741a;

    public m(Function1 r100) {
        this.f146741a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.profit.dress.t r101 = (com.bytedance.android.live.profit.dress.t) r100;
        this.f146741a.invoke(r101);
        ALogger.i("RTChorusRoomDressResource", "onNext: " + r101);
    }
}
