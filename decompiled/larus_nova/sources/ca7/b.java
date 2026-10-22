package ca7;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<c> f22955c;

    public b() {
        new ArrayList();
        this.f22955c = new HashSet();
    }

    @Override // ca7.c
    public final boolean b(da7.b r100) {
        da7.c r101 = r100.a(this);
        if (super.b(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.f467707c.size() != 0) goto L7;
        return true;
    }

    @Override // ca7.c
    public final Object d(da7.b r100) {
        return Boolean.TRUE;
    }

    @Override // ca7.c
    public final void e(da7.b r100, c r101) {
        da7.c r102 = r100.a(this);
        r102.f467705a = true;
        r102.f467707c.remove(r101);
    }
}
