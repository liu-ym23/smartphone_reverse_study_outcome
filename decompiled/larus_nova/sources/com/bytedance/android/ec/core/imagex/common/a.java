package com.bytedance.android.ec.core.imagex.common;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f44633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f44635d;

    @Override // com.bytedance.android.ec.core.imagex.common.h
    public final void c() {
        this.f44634c = 0;
        this.f44635d = 0;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.h
    public final boolean b() {
        if (this.f44635d <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        char[] r100 = this.f44633b;
        int r101 = this.f44634c;
        return new String(r100, r101, this.f44635d - r101);
    }

    public a(int r100) {
        super(r100);
        this.f44633b = new char[r100];
    }

    @Override // com.bytedance.android.ec.core.imagex.common.h
    public final void a(char r100) {
        int r101 = this.f44635d;
        char[] r102 = this.f44633b;
        if (r101 < r102.length) goto L5;
        char[] r103 = new char[r102.length + (this.f44652a * 2)];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        this.f44633b = r103;
    L5:
        char[] r104 = this.f44633b;
        int r105 = this.f44635d;
        this.f44635d = r105 + 1;
        r104[r105] = r100;
    }
}
