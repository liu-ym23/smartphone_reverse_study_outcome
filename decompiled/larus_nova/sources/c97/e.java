package c97;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<h> f22872b;

    public e() {
    }

    public final String a() {
        if (this.f22871a != null) goto L6;
        this.f22871a = "";
    L6:
        return this.f22871a;
    }

    public final Set<h> b() {
        if (this.f22872b != null) goto L6;
        this.f22872b = new HashSet();
    L6:
        return this.f22872b;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("hostAppVersion=");
        r100.append(a());
        r100.append("\n");
        Iterator<h> r101 = b().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next().toString());
        r100.append("\n");
        goto L4
    L7:
        return r100.toString();
    }
}
