package ca7;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Object, c> f22960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22962f;

    public g(String r100) {
        this.f22960d = new HashMap();
        this.f22961e = false;
        this.f22962f = false;
        this.f22959c = r100;
    }

    @Override // ca7.c
    public final void c(da7.b r100) {
        if (b(r100) == true) goto L5;
        return;
    L5:
        Object r101 = d(r100);
        if (this.f22961e == true) goto L8;
        c r102 = this.f22960d.get(r101);
        if (r102 == null) goto L27;
        r102.e(r100, this);
        r102.c(r100);
    L27:
        if ((r101 instanceof Boolean) == true) goto L29;
        super.c(r100);
        return;
    L29:
        if (((Boolean) r101).booleanValue() == false) goto L41;
        super.c(r100);
        return;
    L41:
        return;
    L8:
        if ((r101 instanceof Iterable) == false) goto L16;
        Iterator r103 = ((Iterable) r101).iterator();
    L11:
        if (r103.hasNext() == false) goto L27;
        Object r104 = r103.next();
        c r105 = this.f22960d.get(r104);
        if (r105 == null) goto L11;
        r105.e(r100, this);
        r105.c(r100);
        goto L11
    L16:
        if ((r101 instanceof Object[]) == false) goto L27;
        Object[] r106 = (Object[]) r101;
        int r107 = r106.length;
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L27;
        Object r109 = r106[r108];
        c r110 = this.f22960d.get(r109);
        if (r110 == null) goto L22;
        r110.e(r100, this);
        r110.c(r100);
    L22:
        r108 = r108 + 1;
        goto L18
    }

    @Override // ca7.c
    public final Object d(da7.b r100) {
        if (this.f22962f == false) goto L7;
        return r100.f467702f.getValue(this.f22959c);
    L7:
        return r100.f467697a.get(this.f22959c);
    }

    public final void g(Object r100, c r101) {
        this.f22960d.put(r100, r101);
    }
}
