package com.bytedanceos.appstore.buss.viewmodels.cache;

import com.bytedanceos.appstore.buss.entity.netwrap.MyAppsDeleteEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.DeleteMyAppRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1", f = "CacheMyAppsRepository.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    final /* synthetic */ List<MyAppsDeleteEntity> $deleteList;
    int label;

    public CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1(List<MyAppsDeleteEntity> r10, Continuation<? super CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1> r11) {
        this.$deleteList = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1(this.$deleteList, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super h> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        DeleteMyAppRepository r13 = DeleteMyAppRepository.f9025a;
        List<MyAppsDeleteEntity> r14 = this.$deleteList;
        this.label = 1;
        r10 = r13.f(r14, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
