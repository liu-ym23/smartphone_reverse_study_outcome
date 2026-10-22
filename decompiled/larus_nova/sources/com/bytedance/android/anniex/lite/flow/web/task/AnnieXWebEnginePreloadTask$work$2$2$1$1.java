package com.bytedance.android.anniex.lite.flow.web.task;

import android.app.Application;
import android.util.LruCache;
import com.bytedance.android.anniex.lite.c;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
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

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$2$1$1", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class AnnieXWebEnginePreloadTask$work$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXWebModel $_annieWebXModel;
    final /* synthetic */ Application $context;
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.model.a $loadStateModel;
    int label;
    final /* synthetic */ a this$0;

    public AnnieXWebEnginePreloadTask$work$2$2$1$1(Application r100, a r101, AnnieXWebModel r102, com.bytedance.android.anniex.lite.flow.model.a r103, Continuation<? super AnnieXWebEnginePreloadTask$work$2$2$1$1> r104) {
        this.$context = r100;
        this.$_annieWebXModel = r102;
        this.$loadStateModel = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AnnieXWebEnginePreloadTask$work$2$2$1$1(this.$context, null, this.$_annieWebXModel, this.$loadStateModel, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AnnieXWebEnginePreloadTask$work$2$2$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        LruCache<String, AnnieXWebModel> r102 = c.f40797a;
        Intrinsics.checkNotNull(this.$context, "null cannot be cast to non-null type android.content.Context");
        throw null;
    L5:
        if (r101 != 1) goto L9;
        ResultKt.throwOnFailure(r100);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
