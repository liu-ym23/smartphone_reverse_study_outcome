package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.OAppletUtil$installOApplet$2$1$1$job$1", f = "OAppletUtil.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
public final class OAppletUtil$installOApplet$2$1$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $packageName;
    int label;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.oapplet.OAppletUtil$installOApplet$2$1$1$job$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/smt/obric/appstore/domain/oapplet/b;", "it", "", "<anonymous>", "(Lcom/smt/obric/appstore/domain/oapplet/b;)Z"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.OAppletUtil$installOApplet$2$1$1$job$1$1", f = "OAppletUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $packageName;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r10, Continuation<? super AnonymousClass1> r11) {
            this.$packageName = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$packageName, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull b r10, @Nullable Continuation<? super Boolean> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L7;
            c.b(r10);
            return tf.a.a(q.b(((b) this.L$0).a(), this.$packageName));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(b r10, Continuation<? super Boolean> r11) {
            return invoke2(r10, r11);
        }
    }

    public OAppletUtil$installOApplet$2$1$1$job$1(Context r10, String r11, Continuation<? super OAppletUtil$installOApplet$2$1$1$job$1> r12) {
        this.$context = r10;
        this.$packageName = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new OAppletUtil$installOApplet$2$1$1$job$1(this.$context, this.$packageName, r11);
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
        Flow r13 = OAppletUtilKt.a(this.$context, "installOApplet[" + this.$packageName + ']');
        AnonymousClass1 r14 = new AnonymousClass1(this.$packageName, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.c.v(r13, r14, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((OAppletUtil$installOApplet$2$1$1$job$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
