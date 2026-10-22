package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes28.dex */
public final class o extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f25040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Header> f25042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f25043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25044g;

    public o(String r100) {
        this.f25039b = r100;
        this.f25042e = new ArrayList();
        this.f25043f = new HashMap();
        this.f25041d = "application/x-www-form-urlencoded";
    }

    public final String a() {
        return this.f25039b;
    }

    public final void a(String r100) {
        this.f25041d = r100;
    }

    public final void a(String r100, String r101) {
        if (this.f25043f != null) goto L5;
        this.f25043f = new HashMap();
    L5:
        this.f25043f.put(r100, r101);
    }

    public final void a(Header r100) {
        this.f25042e.add(r100);
    }

    public final void a(boolean r100) {
        this.f25044g = r100;
    }

    public final void a(byte[] r100) {
        this.f25040c = r100;
    }

    public final String b(String r100) {
        Map<String, String> r101 = this.f25043f;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final byte[] b() {
        return this.f25040c;
    }

    public final String c() {
        return this.f25041d;
    }

    public final ArrayList<Header> d() {
        return this.f25042e;
    }

    public final boolean e() {
        return this.f25044g;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (o.class == r100.getClass()) goto L11;
        return false;
    L11:
        o r101 = (o) r100;
        byte[] r102 = this.f25040c;
        if (r102 != null) goto L17;
        if (r101.f25040c == null) goto L19;
        return false;
    L19:
        String r103 = this.f25039b;
        String r104 = r101.f25039b;
        if (r103 != null) goto L24;
        if (r104 == null) goto L26;
        return false;
    L26:
        return true;
    L24:
        if (r103.equals(r104) == true) goto L26;
        return false;
    L17:
        if (r102.equals(r101.f25040c) == true) goto L19;
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f25043f;
        if (r100 != null) goto L5;
    L7:
        int r101 = 1;
    L8:
        int r102 = r101 * 31;
        String r103 = this.f25039b;
        if (r103 != null) goto L11;
        int r104 = 0;
    L13:
        return r102 + r104;
    L11:
        r104 = r103.hashCode();
        goto L13
    L5:
        if (r100.containsKey("id") == false) goto L7;
        r101 = this.f25043f.get("id").hashCode() + 31;
        goto L8
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", new Object[]{this.f25039b, this.f25042e});
    }
}
