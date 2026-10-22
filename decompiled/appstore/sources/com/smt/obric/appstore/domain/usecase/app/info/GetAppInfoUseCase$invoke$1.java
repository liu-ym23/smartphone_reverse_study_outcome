package com.smt.obric.appstore.domain.usecase.app.info;

import com.smt.obric.appstore.domain.app.db.AppInfoDao;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lhe/a;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.usecase.app.info.GetAppInfoUseCase$invoke$1", f = "GetAppInfoUseCase.kt", i = {1}, l = {22, 24, 25}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
final class GetAppInfoUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends he.a>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pkg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f18119a;

        public a(FlowCollector r10) {
            this.f18119a = r10;
        }

        public final Object a(he.a r10, Continuation r11) {
            Object r12 = this.f18119a.emit(Result.m34boximpl(Result.m35constructorimpl(r10)), r11);
            if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r12;
        L6:
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
            return a((he.a) r10, r11);
        }
    }

    public GetAppInfoUseCase$invoke$1(b r10, String r11, Continuation<? super GetAppInfoUseCase$invoke$1> r12) {
        this.$pkg = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        GetAppInfoUseCase$invoke$1 r12 = new GetAppInfoUseCase$invoke$1(null, this.$pkg, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(FlowCollector<? super Result<? extends he.a>> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FlowCollector r13 = (FlowCollector) this.L$0;
        c.b(r10);
    L27:
        Flow<he.a> r14 = b.a(null).getByPkg(this.$pkg);
        a r15 = new a(r13);
        this.L$0 = null;
        this.label = 3;
        if (r14.collect(r15, this) != r11) goto L31;
        return r11;
    L31:
        return Unit.f21064a;
    L11:
        c.b(r10);
        goto L31
    L12:
        c.b(r10);
        r13 = (FlowCollector) this.L$0;
        Result.a r16 = Result.Companion;     // Catch: Throwable -> L15
        throw new UnsupportedOperationException("not supported forceRemote");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.a r17 = Result.Companion;
        Object r18 = Result.m35constructorimpl(c.a(th));
        if (Result.m41isFailureimpl(r18) == false) goto L21;
        Result r19 = Result.m34boximpl(r18);
        this.label = 1;
        if (r13.emit(r19, this) != r11) goto L31;
        return r11;
    L21:
        AppInfoDao r20 = b.a(null);
        if (Result.m41isFailureimpl(r18) == false) goto L24;
        r18 = null;
    L24:
        q.d(r18);
        this.L$0 = r13;
        this.label = 2;
        if (r20.upsert((he.a) r18, this) != r11) goto L27;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<? super Result<he.a>> r10, @Nullable Continuation<? super Unit> r11) {
        return ((GetAppInfoUseCase$invoke$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
