package com.bytedanceos.appstore.datacache;

import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.db.AppBD;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/smt/obric/appstore/domain/app/entity/a;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/smt/obric/appstore/domain/app/entity/a;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.datacache.AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1", f = "AppStoreCacheKtx.kt", i = {}, l = {35, 37}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAppStoreCacheKtx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppStoreCacheKtx.kt\ncom/bytedanceos/appstore/datacache/AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
public final class AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.smt.obric.appstore.domain.app.entity.a>, Object> {
    final /* synthetic */ String $pkg;
    final /* synthetic */ boolean $resume;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ AppStoreCacheKtx this$0;

    public AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1(AppStoreCacheKtx r10, String r11, boolean r12, Continuation<? super AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1> r13) {
        this.this$0 = r10;
        this.$pkg = r11;
        this.$resume = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1(this.this$0, this.$pkg, this.$resume, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        boolean r13 = this.Z$0;
        String r14 = (String) this.L$1;
        AppStoreCacheKtx r15 = (AppStoreCacheKtx) this.L$0;
        c.b(r12);     // Catch: Throwable -> L9
    L25:
        com.smt.obric.appstore.domain.app.entity.a r16 = (com.smt.obric.appstore.domain.app.entity.a) r12;     // Catch: Throwable -> L9
        if (r16 != null) goto L28;
    L30:
        r12 = null;
    L31:
        com.smt.obric.appstore.domain.app.entity.a r17 = (com.smt.obric.appstore.domain.app.entity.a) r12;     // Catch: Throwable -> L9
        if (r13 == false) goto L47;
        if (r17 == null) goto L47;
        if (r17.M() == false) goto L47;
        if (r17.N() == true) goto L47;
        if (r17.w() == true) goto L47;
        if (q.b(r17.G(), AppStatus.j.f17986a) == true) goto L47;
        if (q.b(r17.G(), AppStatus.h.f17982a) == true) goto L47;
        if (q.b(r17.G(), AppStatus.d.f17974a) == true) goto L47;
        j.s("[AppStatus] work around sysapp auto update, resume task when getProgress, pkg=" + r14);     // Catch: Throwable -> L9
        h.d(AppStoreCacheKtx.b(r15), null, null, new AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1$1$1(r14, r17, null), 3, null);     // Catch: Throwable -> L9
    L47:
        Object r18 = Result.m35constructorimpl(r17);     // Catch: Throwable -> L9
    L51:
        if (Result.m41isFailureimpl(r18) == false) goto L54;
        return null;
    L54:
        return r18;
    L28:
        if (r16.I() != 1) goto L30;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        boolean r19 = this.Z$0;
        String r20 = (String) this.L$1;
        AppStoreCacheKtx r21 = (AppStoreCacheKtx) this.L$0;
        c.b(r12);     // Catch: Throwable -> L9
        AppStoreCacheKtx r110 = r21;
    L21:
        Flow r22 = new com.smt.obric.appstore.domain.usecase.app.install.a(AppBD.f17955p.b().F()).a(r20);     // Catch: Throwable -> L9
        this.L$0 = r110;     // Catch: Throwable -> L9
        this.L$1 = r20;     // Catch: Throwable -> L9
        this.Z$0 = r19;     // Catch: Throwable -> L9
        this.label = 2;     // Catch: Throwable -> L9
        Object r111 = kotlinx.coroutines.flow.c.w(r22, this);     // Catch: Throwable -> L9
        if (r111 != r10) goto L24;
        return r10;
    L24:
        r13 = r19;
        r14 = r20;
        AppStoreCacheKtx r112 = r110;
        r12 = r111;
        r15 = r112;
        goto L25
    L16:
        c.b(r12);
        r110 = this.this$0;
        String r23 = this.$pkg;
        boolean r24 = this.$resume;
        Result.a r25 = Result.Companion;     // Catch: Throwable -> L9
        this.L$0 = r110;     // Catch: Throwable -> L9
        this.L$1 = r23;     // Catch: Throwable -> L9
        this.Z$0 = r24;     // Catch: Throwable -> L9
        this.label = 1;     // Catch: Throwable -> L9
        if (AppStoreCacheKtx.a(r110, this) != r10) goto L20;
        return r10;
    L20:
        r20 = r23;
        r19 = r24;
    L9:
        th = move-exception;
        Result.a r113 = Result.Companion;
        r18 = Result.m35constructorimpl(c.a(th));
        goto L51
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r11) {
        return ((AppStoreCacheKtx$getInAppSysAppUpdateInstallTaskBlocking$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
