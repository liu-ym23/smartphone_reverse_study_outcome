package kotlin;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import s7.v;
import v9.C5685n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lu7/f;", "", "", "Lu7/g;", "tracks", "<init>", "(Ljava/util/List;)V", "", "elapsedMs", "LY8/t;", Const.INTENT_KEY_APIKEY, "(J)V", "", "", Const.INTENT_KEY_UMID, "(J)Ljava/util/Set;", "track", "", Const.INTENT_KEY_PKGNAME, "(Lu7/g;J)F", "Ljava/util/List;", "c", "()Ljava/util/List;", "J", "getTotalDurationMs", "()J", "totalDurationMs", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: u7.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5587f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<C5588g> tracks;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long totalDurationMs;

    public C5587f(List<C5588g> tracks) {
        Long lValueOf;
        p.i(tracks, "tracks");
        this.tracks = tracks;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = tracks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            v type = ((C5588g) it.next()).getType();
            if (type instanceof v.OneShot) {
                v.OneShot oneShot = (v.OneShot) type;
                lValueOf = Long.valueOf(oneShot.getDelayMs() + oneShot.getDurationMs());
            } else if (type instanceof v.Sequence) {
                Iterator<T> it2 = ((v.Sequence) type).a().iterator();
                while (it2.hasNext()) {
                    durationMs += ((v.Sequence.Segment) it2.next()).getDurationMs();
                }
                lValueOf = Long.valueOf(durationMs);
            } else {
                lValueOf = null;
            }
            if (lValueOf != null) {
                arrayList.add(lValueOf);
            }
        }
        Long l10 = (Long) F.G0(arrayList);
        this.totalDurationMs = l10 != null ? l10.longValue() : 0L;
    }

    public final void a(long elapsedMs) {
        for (C5588g c5588g : this.tracks) {
            c5588g.g(b(c5588g, elapsedMs));
        }
    }

    public final float b(C5588g track, long elapsedMs) {
        float periodMs;
        float from;
        float to;
        float from2;
        v type = track.getType();
        if (type instanceof v.OneShot) {
            v.OneShot oneShot = (v.OneShot) type;
            long delayMs = elapsedMs - oneShot.getDelayMs();
            if (delayMs < 0) {
                return oneShot.getFrom();
            }
            periodMs = C5584c.f42443a.a(oneShot.getEasing(), C5685n.m(delayMs / oneShot.getDurationMs(), 0.0f, 1.0f));
            from = oneShot.getFrom();
            to = oneShot.getTo();
            from2 = oneShot.getFrom();
        } else if (type instanceof v.Oscillate) {
            v.Oscillate oscillate = (v.Oscillate) type;
            periodMs = (((float) Math.sin((((elapsedMs % oscillate.getPeriodMs()) / oscillate.getPeriodMs()) * 2.0f) * 3.1415927f)) + 1.0f) / 2.0f;
            from = oscillate.getMin();
            to = oscillate.getMax();
            from2 = oscillate.getMin();
        } else {
            if (type instanceof v.Linear) {
                return (elapsedMs / 1000.0f) * ((v.Linear) type).getSpeed();
            }
            if (!(type instanceof v.Sawtooth)) {
                if (type instanceof v.TriangleWave) {
                    v.TriangleWave triangleWave = (v.TriangleWave) type;
                    return triangleWave.getMin() + ((triangleWave.getMax() - triangleWave.getMin()) * (1.0f - Math.abs((((elapsedMs % triangleWave.getPeriodMs()) / triangleWave.getPeriodMs()) * 2.0f) - 1.0f)));
                }
                if (!(type instanceof v.Sequence)) {
                    throw new NoWhenBranchMatchedException();
                }
                v.Sequence sequence = (v.Sequence) type;
                for (v.Sequence.Segment segment : sequence.a()) {
                    if (elapsedMs < segment.getDurationMs()) {
                        return segment.getFrom() + ((segment.getTo() - segment.getFrom()) * C5584c.f42443a.a(segment.getEasing(), C5685n.m(elapsedMs / segment.getDurationMs(), 0.0f, 1.0f)));
                    }
                    elapsedMs -= segment.getDurationMs();
                }
                return ((v.Sequence.Segment) F.C0(sequence.a())).getTo();
            }
            v.Sawtooth sawtooth = (v.Sawtooth) type;
            periodMs = (elapsedMs % sawtooth.getPeriodMs()) / sawtooth.getPeriodMs();
            from = sawtooth.getFrom();
            to = sawtooth.getTo();
            from2 = sawtooth.getFrom();
        }
        return from + ((to - from2) * periodMs);
    }

    public final List<C5588g> c() {
        return this.tracks;
    }

    public final Set<String> d(long elapsedMs) {
        long delayMs;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (C5588g c5588g : this.tracks) {
            if (!c5588g.getCompleteFired()) {
                v type = c5588g.getType();
                if (type instanceof v.OneShot) {
                    v.OneShot oneShot = (v.OneShot) type;
                    delayMs = oneShot.getDelayMs() + oneShot.getDurationMs();
                } else if (type instanceof v.Sequence) {
                    Iterator<T> it = ((v.Sequence) type).a().iterator();
                    delayMs = 0;
                    while (it.hasNext()) {
                        delayMs += ((v.Sequence.Segment) it.next()).getDurationMs();
                    }
                }
                if (elapsedMs >= delayMs) {
                    c5588g.f(true);
                    linkedHashSet.add(c5588g.getName());
                }
            }
        }
        return linkedHashSet;
    }
}
