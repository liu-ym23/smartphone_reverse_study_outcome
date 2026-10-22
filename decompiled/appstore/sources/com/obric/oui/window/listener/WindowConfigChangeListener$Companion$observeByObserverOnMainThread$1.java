package com.obric.oui.window.listener;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xd.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Observer<f> $observer;
    final /* synthetic */ LifecycleOwner $owner;
    int label;

    public WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(LifecycleOwner r10, Observer<f> r11, Continuation<? super WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1> r12) {
        this.$owner = r10;
        this.$observer = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(this.$owner, this.$observer, r11);
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
        if (this.label != 0) goto L11;
        c.b(r10);
        a r11 = b.f17655e.b(this.$owner);
        if (r11 == null) goto L9;
        r11.i(this.$owner, this.$observer);
    L9:
        return Unit.f21064a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
