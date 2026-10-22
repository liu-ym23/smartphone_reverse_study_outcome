package com.bytedanceos.appstore.buss.viewmodels.cache;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.repository.MyAppRepository;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository$updateMyApps$1", f = "CacheMyAppsRepository.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class CacheMyAppsRepository$updateMyApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CacheMyAppsRepository this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository$updateMyApps$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h$c;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h$c;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository$updateMyApps$1$1", f = "CacheMyAppsRepository.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nCacheMyAppsRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheMyAppsRepository.kt\ncom/bytedanceos/appstore/buss/viewmodels/cache/CacheMyAppsRepository$updateMyApps$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n1855#2,2:162\n*S KotlinDebug\n*F\n+ 1 CacheMyAppsRepository.kt\ncom/bytedanceos/appstore/buss/viewmodels/cache/CacheMyAppsRepository$updateMyApps$1$1\n*L\n65#1:162,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h.c>, Object> {
        int label;
        final /* synthetic */ CacheMyAppsRepository this$0;

        public AnonymousClass1(CacheMyAppsRepository r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h.c> r11) {
            return invoke2(r10, r11);
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
            h r13 = (h) r10;
            List r14 = null;
            if ((r13 instanceof h.c) == false) goto L22;
            CommonUtil r15 = CommonUtil.f8830a;
            h.c r16 = (h.c) r13;
            AppsWrap r17 = (AppsWrap) r16.a();
            if (r17 == null) goto L16;
            r14 = r17.getApps();
        L16:
            List r18 = r15.f(r14);
            LinkedHashMap r19 = new LinkedHashMap();
            Iterator r20 = r18.iterator();
        L18:
            if (r20.hasNext() == false) goto L20;
            CommonAppEntity r21 = (CommonAppEntity) r20.next();
            String r22 = r21.getPkg();
            q.f(r22, "getPkg(...)");
            r19.put(r22, r21);
            goto L18
        L20:
            CacheMyAppsRepository.i(this.this$0, System.currentTimeMillis());
            CacheMyAppsRepository.g(this.this$0).clear();
            CacheMyAppsRepository.g(this.this$0).putAll(r19);
            return new h.c(r16.b(), CacheMyAppsRepository.g(this.this$0), r16.c());
        L22:
            if ((r13 instanceof h.a) == false) goto L25;
            return new h.c(new HttpResultHead(0, "本地数据", null), CacheMyAppsRepository.g(this.this$0), "本地数据");
        L25:
            if (q.b(r13, h.b.f8818a) == false) goto L28;
            return null;
        L28:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            MyAppRepository r23 = MyAppRepository.f9031a;
            this.label = 1;
            r10 = r23.f(this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h.c> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public CacheMyAppsRepository$updateMyApps$1(CacheMyAppsRepository r10, Continuation<? super CacheMyAppsRepository$updateMyApps$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new CacheMyAppsRepository$updateMyApps$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        c.b(r10);
    L12:
        r13.p(r10);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        MutableLiveData r14 = this.this$0.k();
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r14;
        this.label = 1;
        Object r17 = kotlinx.coroutines.h.g(r15, r16, this);
        if (r17 != r11) goto L11;
        return r11;
    L11:
        r10 = r17;
        r13 = r14;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((CacheMyAppsRepository$updateMyApps$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
