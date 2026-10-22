package ca7;

import java.util.Collection;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22963c;

    public h(String r100) {
        this.f22963c = r100;
    }

    @Override // ca7.c
    public final boolean b(da7.b r100) {
        da7.c r101 = r100.a(this);
        if (super.b(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.f467706b == false) goto L7;
        return true;
    }

    @Override // ca7.c
    public final Object d(da7.b r100) {
        return r100.f467697a.get(this.f22963c);
    }

    @Override // ca7.c
    public final void e(da7.b r100, c r101) {
        r100.a(this).f467705a = true;
        da7.c r102 = r100.a(this);
        String r103 = (String) r101.d(r100);     // Catch: Exception -> L16
        Object r104 = r100.f467697a.get(this.f22963c);     // Catch: Exception -> L16
        if ((r104 instanceof Collection) == false) goto L9;
        if (((Collection) r104).contains(r103) == false) goto L22;
        r102.f467706b = true;     // Catch: Exception -> L16
        return;
    L22:
        return;
    L9:
        if ((r104 instanceof Object[]) == false) goto L24;
        Object[] r105 = (Object[]) r104;     // Catch: Exception -> L16
        int r106 = r105.length;     // Catch: Exception -> L16
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L25;
        if (r105[r107].equals(r103) == false) goto L15;
        r102.f467706b = true;     // Catch: Exception -> L16
    L15:
        r107 = r107 + 1;
        goto L11
    L25:
        return;
    L24:
        return;
    L16:
        r102.f467706b = false;
    }
}
