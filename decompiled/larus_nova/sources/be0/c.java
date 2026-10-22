package be0;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, a> f18721a;

    public c() {
        this.f18721a = new LinkedHashMap();
    }

    public final a a(int r100) {
        Map<Integer, a> r101 = this.f18721a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        a r103 = (a) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L5;
    L24:
        return r103;
    L5:
        if (r100 != 1) goto L7;
        r103 = new b();
    L23:
        this.f18721a.put(Integer.valueOf(r100), r103);
        goto L24
    L7:
        if (r100 != 2) goto L9;
        r103 = new e();
        goto L23
    L9:
        if (r100 != 3) goto L11;
        r103 = new g();
        goto L23
    L11:
        if (r100 != 4) goto L13;
        r103 = new f();
        goto L23
    L13:
        if (r100 != 5) goto L15;
        r103 = new e();
        goto L23
    L15:
        if (r100 == 100) goto L17;
        r103 = new e();
        goto L23
    L17:
        r103 = new d();
        goto L23
    }
}
