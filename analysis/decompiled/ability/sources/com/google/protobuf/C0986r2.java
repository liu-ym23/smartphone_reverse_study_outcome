package com.google.protobuf;

import java.nio.charset.Charset;

/* renamed from: com.google.protobuf.r2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0986r2 implements InterfaceC0920b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0920b f2938a;
    public AbstractC0916a b;
    public AbstractC0924c c;
    public boolean d;

    public C0986r2(AbstractC0924c abstractC0924c, F1 f12, boolean z10) {
        Charset charset = AbstractC0989s1.f2940a;
        abstractC0924c.getClass();
        this.c = abstractC0924c;
        this.f2938a = f12;
        this.d = z10;
    }

    public final AbstractC0924c a() {
        this.d = true;
        return c();
    }

    public final AbstractC0916a b() {
        if (this.b == null) {
            AbstractC0916a abstractC0916aR = this.c.r(this);
            this.b = abstractC0916aR;
            abstractC0916aR.r(this.c);
            this.b.q();
        }
        return this.b;
    }

    public final AbstractC0924c c() {
        if (this.c == null) {
            this.c = this.b.m();
        }
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.protobuf.AbstractC0924c r3) {
        /*
            r2 = this;
            com.google.protobuf.a r0 = r2.b
            if (r0 != 0) goto Lf
            com.google.protobuf.c r0 = r2.c
            com.google.protobuf.c r1 = r0.getDefaultInstanceForType()
            if (r0 != r1) goto Lf
            r2.c = r3
            goto L16
        Lf:
            com.google.protobuf.a r0 = r2.b()
            r0.r(r3)
        L16:
            r2.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0986r2.d(com.google.protobuf.c):void");
    }

    public final void e() {
        InterfaceC0920b interfaceC0920b;
        if (this.b != null) {
            this.c = null;
        }
        if (!this.d || (interfaceC0920b = this.f2938a) == null) {
            return;
        }
        interfaceC0920b.h();
        this.d = false;
    }

    @Override // com.google.protobuf.InterfaceC0920b
    public final void h() {
        e();
    }
}
