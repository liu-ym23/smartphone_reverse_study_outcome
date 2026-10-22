package com.obric.appstore.buss.repo;

import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.UpdateAppInfoReq;
import com.obric.appstore.network.entity.UpdateAppListReq;
import com.obric.appstore.network.entity.UpdateAppListResp;
import com.obric.appstore.network.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/obric/appstore/network/g;", "Lcom/obric/appstore/network/entity/UpdateAppListResp;", "<anonymous>", "()Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo$getUpdateApps$2", f = "StoreRepo.kt", i = {}, l = {224, 221}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nStoreRepo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StoreRepo.kt\ncom/obric/appstore/buss/repo/StoreRepo$getUpdateApps$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,240:1\n766#2:241\n857#2,2:242\n*S KotlinDebug\n*F\n+ 1 StoreRepo.kt\ncom/obric/appstore/buss/repo/StoreRepo$getUpdateApps$2\n*L\n212#1:241\n212#1:242,2\n*E\n"})
public final class StoreRepo$getUpdateApps$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ List<UpdateAppInfoReq> $apps;
    Object L$0;
    int label;

    public StoreRepo$getUpdateApps$2(List<UpdateAppInfoReq> r10, Continuation<? super StoreRepo$getUpdateApps$2> r11) {
        this.$apps = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new StoreRepo$getUpdateApps$2(this.$apps, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super g> r10) {
        return invoke2(r10);
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
    L26:
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        StoreRepo r13 = (StoreRepo) this.L$0;
        c.b(r10);
    L23:
        this.L$0 = null;
        this.label = 2;
        r10 = r13.a((Response) r10, this);
        if (r10 != r11) goto L26;
        return r11;
    L10:
        c.b(r10);
        List<UpdateAppInfoReq> r14 = this.$apps;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L19;
        Object r17 = r16.next();
        UpdateAppInfoReq r18 = (UpdateAppInfoReq) r17;
        if (r18.getPackageName().length() <= 0) goto L18;
        if (r18.getVersionCode() <= 0) goto L18;
        r15.add(r17);
    L18:
        j.n("getUpdateApps filter for versioncode is 0 " + r18.getPackageName());
        goto L12
    L19:
        StoreRepo r19 = StoreRepo.f10831a;
        Deferred<Response<HttpResp<UpdateAppListResp>>> r20 = StoreHttpEngine.f10958b.h().updateAppList(new UpdateAppListReq(r15));
        this.L$0 = r19;
        this.label = 1;
        Object r21 = r20.await(this);
        if (r21 != r11) goto L22;
        return r11;
    L22:
        r13 = r19;
        r10 = r21;
        goto L23
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super g> r10) {
        return ((StoreRepo$getUpdateApps$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
