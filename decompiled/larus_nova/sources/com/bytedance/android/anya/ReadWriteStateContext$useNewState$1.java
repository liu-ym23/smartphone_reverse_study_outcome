package com.bytedance.android.anya;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/l0;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/anya/l0;Lcom/bytedance/android/anya/MVIState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class ReadWriteStateContext$useNewState$1 extends Lambda implements Function2<l0<MVIState<?>>, MVIState<?>, Unit> {
    public static final ReadWriteStateContext$useNewState$1 INSTANCE = null;

    static {
        INSTANCE = new ReadWriteStateContext$useNewState$1();
    }

    public ReadWriteStateContext$useNewState$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l0<MVIState<?>> r100, MVIState<?> r101) {
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(l0<MVIState<?>> r100, MVIState<?> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
