package com.bytedance.watson.assist.c;

import java.io.File;

/* JADX INFO: compiled from: BaseStatFile.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f11851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f11853c;

    public b a(File r1) {
        return null;
    }

    public a(String r2) {
        this.f11851a = null;
        this.f11852b = null;
        this.f11853c = null;
        this.f11852b = r2;
    }

    public b a() {
        if (this.f11852b != null) goto L7;
        com.bytedance.watson.assist.d.b.c("refresh and path null");
        return null;
    L7:
        if (this.f11853c != null) goto L9;
        this.f11853c = new File(this.f11852b);
    L9:
        b r0 = a(this.f11853c);
        this.f11851a = r0;
        return r0;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.f11852b + "', mFile=" + this.f11853c + ", mLastInfo=" + this.f11851a + '}';
    }
}
