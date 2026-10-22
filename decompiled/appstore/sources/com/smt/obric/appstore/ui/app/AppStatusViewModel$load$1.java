package com.smt.obric.appstore.ui.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.ui.app.AppStatusViewModel$load$1", f = "AppStatusViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class AppStatusViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ he.a $targetAppInfo;
    int label;
    final /* synthetic */ AppStatusViewModel this$0;

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStatusViewModel f18169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ he.a f18170b;

        public a(AppStatusViewModel r10, he.a r11) {
            this.f18169a = r10;
            this.f18170b = r11;
        }

        public final Object a(he.b r10, Continuation r11) {
            AppStatusViewModel.m(this.f18169a).setValue(d.a((AppUIStatus) AppStatusViewModel.m(this.f18169a).getValue(), r10, this.f18170b));
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
            return a((he.b) r10, r11);
        }
    }

    public AppStatusViewModel$load$1(AppStatusViewModel r10, he.a r11, Continuation<? super AppStatusViewModel$load$1> r12) {
        this.this$0 = r10;
        this.$targetAppInfo = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppStatusViewModel$load$1(this.this$0, this.$targetAppInfo, r11);
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
        Flow r13 = AppStatusViewModel.i(this.this$0).b(this.$targetAppInfo.j(), tf.a.d(this.$targetAppInfo.o()));
        a r14 = new a(this.this$0, this.$targetAppInfo);
        this.label = 1;
        if (r13.collect(r14, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppStatusViewModel$load$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
