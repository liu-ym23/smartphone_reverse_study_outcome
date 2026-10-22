package com.bytedance.android.ec.core.cps;

import com.bytedance.common.profilesdk.util.CmdUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$runShell$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$runShell$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String[] $cmd;
    int label;

    public CyberProtectionCollectorKt$runShell$2(String[] r100, Continuation r101) {
        this.$cmd = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new CyberProtectionCollectorKt$runShell$2(this.$cmd, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return ((CyberProtectionCollectorKt$runShell$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r100);
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L19
        InputStream r102 = CmdUtils.exec(this.$cmd).getInputStream();     // Catch: Exception -> L19
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102));     // Catch: Exception -> L19
    L23:
        String r104 = r103.readLine();     // Catch: Throwable -> L14
        if (r104 == null) goto L8;
        r101.append(r104);     // Catch: Throwable -> L14
    L8:
        if (r102 == null) goto L10;
        r102.close();     // Catch: Exception -> L19
    L10:
        r103.close();     // Catch: Exception -> L19
        return r101.toString();
    L14:
        th = move-exception;
        if (r102 == null) goto L17;
        r102.close();     // Catch: Exception -> L19
    L17:
        r103.close();     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L19:
        return null;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
