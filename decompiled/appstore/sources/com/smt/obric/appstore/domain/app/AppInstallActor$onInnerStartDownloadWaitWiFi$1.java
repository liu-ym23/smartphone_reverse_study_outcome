package com.smt.obric.appstore.domain.app;

import com.bytedanceos.common.ui.animation.AnimationConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onInnerStartDownloadWaitWiFi$1", f = "AppInstallActor.kt", i = {}, l = {AnimationConstants.DURATION_550}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$onInnerStartDownloadWaitWiFi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInstallActor.b.r $msg;
    final /* synthetic */ SendChannel<CompletableDeferred<Boolean>> $req;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$onInnerStartDownloadWaitWiFi$1(SendChannel<? super CompletableDeferred<Boolean>> r10, AppInstallActor.b.r r11, Continuation<? super AppInstallActor$onInnerStartDownloadWaitWiFi$1> r12) {
        this.$req = r10;
        this.$msg = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppInstallActor$onInnerStartDownloadWaitWiFi$1(this.$req, this.$msg, r11);
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
        SendChannel<CompletableDeferred<Boolean>> r13 = this.$req;
        CompletableDeferred r14 = this.$msg.a();
        this.label = 1;
        if (r13.send(r14, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onInnerStartDownloadWaitWiFi$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
