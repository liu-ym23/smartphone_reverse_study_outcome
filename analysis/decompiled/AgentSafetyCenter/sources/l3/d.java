package l3;

import android.view.ViewGroup;
import n3.p0;
import stepos.support.v7.app.q0;
import stepos.support.v7.widget.ActionBarContextView;
import te.l;
import te.u;
import u.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements u, p0, n1.a {

    /* renamed from: c, reason: collision with root package name */
    public boolean f7720c;

    /* renamed from: f, reason: collision with root package name */
    public Object f7721f = c.f7719a;

    public d(boolean z10) {
        this.f7720c = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // n1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object S(long r3, long r5, nb.c r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof u.q0
            if (r3 == 0) goto L13
            r3 = r7
            u.q0 r3 = (u.q0) r3
            int r4 = r3.f13554h
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.f13554h = r4
            goto L1a
        L13:
            u.q0 r3 = new u.q0
            pb.c r7 = (pb.c) r7
            r3.<init>(r2, r7)
        L1a:
            java.lang.Object r4 = r3.f13552f
            ob.a r7 = ob.a.f9351c
            int r0 = r3.f13554h
            r1 = 1
            if (r0 == 0) goto L32
            if (r0 != r1) goto L2b
            long r5 = r3.f13551c
            id.c.I(r4)
            goto L48
        L2b:
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r2)
            r2 = 0
            return r2
        L32:
            id.c.I(r4)
            boolean r4 = r2.f7720c
            if (r4 == 0) goto L51
            java.lang.Object r2 = r2.f7721f
            u.z0 r2 = (u.z0) r2
            r3.f13551c = r5
            r3.f13554h = r1
            java.lang.Object r4 = r2.b(r5, r3)
            if (r4 != r7) goto L48
            return r7
        L48:
            o2.p r4 = (o2.p) r4
            long r2 = r4.f9131a
            long r2 = o2.p.e(r5, r2)
            goto L53
        L51:
            r2 = 0
        L53:
            o2.p r2 = o2.p.a(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.d.S(long, long, nb.c):java.lang.Object");
    }

    @Override // n3.p0
    public void a() {
        this.f7720c = true;
    }

    @Override // te.u
    public void b(l lVar, boolean z10) {
        q0 q0Var = (q0) this.f7721f;
        if (this.f7720c) {
            return;
        }
        this.f7720c = true;
        q0Var.f12452a.i();
        stepos.support.v7.app.p0 p0Var = q0Var.f12454c;
        if (p0Var != null) {
            p0Var.onPanelClosed(108, lVar);
        }
        this.f7720c = false;
    }

    @Override // n3.p0
    public void c() {
        ViewGroup viewGroup = ((ActionBarContextView) this.f7721f).i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        this.f7720c = false;
    }

    @Override // n3.p0
    public void d() {
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f7721f;
        if (this.f7720c) {
            return;
        }
        if (actionBarContextView.A == 2) {
            actionBarContextView.j();
        }
        ViewGroup viewGroup = actionBarContextView.i;
        if (viewGroup != null) {
            viewGroup.setTranslationY(0.0f);
        }
        actionBarContextView.A = 0;
        actionBarContextView.D = null;
    }

    @Override // n1.a
    public long d0(int i, long j10, long j11) {
        if (!this.f7720c) {
            return 0L;
        }
        z0 z0Var = (z0) this.f7721f;
        if (z0Var.f13624a.a()) {
            return 0L;
        }
        return z0Var.g(z0Var.c(z0Var.f13624a.e(z0Var.c(z0Var.f(j11)))));
    }

    @Override // te.u
    public boolean e(l lVar) {
        stepos.support.v7.app.p0 p0Var = ((q0) this.f7721f).f12454c;
        if (p0Var == null) {
            return false;
        }
        p0Var.onMenuOpened(108, lVar);
        return true;
    }
}
