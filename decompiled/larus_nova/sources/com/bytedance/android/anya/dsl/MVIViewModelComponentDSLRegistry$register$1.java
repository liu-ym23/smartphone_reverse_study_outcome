package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.o0;
import com.bytedance.android.anya.x;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0000\"\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/android/anya/x;", "STATE", "Lcom/bytedance/android/anya/MVIState;", "SUPER_STATE", "<anonymous parameter 0>", "Lcom/bytedance/android/anya/o0;", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/anya/MVIState;Lcom/bytedance/android/anya/o0;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class MVIViewModelComponentDSLRegistry$register$1 extends Lambda implements Function2<MVIState<?>, o0<MVIState<?>, x<?>>, Boolean> {
    public static final MVIViewModelComponentDSLRegistry$register$1 INSTANCE = null;

    static {
        INSTANCE = new MVIViewModelComponentDSLRegistry$register$1();
    }

    public MVIViewModelComponentDSLRegistry$register$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(MVIState<?> r100, o0<MVIState<?>, x<?>> r101) {
        return true;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(MVIState<?> r100, o0<MVIState<?>, x<?>> r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }
}
