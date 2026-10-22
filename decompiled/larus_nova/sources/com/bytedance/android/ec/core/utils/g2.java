package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f45600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f45602c;

    public final String b() {
        if (((ArrayList) this.f45600a).isEmpty() == true) goto L5;
        String r100 = e2.b(this.f45600a, this.f45602c);
        String r101 = this.f45601b;
        if (r101 != null) goto L9;
        return r100;
    L9:
        if (r101.length() == 0) goto L22;
        int r102 = this.f45601b.indexOf(63);
        if (r102 < 0) goto L20;
        if (this.f45601b.indexOf(61, r102) <= 0) goto L18;
        int r103 = r102 + 1;
        return this.f45601b.substring(0, r103) + r100 + "&" + this.f45601b.substring(r103);
    L18:
        return this.f45601b + "&" + r100;
    L20:
        return this.f45601b + "?" + r100;
    L22:
        return r100;
    L5:
        return this.f45601b;
    }

    public final String toString() {
        return b();
    }

    public g2(String r100) {
        this.f45600a = new ArrayList();
        this.f45602c = "UTF-8";
        this.f45601b = r100;
    }

    public final void a(String r100, String r101) {
        List<i> r102 = this.f45600a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new i(r100, r101));
    }
}
