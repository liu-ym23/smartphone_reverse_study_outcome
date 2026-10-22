package ig;

import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends c implements Temporal {
    public b() {
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(TemporalAmount r10) {
        return r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal plus(TemporalAmount r10) {
        return r10.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster r10) {
        return r10.adjustInto(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.threeten.bp.temporal.Temporal] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        long r12 = 1;
        ?? r13 = plus(Long.MAX_VALUE, r11);
    L7:
        return r13.plus(r12, r11);
    L6:
        r12 = -r10;
        this = this;
        goto L7
    }
}
