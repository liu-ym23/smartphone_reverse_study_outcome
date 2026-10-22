package com.bytedance.android.livesdk.room.Task.base;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LiveTask$tryToInitCountDown$1 extends MutablePropertyReference0Impl {
    public LiveTask$tryToInitCountDown$1(LiveTask r100) {
        super(r100, LiveTask.class, "countDownLatch", "getCountDownLatch()Ljava/util/concurrent/CountDownLatch;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        CountDownLatch r100 = ((LiveTask) this.receiver).f157555a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("countDownLatch");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        CountDownLatch r101 = (CountDownLatch) r100;
        ((LiveTask) this.receiver).f157555a = r101;
    }
}
