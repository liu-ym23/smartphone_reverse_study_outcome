package c86;

import android.content.Context;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d86.c f22728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22732e;

    public final String a() {
        boolean[] r100 = this.f22728a.f467426m;
        if (r100 == null) goto L22;
        if (r100.length != 3) goto L22;
        boolean r101 = r100[0];
        boolean r102 = r100[1];
        boolean r103 = r100[2];
        StringBuilder r104 = new StringBuilder();
        if (r101 == false) goto L13;
        r104.append("yyyy");
        if (r102 == true) goto L12;
        if (r103 == false) goto L13;
    L12:
        r104.append(this.f22729b);
    L13:
        if (r102 == false) goto L17;
        r104.append("MM");
        if (r103 == false) goto L17;
        r104.append(this.f22729b);
    L17:
        if (r103 == false) goto L20;
        r104.append("dd");
    L20:
        return r104.toString();
    L22:
        return "yyyy" + this.f22729b + "MM" + this.f22729b + "dd";
    }

    public final d86.a b() {
        return this.f22728a;
    }

    public b(Context r100) {
        this.f22729b = "-";
        d86.c r101 = new d86.c();
        this.f22728a = r101;
        r101.f467411c = r100;
    }
}
