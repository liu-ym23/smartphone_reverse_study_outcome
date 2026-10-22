package com.bytedanceos.appstore.buss.activity;

import com.bytedanceos.common.toolbox.g0;
import com.bytedanceos.common.ui.listener.AppStateHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.activity.AppSplashActivity$onEvent$1", f = "AppSplashActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppSplashActivity$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppSplashActivity this$0;

    public AppSplashActivity$onEvent$1(AppSplashActivity r10, Continuation<? super AppSplashActivity$onEvent$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppSplashActivity$onEvent$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L17;
        kotlin.c.b(r10);
        if (g0.a().c() == false) goto L8;
        AppSplashActivity.O(this.this$0, 0);
    L15:
        return Unit.f21064a;
    L8:
        if (AppStateHelper.getInstance().isHotBoot() == true) goto L10;
        AppSplashActivity.Q(this.this$0);
        goto L15
    L10:
        if (this.this$0.getIntent().getBooleanExtra(AppSplashActivity.f8315g.a(), false) == false) goto L12;
        AppSplashActivity.Q(this.this$0);
        goto L15
    L12:
        AppSplashActivity.O(this.this$0, 0);
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppSplashActivity$onEvent$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
