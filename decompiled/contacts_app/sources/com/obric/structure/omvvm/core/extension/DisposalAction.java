package com.obric.structure.omvvm.core.extension;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DisposalAction.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0004R\u001b\u0010\u0006\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/structure/omvvm/core/extension/DisposalAction;", "", "onceAction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "disposalAction", "getDisposalAction", "()Lkotlin/Unit;", "disposalAction$delegate", "Lkotlin/Lazy;", "runOnce", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DisposalAction {
    private final Lazy disposalAction$delegate;
    private Function0<Unit> onceAction;

    public DisposalAction(Function0<Unit> r2) {
        this.onceAction = r2;
        this.disposalAction$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DisposalAction$disposalAction$2(this));
    }

    public static final /* synthetic */ Function0 access$getOnceAction$p(DisposalAction r0) {
        return r0.onceAction;
    }

    public static final /* synthetic */ void access$setOnceAction$p(DisposalAction r0, Function0 r1) {
        r0.onceAction = r1;
    }

    private final Unit getDisposalAction() {
        this.disposalAction$delegate.getValue();
        return Unit.INSTANCE;
    }

    public final void runOnce() {
        getDisposalAction();
    }
}
