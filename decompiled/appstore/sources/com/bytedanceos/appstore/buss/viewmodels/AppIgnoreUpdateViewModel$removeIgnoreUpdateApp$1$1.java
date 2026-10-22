package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1", f = "AppIgnoreUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommonAppEntity $entity;
    int label;
    final /* synthetic */ AppIgnoreUpdateViewModel this$0;

    public AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1(AppIgnoreUpdateViewModel r10, CommonAppEntity r11, Continuation<? super AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1> r12) {
        this.this$0 = r10;
        this.$entity = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1(this.this$0, this.$entity, r11);
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
        if (this.label != 0) goto L14;
        kotlin.c.b(r10);
        List r11 = (List) this.this$0.f().e();
        if (r11 == null) goto L12;
        List r12 = b0.z0(r11);
        if (r12 == null) goto L12;
        r12.remove(this.$entity);
        CommonAppEntity r13 = this.$entity;
        BaseApplication.c().b().K(r13.convertAppInfo(), false);
        EventBus.getDefault().post(new AddUpdateEvent());
        this.this$0.f().m(r12);
        return Unit.f21064a;
    L12:
        return Unit.f21064a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
