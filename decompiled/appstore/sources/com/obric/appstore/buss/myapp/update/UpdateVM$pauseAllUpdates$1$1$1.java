package com.obric.appstore.buss.myapp.update;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM$pauseAllUpdates$1$1$1", f = "UpdateVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUpdateVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateVM.kt\ncom/obric/appstore/buss/myapp/update/UpdateVM$pauseAllUpdates$1$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,254:1\n766#2:255\n857#2,2:256\n1855#2,2:258\n*S KotlinDebug\n*F\n+ 1 UpdateVM.kt\ncom/obric/appstore/buss/myapp/update/UpdateVM$pauseAllUpdates$1$1$1\n*L\n230#1:255\n230#1:256,2\n230#1:258,2\n*E\n"})
public final class UpdateVM$pauseAllUpdates$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.smt.obric.appstore.domain.app.entity.a> $it;
    private /* synthetic */ Object L$0;
    int label;

    public UpdateVM$pauseAllUpdates$1$1$1(List<com.smt.obric.appstore.domain.app.entity.a> r10, Continuation<? super UpdateVM$pauseAllUpdates$1$1$1> r11) {
        this.$it = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        UpdateVM$pauseAllUpdates$1$1$1 r12 = new UpdateVM$pauseAllUpdates$1$1$1(this.$it, r11);
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
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L17;
        kotlin.c.b(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        List<com.smt.obric.appstore.domain.app.entity.a> r12 = this.$it;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        Object r15 = r14.next();
        if (((com.smt.obric.appstore.domain.app.entity.a) r15).O() == false) goto L6;
        r13.add(r15);
        goto L6
    L10:
        Iterator r16 = r13.iterator();
    L12:
        if (r16.hasNext() == false) goto L15;
        kotlinx.coroutines.h.d(r11, null, null, new UpdateVM$pauseAllUpdates$1$1$1$2$1((com.smt.obric.appstore.domain.app.entity.a) r16.next(), null), 3, null);
        goto L12
    L15:
        return Unit.f21064a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UpdateVM$pauseAllUpdates$1$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
