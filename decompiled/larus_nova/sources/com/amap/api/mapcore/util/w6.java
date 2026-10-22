package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f28307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w5 f28308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private z6 f28310d;

    public w6() {
        this.f28309c = true;
        this.f28310d = new z6("40C27E38DCAD404B5465362914090908");
    }

    public void a(String r110, String r111) {
        List<w5> r100 = this.f28310d.a(this.f28307a);
        x6.a.f28336a.a(this.f28307a, r110, r111, r100, this.f28309c, this.f28308b);
    }

    public void a(Context r100, boolean r101, String r102, String r103, String r104, String[] r105) {
        w5 r106 = new w5.a(r102, r103, r102).a(r105).a(r104).a();     // Catch: k5 -> L6
        if (r100 == null) goto L9;
        Context r107 = r100.getApplicationContext();     // Catch: k5 -> L6
        this.f28307a = r107;     // Catch: k5 -> L6
        this.f28308b = r106;     // Catch: k5 -> L6
        this.f28309c = r101;     // Catch: k5 -> L6
        this.f28310d.a(r107, r106);     // Catch: k5 -> L6
        return;
    L9:
        return;
    }
}
