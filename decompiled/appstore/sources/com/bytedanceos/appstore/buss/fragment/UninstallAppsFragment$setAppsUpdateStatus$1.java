package com.bytedanceos.appstore.buss.fragment;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.UninstallAppsFragment$setAppsUpdateStatus$1", f = "UninstallAppsFragment.kt", i = {}, l = {474}, m = "invokeSuspend", n = {}, s = {})
final class UninstallAppsFragment$setAppsUpdateStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ UninstallAppsFragment this$0;

    public UninstallAppsFragment$setAppsUpdateStatus$1(View r10, UninstallAppsFragment r11, Continuation<? super UninstallAppsFragment$setAppsUpdateStatus$1> r12) {
        this.$view = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UninstallAppsFragment$setAppsUpdateStatus$1(this.$view, this.this$0, r11);
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
    L11:
        boolean r13 = ((Boolean) r10).booleanValue();
        View r14 = this.$view;
        if (r14 == null) goto L21;
        if (r13 == true) goto L16;
    L18:
        int r15 = 8;
    L19:
        r14.setVisibility(r15);
        goto L21
    L16:
        if (UninstallAppsFragment.I(this.this$0).b() == true) goto L18;
        r15 = 0;
    L21:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CoroutineDispatcher r16 = kotlinx.coroutines.l0.a();
        UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1 r17 = new UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1(this.this$0, null);
        this.label = 1;
        r10 = kotlinx.coroutines.h.g(r16, r17, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UninstallAppsFragment$setAppsUpdateStatus$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
