package com.stepos.motionkit;

import B7.a;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/motionkit/TrackType;", "", AppAgent.CONSTRUCT, "()V", "OneShot", "Oscillate", "Linear", "Sawtooth", "TriangleWave", "Sequence", "Lcom/stepos/motionkit/TrackType$Linear;", "Lcom/stepos/motionkit/TrackType$OneShot;", "Lcom/stepos/motionkit/TrackType$Oscillate;", "Lcom/stepos/motionkit/TrackType$Sawtooth;", "Lcom/stepos/motionkit/TrackType$Sequence;", "Lcom/stepos/motionkit/TrackType$TriangleWave;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TrackType {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/motionkit/TrackType$Linear;", "Lcom/stepos/motionkit/TrackType;", "speed", "", AppAgent.CONSTRUCT, "(F)V", "getSpeed", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Linear extends TrackType {
        private final float speed;

        public Linear(float f) {
            super(null);
            this.speed = f;
        }

        public static /* synthetic */ Linear copy$default(Linear linear, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = linear.speed;
            }
            return linear.copy(f);
        }

        /* renamed from: component1, reason: from getter */
        public final float getSpeed() {
            return this.speed;
        }

        public final Linear copy(float speed) {
            return new Linear(speed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Linear) && Float.compare(this.speed, ((Linear) other).speed) == 0;
        }

        public final float getSpeed() {
            return this.speed;
        }

        public int hashCode() {
            return Float.hashCode(this.speed);
        }

        public String toString() {
            return a.l("Linear(speed=", ")", this.speed);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/motionkit/TrackType$Oscillate;", "Lcom/stepos/motionkit/TrackType;", "min", "", "max", "periodMs", "", AppAgent.CONSTRUCT, "(FFJ)V", "getMin", "()F", "getMax", "getPeriodMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Oscillate extends TrackType {
        private final float max;
        private final float min;
        private final long periodMs;

        public Oscillate(float f, float f7, long j5) {
            super(null);
            this.min = f;
            this.max = f7;
            this.periodMs = j5;
        }

        public static /* synthetic */ Oscillate copy$default(Oscillate oscillate, float f, float f7, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                f = oscillate.min;
            }
            if ((i & 2) != 0) {
                f7 = oscillate.max;
            }
            if ((i & 4) != 0) {
                j5 = oscillate.periodMs;
            }
            return oscillate.copy(f, f7, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final float getMin() {
            return this.min;
        }

        /* renamed from: component2, reason: from getter */
        public final float getMax() {
            return this.max;
        }

        /* renamed from: component3, reason: from getter */
        public final long getPeriodMs() {
            return this.periodMs;
        }

        public final Oscillate copy(float min, float max, long periodMs) {
            return new Oscillate(min, max, periodMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Oscillate)) {
                return false;
            }
            Oscillate oscillate = (Oscillate) other;
            return Float.compare(this.min, oscillate.min) == 0 && Float.compare(this.max, oscillate.max) == 0 && this.periodMs == oscillate.periodMs;
        }

        public final float getMax() {
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        public final long getPeriodMs() {
            return this.periodMs;
        }

        public int hashCode() {
            return Long.hashCode(this.periodMs) + androidx.appfunctions.metadata.a.b(this.max, Float.hashCode(this.min) * 31, 31);
        }

        public String toString() {
            float f = this.min;
            float f7 = this.max;
            long j5 = this.periodMs;
            StringBuilder sb = new StringBuilder("Oscillate(min=");
            sb.append(f);
            sb.append(", max=");
            sb.append(f7);
            sb.append(", periodMs=");
            return androidx.constraintlayout.core.dsl.a.e(j5, ")", sb);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/motionkit/TrackType$Sawtooth;", "Lcom/stepos/motionkit/TrackType;", TypedValues.TransitionType.S_FROM, "", TypedValues.TransitionType.S_TO, "periodMs", "", AppAgent.CONSTRUCT, "(FFJ)V", "getFrom", "()F", "getTo", "getPeriodMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Sawtooth extends TrackType {
        private final float from;
        private final long periodMs;
        private final float to;

        public Sawtooth(float f, float f7, long j5) {
            super(null);
            this.from = f;
            this.to = f7;
            this.periodMs = j5;
        }

        public static /* synthetic */ Sawtooth copy$default(Sawtooth sawtooth, float f, float f7, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                f = sawtooth.from;
            }
            if ((i & 2) != 0) {
                f7 = sawtooth.to;
            }
            if ((i & 4) != 0) {
                j5 = sawtooth.periodMs;
            }
            return sawtooth.copy(f, f7, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final float getFrom() {
            return this.from;
        }

        /* renamed from: component2, reason: from getter */
        public final float getTo() {
            return this.to;
        }

        /* renamed from: component3, reason: from getter */
        public final long getPeriodMs() {
            return this.periodMs;
        }

        public final Sawtooth copy(float from, float to, long periodMs) {
            return new Sawtooth(from, to, periodMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sawtooth)) {
                return false;
            }
            Sawtooth sawtooth = (Sawtooth) other;
            return Float.compare(this.from, sawtooth.from) == 0 && Float.compare(this.to, sawtooth.to) == 0 && this.periodMs == sawtooth.periodMs;
        }

        public final float getFrom() {
            return this.from;
        }

        public final long getPeriodMs() {
            return this.periodMs;
        }

        public final float getTo() {
            return this.to;
        }

        public int hashCode() {
            return Long.hashCode(this.periodMs) + androidx.appfunctions.metadata.a.b(this.to, Float.hashCode(this.from) * 31, 31);
        }

        public String toString() {
            float f = this.from;
            float f7 = this.to;
            long j5 = this.periodMs;
            StringBuilder sb = new StringBuilder("Sawtooth(from=");
            sb.append(f);
            sb.append(", to=");
            sb.append(f7);
            sb.append(", periodMs=");
            return androidx.constraintlayout.core.dsl.a.e(j5, ")", sb);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/motionkit/TrackType$TriangleWave;", "Lcom/stepos/motionkit/TrackType;", "min", "", "max", "periodMs", "", AppAgent.CONSTRUCT, "(FFJ)V", "getMin", "()F", "getMax", "getPeriodMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class TriangleWave extends TrackType {
        private final float max;
        private final float min;
        private final long periodMs;

        public TriangleWave(float f, float f7, long j5) {
            super(null);
            this.min = f;
            this.max = f7;
            this.periodMs = j5;
        }

        public static /* synthetic */ TriangleWave copy$default(TriangleWave triangleWave, float f, float f7, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                f = triangleWave.min;
            }
            if ((i & 2) != 0) {
                f7 = triangleWave.max;
            }
            if ((i & 4) != 0) {
                j5 = triangleWave.periodMs;
            }
            return triangleWave.copy(f, f7, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final float getMin() {
            return this.min;
        }

        /* renamed from: component2, reason: from getter */
        public final float getMax() {
            return this.max;
        }

        /* renamed from: component3, reason: from getter */
        public final long getPeriodMs() {
            return this.periodMs;
        }

        public final TriangleWave copy(float min, float max, long periodMs) {
            return new TriangleWave(min, max, periodMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TriangleWave)) {
                return false;
            }
            TriangleWave triangleWave = (TriangleWave) other;
            return Float.compare(this.min, triangleWave.min) == 0 && Float.compare(this.max, triangleWave.max) == 0 && this.periodMs == triangleWave.periodMs;
        }

        public final float getMax() {
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        public final long getPeriodMs() {
            return this.periodMs;
        }

        public int hashCode() {
            return Long.hashCode(this.periodMs) + androidx.appfunctions.metadata.a.b(this.max, Float.hashCode(this.min) * 31, 31);
        }

        public String toString() {
            float f = this.min;
            float f7 = this.max;
            long j5 = this.periodMs;
            StringBuilder sb = new StringBuilder("TriangleWave(min=");
            sb.append(f);
            sb.append(", max=");
            sb.append(f7);
            sb.append(", periodMs=");
            return androidx.constraintlayout.core.dsl.a.e(j5, ")", sb);
        }
    }

    public /* synthetic */ TrackType(e eVar) {
        this();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/stepos/motionkit/TrackType$OneShot;", "Lcom/stepos/motionkit/TrackType;", TypedValues.TransitionType.S_FROM, "", TypedValues.TransitionType.S_TO, "durationMs", "", "delayMs", "easing", "Lcom/stepos/motionkit/EasingType;", AppAgent.CONSTRUCT, "(FFJJLcom/stepos/motionkit/EasingType;)V", "getFrom", "()F", "getTo", "getDurationMs", "()J", "getDelayMs", "getEasing", "()Lcom/stepos/motionkit/EasingType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class OneShot extends TrackType {
        private final long delayMs;
        private final long durationMs;
        private final EasingType easing;
        private final float from;
        private final float to;

        public /* synthetic */ OneShot(float f, float f7, long j5, long j6, EasingType easingType, int i, e eVar) {
            this(f, f7, j5, (i & 8) != 0 ? 0L : j6, (i & 16) != 0 ? EasingType.LINEAR : easingType);
        }

        public static /* synthetic */ OneShot copy$default(OneShot oneShot, float f, float f7, long j5, long j6, EasingType easingType, int i, Object obj) {
            if ((i & 1) != 0) {
                f = oneShot.from;
            }
            if ((i & 2) != 0) {
                f7 = oneShot.to;
            }
            if ((i & 4) != 0) {
                j5 = oneShot.durationMs;
            }
            if ((i & 8) != 0) {
                j6 = oneShot.delayMs;
            }
            if ((i & 16) != 0) {
                easingType = oneShot.easing;
            }
            EasingType easingType2 = easingType;
            long j10 = j6;
            return oneShot.copy(f, f7, j5, j10, easingType2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getFrom() {
            return this.from;
        }

        /* renamed from: component2, reason: from getter */
        public final float getTo() {
            return this.to;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component4, reason: from getter */
        public final long getDelayMs() {
            return this.delayMs;
        }

        /* renamed from: component5, reason: from getter */
        public final EasingType getEasing() {
            return this.easing;
        }

        public final OneShot copy(float from, float to, long durationMs, long delayMs, EasingType easing) {
            k.f(easing, "easing");
            return new OneShot(from, to, durationMs, delayMs, easing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OneShot)) {
                return false;
            }
            OneShot oneShot = (OneShot) other;
            return Float.compare(this.from, oneShot.from) == 0 && Float.compare(this.to, oneShot.to) == 0 && this.durationMs == oneShot.durationMs && this.delayMs == oneShot.delayMs && this.easing == oneShot.easing;
        }

        public final long getDelayMs() {
            return this.delayMs;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final EasingType getEasing() {
            return this.easing;
        }

        public final float getFrom() {
            return this.from;
        }

        public final float getTo() {
            return this.to;
        }

        public int hashCode() {
            return this.easing.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.b(this.to, Float.hashCode(this.from) * 31, 31), 31, this.durationMs), 31, this.delayMs);
        }

        public String toString() {
            float f = this.from;
            float f7 = this.to;
            long j5 = this.durationMs;
            long j6 = this.delayMs;
            EasingType easingType = this.easing;
            StringBuilder sb = new StringBuilder("OneShot(from=");
            sb.append(f);
            sb.append(", to=");
            sb.append(f7);
            sb.append(", durationMs=");
            sb.append(j5);
            b.y(j6, ", delayMs=", ", easing=", sb);
            sb.append(easingType);
            sb.append(")");
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OneShot(float f, float f7, long j5, long j6, EasingType easing) {
            super(null);
            k.f(easing, "easing");
            this.from = f;
            this.to = f7;
            this.durationMs = j5;
            this.delayMs = j6;
            this.easing = easing;
        }
    }

    private TrackType() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/TrackType$Sequence;", "Lcom/stepos/motionkit/TrackType;", "segments", "", "Lcom/stepos/motionkit/TrackType$Sequence$Segment;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getSegments", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Segment", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Sequence extends TrackType {
        private final List<Segment> segments;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Sequence(List<Segment> segments) {
            super(null);
            k.f(segments, "segments");
            this.segments = segments;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Sequence copy$default(Sequence sequence, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sequence.segments;
            }
            return sequence.copy(list);
        }

        public final List<Segment> component1() {
            return this.segments;
        }

        public final Sequence copy(List<Segment> segments) {
            k.f(segments, "segments");
            return new Sequence(segments);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Sequence) && k.b(this.segments, ((Sequence) other).segments);
        }

        public final List<Segment> getSegments() {
            return this.segments;
        }

        public int hashCode() {
            return this.segments.hashCode();
        }

        public String toString() {
            return "Sequence(segments=" + this.segments + ")";
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/motionkit/TrackType$Sequence$Segment;", "", TypedValues.TransitionType.S_FROM, "", TypedValues.TransitionType.S_TO, "durationMs", "", "easing", "Lcom/stepos/motionkit/EasingType;", AppAgent.CONSTRUCT, "(FFJLcom/stepos/motionkit/EasingType;)V", "getFrom", "()F", "getTo", "getDurationMs", "()J", "getEasing", "()Lcom/stepos/motionkit/EasingType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Segment {
            private final long durationMs;
            private final EasingType easing;
            private final float from;
            private final float to;

            public Segment(float f, float f7, long j5, EasingType easing) {
                k.f(easing, "easing");
                this.from = f;
                this.to = f7;
                this.durationMs = j5;
                this.easing = easing;
            }

            public static /* synthetic */ Segment copy$default(Segment segment, float f, float f7, long j5, EasingType easingType, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = segment.from;
                }
                if ((i & 2) != 0) {
                    f7 = segment.to;
                }
                if ((i & 4) != 0) {
                    j5 = segment.durationMs;
                }
                if ((i & 8) != 0) {
                    easingType = segment.easing;
                }
                EasingType easingType2 = easingType;
                return segment.copy(f, f7, j5, easingType2);
            }

            /* renamed from: component1, reason: from getter */
            public final float getFrom() {
                return this.from;
            }

            /* renamed from: component2, reason: from getter */
            public final float getTo() {
                return this.to;
            }

            /* renamed from: component3, reason: from getter */
            public final long getDurationMs() {
                return this.durationMs;
            }

            /* renamed from: component4, reason: from getter */
            public final EasingType getEasing() {
                return this.easing;
            }

            public final Segment copy(float from, float to, long durationMs, EasingType easing) {
                k.f(easing, "easing");
                return new Segment(from, to, durationMs, easing);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Segment)) {
                    return false;
                }
                Segment segment = (Segment) other;
                return Float.compare(this.from, segment.from) == 0 && Float.compare(this.to, segment.to) == 0 && this.durationMs == segment.durationMs && this.easing == segment.easing;
            }

            public final long getDurationMs() {
                return this.durationMs;
            }

            public final EasingType getEasing() {
                return this.easing;
            }

            public final float getFrom() {
                return this.from;
            }

            public final float getTo() {
                return this.to;
            }

            public int hashCode() {
                return this.easing.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.b(this.to, Float.hashCode(this.from) * 31, 31), 31, this.durationMs);
            }

            public String toString() {
                return "Segment(from=" + this.from + ", to=" + this.to + ", durationMs=" + this.durationMs + ", easing=" + this.easing + ")";
            }

            public /* synthetic */ Segment(float f, float f7, long j5, EasingType easingType, int i, e eVar) {
                this(f, f7, j5, (i & 8) != 0 ? EasingType.LINEAR : easingType);
            }
        }
    }
}
