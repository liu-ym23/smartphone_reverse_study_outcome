package com.smt.obric.appstore.domain.app;

import com.obric.download.base.DownloadInfo;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/smt/obric/appstore/domain/app/entity/a;", "<anonymous>", "()Lcom/smt/obric/appstore/domain/app/entity/a;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$syncWithDownloadInfo$2$getTask$1", f = "AppInstallActor.kt", i = {}, l = {984}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAppInstallActor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$syncWithDownloadInfo$2$getTask$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1261:1\n1#2:1262\n*E\n"})
public final class AppInstallActor$syncWithDownloadInfo$2$getTask$1 extends SuspendLambda implements Function1<Continuation<? super com.smt.obric.appstore.domain.app.entity.a>, Object> {
    final /* synthetic */ AppInstallActor.b.AbstractC0215b $msg;
    final /* synthetic */ AppInstallActor $this_run;
    int label;

    public AppInstallActor$syncWithDownloadInfo$2$getTask$1(AppInstallActor.b.AbstractC0215b r10, AppInstallActor r11, Continuation<? super AppInstallActor$syncWithDownloadInfo$2$getTask$1> r12) {
        this.$msg = r10;
        this.$this_run = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new AppInstallActor$syncWithDownloadInfo$2$getTask$1(this.$msg, this.$this_run, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r10) {
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
    L16:
        return (com.smt.obric.appstore.domain.app.entity.a) r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        DownloadInfo r13 = this.$msg.a();
        if (r13 == null) goto L14;
        long r14 = r13.getId();
        AppInstallTaskDAO r15 = AppInstallActor.t(this.$this_run);
        this.label = 1;
        r10 = r15.getByDownloadId(r14, this);
        if (r10 != r11) goto L16;
        return r11;
    L14:
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r10) {
        return ((AppInstallActor$syncWithDownloadInfo$2$getTask$1) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
