package com.stepos.core.ability.speech;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsSentencePipelineGate {
    private final long creditTimeoutMs;
    private int lastCreditedIndex;
    private int lastFullySentIndex;
    private final Object lock;
    private final zb.a<Long> nowMs;
    private int pendingAudioCreditSteps;
    private final long pollMs;
    private int serverSentenceEndCount;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsSentencePipelineGate", f = "TtsSentencePipelineGate.kt", l = {111}, m = "awaitBeforeSentence")
    /* renamed from: com.stepos.core.ability.speech.TtsSentencePipelineGate$awaitBeforeSentence$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsSentencePipelineGate.this.awaitBeforeSentence(0, null, null, this);
        }
    }

    public TtsSentencePipelineGate(long j10, long j11, zb.a<Long> nowMs) {
        kotlin.jvm.internal.g.f(nowMs, "nowMs");
        this.creditTimeoutMs = j10;
        this.pollMs = j11;
        this.nowMs = nowMs;
        this.lock = new Object();
        this.lastCreditedIndex = -1;
        this.lastFullySentIndex = -1;
    }

    private final void applyServerSentenceCreditLocked() {
        int i10 = this.serverSentenceEndCount;
        if (i10 <= 0) {
            return;
        }
        int i11 = i10 - 1;
        int i12 = this.lastFullySentIndex;
        if (i12 < 0) {
            return;
        }
        if (i11 > i12) {
            i11 = i12;
        }
        if (i11 > this.lastCreditedIndex) {
            this.lastCreditedIndex = i11;
        }
    }

    private final void drainPendingAudioCreditsLocked() {
        int i10;
        while (true) {
            int i11 = this.pendingAudioCreditSteps;
            if (i11 <= 0 || (i10 = this.lastCreditedIndex) >= this.lastFullySentIndex) {
                return;
            }
            this.lastCreditedIndex = i10 + 1;
            this.pendingAudioCreditSteps = i11 - 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitBeforeSentence(int r11, zb.a<java.lang.Boolean> r12, zb.l<? super java.lang.Integer, lb.n> r13, qb.b<? super lb.n> r14) {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsSentencePipelineGate.awaitBeforeSentence(int, zb.a, zb.l, qb.b):java.lang.Object");
    }

    public final void forceCreditAllPending() {
        synchronized (this.lock) {
            try {
                int i10 = this.lastFullySentIndex;
                if (i10 > this.lastCreditedIndex) {
                    this.lastCreditedIndex = i10;
                }
                this.pendingAudioCreditSteps = 0;
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isReadyForTextDone() {
        synchronized (this.lock) {
            int i10 = this.lastFullySentIndex;
            if (i10 < 0) {
                return true;
            }
            return this.lastCreditedIndex >= i10;
        }
    }

    public final void onSentenceFullySent(int i10) {
        synchronized (this.lock) {
            this.lastFullySentIndex = i10;
            drainPendingAudioCreditsLocked();
            applyServerSentenceCreditLocked();
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void onServerAudioDelta() {
        synchronized (this.lock) {
            if (this.lastFullySentIndex < 0) {
                this.pendingAudioCreditSteps++;
                return;
            }
            drainPendingAudioCreditsLocked();
            int i10 = this.lastCreditedIndex;
            if (i10 < this.lastFullySentIndex) {
                this.lastCreditedIndex = i10 + 1;
            }
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void onServerDrained() {
        forceCreditAllPending();
    }

    public final void onServerSentenceEnd() {
        synchronized (this.lock) {
            this.serverSentenceEndCount++;
            applyServerSentenceCreditLocked();
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void reset() {
        synchronized (this.lock) {
            this.lastCreditedIndex = -1;
            this.lastFullySentIndex = -1;
            this.pendingAudioCreditSteps = 0;
            this.serverSentenceEndCount = 0;
            lb.n nVar = lb.n.f10413a;
        }
    }

    public /* synthetic */ TtsSentencePipelineGate(long j10, long j11, zb.a aVar, int i10, kotlin.jvm.internal.e eVar) {
        this(j10, j11, (i10 & 4) != 0 ? new b(4) : aVar);
    }
}
