package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f18213b;

    public h(HashMap<String, Object> r100) {
        m.d(r100, "category");
        this.f18212a = m.c(r100, -1L).longValue();
        if (r100.get("detail") == null) goto L5;
        HashMap<String, String> r101 = (HashMap) r100.get("detail");
    L6:
        this.f18213b = r101;
        return;
    L5:
        r101 = new HashMap();
        goto L6
    }
}
