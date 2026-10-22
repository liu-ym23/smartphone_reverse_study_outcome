package com.obric.appstore.buss.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.smt.obric.appstore.ui.app.AppUIStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1", f = "AppDetailFragment.kt", i = {}, l = {472}, m = "invokeSuspend", n = {}, s = {})
public final class AppDetailFragment$handleInstallReq$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $req;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppDetailFragment this$0;

    /* JADX INFO: renamed from: com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1$1", f = "AppDetailFragment.kt", i = {}, l = {473}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $job;
        final /* synthetic */ AppInfo $req;
        int label;
        final /* synthetic */ AppDetailFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/appstore/buss/detail/a;", "data", "", "<anonymous>", "(Lcom/obric/appstore/buss/detail/a;)V"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1$1$1", f = "AppDetailFragment.kt", i = {0}, l = {491}, m = "invokeSuspend", n = {"appInfo"}, s = {"L$0"})
        public static final class C01651 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $job;
            final /* synthetic */ AppInfo $req;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AppDetailFragment this$0;

            /* JADX INFO: renamed from: com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/smt/obric/appstore/ui/app/AppUIStatus;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.appstore.buss.detail.AppDetailFragment$handleInstallReq$1$1$1$1", f = "AppDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01661 extends SuspendLambda implements Function2<AppUIStatus, Continuation<? super Boolean>, Object> {
                /* synthetic */ Object L$0;
                int label;

                public C01661(Continuation<? super C01661> r10) {
                    super(2, r10);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                    C01661 r12 = new C01661(r11);
                    r12.L$0 = r10;
                    return r12;
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(@NotNull AppUIStatus r10, @Nullable Continuation<? super Boolean> r11) {
                    return ((C01661) create(r10, r11)).invokeSuspend(Unit.f21064a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object r10) {
                    kotlin.coroutines.intrinsics.a.d();
                    if (this.label != 0) goto L7;
                    kotlin.c.b(r10);
                    return tf.a.a(!((AppUIStatus) this.L$0).d());
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo0invoke(AppUIStatus r10, Continuation<? super Boolean> r11) {
                    return invoke2(r10, r11);
                }
            }

            public C01651(AppInfo r10, AppDetailFragment r11, Job r12, Continuation<? super C01651> r13) {
                this.$req = r10;
                this.this$0 = r11;
                this.$job = r12;
                super(2, r13);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                C01651 r12 = new C01651(this.$req, this.this$0, this.$job, r11);
                r12.L$0 = r10;
                return r12;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@Nullable a r10, @Nullable Continuation<? super Unit> r11) {
                return ((C01651) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L7;
                AppInfo r13 = (AppInfo) this.L$0;
                kotlin.c.b(r10);
            L24:
                FragmentActivity r14 = this.this$0.getActivity();
                if (r14 == null) goto L27;
                AppDetailFragment.a0(this.this$0).y(r14, AppInfoKtxKt.newDomainEntity$default(r13, null, 1, null));
            L27:
                AppDetailFragment.d0(this.this$0, true);
                com.bytedanceos.common.toolbox.j.n("[AppStatus][AppDetailFragment] handle install req: handled, argAppInfo = " + com.bytedanceos.common.d.a(this.$req));
                Job r15 = this.$job;
                if (r15 == null) goto L31;
                Job.a.b(r15, null, 1, null);
            L31:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                a r16 = (a) this.L$0;
                if (r16 == null) goto L11;
                AppInfo r17 = r16.a();
            L12:
                if (r17 != null) goto L15;
                com.bytedanceos.common.toolbox.j.n("[AppStatus][AppDetailFragment] handle install req: appInfo is null skip, argAppInfo = " + com.bytedanceos.common.d.a(this.$req));
                return Unit.f21064a;
            L15:
                String r18 = r17.appDownloadUrl;
                if (r18 != null) goto L18;
            L32:
                com.bytedanceos.common.toolbox.j.n("[AppStatus][AppDetailFragment] handle install req: appDownloadUrl is null skip, argAppInfo = " + com.bytedanceos.common.d.a(this.$req));
                return Unit.f21064a;
            L18:
                if (r18.length() == 0) goto L32;
                AppDetailFragment.a0(this.this$0).q(AppInfoKtxKt.newDomainEntity$default(r17, null, 1, null));
                StateFlow r19 = AppDetailFragment.a0(this.this$0).p();
                C01661 r20 = new C01661(null);
                this.L$0 = r17;
                this.label = 1;
                if (kotlinx.coroutines.flow.c.v(r19, r20, this) != r11) goto L23;
                return r11;
            L23:
                r13 = r17;
                goto L24
            L11:
                r17 = null;
                goto L12
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(a r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }
        }

        public AnonymousClass1(AppDetailFragment r10, AppInfo r11, Job r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r10;
            this.$req = r11;
            this.$job = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$req, this.$job, r11);
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
            kotlin.c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            Flow r13 = FlowLiveDataConversions.a(AppDetailFragment.Z(this.this$0).k());
            C01651 r14 = new C01651(this.$req, this.this$0, this.$job, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.c.h(r13, r14, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppDetailFragment$handleInstallReq$1(AppDetailFragment r10, AppInfo r11, Continuation<? super AppDetailFragment$handleInstallReq$1> r12) {
        this.this$0 = r10;
        this.$req = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppDetailFragment$handleInstallReq$1 r12 = new AppDetailFragment$handleInstallReq$1(this.this$0, this.$req, r11);
        r12.L$0 = r10;
        return r12;
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
        kotlin.c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        Job r13 = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
        AppDetailFragment r14 = this.this$0;
        Lifecycle.State r15 = Lifecycle.State.RESUMED;
        AnonymousClass1 r16 = new AnonymousClass1(r14, this.$req, r13, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.b(r14, r15, r16, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppDetailFragment$handleInstallReq$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
