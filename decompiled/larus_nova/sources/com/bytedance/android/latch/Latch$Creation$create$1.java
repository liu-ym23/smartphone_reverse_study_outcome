package com.bytedance.android.latch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "OPTIONS", "Lcom/bytedance/android/latch/LatchOptions;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/latch/LatchOptions;)V"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class Latch$Creation$create$1 extends Lambda implements Function1<LatchOptions, Unit> {
    public static final Latch$Creation$create$1 INSTANCE = null;

    static {
        INSTANCE = new Latch$Creation$create$1();
    }

    public Latch$Creation$create$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LatchOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LatchOptions r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
