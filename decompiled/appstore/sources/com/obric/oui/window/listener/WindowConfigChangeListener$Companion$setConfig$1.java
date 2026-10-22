package com.obric.oui.window.listener;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$setConfig$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$setConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Configuration $config;
    final /* synthetic */ Activity $context;
    final /* synthetic */ int $currentWindowHeight;
    final /* synthetic */ int $currentWindowWidth;
    int label;

    public WindowConfigChangeListener$Companion$setConfig$1(Activity r10, Configuration r11, int r12, int r13, Continuation<? super WindowConfigChangeListener$Companion$setConfig$1> r14) {
        this.$context = r10;
        this.$config = r11;
        this.$currentWindowWidth = r12;
        this.$currentWindowHeight = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new WindowConfigChangeListener$Companion$setConfig$1(this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r18) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L34;
        c.b(r18);
        int r10 = this.$context.hashCode();
        Pair r11 = (Pair) b.f().get(tf.a.c(r10));
        if (r11 != null) goto L7;
        b.a.d(b.f17655e, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
    L32:
        return Unit.f21064a;
    L7:
        int r12 = this.$config.diff((Configuration) r11.getFirst());
        if ((r12 & 128) == 0) goto L10;
    L30:
        b.a.d(b.f17655e, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
        goto L32
    L10:
        if ((r12 & 256) != 0) goto L30;
        if ((r12 & 1024) != 0) goto L30;
        if ((r12 & 2048) != 0) goto L30;
        if ((r12 & 4096) != 0) goto L30;
        if ((r12 & 16384) != 0) goto L30;
        if ((r12 & 512) != 0) goto L30;
        Pair r13 = (Pair) b.f().get(tf.a.c(r10));
        if (r13 != null) goto L26;
    L29:
        Log.e("Window", "setConfigInternal due to window width diff");
        b.a.a(b.f17655e, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, true);
        goto L32
    L26:
        if (((Number) r13.getSecond()).intValue() != this.$currentWindowWidth) goto L29;
        if (ae.a.f85a.c().a() == this.$currentWindowWidth) goto L32;
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((WindowConfigChangeListener$Companion$setConfig$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
