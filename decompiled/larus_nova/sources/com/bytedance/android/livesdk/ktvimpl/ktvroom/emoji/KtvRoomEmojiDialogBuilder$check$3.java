package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvRoomEmojiDialogBuilder$check$3 extends MutablePropertyReference0Impl {
    public KtvRoomEmojiDialogBuilder$check$3(a r100) {
        super(r100, a.class, "requestPage", "getRequestPage()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        String r100 = ((a) this.receiver).f144697d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        String r101 = (String) r100;
        ((a) this.receiver).f144697d = r101;
    }
}
