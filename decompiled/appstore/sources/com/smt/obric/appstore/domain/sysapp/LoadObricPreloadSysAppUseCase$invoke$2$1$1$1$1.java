package com.smt.obric.appstore.domain.sysapp;

import java.io.File;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/smt/obric/appstore/domain/sysapp/LoadObricPreloadSysAppUseCase$a;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/smt/obric/appstore/domain/sysapp/LoadObricPreloadSysAppUseCase$a;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1", f = "LoadObricPreloadSysAppUseCase.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadObricPreloadSysAppUseCase.a>, Object> {
    final /* synthetic */ File $it;
    int label;
    final /* synthetic */ LoadObricPreloadSysAppUseCase this$0;

    public LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1(LoadObricPreloadSysAppUseCase r10, File r11, Continuation<? super LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1> r12) {
        this.this$0 = r10;
        this.$it = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1(this.this$0, this.$it, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super LoadObricPreloadSysAppUseCase.a> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        LoadObricPreloadSysAppUseCase r13 = this.this$0;
        File r14 = this.$it;
        this.label = 1;
        r10 = LoadObricPreloadSysAppUseCase.a(r13, r14, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super LoadObricPreloadSysAppUseCase.a> r11) {
        return ((LoadObricPreloadSysAppUseCase$invoke$2$1$1$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
