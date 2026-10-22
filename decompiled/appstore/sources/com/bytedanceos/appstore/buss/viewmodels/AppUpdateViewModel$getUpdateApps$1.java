package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppUpdateViewModel$getUpdateApps$1", f = "AppUpdateViewModel.kt", i = {0, 0, 1}, l = {84, 85, 86}, m = "invokeSuspend", n = {"asyncUpdateApps", "asyncIgnoreAppsSize", "asyncIgnoreAppsSize"}, s = {"L$0", "L$1", "L$0"})
public final class AppUpdateViewModel$getUpdateApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AppUpdateViewModel this$0;

    public AppUpdateViewModel$getUpdateApps$1(AppUpdateViewModel r10, Continuation<? super AppUpdateViewModel$getUpdateApps$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppUpdateViewModel$getUpdateApps$1 r12 = new AppUpdateViewModel$getUpdateApps$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r15) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        MutableLiveData r14 = (MutableLiveData) this.L$0;
        kotlin.c.b(r15);
    L24:
        r14.p(r15);
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        MutableLiveData r12 = (MutableLiveData) this.L$1;
        Deferred r13 = (Deferred) this.L$0;
        kotlin.c.b(r15);
    L20:
        r12.p(r15);
        MutableLiveData r16 = this.this$0.h();
        this.L$0 = r16;
        this.L$1 = null;
        this.label = 3;
        Object r17 = r13.await(this);
        if (r17 != r10) goto L23;
        return r10;
    L23:
        r15 = r17;
        r14 = r16;
        goto L24
    L11:
        MutableLiveData r18 = (MutableLiveData) this.L$2;
        Deferred r19 = (Deferred) this.L$1;
        Deferred r20 = (Deferred) this.L$0;
        kotlin.c.b(r15);
    L16:
        r18.p(r15);
        r12 = this.this$0.k();
        this.L$0 = r19;
        this.L$1 = r12;
        this.L$2 = null;
        this.label = 2;
        r15 = r20.await(this);
        if (r15 != r10) goto L19;
        return r10;
    L19:
        r13 = r19;
        goto L20
    L12:
        kotlin.c.b(r15);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        Deferred r21 = h.b(r110, l0.b(), null, new AppUpdateViewModel$getUpdateApps$1$asyncDiskFull$1(null), 2, null);
        Deferred r111 = h.b(r110, l0.b(), null, new AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1(this.this$0, null), 2, null);
        Deferred r112 = h.b(r110, l0.b(), null, new AppUpdateViewModel$getUpdateApps$1$asyncIgnoreAppsSize$1(null), 2, null);
        MutableLiveData r22 = this.this$0.g();
        this.L$0 = r111;
        this.L$1 = r112;
        this.L$2 = r22;
        this.label = 1;
        Object r23 = r21.await(this);
        if (r23 != r10) goto L15;
        return r10;
    L15:
        r19 = r112;
        r15 = r23;
        r18 = r22;
        r20 = r111;
        goto L16
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppUpdateViewModel$getUpdateApps$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
