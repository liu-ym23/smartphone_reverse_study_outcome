package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.OAppletUtil$installOApplet$2$1", f = "OAppletUtil.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class OAppletUtil$installOApplet$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $packageName;
    final /* synthetic */ OAppletUtil $this_runCatching;
    int label;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.oapplet.OAppletUtil$installOApplet$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.OAppletUtil$installOApplet$2$1$1", f = "OAppletUtil.kt", i = {0}, l = {149}, m = "invokeSuspend", n = {"installJob"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $packageName;
        final /* synthetic */ OAppletUtil $this_runCatching;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Context r10, String r11, OAppletUtil r12, Continuation<? super AnonymousClass1> r13) {
            this.$context = r10;
            this.$packageName = r11;
            this.$this_runCatching = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$context, this.$packageName, this.$this_runCatching, r11);
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
        public final Object invokeSuspend(@NotNull Object r11) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            Job r13 = (Job) this.L$0;
            c.b(r11);
        L12:
            Job.a.b(r13, null, 1, null);
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r11);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            Job r15 = h.d(r14, null, null, new OAppletUtil$installOApplet$2$1$1$job$1(this.$context, this.$packageName, null), 3, null);
            Job r16 = h.d(r14, l0.b(), null, new OAppletUtil$installOApplet$2$1$1$installJob$1(this.$this_runCatching, this.$context, this.$packageName, null), 2, null);
            this.L$0 = r16;
            this.label = 1;
            if (r15.join(this) != r10) goto L11;
            return r10;
        L11:
            r13 = r16;
            goto L12
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public OAppletUtil$installOApplet$2$1(Context r10, String r11, OAppletUtil r12, Continuation<? super OAppletUtil$installOApplet$2$1> r13) {
        this.$context = r10;
        this.$packageName = r11;
        this.$this_runCatching = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new OAppletUtil$installOApplet$2$1(this.$context, this.$packageName, this.$this_runCatching, r11);
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
        c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        AnonymousClass1 r13 = new AnonymousClass1(this.$context, this.$packageName, this.$this_runCatching, null);
        this.label = 1;
        if (d0.e(r13, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((OAppletUtil$installOApplet$2$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
