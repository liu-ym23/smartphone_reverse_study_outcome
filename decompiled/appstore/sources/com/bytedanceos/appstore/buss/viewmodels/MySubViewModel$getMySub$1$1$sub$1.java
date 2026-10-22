package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.GameSubRepository;
import com.bytedanceos.appstore.utils.d;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppsWrap;", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.MySubViewModel$getMySub$1$1$sub$1", f = "MySubViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class MySubViewModel$getMySub$1$1$sub$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    int label;

    public MySubViewModel$getMySub$1$1$sub$1(Continuation<? super MySubViewModel$getMySub$1$1$sub$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new MySubViewModel$getMySub$1$1$sub$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
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
    L15:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        GameSubRepository r13 = GameSubRepository.f9027a;
        if (d.a() == false) goto L11;
        int r14 = 1;
    L12:
        this.label = 1;
        r10 = r13.h(r14, this);
        if (r10 != r11) goto L15;
        return r11;
    L11:
        r14 = 2;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
        return ((MySubViewModel$getMySub$1$1$sub$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
