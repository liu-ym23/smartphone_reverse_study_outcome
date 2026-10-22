package c1;

import H4.o;
import b1.C0821b;
import d1.d;
import d1.f;
import d1.g;
import d1.h;
import d1.i;
import f1.C1431a;
import g1.AbstractC1451a;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2081a;
    public boolean b;
    public boolean c;
    public C1431a d;
    public K1.a e;
    public A8.b f;
    public C0821b g;
    public g h;
    public h i;

    /* renamed from: j, reason: collision with root package name */
    public i f2082j;
    public d k;
    public f l;

    public final void a(A8.b bVar) {
        if (this.f2081a && this.b) {
            this.f = bVar;
            C0821b c0821b = this.g;
            C1431a c1431a = this.d;
            bVar.H0(c0821b, c1431a == null || !c1431a.e);
            if (AbstractC1451a.f4467a) {
                o.r("APM-CPU", "change cpu exception detect state: " + this.f);
            }
        }
    }

    public final synchronized void b(boolean z10) {
        A8.b bVar = this.f;
        if (bVar != null && this.f2081a) {
            if (this.c == z10) {
                return;
            }
            this.c = z10;
            bVar.K0(z10);
        }
    }
}
