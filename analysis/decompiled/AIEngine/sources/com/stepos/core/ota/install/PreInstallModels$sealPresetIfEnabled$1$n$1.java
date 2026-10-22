package com.stepos.core.ota.install;

import com.stepos.core.ota.crypto.AtRestSealer;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.install.PreInstallModels$sealPresetIfEnabled$1$n$1", f = "PreInstallModels.kt", l = {639}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PreInstallModels$sealPresetIfEnabled$1$n$1 extends SuspendLambda implements p<CoroutineScope, b<? super Integer>, Object> {
    final /* synthetic */ File $dir;
    final /* synthetic */ PreInstallModels $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreInstallModels$sealPresetIfEnabled$1$n$1(PreInstallModels preInstallModels, File file, b<? super PreInstallModels$sealPresetIfEnabled$1$n$1> bVar) {
        super(2, bVar);
        this.$this_runCatching = preInstallModels;
        this.$dir = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new PreInstallModels$sealPresetIfEnabled$1$n$1(this.$this_runCatching, this.$dir, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM118sealDirgIAlus;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            AtRestSealer presetSealer = this.$this_runCatching.getPresetSealer();
            File file = this.$dir;
            this.label = 1;
            objM118sealDirgIAlus = presetSealer.m118sealDirgIAlus(file, this);
            if (objM118sealDirgIAlus == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            objM118sealDirgIAlus = ((Result) obj).f9987a;
        }
        kotlin.c.b(objM118sealDirgIAlus);
        return objM118sealDirgIAlus;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super Integer> bVar) {
        return ((PreInstallModels$sealPresetIfEnabled$1$n$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
