package com.bytedanceos.appstore.buss.network.base;

import com.bytedanceos.appstore.buss.network.AssistantHttpResult;
import com.bytedanceos.appstore.buss.network.d;
import com.bytedanceos.appstore.buss.network.e;
import com.bytedanceos.appstore.buss.network.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.network.base.BaseRepository$executeAssistantResponse$2", f = "BaseRepository.kt", i = {}, l = {87, 101}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBaseRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseRepository.kt\ncom/bytedanceos/appstore/buss/network/base/BaseRepository$executeAssistantResponse$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public final class BaseRepository$executeAssistantResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ e $apiResponse;
    final /* synthetic */ Function3<CoroutineScope, d, Continuation<? super Unit>, Object> $errorCallResult;
    final /* synthetic */ Function3<CoroutineScope, AssistantHttpResult<Object>, Continuation<? super Unit>, Object> $successCallResult;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRepository$executeAssistantResponse$2(e r10, Function3<? super CoroutineScope, ? super AssistantHttpResult<Object>, ? super Continuation<? super Unit>, ? extends Object> r11, Function3<? super CoroutineScope, ? super d, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super BaseRepository$executeAssistantResponse$2> r13) {
        this.$apiResponse = r10;
        this.$successCallResult = r11;
        this.$errorCallResult = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        BaseRepository$executeAssistantResponse$2 r12 = new BaseRepository$executeAssistantResponse$2(this.$apiResponse, this.$successCallResult, this.$errorCallResult, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
        return invoke2(r10, r11);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.bytedanceos.appstore.buss.network.base.BaseRepository$executeAssistantResponse$2 for r7v9 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d();
        int r1 = r7.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.c.b(r8);
    L25:
        com.bytedanceos.appstore.buss.network.e r0 = r7.$apiResponse;
        com.bytedanceos.appstore.buss.network.d r0 = (com.bytedanceos.appstore.buss.network.d) r0;
        java.lang.String r2 = r0.b();
        com.bytedanceos.appstore.buss.network.e r7 = r7.$apiResponse;
        com.bytedanceos.appstore.buss.network.d r7 = (com.bytedanceos.appstore.buss.network.d) r7;
        int r3 = r7.a();
        com.bytedanceos.appstore.buss.network.h.a r8 = new com.bytedanceos.appstore.buss.network.h.a(r2, r3, null, 4, null);
        return r8;
    L7:
        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r7;
    L9:
        kotlin.c.b(r8);
    L17:
        com.bytedanceos.appstore.buss.network.e r1 = r7.$apiResponse;
        com.bytedanceos.appstore.buss.network.f r1 = (com.bytedanceos.appstore.buss.network.f) r1;
        com.bytedanceos.appstore.buss.network.AssistantHttpResult r1 = r1.a();
        int r1 = r1.getCode();
        com.bytedanceos.appstore.buss.network.e r2 = r7.$apiResponse;
        com.bytedanceos.appstore.buss.network.f r2 = (com.bytedanceos.appstore.buss.network.f) r2;
        com.bytedanceos.appstore.buss.network.AssistantHttpResult r2 = r2.a();
        java.lang.String r2 = r2.getMsg();
        java.lang.Boolean r3 = tf.a.a(false);
        com.bytedanceos.appstore.buss.network.HttpResultHead r0 = new com.bytedanceos.appstore.buss.network.HttpResultHead(r1, r2, r3);
        com.bytedanceos.appstore.buss.network.e r1 = r7.$apiResponse;
        com.bytedanceos.appstore.buss.network.f r1 = (com.bytedanceos.appstore.buss.network.f) r1;
        com.bytedanceos.appstore.buss.network.AssistantHttpResult r1 = r1.a();
        java.lang.Object r1 = r1.getData();
        com.bytedanceos.appstore.buss.network.e r7 = r7.$apiResponse;
        com.bytedanceos.appstore.buss.network.f r7 = (com.bytedanceos.appstore.buss.network.f) r7;
        com.bytedanceos.appstore.buss.network.AssistantHttpResult r7 = r7.a();
        java.lang.String r7 = r7.getMsg();
        com.bytedanceos.appstore.buss.network.h.c r8 = new com.bytedanceos.appstore.buss.network.h.c(r0, r1, r7);
        return r8;
    L10:
        kotlin.c.b(r8);
        java.lang.Object r8 = r7.L$0;
        kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8;
        com.bytedanceos.appstore.buss.network.e r1 = r7.$apiResponse;
        boolean r4 = r1 instanceof com.bytedanceos.appstore.buss.network.f;
        if (r4 == false) goto L18;
        kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, com.bytedanceos.appstore.buss.network.AssistantHttpResult<java.lang.Object>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r7.$successCallResult;
        if (r2 == null) goto L17;
        com.bytedanceos.appstore.buss.network.f r1 = (com.bytedanceos.appstore.buss.network.f) r1;
        com.bytedanceos.appstore.buss.network.AssistantHttpResult r1 = r1.a();
        r7.label = 1;
        java.lang.Object r8 = r2.invoke(r8, r1, r7);
        if (r8 != r0) goto L17;
        return r0;
    L18:
        boolean r3 = r1 instanceof com.bytedanceos.appstore.buss.network.d;
        if (r3 == false) goto L27;
        kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, com.bytedanceos.appstore.buss.network.d, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r7.$errorCallResult;
        if (r3 == null) goto L25;
        r7.label = 2;
        com.bytedanceos.appstore.buss.network.d r1 = (com.bytedanceos.appstore.buss.network.d) r1;
        java.lang.Object r7 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r7;
        java.lang.Object r8 = r3.invoke(r8, r1, r7);
        if (r8 != r0) goto L25;
        return r0;
    L27:
        kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException();
        throw r7;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
        return ((BaseRepository$executeAssistantResponse$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
