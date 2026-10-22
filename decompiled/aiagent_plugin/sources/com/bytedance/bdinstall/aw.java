package com.bytedance.bdinstall;

/* JADX INFO: compiled from: RangersHttpException.java */
/* JADX INFO: loaded from: classes.dex */
public class aw extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6155a;

    public aw(int r1, String r2) {
        super(r2);
        this.f6155a = r1;
    }

    public aw(int r1, Throwable r2) {
        super(r2);
        this.f6155a = r1;
    }

    public int a() {
        return this.f6155a;
    }
}
