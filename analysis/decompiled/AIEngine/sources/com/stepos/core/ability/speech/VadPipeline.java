package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.VadEndpointDetector;
import com.stepos.core.ability.speech.VadLevelAggregator;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadPipeline {
    public static final Companion Companion = new Companion(null);
    private static final int DIAG_WINDOW_MS = 500;
    public static final int FRAME_SAMPLES = 256;
    private static final String MODEL_ID = "ten-vad-stream";
    public static final int TARGET_CHANNEL_COUNT = 1;
    public static final int TARGET_SAMPLE_RATE = 16000;
    private VadRuntimeConfig config;
    private long consumedSamples;
    private final VadEndpointDetector detector;
    private final VadLevelAggregator diagLevels;
    private final b7.a engine;
    private VadAdaptiveSpeechGate gate;
    private long inferFrames;
    private long inferNsMax;
    private long inferNsSum;
    private final Method processMethod;
    private final VadFrameSlicer slicer;
    private final String tag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00eb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object create(android.content.Context r25, java.lang.String r26, com.stepos.core.ability.speech.VadRuntimeConfig r27, qb.b<? super com.stepos.core.ability.speech.VadPipeline> r28) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadPipeline.Companion.create(android.content.Context, java.lang.String, com.stepos.core.ability.speech.VadRuntimeConfig, qb.b):java.lang.Object");
        }

        public final VadPipeline fromEngine$ability_release(String tag, b7.a engine, Method method, VadRuntimeConfig config) {
            kotlin.jvm.internal.g.f(tag, "tag");
            kotlin.jvm.internal.g.f(engine, "engine");
            kotlin.jvm.internal.g.f(config, "config");
            return new VadPipeline(tag, engine, method, config, null);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Event {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SpeechEnd implements Event {
            private final long elapsedMs;
            private final String reason;

            public SpeechEnd(long j10, String reason) {
                kotlin.jvm.internal.g.f(reason, "reason");
                this.elapsedMs = j10;
                this.reason = reason;
            }

            public static /* synthetic */ SpeechEnd copy$default(SpeechEnd speechEnd, long j10, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    j10 = speechEnd.elapsedMs;
                }
                if ((i10 & 2) != 0) {
                    str = speechEnd.reason;
                }
                return speechEnd.copy(j10, str);
            }

            public final long component1() {
                return this.elapsedMs;
            }

            public final String component2() {
                return this.reason;
            }

            public final SpeechEnd copy(long j10, String reason) {
                kotlin.jvm.internal.g.f(reason, "reason");
                return new SpeechEnd(j10, reason);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SpeechEnd)) {
                    return false;
                }
                SpeechEnd speechEnd = (SpeechEnd) obj;
                return this.elapsedMs == speechEnd.elapsedMs && kotlin.jvm.internal.g.b(this.reason, speechEnd.reason);
            }

            public final long getElapsedMs() {
                return this.elapsedMs;
            }

            public final String getReason() {
                return this.reason;
            }

            public int hashCode() {
                return this.reason.hashCode() + (Long.hashCode(this.elapsedMs) * 31);
            }

            public String toString() {
                StringBuilder sbO = a0.a.o("SpeechEnd(elapsedMs=", this.elapsedMs, ", reason=", this.reason);
                sbO.append(")");
                return sbO.toString();
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SpeechStart implements Event {
            private final long elapsedMs;

            public SpeechStart(long j10) {
                this.elapsedMs = j10;
            }

            public static /* synthetic */ SpeechStart copy$default(SpeechStart speechStart, long j10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    j10 = speechStart.elapsedMs;
                }
                return speechStart.copy(j10);
            }

            public final long component1() {
                return this.elapsedMs;
            }

            public final SpeechStart copy(long j10) {
                return new SpeechStart(j10);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SpeechStart) && this.elapsedMs == ((SpeechStart) obj).elapsedMs;
            }

            public final long getElapsedMs() {
                return this.elapsedMs;
            }

            public int hashCode() {
                return Long.hashCode(this.elapsedMs);
            }

            public String toString() {
                return ai.onnxruntime.a.h(this.elapsedMs, "SpeechStart(elapsedMs=", ")");
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadPipeline", f = "VadPipeline.kt", l = {186}, m = "close")
    /* renamed from: com.stepos.core.ability.speech.VadPipeline$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadPipeline.this.close(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadPipeline", f = "VadPipeline.kt", l = {210}, m = "inferProbability")
    /* renamed from: com.stepos.core.ability.speech.VadPipeline$inferProbability$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03621 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03621(qb.b<? super C03621> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadPipeline.this.inferProbability(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadPipeline", f = "VadPipeline.kt", l = {89}, m = "offer")
    /* renamed from: com.stepos.core.ability.speech.VadPipeline$offer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03631(qb.b<? super C03631> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadPipeline.this.offer(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadPipeline$offer$2", f = "VadPipeline.kt", l = {92, 117, 118}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.VadPipeline$offer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<short[], qb.b<? super lb.n>, Object> {
        final /* synthetic */ zb.p<Event, qb.b<? super lb.n>, Object> $onEvent;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(zb.p<? super Event, ? super qb.b<? super lb.n>, ? extends Object> pVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$onEvent = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = VadPipeline.this.new AnonymousClass2(this.$onEvent, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            short[] sArr;
            Object objInferProbability;
            CoroutineSingletons coroutineSingletons;
            boolean z;
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                sArr = (short[]) this.L$0;
                if (VadPipeline.this.detector.isEnded()) {
                    return lb.n.f10413a;
                }
                VadPipeline.this.consumedSamples += 256;
                VadPipeline vadPipeline = VadPipeline.this;
                this.L$0 = sArr;
                this.label = 1;
                objInferProbability = vadPipeline.inferProbability(sArr, this);
                if (objInferProbability == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2 && i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                    return lb.n.f10413a;
                }
                sArr = (short[]) this.L$0;
                kotlin.c.b(obj);
                objInferProbability = obj;
            }
            float fFloatValue = ((Number) objInferProbability).floatValue();
            boolean zIsSpeech = VadPipeline.this.gate.isSpeech(fFloatValue, VadSpeechGate.INSTANCE.frameRms(sArr));
            String strTakeCalibrationLog = VadPipeline.this.gate.takeCalibrationLog();
            if (strTakeCalibrationLog != null) {
                VadPipeline vadPipeline2 = VadPipeline.this;
                AIEngineLogger.i(LogModule.ABILITY, vadPipeline2.tag, a0.a.h("[VAD] calibrated t=", vadPipeline2.getElapsedMs(), "ms ", strTakeCalibrationLog));
            }
            VadLevelAggregator.Level levelOnFrame = VadPipeline.this.diagLevels.onFrame(sArr, fFloatValue, VadPipeline.this.getElapsedMs());
            if (levelOnFrame != null) {
                VadPipeline vadPipeline3 = VadPipeline.this;
                LogModule logModule = LogModule.ABILITY;
                String str = vadPipeline3.tag;
                long elapsedMs = vadPipeline3.getElapsedMs();
                String stateName = vadPipeline3.detector.getStateName();
                String strFmt = vadPipeline3.fmt(levelOnFrame.getProbability());
                String strFmt2 = vadPipeline3.fmt(vadPipeline3.config.getThreshold());
                String strFmtRms = vadPipeline3.fmtRms(levelOnFrame.getRms());
                String strFmtRms2 = vadPipeline3.fmtRms(vadPipeline3.config.getMinSpeechRms());
                String strGateTag = vadPipeline3.gateTag();
                String strFmtRms3 = vadPipeline3.fmtRms(levelOnFrame.getPeak());
                int consecutiveSpeechFrames = vadPipeline3.detector.getConsecutiveSpeechFrames();
                int speechStartFrames = vadPipeline3.config.getSpeechStartFrames();
                coroutineSingletons = coroutineSingletons2;
                int consecutiveSilenceFrames = vadPipeline3.detector.getConsecutiveSilenceFrames();
                z = zIsSpeech;
                int silenceFramesRequired = vadPipeline3.detector.getSilenceFramesRequired();
                StringBuilder sbO = a0.a.o("[VAD] t=", elapsedMs, "ms state=", stateName);
                ai.onnxruntime.a.z(sbO, " prob=", strFmt, "/th=", strFmt2);
                ai.onnxruntime.a.z(sbO, " rms=", strFmtRms, "/min=", strFmtRms2);
                ai.onnxruntime.a.z(sbO, strGateTag, " peak=", strFmtRms3, " speechRun=");
                h0.e.l(sbO, consecutiveSpeechFrames, "/", speechStartFrames, " silenceRun=");
                sbO.append(consecutiveSilenceFrames);
                sbO.append("/");
                sbO.append(silenceFramesRequired);
                AIEngineLogger.d(logModule, str, sbO.toString());
            } else {
                coroutineSingletons = coroutineSingletons2;
                z = zIsSpeech;
            }
            VadEndpointDetector.Event eventOnFrame = VadPipeline.this.detector.onFrame(z, VadPipeline.this.getElapsedMs());
            if (eventOnFrame instanceof VadEndpointDetector.Event.SpeechStart) {
                zb.p<Event, qb.b<? super lb.n>, Object> pVar = this.$onEvent;
                Event.SpeechStart speechStart = new Event.SpeechStart(((VadEndpointDetector.Event.SpeechStart) eventOnFrame).getElapsedMs());
                this.L$0 = null;
                this.label = 2;
                Object objInvoke = pVar.invoke(speechStart, this);
                CoroutineSingletons coroutineSingletons3 = coroutineSingletons;
                if (objInvoke == coroutineSingletons3) {
                    return coroutineSingletons3;
                }
            } else {
                CoroutineSingletons coroutineSingletons4 = coroutineSingletons;
                if (eventOnFrame instanceof VadEndpointDetector.Event.SpeechEnd) {
                    zb.p<Event, qb.b<? super lb.n>, Object> pVar2 = this.$onEvent;
                    VadEndpointDetector.Event.SpeechEnd speechEnd = (VadEndpointDetector.Event.SpeechEnd) eventOnFrame;
                    Event.SpeechEnd speechEnd2 = new Event.SpeechEnd(speechEnd.getElapsedMs(), speechEnd.getReason());
                    this.L$0 = null;
                    this.label = 3;
                    if (pVar2.invoke(speechEnd2, this) == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                } else if (eventOnFrame != null) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(short[] sArr, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(sArr, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public /* synthetic */ VadPipeline(String str, b7.a aVar, Method method, VadRuntimeConfig vadRuntimeConfig, kotlin.jvm.internal.e eVar) {
        this(str, aVar, method, vadRuntimeConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fmt(float f8) {
        return String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f8)}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fmtRms(float f8) {
        return String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(f8)}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String gateTag() {
        return this.gate.getEffectiveMinRms() > this.config.getMinSpeechRms() ? a0.a.k("(gate ", fmtRms(this.gate.getEffectiveMinRms()), ")") : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object inferProbability(short[] r9, qb.b<? super java.lang.Float> r10) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadPipeline.inferProbability(short[], qb.b):java.lang.Object");
    }

    public final void applyConfig(VadRuntimeConfig newConfig) {
        kotlin.jvm.internal.g.f(newConfig, "newConfig");
        this.config = newConfig;
        this.gate.applyConfig(newConfig);
        this.detector.updateTiming(newConfig.getSpeechStartFrames(), newConfig.getSilenceFrames(), newConfig.getLeadingSilenceTimeoutMs(), newConfig.getMaxDurationMs());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object close(qb.b<? super lb.n> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.core.ability.speech.VadPipeline.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.core.ability.speech.VadPipeline$close$1 r0 = (com.stepos.core.ability.speech.VadPipeline.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.VadPipeline$close$1 r0 = new com.stepos.core.ability.speech.VadPipeline$close$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$0
            com.stepos.core.ability.speech.VadPipeline r4 = (com.stepos.core.ability.speech.VadPipeline) r4
            kotlin.c.b(r5)     // Catch: java.lang.Throwable -> L2f
            kotlin.Result r5 = (kotlin.Result) r5     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r5.f9987a     // Catch: java.lang.Throwable -> L2f
            goto L49
        L2f:
            r5 = move-exception
            goto L4f
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.c.b(r5)
            b7.a r5 = r4.engine     // Catch: java.lang.Throwable -> L2f
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2f
            r0.label = r3     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r5.mo9closeIoAF18A(r0)     // Catch: java.lang.Throwable -> L2f
            if (r5 != r1) goto L49
            return r1
        L49:
            kotlin.Result r0 = new kotlin.Result     // Catch: java.lang.Throwable -> L2f
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L2f
            goto L53
        L4f:
            kotlin.Result$Failure r0 = kotlin.c.a(r5)
        L53:
            java.lang.Throwable r5 = kotlin.Result.b(r0)
            if (r5 == 0) goto L66
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r4 = r4.tag
            java.lang.String r5 = r5.getMessage()
            java.lang.String r1 = "[VAD] close engine failed: "
            ai.onnxruntime.a.w(r1, r5, r0, r4)
        L66:
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadPipeline.close(qb.b):java.lang.Object");
    }

    public final long getElapsedMs() {
        return (this.consumedSamples * 1000) / 16000;
    }

    public final boolean isEnded() {
        return this.detector.isEnded();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object offer(byte[] r6, zb.p<? super com.stepos.core.ability.speech.VadPipeline.Event, ? super qb.b<? super lb.n>, ? extends java.lang.Object> r7, qb.b<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ability.speech.VadPipeline.C03631
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ability.speech.VadPipeline$offer$1 r0 = (com.stepos.core.ability.speech.VadPipeline.C03631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.VadPipeline$offer$1 r0 = new com.stepos.core.ability.speech.VadPipeline$offer$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ability.speech.VadPipeline r5 = (com.stepos.core.ability.speech.VadPipeline) r5
            kotlin.c.b(r8)
            goto L54
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.c.b(r8)
            com.stepos.core.ability.speech.VadEndpointDetector r8 = r5.detector
            boolean r8 = r8.isEnded()
            if (r8 == 0) goto L41
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L41:
            com.stepos.core.ability.speech.VadFrameSlicer r8 = r5.slicer
            com.stepos.core.ability.speech.VadPipeline$offer$2 r2 = new com.stepos.core.ability.speech.VadPipeline$offer$2
            r4 = 0
            r2.<init>(r7, r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r8.offer(r6, r2, r0)
            if (r6 != r1) goto L54
            return r1
        L54:
            com.stepos.core.ability.speech.VadEndpointDetector r5 = r5.detector
            boolean r5 = r5.isEnded()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadPipeline.offer(byte[], zb.p, qb.b):java.lang.Object");
    }

    public final Event.SpeechEnd onInputComplete() {
        VadEndpointDetector.Event.SpeechEnd speechEndOnInputComplete = this.detector.onInputComplete(getElapsedMs());
        if (speechEndOnInputComplete != null) {
            return new Event.SpeechEnd(speechEndOnInputComplete.getElapsedMs(), speechEndOnInputComplete.getReason());
        }
        return null;
    }

    public final void resetHangover() {
        this.detector.resetHangover();
    }

    public final String stats() {
        long j10 = this.inferFrames;
        if (j10 <= 0) {
            return "inferFrames=0";
        }
        long j11 = 1000;
        long j12 = (this.inferNsSum / j10) / j11;
        long j13 = this.inferNsMax / j11;
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "inferFrames=", " inferAvg=");
        sbQ.append(j12);
        return a0.a.d(j13, "us inferMax=", "us", sbQ);
    }

    private VadPipeline(String str, b7.a aVar, Method method, VadRuntimeConfig vadRuntimeConfig) {
        this.tag = str;
        this.engine = aVar;
        this.processMethod = method;
        this.config = vadRuntimeConfig;
        this.slicer = new VadFrameSlicer(256);
        this.detector = new VadEndpointDetector(this.config.getSpeechStartFrames(), this.config.getSilenceFrames(), this.config.getLeadingSilenceTimeoutMs(), this.config.getMaxDurationMs());
        this.diagLevels = new VadLevelAggregator(500);
        this.gate = new VadAdaptiveSpeechGate(this.config);
    }
}
