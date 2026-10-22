package com.smt.obric.appstore.ui.app;

import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.ui.app.AppStatusViewModel$enqueueDownload$1", f = "AppStatusViewModel.kt", i = {}, l = {84, 92}, m = "invokeSuspend", n = {}, s = {})
public final class AppStatusViewModel$enqueueDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $req;
    int label;
    final /* synthetic */ AppStatusViewModel this$0;

    public AppStatusViewModel$enqueueDownload$1(AppStatusViewModel r10, com.smt.obric.appstore.domain.app.entity.a r11, Continuation<? super AppStatusViewModel$enqueueDownload$1> r12) {
        this.this$0 = r10;
        this.$req = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStatusViewModel$enqueueDownload$1(this.this$0, this.$req, r11);
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
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        kotlin.c.b(r10);
    L21:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L14:
        if (((Boolean) r10).booleanValue() == true) goto L17;
        AppStatusViewModel.l(this.this$0).tryEmit(AppStatusEvent.d.f18154a);
        return Unit.f21064a;
    L17:
        EnqueueAppInstallTaskUseCase r13 = AppStatusViewModel.h(this.this$0);
        com.smt.obric.appstore.domain.app.entity.a r14 = this.$req;
        this.label = 2;
        if (r13.a(r14, this) != r11) goto L21;
        return r11;
    L10:
        kotlin.c.b(r10);
        CoroutineDispatcher r15 = l0.b();
        AppStatusViewModel$enqueueDownload$1$spaceEnough$1 r16 = new AppStatusViewModel$enqueueDownload$1$spaceEnough$1(this.$req, null);
        this.label = 1;
        r10 = h.g(r15, r16, this);
        if (r10 != r11) goto L14;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppStatusViewModel$enqueueDownload$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
