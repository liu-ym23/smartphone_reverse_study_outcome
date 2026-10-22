package com.bytedance.android.live.liveinteract.videotalk.emoji;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class DynamicEmojiDialogBuilder$check$3 extends MutablePropertyReference0Impl {
    public DynamicEmojiDialogBuilder$check$3(t r100) {
        super(r100, t.class, "requestPage", "getRequestPage()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        String r100 = ((t) this.receiver).f79420d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        String r101 = (String) r100;
        ((t) this.receiver).f79420d = r101;
    }
}
