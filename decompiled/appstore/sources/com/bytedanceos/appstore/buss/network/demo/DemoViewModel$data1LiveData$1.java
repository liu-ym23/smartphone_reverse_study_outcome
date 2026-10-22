package com.bytedanceos.appstore.buss.network.demo;

import androidx.lifecycle.LiveDataScope;
import com.bytedanceos.appstore.buss.network.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/lifecycle/LiveDataScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "", "", "<anonymous>", "(Landroidx/lifecycle/LiveDataScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.network.demo.DemoViewModel$data1LiveData$1", f = "DemoViewModel.kt", i = {0}, l = {20, 21, 21}, m = "invokeSuspend", n = {"$this$liveData"}, s = {"L$0"})
public final class DemoViewModel$data1LiveData$1 extends SuspendLambda implements Function2<LiveDataScope<h>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DemoViewModel this$0;

    public DemoViewModel$data1LiveData$1(DemoViewModel r10, Continuation<? super DemoViewModel$data1LiveData$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        DemoViewModel$data1LiveData$1 r12 = new DemoViewModel$data1LiveData$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull LiveDataScope<h> r10, @Nullable Continuation<? super Unit> r11) {
        return ((DemoViewModel$data1LiveData$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        c.b(r10);
    L23:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        LiveDataScope r13 = (LiveDataScope) this.L$0;
        c.b(r10);
    L19:
        this.L$0 = null;
        this.label = 3;
        if (r13.emit(r10, this) != r11) goto L23;
        return r11;
    L11:
        r13 = (LiveDataScope) this.L$0;
        c.b(r10);
    L16:
        DemoRepository r14 = DemoViewModel.f(this.this$0);
        this.L$0 = r13;
        this.label = 2;
        r10 = r14.g(this);
        if (r10 != r11) goto L19;
        return r11;
    L12:
        c.b(r10);
        LiveDataScope r15 = (LiveDataScope) this.L$0;
        h.b r16 = h.b.f8818a;
        this.L$0 = r15;
        this.label = 1;
        if (r15.emit(r16, this) != r11) goto L15;
        return r11;
    L15:
        r13 = r15;
        goto L16
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(LiveDataScope<h> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }
}
