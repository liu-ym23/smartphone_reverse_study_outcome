package com.bytedanceos.appstore.buss.network.cms;

import com.bytedanceos.appstore.buss.network.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/g;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.network.cms.CmsBaseRepository$executeCmsResponse$2", f = "CmsBaseRepository.kt", i = {}, l = {47, 56}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCmsBaseRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CmsBaseRepository.kt\ncom/bytedanceos/appstore/buss/network/cms/CmsBaseRepository$executeCmsResponse$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class CmsBaseRepository$executeCmsResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ g $apiResponse;
    final /* synthetic */ Function3<CoroutineScope, g, Continuation<? super Unit>, Object> $errorCallResult;
    final /* synthetic */ Function3<CoroutineScope, g, Continuation<? super Unit>, Object> $successCallResult;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CmsBaseRepository$executeCmsResponse$2(g r10, Function3<? super CoroutineScope, ? super g, ? super Continuation<? super Unit>, ? extends Object> r11, Function3<? super CoroutineScope, ? super g, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super CmsBaseRepository$executeCmsResponse$2> r13) {
        this.$apiResponse = r10;
        this.$successCallResult = r11;
        this.$errorCallResult = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        CmsBaseRepository$executeCmsResponse$2 r12 = new CmsBaseRepository$executeCmsResponse$2(this.$apiResponse, this.$successCallResult, this.$errorCallResult, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super g> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        c.b(r10);
    L33:
        return new g.a(((g.a) this.$apiResponse).a(), ((g.a) this.$apiResponse).b());
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        c.b(r10);
    L32:
        return new g.c(((g.c) this.$apiResponse).b(), ((g.c) this.$apiResponse).c(), ((g.c) this.$apiResponse).a());
    L10:
        c.b(r10);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        g r14 = this.$apiResponse;
        if ((r14 instanceof g.c) == false) goto L19;
        Function3<CoroutineScope, g, Continuation<? super Unit>, Object> r15 = this.$successCallResult;
        if (r15 == null) goto L32;
        this.label = 1;
        if (r15.invoke(r13, r14, this) != r11) goto L32;
        return r11;
    L19:
        if ((r14 instanceof g.a) == false) goto L27;
        Function3<CoroutineScope, g, Continuation<? super Unit>, Object> r16 = this.$errorCallResult;
        if (r16 == null) goto L33;
        this.label = 2;
        if (r16.invoke(r13, r14, this) != r11) goto L33;
        return r11;
    L27:
        if ((r14 instanceof g.b) == false) goto L31;
        return g.b.f8811a;
    L31:
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super g> r11) {
        return ((CmsBaseRepository$executeCmsResponse$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
