package com.bytedance.android.ec.core.cps;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.Sword.Sword;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionInjectorKt$encodeByBDSword$2", f = "CyberProtectionInjector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionInjectorKt$encodeByBDSword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $data;
    int label;

    public CyberProtectionInjectorKt$encodeByBDSword$2(String r100, Continuation r101) {
        this.$data = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new CyberProtectionInjectorKt$encodeByBDSword$2(this.$data, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return ((CyberProtectionInjectorKt$encodeByBDSword$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$data;
        Charset r102 = Charsets.UTF_8;
        if (r101 == null) goto L17;
        byte[] r103 = r101.getBytes(r102);
        String r104 = Sword.clientPackedBase64(r103, r103.length);
        if (r104 != null) goto L9;
    L14:
        return null;
    L9:
        if (r104.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return r104;
    L11:
        r105 = false;
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
