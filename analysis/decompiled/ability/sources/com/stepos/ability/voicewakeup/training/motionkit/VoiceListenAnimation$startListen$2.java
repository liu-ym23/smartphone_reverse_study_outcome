package com.stepos.ability.voicewakeup.training.motionkit;

import Ba.f;
import C7.r;
import I4.i;
import I4.o;
import J7.c;
import S7.n;
import android.os.SystemClock;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.MotionHost;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.q0;

@c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2", f = "VoiceListenAnimation.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lm9/c0;", "<anonymous>", "(Lm9/z;)Lm9/c0;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class VoiceListenAnimation$startListen$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3405a;
    public final /* synthetic */ a b;

    @c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2$1", f = "VoiceListenAnimation.kt", l = {659}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3406a;
        public final /* synthetic */ a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar, H7.c cVar) {
            super(2, cVar);
            this.b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3406a;
            a aVar = this.b;
            if (i == 0) {
                b.b(obj);
                i iVar = aVar.d;
                float fFloatValue = ((Number) iVar.f800a.getValue(iVar, i.d[2])).floatValue();
                this.f3406a = 1;
                if (a.a(aVar, fFloatValue, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            boolean zE = a.e(aVar, false);
            r rVar = r.f317a;
            if (!zE) {
                return rVar;
            }
            aVar.f3417H = SystemClock.elapsedRealtime();
            aVar.f();
            a.d(aVar);
            AbstractC1683A.n(aVar.y, null, new VoiceListenAnimation$launchListenRetire$1(aVar, null), 3);
            aVar.n();
            return rVar;
        }
    }

    @c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2$2", f = "VoiceListenAnimation.kt", l = {668}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3407a;
        public /* synthetic */ Object b;
        public final /* synthetic */ a c;

        @c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2$2$1", f = "VoiceListenAnimation.kt", l = {674}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$startListen$2$2$1, reason: invalid class name */
        final class AnonymousClass1 extends SuspendLambda implements n {

            /* renamed from: a, reason: collision with root package name */
            public int f3408a;
            public final /* synthetic */ a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(a aVar, H7.c cVar) {
                super(2, cVar);
                this.b = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c create(Object obj, H7.c cVar) {
                return new AnonymousClass1(this.b, cVar);
            }

            @Override // S7.n
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.f3408a;
                if (i == 0) {
                    b.b(obj);
                    this.f3408a = 1;
                    if (a.b(this.b, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a aVar, H7.c cVar) {
            super(2, cVar);
            this.c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.c, cVar);
            anonymousClass2.b = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FxInstance fxInstance;
            a aVar = this.c;
            LinkedHashMap linkedHashMap = aVar.g;
            A5.c cVar = aVar.l;
            i iVar = aVar.d;
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.b;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3407a;
            if (i == 0) {
                b.b(obj);
                float fFloatValue = ((Number) iVar.b.getValue(iVar, i.d[3])).floatValue();
                this.b = interfaceC1733z;
                this.f3407a = 1;
                if (a.a(aVar, fFloatValue, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            boolean zL = AbstractC1683A.l(interfaceC1733z);
            r rVar = r.f317a;
            if (zL) {
                aVar.f3418I = SystemClock.elapsedRealtime();
                FxInstance fxInstance2 = (FxInstance) linkedHashMap.get("AudioWave");
                if (fxInstance2 == null || !fxInstance2.getIsActive()) {
                    MotionHost motionHostJ = aVar.j();
                    if (motionHostJ != null) {
                        aVar.x(motionHostJ, EffectDefinition.copy$default(I4.a.f792a, null, null, null, null, null, false, null, 63, null), cVar.A(), new f(17));
                    }
                } else {
                    FxInstance fxInstance3 = (FxInstance) linkedHashMap.get("AudioWave");
                    if (fxInstance3 != null) {
                        if (!fxInstance3.getIsActive()) {
                            fxInstance3 = null;
                        }
                        if (fxInstance3 != null) {
                            for (Map.Entry entry : cVar.A().entrySet()) {
                                String str = (String) entry.getKey();
                                float[] fArr = (float[]) entry.getValue();
                                if (!k.b(str, "uWaveTime")) {
                                    o.b(fxInstance3, str, fArr);
                                }
                            }
                        }
                    }
                }
                a.d(aVar);
                q0 q0Var = aVar.f3412B;
                if (q0Var != null) {
                    q0Var.cancel(null);
                }
                aVar.f3412B = AbstractC1683A.n(aVar.y, null, new AnonymousClass1(aVar, null), 3);
                aVar.n();
                if (aVar.f3414D.get() && (fxInstance = (FxInstance) linkedHashMap.get("AudioWave")) != null) {
                    FxInstance fxInstance4 = fxInstance.getIsActive() ? fxInstance : null;
                    if (fxInstance4 != null) {
                        float fFloatValue2 = ((Number) iVar.c.getValue(iVar, i.d[4])).floatValue();
                        if (fFloatValue2 < 0.05f) {
                            fFloatValue2 = 0.05f;
                        }
                        fxInstance4.setUniform("uReleaseAt", fFloatValue2);
                        cVar.v("uReleaseAt", new float[]{fFloatValue2}, false);
                    }
                }
            }
            return rVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$startListen$2(a aVar, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        VoiceListenAnimation$startListen$2 voiceListenAnimation$startListen$2 = new VoiceListenAnimation$startListen$2(this.b, cVar);
        voiceListenAnimation$startListen$2.f3405a = obj;
        return voiceListenAnimation$startListen$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((VoiceListenAnimation$startListen$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.f3405a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        b.b(obj);
        a aVar = this.b;
        AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(aVar, null), 3);
        return AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass2(aVar, null), 3);
    }
}
