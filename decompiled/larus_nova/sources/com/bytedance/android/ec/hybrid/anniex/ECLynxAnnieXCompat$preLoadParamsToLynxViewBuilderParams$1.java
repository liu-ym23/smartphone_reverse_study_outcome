package com.bytedance.android.ec.hybrid.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxViewBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/lynx/tasm/LynxViewBuilder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECLynxAnnieXCompat$preLoadParamsToLynxViewBuilderParams$1 extends Lambda implements Function1<LynxViewBuilder, Unit> {
    public static final ECLynxAnnieXCompat$preLoadParamsToLynxViewBuilderParams$1 INSTANCE = null;

    static {
        INSTANCE = new ECLynxAnnieXCompat$preLoadParamsToLynxViewBuilderParams$1();
    }

    public ECLynxAnnieXCompat$preLoadParamsToLynxViewBuilderParams$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LynxViewBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.setEnablePreUpdateData(true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LynxViewBuilder r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
