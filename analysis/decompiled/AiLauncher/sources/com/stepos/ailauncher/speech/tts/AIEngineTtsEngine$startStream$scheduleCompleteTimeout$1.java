package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Ua.U;
import Y8.t;
import android.util.Log;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1", f = "AIEngineTtsEngine.kt", l = {253}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AtomicBoolean $closeIssued;
    final /* synthetic */ AtomicInteger $connectionEpoch;
    final /* synthetic */ int $epoch;
    final /* synthetic */ String $from;
    final /* synthetic */ int $generation;
    final /* synthetic */ TtsListener $listener;
    final /* synthetic */ Ref$ObjectRef<InterfaceC5074l<String, Boolean>> $tryResumeRef;
    int label;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1(int i10, AIEngineTtsEngine aIEngineTtsEngine, int i11, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, String str, Ref$ObjectRef<InterfaceC5074l<String, Boolean>> ref$ObjectRef, TtsListener ttsListener, InterfaceC4014c<? super AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$generation = i10;
        this.this$0 = aIEngineTtsEngine;
        this.$epoch = i11;
        this.$connectionEpoch = atomicInteger;
        this.$closeIssued = atomicBoolean;
        this.$from = str;
        this.$tryResumeRef = ref$ObjectRef;
        this.$listener = ttsListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1(this.$generation, this.this$0, this.$epoch, this.$connectionEpoch, this.$closeIssued, this.$from, this.$tryResumeRef, this.$listener, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (U.a(30000L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (this.$generation == this.this$0.streamGeneration.get() && !this.this$0.cancelled.get() && this.$epoch == this.$connectionEpoch.get() && this.$closeIssued.get()) {
            Log.w("AIEngineTts", "stream complete timeout generation=" + this.$generation + " from=" + this.$from + " timeoutMs=30000 receivedChunks=" + this.this$0.audioChunkSequence.get() + " fedChars=" + this.this$0.totalFedChars.get());
            if (this.$tryResumeRef.f34820a.invoke("completeTimeout").booleanValue()) {
                return t.f7040a;
            }
            this.this$0.r0(this.$listener, this.$generation, "completeTimeout");
        }
        return t.f7040a;
    }
}
