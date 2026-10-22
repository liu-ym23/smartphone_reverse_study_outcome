package com.stepos.core.ability.speech;

import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadEndpointDetector {
    public static final Companion Companion = new Companion(null);
    public static final String REASON_CLIENT_COMPLETE = "client_complete";
    public static final String REASON_MAX_DURATION = "max_duration";
    public static final String REASON_NO_SPEECH = "no_speech";
    public static final String REASON_SILENCE = "silence";
    private int leadingSilenceTimeoutMs;
    private int maxDurationMs;
    private int silenceFrames;
    private int silenceRun;
    private int speechRun;
    private int speechStartFrames;
    private State state = State.WAITING;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class State {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State WAITING = new State("WAITING", 0);
        public static final State SPEAKING = new State("SPEAKING", 1);
        public static final State ENDED = new State("ENDED", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{WAITING, SPEAKING, ENDED};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static sb.a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.SPEAKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.ENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VadEndpointDetector(int i10, int i11, int i12, int i13) {
        this.speechStartFrames = i10;
        this.silenceFrames = i11;
        this.leadingSilenceTimeoutMs = i12;
        this.maxDurationMs = i13;
    }

    public final int getConsecutiveSilenceFrames() {
        return this.silenceRun;
    }

    public final int getConsecutiveSpeechFrames() {
        return this.speechRun;
    }

    public final int getSilenceFramesRequired() {
        return this.silenceFrames;
    }

    public final String getStateName() {
        return this.state.name();
    }

    public final boolean isEnded() {
        return this.state == State.ENDED;
    }

    public final boolean isSpeaking() {
        return this.state == State.SPEAKING;
    }

    public final Event onFrame(boolean z, long j10) {
        State state = this.state;
        State state2 = State.ENDED;
        if (state == state2) {
            return null;
        }
        if (j10 >= this.maxDurationMs) {
            this.state = state2;
            return new Event.SpeechEnd(j10, "max_duration");
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                this.silenceRun = 0;
                return null;
            }
            int i11 = this.silenceRun + 1;
            this.silenceRun = i11;
            if (i11 < this.silenceFrames) {
                return null;
            }
            this.state = state2;
            return new Event.SpeechEnd(j10, "silence");
        }
        if (!z) {
            this.speechRun = 0;
            if (j10 < this.leadingSilenceTimeoutMs) {
                return null;
            }
            this.state = state2;
            return new Event.SpeechEnd(j10, "no_speech");
        }
        this.silenceRun = 0;
        int i12 = this.speechRun + 1;
        this.speechRun = i12;
        if (i12 < this.speechStartFrames) {
            return null;
        }
        this.state = State.SPEAKING;
        return new Event.SpeechStart(j10);
    }

    public final Event.SpeechEnd onInputComplete(long j10) {
        State state = this.state;
        State state2 = State.ENDED;
        if (state == state2) {
            return null;
        }
        String str = state == State.SPEAKING ? REASON_CLIENT_COMPLETE : "no_speech";
        this.state = state2;
        return new Event.SpeechEnd(j10, str);
    }

    public final void resetHangover() {
        if (this.state == State.ENDED) {
            return;
        }
        this.speechRun = 0;
        this.silenceRun = 0;
    }

    public final void updateTiming(int i10, int i11, int i12, int i13) {
        if (this.state == State.ENDED) {
            return;
        }
        this.speechStartFrames = i10;
        this.silenceFrames = i11;
        this.leadingSilenceTimeoutMs = i12;
        this.maxDurationMs = i13;
        this.speechRun = 0;
        this.silenceRun = 0;
    }
}
