package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends n {
    public f(HashMap<String, Object> r110) {
        super(r110);
        Double r100 = Double.valueOf(-1.0d);
        m.b(r110, "loadBundleStart", r100).doubleValue();
        m.b(r110, "loadBundleEnd", r100).doubleValue();
        m.b(r110, "parseStart", r100).doubleValue();
        m.b(r110, "parseEnd", r100).doubleValue();
        m.b(r110, "loadBackgroundStart", r100).doubleValue();
        m.b(r110, "loadBackgroundEnd", r100).doubleValue();
        m.b(r110, "verifyTasmStart", r100).doubleValue();
        m.b(r110, "verifyTasmEnd", r100).doubleValue();
        m.b(r110, "ffiStart", r100).doubleValue();
        m.b(r110, "ffiEnd", r100).doubleValue();
        m.b(r110, "createLynxStart", r100).doubleValue();
        m.b(r110, "createLynxEnd", r100).doubleValue();
        m.b(r110, "loadCoreStart", r100).doubleValue();
        m.b(r110, "loadCoreEnd", r100).doubleValue();
        m.b(r110, "openTime", r100).doubleValue();
        m.b(r110, "containerInitStart", r100).doubleValue();
        m.b(r110, "containerInitEnd", r100).doubleValue();
        m.b(r110, "prepareTemplateStart", r100).doubleValue();
        m.b(r110, "prepareTemplateEnd", r100).doubleValue();
        if (r110.get("fcp") == null) goto L6;
        HashMap r101 = (HashMap) r110.get("fcp");
        m.d(r101, "name");
        m.b(r101, "duration", r100).doubleValue();
        m.d(r101, "startTimestampName");
        m.b(r101, "startTimestamp", r100).doubleValue();
        m.d(r101, "endTimestampName");
        m.b(r101, "endTimestamp", r100).doubleValue();
    L6:
        if (r110.get("lynxFcp") == null) goto L8;
        HashMap r102 = (HashMap) r110.get("lynxFcp");
    L9:
        m.d(r102, "name");
        m.b(r102, "duration", r100).doubleValue();
        m.d(r102, "startTimestampName");
        m.b(r102, "startTimestamp", r100).doubleValue();
        m.d(r102, "endTimestampName");
        m.b(r102, "endTimestamp", r100).doubleValue();
        if (r110.get("totalFcp") == null) goto L13;
        HashMap r111 = (HashMap) r110.get("totalFcp");
        m.d(r111, "name");
        m.b(r111, "duration", r100).doubleValue();
        m.d(r111, "startTimestampName");
        m.b(r111, "startTimestamp", r100).doubleValue();
        m.d(r111, "endTimestampName");
        m.b(r111, "endTimestamp", r100).doubleValue();
        return;
    L13:
        return;
    L8:
        r102 = new HashMap();
        goto L9
    }
}
