package c50;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f22453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<c> f22454d;

    public final void b() {
        this.f22454d.size();
    }

    public final c a(Runnable r100) {
        c r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<c> r102 = this.f22454d.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        c r103 = r102.next();
        if (r103 == null) goto L7;
        if (r103.f22447a != r100) goto L7;
        r101 = r103;
    L13:
        if (r101 == null) goto L15;
        this.f22454d.remove(r101);
    L15:
        return r101;
    }

    public d(String r100, int r101, e.a r102) {
        this.f22451a = null;
        this.f22452b = -1;
        this.f22454d = new ArrayList(32);
        this.f22451a = r100;
        this.f22452b = r101;
        this.f22453c = r102;
    }
}
