package com.bytedanceos.appstore.buss.viewmodels.cache;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.MyAppsDeleteEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.c;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository$removeMyApps$1$removeNetSource$1", f = "CacheMyAppsRepository.kt", i = {0}, l = {110}, m = "invokeSuspend", n = {"deleteList"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nCacheMyAppsRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheMyAppsRepository.kt\ncom/bytedanceos/appstore/buss/viewmodels/cache/CacheMyAppsRepository$removeMyApps$1$removeNetSource$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n1549#2:162\n1620#2,3:163\n1855#2,2:166\n1855#2,2:168\n*S KotlinDebug\n*F\n+ 1 CacheMyAppsRepository.kt\ncom/bytedanceos/appstore/buss/viewmodels/cache/CacheMyAppsRepository$removeMyApps$1$removeNetSource$1\n*L\n107#1:162\n107#1:163,3\n112#1:166,2\n118#1:168,2\n*E\n"})
public final class CacheMyAppsRepository$removeMyApps$1$removeNetSource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ List<CommonAppEntity> $list;
    Object L$0;
    int label;
    final /* synthetic */ CacheMyAppsRepository this$0;

    public CacheMyAppsRepository$removeMyApps$1$removeNetSource$1(List<CommonAppEntity> r10, CacheMyAppsRepository r11, Continuation<? super CacheMyAppsRepository$removeMyApps$1$removeNetSource$1> r12) {
        this.$list = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new CacheMyAppsRepository$removeMyApps$1$removeNetSource$1(this.$list, this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        List r13 = (List) this.L$0;
        c.b(r10);
    L16:
        h r14 = (h) r10;
        if ((r14 instanceof h.c) == false) goto L35;
        CacheMyAppsRepository r15 = this.this$0;
        Iterator r16 = r13.iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        MyAppsDeleteEntity r17 = (MyAppsDeleteEntity) r16.next();
        CacheMyAppsRepository.g(r15).remove(r17.getPackageName());
        goto L20
    L22:
        h r18 = (h) this.this$0.k().e();
        if (r18 == null) goto L33;
        CacheMyAppsRepository r19 = this.this$0;
        List<CommonAppEntity> r20 = this.$list;
        if ((r18 instanceof h.c) == false) goto L33;
        Map r21 = (Map) ((h.c) r18).a();
        if (r21 == null) goto L32;
        Iterator<T> r22 = r20.iterator();
    L30:
        if (r22.hasNext() == false) goto L32;
        r21.remove(((CommonAppEntity) r22.next()).getPkg());
    L32:
        r19.k().m(r18);
    L33:
        h.c r23 = (h.c) r14;
        return new h.c(r23.b(), CacheMyAppsRepository.g(this.this$0), r23.c());
    L35:
        if ((r14 instanceof h.a) == false) goto L38;
        h.a r24 = (h.a) r14;
        CommonUtil.f8830a.b(r24.b());
        return new h.a(r24.c(), r24.b(), null, 4, null);
    L38:
        if (q.b(r14, h.b.f8818a) == false) goto L41;
        return null;
    L41:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        List<CommonAppEntity> r25 = this.$list;
        ArrayList r26 = new ArrayList(u.r(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L10:
        if (r27.hasNext() == false) goto L12;
        String r28 = ((CommonAppEntity) r27.next()).getPkg();
        q.f(r28, "getPkg(...)");
        r26.add(new MyAppsDeleteEntity(r28, 2));
        goto L10
    L12:
        CacheMyAppsRepository r29 = this.this$0;
        CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1 r30 = new CacheMyAppsRepository$removeMyApps$1$removeNetSource$1$wrap$1(r26, null);
        this.L$0 = r26;
        this.label = 1;
        r10 = CacheMyAppsRepository.h(r29, r30, this);
        if (r10 != r11) goto L15;
        return r11;
    L15:
        r13 = r26;
        goto L16
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
        return ((CacheMyAppsRepository$removeMyApps$1$removeNetSource$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
