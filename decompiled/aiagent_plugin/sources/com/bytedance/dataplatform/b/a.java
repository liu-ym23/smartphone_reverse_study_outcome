package com.bytedance.dataplatform.b;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ClientDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f7911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b<T>[] f7912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f7914e;
    private List<Pair<String, Float>> f;

    public a(String r4, double r5, String r7, String[] r8, b<T>... r9) {
        this.f = new ArrayList();
        this.f7910a = r4;
        this.f7911b = r5;
        this.f7913d = r7;
        this.f7914e = r8;
        this.f7912c = r9;
        int r6 = r9.length;
        int r10 = 0;
    L3:
        if (r10 >= r6) goto L5;
        b<T> r11 = r9[r10];
        this.f.add(new Pair(r11.a(), Double.valueOf(r11.b())));
        r10 = r10 + 1;
        goto L3
    }

    public String a() {
        return this.f7910a;
    }

    public List<Pair<String, Float>> b() {
        return this.f;
    }

    public double c() {
        return this.f7911b;
    }

    public b<T>[] d() {
        return this.f7912c;
    }

    public String e() {
        return this.f7913d;
    }

    public String[] f() {
        return this.f7914e;
    }
}
