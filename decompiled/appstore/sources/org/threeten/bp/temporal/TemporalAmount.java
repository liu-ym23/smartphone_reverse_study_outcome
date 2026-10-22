package org.threeten.bp.temporal;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface TemporalAmount {
    Temporal addTo(Temporal r10);

    long get(TemporalUnit r10);

    List<TemporalUnit> getUnits();

    Temporal subtractFrom(Temporal r10);
}
