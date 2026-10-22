package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.network.HttpResult;
import com.bytedanceos.appstore.buss.network.StoreHttpEngine;
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
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppsWrap;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.MyAppRepository$getMyApps$3", f = "MyAppRepository.kt", i = {}, l = {26, 26}, m = "invokeSuspend", n = {}, s = {})
public final class MyAppRepository$getMyApps$3 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    Object L$0;
    int label;

    public MyAppRepository$getMyApps$3(Continuation<? super MyAppRepository$getMyApps$3> r10) {
        super(1, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new MyAppRepository$getMyApps$3(r10);
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
        r13 = MyAppRepository.f9031a;
        Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> r15 = StoreHttpEngine.f8778b.g().getMyGames();
        this.L$0 = r13;
        this.label = 1;
        r11 = r15.await(this);
        if (r11 != r10) goto L10;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((MyAppRepository$getMyApps$3) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
