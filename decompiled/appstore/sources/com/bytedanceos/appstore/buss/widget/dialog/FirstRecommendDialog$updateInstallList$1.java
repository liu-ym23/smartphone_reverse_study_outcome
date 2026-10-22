package com.bytedanceos.appstore.buss.widget.dialog;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.widget.dialog.FirstRecommendDialog$updateInstallList$1", f = "FirstRecommendDialog.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
final class FirstRecommendDialog$updateInstallList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ k this$0;

    public FirstRecommendDialog$updateInstallList$1(k r10, Continuation<? super FirstRecommendDialog$updateInstallList$1> r11) {
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new FirstRecommendDialog$updateInstallList$1(null, r11);
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
        k.c(null).clear();
        List r13 = k.c(null);
        r13.addAll((List) r10);
        k.b(null);
        kotlin.jvm.internal.q.y("binding");
        throw null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        List<Object> r14 = k.a(null).getData();
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type kotlin.collections.List<com.bytedanceos.appstore.buss.entity.netwrap.FirstRecommendWrap>");
        CoroutineDispatcher r15 = l0.b();
        FirstRecommendDialog$updateInstallList$1$newList$1 r16 = new FirstRecommendDialog$updateInstallList$1$newList$1(r14, null);
        this.label = 1;
        r10 = kotlinx.coroutines.h.g(r15, r16, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((FirstRecommendDialog$updateInstallList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
