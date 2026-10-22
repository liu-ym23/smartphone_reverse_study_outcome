package com.bytedance.retrofit2.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: TypedFile.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f9544b;

    @Override // com.bytedance.retrofit2.e.j
    public String d() {
        return null;
    }

    public h(String r2, File r3) {
        if (r2 != null) goto L5;
        r2 = "application/octet-stream";
    L5:
        Objects.requireNonNull(r3, "file");
        this.f9543a = r2;
        this.f9544b = r3;
    }

    @Override // com.bytedance.retrofit2.e.i
    public String b() {
        return this.f9543a;
    }

    @Override // com.bytedance.retrofit2.e.j
    public long c() {
        return this.f9544b.length();
    }

    @Override // com.bytedance.retrofit2.e.j
    public String a() {
        return this.f9544b.getName();
    }

    @Override // com.bytedance.retrofit2.e.i
    public InputStream e_() {
        return new FileInputStream(this.f9544b);
    }

    @Override // com.bytedance.retrofit2.e.j
    public void a(OutputStream r4) {
        byte[] r0 = new byte[4096];
        FileInputStream r1 = new FileInputStream(this.f9544b);
    L12:
        int r3 = r1.read(r0);     // Catch: Throwable -> L9
        if (r3 == (-1)) goto L7;
        r4.write(r0, 0, r3);     // Catch: Throwable -> L9
        goto L12
    L7:
        r1.close();
        return;
    L9:
        th = move-exception;
        r1.close();
        throw th;
    }

    public String toString() {
        return this.f9544b.getAbsolutePath() + " (" + b() + ")";
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L10;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        return this.f9544b.equals(r4.f9544b);
    L10:
        return false;
    }

    public int hashCode() {
        return this.f9544b.hashCode();
    }
}
