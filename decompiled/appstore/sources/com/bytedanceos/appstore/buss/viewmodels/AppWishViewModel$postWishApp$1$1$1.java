package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCollectEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppWishRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/network/h$c;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppWishViewModel$postWishApp$1$1$1", f = "AppWishViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
public final class AppWishViewModel$postWishApp$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ List<AppCollectEntity> $it;
    final /* synthetic */ int $position;
    final /* synthetic */ CommonAppEntity $tvCommonAppEntity;
    int label;
    final /* synthetic */ AppWishViewModel this$0;

    public AppWishViewModel$postWishApp$1$1$1(List<AppCollectEntity> r10, CommonAppEntity r11, AppWishViewModel r12, int r13, Continuation<? super AppWishViewModel$postWishApp$1$1$1> r14) {
        this.$it = r10;
        this.$tvCommonAppEntity = r11;
        this.this$0 = r12;
        this.$position = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppWishViewModel$postWishApp$1$1$1(this.$it, this.$tvCommonAppEntity, this.this$0, this.$position, r11);
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
    L11:
        h r13 = (h) r10;
        List r14 = null;
        if ((r13 instanceof h.c) == false) goto L29;
        CommonAppEntity r15 = this.$tvCommonAppEntity;
        if (r15 == null) goto L27;
        AppWishViewModel r16 = this.this$0;
        int r17 = this.$position;
        List r18 = (List) r16.h().e();
        if (r18 == null) goto L18;
        q.d(r18);
        List r19 = b0.z0(r18);
    L19:
        if (r19 == null) goto L21;
        tf.a.a(r19.remove(r15));
    L21:
        r16.h().m(r19);
        List r20 = (List) AppWishViewModel.f(r16).e();
        if (r20 == null) goto L24;
        q.d(r20);
        r14 = b0.z0(r20);
    L24:
        if (r14 == null) goto L26;
        AppCollectEntity r21 = (AppCollectEntity) r14.remove(r17);
    L26:
        AppWishViewModel.f(r16).m(r14);
        goto L27
    L18:
        r19 = null;
    L27:
        h.c r22 = (h.c) r13;
        return new h.c(r22.b(), r13, r22.c());
    L29:
        if ((r13 instanceof h.a) == false) goto L32;
        return new h.a(((h.a) r13).c(), 0, null, 6, null);
    L32:
        if (q.b(r13, h.b.f8818a) == false) goto L35;
        return null;
    L35:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        AppWishRepository r23 = AppWishRepository.f9016a;
        List<AppCollectEntity> r24 = this.$it;
        q.f(r24, "$it");
        this.label = 1;
        r10 = r23.h(r24, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
        return ((AppWishViewModel$postWishApp$1$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
