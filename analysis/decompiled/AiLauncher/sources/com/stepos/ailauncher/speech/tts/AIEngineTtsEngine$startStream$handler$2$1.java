package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Y8.t;
import android.util.Log;
import com.stepos.aiengine.algorithm.tts.ITtsStreamSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStream$handler$2$1", f = "AIEngineTtsEngine.kt", l = {306}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$startStream$handler$2$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AtomicBoolean $closeIssued;
    final /* synthetic */ AtomicInteger $connectionEpoch;
    final /* synthetic */ int $epoch;
    final /* synthetic */ int $generation;
    final /* synthetic */ Ref$ObjectRef<ITtsStreamSession> $streamHandle;
    int label;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$startStream$handler$2$1(AIEngineTtsEngine aIEngineTtsEngine, int i10, int i11, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef, InterfaceC4014c<? super AIEngineTtsEngine$startStream$handler$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aIEngineTtsEngine;
        this.$generation = i10;
        this.$epoch = i11;
        this.$connectionEpoch = atomicInteger;
        this.$closeIssued = atomicBoolean;
        this.$streamHandle = ref$ObjectRef;
    }

    public static final boolean h(int i10, AtomicInteger atomicInteger) {
        return i10 == atomicInteger.get();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineTtsEngine$startStream$handler$2$1(this.this$0, this.$generation, this.$epoch, this.$connectionEpoch, this.$closeIssued, this.$streamHandle, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineTtsEngine$startStream$handler$2$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AIEngineTtsEngine aIEngineTtsEngine = this.this$0;
            int i11 = this.$generation;
            final int i12 = this.$epoch;
            final AtomicInteger atomicInteger = this.$connectionEpoch;
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.tts.g
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(AIEngineTtsEngine$startStream$handler$2$1.h(i12, atomicInteger));
                }
            };
            this.label = 1;
            if (aIEngineTtsEngine.Y0(i11, interfaceC5063a, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (this.this$0.cancelled.get() || this.$generation != this.this$0.streamGeneration.get()) {
            return t.f7040a;
        }
        if (this.$epoch == this.$connectionEpoch.get()) {
            AIEngineTtsEngine.K0(this.$closeIssued, this.$generation, this.this$0, this.$streamHandle, "endOfInput");
            return t.f7040a;
        }
        Log.i("AIEngineTts", "endOfInput close skipped: connection resumed generation=" + this.$generation + " epoch=" + this.$epoch);
        return t.f7040a;
    }
}
