package com.autonavi.aps.protocol.aps.response.model.vo.fields;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f19149a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f19150b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f19151c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f19152d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f19153e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f19154f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f19155g = null;

    /* renamed from: h, reason: collision with root package name */
    private d f19156h = null;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<a> f19157i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f19158j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f19159k = null;

    /* renamed from: l, reason: collision with root package name */
    private String f19160l = null;

    public String a() {
        return this.f19149a;
    }

    public String b() {
        return this.f19150b;
    }

    public String c() {
        return this.f19152d;
    }

    public String d() {
        return this.f19154f;
    }

    public String e() {
        return this.f19153e;
    }

    public String f() {
        return this.f19151c;
    }

    public String g() {
        return this.f19155g;
    }

    public d h() {
        return this.f19156h;
    }

    public ArrayList<a> i() {
        return this.f19157i;
    }

    public String j() {
        return this.f19158j;
    }

    public String k() {
        return this.f19159k;
    }

    public String l() {
        return this.f19160l;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f19149a);
        sb2.append(',');
        sb2.append(this.f19150b);
        sb2.append(',');
        sb2.append(this.f19151c);
        sb2.append(',');
        sb2.append((String) null);
        sb2.append(',');
        sb2.append(this.f19152d);
        sb2.append(',');
        sb2.append(this.f19153e);
        sb2.append(',');
        sb2.append(this.f19154f);
        sb2.append(',');
        sb2.append(this.f19155g);
        sb2.append(',');
        sb2.append((String) null);
        sb2.append(',');
        sb2.append(this.f19158j);
        sb2.append(',');
        sb2.append(this.f19159k);
        sb2.append(',');
        sb2.append(this.f19160l);
        sb2.append(',');
        d dVar = this.f19156h;
        sb2.append(dVar == null ? "" : dVar.toString());
        sb2.append(',');
        ArrayList<a> arrayList = this.f19157i;
        if (arrayList == null) {
            sb2.append("null");
        } else {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().toString());
                sb2.append(',');
            }
        }
        return sb2.toString();
    }

    public void a(String str) {
        if (str == null) {
            str = "";
        }
        this.f19149a = str;
    }

    public void b(String str) {
        if (str == null) {
            str = "";
        }
        this.f19150b = str;
    }

    public void c(String str) {
        if (str == null) {
            str = "";
        }
        this.f19152d = str;
    }

    public void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f19154f = str;
    }

    public void e(String str) {
        if (str == null) {
            str = "";
        }
        this.f19153e = str;
    }

    public void f(String str) {
        if (str == null) {
            str = "";
        }
        this.f19151c = str;
    }

    public void g(String str) {
        if (str == null) {
            str = "";
        }
        this.f19155g = str;
    }

    public void h(String str) {
        if (str == null) {
            str = "";
        }
        this.f19158j = str;
    }

    public void i(String str) {
        this.f19159k = str;
    }

    public void j(String str) {
        this.f19160l = str;
    }

    public void a(d dVar) {
        this.f19156h = dVar;
    }

    public void a(ArrayList<a> arrayList) {
        this.f19157i = arrayList;
    }
}
