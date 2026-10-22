package e6;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import v5.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {
    public c A;

    /* renamed from: a, reason: collision with root package name */
    public Context f3547a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3548b;

    /* renamed from: c, reason: collision with root package name */
    public stepos.support.v7.app.f f3549c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap.Config f3550d;

    /* renamed from: e, reason: collision with root package name */
    public f6.d f3551e;

    /* renamed from: f, reason: collision with root package name */
    public s f3552f;

    /* renamed from: g, reason: collision with root package name */
    public kb.s f3553g;

    /* renamed from: h, reason: collision with root package name */
    public h6.e f3554h;
    public ad.n i;

    /* renamed from: j, reason: collision with root package name */
    public r f3555j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3556k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3557l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3558m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3559n;

    /* renamed from: o, reason: collision with root package name */
    public b f3560o;

    /* renamed from: p, reason: collision with root package name */
    public b f3561p;

    /* renamed from: q, reason: collision with root package name */
    public b f3562q;

    /* renamed from: r, reason: collision with root package name */
    public kc.p f3563r;

    /* renamed from: s, reason: collision with root package name */
    public kc.p f3564s;

    /* renamed from: t, reason: collision with root package name */
    public kc.p f3565t;

    /* renamed from: u, reason: collision with root package name */
    public kc.p f3566u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.lifecycle.q f3567v;

    /* renamed from: w, reason: collision with root package name */
    public f6.h f3568w;

    /* renamed from: x, reason: collision with root package name */
    public f6.f f3569x;

    /* renamed from: y, reason: collision with root package name */
    public p f3570y;

    /* renamed from: z, reason: collision with root package name */
    public d f3571z;

    public static h a(i iVar) {
        Context context = iVar.f3547a;
        iVar.getClass();
        h hVar = new h();
        hVar.f3530a = context;
        hVar.f3531b = iVar.A;
        hVar.f3532c = iVar.f3548b;
        hVar.f3533d = iVar.f3549c;
        d dVar = iVar.f3571z;
        hVar.f3534e = dVar.f3524d;
        hVar.f3535f = iVar.f3552f;
        hVar.f3536g = iVar.f3553g;
        hVar.f3537h = dVar.f3523c;
        hVar.i = iVar.i.c();
        Map map = iVar.f3555j.f3600a;
        map.getClass();
        hVar.f3538j = new LinkedHashMap(map);
        hVar.f3539k = iVar.f3556k;
        hVar.f3540l = iVar.f3559n;
        p pVar = iVar.f3570y;
        n nVar = new n();
        Map map2 = pVar.f3591c;
        map2.getClass();
        nVar.f3587c = new LinkedHashMap(map2);
        hVar.f3541m = nVar;
        hVar.f3542n = dVar.f3521a;
        hVar.f3543o = dVar.f3522b;
        if (iVar.f3547a == context) {
            hVar.f3544p = iVar.f3567v;
            hVar.f3545q = iVar.f3568w;
            hVar.f3546r = iVar.f3569x;
        } else {
            hVar.f3544p = null;
            hVar.f3545q = null;
            hVar.f3546r = null;
        }
        VarHandle.storeStoreFence();
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return yb.k.a(this.f3547a, iVar.f3547a) && this.f3548b.equals(iVar.f3548b) && yb.k.a(this.f3549c, iVar.f3549c) && this.f3550d == iVar.f3550d && this.f3551e == iVar.f3551e && yb.k.a(this.f3552f, iVar.f3552f) && yb.k.a(this.f3553g, iVar.f3553g) && yb.k.a(this.f3554h, iVar.f3554h) && yb.k.a(this.i, iVar.i) && this.f3555j.equals(iVar.f3555j) && this.f3556k == iVar.f3556k && this.f3557l == iVar.f3557l && this.f3558m == iVar.f3558m && this.f3559n == iVar.f3559n && this.f3560o == iVar.f3560o && this.f3561p == iVar.f3561p && this.f3562q == iVar.f3562q && yb.k.a(this.f3563r, iVar.f3563r) && yb.k.a(this.f3564s, iVar.f3564s) && yb.k.a(this.f3565t, iVar.f3565t) && yb.k.a(this.f3566u, iVar.f3566u) && yb.k.a(this.f3567v, iVar.f3567v) && this.f3568w.equals(iVar.f3568w) && this.f3569x == iVar.f3569x && this.f3570y.equals(iVar.f3570y) && this.f3571z.equals(iVar.f3571z) && yb.k.a(this.A, iVar.A);
    }

    public final int hashCode() {
        int iHashCode = (this.f3548b.hashCode() + (this.f3547a.hashCode() * 31)) * 31;
        stepos.support.v7.app.f fVar = this.f3549c;
        int iHashCode2 = (this.f3551e.hashCode() + ((this.f3550d.hashCode() + ((iHashCode + (fVar != null ? fVar.hashCode() : 0)) * 923521)) * 961)) * 961;
        int iHashCode3 = this.f3552f != null ? s.class.hashCode() : 0;
        this.f3553g.getClass();
        return this.A.hashCode() + ((this.f3571z.hashCode() + ((this.f3570y.f3591c.hashCode() + ((this.f3569x.hashCode() + ((this.f3568w.hashCode() + ((this.f3567v.hashCode() + ((this.f3566u.hashCode() + ((this.f3565t.hashCode() + ((this.f3564s.hashCode() + ((this.f3563r.hashCode() + ((this.f3562q.hashCode() + ((this.f3561p.hashCode() + ((this.f3560o.hashCode() + k0.a.h(k0.a.h(k0.a.h(k0.a.h((this.f3555j.f3600a.hashCode() + ((((this.f3554h.hashCode() + ((1 + ((iHashCode2 + iHashCode3) * 31)) * 31)) * 31) + Arrays.hashCode(this.i.f548c)) * 31)) * 31, 31, this.f3556k), 31, this.f3557l), 31, this.f3558m), 31, this.f3559n)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * (-1807454463))) * 31);
    }
}
