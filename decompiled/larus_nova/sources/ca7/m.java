package ca7;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public abstract class m extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection<String> f22967c;

    public abstract boolean g(String r100, String r101);

    public m(Collection<String> r100) {
        this.f22967c = r100;
    }

    @Override // ca7.c
    public final boolean b(da7.b r100) {
        if (super.b(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.a(this).f467706b == false) goto L7;
        return true;
    }

    @Override // ca7.c
    public final void e(da7.b r100, c r101) {
        r100.a(this).f467705a = true;
        da7.c r102 = r100.a(this);
        String r103 = (String) r101.d(r100);     // Catch: Exception -> L10
        Iterator<String> r104 = this.f22967c.iterator();     // Catch: Exception -> L10
    L5:
        if (r104.hasNext() == false) goto L17;
        if (g(r103, r104.next()) == false) goto L5;
        r102.f467706b = true;     // Catch: Exception -> L10
        return;
    L17:
        return;
    }
}
