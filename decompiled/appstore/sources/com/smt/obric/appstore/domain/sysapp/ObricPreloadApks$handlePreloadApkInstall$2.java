package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import com.smt.obric.appstore.domain.oapplet.OAppletUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.ObricPreloadApks$handlePreloadApkInstall$2", f = "ObricPreloadApks.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class ObricPreloadApks$handlePreloadApkInstall$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $appInstallTask;
    final /* synthetic */ Context $context;
    int label;

    public ObricPreloadApks$handlePreloadApkInstall$2(Context r10, com.smt.obric.appstore.domain.app.entity.a r11, Continuation<? super ObricPreloadApks$handlePreloadApkInstall$2> r12) {
        this.$context = r10;
        this.$appInstallTask = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ObricPreloadApks$handlePreloadApkInstall$2(this.$context, this.$appInstallTask, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Result<? extends Boolean>> r11) {
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
        Object r13 = ((Result) r10).m44unboximpl();
    L12:
        return Result.m34boximpl(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        OAppletUtil r14 = OAppletUtil.f18065a;
        Context r15 = this.$context;
        String r16 = r14.i(this.$appInstallTask.E());
        this.label = 1;
        r13 = r14.f(r15, r16, this);
        if (r13 != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Result<Boolean>> r11) {
        return ((ObricPreloadApks$handlePreloadApkInstall$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
