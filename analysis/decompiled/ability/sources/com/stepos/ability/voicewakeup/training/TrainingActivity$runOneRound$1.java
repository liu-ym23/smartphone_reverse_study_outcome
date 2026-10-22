package com.stepos.ability.voicewakeup.training;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w9.InterfaceC2108a;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity", f = "TrainingActivity.kt", l = {815, 441, 451, 465, 465}, m = "runOneRound", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TrainingActivity$runOneRound$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC2108a f3385a;
    public ByteBuffer b;
    public ShortBuffer c;
    public int d;
    public int e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ TrainingActivity h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$runOneRound$1(TrainingActivity trainingActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        int i = TrainingActivity.f3357M;
        return this.h.z(this);
    }
}
