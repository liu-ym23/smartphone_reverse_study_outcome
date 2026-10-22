package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCommentsWrap;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppCommentsRepository;
import com.bytedanceos.appstore.buss.viewmodels.repository.CommonAppCommentsRepository;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppCommentsViewModel$getComments$1", f = "AppCommentsViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class AppCommentsViewModel$getComments$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AppCommentsViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppCommentsViewModel$getComments$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppCommentsWrap;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppCommentsViewModel$getComments$1$1", f = "AppCommentsViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        int label;
        final /* synthetic */ AppCommentsViewModel this$0;

        public AnonymousClass1(AppCommentsViewModel r10, Continuation<? super AnonymousClass1> r11) {
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
            if ((r13 instanceof h.c) == false) goto L33;
            h.c r14 = (h.c) r13;
            AppCommentsWrap r15 = (AppCommentsWrap) r14.a();
            if (r15 == null) goto L17;
            ((AppCommentsWrap) r14.a()).setResId(e.c0(BaseApplication.c(), r15.getScores(), true, "lkp_"));
        L17:
            if (this.this$0.l() != 1) goto L30;
            CommonAppCommentsRepository r16 = CommonAppCommentsRepository.f9017b.a();
            String r17 = this.this$0.m();
            AppCommentsWrap r18 = (AppCommentsWrap) r14.a();
            Integer r19 = null;
            if (r18 == null) goto L21;
            Float r20 = tf.a.b(r18.getScores());
        L22:
            AppCommentsWrap r21 = (AppCommentsWrap) r14.a();
            if (r21 == null) goto L25;
            Integer r22 = tf.a.c(r21.getCount());
        L26:
            AppCommentsWrap r23 = (AppCommentsWrap) r14.a();
            if (r23 == null) goto L29;
            r19 = tf.a.c(r23.getResId());
        L29:
            r16.c(r17, r20, r22, r19);
            goto L30
        L25:
            r22 = null;
            goto L26
        L21:
            r20 = null;
        L30:
            Object r24 = new h.c(r14.b(), r14.a(), r14.c());
        L38:
            return r24;
        L33:
            if ((r13 instanceof h.a) == true) goto L41;
            r24 = h.b.f8818a;
            if (q.b(r13, r24) == true) goto L38;
            throw new NoWhenBranchMatchedException();
        L41:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            AppCommentsRepository r25 = AppCommentsRepository.f9007a;
            String r26 = this.this$0.m();
            int r27 = this.this$0.l();
            int r28 = this.this$0.n();
            this.label = 1;
            r10 = r25.h(r26, r27, r28, this);
            if (r10 != r11) goto L11;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppCommentsViewModel$getComments$1(AppCommentsViewModel r10, Continuation<? super AppCommentsViewModel$getComments$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppCommentsViewModel$getComments$1(this.this$0, r11);
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
        this.this$0.k().p(h.b.f8818a);
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
        return ((AppCommentsViewModel$getComments$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
