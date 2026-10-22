package com.fasterxml.jackson.b.a;

import com.fasterxml.jackson.a.d.e;
import com.fasterxml.jackson.a.f;
import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.CharArrayReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: YAMLFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends f {
    protected static final Charset q = null;
    protected static final int r = 0;
    protected static final int s = 0;
    protected int t;
    protected int u;
    protected final org.c.a.a.e v;
    protected final com.fasterxml.jackson.b.a.b.a w;

    @Override // com.fasterxml.jackson.a.f
    public boolean c() {
        return false;
    }

    @Override // com.fasterxml.jackson.a.f
    public String d() {
        return "YAML";
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ h a(Writer r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ h a(Writer r1, e r2) {
        return c(r1, r2);
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ k a(Reader r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ k a(Reader r1, e r2) {
        return c(r1, r2);
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ k a(String r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ k a(char[] r1, int r2, int r3, e r4, boolean r5) {
        return b(r1, r2, r3, r4, r5);
    }

    static {
        q = Charset.forName("UTF-8");
        r = d.a.a();
        s = c.a.a();
    }

    public b() {
        this((o) ZeusTransformUtils.preCheckCast(null, o.class, "com.obric.aiagent.plugin"));
    }

    public b(o r2) {
        super(r2);
        int r3 = r;
        this.t = r3;
        int r0 = s;
        this.u = r0;
        this.t = r3;
        this.u = r0;
        this.v = null;
        this.w = com.fasterxml.jackson.b.a.b.a.C0268a.a();
    }

    public d b(String r2) {
        return b(new StringReader(r2));
    }

    public d b(Reader r3) {
        e r0 = a(a(r3), false);
        return c(b(r3, r0), r0);
    }

    public c b(Writer r3) {
        e r0 = a(a(r3), false);
        return c(b(r3, r0), r0);
    }

    public d c(Reader r9, e r10) {
        return new d(r10, f(), this.h, this.t, this.j, r9);
    }

    public d b(char[] r8, int r9, int r10, e r11, boolean r12) {
        return new d(r11, f(), this.h, this.t, this.j, new CharArrayReader(r8, r9, r10));
    }

    public c c(Writer r10, e r11) {
        int r3 = this.u;
        return new c(r11, this.i, r3, this.w, this.j, r10, this.v);
    }
}
