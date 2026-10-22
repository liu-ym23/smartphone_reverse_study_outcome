package w3;

import android.content.Context;
import r3.AbstractC5211e;
import r3.C5214h;
import t3.C5506b;
import z2.B8;
import z2.N8;

/* renamed from: w3.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5731h extends AbstractC5211e {

    /* renamed from: b, reason: collision with root package name */
    public final C5214h f43072b;

    public C5731h(C5214h c5214h) {
        this.f43072b = c5214h;
    }

    @Override // r3.AbstractC5211e
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        C5506b c5506b = (C5506b) obj;
        Context contextB = this.f43072b.b();
        B8 b8B = N8.b(C5725b.d());
        return new k(this.f43072b, c5506b, (n.b(contextB) || com.google.android.gms.common.c.f().a(contextB) >= 204500000) ? new n(contextB, c5506b, b8B) : new p(contextB, c5506b, b8B), b8B);
    }
}
