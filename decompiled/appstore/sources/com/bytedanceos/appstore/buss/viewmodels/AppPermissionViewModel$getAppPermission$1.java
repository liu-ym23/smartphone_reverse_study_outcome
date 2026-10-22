package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppPermissionRepository;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppPermissionViewModel$getAppPermission$1", f = "AppPermissionViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class AppPermissionViewModel$getAppPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AppPermissionViewModel this$0;

    public AppPermissionViewModel$getAppPermission$1(AppPermissionViewModel r10, Continuation<? super AppPermissionViewModel$getAppPermission$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppPermissionViewModel$getAppPermission$1(this.this$0, r11);
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
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        kotlin.c.b(r10);
    L12:
        r13.p(r10);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        this.this$0.h().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.h();
        AppPermissionRepository r15 = AppPermissionRepository.f9011a;
        String r16 = AppPermissionViewModel.f(this.this$0);
        this.L$0 = r14;
        this.label = 1;
        Object r17 = r15.f(r16, this);
        if (r17 != r11) goto L11;
        return r11;
    L11:
        r10 = r17;
        r13 = r14;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppPermissionViewModel$getAppPermission$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
