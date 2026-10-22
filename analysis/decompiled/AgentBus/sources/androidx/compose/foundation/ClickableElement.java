package androidx.compose.foundation;

import i1.w0;
import kotlin.Metadata;
import m.x;
import n0.l;
import o.m0;
import o.r;
import q.i;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ClickableElement;", "Li1/w0;", "Lo/r;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ClickableElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final i f709a;

    /* renamed from: b, reason: collision with root package name */
    public final m0 f710b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f711c;

    /* renamed from: d, reason: collision with root package name */
    public final p7.a f712d;

    public ClickableElement(i iVar, m0 m0Var, boolean z4, p7.a aVar) {
        this.f709a = iVar;
        this.f710b = m0Var;
        this.f711c = z4;
        this.f712d = aVar;
    }

    @Override // i1.w0
    public final l d() {
        return new r(this.f709a, this.f710b, this.f711c, this.f712d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClickableElement.class != obj.getClass()) {
            return false;
        }
        ClickableElement clickableElement = (ClickableElement) obj;
        return k.a(this.f709a, clickableElement.f709a) && k.a(this.f710b, clickableElement.f710b) && this.f711c == clickableElement.f711c && this.f712d == clickableElement.f712d;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    @Override // i1.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(n0.l r8) {
        /*
            r7 = this;
            o.r r8 = (o.r) r8
            o.z r0 = r8.f7122z
            o.b0 r1 = r8.A
            q.i r2 = r8.H
            q.i r3 = r7.f709a
            boolean r2 = q7.k.a(r2, r3)
            r4 = 1
            r5 = 0
            if (r2 != 0) goto L1b
            r8.o0()
            r8.H = r3
            r8.f7118v = r3
            r2 = r4
            goto L1c
        L1b:
            r2 = r5
        L1c:
            o.m0 r3 = r8.f7119w
            o.m0 r6 = r7.f710b
            boolean r3 = q7.k.a(r3, r6)
            if (r3 != 0) goto L29
            r8.f7119w = r6
            r2 = r4
        L29:
            boolean r3 = r8.f7120x
            boolean r6 = r7.f711c
            if (r3 == r6) goto L46
            if (r6 == 0) goto L38
            r8.l0(r0)
            r8.l0(r1)
            goto L41
        L38:
            r8.m0(r0)
            r8.m0(r1)
            r8.o0()
        L41:
            i1.l.n(r8)
            r8.f7120x = r6
        L46:
            p7.a r7 = r7.f712d
            r8.f7121y = r7
            boolean r7 = r8.I
            q.i r0 = r8.H
            if (r0 != 0) goto L56
            o.m0 r3 = r8.f7119w
            if (r3 == 0) goto L56
            r3 = r4
            goto L57
        L56:
            r3 = r5
        L57:
            if (r7 == r3) goto L69
            if (r0 != 0) goto L60
            o.m0 r7 = r8.f7119w
            if (r7 == 0) goto L60
            r5 = r4
        L60:
            r8.I = r5
            if (r5 != 0) goto L69
            i1.j r7 = r8.C
            if (r7 != 0) goto L69
            goto L6a
        L69:
            r4 = r2
        L6a:
            if (r4 == 0) goto L7f
            i1.j r7 = r8.C
            if (r7 != 0) goto L74
            boolean r0 = r8.I
            if (r0 != 0) goto L7f
        L74:
            if (r7 == 0) goto L79
            r8.m0(r7)
        L79:
            r7 = 0
            r8.C = r7
            r8.p0()
        L7f:
            q.i r7 = r8.f7118v
            r1.o0(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableElement.f(n0.l):void");
    }

    public final int hashCode() {
        i iVar = this.f709a;
        int iHashCode = (iVar != null ? iVar.hashCode() : 0) * 31;
        m0 m0Var = this.f710b;
        return this.f712d.hashCode() + x.e((iHashCode + (m0Var != null ? m0Var.hashCode() : 0)) * 31, 29791, this.f711c);
    }
}
