package com.stepos.taskrobot.taskmanager.experiencelib.client;

import J7.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.taskmanager.experiencelib.client.ExperienceClient", f = "ExperienceClient.kt", l = {129}, m = "injectExperience-gIAlu-s", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ExperienceClient$injectExperience$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4053a;
    public final /* synthetic */ a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceClient$injectExperience$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4053a = obj;
        this.c |= Integer.MIN_VALUE;
        Serializable serializableB = this.b.b(null, this);
        return serializableB == CoroutineSingletons.f4909a ? serializableB : new Result(serializableB);
    }
}
