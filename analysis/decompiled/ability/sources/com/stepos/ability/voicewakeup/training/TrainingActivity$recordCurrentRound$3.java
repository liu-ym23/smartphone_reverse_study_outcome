package com.stepos.ability.voicewakeup.training;

import A6.m;
import C7.r;
import S7.n;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.voicewakeup.ui.TrainingPhraseCarousel;
import com.stepos.ability.voicewakeup.ui.WakeupPagAnimation;
import com.stepos.ability.voicewakeup.ui.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.C1718k;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$3", f = "TrainingActivity.kt", l = {TypedValues.PositionType.TYPE_PERCENT_Y}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "startCapture", "<anonymous>", "(LS7/a;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$recordCurrentRound$3 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3383a;
    public /* synthetic */ Object b;
    public final /* synthetic */ TrainingActivity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$recordCurrentRound$3(TrainingActivity trainingActivity, H7.c cVar) {
        super(2, cVar);
        this.c = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        TrainingActivity$recordCurrentRound$3 trainingActivity$recordCurrentRound$3 = new TrainingActivity$recordCurrentRound$3(this.c, cVar);
        trainingActivity$recordCurrentRound$3.b = obj;
        return trainingActivity$recordCurrentRound$3;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$recordCurrentRound$3) create((S7.a) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        r rVar = r.f317a;
        S7.a aVar = (S7.a) this.b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3383a;
        if (i == 0) {
            kotlin.b.b(obj);
            TrainingPhraseCarousel trainingPhraseCarousel = this.c.i;
            if (trainingPhraseCarousel == null) {
                k.n("phraseCarousel");
                throw null;
            }
            int l = trainingPhraseCarousel.getL();
            TrainingActivity trainingActivity = this.c;
            if (l < trainingActivity.f3373x) {
                TrainingPhraseCarousel trainingPhraseCarousel2 = trainingActivity.i;
                if (trainingPhraseCarousel2 == null) {
                    k.n("phraseCarousel");
                    throw null;
                }
                this.b = aVar;
                this.f3383a = 1;
                C1718k c1718k = new C1718k(1, U7.a.I(this));
                c1718k.y();
                trainingPhraseCarousel2.c();
                if (c1718k.isActive()) {
                    trainingPhraseCarousel2.i = c1718k;
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.setDuration(200L);
                    valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                    valueAnimatorOfFloat.addUpdateListener(new J4.c(trainingPhraseCarousel2, 0));
                    valueAnimatorOfFloat.addListener(new m(trainingPhraseCarousel2, 2));
                    trainingPhraseCarousel2.h = valueAnimatorOfFloat;
                    c1718k.j(new J4.b(trainingPhraseCarousel2, 0));
                    valueAnimatorOfFloat.start();
                }
                Object objX = c1718k.x();
                if (objX != coroutineSingletons) {
                    objX = rVar;
                }
                if (objX == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        kotlinx.coroutines.a.g(getContext());
        if (this.c.f3363G || this.c.f3362F || this.c.isFinishing() || this.c.isDestroyed()) {
            throw new CancellationException("Training is no longer active");
        }
        this.c.A();
        aVar.invoke();
        d dVar = this.c.c;
        if (dVar != null) {
            dVar.k(WakeupPagAnimation.c);
            return rVar;
        }
        k.n("orb");
        throw null;
    }
}
