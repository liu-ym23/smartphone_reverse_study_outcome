package com.bytedance.crash.dumper.a;

import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: compiled from: NativeStringDumperImpl.java */
/* JADX INFO: loaded from: classes.dex */
class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f7392a;

    g(long r1) {
        this.f7392a = r1;
    }

    static g a(String r2, int r3) {
        long r4 = NativeBridge.a(r2, r3);
        if (r4 != 0) goto L5;
        return null;
    L5:
        return new g(r4);
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void b() {
        NativeBridge.f(this.f7392a);
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a() {
        NativeBridge.e(this.f7392a);
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
    public void a(String r3) {
        NativeBridge.a(this.f7392a, r3, r3.length());
    }

    @Override // com.bytedance.crash.dumper.a.d
    public void a(char[] r3, int r4) {
        NativeBridge.a(this.f7392a, r3, r4);
    }
}
