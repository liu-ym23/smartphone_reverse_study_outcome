package c86;

import android.content.Context;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d86.c f22733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22737e;

    public final String a() {
        boolean[] r100 = this.f22733a.f467427n;
        if (r100 == null) goto L22;
        if (r100.length != 3) goto L22;
        boolean r101 = r100[0];
        boolean r102 = r100[1];
        boolean r103 = r100[2];
        StringBuilder r104 = new StringBuilder();
        if (r101 == false) goto L13;
        r104.append("HH");
        if (r102 == true) goto L12;
        if (r103 == false) goto L13;
    L12:
        r104.append(this.f22734b);
    L13:
        if (r102 == false) goto L17;
        r104.append("mm");
        if (r103 == false) goto L17;
        r104.append(this.f22734b);
    L17:
        if (r103 == false) goto L20;
        r104.append("ss");
    L20:
        return r104.toString();
    L22:
        return "HH" + this.f22734b + "mm";
    }

    public final d86.a b() {
        return this.f22733a;
    }

    public c(Context r100) {
        this.f22734b = ":";
        d86.c r101 = new d86.c();
        this.f22733a = r101;
        r101.f467411c = r100;
    }
}
