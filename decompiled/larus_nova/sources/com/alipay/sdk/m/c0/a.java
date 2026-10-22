package com.alipay.sdk.m.c0;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f25260g;

    public a(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.f25254a = r100;
        this.f25255b = r101;
        this.f25256c = r102;
        this.f25257d = r103;
        this.f25258e = r104;
        this.f25259f = r105;
        this.f25260g = r106;
    }

    public final String toString() {
        StringBuffer r100 = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        r100.append("," + this.f25254a);
        r100.append("," + this.f25255b);
        r100.append("," + this.f25256c);
        r100.append("," + this.f25257d);
        if (com.alipay.sdk.m.z.a.a(this.f25258e) == false) goto L5;
    L8:
        StringBuilder r101 = new StringBuilder(",");
        String r102 = this.f25258e;
    L9:
        r101.append(r102);
        r100.append(r101.toString());
        if (com.alipay.sdk.m.z.a.a(this.f25259f) == false) goto L12;
    L15:
        StringBuilder r103 = new StringBuilder(",");
        String r104 = this.f25259f;
    L16:
        r103.append(r104);
        r100.append(r103.toString());
        if (com.alipay.sdk.m.z.a.a(this.f25260g) == false) goto L19;
    L22:
        StringBuilder r105 = new StringBuilder(",");
        String r106 = this.f25260g;
    L23:
        r105.append(r106);
        r100.append(r105.toString());
        return r100.toString();
    L19:
        if (this.f25260g.length() < 20) goto L22;
        r105 = new StringBuilder(",");
        r106 = this.f25260g.substring(0, 20);
        goto L23
    L12:
        if (this.f25259f.length() < 20) goto L15;
        r103 = new StringBuilder(",");
        r104 = this.f25259f.substring(0, 20);
        goto L16
    L5:
        if (this.f25258e.length() < 20) goto L8;
        r101 = new StringBuilder(",");
        r102 = this.f25258e.substring(0, 20);
        goto L9
    }
}
