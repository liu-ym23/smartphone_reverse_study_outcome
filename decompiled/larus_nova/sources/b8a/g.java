package b8a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f18210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, h> f18211f;

    public g(HashMap<String, Object> r100) {
        super(r100);
        this.f18210e = m.c(r100, -1L).longValue();
        if (r100.get("detail") == null) goto L5;
        HashMap r101 = (HashMap) r100.get("detail");
    L6:
        this.f18211f = new HashMap();
        Iterator r102 = r101.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        HashMap<String, h> r104 = this.f18211f;
        Object r105 = r103.getKey();
        String r106 = (String) r105;
        r104.put(r106, new h((HashMap) r103.getValue()));
        goto L8
    L10:
        return;
    L5:
        r101 = new HashMap();
        goto L6
    }
}
