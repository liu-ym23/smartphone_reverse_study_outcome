package com.stepos.ailauncher.speech.tts;

import android.os.Bundle;
import com.stepos.aiengine.algorithm.tts.ITtsStreamSession;
import com.stepos.aiengine.algorithm.tts.ITtsStreaming;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class AIEngineTtsEngine$startStream$5 extends FunctionReferenceImpl implements InterfaceC5063a<ITtsStreamSession> {
    final /* synthetic */ AtomicBoolean $closeIssued;
    final /* synthetic */ Ref$ObjectRef<kotlinx.coroutines.g> $completeTimeoutJob;
    final /* synthetic */ AtomicInteger $connectionEpoch;
    final /* synthetic */ int $generation;
    final /* synthetic */ q $handler;
    final /* synthetic */ TtsListener $listener;
    final /* synthetic */ Bundle $params;
    final /* synthetic */ AtomicInteger $resumeAttempts;
    final /* synthetic */ AtomicBoolean $sessionBroken;
    final /* synthetic */ Ref$ObjectRef<InterfaceC5074l<String, Boolean>> $tryResumeRef;
    final /* synthetic */ ITtsStreaming $ttsStream;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$startStream$5(AtomicInteger atomicInteger, ITtsStreaming iTtsStreaming, Bundle bundle, AIEngineTtsEngine aIEngineTtsEngine, int i10, q qVar, AtomicInteger atomicInteger2, TtsListener ttsListener, Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, AtomicBoolean atomicBoolean, Ref$ObjectRef<InterfaceC5074l<String, Boolean>> ref$ObjectRef2, AtomicBoolean atomicBoolean2) {
        super(0, p.a.class, "openCloudSession", "startStream$openCloudSession(Ljava/util/concurrent/atomic/AtomicInteger;Lcom/stepos/aiengine/algorithm/tts/ITtsStreaming;Landroid/os/Bundle;Lcom/stepos/ailauncher/speech/tts/AIEngineTtsEngine;ILcom/stepos/ailauncher/speech/tts/TtsMessageHandler;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/stepos/ailauncher/contract/api/speech/TtsListener;Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/atomic/AtomicBoolean;)Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;", 0);
        this.$connectionEpoch = atomicInteger;
        this.$ttsStream = iTtsStreaming;
        this.$params = bundle;
        this.this$0 = aIEngineTtsEngine;
        this.$generation = i10;
        this.$handler = qVar;
        this.$resumeAttempts = atomicInteger2;
        this.$listener = ttsListener;
        this.$completeTimeoutJob = ref$ObjectRef;
        this.$closeIssued = atomicBoolean;
        this.$tryResumeRef = ref$ObjectRef2;
        this.$sessionBroken = atomicBoolean2;
    }

    @Override // p9.InterfaceC5063a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final ITtsStreamSession invoke() {
        return AIEngineTtsEngine.R0(this.$connectionEpoch, this.$ttsStream, this.$params, this.this$0, this.$generation, this.$handler, this.$resumeAttempts, this.$listener, this.$completeTimeoutJob, this.$closeIssued, this.$tryResumeRef, this.$sessionBroken);
    }
}
