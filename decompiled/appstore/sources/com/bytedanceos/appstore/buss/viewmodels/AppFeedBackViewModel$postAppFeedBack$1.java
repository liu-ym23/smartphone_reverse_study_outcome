package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.netwrap.AppFeedBackEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppFeedBackRepository;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppFeedBackViewModel$postAppFeedBack$1", f = "AppFeedBackViewModel.kt", i = {}, l = {33, 50}, m = "invokeSuspend", n = {}, s = {})
final class AppFeedBackViewModel$postAppFeedBack$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ List<Integer> $list;
    Object L$0;
    int label;
    final /* synthetic */ AppFeedBackViewModel this$0;

    public AppFeedBackViewModel$postAppFeedBack$1(AppFeedBackViewModel r10, List<Integer> r11, String r12, Continuation<? super AppFeedBackViewModel$postAppFeedBack$1> r13) {
        this.this$0 = r10;
        this.$list = r11;
        this.$content = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppFeedBackViewModel$postAppFeedBack$1(this.this$0, this.$list, this.$content, r11);
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
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        kotlin.c.b(r10);
    L17:
        r13.p(r10);
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L13:
        this.this$0.i().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.i();
        AppFeedBackRepository r15 = AppFeedBackRepository.f9010a;
        this.L$0 = r14;
        this.label = 2;
        r10 = r15.f((AppFeedBackEntity) r10, this);
        if (r10 != r11) goto L16;
        return r11;
    L16:
        r13 = r14;
        goto L17
    L10:
        kotlin.c.b(r10);
        CoroutineDispatcher r16 = l0.b();
        AppFeedBackViewModel$postAppFeedBack$1$entity$1 r17 = new AppFeedBackViewModel$postAppFeedBack$1$entity$1(this.$list, this.this$0, this.$content, null);
        this.label = 1;
        r10 = kotlinx.coroutines.h.g(r16, r17, this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppFeedBackViewModel$postAppFeedBack$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
