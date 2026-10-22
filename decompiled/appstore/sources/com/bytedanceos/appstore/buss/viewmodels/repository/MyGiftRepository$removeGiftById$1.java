package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.GiftMyEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.MyGiftRepository$removeGiftById$1", f = "MyGiftRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MyGiftRepository$removeGiftById$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ MyGiftRepository this$0;

    public MyGiftRepository$removeGiftById$1(MyGiftRepository r10, String r11, Continuation<? super MyGiftRepository$removeGiftById$1> r12) {
        this.this$0 = r10;
        this.$id = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new MyGiftRepository$removeGiftById$1(this.this$0, this.$id, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        a.d();
        if (this.label != 0) goto L16;
        c.b(r10);
        List r11 = (List) this.this$0.c().e();
        if (r11 == null) goto L14;
        String r12 = this.$id;
        MyGiftRepository r13 = this.this$0;
        Iterator r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        if (q.b(r12, ((GiftMyEntity) r14.next()).getId()) == false) goto L8;
        r14.remove();
        goto L8
    L12:
        r13.c().m(r11);
    L14:
        return Unit.f21064a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((MyGiftRepository$removeGiftById$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
