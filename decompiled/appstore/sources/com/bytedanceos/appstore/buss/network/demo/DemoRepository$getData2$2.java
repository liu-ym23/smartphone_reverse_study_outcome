package com.bytedanceos.appstore.buss.network.demo;

import com.bytedanceos.appstore.buss.network.HttpResult;
import com.bytedanceos.appstore.buss.network.StoreHttpEngine;
import com.bytedanceos.appstore.buss.network.StoreService;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.network.demo.DemoRepository$getData2$2", f = "DemoRepository.kt", i = {}, l = {23, 23}, m = "invokeSuspend", n = {}, s = {})
public final class DemoRepository$getData2$2 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DemoRepository this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.network.demo.DemoRepository$getData2$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Lcom/bytedanceos/appstore/buss/network/HttpResult;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.network.demo.DemoRepository$getData2$2$1", f = "DemoRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<CoroutineScope, HttpResult<Object>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(3, r10);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r10, HttpResult<Object> r11, Continuation<? super Unit> r12) {
            return invoke2(r10, r11, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            a.d();
            if (this.label != 0) goto L7;
            c.b(r10);
            HttpResult r11 = (HttpResult) this.L$0;
            j.f8856a.a("save data " + r11.getBody());
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @NotNull HttpResult<Object> r11, @Nullable Continuation<? super Unit> r12) {
            AnonymousClass1 r13 = new AnonymousClass1(r12);
            r13.L$0 = r11;
            return r13.invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.network.demo.DemoRepository$getData2$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/a;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/bytedanceos/appstore/buss/network/a;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.network.demo.DemoRepository$getData2$2$2", f = "DemoRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, com.bytedanceos.appstore.buss.network.a, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(3, r10);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r10, com.bytedanceos.appstore.buss.network.a r11, Continuation<? super Unit> r12) {
            return invoke2(r10, r11, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            a.d();
            if (this.label != 0) goto L7;
            c.b(r10);
            com.bytedanceos.appstore.buss.network.a r11 = (com.bytedanceos.appstore.buss.network.a) this.L$0;
            j.f8856a.c(r11.a() + TokenParser.SP + r11.b());
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @NotNull com.bytedanceos.appstore.buss.network.a r11, @Nullable Continuation<? super Unit> r12) {
            AnonymousClass2 r13 = new AnonymousClass2(r12);
            r13.L$0 = r11;
            return r13.invokeSuspend(Unit.f21064a);
        }
    }

    public DemoRepository$getData2$2(DemoRepository r10, Continuation<? super DemoRepository$getData2$2> r11) {
        this.this$0 = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new DemoRepository$getData2$2(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super h> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        c.b(r10);
    L16:
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        DemoRepository r13 = (DemoRepository) this.L$0;
        c.b(r10);
    L13:
        AnonymousClass1 r14 = new AnonymousClass1(null);
        AnonymousClass2 r15 = new AnonymousClass2(null);
        this.L$0 = null;
        this.label = 2;
        r10 = DemoRepository.f(r13, (Response) r10, r14, r15, this);
        if (r10 != r11) goto L16;
        return r11;
    L10:
        c.b(r10);
        r13 = this.this$0;
        StoreService r16 = StoreHttpEngine.f8778b.g();
        this.L$0 = r13;
        this.label = 1;
        r10 = r16.getData(this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((DemoRepository$getData2$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
