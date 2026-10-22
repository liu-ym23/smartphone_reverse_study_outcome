package com.bytedance.android.livesdk.message.cache;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.bytedance.android.livesdk.message.cache.LiveMessageCacheManager$scheduleExpiration$1", f = "LiveMessageCacheManager.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
final class LiveMessageCacheManager$scheduleExpiration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    int label;

    public LiveMessageCacheManager$scheduleExpiration$1(String r100, Continuation r101) {
        this.$key = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new LiveMessageCacheManager$scheduleExpiration$1(this.$key, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LiveMessageCacheManager$scheduleExpiration$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        a r103 = a.f153518e;
        String r104 = this.$key;
        Intrinsics.checkNotNullParameter(r104, "key");
        a.C2363a r105 = a.f153514a.remove(r104);
        Object r106 = null;
        if (r105 == null) goto L18;
        Job r107 = r105.f153523e;
        if (r107 == null) goto L17;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L17:
        r103.b(r105);
        r106 = r105.f153520b;
    L18:
        Objects.toString(r106);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ConcurrentHashMap<String, a.C2363a> r108 = a.f153514a;
        long r109 = a.f153516c;
        this.label = 1;
        if (DelayKt.delay(r109, this) != r101) goto L11;
        return r101;
    }
}
