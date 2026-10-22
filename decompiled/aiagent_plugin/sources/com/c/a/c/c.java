package com.c.a.c;

import java.util.HashMap;

/* JADX INFO: compiled from: ConsumerResult.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f11900c;

    private c(boolean r1, String r2, HashMap<String, String> r3) {
        this.f11898a = r1;
        this.f11899b = r2;
        this.f11900c = r3;
    }

    public boolean a() {
        return this.f11898a;
    }

    public String b() {
        return this.f11899b;
    }

    public HashMap<String, String> c() {
        return this.f11900c;
    }

    public static c a(boolean r1, String r2, HashMap<String, String> r3) {
        return new c(r1, r2, r3);
    }
}
