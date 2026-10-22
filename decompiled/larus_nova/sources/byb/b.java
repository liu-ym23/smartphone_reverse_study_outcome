package byb;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b implements d {
    public b() {
    }

    public static void b(HashMap r100, HashMap r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if ((!r101.isEmpty()) == false) goto L13;
        r102.putAll(r101);
        return;
    L13:
        return;
    L5:
        if ((!r100.isEmpty()) == false) goto L7;
        r102.putAll(r100);
        goto L7
    }

    @Override // byb.d
    public final void a(String r100, HashMap<String, Object> r101, HashMap<String, Object> r102) {
        b(r101, r102);
    }
}
