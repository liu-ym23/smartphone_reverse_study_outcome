package com.bytedance.common.utility;

/* JADX INFO: compiled from: CommonHttpException.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6711a;

    public b(int r1, String r2) {
        super(r2);
        this.f6711a = r1;
    }

    public int a() {
        return this.f6711a;
    }
}
