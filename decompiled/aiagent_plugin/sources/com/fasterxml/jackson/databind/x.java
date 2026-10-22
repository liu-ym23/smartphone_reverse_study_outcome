package com.fasterxml.jackson.databind;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: PropertyName.java */
/* JADX INFO: loaded from: classes2.dex */
public class x implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f13132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f13133b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f13134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f13135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.fasterxml.jackson.a.q f13136e;

    static {
        f13132a = new x("", null);
        f13133b = new x(new String(""), null);
    }

    public x(String r2) {
        this(r2, null);
    }

    public x(String r1, String r2) {
        this.f13134c = com.fasterxml.jackson.databind.l.h.a(r1);
        this.f13135d = r2;
    }

    public static x a(String r2) {
        if (r2 == null) goto L9;
        if (r2.isEmpty() == true) goto L9;
        return new x(com.fasterxml.jackson.a.h.g.f12107a.a(r2), null);
    L9:
        return f13132a;
    }

    public static x a(String r2, String r3) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        if (r3 != null) goto L10;
        if (r2.isEmpty() == false) goto L10;
        return f13132a;
    L10:
        return new x(com.fasterxml.jackson.a.h.g.f12107a.a(r2), r3);
    }

    public x a() {
        if (this.f13134c.isEmpty() == false) goto L5;
        return this;
    L5:
        String r0 = com.fasterxml.jackson.a.h.g.f12107a.a(this.f13134c);
        if (r0 != this.f13134c) goto L9;
        return this;
    L9:
        return new x(r0, this.f13135d);
    }

    public x b(String r2) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (r2.equals(this.f13134c) == false) goto L8;
        return this;
    L8:
        return new x(r2, this.f13135d);
    }

    public String b() {
        return this.f13134c;
    }

    public com.fasterxml.jackson.a.q a(com.fasterxml.jackson.databind.a.m<?> r2) {
        com.fasterxml.jackson.a.q r0 = this.f13136e;
        if (r0 != null) goto L9;
        if (r2 != null) goto L6;
        com.fasterxml.jackson.a.q r3 = new com.fasterxml.jackson.a.d.m(this.f13134c);
    L7:
        com.fasterxml.jackson.a.q r1 = r3;
        this.f13136e = r1;
        return r1;
    L6:
        r3 = r2.a(this.f13134c);
        goto L7
    L9:
        return r0;
    }

    public boolean c() {
        return !this.f13134c.isEmpty();
    }

    public boolean c(String r1) {
        return this.f13134c.equals(r1);
    }

    public boolean d() {
        if (this.f13135d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f13135d == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f13134c.isEmpty() == false) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getClass() == getClass()) goto L11;
        return false;
    L11:
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        String r2 = this.f13134c;
        if (r2 != null) goto L17;
        if (r6.f13134c == null) goto L19;
        return false;
    L19:
        String r4 = this.f13135d;
        if (r4 != null) goto L27;
        if (r6.f13135d != null) goto L25;
        return true;
    L25:
        return false;
    L27:
        return r4.equals(r6.f13135d);
    L17:
        if (r2.equals(r6.f13134c) == true) goto L19;
        return false;
    }

    public int hashCode() {
        String r0 = this.f13135d;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
        return this.f13134c.hashCode() ^ r1;
    L5:
        return this.f13134c.hashCode();
    }

    public String toString() {
        if (this.f13135d != null) goto L7;
        return this.f13134c;
    L7:
        return "{" + this.f13135d + "}" + this.f13134c;
    }
}
