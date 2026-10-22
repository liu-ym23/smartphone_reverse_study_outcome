package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.network.AppHttpEngine;
import com.bytedanceos.appstore.buss.network.CmsHttpResult;
import com.bytedanceos.appstore.buss.network.cms.CmsBaseRepository;
import com.bytedanceos.appstore.buss.network.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/g;", "", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.CmsRepository$getCmsPage$2", f = "CmsRepository.kt", i = {}, l = {17, 17}, m = "invokeSuspend", n = {}, s = {})
final class CmsRepository$getCmsPage$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ String $pageId;
    Object L$0;
    int label;

    public CmsRepository$getCmsPage$2(String r10, Continuation<? super CmsRepository$getCmsPage$2> r11) {
        this.$pageId = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new CmsRepository$getCmsPage$2(this.$pageId, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super g> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        kotlin.c.b(r11);
    L17:
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CmsBaseRepository r13 = (CmsBaseRepository) this.L$0;
        kotlin.c.b(r11);
    L10:
        CmsBaseRepository r14 = r13;
        this.L$0 = null;
        this.label = 2;
        r11 = CmsBaseRepository.b(r14, (Response) r11, null, null, this, 6, null);
        if (r11 != r10) goto L17;
        return r10;
    L11:
        kotlin.c.b(r11);
        r13 = CmsRepository.f8944a;
        Deferred<Response<CmsHttpResult<Object>>> r15 = AppHttpEngine.f8769b.f().getCmsPage(this.$pageId);
        this.L$0 = r13;
        this.label = 1;
        r11 = r15.await(this);
        if (r11 != r10) goto L10;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super g> r10) {
        return ((CmsRepository$getCmsPage$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
