package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends l {
    public b(HashMap<String, Object> r100) {
        super(r100);
        Double r101 = Double.valueOf(-1.0d);
        m.b(r100, "openTime", r101).doubleValue();
        m.b(r100, "containerInitStart", r101).doubleValue();
        m.b(r100, "containerInitEnd", r101).doubleValue();
        m.b(r100, "prepareTemplateStart", r101).doubleValue();
        m.b(r100, "prepareTemplateEnd", r101).doubleValue();
        if (r100.get("extraTiming") == null) goto L5;
        HashMap r102 = (HashMap) r100.get("extraTiming");
        return;
    L5:
        new HashMap();
    }
}
