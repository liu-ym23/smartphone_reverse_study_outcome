package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCollectEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.common.ad.param.AdReportParam;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppWishViewModel$postWishApp$1", f = "AppWishViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
public final class AppWishViewModel$postWishApp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    final /* synthetic */ CommonAppEntity $tvCommonAppEntity;
    Object L$0;
    int label;
    final /* synthetic */ AppWishViewModel this$0;

    public AppWishViewModel$postWishApp$1(AppWishViewModel r10, int r11, CommonAppEntity r12, Continuation<? super AppWishViewModel$postWishApp$1> r13) {
        this.this$0 = r10;
        this.$position = r11;
        this.$tvCommonAppEntity = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppWishViewModel$postWishApp$1(this.this$0, this.$position, this.$tvCommonAppEntity, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        kotlin.c.b(r12);
    L14:
        r13.p(r12);
    L16:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r12);
        List r14 = (List) AppWishViewModel.f(this.this$0).e();
        if (r14 == null) goto L16;
        int r15 = this.$position;
        AppWishViewModel r16 = this.this$0;
        CommonAppEntity r17 = this.$tvCommonAppEntity;
        ((AppCollectEntity) r14.get(r15)).setStatus(AdReportParam.ClickPosType.SKIP);
        r16.j().p(h.b.f8818a);
        MutableLiveData r18 = r16.j();
        CoroutineDispatcher r19 = l0.b();
        AppWishViewModel$postWishApp$1$1$1 r20 = new AppWishViewModel$postWishApp$1$1$1(r14, r17, r16, r15, null);
        this.L$0 = r18;
        this.label = 1;
        Object r110 = kotlinx.coroutines.h.g(r19, r20, this);
        if (r110 != r10) goto L13;
        return r10;
    L13:
        r12 = r110;
        r13 = r18;
        goto L14
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppWishViewModel$postWishApp$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
