package com.stepos.motionkit.fx.anim;

import D7.v;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.TrackType;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/motionkit/fx/anim/TrackEvaluator;", "", "", "Lcom/stepos/motionkit/fx/anim/TrackState;", "tracks", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "track", "", "elapsedMs", "", "evaluateTrack", "(Lcom/stepos/motionkit/fx/anim/TrackState;J)F", "LC7/r;", "evaluate", "(J)V", "", "", "isComplete", "(J)Ljava/util/Set;", "Ljava/util/List;", "getTracks", "()Ljava/util/List;", "totalDurationMs", "J", "getTotalDurationMs", "()J", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackEvaluator {
    private final long totalDurationMs;
    private final List<TrackState> tracks;

    public TrackEvaluator(List<TrackState> tracks) {
        Long lValueOf;
        k.f(tracks, "tracks");
        this.tracks = tracks;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = tracks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrackType type = ((TrackState) it.next()).getType();
            if (type instanceof TrackType.OneShot) {
                TrackType.OneShot oneShot = (TrackType.OneShot) type;
                lValueOf = Long.valueOf(oneShot.getDurationMs() + oneShot.getDelayMs());
            } else if (type instanceof TrackType.Sequence) {
                Iterator<T> it2 = ((TrackType.Sequence) type).getSegments().iterator();
                while (it2.hasNext()) {
                    durationMs += ((TrackType.Sequence.Segment) it2.next()).getDurationMs();
                }
                lValueOf = Long.valueOf(durationMs);
            } else {
                lValueOf = null;
            }
            if (lValueOf != null) {
                arrayList.add(lValueOf);
            }
        }
        Long l = (Long) v.M0(arrayList);
        this.totalDurationMs = l != null ? l.longValue() : 0L;
    }

    private final float evaluateTrack(TrackState track, long elapsedMs) {
        float from;
        float to;
        float periodMs;
        float from2;
        float to2;
        float from3;
        TrackType type = track.getType();
        if (type instanceof TrackType.OneShot) {
            TrackType.OneShot oneShot = (TrackType.OneShot) type;
            long delayMs = elapsedMs - oneShot.getDelayMs();
            if (delayMs < 0) {
                return oneShot.getFrom();
            }
            periodMs = Easing.INSTANCE.evaluate(oneShot.getEasing(), AbstractC1451a.t(delayMs / oneShot.getDurationMs(), 0.0f, 1.0f));
            from2 = oneShot.getFrom();
            to2 = oneShot.getTo();
            from3 = oneShot.getFrom();
        } else if (type instanceof TrackType.Oscillate) {
            TrackType.Oscillate oscillate = (TrackType.Oscillate) type;
            periodMs = (((float) Math.sin((((elapsedMs % oscillate.getPeriodMs()) / oscillate.getPeriodMs()) * 2.0f) * 3.1415927f)) + 1.0f) / 2.0f;
            from2 = oscillate.getMin();
            to2 = oscillate.getMax();
            from3 = oscillate.getMin();
        } else {
            if (type instanceof TrackType.Linear) {
                return ((TrackType.Linear) type).getSpeed() * (elapsedMs / 1000.0f);
            }
            if (!(type instanceof TrackType.Sawtooth)) {
                if (!(type instanceof TrackType.TriangleWave)) {
                    if (!(type instanceof TrackType.Sequence)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    TrackType.Sequence sequence = (TrackType.Sequence) type;
                    for (TrackType.Sequence.Segment segment : sequence.getSegments()) {
                        if (elapsedMs < segment.getDurationMs()) {
                            float fEvaluate = Easing.INSTANCE.evaluate(segment.getEasing(), AbstractC1451a.t(elapsedMs / segment.getDurationMs(), 0.0f, 1.0f));
                            from = segment.getFrom();
                            to = (segment.getTo() - segment.getFrom()) * fEvaluate;
                        } else {
                            elapsedMs -= segment.getDurationMs();
                        }
                    }
                    return ((TrackType.Sequence.Segment) v.K0(sequence.getSegments())).getTo();
                }
                TrackType.TriangleWave triangleWave = (TrackType.TriangleWave) type;
                float fAbs = 1.0f - Math.abs((((elapsedMs % triangleWave.getPeriodMs()) / triangleWave.getPeriodMs()) * 2.0f) - 1.0f);
                from = triangleWave.getMin();
                to = (triangleWave.getMax() - triangleWave.getMin()) * fAbs;
                return to + from;
            }
            TrackType.Sawtooth sawtooth = (TrackType.Sawtooth) type;
            periodMs = (elapsedMs % sawtooth.getPeriodMs()) / sawtooth.getPeriodMs();
            from2 = sawtooth.getFrom();
            to2 = sawtooth.getTo();
            from3 = sawtooth.getFrom();
        }
        return ((to2 - from3) * periodMs) + from2;
    }

    public final void evaluate(long elapsedMs) {
        for (TrackState trackState : this.tracks) {
            trackState.setValue(evaluateTrack(trackState, elapsedMs));
        }
    }

    public final long getTotalDurationMs() {
        return this.totalDurationMs;
    }

    public final List<TrackState> getTracks() {
        return this.tracks;
    }

    public final Set<String> isComplete(long elapsedMs) {
        long durationMs;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (TrackState trackState : this.tracks) {
            if (!trackState.getCompleteFired()) {
                TrackType type = trackState.getType();
                if (type instanceof TrackType.OneShot) {
                    TrackType.OneShot oneShot = (TrackType.OneShot) type;
                    durationMs = oneShot.getDurationMs() + oneShot.getDelayMs();
                } else if (type instanceof TrackType.Sequence) {
                    Iterator<T> it = ((TrackType.Sequence) type).getSegments().iterator();
                    durationMs = 0;
                    while (it.hasNext()) {
                        durationMs += ((TrackType.Sequence.Segment) it.next()).getDurationMs();
                    }
                }
                if (elapsedMs >= durationMs) {
                    trackState.setCompleteFired(true);
                    linkedHashSet.add(trackState.getName());
                }
            }
        }
        return linkedHashSet;
    }
}
