package com.stepos.ability.voicewakeup.training;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w9.InterfaceC2108a;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity", f = "TrainingActivity.kt", l = {815, 428, 432}, m = "loopRounds", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TrainingActivity$loopRounds$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f3381a;
    public InterfaceC2108a b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ TrainingActivity e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$loopRounds$1(TrainingActivity trainingActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return TrainingActivity.q(this.e, this);
    }
}
