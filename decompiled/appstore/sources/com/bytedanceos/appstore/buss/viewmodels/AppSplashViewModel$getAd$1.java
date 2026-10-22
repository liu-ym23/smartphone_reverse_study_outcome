package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.network.ad.d;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppSplashRepository;
import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.req.ReqAdEntity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppSplashViewModel$getAd$1", f = "AppSplashViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class AppSplashViewModel$getAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReqAdEntity $restAdEntity;
    Object L$0;
    int label;
    final /* synthetic */ AppSplashViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppSplashViewModel$getAd$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/ad/d;", "Lcom/bytedanceos/common/ad/entity/rep/RepAdEntity;", "Lcom/bytedanceos/common/ad/entity/rep/media/RepSplashMediaEntity;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/ad/d;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppSplashViewModel$getAd$1$1", f = "AppSplashViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAppSplashViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSplashViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppSplashViewModel$getAd$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,93:1\n1855#2,2:94\n*S KotlinDebug\n*F\n+ 1 AppSplashViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppSplashViewModel$getAd$1$1\n*L\n43#1:94,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
        final /* synthetic */ RequestBody $requestBody;
        int label;
        final /* synthetic */ AppSplashViewModel this$0;

        public AnonymousClass1(RequestBody r10, AppSplashViewModel r11, Continuation<? super AnonymousClass1> r12) {
            this.$requestBody = r10;
            this.this$0 = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.$requestBody, this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super d> r11) {
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
            d r13 = (d) r10;
            if ((r13 instanceof d.c) == false) goto L25;
            ArrayList r14 = new ArrayList();
            d.c r15 = (d.c) r13;
            List r16 = r15.a();
            if (r16 == null) goto L41;
            AppSplashViewModel r17 = this.this$0;
            Iterator r18 = r16.iterator();
        L17:
            if (r18.hasNext() == false) goto L41;
            RepAdEntity r19 = (RepAdEntity) r18.next();
            if (AppSplashViewModel.f(r17, r19) == false) goto L17;
            if (r19.getSet().getAtype() != 1) goto L17;
            r14.add(r19);
        L41:
            return new d.c(r15.b(), r14, r15.c());
        L25:
            if ((r13 instanceof d.a) == false) goto L29;
            return new d.a(((d.a) r13).a(), 0, 2, null);
        L29:
            if (q.b(r13, d.b.f8792a) == false) goto L33;
            return null;
        L33:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            AppSplashRepository r20 = AppSplashRepository.f9013a;
            RequestBody r21 = this.$requestBody;
            q.f(r21, "$requestBody");
            this.label = 1;
            r10 = r20.d(r21, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super d> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppSplashViewModel$getAd$1(ReqAdEntity r10, AppSplashViewModel r11, Continuation<? super AppSplashViewModel$getAd$1> r12) {
        this.$restAdEntity = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppSplashViewModel$getAd$1(this.$restAdEntity, this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        kotlin.c.b(r10);
    L12:
        r13.p(r10);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        String r14 = new Gson().toJson(this.$restAdEntity);
        RequestBody r15 = RequestBody.c(MediaType.c("application/json; charset=utf-8"), r14);
        this.this$0.h().p(d.b.f8792a);
        MutableLiveData r16 = this.this$0.h();
        CoroutineDispatcher r17 = l0.b();
        AnonymousClass1 r18 = new AnonymousClass1(r15, this.this$0, null);
        this.L$0 = r16;
        this.label = 1;
        r10 = h.g(r17, r18, this);
        if (r10 != r11) goto L11;
        return r11;
    L11:
        r13 = r16;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppSplashViewModel$getAd$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
