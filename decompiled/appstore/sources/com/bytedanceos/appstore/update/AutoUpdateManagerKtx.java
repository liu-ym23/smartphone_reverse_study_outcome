package com.bytedanceos.appstore.update;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.db.AppBD;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.CancelAppInstallUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.InstallSysAppAutoUpdateManuallyUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/update/AutoUpdateManagerKtx;", "", "<init>", "()V", "", "awaitDep", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bytedanceos/common/model/AppInfo;", "appInfo", "Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode;", "installMode", "downloadSysAppAutoUpdateManually", "(Lcom/bytedanceos/common/model/AppInfo;Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode;)V", "", AppPermissionActivity.EXTRA_APP_PKG, "installSysAppAutoUpdateManually", "(Ljava/lang/String;Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode;)V", "Lcom/smt/obric/appstore/domain/app/entity/a;", "getAppInstallTaskBlocking", "(Ljava/lang/String;)Lcom/smt/obric/appstore/domain/app/entity/a;", "cancelAppInstallTaskBlocking", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AutoUpdateManagerKtx {

    @NotNull
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.update.AutoUpdateManagerKtx$cancelAppInstallTaskBlocking$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.update.AutoUpdateManagerKtx$cancelAppInstallTaskBlocking$1", f = "AutoUpdateManagerKtx.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ String $pkg;
        int label;
        final /* synthetic */ AutoUpdateManagerKtx this$0;

        /* JADX INFO: renamed from: com.bytedanceos.appstore.update.AutoUpdateManagerKtx$cancelAppInstallTaskBlocking$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedanceos.appstore.update.AutoUpdateManagerKtx$cancelAppInstallTaskBlocking$1$1", f = "AutoUpdateManagerKtx.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $pkg;
            int label;

            public C01261(String r10, Continuation<? super C01261> r11) {
                this.$pkg = r10;
                super(2, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new C01261(this.$pkg, r11);
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
                c.b(r10);
            L12:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                c.b(r10);
                CancelAppInstallUseCase r13 = new CancelAppInstallUseCase(AppInstallActor.f17891n.b());
                String r14 = this.$pkg;
                this.label = 1;
                if (r13.a(r14, this) != r11) goto L12;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((C01261) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass1(AutoUpdateManagerKtx r10, String r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$pkg = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$pkg, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Job> r11) {
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
        L12:
            return h.d(AutoUpdateManagerKtx.access$getScope$p(this.this$0), null, null, new C01261(this.$pkg, null), 3, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            AutoUpdateManagerKtx r13 = this.this$0;
            this.label = 1;
            if (AutoUpdateManagerKtx.access$awaitDep(r13, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Job> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.update.AutoUpdateManagerKtx$downloadSysAppAutoUpdateManually$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.update.AutoUpdateManagerKtx$downloadSysAppAutoUpdateManually$1", f = "AutoUpdateManagerKtx.kt", i = {}, l = {26, 36}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppInfo $appInfo;
        final /* synthetic */ AppInstallMode $installMode;
        int label;
        final /* synthetic */ AutoUpdateManagerKtx this$0;

        public C04241(AutoUpdateManagerKtx r10, AppInstallMode r11, AppInfo r12, Continuation<? super C04241> r13) {
            this.this$0 = r10;
            this.$installMode = r11;
            this.$appInfo = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new C04241(this.this$0, this.$installMode, this.$appInfo, r11);
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
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            c.b(r10);
        L24:
            return Unit.f21064a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            c.b(r10);
        L13:
            AppInstallMode r13 = this.$installMode;
            if (r13 == null) goto L17;
        L20:
            EnqueueAppInstallTaskUseCase r14 = new EnqueueAppInstallTaskUseCase(AppInstallActor.f17891n.b());
            he.a r15 = AppInfoKtxKt.newDomainEntity(this.$appInfo, r13);
            AppInfo r16 = this.$appInfo;
            com.smt.obric.appstore.domain.app.entity.a r17 = n.d(r15, r16.mUpdateModel, r16.mSysAppAutoUpdateComplianceMode, r13);
            this.label = 2;
            if (r14.a(r17, this) != r11) goto L24;
            return r11;
        L17:
            if (this.$appInfo.mUpdateModel != 1) goto L19;
            r13 = AppInstallMode.d.f17966a;
            goto L20
        L19:
            r13 = AppInstallMode.c.f17964a;
            goto L20
        L10:
            c.b(r10);
            AutoUpdateManagerKtx r18 = this.this$0;
            this.label = 1;
            if (AutoUpdateManagerKtx.access$awaitDep(r18, this) != r11) goto L13;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((C04241) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.update.AutoUpdateManagerKtx$getAppInstallTaskBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/smt/obric/appstore/domain/app/entity/a;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/smt/obric/appstore/domain/app/entity/a;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.update.AutoUpdateManagerKtx$getAppInstallTaskBlocking$1", f = "AutoUpdateManagerKtx.kt", i = {}, l = {58, 59}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.smt.obric.appstore.domain.app.entity.a>, Object> {
        final /* synthetic */ String $pkg;
        int label;
        final /* synthetic */ AutoUpdateManagerKtx this$0;

        public C04251(AutoUpdateManagerKtx r10, String r11, Continuation<? super C04251> r12) {
            this.this$0 = r10;
            this.$pkg = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new C04251(this.this$0, this.$pkg, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r11) {
            return invoke2(r10, r11);
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
        L16:
            return r10;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            c.b(r10);
        L13:
            Flow r13 = new com.smt.obric.appstore.domain.usecase.app.install.a(AppBD.f17955p.b().F()).a(this.$pkg);
            this.label = 2;
            r10 = kotlinx.coroutines.flow.c.w(r13, this);
            if (r10 != r11) goto L16;
            return r11;
        L10:
            c.b(r10);
            AutoUpdateManagerKtx r14 = this.this$0;
            this.label = 1;
            if (AutoUpdateManagerKtx.access$awaitDep(r14, this) != r11) goto L13;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r11) {
            return ((C04251) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.update.AutoUpdateManagerKtx$installSysAppAutoUpdateManually$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.update.AutoUpdateManagerKtx$installSysAppAutoUpdateManually$1", f = "AutoUpdateManagerKtx.kt", i = {}, l = {51, 53}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppInstallMode $installMode;
        final /* synthetic */ String $pkg;
        int label;
        final /* synthetic */ AutoUpdateManagerKtx this$0;

        public C04261(AutoUpdateManagerKtx r10, String r11, AppInstallMode r12, Continuation<? super C04261> r13) {
            this.this$0 = r10;
            this.$pkg = r11;
            this.$installMode = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new C04261(this.this$0, this.$pkg, this.$installMode, r11);
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
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            c.b(r10);
        L17:
            return Unit.f21064a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            c.b(r10);
        L13:
            InstallSysAppAutoUpdateManuallyUseCase r13 = new InstallSysAppAutoUpdateManuallyUseCase(AppInstallActor.f17891n.b());
            String r14 = this.$pkg;
            AppInstallMode r15 = this.$installMode;
            this.label = 2;
            if (r13.a(r14, r15, this) != r11) goto L17;
            return r11;
        L10:
            c.b(r10);
            AutoUpdateManagerKtx r16 = this.this$0;
            this.label = 1;
            if (AutoUpdateManagerKtx.access$awaitDep(r16, this) != r11) goto L13;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((C04261) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AutoUpdateManagerKtx() {
        this.scope = d0.b();
    }

    public static final /* synthetic */ Object access$awaitDep(AutoUpdateManagerKtx r10, Continuation r11) {
        return r10.awaitDep(r11);
    }

    public static final /* synthetic */ CoroutineScope access$getScope$p(AutoUpdateManagerKtx r10) {
        return r10.scope;
    }

    private final Object awaitDep(Continuation<? super Unit> r10) {
        Object r11 = AppInstallActor.f17891n.a().await(r10);
        if (r11 != a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public static /* synthetic */ void downloadSysAppAutoUpdateManually$default(AutoUpdateManagerKtx r10, AppInfo r11, AppInstallMode r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.downloadSysAppAutoUpdateManually(r11, r12);
    }

    public static /* synthetic */ void installSysAppAutoUpdateManually$default(AutoUpdateManagerKtx r10, String r11, AppInstallMode r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.installSysAppAutoUpdateManually(r11, r12);
    }

    public final void cancelAppInstallTaskBlocking(@NotNull String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        h.f(null, new AnonymousClass1(this, r10, null), 1, null);
    }

    public final void downloadSysAppAutoUpdateManually(@NotNull AppInfo r10, @Nullable AppInstallMode r11) {
        q.g(r10, "appInfo");
        h.d(this.scope, null, null, new C04241(this, r11, r10, null), 3, null);
    }

    @Nullable
    public final com.smt.obric.appstore.domain.app.entity.a getAppInstallTaskBlocking(@NotNull String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        return (com.smt.obric.appstore.domain.app.entity.a) h.f(null, new C04251(this, r10, null), 1, null);
    }

    public final void installSysAppAutoUpdateManually(@NotNull String r10, @Nullable AppInstallMode r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        h.d(this.scope, null, null, new C04261(this, r10, r11, null), 3, null);
    }
}
