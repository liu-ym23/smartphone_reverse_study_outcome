package com.bytedance.vmsdk.a.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: WebSocketSession.java */
/* JADX INFO: loaded from: classes.dex */
class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f11707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f11708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f11710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f11711e;
    private final d f;
    private final k g;

    static /* synthetic */ void a(j r0, int r1, String r2) {
        r0.b(r1, r2);
    }

    static /* synthetic */ void a(j r0, a r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(j r0, IOException r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(j r0) {
        return r0.f11711e;
    }

    static /* synthetic */ f b(j r0) {
        return r0.f11709c;
    }

    public j(InputStream r3, OutputStream r4, f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.aiagent.plugin");
        this.f11710d = new AtomicBoolean(false);
        this.f = new AnonymousClass1(this);
        this.g = new AnonymousClass2(this);
        this.f11707a = new e(r3, r6);
        this.f11708b = new l(r4);
        this.f11709c = r6;
    }

    public void a() {
        c();
        this.f11707a.a(this.f);     // Catch: IOException -> L5 EOFException -> L8
    L12:
        return;
    L8:
        a(1011, "EOF while reading");
        return;
    L5:
        e = move-exception;
        a(1006, null);
        throw e;
    }

    @Override // com.bytedance.vmsdk.a.a.b.g
    public void a(String r1) {
        a(b.a(r1));
    }

    private void b(int r1, String r2) {
        a(b.a(r1, r2));
        b();
    }

    void b() {
        this.f11711e = true;
    }

    void c() {
        if (this.f11710d.getAndSet(true) == true) goto L6;
        this.f11709c.a(this);
        return;
    }

    void a(int r3, String r4) {
        if (this.f11710d.getAndSet(false) == false) goto L6;
        this.f11709c.a(this, r3, r4);
        return;
    }

    public boolean d() {
        return this.f11710d.get();
    }

    private void a(a r2) {
        if (e() == false) goto L5;
        return;
    L5:
        this.f11708b.a(r2, this.g);
    }

    private boolean e() {
        if (d() == true) goto L6;
        a(new IOException("Session is closed"));
        return true;
    L6:
        return false;
    }

    private void a(IOException r2) {
        this.f11709c.a(this, r2);
    }
}
