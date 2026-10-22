package com.stepos.core.ota.process;

import com.stepos.core.ota.domain.TriggerSource;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface InterruptedResumeDecision {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Resume implements InterruptedResumeDecision {
        private final TriggerSource source;

        public Resume(TriggerSource source) {
            g.f(source, "source");
            this.source = source;
        }

        public static /* synthetic */ Resume copy$default(Resume resume, TriggerSource triggerSource, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                triggerSource = resume.source;
            }
            return resume.copy(triggerSource);
        }

        public final TriggerSource component1() {
            return this.source;
        }

        public final Resume copy(TriggerSource source) {
            g.f(source, "source");
            return new Resume(source);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Resume) && this.source == ((Resume) obj).source;
        }

        public final TriggerSource getSource() {
            return this.source;
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "Resume(source=" + this.source + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Skip implements InterruptedResumeDecision {
        private final String reason;

        public Skip(String reason) {
            g.f(reason, "reason");
            this.reason = reason;
        }

        public static /* synthetic */ Skip copy$default(Skip skip, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = skip.reason;
            }
            return skip.copy(str);
        }

        public final String component1() {
            return this.reason;
        }

        public final Skip copy(String reason) {
            g.f(reason, "reason");
            return new Skip(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Skip) && g.b(this.reason, ((Skip) obj).reason);
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return a0.a.k("Skip(reason=", this.reason, ")");
        }
    }
}
