package com.bytedanceos.appstore.buss.fragment;

import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import java.util.concurrent.CopyOnWriteArrayList;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1", f = "UninstallAppsFragment.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
public final class UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ UninstallAppsFragment this$0;

    public UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1(UninstallAppsFragment r10, Continuation<? super UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Boolean> r11) {
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
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CommonUtil r13 = CommonUtil.f8830a;
        CopyOnWriteArrayList r14 = UninstallAppsFragment.J(this.this$0);
        this.label = 1;
        r10 = r13.a(r14, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Boolean> r11) {
        return ((UninstallAppsFragment$setAppsUpdateStatus$1$canStartDownload$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
