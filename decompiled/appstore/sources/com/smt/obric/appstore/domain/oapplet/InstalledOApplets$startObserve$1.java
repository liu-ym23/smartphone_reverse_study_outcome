package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import kotlin.Metadata;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.InstalledOApplets$startObserve$1", f = "InstalledOApplet.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nInstalledOApplet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstalledOApplet.kt\ncom/smt/obric/appstore/domain/oapplet/InstalledOApplets$startObserve$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,84:1\n53#2:85\n55#2:89\n50#3:86\n55#3:88\n106#4:87\n*S KotlinDebug\n*F\n+ 1 InstalledOApplet.kt\ncom/smt/obric/appstore/domain/oapplet/InstalledOApplets$startObserve$1\n*L\n47#1:85\n47#1:89\n47#1:86\n47#1:88\n47#1:87\n*E\n"})
public final class InstalledOApplets$startObserve$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.oapplet.InstalledOApplets$startObserve$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.InstalledOApplets$startObserve$1$2", f = "InstalledOApplet.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass2(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Unit r10, Continuation<? super Unit> r11) {
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
            InstalledOApplets r13 = InstalledOApplets.f18057a;
            this.label = 1;
            if (InstalledOApplets.c(r13, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull Unit r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public InstalledOApplets$startObserve$1(Continuation<? super InstalledOApplets$startObserve$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new InstalledOApplets$startObserve$1(r11);
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
    L15:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        Flow r13 = kotlinx.coroutines.flow.c.C(Unit.f21064a);
        Context r14 = InstalledOApplets.b();
        if (r14 != null) goto L11;
        q.y("context");
        r14 = null;
    L11:
        final Flow r15 = OAppletUtilKt.a(r14, "InstalledOApplets");
        Flow r16 = kotlinx.coroutines.flow.c.J(new Flow[]{r13, new InstalledOApplets$startObserve$1$invokeSuspend$$inlined$map$1(r15)});
        AnonymousClass2 r17 = new AnonymousClass2(null);
        this.label = 1;
        if (kotlinx.coroutines.flow.c.h(r16, r17, this) != r11) goto L15;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((InstalledOApplets$startObserve$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
