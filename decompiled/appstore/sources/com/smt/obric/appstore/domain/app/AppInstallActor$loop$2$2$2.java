package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/smt/obric/appstore/domain/app/i;", "it", "", "<anonymous>", "(Lcom/smt/obric/appstore/domain/app/i;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$loop$2$2$2", f = "AppInstallActor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$loop$2$2$2 extends SuspendLambda implements Function2<i, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$loop$2$2$2(AppInstallActor r10, CoroutineScope r11, Continuation<? super AppInstallActor$loop$2$2$2> r12) {
        this.this$0 = r10;
        this.$$this$coroutineScope = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$loop$2$2$2 r12 = new AppInstallActor$loop$2$2$2(this.this$0, this.$$this$coroutineScope, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull i r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$loop$2$2$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L7;
        kotlin.c.b(r10);
        i r11 = (i) this.L$0;
        AppInstallActor.y(this.this$0, this.$$this$coroutineScope, r11);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(i r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }
}
