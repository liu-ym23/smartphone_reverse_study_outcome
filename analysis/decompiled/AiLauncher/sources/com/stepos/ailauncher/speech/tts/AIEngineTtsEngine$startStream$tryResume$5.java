package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Y8.t;
import android.util.Log;
import com.stepos.aiengine.algorithm.tts.ITtsStreamSession;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStream$tryResume$5", f = "AIEngineTtsEngine.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$startStream$tryResume$5 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $attempt;
    final /* synthetic */ AtomicInteger $connectionEpoch;
    final /* synthetic */ int $epoch;
    final /* synthetic */ int $generation;
    final /* synthetic */ q $handler;
    final /* synthetic */ TtsListener $listener;
    final /* synthetic */ Ref$ObjectRef<InterfaceC5063a<ITtsStreamSession>> $openCloudSessionRef;
    final /* synthetic */ AtomicBoolean $sessionBroken;
    final /* synthetic */ Ref$ObjectRef<ITtsStreamSession> $streamHandle;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$startStream$tryResume$5(AIEngineTtsEngine aIEngineTtsEngine, int i10, int i11, AtomicInteger atomicInteger, int i12, TtsListener ttsListener, q qVar, Ref$ObjectRef<InterfaceC5063a<ITtsStreamSession>> ref$ObjectRef, Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef2, AtomicBoolean atomicBoolean, InterfaceC4014c<? super AIEngineTtsEngine$startStream$tryResume$5> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aIEngineTtsEngine;
        this.$generation = i10;
        this.$epoch = i11;
        this.$connectionEpoch = atomicInteger;
        this.$attempt = i12;
        this.$listener = ttsListener;
        this.$handler = qVar;
        this.$openCloudSessionRef = ref$ObjectRef;
        this.$streamHandle = ref$ObjectRef2;
        this.$sessionBroken = atomicBoolean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AIEngineTtsEngine$startStream$tryResume$5 aIEngineTtsEngine$startStream$tryResume$5 = new AIEngineTtsEngine$startStream$tryResume$5(this.this$0, this.$generation, this.$epoch, this.$connectionEpoch, this.$attempt, this.$listener, this.$handler, this.$openCloudSessionRef, this.$streamHandle, this.$sessionBroken, interfaceC4014c);
        aIEngineTtsEngine$startStream$tryResume$5.L$0 = obj;
        return aIEngineTtsEngine$startStream$tryResume$5;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineTtsEngine$startStream$tryResume$5) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [T, com.stepos.aiengine.algorithm.tts.ITtsStreamSession] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (this.this$0.cancelled.get() || this.$generation != this.this$0.streamGeneration.get() || this.$epoch != this.$connectionEpoch.get()) {
            return t.f7040a;
        }
        Ref$ObjectRef<InterfaceC5063a<ITtsStreamSession>> ref$ObjectRef = this.$openCloudSessionRef;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(ref$ObjectRef.f34820a.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        int i10 = this.$generation;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("AIEngineTts", "tts resume openSession threw generation=" + i10, thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        ?? r62 = (ITtsStreamSession) objB;
        if (r62 != 0) {
            Object obj2 = this.this$0.feedLock;
            Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef2 = this.$streamHandle;
            AtomicBoolean atomicBoolean = this.$sessionBroken;
            synchronized (obj2) {
                ref$ObjectRef2.f34820a = r62;
                atomicBoolean.set(false);
                t tVar = t.f7040a;
            }
            this.this$0.streamSession = r62;
            this.$handler.g(true);
            return t.f7040a;
        }
        Log.e("AIEngineTts", "tts resume#" + this.$attempt + " failed: openSession null generation=" + this.$generation);
        if (this.this$0.audioChunkSequence.get() > 0) {
            this.this$0.r0(this.$listener, this.$generation, "resumeOpenFailed");
        } else {
            this.this$0.j(this.$listener, this.$generation, "resumeOpenFailed");
        }
        return t.f7040a;
    }
}
