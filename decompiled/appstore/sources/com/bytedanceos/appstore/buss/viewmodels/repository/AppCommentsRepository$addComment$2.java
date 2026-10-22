package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.HttpResult;
import com.bytedanceos.appstore.buss.network.StoreHttpEngine;
import com.bytedanceos.appstore.buss.network.StoreService;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.buss.network.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.AppCommentsRepository$addComment$2", f = "AppCommentsRepository.kt", i = {}, l = {47, 47}, m = "invokeSuspend", n = {}, s = {})
public final class AppCommentsRepository$addComment$2 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    final /* synthetic */ RequestBody $requestBody;
    Object L$0;
    int label;

    public AppCommentsRepository$addComment$2(RequestBody r10, Continuation<? super AppCommentsRepository$addComment$2> r11) {
        this.$requestBody = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new AppCommentsRepository$addComment$2(this.$requestBody, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super h> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        c.b(r11);
    L17:
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        BaseRepository r13 = (BaseRepository) this.L$0;
        c.b(r11);
    L10:
        BaseRepository r14 = r13;
        this.L$0 = null;
        this.label = 2;
        r11 = BaseRepository.d(r14, (Response) r11, null, null, this, 6, null);
        if (r11 != r10) goto L17;
        return r10;
    L11:
        c.b(r11);
        r13 = AppCommentsRepository.f9007a;
        StoreService r15 = StoreHttpEngine.f8778b.g();
        RequestBody r16 = this.$requestBody;
        q.f(r16, "$requestBody");
        Deferred<Response<HttpResult<Object>>> r17 = r15.addComment(r16);
        this.L$0 = r13;
        this.label = 1;
        r11 = r17.await(this);
        if (r11 != r10) goto L10;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((AppCommentsRepository$addComment$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
