package com.bytedance.android.ec.store.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BreakWordTextView$init$1 extends MutablePropertyReference0Impl {
    public BreakWordTextView$init$1(BreakWordTextView r100) {
        super(r100, BreakWordTextView.class, "fullText", "getFullText()Ljava/lang/CharSequence;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        CharSequence r100 = ((BreakWordTextView) this.receiver).f48972a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        CharSequence r101 = (CharSequence) r100;
        ((BreakWordTextView) this.receiver).f48972a = r101;
    }
}
