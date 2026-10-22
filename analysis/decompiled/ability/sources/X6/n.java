package X6;

import F9.x;
import F9.y;
import a.AbstractC0291a;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public String f1517a;
    public String b;
    public String c;
    public String d;
    public int e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f1518j;
    public transient InputStream k;
    public int l;
    public HashMap m;
    public HashMap n;
    public byte[] o;

    public final y a() {
        x xVar = new x(0);
        HashMap map = this.n;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                xVar.a((String) entry.getKey(), a7.f.g((String) entry.getValue(), true));
            }
        }
        String pathSegment = this.d;
        if (AbstractC0291a.y(pathSegment) && AbstractC0291a.y("/") && pathSegment.startsWith("/")) {
            pathSegment = pathSegment.substring(1);
        }
        xVar.m(this.f1517a);
        xVar.h(this.c);
        kotlin.jvm.internal.k.f(pathSegment, "pathSegment");
        xVar.l(pathSegment, 0, pathSegment.length(), false, false);
        int i = this.e;
        if (i != 0) {
            xVar.k(i);
        }
        return xVar.d();
    }
}
