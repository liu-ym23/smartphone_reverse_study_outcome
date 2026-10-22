package com.bytedance.crash.dumper.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: JavaStringDumperImpl.java */
/* JADX INFO: loaded from: classes.dex */
class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileOutputStream f7391a;

    public static e b(String r1) {
        return new e(r1);
    }

    private e(String r3) {
        FileOutputStream r0 = new FileOutputStream(new File(r3));     // Catch: IOException -> L5
    L6:
        this.f7391a = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a(char[] r1, int r2) {
        a(new StringBuilder().append(r1).toString());
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a(String r1) {
        FileOutputStream r0 = this.f7391a;
        if (r0 == null) goto L9;
        r0.write(r1.getBytes());     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a(int r1) {
        a(Integer.toString(r1));
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a(long r1) {
        a(Long.toString(r1));
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a() {
        FileOutputStream r0 = this.f7391a;
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void b() {
        FileOutputStream r0 = this.f7391a;
        if (r0 == null) goto L9;
        r0.flush();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }
}
