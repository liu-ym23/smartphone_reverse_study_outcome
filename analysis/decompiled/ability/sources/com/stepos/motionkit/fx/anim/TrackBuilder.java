package com.stepos.motionkit.fx.anim;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.motionkit.EasingType;
import com.stepos.motionkit.TrackDefinition;
import com.stepos.motionkit.TrackType;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u0000*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0086\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0086\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0086\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u001c\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0004¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u0019J%\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u0019J!\u0010$\u001a\u00020\u00002\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 ¢\u0006\u0004\b$\u0010%J\u000f\u0010)\u001a\u00020&H\u0000¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010,R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010,R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00100\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "", "", HintConstants.AUTOFILL_HINT_NAME, "", "component", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "", "end", TypedValues.TransitionType.S_TO, "(FF)Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "", "ms", TypedValues.TransitionType.S_DURATION, "(Lcom/stepos/motionkit/fx/anim/TrackBuilder;J)Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "delay", "Lcom/stepos/motionkit/EasingType;", "type", "ease", "(Lcom/stepos/motionkit/fx/anim/TrackBuilder;Lcom/stepos/motionkit/EasingType;)Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "min", "max", TypedValues.CycleType.S_WAVE_PERIOD, "oscillate", "(FFJ)Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "speed", "linear", "(F)Lcom/stepos/motionkit/fx/anim/TrackBuilder;", TypedValues.TransitionType.S_FROM, "sawtooth", "triangleWave", "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/anim/SequenceBuilder;", "LC7/r;", "block", "sequence", "(LS7/k;)Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "Lcom/stepos/motionkit/TrackDefinition;", "build$motionkit_fx_release", "()Lcom/stepos/motionkit/TrackDefinition;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Ljava/lang/String;", "I", "F", "durationMs", "J", "delayMs", "easing", "Lcom/stepos/motionkit/EasingType;", "Lcom/stepos/motionkit/TrackType;", "trackType", "Lcom/stepos/motionkit/TrackType;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackBuilder {
    private final int component;
    private long delayMs;
    private long durationMs;
    private EasingType easing;
    private float from;
    private final String name;
    private float to;
    private TrackType trackType;

    public TrackBuilder(String name, int i) {
        k.f(name, "name");
        this.name = name;
        this.component = i;
        this.to = 1.0f;
        this.durationMs = 1000L;
        this.easing = EasingType.LINEAR;
    }

    public final TrackDefinition build$motionkit_fx_release() {
        TrackType oneShot = this.trackType;
        if (oneShot == null) {
            oneShot = new TrackType.OneShot(this.from, this.to, this.durationMs, this.delayMs, this.easing);
        }
        return new TrackDefinition(this.name, oneShot, this.component);
    }

    public final TrackBuilder delay(TrackBuilder trackBuilder, long j5) {
        k.f(trackBuilder, "<this>");
        trackBuilder.delayMs = j5;
        return trackBuilder;
    }

    public final TrackBuilder duration(TrackBuilder trackBuilder, long j5) {
        k.f(trackBuilder, "<this>");
        trackBuilder.durationMs = j5;
        return trackBuilder;
    }

    public final TrackBuilder ease(TrackBuilder trackBuilder, EasingType type) {
        k.f(trackBuilder, "<this>");
        k.f(type, "type");
        trackBuilder.easing = type;
        return trackBuilder;
    }

    public final TrackBuilder linear(float speed) {
        this.trackType = new TrackType.Linear(speed);
        return this;
    }

    public final TrackBuilder oscillate(float min, float max, long period) {
        this.trackType = new TrackType.Oscillate(min, max, period);
        return this;
    }

    public final TrackBuilder sawtooth(float from, float to, long period) {
        this.trackType = new TrackType.Sawtooth(from, to, period);
        return this;
    }

    public final TrackBuilder sequence(S7.k block) {
        k.f(block, "block");
        SequenceBuilder sequenceBuilder = new SequenceBuilder();
        block.invoke(sequenceBuilder);
        this.trackType = sequenceBuilder.build$motionkit_fx_release();
        return this;
    }

    public final TrackBuilder to(float f, float f7) {
        this.from = f;
        this.to = f7;
        return this;
    }

    public final TrackBuilder triangleWave(float min, float max, long period) {
        this.trackType = new TrackType.TriangleWave(min, max, period);
        return this;
    }

    public /* synthetic */ TrackBuilder(String str, int i, int i6, e eVar) {
        this(str, (i6 & 2) != 0 ? -1 : i);
    }
}
