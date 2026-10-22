package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "p1", "", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECImageMainHandlerOpt$configKeys$3 extends FunctionReferenceImpl implements Function2<List<? extends String>, Continuation<? super Unit>, Object>, SuspendFunction {
    public ECImageMainHandlerOpt$configKeys$3(ECImageMainHandlerOpt r100) {
        super(2, r100, ECImageMainHandlerOpt.class, "onInitConfig", "onInitConfig(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<String> r100, Continuation<? super Unit> r101) {
        ECImageMainHandlerOpt r102 = (ECImageMainHandlerOpt) this.receiver;
        KProperty[] r103 = ECImageMainHandlerOpt.f44748a;
        return r102.b(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends String> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }
}
