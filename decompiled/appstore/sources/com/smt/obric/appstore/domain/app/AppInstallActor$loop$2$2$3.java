package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/f;", "", "r", "", "<anonymous>", "(Lkotlinx/coroutines/channels/f;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$loop$2$2$3", f = "AppInstallActor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$loop$2$2$3 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.f, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$loop$2$2$3(AppInstallActor r10, Continuation<? super AppInstallActor$loop$2$2$3> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$loop$2$2$3 r12 = new AppInstallActor$loop$2$2$3(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlinx.coroutines.channels.f r10, Continuation<? super Unit> r11) {
        return m31invokeWpGqRn0(r10.l(), r11);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m31invokeWpGqRn0(@NotNull Object r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$loop$2$2$3) create(kotlinx.coroutines.channels.f.b(r10), r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L11;
        kotlin.c.b(r10);
        Object r11 = ((kotlinx.coroutines.channels.f) this.L$0).l();
        if (kotlinx.coroutines.channels.f.j(r11) == false) goto L7;
        AppInstallActor.z(this.this$0, (String) kotlinx.coroutines.channels.f.g(r11));
        return Unit.f21064a;
    L7:
        return Unit.f21064a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
