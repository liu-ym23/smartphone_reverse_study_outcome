package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends l {
    public k(HashMap<String, Object> r110) {
        super(r110);
        Object r100 = r110.get("fsp");
        Double r101 = Double.valueOf(-1.0d);
        if (r100 == null) goto L5;
        HashMap r102 = (HashMap) r110.get("fsp");
    L6:
        m.d(r102, "name");
        m.b(r102, "duration", r101).doubleValue();
        m.d(r102, "startTimestampName");
        m.b(r102, "startTimestamp", r101).doubleValue();
        m.d(r102, "endTimestampName");
        m.b(r102, "endTimestamp", r101).doubleValue();
        if (r110.get("lynxFsp") == null) goto L9;
        HashMap r103 = (HashMap) r110.get("lynxFsp");
    L10:
        m.d(r103, "name");
        m.b(r103, "duration", r101).doubleValue();
        m.d(r103, "startTimestampName");
        m.b(r103, "startTimestamp", r101).doubleValue();
        m.d(r103, "endTimestampName");
        m.b(r103, "endTimestamp", r101).doubleValue();
        if (r110.get("totalFsp") == null) goto L13;
        HashMap r104 = (HashMap) r110.get("totalFsp");
    L14:
        m.d(r104, "name");
        m.b(r104, "duration", r101).doubleValue();
        m.d(r104, "startTimestampName");
        m.b(r104, "startTimestamp", r101).doubleValue();
        m.d(r104, "endTimestampName");
        m.b(r104, "endTimestamp", r101).doubleValue();
        m.d(r110, "fspStatus");
        m.b(r110, "contentFillPercentageX", r101).doubleValue();
        m.b(r110, "contentFillPercentageY", r101).doubleValue();
        m.b(r110, "contentFillPercentageTotalArea", r101).doubleValue();
        m.b(r110, "containerFillPercentageContainerArea", r101).doubleValue();
        return;
    L13:
        r104 = new HashMap();
        goto L14
    L9:
        r103 = new HashMap();
        goto L10
    L5:
        r102 = new HashMap();
        goto L6
    }
}
