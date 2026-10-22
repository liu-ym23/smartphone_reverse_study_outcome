package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvRoomEmojiDialogBuilder$check$1 extends MutablePropertyReference0Impl {
    public KtvRoomEmojiDialogBuilder$check$1(a r100) {
        super(r100, a.class, PerfLog.PARAM_KEY_CONTEXT_ID, "getContext()Landroid/content/Context;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        Context r100 = ((a) this.receiver).f144694a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        Context r101 = (Context) r100;
        ((a) this.receiver).f144694a = r101;
    }
}
