package com.stepos.ability.voicewakeup.training;

import C7.r;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity", f = "TrainingActivity.kt", l = {537, 553, 585, 585, 585, 585}, m = "generateAndSaveModel", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TrainingActivity$generateAndSaveModel$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref$ObjectRef f3376a;
    public Object b;
    public r c;
    public /* synthetic */ Object d;
    public final /* synthetic */ TrainingActivity e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$generateAndSaveModel$1(TrainingActivity trainingActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        int i = TrainingActivity.f3357M;
        return this.e.s(null, this);
    }
}
