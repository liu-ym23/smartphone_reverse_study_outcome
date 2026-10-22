package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class j extends l {
    public j(HashMap<String, Object> r110) {
        super(r110);
        Object r100 = r110.get("fcp");
        Double r101 = Double.valueOf(-1.0d);
        if (r100 == null) goto L5;
        HashMap r102 = (HashMap) r110.get("fcp");
    L6:
        m.d(r102, "name");
        m.b(r102, "duration", r101).doubleValue();
        m.d(r102, "startTimestampName");
        m.b(r102, "startTimestamp", r101).doubleValue();
        m.d(r102, "endTimestampName");
        m.b(r102, "endTimestamp", r101).doubleValue();
        if (r110.get("lynxFcp") == null) goto L9;
        HashMap r103 = (HashMap) r110.get("lynxFcp");
    L10:
        m.d(r103, "name");
        m.b(r103, "duration", r101).doubleValue();
        m.d(r103, "startTimestampName");
        m.b(r103, "startTimestamp", r101).doubleValue();
        m.d(r103, "endTimestampName");
        m.b(r103, "endTimestamp", r101).doubleValue();
        if (r110.get("totalFcp") == null) goto L13;
        HashMap r111 = (HashMap) r110.get("totalFcp");
    L14:
        m.d(r111, "name");
        m.b(r111, "duration", r101).doubleValue();
        m.d(r111, "startTimestampName");
        m.b(r111, "startTimestamp", r101).doubleValue();
        m.d(r111, "endTimestampName");
        m.b(r111, "endTimestamp", r101).doubleValue();
        return;
    L13:
        r111 = new HashMap();
        goto L14
    L9:
        r103 = new HashMap();
        goto L10
    L5:
        r102 = new HashMap();
        goto L6
    }
}
