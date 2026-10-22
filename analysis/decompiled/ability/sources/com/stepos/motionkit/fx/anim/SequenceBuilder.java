package com.stepos.motionkit.fx.anim;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.motionkit.EasingType;
import com.stepos.motionkit.TrackType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0004¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/motionkit/fx/anim/SequenceBuilder;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "flush", "", "end", TypedValues.TransitionType.S_TO, "(FF)Lcom/stepos/motionkit/fx/anim/SequenceBuilder;", "", "ms", TypedValues.TransitionType.S_DURATION, "(Lcom/stepos/motionkit/fx/anim/SequenceBuilder;J)Lcom/stepos/motionkit/fx/anim/SequenceBuilder;", "Lcom/stepos/motionkit/EasingType;", "type", "ease", "(Lcom/stepos/motionkit/fx/anim/SequenceBuilder;Lcom/stepos/motionkit/EasingType;)Lcom/stepos/motionkit/fx/anim/SequenceBuilder;", "Lcom/stepos/motionkit/TrackType$Sequence;", "build$motionkit_fx_release", "()Lcom/stepos/motionkit/TrackType$Sequence;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "Lcom/stepos/motionkit/TrackType$Sequence$Segment;", "segments", "Ljava/util/List;", "pendingFrom", "F", "pendingTo", "pendingDuration", "J", "pendingEasing", "Lcom/stepos/motionkit/EasingType;", "", "hasPending", "Z", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SequenceBuilder {
    private boolean hasPending;
    private float pendingFrom;
    private float pendingTo;
    private final List<TrackType.Sequence.Segment> segments = new ArrayList();
    private long pendingDuration = 300;
    private EasingType pendingEasing = EasingType.LINEAR;

    private final void flush() {
        this.segments.add(new TrackType.Sequence.Segment(this.pendingFrom, this.pendingTo, this.pendingDuration, this.pendingEasing));
    }

    public final TrackType.Sequence build$motionkit_fx_release() {
        if (this.hasPending) {
            flush();
        }
        return new TrackType.Sequence(this.segments);
    }

    public final SequenceBuilder duration(SequenceBuilder sequenceBuilder, long j5) {
        k.f(sequenceBuilder, "<this>");
        sequenceBuilder.pendingDuration = j5;
        return sequenceBuilder;
    }

    public final SequenceBuilder ease(SequenceBuilder sequenceBuilder, EasingType type) {
        k.f(sequenceBuilder, "<this>");
        k.f(type, "type");
        sequenceBuilder.pendingEasing = type;
        return sequenceBuilder;
    }

    public final SequenceBuilder to(float f, float f7) {
        if (this.hasPending) {
            flush();
        }
        this.pendingFrom = f;
        this.pendingTo = f7;
        this.pendingDuration = 300L;
        this.pendingEasing = EasingType.LINEAR;
        this.hasPending = true;
        return this;
    }
}
