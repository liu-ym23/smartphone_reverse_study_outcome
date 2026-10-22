package com.fasterxml.jackson.a.e;

import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.k;
import java.util.HashSet;

/* JADX INFO: compiled from: DupDetector.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f12020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f12021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f12022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected HashSet<String> f12023d;

    private a(Object r1) {
        this.f12020a = r1;
    }

    public static a a(k r1) {
        return new a(r1);
    }

    public static a a(h r1) {
        return new a(r1);
    }

    public a a() {
        return new a(this.f12020a);
    }

    public void b() {
        this.f12021b = null;
        this.f12022c = null;
        this.f12023d = null;
    }

    public Object c() {
        return this.f12020a;
    }

    public boolean a(String r4) {
        String r0 = this.f12021b;
        if (r0 != null) goto L7;
        this.f12021b = r4;
        return false;
    L7:
        if (r4.equals(r0) == false) goto L9;
        return true;
    L9:
        String r1 = this.f12022c;
        if (r1 != null) goto L14;
        this.f12022c = r4;
        return false;
    L14:
        if (r4.equals(r1) == false) goto L17;
        return true;
    L17:
        if (this.f12023d != null) goto L20;
        HashSet<String> r2 = new HashSet(16);
        this.f12023d = r2;
        r2.add(this.f12021b);
        this.f12023d.add(this.f12022c);
    L20:
        return !this.f12023d.add(r4);
    }
}
