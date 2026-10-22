package com.smt.obric.appstore.domain.usecase.app.install;

import com.smt.obric.appstore.domain.app.entity.AppStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lle/c;", "installed", "Lcom/smt/obric/appstore/domain/app/entity/a;", "processing", "Lhe/b;", "<anonymous>", "(Lle/c;Lcom/smt/obric/appstore/domain/app/entity/a;)Lhe/b;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.usecase.app.install.GetAppStatusUseCase$invoke$1", f = "GetAppStatusUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GetAppStatusUseCase$invoke$1 extends SuspendLambda implements Function3<le.c, com.smt.obric.appstore.domain.app.entity.a, Continuation<? super he.b>, Object> {
    final /* synthetic */ String $pkg;
    final /* synthetic */ Long $versionCode;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ GetAppStatusUseCase this$0;

    public GetAppStatusUseCase$invoke$1(GetAppStatusUseCase r10, Long r11, String r12, Continuation<? super GetAppStatusUseCase$invoke$1> r13) {
        this.this$0 = r10;
        this.$versionCode = r11;
        this.$pkg = r12;
        super(3, r13);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(le.c r10, com.smt.obric.appstore.domain.app.entity.a r11, Continuation<? super he.b> r12) {
        return invoke2(r10, r11, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r14) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L26;
        kotlin.c.b(r14);
        le.c r15 = (le.c) this.L$0;
        com.smt.obric.appstore.domain.app.entity.a r10 = (com.smt.obric.appstore.domain.app.entity.a) this.L$1;
        if (r10 != null) goto L7;
    L14:
        if (r15 == null) goto L24;
        Long r11 = this.$versionCode;
        if (r11 == null) goto L24;
        String r12 = this.$pkg;
        if (r11.longValue() <= r15.b()) goto L21;
        AppStatus r13 = AppStatus.m.f17992a;
    L28:
        return new he.b(r12, null, r11, r13, null);
    L21:
        r13 = AppStatus.i.f17984a;
    L24:
        return new he.b(this.$pkg, null, this.$versionCode, AppStatus.k.f17988a, null);
    L7:
        if (r10.M() == false) goto L27;
        if (GetAppStatusUseCase.a(this.this$0) == false) goto L27;
        if (r10.N() == false) goto L14;
    L27:
        return new he.b(this.$pkg, r10.f(), tf.a.d(r10.J()), r10.G(), r10);
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable le.c r10, @Nullable com.smt.obric.appstore.domain.app.entity.a r11, @Nullable Continuation<? super he.b> r12) {
        GetAppStatusUseCase$invoke$1 r13 = new GetAppStatusUseCase$invoke$1(this.this$0, this.$versionCode, this.$pkg, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.f21064a);
    }
}
