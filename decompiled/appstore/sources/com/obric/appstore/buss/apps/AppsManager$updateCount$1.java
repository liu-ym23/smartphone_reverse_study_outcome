package com.obric.appstore.buss.apps;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.apps.AppsManager$updateCount$1", f = "AppsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppsManager$updateCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AppsManager$updateCount$1(Continuation<? super AppsManager$updateCount$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppsManager$updateCount$1(r11);
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
        if (this.label != 0) goto L14;
        kotlin.c.b(r10);
        List r11 = BaseApplication.c().b().v("UPDATE");
        StringBuilder r12 = new StringBuilder();
        r12.append("AppsManager updateCount ");
        int r13 = 0;
        if (r11 == null) goto L7;
        int r14 = r11.size();
    L8:
        r12.append(r14);
        j.n(r12.toString());
        MutableLiveData r15 = AppsManager.b();
        if (r11 == null) goto L11;
        r13 = r11.size();
    L11:
        r15.m(tf.a.c(r13));
        return Unit.f21064a;
    L7:
        r14 = 0;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppsManager$updateCount$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
