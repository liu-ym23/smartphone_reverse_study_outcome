package com.stepos.ailauncher.speech.tts;

import com.stepos.aiengine.algorithm.tts.ITtsStreamSession;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class AIEngineTtsEngine$startStream$2 extends FunctionReferenceImpl implements InterfaceC5074l<String, Boolean> {
    final /* synthetic */ AtomicBoolean $closeIssued;
    final /* synthetic */ Ref$ObjectRef<kotlinx.coroutines.g> $completeTimeoutJob;
    final /* synthetic */ AtomicInteger $connectionEpoch;
    final /* synthetic */ int $generation;
    final /* synthetic */ q $handler;
    final /* synthetic */ AtomicBoolean $inputClosed;
    final /* synthetic */ AtomicLong $lastResumeAtMs;
    final /* synthetic */ TtsListener $listener;
    final /* synthetic */ Ref$ObjectRef<InterfaceC5063a<ITtsStreamSession>> $openCloudSessionRef;
    final /* synthetic */ AtomicInteger $resumeAttempts;
    final /* synthetic */ AtomicBoolean $sessionBroken;
    final /* synthetic */ Ref$ObjectRef<ITtsStreamSession> $streamHandle;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$startStream$2(AIEngineTtsEngine aIEngineTtsEngine, int i10, AtomicInteger atomicInteger, q qVar, AtomicLong atomicLong, AtomicInteger atomicInteger2, Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef2, TtsListener ttsListener, Ref$ObjectRef<InterfaceC5063a<ITtsStreamSession>> ref$ObjectRef3) {
        super(1, p.a.class, "tryResume", "startStream$tryResume(Lcom/stepos/ailauncher/speech/tts/AIEngineTtsEngine;ILjava/util/concurrent/atomic/AtomicInteger;Lcom/stepos/ailauncher/speech/tts/TtsMessageHandler;Ljava/util/concurrent/atomic/AtomicLong;Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/stepos/ailauncher/contract/api/speech/TtsListener;Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/lang/String;)Z", 0);
        this.this$0 = aIEngineTtsEngine;
        this.$generation = i10;
        this.$resumeAttempts = atomicInteger;
        this.$handler = qVar;
        this.$lastResumeAtMs = atomicLong;
        this.$connectionEpoch = atomicInteger2;
        this.$completeTimeoutJob = ref$ObjectRef;
        this.$closeIssued = atomicBoolean;
        this.$inputClosed = atomicBoolean2;
        this.$sessionBroken = atomicBoolean3;
        this.$streamHandle = ref$ObjectRef2;
        this.$listener = ttsListener;
        this.$openCloudSessionRef = ref$ObjectRef3;
    }

    @Override // p9.InterfaceC5074l
    public final Boolean invoke(String p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return Boolean.valueOf(AIEngineTtsEngine.U0(this.this$0, this.$generation, this.$resumeAttempts, this.$handler, this.$lastResumeAtMs, this.$connectionEpoch, this.$completeTimeoutJob, this.$closeIssued, this.$inputClosed, this.$sessionBroken, this.$streamHandle, this.$listener, this.$openCloudSessionRef, p02));
    }
}
