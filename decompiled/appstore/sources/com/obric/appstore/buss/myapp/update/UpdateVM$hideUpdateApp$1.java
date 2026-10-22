package com.obric.appstore.buss.myapp.update;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.IgnoreAppEvent;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.buss.apps.AppsManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM$hideUpdateApp$1", f = "UpdateVM.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
public final class UpdateVM$hideUpdateApp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $appInfo;
    final /* synthetic */ boolean $hide;
    int label;
    final /* synthetic */ UpdateVM this$0;

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateVM$hideUpdateApp$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM$hideUpdateApp$1$1", f = "UpdateVM.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AppInfo $appInfo;
        final /* synthetic */ boolean $hide;
        int label;

        /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateVM$hideUpdateApp$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM$hideUpdateApp$1$1$1", f = "UpdateVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppInfo $appInfo;
            final /* synthetic */ boolean $hide;
            int label;

            public C01701(AppInfo r10, boolean r11, Continuation<? super C01701> r12) {
                this.$appInfo = r10;
                this.$hide = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new C01701(this.$appInfo, this.$hide, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                kotlin.coroutines.intrinsics.a.d();
                if (this.label != 0) goto L15;
                kotlin.c.b(r10);
                AppsManager r11 = AppsManager.f10585a;
                String r12 = this.$appInfo.appPackageName;
                q.f(r12, "appPackageName");
                AppInfo r13 = r11.d(r12);
                if (r13 != null) goto L9;
                return Unit.f21064a;
            L9:
                if (r13.downloadStatus != 8) goto L12;
                com.bytedanceos.common.toolbox.j.n("UpdateVM hideUpdateApp ignore while installing");
                return Unit.f21064a;
            L12:
                BaseApplication.c().b().K(this.$appInfo, this.$hide);
                com.bytedanceos.common.toolbox.e.c1();
                EventBus.getDefault().post(new IgnoreAppEvent(true));
                return Unit.f21064a;
            L15:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((C01701) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass1(AppInfo r10, boolean r11, Continuation<? super AnonymousClass1> r12) {
            this.$appInfo = r10;
            this.$hide = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
            return new AnonymousClass1(this.$appInfo, this.$hide, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
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
            CoroutineDispatcher r13 = l0.b();
            C01701 r14 = new C01701(this.$appInfo, this.$hide, null);
            this.label = 1;
            if (kotlinx.coroutines.h.g(r13, r14, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r10)).invokeSuspend(Unit.f21064a);
        }
    }

    public UpdateVM$hideUpdateApp$1(UpdateVM r10, AppInfo r11, boolean r12, Continuation<? super UpdateVM$hideUpdateApp$1> r13) {
        this.this$0 = r10;
        this.$appInfo = r11;
        this.$hide = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UpdateVM$hideUpdateApp$1(this.this$0, this.$appInfo, this.$hide, r11);
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
    L11:
        ILoadViewModel.s(this.this$0, false, false, 3, null);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        UpdateVM r13 = this.this$0;
        AnonymousClass1 r14 = new AnonymousClass1(this.$appInfo, this.$hide, null);
        this.label = 1;
        if (r13.i(r14, this) != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UpdateVM$hideUpdateApp$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
