package com.stepos.ability.voicewakeup.training;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity", f = "TrainingActivity.kt", l = {473}, m = "handleRoundPass", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TrainingActivity$handleRoundPass$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3380a;
    public final /* synthetic */ TrainingActivity b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$handleRoundPass$1(TrainingActivity trainingActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3380a = obj;
        this.c |= Integer.MIN_VALUE;
        int i = TrainingActivity.f3357M;
        return this.b.v(0, null, null, this);
    }
}
