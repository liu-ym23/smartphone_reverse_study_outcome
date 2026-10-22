package com.smt.obric.appstore.ui.app;

import com.smt.obric.appstore.domain.usecase.app.install.ResumeAppDownloadUseCase;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.ui.app.AppStatusViewModel$resume$1", f = "AppStatusViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class AppStatusViewModel$resume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $task;
    final /* synthetic */ boolean $wifiOnly;
    int label;
    final /* synthetic */ AppStatusViewModel this$0;

    public AppStatusViewModel$resume$1(AppStatusViewModel r10, com.smt.obric.appstore.domain.app.entity.a r11, boolean r12, Continuation<? super AppStatusViewModel$resume$1> r13) {
        this.this$0 = r10;
        this.$task = r11;
        this.$wifiOnly = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStatusViewModel$resume$1(this.this$0, this.$task, this.$wifiOnly, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
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
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ResumeAppDownloadUseCase r13 = AppStatusViewModel.k(this.this$0);
        String r14 = this.$task.E();
        boolean r15 = this.$wifiOnly;
        this.label = 1;
        if (r13.a(r14, r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppStatusViewModel$resume$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
