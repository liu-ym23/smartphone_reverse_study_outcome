package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends l {
    public d(HashMap<String, Object> r100) {
        super(r100);
        m.d(r100, "stage");
        Double r101 = Double.valueOf(-1.0d);
        m.b(r100, "total_blocking_time", r101).doubleValue();
        m.b(r100, "total_blocking_count", r101).doubleValue();
        m.b(r100, "total_duration", r101).doubleValue();
        m.b(r100, "blocking_ratio", r101).doubleValue();
        m.b(r100, "avg_blocking_time", r101).doubleValue();
        m.b(r100, "time_after_fcp", r101).doubleValue();
    }
}
