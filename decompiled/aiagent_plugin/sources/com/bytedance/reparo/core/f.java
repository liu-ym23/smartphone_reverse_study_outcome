package com.bytedance.reparo.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PatchConfigCell.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f9202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Constructor> f9204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Method> f9205d;

    public f(Class r1, String r2) {
        this.f9202a = r1;
        this.f9203b = r2;
    }

    public void a(Constructor r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.f9204c != null) goto L6;
        this.f9204c = new ArrayList();
    L6:
        this.f9204c.add(r2);
    }

    public void a(Method r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.f9205d != null) goto L6;
        this.f9205d = new ArrayList();
    L6:
        this.f9205d.add(r2);
    }

    public String a() {
        return this.f9203b;
    }

    public List<Constructor> b() {
        return this.f9204c;
    }

    public List<Method> c() {
        return this.f9205d;
    }
}
