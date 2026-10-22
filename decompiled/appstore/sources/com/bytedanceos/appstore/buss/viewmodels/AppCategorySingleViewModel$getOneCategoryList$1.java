package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppCategorySingleRepository;
import com.bytedanceos.common.networkv2.params.NetValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppCategorySingleViewModel$getOneCategoryList$1", f = "AppCategorySingleViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class AppCategorySingleViewModel$getOneCategoryList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AppCategorySingleViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppCategorySingleViewModel$getOneCategoryList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppCategorySingleViewModel$getOneCategoryList$1$1", f = "AppCategorySingleViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        int label;
        final /* synthetic */ AppCategorySingleViewModel this$0;

        public AnonymousClass1(AppCategorySingleViewModel r10, Continuation<? super AnonymousClass1> r11) {
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
            if ((r13 instanceof h.c) == false) goto L18;
            h.c r15 = (h.c) r13;
            HttpResultHead r16 = r15.b();
            AppsWrap r17 = (AppsWrap) r15.a();
            if (r17 == null) goto L26;
            r14 = r17.getApps();
        L26:
            return new h.c(r16, r14, r15.c());
        L18:
            if ((r13 instanceof h.a) == false) goto L21;
            return r13;
        L21:
            if ((r13 instanceof h.b) == false) goto L25;
            return null;
        L25:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            AppCategorySingleRepository r18 = AppCategorySingleRepository.f9006a;
            int r19 = AppCategorySingleViewModel.f(this.this$0);
            int r20 = this.this$0.j();
            int r21 = this.this$0.h();
            this.label = 1;
            r10 = r18.f(r19, r20, r21, NetValue.TYPE_RANK, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppCategorySingleViewModel$getOneCategoryList$1(AppCategorySingleViewModel r10, Continuation<? super AppCategorySingleViewModel$getOneCategoryList$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppCategorySingleViewModel$getOneCategoryList$1(this.this$0, r11);
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
        this.this$0.g().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.g();
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
        return ((AppCategorySingleViewModel$getOneCategoryList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
