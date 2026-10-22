package com.bytedance.ai.debugscene;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1", f = "AIDebugManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, Boolean, String, Unit> $callback;
    final /* synthetic */ boolean $isAllowed;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $versionTag;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1(String r100, String r101, Function3<? super Boolean, ? super Boolean, ? super String, Unit> r102, boolean r103, Continuation<? super AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1> r104) {
        this.$packageName = r100;
        this.$versionTag = r101;
        this.$callback = r102;
        this.$isAllowed = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1(this.$packageName, this.$versionTag, this.$callback, this.$isAllowed, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIDebugManager$installAIPackagesWithVersionTagInMemory$2$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        com.bytedance.ai.utils.g.f37637a.i("AIManager", "terminate app before scan preview install callback. packageName: " + this.$packageName + ", versionTag: " + this.$versionTag);
        AppletAppManagerService r101 = AppletAppManagerService.INSTANCE;
        String r102 = this.$packageName;
        r101.getClass();
        AppletAppManagerService.f(r102);
        Function3<Boolean, Boolean, String, Unit> r103 = this.$callback;
        if (r103 == null) goto L8;
        r103.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(this.$isAllowed), null);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
