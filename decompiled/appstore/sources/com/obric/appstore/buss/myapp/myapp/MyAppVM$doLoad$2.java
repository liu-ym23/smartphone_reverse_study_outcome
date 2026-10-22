package com.obric.appstore.buss.myapp.myapp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.myapp.MyAppVM$doLoad$2", f = "MyAppVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MyAppVM$doLoad$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    int label;

    public MyAppVM$doLoad$2(Continuation<? super MyAppVM$doLoad$2> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        MyAppVM$doLoad$2 r12 = new MyAppVM$doLoad$2(r11);
        r12.Z$0 = ((Boolean) r10).booleanValue();
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Boolean r10, Continuation<? super Boolean> r11) {
        return invoke(r10.booleanValue(), r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L7;
        kotlin.c.b(r10);
        return tf.a.a(this.Z$0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(boolean r10, @Nullable Continuation<? super Boolean> r11) {
        return ((MyAppVM$doLoad$2) create(Boolean.valueOf(r10), r11)).invokeSuspend(Unit.f21064a);
    }
}
