package com.bytedanceos.appstore.ui;

import android.content.Context;
import android.text.format.DateUtils;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.ui.MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    int label;

    public MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1(Context r10, Continuation<? super MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1> r11) {
        this.$context = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1(this.$context, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L30;
        c.b(r10);
        int r11 = b0.n().o("main_launch_count_auto_update_prompt", null, this.$context);
        if (r11 >= 0) goto L7;
        r11 = 0;
    L7:
        int r12 = r11 + 1;
        if (r12 <= 25) goto L11;
        j.o("auto_update_prompt launchCount = " + r12 + ", quick exit");
        return tf.a.a(false);
    L11:
        b0.n().E("main_launch_count_auto_update_prompt", r12, null, this.$context);
        j.o("auto_update_prompt launchCount = " + r12);
        if (r12 == 1) goto L20;
        if (r12 == 10) goto L20;
        if (r12 == 20) goto L20;
        return tf.a.a(false);
    L20:
        if (s.g(this.$context) == false) goto L24;
        return tf.a.a(false);
    L24:
        if (DateUtils.isToday(b0.n().p("main_auto_update_prompt_no_more_today_ts", null, this.$context)) == false) goto L28;
        j.o("auto_update_prompt skip, for do-not-prompt-today");
        return tf.a.a(false);
    L28:
        return tf.a.a(true);
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Boolean> r11) {
        return ((MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
