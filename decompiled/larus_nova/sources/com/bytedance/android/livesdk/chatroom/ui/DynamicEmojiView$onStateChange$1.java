package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DynamicEmojiView$onStateChange$1 extends MutablePropertyReference0Impl {
    public DynamicEmojiView$onStateChange$1(DynamicEmojiView r100) {
        super(r100, DynamicEmojiView.class, "taskEnd", "getTaskEnd()Lkotlin/jvm/functions/Function0;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        Function0<Unit> r100 = ((DynamicEmojiView) this.receiver).f112139h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskEnd");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        Function0<Unit> r101 = (Function0) r100;
        ((DynamicEmojiView) this.receiver).f112139h = r101;
    }
}
